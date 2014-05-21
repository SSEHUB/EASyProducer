package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Initializes built-in VIL types.
 * 
 * @author Holger Eichelberger
 */
public class BuiltIn {
    
    private static boolean initialized = false;
    
    /**
     * Default built-in types.
     */
    public static synchronized void initialize() {
        if (!initialized) {
            initialized = true;
            TypeRegistry.DEFAULT.register(ExpressionEvaluator.class);
        }
    }

}
