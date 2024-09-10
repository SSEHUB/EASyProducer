package net.ssehub.easy.dslCore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.translation.MessageReceiver;

/**
 * A basic set of model utilities.
 * 
 * Call {@link #setResourceInitializer(IResourceInitializer)} before using this
 * class.
 * 
 * @param <E> the top-level ECore class
 * @param <R> the top-level result model class
 * 
 * @author Holger Eichelberger
 */
public abstract class ModelUtility <E extends EObject, R extends IModel> implements IModelLoader<R> {

    private static IResourceInitializer resourceInitializer;

    private static final List<ModelUtility<?, ?>> SCHEDULED 
        = Collections.synchronizedList(new ArrayList<ModelUtility<?, ?>>());

    /**
     * Stores information about files currently being loaded in order to prevent
     * infinite recursions in case of errors in dependent projects.
     */
    private Map<Thread, Set<String>> beingLoaded = Collections.synchronizedMap(new HashMap<Thread, Set<String>>());
    
    /**
     * Stores the XText resource set. This attribute is initialized in a lazy
     * way in {@link #getResourceSet()}. Therefore, do not use this attribute
     * directly but only through {@link #getResourceSet()}.
     */
    private XtextResourceSet resourceSet;

    private Injector injector;
    
    /**
     * Stores the XText grammar. This attribute is initialized in a lazy
     * fashion in {@link #getGrammar()}. Therefore, do not use this attribute
     * directly but only through {@link #getGrammar()}.
     */
    private Grammar grammar;

    /**
     * Creates an instance and causes the creation of the injector or
     * schedules the creation.
     */
    protected ModelUtility() {
        if (null != resourceInitializer) {
            initializeAfterResourceInitializer();
        } else {
            SCHEDULED.add(this);
        }
    }
    
    static {
        EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(ModelUtility.class, BundleId.ID);
        // Eclipse 2024-06, seems to conflict with xText operations and blocks startup
        /*if (Environment.runsInEclipse()) { 
            logger.info("Setting up Eclipse resource initializer");
            resourceInitializer = new EclipseResourceInitializer();
        } else {*/
        logger.info("Setting up Standalone resource initializer");
        resourceInitializer = new StandaloneInitializer();
        //}
    }
    
    /**
     * Defines the resource initializer.
     * 
     * @param initializer
     *            the initializer
     */
    public static void setResourceInitializer(IResourceInitializer initializer) {
        resourceInitializer = initializer;
        if (null != resourceInitializer) {
            for (int i = 0; i < SCHEDULED.size(); i++) {
                SCHEDULED.get(i).initializeAfterResourceInitializer();
            }
            SCHEDULED.clear();
        }
    }
    
    /**
     * Initializes instances which depend on {@link #resourceInitializer}.
     */
    protected abstract void initializeAfterResourceInitializer();

    /**
     * Returns the actual resource initializer.
     * 
     * @return the actual resource initializer
     */
    public static IResourceInitializer getResourceInitializer() {
        return resourceInitializer;
    }
    
    /**
     * Converts an Eclipse URI to a <i>java.net.URI</i>.
     * 
     * @param uri
     *            the URI to convert
     * @return the converted URI
     * @throws URISyntaxException
     *             in case of URI syntax errors
     */
    public static final java.net.URI toNetUri(URI uri) throws URISyntaxException {
        java.net.URI result = null;
        if (null != resourceInitializer) {
            result = resourceInitializer.toNetUri(uri);
        }
        return result;
    }

    // http://www.eclipse.org/forums/index.php/mv/msg/238661/724788/
    // http://www.eclipse.org/forums/index.php/m/754759/
    // http://zarnekow.blogspot.de/2010/06/how-to-deploy-xtext-standalone.html
    // http://www.vorburger.ch/blog1/2009/08/xtext-standalone-setup-parsing-dsl-from.html

    /**
     * Returns the XText resource set (and performs a lazy initialization of 
     * {@link #resourceSet} if required).
     * 
     * @return the resource set
     */
    protected XtextResourceSet getResourceSet() {
        if (null == resourceSet) {
            resourceSet = getResourceInitializer().createResourceSet(getInjector());
        }
        return resourceSet;
    }
    
    /**
     * Returns the injector for this language / environment.
     * 
     * @return the injector
     */
    protected Injector getInjector() {
        return injector;
    }

    /**
     * Defines the injector for this language / environment.
     * 
     * @param injector the injector instance
     */
    protected void setInjector(Injector injector) {
        this.injector = injector;
    }
    
    /**
     * Parse an IVML model file for standalone application (without editor) with a new default import resolver.
     * 
     * @param file the location of the model
     * @return the created variability model including messages
     * @throws IOException in case of IO problems
     */
    public TranslationResult<R> parse(File file) throws IOException {
        if (file.exists()) {
            URI uri = URI.createFileURI(file.getAbsolutePath());
            return parse(uri);
        } else {
            throw new FileNotFoundException(file.toString());
        }
    }
    
    /**
     * Parse an IVML model file for standalone application (without editor) with a new default import resolver.
     * 
     * @param uri the location of the model, e.g. via
     *            URI.createURI("dummy:/example.ex1")
     * @return the created variability model including messages
     * @throws IOException
     *             in case of any I/O or URI problem
     */
    public TranslationResult<R> parse(URI uri) throws IOException {
        return parse(uri, null);
    }

    /**
     * Parse an IVML model file for standalone application (without editor) with a given import resolver.
     * 
     * @param uri the location of the model, e.g. via
     *            URI.createURI("dummy:/example.ex1")
     * @param resolver the import resolver (may be <b>null</b> for a new default import resolver)
     * @return the created variability model including messages
     * @throws IOException
     *             in case of any I/O or URI problem
     */
    public abstract TranslationResult<R> parse(URI uri, ImportResolver<R> resolver) throws IOException;

    /**
     * Returns the object representation of the actual grammar (and performs a lazy 
     * initialization of {@link #grammar} or {@link #resourceSet} if required).
     * 
     * @return the grammar
     */
    protected Grammar getGrammar() {
        if (null == grammar) {
            // the "official" way of getting the grammar is using the GrammarProvider
            // via the injector. However, this uses the wrong resource set so we
            // repeat this code here. Check, whether we shall replace the instance of 
            // the resource set in the injector...
            XtextResourceSet resourceSet = getResourceSet();
            XtextPackage.eINSTANCE.getClass();
            synchronized (ModelUtility.class) { // started with if (null == grammar)
                resourceSet.setClasspathURIContext(getLanguageClassLoader());
                grammar = (Grammar) BaseEPackageAccess.loadGrammarFile(
                    ClasspathUriUtil.CLASSPATH_SCHEME + ":/" + getLanguageName().replace('.', '/') + ".xtextbin",
                    resourceSet);
            }
        }
        return grammar;
    }
    
    /**
     * Returns the language name as specified in the xText configuration. This name can be found
     * as URL in the grammar file or corresponds to the Java path of the grammar-XMI file in 
     * src-gen.
     * 
     * @return the language name in Java package notation
     */
    protected abstract String getLanguageName();
    
    /**
     * Returns the actual class loader of the language. This loader may be different
     * due to different bundles.
     * 
     * @return the class loader
     */
    protected abstract ClassLoader getLanguageClassLoader();
    
    /**
     * Parses a grammar fragment.
     * 
     * @param ruleName the name of the grammar rule
     * @param input the text to be parsed
     * @return the parse result if successful, <b>null</b> in case of instantiation problems
     */
    protected IParseResult parseFragment(String ruleName, String input) {
        IParseResult result = null;
        Grammar grammar = getGrammar();
        if (null != grammar) {
            AbstractRule rule = GrammarUtil.findRuleForName(grammar, ruleName);
            if (rule instanceof ParserRule) {
                IParser parser = getInjector().getInstance(IParser.class);
                result = parser.parse((ParserRule) rule, new StringReader(input));
            }
        }
        return result;
    }

    /**
     * Appends a <code>text</code> to <code>builder</code> and inserts <code>separator</code>
     * before if <code>text</code> is not empty.
     * 
     * @param builder the builder to append to
     * @param text the text to append
     * @param separator the separator to be considered
     * @return <code>builder</code>
     */
    public static StringBuilder append(StringBuilder builder, String text, String separator) {
        if (builder.length() > 0) {
            builder.append(separator);
        }
        builder.append(text);
        return builder;
    }

    /**
     * Appends a <code>text</code> to <code>builder</code> and inserts a new line
     * before if <code>text</code> is not empty.
     * 
     * @param builder the builder to append to
     * @param text the text to append
     * @return <code>builder</code>
     */
    public static StringBuilder appendWithNewLine(StringBuilder builder, String text) {
        return append(builder, text, "\n");
    }
    
    // checkstyle: stop exception type check

    /**
     * Parses an <code>uri</code> to obtain the top-level element.
     * 
     * @param uri the URI to read
     * @param unload unload the parsed XText resource
     * @param receiver the message receiver used for storing messages (may be
     *        <b>null</b>)
     * @param cls the class of the result
     * @return the top-level element (or <b>null</b> if not found)
     * @throws IOException
     *         in case of any I/O and parsing problems
     */
    protected E parse(URI uri, boolean unload,
        MessageReceiver receiver, Class<E> cls) throws IOException {
        E result = null;
        try {
            ResourceSet resourceSet = getResourceSet();
            Resource resource = resourceSet.getResource(uri, true);
            if (null == resource) {
                resource = resourceSet.createResource(uri);    
            }
            resource.load(null);
            if (resource.isLoaded()) {
                boolean hasErrors = false;
                for (Diagnostic diag : resource.getErrors()) {
                    if (null != receiver) {
                        receiver.error(diag);
                    }
                    hasErrors = true;
                }
                
                EObject rootObject = null;
                if (!hasErrors) {
                    rootObject = resource.getContents().get(0);
                }
                if (cls.isInstance(rootObject)) {
                    result = cls.cast(rootObject);
                }
            } else {
                throw new IOException("resource for uri '" + uri + "' not loaded");
            }
            if (unload) {
                resource.unload();
            }
        } catch (Throwable t) { // resources may throw ConcurrentModificationExceptions
            EASyLoggerFactory.INSTANCE.getLogger(ModelUtility.class, BundleId.ID).warn("While loading resource " + uri 
                + ": " + t.getMessage());
            t.printStackTrace(); // preliminary
        }
        return result;
    }

    // checkstyle: resume exception type check

    /**
     * Returns whether this model utility class handles this type of file.
     * 
     * @param location the location to be considered
     * @return <code>true</code> if it handles the specified location, <code>false</code> else
     * @see #getExtension()
     */
    protected boolean handles(File location) {
        return location.isFile() && location.getName().endsWith("." + getExtension());        
    }

    @Override
    public void scan(File location, IModelInfoHolder<R> holder) {
        if (handles(location)) {
            if (!holder.isKnown(location.toURI(), this)) {
                try {
                    List<ModelInfo<R>> info = obtainInfo(location);
                    if (null != info) {
                        for (int i = 0; i < info.size(); i++) {
                            holder.addResult(info.get(i));
                        }
                    }
                } catch (IOException e) {
                    holder.error(e.getMessage());
                }
            } 
        }
    }
    
    /**
     * Obtains project info.
     * 
     * @param file
     *            the file to read the info from
     * @return the project info instances related to <code>file</code>
     * @throws IOException
     *             in case that an I/O error happens during parsing
     */
    public List<ModelInfo<R>> obtainInfo(File file) throws IOException {
        if (file.exists()) {
            URI uri = URI.createFileURI(file.getAbsolutePath());
            return obtainInfo(uri);
        } else {
            throw new FileNotFoundException(file.toString());
        }
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
    public abstract List<ModelInfo<R>> obtainInfo(URI uri) throws IOException;
    
    @Override
    public net.ssehub.easy.basics.modelManagement.IModelLoader.LoadResult<R> load(ModelInfo<R> info, 
        ImportResolver<R> resolver) {
        List<R> models = null;
        List<IMessage> messages = null;
        if (null != info) {
            String location = info.getLocation().toString();
            Thread currentThread = Thread.currentThread();
            Set<String> beingLoadedInThread = beingLoaded.get(currentThread);
            if (null == beingLoadedInThread) {
                beingLoadedInThread = new HashSet<String>();
                beingLoaded.put(currentThread, beingLoadedInThread);
            }
            if (!beingLoadedInThread.contains(location)) {
                beingLoadedInThread.add(location);
                try {
                    TranslationResult<R> parseResult = parse(URI.createURI(location), resolver);
                    models = parseResult.getResultsList();
                    messages = parseResult.getMessageList();
                } catch (IOException e) {
                    if (null == messages) {
                        messages = new ArrayList<IMessage>();
                        messages.add(new net.ssehub.easy.basics.messages.Message(e.getMessage(), Status.ERROR));
                    }
                }
                beingLoadedInThread.remove(location);
            }
        }
        return new LoadResult<R>(models, messages);
    }
    
    /**
     * Returns the file extension / identifier to react on.
     * 
     * @return the extension
     */
    public abstract String getExtension();
    
}
