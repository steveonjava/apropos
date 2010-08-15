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
package org.apropos.model;

import javafx.io.http.HttpRequest;
import javafx.data.pull.Event;
import javafx.data.pull.PullParser;
import java.io.InputStream;
import javafx.io.http.HttpHeader;

/**
 * Mainly provides the ability to retrieve valid values for a given custom
 * field in the Rally workspace.
 * @author Jim Weaver
 */
public class CustomFieldUtil {
    package var model = RallyModel.instance;

    postinit {
        retrieveValidValues();
    }

    public-init var customFieldName:String on replace {
        var lowerCaseName = customFieldName.toLowerCase();
        url = "{RallyModel.server}slm/webservice/current/defect/{lowerCaseName}/allowedvalues.js"
    }

    public-init var username:String;
    public-init var password:String;

    //public-read var done:Boolean;

    var url:String;
    var httpRequest:HttpRequest;
    public var validValues:String[];

    public function retrieveValidValues():Void {
        createHttpRequest();
    }

    function parseResponse(is:InputStream):Void {
        delete validValues;
        try {
            PullParser {
                input: is
                documentType: PullParser.JSON;
                onEvent: function(e:Event) {
                    if (e.type == PullParser.END_VALUE) {
                        if (e.name != "null") {
                            insert e.text into validValues;
                        }
                    }
                }
            }.parse();
        }
        finally {
            is.close();
        }
    }

    function createHttpRequest():Void {
        httpRequest = HttpRequest {
            headers: if (username != null) {
                HttpHeader.basicAuth(username, password);
            } else { null }
            location: url
            method: HttpRequest.GET
            onException: function(e) {
                println("In HttpRequest#onException, stackTrace is:");
                e.printStackTrace();
            }
            onInput: parseResponse
            onDone: function() {
                //TODO: Reconsider best way of doing this.  Former way didn't work on Mac w/Java 1.5
                if (customFieldName == "RoadmapKanbanState") {
                    model.roadmapKanbanStatesLoaded = true;
                }
                else if (customFieldName == "RoadmapRelease") {
                    model.roadmapReleasesLoaded = true;
                }
            }
            onError: function(is:InputStream) {
                println("In HttpRequest#onException, InputStream is:{is}");
            }
        };
        httpRequest.start();
    }
}
