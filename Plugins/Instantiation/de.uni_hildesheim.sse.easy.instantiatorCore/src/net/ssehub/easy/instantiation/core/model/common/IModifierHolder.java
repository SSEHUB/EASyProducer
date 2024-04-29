/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.common;

/**
 * Defines the interface of a class holding modifiers.
 * 
 * @author Holger Eichelberger
 */
public interface IModifierHolder {
    
    /**
     * Returns the number of modifiers.
     * 
     * @return the number of modifiers
     */
    public int getModifierCount();
    
    /**
     * Returns the specified modifier.
     * 
     * @param index the 0-based index of the modifier to return
     * @return the specified modifier
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getModifierCount()}</code>
     */
    public IModifier getModifier(int index);
    
    /**
     * Returns whether this variable declaration has a given <code>modifier</code>.
     * 
     * @param modifier the modifier to search for
     * @return <code>true</code> if this variable declaration has the <code>modifier</code> attached, 
     *   <code>false</code> else
     */
    public boolean hasModifier(IModifier modifier);

}
