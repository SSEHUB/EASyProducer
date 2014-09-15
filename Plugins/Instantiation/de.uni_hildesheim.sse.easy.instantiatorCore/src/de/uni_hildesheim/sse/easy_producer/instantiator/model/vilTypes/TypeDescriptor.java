package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * Represents an actual VIL type, its meta information and operations.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the specific VilType or Artifact
 */
public abstract class TypeDescriptor <T extends IVilType> implements IMetaType {

    private String name;
    private String qualifiedName;
    private OperationDescriptor[] operations;
    private OperationDescriptor[] conversions;
    private TypeDescriptor<? extends IVilType>[] parameter;

    /**
     * Creates a new type descriptor. Overridden constructors shall call {@link #setOperations(java.util.Collection)}
     * and {@link #setConversions(java.util.Collection)}.
     * 
     * @param parameter type parameter (may be <b>null</b>)
     * @throws VilException if analyzing the class fails for some reason
     */
    protected TypeDescriptor(TypeDescriptor<? extends IVilType>... parameter) throws VilException {
        this.parameter = parameter;
    }
    
    /**
     * Defines the name of this descriptor explicitly.
     * 
     * @param name the name of this descriptor
     */
    protected void setName(String name) { // TODO preliminary, needs introduction of qualified names in grammars
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
     * Adds an operation.
     * 
     * @param operation the operation to be added
     */
    protected void addOperation(OperationDescriptor operation) {
        // adding operations was not intended and is typically only used by fake types
        OperationDescriptor[] tmp = new OperationDescriptor[operations.length + 1];
        System.arraycopy(operations, 0, tmp, 0, operations.length);
        tmp[operations.length] = operation;
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
     * Returns the available operations.
     * 
     * @return the available operations
     */
    public Iterable<OperationDescriptor> getOperations() {
        return new ArrayIterable<OperationDescriptor>(operations);
    }
    
    /**
     * Returns the number of operations provided by this type descriptor.
     * 
     * @return the number of operations
     */
    public int getOperationsCount() {
        return operations.length;
    }
    
    /**
     * Returns the specified operation.
     * 
     * @param index the index of the operation to be returned
     * @return the specified operation
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index&gt;={@link #getOperationsCount()}</code>
     */
    public OperationDescriptor getOperation(int index) {
        return operations[index];
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
    public abstract boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc);
    
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
                && desc.getReturnType().isAssignableFrom(targetType)) {
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
    public static final OperationDescriptor findConversionOnBoth(TypeDescriptor<? extends IVilType> sourceType, 
        TypeDescriptor<? extends IVilType> targetType) {
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
    public OperationDescriptor findConversion(TypeDescriptor<? extends IVilType> sourceType, 
        TypeDescriptor<? extends IVilType> targetType) {
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
     * Returns the number of type parameters.
     * 
     * @return the number of type parameter
     */
    public int getParameterCount() {
        return null == parameter ? 0 : parameter.length;
    }
    
    /**
     * Returns the specified parameter type.
     * 
     * @param index the index of the parameter type to return
     * @return the specified parameter type
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getParameterCount()}</code>
     */
    public TypeDescriptor<? extends IVilType> getParameterType(int index) {
        return parameter[index];
    }

    /**
     * Creates an empty array of type descriptors.
     * 
     * @param length the length of the array to be created
     * @return the array instance
     */
    @SuppressWarnings("unchecked")
    public static TypeDescriptor<? extends IVilType>[] createArray(int length) {
        return new TypeDescriptor[length];
    }
    
    /**
     * Appends the type parameters to <code>name</code>.
     * 
     * @param name the VIL name of this type
     * @return the VIL name including parameter types if applicable
     */
    protected String appendParameter(String name) {
        StringBuilder tmp = new StringBuilder(name);
        int count = getParameterCount();
        if (count > 0) {
            tmp.append('(');
            for (int p = 0; p < count; p++) {
                if (p > 0) {
                    tmp.append(", ");
                }
                TypeDescriptor<? extends IVilType> param = getParameterType(p);
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

}
