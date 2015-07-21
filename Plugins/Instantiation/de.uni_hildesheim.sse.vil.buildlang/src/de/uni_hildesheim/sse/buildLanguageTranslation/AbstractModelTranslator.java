/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.buildLanguageTranslation;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IRuleElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Imports;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.LoadProperties;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleExecutionResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule.Side;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script.ScriptDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleDescriptorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.Require;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

/**
 * Implements the translation from the DSL to the build model in the instantiator core. This class is intended for
 * reuse.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractModelTranslator<M extends Script, L extends LanguageUnit> 
    extends de.uni_hildesheim.sse.vil.expressions.translation.ModelTranslator
    <M, VariableDeclaration, Resolver, 
    de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ExpressionStatement, ExpressionTranslator> {

    private ExpressionTranslator expressionTranslator;
    private Resolver resolver;
    private RuleTranslator ruleTranslator = new RuleTranslator();
    
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
     * Creates a script instance from an EMF instance.
     * 
     * @param script the EMF instance to work on
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @param inProgress the scripts currently being translated
     * @param imports the global imports
     * @return the created script
     * @throws TranslatorException in case that a problem occurred
     */
    protected M createScript(L script, URI uri, boolean registerSuccessful, List<LanguageUnit> inProgress, 
        Imports<M> imports) throws TranslatorException {
        int errorCount = getErrorCount();
        Advice[] advices = processAdvices(script.getAdvices(), uri);
        VariableDeclaration[] param = resolveParameters(script.getParam());
        ModelImport<M> parent = null;
        if (null != script.getParent()) {
            parent = getExtensionImport(script.getParent().getName(), imports, script.getParent(), 
                VilBuildLanguagePackage.Literals.SCRIPT_PARENT_DECL__NAME);
        }
        ScriptDescriptor<M> desc = new ScriptDescriptor<M>(param, advices, imports);
        Resolver resolver = getResolver();
        M result = createScript(script.getName(), parent, desc, resolver.getTypeRegistry());
        resolver.pushModel(result);
        if (null != script.getVersion()) {
            try {
                result.setVersion(new Version(script.getVersion().getVersion()));
            } catch (VersionFormatException e) {
                error(e.getMessage(), script, ExpressionDslPackage.Literals.LANGUAGE_UNIT__VERSION, 
                    ErrorCodes.FORMAT_ERROR);
            }
        }
        if (null != script.getLoadProperties()) {
            for (de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties prop : script.getLoadProperties()) {
                result.addLoadProperties(new LoadProperties(ExpressionTranslator.convertString(prop.getPath())));
            }
        }
        resolveImports(script, ExpressionDslPackage.Literals.LANGUAGE_UNIT__IMPORTS, result, uri, inProgress);
        resolver.enumerateImports(result);
        processContents(script, result);
        checkConstants(result, script);
        resolver.popModel();
        if (registerSuccessful && errorCount == getErrorCount()) {
            // required if models in the same file refer to each other
            getManagementInstance().updateModel(result, uri, getModelLoader());
        }
        return result;
    }
    
    /**
     * Processes the contents of a language unit and stores the results in <code>result</code>.
     * Calls {@link #processAdditionalContents(LanguageUnit, Script)} if the contents is processable.
     * 
     * @param script the script language unit to be processed
     * @param result the result instance to be modified
     * @throws TranslatorException in case that processing fails
     */
    protected void processContents(L script, M result) throws TranslatorException {
        List<EObject> elts = getContents(script);
        if (null != elts) {
            processTypedefContents(elts, result);
            processGlobalVariableDeclarations(elts, result);
            ruleTranslator.processRules(script, elts, result);
            processAdditionalContents(script, elts, result);
            reProcessGlobalVariableDeclarations(result);
        }
    }

    /**
     * Processes the global script variable declarations.
     * 
     * @param script the script language unit to be processed
     * @param result the result instance to be modified
     */
    protected void processGlobalVariableDeclarations(List<EObject> elts, M result) {
        List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls = select(
            elts, de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration.class);
        processVariableDeclarations(decls, result);        
    }
    
    /**
     * Re-processes global variable declarations to get rid of temporary "function pointer" expressions.
     * 
     * @param model the model to be processed
     */
    protected void reProcessGlobalVariableDeclarations(M model) {
        for (int v = 0; v < model.getVariableDeclarationCount(); v++) {
            try {
                getExpressionTranslator().reProcessVariableDeclaration(model.getVariableDeclaration(v), resolver);
            } catch (TranslatorException e) {
                error(e);
            }
        }
    }
    
    /**
     * Returns the actual contents of <code>script</code>.
     * 
     * @param script the script to return the contents for
     * @return the script contents
     */
    protected List<EObject> getContents(L script) {
        List<EObject> result;
        if (null != script.getContents()) {
            result = script.getContents().getElements();
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Extension point for {@link #processContents(LanguageUnit, Script)}.
     * 
     * @param unit the language unit to process
     * @param script the script language unit to be processed
     * @param result the result instance to be modified
     * @throws TranslatorException in case that processing fails
     */
    protected void processAdditionalContents(L unit, List<EObject> elements, M result) throws TranslatorException {
    }
    
    /**
     * Creates a script instance.
     * 
     * @param name Name of the project.
     * @param parent the super script to inherit from (as a script import, may be <b>null</b>, shall be member of 
     *     <code>imports</code> or also <b>null</b>)
     * @param descriptor the descriptor carrying parameters, advices and imports (may be <b>null</b>)
     * @param registry the responsible type registry 
     */
    protected abstract M createScript(String name, ModelImport<M> parent, ScriptDescriptor<M> descriptor, 
        TypeRegistry registry);
    
    /**
     * Processes the imports and returns an summarizing instance.
     * 
     * @param imports the imports to be processed
     * @return the summarizing instance
     * @throws TranslatorException in case that processing the imports fails
     */
    protected Imports<M> processImports(EList<Import> imports, EList<Require> requires) throws TranslatorException {
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
        
        return new Imports<M>(processImports(imports), restrictions);
    }
    
    /**
     * Returns the management instance.
     * 
     * @return the management instance
     */
    protected abstract ModelManagement<M> getManagementInstance();
    
    protected abstract IModelLoader<M> getModelLoader();
    
    /**
     * Performs static tests on the constants.
     * 
     * @param project the project created
     * @param cause the causing ECore element
     * @throws TranslatorException in case that a problem occurred
     */
    protected void checkConstants(Script project, L cause) {
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
     * An extensible rule translator. The functions used here are more or less the same for rules as well as
     * later rt-VIL strategies and tactics.
     * 
     * @param <D> the Ecore language declaration type
     * @param <R> the model rule type
     * @author Holger Eichelberger
     */
    protected abstract class AbstractRuleTranslator <D extends EObject, R extends Rule> {

        private Class<D> cls;
        
        /**
         * Creates a rule translator.
         * 
         * @param cls the language declaration class
         */
        protected AbstractRuleTranslator(Class<D> cls) {
            this.cls = cls;
        }
        
        /**
         * Processes all rules considering dependencies and terminates with
         * an error if not all can be resolved.
         * 
         * @param unit the language unit to process
         * @param elements the language elements to be processed
         * @param script the resulting instance being created
         */
        public void processRules(L unit, List<EObject> elements, M script) throws TranslatorException {
            List<D> decls = select(elements, cls);
            Map<String, RuleInfo<D, R>> signatures = new HashMap<String, RuleInfo<D, R>>();
            for (int d = 0; d < decls.size(); d++) {
                try {
                    D decl = decls.get(d);
                    RuleInfo<D, R> info = processRule(decl, script);
                    R rule = info.getRule();
                    String fSig = rule.getSignature() + "[" + script.getName() + ']';
                    if (signatures.containsKey(fSig)) {
                        error("duplicated " + getDisplayName() + " definition", decl, getNameLiteral(), 
                            ErrorCodes.REDEFINITION);
                    } else {
                        signatures.put(fSig, info);
                        addRule(script, rule);
                    }
                } catch (TranslatorException e) {
                    error(e);
                }
            }
            for (RuleInfo<D, R> info : signatures.values()) {
                try {
                    processRuleBody(info, script);
                } catch (TranslatorException e) {
                    error(e);
                }
            }
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
        protected RuleInfo<D, R> processRule(D ruleDecl, M parent) throws TranslatorException {
            RuleInfo<D, R> result;
            resolver.pushLevel();
            try {
                resolver.setContextType(Resolver.ContextType.RULE_HEADER);
                RuleDescriptor descriptor = new RuleDescriptor();
                descriptor.setReturnType(getReturnType(ruleDecl, resolver));
                VariableDeclaration[] params = resolveParameters(getParameterList(ruleDecl));
                resolver.add(params);
                processRuleConditions(descriptor, getRuleConditions(ruleDecl));
                R rule = createRule(ruleDecl, descriptor.getReturnType(), params, parent);
                result = new RuleInfo<D, R>(ruleDecl, rule, descriptor);
            } catch (TranslatorException e) {
                throw e;
            } finally {
                resolver.popLevel();
            }
            return result;
        }
        
        /**
         * Processes a rule body.
         * 
         * @param info the rule information object containing the link between the ECore and the model instance 
         * @throws TranslatorException in case that the translation fails due to semantic reasons
         */
        private void processRuleBody(RuleInfo<D, R> info, M parent) throws TranslatorException {
            D rDecl = info.getRuleDeclaration();
            R rule = info.getRule();
            resolver.pushLevel();
            try {
                resolver.setContextType(Resolver.ContextType.RULE_BODY);
                try {
                    info.registerVariables(resolver);
                } catch (VilException e) {
                    // shall not occur as rules are resolved before
                    throw new TranslatorException(e, rDecl, getNameLiteral());
                }
                RuleElementBlock block = getBlock(rDecl);
                if (null != block) {
                    rule.setBody(getExpressionTranslator().resolveBlock(block, resolver));
                }
                processAdditionalRuleBodyElements(rDecl, rule, parent, resolver);
            } catch (TranslatorException e) {
                throw e;
            } finally {
                resolver.popLevel();
            }
            if (rule.getDefaultReturnType() != rule.getReturnType()) {
                boolean found = false;
                for (int b = rule.getBodyElementCount() - 1; !found && b >= 0; b--) {
                    IRuleElement elt = rule.getBodyElement(b);
                    if (elt instanceof ExpressionStatement) {
                        ExpressionStatement eStmt = (ExpressionStatement) elt;
                        try {
                            TypeDescriptor<?> exType = eStmt.getExpression().inferType();
                            if (!rule.getReturnType().isAssignableFrom(exType)) {
                                throw new TranslatorException(getDisplayName() + " return type is '" 
                                    + exType.getVilName() + "' rather than '" + rule.getReturnType().getVilName() + "'", 
                                    rDecl, VilBuildLanguagePackage.Literals.RULE_DECLARATION__TYPE, 
                                    ErrorCodes.TYPE_CONSISTENCY);
                            } else {
                                found = true;
                            }
                        } catch (VilException e) {
                            throw new TranslatorException(e, rDecl, 
                                VilBuildLanguagePackage.Literals.RULE_DECLARATION__TYPE);
                        }
                    }
                }
                if (!found) {
                    throw new TranslatorException(getDisplayName() + " does not return a result of type '" 
                        + rule.getReturnType().getVilName() + "'", rDecl, 
                        VilBuildLanguagePackage.Literals.RULE_DECLARATION__TYPE, ErrorCodes.MISSING);
                }
            }
        }
        
        /**
         * Processes optional rule pre/postconditions.
         * 
         * @param ruleDecl the ECore rule object
         * @param parent the parent script
         * @return the actual rule information object linking ECore and build language instances
         * @throws TranslatorException in case that the translation fails due to semantic reasons
         * @see #processRuleBody(RuleInfo)
         */
        private void processRuleConditions(RuleDescriptor descriptor, RuleConditions cond) throws TranslatorException {
            if (null != cond) {
                resolveRuleExpressions(descriptor, Side.RHS, cond.getPreconditions());
                resolveRuleExpressions(descriptor, Side.LHS, cond.getPostcondition());
                if (descriptor.getRuleMatchCount(Side.RHS) > 1) {
                    error("at maximum one match expression is supported on the right side", cond, 
                        getPreconditionLiteral(), ErrorCodes.RULES);
                }
                if (descriptor.getRuleMatchCount(Side.LHS) > 1) {
                    warning("at maximum one match expression is supported on the left side", cond, 
                        getPostconditionLiteral(), ErrorCodes.RULES);
                }
                if (descriptor.getRuleCallCount(Side.LHS) > 0) {
                    error("no rule calls are supported on the left side", cond, getPostconditionLiteral(), 0);
                }
            }
        }
        
        /**
         * Adds the given rule to the 
         */
        protected abstract void addRule(M script, R rule);
        
        /**
         * Returns the display name of the language concept being processed.
         * 
         * @return the display name
         */
        protected abstract String getDisplayName();
        
        /**
         * Returns the name literal.
         * 
         * @return the name literal
         */
        protected abstract EStructuralFeature getNameLiteral();

        /**
         * Returns the precondition literal.
         * 
         * @return the precondition literal
         */
        protected EStructuralFeature getPreconditionLiteral() {
            return VilBuildLanguagePackage.Literals.RULE_CONDITIONS__PRECONDITIONS;
        }

        /**
         * Returns the postcondition literal.
         * 
         * @return the postcondition literal
         */
        protected EStructuralFeature getPostconditionLiteral() {
            return VilBuildLanguagePackage.Literals.RULE_CONDITIONS__POSTCONDITION;
        }
        
        /**
         * Creates a specific rule from the given declaration, parameters and parent.
         * 
         * @param ruleDecl the rule declaration
         * @param returnType the desired return type
         * @param params the resolved parameters
         * @param parent the parent
         * @return the specific rule, tactic or strategy (rt-VIL)
         */
        protected abstract R createRule(D ruleDecl, TypeDescriptor<?> returnType, 
            VariableDeclaration[] params, M parent);

        /**
         * Returns the result type of the given <code>ruleDecl</code>.
         * 
         * @param ruleDecl the rule declaration
         * @param resolver the actual resolver instance
         * @return the result type
         * @throws TranslatorException in case that resolving the type fails
         */
        protected abstract TypeDescriptor<?> getReturnType(D ruleDecl, Resolver resolver) 
            throws TranslatorException;
        
        /**
         * Returns the actual parameter list.
         * 
         * @param ruleDecl the rule declaration
         * @return the parameter list of the rule declaration
         */
        protected abstract ParameterList getParameterList(D ruleDecl); // ruleDecl.getParamList()

        /**
         * Returns the actual rule conditions.
         * 
         * @param ruleDecl the rule declaration
         * @return the rule conditions of the rule declaration
         */
        protected abstract RuleConditions getRuleConditions(D ruleDecl); // ruleDecl.getConditions()
        
        /**
         * Is called to process additional rule body elements.
         * 
         * @param ruleDecl the rule declaration
         * @param rule the actual rule (to be modified as a side effect)
         * @param resolver the variable resolver
         * @throws TranslatorException in case of translation problems
         */
        protected void processAdditionalRuleBodyElements(D ruleDecl, R rule, M parent, Resolver resolver) 
            throws TranslatorException {
        }

        /**
         * Returns the actual rule block.
         * 
         * @param ruleDecl the rule declaration
         * @return the rule block of the rule declaration (may be <b>null</b>)
         */
        protected abstract RuleElementBlock getBlock(D ruleDecl); // rDecl.getBlock()
        
    }
    
    /**
     * Implements a translator for VIL rules.
     * 
     * @author Holger Eichelberger
     */
    protected class RuleTranslator extends AbstractRuleTranslator<RuleDeclaration, Rule> {

        /**
         * Creates the translator.
         */
        protected RuleTranslator() {
            super(RuleDeclaration.class);
        }

        @Override
        protected void addRule(M script, Rule rule) {
            script.addRule(rule);
        }
        
        @Override
        protected Rule createRule(RuleDeclaration ruleDecl, TypeDescriptor<?> returnType, 
            VariableDeclaration[] params, M parent) {
            return new Rule(ruleDecl.getName(), isProtected(ruleDecl), returnType, params, parent);
        }

        @Override
        protected TypeDescriptor<?> getReturnType(RuleDeclaration ruleDecl, Resolver resolver) 
            throws TranslatorException{
            TypeDescriptor<?> result = RuleExecutionResult.TYPE;
            if (null != ruleDecl.getType()) {
                result = getExpressionTranslator().processType(ruleDecl.getType(), resolver);
            }
            return result;
        }
        
        @Override
        protected ParameterList getParameterList(RuleDeclaration ruleDecl) {
            return ruleDecl.getParamList();
        }

        @Override
        protected RuleConditions getRuleConditions(RuleDeclaration ruleDecl) {
            return ruleDecl.getConditions();
        }

        @Override
        protected RuleElementBlock getBlock(RuleDeclaration ruleDecl) {
            return ruleDecl.getBlock();
        }

        @Override
        protected EStructuralFeature getNameLiteral() {
            return VilBuildLanguagePackage.Literals.RULE_DECLARATION__NAME;
        }
        
        @Override
        protected String getDisplayName() {
            return "rule";
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
    /*private RuleInfo<RuleDeclaration, Rule> processRule(RuleDeclaration ruleDecl, Script parent) throws TranslatorException {
        RuleInfo<RuleDeclaration, Rule> result;
        resolver.pushLevel();
        try {
            // TODO process type
            resolver.setContextType(Resolver.ContextType.RULE_HEADER);
            RuleDescriptor descriptor = new RuleDescriptor();
            VariableDeclaration[] params = resolveParameters(ruleDecl.getParamList());
            resolver.add(params);
            processRuleConditions(descriptor, ruleDecl.getConditions());
            Rule rule = new Rule(ruleDecl.getName(), isProtected(ruleDecl), params, parent);
            result = new RuleInfo<RuleDeclaration, Rule>(ruleDecl, rule, descriptor);
            // TODO process type check
        } catch (TranslatorException e) {
            throw e;
        } finally {
            resolver.popLevel();
        }
        return result;
    }*/

    /**
     * Processes optional rule pre/postcnditions.
     * 
     * @param ruleDecl the ECore rule object
     * @param parent the parent script
     * @return the actual rule information object linking ECore and build language instances
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     * @see #processRuleBody(RuleInfo)
     */
    /*protected void processRuleConditions(RuleDescriptor descriptor, RuleConditions cond) throws TranslatorException {
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
    }*/
    
    /**
     * Processes a rule body.
     * 
     * @param info the rule information object containing the link between the ECore and the model instance 
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    /*private void processRuleBody(RuleInfo<RuleDeclaration, Rule> info) throws TranslatorException {
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
    }*/
    
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
    void error(VilException exception, EObject cause,
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
    void warning(VilException exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.warning(exception, cause, causeFeature);
    }

}
