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
package org.apropos.ui;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XLayoutInfo;
import org.jfxtras.scene.layout.XLayoutInfo.*;
import org.jfxtras.scene.layout.XVBox;
import org.jfxtras.scene.control.XPicker;
import org.apropos.model.Release;
import javafx.animation.transition.FadeTransition;
import javafx.animation.Interpolator;

/**
 * @author Stephen Chin
 */
public class AnalyzeModule extends AbstractModulePage {

//    def releaseChoice:ChoiceBox = ChoiceBox {
//        items: bind model.releases
//        var selIndex = bind releaseChoice.selectedIndex on replace {
//          if (selIndex >= 0) {
//            rebuildChart();
//          }
//        }
//    }
//
//    def release = bind releaseChoice.selectedItem as Release;

    def release:Release = bind model.releases[selectedIndex] as Release;

    def fadeIn = FadeTransition {
        node: bind pageContent
        fromValue: 0.0
        toValue: 1.0
        duration: 2000ms
        interpolator: Interpolator.LINEAR
    };


    public var selectedIndex:Integer = 0 on replace {
        if (releaseChoice.selectedIndex != selectedIndex) {
            releaseChoice.select(selectedIndex);
        }
        if (selectedIndex >= 0) {
            fadeIn.playFromStart();
            rebuildChart();
        }
    }

//    var releaseChoice:XPicker = XPicker {
//        firstLetter: true
//        promptText: "Please choose ..."
//        //id: "JFXtras Shapes"
//        layoutInfo: XLayoutInfo {
////            hfill: true
////            maxWidth: 4000
//            width: 160
//        }
//        items: bind model.releases
//        onIndexChange: function(index) {
//            selectedIndex = index;
//        }
//    };

    var releaseChoice:RallyPicker = RallyPicker {
        rowWidth: 160
        rowHeight: 20
        items: bind for (rel in model.releases) "{rel}"
        onIndexChange: function(index) {
            selectedIndex = index;
        }
    };


    def names = bind model.allocationNames;

    def parentBind = bind parent on replace {
        if (parent != null) {
            rebuildChart();
        }
    }

    var chart:PieChart;

    function rebuildChart():Void {
        def data = for (name in names where release.getAllocationTotals(name) > 0) {
            PieChart.Data {
                label: name
                value: release.getAllocationTotals(name)
            }
        }
        chart = PieChart {
            titleFont: Font.font(null, 24)
            title: bind "Investment Allocation for {release}"
            data: data
            legendVisible: true
            layoutInfo: XLayoutInfo {hgrow: ALWAYS, vgrow: ALWAYS, vfill: true, hfill: true}
        }
    }
    
    def pickers = XHBox {
        spacing: 8
        content: [
            Label {
                text: "Release:"
            }
            releaseChoice
        ]
    }

    init {
        pageToolBar = PageToolBar {
            leftNodes: pickers
            rightNodes: CostSelectionNode {}
        }
        pageContent = XVBox {
            content: bind chart
        }
        model.selectedAllocationIndex = 0;
        model.selectedReleaseIndex = 0;
        model.selectedMainProjectsIndex = 0;
    }

    public override function initPage():Void {
        fadeIn.playFromStart();
        releaseChoice.select(0);
    };
}
