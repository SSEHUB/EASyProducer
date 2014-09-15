package de.uni_hildesheim.sse.buildLanguageTranslation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IRuleElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.InstantiateExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.JoinExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.JoinVariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.MapExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StrategyCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.AbstractCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ValueAssignmentExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlTypes;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.translation.ImportTranslator;
import de.uni_hildesheim.sse.vilBuildLanguage.Join;
import de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable;
import de.uni_hildesheim.sse.vilBuildLanguage.MapVariable;
import de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElement;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

/**
 * A specific expression translator for the build language.
 * 
 * @author Holger Eichelberger
 *
 */
public class ExpressionTranslator 
    extends de.uni_hildesheim.sse.vil.expressions.translation.ExpressionTranslator<VariableDeclaration, Resolver> {
    
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
            var = resolver.resolve(inst.getProject(), false);
            if (null != var) {
                if (!IvmlTypes.projectType().isAssignableFrom(var.getType())) {
                    throw new TranslatorException(inst.getProject() + " is not of type Project", inst, 
                         VilBuildLanguagePackage.Literals.INSTANTIATE__PROJECT, ErrorCodes.TYPE_CONSISTENCY);
                }
            } else {
                throw new TranslatorException("cannot resolve " + inst.getProject(), inst, 
                    VilBuildLanguagePackage.Literals.INSTANTIATE__PROJECT, ExpressionException.ID_CANNOT_RESOLVE);
            }
        } else {
            if (0 == convertString(inst.getRuleName()).length()) {
                throw new TranslatorException("the rule name must not be empty", inst, 
                    VilBuildLanguagePackage.Literals.INSTANTIATE__PROJECT, ErrorCodes.UNKNOWN_ELEMENT);
            }
        }

        try {
            if (null != inst.getProject()) {
                VersionRestriction[] vRestrict = null;
                if (null != inst.getVersionSpec()) {
                    warnVersionRestrictions(inst.getVersionSpec());
                    vRestrict = ImportTranslator.processRestrictions(inst.getProject(), inst.getVersionSpec());
                }
                result = new InstantiateExpression(var, vRestrict, convertString(inst.getRule()), args);
            } else {
                result = new InstantiateExpression(convertString(inst.getRuleName()), args);
            }
        } catch (ExpressionException e) {
            throw new TranslatorException(e, inst, VilBuildLanguagePackage.Literals.INSTANTIATE__PARAM);
        }
        return result;
    }
    
    /**
     * Processes a map statement.
     * 
     * @param map the ECore object representing the statement
     * @param resolver a resolver instance for resolving variables etc.
     * @return the translated object in terms of the build language model
     * @throws TranslatorException in case that the translation fails
     */
    private MapExpression processMap(de.uni_hildesheim.sse.vilBuildLanguage.Map map, Resolver resolver) 
        throws TranslatorException {
        Expression expr = processExpression(map.getExpr(), resolver);
        TypeDescriptor<? extends IVilType> type = null;
        try {
            type = expr.inferType();
        } catch (ExpressionException e) {
            throw new TranslatorException(e, map, VilBuildLanguagePackage.Literals.MAP__EXPR);
        }
        if (!type.isCollection()) {
            OperationDescriptor conversion = type.getConversionToSequence();
            if (null == conversion) {
                throw new TranslatorException("map must run over collection", map, 
                    VilBuildLanguagePackage.Literals.MAP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
            } else {
                type = conversion.getReturnType();
            }
        }
        EList<MapVariable> vars = map.getVar();
        if (type.getParameterCount() != vars.size()) {
            throw new TranslatorException("number of map variables does not comply with expression", map, 
                VilBuildLanguagePackage.Literals.MAP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
        }
        int vSize = vars.size();
        VariableDeclaration[] mapVars = new VariableDeclaration[vSize];
        TypeDescriptor<? extends IVilType>[] givenTypes = TypeDescriptor.createArray(vSize);
        for (int i = 0; i < vars.size(); i++) {
            MapVariable mv = vars.get(i);
            TypeDescriptor<? extends IVilType> varType = type.getParameterType(i);
            if (null != mv.getType()) {
                givenTypes[i] = processType(mv.getType(), resolver);
                if (!givenTypes[i].isAssignableFrom(varType)) {
                    throw new TranslatorException("explicitly given type '" + givenTypes[i].getVilName() 
                        + "'of map variable '" + mv.getVar() + "' does not match inferred type '" 
                        + varType.getVilName() + "'", mv, 
                        VilBuildLanguagePackage.Literals.MAP_VARIABLE__TYPE, ErrorCodes.TYPE_CONSISTENCY);
                } else {
                    varType = givenTypes[i];
                }
            }
            mapVars[i] = new VariableDeclaration(mv.getVar(), varType);
        }
        resolver.pushLevel();
        resolver.add(mapVars);
        IRuleElement[] block ;
        try {
            block = resolveBlock(map.getBlock(), resolver);
        } catch (TranslatorException e) {
            throw e;
        } finally {
            resolver.popLevel();
        }
        try {
            return new MapExpression(mapVars, expr, block, givenTypes, map.getSeparator().equals(Constants.COLON));
        } catch (VilLanguageException e) {
            throw new TranslatorException(e, map, VilBuildLanguagePackage.Literals.MAP__VAR);
        }
    }
    
    /**
     * Resolves a block of rule elements.
     * @param block the block to be resolved
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resolved elements
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    IRuleElement[] resolveBlock(RuleElementBlock block, Resolver resolver) throws TranslatorException {
        IRuleElement[] result = null;
        if (null != block && null != block.getElements()) {
            List<IRuleElement> tmp = new ArrayList<IRuleElement>();
            for (RuleElement elt : block.getElements()) {
                if (null != elt.getDeferDecl()) {
                    warning("defer is currently not supported", elt.getDeferDecl(), 
                        VilBuildLanguagePackage.Literals.DEFER_DECLARATION__NAME, 0);
                } else if (null != elt.getExprStmt()) {
                    tmp.add(processExpressionStatement(elt.getExprStmt(), resolver));
                } else if (null != elt.getVarDecl()) {
                    tmp.add(processVariableDeclaration(elt.getVarDecl(), resolver));
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
     * Processes an expression statement.
     * 
     * @param expr the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the expression statement
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    protected ExpressionStatement processExpressionStatement(
        de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement expr, Resolver resolver) 
        throws TranslatorException {
        Expression result = processExpression(expr.getExpr(), resolver);
        if (null != expr.getVar()) {
            VariableDeclaration decl = resolver.resolve(expr.getVar(), false);
            if (null == decl) {
                throw new TranslatorException("cannot resolve variable '" + expr.getVar() + "'", expr, 
                    ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__VAR, ErrorCodes.UNKNOWN_ELEMENT);
            }
            try {
                result = new ValueAssignmentExpression(decl, result);
                result.inferType();
            } catch (ExpressionException e) {
                throw new TranslatorException(e, expr, ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__VAR);
            }
        }
        return new ExpressionStatement(result);
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
        } catch (ExpressionException e) {
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
        } catch (ExpressionException e) {
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
                VariableDeclaration nameVar = resolver.resolve(name, false);
                if (null == nameVar) {
                    throw new TranslatorException("cannot resolve variable " + nameVar, call, 
                        ExpressionDslPackage.Literals.CALL__NAME, ErrorCodes.UNKNOWN_ELEMENT);
                }
                result = new StrategyCallExpression(nameVar, arg);
                result.inferType();
            } catch (ExpressionException e) {
                throw new TranslatorException(e, call, ExpressionDslPackage.Literals.CALL__NAME);
            }
        } else {
            result = null;
            ExpressionException semanticException = null;
            //if (Resolver.ContextType.RULE_HEADER == resolver.getContextType()) {
                try {
                    result = resolver.createCallExpression(CallType.SUPER == type, name, arg);
                } catch (ExpressionException e) {
                    semanticException = e;
                }
            //}
            if ((null == result || continueResolution(semanticException)) && Resolver.ContextType.RULE_BODY == resolver.getContextType()) {
                // grammar supports system executions only on top-level
                try {
                    result = new StrategyCallExpression(resolver.getCurrentModel(), name, arg);
                    semanticException = checkSemantics(result);
                } catch (ExpressionException e) {
                    // wrong expression
                }
            }
            if (null == result || continueResolution(semanticException)) {
                try {
                    result = new CallExpression(null, name, arg);
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
    protected VariableDeclaration createVariableDeclaration(String name, TypeDescriptor<? extends IVilType> type,
        boolean isConstant, Expression expression) {
        return new VariableDeclaration(name, type, isConstant, expression);
    }

}
