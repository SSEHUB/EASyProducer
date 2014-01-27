package de.uni_hildesheim.sse.reasoning.core.model.variables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.reasoning.core.model.IVariableContainer;
import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningState;
import de.uni_hildesheim.sse.reasoning.core.model.datatypes.CompoundType;

/**
 * {@link ReasonerVariable} representing a reference {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class CompoundVariable extends CustomVariable implements IVariableContainer {

    /**
     * Nested elements in the form of: (slot name, nested variable).
     */
    private Map<String, ReasonerVariable> nestedElements;
    
    /**
     * Sole constructor for creating a new {@link CompoundVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent a compound.
     * @param name The unique name of the {@link ReasonerVariable} inside the
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel}.
     * @param model the {@link ReasonerModel}, where this variable should be added to
     *     (needed for {@link de.uni_hildesheim.sse.reasoning.core.model.datatypes.ReasonerDatatype} resolution).
     * @param parent Variables container.
     */
    CompoundVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        nestedElements = new HashMap<String, ReasonerVariable>();        
    }
    
    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        nestedElements.put(nestedVariable.getName(), nestedVariable);
    }
    
    /**
     * Returns the nested {@link ReasonerVariable} to which the specified <tt>nestedName</tt> is mapped,
     * or {@code null} if this {@link CompoundVariable} contains no nested {@link ReasonerVariable} with
     * the specified name.
     *
     * @param nestedName The name  of the nested Element, written exactly as in the related
     * {@link de.uni_hildesheim.sse.model.varModel.datatypes.Compound} datatype.
     * @return the nested {@link ReasonerVariable} to which the specified <tt>nestedName</tt> is mapped, or
     *     {@code null} if this {@link CompoundVariable} contains no nested {@link ReasonerVariable} with
     *     the specified name.
     * @throws NullPointerException if the specified key is <tt>null</tt>.
     */
    public ReasonerVariable getNestedVariable(String nestedName) {
        return nestedElements.get(nestedName);
    }

    @Override
    public CompoundType getType() {
        return (CompoundType) super.getType();
    }

    @Override
    protected void assignValue(Object newValue) {
        //TODO SE: Unclear whether we need this function
//        if (null != newValue) {
//            //Change nested Values
//            Object[] nestedValues = (Object[]) newValue;
//            for (int i = 0; i < nestedValues.length; i++) {
//                String slotName = (String) nestedValues[i];
//                Object value = nestedValues[i];
//                // TODO SE: Check whether value should be checked (than setValue should be used).
//                nestedElements.get(slotName).assignValue(value);
//            }
//        } else {
//            // Delete all values
//            for (ReasonerVariable nestedVariable : nestedElements.values()) {
//                nestedVariable.assignValue(null);
//            }
//        }
    }
    
    @Override
    protected boolean isSameValue(Object newValue) {
        boolean isSame = true;
        if (null != newValue) {
            Object[] nestedValues = (Object[]) newValue;
            for (int i = 0; isSame && i < nestedValues.length; i++) {
                String slotName = (String) nestedValues[i];
                Object value = nestedValues[i];
                isSame = nestedElements.get(slotName).getObjectValue() == value;
            }
        } else {
            Iterator<ReasonerVariable> iterator = nestedElements.values().iterator();
            while (iterator.hasNext() && isSame) {
                ReasonerVariable nestedVariable = iterator.next();
                isSame = nestedVariable.getReasoningState() == ReasoningState.UNASSIGNED;
            }
        }
          
        return isSame;
    }
 
    @Override
    protected Object[][] getObjectValue() {
        //FIXME
        return null;
    }
    
    /**
     * Returns a nested variable, specified by the given name.
     * @param slotName The name of the nestedVariable to be returned.
     * @return the nested variable or <tt>null</tt> if no nested variable with the given name exist.
     */
    public ReasonerVariable get(String slotName) {
        return nestedElements.get(slotName);
    }
    
    @Override
    public ReasonerVariable getVariable(String name) {
        return get(name);
    }

    @Override
    public Object getValue() {
        Boolean value = null;
        Iterator<ReasonerVariable> varIterator = iterator();
        while (varIterator.hasNext()) {
            ReasonerVariable nestedVariable = varIterator.next();
            if (nestedVariable.getValue() != null) {
                value = true;                
            }
        }     
        return value;
    }
    
    /**
     * Iterator to retrieve all nested variables.
     * @return {@link ReasonerVariable}s that are nested in the compound.
     */
    public Iterator<ReasonerVariable> iterator() {
        return nestedElements.values().iterator();
    }
}
