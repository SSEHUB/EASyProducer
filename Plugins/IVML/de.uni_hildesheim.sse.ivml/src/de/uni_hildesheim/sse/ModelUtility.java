package de.uni_hildesheim.sse;

import static com.google.inject.Guice.createInjector;

import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

import de.uni_hildesheim.sse.ivml.ConflictStmt;
import de.uni_hildesheim.sse.ivml.DerivedType;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ExpressionStatement;
import de.uni_hildesheim.sse.ivml.ImportStmt;
import de.uni_hildesheim.sse.ivml.Type;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import de.uni_hildesheim.sse.ivml.VersionStmt;
import de.uni_hildesheim.sse.translation.ExpressionTranslator;
import de.uni_hildesheim.sse.translation.ImportTranslator;
import de.uni_hildesheim.sse.translation.ModelTranslator;
import de.uni_hildesheim.sse.translation.ModelTranslator.Result;
import de.uni_hildesheim.sse.translation.TypeContext;
import de.uni_hildesheim.sse.translation.Utils;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.translation.LogMessageReceiver;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.dslCore.translation.MessageReceiver;
import net.ssehub.easy.dslCore.translation.TranslatorException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.EmptyInitializer;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.persistency.ConfigurableIVMLWriter;

/**
 * (Entry points for) Utilities for working with the EMF model.
 * 
 * @author Holger Eichelberger
 */
public class ModelUtility extends net.ssehub.easy.dslCore.ModelUtility<VariabilityUnit, Project> 
    implements IModelLoader<Project> {

    public static final ModelUtility INSTANCE = new ModelUtility();
    private final LogMessageReceiver logReceiver;
                    
    /**
     * Prevents external creation.
     */
    private ModelUtility() {
        logReceiver = new LogMessageReceiver(getClass(), IvmlBundleId.ID);
    }

    @Override
    protected void initializeAfterResourceInitializer() {
        if (getResourceInitializer().forEclipse()) {
            setInjector(createInjector(new de.uni_hildesheim.sse.IvmlRuntimeModule()));
        } else {
            setInjector(new IvmlStandaloneSetup().createInjectorAndDoEMFRegistration());
        }
    }
    
    @Override
    protected String getLanguageName() {
        return "de.uni_hildesheim.sse.Ivml";
    }

    @Override
    protected ClassLoader getLanguageClassLoader() {
        return ModelUtility.class.getClassLoader();
    }


    /**
     * Create the variability model from an EMF variability unit.
     * 
     * @param root
     *            the root-level variability unit
     * @param uri
     *            the URI of the project to resolve (in order to find the
     *            closest project, may be <b>null</b>)
     * @param registerSuccessful
     *            successfully created models shall be registered
     * @return the created variability model including messages
     */
    public TranslationResult<Project> createVarModel(VariabilityUnit root, java.net.URI uri, 
        boolean registerSuccessful) {
        ModelTranslator translator = new ModelTranslator();
        ImportResolver<Project> impResolver = VarModel.INSTANCE.getResolverFromPool();
        Result mRes = translator.createModel(root, uri, registerSuccessful, impResolver);
        impResolver.addDeferredLoader(mRes);
        VarModel.INSTANCE.releaseResolver(impResolver);
        return mRes.createTranslationResult();
    }

    /**
     * Prints the var model stored in the result to the console output stream
     * (for debugging).
     * 
     * @param result the result instance
     * @param out the output writer
     * @param emitComments whether comments shall be emitted
     * @param emitImports whether imports shall be emitted
     */
    public void print(TranslationResult<Project> result, Writer out, boolean emitComments, boolean emitImports) {
        try {
            ConfigurableIVMLWriter writer = new ConfigurableIVMLWriter(out, emitComments, emitImports);
            for (int p = 0; p < result.getResultCount(); p++) {
                result.getResult(p).accept(writer);
            }
            writer.flush();
        } catch (IOException e) {
        }
    }

    @Override
    public TranslationResult<Project> parse(URI uri, ImportResolver<Project> resolver) throws IOException {
        ImportResolver<Project> impResolver;
        if (null == resolver) {
            impResolver = VarModel.INSTANCE.getResolverFromPool();
        } else {
            impResolver = resolver;
        }
        
        ModelTranslator translator = new ModelTranslator();
        VariabilityUnit root = parse(uri, true, translator, VariabilityUnit.class);
        Result mRes = null;
        try {
            if (null != root) {
                mRes = translator.createModel(root, toNetUri(uri), true, impResolver);
            } else {
                mRes = translator.createEmptyResult(toNetUri(uri));
            }
        } catch (URISyntaxException e) {
            throw new IOException(e);
        }
        impResolver.addDeferredLoader(mRes);
        if (null == resolver) {
            VarModel.INSTANCE.releaseResolver(impResolver);
        }
        return mRes.createTranslationResult();
    }

    /**
     * Obtains project info.
     * 
     * @param uri
     *            the URI to read the info from
     * @return the project info instances related to <code>uri</code>
     * @throws IOException
     *             in case that an I/O error happens during parsing
     */
    public List<ModelInfo<Project>> obtainInfo(URI uri) throws IOException {
        logReceiver.setLocationHint(uri);
        VariabilityUnit root = parse(uri, true, logReceiver, VariabilityUnit.class);
        List<ModelInfo<Project>> result = new ArrayList<ModelInfo<Project>>();
        if (null != root) {
            for (de.uni_hildesheim.sse.ivml.Project project : root
                    .getProjects()) {
                Version version = null;
                VersionStmt versionStatement = project.getVersion();
                String vString;
                if (null == versionStatement) {
                    vString = null;
                } else {
                    vString = versionStatement.getVersion();
                }
                if (null == vString) {
                    version = null;
                } else {
                    try {
                        version = new Version(vString);
                    } catch (VersionFormatException e) {
                    }
                }
                ArrayList<ModelImport<Project>> imp = new ArrayList<ModelImport<Project>>();
                for (ImportStmt importStmt : project.getImports()) {
                    try {
                        imp.add(ImportTranslator.processImport(importStmt));
                    } catch (TranslatorException e) {
                        throw new IOException(e);
                    }
                }
                for (ConflictStmt importStmt : project.getConflicts()) {
                    try {
                        imp.add(ImportTranslator.processConflict(importStmt));
                    } catch (TranslatorException e) {
                        //throw new IOException(e); // do not consider semantic errors here
                    }
                }
                
                try {
                    result.add(new ModelInfo<Project>(project.getName(), version, this, toNetUri(uri), imp));
                } catch (URISyntaxException e) {
                    throw new IOException(e);
                }
            }
        }
        return result;
    }

    /**
     * Returns the string representation of <code>type</code> (no search).
     * 
     * @param type the type to be converted into a string
     * @return the type representation
     */
    public static final String stringValue(Type type) {
        return stringValue(type, false);
    }
    
    /**
     * Returns the string representation of <code>type</code>.
     * 
     * @param type the type to be converted into a string
     * @param forSearch is the result intended for type searching
     * @return the type representation
     */
    public static final String stringValue(Type type, boolean forSearch) {
        String result;
        if (null != type) {
            if (null != type.getDerived()) {
                String op = type.getDerived().getOp();
                if (forSearch) {
                    if (op.equals(IvmlKeyWords.SETOF)) {
                        op = ModelQuery.MQ_SHORT_SET;
                    } else if (op.equals(IvmlKeyWords.SEQUENCEOF)) {
                        op = ModelQuery.MQ_SHORT_SEQUENCE;
                    } else if (op.equals(IvmlKeyWords.REFTO)) {
                        op = ModelQuery.MQ_SHORT_REFERENCE;
                    }
                }
                result = stringValue(type.getDerived(), forSearch);
            } else if (null != type.getType()) {
                result = type.getType().getType();
            } else if (null != type.getId()) {
                result = Utils.getQualifiedNameString(type.getId());
            } else {
                // should not occur
                result = "<unknown type>";
            }
        } else {
            result = ""; // incremental editing
        }
        return result;
    }

    /**
     * Returns the string representation of <code>type</code>.
     * 
     * @param type the type to be converted into a string
     * @param forSearch is the result intended for type searching
     * @return the type representation
     */
    public static final String stringValue(DerivedType type, boolean forSearch) {
        String op = type.getOp();
        if (forSearch) {
            if (op.equals(IvmlKeyWords.SETOF)) {
                op = ModelQuery.MQ_SHORT_SET;
            } else if (op.equals(IvmlKeyWords.SEQUENCEOF)) {
                op = ModelQuery.MQ_SHORT_SEQUENCE;
            } else if (op.equals(IvmlKeyWords.REFTO)) {
                op = ModelQuery.MQ_SHORT_REFERENCE;
            }
        }
        return op + "(" + stringValue(type.getType(), forSearch) + ")";
    }
    
    /**
     * Parses a text into a constraint in the context of <code>project</code>. Project is not modified!
     * 
     * @param text the text to be parsed containing the constraint
     * @param project the project
     * @param asStatement <code>true</code> then parse <code>text</code> as a statement, else as an expression
     * @return the constraint, <b>null</b> in case of internal instantiation errors
     * @throws CSTSemanticException in case of semantic problems in <code>text</code>
     * @throws ConstraintSyntaxException in case of syntax problems in <code>text</code>
     */
    public Constraint createConstraint(String text, Project project, boolean asStatement)
        throws CSTSemanticException, ConstraintSyntaxException {
        Constraint constraint = null;
        String ruleName;
        if (asStatement) {
            ruleName = "ExpressionStatement";
        } else {
            ruleName = "Expression";
        }
        IParseResult result = parseFragment(ruleName, text);
        if (null != result) {
            StringBuilder errors = new StringBuilder();
            for (INode error : result.getSyntaxErrors()) {
                appendWithNewLine(errors, error.getText());
            }
            if (0 == errors.length()) {
                if (null == result.getRootASTElement()) {
                    appendWithNewLine(errors, "empty constraint");
                }
            }
            if (0 == errors.length()) {
                Expression expr;
                ExpressionTranslator translator = new ExpressionTranslator();
                MessageReceiver messageReceiver = translator;
                if (asStatement) {
                    ExpressionStatement stm = (ExpressionStatement) result.getRootASTElement();
                    if (null != stm) {
                        expr = stm.getExpr();
                    } else {
                        expr = null;
                    }
                } else {
                    expr = (Expression) result.getRootASTElement();
                }
                TypeContext context = new TypeContext(project, messageReceiver);
                constraint = new Constraint(project);
                try {
                    constraint.setConsSyntax(translator.processExpression(expr, context, constraint));
                    if (translator.getErrorCount() > 0) {
                        for (int i = 0; i < translator.getMessageCount(); i++) {
                            Message msg = translator.getMessage(i);
                            if (Status.ERROR == msg.getStatus()) {
                                appendWithNewLine(errors, msg.getDescription());
                            }
                        }
                        throw new CSTSemanticException(errors.toString(), CSTSemanticException.INTERNAL);
                    }
                    constraint.getConsSyntax().inferDatatype();
                } catch (TranslatorException e) {
                    throw new CSTSemanticException(e.getMessage(), CSTSemanticException.INTERNAL);
                }
            } else {
                throw new ConstraintSyntaxException(errors.toString());
            }
        } else {
            throw new ConstraintSyntaxException("internal: IVML grammar not available");
        }
        return constraint;
    }

    /**
     * Parses a text into a typed expression in the context of <code>project</code>. Project is not modified!
     * 
     * @param type the target type, may be <b>null</b> the {@link #createExpression(String, IModelElement)} is called
     * @param text the text to be parsed containing the constraint
     * @param parent the intended parent model element (turned into {@link Compound} or {@link Project} 
     *     depending on nesting
     * @return the expression, <b>null</b> in case of internal instantiation errors
     * @throws CSTSemanticException in case of semantic problems in <code>text</code>
     * @throws ConstraintSyntaxException in case of syntax problems in <code>text</code>
     */
    public ConstraintSyntaxTree createExpression(IDatatype type, String text, Project parent) 
        throws CSTSemanticException, ConstraintSyntaxException {
        ConstraintSyntaxTree cst = null;
        if (null == type) {
            cst = createExpression(text, parent);
        } else {
            String expression = text;
            if (TypeQueries.isContainer(type)) {
                expression = "let " + IvmlDatatypeVisitor.getUnqualifiedType(type) + " tmp = " 
                    + expression + " in tmp <> null;";
                cst = createConstraint(expression, parent, true).getConsSyntax();
                if (cst instanceof Let) {
                    cst = ((Let) cst).getInitExpression();
                } else {
                    throw new CSTSemanticException("Cannot construct temporary let expression", 
                        CSTSemanticException.INTERNAL);
                }
            } else {
                if (TypeQueries.isCompound(type) && expression.trim().startsWith("{")) {
                    expression = IvmlDatatypeVisitor.getUnqualifiedType(type) + expression;
                }
                cst = createExpression(expression, parent);
            }
        }
        return cst;
    }

    /**
     * Parses a text into an expression in the context of <code>project</code>. Project is not modified! Containers 
     * typically return an internal {@link EmptyInitializer} as it remains unclear whether the value shall be a set or 
     * a sequence. For creating container and typed compound values, please refer to 
     * {@link #createExpression(IDatatype, String, Project)}.
     * 
     * @param text the text to be parsed containing the constraint
     * @param parent the intended parent model element (turned into {@link Compound} or {@link Project} 
     *     depending on nesting
     * @return the expression, <b>null</b> in case of internal instantiation errors
     * @throws CSTSemanticException in case of semantic problems in <code>text</code>
     * @throws ConstraintSyntaxException in case of syntax problems in <code>text</code>
     */
    public ConstraintSyntaxTree createExpression(String text, IModelElement parent) throws CSTSemanticException, 
        ConstraintSyntaxException {
        ConstraintSyntaxTree expression = null;
        IParseResult result = parseFragment("Expression", text);
        if (null != result) {
            StringBuilder errors = new StringBuilder();
            for (INode error : result.getSyntaxErrors()) {
                appendWithNewLine(errors, error.getText());
            }
            if (0 == errors.length()) {
                if (null == result.getRootASTElement()) {
                    appendWithNewLine(errors, "empty constraint");
                }
            }
            if (0 == errors.length()) {
                ExpressionTranslator translator = new ExpressionTranslator();
                MessageReceiver messageReceiver = translator;
                Expression expr = (Expression) result.getRootASTElement();

                // determine project and containing element within project for expression
                IModelElement expressionParent = null;
                if (parent instanceof AbstractVariable) {
                    IDatatype type = ((AbstractVariable) parent).getType();
                    if (type instanceof IModelElement) {
                        parent = (IModelElement) type;
                    }
                }
                IModelElement iter = parent;
                while (null != iter && !(iter instanceof Project)) {
                    if (iter instanceof Compound) {
                        expressionParent = iter;
                    }
                    iter = iter.getParent();
                }
                Project project = null;
                if (iter instanceof Project) {
                    project = (Project) iter;
                }
                if (null == expressionParent) {
                    expressionParent = null == project ? parent : project;
                }
                TypeContext context = new TypeContext(project, messageReceiver);
                if (expressionParent instanceof Compound) {
                    context.pushLayer(expressionParent);
                    context.addToContext((Compound) expressionParent);
                }
                try {
                    expression = translator.processExpression(expr, context, expressionParent);
                    if (translator.getErrorCount() > 0) {
                        for (int i = 0; i < translator.getMessageCount(); i++) {
                            Message msg = translator.getMessage(i);
                            if (Status.ERROR == msg.getStatus()) {
                                appendWithNewLine(errors, msg.getDescription());
                            }
                        }
                        throw new CSTSemanticException(errors.toString(), CSTSemanticException.INTERNAL);
                    }
                    expression.inferDatatype();
                } catch (TranslatorException e) {
                    throw new CSTSemanticException(e.getMessage(), CSTSemanticException.INTERNAL);
                }
            } else {
                throw new ConstraintSyntaxException(errors.toString());
            }
        } else {
            throw new ConstraintSyntaxException("internal: IVML grammar not available");
        }
        return expression;
    }
    
    @Override
    public String getExtension() {
        return "ivml";
    }

    @Override
    public ModelInfo<Project> getInfo(java.net.URI uri) {
        return VarModel.INSTANCE.availableModels().getInfo(uri);
    }

}
