package de.uni_hildesheim.sse.vil.rt.rtLanguageTranslation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;
import de.uni_hildesheim.sse.vil.rt.rtVil.FailStatement;
import de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage;
import de.uni_hildesheim.sse.vil.rt.rtVil.RuleElement;
import net.ssehub.easy.dslCore.translation.ErrorCodes;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Resolver;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A specific expression translator for the adaptation language.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionTranslator extends de.uni_hildesheim.sse.buildLanguageTranslation.ExpressionTranslator {

    @Override
    protected IRuleElement resolveRuleElement(de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleElement elt, 
        Resolver resolver) throws TranslatorException {
        IRuleElement result = null;
        if (elt instanceof RuleElement) {
            RuleElement rElt = (RuleElement) elt;
            FailStatement fStmt = rElt.getFail();
            if (null != fStmt) {
                if ("fail".equals(fStmt.getName())) {
                    result = createFailStatement(elt, fStmt, resolver);
                } else {
                    result = new net.ssehub.easy.instantiation.rt.core.model.rtVil.FailStatement(
                        resolver.getCurrentModel());
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
    private net.ssehub.easy.instantiation.rt.core.model.rtVil.FailStatement createFailStatement(
        de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleElement elt, FailStatement fStmt, Resolver resolver) 
        throws TranslatorException{
        net.ssehub.easy.instantiation.core.model.expressions.Expression reasonEx = 
            resolveFailExpression(fStmt.getReason(), TypeRegistry.stringType(), fStmt, 
            RtVilPackage.Literals.FAIL_STATEMENT__REASON, resolver);
        net.ssehub.easy.instantiation.core.model.expressions.Expression codeEx = 
            resolveFailExpression(fStmt.getCode(), TypeRegistry.integerType(), fStmt, 
            RtVilPackage.Literals.FAIL_STATEMENT__CODE, resolver);
        return new net.ssehub.easy.instantiation.rt.core.model.rtVil.FailStatement(reasonEx, codeEx, 
            resolver.getCurrentModel());        
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
    private net.ssehub.easy.instantiation.core.model.expressions.Expression resolveFailExpression(
        Expression ex, TypeDescriptor<?> requiredType, EObject failCause, 
        EStructuralFeature failFeature, Resolver resolver) throws TranslatorException {
        net.ssehub.easy.instantiation.core.model.expressions.Expression result = null;
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
