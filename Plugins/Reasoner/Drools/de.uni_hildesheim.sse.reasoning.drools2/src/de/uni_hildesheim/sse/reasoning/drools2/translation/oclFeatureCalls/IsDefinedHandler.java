package de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls;

import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.reasoning.drools2.translation.AbstractConstraintTranslator;

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
