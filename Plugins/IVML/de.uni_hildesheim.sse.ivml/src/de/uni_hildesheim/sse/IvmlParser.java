package de.uni_hildesheim.sse;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.AbstractModelInitializer;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelInitializer;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

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
