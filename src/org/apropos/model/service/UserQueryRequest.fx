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
//import org.apropos.model.RallyModel;
import org.apropos.model.domain.User;
import javafx.data.pull.Event;
import javafx.data.pull.PullParser;
import org.apropos.model.domain.UserProfile;
import org.apropos.model.domain.UserQueryResultWrapper;
import org.apropos.model.domain.UserQueryResult;
import org.apropos.model.RallyModel;
import org.apropos.model.domain.Subscription;

/**
 * Contains functions that create and return an object such as QueryRequest for
 * query, ReadRequest for read, and UpdateRequest for update.
 *
 * TODO: Push the common instance variables into the AbstractRequest class
 * TODO: Append the workspaceRef to the endpoint
 * @author Jim Weaver
 */
public class UserQueryRequest extends AbstractRequest {
    package var model = RallyModel.instance;


    public-init var endPoint:String;

    public var onResponse:function(userQueryResultWrapper:UserQueryResultWrapper);

    //TODO: Consolidate these
    public var onError:function(obj:Object);
    public var onErrors:function(:String[]);

    var errors:String[];
    var warnings:String[];


    var httpRequest:HttpRequest;
    var wrapper:UserQueryResultWrapper;
    var curUser:User;

    var curUserProfile:UserProfile;
    var curSubscription:Subscription;

    var processingUserProfile:Boolean;
    var processingSubscription:Boolean;
    
    function resetProcessingFlags():Void {
        processingUserProfile = false;
        processingSubscription = false;
    }
    

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
                    if (e.type == PullParser.START_VALUE) {
                        if (e.level == 2) {
                            if (e.name == "UserProfile") {
                                resetProcessingFlags();
                                processingUserProfile = true;
                                curUserProfile = UserProfile {};
                            }
                            else if (e.name == "Subscription") {
                                resetProcessingFlags();
                                processingSubscription = true;
                                curSubscription = Subscription {};
                            }
                        }
                    }
                    if (e.type == PullParser.END_VALUE) {
                        if (e.level == 1) {
                            if (e.name == "_rallyAPIMajor") {
                                wrapper.UserQueryResult._rallyAPIMajor = e.text;
                            }
                            else if (e.name == "_rallyAPIMinor") {
                                wrapper.UserQueryResult._rallyAPIMinor = e.text;
                            }
                            else if (e.name == "TotalResultCount") {
                                wrapper.UserQueryResult.TotalResultCount = e.integerValue;
                            }
                            else if (e.name == "StartIndex") {
                                wrapper.UserQueryResult.StartIndex = e.integerValue;
                            }
                        }
                        if (e.level == 2) {
                            if (curUser != null) {
                                if (e.name == "UserProfile") {
                                    processingUserProfile = false;
                                    curUser.UserProfile = curUserProfile;
                                }
                                else if (e.name == "Subscription") {
                                    processingSubscription = false;
                                    curUser.Subscription = curSubscription;
                                }
                                if (e.name == "_rallyAPIMajor") {
                                    curUser._rallyAPIMajor = e.text;
                                }
                                else if (e.name == "_rallyAPIMinor") {
                                    curUser._rallyAPIMinor = e.text;
                                }
                                else if (e.name == "_ref") {
                                    curUser._ref = e.text;
                                }
                                else if (e.name == "_objectVersion") {
                                    curUser._objectVersion = e.text;
                                }
                                else if (e.name == "_refObjectName") {
                                    curUser._refObjectName = e.text;
                                }
                                else if (e.name == "Disabled") {
                                    curUser.Disabled = e.booleanValue;
                                }
                                else if (e.name == "EmailAddress") {
                                    curUser.EmailAddress = e.text;
                                }
                                else if (e.name == "FirstName") {
                                    curUser.FirstName = e.text;
                                }
                                else if (e.name == "LastName") {
                                    curUser.LastName = e.text;
                                }
                                else if (e.name == "LastPasswordUpdateDate") {
                                    curUser.LastPasswordUpdateDate = e.text;
                                }
                                else if (e.name == "MiddleName") {
                                    curUser.MiddleName = e.text;
                                }
                                else if (e.name == "Role") {
                                    curUser.Role = e.text;
                                }
                                else if (e.name == "ShortDisplayName") {
                                    curUser.ShortDisplayName = e.text;
                                }
                                else if (e.name == "UserName") {
                                    curUser.UserName = e.text;
                                }
                                else if (e.name == "ObjectID") {
                                    curUser.ObjectID = e.integerValue;
                                }
                                else if (e.name == "_type") {
                                    curUser._type = e.text;
                                }
                            }
                        }
                        else if (e.level == 3) {
                            if (processingUserProfile) {
                                if (e.name == "_rallyAPIMajor") {
                                    curUserProfile._rallyAPIMajor = e.text;
                                }
                                else if (e.name == "_rallyAPIMinor") {
                                    curUserProfile._rallyAPIMinor = e.text;
                                }
                                else if (e.name == "_ref") {
                                    curUserProfile._ref = e.text;
                                }
                                else if (e.name == "_objectVersion") {
                                    curUserProfile._objectVersion = e.text;
                                }
                                else if (e.name == "_refObjectName") {
                                    curUserProfile._refObjectName = e.text;
                                }
                                else if (e.name == "_type") {
                                    curUserProfile._type = e.text;
                                }
                            }
                            else if (processingSubscription) {
                                if (e.name == "_rallyAPIMajor") {
                                    curSubscription._rallyAPIMajor = e.text;
                                }
                                else if (e.name == "_rallyAPIMinor") {
                                    curSubscription._rallyAPIMinor = e.text;
                                }
                                else if (e.name == "_ref") {
                                    curSubscription._ref = e.text;
                                }
                                else if (e.name == "_objectVersion") {
                                    curSubscription._objectVersion = e.text;
                                }
                                else if (e.name == "_refObjectName") {
                                    curSubscription._refObjectName = e.text;
                                }
                                else if (e.name == "_type") {
                                    curSubscription._type = e.text;
                                }
                            }
                        }
                    }
                    else if (e.type == PullParser.START_ARRAY_ELEMENT) {
                        if (e.name == "Results") {
                            curUser = User {};
                        }
                    }
                    else if (e.type == PullParser.END_ARRAY_ELEMENT) {
                        if (e.level == 1) {
                            if (e.name == "Errors") {
                                insert e.text into errors;
                            }
                            else if (e.name == "Warnings") {
                                insert e.text into warnings;
                            }
                        }
                        if (e.name == "Results") {
                            insert curUser into wrapper.UserQueryResult.Results;
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
        def username = model.login.userName;
        def password = model.login.password;
        wrapper = UserQueryResultWrapper {};
        wrapper.UserQueryResult = UserQueryResult {};

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
                if (sizeof errors > 0) {
                    onErrors(errors);
                }
            }
        }
        httpRequest.start();
    }
}
