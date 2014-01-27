package de.uni_hildesheim.sse.model.varModel.values;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * ContainerValue class.
 * 
 * @author Marcel Lueder
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class ContainerValue extends StructuredValue implements Cloneable {
    
    private List<Value> nestedElements = new ArrayList<Value>();

    /**
     * Constructor for a new ContainerValue.
     * @param container the container which extends this ContainerValue
     * @param value the value(s) to be assigned to this container
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    ContainerValue(Container container, Object... value) throws ValueDoesNotMatchTypeException {
        this(container);
        // Check whether this is a SetValue and the given values contain duplicates.
        if (duplicateValues(value)) {
            throw new ValueDoesNotMatchTypeException("Duplicates are not allowed for a Set.",
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
    
    /**
     * Getter for the value. Do not use! This value instance has substructures 
     * and does not hold a single value. Use {@link #getElement(int)} instead.
     * 
     * @return null always
     */
    @Override
    public Object getValue() {
        StringBuffer str = new StringBuffer();
        str.append("{");
        for (int i = 0; i < nestedElements.size() - 1; i++) {
            str.append(getElement(i).getValue());
            str.append(", ");
        }
        if (!nestedElements.isEmpty()) {
            str.append(getElement(nestedElements.size() - 1).getValue());
        }
        str.append("}");
        return str.toString();
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
    
    /**
     * {@inheritDoc}
     */
    public Value clone() {
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
        boolean dupplicatesFound = false;
        if (isSetValue() && null != values) {
            for (int i = 0; !dupplicatesFound && i < values.length - 1; i++) {
                if (null != values[i]) {
                    for (int j = i + 1; !dupplicatesFound && j < values.length; j++) {
                        if (values[i].equals(values[j])) {
                            dupplicatesFound = true;
                        }
                    }
                }
            }
        }
        
        return dupplicatesFound;
    }
    
    /**
     * Sets the value for an already existent nested value.
     * @param index The index of the element to be configured.
     * @param nestedValue The new value of the nested element.
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this Value
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= {@link #getElementSize()}</tt>)
     */
    public void setValue(int index, Value nestedValue) {
        if (index >= nestedElements.size()) {
            nestedElements.add(nestedValue);
        } else {
            nestedElements.set(index, nestedValue);
        }
    }
}
