package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for providing details for a VIL operation implementation. For detailing
 * operation parameters, see {@link ParameterMeta}.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationMeta {
    
    /**
     * The actual names of the operation as it shall appear in VIL. This supersedes the 
     * original operation name.
     * 
     * @return the name
     */
    String[] name() default { };
    
    /**
     * Which names from {@link #name()} is not OCL compliant. Only aliases shall be given here.
     * 
     * @return the names
     */
    String[] notOclCompliant() default {};
    
    /**
     * The type of this operation.<br/>
     * The operation type ({@link OperationType#NORMAL} by default)
     * 
     * @return the type
     */
    OperationType opType() default OperationType.NORMAL;

    /**
     * The generic parameters of the return type. This is required as the type parameters
     * of Java generics cannot be accessed. Generics of complex types are just given in 
     * linear sequence. Empty by default. Might be replaced by new reflection functions in Java 8.
     * 
     * @return the generic parameter types
     */
    Class<?>[] returnGenerics() default { };
    
    /**
     * Whether a generic parameter (index) of the operand shall be used as return type. 
     * Unused by default. Disregards first implicit parameter. Only for collection operations.<br/>
     * 
     * @return the 0-based parameter index (default <code>-1</code>)
     */
    int useGenericParameter() default -1;

    /**
     * Whether a parameter (0-based index) shall be used as return type. 
     * Unused by default (<code>-1</code>). If <code>Integer.MAX_VALUE</code> all
     * parameters are taken over.
     * 
     * @return the 0-based index
     */
    int useParameter() default -1;
    
    /**
     * Use the actual operand type as parameter.
     * 
     * @return the operand type
     */
    boolean useOperandTypeAsParameter() default false;
    
    /**
     * Whether artifacts in the current context shall be stored before executing this operation.
     * Such operations have more precendece than dynamic auto-store preferences (exclusion) in 
     * {@link RuntimeEnvironment the runtime environment}.
     * 
     * @return whether artifacts in the current context shall be stored before executing this operation
     */
    boolean storeArtifactsBefore() default false;
    
    /**
     * Indicates whether this function requires dynamic expression processing and may cause problems with 
     * serialized models in standalone settings without xText.<br/>
     * 
     * Whether dynamic expression processing is required (default <code>false</code>)
     * 
     * @return whether dynamic expression processing is required
     */
    boolean requiresDynamicExpressionProcessing() default false;
    
    /**
     * Disables tracing the execution, e.g., in case of output operations.<br/>
     * 
     * @return whether tracing is enabled (default <code>true</code>)
     */
    boolean trace() default true;
    
    /**
     * Denotes the index values of the generic parameters to be replaced by the given argument types. Negative values
     * indicate that the given argument types shall be used. May be required to force / enable automatic conversion.
     * <br/>
     * 
     * @return the generic arguments as 0-based indexes
     */
    int[] genericArgument() default { };
    
    /**
     * Whether iterator aggregation (first declarator with default value denotes result value and type) is supported
     * or not. Default is not supported.<br/>
     * 
     * @return <code>true</code> if iterator aggregation is supported, <code>false</code> (default)
     */
    boolean allowsAggregation() default false;
    
    /**
     * If Any/Object is the return type, don't override this when resolving expression results.
     * 
     * @return if Any/Object is the return type
     */
    boolean useAny() default false;
    
    /**
     * Whether the result type shall be flattened to a non-collection type.
     * 
     * @return flatten if {@code true}, no flattening if {@code false}
     */
    boolean flatten() default false;
    
}
