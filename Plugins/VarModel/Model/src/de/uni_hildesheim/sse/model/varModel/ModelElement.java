package de.uni_hildesheim.sse.model.varModel;

/** 
 * All elements a VarModel could contain.
 * @author Marcel Lueder
 */
public abstract class ModelElement implements IModelElement {
    private String name;
    private String comment = "";
    private boolean isUnique;
    
    /**
     * Constructor for the model element.
     * @param name Name of the model element
     */
    protected ModelElement(String name) {
        this.name = name;
        comment = null;
        isUnique = true;
    }
    
    /** 
     * {@inheritDoc}
     */
    public final String getName() {
        return name;
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }
    
    /** 
     * {@inheritDoc}
     */
    public final String getComment() {
        return comment;
    }
    
    /** 
     * {@inheritDoc}
     */
    public void setComment(String comment) {
        if (null == comment) {
            this.comment = "";
        } else {
            this.comment = comment;
        }
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
    public abstract void accept(IModelVisitor visitor);
    // keep this for the moment so that @Overrides are correct in Java 1.5
    
    /** 
     * {@inheritDoc}
     */
    public String getQualifiedName() {
        return getName(); // we do not have a parent here
    }
    
    /** 
     * {@inheritDoc}
     */
    public final String getUniqueName() {
        String uniqueName = getName();
        if (!isUnique) {
            uniqueName = getQualifiedName();
        }
        if (null == uniqueName) {
            uniqueName = "";
        }
        return uniqueName;
    }
    
    /**
     * Changes the name of this model element.
     * @param name the new name
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Searches for a specified attribute.
     * 
     * @param access the instance providing access to attributes
     * @param name the name of the attribute to search for
     * @return the attribute or <b>null</b> if not found
     */
    public static final Attribute findAttribute(IAttributeAccess access, String name) {
        Attribute result = null;
        for (int a = 0; null == result && a < access.getAttributesCount(); a++) {
            Attribute attr = access.getAttribute(a);
            if (attr.getName().equals(name)) {
                result = attr;
            }
        }
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean propagateAttribute(Attribute attribute) {
        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isTransparent() {
        return false;
    }
    
    /**
     * {@inheritDoc}
     */
    public IModelElement getParent() {
        return null;
    }

}
