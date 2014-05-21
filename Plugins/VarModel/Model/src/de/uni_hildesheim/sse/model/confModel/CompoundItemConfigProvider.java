package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

/**
 * {@link VariableConfigProvider} for nested Elements of a {@link ContainerVariable}.
 * 
 * @author El-Sharkawy
 *
 */
class CompoundItemConfigProvider extends NestedVarConfigProvider {
    private String slotName;
    private IAssignmentState state;
    
    /**
     * Sole constructor for creating a {@link VariableConfigProvider} for nested elements of a compound.
     * @param parent A {@link CompoundVariable} which will hold the
     *     nested {@link IDecisionVariable} where this provider belongs to.
     * @param slotName The <tt>parent</tt>'s slotName of the nested {@link IDecisionVariable}
     *     where this provider belongs to.
     */
    protected CompoundItemConfigProvider(CompoundVariable parent, String slotName) {
        super(parent);
        this.slotName = slotName;
        state = AssignmentState.UNDEFINED;
    }

    @Override
    protected CompoundVariable getParent() {
        return (CompoundVariable) super.getParent();
    }

    @Override
    protected Value getValue() {
        CompoundValue cmpValue = (CompoundValue) getParent().getValue();
        return cmpValue.getNestedValue(slotName);
    }

    @Override
    protected void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        CompoundValue cmpValue = (CompoundValue) getParent().getValue();
        try {
            cmpValue.configureValue(slotName, value);
            setState(state);
        } catch (ValueDoesNotMatchTypeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    protected IAssignmentState getState() {
        IAssignmentState state = this.state;
        if (!getParent().ownStateAllowed() && null != getValue()) {
            state = getParent().getState();
        }
        return state;
    }
    
    @Override
    protected final void setState(IAssignmentState state) throws ConfigurationException {
        if (this.state != AssignmentState.FROZEN) {
            this.state = state;
            getConfiguration().variableChangedState(getParent());
        } else {
            throw new ConfigurationException(getConfiguration(), 
                "decision '" + slotName 
                + "' is already frozen and cannot be changed", ConfigurationException.ALREADY_FROZEN);
        }
    }

    @Override
    protected AbstractVariable getDeclaration() {
        Compound cmpType = (Compound) getParent().getDeclaration().getType();
        AbstractVariable decl = null;
        for (int i = 0; i < cmpType.getElementCount() && null == decl; i++) {
            if (cmpType.getElement(i).getName().equals(slotName)) {
                decl = cmpType.getElement(i);
            }
        }
        
        return decl;
    }

    @Override
    protected void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        // Function not needed here
    }

}
