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
import org.jfxtras.scene.layout.XStack;
import org.jfxtras.scene.shape.ResizableRectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.geometry.HPos;
import javafx.util.Math;

/**
 * @author Jim Weaver
 * TODO: Provide the ability to use a style sheet for appearance.
 */
public class ComplianceBarNode extends XCustomNode {

    public var numerator:Number;

    public var denominator:Number;

    def percent = bind
        if (denominator != 0) numerator / denominator
        else 0;

    def rallyYellow = Color.web("#fbde98");
    def rallyGreen = Color.web("#b2e3b6");
    def rallyRed = Color.web("#fcb5b1");
    def background = Color.web("#f8f8f8");

    init {
        children = XStack {
            content: [
                XStack {
                    content: [
                        Rectangle {
                            width: bind width
                            height: bind height
                            fill: background
                        },
                        Rectangle {
                            fill: bind
                                if (percent <= 0.25) rallyYellow
                                else if (percent > 1.0) rallyRed
                                else rallyGreen
                            width: bind Math.min(1.0, percent) * width
                            height: bind height
                        },
                    ]
                    nodeHPos: HPos.LEFT
                },
                Label {
                    text: bind "{(percent * 100) as Integer}%"
                }
            ]
        }
    }
}
