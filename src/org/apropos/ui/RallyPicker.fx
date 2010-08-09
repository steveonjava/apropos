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

import org.jfxtras.scene.XCustomNode;
import javafx.scene.paint.Color;
import org.jfxtras.scene.layout.XVBox;
import org.jfxtras.scene.layout.XStack;
import javafx.scene.control.Label;
import javafx.geometry.HPos;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import org.jfxtras.scene.layout.XLayoutInfo;
import javafx.scene.input.MouseEvent;
import org.jfxtras.scene.layout.XHBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.geometry.VPos;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.scene.Group;
import org.jfxtras.stage.XStage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

/**
 * @author Jim Weaver
 * This was created to have the Rally dropdown appearance and behavior, after
 * trying to do the same thing by styling existing pickers (like XPicker).
 * TODO: Provide the ability to use a style sheet for appearance.
 * TODO: Leverage more layout capabilities, and less positioning via bind
 * TODO: Implement/fix key events (e.g. switching values with up and down arrows)
 */
public class RallyPicker extends XCustomNode {

//    def model = RallyModel.instance;
    var itemStacks:XStack[];


    public var items:String[] on replace {
            itemStacks = for (item in items) {
                XStack {
                    var rectRef:Rectangle;
                    nodeHPos: HPos.LEFT
                    content: [
                        rectRef = Rectangle {
                            fill: bind if ((rectRef.hover) or
                                           (indexof item == selectedIndex) and
                                           (not dropdownList.hover)) rallyBlue else rallyLightBlue
                            width: bind rowWidth
                            height: bind rowHeight
//                            width: 160
//                            height: 20
                        },
                        Label {
                            text: bind item
                            layoutInfo: XLayoutInfo {
                                margin: Insets {left: 6}
                            }
                        }
                    ]
                    onMouseReleased: function(me:MouseEvent) {
                        selectedIndex = indexof item;
                        showList = false;
                    }
                }

            }
    };

    public var selectedIndex:Integer = 0 on replace {
        onIndexChange(selectedIndex);
    };

    public var rowWidth:Number = 120;
    public var rowHeight:Number = 20;

    public var onIndexChange:function(index:Integer):Void;

    public function select(index:Integer):Void {
        selectedIndex = index;
    }

    var topRectRef:Rectangle;

    var showList:Boolean;

    def rallyWhite = Color.web("#ffffff");
    def rallyLightBlue = Color.web("#eff8fb");
    def rallyBlue = Color.web("#b5d8eb");
    def rallyOutline = Color.web("#c6c6c6");

    def dropdownList:XVBox = XVBox {
        //visible: bind showList
        effect: DropShadow {offsetY: 3}
        spacing: 0
        content: bind itemStacks
        onMouseExited: function(me:MouseEvent) {
            showList = false;
        }

    }

    package var pickerDropDown:XStage = XStage {
        alwaysOnTop: true
        isPopupStage: true
        visible: bind showList
        style: StageStyle.TRANSPARENT
        x: bind scene.stage.x + scene.x + localToScene(layoutBounds).minX - 3 + boundsInParent.minX
        y: bind scene.stage.y + scene.y + localToScene(layoutBounds).maxY + boundsInParent.minY
        width: bind dropdownList.boundsInParent.width + 6
        height: bind dropdownList.boundsInParent.height + 3
        scene: Scene {
            fill: Color.TRANSPARENT
            content: Group {
                layoutX: 3
                content: dropdownList
            }
        }
    };

    init {
        children =
            XStack {
                focusTraversable: true
                nodeHPos: HPos.LEFT
                nodeVPos: VPos.CENTER
                content: [
                    topRectRef = Rectangle {
                        width: bind rowWidth
                        height: bind rowHeight
                        fill: rallyWhite
                        stroke: rallyOutline
                    },
                    Group {
                        content: [
                            Label {
                                text: bind items[selectedIndex]
                            },
                            ImageView {
                                // TODO: At least base this on image size,
                                //       but better to leverage layouts
                                layoutX: bind rowWidth - 22
                                image: Image {
                                    url: "{__DIR__}images/down.jpg"
                                }
                            }
                        ]
                        layoutInfo: XLayoutInfo {
                            margin: Insets {top: 2 left: 6}
                        }
                    },
                ]
                onMouseReleased: function(me:MouseEvent) {
                    requestFocus();
                    showList = not showList;
                }
                onMouseExited: function(me:MouseEvent) {
                    def wait = Timeline {
                        keyFrames: KeyFrame {
                            time: 1000ms
                            action: function() {
                                if (not dropdownList.hover) {
                                    showList = false;
                                }
                            }
                        }
                    };
                    wait.playFromStart();
                }
                onKeyPressed: function(ke:KeyEvent) {
                    if (ke.code == KeyCode.VK_DOWN) {
                        if (selectedIndex < sizeof items - 1) {
                            selectedIndex++;
                        }
                    }
                    else if (ke.code == KeyCode.VK_UP) {
                        if (selectedIndex > 0) {
                            selectedIndex--;
                        }
                    }
                    else if (ke.code == KeyCode.VK_ENTER) {
                        showList = not showList;
                    }


                }
            }
    }
}
