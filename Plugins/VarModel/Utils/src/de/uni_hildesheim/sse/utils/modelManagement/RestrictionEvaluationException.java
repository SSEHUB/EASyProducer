/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.utils.modelManagement;

/**
 * An exception thrown when then evaluation of a restriction fails.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class RestrictionEvaluationException extends Exception {

    public static final int ID_INTERNAL = 10999;

    private int id;

    /**
     * Creates a restriction evaluation exception.
     *  
     * @param message the exception message
     * @param id an identification used for testing
     */
    public RestrictionEvaluationException(String message, int id) {
        this(message, id, null);
    }
    
    /**
     * Creates a restriction evaluation exception.
     *  
     * @param message the exception message
     * @param id an identification used for testing
     * @param cause the causing exception
     */
    public RestrictionEvaluationException(String message, int id, Exception cause) {
        super(message, cause);
        this.id = id;
    }
    
    /**
     * Returns the identification used for testing.
     * 
     * @return the identification
     */
    public int getId() {
        return id;
    }
    
}
