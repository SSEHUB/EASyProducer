package net.ssehub.easy.integration.common;

/**
 * Represents a decision variable.
 * 
 * @author Holger Eichelberger
 */
public interface IDecisionVariable extends IModelElement {

    /**
     * Returns the name of the variable.
     * 
     * @return the name of the variable
     */
    public String getName();
    
    /**
     * Returns the type of the variable.
     * 
     * @return the type of the variable, possibly adjusted by the model after adding
     *   this variable if the model supports fault-tolerance 
     */
    public String getType();
    
    /**
     * Returns the binding time of the variable.
     * 
     * @return the binding time, may be <b>null</b> if none is defined
     */
    public String getBindingTime(); // TODO HE: check whether we may need multiple ones

    /**
     * Returns the default value of the variable as specified as part of the variable
     * declaration in the underlying IVML model. For obtaining the actual value in 
     * a configuration, please refer to {@link #getValue()}.
     * 
     * @return the default value, may be <b>null</b> if none is defined, possibly 
     *   adjusted by the model after adding this variable if the model supports 
     *   fault-tolerance
     */
    public String getDefaultValue();

    /**
     * Returns the configured value for this variable. Please consider {@link #hasValue()}
     * and {@link #hasFrozenValue()} in order to judge the return value correctly.
     * 
     * @return the configured value for this variable, may be <b>null</b> if the actual
     *   value is null or if the variable has not been configured (see {@link #hasValue()})
     */
    public String getValue();
    
    /**
     * Returns whether there this variable has been configured with a value.
     * 
     * @return <code>true</code> if variable has been configured, <code>false</code> else
     */
    public boolean hasValue();

    /**
     * Returns whether the this variable has been configured and is frozen.
     * 
     * @return <code>true</code> if the configured value is frozen, <code>false</code> else
     */
    public boolean hasFrozenValue();

}
