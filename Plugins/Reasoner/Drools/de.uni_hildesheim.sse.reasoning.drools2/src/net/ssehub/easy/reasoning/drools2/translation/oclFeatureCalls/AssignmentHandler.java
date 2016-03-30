package net.ssehub.easy.reasoning.drools2.translation.oclFeatureCalls;

import net.ssehub.easy.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * Handler for translating {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#ASSIGNMENT} operations.
 * @author Sizonenko
 *
 */
class AssignmentHandler extends TranslationFragment {

    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    AssignmentHandler() {
        
    }
    
    @Override
    public synchronized void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        if (validForAssignment(constraint)) {
            appendAssignment(translator, constraint);
        } else {            
            appendEquality(translator, constraint);
        }
    }

}
