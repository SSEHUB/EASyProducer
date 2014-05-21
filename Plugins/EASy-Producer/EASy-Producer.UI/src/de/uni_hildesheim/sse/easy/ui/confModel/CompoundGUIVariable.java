package de.uni_hildesheim.sse.easy.ui.confModel;

import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * GUI representation of compound values.
 * @author El-Sharkawy
 *
 */
class CompoundGUIVariable extends AbstractExpandableGUIVariable {
    
    /**
     * Sole constructor for this class.
     * @param variable The {@link IDecisionVariable} represented by this GUIVariable
     * @param parent The controlling composite, needed for the creation of CellEditors
     * @param config The {@link GUIConfiguration} holding this GUIVariable
     * @param varParent The parent GUIVariable holding this variable. Can be <tt>null</tt> if and only if this variable
     * is a top level variable stored inside the configuration.
     */
    CompoundGUIVariable(IDecisionVariable variable, Composite parent, GUIConfiguration config, GUIVariable varParent) {
        super(variable, parent, config, varParent);
    }


    @Override
    public String getValueText() {
        String result;
        if (hasValue() && hasNullValue()) {
            result = GUIVariable.NULL_VALUE_LABEL;
        } else {
            //checkstyle: stop exception type check 
            try {
                result = getVariable().getState().toString();
            } catch (Throwable t) {
                result = "";
            }
            //checkstyle: resume exception type check 
        }
        return result;
    }

    @Override
    public Object getValue() {
        // TODO Auto-generated method stub
        return null;
    }
    
    // TODO listener to reflect changes in textual representation of container
}
