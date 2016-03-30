package net.ssehub.easy.producer.ui.productline_editor.configuration;

import net.ssehub.easy.producer.ui.confModel.GUIVariable;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IAssignmentState;

/**
 * Filters variables which are in a specific state.
 * @author El-Sharkawy
 *
 */
class AssignmentStateFilter extends AbstractConfigurationFilter {
    
    private AssignmentState state;
    
    /**
     * Sole constructor for this class.
     * @param state Specifies which variables should be visible and which variables should be hidden:
     * <ul>
     * <li>{@link AssignmentState#UNDEFINED} - Shows only variables (and their parents) which are not configured.</li>
     * <li>{@link AssignmentState#ASSIGNED} - Shows only variables (and their parents) which are configured
     *     and not frozen. This also included default and derived values.</li>
     * <li>{@link AssignmentState#DERIVED} - Shows only variables (and their parents) which are configured
     *     by the reasoner.</li>
     * <li>{@link AssignmentState#FROZEN} - Shows only variables (and their parents) which are frozen.</li>
     * </ul>
     */
    AssignmentStateFilter(AssignmentState state) {
        this.state = state;
    }

    @Override
    protected boolean checkVariable(GUIVariable variable) {
        boolean showVariable = false;
        IAssignmentState variablesState = variable.getAssignmentState();
        //Determine correct test method
        switch (state) {
        case UNDEFINED:
            showVariable = variablesState == AssignmentState.UNDEFINED;
            break;
        case ASSIGNED:
            //falls through
        case DEFAULT:
            showVariable = variablesState == AssignmentState.ASSIGNED || variablesState == AssignmentState.ASSIGNED
                || variablesState == AssignmentState.DERIVED;
            break;
        case DERIVED:
            showVariable = variablesState == AssignmentState.DERIVED;
            break;
        case FROZEN:
            showVariable = variablesState == AssignmentState.FROZEN;
            break;
        default:
            showVariable = true;
            break;
        }
        
        for (int i = 0; i < variable.getNestedElementsCount() && !showVariable; i++) {
            GUIVariable nestedVariable = variable.getNestedElement(i);
            showVariable |= checkVariable(nestedVariable);
        }
        
        return showVariable;
    }

}
