package de.uni_hildesheim.sse.vil.rt.rtLanguageTranslation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IRuleElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
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
                if ("fail".equals(fStmt.getName())) {
                    result = createFailStatement(elt, fStmt, resolver);
                } else {
                    result = new de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.FailStatement();
                }
            }
        }
        return result;
    }
    
    /**
     * Creates an explicit fail statement.
     * 
     * @param elt the rule element
     * @param fStmt the fail statement
     * @param resolver the actual resolver
     * @return the created model element
     * @throws TranslatorException in case that translation fails
     */
    private de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.FailStatement createFailStatement(
        de.uni_hildesheim.sse.vilBuildLanguage.RuleElement elt, FailStatement fStmt, Resolver resolver) 
        throws TranslatorException{
        de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression reasonEx = 
            resolveFailExpression(fStmt.getReason(), TypeRegistry.stringType(), fStmt, 
            RtVilPackage.Literals.FAIL_STATEMENT__REASON, resolver);
        de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression codeEx = 
            resolveFailExpression(fStmt.getCode(), TypeRegistry.integerType(), fStmt, 
            RtVilPackage.Literals.FAIL_STATEMENT__CODE, resolver);
        return new de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.FailStatement(reasonEx, codeEx);        
    }
    
    /**
     * Resolves an expression used in a fail statement.
     * 
     * @param ex the expression
     * @param requiredType the required type of the evaluated expression
     * @param failCause the failure cause (if failing)
     * @param failFeature the failure feature (if failing)
     * @param resolver the resolver
     * @return the resolved expression or <b>null</b>
     * @throws TranslatorException in case of translation problems
     */
    private de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression resolveFailExpression(
        Expression ex, TypeDescriptor<?> requiredType, EObject failCause, 
        EStructuralFeature failFeature, Resolver resolver) throws TranslatorException {
        de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression result = null;
        if (null != ex) {
            result = processExpression(ex, resolver);
            if (null != result) {
                try {
                if (!requiredType.isAssignableFrom(result.inferType())) {
                    throw new TranslatorException("Expression must be of type " + requiredType.getVilName(), failCause, 
                        failFeature, ErrorCodes.TYPE_CONSISTENCY);
                }
                } catch (VilException e) {
                    throw new TranslatorException(e, failCause, failFeature);
                }
            }
        }
        return result;
    }

    @Override
    protected String cannotAssignHint() {
        return ""; // no hint, rt-VIL can assign values
    }
    
    // TODO intend
    
}
