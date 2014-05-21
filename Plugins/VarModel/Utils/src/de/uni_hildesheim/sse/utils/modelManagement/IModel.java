package de.uni_hildesheim.sse.utils.modelManagement;

/**
 * Represents the type of models to be managed.
 * 
 * @author Holger Eichelberger
 */
public interface IModel extends IModelData {

    /**
     * Changes the version of this model.
     * 
     * @param version Version to set
     */
    public void setVersion(Version version);
    
    /**
     * Returns the version of this model.
     * 
     * @return the version or <code>null</code> if no version is specified for this model.
     */
    public Version getVersion();

    /** 
     * Returns the name of the model element.
     * @return the name of this model element.
     */
    public String getName();

    /**
     * Returns the number of imports.
     * 
     * @return the number of imports
     */
    public int getImportsCount(); 
    
    /**
     * Returns the model import specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the import to be returned
     * @return the model import
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getImportsCount()}</code>
     */
    public ModelImport<?> getImport(int index);
    
    /**
     * Returns the reference to the super model (if it exists).
     * 
     * @return the super model (in terms of a model import/reference, may be <b>null</b>)
     */
    public ModelImport<?> getSuper();

    /**
     * Returns the indentation configuration for this model. The indentation
     * configuration is considered to be immutable.
     * 
     * @return the indentation configuration (disabled if <b>null</b>)
     */
    public IndentationConfiguration getIndentationConfiguration();
    
}
