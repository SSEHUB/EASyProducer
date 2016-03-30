package net.ssehub.easy.instantiation.core.model;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.instantiation.core.model.templateModel.ExtensionClassLoaders;
import net.ssehub.easy.instantiation.core.model.vilTypes.IRegistration;

/**
 * Initializes built-in VIL types.
 * 
 * @author Holger Eichelberger
 */
public class BuiltIn implements IRegistration {

    // public or implicit no-arg constructor

    /**
     * Default built-in types. Called directly by test initialization.
     */
    public static synchronized void initialize() {
        net.ssehub.easy.instantiation.core.model.vilTypes.BuiltIn.initialize();
        net.ssehub.easy.instantiation.core.model.expressions.BuiltIn.initialize();
        net.ssehub.easy.instantiation.core.model.artifactModel.BuiltIn.initialize();
        net.ssehub.easy.instantiation.core.model.defaultInstantiators.BuiltIn.initialize();
    }

    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        initialize(); 
        ExtensionClassLoaders.registerLoader(getClass().getClassLoader());
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        ExtensionClassLoaders.unregisterLoader(getClass().getClassLoader());
    }

}
