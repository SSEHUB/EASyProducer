package de.uni_hildesheim.sse.easy.ui.productline_editor;

import org.eclipse.jface.viewers.TreeViewer;

import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.ConfigurationTableEditor;
import de.uni_hildesheim.sse.model.confModel.Configuration;

/**
 * An UI element factory (preliminary).
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationTableEditorFactory {

    /**
     * Just for now as the constructor of the target class is protected.
     * 
     * @author Holger Eichelberger
     */
    private static class ConfigTableEditor extends ConfigurationTableEditor {

        /**
         * Creates a configuration table editor.
         * 
         * @param configuration the actual configuration
         * @param parent the configuration parent
         */
        protected ConfigTableEditor(Configuration configuration, IEASyEditorPage parent) {
            super(configuration, parent);
        }
        
    }

    /**
     * Creates a configuration table editor.
     * 
     * @param configuration the configuration to be displayed / manipulated
     * @param parent the parent instance
     * @return the configuration table editor
     */
    public static final TreeViewer createConfigurationTableEditor(Configuration configuration, 
        IEASyEditorPage parent) {
        return new ConfigTableEditor(configuration, parent);
    }

}
