package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a method as type specialization method.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeSpecialization {

}
