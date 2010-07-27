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

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.apropos.model.RallyModel;
import org.apropos.model.Story;
import org.apropos.model.StoryContainer;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.control.XTableView;
import org.jfxtras.scene.control.XTableColumn;
import org.jfxtras.scene.control.renderer.RowNumberRenderer;
import org.jfxtras.scene.control.renderer.TextRenderer;
import org.jfxtras.scene.paint.ColorUtil;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XLayoutInfo;
import org.jfxtras.scene.layout.XLayoutInfo.*;
import org.jfxtras.scene.layout.XVBox;
import org.jfxtras.util.SequenceUtil;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
public class StoryView extends XCustomNode {
    def model = RallyModel.instance;

    public var storyViews:StoryView[];

    public-init var narrowColumns = false;

    public var totalLimit:Double;

    public var limitByCount = false;

    public var overSubLimit = false;

    public-init var storyContainer:StoryContainer;

    public-read var filteredStories = bind model.filter(storyContainer.getVisibleStories());

    var filteredCount = bind sizeof filteredStories;

    var filteredSum = bind SequenceUtil.sum(for (story in filteredStories) {story.estimate});

    public-read def total = bind if (limitByCount) filteredCount else filteredSum;

    public-read def overLimit = bind totalLimit > 0 and total > totalLimit;

    public-read var maximized = false on replace {
        table.columns = createColumns();
    }

    var table:XTableView;

    function move(inAmount:Integer) {
        def amount = if (table.selectedRow + inAmount < 0) {
            -table.selectedRow;
        } else if (table.selectedRow + inAmount >= sizeof filteredStories) {
            sizeof filteredStories - 1 - table.selectedRow;
        } else {
            inAmount;
        }
        if (amount == 0) {
            return;
        }
        def away2 = filteredStories[table.selectedRow+amount+(if (amount < 0) -1 else 1)];
        def away1 = filteredStories[table.selectedRow+amount];
        def newRank = if (away2 == null) (if (amount < 0) away1.rank / 2 else away1.rank + 100) else {
            (away1.rank + away2.rank) / 2;
        }
        filteredStories[table.selectedRow].rank = newRank;
        storyContainer.rerank();
        table.selectedRow = table.selectedRow + amount;
        table.scrollToSelected();
    }

    function createColumns() {
        [
            if (narrowColumns and not maximized) [] else [
                XTableColumn {
                    displayName: "#"
                    prefWidth: 20
                    id: "rank"
                    renderer: RowNumberRenderer {}
                }
            ],
            if (not maximized) [] else [
                XTableColumn {
                    displayName: "ID"
                    prefWidth: 20
                    id: "id"
                    renderer: TextRenderer {}
                }
                XTableColumn {
                    displayName: "Rank"
                    prefWidth: 20
                    id: "rank"
                    renderer: TextRenderer {}
                }
            ],
            if (narrowColumns and not maximized) [] else [
                XTableColumn {
                    displayName: "Epic Name"
                    prefWidth: 80
                    id: "parentName"
                    renderer: TextRenderer {}
                }
            ],
            XTableColumn {
                displayName: "Feature Name"
                prefWidth: 90
                id: "name"
                renderer: TextRenderer {}
            }
            if (not maximized) [] else [
                XTableColumn {
                    displayName: "Description"
                    prefWidth: 180
                    id: "textDescription"
                    renderer: TextRenderer {}
                }
                XTableColumn {
                    displayName: "Owner"
                    prefWidth: 100
                    id: "ownerName"
                    renderer: TextRenderer {}
                }
            ],
            XTableColumn {
                displayName: "Est"
                prefWidth: 35
                id: "estimateDisplay"
                renderer: TextRenderer {}
            }
            if (narrowColumns and not maximized) [] else XTableColumn {
                displayName: "AT"
                prefWidth: 25
                id: "acceptanceTest"
                renderer: TextRenderer {}
            }
        ]
    }

    function previous() {
        storyContainer.moveBefore(filteredStories[table.selectedRow]);
    }

    function next() {
        storyContainer.moveAfter(filteredStories[table.selectedRow]);
    }

    override function create() {
        XVBox {
            onKeyTyped: function(e) {
                if (e.code == KeyCode.VK_LEFT) {
                    previous();
                } else if (e.code == KeyCode.VK_RIGHT) {
                    next();
                }
            }
            spacing: 8
            content: [
                XHBox {
                    var imageView:ImageView;
                    content: [
                        Label {
                            text: bind storyContainer.name
                            textFill: Color.WHITE
                        }
                        imageView = ImageView {
                            effect: bind if (imageView.hover) DropShadow {color: Color.WHITE} else null
                            image: Image {
                                url: "{__DIR__}maximize.png"
                            }
                            onMousePressed: function(e) {
                                maximized = not maximized;
// todo - bug with visibility in javafx 1.3
//                                for (view in storyViews) {
//                                    if (view != this) {
//                                        view.visible = not view.visible;
//                                    }
//                                }
                                for (view in storyViews) {
                                    if (view != this) {
                                        view.managed = not view.managed;
                                        if (not view.managed) {
                                            view.layoutX = 2000;
                                        }
                                    }
                                }
                            }
                            layoutInfo: XLayoutInfo {hgrow: ALWAYS, hpos: RIGHT}
                        }
                    ]
                }
                XHBox {
                    spacing: 5
                    var text:String;
                    var error = false;
                    def search = function() {
                        var match = -1;
                        for (story in filteredStories where indexof story > table.selectedRow) {
                            if (story.id.contains(text) or story.name.contains(text) or story.textDescription.contains(text)) {
                                match = indexof story;
                                break;
                            }
                        }
                        if (match == -1) for (story in filteredStories) {
                            if (story.id.contains(text) or story.name.contains(text) or story.textDescription.contains(text)) {
                                match = indexof story;
                                break;
                            }
                        }
                        if (match != -1) {
                            table.selectedRow = match;
                            table.scrollToSelected();
                            table.requestFocus();
                        } else {
                            error = true;
                        }
                    }
                    content: [
                        TextBox {
                            style: bind if (error) "background-fill: red; text-fill: white" else ""
                            text: bind text with inverse
                            action: search
                            onKeyPressed: function(e) {error = false}
                            onMousePressed: function(e) {error = false}
                        }
                        Button {
                            style: RallyModel.buttonSkin
                            text: "Search"
                            action: search
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
                    columns: createColumns()
                }
                XHBox {
                    spacing: 4
                    content: [
                        Button {
                            style: RallyModel.buttonSkin
                            graphic: ImageView {
                                image: Image {
                                    url: "{__DIR__}go-previous.png"
                                }
                            }
                            action: previous
                            disable: bind table.selectedRow == -1 or storyContainer.containerBefore == null
                            layoutInfo: XLayoutInfo {minWidth: 25, hshrink: SOMETIMES}
                        }
                        Button {
                            style: RallyModel.buttonSkin
                            graphic: ImageView {
                                image: Image {
                                    url: "{__DIR__}go-up.png"
                                }
                            }
                            onMouseClicked: function(e) {
                                if (e.altDown) {
                                    move(-100000);
                                } else if (e.controlDown) {
                                    move(-10);
                                }
                            }
                            action: function() {
                                move(-1);
                            }
                            disable: bind table.selectedRow == -1 or table.selectedRow == 0
                            layoutInfo: XLayoutInfo {minWidth: 25, hshrink: SOMETIMES}
                        }
                        Button {
                            style: RallyModel.buttonSkin
                            graphic: ImageView {
                                image: Image {
                                    url: "{__DIR__}go-down.png"
                                }
                            }
                            onMouseClicked: function(e) {
                                if (e.altDown) {
                                    move(100000);
                                } else if (e.controlDown) {
                                    move(10);
                                }
                            }
                            action: function() {
                                move(1);
                            }
                            disable: bind table.selectedRow == -1 or table.selectedRow == sizeof filteredStories - 1
                            layoutInfo: XLayoutInfo {minWidth: 25, hshrink: SOMETIMES}
                        }
                        Button {
                            style: RallyModel.buttonSkin
                            graphic: ImageView {
                                image: Image {
                                    url: "{__DIR__}go-next.png"
                                }
                            }
                            action: next
                            disable: bind table.selectedRow == -1 or storyContainer.containerAfter == null
                            layoutInfo: XLayoutInfo {minWidth: 25, hshrink: SOMETIMES}
                        }
                    ]
                    layoutInfo: XLayoutInfo {hpos: CENTER}
                }
                XVBox {
                    spacing: 3
                    content: [
                        Text {
                            content: bind "Count: {filteredCount}"
                            fill: bind if (not limitByCount) Color.WHITE else if (overLimit) ColorUtil.lighter(Color.RED, .3) else if (overSubLimit) Color.ORANGE else Color.WHITE
                            layoutInfo: XLayoutInfo {hpos: LEFT}
                        }
                        Text {
                            content: bind "Total: {model.convertEstimate(filteredSum)}"
                            fill: bind if (limitByCount) Color.WHITE else if (overLimit) ColorUtil.lighter(Color.RED, .3) else if (overSubLimit) Color.ORANGE else Color.WHITE
                            layoutInfo: XLayoutInfo {hpos: LEFT}
                        }
                        Text {
                            content: bind if (limitByCount) "Limit: {%.0f totalLimit}" else "Limit: {model.convertEstimate(totalLimit)}"
                            fill: bind if (totalLimit == 0) Color.TRANSPARENT else if (overLimit) ColorUtil.lighter(Color.RED, .3) else if (overSubLimit) Color.ORANGE else Color.WHITE
                            layoutInfo: XLayoutInfo {hpos: LEFT}
                        }
                    ]
                    layoutInfo: XLayoutInfo {hpos: LEFT}
                }
            ]
        }
    }

}
