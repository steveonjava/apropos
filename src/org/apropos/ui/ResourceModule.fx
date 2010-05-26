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
import javafx.scene.control.Label;
import javafx.scene.control.TextBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.control.XTableColumn;
import org.jfxtras.scene.control.XTableView;
import org.jfxtras.scene.control.XPicker;
import org.jfxtras.scene.control.renderer.RowNumberRenderer;
import org.jfxtras.scene.control.renderer.TextRenderer;
import org.jfxtras.scene.layout.XGrid;
import org.jfxtras.scene.layout.XGridLayoutInfo.*;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XVBox;
import org.jfxtras.scene.paint.ColorUtil;
import org.jfxtras.util.SequenceUtil;

/**
 * @author Stephen Chin
 */
public class ResourceModule extends XCustomNode {
        
    def model = bind RallyModel.instance;

    def firstRelease = model.releases[0];

    var stories:Story[] = bind firstRelease.stories on replace {
        updateFiltered();
    }

    var selectedPackage = bind model.selectedPackage on replace {
        updateFiltered();
    }

    function updateFiltered() {
        filteredStories = firstRelease.stories[s|selectedPackage == null or s.inPackage == selectedPackage];
    }

    var filteredStories:Story[];

    var table:XTableView;

    var ownerTotals:Double[];

    function calculateOwnerTotals() {
        ownerTotals = for (owner in model.owners) {
            SequenceUtil.sum(for (story in stories where story.owner == owner and story.drafted) story.estimate)
        }
    }

    def parentBind = bind parent on replace {
        if (parent != null) {
            calculateOwnerTotals();
        }
    }

    var picker:XPicker = XPicker {
        items: bind ["All", model.packageNames]
        onIndexChange: function(index) {
            model.selectedPackageIndex = index;
        }
    }
    def selectedPackageIndex = bind model.selectedPackageIndex on replace {
        if (picker.selectedIndex != model.selectedPackageIndex) {
            picker.select(model.selectedPackageIndex);
        }
    }

    override function create() {
        XHBox {
            spacing: 20
            content: [
                XVBox {
                    spacing: 10
                    content: [
                        Label {
                            text: "Investment Filter:"
                            textFill: Color.WHITE
                        }
                        XHBox {
                            spacing: 8
                            content: [
                                picker,
                                Button {
                                    text: "Auto Draft"
                                    style: RallyModel.buttonSkin
                                    action: function() {
                                        for (story in stories) {
                                            story.drafted = true;
                                            calculateOwnerTotals();
                                            filteredStories = null;
                                            updateFiltered();
                                        }
                                        model.approval = true;
                                    }
                                }
                                Button {
                                    text: "Clear"
                                    style: RallyModel.buttonSkin
                                    action: function() {
                                        for (story in stories) {
                                            story.drafted = false;
                                            calculateOwnerTotals();
                                            filteredStories = null;
                                            updateFiltered();
                                        }
                                    }
                                }
                            ]
                        }
                        table = XTableView {
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
                                    displayName: "Epic Name"
                                    prefWidth: 80
                                    id: "parentName"
                                    renderer: TextRenderer {}
                                }
                                XTableColumn {
                                    displayName: "Feature Name"
                                    prefWidth: 100
                                    id: "name"
                                    renderer: TextRenderer {}
                                }
                                XTableColumn {
                                    displayName: "Owner"
                                    prefWidth: 100
                                    id: "owner"
                                    renderer: TextRenderer {}
                                }
                                XTableColumn {
                                    displayName: "Est"
                                    prefWidth: 40
                                    id: "estimateDisplay"
                                    renderer: TextRenderer {}
                                }
                                XTableColumn {
                                    displayName: "AT"
                                    prefWidth: 40
                                    id: "acceptanceTest"
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
                    ]
                }
                XGrid {
                    hgap: 10
                    vgap: 20
                    rows: for (owner in model.owners) {
                        var target:String = model.initialTargets[indexof owner];
                        row([
                            Text {
                                content: model.ownerNames[indexof owner]
                                fill: Color.WHITE
                                font: Font.font(null, 18);
                            }
                            Button {
                                text: "Draft"
                                style: RallyModel.buttonSkin
                                action: function() {
                                    def story = filteredStories[table.selectedRow];
                                    if (story.owner != owner) {
                                        story.owner = owner;
                                    }
                                    story.drafted = true;
                                    calculateOwnerTotals();
                                    filteredStories = null;
                                    updateFiltered();
                                    model.approval = true;
                                }
                            }
                            Text {
                                content: bind "Total: {ownerTotals[indexof owner]}"
                                fill: bind if (target != "" and Double.valueOf(target) < ownerTotals[indexof owner]) ColorUtil.lighter(Color.RED, .3) else Color.WHITE
                                font: Font.font(null, 18);
                            }
                            Text {
                                content: bind "Target:"
                                fill: Color.WHITE
                                font: Font.font(null, 18);
                            }
                            TextBox {
                                text: bind target with inverse;
                                font: Font.font(null, 18);
                            }
                        ])
                    }
                }
            ]
        }
    }
}
