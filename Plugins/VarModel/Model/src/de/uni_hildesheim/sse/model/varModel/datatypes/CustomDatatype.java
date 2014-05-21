package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.InternalConstraint;

/**
 * Abstract class, implements the setName method for the custom data types.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/

public abstract class CustomDatatype extends ContainableModelElement implements IDatatype {

    private DelegatingType singleton;
    
    /**
     * Constructor for custom data type.
     * @param name Name of the custom data type
     * @param singleton the instance which knows the operations
     * @param parent the object, in which this specific one is embedded
     */
    protected CustomDatatype(String name, DelegatingType singleton, IModelElement parent) {
        super(name, parent);
        this.singleton = singleton;
    }

    /*
     * Method to set the name of the Object.    
     * @param name 
     */
    /*public void setName(String name) {
    }*/
    
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
        return singleton.equals(type) // allow exactly the same 
            || AnyType.TYPE == type   // allow null
            || (null != type && getClass().isAssignableFrom(type.getClass())); // allow subclasses
    }
    
    /**
     * Returns the java class realizing the type.
     * 
     * @return the java class realizing the type
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
    public InternalConstraint[] createConstraints(AbstractVariable declaration) throws CSTSemanticException {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isPseudoType() {
        return false;
    }

}
