package de.uni_hildesheim.sse.buildLanguageTranslation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Imports;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule.Side;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleDescriptorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vilBuildLanguage.Require;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

/**
 * Implements the translation from the DSL to the build model in the instantiator core. This class is intended for
 * reuse.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractModelTranslator extends de.uni_hildesheim.sse.vil.expressions.translation.ModelTranslator
    <Script, VariableDeclaration, Resolver, ExpressionTranslator> {

    private ExpressionTranslator expressionTranslator;
    private Resolver resolver;
    
    /**
     * Creates a model translator.
     */
    public AbstractModelTranslator() {
        this(new ExpressionTranslator(), new Resolver(new TypeRegistry(TypeRegistry.DEFAULT)));
    }

    /**
     * Creates a model translator.
     * 
     * @param expressionTranslator the expression translator to use
     * @param resolver the resolver to use
     */
    protected AbstractModelTranslator(ExpressionTranslator expressionTranslator, Resolver resolver) {
        super(expressionTranslator, resolver);
        this.expressionTranslator = getExpressionTranslator();
        this.resolver = getResolver();
    }
    
    /**
     * Processes the imports and returns an summarizing instance.
     * 
     * @param imports the imports to be processed
     * @return the summarizing instance
     * @throws TranslatorException in case that processing the imports fails
     */
    protected Imports processImports(EList<Import> imports, EList<Require> requires) throws TranslatorException {
        List<ModelImport<Template>> restrictions = null;
        if (null != requires) {
            restrictions = new ArrayList<ModelImport<Template>>();
            for (int r = 0; r < requires.size(); r++) {
                Require req = requires.get(r);
                warnVersionRestrictions(req.getVersionSpec());
                String name = req.getName(); // this is a STRING!
                if (name.startsWith("\"") && name.startsWith("\"")) {
                    name = name.substring(1, name.length() - 1).trim();
                }
                restrictions.add(new ModelImport<Template>(name, false, 
                    expressionTranslator.processRestriction(name, req.getVersionSpec(), resolver)));
            }
        }
        return new Imports(processImports(imports), restrictions);
    }
    
    /**
     * Returns the management instance.
     * 
     * @return the management instance
     */
    protected ModelManagement<Script> getManagementInstance() {
        return BuildModel.INSTANCE;
    }
    
    /**
     * Performs static tests on the constants.
     * 
     * @param project the project created
     * @param cause the causing ECore element
     * @throws TranslatorException in case that a problem occurred
     */
    protected void checkConstants(Script project, de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit cause) {
        if (0 == project.getPropertiesCount()) {
            for (int v = 0; v < project.getVariableDeclarationCount(); v++) {
                VariableDeclaration var = project.getVariableDeclaration(v);
                if (var.isConstant() && null == var.getExpression()) {
                    error("constant '" + var.getName() 
                        + "'is not initialized", cause, ExpressionDslPackage.Literals.LANGUAGE_UNIT__NAME, 
                        ErrorCodes.INITIALIZER_CONSISTENCY);
                }
            }
        }
    }

    /**
     * Processes all rules considering dependencies and terminates with
     * an error if not all can be resolved.
     * 
     * @param langUnit the ECore instance representing the script / language unit
     * @param script the resulting instance being created
     */
    protected void processRules(de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit langUnit, Script script) {
        List<RuleDeclaration> decls = select(langUnit.getContents().getElements(), RuleDeclaration.class);
        Map<String, RuleInfo> signatures = new HashMap<String, RuleInfo>();
        for (int d = 0; d < decls.size(); d++) {
            try {
                RuleDeclaration decl = decls.get(d);
                RuleInfo info = processRule(decl, script);
                Rule rule = info.getRule();
                String fSig = rule.getSignature() + "[" + script.getName() + ']';
                if (signatures.containsKey(fSig)) {
                    error("duplicated rule definition", decl, VilBuildLanguagePackage.Literals.RULE_DECLARATION__NAME, 
                        ErrorCodes.REDEFINITION);
                } else {
                    signatures.put(fSig, info);
                    script.addRule(rule);
                }
            } catch (TranslatorException e) {
                error(e);
            }
        }
        for (RuleInfo info : signatures.values()) {
            try {
                processRuleBody(info);
            } catch (TranslatorException e) {
                error(e);
            }
        }
    }

    /**
     * Resolves a set of expressions.
     * 
     * @param expressions the expressions to be resolved
     * @return the resolved expression (may be less than the elements in <code>expressions</code> in case of errors) 
     *   or <b>null</b> in case of errors
     */
    private List<Expression> resolveExpressions(
        EList<de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression> expressions) throws TranslatorException {
        List<Expression> result;
        if (null != expressions) {
            result = new ArrayList<Expression>();
            for (int e = 0; e < expressions.size(); e++) {
                Expression ex = expressionTranslator.processLogicalExpression(expressions.get(e), resolver);
                if (null != ex) {
                    result.add(ex);
                }
            }
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Processes a rule declaration.
     * 
     * @param ruleDecl the ECore rule object
     * @param parent the parent script
     * @return the actual rule information object linking ECore and build language instances
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     * @see #processRuleBody(RuleInfo)
     */
    private RuleInfo processRule(RuleDeclaration ruleDecl, Script parent) throws TranslatorException {
        RuleInfo result;
        resolver.pushLevel();
        try {
            // TODO process type
            resolver.setContextType(Resolver.ContextType.RULE_HEADER);
            RuleDescriptor descriptor = new RuleDescriptor();
            VariableDeclaration[] params = resolveParameters(ruleDecl.getParamList());
            resolver.add(params);
            processRuleConditions(descriptor, ruleDecl.getConditions());
            Rule rule = new Rule(ruleDecl.getName(), isProtected(ruleDecl), params, parent);
            result = new RuleInfo(ruleDecl, rule, descriptor);
            // TODO process type check
        } catch (TranslatorException e) {
            throw e;
        } finally {
            resolver.popLevel();
        }
        return result;
    }

    /**
     * Processes optional rule pre/postcnditions.
     * 
     * @param ruleDecl the ECore rule object
     * @param parent the parent script
     * @return the actual rule information object linking ECore and build language instances
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     * @see #processRuleBody(RuleInfo)
     */
    protected void processRuleConditions(RuleDescriptor descriptor, RuleConditions cond) throws TranslatorException {
        if (null != cond) {
            resolveRuleExpressions(descriptor, Side.RHS, cond.getPreconditions());
            resolveRuleExpressions(descriptor, Side.LHS, cond.getPostcondition());
            if (descriptor.getRuleMatchCount(Side.RHS) > 1) {
                error("at maximum one match expression is supported on the right side", cond, 
                    VilBuildLanguagePackage.Literals.RULE_CONDITIONS__PRECONDITIONS, ErrorCodes.RULES);
            }
            if (descriptor.getRuleMatchCount(Side.LHS) > 1) {
                warning("at maximum one match expression is supported on the left side", cond, 
                    VilBuildLanguagePackage.Literals.RULE_CONDITIONS__POSTCONDITION, ErrorCodes.RULES);
            }
            if (descriptor.getRuleCallCount(Side.LHS) > 0) {
                error("no rule calls are supported on the left side", cond, 
                    VilBuildLanguagePackage.Literals.RULE_CONDITIONS__POSTCONDITION, 0);
            }
        }
    }
    
    /**
     * Processes a rule body.
     * 
     * @param info the rule information object containing the link between the ECore and the model instance 
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    private void processRuleBody(RuleInfo info) throws TranslatorException {
        RuleDeclaration rDecl = info.getRuleDeclaration();
        Rule rule = info.getRule();
        resolver.pushLevel();
        try {
            resolver.setContextType(Resolver.ContextType.RULE_BODY);
            try {
                info.registerVariables(resolver);
            } catch (ExpressionException e) {
                // shall not occur as rules are resolved before
                throw new TranslatorException(e, rDecl, VilBuildLanguagePackage.Literals.RULE_DECLARATION__NAME);
            }
            rule.setBody(getExpressionTranslator().resolveBlock(rDecl.getBlock(), resolver));
        } catch (TranslatorException e) {
            throw e;
        } finally {
            resolver.popLevel();
        }
    }
    
    /**
     * Resolves rule expressions.
     * 
     * @param descriptor the rule descriptor as target for the data
     * @param side the rule side
     * @param expressions the expressions to be resolved
     * @throws TranslatorException in case of resolution problems
     */
    private void resolveRuleExpressions(RuleDescriptor descriptor, Side side, 
        EList<de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression> expressions) 
        throws TranslatorException {
        try {
            descriptor.setRuleExpressions(side, resolveExpressions(expressions));
        } catch (RuleDescriptorException e) {
            throw new TranslatorException(e.getMessage(), expressions.get(e.getIndex()), 
                ExpressionDslPackage.Literals.LOGICAL_EXPRESSION__LEFT, e.getId());
        }
    }
    
    @Override
    protected VariableDeclaration[] createArray(int len) {
        return new VariableDeclaration[len];
    }
        
    /**
     * Returns whether a rule is protected.
     * 
     * @param rule the rule to be tested
     * @return <code>true</code> if it is protected, <code>false</code> else
     */
    private static boolean isProtected(RuleDeclaration rule) {
        return null != rule.getModifier() && null != rule.getModifier().getProtected();
    }

    /**
     * Turns a buildlang exception into a xText error.
     * 
     * @param exception the exception to used
     * @param cause the cause (as instance of the EMF grammar model)
     * @param causeFeature the cause of the feature 
     */
    void error(VilLanguageException exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.error(exception, cause, causeFeature);
    }

    /**
     * Turns a buildlang exception into a xText warning.
     * 
     * @param exception the exception to used
     * @param cause the cause (as instance of the EMF grammar model)
     * @param causeFeature the cause of the feature 
     */
    void warning(VilLanguageException exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.warning(exception, cause, causeFeature);
    }

}
