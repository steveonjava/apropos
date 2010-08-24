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

//import com.rallydev.webservice.v1_19.rallyworkspace.domain.HierarchicalRequirement;
//import com.rallydev.webservice.v1_19.rallyworkspace.domain.QueryResult;
import javafx.util.Sequences;
import org.jfxtras.util.SequenceUtil;
import org.apropos.model.domain.HierarchicalRequirement;
import org.apropos.model.domain.Workspace;
import org.apropos.model.domain.HierQueryResultWrapper;
import org.apropos.model.service.HierQueryRequest;
import java.net.URLEncoder;
//import org.apropos.model.service.QueryRequest;
//import com.rallydev.webservice.v1_19.rallyworkspace.domain.Workspace;

/**
 * @author Stephen Chin
 */
public class Release extends StoryContainer {

// todo - release fix
//    public var release:com.rallydev.webservice.v1_19.domain.Release on replace {
//        if (release != null) {
//            name = release.getName();
//        }
//    }

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
                      //"?workspace=\"https://rallytest1.rallydev.com/slm/webservice/1.19/workspace/41529001.js\""
                      "?{query}"
                      "&projectScopeUp=false"
                      "&projectScopeDown=true"
                      "&order=Rank"
                      //"&fetch=false"
                      //TODO: Implement ability to read array of elements when using fetch
                      "&fetch=FormattedID,Description,RoadmapAllocation,RoadmapRelease,Rank,ScheduleState,Owner,Project,Parent"
                      "&start=1"
                      "&pagesize=100"
            //endPoint: "https://rallytest1.rallydev.com/slm/webservice/1.19/hierarchicalrequirement.js?query=%28%28RoadmapRelease%20=%20%22Q3%202010%22%29%20and%20%28RoadmapLevel%20=%20%22Feature%22%29%29&projectScopeUp=false&projectScopeDown=true&order=Rank&fetch=FormattedID,Description,Parent,RoadmapAllocation,RoadmapRelease,Rank,Owner,Project,ScheduleState&start=1&pagesize=100"

            onResponse: function(wrapper:HierQueryResultWrapper):Void {
                model.waiting--;
                var queryResult = wrapper.HierQueryResult;
                if (sizeof queryResult.Errors > 0) {
                    //TODO: Implement the Errors and Warnings elements
                    println("Unable to load release {name} due to the following errors:");
                    for (error in queryResult.Errors) println('ERROR: {error}"');
                }
                else {
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



//                println("In onResponse, sizeof wrapper.QueryResult.Results:{sizeof wrapper.QueryResult.Results}");
//                for (result in wrapper.QueryResult.Results) {
//                    println("Hier{indexof result}: {result._refObjectName}");
//                }

            }
            onError: function(obj:Object):Void {
                model.waiting--;
                println("Unable to load release {name} due to the following exception:{obj}");
            }
        }
        readRequest.start();


        //model.rallyService.query(workspace, model.mainProject, false, true, "HierarchicalRequirement", "((RoadmapRelease = \"{roadmapRelease}\") and (RoadmapLevel = \"Feature\"))", "Rank", true, start, 100);
   }


// TODO: Replace this functionality
//    function loadStories(start:Integer):Void {
//        var workspace:Workspace;
//        if (model.selectedWorkspace != null) {
//            workspace = model.rallyService.read(model.selectedWorkspace) as Workspace;
//        }
//        model.waiting++;
//        XWorker {
//            inBackground: function() {
//                model.rallyService.query(workspace, model.mainProject, false, true, "HierarchicalRequirement", "((RoadmapRelease = \"{roadmapRelease}\") and (RoadmapLevel = \"Feature\"))", "Rank", true, start, 100);
//            }
//            onFailure: function(e) {
//                model.waiting--;
//                println("Unable to load release {name} due to the following exception:");
//                e.printStackTrace();
//            }
//            onDone: function(result) {
//                model.waiting--;
//                var queryResult = result as QueryResult;
//                if (sizeof queryResult.getErrors() > 0) {
//                    println("Unable to load release {name} due to the following errors:");
//                    for (error in queryResult.getErrors()) println('ERROR: {error}"');
//                } else {
//                    def results = queryResult.getResults();
//
//                    def newStories = for (domainObject in results) {
//                        def hierarchicalRequirement = domainObject as HierarchicalRequirement;
//                        Story {
//                           hierarchicalRequirement: hierarchicalRequirement
//                        };
//                    }
//                    insert newStories into stories;
//                    for (story in newStories) {
//                        def insertionPoint = Sequences.binarySearch(model.packageNames, story.inPackage);
//                        if (insertionPoint < 0) {
//                            insert story.inPackage before model.packageNames[-insertionPoint - 1];
//                        }
//                    }
//                    for (story in newStories) {
//                        def insertionPoint = Sequences.binarySearch(model.epicNames, story.parentName);
//                        if (insertionPoint < 0) {
//                            insert story.parentName before model.epicNames[-insertionPoint - 1];
//                        }
//                    }
//                    for (story in newStories) {
//                        if (story.roadmapAllocation.trim() != "") {
//                            def insertionPoint = Sequences.binarySearch(model.allocationNames, story.roadmapAllocation);
//                            if (insertionPoint < 0) {
//                                insert story.roadmapAllocation before model.allocationNames[-insertionPoint - 1];
//                            }
//                        }
//                    }
//                    for (stage in model.stages) {
//                        def stageStories = newStories[s|s.stage == stage.name];
//                        insert stageStories into stage.stories;
//                    }
//                    def noStage = newStories[s|s.stage == null];
//                    insert noStage into model.stages[0].stories;
//                    if (results.length == 100) {
//                        loadStories(start + 100);
//                    }
//                }
//            }
//        }
//    }
}
