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

import com.rallydev.webservice.v1_19.rallyworkspace.domain.Project;
import com.rallydev.webservice.v1_19.rallyworkspace.domain.User;
import com.rallydev.webservice.v1_19.rallyworkspace.domain.UserProfile;
import com.rallydev.webservice.v1_19.rallyworkspace.service.RallyService;
import com.rallydev.webservice.v1_19.rallyworkspace.service.RallyServiceServiceLocator;
import javafx.scene.image.Image;
import javafx.util.Math;
import org.apache.axis.client.Stub;
import org.jfxtras.lang.XObject;
import org.jfxtras.util.SequenceUtil;
import javafx.stage.Alert;
import com.rallydev.webservice.v1_19.rallyworkspace.domain.OperationResult;
import org.apache.axis.AxisFault;
import javafx.util.Sequences;
import com.rallydev.webservice.v1_19.rallyworkspace.domain.Workspace;
import com.rallydev.webservice.v1_19.rallyworkspace.domain.Subscription;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
public def APROPOS_VERSION = "0.8.29";

public var readOnly:Boolean;

def community:Boolean = false;
def show:Boolean = false;
public def server = bind if (community) "https://community.rallydev.com/" else if (show) "https://show.rallydev.com/" else "https://rallytest1.rallydev.com/";

//def GUEST_USER = if (community) "apropos@jfxtras.org" else if (show) "peggy@acme.com" else "catherine@rallydev.com";
def GUEST_USER = if (community) "apropos@jfxtras.org" else if (show) "peggy@acme.com" else "james.l.weaver@gmail.com";
def GUEST_PASSWORD = if (community) "AproposFX" else if (show) "4apropos" else "";

public def instance = RallyModel {}
package def projectsManager:ProjectsManager = ProjectsManager {};

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
//    public-init var ownerNames:String[] =
//      if (community) ["vaan@jfxtras.org", "ashe@jfxtras.org", "basch@jfxtras.org", "penelo@jfxtras.org", "balthier@jfxtras.org", "fran@jfxtras.org"]
//      else if (show) ["paul@acme.com", "dave@acme.com", "srampson@rallydev.com", "peggy@acme.com", "sara@acme.com", "tara@acme.com", "tom@acme.com"]
//      else ["alex@rallydev.com", "lmaccherone@rallydev.com", "mringer@rallydev.com",
//            "klindholm@rallydev.com", "sstolt@rallydev.com", "mcampbell@rallydev.com",
//            "catherine@rallydev.com", "katie@rallydev.com", "james.l.weaver@gmail.com"];
//    public-init var owners:User[];
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
    public-read var rallyService:RallyService;
    public var backlog:Backlog;
    public var releases:Release[];
    public var stages:Stage[];

    public var mainProjectName;
    public-read var mainProject:Project on replace {
        //TODO: Find better way of governing when loadReleases() is invoked
        if (mainProject != null and roadmapKanbanStatesLoaded and roadmapReleasesLoaded) {
            loadReleases();
        }
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
        mainProjects[selectedMainProjectsIndex - 1].getName();
    }

    public var epicNames:String[];

    public-read var workspaces:Workspace[];
    public-read var workspacesNames:String[] =
        bind for (workspace in workspaces) workspace.getRefObjectName();

    public-read var defaultWorkspace:Workspace;
    public-read var selectedWorkspace:Workspace on replace {
        // If the workspace changes, and the default project is not in the
        // workspace (or there is no default project), then choose the first
        // project in the workspace in alphabetical order (see business rules
        // in S19520)
        if (selectedWorkspace != null) {
            loadProjectsForCurrentWorkspaceByQuery();
            if ((selectedWorkspace.getRefObjectName() == defaultWorkspace.getRefObjectName()) and (defaultProject != null)) {
                mainProject = defaultProject;
                println("Switching to default project: {mainProject.getName()}");
            }
            else if (sizeof projectsInCurrentWorkspace > 0) {
                mainProject = projectsInCurrentWorkspace[0];
                println("Switching to first project alphabetically: {mainProject.getName()}");
            }
            else {
                Alert.inform("No project available in workspace {selectedWorkspace.getName()}");
            }
        }
    };
    public var selectedWorkspaceIndex:Integer on replace {
        if (selectedWorkspaceIndex >= 0) {
            selectedWorkspace = workspaces[selectedWorkspaceIndex];
            selectedWorkspace = rallyService.read(selectedWorkspace) as Workspace;
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

//    public var selectedOwnerIndex:Integer;
//    public var selectedOwner:String = bind if (selectedOwnerIndex == 0) null else {
//        owners[selectedOwnerIndex - 1].getDisplayName();
//    }

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
            loadMainProjects();
            //loadMainProjectsByQuery();
        }
    }

    public function doLogin():Void {
        try {
            processingLogin = true;
            createService();
            loggedIn = true;
            retrieveCustomFieldValues();
//            kanbanStatesCFU = CustomFieldUtil {
//                customFieldName: "RoadmapKanbanState"
//                username: login.userName
//                password: login.password
//            };
//            releasesCFU = CustomFieldUtil {
//                customFieldName: "RoadmapRelease"
//                username: login.userName
//                password: login.password
//            };
        } catch (e:AxisFault) {
            processingLogin = false;
            Alert.inform("Login Failed", "Login failed to Rally.  Please double check your username and password.");
        }
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

    function createService():Void {
        rallyService = new RallyServiceServiceLocator().getRallyService();

        var stub = rallyService as Stub;
        stub.setUsername(login.userName);
        stub.setPassword(login.password);

        stub.setMaintainSession(true);

        // Get the logged-user, project, and workspace

        myUser = rallyService.getCurrentUser() as User;
        if (myUser != null) {
            myUserProfile = myUser.getUserProfile();
            myUserProfile = rallyService.read(myUserProfile) as UserProfile;
            mainProject = myUserProfile.getDefaultProject();

            //var proj = rallyService.read(mainProject);
            var proj = projectsManager.read(mainProject);
            if (proj instanceof OperationResult) {
                def operRes = proj as OperationResult;
                Alert.inform("No default project set for user.  Please set a default project in Rally");
                println("operRes.getErrors() = {operRes.getErrors()}");
            }
            else {
                //defaultProject = rallyService.read(mainProject) as Project;
                defaultProject = projectsManager.read(mainProject) as Project;
                mainProject = defaultProject;
                mainProjectName = mainProject.getName();
                println("mainProjectName:{mainProjectName}");

                defaultWorkspace = myUserProfile.getDefaultWorkspace();
                defaultWorkspace = rallyService.read(defaultWorkspace) as Workspace;
                println("defaultWorkspace.getName():{defaultWorkspace.getName()}");
            }
        }
        else {
            println("Unable to login user");
            Alert.inform("Unable to login user");
        }
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

//    function loadOwners() {
//        owners = for (ownerName in ownerNames) {
//            def results = rallyService.query(null, mainProject, false, false, "User", "(EmailAddress = \"{ownerName}\")", null, true, 0, 100).getResults();
//            if (sizeof results == 0) null else results[0] as User;
//        }
//    }

    function loadMainProjectsByQuery():Void {
        delete mainProjects;
        insert mainProject into mainProjects;
        def results = rallyService.query(selectedWorkspace, mainProject, false, false, "Project", "(State = \"Open\")", null, true, 0, 100).getResults() as Project[];
        if (sizeof results > 0) {
//            for (project in results) {
//                insert project into mainProjects;
//            }

            mainProjects = results as Project[];
        }
        else {
            println("In loadMainProjectsByQuery, no results returned");
        }

        mainProjects = Sequences.sort(mainProjects, new ProjectComparator()) as Project[];
    }

    function loadMainProjects():Void {
        delete mainProjects;
        insert mainProject into mainProjects;
        getChildProjects(mainProject);
        mainProjects = Sequences.sort(mainProjects, new ProjectComparator()) as Project[];
    }

    function getChildProjects(project:Project):Project[] {
        println("------------------------In getChildProjects(), project:{project.getName()}, state:{project.getState()}");
        // Only consider open projects
        if (project.getState() == "Open") {
            var children:Project[] = project.getChildren();
            if (sizeof children > 0) {
                for (child in children) {
                    //def proj = rallyService.read(child) as Project;
                    def proj = projectsManager.read(child) as Project;
                    // Only insert projects that are open, TODO: and have no open child projects,
                    if (proj.getState() == "Open") {
                         insert proj into mainProjects;
                    }
                    getChildProjects(proj);
                }

            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    function loadProjectsForCurrentWorkspaceByQuery():Void {
        def results = rallyService.query(selectedWorkspace, "Project", "(State = \"Open\")", "Name", true, 0, 100).getResults() as Project[];
        if (sizeof results > 0) {
//            for (project in results) {
//                insert project into mainProjects;
//            }

            projectsInCurrentWorkspace = results as Project[];
        }
        else {
            println("In loadProjectsForCurrentWorkspaceByQuery, no results returned");
        }

        //mainProjects = Sequences.sort(mainProjects, new ProjectComparator()) as Project[];
    }

    function loadProjectsForCurrentWorkspace():Void {
        var openProjectsInWorkspace:Project[];
        def projectsInWorkspace:Project[] = selectedWorkspace.getProjects();
        for (project in projectsInWorkspace) {
            // TODO: Change to use caching mechanism after inplementing REST, if
            //       necessary.
            //def proj = rallyService.read(project) as Project;
            def proj = projectsManager.read(project) as Project;
            //def proj = rallyService.read(project) as Project;
            if (proj.getState() == "Open") {
                insert proj into openProjectsInWorkspace;
            }
        }
        projectsInCurrentWorkspace = Sequences.sort(openProjectsInWorkspace, new ProjectComparator()) as Project[];
        println("projectsInCurrentWorkspace:{for (project in projectsInCurrentWorkspace) "{project.getName()}\n "}");
    }

    function loadWorkspaces():Void {
        delete workspaces;
        var subscription = myUser.getSubscription();
        subscription = rallyService.read(subscription) as Subscription;
        workspaces = subscription.getWorkspaces();
//        for (workspace in workspaces) {
//            workspaces[indexof workspace] = rallyService.read(workspace) as Workspace;
//        }
        workspaces = Sequences.sort(workspaces, new WorkspaceRefComparator()) as Workspace[];
//        println("workspaces:{for (workspace in workspaces) "{workspace.getName()}, "}");
        selectedWorkspaceIndex = Sequences.indexOf(workspacesNames, defaultWorkspace.getRefObjectName());

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

// causes a big performance issues - need to investigate further...
//    bound function overThemeLimit(stageIndex:Integer, themeIndex:Integer, theme:String) {
//        def limitByCount = wipLimitByCount[stageIndex];
//        def stageLimit = wipLimits[stageIndex];
//        def stage = stages[stageIndex];
//        def themeLimit = stageLimit * themeRatios[themeIndex];
//        def filteredStories = stage.stories[s|s.inPackage == theme];
//        def filteredCount = sizeof filteredStories;
//        def filteredSize = SequenceUtil.sum(for (story in filteredStories) story.estimate);
//        def themeTotal = if (limitByCount) filteredCount else filteredSize;
//        themeTotal > themeLimit;
//    }

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

//    public function getOwnerDisplayName(ownerEmailAddress:String):String {
//        var displayName:String;
//        for (owner in owners) {
//            if (owner.getEmailAddress() == ownerEmailAddress) {
//                displayName = owner.getDisplayName();
//                break;
//            }
//        }
//        return displayName;
//    }

}
