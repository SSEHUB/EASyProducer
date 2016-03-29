package de.uni_hildesheim.sse.easy.ui.confModel;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.easy.ui.productline_editor.EasyProducerDialog;
import net.ssehub.easy.varModel.confModel.AllFreezeSelector;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.DisplayNameProvider;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * A {@link IDecisionVariable} with functionality needed by the Eclipse UI.
 * @author El-Sharkawy
 *
 */
public abstract class GUIVariable implements IGUIConfigurableElement, Comparable<GUIVariable> {
    
    private GUIConfiguration parentConfig;
    private IDecisionVariable variable;
    private String tooltip;
    private String errorMsg;
    
    private GUIHistory history;
    private Composite composite;
    
    /**
     * The parent holding this variable. Can be <tt>null</tt> in case of top level elements.
     */
    private GUIVariable parent;

    /**
     * Sole constructor for this class.
     * @param variable The {@link IDecisionVariable} represented by this GUIVariable
     * @param parentConfig The {@link GUIConfiguration} holding this GUIVariable
     * @param parent The parent GUIVariable holding this variable. Can be <tt>null</tt> if and only if this variable
     * is a top level variable stored inside the configuration.
     * @param composite The controlling composite, needed for the creation of editors.
     */
    protected GUIVariable(IDecisionVariable variable, GUIConfiguration parentConfig, GUIVariable parent,
        Composite composite) {
        
        //assignments = new AssignmentHistory(this);
        this.parentConfig = parentConfig;
        this.variable = variable;
        this.parent = parent;
        errorMsg = null;
        TooltipCreator creator = new TooltipCreator(variable);
        tooltip = creator.getTooltip();
        history = new GUIHistory();
        this.composite = composite;
    }
    
    /**
     * Returns the GUI component where this variable and its editors are displayed.
     * @return The holding GUI component.
     */
    public final Composite getComposite() {
        return composite;
    }
    
    /**
     * Returns the wrapped {@link IDecisionVariable}.
     * @return The wrapped {@link IDecisionVariable}
     */
    public IDecisionVariable getVariable() {
        return variable;
    }
    
    /**
     * Returns the parent Variable holding this variable.
     * @return The parent or <tt>null</tt> if this variable is a top level variable nested directly inside the
     * configuration.
     */
    public GUIVariable getParent() {
        return parent;
    }
    
    /**
     * Returns the TopLevelParent Variable holding this variable or the variable itself if it is a top level variable.
     * @return The TopLevelParent or <tt>this</tt> if this variable is a top level variable.
     */
    public GUIVariable getTopLevelParent() {
        GUIVariable topLevel = this;
        if (!isTopLevelDeclaration()) {
            topLevel = getParent().getTopLevelParent();
        }
        return topLevel;
    }
    
    /**
     * Setter for the wrapped {@link IDecisionVariable}.
     * @param variable The new {@link IDecisionVariable}
     */
    public void setVariable(IDecisionVariable variable) {
        this.variable = variable;
    }
    
    /**
     * Returns how many parent {@link IDecisionVariable}s exist for this variable.
     * @return 0 if the Configuration is the direct parent of this {@link IDecisionVariable}, otherwise
     * a number greater than 0 indicating how many {@link IDecisionVariable}s between the <tt>Configuration</tt> and
     * this variable exist. 
     */
    public final int getNestedDepth() {
        return variable.getNestedDepth();
    }
    
//    public CellEditor getCellEditor() {
//        return getCellEditor(getComposite());
//    }
    
    /**
     * Returns a {@link CellEditor} for a table.
     * @param parent The GUI component where this {@link GUIVariable} and, thus, its editor are displayed. 
     * @return {@link CellEditor} to configure the enclosed {@link IDecisionVariable}
     */
    public abstract CellEditor getCellEditor(Composite parent);
    
    /**
     * Returns the (non-cell) editor for this variable. The editor shall be ready to use,
     * i.e., properly initialized.
     * 
     * @return the editor, may be <b>null</b> if the variable shall not be displayed / being edited
     */
    public abstract GUIEditor getEditor();
    
    /**
     * Returns the value of the given {@link IDecisionVariable} so that it can be used as return value for
     * the {@link org.eclipse.jface.viewers.EditingSupport#getValue(Object)} method.
     * @return A value as needed by the Eclipse UI.
     */
    public abstract Object getValue();
    
    /**
     * Sets the value of the wrapped {@link IDecisionVariable}.
     * @param value The value to be set.
     */
    public void setValue(Object value) {
        try {
            Value val = getValueAssignment(value);
            if (null != val) {
                // Add value to history if variable is toplevel
                getTopLevelParent().history.assignValue(getTopLevelParent().getVariable());
//              assignments.assignValue(val);
                variable.setValue(val, AssignmentState.ASSIGNED);
                parentConfig.changed(this);
            }
        } catch (ValueDoesNotMatchTypeException e) {
            EasyProducerDialog.showErrorDialog(e.getLocalizedMessage());
        } catch (ConfigurationException e) {
            EasyProducerDialog.showErrorDialog(e.getLocalizedMessage());
        }
    }
    
    /**
     * Converts the given object into a {@link Value}.
     * @param value An object given by the Eclipse GUI.
     * @return A {@link Value} representation of the object, maybe <tt>null</tt>.
     * @throws ValueDoesNotMatchTypeException in case of <code>value</code> cannot be converted to
     * the related data type of the wrapped {@link IDecisionVariable}.
     */
    protected abstract Value getValueAssignment(Object value) throws ValueDoesNotMatchTypeException;
    
    /**
     * Returns the name of the {@link IDecisionVariable}.
     * @return The name of the {@link IDecisionVariable}, must not be <tt>null</tt>.
     */
    public String getName() {
        return variable.getDeclaration().getUniqueName();
    }
    
    /**
     * The current {@link IAssignmentState} of the wrapped {@link IDecisionVariable}.
     * @return The {@link IAssignmentState} of the wrapped {@link IDecisionVariable}.
     */
    public IAssignmentState getAssignmentState() {
        return variable.getState();
    }
    
    /**
     * Returns whether the wrapped {@link IDecisionVariable} can be edited.
     * @return <tt>true</tt> if the variable can be edited, otherwise <tt>false</tt>.
     */
    public boolean isEditable() {
        boolean result = true;
        if (getAssignmentState() == AssignmentState.FROZEN) {
            result = false;
        }
        
        return result;
    }
    
    /**
     * Returns a string representation of the current value.
     * This is used when <b>no</b> cursor is inside the cell (if the user is <b>not</b> editing the variable).
     * @return A string representation of the current value or <tt>null</tt>.
     */
    public abstract String getValueText();
    
    /**
     * Returns whether is variable can be expanded. Subclasses may override this method.
     * 
     * @return <tt>true</tt> if this variable is expandable, otherwise <tt>false</tt>.
     */
    public boolean isExpandable() {
        return false;
    }
    
    /**
     * Returns whether is variable can be extended (insert new empty values). Subclasses may override this method.
     * 
     * @return <tt>true</tt> if this variable is extendable, otherwise <tt>false</tt>.
     * @see #extend()
     */
    public boolean isExtendable() {
        return false;
    }
    
    /**
     * Creates a new empty nested value/variable if supported.
     * This method shall only be called by the set and sequence variables.
     */
    public void extend() {
        if (isExtendable()) {
            getTopLevelParent().history.assignValue(getTopLevelParent().getVariable());
        }
    }
    
    /**
     * Deletes a nested {@link GUIVariable} from this variable.
     * This is only supported in {@link ContainerGUIVariable} class.
     * @param nestedVariable The nested variable which shall be removed.
     */
    public void remove(GUIVariable nestedVariable) {
        // This action is handled in ContainerGUIVariable class.
    }
    
    /** 
     * Returns the comment of the model element.
     * 
     * @return Comment of this model element.
     */
    public String getComment() {
        return variable.getDeclaration().getComment();
    }
 
    /**
     * Returns the number of nested elements.
     * The return value should be 0 unless this {@link IDecisionVariable} is an {@link AbstractExpandableGUIVariable}.
     * @return An integer value greater or equal to 0.
     */
    public int getNestedElementsCount() {
        return variable.getNestedElementsCount();
    }
    
    /**
     * Returns a nested element specified by the given index.
     * @param index The 0-based index of the nested element.
     * @return The specified nestedvariable.
     * @throws ArrayIndexOutOfBoundsException if this variable has no nested elements, is not expanded,
     * or if the index is out of range (<tt>index &lt; 0 || index &gt;= size()</tt>)
     * 
     */
    public GUIVariable getNestedElement(int index) {
        // there is just one and this is this GUIVariable
        throw new ArrayIndexOutOfBoundsException();
    }
    
    /**
     * Getter for the configuration which holds this variable.
     * @return The configuration bearing this variable.
     */
    public final GUIConfiguration getConfiguration() {
        return parentConfig;
    }
    
    /**
     * Returns whether the current variable is already frozen.
     * @return <tt>true</tt> if the variable is frozen, otherwise <tt>false</tt>.
     */
    public boolean isFrozen() {
        return null != getVariable() && getVariable().getState() == AssignmentState.FROZEN;
    }
    
    /**
     * Returns whether this variable can be frozen.
     * In case of some nested variables it is not possible to freeze only the nested variable
     * (e.g. a nested set variable).
     * @return <tt>true</tt> if the nested variable can be frozen, otherwise <tt>false</tt>.
     */
    public final boolean isFreezable() {
        boolean freezable = !isFrozen() && getAssignmentState() != AssignmentState.UNDEFINED;
        boolean isToplevelElement = getVariable().getParent() == getVariable().getConfiguration();
        
        return freezable && isToplevelElement;
    }
    
    /**
     * Causes to freeze the current value.
     */
    public void freeze() {
        if (!isFrozen()) {
            // Add value to history if variable is toplevel
            getTopLevelParent().history.assignValue(getTopLevelParent().getVariable());
            getVariable().freeze(AllFreezeSelector.INSTANCE);
            // Inform listeners only if state has been changed.
            if (isFrozen()) {
                getConfiguration().changed(this);
            }
        }
    }
    
    /**
     * Unfreezes the current variable.
     * 
     * @param state the state after unfreezing (do not use {@link AssignmentState#FROZEN})
     */
    public void unfreeze(IAssignmentState state) {
        if (isFrozen()) {
            // Add value to history if variable is toplevel
            getTopLevelParent().history.assignValue(getTopLevelParent().getVariable());
            getVariable().unfreeze(state);
            // Inform listeners only if state has been changed.
            if (!isFrozen()) {
                getConfiguration().changed(this);
            }
        }
    }
    
    /**
     * Returns a tooltip which can be displayed inside the GUI.
     * @return The datatype of the variable (must not be <tt>null</tt>).
     */
    public final String getTooltip() {
        return tooltip;
    }
    
    /**
     * Checks whether error messages are stored to this {@link GUIVariable}.
     * @return <tt>true</tt> if this variable has stored error messages, <tt>false</tt> otherwise.
     * @see #getErrorMessages()
     */
    public final boolean hasErrors() {
        return errorMsg == null || errorMsg.isEmpty() ? false : true;
    }
    
    /**
     * Returns the stored error messages as a string.
     * @return The error messages stored at this variable or <tt>null</tt> if no errors are stored.
     * @see #hasErrors()
     */
    public final String getErrorMessages() {
        return errorMsg;
    }
    
    /**
     * Removes the stored error message.
     */
    final void removeErrorMessages() {
        errorMsg = null;
    }
    
    /**
     * Adds a new error message to this {@link GUIVariable}.
     * @param conflictingElement A {@link ContainableModelElement} which lead to the conflict and where 
     * {@link #getVariable()} is included.
     * @param userMessage Optional: A error message which can be ready by a normal user. If <tt>null</tt>,
     * the constraint will be used for displaying an error message.
     */
    final void addErrorMessage(ContainableModelElement conflictingElement, String userMessage) {
        StringBuffer errorMsg = new StringBuffer();
        if (this.errorMsg != null) {
            errorMsg.append(this.errorMsg);
            errorMsg.append(", ");
        }
        
        if (null != userMessage && !userMessage.isEmpty()) {
            errorMsg.append(userMessage);
        } else if (conflictingElement instanceof Constraint) {
            Constraint constraint = (Constraint) conflictingElement;
            errorMsg.append(StringProvider.toIvmlString(constraint.getConsSyntax()));
        }
        
        this.errorMsg = errorMsg.toString();
    }
    
    @Override
    public final int compareTo(GUIVariable other) {
        return getName().compareTo(other.getName());
    }
    
    /**
     * Check for TopLevelDeclaration. Can be null in case of top level elements.
     * @return true if Element is a TopLevelDeclaration.
     */
    boolean isTopLevelDeclaration() {
        return parent == null;
    }
    
    /**
     * Getter for the history of the variable.
     * @return The history of the variable.
     */
    public GUIHistory getHistory() {
        return history;
    }
    
    /**
     * Checks whether the variable has a configured {@link Value}.
     * @return <tt>true</tt> if the variable has a value, <tt>false</tt> otherwise.
     */
    public boolean hasValue() {
        return getVariable().hasValue();
    }
    
    /**
     * Checks whether the variable has a {@link NullValue}.
     * Note: this method does not check whether the variable <b>has</b> a value.
     * @return <tt>true</tt> if the variable has a {@link NullValue}, <tt>false</tt> otherwise.
     */
    public boolean hasNullValue() {
        return getVariable().hasNullValue();
    }
    
    /**
     * Removes the current {@link Value}.
     */
    public void setEmptyValue() {
        try {
            getVariable().setValue(null, AssignmentState.UNDEFINED);
        } catch (ConfigurationException e) {
            EasyProducerDialog.showErrorDialog(e.getLocalizedMessage());
        }
        parentConfig.changed(this);
    }
    
    /**
     * Sets a {@link NullValue}.
     */
    public void setNULLValue() {
        try {
            getVariable().setValue(NullValue.INSTANCE, AssignmentState.ASSIGNED);
        } catch (ConfigurationException e) {
            EasyProducerDialog.showErrorDialog(e.getLocalizedMessage());
        }
        parentConfig.changed(this);
    }
    
    /**
     * Returns the label for an IVML null value to be used in this GUI variable.
     * 
     * @return the label for an IVML null value
     */
    public String getNullLabel() {
        return DisplayNameProvider.getInstance().getNullName(variable);
    }
    
    /**
     * Returns the type of the underlying IVML variable. In case of derived variables, it returns the innermost type.
     * 
     * @return the type
     */
    protected IDatatype getType() {
        // as the editor shall internally rely on the basis type
        return DerivedDatatype.resolveToBasis(variable.getDeclaration().getType());
    }
    
    @Override
    public String toString() {
        return null != variable ? variable.getDeclaration().getName() : "null";
    }
    
    /**
     * Returns whether the variable has any annotations.
     * @return <tt>true</tt> The variable has at least one annotation, <tt>false</tt> the variable has no annotations.
     */
    public boolean isAnnotated() {
        return null != variable ? variable.getAttributesCount() > 0 : false;
    }
    
}
