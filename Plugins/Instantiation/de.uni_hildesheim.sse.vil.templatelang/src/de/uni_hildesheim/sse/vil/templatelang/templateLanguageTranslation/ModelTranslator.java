package de.uni_hildesheim.sse.vil.templatelang.templateLanguageTranslation;

import static net.ssehub.easy.instantiation.core.model.templateModel.Constants.*;

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

import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression;
import de.uni_hildesheim.sse.vil.expressions.translation.StringResolver;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHint;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHintPart;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.translation.ErrorCodes;
import net.ssehub.easy.dslCore.translation.StringUtils;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.instantiation.core.model.common.Imports;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CompositeExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.templateModel.AlternativeStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;
import net.ssehub.easy.instantiation.core.model.templateModel.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.FormattingConfiguration;
import net.ssehub.easy.instantiation.core.model.templateModel.ITemplateElement;
import net.ssehub.easy.instantiation.core.model.templateModel.JavaExtension;
import net.ssehub.easy.instantiation.core.model.templateModel.LoopStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.Resolver;
import net.ssehub.easy.instantiation.core.model.templateModel.SwitchStatement;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateBlock;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateDescriptor;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.templateModel.TypeDef;
import net.ssehub.easy.instantiation.core.model.templateModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.templateModel.WhileStatement;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Translates a parsed template language in ECore instances into
 * instances of the template language model and performs semantic
 * analysis.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends de.uni_hildesheim.sse.vil.expressions.translation.ModelTranslator
    <Template, VariableDeclaration, Resolver, ExpressionStatement, ExpressionTranslator> {
    
    private ExpressionTranslator expressionTranslator;
    private Resolver resolver;
    
    /**
     * Creates the model translator.
     */
    public ModelTranslator() {
        super(new ExpressionTranslator(), new Resolver(new TypeRegistry(TypeRegistry.DEFAULT)));
        expressionTranslator = getExpressionTranslator();
        resolver = getResolver();
    }
    
    /**
     * Creates a build model from a given implementation unit. This is the
     * top-level entry method.
     * 
     * @param tpl the language unit to be translated
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @param impResolver the import resolver to use (may be <b>null</b> to use a new default import resolver)
     * @return the corresponding build model
     */
    public Template createModel(de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit tpl, URI uri, 
        boolean registerSuccessful, ImportResolver<Template> impResolver) {
        Template result = null;
        boolean pushed = false;
        int errorCount = getErrorCount();
        ResourceRegistry.register(tpl.eResource(), resolver.getTypeRegistry());
        try {
            TemplateDescriptor desc = new TemplateDescriptor();
            Imports<Template> imports = processImports(tpl.getImports());
            desc.setImports(imports);
            desc.setAdvices(processAdvices(tpl.getAdvices(), uri));
            
            processJavaExtensions(tpl, desc);
            desc.setParameter(resolveParameters(tpl.getParam(), resolver), resolver);
            ModelImport<Template> extension = getExtensionImport(tpl.getExt(), imports, tpl, 
                TemplateLangPackage.Literals.LANGUAGE_UNIT__EXT);
            if (null != tpl.getIndent()) {
                desc.setIndentationConfiguration(processIndentHint(tpl.getIndent()));
            }
            if (null != tpl.getFormatting()) {
                desc.setFormattingConfiguration(processFormattingHint(tpl.getFormatting()));
            }
            result = new Template(tpl.getName(), extension, desc, resolver.getTypeRegistry());
            resolver.pushModel(result);
            pushed = true;
            processTypedefs(tpl.getTypeDefs(), result);
            if (null != tpl.getVars()) {
                List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls = select(
                    tpl.getVars(), de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration.class);
                processVariableDeclarations(decls, result);
                // variables are added successively to the resolver
            }
            result.setVersion(convert(tpl.getVersion()));
            resolveImports(tpl, ExpressionDslPackage.Literals.LANGUAGE_UNIT__IMPORTS, result, uri, 
                new ArrayList<de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit>(), impResolver);
            resolver.enumerateImports(result);
            if (null != tpl.getDefs()) {
                processDefs(tpl, result);
            }
            reProcessGlobalVariableDeclarations(result);
            if (registerSuccessful && errorCount == getErrorCount()) {
                // required if models in the same file refer to each other
                TemplateModel.INSTANCE.updateModel(result, uri, TemplateLangModelUtility.INSTANCE);
            }
        } catch (VilException e) {
            error(e, tpl, ExpressionDslPackage.Literals.LANGUAGE_UNIT__NAME);
        } catch (TranslatorException e) {
            error(e);
        } finally {
            if (pushed) {
                resolver.popModel();
            }
        }
        getExpressionTranslator().enactIvmlWarnings();
        return result;
    }
    
    /**
     * Processes an indentation hint and returns the indentation configuration.
     * 
     * @param hint the hint
     * @return the indentation configuration (may be <b>null</b> if there is no indentation hint)
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
     * Processes the formatting hint.
     * 
     * @param hint the hint to be processed 
     * @return the related formatting configuration (may be <b>null</b> if there is no formatting hint)
     */
    private FormattingConfiguration processFormattingHint(FormattingHint hint) {
        FormattingConfiguration result = null;
        if (null != hint) {
            for (FormattingHintPart part : hint.getParts()) {
                if (FORMATTING_HINT_LINEEND.equals(part.getName())) {
                    result = new FormattingConfiguration();
                    String value = StringUtils.convertString(part.getValue());
                    result.setLineEnding(value);
                }
            }
        }
        return result;
    }
     
    /**
     * Re-processes global variable declarations to get rid of temporary "function pointer" expressions.
     * 
     * @param model the model to be processed
     */
    protected void reProcessGlobalVariableDeclarations(Template model) {
        for (int v = 0; v < model.getVariableDeclarationCount(); v++) {
            try {
                getExpressionTranslator().reProcessVariableDeclaration(model.getVariableDeclaration(v), resolver);
            } catch (TranslatorException e) {
                error(e);
            }
        }
    }
    
    /**
     * Processes the Java extensions.
     * 
     * @param tpl the template to be processed
     * @param desc the template descriptor to put the information into
     * @throws TranslatorException in case that resolving/processing/adding the Java extensions fails
     */
    private void processJavaExtensions(de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit tpl, 
        TemplateDescriptor desc) throws TranslatorException {
        int extCount = TemplateLangExecution.getDefaultExtensionCount();
        List<Extension> exts = tpl.getJavaExts();
        if (extCount > 0 || null != exts) {
            Set<String> knownTypes = new HashSet<String>();
            Set<String> knownSignatures = new HashSet<String>();
            Iterator<TypeDescriptor<?>> iter = resolver.getTypeRegistry().allTypes().iterator();
            while (iter.hasNext()) {
                knownTypes.add(iter.next().getName());
            }

            // process default extensions
            for (int e = 0; e < extCount; e++) {
                desc.addJavaExtension(processJavaExtension(TemplateLangExecution.getDefaultExtension(e), knownTypes, 
                    knownSignatures, tpl, TemplateLangPackage.Literals.LANGUAGE_UNIT__JAVA_EXTS));
            }
            
            // process defined extensions
            if (null != exts) {
                for (Extension ext : exts) {
                    desc.addJavaExtension(processJavaExtension(ext, knownTypes, knownSignatures));
                }
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
     * @throws TranslatorException in case that resolving/processing/adding the Java extension fails
     */
    private JavaExtension processJavaExtension(Extension ext, Set<String> knownTypes, Set<String> knownSignatures) 
        throws TranslatorException {
        JavaExtension javaExt;
        try {
            javaExt = new JavaExtension(getJavaQualifiedNameString(ext.getName()), resolver.getTypeRegistry());
            processJavaExtension(javaExt, knownTypes, knownSignatures, ext, 
                TemplateLangPackage.Literals.EXTENSION__NAME);
        } catch (VilException e) {
            throw new TranslatorException(e, ext, TemplateLangPackage.Literals.EXTENSION__NAME);
        }
        return javaExt;
    }

    /**
     * Processes a Java extension.
     * 
     * @param ext the extension to be processed
     * @param knownTypes known type names (may be modified as a side effect)
     * @param knownSignatures known signatures due to Java extensions (may be modified as a side effect)
     * @param cause the causing EObject
     * @param causingFeature the causing language feature 
     * @return the Java extension
     * @throws TranslatorException in case that resolving/processing/adding the Java extension fails
     */
    private JavaExtension processJavaExtension(JavaExtension javaExt, Set<String> knownTypes, Set<String> knownSignatures, 
        EObject cause, EStructuralFeature causingFeature) throws TranslatorException{
        IMetaType resolved = javaExt.getResolved();
        if (null != resolved) {
            String typeName = resolved.getName();
            if (!knownTypes.contains(typeName)) {
                knownTypes.add(typeName);
                for (int o = 0; o < resolved.getOperationsCount(); o++) {
                    String sig = resolved.getOperation(o).getJavaSignature();
                    if (knownSignatures.contains(sig)) {
                        throw new TranslatorException("signature " + sig + " in type " + typeName + 
                            " is already known", cause, causingFeature, ErrorCodes.REDEFINITION);
                    }
                    knownSignatures.add(sig);
                }
            } else {
                throw new TranslatorException("type " + typeName + " is already known", cause, causingFeature, 
                    ErrorCodes.REDEFINITION);
            }
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
    protected void processDefs(de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit tpl, 
        Template template) {
        Map<String, DefInfo> signatures = new HashMap<String, DefInfo>();
        List<VilDef> defs = new ArrayList<VilDef>();
        defs.addAll(tpl.getDefs()); // avoid concurrent modifications with xText (select function in other languages)
        for (int d = 0; d < defs.size(); d++) {
            try {
                VilDef vilDef = defs.get(d);
                Def def = processDef(defs.get(d), template);
                String fSig = def.getSignature() + "[" + template.getName() + ']';
                if (signatures.containsKey(fSig)) {
                    error("duplicated template definition", vilDef, TemplateLangPackage.Literals.VIL_DEF__ID, 
                        ErrorCodes.REDEFINITION);
                } else {
                    DefInfo info = new DefInfo(vilDef, def);
                    signatures.put(fSig, info);
                    template.addDef(def);
                }
            } catch (TranslatorException e) {
                error(e);
            }
        }
        for (DefInfo info : signatures.values()) {
            try {
                processDefBody(info);
            } catch (TranslatorException e) {
                error(e);
            }
        }
    }

    /**
     * Processes a (sub-)template definition header.
     * 
     * @param def the sub-template
     * @param template the target template to store the def in
     * @return the model instance
     * @throws TranslatorException in case that processing the definition fail
     */
    private Def processDef(VilDef def, Template template) throws TranslatorException {
        VariableDeclaration[] param = resolveParameters(def.getParam(), resolver);
        TypeDescriptor<?> specifiedType = null;
        if (null != def.getType()) {
            specifiedType = getExpressionTranslator().processType(def.getType(), resolver);
        }
        Def result = new Def(def.getId(), param, null, specifiedType, template);
        if (null != def.getProtected()) {
            result.setProtected(true);
        }
        return result;
    }

    /**
     * Processes a (sub-)template body.
     * 
     * @param info the def information object relating Ecore and model instance
     * @throws TranslatorException in case that processing the definition fail
     */
    private void processDefBody(DefInfo info) throws TranslatorException{
        Def def = info.getDef();
        VilDef vilDef = info.getVilDef();
        resolver.pushLevel();
        for (int p = 0; p < def.getParameterCount(); p++) {
            resolver.add(def.getParameter(p));
        }
        def.setBody(processBlock(vilDef.getStmts()));
        try {
            def.inferType();
        } catch (VilException e) {
            throw new TranslatorException(e, vilDef, TemplateLangPackage.Literals.VIL_DEF__STMTS);
        } finally {
            resolver.popLevel();
        }
    }
    
    /**
     * Processes a block of rule elements.
     * @param block the block to be resolved
     * @return the resolved elements
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     */
    private ITemplateElement[] processBlock(StmtBlock block) {
        ITemplateElement[] result = null;
        if (null != block && null != block.getStmts() && !block.getStmts().isEmpty()) {
            List<ITemplateElement> tmp = new ArrayList<ITemplateElement>();
            for (Stmt stmt : block.getStmts()) {
                try {
                    tmp.add(processStatement(stmt));
                } catch (TranslatorException e) {
                    error(e);
                }
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
        if (null != stmt) {
            if (null != stmt.getAlt()) {
                result = processAlternative(stmt.getAlt());
            } else if (null != stmt.getBlock()) {
                resolver.pushLevel();
                result = new TemplateBlock(processBlock(stmt.getBlock()));
                resolver.popLevel();
            } else if (null != stmt.getCtn()) {
                result = processContent(stmt.getCtn(), resolver);
            } else if (null != stmt.getExprStmt()) {
                result = expressionTranslator.processExpressionStatement(stmt.getExprStmt(), resolver);
            } else if (null != stmt.getLoop()) {
                result = processLoop(stmt.getLoop());
            } else if (null != stmt.getWhile()) {
                result = processWhile(stmt.getWhile());
            } else if (null != stmt.getMulti()) {
                warning("multi selection is currently not supported", stmt.getMulti(), 
                    TemplateLangPackage.Literals.STMT__MULTI, 0);
            } else if (null != stmt.getSwitch()) {
                result = processSwitch(stmt.getSwitch());
            } else if (null != stmt.getVar()) {
                result = getExpressionTranslator().processVariableDeclaration(stmt.getVar(), resolver);
            }
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
        condition = expressionTranslator.assertBooleanExpression(condition, alt, 
            TemplateLangPackage.Literals.ALTERNATIVE__EXPR);
        resolver.pushLevel();
        ITemplateElement ifElt = processStatement(alt.getIf());
        resolver.popLevel();
        ITemplateElement elseElt;
        if (null != alt.getElse()) {
            resolver.pushLevel();
            elseElt = processStatement(alt.getElse());
            resolver.popLevel();
        } else {
            elseElt = null;
        }
        try {
            return new AlternativeStatement(condition, ifElt, elseElt);
        } catch (VilException e) {
            throw new TranslatorException(e, alt, TemplateLangPackage.Literals.ALTERNATIVE__EXPR);
        }
    }
    
    /**
     * Processes a separator expression.
     * 
     * @param ex the ECore expression tree
     * @return the VIL/VTL expression tree
     * @throws TranslatorException in case that the translation fails
     */
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
     * Processes a while statement.
     * 
     * @param loop the ECore loop representation
     * @return the VTL while statement
     * @throws TranslatorException in case that the translation fails
     */
    private WhileStatement processWhile(de.uni_hildesheim.sse.vil.templatelang.templateLang.While loop) 
        throws TranslatorException {
        Expression loopExpression = expressionTranslator.processExpression(loop.getExpr(), resolver);
        loopExpression = expressionTranslator.assertBooleanExpression(loopExpression, loop, 
            TemplateLangPackage.Literals.WHILE__EXPR);
        resolver.pushLevel();
        ITemplateElement stmt = null;
        try {
            stmt = processStatement(loop.getStmt());
        } catch (TranslatorException e) {
            throw e;
        } finally {
            resolver.popLevel();
        }
        try {
            return new WhileStatement(loopExpression, stmt);
        } catch (VilException e) {
            throw new TranslatorException(e, loop, TemplateLangPackage.Literals.WHILE__EXPR);
        }
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
        TypeDescriptor<?> exprType = null;
        try {
            exprType = loopExpression.inferType();
        } catch (VilException e) {
            throw new TranslatorException(e, loop, TemplateLangPackage.Literals.LOOP__EXPR);
        }
        if (!exprType.isCollection() && !exprType.isIterator()) {
            OperationDescriptor conversion = exprType.getConversionToSequence();
            if (null == conversion) {
                throw new TranslatorException("loop expression must be of type collection rather than " 
                    + exprType.getVilName(), loop, TemplateLangPackage.Literals.LOOP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
            } else {
                exprType = conversion.getReturnType();
            }
        }
        if (0 == exprType.getGenericParameterCount()) {
            throw new TranslatorException("loop expression is not generic", loop, 
                TemplateLangPackage.Literals.LOOP__EXPR, ErrorCodes.TYPE_CONSISTENCY);
        }
        TypeDescriptor<?> type = expressionTranslator.processType(loop.getType(), resolver);
        TypeDescriptor<?> p0Type = exprType.getGenericParameterType(0);
        if (!type.isAssignableFrom(p0Type) && null == p0Type.findConversion(p0Type, type)) {
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
        } catch (VilException e) {
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
        TypeDescriptor<?> type;
        try {
            type = switchExpression.inferType();
        } catch (VilException e) {
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
            } catch (VilException e) {
                resolver.popLevel();
                throw new TranslatorException(e, part, TemplateLangPackage.Literals.SWITCH_PART__LEFT);
            }
            Expression value = expressionTranslator.processExpression(part.getRight(), resolver);
            try {
                condition.inferType();
            } catch (VilException e) {
                resolver.popLevel();
                throw new TranslatorException(e, part, TemplateLangPackage.Literals.SWITCH_PART__RIGHT);
            }
            alternatives.add(new SwitchStatement.Alternative(condition, value));
        }
        if (null != swtch.getDflt()) {
            Expression expr = expressionTranslator.processExpression(swtch.getDflt(), resolver);
            try {
                expr.inferType();
            } catch (VilException e) {
                resolver.popLevel();
                throw new TranslatorException(e, swtch, TemplateLangPackage.Literals.SWITCH__DFLT);
            }
            alternatives.add(new SwitchStatement.Alternative(expr));
        }
        try {
            return new SwitchStatement(switchExpression, switchVar, alternatives);
        } catch (VilException e) {
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
            text = StringUtils.convertString(text);
            StringBuilder warnings = new StringBuilder();
            CompositeExpression tmp = (CompositeExpression) StringResolver.substitute(text, resolver, 
                expressionTranslator, warnings);
            if (warnings.length() > 0) {
                warning(warnings.toString(), content, TemplateLangPackage.Literals.CONTENT__CTN, 0);
            }
            return new ContentStatement(tmp, terminal, indentExpr, content.getPrint() == null, 
                resolver.getCurrentModel());
        } catch (VilException e) {
            throw new TranslatorException(e, content, TemplateLangPackage.Literals.CONTENT__INDENT);
        }
    }
    
    /**
     * Turns a buildlang exception into a xText error.
     * 
     * @param exception the exception to used
     * @param cause the cause (as instance of the EMF grammar model)
     * @param causeFeature the causing feature (as part of <code>cause</code>)
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
     * @param causeFeature the causing feature (as part of <code>cause</code>)
     */
    void warning(VilException exception, EObject cause,
            EStructuralFeature causeFeature) {
        expressionTranslator.warning(exception, cause, causeFeature);
    }

    @Override
    protected VariableDeclaration[] createArray(int len) {
        return new VariableDeclaration[len];
    }
    
    @Override
    protected void addVisibleDeclarationsToResolver(Template model, Resolver resolver) {
        for (int v = 0; v < model.getVariableDeclarationCount(); v++) {
            VariableDeclaration decl = model.getVariableDeclaration(v);
            if (!resolver.contains(decl)) { // don't overwrite existing ones, they have priority
                resolver.add(decl);
            }
        }
    }
 
    @Override
    protected Typedef createTypedef(String name, TypeDescriptor<?> type) throws VilException {
        return new TypeDef(name, type, getResolver().getCurrentModel());
    }

}