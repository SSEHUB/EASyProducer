package de.uni_hildesheim.sse.vil.rt.ui.embed;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.osgi.service.component.ComponentContext;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.vil.rt.RtVilModelUtility;
import de.uni_hildesheim.sse.vil.rt.ui.RtVilModelListener;
import de.uni_hildesheim.sse.vil.rt.ui.internal.RtActivator;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.dslCore.TopLevelModelAccessor;
import net.ssehub.easy.dslCore.TopLevelModelAccessor.AbstractModelAccessor;
import net.ssehub.easy.dslCore.TopLevelModelAccessor.IModelAccessor;
import net.ssehub.easy.dslCore.ui.EditorEmbedderFactory;
import net.ssehub.easy.dslCore.ui.EditorEmbedderFactory.IEditorCreator;
import net.ssehub.easy.dslCore.ui.editors.AbstractModelChangeListener;
import net.ssehub.easy.dslCore.ui.editors.EmbeddingHelper;
import net.ssehub.easy.dslCore.ui.editors.IEmbeddedEditor;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer.IHeader;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer.IModelEditorConfigurer;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Bundle;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * Provides editor utility methods.
 * 
 * @author Holger Eichelberger
 */
public class EditorUtils implements IEditorCreator {

    public static final String EXTENSION = RtVilModelUtility.INSTANCE.getExtension();
    
    private static final IModelEditorConfigurer CONFIGURER = new IModelEditorConfigurer() {
        
        @Override
        public String getPageTitle(boolean editable) {
            return "Adaptation Model";
        }
        
        @Override
        public String getEditorTitle(boolean editable) {
            return "Adaptation Model " + (editable ? "Editor" : "Viewer");
        }

        @Override
        public String getExtension() {
            return EXTENSION;
        }
        
        @Override
        public int getOrdinal() {
            return 10;
        }

        @Override
        public boolean hasHeader() {
            return true;
        }

        @Override
        public IHeader createHeader(Composite parent, Configuration config, File base, ModelInfo<?> info) {
            return new HeaderPanel(parent, config, base, info);
        }

        @Override
        public AbstractModelChangeListener getModelChangeListener() {
            return new RtVilModelListener();
        }
        
    };

    private static final IModelAccessor<Script> ACCESSOR 
        = new AbstractModelAccessor<Script>(RtVilModelUtility.INSTANCE) {

        @Override
        public ModelInfo<Script> getModelInfo(String projectName, Object project) {
            // currently, there is no full EASy integration / convention, search for the rt-VIL model with project name
            // and largest version number (if given)
            List<ModelInfo<Script>> infos = RtVilModel.INSTANCE.availableModels().getModelInfo(projectName);
            ModelInfo<Script> result = null;
            Version maxVer = null;
            if (null != infos && !infos.isEmpty()) {
                for (int i = 0; i < infos.size(); i++) {
                    ModelInfo<Script> tmp = infos.get(i);
                    if (null == maxVer || Version.compare(maxVer, tmp.getVersion()) < 0) {
                        result = tmp;
                    }
                }
            }
            if (null != result && !result.isResolved()) {
                try {
                    getModelManagement().load(result);
                } catch (ModelManagementException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
                }
            }
            return result;
        }

        @Override
        public ModelManagement<Script> getModelManagement() {
            return RtVilModel.INSTANCE;
        }

        @Override
        public String getPathKindHint() {
            return "VIL";
        }

    };

    /**
     * Creates an instance (public constructor required by OSGI-DS).
     */
    public EditorUtils() {
    }
    
    /**
     * Embeds an VTL editor for the given resource into the given <code>parent</code>.
     * 
     * @param file the file representing the resource
     * @param parent the parent UI component
     * @return the editor viewer
     */
    public static IEmbeddedEditor embedRtVilEditor(final java.net.URI file, Composite parent) {
        RtActivator activator = RtActivator.getInstance();
        Injector injector = activator.getInjector(RtActivator.DE_UNI_HILDESHEIM_SSE_VIL_RT_RTVIL);
        return EmbeddingHelper.embedEditor(file, parent, injector);
    }

    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        TopLevelModelAccessor.register(EXTENSION, ACCESSOR);
        EditorEmbedderFactory.register(EXTENSION, this);
        ModelEditorConfigurer.register(CONFIGURER);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        TopLevelModelAccessor.unregister(EXTENSION);
        EditorEmbedderFactory.unregister(EXTENSION);
        ModelEditorConfigurer.unregister(CONFIGURER);
    }

    @Override
    public IEmbeddedEditor embedEditor(URI resourceURI, Composite composite) {
        return embedRtVilEditor(resourceURI, composite);
    }

}
