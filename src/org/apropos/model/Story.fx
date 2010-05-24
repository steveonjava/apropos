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
import javafx.util.Math;
import org.apropos.api.HierarchicalRequirement;
import org.apropos.api.QueryResult;
import org.apropos.model.RallyModel;
import org.jfxtras.async.XWorker;
import org.jfxtras.lang.XObject;
import org.jfxtras.util.BrowserUtil;
import org.jfxtras.util.SequenceUtil;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
public class Story extends XObject, Comparable {
    def model = bind RallyModel.instance;
    var initialized = false;
    var dirty = false;
    var executing = false;
    public-init var hierarchicalRequirement:HierarchicalRequirement;
    public var drafted:Boolean = false;
    public var name:String;
    public var id:String;
    public var description:String;
    public var textDescription:String;
    public var parentName:String;
    public var stage:String on replace {
        if (initialized) {
            hierarchicalRequirement.setStage(stage);
            update();
        }
    }
    public var releasePlan:String on replace {
        if (initialized) {
            hierarchicalRequirement.setReleasePlan(releasePlan);
            update();
        }
    }
    public var owner:String on replace {
        if (initialized) {
            hierarchicalRequirement.setOwner(owner);
            update();
        }
    }
    public var estimate:Double;
    public var estimateDisplay = bind model.convertEstimate(estimate);
    public var rank:Double on replace {
        if (initialized) {
            var rank3 = Math.floor(rank * 1000) / 1000;
            hierarchicalRequirement.setRank(rank3);
            update();
        }
    }
    public var inPackage:String;
    public var acceptanceTest:String;
    public var iteration1:String;
    public var iteration2:String;
    public var iteration3:String;
    public var iteration4:String;
    public var iteration5:String;
    public var iteration6:String;
    public var overflow:String;

    public function browse():Void {
        BrowserUtil.browse("https://rally1.rallydev.com/slm/detail/ar/{hierarchicalRequirement.getObjectID()}");
    }

    function reapply():Void {
        // todo - find a cleaner way to do this
        hierarchicalRequirement.setReleasePlan(releasePlan);
        hierarchicalRequirement.setStage(stage);
        var rank3 = Math.floor(rank * 1000) / 1000;
        hierarchicalRequirement.setRank(rank3);
        hierarchicalRequirement.setOwner(owner);
    }

    function update():Void {
        if (not model.requestAccess()) {
            return;
        }
        dirty = true;
        if (not executing) {
            executing = true;
            dirty = false;
            model.waiting++;
            XWorker {
                inBackground: function() {
                    var result = model.rallyService.update(hierarchicalRequirement);
                    for (error in result.getErrors()) println("ERROR: {error}");
                    model.rallyService.read(hierarchicalRequirement) as HierarchicalRequirement;
                }
                onFailure: function(e) {
                    model.waiting--;
                    println("Unable to update Story \"{name}\" due to the following exception:");
                    e.printStackTrace();
                }
                onDone: function(result) {
                    model.waiting--;
                    hierarchicalRequirement = result as HierarchicalRequirement;
                    executing = false;
                    if (dirty) {
                        reapply();
                        update();
                    } else {
                        initialize();
                    }
                }
            }
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
        name = hierarchicalRequirement.getRefObjectName();
        id = hierarchicalRequirement.getFormattedID();
        description = hierarchicalRequirement.getDescription();
        textDescription = removeTags(description);
        parentName = hierarchicalRequirement.getParent().getRefObjectName();
        releasePlan = hierarchicalRequirement.getReleasePlan();
        rank = if (hierarchicalRequirement.getRank() == null) 0 else hierarchicalRequirement.getRank();
        owner = hierarchicalRequirement.getOwner();
        inPackage = hierarchicalRequirement.get_package();
        if (inPackage == "") inPackage = "<missing package>";
        var desc = description.toLowerCase();
        acceptanceTest = if (desc.contains("acceptance") or desc.contains("criteria")) "Y" else "N";
        stage = hierarchicalRequirement.getStage();
        if (stage == "") {
            stage = "Proposed";
        }
        if (stage == "Proposed" and sizeof model.releasePlans[r|r == releasePlan] > 0) {
            stage = "Backlogged";
        }
        if ((stage == "Proposed" or stage == "Backlogged") and releasePlan == model.currentRelease) {
            stage = "Scheduled";
        }
        if (stage == "Scheduled" and hierarchicalRequirement.getScheduleState() == "In-Progress") {
            stage = "In Process";
        }
        if ((stage == "In Process" or stage == "Scheduled") and hierarchicalRequirement.getScheduleState() == "Accepted") {
            stage = "Deployed";
        }
        def children = hierarchicalRequirement.getChildren();
        if (children == null or children.length == 0) {
            estimate = if (hierarchicalRequirement.getPlanEstimate() == null) 0 else hierarchicalRequirement.getPlanEstimate();
        } else {
            loadEstimate(hierarchicalRequirement, true);
        }
        initialized = true;
    }

    function loadEstimate(parent:HierarchicalRequirement, top:Boolean):Void {
        model.waiting++;
        XWorker {
            inBackground: function() {
                model.rallyService.query(null, "HierarchicalRequirement", "(Parent = \"{parent.getRef()}\")", "Rank", true, 0, 100);
            }
            onFailure: function(e) {
                model.waiting--;
                println("Unable to load estimate for Story \"{name}\" due to the following exception:");
                e.printStackTrace();
            }
            onDone: function(result) {
                model.waiting--;
                def queryResult = result as QueryResult;
                for (error in queryResult.getErrors()) println('ERROR: {error}"');
                if (sizeof queryResult.getErrors() > 0) 0 else {
                    var fetchedChildren = for (do in queryResult.getResults()) do as HierarchicalRequirement;
                    if (top) {
                        estimate = SequenceUtil.sum(for (child in fetchedChildren where child.getScheduleState() != "Accepted") if (child.getPlanEstimate() == null) 0 else child.getPlanEstimate());
                    }
                    for (child in fetchedChildren) {
                        def name = child.getIteration().getRefObjectName();
                        for (iteration in model.iterations where iteration == name) {
                            if (indexof iteration == 0) {
                                iteration1 = maybeAppend(iteration1, child.getProject().getRefObjectName());
                            } else if (indexof iteration == 1) {
                                iteration2 = maybeAppend(iteration2, child.getProject().getRefObjectName());
                            } else if (indexof iteration == 2) {
                                iteration3 = maybeAppend(iteration3, child.getProject().getRefObjectName());
                            } else if (indexof iteration == 3) {
                                iteration4 = maybeAppend(iteration4, child.getProject().getRefObjectName());
                            } else if (indexof iteration == 4) {
                                iteration5 = maybeAppend(iteration5, child.getProject().getRefObjectName());
                            } else if (indexof iteration == 5) {
                                iteration6 = maybeAppend(iteration6, child.getProject().getRefObjectName());
                            } else {
                                overflow = child.getProject().getRefObjectName();
                            }
                        }
                        loadEstimate(child, false);
                    }
                }
            }
        }
    }

    function maybeAppend(base:String, addition:String):String {
        if (base.contains(addition)) {
            return base;
        } else if (base == "") {
            return addition;
        } else {
            return "{base}, {addition}";
        }
    }

    override function compareTo(obj:Object) {
        return rank.compareTo((obj as Story).rank);
    }

    override function toString() {
        return "Story \{name: {name}\}, estimate: \{{estimate}\}, rank: \{{rank}\}, inPackage: \{{inPackage}\}";
    }
}