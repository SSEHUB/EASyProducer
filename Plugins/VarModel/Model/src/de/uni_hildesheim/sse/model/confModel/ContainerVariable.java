package de.uni_hildesheim.sse.model.confModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * 
 * {@link VariableConfigProvider} for nested variables of a {@link ContainerVariable}.
 * 
 * @author El-Sharkawy
 * 
 */
public abstract class ContainerVariable extends StructuredVariable {

    private List<IDecisionVariable> nestedElements;

    /**
     * Sole constructor for this class.
     * 
     * @param parent
     *     the parent this variable is part of, typically the {@link Configuration} instance, but in case of
     *     compounds/container also the containing {@link IDecisionVariable}
     * @param varDeclaration
     *     the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     */
    protected ContainerVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible) {
        super(parent, varDeclaration, isVisible);
        if (null == nestedElements) {
            nestedElements = new ArrayList<IDecisionVariable>();
        }
    }
    
    /**
     * Clears the list.
     */
    void clear() {
        nestedElements.clear();
    }

    /**
     * {@inheritDoc}
     */
    public int getNestedElementsCount() {
        // During initialization, nestedElements can be null
        return null == nestedElements ? 0 : nestedElements.size();
    }

    /**
     * {@inheritDoc}
     */
    public IDecisionVariable getNestedElement(int index) {
        return nestedElements.get(index);
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
        throws ConfigurationException {

        nestedElements.clear();
        ContainerValue conValue = (ContainerValue) value;
        IDatatype type = ((Container) getDeclaration().getType()).getContainedType();
        for (int i = 0; null != conValue && i < conValue.getElementSize(); i++) {
            String name = getElementName(i);
            DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, type, getDeclaration());
            VariableCreator creator = new VariableCreator(decl, this, isVisible());
            IDecisionVariable var = creator.getVariable();
            var.setValue(conValue.getElement(i), state);
            nestedElements.add(var);
        }
    }
    
    @Override
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        ContainerValue conValue = null;
        
        if (value == NullValue.INSTANCE) {
            nestedElements.clear();
        } else {
            conValue = (ContainerValue) value;
            IDatatype type = ((Container) getDeclaration().getType()).getContainedType();
            
            // Create nested Elements
            if (conValue != null) {
                for (int i = 0; i < conValue.getElementSize(); i++) {
                    String name = getElementName(i);
                    DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, type, getDeclaration());
                    VariableCreator creator = new VariableCreator(decl, this, isVisible());
                    try {
                        IDecisionVariable var = creator.getVariable();
                        addNestedElement(var);
                    } catch (ConfigurationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        
        // Set Value for this variable
        super.setValue(value, state);
        
        // set value for nested elements (needed for recursion)
        if (conValue != null) {
            for (int i = 0; i < conValue.getElementSize(); i++) {
                IDecisionVariable nestedVariable = getNestedElement(i);
                Value nestedValue = conValue.getElement(i);
                nestedVariable.setValue(nestedValue, state);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void freeze(String nestedElement) {
        // Not supported by this class
    }

    @Override
    boolean allowsNestedStates() {
        return false;
    }

    /**
     * Returns the symbolic name for an element in this container, such as the index for sequences.
     * 
     * @param index
     *            the position of the element within the container
     * @return the symbolic name
     */
    protected String getElementName(int index) {
        return "" + index;
    }

    /**
     * Adds a new nested element to this variable. This nested element is empty, is in state
     * {@link AssignmentState#UNDEFINED} and can be configured afterwards.
     */
    public void addNestedElement() {
        if (null == getValue()) {
            try {
                Value containerValue = ValueFactory.createValue(getDeclaration().getType(), (Object[]) null);
                setValue(containerValue, AssignmentState.UNDEFINED);
            } catch (ConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ValueDoesNotMatchTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        IDatatype type = ((Container) getDeclaration().getType()).getContainedType();
        int elementPos = nestedElements.size();
        try {
            String name = getElementName(elementPos);
            DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, type, getDeclaration());
            VariableCreator creator = new VariableCreator(decl, this, isVisible());
            IDecisionVariable var = creator.getVariable(false);
            addNestedElement(var);
            Value nullValue = ValueFactory.createValue(type, (Object[]) null);
            var.setValue(nullValue, AssignmentState.UNDEFINED);
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ValueDoesNotMatchTypeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Removes a (configured) element ({@link IDecisionVariable}) of this {@link ContainerVariable}.
     * This is the reverse function of {@link #addNestedElement()}.
     * @param var A variable which is directly nested in this variable and shall be deleted.
     * @return <tt>true</tt> if the specified element was found and deleted from this variable, <tt>false</tt> otherwise
     * @see #addNestedElement()
     */
    public boolean removeNestedElement(IDecisionVariable var) {
        int index = nestedElements.indexOf(var);
        
        if (-1 != index) {
            nestedElements.remove(index);
            
            /* 
             * Copy old values (the old indexes must be used,
             * since the ConfigurationProvider use the old complete ContainerValue to retrieve sub values.
             */
            Object[] copiedValues = new Object[nestedElements.size()];
            for (int i = 0; i < nestedElements.size(); i++) {
                copiedValues[i] = nestedElements.get(i).getValue();
            }
            
            // Change the indexes inside the ConfigurationProvider to retrieve the correct sub values
            for (int i = index; i < nestedElements.size(); i++) {
                ((DecisionVariable) nestedElements.get(i)).setIndex(i);
            }
           
            try {
                Value newValue = ValueFactory.createValue(getDeclaration().getType(), copiedValues);
                super.setValue(newValue, AssignmentState.ASSIGNED);
            } catch (ValueDoesNotMatchTypeException e) {
                // Should not occur
                // TODO SE: Integrate Logging
                e.printStackTrace();
            } catch (ConfigurationException e) {
                // Should not occur
                // TODO SE: Integrate Logging
                e.printStackTrace();
            }
        }
        
        return -1 != index;
    }

    @Override
    public IAssignmentState getState() {
        IAssignmentState state = super.getState();

        if (state == AssignmentState.UNDEFINED && nestedElements.size() > 0) {
            state = AssignmentState.ASSIGNED;
        }

        return state;
    }

    /**
     * Adds a nested {@link IDecisionVariable} to this {@link ContainerVariable}.
     * If an equal {@link IDecisionVariable} is already part of this {@link ContainerVariable},
     * the {@link IDecisionVariable} will be replaced by the new one.
     * @param var The nested {@link IDecisionVariable} which should be added to this container.
     */
    void addNestedElement(IDecisionVariable var) {
        boolean found = false;
        for (int i = 0; i < getNestedElementsCount() && !found; i++) {
            IDecisionVariable oldVar = nestedElements.get(i);
            if (oldVar.getDeclaration().getName().equals(var.getDeclaration().getName())) {
                found = true;
                nestedElements.set(i, var);
            }
        }
        if (!found) {
            if (null == nestedElements) {
                nestedElements = new ArrayList<IDecisionVariable>();
            }
            nestedElements.add(var);
        }
    }
}
