/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.validation;

import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * A specific message for model validation purposes.
 * 
 * @author Holger Eichelberger
 */
public class ValidationMessage extends Message {
    
    /**
     * Denotes the case that contained element (reference) is null.
     */
    public static final int ELEMENT_IS_NULL = 10800;

    /**
     * Denotes the case that an identifier is invalid (see {@link IvmlIdentifierCheck}).
     */
    public static final int INVALID_IDENTIFIER = 10801;

    /**
     * Denotes the case that a type reference is null.
     */
    public static final int TYPE_IS_NULL = 10802;

    /**
     * Denotes the case that a parent reference is invalid, e.g., <b>null</b>.
     */
    public static final int INVALID_PARENT = 10803;

    /**
     * Denotes the case that a slot in a compound is used but not declared.
     */
    public static final int UNDECLARED_SLOT = 10804;

    /**
     * Denotes the case that an expression is missing.
     */
    public static final int MISSING_EXPRESSION = 10805;

    /**
     * Denotes a generic null pointer which shall not be present.
     */
    public static final int IS_NULL = 10806;

    /**
     * Denotes an illegal comment.
     */
    public static final int ILLEGAL_COMMENT = 10807;
   
    /**
     * Denotes a missing {@link de.uni_hildesheim.sse.model.varModel.datatypes.CustomDatatype} of an
     * {@link de.uni_hildesheim.sse.model.varModel.AbstractVariable}.
     */
    public static final int MISSING_CUSTOM_DATATYPE = 10808;
    
    /**
     * Denotes a missing/unspecified operation used inside an {@link de.uni_hildesheim.sse.model.cst.OCLFeatureCall}.
     * The operation was not resolved, probably because
     * {@link de.uni_hildesheim.sse.model.cst.OCLFeatureCall#inferDatatype()} was not called.
     */
    public static final int UNRESOLVED_OPERATION = 10809;
    
    /**
     * Stores the type of the message (see constants above).
     */
    private int code;
    
    /**
     * Stores the cause of the message.
     */
    private Object cause;

    /**
     * Creates a validation message (without a model element as cause).
     * 
     * @param description the message description
     * @param status the status of the message
     * @param code an optional code identifying the specific kind of message 
     *   typically used while automated testing (use constants defined in this class)
     */
    public ValidationMessage(String description, Status status, int code) {
        this(description, status, null, code);
    }

    /**
     * Creates a validation message.
     * 
     * @param description the message description
     * @param status the status of the message
     * @param cause the element which caused the message (may be <b>null</b>)
     * @param code an optional code identifying the specific kind of message 
     *   typically used while automated testing (use constants defined in this class)
     */
    public ValidationMessage(String description, Status status, Object cause, int code) {
        super(description, status);
        this.code = code;
        this.cause = cause;
    }
    
    /**
     * Returns the code of this message.
     * 
     * @return the code identifying the kind of message, see constants in this class
     */
    public int getCode() {
        return code;
    }
    
    /**
     * Returns the cause of this message.
     * 
     * @return the cause, may be <b>null</b>
     */
    public Object getCause() {
        return cause;
    }

}
