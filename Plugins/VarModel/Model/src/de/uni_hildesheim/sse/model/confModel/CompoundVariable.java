package de.uni_hildesheim.sse.model.confModel;

import java.util.LinkedHashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Class for variables of Compounds.
 * @author El-Sharkawy
 *
 */
public class CompoundVariable extends StructuredVariable {
    private Map<String, IDecisionVariable> nestedElements;
    
    /**
     * Sole constructor for creating {@link ContainerVariable}'s.
     * @param parent the parent this variable is part of, typically the {@link Configuration}
     *   instance, but in case of compounds/container also the containing {@link IDecisionVariable}
     * @param varDeclaration the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     */
    CompoundVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible) {
        super(parent, varDeclaration, isVisible);
        if (null == nestedElements) {
            nestedElements = new LinkedHashMap<String, IDecisionVariable>();
        }
        Compound cmpType = (Compound) varDeclaration.getType();
        for (int i = 0; i < cmpType.getInheritedElementCount(); i++) {
            AbstractVariable nestedItem = cmpType.getInheritedElement(i);
            VariableCreator creator = new VariableCreator(nestedItem, this, isVisible);
            try {
                nestedElements.put(nestedItem.getName(), creator.getVariable(false));
            } catch (ConfigurationException e) {
                // Should not occur
                e.printStackTrace();
            }
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public IAssignmentState getState() {
        IAssignmentState state = super.getState();
        
        // check whether the whole compound was frozen already
        if (state != AssignmentState.FROZEN) {
            if (ownStateAllowed()) {
                state = AssignmentState.ASSIGNED;
                for (IDecisionVariable nestedVar : nestedElements.values()) {
                    if (null == nestedVar.getValue() || AssignmentState.UNDEFINED == nestedVar.getState()) {
                        state = AssignmentState.UNDEFINED;
                        break;
                    }
                }
            } else {
                CompoundValue cmpValue = (CompoundValue) getValue();
                if (null == cmpValue || !cmpValue.isFullyConfigured()) {
                    state = AssignmentState.UNDEFINED;
                }
            }
        }
        
        return state;
    }

    /**
     * {@inheritDoc}
     */
    public int getNestedElementsCount() {
        return null == nestedElements ? 0 : nestedElements.size();
    }

    /**
     * {@inheritDoc}
     */
    public IDecisionVariable getNestedElement(int index) {
        return (IDecisionVariable) nestedElements.values().toArray()[index];
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
        throws ConfigurationException {
        IDecisionVariable nestedVar = getNestedVariable(nested.getDeclaration().getName());
        nestedVar.setValue(value, state);        
    }
    
    /**
     * {@inheritDoc}<br/>
     * Sets also the states for the nested elements.
     */
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        super.setValue(value, state); // TODO if state==FREEZE this leads to Exception in second part
        if (null != value && value != NullValue.INSTANCE) {
            CompoundValue cmpValue = (CompoundValue) value;
            Compound cmpType = (Compound) getDeclaration().getType();
            for (int i = 0; i < cmpType.getInheritedElementCount(); i++) {
                String slotName = cmpType.getInheritedElement(i).getName();
                if (null != slotName && null != cmpValue.getNestedValue(slotName)) {
                    DecisionVariable nestedVar = (DecisionVariable) nestedElements.get(slotName);
                    if (null != nestedVar) {
                        nestedVar.getConfigProvider().setState(state);
                    }
                }
            }
        }
    }
    
    /**
     * Returns a nested {@link IDecisionVariable}.
     * @param slotName The name of the nested {@link IDecisionVariable} to be returned.
     * @return The nested {@link IDecisionVariable} with the same name or <tt>null</tt>.
     */
    public IDecisionVariable getNestedVariable(String slotName) {
        return nestedElements.get(slotName);
    }

    /**
     * {@inheritDoc}
     */
    public void freeze(String nestedElement) {
        IDecisionVariable nestedVar = nestedElements.get(nestedElement);
        nestedVar.freeze();
    }

    @Override
    boolean allowsNestedStates() {
        return true;
    }
    
    @Override
    public Value getValue() {
        Value value = super.getValue();
        if (null == value) {
            try {
                value = ValueFactory.createValue(getDeclaration().getType(), (Object[]) null);
                setValue(value, AssignmentState.UNDEFINED);
            } catch (ValueDoesNotMatchTypeException e) {
                e.printStackTrace();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }
        
        return value;
    }
}
