package de.uni_hildesheim.sse.reasoning.core.model.datatypes;


/**
 * A visitor interface for visiting {@link ReasonerDatatype}.
 * 
 * @author El-Sharkawy
 *
 */
public interface IReasonerTypeVisitor {
    
    /**
     * Is called via the {@link CompoundType#accept(IReasonerTypeVisitor)} method.
     * @param cmpType The calling {@link CompoundType} instance.
     */
    public void visitCompoundType(CompoundType cmpType);
    
    /**
     * Is called via the {@link EnumType#accept(IReasonerTypeVisitor)} method.
     * @param enumType The calling {@link EnumType} instance.
     */
    public void visitEnumType(EnumType enumType);
    
    /**
     * Is called via the {@link ReferenceType#accept(IReasonerTypeVisitor)} method.
     * @param refType The calling {@link ReferenceType} instance.
     */
    public void visitRefernceType(ReferenceType refType);
}
