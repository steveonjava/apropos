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

import java.math.BigDecimal;
import javafx.scene.control.Label;
import javafx.scene.control.TextBox;
import javafx.scene.shape.Rectangle;
import org.apropos.model.RallyModel;
import org.apropos.model.StoryContainer;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.control.XTableView;
import org.jfxtras.scene.control.XTableColumn;
import org.jfxtras.scene.control.renderer.RowNumberRenderer;
import org.jfxtras.scene.control.renderer.TextRenderer;
import org.jfxtras.util.SequenceUtil;
import javafx.scene.control.Tooltip;
import javafx.stage.Alert;
import org.apropos.model.KanbanStageManager;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import java.lang.String;
import org.apropos.model.Stage;
import org.apropos.model.Story;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XLayoutInfo;
import org.jfxtras.scene.layout.XVBox;
import org.jfxtras.scene.paint.ColorUtil;
import org.jfxtras.scene.shape.ResizableRectangle;
import org.jfxtras.scene.layout.XStack;

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

    //public-init var storyContainer:StoryContainer;
    public var storyContainer:StoryContainer;

    //public var storyContainerName:String; //TODO: Find a better way to dynamically update the name on the StoryView

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
        def newRank = if (away2 == null) (if (amount < 0) away1.rank.divide(new BigDecimal(2)) else away1.rank.add(new BigDecimal(100))) else {
            away1.rank.add(away2.rank).divide(new BigDecimal(2));
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
            ],
            if (narrowColumns and not maximized) [] else [
                XTableColumn {
                    displayName: "Theme"
                    prefWidth: 80
                    id: "parentName"
                    renderer: TextRenderer {}
                }
            ],
            XTableColumn {
                displayName: "Feature"
                prefWidth: 92
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
                prefWidth: 42
                id: "estimateDisplay"
                renderer: TextRenderer {}
            }
        ]
    }

    function previous() {
        // Display an alert if this operation is not allowed
        if (storyContainer instanceof Stage) {
            if (not KanbanStageManager.canDemoteFeature(storyContainer.name)) {
                Alert.inform(KanbanStageManager.getDemoteFeatureMsg(storyContainer.name));
                return;
            }
        }

        storyContainer.moveBefore(filteredStories[table.selectedRow]);
        if ((table.selectedRow >= sizeof table.rows) and
            (sizeof table.rows > 0)) {
          table.selectedRow = sizeof table.rows - 1;
        }
        // Force table to update [DE8910]
        // TODO: Identify a less heavy-handed approach
        if (sizeof table.rows >= 2) {
            if (table.selectedRow > 0) {
                move(-1);
                move(1);
            }
            else {
                move(1);
                move(-1);
            }

        }
    }

    function next() {
        // Display an alert if this operation is not allowed
        if (storyContainer instanceof Stage) {
            if (not KanbanStageManager.canPromoteFeature(storyContainer.name)) {
                Alert.inform(KanbanStageManager.getPromoteFeatureMsg(storyContainer.name));
                return;
            }
        }
        //else if (storyContainer instanceof Release)

        storyContainer.moveAfter(filteredStories[table.selectedRow]);
        if ((table.selectedRow >= sizeof table.rows) and
            (sizeof table.rows > 0)) {
          table.selectedRow = sizeof table.rows - 1;
        }
        // Force table to update [DE8910]
        // TODO: Identify a less heavy-handed approach
        if (sizeof table.rows >= 2) {
            if (table.selectedRow > 0) {
                move(-1);
                move(1);
            }
            else {
                move(1);
                move(-1);
            }

        }
    }

    override function create() {
        var viewDetail:XVBox;
        var viewSummary:XHBox;
        XVBox {
            spacing: 8
            content: [
                XStack {
                    nodeHPos: HPos.LEFT
                    content: [
                        ResizableRectangle {
                            //TODO: Implement JavaFX CSS support in ResizableRectangle
                            //styleClass: "story-view-box"
                            fill: Color.web("#ffffff")
                            stroke: Color.web("#c6c6c6")
                            layoutInfo: XLayoutInfo {
                                width: 0
                                height: 0
                            }
                        },
                        viewDetail = XVBox {
                            onKeyTyped: function(e) {
                                if (e.code == KeyCode.VK_LEFT) {
                                    previous();
                                } else if (e.code == KeyCode.VK_RIGHT) {
                                    next();
                                }
                            }
                            content: [
                                XStack {
                                    nodeHPos: HPos.LEFT
                                    content: [
                                        ResizableRectangle {
                                            //TODO: Implement JavaFX CSS support in ResizableRectangle
                                            //styleClass: "story-view-header"
                                            fill: Color.web("#b5d8eb")
                                            layoutInfo: XLayoutInfo {
                                                width: 0
                                                height: 0
                                            }
                                        },
                                        XHBox {
                                            def maximizeImage:Image = Image {
                                                url: "{__DIR__}images/maximize.png"
                                            };
                                            def minimizeImage:Image = Image {
                                                url: "{__DIR__}images/minimize.jpg"
                                            };
                                            var imageView:ImageView;
                                            content: [
                                                Label {
                                                    styleClass: "story-view-header-title"
                                                    text: bind storyContainer.name
                                                    layoutInfo: XLayoutInfo {
                                                        margin: Insets {top: 5, right: 5, bottom: 5, left: 5}
                                                    }
                                                }
                                                //TODO: Change to ToggleButton or Button?
                                                imageView = ImageView {
                                                    //effect: bind if (imageView.hover) DropShadow {color: Color.WHITE} else null
                                                    image: bind if (maximized) minimizeImage
                                                                else maximizeImage
                                                    onMousePressed: function(e) {
                                                        model.animateLayouts = true;
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
                                                    layoutInfo: XLayoutInfo {
                                                        hgrow: Priority.ALWAYS
                                                        hpos: HPos.RIGHT
                                                        margin: Insets {top: 5, right: 5, bottom: 5, left: 5}
                                                    }
                                                }
                                            ]
                                        }
                                    ]
                                },
                                XHBox {
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
                                            //TODO: Use a styleClass instead
                                            style: bind if (error) "background-fill: red; text-fill: white" else ""
                                            text: bind text with inverse
                                            action: search
                                            onKeyPressed: function(e) {error = false}
                                            onMousePressed: function(e) {error = false}
                                            layoutInfo: XLayoutInfo {
                                                margin: Insets {top: 3, right: 3, bottom: 3, left: 3}
                                            }
                                        }
                                        Button {
                                            styleClass: "image-button"
                                            graphic: ImageView {
                                                image: Image {
                                                    url: "{__DIR__}images/search.png"
                                                }
                                            }
                                            action: search
                                            layoutInfo: XLayoutInfo {
                                                margin: Insets {top: 3, right: 3, bottom: 3, left: 0}
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
                                    columns: createColumns()
                                }
                            ]
                        }
                    ]
                },
                XVBox {
                    spacing: 4
                    content: [
                        XHBox {
                            var leftButton:Button;
                            var rightButton:Button;
                            spacing: 4
                            content: [
                                leftButton = Button {
                                    styleClass: "image-button"
                                    graphic: ImageView {
                                        image: Image {
                                            url: "{__DIR__}images/left.jpg"
                                        }
                                    }
                                    action: previous
                                    disable: bind (table.selectedRow == -1) or
                                                  (sizeof filteredStories == 0) or
                                                  (storyContainer.containerBefore == null)
                                    tooltip: bind
                                        if ((KanbanStageManager.getDemoteFeatureMsg(storyContainer.name) != "") and
                                            (storyContainer instanceof Stage))
                                            Tooltip {
                                                text: bind KanbanStageManager.getDemoteFeatureMsg(storyContainer.name)
                                            }
                                        else null
                                    opacity: bind if (not KanbanStageManager.canDemoteFeature(storyContainer.name) and
                                                      not leftButton.disable) 0.4
                                                      else 1.0
                                }
                                Button {
                                    styleClass: "image-button"
                                    graphic: ImageView {
                                        image: Image {
                                            url: "{__DIR__}images/up.jpg"
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
                                }
                                Button {
                                    styleClass: "image-button"
                                    graphic: ImageView {
                                        image: Image {
                                            url: "{__DIR__}images/down.jpg"
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
                                    disable: bind (table.selectedRow == -1) or
                                                  (sizeof filteredStories == 0) or
                                                  table.selectedRow == sizeof filteredStories - 1
                                }
                                rightButton = Button {
                                    styleClass: "image-button"
                                    graphic: ImageView {
                                        image: Image {
                                            url: "{__DIR__}images/right.jpg"
                                        }
                                    }
                                    action: next
                                    disable: bind (table.selectedRow == -1) or
                                                  (sizeof filteredStories == 0) or
                                                  (storyContainer.containerAfter == null)
                                    tooltip: bind
                                        if ((KanbanStageManager.getPromoteFeatureMsg(storyContainer.name) != "") and
                                            (storyContainer instanceof Stage))
                                            Tooltip {
                                                text: bind KanbanStageManager.getPromoteFeatureMsg(storyContainer.name)
                                            }
                                        else null
                                    opacity: bind if (not KanbanStageManager.canPromoteFeature(storyContainer.name) and
                                                      not rightButton.disable) 0.4
                                                  else 1.0
                                }
                            ]
                            //TODO: Center horizonally in the width of the table above it
                        }
                        //TODO: Use XGrid, and/or some way less verbose technique
                        viewSummary = XHBox {
                             content: [
                                Rectangle {
                                    managed: false
                                    styleClass: "story-view-summary-box"
                                    width: bind viewSummary.width
                                    height: bind viewSummary.height
                                }
                                XVBox {
                                    content: [
                                        Rectangle {
                                            managed: false
                                            layoutX: 3
                                            layoutY: 3
                                            styleClass: "story-view-summary-header"
                                            width: bind viewSummary.width / 3 - 6
                                            height: bind viewSummary.height / 2 - 2
                                        }
                                        Label {
                                            styleClass: "story-view-summary-text"
                                            text: "Count"
                                            layoutInfo: XLayoutInfo {
                                                margin: Insets {top: 5, right: 5, bottom: 5, left: 5}
                                            }
                                        }
                                        Label {
                                            styleClass: "story-view-summary-text"
                                            text: bind "{filteredCount}"
                                            textFill: bind if (not limitByCount) Color.BLACK else if (overLimit) ColorUtil.lighter(Color.RED, .3) else if (overSubLimit) Color.ORANGE else Color.BLACK
                                            layoutInfo: XLayoutInfo {
                                                margin: Insets {top: 5, right: 5, bottom: 5, left: 5}
                                            }
                                        }
                                    ]
                                    layoutInfo: XLayoutInfo {
                                        hgrow: Priority.SOMETIMES
                                    }
                                },
                                XVBox {
                                    content: [
                                        Rectangle {
                                            managed: false
                                            layoutX: 3
                                            layoutY: 3
                                            styleClass: "story-view-summary-header"
                                            width: bind viewSummary.width / 3 - 6
                                            height: bind viewSummary.height / 2 - 2
                                        }
                                        Label {
                                            styleClass: "story-view-summary-text"
                                            text: "Total"
                                            layoutInfo: XLayoutInfo {
                                                margin: Insets {top: 5, right: 5, bottom: 5, left: 5}
                                            }
                                         }
                                        Label {
                                            styleClass: "story-view-summary-text"
                                            text: bind "{model.convertEstimate(filteredSum)}"
                                            textFill: bind if (limitByCount) Color.BLACK else if (overLimit) ColorUtil.lighter(Color.RED, .3) else if (overSubLimit) Color.ORANGE else Color.BLACK
                                            layoutInfo: XLayoutInfo {
                                                margin: Insets {top: 5, right: 5, bottom: 5, left: 5}
                                            }
                                       }
                                    ]
                                    layoutInfo: XLayoutInfo {
                                        hgrow: Priority.SOMETIMES
                                    }
                                },
                                XVBox {
                                    content: [
                                        Rectangle {
                                            managed: false
                                            layoutX: 3
                                            layoutY: 3
                                            styleClass: "story-view-summary-header"
                                            width: bind viewSummary.width / 3 - 6
                                            height: bind viewSummary.height / 2 - 2
                                        }
                                        Label {
                                            styleClass: "story-view-summary-text"
                                            text: "Limit"
                                            layoutInfo: XLayoutInfo {
                                                margin: Insets {top: 5, right: 5, bottom: 5, left: 5}
                                            }
                                        }
                                        Label {
                                            styleClass: "story-view-summary-text"
                                            text: bind 
                                                if (totalLimit == 0) "None"
                                                else if (limitByCount) "{%.0f totalLimit}" else "{model.convertEstimate(totalLimit)}"
                                            textFill: bind if (overLimit) ColorUtil.lighter(Color.RED, .3) else if (overSubLimit) Color.ORANGE else Color.BLACK
                                            layoutInfo: XLayoutInfo {
                                                margin: Insets {top: 5, right: 5, bottom: 5, left: 5}
                                            }
                                        }
                                    ]
                                    layoutInfo: XLayoutInfo {
                                        hgrow: Priority.SOMETIMES
                                    }
                               }
                            ]
                        }
                    ]
                }
            ]
        }
    }
}
