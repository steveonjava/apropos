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
package org.apropos;

import javafx.stage.Stage;
import javafx.scene.image.Image;
import org.apropos.model.RallyModel;
import org.apropos.ui.AproposUI;
import org.apropos.ui.LoginScreen;
import org.jfxtras.scene.XScene;
import org.jfxtras.scene.layout.XStack;
import javafx.scene.shape.Rectangle;
import javafx.scene.Cursor;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
def model = RallyModel.instance;

var scene:XScene;

Stage {
    title: "Roadmap Planner"
    icons: [
        Image {url: "{__DIR__}ui/images/rally-reg-128.png"},
        Image {url: "{__DIR__}ui/images/rally-reg-64.png"},
        Image {url: "{__DIR__}ui/images/rally-reg-32.png"},
    ]
    scene: scene = XScene {
        // 1366 x 768 for the 26" monitor and either 1366 x 768 or 1920 x 1080 for the 42".
        // 1280 x 800 for MacBook Air (use 1280 x 700)
        // 1024 x 768 for a projector (use 1000 x 700)
        width: 1000
        height: 700
        stylesheets: ["/org/jfxtras/scene/control/skin/jfxtras.css", "{__DIR__}rally-style.css"]
        cursor: bind if (model.processingLogin) Cursor.WAIT else Cursor.DEFAULT
        content: XStack {
            styleClass: "background"
            content: bind [
                Rectangle {
                    styleClass: "background"
                    width: bind scene.width
                    height: bind scene.height
                },
                if (not model.loggedIn) LoginScreen {} else AproposUI {}
            ]
        }
    }
}
println("Current runtime environment:");
println("- javafx.version:{FX.getProperty("javafx.version")}");
println("- javafx.java.version:{FX.getProperty("javafx.java.version")}");

