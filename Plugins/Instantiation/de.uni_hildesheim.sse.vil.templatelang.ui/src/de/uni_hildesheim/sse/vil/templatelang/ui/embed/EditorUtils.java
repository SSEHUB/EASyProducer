package de.uni_hildesheim.sse.vil.templatelang.ui.embed;

import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.dslcore.ui.editors.EmbeddingHelper;
import de.uni_hildesheim.sse.vil.templatelang.ui.internal.TemplateLangActivator;

/**
 * Provides editor utility methods.
 * 
 * @author Holger Eichelberger
 */
public class EditorUtils {

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
     */
    public static void embedVtlEditor(final java.net.URI file, Composite parent) {
        TemplateLangActivator activator = TemplateLangActivator.getInstance();
        Injector injector = activator.getInjector(
            TemplateLangActivator.DE_UNI_HILDESHEIM_SSE_VIL_TEMPLATELANG_TEMPLATELANG);
        EmbeddingHelper.embedEditor(file, parent, injector);
    }

}
