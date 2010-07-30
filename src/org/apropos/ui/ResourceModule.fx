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

import org.apropos.model.RallyModel;
import org.apropos.model.Story;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.control.XTableColumn;
import org.jfxtras.scene.control.XTableView;
import org.jfxtras.scene.control.renderer.RowNumberRenderer;
import org.jfxtras.scene.control.renderer.TextRenderer;
import org.jfxtras.scene.layout.XGrid;
import org.jfxtras.scene.layout.XGridLayoutInfo.*;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XVBox;
import org.jfxtras.scene.paint.ColorUtil;
import org.jfxtras.util.SequenceUtil;
import javafx.scene.image.ImageView;
import javafx.scene.control.ScrollView;
import javafx.scene.layout.LayoutInfo;
import javafx.scene.control.Label;

/**
 * @author Stephen Chin
 */
public class ResourceModule extends AbstractModulePage {
        
    //def model = RallyModel.instance;

    var stories:Story[] = bind model.currentRelease.stories;

    var selectedPackage = bind model.selectedPackage;

    public-read var filteredStories = bind model.filter(model.currentRelease.stories);

    var ownerTotals:Double[];

    function calculateOwnerTotals() {
        ownerTotals = for (owner in model.owners) {
            SequenceUtil.sum(for (story in stories where story.ownerName == owner.getRefObjectName() and story.drafted) story.estimate)
        }
    }

    def parentBind = bind parent on replace {
        if (parent != null) {
            calculateOwnerTotals();
        }
    }

//    def epicFilter = Filter {name: "Epic", list: bind model.epicNames, selectedIndex: bind model.selectedEpicIndex with inverse}
//    def packageFilter = Filter {name: "Package", list: bind model.packageNames, selectedIndex: bind model.selectedPackageIndex with inverse}

    def allocationFilter = Filter {
        name: "Investment Allocation"
        list: bind model.allocationNames
        selectedIndex: bind model.selectedAllocationIndex with inverse
    };
    def ownerFilter = Filter {
        name: "Owner"
        list: bind for (o in model.owners) o.getDisplayName()
        selectedIndex: bind model.selectedOwnerIndex with inverse
    };

    def filters = XHBox {
        spacing: 8
//        layoutInfo: LayoutInfo {
//          width: bind scene.width
//        }
        content: [
            allocationFilter,
            ownerFilter,
            Button {
                text: "Auto Draft"
                action: function() {
                    for (story in stories) {
                        story.drafted = true;
                    }
                    calculateOwnerTotals();
                }
            }
            Button {
                text: "Clear"
                action: function() {
                    for (story in stories) {
                        story.drafted = false;
                    }
                    calculateOwnerTotals();
                }
            }
        ]
    }

    def owners = XGrid {
        hgap: 10
        vgap: 10
        rows: for (owner in model.owners) {
            var target:String = model.initialTargets[indexof owner];
            row([
                ImageView {
                    image: model.ownerImages[indexof owner]
                }
                Text {
                    content: owner.getDisplayName();
                    fill: Color.WHITE
                    font: Font.font(null, 18);
                }
                Button {
                    text: "Draft"
                    action: function() {
                        def story = filteredStories[table.selectedRow];
                        if (story.owner != owner) {
                            story.owner = owner;
                            story.ownerDisplayName = owner.getDisplayName();
                        }
                        story.drafted = true;
                        calculateOwnerTotals();
                    }
                }
                Label {
                    text: bind "Total: {ownerTotals[indexof owner]}"
                    textFill: bind if (target != "" and Double.valueOf(target) < ownerTotals[indexof owner]) ColorUtil.lighter(Color.RED, .3) else Color.WHITE
                    font: Font.font(null, 18);
                    layoutInfo: LayoutInfo {
                      width: 100
                    }
                }
//                Text {
//                    content: bind "Total: {ownerTotals[indexof owner]}"
//                    fill: bind if (target != "" and Double.valueOf(target) < ownerTotals[indexof owner]) ColorUtil.lighter(Color.LIGHTSALMON, .3) else Color.WHITE
//                    font: Font.font(null, 18);
//                }
                Text {
                    content: bind "Target:"
                    fill: Color.WHITE
                    font: Font.font(null, 18);
                }
                TextBox {
                    text: bind target with inverse;
                    font: Font.font(null, 18);
                }
                VBox {
                    def ownerStories = bind stories[s|s.owner.getRefObjectName() == owner.getRefObjectName()];
                    content: [
                        Text {
                            content: "Compliance"
                            fill: Color.WHITE
                        }
                        ProgressBar {
                            progress: bind (sizeof ownerStories[s|s.acceptanceTest == "Y"] as Number) / (sizeof ownerStories)
                        }
                        ProgressBar {
                            progress: bind (sizeof ownerStories[s|s.scheduled] as Number) / (sizeof ownerStories)
                        }
                    ]
                }
            ])
        }
    }

    def table:XTableView = XTableView {
        rowType: Story {}.getJFXClass()
        rows: bind filteredStories
        rowHeight: 50
        onMouseClicked: function(e) {
            if (e.clickCount == 2) {
                filteredStories[table.selectedRow].browse();
            }
        }
        columns: [
            XTableColumn {
                displayName: "#"
                prefWidth: 20
                id: "rank"
                renderer: RowNumberRenderer {}
            }
            XTableColumn {
                displayName: "ID"
                prefWidth: 20
                id: "id"
                renderer: TextRenderer {}
            }
            XTableColumn {
                displayName: "Theme"
                prefWidth: 80
                id: "parentName"
                renderer: TextRenderer {}
            }
            XTableColumn {
                displayName: "Feature"
                prefWidth: 100
                id: "name"
                renderer: TextRenderer {}
            }
            XTableColumn {
                displayName: "Owner"
                prefWidth: 100
                id: "ownerDisplayName"
                renderer: TextRenderer {}
            }
            XTableColumn {
                displayName: "Est"
                prefWidth: 40
                id: "estimateDisplay"
                renderer: TextRenderer {}
            }
            XTableColumn {
                displayName: "Drafted"
                prefWidth: 40
                id: "drafted"
                renderer: TextRenderer {}
            }
        ]
    }

    init {
        pageToolBar = PageToolBar {
            leftNodes: [
                allocationFilter,
                ownerFilter
            ]
            rightNodes: CostSelectionNode {}
        };
        pageContent = XVBox {
            spacing: 10
            content: [
                filters,
                XHBox {
                    spacing: 20
                    content: [
                        table,
                        ScrollView {
                            node: owners
                            layoutInfo:LayoutInfo {
                                width: bind owners.width + 20
                            }
                        }
                    ]
                }
            ]
        }
    }

//    override function create() {
//        XVBox {
//            spacing: 10
//            content: [
//                filters,
//                XHBox {
//                    spacing: 20
//                    content: [
//                        table,
//                        ScrollView {
//                            node: owners
//                            layoutInfo:LayoutInfo {
//                                width: bind owners.width + 20
//                            }
//                        }
//                    ]
//                }
//            ]
//        }
//    }
}
