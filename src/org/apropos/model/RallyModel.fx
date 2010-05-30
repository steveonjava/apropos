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

import com.rallydev.webservice.v1_17.domain.Project;
import com.rallydev.webservice.v1_17.domain.User;
import com.rallydev.webservice.v1_17.service.RallyService;
import com.rallydev.webservice.v1_17.service.RallyServiceServiceLocator;
import java.util.Calendar;
import javafx.scene.image.Image;
import javafx.stage.Alert;
import javafx.util.Math;
import org.apache.axis.client.Stub;
import org.jfxtras.lang.XObject;
import org.jfxtras.util.SequenceUtil;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
public var readOnly:Boolean;

public def buttonSkin = "-fx-color: BLACK;"
    "-fx-focus-color: white;"
    "-fx-background: black;";

def GUEST_USER = "apropos@jfxtras.org";
def GUEST_PASSWORD = "AproposFX";

public def instance = RallyModel {}

public class RallyModel extends XObject {
    var warned = false;
    public var login = Login {userName: GUEST_USER, password: GUEST_PASSWORD};
    public var loggedIn = false;
    public var showInDollars = false;
    public-init var currentRelease:Release;
    public-init var iterations = ["Sprint 2010-04-13", "Sprint 2010-04-27", "Sprint 2010-05-11", "Sprint 2010-05-25", "Sprint 2010-06-08", "Sprint 2010-06-22"];
    public-init var ownerNames:String[] = ["vaan@jfxtras.org", "ashe@jfxtras.org", "basch@jfxtras.org", "penelo@jfxtras.org", "balthier@jfxtras.org", "fran@jfxtras.org"];
    public-init var owners:User[];
    public-read var myUser:User;
    public-read var myImage:Image;
    public-read var ownerImages:Image[];
    public-init var initialTargets = ["450", "390", "180", "960", "107", "420", "320", "93"];
    public-init var stageNames = ["Propose", "Backlog", "Schedule", "Develop", "Deploy", "Enable", "Adopt", "Validate"];
    public-init var themeRatios = [.05, .38, .27, .16, .03, .08, .01];
    public-init var wipLimits = [0.0, 9600.0, 2400.0, 1000.0, 0, 12, 12, 0];
    public-init var wipLimitByCount = [false, false, false, false, false, true, true, false];
    public-init var estimateToActualRatio = 4.53;
    public-init var actualToCostRatio = 66.5;
    public-read var rallyService:RallyService;
    public var backlog:Backlog;
    public var releases:Release[];
    public var stages:Stage[];
    public var packageNames:String[];
    public var selectedPackageIndex:Integer;
    public var selectedPackage:String = bind if (selectedPackageIndex == 0) null else {
        packageNames[selectedPackageIndex - 1];
    }
    public-read var mainProject:Project;
    public var waiting = 0;

    public function doLogin():Void {
        try {
            readOnly = login.userName == GUEST_USER;
            createService();
            loadReleases();
            loadOwners();
            loggedIn = true;
        } catch (e) {
            e.printStackTrace();
        }
    }

    function loadReleases() {
        def rallyReleases = rallyService.query(null, mainProject, false, false, "Release", null, null, true, 0, 100).getResults();
        backlog = Backlog {model: this}
        releases = for (r in rallyReleases) Release {release: r as com.rallydev.webservice.v1_17.domain.Release, model: this}
        def now = Calendar.getInstance();
        for (r in releases) {
            if (r.release.getReleaseStartDate().<<before>>(now) and r.release.getReleaseDate().<<after>>(now)) currentRelease = r;
            r.containerBefore = releases[indexof r - 1];
            r.containerAfter = releases[indexof r + 1];
        }
        backlog.containerAfter = releases[0];
        releases[0].containerBefore = backlog;
        stages = for (stageName in stageNames) Stage {name: stageName}
        for (s in stages) {
            s.containerBefore = stages[indexof s - 1];
            s.containerAfter = stages[indexof s + 1];
        }
    }

    function loadOwners() {
        myUser = rallyService.query(null, mainProject, false, false, "User", "(LoginName = \"{login.userName}\")", null, true, 0, 100).getResults()[0] as User;
        owners = for (ownerName in ownerNames) {
            def results = rallyService.query(null, mainProject, false, false, "User", "(LoginName = \"{ownerName}\")", null, true, 0, 100).getResults();
            if (sizeof results == 0) null else results[0] as User;
        }
        // hack to login for image retrieval
        Image {url: "https://community.rallydev.com/slm/j_spring_security_check?j_username={login.userName}&j_password={login.password}"}
        Image {url: "https://community.rallydev.com/slm/j_spring_security_check?j_username={login.userName}&j_password={login.password}"}
        myImage = Image {
            width: 70
            height: 70
            preserveRatio: true
            url: "https://community.rallydev.com/slm/profile/viewThumbnailImage.sp?tSize=200&uid={myUser.getObjectID()}"
        }
        ownerImages = for (owner in owners) {
            Image {
                width: 70
                height: 70
                preserveRatio: true
                url: "https://community.rallydev.com/slm/profile/viewThumbnailImage.sp?tSize=200&uid={owner.getObjectID()}"
            }
        }
    }

    public function getRelease(ref:String) {
        return releases[r|r.release.getRef() == ref][0];
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
        mainProject = rallyService.query(null, "Project", null, null, true, 0, 100).getResults()[0] as Project;
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
