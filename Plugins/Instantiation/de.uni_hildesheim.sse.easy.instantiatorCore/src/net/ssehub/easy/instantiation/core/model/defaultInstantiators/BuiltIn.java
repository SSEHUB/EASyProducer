package net.ssehub.easy.instantiation.core.model.defaultInstantiators;

import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

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
            TypeRegistry.DEFAULT.register(RandomDouble.class);
            TypeRegistry.DEFAULT.register(RandomInteger.class);
            TypeRegistry.DEFAULT.register(IntegerSequenceConstructors.class);
            TypeRegistry.DEFAULT.register(Println.class);
            
            TemplateLangExecution.registerDefaultExtension(DefaultVtlJavaExtension.class);
        }
    }


}
