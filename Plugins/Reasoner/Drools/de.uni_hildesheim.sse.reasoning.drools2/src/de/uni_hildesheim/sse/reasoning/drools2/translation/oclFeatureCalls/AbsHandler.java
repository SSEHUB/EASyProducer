package de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls;

import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.reasoning.drools2.translation.AbstractConstraintTranslator;

/**
 * Handler for translating {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords#ABS} operations.
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
