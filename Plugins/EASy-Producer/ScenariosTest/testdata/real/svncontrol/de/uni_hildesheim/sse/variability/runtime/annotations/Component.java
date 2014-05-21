package de.uni_hildesheim.sse.variability.runtime.annotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Defines an annotation for components.
 * 
 * @author Holger Eichelberger
 * @since 1.10
 * @version 1.10
 */
@Target(value = { TYPE } )
@Retention(value = SOURCE)
public @interface Component {

    /**
     * The unique identification of the decision assigned
     * to this component [not nice, to be replaced by 
     * decision table artifact information].
     * 
     * @since 1.00
     */
    String boundTo();

    /**
     * Defines the deletion strategy for this component, i.e.
     * if it should be considered during packaging the final
     * application or not. Use <code>true</code> if this 
     * should be packaged always, <code>false</code> if the 
     * setting of the decision decides
     */
    boolean packageAlways();
    
    /**
     * Defines the generator strategy for this component, i.e.
     * if the entire component should be replaced by appropriate
     * code. Use <code>true</code> if replacement is needed (strongly
     * coupled code), <code>false</code> else (e.g. encapsulated
     * by interface)
     */
    boolean replaceThis();
    
}
