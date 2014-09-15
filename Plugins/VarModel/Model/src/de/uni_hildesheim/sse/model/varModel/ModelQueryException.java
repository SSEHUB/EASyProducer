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

/**
 * Defines an exception type thrown by the {@link ModelQuery} class.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ModelQueryException extends IvmlException {

    public static final int AMBIGUITY = 10150;
    public static final int ACCESS_ERROR = 10151;
    public static final int MISMATCHED_IMPORT = 10152;
    public static final int UNMATCHED_IMPORT = 10153;
    
    /**
     * Creates a new model query exception.
     * 
     * @param message the message
     * @param code the related code
     */
    public ModelQueryException(String message, int code) {
        super(message, code);
    }
    
}
