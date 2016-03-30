package net.ssehub.easy.producer.core.persistence.standard;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.EclipseResourceInitializer;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.dslCore.TopLevelModelAccessor;
import net.ssehub.easy.dslCore.TopLevelModelAccessor.IModelAccessor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.producer.core.persistence.internal.Activator;
import net.ssehub.easy.varModel.management.VarModel;

/**
 * This singelton class controls the {@link net.ssehub.easy.dslCore.IResourceInitializer} for the EASyPeristencer.
 * @author El-Sharkawy
 *
 */
public abstract class EASyInitializer {
    
    public static final String IVML_EXTENSION = ModelUtility.INSTANCE.getExtension();
    public static final String VIL_EXTENSION = BuildLangModelUtility.INSTANCE.getExtension();
    public static final String VTL_EXTENSION = TemplateLangModelUtility.INSTANCE.getExtension();
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(EASyInitializer.class
        , Activator.PLUGIN_ID);    
    
    /**
     * Registers the {@link net.ssehub.easy.dslCore.ModelUtility}s to the Models, if it was not already done by
     * the descriptive services.
     */
    public static void setInitializer() {
        setInitializer(false);
        ProgressObserver observer = ProgressObserver.NO_OBSERVER;
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, observer);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        
        try {
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, observer);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        
        try {
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, observer);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        
        for (IModelAccessor<?> accessor : TopLevelModelAccessor.registered()) {
            try {
                accessor.registerLoader(observer);
            } catch (ModelManagementException e) {
                LOGGER.exception(e);
            }
        }
    }
    
    /**
     * Changes the {@link net.ssehub.easy.dslCore.IResourceInitializer} of all
     * {@link net.ssehub.easy.dslCore.ModelUtility}s.
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
