package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;

/**
 * A filter for showing only variables of a given namespace (project name).
 * @author El-Sharkawy
 *
 */
class NamespaceFilter extends AbstractConfigurationFilter {
    
    private String namespace;

    /**
     * Sole constructor for this class.
     * @param namespace A project name (namespace) only variables having exactly the same
     *     namespace will be returned.
     */
    NamespaceFilter(String namespace) {
        this.namespace = namespace;
    }
    
    @Override
    protected boolean checkVariable(GUIVariable variable) {
        boolean showVariable = false;
        AbstractVariable decl = variable.getVariable().getDeclaration();
        if (decl.getNameSpace().equalsIgnoreCase(namespace.trim())) {
            showVariable = true;
        }
        
        // Make parent visible, if a nested variable shall be visible
        for (int i = 0; i < variable.getNestedElementsCount() && !showVariable; i++) {
            showVariable = checkVariable(variable.getNestedElement(i));
        }
        
        return showVariable;
    }

}
