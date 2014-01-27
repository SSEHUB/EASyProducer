package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for methods which shall be invisible to the dynamic 
 * dispatch mechanism, i.e., which shall not be recognized as artifact types or 
 * artifact operations (internal operations of the artifact model). Constructors 
 * and files are not visible per se. Further, certain basic methods such as those
 * in <code>java.lang.Object</code> are invisible by default (see also 
 * {@link TypeRegistry#INVISIBLE_BY_DEFAULT} for all such classes).
 * 
 * @author Holger Eichelberger
 */
@Target({ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Invisible {
    
    /**
     * Whether this annotation shall be inherited by subclasses / overridden methods (default <code>false</code>).
     */
    boolean inherit() default false;
}
