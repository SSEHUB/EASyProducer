package net.ssehub.easy.producer.ui.confModel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import net.ssehub.easy.producer.ui.internal.TypeSelectionDialog;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.ContainerVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Super class for variables, which contain nested elements and can be expanded.
 * @author El-Sharkawy
 *
 */
abstract class AbstractExpandableGUIVariable extends GUIVariable {

    private List<GUIVariable> nested;
    
    /**
     * Sole constructor for this class.
     * @param variable The {@link IDecisionVariable} represented by this GUIVariable
     * @param parent The controlling composite, needed for the creation of CellEditors
     * @param parentConfig The {@link GUIConfiguration} holding this GUIVariable
     * @param varParent The parent GUIVariable holding this variable. Can be <code>null</code> 
     * if and only if this variable is a top level variable stored inside the configuration.
     */
    protected AbstractExpandableGUIVariable(IDecisionVariable variable, Composite parent,
        GUIConfiguration parentConfig, GUIVariable varParent) {
        
        super(variable, parentConfig, varParent, parent);
        nested = new ArrayList<GUIVariable>(variable.getNestedElementsCount());
        createNestedVariables();
    }
    
    @Override
    public int getNestedElementsCount() {
        return nested.size();
    }
    
    /**
     * Creates nested GUIVariables for this variable.
     * This method should be called inside the constructor and if the number of nested variables has been changed,
     * e.g. a nested sequence item has been added to this variable.
     */
    protected void createNestedVariables() {
        nested.clear();
        for (int n = 0; n < getVariable().getNestedElementsCount(); n++) {
            IDecisionVariable nestedVariable = getVariable().getNestedElement(n);
            IDatatype nestedType = DerivedDatatype.resolveToBasis(nestedVariable.getDeclaration().getType());
            if (ConstraintType.TYPE != nestedType) {
                nested.add(GUIValueFactory.createVariable(
                    nestedVariable,
                    getComposite(),
                    getConfiguration(), this));
            }
        }        
    }
    
    @Override
    public final CellEditor getCellEditor(Composite parent) {
        // Only the nested elements have CellEditors not the parent.
        return null;
    }
    
    @Override
    public GUIEditor getEditor() {
        // basically, shall not be shown anywhere but also shall indicate that
        Label label = new Label(getComposite(), SWT.NONE);
        label.setText(getValueText());
        return new LabelGUIEditor(label);
    }
    
    @Override
    public void setValue(Object value) {
        //Not needed (only the nested variables can be configured, not the parent itself)
    }

    @Override
    protected final Value getValueAssignment(Object value) throws ValueDoesNotMatchTypeException {
        // Not needed (would only be called by setValue(Object) which is also not needed
        return null;
    }
    
    @Override
    public GUIVariable getNestedElement(int index) {
        return nested.get(index);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isExpandable() {
        return true;
    }
    
    @Override
    public GUIVariable extend() {
        GUIVariable result = null;
        if (isExtendable()) {
            if (hasValue() && hasNullValue()) {
                setEmptyValue();
            }
            super.extend();
            ContainerVariable variable = (ContainerVariable) getVariable();
            IDatatype elementType = variable.getContainedType();
            if (elementType instanceof Compound) { // do we have a compound, we may have to choose
                Compound cmp = (Compound) elementType;
                Project prj = getTopLevelParent().getVariable().getDeclaration().getProject();
                elementType = TypeSelectionDialog.selectCompoundType(getComposite().getShell(), "Type selection", 
                    prj, cmp);
            }
            if (null != elementType) { // selection from window may be null if not selected
                variable.addNestedElement(elementType);
                createNestedVariables();
                getConfiguration().changed(this);
                result = getNestedElement(getNestedElementsCount() - 1);
            }
        }
        return result;
    }

    @Override
    protected GUIVariable replace(GUIVariable nestedVariable, Value value) throws ConfigurationException {
        GUIVariable result = nestedVariable;
        for (int n = 0; n < nested.size(); n++) {
            if (nested.get(n) == nestedVariable) {
                IDecisionVariable decVar = nested.get(n).getVariable();
                replaceValue(decVar, value);
                result = GUIValueFactory.createVariable(decVar, getComposite(), getConfiguration(), this);
                nested.set(n, result);
                getConfiguration().changed(result);
                break;
            }
        }
        return nestedVariable;
    }

}
