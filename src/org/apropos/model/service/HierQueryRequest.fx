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
import org.apropos.model.domain.HierQueryResultWrapper;
import org.apropos.model.domain.HierQueryResult;
import org.apropos.model.domain.HierarchicalRequirement;
import org.apropos.model.RallyModel;
import org.apropos.model.domain.User;
import javafx.data.pull.Event;
import javafx.data.pull.PullParser;
import org.apropos.model.domain.Project;
//import org.apropos.model.RallyModel;

//import org.apropos.model.RallyModel;

/**
 * Contains functions that create and return an object such as QueryRequest for
 * query, ReadRequest for read, and UpdateRequest for update.
 *
 * TODO: Push the common instance variables into the AbstractRequest class
 * TODO: Append the workspaceRef to the endpoint
 * @author Jim Weaver
 */
public class HierQueryRequest extends AbstractRequest {
    package var model = RallyModel.instance;


    public-init var endPoint:String;

//    var workspaceRef:String = model.selectedWorkspace._ref on replace {
//        if (workspaceRef != null) {
//            println("In ReadRequest#workspaceRef trigger, workspaceRef:{workspaceRef}");
//        }
//    };

    public var onResponse:function(hierQueryResultWrapper:HierQueryResultWrapper);

    public var onError:function(obj:Object);

    var httpRequest:HttpRequest;
    var wrapper:HierQueryResultWrapper;
    var curHierReq:HierarchicalRequirement;

    var curOwner:User;
    var curParent:HierarchicalRequirement;
    var curProject:Project;

    var processingOwner:Boolean;
    var processingParent:Boolean;
    var processingProject:Boolean;

    public function start():Void {
        createHttpRequest();
    }

    public function gotResult(obj:Object):Void {
        onResponse(wrapper);
    }

    public function gotError(obj:Object):Void {
        onError(obj);
    }

    function parseResponse(is:InputStream) {
        try {
            PullParser {
                input: is
                documentType: PullParser.JSON;
                onEvent: function( e:Event ) {
                    //println("Event:{e}");
                    if (e.type == PullParser.START_VALUE) {
                        if (e.level == 3) {
                            if (e.name == "Owner") {
                                processingOwner = true;
                                curOwner = User {};
                            }
                            else if (e.name == "Parent") {
                                processingParent = true;
                                curParent = HierarchicalRequirement {};
                            }
                            else if (e.name == "Project") {
                                processingProject = true;
                                curProject = Project {};
                            }
                        }
                    }
                    else if (e.type == PullParser.END_VALUE) {
                        if (e.level == 1) {
                            if (e.name == "_rallyAPIMajor") {
                                wrapper.HierQueryResult._rallyAPIMajor = e.text;
                            }
                            else if (e.name == "_rallyAPIMinor") {
                                wrapper.HierQueryResult._rallyAPIMinor = e.text;
                            }
                            //TODO: Handle Errors, Warnings
                            else if (e.name == "TotalResultCount") {
                                wrapper.HierQueryResult.TotalResultCount = e.integerValue;
                            }
                            else if (e.name == "StartIndex") {
                                wrapper.HierQueryResult.StartIndex = e.integerValue;
                            }
                        }
                        if (e.level == 3) {
                            if (e.name == "Owner") {
                                processingOwner = false;
                                curHierReq.Owner = curOwner;
                            }
                            else if (e.name == "Parent") {
                                processingParent = false;
                                curHierReq.Parent = curParent;
                            }
                            else if (e.name == "Project") {
                                processingProject = false;
                                curHierReq.Project = curProject;
                            }
                        }
                        else if (e.level == 4) {
                            if (processingOwner) {
                                if (e.name == "_rallyAPIMajor") {
                                    curOwner._rallyAPIMajor = e.text;
                                }
                                else if (e.name == "_rallyAPIMinor") {
                                    curOwner._rallyAPIMinor = e.text;
                                }
                                else if (e.name == "_ref") {
                                    curOwner._ref = e.text;
                                }
                                else if (e.name == "_objectVersion") {
                                    curOwner._objectVersion = e.text;
                                }
                                else if (e.name == "_refObjectName") {
                                    curOwner._refObjectName = e.text;
                                }
                                else if (e.name == "_type") {
                                    curOwner._type = e.text;
                                }
                            }
                            else if (processingParent) {
                                if (e.name == "_rallyAPIMajor") {
                                    curParent._rallyAPIMajor = e.text;
                                }
                                else if (e.name == "_rallyAPIMinor") {
                                    curParent._rallyAPIMinor = e.text;
                                }
                                else if (e.name == "_ref") {
                                    curParent._ref = e.text;
                                }
                                else if (e.name == "_objectVersion") {
                                    curParent._objectVersion = e.text;
                                }
                                else if (e.name == "_refObjectName") {
                                    curParent._refObjectName = e.text;
                                }
                                else if (e.name == "_type") {
                                    curParent._type = e.text;
                                }
                            }
                            else if (processingProject) {
                                if (e.name == "_rallyAPIMajor") {
                                    curProject._rallyAPIMajor = e.text;
                                }
                                else if (e.name == "_rallyAPIMinor") {
                                    curProject._rallyAPIMinor = e.text;
                                }
                                else if (e.name == "_ref") {
                                    curProject._ref = e.text;
                                }
                                else if (e.name == "_objectVersion") {
                                    curProject._objectVersion = e.text;
                                }
                                else if (e.name == "_refObjectName") {
                                    curProject._refObjectName = e.text;
                                }
                                else if (e.name == "_type") {
                                    curProject._type = e.text;
                                }
                            }
                        }
                        else if (curHierReq != null) {
                            if (e.level == 2) {
                                if (e.name == "_rallyAPIMajor") {
                                    curHierReq._rallyAPIMajor = e.text;
                                }
                                else if (e.name == "_rallyAPIMinor") {
                                    curHierReq._rallyAPIMinor = e.text;
                                }
                                else if (e.name == "_ref") {
                                    curHierReq._ref = e.text;
                                }
                                else if (e.name == "_objectVersion") {
                                    curHierReq._objectVersion = e.text;
                                }
                                else if (e.name == "_refObjectName") {
                                    curHierReq._refObjectName = e.text;
                                }
                                else if (e.name == "Description") {
                                    curHierReq.Description = e.text;
                                }
                                else if (e.name == "FormattedID") {
                                    curHierReq.FormattedID = e.text;
                                }
                                //TODO: Handle Owner, Project, Parent
                                else if (e.name == "Rank") {
                                    curHierReq.Rank = e.numberValue;
                                }
                                else if (e.name == "ScheduleState") {
                                    curHierReq.ScheduleState = e.text;
                                }
                                else if (e.name == "Blocked") {
                                    curHierReq.Blocked = e.booleanValue;
                                }
                                else if (e.name == "RoadmapAllocation") {
                                    curHierReq.RoadmapAllocation = e.text;
                                }
                                else if (e.name == "RoadmapKanbanState") {
                                    curHierReq.RoadmapKanbanState = e.text;
                                }
                                else if (e.name == "RoadmapRelease") {
                                    curHierReq.RoadmapRelease = e.text;
                                }
                                else if (e.name == "ObjectID") {
                                    curHierReq.ObjectID = e.integerValue;
                                }
                                else if (e.name == "_type") {
                                    curHierReq._type = e.text;
                                }
                            }
                        }
                    }
                    else if (e.type == PullParser.START_ARRAY_ELEMENT) {
                        if (e.name == "Results") {
                            curHierReq = HierarchicalRequirement {};
                        }
                    }
                    else if (e.type == PullParser.END_ARRAY_ELEMENT) {
                        if (e.name == "Results") {
                            insert curHierReq into wrapper.HierQueryResult.Results;
                        }
                    }
                }
            }.parse();
        }
        finally {
            is.close();
            gotResult(wrapper);
        }
      }

    function createHttpRequest():Void {
        println("endPoint:{endPoint}");
        def username = model.login.userName;
        def password = model.login.password;
        wrapper = HierQueryResultWrapper {};
        wrapper.HierQueryResult = HierQueryResult {};

        httpRequest = HttpRequest {
            headers: if (username != null) {
                HttpHeader.basicAuth(username, password);
            } else { null }
            location: endPoint
            method: HttpRequest.GET
            onException: function(e) {
                e.printStackTrace();
            }
            onInput: parseResponse
            onDone: function() {
                //println("HttpRequest is done, responseCode:{httpRequest.responseCode}");
            }
        }
        httpRequest.start();
    }
}
