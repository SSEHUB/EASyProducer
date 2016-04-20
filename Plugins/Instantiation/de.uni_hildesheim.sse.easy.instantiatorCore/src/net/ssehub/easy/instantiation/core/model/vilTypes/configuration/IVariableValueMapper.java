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
package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

/**
 * Performs a variable value mapping. {@link #isValid(IvmlElement) isValid} and 
 * {@link #isEnacting(IvmlElement) isEnacting} need special treatment as they represent
 * meta-values.
 * 
 * @author Holger Eichelberger
 */
public interface IVariableValueMapper {

    /**
     * Returns whether the given <code>element</code> is valid.
     * 
     * @param element the element
     * @return <code>true</code> if valid (also if no mapping), <code>false</code> if invalid
     */
    public boolean isValid(IvmlElement element);

    /**
     * Returns whether the given <code>element</code> is valid.
     * 
     * @param element the element
     * @return <code>true</code> if valid, <code>false</code> if invalid (also if no mapping)
     */
    public boolean isEnacting(IvmlElement element);

    /**
     * Returns the value of the specified element.
     * 
     * @param element the element
     * @return the value, <b>null</b> if undefined or if there is no mapping
     */
    public Object getValue(IvmlElement element);
    
}
