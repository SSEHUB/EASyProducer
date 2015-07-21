package de.uni_hildesheim.sse.easy_producer.instantiator.model;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ExtensionClassLoaders;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IRegistration;

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
        de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.BuiltIn.initialize();
        de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.BuiltIn.initialize();
        de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.BuiltIn.initialize();
        de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.BuiltIn.initialize();
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
