package de.uni_hildesheim.sse.easy.ui.confModel;

import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.model.confModel.ContainerVariable;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * GUI representation of container values.
 * @author El-Sharkawy
 *
 */
class ContainerGUIVariable extends AbstractExpandableGUIVariable {
    
    /**
     * Sole constructor for this class.
     * @param variable The {@link IDecisionVariable} represented by this GUIVariable
     * @param parent The controlling composite, needed for the creation of CellEditors
     * @param config The {@link GUIConfiguration} holding this GUIVariable
     * @param varParent The parent GUIVariable holding this variable. Can be <tt>null</tt> if and only if this variable
     * is a top level variable stored inside the configuration.
     */
    ContainerGUIVariable(IDecisionVariable variable, Composite parent, GUIConfiguration config, GUIVariable varParent) {
        super(variable, parent, config, varParent);
    }
    
    @Override
    public boolean isExtendable() {
        return true;
    }

    @Override
    public String getValueText() {
        String result;
        if (hasValue() && hasNullValue()) {
            result = GUIVariable.NULL_VALUE_LABEL;
        } else {
            //checkstyle: stop exception type check 
            try {
                result = StringProvider.toIvmlString(getVariable().getValue());
            } catch (Throwable t) {
                result = "";
            }
            //checkstyle: resume exception type check 
        }
        return result;
    }
    
    @Override
    public void remove(GUIVariable nestedVariable) {
        ContainerVariable relatedVariable = (ContainerVariable) getVariable();
        boolean found = relatedVariable.removeNestedElement(nestedVariable.getVariable());
        
        if (found) {
            //Notify Editor to become dirty
            getConfiguration().changed(this);
            // create nested GUIVariables
            createNestedVariables();
        }  
    }
    
    // TODO listener to reflect changes in textual representation of container and to change values in container itself

    @Override
    public Object getValue() {
        String value = "";
        if (null != getVariable().getValue() && null != getVariable().getValue().getValue()) {
            value = getVariable().getValue().getValue().toString();
        }
        
        return value;
    }
}
