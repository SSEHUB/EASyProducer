package de.uni_hildesheim.sse.buildLanguageTranslation;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Imports;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.LoadProperties;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule.Side;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleDescriptorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script.ScriptDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vil.expressions.translation.ImportTranslator;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.Require;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

/**
 * Implements the translation from the DSL to the build model in the instantiator core.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends de.uni_hildesheim.sse.vil.expressions.translation.ModelTranslator
    <Script, VariableDeclaration, Resolver, ExpressionTranslator> {

    private ExpressionTranslator expressionTranslator;
    private Resolver resolver;
    
    // a temporary model for resolving recursive calls - not nice but temporarily adding them to template fails
    private Script recursiveResolutionModel;
    
    /**
     * Creates a model translator.
     */
    public ModelTranslator() {
        super(new ExpressionTranslator(), new Resolver(new TypeRegistry(TypeRegistry.DEFAULT)));
        expressionTranslator = getExpressionTranslator();
        resolver = getResolver();
        //try {
            recursiveResolutionModel = new Script("$$");
            resolver.setRecursiveResolutionModel(recursiveResolutionModel);
        //} catch (VilLanguageException e) {
        //    e.printStackTrace();
        //}
    }
    
    /**
     * Creates a build model from a given implementation unit. This is the
     * top-level entry method.
     * 
     * @param unit the language unit to be translated
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @return the corresponding build model
     */
    public List<Script> createModel(ImplementationUnit unit, URI uri, boolean registerSuccessful) {
        ResourceRegistry.register(unit.eResource(), resolver.getTypeRegistry());
        List<Script> result = new ArrayList<Script>();
        if (null != unit.getScripts()) {
            HashSet<String> names = new HashSet<String>();
            Imports imports = null;
            try {
                imports = processImports(unit.getImports(), unit.getRequires());
            } catch (TranslatorException e) {
                error(e);
            }
            for (de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit script : unit.getScripts()) {
                String name = script.getName();
                if (!names.contains(name)) {
                    try {
                        result.add(createScript(script, uri, registerSuccessful, unit.getScripts(), imports));
                        names.add(name);
                    } catch (TranslatorException e) {
                        error(e);
                    }
                } else {
                    error("script '" + name + "' occurs multiple times in the same file", script,
                        ExpressionDslPackage.Literals.LANGUAGE_UNIT__NAME, ErrorCodes.NAME_CLASH);
                }
            }
        }
        return result;
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
                    ImportTranslator.processRestrictions(name, req.getVersionSpec())));
            }
        }
        return new Imports(processImports(imports), restrictions);
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
    private Script createScript(de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit script, URI uri, 
        boolean registerSuccessful, List<de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit> inProgress, 
        Imports imports) throws TranslatorException {
        int errorCount = getErrorCount();
        VariableDeclaration[] param = resolveParameters(script.getParam());
        Advice[] advices = processAdvices(script.getAdvices(), uri);
        ModelImport<Script> parent = null;
        if (null != script.getParent()) {
            parent = getExtensionImport(script.getParent().getName(), imports, script.getParent(), 
                VilBuildLanguagePackage.Literals.SCRIPT_PARENT_DECL__NAME);
        }
        ScriptDescriptor desc = new ScriptDescriptor(param, advices, imports);
        Script result = new Script(script.getName(), parent, desc, resolver.getTypeRegistry());
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
        if (null != script.getContents()) {
            if (null != script.getContents().getElements()) {
                List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls = select(
                    script.getContents().getElements(), de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration.class);
                // process variable declarations first
                processVariableDeclarations(decls, result);
                // then rules
                processRules(script, result);
            }
        }
        checkConstants(result, script);
        resolver.popModel();
        if (registerSuccessful && errorCount == getErrorCount()) {
            // required if models in the same file refer to each other
            BuildModel.INSTANCE.updateModel(result, uri, BuildLangModelUtility.INSTANCE);
        }
        return result;
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
    private void checkConstants(Script project, de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit cause) {
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
     * @param script the ECore instance representing the script
     * @param result the resulting instance being created
     */
    private void processRules(de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit script, Script result) {
        List<de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration> decls = select(
            script.getContents().getElements(), de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration.class);
        int count;
        do {
            count = decls.size();
            processRules(decls, result, false);
            if (count == decls.size()) {
                break;
            }
        } while (count > 0);
        if (decls.size() > 0) {
            processRules(decls, result, true);
        }
    }

    /**
     * Processes a set of rules.
     * 
     * @param decls the declarations to be processed (successfully processed declarations will be removed, may be 
     *   modified as a side effect)
     * @param script the result instance successfully created instances will be added to
     * @param force if <code>true</code> a failing variable creation will be recorded as an error, 
     *   <code>false</code> failing creations will be ignored
     */
    private void processRules(List<de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration> decls, 
        Script script, boolean force) {
        Iterator<de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration> iter = decls.iterator();
        while (iter.hasNext()) {
            de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration decl = iter.next();
            try {
                script.addRule(processRule(decl, script));
                iter.remove();
            } catch (TranslatorException e) {
                if (force) {
                    error(e);
                }
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
     * @param rule the ECore rule object
     * @param parent the parent script
     * @return the actual rule of the buildlanguage model
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    private Rule processRule(RuleDeclaration rule, Script parent) throws TranslatorException {
        Rule result;
        resolver.pushLevel();
        try {
            resolver.setContextType(Resolver.ContextType.RULE_HEADER);
            RuleDescriptor descriptor = new RuleDescriptor();
            descriptor.setParameters(resolveParameters(rule.getParamList()));
            resolver.add(descriptor.getParameters());
            resolveRuleExpressions(descriptor, Side.RHS, rule.getPreconditions());
            resolveRuleExpressions(descriptor, Side.LHS, rule.getPostcondition());
            if (descriptor.getRuleMatchCount(Side.RHS) > 1) {
                error("at maximum one match expression is supported on the right side", rule, 
                    VilBuildLanguagePackage.Literals.RULE_DECLARATION__PRECONDITIONS, ErrorCodes.RULES);
            }
            if (descriptor.getRuleMatchCount(Side.LHS) > 1) {
                warning("at maximum one match expression is supported on the left side", rule, 
                    VilBuildLanguagePackage.Literals.RULE_DECLARATION__POSTCONDITION, ErrorCodes.RULES);
            }
            if (descriptor.getRuleCallCount(Side.LHS) > 0) {
                error("no rule calls are supported on the left side", rule, 
                    VilBuildLanguagePackage.Literals.RULE_DECLARATION__POSTCONDITION, 0);
            }
            try {
                descriptor.registerVariables(resolver);
            } catch (ExpressionException e) {
                // shall not occur as rules are resolved before
                throw new TranslatorException(e, rule, VilBuildLanguagePackage.Literals.RULE_DECLARATION__NAME);
            }
            resolver.setContextType(Resolver.ContextType.RULE_BODY);
            result = new Rule(rule.getName(), descriptor, isProtected(rule), parent);
            recursiveResolutionModel.addRule(result);
            try {
                result.setBody(getExpressionTranslator().resolveBlock(rule.getBlock(), resolver));
            } catch (TranslatorException e) {
                error(e); // allow rule completion if only errors in body
            }
            recursiveResolutionModel.removeRule(result);
        } catch (TranslatorException e) {
            throw e;
        } finally {
            resolver.popLevel();
        }
        return result;
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
