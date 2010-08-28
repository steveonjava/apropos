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

import java.lang.Comparable;
import java.lang.StringBuilder;
import org.jfxtras.lang.XObject;
import java.math.BigDecimal;
import javafx.util.Math;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.Void;
import org.apropos.model.Backlog;
import org.apropos.model.RallyModel;
import org.apropos.model.Story;
import org.apropos.model.domain.HierarchicalRequirement;
import org.apropos.model.domain.Project;
import org.apropos.model.domain.User;
import org.jfxtras.util.BrowserUtil;
import org.apropos.model.service.HierUpdateRequest;

/**
 * @author Stephen Chin
 * @author Keith Combs
 * TODO: Ascertain the best way to retrieve, and hold in an instance variable,
 *       the owner's display name
 */
public class Story extends XObject, Comparable {
    def model = bind RallyModel.instance;
    var initialized = false;
    var dirty = false;
    var executing = false;
    public-init var hierarchicalRequirement:HierarchicalRequirement;
    public var scheduled:Boolean = false;
    public var drafted:Boolean = false;
    public var name:String;
    public var id:String;
    public var description:String;
    public var textDescription:String;
    public var parentName:String;
    public var roadmapAllocation:String;
    public var stage:String on replace oldStage=newStage {
        if (initialized) {
            hierarchicalRequirement.RoadmapKanbanState = stage;
            update();
            if (stage == "Schedule" and release instanceof Backlog) {
                release = model.currentRelease;
            }
            if (stage == "Backlog" and not (release instanceof Backlog)) {
                release = model.backlog;
            }
            model.findStage(oldStage).removeStory(this);
            model.findStage(newStage).addStory(this);
        }
    }
    public var release:Release on replace oldRelease=newRelease {
        if (initialized) {
            hierarchicalRequirement.RoadmapRelease = release.roadmapRelease;
            update();
            if (release instanceof Backlog) {
                stage = "Backlog"
            }
            oldRelease.removeStory(this);
            newRelease.addStory(this);
        }
    }
    public var owner:User on replace {
        if (initialized) {
            hierarchicalRequirement.Owner = owner;
            update();
        }
    }
    public var ownerName:String = bind owner._refObjectName on replace {
        ownerDisplayName = ownerName;
    };
    public var ownerDisplayName:String;

    public var project:Project on replace {
        if (initialized) {
            hierarchicalRequirement.Project = project;
            update();
        }
    }
    public var projectName:String = bind project._refObjectName;

    public var estimate:Double;
    public var estimateDisplay = bind model.convertEstimate(estimate);

    public var rank:BigDecimal on replace {
        if (initialized) {
            var rank3 = Math.floor(rank.doubleValue() * 1000) / 1000;
            //TODO: Is BigDecimal required? If so, revisit RedFX JSON types capability
            //hierarchicalRequirement.Rank = new BigDecimal(rank3);
            hierarchicalRequirement.Rank = rank3;
            update();
        }
    }
    public var inPackage:String;

    public function browse():Void {
        BrowserUtil.browse("{RallyModel.server}slm/detail/ar/{hierarchicalRequirement.ObjectID}");
    }

    function reapply():Void {
        // todo - find a cleaner way to do this
        hierarchicalRequirement.RoadmapRelease = release.roadmapRelease;
        hierarchicalRequirement.RoadmapKanbanState = stage;
        var rank3 = Math.floor(rank.doubleValue() * 1000) / 1000;
        //TODO: Is BigDecimal required? If so, revisit RedFX JSON types capability
        //hierarchicalRequirement.Rank = new BigDecimal(rank3);
        hierarchicalRequirement.Rank = rank3;
        hierarchicalRequirement.Owner = owner;
    }

    package function update():Void {
        if (not model.requestAccess()) {
            return;
        }
        dirty = true;
        if (not executing) {
            executing = true;
            dirty = false;
            model.waiting++;
            var updateRequest:HierUpdateRequest = HierUpdateRequest {
                hierarchicalRequirement: hierarchicalRequirement
                onDone: function():Void {
                    model.waiting--;
                    executing = false;
                    if (dirty) {
                        reapply();
                        update();
                    } else {
                        initialize();
                    }
                }
                onErrors: function(errors:String[]):Void {
                    model.waiting--;
                    println("In onErrors, errors: [{for (error in errors)"\n  {error}"}\n]");
                    println("hierarchicalRequirement._ref: {hierarchicalRequirement._ref}");
                }
            }
            updateRequest.start();
        }
    }

    init {
        initialize();
    }

    function removeTags(html:String):String {
        var inTag = false;
        var inEntity = false;
        var sb:StringBuilder = StringBuilder {}
        var entity:StringBuilder = StringBuilder {}
        for (i in [0..<html.length()]) {
            var char = html.charAt(i);
            if (char == "<".charAt(0)) {
                // hit a tag start before the entity ended, assume it wasn't a real entity
                inTag = true;
                if (entity.length() > 0)
                {
                    sb.append(entity);
                    entity.setLength(0);
                }
            } else if (char == ">".charAt(0)) {
                inTag = false;
            } else if (not inTag) {
                if (not inEntity) {
                    if (char == "&".charAt(0)) {
                        inEntity = true;
                        entity.append(char);
                    } else {
                        sb.append(char);
                    }
                } else {
                    if (char == ";".charAt(0)) {
                        inEntity = false;

                        if (inEntity.toString() == "&nbsp") {
                            sb.append(" ");
                        } else if (inEntity.toString() == "&amp") {
                            sb.append("&");
                        } else if (inEntity.toString() == "&lt") {
                            sb.append("<");
                        } else if (inEntity.toString() == "&gt") {
                            sb.append(">");
                        }

                        entity.setLength(0);
                    } else {
                        entity.append(char);
                    }

                    if (entity.length() > 6) {
                        // not really an entity
                        inEntity = false;
                        sb.append(entity);
                        entity.setLength(0);
                    }
                }

            }
        };

        if (entity.length() > 0)
        {
            // hit the end before the entity ended, assume it wasn't a real entity
            sb.append(entity);
        }

        return sb.toString();
    }

    function initialize() {
        initialized = false;
        name = removeTags(hierarchicalRequirement._refObjectName);
        id = hierarchicalRequirement.FormattedID;
        description = removeTags(hierarchicalRequirement.Description);
        //textDescription = removeTags(description);
        //TODO: Why textDescription and description? Remove one?
        textDescription = description;

        parentName = removeTags(hierarchicalRequirement.Parent._refObjectName);
        roadmapAllocation = hierarchicalRequirement.RoadmapAllocation;
        release = model.getRelease(hierarchicalRequirement.RoadmapRelease);
        rank = new BigDecimal(hierarchicalRequirement.Rank);
        owner = hierarchicalRequirement.Owner;
        estimate = hierarchicalRequirement.PlanEstimate;

        project = hierarchicalRequirement.Project;

        //TODO: Determine if necessary to do the following two lines
//        inPackage = hierarchicalRequirement.get_package();
//        if (inPackage == "") inPackage = "<missing package>";

        stage = hierarchicalRequirement.RoadmapKanbanState;

        //TODO: Remove when sure it's not required, and use in S19376
        //loadEstimate(hierarchicalRequirement, true);

        initialized = true;
        promoteStage();
    }

    function promoteStage() {
        if (stage == "" and hierarchicalRequirement.ScheduleState == "Defined") {
            stage = "Propose";
        }
        if ((stage == "Propose" or stage == "Backlog") and not (release instanceof Backlog)) {
            stage = "Schedule";
        }
        if (stage == "Schedule" and hierarchicalRequirement.ScheduleState == "In-Progress") {
            stage = "Develop";
        }
        if ((stage == "Develop" or stage == "Schedule") and hierarchicalRequirement.ScheduleState == "Accepted") {
            stage = "Deploy";
        }
    }

    /* TODO: Keep for a bit (Use much of this code for S19376)
    function loadEstimate(parent:HierarchicalRequirement, top:Boolean):Void {
        var query = "query=(Parent = \"{parent._ref}\")";
        query = query.replaceAll(" ", "%20");

        var readRequest:HierQueryRequest = HierQueryRequest {
            endPoint: "{model.server}{model.endpointPath}hierarchicalrequirement.js"
                      "?{query}"
                      //"&projectScopeUp=false"
                      //"&projectScopeDown=true"
                      "&order=Rank"
                      //TODO: Implement ability to read array of elements when using fetch
                      "&fetch=true"
                      //"&fetch=FormattedID,Description,RoadmapAllocation,RoadmapKanbanState,RoadmapRelease,RoadmapLevel,Rank,ScheduleState,Owner,Project,Parent,ObjectID"
                      "&start=0"
                      "&pagesize=100"

            onResponse: function(wrapper:HierQueryResultWrapper):Void {
                model.waiting--;
                var queryResult = wrapper.HierQueryResult;
                if (sizeof queryResult.Errors > 0) {
                    //TODO: Implement the Errors and Warnings elements
                    println("Unable to load release {name} due to the following errors:");
                    for (error in queryResult.Errors) println('ERROR: {error}"');
                }
                else {
                    var fetchedChildren = for (do in queryResult.Results) do as HierarchicalRequirement;
                    if (top) {
                        estimate = SequenceUtil.sum(for (child in fetchedChildren where child.ScheduleState != "Accepted") child.PlanEstimate);
                    }
                }
            }
            onError: function(obj:Object):Void {
                model.waiting--;
                println("Unable to load release {name} due to the following exception:{obj}");
            }
        }
        readRequest.start();
    }
    */

    override function compareTo(obj:Object) {
        return rank.compareTo((obj as Story).rank);
    }

    override function toString() {
        return "Story \{name: {name}\}, estimate: \{{estimate}\}, rank: \{{rank}\}, inPackage: \{{inPackage}\}, hierarchicalRequirement: \{{hierarchicalRequirement}\}";
    }
}
