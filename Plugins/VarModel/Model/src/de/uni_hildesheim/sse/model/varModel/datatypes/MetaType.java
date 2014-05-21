package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * Implements a data type which represents types (as result of type operations).
 * 
 * @author Holger Eichelberger
 */
public class MetaType extends BasisDatatype {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    public static final IDatatype TYPE = AnyType.META_TYPE;

    // we assume normalized operations to OCL -> simplifies reasoner translation
    public static final Operation EQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE);
    public static final Operation NOTEQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);

    // checkstyle: resume declaration order check

    static {
        AnyType.META_TYPE.setDelegate(new MetaType());
        AnyType.META_TYPE.addOperation(EQUALS);
        AnyType.META_TYPE.addOperation(NOTEQUALS);
    }
    
    /**
     * Creates the singleton instance of this class.
     */
    private MetaType() {
        super("MetaType", AnyType.META_TYPE);
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitMetaType(this);
    }
    
}
