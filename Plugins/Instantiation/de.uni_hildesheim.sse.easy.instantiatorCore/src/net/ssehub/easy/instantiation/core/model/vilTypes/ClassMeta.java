package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for classes to rename classes as they shall appear in VIL.
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
     * Defines assignment compatible (equivalent) classes. This is intended for 
     * basic / primitive types. Primitive types shall be referred by their wrappers
     * and will be considered transparently.<br/>
     * 
     * @return the equivalent classes
     */
    Class<?>[] equiv() default { };
    
    /**
     * Defines explicitly non-assignable  classes for which assignment compatibility shall
     * not be possible. {@link #equiv()} takes precedence.<br/>
     * 
     * @return the non assignable classes
     */
    Class<?>[] nAssign() default { };
    
    /**
     * Search this class for further operations. This is in particular helpful
     * for operations or conversions on interfaces. Object disables this.<br/>
     * 
     * @return the class containing further operations
     */
    Class<?> furtherOperations() default Object.class;
}
