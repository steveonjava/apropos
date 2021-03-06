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
import org.apropos.ui.AnalyzeModule;
import org.apropos.ui.RoadmapModule;
import org.apropos.ui.KanbanModule;
import org.apropos.ui.ScheduleModule;
import org.apropos.ui.PlanModule;
import javafx.scene.Node;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XLayoutInfo;
import org.jfxtras.scene.layout.XLayoutInfo.*;
import org.jfxtras.scene.layout.XStack;
import org.jfxtras.scene.layout.XVBox;
import org.jfxtras.util.XMap;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.Priority;
import javafx.geometry.HPos;
import javafx.scene.paint.Color;
import org.jfxtras.scene.shape.ResizableRectangle;
import org.jfxtras.scene.layout.XSpacer;

/**
 * @author Stephen Chin
 */
public class AproposUI extends XCustomNode {
    def model = RallyModel.instance;

    var selectedWorkspaceIndex:Integer = bind model.selectedWorkspaceIndex on replace {
        if (workspaceChoice.selectedIndex != selectedWorkspaceIndex) {
            workspaceChoice.select(selectedWorkspaceIndex);
        }
    };
    var workspaceChoice:RallyPicker = RallyPicker {
        placeholderText: bind model.defaultWorkspace._refObjectName
        pickerStyle: "transparent"
        rowWidth: 160
        rowHeight: 20
        items: bind for (workspace in model.workspaces) "{workspace._refObjectName}"
        onIndexChange: function(index) {
            model.selectedWorkspaceIndex = index;
        }
    };

    def toggleGroup = ToggleGroup {}
    def buttonBar = XStack {
        content: [
            XHBox {
                spacing: 5
                def buttonLabels = [
                    "Kanban",
                    "Roadmap",
                    "Plan",
                    "Analyze",
                    "Schedule"
                ]
                content: bind for (label in buttonLabels)
                    createMenuToggleButton(label, indexof label == 0);
                layoutInfo: XLayoutInfo {
                    vpos: VPos.BOTTOM
                    hpos: HPos.LEFT
                    hgrow: Priority.NEVER
                    vgrow: Priority.NEVER
                }
            }
        ]
        layoutInfo: XLayoutInfo {
            vpos: VPos.BOTTOM
        }
    }

    def titleBar = XHBox {
        vpos: TOP
        content: [
            XVBox {
                content: [
                    XHBox {
                        nodeVPos: VPos.TOP
                        spacing: 10
                        content: [
                            XVBox {
                                nodeHPos: HPos.LEFT
                                spacing: 0
                                content: [
                                    workspaceChoice,
                                    Label {
                                        styleClass: "transparent-large-top-text"
                                        text: bind model.mainProject._refObjectName
                                    }

                                ]
                            },
                            XSpacer {
                                width: 40
                            },
                            Label {
                                id: "app-header-title"
                                layoutInfo: XLayoutInfo {
                                    vpos: VPos.TOP
                                    hpos: HPos.LEFT
                                    hgrow: Priority.NEVER
                                    //vgrow: Priority.NEVER
                                    vgrow: Priority.ALWAYS
                                }
                            },
                            ImageView {
                                image: Image {
                                    url: "{__DIR__}images/preview-80x35.png";
                                }
                                layoutInfo: XLayoutInfo {vpos: TOP}
                            }
                        ]
                    },
                    buttonBar
                ]
                layoutInfo: XLayoutInfo {
                    hgrow: Priority.ALWAYS
                    vgrow: Priority.NEVER
                    margin: Insets {
                        top: 6
                        left: 6
                    }
                }
            }
            ImageView {
                image: Image {
                    url: "{__DIR__}images/sticky-graphic-header-clipped.png";
                }
                layoutInfo: XLayoutInfo {vpos: TOP}
            }
            ImageView {
                image: Image {
                    url: "{__DIR__}images/rally-logo-header.png";
                }
                layoutInfo: XLayoutInfo {vpos: TOP}
            }
        ]
    };

    def modules = XMap {
        entries: [
            XMap.Entry {key: "Kanban", value: KanbanModule {}}
            XMap.Entry {key: "Roadmap", value: RoadmapModule {}}
            XMap.Entry {key: "Plan", value: PlanModule {}}
            XMap.Entry {key: "Analyze", value: AnalyzeModule {}}
            XMap.Entry {key: "Schedule", value: ScheduleModule {}}
        ]
    }
    var activeModule:AbstractModulePage = bind modules.boundGet((toggleGroup.selectedToggle as ToggleButton).text) as AbstractModulePage on replace {
        activeModule.initPage();
    };

    def content:XStack = XStack {
        content: bind [
            ResizableRectangle {
                //TODO: Implement JavaFX CSS support in ResizableRectangle
                //styleClass: "page-content-background"
                fill: Color.web("#e0e0e0")
            },
            activeModule,
        ]
    }

    function createMenuToggleButton(text:String, selected:Boolean):ToggleButton {
        var tbRef:ToggleButton;
        tbRef = ToggleButton {
            text: text
            selected: selected
            // Disable the button if is selected so it can't be de-selected
            disable: bind tbRef.selected
            toggleGroup: toggleGroup
        }
    }


    override function create() {
        XStack {
            content: [
                XVBox {
                    spacing: 0
                    content: [titleBar, content]
                }
                // todo - it is kind of annoying, but progress indicators don't play nice with layouts...
                ProgressIndicator {
                    layoutY: 35
                    layoutX: bind scene.width - 44
                    visible: bind model.waiting > 0
                }
            ]
        }
    }
}
