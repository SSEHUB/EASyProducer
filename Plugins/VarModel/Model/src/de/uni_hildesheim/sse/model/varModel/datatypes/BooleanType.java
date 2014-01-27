package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * Creates the BasisDatatype Boolean.
 * 
 * @author beck
 *
 */
public class BooleanType extends BasisDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check
    
    public static final IDatatype TYPE = AnyType.BOOLEAN_TYPE;
    
    // basic from any
    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    
    public static final Operation EQUALS = Operation.createInfixOperator(TYPE, OclKeyWords.EQUALS, TYPE, TYPE);
    public static final Operation UNEQUALS = Operation.createInfixOperator(TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);
    public static final Operation ASSIGNMENT = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE);    
    
    // unary operation
    public static final Operation NOT = Operation.createPrefixOperator(TYPE, OclKeyWords.NOT, TYPE);
    
    // binary operations!
    public static final Operation OR = Operation.createInfixOperator(TYPE, OclKeyWords.OR, TYPE, TYPE);
    public static final Operation XOR = Operation.createInfixOperator(TYPE, OclKeyWords.XOR, TYPE, TYPE);
    public static final Operation AND = Operation.createInfixOperator(TYPE, OclKeyWords.AND, TYPE, TYPE);
    public static final Operation IMPLIES = Operation.createInfixOperator(TYPE, OclKeyWords.IMPLIES, TYPE, TYPE);

    // IVML
   
    public static final Operation IFF = new Operation(TYPE, OclKeyWords.IFF, TYPE, TYPE);
    
    // checkstyle: resume declaration order check
    
    static {
        AnyType.BOOLEAN_TYPE.setDelegate(new BooleanType());
        AnyType.BOOLEAN_TYPE.addOperation(TYPE_OF);
        AnyType.BOOLEAN_TYPE.addOperation(EQUALS);
        AnyType.BOOLEAN_TYPE.addOperation(UNEQUALS);
        AnyType.BOOLEAN_TYPE.addOperation(ASSIGNMENT);
        AnyType.BOOLEAN_TYPE.addOperation(IS_DEFINED);
        AnyType.BOOLEAN_TYPE.addOperation(NOT);
        AnyType.BOOLEAN_TYPE.addOperation(OR);
        AnyType.BOOLEAN_TYPE.addOperation(XOR);
        AnyType.BOOLEAN_TYPE.addOperation(AND);
        AnyType.BOOLEAN_TYPE.addOperation(IMPLIES);
        AnyType.BOOLEAN_TYPE.addOperation(IFF);
    }
    
    /**
     * Constructor for a new BooleanType.
     */
    private BooleanType() {
        super("Boolean", AnyType.BOOLEAN_TYPE);
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitBooleanType(this);
    }
    
    /**
    * {@inheritDoc}
    */
    public boolean isAssignableFrom(IDatatype type) {
        // enable boolean assignments as constraints are handled as Boolean expressions
        return super.isAssignableFrom(type) || ConstraintType.TYPE.isAssignableFrom(type);
    }

}
