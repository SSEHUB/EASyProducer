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
package net.ssehub.easy.varModel.model.values;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * ContainerValue class.
 * 
 * @author Marcel Lueder
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class ContainerValue extends StructuredValue implements Cloneable {

    // TODO add, set do not check for duplicates in case of sets!
    // TODO duplicate check works with equals of slots for compound values... correct???
    
    private List<Value> nestedElements = new ArrayList<Value>();

    /**
     * Constructor for a new ContainerValue.
     * @param container the container which extends this ContainerValue
     * @param value the value(s) to be assigned to this container
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    ContainerValue(Container container, Object... value) throws ValueDoesNotMatchTypeException {
        this(container, true, value);
    }

    /**
     * Constructor for a new ContainerValue.
     * @param container the container which extends this ContainerValue
     * @param check for duplicates
     * @param value the value(s) to be assigned to this container
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    public ContainerValue(Container container, boolean check, Object... value) throws ValueDoesNotMatchTypeException {
        this(container);
        // Check whether this is a SetValue and the given values contain duplicates.
        if (check && duplicateValues(value)) {
            throw new ValueDoesNotMatchTypeException("Duplicates in '" 
                + Arrays.toString(value) + "' are not allowed for a Set.",
                ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE);
        }
        
        //Loop to properly add all nested elements
        for (int i = 0; null != value && i < value.length; i++) {
            if (null != value[i]) {
//                if (!value[i].getClass().isArray()) {
//                    if (value[i] instanceof ConstraintSyntaxTree) {
//                        ConstraintSyntaxTree tree = (ConstraintSyntaxTree) value[i];
//                        try {
//                            IDatatype treeType = tree.inferDatatype();
//                            if (!container.getContainedType().isAssignableFrom(treeType)) {
//                                throw new ValueDoesNotMatchTypeException(treeType.getName(), 
//                                    container.getContainedType().getName(), 
//                                    ValueDoesNotMatchTypeException.TYPE_MISMATCH);
//                            }
//                        } catch (CSTSemanticException e) {
//                            // for the moment
//                        }
//                        nestedElements.add(tree);
//                } else 
                if (value[i] instanceof Value) {
                    Value v = (Value) value[i];
                    if (!container.getContainedType().isAssignableFrom(v.getType())) {
                        throw new ValueDoesNotMatchTypeException(v.getValue(), 
                            container.getContainedType().getName(), 
                            ValueDoesNotMatchTypeException.TYPE_MISMATCH);
                    }
                    nestedElements.add(v);
                }  else {
                    if (value[i].getClass().isArray()) {
                        nestedElements.add(ValueFactory.createValue(container.getContainedType(), (Object[]) value[i]));
                    } else {
                        nestedElements.add(ValueFactory.createValue(container.getContainedType(), value[i]));
                    }
                }
//                } else {
//                    Object[] tmp = (Object[]) value[i]; // urgent!
//                    IDatatype contained = container.getContainedType(); 
//                    if (Compound.TYPE.isAssignableFrom(contained)) {
//                        IDatatype tmpContained = CompoundValue.getActualType(tmp);
//                        if (null != tmpContained) {
//                            contained = tmpContained;
//                        }
//                    }
//                    nestedElements.add(new ConstantValue(ValueFactory.createValue(contained, tmp)));
//                }
            }
        }
    }

    /**
     * Creates a new compound value by copying the values from <code>source</code>.
     * 
     * @param container the container type
     * @param source the value which acts as a source for data
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected ContainerValue(Container container, ContainerValue source) throws ValueDoesNotMatchTypeException {
        this(container);
        copyValuesFrom(source);
    }

    
    /**
     * Constructor for a new ContainerValue.
     * @param container the container which extends this ContainerValue
     */
    ContainerValue(Container container) {
        super(container);
    }

    @Override
    public IDatatype getContainedType() {
        IDatatype type = getType();
        if (1 == type.getGenericTypeCount()) {
            type = type.getGenericType(0);
        } else {
            type = null;
        }
        return type;
    }
    
    /**
     * Getter for the value. Do not use! This value instance has substructures 
     * and does not hold a single value. Use {@link #getElement(int)} instead.
     * 
     * @return null always
     */
    @Override
    public Object getValue() {
        Object[] result = null;
        if (null != nestedElements) {
            result = new Object[nestedElements.size()];
            nestedElements.toArray(result);
        }
        return result;
        
        // nestedValuesToString() was here before
        // sorry (including me) ... the value of a container cannot be a String. 
        // This is nonsense as it prevents further value instantiation
    }
    
    /**
     * Turns the nested values into a string.
     * 
     * @return the nested values as string
     */
    public String nestedValuesToString() {
        StringBuffer str = new StringBuffer();
        str.append("{");
        for (int i = 0; i < nestedElements.size() - 1; i++) {
            str.append(getElement(i));
            str.append(", ");
        }
        if (!nestedElements.isEmpty()) {
            str.append(getElement(nestedElements.size() - 1));
        }
        str.append("}");
        return str.toString();
    }
    
    @Override
    public String toString() {
        return nestedValuesToString() + " : " + getType().toString();
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitContainerValue(this);
    }
    
    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof ContainerValue) {
            // this realizes copy semantics among assignable types
            // as this assignment is not a reference!!!
            
            // TODO: Check - this is not setting but adding values!!!
            copyValuesFrom((ContainerValue) value);
        } else if (null == value) {
            nestedElements.clear();
        } else if (null != value) {
            throw new ValueDoesNotMatchTypeException("<not implemented>", this, 
                ValueDoesNotMatchTypeException.INTERNAL);
        }
    }

    @Override
    public boolean isFullyConfigured() {
        boolean fullyConfigured = true;
        
        //Check whether all containing elements are configured.
        for (int i = 0; fullyConfigured && i < nestedElements.size(); i++) {
            if (null != nestedElements.get(i)) {
                fullyConfigured = nestedElements.get(i).isConfigured();
//                if (nestedElements.get(i) instanceof ConstantValue) {
//                    Value val = ((ConstantValue) nestedElements.get(i)).getConstantValue();
//                    fullyConfigured = val.isConfigured();
//                } // we cannot say anything about the other elements
            }
        }
        
        return fullyConfigured;
    }

    /**
     * Copies the values from <code>source</code>.
     * 
     * @param source the source type
     * @throws ValueDoesNotMatchTypeException in case that values do not match
     */
    public void copyValuesFrom(ContainerValue source) throws ValueDoesNotMatchTypeException {

        if (isSetValue()) {
            // Check whether no value will be included twice
            for (int i = 0; i < source.getElementSize(); i++) {
                if (nestedElements.contains(source.getElement(i))) {
                    StringBuffer message = new StringBuffer("Duplicate value for ");
                    message.append(getType().getName());
                    message.append(": ");
                    message.append(StringProvider.toIvmlString(source.getElement(i)));
                    throw new ValueDoesNotMatchTypeException(message.toString(),
                        ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE);
                }
            }
        }
        
        for (int i = 0; i < source.getElementSize(); i++) {
            nestedElements.add(source.getElement(i));
        }
        
    }
    
    @Override
    public ContainerValue clone() {
        ContainerValue clonedValue = (ContainerValue) super.clone();
        clonedValue.nestedElements = new ArrayList<Value>();
        for (int i = 0; i < nestedElements.size(); i++) {
            Value clonedNestedValue = nestedElements.get(i).clone();
            clonedValue.nestedElements.add(clonedNestedValue);
        }
        return clonedValue;
    }
    
    /**
     * Returns the number of elements in this container.
     * 
     * @return the number of elements
     */
    public int getElementSize() {
        return nestedElements.size();
    }
    
    /**
     * Returns the specified element.
     * 
     * @param index the index of the element to be returned
     * @return the specified element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getElementSize()}</code>
     */
    public Value getElement(int index) {
        return nestedElements.get(index);
    }

    /**
     * Returns the (first) index of the specified (nested) value.
     *  
     * @param value the value to search for
     * @return the first index of <code>value</code> or <code>-1</code> if not found
     */
    public int indexOf(Value value) {
        return nestedElements.indexOf(value);
    }

    /**
     * Checks whether this value belongs to a {@link Set} or an <tt>Sequence</tt>.
     * @return <tt>true</tt> if this value belongs to a {@link Set}, otherwise <tt>false</tt>.
     */
    private boolean isSetValue() {
        return Set.TYPE.isAssignableFrom(getType());
    }
    
    /**
     * Checks whether the given array has duplicated values and this value belongs to a set.
     * @param values The values, which shall be assigned to this ContainerValue.
     * @return <tt>true</tt> if this value belongs to a set and the value array contains duplicates,
     * otherwise <tt>false</tt>.
     */
    private boolean duplicateValues(Object[] values) {
        boolean duplicatesFound = false;
        if (isSetValue() && null != values) {
            // TODO improve - quadratic runtime complexity
            for (int i = 0; !duplicatesFound && i < values.length - 1; i++) {
                if (null != values[i]) {
                    for (int j = i + 1; !duplicatesFound && j < values.length; j++) {
                        if (values[i].equals(values[j])) {
                            // for Compound/Container -> breaks in ScaleLog
                            if (!(values[i] instanceof CompoundValue) && !(values[i] instanceof ContainerValue) ) {
                                duplicatesFound = true;
                            }
                        }
                    }
                }
            }
        }
        
        return duplicatesFound;
    }
    
    /**
     * Sets the value for an already existent nested value.
     * @param index The index of the element to be configured.
     * @param nestedValue The new value of the nested element.
     * @throws ValueDoesNotMatchTypeException IF this {@link ContainerValue} represents a value of a {@link Set}
     *     and the new <tt>nestedValue</tt> is already part of this value.
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this Value
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= {@link #getElementSize()}</tt>)
     */
    public void setValue(int index, Value nestedValue) throws ValueDoesNotMatchTypeException {    
        if (index >= nestedElements.size()) {
            // Add new value
            if (isSetValue() && null != nestedValue) {
                boolean duplicateFound = false;
                for (int i = 0; i < nestedElements.size() && !duplicateFound; i++) {
                    if (nestedValue.equals(nestedElements.get(i))) {
                        throw new ValueDoesNotMatchTypeException("'" + nestedValue.getValue().toString()
                            + "' already contained and duplicates are not allowed for a Sets.",
                            ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE);
                    }
                }
            }
            nestedElements.add(nestedValue);
        } else {
            // Replace existing Value            
            if (isSetValue() && null != nestedValue) {
                boolean duplicateFound = false;
                for (int i = 0; i < nestedElements.size() && !duplicateFound; i++) {
                    if (i != index && nestedValue.equals(nestedElements.get(i))) {
                        throw new ValueDoesNotMatchTypeException("'" + nestedValue.getValue().toString()
                            + "' already contained and duplicates are not allowed for a Sets.",
                            ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE);
                    }
                }
            }
            nestedElements.set(index, nestedValue);
        }
    }

    @Override
    public int hashCode() {
        int result;
        if (Sequence.TYPE.isAssignableFrom(getType())) {
            // corresponds to AbstractList
            result = nestedElements.hashCode();
        } else {
            result = 0;
            // corresponds to AbstractSet
            for (int i = 0; i < nestedElements.size(); i++) {
                Value val = nestedElements.get(i);
                if (null != val) {
                    result += val.hashCode();
                }
            }
        }
        return result;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean equals = false;
        if (other instanceof ContainerValue) {
            ContainerValue oContainer = (ContainerValue) other;
            if (getType().isAssignableFrom(oContainer.getType())) { 
                int opSize = getElementSize();
                if (opSize == oContainer.getElementSize()) {
                    equals = true;
                    if (Sequence.TYPE.isAssignableFrom(getType())) {
                        // corresponds to AbstractList
                        equals = nestedElements.equals(oContainer.nestedElements);
                    } else {
                        // corresponds to AbstractSet
                        HashSet<Value> tmp = new HashSet<Value>();
                        doAll(tmp, true);
                        oContainer.doAll(tmp, false);
                        equals = tmp.isEmpty();
                    }
                } 
            }
        } 
        return equals;
    }

    /**
     * Adds/removes all elements to/from <code>set</code>.
     * 
     * @param set the set to add/remove
     * @param add add (<code>true</code>) or remove (<code>false</code>)
     */
    private void doAll(HashSet<Value> set, boolean add) {
        int size = getElementSize();
        for (int e = 0; e < size; e++) {
            Value value = getElement(e);
            if (null != value) {
                if (add) {
                    set.add(value);
                } else {
                    set.remove(value);
                }
            }
        }
    }

    /**
     * Adds a <code>value</code> at the position <code>pos</code>.
     * 
     * @param pos the position after which <code>value</code> shall be added
     * @param value the value to be added
     * @throws ValueDoesNotMatchTypeException in case that the type of <code>value</code>
     *   does not match the container type of the containers or that index shall be applied to a set
     * @throws IndexOutOfBoundsException in case that pos is invalid
     */
    public void addElement(int pos, Value value) throws ValueDoesNotMatchTypeException {
        if (isSetValue()) {
            throw new ValueDoesNotMatchTypeException("no index access for sets", 
                ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE);
        }
        checkContainedType(value);
        nestedElements.add(pos, value);
    }

    /**
     * Checks whether <code>value</code> is type compliant with the {@link #getContainedType()}.
     * 
     * @param value the value to check for
     * @throws ValueDoesNotMatchTypeException in case that the type of <code>value</code>
     *   does not match the container type of the containers
     */
    private void checkContainedType(Value value) throws ValueDoesNotMatchTypeException {
        if (!getContainedType().isAssignableFrom(value.getType())) {
            throw new ValueDoesNotMatchTypeException("cannot assign value of type '" 
                + IvmlDatatypeVisitor.getQualifiedType(value.getType()) + "' to '"
                + IvmlDatatypeVisitor.getQualifiedType(getContainedType()) + "'", 
                ValueDoesNotMatchTypeException.TYPE_MISMATCH);
        }
    }
    
    /**
     * Adds an element to this container. Shall only be called during dynamic execution.
     * 
     * @param value the value to be added
     * @throws ValueDoesNotMatchTypeException in case that the type of <code>value</code>
     *   does not match the container type of the containers
     */
    public void addElement(Value value) throws ValueDoesNotMatchTypeException {
        checkContainedType(value);
        boolean add = true;
        if (isSetValue()) {
            // a set would be faster!
            add = !nestedElements.contains(value);
        }
        if (add) {
            nestedElements.add(value);
        }
    }
    
    /**
     * Removes a value from this container.
     * 
     * @param value the value to be removed
     */
    public void removeElement(Value value) {
        nestedElements.remove(value);
    }

    /**
     * Removes a value from this container.
     * 
     * @param index the index position of the value to be removed
     * @throws IndexOutOfBoundsException in case that the index is illegal
     */
    public void removeElement(int index) {
        nestedElements.remove(index);
    }

    @Override
    public boolean equalsPartially(Value value) {
        return equals(value); // meta type value is symmetric as a new value must provide all values
    }
    
    /**
     * Clears all elements.
     */
    public void clear() {
        nestedElements.clear(); 
    }
    
    /**
     * Returns an iterator over all values.
     * 
     * @return the iterator
     */
    public Iterator<Value> iterator() {
        return nestedElements.iterator();
    }

}
