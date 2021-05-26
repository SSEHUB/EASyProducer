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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.HashMap;

import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.expressions.IInitializableValue;
import net.ssehub.easy.instantiation.core.model.vilTypes.CompoundTypeDescriptor.SlotDescriptor;

/**
 * Represents a compound instance.
 * 
 * @author Holger Eichelberger
 */
public class CompoundInstance implements IInitializableValue, IStringValueProvider {

    private CompoundTypeDescriptor type;
    private java.util.Map<String, Object> slotValues = new HashMap<String, Object>();
    
    /**
     * Creates a compound instance and leaves it uninitialized.
     * 
     * @param type the type
     * @see #initialize(EvaluationVisitor)
     */
    public CompoundInstance(CompoundTypeDescriptor type) {
        this.type = type;
    }

    @Override
    public void initialize(IExpressionVisitor evaluator) throws VilException {
        initializeFor(evaluator, type);
    }
    
    /**
     * Initializes this instance for the given (parent) <code>type</code>.
     * 
     * @param evaluator the evaluator
     * @param type the type to initialize for
     * @throws VilException in case that evaluating initialization expressions fails
     */
    private void initializeFor(IExpressionVisitor evaluator, CompoundTypeDescriptor type) throws VilException {
        // parents first
        if (null != type.getRefines()) {
            initializeFor(evaluator, type.getRefines());
        }
        // then the type we are called with
        for (int f = 0; f < type.getFieldCount(); f++) {
            FieldDescriptor field = type.getField(f);
            // don't override constuctor values
            if (field instanceof SlotDescriptor && !slotValues.containsKey(field.getName())) {
                Expression initEx = ((SlotDescriptor) field).getExpression();
                if (null != initEx) {
                    setSlotValue(field.getName(), initEx.accept(evaluator));
                }
            }
        }
    }
    
    /**
     * Returns the type of this compound instance.
     * 
     * @return the type
     */
    public CompoundTypeDescriptor getType() {
        return type;
    }

    /**
     * Returns the value of the slot <code>name</code>.
     * 
     * @param name the name of the slot
     * @return the slot value (may be <b>null</b> for undefined)
     * @throws VilException if there is no such slot defined
     */
    public Object getSlotValue(String name) throws VilException {
        checkSlot(name);
        return slotValues.get(name); // undefined if null
    }
    
    /**
     * Checks whether there is a slot with given <code>name</code>.
     * 
     * @param name the name of the slot
     * @return the slot
     * @throws VilException if there is no such slot
     */
    private FieldDescriptor checkSlot(String name) throws VilException {
        FieldDescriptor field = null;
        CompoundTypeDescriptor iter = type;
        while (null != iter && null == field) {
            field = iter.getField(name);
            iter = iter.getRefines();
        }
        if (null == field) {
            throw new VilException("Slot '" + name + "' is not defined for type " + type.getVilName(), 
                VilException.ID_NOT_FOUND);
        }
        return field;
    }

    /**
     * Changes the value of slot <code>name</code>.
     * 
     * @param name the name of the slot
     * @param value the value
     * @throws VilException if there is no such slot defined
     */
    public void setSlotValue(String name, Object value) throws VilException {
        FieldDescriptor field = checkSlot(name);
        slotValues.put(name, RuntimeEnvironment.checkType(field.getName(), field.getType(), 
            value, type.getTypeRegistry(), null));
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        // just take the Map output
        return StringValueHelper.getStringValue(slotValues, comparator);
    }
    
}
