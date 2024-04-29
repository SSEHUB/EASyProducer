package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines assignment compatible (equivalent) classes. This is intended for basic / primitive types.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassEquivalentTo {
    
    /**
     * Defines assignment compatible (equivalent) classes. This is intended for 
     * basic / primitive types. Primitive types shall be referred by their wrappers
     * and will be considered transparently.
     * 
     * @return the equivalent classes (none/neutral is the empty array)
     */
    Class<?>[] value(); // java 17 does not compile empty non-constant arrays as defaults anymore
    
}
