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

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.LayoutInfo;
import org.apropos.model.RallyModel;
import org.jfxtras.scene.XCustomNode;
import org.jfxtras.scene.control.XPane;
import org.jfxtras.scene.form.XForm;
import org.jfxtras.scene.layout.XStack;
import org.jfxtras.scene.layout.XVBox;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
def model = RallyModel.instance;

public class LoginScreen extends XCustomNode {
    override function create() {
        XStack {
            content: [
                XPane {
                    title: "Login"
                    contentNode: XVBox {
                        spacing: 8
                        content: [
                            XForm {
                                model: model.login
                                action: model.doLogin
                                layoutInfo: LayoutInfo {width: 250, height: 60}
                            }
                            Button {
                                text: "Login"
                                action: model.doLogin
                                layoutInfo: LayoutInfo {hpos: HPos.RIGHT}
                            }
                        ]
                    }
                }
                PageFooter {layoutInfo: LayoutInfo {vpos: VPos.BOTTOM}}
            ]
        }
    }
    // Show wait cursor only in Login page, as the app has a progress indicator
    override var cursor = bind if (model.processingLogin) Cursor.WAIT
                                else Cursor.DEFAULT
}
