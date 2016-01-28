package de.uni_hildesheim.sse.vil.rt.rtLanguageTranslation;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IRuleElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;
import de.uni_hildesheim.sse.vil.rt.rtVil.FailStatement;
import de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage;
import de.uni_hildesheim.sse.vil.rt.rtVil.RuleElement;

/**
 * A specific expression translator for the adaptation language.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionTranslator extends de.uni_hildesheim.sse.buildLanguageTranslation.ExpressionTranslator {

    @Override
    protected IRuleElement resolveRuleElement(de.uni_hildesheim.sse.vilBuildLanguage.RuleElement elt, 
        Resolver resolver) throws TranslatorException {
        IRuleElement result = null;
        if (elt instanceof RuleElement) {
            RuleElement rElt = (RuleElement) elt;
            FailStatement fStmt = rElt.getFail();
            if (null != fStmt) {
                de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression codeEx = null;
                Expression expr = fStmt.getCode();
                if (null != expr) {
                    codeEx = processExpression(expr, resolver);
                    if (null != codeEx) {
                        try {
                        if (!TypeRegistry.integerType().isAssignableFrom(codeEx.inferType())) {
                            throw new TranslatorException("Code expression must be of type Integer", elt, 
                                RtVilPackage.Literals.FAIL_STATEMENT__CODE, ErrorCodes.TYPE_CONSISTENCY);
                        }
                        } catch (VilException e) {
                            throw new TranslatorException(e, elt, RtVilPackage.Literals.FAIL_STATEMENT__CODE);
                        }
                    }
                }
                result = new de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.FailStatement(
                    fStmt.getReason(), codeEx);
            }
        }
        return result;
    }
    
    // TODO intend
    
}
