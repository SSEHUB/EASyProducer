package net.ssehub.easy.reasoning.core.model.variables;

import net.ssehub.easy.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.reasoning.core.model.ReasoningState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;

/**
 * {@link ReasonerVariable} representing an Constraint {@link IDecisionVariable}.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class ConstraintVariable extends ReasonerVariable {

    private ConstraintSyntaxTree value;
    
    /**
     * Sole constructor for creating a new {@link ConstraintVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent an integer.
     * @param name The unique name of the {@link ReasonerVariable} inside the 
     *     {@link net.ssehub.easy.reasoning.core.model.ReasonerModel}.
     * @param model Reasoning model of the variable.
     * @param parent Variables container.     
     */
    ConstraintVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        value = null;
//        System.out.println(configVariable.getValue().getType().getName().toString());
        System.out.println(configVariable.getDeclaration().getDefaultValue());
        if (configVariable.getDeclaration().getDefaultValue() != null) {
            value = (ConstraintSyntaxTree) configVariable.getDeclaration().getDefaultValue();
            this.setReasoningState(ReasoningState.DEFAULT_SAME);
            model.addConstraintVariable(this);
        } 
    }
    
    @Override
    public ConstraintSyntaxTree getValue() {
        return value;
    }
    
    @Override
    protected void assignValue(Object newValue) {
        value = (ConstraintSyntaxTree) newValue;
    }
    
    @Override
    protected boolean isSameValue(Object newValue) {
        return value.equals((Integer) newValue) ? true : false;
    }
    
    @Override
    protected ConstraintSyntaxTree getObjectValue() {
        return value;
    }

    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        // TODO Auto-generated method stub
        
    }
}
