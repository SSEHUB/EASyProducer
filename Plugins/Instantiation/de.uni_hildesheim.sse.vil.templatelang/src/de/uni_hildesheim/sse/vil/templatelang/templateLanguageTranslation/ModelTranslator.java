package de.uni_hildesheim.sse.vil.templatelang.templateLanguageTranslation;

import static de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Constants.INDENTATION_HINT_ADDITIONAL;
import static de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Constants.INDENTATION_HINT_INDENTATION;
import static de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Constants.INDENTATION_HINT_TAB_EMU;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Imports;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ValueAssignmentExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.AlternativeStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ContentStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Def;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITemplateElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.JavaExtension;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.LoopStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.SwitchStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateBlock;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef;

/**
 * Translates a parsed template language in ECore instances into
 * instances of the template language model and performs semantic
 * analysis.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends de.uni_hildesheim.sse.vil.expressions.translation.ModelTranslator
    <Template, VariableDeclaration, Resolver, ExpressionTranslator> {
    
    private ExpressionTranslator expressionTranslator;
    private Resolver resolver;
    
    // a temporary model for resolving recursive calls - not nice but temporarily adding them to template fails
    private Template recursiveResolutionModel;
    
    /**
     * Creates the model translator.
     */
    public ModelTranslator() {
        super(new ExpressionTranslator(), new Resolver());
        expressionTranslator = getExpressionTranslator();
        resolver = getResolver();
        try {
            recursiveResolutionModel  = new Template("$$", null, new TemplateDescriptor());
            resolver.setRecursiveResolutionModel(recursiveResolutionModel);
        } catch (VilLanguageException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Creates a build model from a given implementation unit. This is the
     * top-level entry method.
     * 
     * @param tpl the language unit to be translated
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @return the corresponding build model
     */
    public Template createModel(de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit tpl, URI uri, 
        boolean registerSuccessful) {
        Template result = null;
        boolean pushed = false;
        int errorCount = getErrorCount();
        try {
            TemplateDescriptor desc = new TemplateDescriptor();
            Imports<Template> imports = processImports(tpl.getImports());
            desc.setImports(imports);
            
            processJavaExtensions(tpl, desc);
            desc.setParameter(resolveParameters(tpl.getParam()), resolver);
            ModelImport<Template> extension = getExtensionImport(tpl.getExt(), imports, tpl, 
                TemplateLangPackage.Literals.LANGUAGE_UNIT__EXT);
            desc.setAdvices(processAdvices(tpl.getAdvices(), uri));
            if (null != tpl.getIndent()) {
                desc.setIndentationConfiguration(processIndentHint(tpl.getIndent()));
            }
            result = new Template(tpl.getName(), extension, desc);
            resolver.pushModel(result);
            pushed = true;
            if (null != tpl.getVars()) {
                List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls = select(
                    tpl.getVars(), de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration.class);
                processVariableDeclarations(decls, result);
                // variables are added successively to the resolver
            }
            result.setVersion(convert(tpl.getVersion()));
            resolveImports(tpl, ExpressionDslPackage.Literals.LANGUAGE_UNIT__IMPORTS, result, uri, 
                new ArrayList<de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit>());
            resolver.enumerateImports(result);
            if (null != tpl.getDefs()) {
                List<VilDef> tmp = new ArrayList<VilDef>(); // otherwise... concurrent modification exception -> select
                tmp.addAll(tpl.getDefs());
                processDefs(tmp, result);
            }
            if (registerSuccessful && errorCount == getErrorCount()) {
                // required if models in the same file refer to each other
                TemplateModel.INSTANCE.updateModel(result, uri, TemplateLangModelUtility.INSTANCE);
            }
        } catch (VilLanguageException e) {
            error(e, tpl, ExpressionDslPackage.Literals.LANGUAGE_UNIT__NAME);
        } catch (TranslatorException e) {
            error(e);
        } finally {
            if (pushed) {
                resolver.popModel();
            }
        }
        return result;
    }
    
    /**
     * Processes an indentation hint and returns the indentation configuration.
     * 
     * @param hint the hint
     * @return the indentation configuration
     */
    private IndentationConfiguration processIndentHint(IndentationHint hint) {
        IndentationConfiguration result = null;
        if (null != hint) {
            // disable
            Map<String, Integer> values = new HashMap<String, Integer>();
            Set<String> assigned = new HashSet<String>();
            values.put(INDENTATION_HINT_INDENTATION, -1);
            values.put(INDENTATION_HINT_TAB_EMU, -1);
            values.put(INDENTATION_HINT_ADDITIONAL, 1); 
            
            for (IndentationHintPart part : hint.getParts()) {
                String name = part.getName();
                if (!values.containsKey(name)) {
                    warning("indentation entry '" + name + "' is unknown - igored", part, 
                        TemplateLangPackage.Literals.INDENTATION_HINT_PART__NAME, ErrorCodes.UNKNOWN_ELEMENT);
                } else {
                    if (assigned.contains(name)) {
                        warning("indentation entry '" + name + "' is already specified - igored", part, 
                            TemplateLangPackage.Literals.INDENTATION_HINT_PART__NAME, ErrorCodes.UNKNOWN_ELEMENT);
                    } else {
                        int value;
                        try {
                            value = Integer.parseInt(part.getValue());
                            if (value < 0) {
                                warning("indentation value is negative - igored", part, 
                                    TemplateLangPackage.Literals.INDENTATION_HINT_PART__NAME, ErrorCodes.UNKNOWN_ELEMENT);
                            }
                            values.put(name, value);
                            assigned.add(name);
                        } catch (NumberFormatException e) {
                            warning("indentation value is not an integer - igored", part, 
                                TemplateLangPackage.Literals.INDENTATION_HINT_PART__NAME, ErrorCodes.UNKNOWN_ELEMENT);
                        }
                    }
                }
            }
            result = new IndentationConfiguration(values.get(INDENTATION_HINT_INDENTATION), 
                values.get(INDENTATION_HINT_TAB_EMU), values.get(INDENTATION_HINT_ADDITIONAL));
        } 
        return result;
    }
     
    /**
     * Processes the Java extensions.
     * 
     * @param tpl the template to be processed
     * @param desc the template descriptor to put the information into
     * @throws TranslatorException in case that resolving the Java extensions fails
     */
    private void processJavaExtensions(de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit tpl, 
        TemplateDescriptor desc) throws TranslatorException {
        if (null != tpl.getJavaExts()) {
            Set<String> knownTypes = new HashSet<String>();
            Set<String> knownSignatures = new HashSet<String>();
            Iterator<TypeDescriptor<? extends IVilType>> iter = TypeRegistry.allTypes().iterator();
            while (iter.hasNext()) {
                knownTypes.add(iter.next().getName());
            }
            for (Extension ext : tpl.getJavaExts()) {
                desc.addJavaExtension(processJavaExtension(ext, knownTypes, knownSignatures));
            }
        }
    }

    /**
     * Processes a Java extension.
     * 
     * @param ext the extension to be processed
     * @param knownTypes known type names (may be modified as a side effect)
     * @param knownSignatures known signatures due to Java extensions (may be modified as a side effect)
     * @return the Java extension
     * @throws TranslatorException in case that resolving the Java extension fails
     */
    private JavaExtension processJavaExtension(Extension ext, Set<String> knownTypes, Set<String> knownSignatures) 
        throws TranslatorException {
        JavaExtension javaExt;
        try {
            javaExt = new JavaExtension(getJavaQualifiedNameString(ext.getName()));
            IMetaType resolved = javaExt.getResolved();
            if (null != resolved) {
                String typeName = resolved.getName();
                if (!knownTypes.contains(typeName)) {
                    knownTypes.add(typeName);
                    for (int o = 0; o < resolved.getOperationsCount(); o++) {
                        String sig = resolved.getOperation(o).getJavaSignature();
                        if (knownSignatures.contains(sig)) {
                            throw new TranslatorException("signature " + sig + " in type " + typeName + 
                                " is already known", ext, TemplateLangPackage.Literals.EXTENSION__NAME, ErrorCodes.REDEFINITION);
                        }
                    }
                } else {
                    throw new TranslatorException("type " + typeName + " is already known", ext, 
                        TemplateLangPackage.Literals.EXTENSION__NAME, ErrorCodes.REDEFINITION);
                }
            }
        } catch (VilLanguageException e) {
            throw new TranslatorException(e, ext, TemplateLangPackage.Literals.EXTENSION__NAME);
        }
        return javaExt;
    }
    
    /**
     * Returns a string representing a qualified name. (May change in future to
     * structured qualified names.)
     * 
     * @param name
     *            the qualified name
     * @return the corresponding string representation
     */
    public static String getJavaQualifiedNameString(JavaQualifiedName name) {
        StringBuilder result = new StringBuilder();
        for (String s : name.getQname()) {
            result.append(s);
        }
        return result.toString();
    }
    
    /**
     * Returns the management instance.
     * 
     * @return the management instance
     */
    protected ModelManagement<Template> getManagementInstance() {
        return TemplateModel.INSTANCE;
    }
    
    /**
     * Processes all template defs considering dependencies and terminates with
     * an error if not all can be resolved.
     * 
     * @param defs the defs to be processed
     * @param template the target template to store the defs in
     */
    protected void processDefs(List<VilDef> defs, Template template) {
        int count;
        do {
            count = defs.size();
            processDefs(defs, template, false);
            if (count == defs.size()) {
                break;
            }
        } while (count > 0);
        if (defs.size() > 0) {
            processDefs(defs, template, true);
        }
    }

    /**
     * Processes a set of template definitions.
     * 
     * @param defs the defs to be processed
     * @param template the target template to store the defs in
     * @param force if <code>true</code> a failing variable creation will be recorded as an error, 
     *   <code>false</code> failing creations will be ignored
     */
    private void processDefs(List<VilDef> defs, Template template, boolean force) {
        Iterator<VilDef> iter = defs.iterator();
        while (iter.hasNext()) {
            VilDef def = iter.next();
            try {
                template.addDef(processDef(def, template));
                iter.remove();
            } catch (TranslatorException e) {
                if (force) {
                    error(e);
                }
            }
        }
    }

    /**
     * Processes a (sub-)template definition.
     * 
     * @param def the sub-template
     * @param template the target template to store the def in
     * @return the model instance
     * @throws TranslatorException in case that processing the definition fail
     */
    private Def processDef(VilDef def, Template template) throws TranslatorException {
        Def result = null;
        resolver.pushLevel();
        try {
            VariableDeclaration[] param = resolveParameters(def.getParam());
            resolver.add(param);
            TypeDescriptor<? extends IVilType> specifiedType = null;
            if (null != def.getType()) {
                specifiedType = getExpressionTranslator().processType(def.getType());
            }
            result = new Def(def.getId(), param, null, specifiedType, template); 
            recursiveResolutionModel.addDef(result);
            result.setBody(processBlock(def.getStmts()));
            recursiveResolutionModel.removeDef(result);
            try {
                result.inferType();
            } catch (VilLanguageException e) {
                throw new TranslatorException(e, def, TemplateLangPackage.Literals.VIL_DEF__STMTS);
            }
        } catch (TranslatorException e) {
            throw e;
        } finally {
            resolver.popLevel();
        }
        return result; 
    }
    
    /**
     * Processes a block of rule elements.
     * @param block the block to be resolved
     * @return the resolved elements
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    private ITemplateElement[] processBlock(StmtBlock block) throws TranslatorException {
        ITemplateElement[] result = null;
        if (null != block && null != block.getStmts() && !block.getStmts().isEmpty()) {
            List<ITemplateElement> tmp = new ArrayList<ITemplateElement>();
            for (Stmt stmt : block.getStmts()) {
                tmp.add(processStatement(stmt));
            }
            if (!tmp.isEmpty()) {
                result = new ITemplateElement[tmp.size()];
                tmp.toArray(result);
            }
        }
        return result;
    }
    
    /**
     * Processes a statement.
     * 
     * @param stmt the statement to be resolved
     * @return the resolved elements
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    private ITemplateElement processStatement(Stmt stmt) throws TranslatorException {
        ITemplateElement result = null;
        if (null != stmt.getAlt()) {
            result = processAlternative(stmt.getAlt());
        } else if (null != stmt.getBlock()) {
            resolver.pushLevel();
            try {
                result = new TemplateBlock(processBlock(stmt.getBlock()));
            } catch (TranslatorException e) {
                throw e;
            } finally {
                resolver.popLevel();
            }
        } else if (null != stmt.getCtn()) {
            result = processContent(stmt.getCtn(), resolver);
        } else if (null != stmt.getExprStmt()) {
            result = processExpressionStatement(stmt.getExprStmt());
        } else if (null != stmt.getLoop()) {
            result = processLoop(stmt.getLoop());
        } else if (null != stmt.getMulti()) {
            warning("multi selection is currently not supported", stmt.getMulti(), 
                TemplateLangPackage.Literals.STMT__MULTI, 0);
        } else if (null != stmt.getSwitch()) {
            result = processSwitch(stmt.getSwitch());
        } else if (null != stmt.getVar()) {
            result = getExpressionTranslator().processVariableDeclaration(stmt.getVar(), resolver);
        }
        return result;
    }
    
    /**
     * Processes an alternative statement.
     * 
     * @param alt the alternative element from the language
     * @return the object representation of the alternative statement
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    private AlternativeStatement processAlternative(de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative alt) 
        throws TranslatorException {
        Expression condition = expressionTranslator.processExpression(alt.getExpr(), resolver);
        ITemplateElement ifElt = processStatement(alt.getIf());
        ITemplateElement elseElt;
        if (null != alt.getElse()) {
            elseElt = processStatement(alt.getElse());
        } else {
            elseElt = null;
        }
        try {
            return new AlternativeStatement(condition, ifElt, elseElt);
        } catch (VilLanguageException e) {
            throw new TranslatorException(e, alt, TemplateLangPackage.Literals.ALTERNATIVE__EXPR);
        }
    }
    
    private Expression processSeparatorExpression(PrimaryExpression ex) throws TranslatorException {
        Expression result;
        if (null != ex) {
            result = expressionTranslator.processPrimaryExpression(ex, resolver);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Processes a loop expression.
     * 
     * @param loop the loop expression to be processed
     * @return the loop object model instance
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    private LoopStatement processLoop(de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop loop) 
        throws TranslatorException {
        Expression loopExpression = expressionTranslator.processExpression(loop.getExpr(), resolver);
        TypeDescriptor<? extends IVilType> exprType = null;
        try {
            exprType = loopExpression.inferType();
        } catch (ExpressionException e) {
            throw new TranslatorException(e, loop, TemplateLangPackage.Literals.LOOP__EXPR);
        }
        if (!exprType.isCollection()) {
            throw new TranslatorException("loop expression must be of type collection rather than " 
                + exprType.getVilName(), loop, TemplateLangPackage.Literals.LOOP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
        }
        if (0 == exprType.getParameterCount()) {
            throw new TranslatorException("loop expression is not generic", loop, 
                TemplateLangPackage.Literals.LOOP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
        }
        TypeDescriptor<? extends IVilType> type = expressionTranslator.processType(loop.getType());
        if (!type.isAssignableFrom(exprType.getParameterType(0))) {
            throw new TranslatorException("loop variable type " + type.getVilName() 
                + " must match the element type of the collection " + exprType.getVilName(), loop, 
                TemplateLangPackage.Literals.LOOP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
        }
        Expression separatorEx = processSeparatorExpression(loop.getSeparator());
        Expression finalSeparatorEx = processSeparatorExpression(loop.getFinalSeparator());
        VariableDeclaration iteratorVar = new VariableDeclaration(loop.getId(), type);
        ITemplateElement stmt = null;
        resolver.pushLevel();
        resolver.add(iteratorVar);
        try {
            stmt = processStatement(loop.getStmt());
        } catch (TranslatorException e) {
            throw e;
        } finally {
            resolver.popLevel();
        }
        try {
            return new LoopStatement(iteratorVar, loopExpression, stmt, separatorEx, finalSeparatorEx);
        } catch (VilLanguageException e) {
            throw new TranslatorException(e, loop, TemplateLangPackage.Literals.LOOP__ID);
        }
    }
    
    /**
     * Processes a switch statement.
     * 
     * @param swtch the switch statement from the language
     * @return the switch object model instance
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    private SwitchStatement processSwitch(de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch swtch) 
        throws TranslatorException {
        Expression switchExpression = expressionTranslator.processExpression(swtch.getExpr(), resolver);
        TypeDescriptor<? extends IVilType> type;
        try {
            type = switchExpression.inferType();
        } catch (ExpressionException e) {
            throw new TranslatorException(e, swtch, TemplateLangPackage.Literals.SWITCH__EXPR);
        }
        VariableDeclaration switchVar = new VariableDeclaration("VALUE", type);
        resolver.pushLevel();
        resolver.add(switchVar);
        List<SwitchStatement.Alternative> alternatives = new ArrayList<SwitchStatement.Alternative>();
        for (SwitchPart part : swtch.getParts()) {
            Expression condition = expressionTranslator.processExpression(part.getLeft(), resolver);
            try {
                condition.inferType();
            } catch (ExpressionException e) {
                resolver.popLevel();
                throw new TranslatorException(e, part, TemplateLangPackage.Literals.SWITCH_PART__LEFT);
            }
            Expression value = expressionTranslator.processExpression(part.getRight(), resolver);
            try {
                condition.inferType();
            } catch (ExpressionException e) {
                resolver.popLevel();
                throw new TranslatorException(e, part, TemplateLangPackage.Literals.SWITCH_PART__RIGHT);
            }
            alternatives.add(new SwitchStatement.Alternative(condition, value));
        }
        if (null != swtch.getDflt()) {
            Expression expr = expressionTranslator.processExpression(swtch.getDflt(), resolver);
            try {
                expr.inferType();
            } catch (ExpressionException e) {
                resolver.popLevel();
                throw new TranslatorException(e, swtch, TemplateLangPackage.Literals.SWITCH__DFLT);
            }
            alternatives.add(new SwitchStatement.Alternative(expr));
        }
        try {
            return new SwitchStatement(switchExpression, switchVar, alternatives);
        } catch (VilLanguageException e) {
            throw new TranslatorException(e, swtch, TemplateLangPackage.Literals.SWITCH__EXPR);
        }  finally {
            resolver.popLevel();
        }
    }
    
    /**
     * Processes a content statement.
     * 
     * @param content the statement
     * @return the model object
     */
    private ContentStatement processContent(de.uni_hildesheim.sse.vil.templatelang.templateLang.Content content, 
        Resolver resolver) 
        throws TranslatorException {
        Expression indentExpr;
        if (null != content.getIndent()) {
            indentExpr = getExpressionTranslator().processExpression(content.getIndent(), resolver);
        } else {
            indentExpr = null;
        }
        try {
            String text = content.getCtn();
            String terminal = text.substring(0, 1);
            text = ExpressionTranslator.convertString(text);
            return new ContentStatement(text, terminal, indentExpr, content.getPrint() == null);
        } catch (VilLanguageException e) {
            throw new TranslatorException(e, content, TemplateLangPackage.Literals.CONTENT__INDENT);
        }
    }
    
    /**
     * Processes an expression statement.
     * 
     * @param expr the expression to be processed
     * @return the expression statement
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    protected ExpressionStatement processExpressionStatement(de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement expr) 
        throws TranslatorException {
        Expression result = getExpressionTranslator().processExpression(expr.getExpr(), resolver);
        try {
            result.inferType();
        } catch (ExpressionException e) {
            throw new TranslatorException(e, expr, ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__EXPR);
        }
        if (null != expr.getVar()) {
            VariableDeclaration decl = resolver.resolve(expr.getVar(), false);
            if (null == decl) {
                throw new TranslatorException("cannot resolve '" + expr.getVar() + "'", expr, 
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
     * Turns a buildlang exception into a xText error.
     * 
     * @param exception the exception to used
     * @param cause the cause (as instance of the EMF grammar model)
     * @param causeFeature the causing feature (as part of <code>cause</code>)
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
     * @param causeFeature the causing feature (as part of <code>cause</code>)
     */
    void warning(VilLanguageException exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.warning(exception, cause, causeFeature);
    }

    @Override
    protected VariableDeclaration[] createArray(int len) {
        return new VariableDeclaration[len];
    }

}
