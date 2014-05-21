package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.InternalConstraint;


/**
 * Represents the basic data types of the IVML.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public abstract class BasisDatatype implements IDatatype {
    
    private String name;
    
    private DelegatingType singleton;
        
    /**
     * Constructor for the basis data type.
     * @param name Name of the basis data type
     * @param singleton the instance which knows the operations
     */
    protected BasisDatatype(String name, DelegatingType singleton) {
        this.name = name;
        this.singleton = singleton;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return name;
    }
    
    /** 
     * {@inheritDoc}
     */
    public String getNameSpace() {
        return "";
    }
    
    /**
     * {@inheritDoc}
     */
    public String getQualifiedName() {
        return name;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getUniqueName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public final Operation getOperation(int index) {
        return singleton.getOperation(index);
    }

    /**
     * {@inheritDoc}
     */
    public final int getOperationCount() {
        return singleton.getOperationCount();
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
        // basically the same due to singletons and null is assignable too
        return singleton.equals(type) || AnyType.TYPE == type;
    }
    
    /**
     * {@inheritDoc}
     */
    public Class<? extends IDatatype> getTypeClass() {
        return singleton.getTypeClass();
    }
    
    /**
     * Returns the object realizing the type.
     * 
     * @return the object realizing the type
     */
    public IDatatype getType() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public IDatatype getGenericType(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * {@inheritDoc}
     */
    public int getGenericTypeCount() {
        return 0;
    }
    
    /**
     * {@inheritDoc}
     */
    public abstract void accept(IDatatypeVisitor visitor);
    
    /**
     * {@inheritDoc}
     */
    public final InternalConstraint[] createConstraints(AbstractVariable declaration) {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isPseudoType() {
        return false;
    }

}
