package de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls;

import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.reasoning.drools2.translation.AbstractConstraintTranslator;

/**
 * Handler for translating {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords#NOT} operations.
 * @author Sizonenko
 *
 */
class NotHandler extends TranslationFragment {

    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    NotHandler() {}
    
    @Override
    public synchronized void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        translator.append(" !(");
        constraint.getOperand().accept(translator);
        translator.append(")");
    }

}
