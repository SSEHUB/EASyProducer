package de.uni_hildesheim.sse.buildLanguageTranslation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vilBuildLanguage.Alternative;
import de.uni_hildesheim.sse.vilBuildLanguage.Join;
import de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable;
import de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable;
import de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElement;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.dslCore.translation.ErrorCodes;
import net.ssehub.easy.dslCore.translation.MessageHandler;
import net.ssehub.easy.dslCore.translation.StringUtils;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.instantiation.core.model.buildlangModel.AlternativeExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ForStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.InstantiateExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.JoinExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.JoinVariableDeclaration;
import net.ssehub.easy.instantiation.core.model.buildlangModel.MapExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.NestedRuleBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Resolver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.SimpleStatementBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.StrategyCallExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.buildlangModel.WhileStatement;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.AbstractCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionVersionRestriction;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionVersionRestrictionValidator;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationCallExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;

/**
 * A specific expression translator for the build language.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionTranslator 
    extends de.uni_hildesheim.sse.vil.expressions.translation.ExpressionTranslator<VariableDeclaration, Resolver, 
    ExpressionStatement> {
    
    /**
     * Processes a primary expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    public Expression processPrimaryExpression(de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression ex, 
        Resolver resolver) throws TranslatorException {
    	Expression result = null;
    	if (ex != null) {
	    result = super.processPrimaryExpression(ex, resolver);
	    PrimaryExpression pEx = (PrimaryExpression) ex;
	    SystemExecution systemEx = pEx.getSysEx();
	    if (null != systemEx) {
                result = processCall(null, systemEx.getCall(), CallType.SYSTEM, null, resolver);
                result = processSubCalls(result, systemEx.getCalls(), resolver);
	    }
	    if (null != pEx.getJoin()) {
                result = processJoin(pEx.getJoin(), resolver);
	    }
	    if (null != pEx.getMap()) {
                result = processMap(pEx.getMap(), resolver);
	    }
	    if (null != pEx.getInstantiate()) {
                result = processInstantiate(pEx.getInstantiate(), resolver);
	    }
    	}
        return result;
    }

    /**
     * Processes an instantiate expression. Here, many must be deferred to runtime as the main parameter determining
     * the rule to be executed can only be determined at runtime.
     * 
     * @param inst
     * @param resolver
     * @return
     * @throws TranslatorException
     */
    private InstantiateExpression processInstantiate(de.uni_hildesheim.sse.vilBuildLanguage.Instantiate inst, 
        Resolver resolver) throws TranslatorException {
        InstantiateExpression result;
        List<CallArgument> arguments = new ArrayList<CallArgument>();
        if (null != inst.getParam()) {
            for (de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument param : inst.getParam().getParam()) {
                arguments.add(new CallArgument(param.getName(), processExpression(param.getEx(), resolver)));
            }
        }
        CallArgument[] args = new CallArgument[arguments.size()];
        arguments.toArray(args);
        VariableDeclaration var = null;
        if (null != inst.getProject()) {
            // check what can be checked... remainder happens at runtime
            var = resolver.resolve(inst.getProject(), false, inst, 
                VilBuildLanguagePackage.Literals.INSTANTIATE__PROJECT, this);
            if (null != var) {
                if (!IvmlTypes.projectType().isAssignableFrom(var.getType())) {
                    throw new TranslatorException(inst.getProject() + " is not of type Project", inst, 
                         VilBuildLanguagePackage.Literals.INSTANTIATE__PROJECT, ErrorCodes.TYPE_CONSISTENCY);
                }
            } else {
                throw new TranslatorException("cannot resolve " + inst.getProject(), inst, 
                    VilBuildLanguagePackage.Literals.INSTANTIATE__PROJECT, VilException.ID_CANNOT_RESOLVE);
            }
        } else {
            if (0 == StringUtils.convertString(inst.getRuleName()).length()) {
                throw new TranslatorException("the rule name must not be empty", inst, 
                    VilBuildLanguagePackage.Literals.INSTANTIATE__PROJECT, ErrorCodes.UNKNOWN_ELEMENT);
            }
        }

        try {
            if (null != inst.getProject()) {
                IVersionRestriction vRestrict = null;
                if (null != inst.getVersionSpec()) {
                    warnVersionRestrictions(inst.getVersionSpec());
                    vRestrict = processRestriction(inst.getProject(), inst.getVersionSpec(), resolver);
                }
                result = new InstantiateExpression(var, vRestrict, null, args);
            } else {
                result = new InstantiateExpression(StringUtils.convertString(inst.getRuleName()), args);
            }
        } catch (VilException e) {
            throw new TranslatorException(e, inst, VilBuildLanguagePackage.Literals.INSTANTIATE__PARAM);
        }
        return result;
    }

    /**
     * Processes an alternative expression.
     * 
     * @param alt the ECore object representing the alternative expression
     * @param resolver a resolver instance for resolving variables etc.
     * @return the translated object in terms of the build language model
     * @throws TranslatorException in case that the translation fails
     */
    private AlternativeExpression processAlternative(Alternative alt, Resolver resolver) throws TranslatorException {
        try {
            Expression cond = processExpression(alt.getExpr(), resolver);
            cond = assertBooleanExpression(cond, alt, VilBuildLanguagePackage.Literals.ALTERNATIVE__EXPR);
            resolver.pushLevel();
            IRuleBlock ifBlock = resolveStatementOrBlock(alt.getIf(), resolver);
            resolver.popLevel();
            resolver.pushLevel();
            IRuleBlock elseBlock = resolveStatementOrBlock(alt.getElse(), resolver);
            resolver.popLevel();
            return new AlternativeExpression(cond, ifBlock, elseBlock);
        } catch (VilException e) {
            throw new TranslatorException(e, alt, VilBuildLanguagePackage.Literals.ALTERNATIVE__IF);
        }
    }

    /**
     * Processes a "while" statement.
     * 
     * @param stmt the ECore object representing the statement
     * @param resolver a resolver instance for resolving variables etc.
     * @return the translated object in terms of the build language model
     * @throws TranslatorException in case that the translation fails
     */
    private WhileStatement processWhileStatement(de.uni_hildesheim.sse.vilBuildLanguage.While stmt, Resolver resolver) 
        throws TranslatorException {
        Expression expr = processExpression(stmt.getExpr(), resolver);
        expr = assertBooleanExpression(expr, stmt, VilBuildLanguagePackage.Literals.MAP__EXPR);
        resolver.pushLevel();
        IRuleElement[] block = resolveBlock(stmt.getBlock(), resolver);
        resolver.popLevel();
        try {
            return new WhileStatement(expr, block);
        } catch (VilException e) {
            throw new TranslatorException(e, stmt, VilBuildLanguagePackage.Literals.WHILE__EXPR);
        }
    }

    /**
     * Processes a "for" statement.
     * 
     * @param stmt the ECore object representing the statement
     * @param resolver a resolver instance for resolving variables etc.
     * @return the translated object in terms of the build language model
     * @throws TranslatorException in case that the translation fails
     */
    private ForStatement processForStatement(de.uni_hildesheim.sse.vilBuildLanguage.For stmt, Resolver resolver) 
        throws TranslatorException {
        Expression expr = processExpression(stmt.getExpr(), resolver);
        TypeDescriptor<?> type = null;
        try {
            type = expr.inferType();
        } catch (VilException e) {
            throw new TranslatorException(e, stmt, VilBuildLanguagePackage.Literals.FOR__EXPR);
        }
        if (!type.isCollection() && !type.isIterator()) {
            OperationDescriptor conversion = type.getConversionToSequence();
            if (null == conversion) {
                throw new TranslatorException("for must run over collection", stmt, 
                    VilBuildLanguagePackage.Literals.FOR__EXPR, ErrorCodes.TYPE_CONSISTENCY);
            } else {
                type = conversion.getReturnType();
            }
        }
        EList<LoopVariable> vars = stmt.getVar();
        if (type.getGenericParameterCount() != vars.size()) {
            throw new TranslatorException("number of for variables does not comply with expression", stmt, 
                VilBuildLanguagePackage.Literals.FOR__EXPR, ErrorCodes.TYPE_CONSISTENCY);
        }
        int vSize = vars.size();
        VariableDeclaration[] mapVars = new VariableDeclaration[vSize];
        TypeDescriptor<?>[] givenTypes = TypeDescriptor.createArray(vSize);
        for (int i = 0; i < vars.size(); i++) {
            LoopVariable mv = vars.get(i);
            TypeDescriptor<?> varType = type.getGenericParameterType(i);
            if (null != mv.getType()) {
                givenTypes[i] = processType(mv.getType(), resolver);
                if (!givenTypes[i].isAssignableFrom(varType) && null == varType.findConversion(varType, givenTypes[i])) {
                    throw new TranslatorException("explicitly given type '" + givenTypes[i].getVilName() 
                        + "'of for iterator variable '" + mv.getVar() + "' does not match inferred type '" 
                        + varType.getVilName() + "'", mv, 
                        VilBuildLanguagePackage.Literals.LOOP_VARIABLE__TYPE, ErrorCodes.TYPE_CONSISTENCY);
                } else {
                    varType = givenTypes[i];
                }
            }
            mapVars[i] = new VariableDeclaration(mv.getVar(), varType);
        }
        resolver.pushLevel();
        resolver.add(mapVars);
        IRuleElement[] block = resolveBlock(stmt.getBlock(), resolver);
        resolver.popLevel();
        try {
            return new ForStatement(mapVars, expr, block, givenTypes, stmt.getSeparator().equals(Constants.COLON));
        } catch (VilException e) {
            throw new TranslatorException(e, stmt, VilBuildLanguagePackage.Literals.FOR__VAR);
        }
    }
    
    /**
     * Processes a "map" expression.
     * 
     * @param map the ECore object representing the expression
     * @param resolver a resolver instance for resolving variables etc.
     * @return the translated object in terms of the build language model
     * @throws TranslatorException in case that the translation fails
     */
    private MapExpression processMap(de.uni_hildesheim.sse.vilBuildLanguage.Map map, Resolver resolver) 
        throws TranslatorException {
        Expression expr = processExpression(map.getExpr(), resolver);
        TypeDescriptor<?> type = null;
        try {
            type = expr.inferType();
        } catch (VilException e) {
            throw new TranslatorException(e, map, VilBuildLanguagePackage.Literals.MAP__EXPR);
        }
        if (!type.isCollection() && !type.isIterator()) {
            OperationDescriptor conversion = type.getConversionToSequence();
            if (null == conversion) {
                throw new TranslatorException("map must run over collection", map, 
                    VilBuildLanguagePackage.Literals.MAP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
            } else {
                type = conversion.getReturnType();
            }
        }
        EList<LoopVariable> vars = map.getVar();
        if (type.getGenericParameterCount() != vars.size()) {
            throw new TranslatorException("number of map variables does not comply with expression", map, 
                VilBuildLanguagePackage.Literals.MAP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
        }
        int vSize = vars.size();
        VariableDeclaration[] mapVars = new VariableDeclaration[vSize];
        TypeDescriptor<?>[] givenTypes = TypeDescriptor.createArray(vSize);
        for (int i = 0; i < vars.size(); i++) {
            LoopVariable mv = vars.get(i);
            TypeDescriptor<?> varType = type.getGenericParameterType(i);
            if (null != mv.getType()) {
                givenTypes[i] = processType(mv.getType(), resolver);
                if (!givenTypes[i].isAssignableFrom(varType) && null == varType.findConversion(varType, givenTypes[i])) {
                    throw new TranslatorException("explicitly given type '" + givenTypes[i].getVilName() 
                        + "'of map variable '" + mv.getVar() + "' does not match inferred type '" 
                        + varType.getVilName() + "'", mv, 
                        VilBuildLanguagePackage.Literals.LOOP_VARIABLE__TYPE, ErrorCodes.TYPE_CONSISTENCY);
                } else {
                    varType = givenTypes[i];
                }
            }
            mapVars[i] = new VariableDeclaration(mv.getVar(), varType);
        }
        resolver.pushLevel();
        resolver.limitVariablesOnCurrentLevel(); // specific for map
        resolver.add(mapVars);
        IRuleElement[] block = resolveBlock(map.getBlock(), resolver);
        resolver.popLevel();
        try {
            return new MapExpression(mapVars, expr, block, givenTypes, map.getSeparator().equals(Constants.COLON));
        } catch (VilException e) {
            throw new TranslatorException(e, map, VilBuildLanguagePackage.Literals.MAP__VAR);
        }
    }
    
    /**
     * Resolves a statement-or-block part.
     * 
     * @param part the ECore part object to be resolved (may be <b>null</b>)
     * @param resolver the resolver
     * @return the resolved element (may be <b>null</b>)
     * @throws TranslatorException in case of translation problems
     */
    private IRuleBlock resolveStatementOrBlock(StatementOrBlock part, Resolver resolver) throws TranslatorException {
        IRuleBlock result = null;
        if (null != part) {
            if (null != part.getBlock()) {
                result = new NestedRuleBlock(resolveBlock(part.getBlock(), resolver));
            } else if (null != part.getExStmt()) {
                result = new SimpleStatementBlock(processExpressionStatement(part.getExStmt(), resolver));
            }
        }
        return result;
    }
    
    /**
     * Resolves a block of rule elements.
     * 
     * @param block the block to be resolved
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resolved elements
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    public IRuleElement[] resolveBlock(RuleElementBlock block, Resolver resolver) {
        IRuleElement[] result = null;
        if (null != block && null != block.getElements()) {
            result = resolveBlock(block.getElements(), resolver);
        }
        return result;
    }

    /**
     * Resolves a block of rule elements.
     * 
     * @param block the block to be resolved
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resolved elements
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    public IRuleElement[] resolveBlock(List<? extends RuleElement> block, Resolver resolver) {
        IRuleElement[] result = null;
        if (null != block) {
            List<IRuleElement> tmp = new ArrayList<IRuleElement>();
            for (RuleElement elt : block) {
                try {
                    if (null != elt.getExprStmt()) {
                        tmp.add(processExpressionStatement(elt.getExprStmt(), resolver));
                    } else if (null != elt.getVarDecl()) {
                        tmp.add(processVariableDeclaration(elt.getVarDecl(), resolver));
                    } else if (null != elt.getFor()) {
                        tmp.add(processForStatement(elt.getFor(), resolver));
                    } else if (null != elt.getWhile()) {
                        tmp.add(processWhileStatement(elt.getWhile(), resolver));
                    } else {
                        IRuleElement rElt = resolveRuleElement(elt, resolver);
                        if (null != rElt) {
                            tmp.add(rElt);
                        }
                    }
                } catch (TranslatorException e) {
                    error(e);
                }
            }
            if (!tmp.isEmpty()) {
                result = new IRuleElement[tmp.size()];
                tmp.toArray(result);
            }
        }
        return result;
    }
    
    /**
     * Called if the default processing of rule elements cannot be applied.
     * 
     * @param elt the rule element
     * @param resolver the resolver
     * @return the resolved element (may be <b>null</b>, is ignored then)
     * @throws TranslatorException in case that resolving the rule element fails for some reason
     */
    protected IRuleElement resolveRuleElement(RuleElement elt, Resolver resolver) throws TranslatorException {
        return null;
    }

    @Override
    protected ExpressionStatement createExpressionStatement(Expression expression, Resolver resolver) {
        return new ExpressionStatement(expression);
    }

    /**
     * Processes an expression statement.
     * 
     * @param expr the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the expression statement
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    public ExpressionStatement processExpressionStatement(
        de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement expr, Resolver resolver) 
        throws TranslatorException {
        ExpressionStatement result;
        if (null != expr.getAlt()) {
            result = createExpressionStatement(processAlternative(expr.getAlt(), resolver), resolver);
        } else {
            result = super.processExpressionStatement(expr, resolver);
        }
        return result;
    }
    
    /**
     * Processes a join.
     * 
     * @param join the join to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the join model representation
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected JoinExpression processJoin(Join join, Resolver resolver) throws TranslatorException {
        JoinVariableDeclaration [] vars = new JoinVariableDeclaration[2];
        vars[0] = processJoinVariable(join.getVar1(), resolver);
        vars[1] = processJoinVariable(join.getVar2(), resolver);
        Expression condition = null;
        if (null != join.getCondition()) {
            resolver.pushLevel();
            for (int i = 0; i < vars.length; i++) {
                resolver.add(vars[i]); // only the first shall be relevant
            }
            try {
                condition = processExpression(join.getCondition(), resolver);
            } catch (TranslatorException e) {
                throw e;
            } finally {
                resolver.popLevel();
            }
        }
        try {
            return new JoinExpression(vars, condition);
        } catch (VilException e) {
            throw new TranslatorException(e, join, VilBuildLanguagePackage.Literals.JOIN__CONDITION);
        }
    }

    /**
     * Processes a join variable.
     * 
     * @param var the variable to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the join variable
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected JoinVariableDeclaration processJoinVariable(JoinVariable var, Resolver resolver) throws TranslatorException {
        Expression ex = processExpression(var.getExpr(), resolver);
        try {
            return new JoinVariableDeclaration(var.getVar(), ex, null != var.getExcl());
        } catch (VilException e) {
            throw new TranslatorException(e, var, VilBuildLanguagePackage.Literals.JOIN_VARIABLE__VAR);
        }
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
            try {
                VariableDeclaration nameVar = resolver.resolve(name, false, call, 
                    ExpressionDslPackage.Literals.CALL__NAME, this);
                if (null == nameVar) {
                    throw new TranslatorException("cannot resolve variable " + nameVar, call, 
                        ExpressionDslPackage.Literals.CALL__NAME, ErrorCodes.UNKNOWN_ELEMENT);
                }
                result = new StrategyCallExpression(nameVar, arg);
                result.inferType();
            } catch (VilException e) {
                throw new TranslatorException(e, call, ExpressionDslPackage.Literals.CALL__NAME);
            }
        } else {
            result = null;
            VilException semanticException = null;
            //if (Resolver.ContextType.RULE_HEADER == resolver.getContextType()) {
                try {
                    result = resolver.createCallExpression(CallType.SUPER == type, name, arg);
                } catch (VilException e) {
                    semanticException = e;
                }
            //}
            if ((null == result || continueResolution(semanticException)) && Resolver.ContextType.RULE_BODY == resolver.getContextType()) {
                // grammar supports system executions only on top-level
                try {
                    StrategyCallExpression sce = new StrategyCallExpression(resolver.getCurrentModel(), name, arg);
                    sce.setTypeRegistry(resolver.getTypeRegistry());
                    result = sce;
                    semanticException = checkSemantics(result);
                } catch (VilException e) {
                    // wrong expression
                }
            }
            if (null == result || continueResolution(semanticException)) {
                try {
                    result = new CallExpression(null, name, arg);
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
            throw new TranslatorException("cannot resolve " + call.getName(), call, 
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
        boolean isConstant, Expression expression, Resolver resolver) {
        return new VariableDeclaration(name, type, isConstant, expression);
    }

    @Override
    protected ExpressionVersionRestriction createExpressionVersionRestriction(Expression expr,
        net.ssehub.easy.instantiation.core.model.common.VariableDeclaration decl, 
        EObject cause, EStructuralFeature feature) throws RestrictionEvaluationException {
        try {
            ExpressionVersionRestrictionValidator validator = new ExpressionVersionRestrictionValidator(
                new MessageHandler(this, cause, feature));
            expr.accept(validator);
            return new net.ssehub.easy.instantiation.core.model.buildlangModel.
                ExpressionVersionRestriction(expr, decl);
        } catch (VilException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId());
        }
    }

    @Override
    protected Expression parseExpression(String expression, Resolver resolver, StringBuilder warnings) throws VilException {
        return BuildLangModelUtility.INSTANCE.createExpression(expression, resolver, warnings);
    }

    @Override
    protected String cannotAssignHint() {
        return "VIL cannot assign values to configurable elements.";
    }

}
