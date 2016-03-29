package de.uni_hildesheim.sse.vil.rt;

import static com.google.inject.Guice.createInjector;

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
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.RtVilWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression;
import de.uni_hildesheim.sse.vil.rt.rtLanguageTranslation.ExpressionTranslator;
import de.uni_hildesheim.sse.vil.rt.rtLanguageTranslation.ModelTranslator;
import de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;

/**
 * Provides language-wide functionality.
 * 
 * @author Holger Eichelberger
 */
public class RtVilModelUtility extends de.uni_hildesheim.sse.dslCore.ModelUtility<ImplementationUnit, Script> 
    implements IModelLoader<Script> {
    
    public static final RtVilModelUtility INSTANCE = new RtVilModelUtility();
    
    /**
     * Prevents external creation.
     */
    private RtVilModelUtility() {
    }
    
    /**
     * Create the rt-VIL language model from an EMF implementation unit.
     * 
     * @param root the root-level build unit
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @return the created variability model including messages
     */
    public TranslationResult<Script> createRtModel(ImplementationUnit root, java.net.URI uri, 
        boolean registerSuccessful) {
        ModelTranslator translator = new ModelTranslator();
        return new TranslationResult<Script>(translator.createModel(root, uri, registerSuccessful, null), translator);
    }

    /**
     * Initializes instances which depend on {@link #resourceInitializer}.
     */
    protected void initializeAfterResourceInitializer() {
        if (getResourceInitializer().forEclipse()) {
            setInjector(createInjector(new de.uni_hildesheim.sse.VilBuildLanguageRuntimeModule()));
        } else {
            setInjector(new RtVilStandaloneSetup().createInjectorAndDoEMFRegistration());
        }
    }

    @Override
    public TranslationResult<Script> parse(URI uri, ImportResolver<Script> resolver) throws IOException {
        ModelTranslator translator = new ModelTranslator();
        ImplementationUnit root = parse(uri, true, translator, ImplementationUnit.class);
        List<Script> result = null;
        if (null != root) {
            try {
                result = translator.createModel(root, toNetUri(uri), true, resolver);
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
            RtVilWriter writer = new RtVilWriter(out);
            for (int p = 0; p < result.getResultCount(); p++) {
                try {
                    result.getResult(p).accept(writer);
                } catch (VilException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(RtVilModelUtility.class, RtVilBundleId.ID);
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
        return RtVilModelUtility.class.getClassLoader();
    }
    
    /**
     * Parses <code>text</code> into an expression.
     * 
     * @param text the text to be parsed
     * @param environment the runtime environment for resolving variables
     * @return the resulting expression
     * @throws VilException in case that parsing fails
     */
    public Expression createExpression(String text, IRuntimeEnvironment environment) throws VilException {
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
                        throw new VilException(errors.toString(), VilException.ID_INTERNAL);
                    }
                } catch (TranslatorException e) {
                    throw new VilException(e, e.getId());
                }
            }
        }
        return result;
    }

    /**
     * Parses <code>text</code> into a primary expression.
     * 
     * @param text the text to be parsed
     * @param environment the runtime environment for resolving variables
     * @return the resulting expression
     * @throws VilException in case that parsing fails
     */
    public Expression createPrimaryExpression(String text, IRuntimeEnvironment environment) throws VilException {
        Expression result = null;
        IParseResult parseResult = parseFragment("PrimaryExpression", text);
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
                PrimaryExpression expr = (PrimaryExpression) parseResult.getRootASTElement();
                try {
                    result = translator.processPrimaryExpression(expr, new Resolver(environment));
                    if (translator.getErrorCount() > 0) {
                        for (int i = 0; i < translator.getMessageCount(); i++) {
                            Message msg = translator.getMessage(i);
                            if (Status.ERROR == msg.getStatus()) {
                                appendWithNewLine(errors, msg.getDescription());
                            }
                        }
                        throw new VilException(errors.toString(), VilException.ID_INTERNAL);
                    }
                } catch (TranslatorException e) {
                    throw new VilException(e, e.getId());
                }
            }
        }
        return result;
    }
    
    
    @Override
    public String getExtension() {
        return "rtvil";
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
                    imports.add(new ModelImport<Script>(name, false, null));
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
