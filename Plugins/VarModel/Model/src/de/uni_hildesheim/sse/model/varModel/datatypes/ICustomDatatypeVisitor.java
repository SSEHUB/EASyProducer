package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * Defines an interface for visiting datatypes. Please note that
 * no class directly uses this interface but the model visitor is
 * a sub interface of this interface. Further, please note that
 * datatypes in general and {@linkplain BasisDatatype basis datatypes} 
 * in particular are not subject of being visited.<br/>
 * 
 * @author Lueder
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public interface ICustomDatatypeVisitor {

    /**
     * Method for visiting an enum.
     * 
     * @param eenum The enum which should be visited.
     */
    public void visitEnum(Enum eenum);

    /**
     * Method for visiting an ordered enum.
     * 
     * @param eenum The enum which should be visited.
     */
    public void visitOrderedEnum(OrderedEnum eenum);
    
    /**
     * Method for visiting a compound.
     * 
     * @param compound The compound which should be visited.
     */
    public void visitCompound(Compound compound);

    /**
     * Method for visiting a derived datatype.
     * 
     * @param datatype The datatype which should be visited.
     */
    public void visitDerivedDatatype(DerivedDatatype datatype);

    /**
     * Method for visiting an enum literal.
     * 
     * @param literal The literal which should be visited.
     */
    public void visitEnumLiteral(EnumLiteral literal);
    
    /**
     * Method for visiting a reference.
     * 
     * @param reference The reference which should be visited.
     */
    public void visitReference(Reference reference);

    /**
     * Method for visiting a sequence.
     * 
     * @param sequence The sequence which should be visited.
     */
    public void visitSequence(Sequence sequence);

    /**
     * Method for visiting a set.
     * 
     * @param set The set which should be visited.
     */
    public void visitSet(Set set);

}
