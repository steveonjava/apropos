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
package org.apropos.model.domain;

/**
 * The base class for all domain objects
 * TODO: Try making this class abstract
 * @author Jim Weaver
 */
public class DomainObject extends OperationResult {

    /**
     *
     */
    public var _ref:String;

    /**
     *
     */
    public var _objectVersion:String;

    /**
     *
     */
    public var _type:String;

    /**
     *
     */
    public var _refObjectName:String;

    /**
     *
     */
    public var _rallyAPIMajor:String;

    /**
     *
     */
    public var _rallyAPIMinor:String;

    /**
     *
     */
    public var CreationDate:String;

    /**
     * TODO: Decide if this variable belongs in this class
     */
    public var _CreatedAt:String;

    /**
     *
     */
    public var ObjectID:Integer;

    /**
     *
     */
    public var Subscription:Subscription;

    /**
     *
     */
    override public function toString () {
        return "_ref:{_ref}";
    }
}
