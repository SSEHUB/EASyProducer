package de.uni_hildesheim.sse.vil.templatelang.templateLanguageTranslation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.MessageHandler;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.AbstractCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ResolvableOperationCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionVersionRestriction;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionVersionRestrictionValidator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.utils.modelManagement.RestrictionEvaluationException;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;

/**
 * A specific expression translator for the template language.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionTranslator 
    extends de.uni_hildesheim.sse.vil.expressions.translation.ExpressionTranslator<VariableDeclaration, Resolver, 
    ExpressionStatement> {
    
    /**
     * Processes a function call.
     * 
     * @param firstParam the first parameter (may be <b>null</b>)
     * @param call the function all (may be <b>null</b>, but then <code>arrayEx</code> is required)
     * @param arrayEx an array access expression (may be <b>null</b>, but then <code>call</code> is required)
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processCall(Expression firstParam, Call call, CallType type,
        de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression arrayEx, Resolver resolver) 
        throws TranslatorException {
        AbstractCallExpression result;
        List<CallArgument> arguments = new ArrayList<CallArgument>();
        if (null != firstParam) {
            arguments.add(new CallArgument(firstParam));
        }
        List<VariableDeclaration> varDecls = resolveIteratorDeclarations(call, type, arguments, resolver);
        String name = resolveCallArguments(call, varDecls, arguments, arrayEx, resolver);
        CallArgument[] arg = new CallArgument[arguments.size()];
        arguments.toArray(arg);
        if (CallType.SYSTEM == type) {
            throw new TranslatorException("system calls are not supported", call, 
                ExpressionDslPackage.Literals.CALL__NAME, TranslatorException.INTERNAL);
        } else {
            result = null;
            VilException semanticException = null;
            try {
                result = resolver.createCallExpression(CallType.SUPER == type, name, arg);
            } catch (VilException e) {
                semanticException = e;
            }
            if (null == result || continueResolution(semanticException)) {
                try {
                    result = new CallExpression(null, name, arg);
                    semanticException = checkSemantics(result);
                } catch (VilException e) {
                    // wrong expression
                }
            }
            if ((null == result || continueResolution(semanticException))) {
                // last resort
                try {
                    result = resolver.createExtensionCallExpression(name, arg);
                    semanticException = checkSemantics(result);
                } catch (VilException e) {
                    // wrong expression
                }
            }
            if (null == result || continueResolution(semanticException)) {
                VariableDeclaration opVar = resolver.resolve(name, false);
                if (null != opVar) {
                    try {
                        result = new ResolvableOperationCallExpression(opVar, arg);
                        semanticException = checkSemantics(result);
                    } catch (VilException e) {
                        // wrong expression
                    }
                }
            }
            if (null != semanticException) {
                throw new TranslatorException(semanticException, call, ExpressionDslPackage.Literals.CALL__NAME);
            }
        }
        if (null == result) {
            throw new TranslatorException("cannot resolve call to '" + name + "'", call, 
                ExpressionDslPackage.Literals.CALL__NAME, ErrorCodes.UNKNOWN_ELEMENT);
        }
        if (result.isPlaceholder()) {
            warning("The operation '" + result.getVilSignature() 
                + "' is unknown, shall be a VIL type - may lead to a runtime error", call, 
                ExpressionDslPackage.Literals.CALL__NAME, ErrorCodes.UNKNOWN_TYPE);
        }
        return result;
    }
    
    @Override
    protected VariableDeclaration createVariableDeclaration(String name, TypeDescriptor<?> type,
                    boolean isConstant, Expression expression) {
        return new VariableDeclaration(name, type, isConstant, expression);
    }

    @Override
    protected ExpressionVersionRestriction createExpressionVersionRestriction(Expression expr,
        de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration decl, 
        EObject cause, EStructuralFeature feature)
        throws RestrictionEvaluationException {
        try {
            ExpressionVersionRestrictionValidator validator = new ExpressionVersionRestrictionValidator(
                new MessageHandler(this, cause, feature));
            expr.accept(validator);
            return new de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.
                ExpressionVersionRestriction(expr, decl);
        } catch (VilException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId());
        }
    }

    @Override
    protected Expression parseExpression(String expression, Resolver resolver, StringBuilder warnings) throws VilException {
        return TemplateLangModelUtility.INSTANCE.createExpression(expression, resolver, warnings);
    }

    @Override
    protected ExpressionStatement createExpressionStatement(Expression expression) {
        return new ExpressionStatement(expression);
    }

    @Override
    protected String cannotAssignHint() {
        return "VTL cannot assign values to configurable elements.";
    }

}
