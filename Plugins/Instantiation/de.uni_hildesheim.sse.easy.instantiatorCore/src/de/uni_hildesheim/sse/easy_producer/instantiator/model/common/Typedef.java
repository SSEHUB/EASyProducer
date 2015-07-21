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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Implements the typedef element, actually a type alias.
 * 
 * @author Holger Eichelberger
 */
public class Typedef {
    
    private String name;
    private TypeDescriptor<?> type;

    /**
     * Creates a typedef.
     * 
     * @param name the alias name
     * @param type the type to be used for <code>name</code>
     * @throws VilException if one  of the arguments is invalid
     */
    public Typedef(String name, TypeDescriptor<?> type) throws VilException {
        this.name = name;
        this.type = type;
        if (null == name || 0 == name.length()) {
            throw new VilException("No name for typedef given", VilException.ID_INTERNAL);
        }
        if (null == type) {
            throw new VilException("No type given", VilException.ID_INTERNAL);
        }
    }
    
    /**
     * Accepts the visitor for visiting.
     * 
     * @param visitor the visitor to be used
     * @return the result of visiting this instance (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitTypedef(this);
    }
    
    /**
     * Returns the alias name.
     * 
     * @return the alias name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the represented type.
     * 
     * @return the represented type
     */
    public TypeDescriptor<?> getType() {
        return type;
    }
    
}
