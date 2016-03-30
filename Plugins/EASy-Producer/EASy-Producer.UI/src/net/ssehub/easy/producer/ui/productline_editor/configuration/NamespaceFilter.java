package net.ssehub.easy.producer.ui.productline_editor.configuration;

import net.ssehub.easy.producer.ui.confModel.GUIVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;

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
