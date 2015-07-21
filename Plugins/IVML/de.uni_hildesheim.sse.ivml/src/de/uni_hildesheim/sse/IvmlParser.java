package de.uni_hildesheim.sse;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.AbstractModelInitializer;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInitializer;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Registers IMVL automatically.
 * 
 * @author Holger Eichelberger
 */
public class IvmlParser extends AbstractModelInitializer<Project> implements IParser {
    
    // no private constructor!!!
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            EASyLoggerFactory.INSTANCE.getLogger(IvmlParser.class, IvmlBundleId.ID);
        }
        ModelInitializer.register(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        ModelInitializer.unregister(this);
    }

    @Override
    protected ModelManagement<Project> getModelManagement() {
        return VarModel.INSTANCE;
    }

    @Override
    protected IModelLoader<Project> getModelLoader() {
        return null; // done above
    }

}
