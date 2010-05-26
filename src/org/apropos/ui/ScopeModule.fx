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

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import org.apropos.model.RallyModel;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.control.XPicker;
import org.jfxtras.scene.layout.XHBox;
import org.jfxtras.scene.layout.XGrid;
import org.jfxtras.scene.layout.XGridLayoutInfo.*;

/**
 * @author Stephen Chin
 */
public class ScopeModule extends XCustomNode {
    def model = RallyModel.instance;
    package var storyViews:StoryView[] = for (release in model.releases) StoryView {
        storyViews: bind storyViews;
        storyContainer: release
    }

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
        XGrid {
            animate: true
            hgap: 10
            rows: bind [
                row(XHBox {
                    content: [
                        Label {
                            text: "Investment Filter:"
                            textFill: Color.WHITE
                        }
                        picker
                    ]
                }),
                row(storyViews[s|s.visible])
            ]
        }
    }
}
