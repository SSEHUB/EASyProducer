package de.uni_hildesheim.sse.model.varModel;

/**
 * Interface to mark attributable elements. Classes implementing this interface
 * shall consider the implementation of {@link IModelElement#propagateAttribute(Attribute)}.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public interface IAttributableElement extends IAttributeAccess {
    
    /**
     * Method to get the name of the element.
     * 
     * @return name of the element
     */
    public String getName();

    /**
     * Returns the qualified name of this element.
     * 
     * @return the qualified name
     */
    public String getQualifiedName();

    /**
     * Attributes this element.
     * 
     * @param attribute the attribute to be added
     * @return <code>true</code> if the operation was successful,
     *   <code>false</code> if the element is about being attributed 
     *   multiple times with the same attribute
     */
    public boolean attribute(Attribute attribute);
    
}
