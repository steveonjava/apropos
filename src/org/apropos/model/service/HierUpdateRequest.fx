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
package org.apropos.model.service;
import javafx.io.http.HttpRequest;
import java.io.InputStream;
import javafx.io.http.HttpHeader;
import org.apropos.model.domain.HierarchicalRequirement;
import javafx.data.pull.Event;
import javafx.data.pull.PullParser;
import org.apropos.model.RallyModel;

/**
 * Updates a HierarchyRequirements object in the Rally server by issuing an
 * HTTP POST with the JSON stream representation of the object.
 * Note: The JSON stream only contains the elements corresponding to the
 *       HierarchicalRequirement instance variables that the application
 *       modifies, as this saves available bandwidth.
 *
 * TODO: Generalize this functionality, leveraging RedFX (when update is
 *       available) to update any Rally domain object
 *
 * TODO: Push the common instance variables into the AbstractRequest class
 * @author Jim Weaver
 */
public class HierUpdateRequest extends AbstractRequest {
    package var model = RallyModel.instance;


    public-init var hierarchicalRequirement:HierarchicalRequirement on replace {
        if (hierarchicalRequirement != null) {
            endPoint = hierarchicalRequirement._ref;
        }
    }

    var endPoint:String;

    var outStr =
            "\{ \"HierarchicalRequirement\": \{ "
            "  \"RoadmapKanbanState\": \"{hierarchicalRequirement.RoadmapKanbanState}\", "
            "  \"RoadmapRelease\": \"{hierarchicalRequirement.RoadmapRelease}\", "
            "  \"Owner\": \"{hierarchicalRequirement.Owner}\", "
            "  \"Project\": \"{hierarchicalRequirement.Project}\", "
            "  \"Rank\": \"{hierarchicalRequirement.Rank}\" "
            "  \} "
            "\} ";

    public var onDone:function();

    public var onErrors:function(:String[]);

    var httpRequest:HttpRequest;

    var errors:String[];
    var warnings:String[];

    public function start():Void {
        createHttpRequest();
    }

    function parseResponse(is:InputStream) {
        try {
            PullParser {
                input: is
                documentType: PullParser.JSON;
                onEvent: function( e:Event ) {
                    if (e.type == PullParser.END_ARRAY_ELEMENT) {
                        if (e.level == 1) {
                            if (e.name == "Errors") {
                                insert e.text into errors;
                            }
                            else if (e.name == "Warnings") {
                                insert e.text into warnings;
                            }
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
        def username = model.login.userName;
        def password = model.login.password;

        //TODO: Keep the print statements in while validating functionality
        println("In HierUpdateRequest#createHttpRequest, hierarchicalRequirement.toString():");
        println(hierarchicalRequirement.toString());

        httpRequest = HttpRequest {
            headers: [
                HttpHeader.basicAuth(username, password),
                HttpHeader {
                    name: HttpHeader.CONTENT_TYPE;
                    value: "text/json";
                },
                HttpHeader {
                    name: HttpHeader.CONTENT_LENGTH;
                    value: "{outStr.getBytes().length}";
                }
            ]
            location: endPoint
            method: HttpRequest.POST
            onException: function(e) {
                insert "Exception: {e.getClass()} {e.getMessage()}" into errors;
            }
            onInput: parseResponse
            onOutput: function(os: java.io.OutputStream) {
                try {
                    os.write(outStr.getBytes());
                }
                finally {
                    os.close();
                }
            }
            onDone: function() {
                onDone();
                if (sizeof errors > 0) {
                    onErrors(errors);
                }
            }
        }
        httpRequest.start();
    }
}
