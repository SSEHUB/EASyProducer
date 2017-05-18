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
package net.ssehub.easy.varModel.cstEvaluation;

import java.util.List;

import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.values.IValueVisitor;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Special wrapper value for lists. To be used just for iteration evaluation.
 * 
 * @author Holger Eichelberger
 */
class ListWrapperValue extends Value {

    private List<Value> values;
    
    /**
     * Creates a list wrapper value.
     * 
     * @param values the list values
     */
    ListWrapperValue(List<Value> values) {
        super(AnyType.TYPE);
        this.values = values;
    }
    
    @Override
    public Object getValue() {
        return values;
    }
    
    /**
     * Returns the number of elements in the wrapped list.
     * 
     * @return the number of elements
     */
    public int getElementCount() {
        return values.size();
    }
    
    /**
     * Returns the specified element.
     * 
     * @param index the 0-based index of the element
     * @return the element
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getElementCount()}</code>
     */
    public Value getElement(int index) {
        return values.get(index);
    }

    @Override
    public void accept(IValueVisitor visitor) {
        // do nothing
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        // not needed
    }

    @Override
    public boolean isConfigured() {
        return true;
    }

    @Override
    public boolean equalsPartially(Value value) {
        return false; // only temporary
    }

}
