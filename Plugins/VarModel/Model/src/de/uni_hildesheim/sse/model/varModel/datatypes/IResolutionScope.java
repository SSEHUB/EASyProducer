package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;

/**
 * Provides access to containable model elements.
 * 
 * @author Holger Eichelberger
 */
public interface IResolutionScope {

    /** 
     * Returns the (unqualified) name of the scope.
     * @return the unqualified name of the scope
     */
    public String getName();
    
    /**
     * Returns a contained model element specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the contained element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getElementCount()}</code>
     */
    public ContainableModelElement getElement(int index);

    /**
     * Returns the number of contained elements.
     * 
     * @return the number of contained elements
     */
    public int getElementCount();
    
    /**
     * Returns the number of imports.
     * 
     * @return the number of imports
     */
    public int getImportsCount();
    
    /**
     * Returns the project import specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the import to be returned
     * @return the project import
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getImportsCount()}</code>
     */
    public ProjectImport getImport(int index);
    
    /**
     * Returns whether this scope has interfaces.
     * 
     * @return <code>true</code> if it has interfaces, <code>false</code> else
     */
    public boolean hasInterfaces();

    /**
     * Returns whether this scope is an interfaces.
     * 
     * @return <code>true</code> if it is an interface, <code>false</code> else
     */
    public boolean isInterface();

}
