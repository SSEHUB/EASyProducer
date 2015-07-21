package de.uni_hildesheim.sse.easy.ant;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy.ant.instantiators.Ant;
import de.uni_hildesheim.sse.easy.ant.instantiators.Make;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IRegistration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Registers the ANT additions to VIL.
 * 
 * @author Holger Eichelberger
 */
public class Registration implements IRegistration {

    private static boolean registered = false;
    
    /**
     * Registers the ANT artifacts and instantiators.
     */
    public static final void register() {
        if (!registered) {
            registered = true;
            TypeRegistry.DEFAULT.register(Ant.class);
            TypeRegistry.DEFAULT.register(Make.class);
        }
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        register();
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
    }

}
