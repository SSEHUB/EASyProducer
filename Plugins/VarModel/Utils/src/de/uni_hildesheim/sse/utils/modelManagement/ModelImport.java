package de.uni_hildesheim.sse.utils.modelManagement;

/**
 * Defines model imports and related restrictions.
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public class ModelImport <M extends IModel> implements IVersionRestrictable {

    private M resolved;
    private String name;
    private VersionRestriction[] restrictions;
    private boolean isConflict;

    /**
     * Creates an unrestricted script import.
     * 
     * @param name The name of the project to be imported.
     */
    public ModelImport(String name) {
        this(name, false, (VersionRestriction[]) null);
    }
    
    /**
     * Creates a model import instance.
     * 
     * @param name the name of the model to be import
     * @param isConflict does this object represent a conflict or an import
     * @param restrictions the version restrictions
     */
    public ModelImport(String name, boolean isConflict, VersionRestriction... restrictions) {
        this.name = name;
        this.restrictions = restrictions;
        this.isConflict = isConflict;
    }
    
    /**
     * Returns the name of the model to be imported.
     * 
     * @return Name of the import
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the restriction specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the restriction to be returned
     * @return the restriction
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getRestrictionsCount}</code>
     */
    public VersionRestriction getRestriction(int index) {
        if (null == restrictions) {
            throw new IndexOutOfBoundsException();
        }
        return restrictions[index];
    }

    /**
     * Returns the number of restrictions.
     * 
     * @return the number of restrictions
     */
    public int getRestrictionsCount() {
        return null == restrictions ? 0 : restrictions.length;
    }

    /**
     * Does this object represent an import or a conflict.
     * 
     * @return <code>true</code> in case of a conflict, 
     *   <code>false</code> in case of an import
     */
    public boolean isConflict() {
        return isConflict;
    }

    /**
     * Setter for setting the version restrictions.
     * @param restrictions Version restrictions related to this import or <code>null</code>.
     */
    public void setRestrictions(VersionRestriction[] restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * Returns the resolved model instance.
     * 
     * @return the resolved instance
     */
    public M getResolved() {
        return resolved;
    }
    
    /**
     * Returns whether the related model was already resolved.
     * 
     * @return <code>true</code> if it was resolved, <code>false</code> else
     */
    public boolean isResolved() {
        return null != resolved;
    }

    /**
     * Defines the resolved model instance.
     * 
     * @param resolved the resolved instance or <b>null</b>
     * @throws ModelManagementException in case of violated model access restrictions
     */
    public void setResolved(M resolved) throws ModelManagementException {
        // set resolved
        this.resolved = resolved;
    }
 
}
