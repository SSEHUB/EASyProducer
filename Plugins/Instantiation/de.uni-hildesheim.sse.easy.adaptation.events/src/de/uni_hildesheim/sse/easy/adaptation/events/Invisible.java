package de.uni_hildesheim.sse.easy.adaptation.events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation for class methods that shall be invisible to the adaptation behavior language
 * (rt-VIL). This annotation corresponds to the equally named annotation of the InstantiatorCore.
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
