package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IRegistration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInitializer;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInitializer.IModelInitializer;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Registers the serialization additions to VIL.
 * 
 * @author Aike Sass
 */
public class Registration implements IRegistration, IModelInitializer {

    private static boolean registered = false;
    
    /**
     * Registers the model serialization and instantiators.
     */
    public static final void register() {
        if (!registered) {
            registered = true;
            TypeRegistry.DEFAULT.register(ModelSerializer.class);
            TypeRegistry.DEFAULT.register(ModelDeserializer.class);
        }
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        register();
        ModelInitializer.register(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        ModelInitializer.unregister(this);
    }

    @Override
    public void addLocation(File location, ProgressObserver observer) throws ModelManagementException {
        // TODO if location is file, load the model - else ignore
        // TODO derive VIL.xml by convention
    }

    @Override
    public void removeLocation(File location, ProgressObserver observer) throws ModelManagementException {
        // TODO check if removing the location is needed 
    }

    @Override
    public void registerLoader(ProgressObserver observer) throws ModelManagementException {
        // TODO check if this is needed
    }

    @Override
    public void unregisterLoader(ProgressObserver observer) throws ModelManagementException {
        // TODO check if this is needed
    }

}
