/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.basics.messages.AbstractException;

/**
 * Defines a specific exception for failing rule conditions carrying the index of the 
 * failing expression.
 * 
 * @author Holger Eichelberger
 */
public class RuleDescriptorException extends AbstractException {

    public static final int ID_RULE_MISMATCH = 79990;

    /**
     * For serialization.
     */
    private static final long serialVersionUID = -6133161535416122432L;

    private int index;

    /**
     * Creates a new rule condition exception.
     * 
     * @param message the message
     * @param index the index of the failing expression
     */
    public RuleDescriptorException(String message, int index) {
        super(message, ID_RULE_MISMATCH);
        this.index = index;
    }

    /**
     * Creates a new rule condition exception.
     * 
     * @param exception the exception to take message and id from
     * @param index the index of the failing expression
     */
    public RuleDescriptorException(AbstractException exception, int index) {
        super(exception);
        this.index = index;
    }
    
    /**
     * Returns the index of the failing expression.
     * 
     * @return the index
     */
    public int getIndex() {
        return index;
    }
    
}
