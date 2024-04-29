package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines explicitly non-assignable  classes for which assignment compatibility shall not be possible.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassNotAssignable {
    
    /**
     * Defines explicitly non-assignable  classes for which assignment compatibility shall
     * not be possible. {@link #equiv()} takes precedence.<br/>
     * 
     * @return the non assignable classes (none/neutral is the empty array)
     */
    Class<?>[] value(); // java 17 does not compile empty non-constant arrays as defaults anymore
    
}
