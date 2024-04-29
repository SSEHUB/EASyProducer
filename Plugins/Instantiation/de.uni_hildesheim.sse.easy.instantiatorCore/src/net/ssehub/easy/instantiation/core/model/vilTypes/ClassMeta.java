package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for classes to rename classes as they shall appear in VIL. For detailing information, see 
 * {@link ClassEquivalentTo} and {@link ClassNotAssignable}. Those detailing annotations can be used without 
 * {@link ClassMeta}.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassMeta {
    
    /**
     * The actual name of the operation as it shall appear in VIL. This supersedes the 
     * original operation name.
     * 
     * @return the name
     */
    String name() default "";
    
    /**
     * Search this class for further operations. This is in particular helpful
     * for operations or conversions on interfaces. Object disables this.<br/>
     * 
     * @return the class containing further operations
     */
    Class<?> furtherOperations() default Object.class;
}
