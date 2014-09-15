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
package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.utils.messages.IIdentifiable;

/**
 * A top level exception class for all IVML exceptions.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public abstract class IvmlException extends Exception implements IIdentifiable {

    private int code;
    
    /**
     * Create a new exception based on the given message.
     * 
     * @param message the message
     * @param code a code detailing the exception
     */
    public IvmlException(String message, int code) {
        super(message);
        this.code = code;
    }
    
    /**
     * Returns a numerical code representing the cause.
     * 
     * @return the numerical code
     */
    public int getCode() {
        return code;
    }

    /**
     * {@inheritDoc}
     */
    public int getId() {
        return code;
    }
    
}
