package de.uni_hildesheim.sse.reasoning.core.model.variables;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * {@link ReasonerVariable} representing a Set {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class SetVariable extends ReasonerVariable {

    private Set<ReasonerVariable> nestedElements;
    
    /**
     * Sole constructor for creating a new {@link SetVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent a Set.
     * @param name The unique name of the {@link ReasonerVariable} inside the
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel}.
     * @param model Reasoning model of the variable.
     * @param parent Variables container.     
     */
    SetVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        nestedElements = new HashSet<ReasonerVariable>();
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
