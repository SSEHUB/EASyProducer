package de.uni_hildesheim.sse.utils.modelManagement;


/**
 * Denotes an element which can be restricted in terms of versions.
 * 
 * @author Holger Eichelberger
 */
public interface IVersionRestrictable {

    /**
     * Returns the restriction specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the restriction to be returned
     * @return the restriction
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getRestrictionsCount}</code>
     */
    public VersionRestriction getRestriction(int index);

    /**
     * Returns the number of restrictions.
     * 
     * @return the number of restrictions
     */
    public int getRestrictionsCount();

}
