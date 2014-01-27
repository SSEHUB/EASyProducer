package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;

import de.uni_hildesheim.sse.model.varModel.datatypes.IResolutionScope;

/**
 * A list of containable model elements which acts as {@link IResolutionScope}.
 * Note that such a list does neither provides imports nor a name and is more 
 * or less inteded to be considered for searching specific elements 
 * in {@link ModelQuery}.
 * 
 * @author Holger Eichelberger
 */
public class ContainableModelElementList extends ArrayList<ContainableModelElement> 
    implements IResolutionScope {
    
    // This would be a candidate for a utils package

    /**
     * Identification for serialization.
     */
    private static final long serialVersionUID = 6379434188902270970L;

    /**
     * Creates a new model element list.
     */
    public ContainableModelElementList() {
        super();
    }

    /**
     * Creates a new model element list.
     * 
     * @param initialCapacity the initial capacity of the list
     */
    public ContainableModelElementList(int initialCapacity) {
        super(initialCapacity);
    }
    
    /**
     * {@inheritDoc}
     */
    public ContainableModelElement getElement(int index) {
        return get(index);
    }

    /**
     * {@inheritDoc}
     */
    public int getElementCount() {
        return size();
    }

    /**
     * {@inheritDoc}
     */
    public int getImportsCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public ProjectImport getImport(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    /** 
     * Returns the (unqualified) name of the scope.
     * @return the unqualified name of the scope
     */
    public String getName() {
        return "";
    }

    /**
     * Returns whether this project has interfaces.
     * 
     * @return <code>true</code> if it has interfaces, <code>false</code> else
     */
    public boolean hasInterfaces() {
        return false; // this is just a list used internally
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isInterface() {
        return false; // this is just a list used internally
    }
    
}

