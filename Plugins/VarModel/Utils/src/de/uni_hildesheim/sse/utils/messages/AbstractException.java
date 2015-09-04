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
package de.uni_hildesheim.sse.utils.messages;


/**
 * A common exception with identifier for testing.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public abstract class AbstractException extends Exception implements IIdentifiable {

    /**
     * Defines an identifier for implementation problems.
     */
    public static final int ID_INTERNAL = 70000;
    
    /**
     * Defines an identifier for semantic problems.
     */
    public static final int ID_SEMANTIC = 70001;

    /**
     * Defines an identifier if something cannot be resolved.
     */
    public static final int ID_CANNOT_RESOLVE = 70002;
    
    /**
     * Defines an identifier for ambiguities.
     */
    public static final int ID_AMBIGUOUS = 70003;
    
    /**
     * Indicates a warning to be filtered out.
     */
    public static final int ID_WARNING = 70004;
    
    private int id;
    
    /**
     * Creates a buildlang exception based on a given <code>message</code>.
     * 
     * @param message the message of the exception
     * @param id the identifier (see constants above)
     */
    public AbstractException(String message, int id) {
        this(message, null, id);
    }
    
    /**
     * Creates a expression exception from a message and an optional cause.
     * 
     * @param message the message of the exception
     * @param cause the originally causing exception
     * @param id the identifier (see constants above) 
     */
    public AbstractException(String message, Throwable cause, int id) {
        super(null == message && null != cause ? cause.getMessage() : message, cause);
        this.id = id;
    }
    
    /**
     * Creates a known exception as cause.
     * Note that the identification from <code>cause</code> is taken over
     * as identification.
     * 
     * @param cause the causing exception 
     */
    public AbstractException(AbstractException cause) {
        this(cause.getMessage(), cause, cause.getId());
    }
    
    /**
     * Returns the identifier. (for testing)
     * 
     * @return the identifier
     */
    public int getId() {
        return id;
    }
    
}
