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

import com.rallydev.webservice.v1_20.domain.Project;
import com.rallydev.webservice.v1_20.domain.User;
import com.rallydev.webservice.v1_20.service.RallyService;
import com.rallydev.webservice.v1_20.service.RallyServiceServiceLocator;
import javafx.scene.image.Image;
import javafx.stage.Alert;
import javafx.util.Math;
import org.apache.axis.client.Stub;
import org.apache.axis.AxisFault;
import org.jfxtras.lang.XObject;
import org.jfxtras.util.SequenceUtil;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
public def APROPOS_VERSION = "0.8.15";

public var readOnly:Boolean;

def community:Boolean = false;
def show:Boolean = true;
public def server = bind if (community) "https://community.rallydev.com/" else if (show) "https://show.rallydev.com/" else "https://rally1.rallydev.com/";

def GUEST_USER = if (community) "apropos@jfxtras.org" else if (show) "peggy@acme.com" else "build@inovis.com";
def GUEST_PASSWORD = if (community) "AproposFX" else if (show) "4apropos" else "StephenIsCool";

public def instance = RallyModel {}

public class RallyModel extends XObject {
    var warned = false;
    public var login = Login {userName: GUEST_USER, password: GUEST_PASSWORD};
    public var loggedIn = false;
    public var processingLogin:Boolean = false;
    public var showInDollars = false;
    public-init var releasePlanNames = ["2010 Q3", "2010 Q4"];
    public-init var currentRelease:Release;
    public-init var iterations = ["Iteration 5 (R2)", "Iteration 6 (R2)", "Iteration 7 (R2)", "Iteration 8 (R3)", "Iteration 9 (R3)", "Iteration 10 (R3)"];
    public-init var ownerNames:String[] =
      if (community) ["vaan@jfxtras.org", "ashe@jfxtras.org", "basch@jfxtras.org", "penelo@jfxtras.org", "balthier@jfxtras.org", "fran@jfxtras.org"]
      else if (show) ["paul@acme.com", "dave@acme.com", "srampson@rallydev.com", "peggy@acme.com", "sara@acme.com", "tara@acme.com", "tom@acme.com"]
      else ["michelle.covey@inovis.com", "tom.aydelotte@inovis.com", "david.gouge@inovis.com", "murray.brook@inovis.com", "brian.huddleston@inovis.com", "peter.corliss@inovis.com", "jason.westigard@inovis.com"];
    public-init var owners:User[];
    public-read var myUser:User;
    public-read var myImage:Image;
    public-read var ownerImages:Image[];
    public-init var initialTargets = ["396", "360", "168", "702", "150", "365", "270"];
    public-init var stageNames = ["Propose", "Backlog", "Schedule", "Develop", "Deploy", "Enable", "Adopt", "Validate"];
    public-init var themeRatios = [.05, .38, .27, .16, .03, .08, .01];
    public-init var wipLimits = [0.0, 9600.0, 2400.0, 1000.0, 0, 12, 12, 0];
    public-init var wipLimitByCount = [false, false, false, false, false, true, true, false];
    public-init var estimateToActualRatio = 4.53;
    public-init var actualToCostRatio = 66.5;
    public-read var rallyService:RallyService;
    public var backlog:Backlog;
    public-init var releaseNames = ["Internal Release 2010Q3", "Internal Release 2010Q4", "Internal Release 2011Q1", "Internal Release 2011Q2"];
    public var releases:Release[];
    public var stages:Stage[];

    public var epicNames:String[];

    public var allocationNames:String[];
    public var selectedAllocationIndex:Integer;
    public var selectedAllocation:String = bind if (selectedAllocationIndex == 0) null else {
        allocationNames[selectedAllocationIndex - 1];
    }

    //TODO: Remove the concept of packages, in favor of Portfolio Allocations
    public var packageNames:String[];
    public var selectedPackageIndex:Integer;
    public var selectedPackage:String = bind if (selectedPackageIndex == 0) null else {
        packageNames[selectedPackageIndex - 1];
    }

    public var selectedOwnerIndex:Integer;
    public var selectedOwner:String = bind if (selectedOwnerIndex == 0) null else {
        owners[selectedOwnerIndex - 1].getDisplayName();
    }
    public var mainProjectName = if (community) "" else if (show) "Online Store" else "Business Community Management";
    public-read var mainProject:Project;
    public var waiting = 0;

    bound function filtersOn() {
        return selectedAllocation != null or selectedOwner != null;
    }

    bound function selected(s:Story) {
        (selectedAllocation == null or s.portfolioAllocation == selectedAllocation) and
        (selectedOwner == null or s.ownerName == selectedOwner)
    }

    public bound function filter(stories:Story[]) {
        if (not filtersOn()) stories else stories[s|selected(s)];
    }

    public function doLogin():Void {
        try {
            processingLogin = true;
            readOnly = login.userName == GUEST_USER and not show;

            createService();
            loadReleases();
            loadOwners();

            loggedIn = true;
        } catch (e:AxisFault) {
            processingLogin = false;
            Alert.inform("Login Failed", "Login failed to Rally.  Please double check your username and password.");
        } finally {
          processingLogin = false;
        }
    }

    function loadReleases() {
// todo - release fix
//        def rallyReleases = rallyService.query(null, mainProject, false, false, "Release", null, null, true, 0, 100).getResults();
//        def now = Calendar.getInstance();
        backlog = Backlog {model: this}
//        releases = for (r in rallyReleases where (r as com.rallydev.webservice.v1_19.domain.Release).getReleaseDate().<<after>>(now)) Release {release: r as com.rallydev.webservice.v1_19.domain.Release, model: this}
        releases = for (rpn in releasePlanNames) Release {model: this, name: rpn}
        for (r in releases) {
//            if (r.release.getReleaseStartDate().<<before>>(now) and r.release.getReleaseDate().<<after>>(now)) currentRelease = r;
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
    }

    function loadOwners() {
        def myResult = rallyService.query(null, mainProject, false, false, "User", "(UserName = \"{login.userName}\")", null, true, 0, 100).getResults();
        if (sizeof myResult > 0) {
            myUser = myResult[0] as User;
        } else {
            println("Unable to get credentials for users -- please update account priveleges");
        }
        owners = for (ownerName in ownerNames) {
            def results = rallyService.query(null, mainProject, false, false, "User", "(UserName = \"{ownerName}\")", null, true, 0, 100).getResults();
            if (sizeof results == 0) null else results[0] as User;
        }
        // hack to login for image retrieval
        Image {url: "{server}slm/j_spring_security_check?j_username={login.userName}&j_password={login.password}"}
        Image {url: "{server}slm/j_spring_security_check?j_username={login.userName}&j_password={login.password}"}
        myImage = Image {
            width: 70
            height: 70
            preserveRatio: true
            url: "{server}slm/profile/viewThumbnailImage.sp?tSize=200&uid={myUser.getObjectID()}"
        }
        ownerImages = for (owner in owners) {
            Image {
                width: 70
                height: 70
                preserveRatio: true
                url: "{server}slm/profile/viewThumbnailImage.sp?tSize=200&uid={owner.getObjectID()}"
            }
        }
    }

    public function getRelease(releasePlanName:String) {
        return releases[r|r.name == releasePlanName][0];
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
//        def packagesOver = for (p in packageNames where overThemeLimit(stageIndex, indexof p, p)) p;
//        return sizeof packagesOver > 0;
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

    function createService():Void {
        rallyService = new RallyServiceServiceLocator().getRallyService();

        var stub = rallyService as Stub;
        stub.setUsername(login.userName);
        stub.setPassword(login.password);

        stub.setMaintainSession(true);
        // todo - need to create a project selector dialog
        def projects = rallyService.query(null, "Project", null, null, true, 0, 100).getResults();
        for (project in projects) {
            def p = project as Project;
            if (p.getName() == mainProjectName) {
                mainProject = p;
            }
        }
        if (mainProject == null) {
            mainProject = projects[0] as Project;
        }
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

    public function getOwnerDisplayName(ownerEmailAddress:String):String {
        var displayName:String;
        for (owner in owners) {
            if (owner.getEmailAddress() == ownerEmailAddress) {
                displayName = owner.getDisplayName();
                break;
            }
        }
        return displayName;
    }

}
