package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.IAttributeAccess;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Class to show the syntax of an Constraint.
 * 
 * @author Heiko Beck
 * @author Holger Eichelberger
 */
public abstract class ConstraintSyntaxTree implements IAttributeAccess {
    
    /** 
     * Visiting method for the visitor. <br/>
     * This method is used for saving this model element.
     * @param visitor The visitor, which should save this model element.
     */
    public abstract void accept(IConstraintTreeVisitor visitor);
    
    /**
     * Infers the datatype of the subtree represented by this object.
     * 
     * @return the data type
     * @throws CSTSemanticException Will be thrown if parameters of (sub-) trees do not fit together.
     */
    public abstract IDatatype inferDatatype() throws CSTSemanticException;

    /**
     * Returns the data type explicitly contained in this syntax tree. This is 
     * typically a constant value which contains a meta value, i.e. a type expression.
     * 
     * @return the contained type or <b>null</b> if there is none
     */
    public IDatatype getContainedType() {
        return null;
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount() {
        return 0;
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param index the index of the attribute
     * @return the attribute
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getAttributesCount()}</code>
     */
    public Attribute getAttribute(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param name the name of the attribute
     * @return the attribute (or <b>null</b> if not found)
     */
    public Attribute getAttribute(String name) {
        return null;
    }
    
    /**
     * Returns the parent model element.
     * 
     * @return the parent model element (may be <b>null</b>)
     */
    public IModelElement getParent() {
        return null;
    }

}
