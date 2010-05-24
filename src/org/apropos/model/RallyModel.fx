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

import javafx.stage.Alert;
import javafx.util.Math;
import org.apropos.api.Project;
import org.apropos.api.RallyService_PortType;
import org.apropos.api.RallyServiceServiceLocator;
import org.apache.axis.client.Stub;
import org.jfxtras.lang.XObject;
import org.jfxtras.util.SequenceUtil;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
public var readOnly:Boolean;

public def buttonSkin = "fill: BLACK;"
    "focusFill: DARKGRAY;"
    "borderFill: BLACK;"
    "textFill: WHITE;"
    "shadowFill: BLACK;";

def GUEST_USER = "build@inovis.com";
def GUEST_PASSWORD = "StephenIsCool";

public def instance = RallyModel {}

public class RallyModel extends XObject {
    public var login = Login {userName: GUEST_USER, password: GUEST_PASSWORD};
    public var loggedIn = false;
    public var approval = false;
    public var showInDollars = false;
    public-init var releasePlans = ["2010 Q2", "2010 Q3", "2010 Q4", "2011 Q1"];
    public-init var currentRelease = "2010 Q2";
    public-init var iterations = ["Sprint 2010-04-13", "Sprint 2010-04-27", "Sprint 2010-05-11", "Sprint 2010-05-25", "Sprint 2010-06-08", "Sprint 2010-06-22"];
    public-init var owners:String[] = ["michelle.covey@inovis.com", "tom.aydelotte@inovis.com", "david.gouge@inovis.com", "murray.brook@inovis.com", "brian.huddleston@inovis.com", "peter.corliss@inovis.com", "jason.westigard@inovis.com", "michael.hatton@inovis.com"];
    public-init var ownerNames:String[] = ["Michelle Covey", "Tom Aydelotte", "David Gouge", "Murray Brook", "Brian Huddleston", "Peter Corliss", "Jason Westigard", "Michael Hatton"];
    public-init var initialTargets = ["450", "390", "180", "960", "107", "420", "320", "0"];
    public-init var stageNames = ["Proposed", "Backlogged", "Scheduled", "In Process", "Deployed", "Enabled", "Adopted", "Validated"];
    public-init var themeNames = ["Investment - App/Service Upsell", "Investment - Cloud Platform", "Investment - MFT Go to Market", "Investment - Dell Success", "Investment - Global", "Maintenance", "Sales Directed"];
    public-init var themeRatios = [.05, .38, .27, .16, .03, .08, .01];
    public-init var wipLimits = [0.0, 9600.0, 2400.0, 1000.0, 0, 12, 12, 0];
    public-init var wipLimitByCount = [false, false, false, false, false, true, true, false];
    public-init var estimateToActualRatio = 4.53;
    public-init var actualToCostRatio = 66.5;
    public-read var rallyService:RallyService_PortType;
    public var releases:Release[];
    public var stages:Stage[];
    public var packageNames:String[];
    public var selectedPackageIndex:Integer;
    public var selectedPackage:String = bind if (selectedPackageIndex == 0) null else {
        packageNames[selectedPackageIndex - 1];
    }
    public-read var bcmProject:Project;
    public var waiting = 0;

    public function doLogin():Void {
        readOnly = login.userName == GUEST_USER;
        createService();
        releases = for (r in releasePlans) Release {name: r, model: this}
        for (r in releases) {
            r.containerBefore = releases[indexof r - 1];
            r.containerAfter = releases[indexof r + 1];
        }
        stages = for (stageName in stageNames) Stage {name: stageName}
        for (s in stages) {
            s.containerBefore = stages[indexof s - 1];
            s.containerAfter = stages[indexof s + 1];
        }
        loggedIn = true;
    }

    public bound function limitByCount(stageIndex:Integer):Boolean {
        return wipLimitByCount[stageIndex];
    }

    public bound function getWipLimit(stageIndex:Integer):Double {
        def multiplier = SequenceUtil.product(for (t in themeNames) {
            if (t == selectedPackage) {
                themeRatios[indexof t];
            } else {
                1
            }
        });
        def rawLimit = wipLimits[stageIndex] * multiplier;
        return if (wipLimitByCount[stageIndex]) Math.ceil(rawLimit) else rawLimit;
    }

    public bound function overSubLimit(stageIndex:Integer):Boolean {
        def themesOver = for (theme in themeNames where overThemeLimit(stageIndex, indexof theme, theme)) theme;
        return sizeof themesOver > 0;
    }

    bound function overThemeLimit(stageIndex:Integer, themeIndex:Integer, theme:String) {
        def limitByCount = wipLimitByCount[stageIndex];
        def stageLimit = wipLimits[stageIndex];
        def stage = stages[stageIndex];
        def themeLimit = stageLimit * themeRatios[themeIndex];
        def filteredStories = stage.stories[s|s.inPackage == theme];
        def filteredCount = sizeof filteredStories;
        def filteredSize = SequenceUtil.sum(for (story in filteredStories) story.estimate);
        def themeTotal = if (limitByCount) filteredCount else filteredSize;
        themeTotal > themeLimit;
    }

    public function requestAccess():Boolean {
        if (readOnly) {
            Alert.inform("View is read only.  Changes you make will not be saved!");
        }
        return not readOnly;
    }

    public function refresh():Void {
        for (stage in stages) stage.stories = null;
        for (r in releases) r.refresh();
    }

    function createService():Void {
        rallyService = new RallyServiceServiceLocator().getRallyService();

        var stub = rallyService as Stub;
        stub.setUsername(login.userName);
        stub.setPassword(login.password);

        stub.setMaintainSession(true);
        bcmProject = rallyService.query(null, "Project", "(Name = \"Business Community Management\")", null, true, 0, 100).getResults()[0] as Project;
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
