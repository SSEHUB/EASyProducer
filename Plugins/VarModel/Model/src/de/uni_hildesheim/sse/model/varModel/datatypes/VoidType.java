package de.uni_hildesheim.sse.model.varModel.datatypes;


/**
 * The AnyType is the "Object" of OCL, a type to which all types are compatible.
 * We need this type to specify generic operations (return values)
 * 
 * @author Holger Eichelberger
 */
public class VoidType extends BasisDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType();
    public static final IDatatype TYPE = DTYPE;
    
    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new VoidType());
    }
    
    /**
     * Constructor for a new VoidType.
     */
    private VoidType() {
        super("VoidType", DTYPE);
    }
    
    /**
    * {@inheritDoc}
    */
    @Override
    public boolean isAssignableFrom(IDatatype type) {
        return false; // no type is compliant to this
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        //visitor.visitAnyType(this);
    }

}
