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
import org.apropos.ui.ScopeModule;
import org.apropos.ui.PortfolioModule;
import org.apropos.ui.RoadmapModule;
import org.apropos.ui.ResourceModule;
import javafx.scene.Node;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;

/**
 * @author Stephen Chin
 */
public class AproposUI extends XCustomNode {
    def model = RallyModel.instance;

    def toggleGroup = ToggleGroup {}
    def buttonBar = XStack {
        content: [
            XHBox {
                spacing: 20
                def buttonLabels = [
                    "Portfolio",
                    "Scope",
                    "Resource",
                    "Analyze",
                    "Roadmap"
                ]
                content: bind for (label in buttonLabels)
                    createMenuToggleButton(label, indexof label == 0);
                layoutInfo: XLayoutInfo {
                    vpos: VPos.BOTTOM
                    hpos: HPos.LEFT
                    hgrow: Priority.NEVER
                    vgrow: Priority.NEVER
                }
                //layoutInfo: XLayoutInfo {hpos: LEFT, margin: insets(4, 16)}
            }
        ]
        layoutInfo: XLayoutInfo {
            vpos: VPos.BOTTOM
            //hgrow: Priority.ALWAYS
        }
    }

    def titleBar = XHBox {
        vpos: TOP
        content: [
            XVBox {
                content: [
                    Label {
                        id: "app-header-title"
                        layoutInfo: XLayoutInfo {
                            vpos: VPos.TOP
                            hpos: HPos.LEFT
                            hgrow: Priority.NEVER
                            vgrow: Priority.NEVER
                        }
                    },
                    buttonBar
                ]
                layoutInfo: XLayoutInfo {
                    //vpos: VPos.TOP
                    hgrow: Priority.ALWAYS
                    margin: Insets {
                        top: 10
                        left: 10
                    }
                }
            },
            ImageView {
                image: Image {
                    url: "{__DIR__}images/sticky-graphic-header-clipped.png";
                }
                layoutInfo: XLayoutInfo {vpos: TOP}
            },
            ImageView {
                image: Image {
                    url: "{__DIR__}images/rally-logo-header.png";
                }
                layoutInfo: XLayoutInfo {vpos: TOP}
            },
        ]
    };

    def pageToolBar = PageToolBar {
        leftNodes: Button {text: "Hello"}
        rightNodes: Button {text: "Hello"}
    };


    def modules = XMap {
        entries: [
            XMap.Entry {key: "Portfolio", value: PortfolioModule {}}
            XMap.Entry {key: "Scope", value: ScopeModule {}}
            XMap.Entry {key: "Resource", value: ResourceModule {}}
            XMap.Entry {key: "Analyze", value: AnalyzeModule {}}
            XMap.Entry {key: "Roadmap", value: RoadmapModule {}}
        ]
    }
    var activeModule = bind modules.boundGet((toggleGroup.selectedToggle as ToggleButton).text) as Node;

    def content:XStack = XStack {
        content: bind [
          Rectangle {
            width: bind content.width
            height: bind content.height
            styleClass: "page-content-background"
          },
          activeModule
        ]
    }

    function createMenuToggleButton(text:String, selected:Boolean):ToggleButton {
        var tbRef:ToggleButton;
        tbRef = ToggleButton {
            text: text
            selected: selected
            // Disable the button if is selected so it can't be de-selected
            //TODO: Style this button so that it is more legible in its disabled state
            disable: bind tbRef.selected
            //TODO: Move font size to style sheet
            font: Font.font("Eras Demi ITC", FontWeight.REGULAR, 14)
            toggleGroup: toggleGroup
        }
    }


    override function create() {
        XStack {
            content: [
                XVBox {
                    content: [
                        titleBar,
                        //buttonBar,
                        //pageToolBar,
                        content,
                        //PageFooter {}
                    ]
                }
                // todo - it is kind of annoying, but progress indicators don't play nice with layouts...
                ProgressIndicator {
                    layoutY: 84
                    layoutX: bind scene.width - 44
                    visible: bind model.waiting > 0
                }
            ]
        }
    }
}
