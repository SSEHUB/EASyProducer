package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelElement;


/** 
 * A reference allows the definition of individual configurations of an (external) element for the referencing element.
 * Currently, operations such as assignments are represented as the respective operations of the base type. Actually, 
 * this may be confusing / wrong. See {@link de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree#inferDatatype()}.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public class Reference extends CustomDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType();
    
    /**
     * This constant represents the common type of all references. Each specific reference type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    // no further operations such as assignments here as assignments are represented as the base type assignments
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE);    
 
    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new Reference());
        DTYPE.addOperation(TYPE_OF);
        DTYPE.addOperation(IS_DEFINED);
    }
    
    private IDatatype type;

    /**
     * Creates the singleton instance for {@link #TYPE}.
     */
    private Reference() {
        this("<Reference>", null, null);
    }
    
    /**
     * Constructor for the reference.
     * @param name Name of reference
     * @param type the type to refer to
     * @param parent the object, in which this specific one is embedded
     */
    public Reference(String name, IDatatype type, ModelElement parent) {
        super(name, DTYPE, parent);
        this.type = type;
    }
    
    /**
     * Returns the type this reference is referring to.
     * 
     * @return the type
     */
    public IDatatype getType() {
        return type;
    }

    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitReference(this);
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitReference(this);
    }
    
    /**
    * Determines if the data type represented by this
    * object is either the same as, or is a supertype of 
    * <code>type</code>.
    * 
    * @param type the type being checked
    * @return <code>true</code> if this type is either the same or a 
    *   supertype of <code>type</code>, <code>true</code> else
    */
    public boolean isAssignableFrom(IDatatype type) {
        return super.isAssignableFrom(type) || (this.type != null && this.type.isAssignableFrom(type));
    }

}
