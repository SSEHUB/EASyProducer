package de.uni_hildesheim.sse.model.varModel.datatypes;


/**
 * The AnyType is the "Object" of OCL, a type to which all types are compatible.
 * We need this type to specify generic operations (return values)
 * 
 * @author Holger Eichelberger
 */
public class AnyType extends BasisDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType();
    public static final IDatatype TYPE = DTYPE;
    
    static final DelegatingType META_TYPE = new DelegatingType();
    static final DelegatingType BOOLEAN_TYPE = new DelegatingType(DTYPE);
    static final DelegatingType CONSTRAINT_TYPE = new DelegatingType(AnyType.DTYPE);
    
    // operations go here
    public static final Operation IS_TYPE_OF = new Operation(
        BOOLEAN_TYPE, OclKeyWords.IS_TYPE_OF, TYPE, META_TYPE);
    public static final Operation IS_KIND_OF = new Operation(
        BOOLEAN_TYPE, OclKeyWords.IS_KIND_OF, TYPE, META_TYPE);

    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new AnyType());
        DTYPE.addOperation(IS_TYPE_OF);
        DTYPE.addOperation(IS_KIND_OF);
    }
    
    /**
     * Constructor for a new BooleanType.
     */
    private AnyType() {
        super("AnyType", DTYPE);
    }
    
    /**
    * {@inheritDoc}
    */
    @Override
    public boolean isAssignableFrom(IDatatype type) {
        return true; // any type is compliant to this
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitAnyType(this);
    }

}
