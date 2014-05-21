package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * Defines the interface of a meta type. This interface is used for generic type conformance checks.
 * 
 * @author Holger Eichelberger
 */
public interface IMetaType {

    /**
     * Returns the (simple) name of this type.
     * 
     * @return the simple name
     */
    public String getName();
    
    /**
     * Returns the qualified name of this type.
     * 
     * @return the qualified name
     */
    public String getQualifiedName();
    
    /**
     * Returns the number of operations provided by this provider.
     * 
     * @return the number of operations
     */
    public int getOperationsCount();
    
    /**
     * Returns the specified operation.
     * 
     * @param index the index of the operation to be returned
     * @return the specified operation
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index&gt;={@link #getOperationsCount()}</code>
     */
    public IMetaOperation getOperation(int index);

    /**
     * Returns whether this type is the same or a super class of <code>type</code>.
     * 
     * @param type the descriptor to be tested
     * @return <code>true</code> if both types are assignment compatible, <code>false</code> else
     */
    public boolean isAssignableFrom(IMetaType type);

    /**
     * Returns the conversion operation from this type to target type (if there is any).
     * 
     * @param sourceType the source type to convert from
     * @param targetType the target type to convert to
     * @return the conversion operation as defined in the underlying implementation class, 
     *   <b>null</b> if no matching can be found
     */
    public IMetaOperation findConversion(IMetaType sourceType, IMetaType targetType);

    /**
     * Returns whether this instance represents a basic type.
     * 
     * @return <code>true</code> if this instance represents a basic type, <code>false</code> else
     */
    public boolean isBasicType();
    
    /**
     * Returns the type registry this type was registered by.
     * 
     * @return the type registry
     */
    public TypeRegistry getTypeRegistry();
}
