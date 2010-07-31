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

import org.apropos.model.Story;
import org.jfxtras.scene.control.XTableColumn;
import org.jfxtras.scene.control.XTableView;
import org.jfxtras.scene.control.renderer.RowNumberRenderer;
import org.jfxtras.scene.control.renderer.TextRenderer;

/**
 * @author Stephen Chin
 */
public class RoadmapModule extends AbstractModulePage {

    var stories:Story[] = bind model.currentRelease.stories;

    var filteredStories = bind model.filter(model.currentRelease.stories);

    def allocationFilter = Filter {
        name: "Investment Allocation"
        list: bind model.allocationNames
        selectedIndex: bind model.selectedAllocationIndex with inverse
    }

    def ownerFilter = Filter {
        name: "Owner"
        list: bind for (o in model.owners) o.getDisplayName()
        selectedIndex: bind model.selectedOwnerIndex with inverse
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
                prefWidth: 140
                id: "parentName"
                renderer: TextRenderer {}
            }
            XTableColumn {
                displayName: "Feature"
                prefWidth: 140
                id: "name"
                renderer: TextRenderer {}
            }
            XTableColumn {
                displayName: "Owner"
                prefWidth: 100
                id: "ownerDisplayName"
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


    init {
        pageToolBar = PageToolBar {
            leftNodes: [
                allocationFilter,
                ownerFilter
            ]
            rightNodes: CostSelectionNode {}
        };
        pageContent = table;
    }
}
