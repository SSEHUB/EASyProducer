package net.ssehub.easy.integration.common;

/**
 * Represents a variability model.
 * 
 * @author Holger Eichelberger
 */
public interface IModel {

    /**
     * Returns the name of the model.
     * 
     * @return the name of the model
     */
    public String getName();

    /**
     * Returns the name of the version.
     * 
     * @return the name of the version (may be <b>null</b>)
     */
    public String getVersion();

    /**
     * Returns the number of decision variables stored in this model.
     * 
     * @return the number of decision variables
     */
    public int getVariablesCount();

    /**
     * Returns a particular decision variable.
     * 
     * @param index the 0-based index of the variable to be returned 
     * @return the specified variable
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index&lt;0 || index&gt;={{@link #getVariablesCount()}}</code>
     */
    public IDecisionVariable getVariable(int index);

    /**
     * Returns a decision variable by it's (valid IVML) name.
     * 
     * @param name the name of the variable
     * @return the decision variable (or <b>null</b> if not found)
     * @throws ModelException in case of any semantic problem
     */
    public IDecisionVariable getVariable(String name) throws ModelException;
    
    /**
     * Returns the number of types known to this model.
     * 
     * @return the number of types
     */
    public int getTypesCount();

    /**
     * Returns a particular known type.
     * 
     * @param index the 0-based index of the type to be returned 
     * @return the specified type
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index&lt;0 || index&gt;={{@link #getTypesCount()}}</code>
     */
    public String getType(int index);

    /**
     * Creates a constraint from the given string. This method does not modify the model.
     * 
     * @param constraint the string to be turned into a constraint (in IVML notation)
     * @return the constraint
     * @throws ModelException in case of syntactical or semantical problems
     */
    public IConstraint createConstraint(String constraint) throws ModelException;
    
    /**
     * Returns the textual representation of this model.
     * 
     * @return the textual representation in IVML syntax
     */
    public String toString();

}
