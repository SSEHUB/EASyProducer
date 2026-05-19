package net.ssehub.easy.dslCore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.StringInputStream;

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

    protected static final Rule RULE_VERSION = new Rule("version", ";", true, true);
    protected static final Rule RULE_IMPORT = new Rule("import|insert", ";", true, true);
    protected static final Rule RULE_CONFLICT = new Rule("conflict", ";", true, true);

    private static IResourceInitializer resourceInitializer;
    private static List<ModelUtility<?, ?>> instances = 
        Collections.synchronizedList(new ArrayList<ModelUtility<?, ?>>());
    private static final List<ModelUtility<?, ?>> SCHEDULED 
        = Collections.synchronizedList(new ArrayList<ModelUtility<?, ?>>());
    private static boolean forceUnloadOnParse = false;
    
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
        instances.add(this);
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
    
    public static boolean forceUnloadOnParse(boolean force) {
        boolean old = forceUnloadOnParse;
        forceUnloadOnParse = force;
        return old;
    }
    
    public static Iterable<ModelUtility<?, ?>> instances() {
        return instances;
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
    public XtextResourceSet getResourceSet() {
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
    public Injector getInjector() {
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
     * Cutoff parser states.
     * 
     * @author Holger Eichelberger
     */
    private enum ParseState {
        
        CODE(false),
        SLASH(false),
        SL_COMMENT(true),
        ML_COMMENT(true),
        ML_COMMENT_STAR(true),
        STRING(false),
        STRING_ESCAPE(false),
        STRING2(false),
        STRING2_ESCAPE(false);
        
        private boolean isComment;
        
        /**
         * Creates a new value.
         * 
         * @param isComment whether this "constant" represents a comment
         */
        private ParseState(boolean isComment) {
            this.isComment = isComment;
        }

        /**
         * Returns whether this state is a comment state.
         * 
         * @return {@code true} for comment state, {@code false} else
         */
        private boolean isComment() {
            return isComment;
        }
    }

    /**
     * Cutoff parser rule. All rules are matched in sequence until no rule matches. This is the cutoff point.
     * 
     * @author Holger Eichelberger
     */
    protected static class Rule {
        
        private String[] firsts;
        private String[] follows;
        private String[] terminates;
        private boolean optional;
        private boolean multi;
        private boolean includesFollows = true;

        /**
         * Creates a non-optional single-match rule.
         * 
         * @param firsts the leading keywords, may be multiple alternative ones separated by "|"
         * @param follows the follow symbols, may be multiple alternative ones separated by "|", may be <b>null</b> 
         *   to use the following rules
         */
        public Rule(String firsts, String follows) {
            this(firsts, follows, false, false);
        }

        /**
         * Creates a non-optional single-match rule with self-setting follows.
         * 
         * @param firsts the leading keywords, may be multiple alternative ones separated by "|"
         */
        public Rule(String firsts) {
            this(firsts, null);
        }

        /**
         * Creates rule with self-setting follows.
         * 
         * @param firsts the leading keywords, may be multiple alternative ones separated by "|"
         * @param optional is the rule optional
         * @param multi is this a multiple matching rule
         */
        public Rule(String firsts, boolean optional, boolean multi) {
            this(firsts, null, optional, multi);
        }

        /**
         * Creates rule.
         * 
         * @param firsts the leading keywords, may be multiple alternative ones separated by "|"
         * @param follows the follow symbols, may be multiple alternative ones separated by "|", may be <b>null</b> 
         *   to use the following rules
         * @param optional is the rule optional
         * @param multi is this a multiple matching rule
         */
        public Rule(String firsts, String follows, boolean optional, boolean multi) {
            this.firsts = split(firsts);
            setFollows(follows);
            this.optional = optional;
            this.multi = multi;
        }
        
        /**
         * Sets the follow symbols.
         * 
         * @param follows the follow symbols, may be multiple alternative ones separated by "|", may be <b>null</b> 
         *   to use the following rules
         */
        private void setFollows(String follows) {
            this.follows = split(follows);
        }
        
        /**
         * Additional optional terminating terminals. Matches like follows but if one of those, considers as part
         * of the current match.
         * 
         * @param terminates the terminating symbols, may be multiple alternative ones separated by "|", may be 
         *   <b>null</b> for none
         * @return <b>this</b> for chaining
         */
        public Rule terminates(String terminates) {
            this.terminates = split(terminates);
            return this;
        }
        
        /**
         * Splits symbols.
         * 
         * @param symbols the symbols given as single or multiple alternative, separated by "|" or <b>null</b>
         * @return the splitted symbols, <b>null</b> if {@code symbols} was <b>null</b>
         */
        private String[] split(String symbols) {
            String[] result;
            if (null != symbols) {
                result = symbols.split("\\|");
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i].trim();
                }
            } else {
                result = null;
            }
            return result;
        }
        
        /**
         * Does this rule match on the given collected parts.
         * 
         * @param parts the parts
         * @return {@code true} for match, {@code false} else
         */
        private boolean matches(List<String> parts) {
            boolean matches = canMatch(parts);
            if (matches) {
                String last = parts.get(parts.size() - 1);
                matches = matchesFollow(last, follows);
                if (!matches && terminates != null) {
                    matches = matchesFollow(last, terminates);
                }
            }
            return matches;
        }

        /**
         * Returns whether {@code text} starts by one of the {@code firsts}.
         * 
         * @param text the text to match
         * @param firsts the firsts
         * @return {@code true} for match, {@code false} else
         */
        private boolean matchesFirst(String text, String[] firsts) {
            boolean matches = false;
            for (int f = 0; !matches && f < firsts.length; f++) {
                matches = text.startsWith(firsts[f]);
            }
            return matches;
        }

        /**
         * Returns whether {@code text} ends by one of the {@code follows}.
         * 
         * @param text the text to match
         * @param follows the follows
         * @return {@code true} for match, {@code false} else
         */
        private boolean matchesFollow(String text, String[] follows) {
            boolean matches = false;
            for (int f = 0; !matches && f < follows.length; f++) {
                matches = text.endsWith(follows[f]);
            }
            return matches;
        }

        /**
         * Does this rule match at all. Must be consistent with {@link #matches(List)}.
         * 
         * @param parts the parts
         * @return {@code true} for potential match, {@code false} else
         */
        private boolean canMatch(List<String> parts) {
            boolean matches = false;
            if (parts.size() > 0) {
                matches = matchesFirst(parts.get(0), firsts);
            }
            return matches;
        }
        
        /**
         * Is this rule optional?
         * 
         * @return {@code true} for optional, {@code false} else
         */
        private boolean isOptional() {
            return optional;
        }

        /**
         * May this rule match multiple times?
         * 
         * @return {@code true} for multi-match, {@code false} else
         */
        private boolean isMulti() {
            return multi;
        }

        /**
         * Returns {@code rules} or an instantiated rule sequence to be used for matching if {@link #follows}
         * is not defined - then fill it with the firsts of the next rules until a mandatory rule comes up.
         * 
         * @param rules the rules
         * @param copy whether the original array and rules shall be returned or whether a new array with potentially 
         *    the same or instantiated rules shall be returned
         * @return <b>this</b> or an intantiated version
         */
        public static Rule[] instantiate(Rule[] rules, boolean copy) {
            Rule[] result = rules;
            if (copy) {
                result = new Rule[rules.length];
                System.arraycopy(rules, 0, result, 0, result.length);
            }
            // take over or instantiate undefined follows, keep given rules as "templates"
            for (int r = result.length - 1; r >= 0; r--) {
                Rule rule = result[r];
                if (null == rule.follows) {
                    String fws = "";
                    for (int p = r + 1; p < result.length; p++) {
                        Rule r2 = result[p];
                        if (fws.length() > 0) {
                            fws += "|";
                        }
                        fws += String.join("|", r2.firsts);
                        if (!r2.isOptional()) {
                            break;
                        }
                    }
                    if (copy) {
                        result[r] = new Rule(String.join("|", rule.firsts), fws, rule.optional, rule.multi);
                    } else {
                        rule.setFollows(fws);
                    }
                    rule.includesFollows = false;
                }
            }
            return rules;
        }

        /**
         * Shortcut default instantiation of rules.
         * 
         * @param rules the rules to be instantiated
         * @return the instantiated rules
         */
        public static Rule[] instantiate(Rule... rules) {
            return instantiate(rules, false);
        }
        
        /**
         * Clears a matched {@code parts} list.
         * 
         * @param parts the parts to clear
         */
        private void clear(List<String> parts) {
            if (includesFollows) { // matched, clear all
                parts.clear();
            } else { //matched, keep last
                if (parts.size() > 0) {
                    String follow = parts.get(parts.size() - 1);
                    parts.clear();
                    boolean addFollow = true;
                    if (terminates != null) {
                        if (matchesFollow(follow, terminates)) {
                            addFollow = false;
                        }
                    }
                    if (addFollow) {
                        parts.add(follow);
                    }
                }
            }
        }
        
        @Override
        public String toString() {
            String ff = "";
            if (null != terminates) {
                ff = "-> " + Arrays.toString(terminates) + " ";
            }
            return "f: " + Arrays.toString(firsts) + ff + " w: " + Arrays.toString(follows) + " inc: " 
                + includesFollows + " opt: " + optional + " multi: " + multi; 
        }
        
    }
    
    /**
     * Specific "parser" that identifies a position where to cut the headers from the content.
     * 
     * @author Holger Eichelberger
     */
    private static class CutLeadInParser {
        
        private InputStream in;
        private StringBuilder out = new StringBuilder();
        private Rule[] rules;
        private ParseState state = ParseState.CODE;
        private int lastStart = 0;
        private int lastEndMatch = 0;
        private int ruleIndex = 0;
        private List<String> parts = new ArrayList<>();
        private int nestingLevel = 0;
        private int parLevel = 0;
        private boolean emit = true;
        
        /**
         * Creates a parser instance.
         * 
         * @param in the input stream to analyze/cut
         * @param rules the rules
         */
        private CutLeadInParser(InputStream in, Rule... rules) {
            this.in = in;
            this.rules = Rule.instantiate(rules, false);
        }

        /**
         * Handles the state transitions for an escape character.
         * 
         * @param state the actual state
         * @return the next state, may be <code>state</code>
         */
        private ParseState handleEscape(ParseState state) {
            ParseState result = state;
            if (ParseState.STRING_ESCAPE == state) {
                result = ParseState.STRING;
            } else if (ParseState.STRING2_ESCAPE == state) {
                result = ParseState.STRING2;
            }
            return result;
        }
        
        /**
         * Handles the state transitions when a string starts.
         * 
         * @param stringState the state representing the string
         * @param state the actual state
         * @param nextState the next state to become active with the next character
         * @return the next state, may be <code>nextState</code>
         */
        private ParseState handleStringStart(final ParseState stringState, ParseState state, ParseState nextState) {
            ParseState result = nextState;
            if (ParseState.CODE == state) {
                result = stringState;
            } else if (stringState == state) {
                result = ParseState.CODE;
            }
            return result;
        }
        
        /**
         * Handles the state transitions when an asterisk is found.
         * 
         * @param state the actual state
         * @param nextState the next state to become active with the next character
         * @return the next state, may be <code>nextState</code>
         */
        private ParseState handleAsterisk(ParseState state, ParseState nextState) {
            ParseState result = nextState;
            if (ParseState.SLASH == state) {
                result = ParseState.ML_COMMENT;
            } else if (ParseState.ML_COMMENT == state) {
                result = ParseState.ML_COMMENT_STAR;
            }
            return result;
        }

        /**
         * Handles the state transitions when a slash is found.
         * 
         * @param state the actual state
         * @param nextState the next state to become active with the next character
         * @return the next state, may be <code>nextState</code>
         */
        private ParseState handleSlash(ParseState state, ParseState nextState) {
            ParseState result = nextState;
            if (ParseState.CODE == state) {
                result = ParseState.SLASH;
            } else if (ParseState.SLASH == state) {
                result = ParseState.SL_COMMENT;
            } else if (ParseState.ML_COMMENT_STAR == state) {
                result = ParseState.CODE;
                lastStart = out.length();
            }
            return result;
        }

        /**
         * Handles the state transitions when a backslash is found.
         * 
         * @param state the actual state
         * @param nextState the next state to become active with the next character
         * @return the next state, may be <code>nextState</code>
         */
        private ParseState handleBackSlash(ParseState state, ParseState nextState) {
            ParseState result = nextState;
            if (ParseState.STRING == state) {
                result = ParseState.STRING_ESCAPE;
            } else if (ParseState.STRING2 == state) {
                result = ParseState.STRING2_ESCAPE;
            }
            return result;
        }

        /**
         * Parse the text and cut it.
         * 
         * @return the inital or modified text
         * @throws IOException if reading a character fails
         */
        private String parse() throws IOException {
            int data;
            while ((data = in.read()) != -1) {
                char c = (char) data;
                ParseState nextState = handleEscape(state);
                if (nextState == state) { // not changed by handleEscape
                    switch (c) {
                    case '/':
                        nextState = handleSlash(state, nextState);
                        break;
                    case '*':
                        nextState = handleAsterisk(state, nextState);
                        break;
                    case '"':
                        nextState = handleStringStart(ParseState.STRING, state, nextState);
                        break;
                    case '\'':
                        nextState = handleStringStart(ParseState.STRING2, state, nextState);
                        break;
                    case '\n':
                        if (ParseState.SL_COMMENT == state) {
                            nextState = ParseState.CODE;
                        }
                        break;
                    case '\\':
                        nextState = handleBackSlash(state, nextState);
                        break;
                    case '(', '[':
                        if (ParseState.CODE == state) {
                            parLevel++;
                        }
                        break;
                    case ')', ']':
                        if (ParseState.CODE == state) {
                            parLevel--;
                        }
                        break;
                    case '{':
                        if (ParseState.CODE == state || ParseState.SLASH == state) {
                            nestingLevel++;
                        }
                        break;
                    case '}':
                        if (ParseState.CODE == state || ParseState.SLASH == state) {
                            nestingLevel--;
                        }
                        if (nestingLevel == 0 && parLevel == 0) { // reset for next file
                            if (emit && lastEndMatch > 0 && lastEndMatch < out.length() - 1) {
                                out.delete(lastEndMatch, out.length() - 1);
                            }
                            nextState = reset(out.length() + 1); // the }
                        }
                        break;
                    default:
                        break;
                    }
                }
                state = handleOut(c, nextState);
            }
            return out.toString();
        }
        
        /**
         * Resets the parser for a new top-level unit.
         * 
         * @param pos the next position of {@link #lastStart} and {@link #lastEndMatch}.
         * @return the next state
         */
        private ParseState reset(int pos) {
            lastStart = pos; 
            lastEndMatch = pos;
            emit = true;
            ruleIndex = 0;
            parts.clear();
            state = ParseState.CODE;
            return ParseState.CODE;
        }
        
        /**
         * Handles fixing or appending to {@link #out}.
         * 
         * @param ch the actual character
         * @param nextState the next state
         * @return {@code nextState}
         */
        private ParseState handleOut(char ch, ParseState nextState) {
            if (ParseState.SLASH == state && nextState.isComment()) {
                if (emit) { 
                    out.deleteCharAt(out.length() - 1);
                }
            } else if (!state.isComment() && !nextState.isComment()) {
                if (emit) {
                    out.append(ch);
                }
            }
            if (ParseState.CODE == state && enableAnalysis(ch)) {
                analyze();
            }
            return nextState;
        }
        
        /**
         * Enables token/symbol analysis, i.e., are we at a meaningful separator (in CODE).
         * 
         * @param ch the actual character
         * @return {@code true} for enable analysis, {@code false} else
         */
        private boolean enableAnalysis(char ch) {
            boolean enableAnalysis = Character.isWhitespace(ch);
            enableAnalysis |= ch == '{' || ch == '}';
            enableAnalysis |= ch == '(' || ch == ')';
            enableAnalysis &= parLevel == 0;
            return enableAnalysis;
        }
        
        /**
         * Analyze a token/constant/value/keyword.
         */
        private void analyze() {
            if (ParseState.CODE == state || ParseState.SL_COMMENT == state) {
                if (lastStart < out.length()) {
                    String part = out.substring(lastStart).trim();
                    if (part.length() > 0) {
                        parts.add(part);
                        matchRules();
                    }
                    lastStart = out.length();
                }
            }
        }
        
        /**
         * Matches the rules.
         */
        private void matchRules() {
            boolean matched = false;
            boolean foundMatch = false;
            boolean cont;
            do {
                cont = false;
                Rule rule = rules[ruleIndex];
                matched = rule.matches(parts);
                if (matched) {
                    foundMatch = true;
                    rule.clear(parts);
                    if (!rule.isMulti()) {
                        ruleIndex++;
                        break;
                    }
                } else if (parts.size() > 0 && !rule.canMatch(parts)) {
                    // if optional and cannot match, potentially hop over multiple optional rules
                    while (!rule.canMatch(parts) && rule.isOptional()) {
                        ruleIndex++;
                        if (ruleIndex < rules.length) {
                            rule = rules[ruleIndex];
                        } else {
                            break;
                        }
                    }
                    cont = true;
                }
                cont = cont || matched;
            } while (cont && parts.size() > 0 && ruleIndex < rules.length 
                && rules[ruleIndex].isOptional());
            boolean stopped = ruleIndex >= rules.length;
            if (stopped) {
                out.delete(lastEndMatch, out.length());
                emit = false;
            } else if (foundMatch) {
                lastStart = out.length();
                lastEndMatch = lastStart;
            }
        }
        
    }

    /**
     * Cuts the lead-in from the specified grammar text after the first not matching rule, adds a "}".
     * 
     * @param in the input stream to analyze/cut
     * @param rules the rules
     * @return {@code text} or modified
     * @throws IOException if reading characters fails
     */
    public static String cutLeadin(InputStream in, Rule... rules) throws IOException {
        return new CutLeadInParser(in, rules).parse();
    }

    /**
     * Cuts the lead-in from the specified grammar text after the first not matching rule, adds a "}".
     * 
     * @param in the input string to analyze/cut
     * @param rules the rules
     * @return {@code text} or modified
     * @throws IOException if reading characters fails
     */
    public static String cutLeadin(String in, Rule... rules) throws IOException {
        return cutLeadin(new StringInputStream(in), rules);
    }

    /**
     * A bit of testing as we do not have a test bundle.
     * 
     * @param args ignored
     * @throws IOException if file reading fails
     */
    public static void main(String[] args) throws IOException {
        Rule[] rules = {new Rule("project", "{"), RULE_VERSION, RULE_IMPORT, RULE_CONFLICT};
        String o = cutLeadin("project test{ }", rules);
        System.out.println(o);
        o = cutLeadin("project test{ version v1; Integer i = 0;}", rules);
        System.out.println(o);
        o = cutLeadin("project test{ version v1; import base; Integer i = 0;}", rules);
        System.out.println(o);
        o = cutLeadin("project test{ version v1; import base; Integer i = 0;}project test2{ version v1; "
            + "import base; Integer i = 0;}", rules);
        System.out.println(o);
    
        rules = new Rule[]{RULE_IMPORT, new Rule("@advice", true, true), new Rule("project", "{"), RULE_VERSION};
    
        o = cutLeadin("import base; @advice(XYZ) with (ver>0) project test{ Integer i = 0; }", rules);
        System.out.println(o);
    
    }

    /**
     * Parses a grammar fragment.
     * 
     * @param ruleName the name of the grammar rule
     * @param input the text to be parsed
     * @return the parse result if successful, <b>null</b> in case of instantiation problems
     */
    protected IParseResult parseFragment(String ruleName, String input) {
        return parseFragment(ruleName, new StringReader(input));
    }

    /**
     * Parses a grammar fragment.
     * 
     * @param ruleName the name of the grammar rule
     * @param input the text in the reader be parsed
     * @return the parse result if successful, <b>null</b> in case of instantiation problems
     */
    protected IParseResult parseFragment(String ruleName, Reader input) {
        IParseResult result = null;
        Grammar grammar = getGrammar();
        if (null != grammar) {
            AbstractRule rule = GrammarUtil.findRuleForName(grammar, ruleName);
            if (rule instanceof ParserRule) {
                IParser parser = getInjector().getInstance(IParser.class);
                result = parser.parse((ParserRule) rule, input);
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
    
    public static InputStream createInputStream(URI uri) throws IOException {
        InputStream result = null;
        if (uri.isFile()) { // seems to be faster on windows
            File file = new File(uri.toFileString());
            FileChannel fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ);
            result = Channels.newInputStream(fileChannel);
        }
        return null == result ? URIConverter.INSTANCE.createInputStream(uri) : result;
    }

    // checkstyle: stop exception type check

    /**
     * Parses an <code>uri</code> to obtain an instance of the grammar {@code ruleName}. Cuts the first {@code rules} if
     * given, else parses the entire text.
     * 
     * @param uri the URI to read
     * @param ruleName the grammar rule name to start parsing at
     * @param receiver the message receiver used for storing messages (may be <b>null</b>)
     * @param cls the class of the result
     * @param rules optional rules for cutting the header of the contents, removing the remainder for performance
     * @return the top-level element (or <b>null</b> if not found)
     * @throws IOException in case of any I/O and parsing problems
     * @see #cutLeadin(InputStream, Rule...)
     */
    public E parse(URI uri, MessageReceiver receiver, String ruleName, Class<E> cls, Rule... rules) throws IOException {
        E result = null;
        try {
            //System.out.println("- " + uri);        
            //InputStream is = URIConverter.INSTANCE.createInputStream(uri);
            //System.out.println(Files.readStreamIntoString(is));
            //is.close();
            //System.out.println(" ==");        
            InputStream inputStream = createInputStream(uri);
            Reader reader;
            if (rules.length > 0) {
                reader = new StringReader(cutLeadin(inputStream, rules));
                //System.out.println(cutLeadin(createInputStream(uri), rules));        
                //System.out.println("<OUT "+ uri);
            } else {
                reader = new InputStreamReader(inputStream);
            }
            reader = new BufferedReader(reader);
            IParseResult pr = parseFragment(ruleName, reader);
            /*if (pr.hasSyntaxErrors()) {
                System.out.println(cutLeadin(createInputStream(uri), rules));        
                for (INode n : pr.getSyntaxErrors()) {
                    System.out.println(" E " + n.getStartLine()+" "+n.getSyntaxErrorMessage().getMessage());
                }
            }*/
            if ((null == pr || pr.hasSyntaxErrors())) {
                // fallback, may take longer but kicks in if shortcut or fragment parsing fails
                result = parse(uri, true, receiver, cls);
            } else if (null != pr) {
                if (receiver != null && pr.hasSyntaxErrors()) {
                    for (INode en : pr.getSyntaxErrors()) {
                        receiver.error(new XtextSyntaxDiagnostic(en));
                    }
                }
                EObject rootObject = pr.getRootASTElement();
                if (cls.isInstance(rootObject)) {
                    result = cls.cast(rootObject);
                }
            }    
            inputStream.close();
        } catch (Throwable t) { // just in case
            EASyLoggerFactory.INSTANCE.getLogger(ModelUtility.class, BundleId.ID).warn("While loading URI " + uri 
                + ": " + t.getMessage());
            t.printStackTrace(); // preliminary
        }
        return result;
    }

    /**
     * Parses an <code>uri</code> to obtain the top-level element.
     * 
     * @param uri the URI to read
     * @param unload unload the parsed XText resource, may change AST node adapters and keep source positions internal
     * @param receiver the message receiver used for storing messages (may be
     *        <b>null</b>)
     * @param cls the class of the result
     * @return the top-level element (or <b>null</b> if not found)
     * @throws IOException
     *         in case of any I/O and parsing problems
     */
    protected E parse(URI uri, boolean unload, MessageReceiver receiver, Class<E> cls) throws IOException {
        E result = null;
        try {
            ResourceSet resourceSet = getResourceSet();
            Resource resource = resourceSet.getResource(uri, true);
            if (null == resource) {
                resource = resourceSet.createResource(uri);    
            } else {
                resource.unload(); // get rid of adaptors, line numbers etc., they stay otherwise
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
            if (unload || forceUnloadOnParse) {
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

    /**
     * Returns model information from the underlying model repository.
     * 
     * @param uri the URI to return the info for
     * @return the project info instance related to <code>uri</code>, may be <b>null</b> for none
     */
    public abstract ModelInfo<R> getInfo(java.net.URI uri);

    /**
     * Return model information from the underlying model repository.
     * 
     * @param uri the URI to return the info for
     * @return the project info instance related to <code>uri</code>, may be <b>null</b> for none
     * @see #toNetUri(URI)
     * @see #getInfo(java.net.URI)
     */
    public ModelInfo<R> getInfo(URI uri) {
        try {
            return getInfo(toNetUri(uri));
        } catch (URISyntaxException e) {
            return null;
        }
    }
    
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
    
    /**
     * Validates the given resource.
     * 
     * @param resource the resource
     * @param messageHandler message handler (may be on UI level)
     */
    public void validate(Resource resource, Consumer<MessageReceiver> messageHandler) {
        try {
            TranslationResult<R> res = parse(resource.getURI());
            messageHandler.accept(res.getReceiver());
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), BundleId.ID).exception(e);
        }
    }
    
}
