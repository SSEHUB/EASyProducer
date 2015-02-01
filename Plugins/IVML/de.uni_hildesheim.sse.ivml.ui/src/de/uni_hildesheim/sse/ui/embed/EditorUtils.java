package de.uni_hildesheim.sse.ui.embed;

import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.dslcore.ui.editors.EmbeddingHelper;
import de.uni_hildesheim.sse.ui.internal.IvmlActivator;

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
     * Embeds an IVML editor for the given resource into the given <code>parent</code>.
     * 
     * @param file the file representing the resource
     * @param parent the parent UI component
     */
    public static void embedIvmlEditor(final java.net.URI file, Composite parent) {
        IvmlActivator activator = IvmlActivator.getInstance();
        Injector injector = activator.getInjector(IvmlActivator.DE_UNI_HILDESHEIM_SSE_IVML);
        EmbeddingHelper.embedEditor(file, parent, injector);
    }

}
