package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Represents an actual VIL type, its meta information, fields and operations.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the specific VilType or Artifact
 */
public abstract class TypeDescriptor <T> implements IMetaType {

    public static final TypeDescriptor<?>[] EMPTY = null;
    
    private String name;
    private String qualifiedName;
    private OperationDescriptor[] operations;
    private FieldDescriptor[] fields;
    private OperationDescriptor[] conversions;
    private TypeDescriptor<?>[] parameter;

    // reminder: AliasTypeDescriptor must take over / mock some values

    /**
     * Creates a new type descriptor. Overridden constructors shall call {@link #setOperations(java.util.Collection)}, 
     * {@link #setFields(java.util.Collection)} or {@link #setConversions(java.util.Collection)}.
     * 
     * @param parameter type parameter (may be <b>null</b>)
     * @throws VilException if initialization fails for some reason
     */
    protected TypeDescriptor(TypeDescriptor<?>... parameter) throws VilException {
        this.parameter = parameter;
    }
    
    /**
     * Returns whether this descriptor was initialized.
     * 
     * @return <code>true</code> if it was initialized, <code>false</code> else
     */
    protected boolean isInitialized() {
        return null != operations;
    }
    
    /**
     * Defines the name of this descriptor explicitly.
     * 
     * @param name the name of this descriptor (may be qualified by :: and is split internally)
     */
    protected void setName(String name) {
        if (null == name) {
            this.name = null;
            this.qualifiedName = null;
        } else {
            int pos = name.lastIndexOf("::");
            if (pos > 0 && pos < name.length() - 2) {
                this.name = name.substring(pos + 2);
                this.qualifiedName = name;
            } else {
                this.name = name;
                this.qualifiedName = name;
            }
        }
    }
    
    /**
     * Returns whether the name of this type descriptor (single or qualified) has yet been set.
     * 
     * @return <b>true</b> if the name has been set, <code>false</code> else
     */
    protected boolean isNameSet() {
        return null != qualifiedName || null != name;
    }

    /**
     * Defines the operations for this type.
     *  
     * @param operations the operations (may be <b>null</b>)
     */
    protected void setOperations(java.util.Collection<OperationDescriptor> operations) {
        if (null == operations) {
            this.operations = new OperationDescriptor[0];
        } else {
            this.operations = new OperationDescriptor[operations.size()];
            operations.toArray(this.operations);
        }
    }

    /**
     * Defines the fields for this type.
     *  
     * @param fields the fields (may be <b>null</b>)
     */
    protected void setFields(java.util.Collection<FieldDescriptor> fields) {
        if (null == fields) {
            this.fields = new FieldDescriptor[0];
        } else {
            this.fields = new FieldDescriptor[fields.size()];
            fields.toArray(this.fields);
        }
    }
    
    /**
     * Changes the fields.
     * 
     * @param fields the new fields
     */
    protected void setFields(FieldDescriptor[] fields) {
        this.fields = fields;
    }
    
    /**
     * Returns whether so far no fields have been defined at all.
     * 
     * @return <code>true</code> for no fields, <code>false</code> else
     */
    protected boolean isFieldsNull() {
        return this.fields == null;
    }
    
    /**
     * Adds an operation.
     * 
     * @param operation the operation to be added
     */
    protected void addOperation(OperationDescriptor operation) {
        // adding operations was not intended and is typically only used by fake types
        int opLen = null == operations ? 0 : operations.length;
        OperationDescriptor[] tmp = new OperationDescriptor[opLen + 1];
        if (null != operations) {
            System.arraycopy(operations, 0, tmp, 0, operations.length);
        }
        tmp[opLen] = operation;
        operations = tmp;
    }
    
    /**
     * Defines the conversions for this type.
     * 
     * @param conversions the conversions (may be <b>null</b>)
     */
    protected void setConversions(java.util.Collection<OperationDescriptor> conversions) {
        if (null == conversions) {
            this.conversions = new OperationDescriptor[0];
        } else {
            this.conversions = new OperationDescriptor[conversions.size()];
            conversions.toArray(this.conversions);
        }
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getQualifiedName() {
        return qualifiedName;
    }
    
    @Override
    public boolean enableDynamicDispatch() {
        return true;
    }
    
    /**
     * Returns the class of the described VIL type. Please use this
     * method sparingly as the required functionality is provided by
     * this class.
     * 
     * @return the class
     */
    public abstract Class<T> getTypeClass();
    
    /**
     * Returns whether {@link #create(Object...)} will return an instance.
     * 
     * @return <code>true</code> if this type can be instantiated from VIL/VTL, <code>false</code> else
     */
    public abstract boolean canBeInstantiated();
    
    /**
     * Creates an instance of the type according to the given parameters. 
     * 
     * @param params the parameters
     * @return the created instance
     * @throws VilException in case that the creation does not work
     */
    public abstract T create(Object...params) throws VilException;

    /**
     * Returns the available fields.
     * 
     * @return the available fields
     */
    public Iterable<FieldDescriptor> getFields() {
        return new ArrayIterable<FieldDescriptor>(fields);
    }
    
    /**
     * Returns the available operations.
     * 
     * @return the available operations
     */
    public Iterable<OperationDescriptor> getOperations() {
        return new ArrayIterable<OperationDescriptor>(operations);
    }
    
    /**
     * Returns the available conversions.
     * 
     * @return the available conversion
     */
    public Iterable<OperationDescriptor> getConversions() {
        return new ArrayIterable<OperationDescriptor>(conversions);
    }
    
    @Override
    public int getOperationsCount() {
        return operations.length;
    }
    
    @Override
    public OperationDescriptor getOperation(int index) {
        return operations[index];
    }
    
    @Override
    public FieldDescriptor getField(int index) {
        if (null == fields) {
            throw new IndexOutOfBoundsException();
        }
        return fields[index];
    }
    
    /**
     * Returns the field descriptor with the specified name.
     * 
     * @param name the name of the field
     * @return the field descriptor (may be <b>null</b> if not found)
     */
    public FieldDescriptor getField(String name) {
        FieldDescriptor result = null;
        if (null != name) {
            int count = getFieldCount();
            // reverse due to refined slots
            for (int i = count - 1; null == result && i >= 0; i--) {
                FieldDescriptor tmp = getField(i);
                if (name.equals(tmp.getName())) {
                    result = tmp;
                }
            }
        }
        return result;
    }
    
    @Override
    public int getFieldCount() {
        return null == fields ? 0 : fields.length;
    }
    
    /**
     * Returns the number of conversions provided by this type descriptor.
     * 
     * @return the number of conversions, i.e., from this type to other types
     */
    public int getConversionsCount() {
        return conversions.length;
    }
    
    /**
     * Returns the specified conversion.
     * 
     * @param index the index of the conversion to be returned
     * @return the specified conversion
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index&gt;={@link #getConversionsCount()}</code>
     */
    public OperationDescriptor getConversion(int index) {
        return conversions[index];
    }
    
    /**
     * Returns whether this descriptor is the same or a super class of <code>desc</code>.
     * 
     * @param desc the descriptor to be tested
     * @return <code>true</code> if both descriptors are assignment compatible, <code>false</code> else
     */
    public abstract boolean isAssignableFrom(TypeDescriptor<?> desc);
    
    /**
     * Returns the most specific conversion operation from this type to target type (if there is any).
     * 
     * @param sourceType the source type to convert from
     * @param targetType the target type to convert to
     * @return the most specific conversion operation as defined in the underlying implementation class, 
     *   <b>null</b> if no matching can be found
     */
    public IMetaOperation findConversion(IMetaType sourceType, IMetaType targetType) {
        IMetaOperation result = null;
        for (int c = 0; null == result && c < conversions.length; c++) {
            IMetaOperation desc = conversions[c];  
            if (desc.getParameterType(0).isAssignableFrom(sourceType) 
                && (desc.getReturnType().isAssignableFrom(targetType) 
                    || targetType.isAssignableFrom(desc.getReturnType()))) { // needed for derived IVML types
                result = TypeHelper.getMoreSpecificParam1(desc, result);
            }
        }
        return result;
    }
    
    /**
     * Returns the most specific conversion operation from this type to target type considering
     * both types as declarators of the conversion operation (if there is any).
     * 
     * @param sourceType the source type to convert from
     * @param targetType the target type to convert to
     * @return the most specific conversion operation as defined in the underlying implementation class, 
     *   <b>null</b> if no matching can be found
     */
    public static final OperationDescriptor findConversionOnBoth(TypeDescriptor<?> sourceType, 
        TypeDescriptor<?> targetType) {
        OperationDescriptor c1 = targetType.findConversion(sourceType, targetType);
        OperationDescriptor c2 = sourceType.findConversion(sourceType, targetType);
        return TypeHelper.getMoreSpecificParam1(c1, c2);
    }
    
    /**
     * Returns the most specific conversion operation from this type to target type (if there is any).
     * 
     * @param sourceType the source type to convert from
     * @param targetType the target type to convert to
     * @return the most specific conversion operation as defined in the underlying implementation class, 
     *   <b>null</b> if no matching can be found
     */
    public OperationDescriptor findConversion(TypeDescriptor<?> sourceType, 
        TypeDescriptor<?> targetType) {
        return (OperationDescriptor) findConversion((IMetaType) sourceType, (IMetaType) targetType);
    }
    
    /**
     * Returns the first registered conversion operation from this type to a sequence.
     *   
     * @return the conversion operation or <b>null</b> if none was found
     */
    public OperationDescriptor getConversionToSequence() {
        OperationDescriptor result = null;
        for (int c = 0; null == result && c < conversions.length; c++) {
            OperationDescriptor desc = conversions[c];
            if (desc.getReturnType().isSequence() && isAssignableFrom(desc.getParameterType(0))) {
                result = desc;
            }
        }
        return result;
    }
    
    /**
     * Returns a textual representation of this descriptor (the Java signature).
     * 
     * @return the textual representation
     */
    @Override
    public String toString() {
        return getName();
    }
    
    /**
     * Returns the type parameters as array.
     * @return the type parameters as array, may be <b>null</b>
     */
    public TypeDescriptor<?>[] getGenericParameter() {
        TypeDescriptor<?>[] result;
        if (null == parameter) {
            result = null;
        } else {
            result = new TypeDescriptor<?>[parameter.length];
            System.arraycopy(parameter, 0, result, 0, parameter.length);
        }
        return result;
    }
    
    @Override
    public int getGenericParameterCount() {
        return null == parameter ? 0 : parameter.length;
    }
    
    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        return parameter[index];
    }

    /**
     * Creates an empty array of type descriptors.
     * 
     * @param length the length of the array to be created
     * @return the array instance
     */
    public static TypeDescriptor<?>[] createArray(int length) {
        return new TypeDescriptor[length];
    }
    
    /**
     * Appends the type parameters to <code>name</code>.
     * 
     * @param name the VIL name of this type
     * @param exclude the parameters from the end to exclude, <code>0</code> for none
     * @return the VIL name including parameter types if applicable
     */
    protected String appendParameter(String name, int exclude) {
        StringBuilder tmp = new StringBuilder(name);
        int count = getGenericParameterCount();
        if (count > 0) {
            tmp.append('(');
            for (int p = 0; p < count - exclude; p++) {
                if (p > 0) {
                    tmp.append(", ");
                }
                TypeDescriptor<?> param = getGenericParameterType(p);
                if (null == param) {
                    tmp.append("<null>"); // shall not happen
                } else {
                    tmp.append(param.getVilName());
                }
            }
            tmp.append(')');
        }
        return tmp.toString();
    }
    
    /**
     * Returns the name of this type in VIL notation.
     * 
     * @return the name of this type
     */
    public String getVilName() {
        return getName();
    }

    /**
     * Returns whether this descriptor represents a VIL map.
     * 
     * @return <code>true</code> if this is a VIL map, <code>false</code> else
     */
    public abstract boolean isMap();

    /**
     * Returns whether this descriptor represents an iterator.
     * 
     * @return <code>true</code> if this is an iterator, <code>false</code> else
     */
    public abstract boolean isIterator();
    
    /**
     * Returns whether this descriptor represents a VIL collection, i.e., set, sequence or collection.
     * 
     * @return <code>true</code> if this is a VIL collection, <code>false</code> else
     */
    public abstract boolean isCollection();

    /**
     * Returns whether this descriptor represents a VIL set.
     * 
     * @return <code>true</code> if this is a VIL set, <code>false</code> else
     */
    public abstract boolean isSet();

    /**
     * Returns whether this descriptor represents a VIL sequence.
     * 
     * @return <code>true</code> if this is a VIL sequence, <code>false</code> else
     */
    public abstract boolean isSequence();
    
    /**
     * Returns whether the given <code>object</code> is an instance of this descriptor.
     * 
     * @param object the object to be checked
     * @return <code>true</code> if it is an instance, <code>false</code> else
     */
    public abstract boolean isInstance(Object object);

    /**
     * Returns whether the given <code>object</code> of of the type of this descriptor.
     * 
     * @param object the object to be checked
     * @return <code>true</code> if <code>object</code> has the same type, <code>false</code> else
     */
    public abstract boolean isSameType(Object object);
    
    /**
     * Adds a placeholder operation, i.e., in case that the original operation cannot be resolved
     * but the script shall remain executable.
     * 
     * @param name the name of the operation
     * @param parameterCount the number of parameters of the operation
     * @param acceptsNamedParameters whether the operation accepts named parameters
     * @return the added operation, <b>null</b> if this type is not a {@link #isPlaceholder() placeholder}
     */
    public abstract OperationDescriptor addPlaceholderOperation(String name, int parameterCount, 
        boolean acceptsNamedParameters);

    /**
     * Returns whether this type is an instantiator.
     * 
     * @return <code>true</code> if it is an instantiator, <code>false</code> else
     */
    public abstract boolean isInstantiator();
    
    /**
     * Returns whether a given <code>object</code> is the same.
     * 
     * @param typeDescriptor the object to be checked
     * @return <code>true</code> if the object is the same, <code>false</code> else
     */
    public boolean isSame(TypeDescriptor<?> typeDescriptor) {
        return isAssignableFrom(typeDescriptor) && typeDescriptor.isAssignableFrom(this);
    }

    /**
     * Returns a flattened collection type if this type is a collection. If not, return <b>this</b>.
     * 
     * @return the flattened collection type or <b>this</b>
     * @throws VilException in case that the derivation of the type fails
     */
    public TypeDescriptor<?> flatten() throws VilException {
        TypeDescriptor<?> result;
        if (isSet()) {
            result = TypeRegistry.getSetType(flattenParam(this));
        } else if (isSequence()) {
            result = TypeRegistry.getSequenceType(flattenParam(this));
        } else if (isCollection()) {
            result = TypeRegistry.getCollectionType(flattenParam(this));
        } else {
            result = this; // usn
        }
        return result;
    }

    /**
     * Returns deepest nested non-collection parameter type of this type.
     * 
     * @return the nested non-collection type
     */
    public TypeDescriptor<?> flattenParam() {
        return flattenParam(this);
    }
    
    /**
     * Returns deepest nested non-collection parameter type.
     * 
     * @param type the type to return the parameter type for
     * @return the nested non-collection type
     */
    private TypeDescriptor<?> flattenParam(TypeDescriptor<?> type) {
        TypeDescriptor<?> result;
        if (type.getGenericParameterCount() > 0) {
            result = type.getGenericParameterType(0);
            if (result.isCollection()) {
                result = flattenParam(result);
            }
        } else {
            result = TypeRegistry.anyType();
        }
        return result;
    }
    
    /**
     * Returns a collection iterator operation with given <code>name</code>.
     * 
     * @param name the name of the operation to search for
     * @return the collection iterator operation or <b>null</b>
     */
    public OperationDescriptor findCollectionIteratorOperation(String name) {
        OperationDescriptor result = null;
        for (int o = 0; null == result && o < getOperationsCount(); o++) {
            OperationDescriptor tmp = getOperation(o);
            if (tmp.isIteratingCollectionOperation() && name.equals(tmp.getName())) {
                result = tmp;
            }
        }
        return result;
    }
    
    /**
     * Provides access to all instances of this type.
     * 
     * @return access to all instances (may be <b>null</b> if there are none)
     */
    public Set<?> allInstances() {
        return null;
    }
    
    /**
     * Returns the default value for this type, usually a neutral value or a constant value
     * to compare against.
     * 
     * @return the default value, <b>null</b> for none - may lead to an undefined operation execution
     */
    public Object getDefaultValue() {
        return null;
    }

    @Override
    public List<IMetaOperation> getCandidates(String name, int unnamedArgsCount) {
        return getCandidates(this, name, unnamedArgsCount);
    }
    
    /**
     * Returns the potential operation candidates for a given <code>name</code> and parameter numbers
     * on a specific <code>type</code>. This is the most basic implementation done by a linear search
     * on the available operations. An optimized version may/shall be realized via {@link #getCandidates(String, int)}.
     * 
     * @param type the type to be searched for
     * @param name the name of the operation call to be resolved
     * @param argCount the number of required arguments
     * @return <code>true</code> if <code>desc</code> is a candidate, <code>false</code> else
     */
    public static List<IMetaOperation> getCandidates(IMetaType type, String name, int argCount) {
        List<IMetaOperation> result = new ArrayList<IMetaOperation>(5); 
        for (int o = 0; o < type.getOperationsCount(); o++) {
            IMetaOperation op = type.getOperation(o);
            boolean ok;
            if (null != op && op.getName().equals(name)) {
                // in case of default parameters, the actual number of required params may be less than the given ones
                int reqParam = op.getRequiredParameterCount();
                if (argCount > 0) {
                    ok = reqParam > 0 && reqParam <= argCount && argCount <= op.getParameterCount();
                } else {
                    ok = reqParam == 0;
                }
            } else {
                ok = false;
            }
            if (ok) {
                result.add(op);
            }
        }
        return result;
    }

}
