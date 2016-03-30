package net.ssehub.easy.reasoning.drools2.translation.oclFeatureCalls;

import net.ssehub.easy.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * Handler for translating {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#DIV_INT} operations.
 * div operation returns how many times parameter fits in the operand. Example: 10 div 3 == 3;
 * @author Sizonenko
 *
 */
class DivHandler extends TranslationFragment {

    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    DivHandler() {
        
    }
    
    @Override
    public synchronized void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        translator.append(" div(");
        constraint.getOperand().accept(translator);
        translator.append(", ");
        constraint.getParameter(0).accept(translator);
        translator.append(")");
    }

}
