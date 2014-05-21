package de.uni_hildesheim.sse.easy.java;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy.java.artifacts.ClassFileArtifact;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaAnnotation;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaAttribute;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaClass;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaFileArtifact;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaMethod;
import de.uni_hildesheim.sse.easy.java.instantiators.AspectJ;
import de.uni_hildesheim.sse.easy.java.instantiators.CocktailInstantiator;
import de.uni_hildesheim.sse.easy.java.instantiators.Jar;
import de.uni_hildesheim.sse.easy.java.instantiators.Javac;
import de.uni_hildesheim.sse.easy.java.instantiators.Unjar;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IRegistration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

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
            TypeRegistry.DEFAULT.register(AspectJ.class);

            TypeRegistry.DEFAULT.register(CocktailInstantiator.class);

            TypeRegistry.DEFAULT.register(ClassFileArtifact.class);
            TypeRegistry.DEFAULT.register(JavaFileArtifact.class);
            TypeRegistry.DEFAULT.register(JavaClass.class);
            TypeRegistry.DEFAULT.register(JavaMethod.class);
            TypeRegistry.DEFAULT.register(JavaAttribute.class);
            TypeRegistry.DEFAULT.register(JavaAnnotation.class);
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
