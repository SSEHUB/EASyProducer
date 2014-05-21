package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Initializes built-in VIL instantiators.
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
            TypeRegistry.DEFAULT.register(Zip.class);
            TypeRegistry.DEFAULT.register(Unzip.class);
            TypeRegistry.DEFAULT.register(VilTemplateProcessor.class);
        }
    }


}
