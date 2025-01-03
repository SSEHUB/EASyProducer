package net.ssehub.easy.reasoning.drools2.translation.oclFeatureCalls;

import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.drools2.model.ConstraintPattern;
import net.ssehub.easy.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * Handler for translating {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#EQUALS} operations.
 * @author Sizonenko
 *
 */
class EqualsHandler extends TranslationFragment {
   
    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    EqualsHandler() {
        
    }
    
    @Override
    public synchronized void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        if (translator.getOperation() == ReasoningOperation.PROPAGATION 
            && translator.getConstraintPattern() == ConstraintPattern.IMPLIES_VALIDATION
            && translator.getPropagationPosition()
            && validForAssignment(constraint)
            ) {
            appendAssignment(translator, constraint);
        } else {            
            appendEquality(translator, constraint);
        }
    }

}
