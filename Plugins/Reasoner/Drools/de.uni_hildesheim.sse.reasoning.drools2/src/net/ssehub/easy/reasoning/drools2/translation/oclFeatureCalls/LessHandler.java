package net.ssehub.easy.reasoning.drools2.translation.oclFeatureCalls;

import net.ssehub.easy.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * Handler for translating {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#LESS} operations.
 * @author Sizonenko
 *
 */
class LessHandler extends TranslationFragment {

    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    LessHandler() {}
    
    @Override
    public synchronized void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        constraint.getOperand().accept(translator);
        translator.append(" < ");
        constraint.getParameter(0).accept(translator);
    }

}
