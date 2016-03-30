package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

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
