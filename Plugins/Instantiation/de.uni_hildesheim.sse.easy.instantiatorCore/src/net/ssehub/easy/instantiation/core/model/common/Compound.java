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

import net.ssehub.easy.instantiation.core.model.vilTypes.CompoundTypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.CompoundTypeDescriptor.SlotDescriptor;

/**
 * Represents a compound mostly through its type.
 * 
 * @author Holger Eichelberger
 */
public class Compound {

    private CompoundTypeDescriptor type;

    /**
     * Creates a compound.
     * 
     * @param type the type of the compound
     */
    public Compound(CompoundTypeDescriptor type) {
        this.type = type;
    }
    
    /**
     * Returns the name of the compound.
     * 
     * @return the name of the compound
     */
    public String getName() {
        return type.getName();
    }
    
    /**
     * Returns the refined compound.
     * 
     * @return the refined compound (<b>null</b> for none)
     */
    public CompoundTypeDescriptor getRefines() {
        return type.getRefines();
    }
    
    /**
     * Returns whether the compound is abstract.
     * 
     * @return <code>true</code> for abstract, <code>false</code> else
     */
    public boolean isAbstract() {
        return type.isAbstract();
    }
    
    /**
     * Returns the number of slots.
     * 
     * @return the number of slots
     */
    public int getSlotsCount() {
        return type.getSlotCount();
    }
    
    /**
     * Returns the specified slot.
     * 
     * @param index the 0-based index
     * @return the slot
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getSlotsCount()}</code>
     */
    public SlotDescriptor getSlot(int index) {
        return type.getSlot(index);
    }
    
    /**
     * Returns the defined type.
     * 
     * @return the defined type
     */
    public TypeDescriptor<?> getType() {
        return type;
    }

    /**
     * Accepts the visitor for visiting.
     * 
     * @param visitor the visitor to be used
     * @return the result of visiting this instance (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitCompound(this);
    }

}
