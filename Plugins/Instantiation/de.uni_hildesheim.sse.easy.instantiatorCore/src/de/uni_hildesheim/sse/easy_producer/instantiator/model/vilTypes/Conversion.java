package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for the singleton instance of a type class. Conversions must 
 * accept one parameter (compatible to the the declaring class) and return the type
 * of the converted result. Conversion operations must be static, public and not abstract.
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Conversion {
    
}
