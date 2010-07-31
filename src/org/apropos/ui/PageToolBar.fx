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
import org.jfxtras.scene.layout.XHBox;
import javafx.scene.Node;
import javafx.geometry.Insets;
import org.jfxtras.scene.layout.XLayoutInfo;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Priority;

/**
 * @author Jim Weaver
 */
public class PageToolBar extends XCustomNode {

    public-init var leftNodes: Node[];
    public-init var rightNodes: Node[];

    override function getVFill() {false}
    
    init {
        var container: XHBox = XHBox {
            spacing: 8
            content: [
                Rectangle {
                    managed: false
                    width: bind container.width
                    height: bind container.height
                    styleClass: "page-toolbar"
                }
                XHBox {
                    spacing: 8 //TODO: Put in style sheet
                    content: leftNodes
                    layoutInfo: XLayoutInfo {
                        hgrow: Priority.ALWAYS
                        margin: Insets { //TODO: Put in style sheet
                            top: 10
                            bottom: 10
                            left: 10
                            right: 10
                        }
                    }
                },
                XHBox {
                    spacing: 8 //TODO: Put in style sheet
                    content: rightNodes
                    layoutInfo: XLayoutInfo {
                        margin: Insets { //TODO: Put in style sheet
                            top: 10
                            bottom: 10
                            left: 10
                            right: 10
                        }
                    }
                }
            ]
        };
        children = container;
    }

}
