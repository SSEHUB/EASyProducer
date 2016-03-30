package net.ssehub.easy.reasoning.drools2.translation.oclFeatureCalls;

import net.ssehub.easy.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * Handler for translating {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#ABS} operations.
 * @author Sizonenko
 *
 */
class AbsHandler extends TranslationFragment {
    
    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    AbsHandler() {
        
    }
    
    @Override
    public synchronized void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        translator.append(" abs(");
        constraint.getOperand().accept(translator);
        translator.append(")");
    }

}
