package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * 
 * {@link VariableConfigProvider} for nested variables of a {@link ContainerVariable}.
 * 
 * @author El-Sharkawy
 *
 */
class ContainerItemConfigProvider extends NestedVarConfigProvider {

    /**
     * this index is used to retrieve the correct sub value of the parent {@link ContainerVariable}.
     */
    private int index;

    /**
     * Sole constructor for creating a {@link VariableConfigProvider} for nested elements of a container.
     * @param parent A {@link CompoundVariable} which will hold the
     *     nested {@link IDecisionVariable} where this provider belongs to.
     * @param index The <tt>index</tt> of the nested {@link IDecisionVariable}
     *     inside the prant.
     */
    ContainerItemConfigProvider(ContainerVariable parent, int index) {
        super(parent);
        this.index = index;
    }
    
    @Override
    protected Value getValue() {
        Value value = null;
        ContainerValue parentValue = (ContainerValue) getParent().getValue();
        if (null != parentValue && parentValue.getElementSize() > index) {
            value = parentValue.getElement(index);
        }
        return value;
    }

    @Override
    protected void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        ContainerValue parentValue = (ContainerValue) getParent().getValue();
        if (parentValue != null) {
            parentValue.setValue(index, value);
        } else {
            ContainerVariable parent = getParent();
            String nestedName = parent.getElementName(index);
            IDatatype type = ((Container) parent.getDeclaration().getType()).getContainedType();
            DecisionVariableDeclaration nestedDecl = new DecisionVariableDeclaration(nestedName,
                type, parent.getDeclaration());
            VariableCreator creator = new VariableCreator(nestedDecl, parent, parent.isVisible());
            IDecisionVariable nestedVar = creator.getVariable(false);
            parent.addNestedElement(nestedVar);
        }
    }

    @Override
    protected IAssignmentState getState() {
        return getParent().getState();
    }

    @Override
    protected void setState(IAssignmentState state) throws ConfigurationException {
        // Not supported by this class        
    }

    @Override
    protected AbstractVariable getDeclaration() {
        // TODO Auto-generated method stub
        return null;
    }

    
    @Override
    protected ContainerVariable getParent() {
        return (ContainerVariable) super.getParent();
    }
    
    /**
     * Setter for the index.
     * Should only be used inside the {@link ContainerVariable} classes to adjust the index after one
     * element as been removed from the list of nested elements.
     * @param newIndex The new index of the related nested {@link IDecisionVariable}.
     * This value must be in the range (this is not checked):
     * (<tt>0 &lt;= newIndex &lt; getParent().getNestedElementsCount()</tt>)
     */
    void setIndex(int newIndex) {
        this.index = newIndex;
    }

    @Override
    protected void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        // Function not needed here        
    }
}
