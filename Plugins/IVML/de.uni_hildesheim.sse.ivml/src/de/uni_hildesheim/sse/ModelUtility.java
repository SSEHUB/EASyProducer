package de.uni_hildesheim.sse;

import static com.google.inject.Guice.createInjector;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;

import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.dslCore.translation.MessageReceiver;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.ivml.ConflictStmt;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ExpressionStatement;
import de.uni_hildesheim.sse.ivml.ImportStmt;
import de.uni_hildesheim.sse.ivml.Type;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import de.uni_hildesheim.sse.ivml.VersionStmt;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.ConfigurableIVMLWriter;
import de.uni_hildesheim.sse.translation.ExpressionTranslator;
import de.uni_hildesheim.sse.translation.ImportTranslator;
import de.uni_hildesheim.sse.translation.ModelTranslator;
import de.uni_hildesheim.sse.translation.TypeContext;
import de.uni_hildesheim.sse.translation.Utils;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * (Entry points for) Utilities for working with the EMF model.
 * 
 * @author Holger Eichelberger
 */
public class ModelUtility extends de.uni_hildesheim.sse.dslCore.ModelUtility<VariabilityUnit, Project> 
    implements IModelLoader<Project> {

    public static final ModelUtility INSTANCE = new ModelUtility();
    
    /**
     * Prevents external creation.
     */
    private ModelUtility() {
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
        return new TranslationResult<Project>(translator.createModel(root, uri, registerSuccessful), translator);
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
    public TranslationResult<Project> parse(URI uri) throws IOException {
        ModelTranslator translator = new ModelTranslator();
        VariabilityUnit root = parse(uri, true, translator, VariabilityUnit.class);
        List<Project> result = null;
        if (null != root) {
            try {
                result = translator.createModel(root, toNetUri(uri), true);
            } catch (URISyntaxException e) {
                throw new IOException(e);
            }
        }
        return new TranslationResult<Project>(result, translator);
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
        VariabilityUnit root = parse(uri, true, null, VariabilityUnit.class);
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
                        throw new IOException(e);
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
     * Returns the string representation of <code>type</code>.
     * 
     * @param type
     *            the type to be converted into a string
     * @return the type representation
     */
    public static final String stringValue(Type type) {
        String result;
        if (null != type) {
            if (null != type.getDerived()) {
                result = type.getDerived().getOp() + "("
                        + stringValue(type.getDerived().getType()) + ")";
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
                    expr = ((ExpressionStatement) result.getRootASTElement()).getExpr();
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
     * Returns whether this model utility class handles this type of file.
     * 
     * @param location the location to be considered
     * @return <code>true</code> if it handles the specified location, <code>false</code> else
     */
    @Override
    protected boolean handles(File location) {
        return location.isFile() && location.getName().endsWith(".ivml");
    }

}
