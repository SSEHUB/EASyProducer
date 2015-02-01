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
package de.uni_hildesheim.sse.model.varModel.values;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IDecisionVariableContainer;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * CompoundValue class.
 * @author Marcel Lueder
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class CompoundValue extends StructuredValue implements Cloneable {

    /**
     * Denotes an internal compound slot name during initialization which 
     * specifies the actual type of the compound (in case of container initializations
     * defined on a refined compound).
     */
    public static final String SPECIAL_SLOT_NAME_TYPE = ".";
    
    private HashMap<String, Value> nestedElements;
    
    /**
     * Constructor for a new CompoundValue.
     * @param compound compound which extends this CompoundValue
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     */
    CompoundValue(Compound compound) throws ValueDoesNotMatchTypeException {
        this(compound, (Object[]) null);        
    }

    /**
     * Constructor for a new CompoundValue.
     * @param compound compound which extends this CompoundValue
     * @param value initial value(s), two entries for each compound given as name and value
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     */
    CompoundValue(Compound compound, Object... value) throws ValueDoesNotMatchTypeException {
        super(compound);
        if (compound.isAbstract()) {
            throw new ValueDoesNotMatchTypeException("cannot assign value as '" + compound.getName() + "' is abstract",
                ValueDoesNotMatchTypeException.IS_ABSTRACT);
        }
        nestedElements = new HashMap<String, Value>();
        if (null != value && value.length % 2 != 0) {
            throw new ValueDoesNotMatchTypeException("amount of slot names and values does not match", 
                this, ValueDoesNotMatchTypeException.SLOT_MISMATCH);
        }
        Map<String, Object> initialValues = new HashMap<String, Object>();
        if (null != value) {
            for (int v = 0; v < value.length; v += 2) {
                String slotName = value[v].toString();
                if (!slotName.equals(SPECIAL_SLOT_NAME_TYPE)) {
                    initialValues.put(slotName, value[v + 1]);
                }
            }
        }
        initialize(compound, initialValues);
        for (int a = 0; a < compound.getAssignmentCount(); a++) {
            initializeAttributeAssignment(compound.getAssignment(a), initialValues);
        }
    }

    /**
     * Creates a new compound value by copying the values from <code>source</code>.
     * 
     * @param compound the compound type
     * @param source the value which acts as a source for data
     */
    protected CompoundValue(Compound compound, CompoundValue source) {
        super(compound);
        nestedElements = new HashMap<String, Value>();
        try {
            copyValuesFrom(source);
        } catch (ValueDoesNotMatchTypeException e) {
            // should not happen
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Initializes an attribute assignment.
     * 
     * @param assng the assignment to initialize
     * @param initialValues the initial values
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     */
    private void initializeAttributeAssignment(AttributeAssignment assng, Map<String, Object> initialValues) 
        throws ValueDoesNotMatchTypeException {
        initialize(assng, initialValues);
        for (int a = 0; a < assng.getAssignmentCount(); a++) {
            initializeAttributeAssignment(assng.getAssignment(a), initialValues);
        }
    }

    /**
     * Initializes a variable container.
     * 
     * @param container the variable container
     * @param initialValues the initial values
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     */
    private void initialize(IDecisionVariableContainer container, Map<String, Object> initialValues) 
        throws ValueDoesNotMatchTypeException {
        
        boolean isCompound = container instanceof Compound;
        Compound cmpContainer = null;
        if (isCompound) {
            cmpContainer = (Compound) container;
        }
        
        int elementCount = isCompound ? cmpContainer.getInheritedElementCount() : container.getElementCount();
        for (int i = 0; i < elementCount; i++) {
            DecisionVariableDeclaration decl = isCompound ? cmpContainer.getInheritedElement(i)
                : container.getElement(i);
            IDatatype type = decl.getType();
            String name = decl.getName();
            Object oVal = initialValues.get(name); //objectValue
            Object[] slotVals;
            // complicated but one cannot just pass oVal into createValue
            // arbitrary arrays are created in case that oVal = null
            boolean done = false;
            if (null == oVal) {
                slotVals = new Object[1];
                slotVals = null;
            } else {
                if (oVal.getClass().isArray()) {
                    slotVals = (Object[]) oVal;
                } else {
                    if (oVal instanceof ConstraintSyntaxTree) {
                        configureValue(name, oVal);
                        slotVals = null;
                        done = true;
                    } else if (oVal instanceof Value) {
                        //Creates a CST
                        configureValue(name, oVal);
                        slotVals = null;
                        done = true;
                    } else {
                        slotVals = new Object[1];
                        slotVals[0] = oVal;
                    }
                }
            }
            if (!done) {
                try {
                    //nestedElements.put(name, ValueFactory.createValue(type, slotVals));
                    if (null != slotVals) {
                        nestedElements.put(name, ValueFactory.createValue(type, slotVals));
                    } else {
                        nestedElements.put(name, null);
                    }
                } catch (ValueDoesNotMatchTypeException vdnmte) {
                    if (null != slotVals) {
                        throw vdnmte;
                    }
                }
            }
        }
    }

    /**
     * Returns the actual type if stored as {@link #SPECIAL_SLOT_NAME_TYPE}
     * parameter in the given array.
     * 
     * @param slotValues the slot values, may be <b>null</b>
     * @return the actual type or <b>null</b>
     */
    public static final IDatatype getActualType(Object[] slotValues) {
        IDatatype result = null;
        if (null != slotValues && slotValues.length % 2 == 0) {
            for (int s = 0; s < slotValues.length; s = s + 2) {
                if (slotValues[s].toString().equals(SPECIAL_SLOT_NAME_TYPE)) {
                    if (slotValues[s + 1] instanceof IDatatype) {
                        result = (IDatatype) slotValues[s + 1];
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the value for the variable with the given name.
     * @param name the name of the variable.
     * @return the value to which the specified name is mapped,
     * or <b>null</b> if this Compound contains no variable with the specified name 
     */
    public Value getNestedValue(String name) {
        return nestedElements.get(name);
    }

    @Override
    public Object getValue() {
        // following the constructor and ValueFactory convention
        // null would prevent subsequent value initialization
        int size = 2 + (null != nestedElements ? 2 * nestedElements.size() : 0);
        Object[] result = new Object[size];
        
        int pos = 0;
        result[pos++] = SPECIAL_SLOT_NAME_TYPE;
        result[pos++] = getType();
        for (Map.Entry<String, Value> ent : nestedElements.entrySet()) {
            result[pos++] = ent.getKey();
            result[pos++] = ent.getValue();
        }
        return result;
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitCompoundValue(this);
    }

    /**
     * Method to get the object which a specific name of the hashMap.
     * @param name the key for the hashMap
     * @param value the value, which should be assigned to the key-object.
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    public void configureValue(String name, Object value) throws ValueDoesNotMatchTypeException {
        if (null != value) {
            DecisionVariableDeclaration field = ((Compound) getType()).getElement(name);
            if (null != field) {
                Value newValue;
                if (value instanceof Value) {
                    newValue = (Value) value;
                    if (!field.getType().isAssignableFrom(newValue.getType())) {
                        throw new ValueDoesNotMatchTypeException(newValue.getValue(), 
                            field.getName(), 
                            ValueDoesNotMatchTypeException.TYPE_MISMATCH);
                    }
                    Value oldValue = getNestedValue(name);
                    if (oldValue != null && oldValue instanceof CompoundValue) {
                        ((CompoundValue) oldValue).copyValuesFrom((CompoundValue) newValue);
                        newValue = oldValue;
                    }
                } else if (value.getClass().isArray()) {
                    newValue = ValueFactory.createValue(field.getType(), (Object[]) value);
                } else {
                    newValue = ValueFactory.createValue(field.getType(), value);
                }
                nestedElements.put(name, newValue);
            } else {
                throw new ValueDoesNotMatchTypeException("field " + name + " does not exist", 
                    ValueDoesNotMatchTypeException.SLOT_MISMATCH);
            }
        }
    }

    /**
     * Copies the values from <code>source</code>.
     * 
     * @param source the source type
     * @throws ValueDoesNotMatchTypeException in case that values do not match
     */
    public void copyValuesFrom(CompoundValue source) throws ValueDoesNotMatchTypeException {
        Compound sourceType = (Compound) source.getType();
        Compound myType = (Compound) getType();
        if (sourceType.isAssignableFrom(myType)) {
            for (int i = 0; i < myType.getInheritedElementCount(); i++) {
                DecisionVariableDeclaration decl = myType.getInheritedElement(i);
                String name = decl.getName();
                /*
                 * Avoid deletion of already configured nested values.
                 * This is needed for the stepwise configuration of
                 * (nested) CompoundValues.
                 */
                Value oldValue = nestedElements.get(name);
                Value newValue = source.getNestedValue(name);
                if (!(oldValue != null && newValue == null)) {
                    nestedElements.put(name, source.getNestedValue(name));
                }
            }
        } else {
            throw new ValueDoesNotMatchTypeException("compounds '"
                + sourceType.getName() + "' cannot be assigned to '" 
                + myType.getName() + "'", this, ValueDoesNotMatchTypeException.TYPE_MISMATCH);
        }
    }

    
    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof CompoundValue) {
            // this realizes copy semantics among assignable types
            // as this assignment is not a reference!!!
            copyValuesFrom((CompoundValue) value);
        } else if (null == value) {
            nestedElements.clear();
        } else if (null != value) {
            throw new ValueDoesNotMatchTypeException("<not implemented>", this, 
                ValueDoesNotMatchTypeException.INTERNAL);
        }
    }

    @Override
    public boolean isFullyConfigured() {
        // all required slots are created in the constructor
        boolean fullyConfigured = true;
        
        Iterator<Value> valueIterator = nestedElements.values().iterator();
        while (valueIterator.hasNext() && fullyConfigured) {
            Value nestedValue = valueIterator.next();
            fullyConfigured = (null != nestedValue) && (nestedValue.isConfigured());
        }
        
        return fullyConfigured;
    }
    
    @Override
    public Value clone() {
        CompoundValue clonedValue = null;
        clonedValue = (CompoundValue) super.clone();
        clonedValue.nestedElements = new HashMap<String, Value>();
        for (Map.Entry<String, Value> item : nestedElements.entrySet()) {
            String slotname = item.getKey();
            Value clonedNestedValue = null;
            if (!(item.getValue() == null)) {
                clonedNestedValue = item.getValue().clone();
            }
            clonedValue.nestedElements.put(slotname, clonedNestedValue);
        }
        return clonedValue;
    }

    @Override
    public String toString() {
        return nestedElements.toString(); // TODO consider + " : " + getType().toString(); from Value superclass
    }
    
    @Override
    public int hashCode() {
        int result = getType().getName().hashCode();
        Compound type = (Compound) getType(); // by construction
        while (null != type) {
            for (int s = 0; s < type.getElementCount(); s++) {
                String slotName = type.getElement(s).getName();
                Value myValue = getNestedValue(slotName);
                if (null != myValue) {
                    result += myValue.hashCode();
                }
            }        
            type = type.getRefines();
        }
        return result;
    }
    
    @Override
    public boolean equals(Object object) {
        return equals(object, false);
    }
    
    /**
     * Checks for equality potentially ignoring undefined values in the given <code>object</code>.
     * 
     * @param object the object to check for
     * @param ignoreUndefinedInObject whether undefined values in <code>object</code> shall be ignored 
     *   (partial equality)
     * @return <code>true</code> if <code>object</code> is considered equal to <b>this</b>, <code>false</code> else
     */
    private boolean equals(Object object, boolean ignoreUndefinedInObject) {
        boolean equals = false;
        Compound type = (Compound) getType(); // by construction
        if (object instanceof CompoundValue ) {
            CompoundValue oCompound = (CompoundValue) object;
            IDatatype oType = oCompound.getType(); 
            if (type.isAssignableFrom(oType) && oType.isAssignableFrom(type)) {
                CompoundValue otherValue = (CompoundValue) object;
                equals = true;
                while (equals && null != type) {
                    for (int s = 0; equals && s < type.getElementCount(); s++) {
                        String slotName = type.getElement(s).getName();
                        Value oValue = otherValue.getNestedValue(slotName);
                        if (!ignoreUndefinedInObject || (ignoreUndefinedInObject && null != oValue)) {
                            Value myValue = getNestedValue(slotName);
                            if (null == myValue) {
                                equals = (null == oValue);
                            } else {
                                equals = myValue.equals(oValue);
                            }
                        }
                    }
                    type = type.getRefines();
                }
            }
        }
        return equals;
    }

    
    @Override
    public boolean equalsPartially(Value value) {
        return equals(value, true);
    }
        
}