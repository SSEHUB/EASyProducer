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

import de.uni_hildesheim.sse.buildLanguageTranslation.ExpressionTranslator;
import de.uni_hildesheim.sse.buildLanguageTranslation.ModelTranslator;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vil.expressions.translation.ImportTranslator;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;

/**
 * Provides language-wide functionality.
 * 
 * @author Holger Eichelberger
 */
public class BuildLangModelUtility extends de.uni_hildesheim.sse.dslCore.ModelUtility<ImplementationUnit, Script> 
    implements IModelLoader<Script> {
    
    public static final BuildLangModelUtility INSTANCE = new BuildLangModelUtility();
    
    /**
     * Prevents external creation.
     */
    private BuildLangModelUtility() {
    }
    
    /**
     * Create the build language model from an EMF implementation unit.
     * 
     * @param root the root-level build unit
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @return the created variability model including messages
     */
    public TranslationResult<Script> createBuildModel(ImplementationUnit root, java.net.URI uri, 
        boolean registerSuccessful) {
        ModelTranslator translator = new ModelTranslator();
        return new TranslationResult<Script>(translator.createModel(root, uri, registerSuccessful), translator);
    }

    /**
     * Initializes instances which depend on {@link #resourceInitializer}.
     */
    protected void initializeAfterResourceInitializer() {
        if (getResourceInitializer().forEclipse()) {
            setInjector(createInjector(new de.uni_hildesheim.sse.VilBuildLanguageRuntimeModule()));
        } else {
            setInjector(new VilBuildLanguageStandaloneSetup().createInjectorAndDoEMFRegistration());
        }
    }

    @Override
    public TranslationResult<Script> parse(URI uri) throws IOException {
        ModelTranslator translator = new ModelTranslator();
        ImplementationUnit root = parse(uri, true, translator, ImplementationUnit.class);
        List<Script> result = null;
        if (null != root) {
            try {
                result = translator.createModel(root, toNetUri(uri), true);
            } catch (URISyntaxException e) {
                throw new IOException(e);
            }
        }
        return new TranslationResult<Script>(result, translator);
    }
    
    /**
     * Prints the model stored in the result to the console output stream
     * (for debugging / testing).
     * 
     * @param result the result instance
     * @param out the output writer
     * @param emitComments whether comments shall be emitted
     * @param emitImports whether imports shall be emitted
     */
    public void print(TranslationResult<Script> result, Writer out, boolean emitComments, boolean emitImports) {
        try {
            BuildlangWriter writer = new BuildlangWriter(out);
            for (int p = 0; p < result.getResultCount(); p++) {
                try {
                    result.getResult(p).accept(writer);
                } catch (VilLanguageException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(BuildLangModelUtility.class, VilBundleId.ID);
                }
            }
            writer.flush();
        } catch (IOException e) {
        }
    }
    
    @Override
    protected String getLanguageName() {
        return "de.uni_hildesheim.sse.VilBuildLanguage";
    }

    @Override
    protected ClassLoader getLanguageClassLoader() {
        return BuildLangModelUtility.class.getClassLoader();
    }
    
    /**
     * Parses <code>text</code> into an expression.
     * 
     * @param text the text to be parsed
     * @param environment the runtime environment for resolving variables
     * @return the resulting expression
     * @throws ExpressionException in case that parsing fails
     */
    public Expression createExpression(String text, IRuntimeEnvironment environment) throws ExpressionException {
        Expression result = null;
        IParseResult parseResult = parseFragment("Expression", text);
        if (null != parseResult) {
            StringBuilder errors = new StringBuilder();
            for (INode error : parseResult.getSyntaxErrors()) {
                appendWithNewLine(errors, error.getText());
            }
            if (0 == errors.length()) {
                if (null == parseResult.getRootASTElement()) {
                    appendWithNewLine(errors, "empty expression");
                }
            }
            if (0 == errors.length()) {
                ExpressionTranslator translator = new ExpressionTranslator();
                de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression expr = 
                    (de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression) parseResult.getRootASTElement();
                try {
                    result = translator.processExpression(expr, new Resolver(environment));
                    if (translator.getErrorCount() > 0) {
                        for (int i = 0; i < translator.getMessageCount(); i++) {
                            Message msg = translator.getMessage(i);
                            if (Status.ERROR == msg.getStatus()) {
                                appendWithNewLine(errors, msg.getDescription());
                            }
                        }
                        throw new ExpressionException(errors.toString(), ExpressionException.ID_INTERNAL);
                    }
                } catch (TranslatorException e) {
                    throw new ExpressionException(e, e.getId());
                }
            }
        }
        return result;
    }
    
    /**
     * Returns whether this model utility class handles this type of file.
     * 
     * @param location the location to be considered
     * @return <code>true</code> if it handles the specified location, <code>false</code> else
     */
    @Override
    protected boolean handles(File location) {
        return location.isFile() && location.getName().endsWith(".vil");
    }

    /**
     * Obtains model information.
     * 
     * @param uri
     *            the URI to read the info from
     * @return the project info instances related to <code>uri</code>
     * @throws IOException
     *             in case that an I/O error happens during parsing
     */
    public List<ModelInfo<Script>> obtainInfo(URI uri) throws IOException {
        ImplementationUnit root = parse(uri, true, null, ImplementationUnit.class);
        List<ModelInfo<Script>> result = new ArrayList<ModelInfo<Script>>();
        if (null != root) {
            for (de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit script : root.getScripts()) {
                Version version = ModelTranslator.convert(script.getVersion());
                ArrayList<ModelImport<Script>> imports = new ArrayList<ModelImport<Script>>();
                for (Import imp : script.getImports()) {
                    String name = imp.getName();
                    try {
                        imports.add(new ModelImport<Script>(name, false, 
                            ImportTranslator.processRestrictions(name, imp.getVersionSpec())));
                    } catch (TranslatorException e) {
                        throw new IOException(e);
                    }
                }
                try {
                    result.add(new ModelInfo<Script>(script.getName(), version, this, toNetUri(uri), imports));
                } catch (URISyntaxException e) {
                    throw new IOException(e);
                }
            }
        }
        return result;
    }

}
