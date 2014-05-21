package de.uni_hildesheim.sse.model.varModel.values;

/**
 * Defines a visitor for values.
 * 
 * @author Lueder
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public interface IValueVisitor {

    /**
     * This method is used for visiting ConstraintValue.<br/>
     * 
     * @param value One ConstraintValue which should be visited.
     */
    void visitConstraintValue(ConstraintValue value);
    
    /**
     * This method is used for visiting EnumValue.<br/>
     * 
     * @param value One EnumValue which should be visited.
     */
    void visitEnumValue(EnumValue value);
    
    /**
     * This method is used for visiting StringValue.<br/>
     * 
     * @param value One StringValue which should be visited.
     */
    void visitStringValue(StringValue value);
    
    /**
     * This method is used for visiting CompoundValue.<br/>
     * 
     * @param value One CompoundValue which should be visited.
     */
    void visitCompoundValue(CompoundValue value);

    /**
     * This method is used for visiting ContainerValue.<br/>
     * 
     * @param value One CompoundValue which should be visited.
     */
    void visitContainerValue(ContainerValue value);
    
    /**
     * This method is used for visiting IntValue.<br/>
     * 
     * @param value One IntValue which should be visited.
     */
    void visitIntValue(IntValue value);
    
    /**
     * This method is used for visiting RealValue.<br/>
     * 
     * @param value One RealValue which should be visited.
     */
    void visitRealValue(RealValue value);
    
    /**
     * This method is used for visiting BooleanValue.<br/>
     * 
     * @param value One BooleanValue which should be visited.
     */
    void visitBooleanValue(BooleanValue value);

    /**
     * This method is used for visiting referenceValue.<br/>
     * 
     * @param referenceValue One referenceValue which should be visited.
     */
    void visitReferenceValue(ReferenceValue referenceValue);

    /**
     * This method is used for visiting meta type value.<br/>
     * 
     * @param value a value which should be visited.
     */
    void visitMetaTypeValue(MetaTypeValue value);

    /**
     * This method is used for visiting a null value.<br/>
     * 
     * @param value a value which should be visited (actually {@link NullValue#INSTANCE}).
     */
    void visitNullValue(NullValue value);

}
