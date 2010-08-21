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
import org.apropos.model.domain.DomainObjectWrapper;
import org.jfxtras.redfx.client.rest.RestRequest;
import org.apropos.model.RallyModel;

//import org.apropos.model.RallyModel;

/**
 * Contains functions that create and return an object such as QueryRequest for
 * query, ReadRequest for read, and UpdateRequest for update.
 *
 * TODO: Push the common instance variables into the AbstractRequest class
 * TODO: Append the workspaceRef to the endpoint
 * @author Jim Weaver
 */
public class ReadRequest extends AbstractRequest {
    package var model = RallyModel.instance;

//TODO: Implement these in this class, and/or the super class
//    public-init var resultType:String = "QueryResult";
//    public-init var fetch:String;
//    public-init var query:String;
//    public-init var order:String;
//    public-init var start:Integer = 1;
//    public-init var pagesize:Integer = 20;
//    public-init var workspace:String;
//    public-init var project:String;
//    public-init var projectScopeUp:Boolean = true;
//    public-init var projectScopeDown:Boolean = true;

    public-init var endPoint:String;

    var workspaceRef:String = model.selectedWorkspace.getRef() on replace {
        if (workspaceRef != null) {
            println("In ReadRequest#workspaceRef trigger, workspaceRef:{workspaceRef}");
        }
    };

    public var onResponse:function(domainObjectWrapper:DomainObjectWrapper);

    public var onError:function(obj:Object);

    public function start():Void {
        request.start();
    }

    public function gotResult(obj:Object):Void {
        var wrapper: DomainObjectWrapper = obj as DomainObjectWrapper;
        onResponse(wrapper);
    }

    public function gotError(obj:Object):Void {
        onError(obj);
    }

    var request: RestRequest = RestRequest {
        username: model.login.userName
        password: model.login.password
        uri: endPoint
        clazz: "org.apropos.model.domain.DomainObjectWrapper"
        onResult: gotResult
        onError: gotError
    }

}
