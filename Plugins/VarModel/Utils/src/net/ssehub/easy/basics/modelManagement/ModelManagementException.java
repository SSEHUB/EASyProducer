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
package net.ssehub.easy.basics.modelManagement;

import net.ssehub.easy.basics.messages.AbstractException;

/**
 * An exception thrown by the model management itself typically
 * on global consistency issues.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ModelManagementException extends AbstractException {
    
    public static final int MODEL_INFO_INCONSISTENCY = 10500;
    public static final int MODEL_CYCLIC_IMPORT = 10501;
    public static final int MODEL_IMPORT_VERSION_CONFLICT = 10502;
    public static final int MODEL_LOAD_FAILURE = 10503;
    public static final int INTERNAL = 10599;
    
    /**
     * Create a new exception based on the given message.
     * 
     * @param message the message
     * @param code a code detailing the exception
     */
    public ModelManagementException(String message, int code) {
        super(message, code);
    }
    
    /**
     * Create a new exception based on the given message.
     * 
     * @param message the message
     * @param code a code detailing the exception
     */
    public ModelManagementException(StringBuilder message, int code) {
        super(message.toString(), code);
    }

}
