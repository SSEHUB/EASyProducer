package net.ssehub.easy.producer.ui.productline_editor.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;

import net.ssehub.easy.producer.ui.confModel.GUIVariable;
import net.ssehub.easy.producer.ui.internal.TypeSelectionDialog;
import net.ssehub.easy.producer.ui.productline_editor.EasyProducerDialog;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Listener for the context menu of the {@link ConfigurationTableEditor}.
 * @author El-Sharkawy
 *
 */
public class EditorContextMenuListener implements SelectionListener {
    
    /**
     * Specifies the action which should be handled by the {@link EditorContextMenuListener} instance.
     * @author El-Sharkawy
     *
     */
    static enum Action {
        SET_NULL, REMOVE_VALUE, ANNOTATION_VIEW, CHANGE_COMPOUND_INSTANCE_TYPE;
    }
    
    private StructuredViewer viewer;
    private Action action;
    
    
    /**
     * Sole constructor for this listener.
     * @param viewer The {@link ConfigurationTableEditor} having a context menu.
     * @param action Specifies the action which shall be performed
     * by the specific menu item (must not be <code>null</code>).
     */
    public EditorContextMenuListener(StructuredViewer viewer, Action action) {
        this.viewer = viewer;
        this.action = action;
    }

    @Override
    public void widgetSelected(SelectionEvent evt) {
        GUIVariable var = getSelectedVariable();
        switch(action) {
        case SET_NULL:
            var.setNULLValue();
            break;
        case REMOVE_VALUE:
            var.setEmptyValue();
            break;
        case ANNOTATION_VIEW:
            AnnotationsViewDialog annotationsView = new AnnotationsViewDialog(viewer.getControl().getShell(), var);
            annotationsView.open();
            break;
        case CHANGE_COMPOUND_INSTANCE_TYPE:
            changeCompoundValueType(var);
            break;
        default:
            // DO nothing
        }
        viewer.refresh();
    }
    
    /**
     * Asks the user for changing the type of the compound value in <code>var</code> along the refinement hierarchy. 
     * Nothing happens if <code>var</code> does not contain a {@link CompoundValue}.
     * 
     * @param var the variable to change the compound value tpye
     */
    private void changeCompoundValueType(GUIVariable var) {
        IDecisionVariable decVar = var.getVariable();
        Value val = decVar.getValue();
        if (val.getType() instanceof Compound) {
            Compound oldType = null == val ? null : (Compound) val.getType();
            AbstractVariable decVarDecl = decVar.getDeclaration();
            Project prj = decVarDecl.getProject();
            Shell shell = viewer.getControl().getShell();
            Compound newType = TypeSelectionDialog.selectCompoundType(shell, "Change instance type" 
                + TypeSelectionDialog.getActualTypeString(oldType, "") , prj, (Compound) decVarDecl.getType(), oldType);
            if (null != newType && newType.isAbstract()) {
                MessageDialog.openInformation(shell, "No suitable type found",
                    "No suitable type defined, e.g., only abstract refined compounds. Cannot change value type.");
                newType = null;
            }
            if (null != newType && null != oldType && oldType != newType) {
                if (newType.isAssignableFrom(oldType) && !MessageDialog.openConfirm(shell, "Configuration loss warning",
                    "Converting to a refined super type may implay loss of configuration information not"
                    + " defined for the super type. Continue?")) {
                    newType = null;
                }
            }
            if (null != newType) {
                try {
                    List<Object> values = new ArrayList<Object>();
                    if (null != val) {
                        copyValues(newType, (CompoundValue) val, values, new HashSet<Object>());
                    }
                    Value newValue = ValueFactory.createValue(newType, values.toArray());
                    var.getConfiguration().replace(var, newValue);
                } catch (ValueDoesNotMatchTypeException e) {
                    EasyProducerDialog.showErrorDialog(shell, "Cannot change the value type / assign the"
                        + "configured values: " + e.getMessage());
                } catch (ConfigurationException e) {
                    EasyProducerDialog.showErrorDialog(shell, "Cannot change the value type / assign the"
                        + "configured values: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Copies values to achieve an instance of <code>type</code> based on values from <code>orig</code>.
     * Values are stored in <code>target</code> in the format required for {@link ValueFactory}. Already
     * processed slots are stored in <code>done</code>.
     * 
     * @param type the target type
     * @param orig the original value
     * @param target the target values for {@link ValueFactory} - to be turned into an array
     * @param done already processed slots
     */
    private void copyValues(Compound type, CompoundValue orig, List<Object> target, Set<Object> done) {
        for (int d = 0; d < type.getDeclarationCount(); d++) {
            DecisionVariableDeclaration slotDecl = type.getDeclaration(d);
            String slotName = slotDecl.getName();
            Value slotValue = orig.getNestedValue(slotName);
            if (null != slotValue) {
                target.add(slotName);
                target.add(slotValue);
                done.add(slotName);
            }
        }
        for (int r = 0; r < type.getRefinesCount(); r++) {
            copyValues(type.getRefines(r), orig, target, done);
        }
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent evt) {
        // Not needed
    }
    
    /**
     * Returns the current selected variable, i.e. which the user has clicked with the right mouse button.
     * @return The selected {@link GUIVariable}.
     */
    private GUIVariable getSelectedVariable() {
        IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        return (GUIVariable) selection.getFirstElement();
    }

}
