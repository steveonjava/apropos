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

import javafx.util.Sequences;
import org.jfxtras.util.SequenceUtil;
import org.apropos.model.domain.HierarchicalRequirement;
import org.apropos.model.domain.Workspace;
import org.apropos.model.domain.HierQueryResultWrapper;
import org.apropos.model.service.HierQueryRequest;

/**
 * @author Stephen Chin
 */
public class Release extends StoryContainer {

    package var model = RallyModel.instance;

    public function getAllocationTotals(name:String):Double {
        SequenceUtil.sum(for (s in stories where s.roadmapAllocation == name) s.estimate)
    }
    override function moveBefore(story:Story) {
        story.release = containerBefore as Release;
    }

    override function moveAfter(story:Story) {
        story.release = containerAfter as Release;
    }

    public function addStory(story:Story) {
        insert story into stories;
        rerank();
    }

    public function removeStory(story:Story) {
        delete story from stories;
    }

    override function rerank() {
        stories = Sequences.sort(stories) as Story[];
    }

    public function refresh() {
        delete stories;
        loadStories(1);
    }

    init {
        loadStories(1);
    }

    function loadStories(start:Integer):Void {
        var workspace:Workspace;
        model.waiting++;
        var query = "query=((RoadmapRelease = \"{roadmapRelease}\") and (RoadmapLevel = \"Feature\"))";
        query = query.replaceAll(" ", "%20");

        var readRequest:HierQueryRequest = HierQueryRequest {
            endPoint: "{model.server}{model.endpointPath}hierarchicalrequirement.js"
                      "?{query}"
                      "&projectScopeUp=false"
                      "&projectScopeDown=true"
                      "&order=Rank"
                      //"&fetch=fetch"
                      "&fetch=FormattedID,Description,RoadmapAllocation,RoadmapKanbanState,RoadmapRelease,RoadmapLevel,Rank,ScheduleState,Owner,Project,Parent,PlanEstimate,ObjectID"
                      "&start=1"
                      "&pagesize=100"

            onResponse: function(wrapper:HierQueryResultWrapper):Void {
                model.waiting--;
                var queryResult = wrapper.HierQueryResult;
                def results = queryResult.Results;

                def newStories = for (domainObject in results) {
                    def hierarchicalRequirement = domainObject as HierarchicalRequirement;
                    Story {
                       hierarchicalRequirement: hierarchicalRequirement
                    };
                }
                insert newStories into stories;
                for (story in newStories) {
                    def insertionPoint = Sequences.binarySearch(model.packageNames, story.inPackage);
                    if (insertionPoint < 0) {
                        insert story.inPackage before model.packageNames[-insertionPoint - 1];
                    }
                }
                for (story in newStories) {
                    def insertionPoint = Sequences.binarySearch(model.epicNames, story.parentName);
                    if (insertionPoint < 0) {
                        insert story.parentName before model.epicNames[-insertionPoint - 1];
                    }
                }
                for (story in newStories) {
                    if (story.roadmapAllocation.trim() != "") {
                        def insertionPoint = Sequences.binarySearch(model.allocationNames, story.roadmapAllocation);
                        if (insertionPoint < 0) {
                            insert story.roadmapAllocation before model.allocationNames[-insertionPoint - 1];
                        }
                    }
                }
                for (stage in model.stages) {
                    def stageStories = newStories[s|s.stage == stage.name];
                    insert stageStories into stage.stories;
                }
                def noStage = newStories[s|s.stage == null];
                insert noStage into model.stages[0].stories;
                if (sizeof results == 100) {
                    loadStories(start + 100);
                }
            }
            //TODO: Consolidate onError and onErrors
            onError: function(obj:Object):Void {
                model.waiting--;
                println("Unable to load release {name} due to the following exception:{obj}");
            }
            onErrors: function(errors:String[]):Void {
                model.waiting--;
                println("Unable to load release {name} due to the following errors: [{for (error in errors)"\n  {error}"}\n]");
            }
        }
        readRequest.start();
   }
}
