package de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls;

import de.uni_hildesheim.sse.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * This Handler translates a logical equality (if and only if, short iff) into drools specific code.
 * Since drools does not support a logical equality, logical equalities will be translated as follows: <br/>
 * <tt>a iff b</tt><br/>
 * will be translated to <br/>
 * <tt>(a) == (b)</tt>
 * @author El-Sharkawy
 *
 */
class IFFHandler extends TranslationFragment {

    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    IFFHandler() {}
    
    @Override
    public void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        translator.append(" (");
        constraint.getOperand().accept(translator);
        translator.append(") == (");
        constraint.getParameter(0).accept(translator);
        translator.append(")");
    }

}
