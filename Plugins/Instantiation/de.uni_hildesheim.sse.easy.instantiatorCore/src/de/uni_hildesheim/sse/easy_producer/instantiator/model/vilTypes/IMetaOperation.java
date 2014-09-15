package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * Describes an operation defined for a {@link IMetaType}.
 * This interface is used for generic type compliance checks.
 * Please note that named arguments are passed in terms of a map as the last parameter
 * of the respective method. If the underlying Java method takes such a parameter, 
 * the descriptor will count one parameter less!
 * 
 * @author Holger Eichelberger
 */
public interface IMetaOperation {

    /**
     * Returns the name of the method.
     * 
     * @return the name of the method
     */
    public String getName();
    
    /**
     * Returns whether this operation is static.
     * 
     * @return <code>true</code> if it is static, <code>false</code> else
     */
    public boolean isStatic();
    
    /**
     * Returns whether the first parameter is the operand.
     * 
     * @return <code>true</code> if the first parameter is the operand, <code>false</code> else
     */
    public boolean isFirstParameterOperand();
    
    /**
     * Returns the number of parameters.
     * 
     * @return the number of parameter
     */
    public int getParameterCount();
    
    /**
     * Returns the specified parameter type.
     * 
     * @param index the index of the parameter to return
     * @return the specified parameter type
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getParameterCount()}</code>
     */
    public IMetaType getParameterType(int index);

    /**
     * Returns the java-like signature of this operation.
     * 
     * @return the java-like Java signature of this operation
     */
    public String getJavaSignature();

    /**
     * Returns the signature of the method (in terms of VIL types where possible).
     * 
     * @return the signature of the method
     */
    public String getSignature();
    
    /**
     * Returns the return type of this operation.
     * 
     * @return the return type
     */
    public IMetaType getReturnType();

    /**
     * Returns whether the operation accepts named parameters.
     * 
     * @return <code>true</code> if it accepts named parameters, <code>false</code> else
     */
    public boolean acceptsNamedParameters();

    /**
     * Returns the declaring type.
     * 
     * @return the declaring type (may be <b>null</b> in case of a wrapped external Java method)
     */
    public IMetaType getDeclaringType();

    /**
     * Returns whether this operation is valid or whether it is a placeholder operation in case that the original
     * operation cannot be resolved but the script shall remain executable.
     * 
     * @return <code>true</code> if this operation is a placeholder, <code>false</code> else
     */
    public boolean isPlaceholder();
    
}
