package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for methods in order to rename an operation or to mark it as infix.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationMeta {
    
    /**
     * The actual names of the operation as it shall appear in VIL. This supersedes the 
     * original operation name.
     */
    String[] name() default { };
    
    /**
     * The type of this operation.
     */
    OperationType opType() default OperationType.NORMAL;

    /**
     * The generic parameters of the return type. This is required as the type parameters
     * of Java generics cannot be accessed. Empty by default.
     */
    Class<?>[] returnGenerics() default { };
    
    /**
     * Whether a generic parameter (index) of the operand shall be used as return type. 
     * Unused by default.
     */
    int useGenericParameter() default -1;
    
    /**
     * Whether artifacts in the current context shall be stored before executing this operation.
     */
    boolean storeArtifactsBefore() default false;
}
