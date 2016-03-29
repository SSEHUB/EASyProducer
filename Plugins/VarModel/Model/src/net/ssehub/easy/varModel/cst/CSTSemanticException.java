/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.model.IvmlException;

/**
 * Exception for invalid Constraints. Will be thrown if datatypes not match.
 * 
 * @author tebbje
 * @author Holger Eichelberger
 *
 */
@SuppressWarnings("serial")
public class CSTSemanticException extends IvmlException {

    public static final int TYPE_MISMATCH = 10100;
    public static final int UNKNOWN_OPERATION = 10101;
    public static final int CONTAINER_OPERATION = 10102;
    public static final int INTERNAL = 10103;
    public static final int UNKNOWN_ELEMENT = 10104;
    public static final int AMBIGUITY = 10105;
    public static final int ILLEGAL = 10106;
    public static final int DECLARATOR_SEMANTICS = 10107;
    public static final int UNRESOLVED = 10108;
    
    /**
     * Creates a new exception instance.
     * 
     * @param message the message describing the problem
     * @param code a code representing the reason
     */
    public CSTSemanticException(String message, int code) {
        super(message, code); // TODO consider internationalization
    }

}
