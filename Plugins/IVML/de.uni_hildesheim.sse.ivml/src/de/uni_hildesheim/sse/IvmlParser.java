package de.uni_hildesheim.sse;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Registers IMVL automatically.
 * 
 * @author Holger Eichelberger
 */
public class IvmlParser implements IParser {
    
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
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
    }

}
