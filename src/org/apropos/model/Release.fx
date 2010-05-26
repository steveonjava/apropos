/*
 * Copyright (c) 2010, Apropos Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name Apropos nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.apropos.model;

import com.rallydev.webservice.v1_17.domain.HierarchicalRequirement;
import com.rallydev.webservice.v1_17.domain.QueryResult;
import javafx.util.Sequences;
import org.jfxtras.async.XWorker;
import org.jfxtras.util.SequenceUtil;

/**
 * @author Stephen Chin
 */
public class Release extends StoryContainer {

    public var release:com.rallydev.webservice.v1_17.domain.Release on replace {
        if (release != null) {
            name = release.getName();
        }
    }

    package var model = RallyModel.instance;

    public var packageNames:String[] on replace = newPackages {
        for (p in newPackages where -1 == Sequences.indexOf(model.packageNames, p)) {
            insert p into model.packageNames;
        }
    }

    public function getPackageTotals(name:String):Double {
        SequenceUtil.sum(for (s in stories where s.inPackage == name) s.estimate)
    }

    override function moveBefore(story:Story) {
        story.release = containerBefore as Release;
        delete story from stories;
        insert story into containerBefore.stories;
        containerBefore.rerank();
    }

    override function moveAfter(story:Story) {
        story.release = containerAfter as Release;
        delete story from stories;
        insert story into containerAfter.stories;
        containerAfter.rerank();
    }

    function fixRanks() {
        if (not model.readOnly) {
            var lastRank:Double = 0;
            for (story in stories) {
                if (story.rank < lastRank + 0.9) {
                    println("fixing story rank from {story.rank} to {lastRank + 1} for {story}");
                    story.rank = lastRank + 1;
                }
                lastRank = story.rank;
            }
        }
    }

    override function rerank() {
        stories = Sequences.sort(stories) as Story[];
    }

    public function refresh() {
        delete stories;
        delete packageNames;
        loadStories(1);
    }

    init {
        loadStories(1);
    }

    function loadStories(start:Integer):Void {
        model.waiting++;
        XWorker {
            inBackground: function() {
                model.rallyService.query(null, model.mainProject, false, false, "HierarchicalRequirement", "(Release = \"{release.getRef()}\")", "Rank", true, start, 100);
            }
            onFailure: function(e) {
                model.waiting--;
                println("Unable to load release {name} due to the following exception:");
                e.printStackTrace();
            }
            onDone: function(result) {
                model.waiting--;
                var queryResult = result as QueryResult;
                if (sizeof queryResult.getErrors() > 0) {
                    println("Unable to load release {name} due to the following errors:");
                    for (error in queryResult.getErrors()) println('ERROR: {error}"');
                } else {
                    def results = queryResult.getResults();
                    def newStories = for (domainObject in results) Story {
                       hierarchicalRequirement: domainObject as HierarchicalRequirement
                    }
                    insert newStories into stories;
                    var newPackages:String[] = packageNames;
                    for (story in newStories where -1 == Sequences.indexOf(newPackages, story.inPackage)) {
                        insert story.inPackage into newPackages;
                    }
                    packageNames = Sequences.sort(newPackages) as String[];
                    if (results.length == 100) {
                        loadStories(start + 100);
                    }
                    fixRanks();
                }
            }
        }
    }
}
