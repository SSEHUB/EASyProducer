package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/** IFreezable interface. **/
public interface IFreezable {
    
    /** 
     * Returns the name of the freezable.
     * @return Name of this freezable.
     */
    public String getName();
 
    /**
     * Returns the type of this freezable.
     * 
     * @return the type of this freezable
     */
    public IDatatype getType();
    
    /**
     * Getter-Method for the parent-object.
     * @return the parent-object
     */
    public IModelElement getParent();
    
    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public abstract void accept(IModelVisitor visitor);

}