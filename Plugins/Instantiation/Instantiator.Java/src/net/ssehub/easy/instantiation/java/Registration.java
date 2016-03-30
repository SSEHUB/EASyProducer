package net.ssehub.easy.instantiation.java;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.instantiation.core.model.vilTypes.IRegistration;
import net.ssehub.easy.instantiation.core.model.vilTypes.SettingsInitializerRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.java.artifacts.ClassFileArtifact;
import net.ssehub.easy.instantiation.java.artifacts.JavaAnnotation;
import net.ssehub.easy.instantiation.java.artifacts.JavaAssignment;
import net.ssehub.easy.instantiation.java.artifacts.JavaAttribute;
import net.ssehub.easy.instantiation.java.artifacts.JavaCall;
import net.ssehub.easy.instantiation.java.artifacts.JavaClass;
import net.ssehub.easy.instantiation.java.artifacts.JavaFileArtifact;
import net.ssehub.easy.instantiation.java.artifacts.JavaImport;
import net.ssehub.easy.instantiation.java.artifacts.JavaMethod;
import net.ssehub.easy.instantiation.java.instantiators.CocktailInstantiator;
import net.ssehub.easy.instantiation.java.instantiators.Jar;
import net.ssehub.easy.instantiation.java.instantiators.Javac;
import net.ssehub.easy.instantiation.java.instantiators.Unjar;

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
            TypeRegistry.DEFAULT.register(Javac.class);
            TypeRegistry.DEFAULT.register(Jar.class);
            TypeRegistry.DEFAULT.register(Unjar.class);

            TypeRegistry.DEFAULT.register(CocktailInstantiator.class);

            TypeRegistry.DEFAULT.register(ClassFileArtifact.class);
            TypeRegistry.DEFAULT.register(JavaFileArtifact.class);
            TypeRegistry.DEFAULT.register(JavaClass.class);
            TypeRegistry.DEFAULT.register(JavaMethod.class);
            TypeRegistry.DEFAULT.register(JavaAttribute.class);
            TypeRegistry.DEFAULT.register(JavaAnnotation.class);
            TypeRegistry.DEFAULT.register(JavaCall.class);
            TypeRegistry.DEFAULT.register(JavaAssignment.class);
            SettingsInitializerRegistry.register(new JavaSettingsInitializer());
            TypeRegistry.DEFAULT.register(JavaSettings.class);
            TypeRegistry.DEFAULT.register(JavaImport.class);
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
