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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.TextBoundsType;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XLayoutInfo;
import org.jfxtras.scene.layout.XLayoutInfo.*;
import org.jfxtras.scene.layout.XStack;
import org.jfxtras.scene.layout.XVBox;
import org.jfxtras.scene.shape.ResizableRectangle;
import org.jfxtras.util.XMap;

/**
 * @author Stephen Chin
 */
public class AproposUI extends XCustomNode {
    def model = RallyModel.instance;

    def titleBar = XHBox {
        spacing: 20
        content: [
            XVBox {
                content: [
                    Text {
                        boundsType: TextBoundsType.VISUAL
                        content: "APROPOS"
                        font: Font.font("Eras Demi ITC", FontWeight.REGULAR, 46)
                    }
                    Text {
                        boundsType: TextBoundsType.VISUAL
                        content: "Agile Project Portfolio Scheduler"
                        font: Font {
                            name: "Eras Demi ITC"
                            embolden: true
                            letterSpacing: -20
                            size: 14
                        }
                    }
                ]
                layoutInfo: XLayoutInfo {vpos: BOTTOM}
            }
            ImageView {
                image: bind if (model.approval) {
                    Image {url: "{__DIR__}approval.png"};
                } else {
                    Image {url: "{__DIR__}ken.png"};
                }
                onMouseClicked: function(e) {
                    model.approval = not model.approval;
                }
            }
            CheckBox {
                text: "Cost As Dollars"
                selected: bind model.showInDollars with inverse
                layoutInfo: XLayoutInfo {hpos: RIGHT, hgrow: ALWAYS}
            }
            Button {
                text: "Refresh"
                action: model.refresh
            }
        ]
        layoutInfo: XLayoutInfo {margin: insets(16, 16, 0, 16)}
    }

    def divider = ResizableRectangle {layoutInfo: XLayoutInfo {height: 3, vgrow: NEVER}, fill: Color.BLACK}

    def backgroundGradient = LinearGradient {
        proportional: false
        endX: 0
        endY: 15
        stops: [
            Stop {offset: 0, color: Color.rgb(200, 200, 200)}
            Stop {offset: 1, color: Color.rgb(41, 41, 41)}
        ]
    }

    def toggleGroup = ToggleGroup {}
    def darkTBStyle = "fill: BLACK;"
        "focusFill: DARKGRAY;"
        "borderFill: BLACK;"
        "textFill: WHITE;"
        "shadowFill: BLACK;"
        "fontSize: 14pt;";

    def buttonBar = XStack {
        content: [
            ResizableRectangle {
                fill: backgroundGradient
                layoutInfo: XLayoutInfo {height: 35, vgrow: NEVER}
            }
            XHBox {
                spacing: 20
                content: bind [
                    ToggleButton {
                        style: darkTBStyle
                        text: "Portfolio"
                        font: Font.font("Eras Demi ITC", FontWeight.REGULAR, 14)
                        toggleGroup: toggleGroup
                        selected: true
                    }
                    ToggleButton {
                        style: darkTBStyle
                        text: "Scope"
                        font: Font.font("Eras Demi ITC", FontWeight.REGULAR, 14)
                        toggleGroup: toggleGroup
                    }
                    ToggleButton {
                        style: darkTBStyle
                        text: "Resource"
                        font: Font.font("Eras Demi ITC", FontWeight.REGULAR, 14)
                        toggleGroup: toggleGroup
                    }
                    ToggleButton {
                        style: darkTBStyle
                        text: "Analyze"
                        font: Font.font("Eras Demi ITC", FontWeight.REGULAR, 14)
                        toggleGroup: toggleGroup
                    }
                    ToggleButton {
                        style: darkTBStyle
                        text: "Roadmap"
                        font: Font.font("Eras Demi ITC", FontWeight.REGULAR, 14)
                        toggleGroup: toggleGroup
                    }
                ]
                layoutInfo: XLayoutInfo {hpos: LEFT, margin: insets(4, 16)}
            }
        ]
    }

    def modules = XMap {
        entries: [
            XMap.Entry {key: "Portfolio", value: PortfolioModule {layoutInfo: XLayoutInfo {margin: insets(16)}}}
            XMap.Entry {key: "Scope", value: ScopeModule {layoutInfo: XLayoutInfo {margin: insets(16)}}}
            XMap.Entry {key: "Resource", value: ResourceModule {layoutInfo: XLayoutInfo {margin: insets(16)}}}
            XMap.Entry {key: "Analyze", value: AnalyzeModule {layoutInfo: XLayoutInfo {margin: insets(16)}}}
            XMap.Entry {key: "Roadmap", value: RoadmapModule {layoutInfo: XLayoutInfo {margin: insets(16)}}}
        ]
    }
    var activeModule = bind modules.boundGet((toggleGroup.selectedToggle as ToggleButton).text) as Node;

    def content = XStack {
        content: bind [
            ResizableRectangle {
                fill: Color.rgb(41, 41, 41)
            }
            activeModule
        ]
    }

    override function create() {
        XStack {
            content: [
                XVBox {
                    content: [
                        titleBar,
                        divider,
                        buttonBar,
                        content
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
