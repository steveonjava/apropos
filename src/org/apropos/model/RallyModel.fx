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

import javafx.scene.image.Image;
import javafx.util.Math;
import org.jfxtras.lang.XObject;
import org.jfxtras.util.SequenceUtil;
import javafx.stage.Alert;
import javafx.util.Sequences;
import org.apropos.model.domain.DomainObjectWrapper;
import org.apropos.model.service.ReadRequest;
import org.apropos.model.domain.Project;
import org.apropos.model.domain.User;
import org.apropos.model.domain.UserProfile;
import org.apropos.model.domain.Subscription;
import org.apropos.model.domain.Workspace;
import org.apropos.model.domain.UserQueryResultWrapper;
import org.apropos.model.service.UserQueryRequest;

/**
 * @author Stephen Chin
 * @author Keith Combs
 * @author Jim Weaver
 */
public def APROPOS_VERSION = "0.8.37";

public var readOnly:Boolean;

def community:Boolean = false;
def show:Boolean = false;
public def server = bind if (community) "https://community.rallydev.com/" else if (show) "https://show.rallydev.com/" else "https://rallytest1.rallydev.com/";
public def endpointPath = "slm/webservice/1.19/";

public def GUEST_USER = if (community) "apropos@jfxtras.org" else if (show) "peggy@acme.com" else "catherine@rallydev.com";
public def GUEST_PASSWORD = if (community) "AproposFX" else if (show) "4apropos" else "";

public def instance = RallyModel {}

public class RallyModel extends XObject {

    var warned = false;
    public var animateLayouts:Boolean = false;
    public var login = Login {userName: GUEST_USER, password: GUEST_PASSWORD};
    public var loggedIn = false;
    public var processingLogin:Boolean = false;
    public var showInDollars = false;

    var kanbanStatesCFU:CustomFieldUtil;
    public-read var stageNames = bind kanbanStatesCFU.validValues;

    var releasesCFU:CustomFieldUtil;
    public-read var releasePlanNames = bind releasesCFU.validValues;

    public-init var currentRelease:Release;
    public-init var iterations = ["Iteration 5 (R2)", "Iteration 6 (R2)", "Iteration 7 (R2)", "Iteration 8 (R3)", "Iteration 9 (R3)", "Iteration 10 (R3)"];
    
    public-read var myUser:User;

    public-read var myUserProfile:UserProfile;
    public-read var myImage:Image;
    public-read var ownerImages:Image[];
    //TODO: Make initialTargets, and other values, configurable
    public-init var initialTargets = ["10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10"];
    public-init var themeRatios = [.05, .38, .27, .16, .03, .08, .01];
    public-init var wipLimits = [0.0, 15.0, 15.0, 15.0, 0.0, 12.0, 12.0, 0.0];
    public-init var wipLimitByCount = [false, false, false, false, false, true, true, false];
    public-init var estimateToActualRatio = 4.53;
    public-init var actualToCostRatio = 66.5;
    public var backlog:Backlog;
    public var releases:Release[];
    public var stages:Stage[];

    public var mainProjectName:String;
    public-read var mainProject:Project on replace {
    };
    var defaultProject:Project;
    public var waiting = 0;

    /**
     * A sequence of the open projects in the currently selected workspace.
     * TODO: Change this to a directed graph when implementing the project
     *       picker.
     */
    public-read var projectsInCurrentWorkspace:Project[];

    /**
     * A sequence of the open, leaf-node projects subordinate to, and
     * including, the currently selected project.
     */
    public-read var mainProjects:Project[];

    public var selectedMainProjectsIndex:Integer;
    public var selectedMainProjectsName:String = bind if (selectedMainProjectsIndex == 0) null else {
        //TODO: Modify RedFX to allow converting case (and perhaps names) of instance variables
        mainProjects[selectedMainProjectsIndex - 1]._refObjectName;
    }

    public var epicNames:String[];

    public-read var workspaces:Workspace[];
    public-read var workspacesNames:String[] =
        bind for (workspace in workspaces) workspace._refObjectName;

    public-read var defaultWorkspace:Workspace;
    public-read var selectedWorkspace:Workspace on replace {
        // If the workspace changes, and the default project is not in the
        // workspace (or there is no default project), then choose the first
        // project in the workspace in alphabetical order (see business rules
        // in S19520)
        if (selectedWorkspace != null) {
            //loadProjectsForCurrentWorkspaceByQuery(); //TODO: Replace this functionality
            if ((selectedWorkspace._refObjectName == defaultWorkspace._refObjectName) and (defaultProject != null)) {
                mainProject = defaultProject;
            }
            else if (sizeof projectsInCurrentWorkspace > 0) {
                mainProject = projectsInCurrentWorkspace[0];
            }
            else {
                Alert.inform("No project available in workspace {selectedWorkspace._refObjectName}");
            }
        }
    };
    public var selectedWorkspaceIndex:Integer on replace {
        if (selectedWorkspaceIndex >= 0) {
            selectedWorkspace = workspaces[selectedWorkspaceIndex];
            //TODO: Read the workspace
            //selectedWorkspace = rallyService.read(selectedWorkspace) as Workspace;
        }
        else {
            selectedWorkspace = null;
        }
    };

    public var allocationNames:String[];
    public var selectedAllocationIndex:Integer;
    public var selectedAllocation:String = bind if (selectedAllocationIndex == 0) null else {
        allocationNames[selectedAllocationIndex - 1];
    }

    public var selectedReleaseIndex:Integer;
    public var selectedReleaseName:String = bind if (selectedReleaseIndex == 0) null else {
        releasePlanNames[selectedReleaseIndex - 1];
    }

    //TODO: Remove the concept of packages, in favor of Portfolio Allocations
    public var packageNames:String[];
    public var selectedPackageIndex:Integer;
    public var selectedPackage:String = bind if (selectedPackageIndex == 0) null else {
        packageNames[selectedPackageIndex - 1];
    }

    bound function filtersOn() {
        return selectedAllocation != null or selectedReleaseName != null or selectedMainProjectsName != null;
    }

    bound function selected(s:Story) {
        (selectedAllocation == null or s.roadmapAllocation == selectedAllocation) and
        (selectedReleaseName == null or s.release.name == selectedReleaseName) and
        (selectedMainProjectsName == null or s.projectName == selectedMainProjectsName)
    }

    public bound function filter(stories:Story[]) {
        if (not filtersOn()) stories else stories[s|selected(s)];
    }

    // Trigger loadReleases() and loadOwners() after the valid values for RoadmapKanbanState and
    // RoadmapRelease have been loaded
    package var roadmapKanbanStatesLoaded = false;
    package var roadmapReleasesLoaded = false;
    def startLoading:Boolean = bind (roadmapKanbanStatesLoaded and roadmapReleasesLoaded) on replace {
        if (startLoading) {
            loadReleases();
            loadWorkspaces();
        }
    }

    public function doLogin():Void {
        processingLogin = true;
        createService();
        loggedIn = true;
        retrieveCustomFieldValues();
    }

    public function retrieveCustomFieldValues():Void {
        kanbanStatesCFU = CustomFieldUtil {
            customFieldName: "RoadmapKanbanState"
            username: login.userName
            password: login.password
        };
        releasesCFU = CustomFieldUtil {
            customFieldName: "RoadmapRelease"
            username: login.userName
            password: login.password
        };
    }

    /**
     * TODO: Consider renaming this function, as a service is no longer being created
     */
    function createService():Void {
        var query = "query=(Name = \"{login.userName}\")";
        query = query.replaceAll(" ", "%20");
        var readRequest:UserQueryRequest = UserQueryRequest {
            endPoint: "{server}{endpointPath}user.js"
                      "?{query}"
                      "&fetch=userprofile,subscription"

            onResponse: function(wrapper:UserQueryResultWrapper):Void {
                var queryResult = wrapper.UserQueryResult;
                if (sizeof queryResult.Errors > 0) {
                    println("Unable to load user {login.userName} due to the following errors:");
                    for (error in queryResult.Errors) println('ERROR: {error}"');
                }
                else {
                    def results = queryResult.Results;

                    if (sizeof results > 0) {
                        myUser = results[0];
                        loadUserProfile();
                    }
                    else {
                        Alert.inform("Unable to login user");
                        println("User {login.userName} not found");
                    }
                }
            }
            //TODO: Consolidate onError and onErrors
            onError: function(obj:Object):Void {
                 Alert.inform("Unable to login user");
                 println("Unable to load user {login.userName} due to the following exception:{obj}");
            }
            onErrors: function(errors:String[]):Void {
                Alert.inform("Unable to login user");
                println("Unable to load user {login.userName} due to the following errors:");
                for (error in errors) println('ERROR: {error}"');
            }
        }
        readRequest.start();
    }

    function loadUserProfile():Void {
        var readRequest:ReadRequest = ReadRequest {
            endPoint: "{myUser.UserProfile._ref}?fetch=defaultproject,defaultworkspace"
            onResponse: function(wrapper:DomainObjectWrapper):Void {
                myUserProfile = wrapper.UserProfile;
                
                mainProject = myUserProfile.DefaultProject;
                defaultProject = mainProject;

                defaultWorkspace = myUserProfile.DefaultWorkspace;
                selectedWorkspace = defaultWorkspace;
                println("defaultWorkspace._refObjectName:{defaultWorkspace._refObjectName}");

                loadMainProjects();
            }
            onError: function(obj:Object):Void {
                println("In loadUserProfile#onError, obj:{obj}");
            }
        }
        readRequest.start();
    }

    function loadReleases() {
        backlog = Backlog {model: this}
        releases = for (rpn in releasePlanNames) Release {model: this, name: rpn}
        for (r in releases) {
            r.containerBefore = releases[indexof r - 1];
            r.containerAfter = releases[indexof r + 1];
        }
        currentRelease = releases[0];
        backlog.containerAfter = releases[0];
        releases[0].containerBefore = backlog;
        stages = for (stageName in stageNames) Stage {name: stageName}
        for (s in stages) {
            s.containerBefore = stages[indexof s - 1];
            s.containerAfter = stages[indexof s + 1];
        }
        processingLogin = false;
    }

    function loadMainProjects():Void {
        var readRequest:ReadRequest = ReadRequest {
            endPoint: "{mainProject._ref}?fetch=Children&query=%28Name%20=%20%22Product%20Dev%22%29&State=Open"
            onResponse: function(wrapper:DomainObjectWrapper):Void {
                mainProject = wrapper.Project;
                delete mainProjects;
                insert mainProject into mainProjects;
                getChildProjects(mainProject);
                mainProjects = Sequences.sort(mainProjects, new ProjectNameComparator()) as Project[];
            }
            onError: function(obj:Object):Void {
                println("In loadMainProjects#onError, obj:{obj}");
            }
        }
        readRequest.start();
    }

    function getChildProjects(project:Project):Project[] {
        var children:Project[] = project.Children;
        if (sizeof children > 0) {
            for (child in children) {
                insert child into mainProjects;
                getChildProjects(child);
            }
        }
        else return null;
    }

    /**
     * TODO: Consider migrating this from RedFX to pure JSON parser after measuring performance differences
     */
    function loadWorkspaces():Void {
        delete workspaces;
        //TODO: Put back in
        var subscription:Subscription = myUser.Subscription as Subscription;

        var readRequest:ReadRequest = ReadRequest {
            endPoint: "{subscription._ref}?fetch=Workspaces"
            onResponse: function(wrapper:DomainObjectWrapper):Void {
                subscription = wrapper.Subscription;

                workspaces = subscription.Workspaces;
                workspaces = Sequences.sort(workspaces, new WorkspaceNameComparator()) as Workspace[];
                selectedWorkspaceIndex = Sequences.indexOf(workspacesNames, defaultWorkspace._refObjectName);
            }
            onError: function(obj:Object):Void {
                println("In loadWorkspaces#onError, obj:{obj}");
            }
        }
        readRequest.start();
    }

    public function getRelease(releasePlanName:String) {
        return if (releasePlanName == "") backlog else releases[r|r.roadmapRelease == releasePlanName][0];
    }

    public bound function limitByCount(stageIndex:Integer):Boolean {
        return wipLimitByCount[stageIndex];
    }

    public bound function getWipLimit(stageIndex:Integer):Double {
        def multiplier = SequenceUtil.product(for (p in packageNames) {
            if (p == selectedPackage) {
                themeRatios[indexof p];
            } else {
                1
            }
        });
        def rawLimit = wipLimits[stageIndex] * multiplier;
        return if (wipLimitByCount[stageIndex]) Math.ceil(rawLimit) else rawLimit;
    }

    public bound function overSubLimit(stageIndex:Integer):Boolean {
        return false;
    }

    public function requestAccess():Boolean {
        if (readOnly and not warned) {
            Alert.inform("View is read only.  Changes you make will not be saved!");
            warned = true;
        }
        return not readOnly;
    }

    public function refresh():Void {
        for (stage in stages) stage.stories = null;
        for (r in [backlog, releases]) r.refresh();
    }

    public function findStage(stageName:String):Stage {
        if (stageName == null) return null;
        for (stage in stages) {
            if (stage.name.equalsIgnoreCase(stageName)) {
                return stage;
            }
        }
        return null;
    }

    public bound function convertEstimate(estimate:Double):String {
        return if (showInDollars) {
            def dollars = estimate * estimateToActualRatio * actualToCostRatio;
            if (dollars >= 10000000) {
                "${%.0f dollars/1000000}M";
            } else if (dollars >= 1000000) {
                "${%.1f dollars/1000000}M";
            } else if (dollars >= 10000) {
                "${%.0f dollars/1000}K";
            } else if (dollars >= 1000) {
                "${%.1f dollars/1000}K";
            } else {
                "${%.0f dollars}";
            }
        } else {
            "{estimate}";
        }
    }
}
