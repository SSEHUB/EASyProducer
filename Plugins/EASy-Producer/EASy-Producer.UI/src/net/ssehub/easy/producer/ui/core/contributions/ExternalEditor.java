package net.ssehub.easy.producer.ui.core.contributions;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

/**
 * Enables to plug in external editors.
 * 
 * @author Holger Eichelberger
 */
public abstract class ExternalEditor {

    private static final List<ExternalEditor> REGISTERED = new ArrayList<ExternalEditor>();

    /**
     * Embeds this editor for the given <code>uri</code> into the given <code>parent</code>.
     * 
     * @param uri the URI representing the resource to be read
     * @param parent the parent composite
     * @return <code>true</code> if this editor was embedded, <code>false</code> else
     */
    protected abstract boolean embedEditorImpl(URI uri, Composite parent);

    /**
     * Returns whether this editor plugin provides an editor for the given <code>uri</code>.
     * 
     * @param uri the URI representing the resource to be read
     * @return <code>true</code> if an editor can be provided, <code>false</code> else
     */
    protected abstract boolean providesEditorForImpl(java.net.URI uri);

    /**
     * Registers the external editor plugin.
     * 
     * @param editor the plugin to be unregistered
     */
    public static void register(ExternalEditor editor) {
        if (null == editor) {
            throw new IllegalArgumentException("null");
        }
        REGISTERED.add(editor);
    }

    /**
     * Unregisters the external editor plugin.
     * 
     * @param editor the plugin to be unregistered
     */
    public static void unregister(ExternalEditor editor) {
        if (null == editor) {
            throw new IllegalArgumentException("null");
        }
        REGISTERED.add(editor);
    }

    /**
     * Embeds an editor for the given <code>uri</code> into the given <code>parent</code>.
     * 
     * @param uri the URI representing the resource to be read
     * @param parent the parent composite
     * @return <code>true</code> if an editor was embedded, <code>false</code> else
     */
    public static boolean embedEditor(URI uri, Composite parent) {
        boolean done = false;
        for (int r = 0; !done && r < REGISTERED.size(); r++) {
            ExternalEditor editor = REGISTERED.get(r);
            if (editor.providesEditorForImpl(uri)) {
                done = REGISTERED.get(r).embedEditorImpl(uri, parent);
            }
        }
        return done;
    }
    
    /**
     * Returns whether any editor plugin provides an editor for the given <code>uri</code>.
     * 
     * @param uri the URI representing the resource to be read
     * @return <code>true</code> if an editor can be provided, <code>false</code> else
     */
    public static boolean providesEditorFor(URI uri) {
        boolean provides = false;
        for (int r = 0; !provides && r < REGISTERED.size(); r++) {
            provides = REGISTERED.get(r).providesEditorForImpl(uri);
        }
        return provides;
    }
    
}
