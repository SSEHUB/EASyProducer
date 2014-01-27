package de.uni_hildesheim.sse.reasoning.core.model.variables;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;

/**
 * {@link ReasonerVariable} representing a Sequence {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class SequenceVariable extends ReasonerVariable {

    private List<ReasonerVariable> nestedElements;
    
    /**
     * Sole constructor for creating a new {@link SequenceVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent a Sequence.
     * @param name The unique name of the {@link ReasonerVariable} inside the
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel}.
     * @param model Reasoning model of the variable.
     * @param parent Variables container.     
     */
    SequenceVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        nestedElements = new ArrayList<ReasonerVariable>();
    }

    @Override
    protected void assignValue(Object newValue) {
        // FIXME SE: No idea how this should work
    }
    
    @Override
    protected boolean isSameValue(Object newValue) {
        // FIXME SE: No idea how this should work
        return false;
    }
    
    @Override
    protected Object getObjectValue() {
        return null;
    }

    @Override
    public Object getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        nestedElements.add(nestedVariable);
        
    }
}
