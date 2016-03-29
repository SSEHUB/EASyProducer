package de.uni_hildesheim.sse.reasoning.drools2.translation.oclFeatureCalls;

import de.uni_hildesheim.sse.reasoning.drools2.translation.AbstractConstraintTranslator;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;

/**
 * This Handler translates an implication into drools specific code.
 * Since drools does not support an implication, implications will be translated as follows: <br/>
 * <tt>a implies b</tt><br/>
 * will be translated to <br/>
 * <tt>!(a) || (b)</tt>
 * @author El-Sharkawy
 *
 */
class ImpliesHandler extends TranslationFragment {

    /**
     * Sole constructor for this class.
     * Should prevent calling this constructor form outside of the static block.
     */
    ImpliesHandler() {}
    
    @Override
    public void toDroolsCode(AbstractConstraintTranslator translator, OCLFeatureCall constraint) {
        if (translator.getIsImpliesOperand()) {
            constraint.getOperand().accept(translator);
            translator.setIsImpliesOperand(false);
        } else {
            constraint.getParameter(0).accept(translator);
        }
    }

}
