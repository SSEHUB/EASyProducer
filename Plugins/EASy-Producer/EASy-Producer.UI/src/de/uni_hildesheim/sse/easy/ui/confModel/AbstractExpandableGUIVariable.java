package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.uni_hildesheim.sse.model.confModel.ContainerVariable;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

/**
 * Super class for variables, which contain nested elements and can be expanded.
 * @author El-Sharkawy
 *
 */
abstract class AbstractExpandableGUIVariable extends GUIVariable {

    private List<GUIVariable> nested;
    
    /**
     * Needed for the nested elements.
     */
    private Composite composite;
    
    /**
     * Sole constructor for this class.
     * @param variable The {@link IDecisionVariable} represented by this GUIVariable
     * @param parent The controlling composite, needed for the creation of CellEditors
     * @param parentConfig The {@link GUIConfiguration} holding this GUIVariable
     * @param varParent The parent GUIVariable holding this variable. Can be <tt>null</tt> if and only if this variable
     * is a top level variable stored inside the configuration.
     */
    protected AbstractExpandableGUIVariable(IDecisionVariable variable, Composite parent,
        GUIConfiguration parentConfig, GUIVariable varParent) {
        
        super(variable, parentConfig, varParent);
        composite = parent;
        nested = new ArrayList<GUIVariable>(variable.getNestedElementsCount());
        createNestedVariables();
    }
    
    /**
     * Getter for Composite of class.
     * 
     * @return composite the composite
     */
    protected Composite getComposite() {
        return composite;
    }
    
    /**
     * Creates nested GUIVariables for this variable.
     * This method should be called inside the constructor and if the number of nested variables has been changed,
     * e.g. a nested sequence item has been added to this variable.
     */
    protected void createNestedVariables() {
        nested.clear();
        for (int n = 0; n < getVariable().getNestedElementsCount(); n++) {
            nested.add(GUIValueFactory.createVariable(
                getVariable().getNestedElement(n),
                composite,
                getConfiguration(), this));
        }        
    }
    
    @Override
    public final CellEditor getCellEditor() {
        // Only the nested elements have CellEditors not the parent.
        return null;
    }
    
    @Override
    public GUIEditor getEditor() {
        // basically, shall not be shown anywhere but also shall indicate that
        Label label = new Label(composite, SWT.NONE);
        label.setText(getValueText());
        return new LabelGUIEditor(label);
    }
    
    @Override
    public final void setValue(Object value) {
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
    public void extend() {
        if (isExtendable()) {
            if (hasValue() && hasNullValue()) {
                setEmptyValue();
            }
            super.extend();
            ContainerVariable variable = (ContainerVariable) getVariable();
            variable.addNestedElement();
            createNestedVariables();
            getConfiguration().changed(this);
        }
    }
}
