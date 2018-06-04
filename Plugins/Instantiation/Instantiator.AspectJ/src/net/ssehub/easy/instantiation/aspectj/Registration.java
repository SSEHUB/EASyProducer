package net.ssehub.easy.instantiation.aspectj;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.instantiation.aspectj.instantiators.AspectJ;
import net.ssehub.easy.instantiation.core.JavaUtilities;
import net.ssehub.easy.instantiation.core.model.vilTypes.IRegistration;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Registers the Java additions to VIL.
 * 
 * @author Holger Eichelberger
 */
public class Registration implements IRegistration {

    private static boolean registered = false;
    
    /**
     * Registers the Java artifacts and instantiators.
     */
    public static final void register() {
        if (!registered) {
            registered = true;
            TypeRegistry.DEFAULT.register(AspectJ.class);
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
    
    /**
     * Checks whether the AspectJ instantiator will work in this environment, e.g., not
     * due to Java 9.
     * 
     * @return a message if the instantiator will not work, <b>null</b> else
     */
    public static String checkEnvironment() {
        //  return JavaUtilities.isJava9() ? "AspectJ is not available for JDK 9" : null;
        return null; // ok, since AspectJ 1.9.1
    }

}
