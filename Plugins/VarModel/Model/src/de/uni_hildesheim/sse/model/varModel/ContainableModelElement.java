package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitable;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitor;


/**
 * Represents the objects, a project can handle.
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public abstract class ContainableModelElement extends ModelElement implements IDatatypeVisitable {

    private IModelElement parent;
    
    /**
     * Constructor for containable model element.
     * @param name Name of the containable model element
     * @param parent the object, in which this specific one is embedded
     */
    protected ContainableModelElement(String name, IModelElement parent) {
        super(name);
        this.parent = parent;
    }

    /**
     * {@inheritDoc}
     */
    public final IModelElement getParent() {
        return parent;
    }
    
    /**
     * Returns the topLevel parent.
     * @return should be the project
     */
    public final IModelElement getTopLevelParent() {
        IModelElement parent = getParent();
        if (null != parent && !(parent instanceof Project)) {
            ContainableModelElement immidiateParent = (ContainableModelElement) parent;
            parent = immidiateParent.getTopLevelParent();
        }
        return parent;
    }
    
    /**
     * Method to check whether the parent is a topLevel-element.
     * @return true, if the parent is the project, otherwise false
     */
    public final boolean isTopLevel() {
        boolean top = false;
        if (parent instanceof Project) {
            top = true;
        }
        return top;
    }
    
    /** 
     * {@inheritDoc}
     */
    public String getNameSpace() {
        String namespace;
        if (null == parent) {
            namespace = "";
        } else {
            IModelElement p = parent;
            while (null != p && p.isTransparent()) {
                p = p.getParent();
            }
            if (null == p) {
                namespace = "";
            } else {
                namespace = p.getNameSpace();
            }
        }
        return namespace;
    }
    
    /**
     * Returns the qualified name of this element.
     * 
     * @return the qualified name
     */
    public String getQualifiedName() {
        String result = getNameSpace();
        if (result.length() > 0) {
            result += "::" + getName();
        }
        return result;
    }

    
    /**
     * Changes the parent object. Note, that this operation
     * is necessary (although not intended) to resolve some
     * of the cycles in creating compounds or temporary variables.
     * 
     * @param parent the parent element
     */
    public final void setParent(IModelElement parent) {
        this.parent = parent;
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        //do nothing
    }
    
}
