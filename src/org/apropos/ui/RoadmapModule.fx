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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.control.XPicker;
import org.jfxtras.scene.control.XTableColumn;
import org.jfxtras.scene.control.XTableView;
import org.jfxtras.scene.control.renderer.RowNumberRenderer;
import org.jfxtras.scene.control.renderer.TextRenderer;
import org.jfxtras.scene.layout.XVBox;

/**
 * @author Stephen Chin
 */
public class RoadmapModule extends XCustomNode {

    def model = bind RallyModel.instance;

    var table:XTableView;

    def firstRelease = bind model.releases[0];

    var stories:Story[] = bind firstRelease.stories;

    var filteredStories = bind firstRelease.stories[s|model.selectedPackage == null or s.inPackage == model.selectedPackage];

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
        XVBox {
            spacing: 10
            content: [
                Label {
                    text: "Investment Filter:"
                    textFill: Color.WHITE
                }
                picker,
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
                            prefWidth: 140
                            id: "parentName"
                            renderer: TextRenderer {}
                        }
                        XTableColumn {
                            displayName: "Feature Name"
                            prefWidth: 140
                            id: "name"
                            renderer: TextRenderer {}
                        }
                        XTableColumn {
                            displayName: "Owner"
                            prefWidth: 100
                            id: "owner"
                            renderer: TextRenderer {}
                        }
                        for (iteration in model.iterations) {
                            XTableColumn {
                                displayName: iteration
                                prefWidth: 100
                                id: "iteration{indexof iteration + 1}"
                                renderer: TextRenderer {}
                            }
                        }
                        XTableColumn {
                            displayName: "Overflow"
                            prefWidth: 100
                            id: "overflow"
                            renderer: TextRenderer {}
                        }
                    ]
                }
            ]
        }
    }

}
