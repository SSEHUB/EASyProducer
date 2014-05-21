package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * Provides access to custom operations.
 * 
 * @author Holger Eichelberger
 *
 */
public interface ICustomOperationAccessor {

    /**
     * Returns the (pseudo) datatype of this accessor, the operand type for
     * all accessible custom operations.
     * 
     * @return the datatype
     */
    public IDatatype getType();

    /**
     * Returns the operation specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the operation
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getOperationCount}</code>
     */
    public CustomOperation getOperation(int index);

    /**
     * Returns the number of operations.
     * 
     * @return the number of operations
     */
    public int getOperationCount();

}
