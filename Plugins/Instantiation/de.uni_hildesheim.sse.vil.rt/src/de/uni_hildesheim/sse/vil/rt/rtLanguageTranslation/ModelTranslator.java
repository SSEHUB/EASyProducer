package de.uni_hildesheim.sse.vil.rt.rtLanguageTranslation;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.buildLanguageTranslation.RuleInfo;
import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vil.expressions.translation.Utils;
import de.uni_hildesheim.sse.vil.rt.RtErrorCodes;
import de.uni_hildesheim.sse.vil.rt.RtVilModelUtility;
import de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement;
import de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement;
import de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart;
import de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit;
import de.uni_hildesheim.sse.vil.rt.rtVil.IntentDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit;
import de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage;
import de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.WeightingStatement;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.translation.ErrorCodes;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Imports;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Resolver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script.ScriptDescriptor;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.AbstractBreakdownCall;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilStorage;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Strategy;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.StrategyCall;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Tactic;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.TacticCall;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.VariableDeclarationModifier;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.WeightingFunction;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.types.RtVilTypeRegistry;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.types.TupleType;

/**
 * Implements the translation from the DSL to the adaptation language model in the instantiator core.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends de.uni_hildesheim.sse.buildLanguageTranslation.AbstractModelTranslator
    <Script, LanguageUnit> {

    private TacticTranslator tacticTranslator = new TacticTranslator();
    private StrategyTranslator strategyTranslator = new StrategyTranslator();
    
    /**
     * Creates a model translator.
     */
    public ModelTranslator() {
        super(new ExpressionTranslator(), new Resolver(new TypeRegistry(RtVilTypeRegistry.INSTANCE)));
    }
    
    /**
     * Returns the associated expression translator.
     * 
     * @return the expression translator
     */
    protected ExpressionTranslator getExpressionTranslator() {
        return (ExpressionTranslator) super.getExpressionTranslator();
    }
    
    /**
     * Creates a build model from a given implementation unit. This is the
     * top-level entry method.
     * 
     * @param unit the language unit to be translated
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @param impResolver the import resolver to use (may be <b>null</b> to use a new default import resolver)
     * @return the corresponding build model
     */
    public List<Script> createModel(ImplementationUnit unit, URI uri, boolean registerSuccessful, 
        ImportResolver<Script> impResolver) {
        ResourceRegistry.register(unit.eResource(), getResolver().getTypeRegistry());
        List<Script> result = new ArrayList<Script>();
        if (null != unit.getScripts()) {
            HashSet<String> names = new HashSet<String>();
            Imports<Script> imports = null;
            try {
                imports = processImports(unit.getImports(), unit.getRequires());
            } catch (TranslatorException e) {
                error(e);
            }
            for (de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit s : unit.getScripts()) {
                LanguageUnit script = (LanguageUnit) s;
                String name = script.getName();
                if (!names.contains(name)) {
                    try {
                        result.add(createScript(script, uri, registerSuccessful, unit.getScripts(), imports, 
                            impResolver));
                        names.add(name);
                    } catch (TranslatorException e) {
                        error(e);
                    }
                } else {
                    error("script '" + name + "' occurs multiple times in the same file", script,
                        ExpressionDslPackage.Literals.LANGUAGE_UNIT__NAME, ErrorCodes.NAME_CLASH);
                }
            }
            getExpressionTranslator().enactIvmlWarnings();
        }
        return result;
    }
    
    protected List<IMessage> postResolveImports(Script model, URI uri, List<IMessage> resolutionMessages) {
        // by default imports are resolved against RtVilModel, but plain VIL scripts are not considered
        // as the import resolver is typed, we have to trick the BuildModel resolver
        net.ssehub.easy.instantiation.core.model.buildlangModel.Script tmp 
            = new net.ssehub.easy.instantiation.core.model.buildlangModel.Script("tmp");
        for (int i = 0; i < model.getImportsCount(); i++) {
            ModelImport<net.ssehub.easy.instantiation.core.model.buildlangModel.Script> imp 
                = model.getImport(i);
            if (null == imp.getResolved()) {
                tmp.addImport(imp);
            }
        }
        return BuildModel.INSTANCE.resolveImports(tmp, uri, null);
    }

    @Override
    protected List<EObject> getContents(LanguageUnit script) {
        List<EObject> result;
        if (null != script.getRtContents()) {
            result = script.getRtContents().getElements();
        } else {
            result = null;
        }
        return result;
    }
    
    @Override
    protected void processAdditionalContents(LanguageUnit unit, List<EObject> elements, Script result) throws TranslatorException {
        tacticTranslator.processRules(unit, elements, result);
        strategyTranslator.processRules(unit, elements, result);
    }
    
    @Override
    protected void processGlobalVariableDeclarations(List<EObject> elts, Script result) {
        List<GlobalVariableDeclaration> decls = select(elts, GlobalVariableDeclaration.class);
        if (!decls.isEmpty()) {
            List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> tmp 
                = new ArrayList<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration>();
            Set<String> persistent = new HashSet<String>();
            for (GlobalVariableDeclaration d : decls) {
                de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration vDecl = d.getVarDecl();
                if (null != vDecl) { // incremental xtext processing
                    tmp.add(vDecl);
                    if (null != vDecl.getName() && null != d.getPersistent()) {
                        persistent.add(vDecl.getName());
                        if (!RtVilStorage.hasStorage()) {
                            warning("the system to be adapted probably does not provide a storage for persistent "
                                + "variables, i.e., values may not be stored across different script runs (use of "
                                + "modifier is discouraged)", d, 
                                RtVilPackage.Literals.GLOBAL_VARIABLE_DECLARATION__PERSISTENT, ErrorCodes.DISCOURAGED);
                        }
                    }
                }
            }
            processVariableDeclarations(tmp, result);
            for (int v = 0; v < result.getVariableDeclarationCount(); v++) {
                VariableDeclaration varDecl = result.getVariableDeclaration(v);
                if (persistent.contains(varDecl.getName())) {
                    varDecl.addModifier(VariableDeclarationModifier.PERSISTENT);
                }
            }
        }
    }

    /**
     * Implements a rule translator for tactics.
     * 
     * @author Holger Eichelberger
     */
    protected class TacticTranslator extends AbstractRuleTranslator<TacticDeclaration, Tactic> {

        /**
         * Creates a tactic translator.
         */
        protected TacticTranslator() {
            super(TacticDeclaration.class);
        }

        @Override
        protected void addRule(Script script, Tactic tactic) {
            script.addTactic(tactic);
        }
        
        @Override
        protected Tactic createRule(TacticDeclaration tacticDecl, TypeDescriptor<?> returnType, 
            VariableDeclaration[] params, Script parent) {
            return new Tactic(tacticDecl.getName(), false, params, parent);
        }
        
        @Override
        protected TypeDescriptor<?> getReturnType(TacticDeclaration tacticDecl, Resolver resolver) {
            return RuleExecutionResult.TYPE; // go with the default for now
        }

        @Override
        protected ParameterList getParameterList(TacticDeclaration tacticDecl) {
            return tacticDecl.getParamList();
        }

        @Override
        protected RuleConditions getRuleConditions(TacticDeclaration tacticDecl) {
            return tacticDecl.getConditions();
        }

        @Override
        protected RuleElementBlock getBlock(TacticDeclaration tacticDecl) {
            return tacticDecl.getBlock();
        }

        @Override
        protected EStructuralFeature getNameLiteral() {
            return RtVilPackage.Literals.TACTIC_DECLARATION__NAME;
        }
        
        @Override
        protected String getDisplayName() {
            return "tactic";
        }
        
        @Override
        protected void processAdditionalRuleBodyElements(TacticDeclaration tacticDecl, Tactic tactic, 
            Script parent, Resolver resolver) throws TranslatorException {
            RuleElementBlock block = tacticDecl.getBlock();
            if (block instanceof de.uni_hildesheim.sse.vil.rt.rtVil.RuleElementBlock) {
                de.uni_hildesheim.sse.vil.rt.rtVil.RuleElementBlock rBlock = 
                    (de.uni_hildesheim.sse.vil.rt.rtVil.RuleElementBlock) block;
                IntentDeclaration intentDecl = rBlock.getIntent();
                if (null != intentDecl) {
                    ExpressionStatement stmt = getExpressionTranslator().processExpressionStatement(
                        intentDecl.getExprStmt(), resolver);
                    tactic.setIntent(stmt);
                }
            }
        }

    }
    
    /**
     * Implements a rule translator for strategies.
     * 
     * @author Holger Eichelberger
     */
    protected class StrategyTranslator extends AbstractRuleTranslator<StrategyDeclaration, Strategy> {

        private Map<Strategy, RuleInfo<StrategyDeclaration, Strategy>> ruleMap 
            = new HashMap<Strategy, RuleInfo<StrategyDeclaration, Strategy>>();
        
        /**
         * Creates a strategy translator.
         */
        protected StrategyTranslator() {
            super(StrategyDeclaration.class);
        }

        @Override
        public void processRules(LanguageUnit unit, List<EObject> elements, Script script) throws TranslatorException {
            super.processRules(unit, elements, script);
            List<Strategy> topLevel = script.getTopLevelStrategies(false, true);
            if (script.getStrategiesCount() > 0 && topLevel.isEmpty()) {
                error("Script declares strategies but does not provide top-level strategies (cyclic breakdown)", unit, 
                    RtVilPackage.Literals.LANGUAGE_UNIT__RT_CONTENTS, RtErrorCodes.CYCLIC_BREAKDOWN);
            } else {
                Set<Strategy> done = new HashSet<Strategy>();
                for (int s = 0; s < topLevel.size(); s++) {
                    Strategy strategy = topLevel.get(s);
                    done.add(strategy);
                    checkBreakdown(strategy, done);
                    done.clear();
                }
            }
        }

        /**
         * Checks for a cyclic breakdown structure.
         * 
         * @param strategy
         * @param done
         */
        private void checkBreakdown(Strategy strategy, Set<Strategy> done) {
            for (int b = 0; b < strategy.getBodyElementCount(); b++) {
                IRuleElement elt = strategy.getBodyElement(b);
                if (elt instanceof StrategyCall) {
                    StrategyCall call = (StrategyCall) elt;
                    Strategy resolved = call.getResolved();
                    if (null != resolved) {
                        if (done.contains(resolved)) {
                            RuleInfo<StrategyDeclaration, Strategy> info = ruleMap.get(resolved);
                            StrategyDeclaration decl = info.getRuleDeclaration();
                            String msg = null;
                            EObject cause = null;
                            EStructuralFeature causingFeature = null;
                            if (resolved == strategy) {
                                msg = "Cyclic use of this strategy ('"+resolved.getSignature()+"')";
                                cause = decl.getBreakdown().get(b);
                                causingFeature = RtVilPackage.Literals.BREAKDOWN_ELEMENT__BREAKDOWN_STMT;
                            } else if (b < decl.getBreakdown().size()) { // just to be sure
                                msg = "Strategy '" + resolved.getSignature() + "' was already used on a higher level "
                                    + "causing a cyclic breakdown structure";
                                cause = decl.getBreakdown().get(b);
                                causingFeature = RtVilPackage.Literals.BREAKDOWN_ELEMENT__BREAKDOWN_STMT;
                            } else {
                                msg = "Strategy '" + resolved.getSignature() + "' is used on different breakdown "
                                    + "levels causing a cyclic breakdown structure";
                                cause = decl;
                                causingFeature = RtVilPackage.Literals.STRATEGY_DECLARATION__NAME;
                            }
                            if (null != msg) {
                                error(msg, cause, causingFeature, RtErrorCodes.CYCLIC_BREAKDOWN);
                            }
                        } else {
                            done.add(resolved);
                            checkBreakdown(resolved, done);
                            done.remove(resolved);
                        }
                    }
                }
            }
        }
        
        @Override
        protected RuleInfo<StrategyDeclaration, Strategy> processRule(StrategyDeclaration ruleDecl, Script parent) throws TranslatorException {
            RuleInfo<StrategyDeclaration, Strategy> result = super.processRule(ruleDecl, parent);
            ruleMap.put(result.getRule(), result);
            return result;
        }
        
        @Override
        protected void addRule(Script script, Strategy strategy) {
            script.addStrategy(strategy);
        }
        
        @Override
        protected Strategy createRule(StrategyDeclaration strategyDecl, TypeDescriptor<?> returnType, 
            VariableDeclaration[] params, Script parent) {
            return new Strategy(strategyDecl.getName(), false, params, parent);
        }

        @Override
        protected TypeDescriptor<?> getReturnType(StrategyDeclaration tacticDecl, Resolver resolver) {
            return RuleExecutionResult.TYPE; // go with the default for now
        }

        @Override
        protected ParameterList getParameterList(StrategyDeclaration strategyDecl) {
            return strategyDecl.getParamList();
        }

        @Override
        protected RuleConditions getRuleConditions(StrategyDeclaration strategyDecl) {
            return strategyDecl.getConditions();
        }

        @Override
        protected RuleElementBlock getBlock(StrategyDeclaration ruleDecl) {
            return null;
        }
                
        @Override
        protected void processAdditionalRuleBodyElements(StrategyDeclaration strategyDecl, Strategy strategy, 
            Script parent, Resolver resolver) throws TranslatorException {
            processVariableDeclarations(strategyDecl.getVarDecls(), strategy);
            if (null != strategyDecl.getObjective()) {
                Expression objective = getExpressionTranslator().processExpression(strategyDecl.getObjective(), 
                    resolver);
                try {
                    if (!TypeRegistry.booleanType().isAssignableFrom(objective.inferType())) {
                        throw new TranslatorException("objective must be of type Boolean", strategyDecl, 
                            RtVilPackage.Literals.STRATEGY_DECLARATION__OBJECTIVE, ErrorCodes.TYPE_CONSISTENCY);
                    }
                    strategy.setObjective(objective);
                } catch (VilException e) {
                    throw new TranslatorException(e, strategyDecl, 
                        RtVilPackage.Literals.STRATEGY_DECLARATION__OBJECTIVE);
                }
            }
            ExpressionTranslator eTranslator = getExpressionTranslator();
            Map<String, TypeDescriptor<?>> tupleFields = null;
            if (null != strategyDecl.getBreakdown()) {
                List<IRuleElement> tmp = new ArrayList<IRuleElement>();
                tupleFields = new HashMap<String, TypeDescriptor<?>>();
                for (BreakdownElement b : strategyDecl.getBreakdown()) {
                    if (null != b.getBreakdownStmt()) {
                        tmp.add(processBreakdownStatement(b.getBreakdownStmt(), parent, resolver, tupleFields));
                    }
                    if (null != b.getExprStmt()) {
                        tmp.add(eTranslator.processExpressionStatement(b.getExprStmt(), resolver));
                    }
                    if (null != b.getVarDecl()) {
                        tmp.add(eTranslator.processVariableDeclaration(b.getVarDecl(), resolver));
                    }
                }
                if (!tmp.isEmpty()) {
                    IRuleElement[] result = new IRuleElement[tmp.size()];
                    strategy.setBody(tmp.toArray(result));
                }
            }
            if (null != strategyDecl.getWeighting()) {
                WeightingStatement wSt = strategyDecl.getWeighting();
                TypeDescriptor<?> type;
                if (null != tupleFields) {
                    try {
                        type = new TupleType(strategy, tupleFields, resolver.getTypeRegistry());
                    } catch (VilException e) {
                        throw new TranslatorException(e, strategyDecl, 
                            RtVilPackage.Literals.STRATEGY_DECLARATION__WEIGHTING);
                    }
                } else {
                    type = RtVilTypeRegistry.conceptType();
                }
                VariableDeclaration varDecl = new VariableDeclaration(wSt.getName(), type);
                resolver.pushLevel();
                resolver.add(varDecl);
                Expression expression = eTranslator.processExpression(wSt.getExpr(), resolver);
                resolver.popLevel();
                strategy.setWeightingFunction(new WeightingFunction(varDecl, expression));
            }
            strategy.setPostprocessing(getExpressionTranslator().resolveBlock(strategyDecl.getPost(), resolver));
        }

        @Override
        protected EStructuralFeature getNameLiteral() {
            return RtVilPackage.Literals.STRATEGY_DECLARATION__NAME;
        }
        
        @Override
        protected String getDisplayName() {
            return "strategy";
        }
        
    }
    
    /**
     * Processes a breakdown statement.
     * 
     * @param stmt the ECore representation of the statement
     * @param parent the parent script
     * @param resolver the resolver
     * @param tupleFields the actually resolved with-tuples
     * @return the created breakdown statement
     * @throws TranslatorException in case that translation fails, e.g., due to illegal types
     */
    private IRuleElement processBreakdownStatement(BreakdownStatement stmt, Script parent, Resolver resolver, 
        Map<String, TypeDescriptor<?>> tupleFields) throws TranslatorException {
        ExpressionTranslator eTranslator = getExpressionTranslator();
        String name = Utils.getQualifiedNameString(stmt.getName());
        CallArgument[] args = eTranslator.processArguments(stmt.getParam(), resolver);
        stmt.getPart();
        
        AbstractBreakdownCall result;
        try {
            if ("strategy".equals(stmt.getType())) {
                result = new StrategyCall(parent, name, args);
            } else if ("tactic".equals(stmt.getType())) {
                result = new TacticCall(parent, name, args);
            } else {
                throw new TranslatorException("unknown breakdown element", stmt, 
                    RtVilPackage.Literals.BREAKDOWN_STATEMENT__NAME, TranslatorException.INTERNAL);
            }
            if (null != stmt.getGuard()) {
                result.setGuardExpression(eTranslator.processLogicalExpression(stmt.getGuard(), resolver));
            }
            if (null != stmt.getPart())  {
                for (BreakdownWithPart part : stmt.getPart()) {
                    String pName = part.getName();
                    if (null == pName || 0 == pName.length()) {
                        throw new TranslatorException("no name given", part, 
                            RtVilPackage.Literals.BREAKDOWN_WITH_PART__NAME, VilException.ID_NOT_FOUND);
                    }
                    if (null == part.getValue()) {
                        throw new TranslatorException("no value expression given", part, 
                            RtVilPackage.Literals.BREAKDOWN_WITH_PART__VALUE, VilException.ID_NOT_FOUND);
                    }
                    Expression valueEx = eTranslator.processExpression(part.getValue(), resolver);
                    TypeDescriptor<?> valueExType = valueEx.inferType();
                    TypeDescriptor<?> expectedType = tupleFields.get(pName);
                    if (null == expectedType) {
                        tupleFields.put(pName, valueExType);
                    } else {
                        if (!expectedType.isAssignableFrom(valueExType)) {
                            throw new TranslatorException("value of type '"+valueExType.getVilName() + "' cannot be "
                                + "assigned to known slot '" + pName + "' of type '" + expectedType.getVilName(), part, 
                                RtVilPackage.Literals.BREAKDOWN_WITH_PART__VALUE, VilException.ID_SEMANTIC);
                        }
                    }
                    result.addTupleField(pName, valueEx);
                }
            }
            if (null != stmt.getTime()) {
                Expression timeEx = eTranslator.processExpression(stmt.getTime(), resolver);
                TypeDescriptor<?> timeType = timeEx.inferType();
                if (TypeRegistry.integerType() != timeType && TypeRegistry.realType() != timeType) {
                    throw new TranslatorException("timeout expression must be a numerical type rather than " 
                        + timeType.getVilName(), stmt, 
                        RtVilPackage.Literals.BREAKDOWN_STATEMENT__TIME, VilException.ID_SEMANTIC);
                }
                result.setTimeoutExpression(eTranslator.processExpression(stmt.getTime(), resolver));
            }
            result.inferType();
        } catch (VilException e) {
            throw new TranslatorException(e, stmt, RtVilPackage.Literals.BREAKDOWN_STATEMENT__NAME);
        }
        return result;
    }

    
    @Override
    protected Script createScript(String name, ModelImport<Script> parent, ScriptDescriptor<Script> descriptor, 
        TypeRegistry registry) {
        return new Script(name, parent, descriptor, registry);
    }
    
    @Override
    protected ModelManagement<Script> getManagementInstance() {
        return RtVilModel.INSTANCE;
    }
    
    @Override
    protected IModelLoader<Script> getModelLoader() {
        return RtVilModelUtility.INSTANCE;
    }

}
