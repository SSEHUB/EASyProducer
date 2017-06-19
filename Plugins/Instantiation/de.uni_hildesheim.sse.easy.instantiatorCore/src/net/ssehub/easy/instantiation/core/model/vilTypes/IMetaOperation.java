package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.instantiation.core.model.common.VilException;

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
     * Returns the result of a type compatibility comparison.
     * 
     * @author Holger Eichelberger
     */
    public enum CompatibilityResult {
        
        /**
         * Types are compatible.
         */
        COMPATIBLE,
        
        /**
         * Types are incompatible.
         */
        INCOMPATIBLE,

        /**
         * Argument evaluates to <b>null</b>, i.e., stop expression evaluation.
         */
        ARG_EVALUATION_FAILED
    }
    
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
     * Returns the number of required parameters, i.e., non-default and non-named parameters.
     * 
     * @return the number of required parameters
     */
    public int getRequiredParameterCount();
    
    /**
     * Returns a named parameter declaration.
     * 
     * @param name the name of the parameter
     * @return the declaration or <b>null</b> if there is none
     */
    public IMetaParameterDeclaration getParameter(String name);

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
    
    /**
     * Returns whether the operation represented by this instance is compatible to
     * the given return type and parameters. This method does not consider possible
     * unnamed parameter rather than the underlying Java parameter.
     * 
     * @param retType the return type (may be <b>null</b> in order to ignore this parameter)
     * @param params the parameters (may be <b>null</b> if there are none, may be classes)
     * @return an instance of {@link CompatibilityResult} denoting the actual compatibility level
     */
    public CompatibilityResult isCompatible(Class<?> retType, Object... params); 
    
    /**
     * Invokes the specified operation. This method does not consider possible
     * unnamed parameter rather than the underlying Java parameter. In case of {@link #acceptsNamedParameters()}
     * the caller must ensure that the last parameter is a <code>map&lt;String, Object&gt;</code> containing
     * the named parameters.
     * 
     * @param args the arguments, in case of non-static operations the first argument 
     *   must be the object to execute on
     * @return the result of the execution
     * @throws VilException if the invocation fails
     * 
     * @see #isCompatible
     */
    public Object invoke(Object... args) throws VilException;

}
