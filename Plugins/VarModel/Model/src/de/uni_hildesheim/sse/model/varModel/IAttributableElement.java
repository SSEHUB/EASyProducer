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
 * Interface to mark attributable elements. Classes implementing this interface
 * shall consider the implementation of {@link IModelElement#propagateAttribute(Attribute)}.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public interface IAttributableElement extends IAttributeAccess {
    
    /**
     * Method to get the name of the element.
     * 
     * @return name of the element
     */
    public String getName();

    /**
     * Returns the qualified name of this element.
     * 
     * @return the qualified name
     */
    public String getQualifiedName();

    /**
     * Attributes this element.
     * 
     * @param attribute the attribute to be added
     * @return <code>true</code> if the operation was successful,
     *   <code>false</code> if the element is about being attributed 
     *   multiple times with the same attribute
     */
    public boolean attribute(Attribute attribute);
    
}
