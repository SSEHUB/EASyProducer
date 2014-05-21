package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * A specific visitor for building type identities.
 * 
 * @author Holger Eichelberger
 */
public interface IDatatypeVisitor {
       
    /**
     * Is called by an arbitrary data type.
     * 
     * @param datatype the data type.
     */
    public void visitDatatype(IDatatype datatype);

    /**
     * Is called by an AnyType.
     * 
     * @param datatype the data type.
     */
    public void visitAnyType(AnyType datatype);


    /**
     * Is called by a MetaType.
     * 
     * @param datatype the data type.
     */
    public void visitMetaType(MetaType datatype);

    /**
     * Is called by an <code>DerivedDatatype</code> data type.
     * 
     * @param datatype the data type.
     */
    public void visitDerivedType(DerivedDatatype datatype);
    
    /**
     * Is called by a set data type.
     * 
     * @param set the set instance
     */
    public void visitSet(Set set);

    /**
     * Is called by a sequence datatype.
     * 
     * @param sequence the sequence instance
     */
    public void visitSequence(Sequence sequence);

    /**
     * Is called by a reference data type.
     * 
     * @param reference the references instance
     */
    public void visitReference(Reference reference);
    
    /**
     * Visiting method for visiting a <code>BooleanType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitBooleanType(BooleanType type);

    /**
     * Visiting method for visiting a <code>StringType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitStringType(StringType type);

    /**
     * Visiting method for visiting a <code>ConstraintType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitConstraintType(ConstraintType type);
    
    /**
     * Visiting method for visiting a <code>IntegerType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitIntegerType(IntegerType type);
    
    /**
     * Visiting method for visiting a <code>RealType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitRealType(RealType type);

    /**
     * Visiting method for visiting a <code>Compound</code>.
     * @param compound The <code>Compound</code> which should be visited.
     */
    public void visitCompoundType(Compound compound);
    /**
     * Visiting method for visiting a <code>Enum</code>.
     * @param enumType The <code>Enum</code> which should be visited.
     */
    public void visitEnumType(Enum enumType);
    /**
     * Visiting method for visiting a <code>OrderredEnum</code>.
     * @param enumType The <code>Enum</code> which should be visited.
     */
    public void visitOrderedEnumType(OrderedEnum enumType);
    
}
