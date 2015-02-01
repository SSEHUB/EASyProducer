package de.uni_hildesheim.sse.vil.templatelang;

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
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangWriter;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;
import de.uni_hildesheim.sse.vil.templatelang.templateLanguageTranslation.ExpressionTranslator;
import de.uni_hildesheim.sse.vil.templatelang.templateLanguageTranslation.ModelTranslator;

/**
 * Provides language-wide functionality.
 * 
 * @author Holger Eichelberger
 */
public class TemplateLangModelUtility extends de.uni_hildesheim.sse.dslCore.ModelUtility <LanguageUnit, Template>
    implements IModelLoader<Template> {
    
    public static final TemplateLangModelUtility INSTANCE = new TemplateLangModelUtility();
    
    /**
     * Prevents external creation.
     */
    private TemplateLangModelUtility() {
    }
    
    /**
     * Initializes instances which depend on {@link #resourceInitializer}.
     */
    protected void initializeAfterResourceInitializer() {
        if (getResourceInitializer().forEclipse()) {
            setInjector(createInjector(new de.uni_hildesheim.sse.vil.templatelang.TemplateLangRuntimeModule()));
        } else {
            setInjector(new TemplateLangStandaloneSetup().createInjectorAndDoEMFRegistration());
        }
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
    public TranslationResult<Template> createModel(LanguageUnit root, java.net.URI uri, 
        boolean registerSuccessful) {
        ModelTranslator translator = new ModelTranslator();
        List<Template> result = new ArrayList<Template>();
        result.add(translator.createModel(root, uri, registerSuccessful));
        return new TranslationResult<Template>(result , translator);
    }

    
    @Override
    public TranslationResult<Template> parse(URI uri) throws IOException {
        ModelTranslator translator = new ModelTranslator();
        LanguageUnit root = parse(uri, true, translator, LanguageUnit.class);
        List<Template> result = null;
        if (null != root) {
            try {
                result = new ArrayList<Template>();
                Template tpl = translator.createModel(root, toNetUri(uri), true);
                if (null != tpl) {
                    result.add(tpl);
                }
            } catch (URISyntaxException e) {
                throw new IOException(e);
            }
        }
        return new TranslationResult<Template>(result, translator);
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
    public void print(TranslationResult<Template> result, Writer out, boolean emitComments, boolean emitImports) {
        try {
            TemplateLangWriter writer = new TemplateLangWriter(out);
            for (int p = 0; p < result.getResultCount(); p++) {
                try {
                    result.getResult(p).accept(writer);
                } catch (VilLanguageException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(TemplateLangModelUtility.class, VtlBundleId.ID);
                }
            }
            writer.flush();
        } catch (IOException e) {
        }
    }
    
    @Override
    protected String getLanguageName() {
        return "de.uni_hildesheim.sse.vil.templatelang.TemplateLang";
    }

    @Override
    protected ClassLoader getLanguageClassLoader() {
        return TemplateLangModelUtility.class.getClassLoader();
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
        return location.isFile() && location.getName().endsWith(".vtl");
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
    public List<ModelInfo<Template>> obtainInfo(URI uri) throws IOException {
        LanguageUnit template = parse(uri, true, null, LanguageUnit.class);
        List<ModelInfo<Template>> result = new ArrayList<ModelInfo<Template>>();
        if (null != template) {
            Version version = ModelTranslator.convert(template.getVersion());
            ArrayList<ModelImport<Template>> imports = new ArrayList<ModelImport<Template>>();
            for (Import imp : template.getImports()) {
                String name = imp.getName();
                imports.add(new ModelImport<Template>(name, false, null));
            }
            try {
                result.add(new ModelInfo<Template>(template.getName(), version, this, toNetUri(uri), imports));
            } catch (URISyntaxException e) {
                throw new IOException(e);
            }
        }
        return result;
    }

}
