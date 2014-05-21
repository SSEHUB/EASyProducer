package de.uni_hildesheim.sse.model.varModel;

/** 
 * An element which may act as an evaluable expression in an eval block. 
 */
public interface IPartialEvaluable {
    
    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public abstract void accept(IModelVisitor visitor);

    /**
     * Returns the parent model element.
     * 
     * @return the parent model element (may be <b>null</b>)
     */
    public IModelElement getParent();

}
