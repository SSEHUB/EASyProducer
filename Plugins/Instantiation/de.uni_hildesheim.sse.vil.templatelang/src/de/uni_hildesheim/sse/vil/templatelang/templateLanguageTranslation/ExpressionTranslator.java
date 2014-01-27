package de.uni_hildesheim.sse.vil.templatelang.templateLanguageTranslation;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;

/**
 * A specific expression translator for the template language.
 * 
 * @author Holger Eichelberger
 *
 */
public class ExpressionTranslator 
    extends de.uni_hildesheim.sse.vil.expressions.translation.ExpressionTranslator<VariableDeclaration, Resolver> {
    
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
        Expression result;
        List<CallArgument> arguments = new ArrayList<CallArgument>();
        if (null != firstParam) {
            arguments.add(new CallArgument(firstParam));
        }
        String name = resolveCallArguments(call, arguments, arrayEx, resolver);
        /*if (null != call) {
            if (null != call.getParam()) {
                for (de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument param : call.getParam().getParam()) {
                    arguments.add(new CallArgument(param.getName(), processExpression(param.getEx(), resolver)));
                }
            }
            name = call.getName();
        } else {
            arguments.add(new CallArgument(processExpression(arrayEx, resolver)));
            name = "[]";
        }*/
        CallArgument[] arg = new CallArgument[arguments.size()];
        arguments.toArray(arg);
        if (CallType.SYSTEM == type) {
            throw new TranslatorException("system calls are not supported", call, 
                ExpressionDslPackage.Literals.CALL__NAME, TranslatorException.INTERNAL);
        } else {
            result = null;
            ExpressionException semanticException = null;
            try {
                result = resolver.createCallExpression(CallType.SUPER == type, name, arg);
            } catch (ExpressionException e) {
                semanticException = e;
            }
            if (null == result || continueResolution(semanticException)) {
                try {
                    result = new CallExpression(name, arg);
                    semanticException = checkSemantics(result);
                } catch (ExpressionException e) {
                    // wrong expression
                }
            }
            if ((null == result || continueResolution(semanticException))) {
                // last resort
                try {
                    result = resolver.createExtensionCallExpression(name, arg);
                    semanticException = checkSemantics(result);
                } catch (ExpressionException e) {
                    // wrong expression
                }
            }
            if (null != semanticException) {
                throw new TranslatorException(semanticException, call, ExpressionDslPackage.Literals.CALL__NAME);
            }
        }
        if (null == result) {
            throw new TranslatorException("cannot resolve " + name, call, 
                ExpressionDslPackage.Literals.CALL__NAME, ErrorCodes.UNKNOWN_ELEMENT);
        }
        return result;
    }
    
    @Override
    protected VariableDeclaration createVariableDeclaration(String name, TypeDescriptor<? extends IVilType> type,
                    boolean isConstant, Expression expression) {
        return new VariableDeclaration(name, type, isConstant, expression);
    }

}
