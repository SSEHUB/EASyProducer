package de.uni_hildesheim.sse.easy_producer.core.persistence.standard;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.EclipseResourceInitializer;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.internal.Activator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;

/**
 * This singelton class controls the {@link de.uni_hildesheim.sse.dslCore.IResourceInitializer} for the EASyPeristencer.
 * @author El-Sharkawy
 *
 */
public abstract class EASyInitializer {
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(EASyInitializer.class
        , Activator.PLUGIN_ID);    
    
    /**
     * Registers the {@link de.uni_hildesheim.sse.dslCore.ModelUtility}s to the Models, if it was not already done by
     * the descriptive services.
     */
    public static void setInitializer() {
        setInitializer(false);
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        
        try {
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        
        try {
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE,
                ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
    }
    
    /**
     * Changes the {@link de.uni_hildesheim.sse.dslCore.IResourceInitializer} of all
     * {@link de.uni_hildesheim.sse.dslCore.ModelUtility}s.
     * @param runsInEclipse <tt>true</tt> if the {@link EclipseResourceInitializer} should be used,
     *     <tt>false</tt> if the {@link StandaloneInitializer} should be used.
     */
    public static void setInitializer(boolean runsInEclipse) {
        if (runsInEclipse) {
            ModelUtility.setResourceInitializer(new EclipseResourceInitializer());
        } else {
            ModelUtility.setResourceInitializer(new StandaloneInitializer());
        }
    }
}
