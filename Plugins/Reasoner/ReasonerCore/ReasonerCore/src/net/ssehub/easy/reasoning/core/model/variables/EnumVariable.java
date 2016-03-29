package net.ssehub.easy.reasoning.core.model.variables;

import net.ssehub.easy.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;

/**
 * {@link ReasonerVariable} representing an enumeration {@link IDecisionVariable}.
 * This subsumes ordered and not ordered enumerations.
 * @author El-Sharkawy
 *
 */
public class EnumVariable extends ReasonerVariable {

    private Integer value;
    
    /**
     * Sole constructor for creating a new {@link EnumVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent an enumeration.
     * @param name The unique name of the {@link ReasonerVariable} inside the
     *     {@link net.ssehub.easy.reasoning.core.model.ReasonerModel}. 
     * @param model Reasoning model of the variable.
     * @param parent Variables container.       
     */
    EnumVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        //Enum type = (Enum) configVariable.getDeclaration().getType();
        
        // Default value is the smallest ordinal or 0 if no literal exists.
        //value = type.getLiteralCount() > 0 ? type.getLiteral(0).getOrdinal() : 0;
        value = null;
        if (configVariable.getState() != AssignmentState.UNDEFINED) {
            System.out.println("Value to cast: " + name.toString() 
                    + " " + configVariable.getValue().getType().getName());
            if (!configVariable.getValue().getType().getName().equals("AnyType")) {                
                value = ((EnumLiteral) configVariable.getValue().getValue()).getOrdinal();
            }            
        }
    }

    @Override
    protected void assignValue(Object newValue) {
        value = (Integer) newValue;
    }

    @Override
    protected boolean isSameValue(Object newValue) {
        return value == (Integer) newValue ? true : false;
    }
    
    @Override
    protected Integer getObjectValue() {
        return value;
    }
    
    /**
     * Method to get value of {@link EnumVariable}. 
     * @return Integer representation of the value.
     */
    public Integer getValue() {
        return value;
    }

    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        // TODO Auto-generated method stub
        
    }
}
