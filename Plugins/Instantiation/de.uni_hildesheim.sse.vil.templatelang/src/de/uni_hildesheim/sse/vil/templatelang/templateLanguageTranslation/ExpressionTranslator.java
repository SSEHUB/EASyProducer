package de.uni_hildesheim.sse.vil.templatelang.templateLanguageTranslation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.dslCore.translation.MessageHandler;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.AbstractCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionVersionRestriction;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionVersionRestrictionValidator;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationCallExpression;
import net.ssehub.easy.instantiation.core.model.templateModel.BuilderBlockExpression;
import net.ssehub.easy.instantiation.core.model.templateModel.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.ITemplateElement;
import net.ssehub.easy.instantiation.core.model.templateModel.ImplicitVariableDeclaration;
import net.ssehub.easy.instantiation.core.model.templateModel.Resolver;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateBlock;
import net.ssehub.easy.instantiation.core.model.templateModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * A specific expression translator for the template language.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionTranslator 
    extends de.uni_hildesheim.sse.vil.expressions.translation.ExpressionTranslator<VariableDeclaration, Resolver, 
    ExpressionStatement> {
    
    private IStatementTranslator sTranslator;
    
    public interface IStatementTranslator {
        
        /**
         * Processes a statement.
         * 
         * @param stmt the statement to be resolved
         * @return the resolved elements
         * @throws TranslatorException in case that the translation fails due to semantic reasons
         */
        public ITemplateElement processStatement(Stmt stmt) throws TranslatorException;

    }
    
    public void setStatementTranslator(IStatementTranslator sTranslator) {
        this.sTranslator = sTranslator;
    }
    
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
        return checkCallExpression(result, type, call);
    }
    
    @Override
    protected VariableDeclaration createVariableDeclaration(String name, TypeDescriptor<?> type,
        boolean isConstant, Expression expression, Resolver resolver) {
        return new VariableDeclaration(name, type, isConstant, expression);
    }

    @Override
    protected VariableDeclaration createImplicitVariableDeclaration(String name, TypeDescriptor<?> type,
        boolean isConstant, Expression expression, Resolver resolver) {
        return new ImplicitVariableDeclaration(name, type, isConstant, expression);
    }

    @Override
    protected ExpressionVersionRestriction createExpressionVersionRestriction(Expression expr,
        net.ssehub.easy.instantiation.core.model.common.VariableDeclaration decl, 
        EObject cause, EStructuralFeature feature)
        throws RestrictionEvaluationException {
        try {
            ExpressionVersionRestrictionValidator validator = new ExpressionVersionRestrictionValidator(
                new MessageHandler(this, cause, feature));
            expr.accept(validator);
            return new net.ssehub.easy.instantiation.core.model.templateModel.
                ExpressionVersionRestriction(expr, decl);
        } catch (VilException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId());
        }
    }

    @Override
    public Expression parseExpression(String expression, Resolver resolver, StringBuilder warnings) throws VilException {
        return TemplateLangModelUtility.INSTANCE.createExpression(expression, resolver, warnings, 
            getIvmlMessageAdapter());
    }

    @Override
    protected ExpressionStatement createExpressionStatement(Expression expression, Resolver resolver) {
        return new ExpressionStatement(expression, resolver.getCurrentModel());
    }

    @Override
    protected String cannotAssignHint() {
        return "VTL cannot assign values to configurable elements.";
    }

    @Override
    protected Expression processSubCall(Expression result, SubCall call, CallType callType, Resolver resolver) 
        throws TranslatorException {
        Expression subCallResult = null;
        if (call instanceof de.uni_hildesheim.sse.vil.templatelang.templateLang.SubCall) {
            de.uni_hildesheim.sse.vil.templatelang.templateLang.SubCall sc = 
                (de.uni_hildesheim.sse.vil.templatelang.templateLang.SubCall) call;
            if (null == sc.getType() && null == sc.getArrayEx()) { // exclude other alternatives than builder block
                resolver.pushLevel();
                try {
                    BuilderBlockExpression.Mode mode = BuilderBlockExpression.Mode.NONE;
                    TypeDescriptor<?> varType = result.inferType();
                    String varName = "o"; // default
                    if (sc.getId() != null) { // we have parts of the optional type declaration before the |
                        mode = BuilderBlockExpression.Mode.NAME;
                        if (sc.getVarType() != null) { // we have a specific type
                            varType = processType(sc.getVarType(), resolver);
                            mode = BuilderBlockExpression.Mode.TYPE_NAME;
                        }
                        varName = sc.getId();
                    }
                    VariableDeclaration varDecl = new VariableDeclaration(varName, varType, false, result);
                    resolver.add(varDecl);
                    List<ITemplateElement> blockElements = new ArrayList<>();
                    if (sTranslator != null) {
                        for (Stmt stmt: sc.getNested()) {
                            /*Expression ex = processCall(null, unqEx.getCall(), CallType.OTHER, null, resolver);
                            ex = processSubCalls(ex, unqEx.getCalls(), resolver);
                            blockElements.add(createExpressionStatement(ex, resolver));*/
                            blockElements.add(sTranslator.processStatement(stmt));
                        }
                    } else {
                        throw new TranslatorException("No statement translator given", sc, 
                            ExpressionDslPackage.Literals.SUB_CALL__TYPE, TranslatorException.INTERNAL);
                    }
                    subCallResult = new BuilderBlockExpression(varDecl, mode,
                        new TemplateBlock(blockElements.toArray(new ITemplateElement[0])));
                } catch (VilException e) {
                    throw new TranslatorException(e, sc, ExpressionDslPackage.Literals.SUB_CALL__TYPE);
                }
                resolver.popLevel();
            }
        }
        if (null == subCallResult) {
            subCallResult = super.processSubCall(result, call, callType, resolver);
        }
        return subCallResult;
    }

}
