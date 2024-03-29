package net.ssehub.easy.reasoning.drools2.translation.oclFeatureCalls;

import net.ssehub.easy.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * Handler for translating de.uni_hildesheim.sse.model.varModel.datatypes.Compound.IS_DEFINED operations.
 * @author Sizonenko
 *
 */
class IsDefinedHandler extends TranslationFragment {

    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    IsDefinedHandler() {
        
    }
    
    @Override
    public synchronized void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        translator.append(" isDefined(");
        constraint.getOperand().accept(translator);
        translator.append(")");
    }

}
