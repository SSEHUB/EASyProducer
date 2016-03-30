package net.ssehub.easy.reasoning.drools2.translation.oclFeatureCalls;

import net.ssehub.easy.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * Elements for translating {@link OCLFeatureCall}s into Drools specific code.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public abstract class TranslationFragment {
    
    /**
     * Translates the element into Drools specific expressions.
     * @param translator Instance of current translator (to avoid errors in multithreading).
     * @param constraint Constraint to translate.
     */
    public abstract void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint);
    
    /**
     * Method for determining if assignment could be performed on the operand.
     * @param constraint Constraint to translate.
     * @return true if assignment is possible.
     */
    protected boolean validForAssignment(OCLFeatureCall constraint) {
        boolean isValid = false;
        if (constraint.getOperand().getClass().getSimpleName().equals("Variable")
            ||
            constraint.getOperand().getClass().getSimpleName().equals("CompoundAccess")) {
            isValid = true;
        } 
        return isValid; 
    }
    
    /**
     * Method for translating equality constraint.
     * @param translator Instance of current translator (to avoid errors in multithreading).
     * @param constraint Constraint to translate.
     */
    protected void appendEquality(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        translator.append("(");
        constraint.getOperand().accept(translator);
        translator.append(") == (");
        constraint.getParameter(0).accept(translator);
        translator.append(")");
    }
    
    /**
     * Method for translating assignment constraint.
     * @param translator Instance of current translator (to avoid errors in multithreading).
     * @param constraint Constraint to translate.
     */
    protected void appendAssignment(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        translator.setIsAssignmentOperand(true);
        constraint.getOperand().accept(translator);        
        translator.setIsAssignmentOperand(false);
        translator.append("(");
        constraint.getParameter(0).accept(translator);
        translator.append(")");
    }
    
}
