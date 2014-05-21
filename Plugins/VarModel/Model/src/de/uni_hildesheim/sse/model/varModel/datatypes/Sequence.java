package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation.ReturnTypeMode;

/**
 * Realizes a sequence container.
 * This represents an array.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public class Sequence extends Container {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check
    
    static final DelegatingType DTYPE = new DelegatingType(Container.DTYPE);
    // actually we can define operations once and reuse them but I'm not sure whether this makes
    // sense with respect to the reasoner -> define in "supertype" and link to respective DTYPE
    
    /**
     * This constant represents the common type of all sets. Each specific sequence type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    // generic operations
    public static final Operation INDEX_ACCESS = new Operation(AnyType.TYPE, 
        ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.INDEX_ACCESS, TYPE, IntegerType.TYPE);
    public static final Operation AT = new Operation(AnyType.TYPE, 
        ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.AT, TYPE, IntegerType.TYPE);
    public static final Operation FIRST = new Operation(AnyType.TYPE, 
        ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.FIRST, TYPE);
    public static final Operation LAST = new Operation(AnyType.TYPE, 
        ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.LAST, TYPE);

    public static final Operation AS_SET = new Operation(Set.TYPE, ReturnTypeMode.TYPED_OPERAND_1, 
        OclKeyWords.AS_SET, TYPE);
    public static final Operation AS_SEQUENCE = new Operation(Sequence.TYPE, ReturnTypeMode.TYPED_OPERAND_1, 
        OclKeyWords.AS_SEQUENCE, TYPE);
    public static final Operation UNION = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, 
        OclKeyWords.UNION, TYPE, TYPE);
    public static final Operation APPEND = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, 
        OclKeyWords.APPEND, TYPE, AnyType.TYPE);
    public static final Operation PREPEND = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, 
        OclKeyWords.PREPEND, TYPE, AnyType.TYPE);
    public static final Operation INSERT_AT = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.INSERT_AT, TYPE, IntegerType.TYPE, AnyType.TYPE);
    public static final Operation INDEX_OF = new Operation(IntegerType.TYPE, OclKeyWords.INDEX_OF, TYPE, AnyType.TYPE);

    // type specific 
    public static final Operation EQUALS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE).markAsAssignableParameterOperation();
    public static final Operation ASSIGNMENT = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    
    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new Sequence());
        DTYPE.addOperation(INDEX_ACCESS);
        DTYPE.addOperation(AT);
        DTYPE.addOperation(FIRST);
        DTYPE.addOperation(LAST);
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(AS_SET);
        DTYPE.addOperation(AS_SEQUENCE);
        DTYPE.addOperation(UNION);
        DTYPE.addOperation(APPEND);
        DTYPE.addOperation(PREPEND);
        DTYPE.addOperation(INSERT_AT);
        DTYPE.addOperation(INDEX_OF);
    }
    
    /**
     * Creates the singleton instance.
     */
    private Sequence() {
        this("<Sequence>",  null, null);
    }
    
    /**
     * Constructor for the container.
     * @param name Name of the container
     * @param type data type of the container elements
     * @param parent the object, in which this specific one is embedded
     */
    public Sequence(String name, IDatatype type, IModelElement parent) {
        super(name, DTYPE, type, parent);
    }

    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitSequence(this);
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitSequence(this);
    }

}
