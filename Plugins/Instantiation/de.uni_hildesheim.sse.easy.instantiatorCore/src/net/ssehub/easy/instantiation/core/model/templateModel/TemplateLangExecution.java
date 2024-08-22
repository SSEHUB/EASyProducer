package net.ssehub.easy.instantiation.core.model.templateModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.AvailableModels;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactTypes;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.Compound;
import net.ssehub.easy.instantiation.core.model.common.ExecutionVisitor;
import net.ssehub.easy.instantiation.core.model.common.IResolvableModel;
import net.ssehub.easy.instantiation.core.model.common.ITerminatable;
import net.ssehub.easy.instantiation.core.model.common.ModelCallExpression;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.AbstractCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.ConstantExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionParser;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.StringReplacer;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentStatement.LineEndType;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry.ILanguage;
import net.ssehub.easy.instantiation.core.model.expressions.IArgumentProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypedModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.PseudoString;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlElement;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.NullValue;

/**
 * Implements the execution of the template language.
 * 
 * @author Holger Eichelberger
 */
public class TemplateLangExecution extends ExecutionVisitor<Template, Def, VariableDeclaration, Resolver> 
    implements ITemplateLangVisitor, ITerminatable {

    public static final ILanguage<Resolver> LANGUAGE = new ILanguage<Resolver>() {

        @Override
        public String getName() {
            return "VTL";
        }
        
    };
    
    /**
     * The name of the default main template (called {@value}).
     */
    public static final String DEFAULT_MAIN_TEMPLATE = "main";
    
    /**
     * Denotes the default name of the configuration parameter (may be overwritten by user values).
     */
    public static final String PARAM_CONFIG = "config";
    
    /**
     * Denotes the default name of the target artifact parameter (may be overwritten by user values).
     */
    public static final String PARAM_TARGET = "target";

    /**
     * Denotes a prefix for internal parameter which must be set in addition.
     */
    public static final String INTERNAL_PARAM_PREFIX = "$$";
    
    /**
     * Denotes the default name of the configuration parameter always containing the source configuration.
     */
    public static final String PARAM_CONFIG_SURE = INTERNAL_PARAM_PREFIX + PARAM_CONFIG;
    
    /**
     * Denotes the default name of the target artifact parameter always containing the target artifact.
     */
    public static final String PARAM_TARGET_SURE = INTERNAL_PARAM_PREFIX + PARAM_TARGET;

    private static final List<JavaExtension> DEFAULT_EXTENSIONS = new ArrayList<JavaExtension>();
    private static final String EMPTY_CONTENT = PseudoString.EMPTY_CONTENT;
    
    private RuntimeEnvironment environment;
    private Writer mainOut;
    private PrintWriter out;
    private String mainName;
    private ITracer tracer;
    private boolean stop = false;
    private int contentNestingLevel;
    private int lastContentNestingLevel = -1;
    private boolean lastContentFormatted = false;
    private Stack<String> defContentStack = new Stack<String>();
    private ContentStatement lastContent = null;
    private LineEndType lastContentLineEndType = LineEndType.DEFAULT;
    private ContentFormatter contentFormatter;

    /**
     * Creates a new evaluation visitor.
     * 
     * @param tracer the tracer instance for testing
     * @param out where to put the output to
     * @param parameter the top-level parameter for the script to be executed
     */
    public TemplateLangExecution(ITracer tracer, Writer out, Map<String, Object> parameter) {
        this(tracer, out, DEFAULT_MAIN_TEMPLATE, parameter);
    }
    
    /**
     * Creates a new evaluation visitor.
     * 
     * @param tracer the tracer instance for testing
     * @param out where to put the output to
     * @param mainName the name of the sub-template to be executed
     * @param parameter the top-level parameter for the script to be executed
     */
    public TemplateLangExecution(ITracer tracer, Writer out, String mainName, Map<String, Object> parameter) {
        super(new RuntimeEnvironment(), tracer, parameter);
        this.environment = (RuntimeEnvironment) getRuntimeEnvironment();
        this.mainOut = out;
        this.out = new PrintWriter(out);
        this.mainName = mainName;
        this.tracer = tracer;
        enableArtifactAutoStoreOnParameters(false);
    }
    
    /**
     * Creates a new execution visitor for import expression evaluation.
     * 
     * @param environment the runtime environment to be used for expression evaluation
     */
    TemplateLangExecution(RuntimeEnvironment environment) {
        super(environment, NoTracer.INSTANCE, new HashMap<String, Object>());
        this.environment = environment;
        this.out = new PrintWriter(new Writer() {

            @Override
            public void close() throws IOException {
            }

            @Override
            public void flush() throws IOException {
            }

            @Override
            public void write(char[] arg0, int arg1, int arg2) throws IOException {
            }
            
        });
        this.mainName = DEFAULT_MAIN_TEMPLATE;
        this.tracer = NoTracer.INSTANCE;
    }

    @Override
    public void release(boolean releaseDefault) {
        enableArtifactAutoStoreOnParameters(true);
        super.release(releaseDefault);
    }
    
    /**
     * Register a default Java extension.
     * 
     * @param extension the extension to be registered
     */
    public static void registerDefaultExtension(Class<?> extension) {
        if (null != extension) {
            EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(TemplateLangExecution.class, Bundle.ID);
            try {
                DEFAULT_EXTENSIONS.add(new JavaExtension(extension, TypeRegistry.DEFAULT));
                logger.info("registered default VTL extension " + extension.getName());
            } catch (VilException e) {
                logger.exception(e);
            }
        }
    }
    
    /**
     * Returns the number of default extensions.
     * 
     * @return the number of default extensions
     */
    public static int getDefaultExtensionCount() {
        return DEFAULT_EXTENSIONS.size();
    }
    
    /**
     * Returns the specified default extension.
     * 
     * @param index the 0-based index of the default extension
     * @return the default extension
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getDefaultExtensionCount()}</code>
     */
    public static JavaExtension getDefaultExtension(int index) {
        return DEFAULT_EXTENSIONS.get(index);
    }
    
    @Override
    public Object visitTemplate(Template template) throws VilException {
        environment.switchContext(template); // initial context, assumption that method is only called from outside
        tracer.visitTemplate(template);
        visitModelHeader(template);
        contentFormatter = new ContentFormatter();
        contentFormatter.setFormattingConfiguration(getFormattingConfiguration());
        contentFormatter.setIndentationConfiguration(environment.getIndentationConfiguration());
        Def main = null;
        for (int d = 0; null == main && d < template.getDefCount(); d++) {
            Def def = template.getDef(d);
            if (def.getName().equals(mainName)) {
                if (template.getParameterCount() == def.getParameterCount()) {
                    main = def;
                    for (int p = 0; null != main && p < template.getParameterCount(); p++) {
                        if (!template.getParameter(p).getType().isAssignableFrom(def.getParameter(p).getType())) {
                            main = null;
                        }
                    }
                }
            }
        }
        if (null == main) {
            throw new VilException("no '" + mainName + "' template found with suitable parameters", 
                VilException.ID_RUNTIME_STARTRULE);
        }
        Object result = executeMain(template, main);
        tracer.visitedTemplate(template);
        return result;
    }

    @Override
    public Object visitDef(Def def) throws VilException {
        defContentStack.push("");
        Object result;
        if (def.isPlaceholder()) {
            result = null;
        } else {
            tracer.visitDef(def, environment);
            result = visitTemplateBlock(def); // increases indentation
            // if top-level, print last line ending by default else not
            if (null != lastContent && lastContent.needsLineEnd(0 == contentNestingLevel)) { 
                appendContent(getLineEnd());
            }
            lastContent = null; // handled, reset
            tracer.visitedDef(def, environment, result);
        }
        String content = defContentStack.pop();
        if (0 == contentNestingLevel) { // top level - compose or emit
            if (defContentStack.isEmpty()) {
                emit(content);
            } else {
                appendContent(content);
            }
        } // nested content mode - composed from return
        return result;
    }
    
    /**
     * Emits the content, takes care of the formatting configuration.
     * 
     * @param content the content to emit
     */
    private void emit(String content) {
        if (null != contentFormatter) {
            content = contentFormatter.format(content);
        }
        if (null != content) {
            out.print(content);
        }
    }

    /**
     * Increases the current indentation level depending on the
     * specified <code>element</code>. This information is required for
     * content formatting.
     * 
     * @param element the element to be considered
     */
    private void increaseIndentation(ITemplateElement element) {
        if (!element.isBlock()) {
            environment.increaseIndentation();
        }
    }

    /**
     * Decreases the current indentation level depending on the
     * specified <code>element</code>. This information is required for
     * content formatting.
     * 
     * @param element the element to be considered
     */
    private void decreaseIndentation(ITemplateElement element) {
        if (!element.isBlock()) {
            environment.decreaseIndentation();
        }
    }

    @Override
    public Object visitTemplateBlock(TemplateBlock block) throws VilException {
        boolean ok = true;
        boolean returns = !TypeRegistry.voidType().isSame(block.inferType());
        Object value = null;
        Object lastValue = null;
        environment.increaseIndentation();
        int count = block.getBodyElementCount();
        for (int e = 0; ok && !stop && e < count; e++) {
            ITemplateElement elt = block.getBodyElement(e);
            value = elt.accept(this);
            if (elt.isLoop() && elt.endsWithContentStatement() && value == EMPTY_CONTENT 
                && lastValue instanceof String ) {
                // loop does not append, "eats up" result
                value = lastValue;
            }
            if ((!returns || (returns && e + 1 < count)) && mayFail(elt)) {
                ok = checkConditionResult(value, block, ConditionTest.DONT_CARE);
            }
            if (!ok) {
                tracer.failedAt(block.getBodyElement(e));
                value = null;
            }
            lastValue = value;
        }
        environment.decreaseIndentation();
        return value;
    }

    @Override
    public Object visitAlternative(AlternativeStatement alternative) throws VilException {
        Object value = null;
        Expression cond = alternative.getCondition();
        Object condValue = cond.accept(this);
        if (checkConditionResult(condValue, cond, ConditionTest.DONT_CARE)) {
            ITemplateElement ifStmt = alternative.getIfStatement();
            increaseIndentation(ifStmt);
            tracer.visitAlternative(true);
            value = ifStmt.accept(this);
            decreaseIndentation(ifStmt);
            value = checkContentStatement(value, null, alternative.getIfStatement());
        } else {
            if (null != alternative.getElseStatement()) {
                ITemplateElement elseStmt = alternative.getElseStatement();
                increaseIndentation(elseStmt);
                tracer.visitAlternative(false);
                value = elseStmt.accept(this);
                decreaseIndentation(elseStmt);
                value = checkContentStatement(value, null, alternative.getElseStatement());
            } else {
                // there is no else - check content for if-part
                boolean isIfContentStatement = isContentStatement(alternative.getIfStatement());
                if (isIfContentStatement) { // pretend there is one, otherwise content evaluation fails
                    if (!defContentStack.isEmpty()) { // emulate visitContentStatement(""), pass through content
                        value = defContentStack.peek();
                    } else {
                        value = "";
                    }
                }
                value = checkContentStatement(value, null, isIfContentStatement);
            }
        }
        return value;
    }
    
    /**
     * Turns the <code>expression</code> into a separator.
     * 
     * @param expression the expression (may be <b>null</b>)
     * @return the separator (or <b>null</b>)
     * @throws VilException in case of evaluation problems
     */
    private String getSeparatorFromExpression(Expression expression) throws VilException {
        String separator;
        if (null != expression) {
            separator = StringValueHelper.getStringValue(expression.accept(this), null);
        } else {
            separator = null;
        }
        return separator;
    }

    @Override
    public Object visitLoop(LoopStatement loop) throws VilException {
        Object object;
        Expression expr = loop.getContainerExpression();
        object = convertToContainer(expr, expr.accept(this), "loop");
        String separator = getSeparatorFromExpression(loop.getSeparatorExpression());
        String finalSeparator = getSeparatorFromExpression(loop.getFinalSeparatorExpression());

        Object bodyResult = NullValue.VALUE;
        if (object instanceof Collection<?>) {
            VariableDeclaration iterVar = loop.getIteratorVariable();
            environment.pushLevel();
            Collection<?> collection = (Collection<?>) object;
            Iterator<?> iter = collection.iterator();
            tracer.visitLoop(iterVar);
            while (iter.hasNext() && !stop) {
                Object value = iter.next();
                environment.addValue(iterVar, value);
                tracer.valueDefined(iterVar, null, value);
                ITemplateElement loopStmt = loop.getLoopStatement();
                increaseIndentation(loopStmt);
                bodyResult = loopStmt.accept(this);
                decreaseIndentation(loopStmt);
                if (null != separator && iter.hasNext()) {
                    appendContent(separator);
                }
                if (null != finalSeparator && !iter.hasNext()) {
                    appendContent(finalSeparator);
                }
            }
            tracer.visitedLoop(iterVar);
            environment.popLevel();
        } else {
            if (null != object) {
                throw new VilException("loop must iterate over collection", VilException.ID_SEMANTIC);
            }
        }
        return checkContentStatement(bodyResult, NullValue.VALUE, loop.getLoopStatement());
    }
    
    /**
     * Checks the current value for the need of correction with respect to the last content statement.
     * 
     * @param currentValue the current value
     * @param noValue the object indicating no value in this context
     * @param check the template element/statement to check for a content statement
     * @return <code>currentValue</code> or {@link #EMPTY_CONTENT}
     */
    private Object checkContentStatement(Object currentValue, Object noValue, ITemplateElement check) {
        return checkContentStatement(currentValue, noValue, isContentStatement(check));
    }

    /**
     * Checks the current value for the need of correction with respect to the last content statement.
     * 
     * @param currentValue the current value
     * @param noValue the object indicating no value in this context
     * @param isContentStatement whether the relevant element is a content statement
     * @return <code>currentValue</code> or {@link #EMPTY_CONTENT}
     */
    private Object checkContentStatement(Object currentValue, Object noValue, boolean isContentStatement) {
        Object result = currentValue;
        if (noValue == currentValue && isContentStatement) {
            result = EMPTY_CONTENT;
        }
        return result;
    }
    
    /**
     * Returns whether the template element or the last statement within is a content statement.
     * 
     * @param elt the element (may be <b>null</b>)
     * @return <code>true</code> for content statement, <code>false</code> else 
     *   (also if <code>elt</code> is <b>null</b>)
     */
    private static final boolean isContentStatement(ITemplateElement elt) {
        return null == elt ? false : elt.endsWithContentStatement();
    }
    
    /**
     * Adds content to the current top element of {@link #defContentStack}.
     * 
     * @param string the string to add to the current content.
     */
    private void appendContent(String string) {
        String topContent = defContentStack.pop();
        if (null == topContent) {
            topContent = string;
        } else {
            topContent += string;
        }
        defContentStack.push(topContent);
    }

    @Override
    public Object visitSwitch(SwitchStatement swtch) throws VilException {
        Object value;
        environment.pushLevel();
        Object select = swtch.getSwitchExpression().accept(this);
        environment.addValue(swtch.getImplicitVariable(), select);
        int found = -1;
        value = null;
        // currently no indentation as content is not allowe in switch
        for (int a = 0; found < 0 && a < swtch.getAlternativeCount(); a++) {
            SwitchStatement.Alternative alt = swtch.getAlternative(a);
            boolean take = alt.isDefault();
            if (!take) {
                Expression cond = alt.getCondition();
                Object condValue = cond.accept(this);
                take = equals(condValue, select);
            }
            if (take) {
                value = alt.getValue().accept(this);
                found = a;
            }
        }
        // currently no indentation as content is not allowe in switch
        tracer.visitedSwitch(select, found, value);
        environment.popLevel();
        return value;
    }

    /**
     * Checks for equality among the given <code>condValue</code> (condition value) and the 
     * given <code>exprValue</code>, whereby <code>exprValue</code> may be an {@link IvmlElement} and, thus,
     * implicitly casted to the right value. This method is intended where common object values need to 
     * be compared and no VIL/VTL casts may happen.
     * 
     * @param condValue the condition value
     * @param exprValue the expression value
     * @return <code>true</code> if the values are equal <code>false</code> else
     */
    private boolean equals(Object condValue, Object exprValue) {
        boolean result = condValue.equals(exprValue);
        if (!result && exprValue instanceof IvmlElement) {
            IvmlElement iElt = (IvmlElement) exprValue;
            if (condValue instanceof String) {
                result = condValue.equals(iElt.getStringValue());
            } else if (condValue instanceof Integer) {
                result = condValue.equals(iElt.getIntegerValue());
            } else if (condValue instanceof Boolean) {
                result = condValue.equals(iElt.getBooleanValue());
            } else if (condValue instanceof Double) {
                result = condValue.equals(iElt.getRealValue());
            } else if (condValue instanceof EnumValue) {
                result = condValue.equals(iElt.getEnumValue());
            }
        }
        return result;
    }

    @Override
    public Object visitContentStatement(ContentStatement cnt) throws VilException {
        contentNestingLevel++;
        lastContentFormatted = false;
        if (null != lastContent && lastContent.needsLineEnd(true)) { // if sequence, print line ending by default
            appendContent(getLineEnd());
        }
        lastContent = null; // handled, reset
        String content = (String) cnt.getContent().accept(this);
        if (null != content) {
            // search for \r\n, \r, \n followed by indentation*step whitespaces or tabs +1
            content = cleanLineEnd(content, true);
        } 
        if (null != content) {
            int forced = 0; // negative disables VTL indentation mechanism
            if (null != cnt.getIndentExpression()) {
                Object val = cnt.getIndentExpression().accept(this);
                if (val instanceof Integer) {
                    forced = ((Integer) val).intValue();
                } else {
                    throw new VilException("indentation value is no integer", VilException.ID_SEMANTIC);
                }
            }
            if (forced >= 0) { // auto/forced indentation is not disabled
                int indentation = environment.getIndentation();
                if (indentation > 0) {
                    int indent = indentation + getAdditionalIndentation();
                    content = IndentationUtils.removeIndentation(content, indent, getTabEmulation());
                }
                //int forced = 0;
                if (forced > 0) { // precondition of insertIndentation
                    content = IndentationUtils.insertIndentation(content, forced, contentNestingLevel > 1);
                    lastContentFormatted = true;
                }
            }
            String topContent = defContentStack.pop();
            if (0 == topContent.length() || forced < 0) {
                topContent = content;
            } else {
                topContent = IndentationUtils.appendWithLastIndentation(topContent, content, 
                    contentNestingLevel == 1 || lastContentNestingLevel == contentNestingLevel);
            }
            defContentStack.push(topContent);
            content = topContent; // replace by all for end of def/return
        }
        lastContentNestingLevel = contentNestingLevel;
        contentNestingLevel--;
        lastContent = cnt;
        lastContentLineEndType = cnt.getLineEndType();
        return content;
    }
    
    @Override
    protected boolean lastContentReplaceEmptyLine() {
        boolean result = lastContentLineEndType == LineEndType.NO_LINE_END;
        lastContentLineEndType = null;
        return result;
    }
    
    /**
     * Removes the empty line marker {@link #EMPTY_CONTENT} and considers surrounding indentation for removal.
     * 
     * @param content the content to be considered
     * @param includeIndentation whether indentation shall be taken into account
     * @return the modified content
     */
    private static String cleanLineEnd(String content, boolean includeIndentation) {
        int pos;
        do {
            pos = content.indexOf(EMPTY_CONTENT);
            if (pos >= 0) {
                int end = pos + EMPTY_CONTENT.length();
                if (includeIndentation) {
                    while (end < content.length() && IndentationUtils.isLineEnd(content.charAt(end))) {
                        end++;
                    }
                }
                int start = pos;
                if (start > 0) {
                    start--;
                    if (includeIndentation) {
                        while (start >= 0 && IndentationUtils.isIndentationChar(content.charAt(start))) {
                            start--;
                        }
                    }
                    if (start < 0) {
                        start = 0;
                    }
                }
                content = content.substring(0, start) + content.substring(end);
            }
        } while (pos >= 0);
        return content;
    }

    @Override
    protected String appendInCompositeExpression(String s1, Expression e1, Object v1, String s2, Expression e2) {
        String result;
        boolean format = false;
        boolean clear = false;
        boolean isS1 = false;
        IndentationConfiguration config = environment.getIndentationConfiguration();
        if (e1 instanceof ConstantExpression && e2 instanceof TemplateCallExpression) {
            // do formatting only in presence of a ${template call} and if not explicitly formatted
            format = !lastContentFormatted;
            if (format) {
                if (s1.length() > 0) {
                    // avoid in-place indentation
                    char last = s1.charAt(s1.length() - 1);
                    format = IndentationUtils.isLineEnd(last) || IndentationUtils.isIndentationChar(last);
                }
            }
        } else if (e2 instanceof InContentExpression) {
            // an in-content expression leading to an empty information shall be wiped out including prepared indent
            clear = null != config && s2.isEmpty();
        } else if (e1 instanceof InContentExpression) {
            // if the last in-content expression led to an empty string and the following is an indentation, leave
            // out the indentation
            if (v1.toString().isEmpty() && IndentationUtils.isIndentationString(s2)) {
                format = false;
                isS1 = true;
            }
        }
        
        String hint = e2.getFormattingHint();
        boolean clearLE = false;
        if (null != hint) {
            if ("e".equals(hint)) {
                if (s2.length() == 0) {
                    clear = true;
                    clearLE = true;
                } else {
                    format = true;
                }
            } else if ("<".equals(hint)) {
                s1 = IndentationUtils.removeLastIndentation(s1, false);
                clear = false;
                format = false;
                isS1 = false;
            }
        }
        if (format) {
            int indentation = environment.getIndentation();
            indentation -= getIndentationStep(); // we are within/among expressions, one step out
            if (indentation > 0) {
                int indent = indentation + getAdditionalIndentation();
                if (IndentationUtils.allLinesStartWith(s2, indent)) {
                    s2 = IndentationUtils.removeIndentation(s2, indent, getTabEmulation());
                }
            }
            result = IndentationUtils.appendWithLastIndentation(s1, s2, false);
        } else if (clear) {
            result = IndentationUtils.removeLastIndentation(s1, clearLE);
        } else if (isS1) {
            result = s1;
        } else {
            result = super.appendInCompositeExpression(s1, e1, v1, s2, e2);
        }
        return result;
    }
    
    /**
     * Returns the additional indentation as configured.
     * 
     * @return the additional indentation or {@code 0} if no configuration is present
     */
    private int getAdditionalIndentation() {
        IndentationConfiguration icfg = environment.getIndentationConfiguration();
        return null == icfg ? 0 : icfg.getAdditional();
    }
    
    private int getTabEmulation() {
        IndentationConfiguration icfg = environment.getIndentationConfiguration();
        return null == icfg ? 0 : icfg.getTabEmulation();
    }

    private int getIndentationStep() {
        IndentationConfiguration icfg = environment.getIndentationConfiguration();
        return null == icfg ? 0 : icfg.getIndentationStep();
    }

    /**
     * Returns the current line end based on the formatting configuration of the actual context model.
     * 
     * @return the actual line end (fallback is the Java line end)
     */
    private String getLineEnd() {
        return FormattingConfiguration.getLineEnding(getFormattingConfiguration());
    }
    
    /**
     * Returns the formatting configuration.
     * 
     * @return the formatting configuration, may be <b>null</b>
     */
    private FormattingConfiguration getFormattingConfiguration() {
        FormattingConfiguration cfg = null;
        ITypedModel model = environment.getContextModel();
        if (model instanceof Template) {
            Template template = (Template) model;
            cfg = template.getFormattingConfiguration();
        }
        return cfg;
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        Object result = cst.getValue();
        // we have to care for $name and ${} but only in strings
        if (result instanceof String) {
            result = StringReplacer.substitute(result.toString(), new Resolver(environment), 
                getExpressionParser(), this, null);
        }
        return result;
    }

    @Override
    public Object visitJavaExtension(JavaExtension ext) throws VilException {
        // operations shall already be resolvable and handled by expressions
        return null;
    }

    @Override
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws VilException {
        Object result;
        if (stop) {
            result = null;
        } else {
            int indentation = environment.getIndentation();
            environment.setIndentationSteps(1); // reset to template level
            result = visitModelCallExpression(call);
            environment.setIndentation(indentation);
        }
        return result;
    }

    @Override
    protected Object executeModelCall(Def def) throws VilException {
        return def.accept(this);
    }

    @Override
    protected ModelCallExpression<VariableDeclaration, Template, Def> createModelCall(Template model, Def operation,
        CallArgument... arguments) throws VilException {
        return new TemplateCallExpression(model, operation, arguments);
    }

    @Override
    protected Def dynamicDispatch(Def operation, Object[] args, IArgumentProvider argumentProvider, 
        boolean enableParentScope) {
        return AbstractCallExpression.dynamicDispatch(operation, args, Def.class, environment.getTypeRegistry(), 
            argumentProvider, enableParentScope ? environment.getMostSpecificContextModel() : null);
    }

    @Override
    protected void handleParameterInSequence(IResolvableModel<VariableDeclaration, Template> model,
        Map<String, VariableDeclaration> varMap) throws VilException {
        if (model.getParameterCount() >= 2) {
            // check default sequence instead, config, target
            boolean ok = IvmlTypes.configurationType().isAssignableFrom(model.getParameter(0).getType());
            ok &= ArtifactTypes.artifactType().isAssignableFrom(model.getParameter(1).getType());
            if (ok) {
                assignModelParameter(model, model);
                for (int p = 0; p < 2; p++) {
                    varMap.remove(model.getParameter(p).getName());
                }
            }
        }
        // remove anyway
        varMap.remove(PARAM_CONFIG_SURE);
        varMap.remove(PARAM_TARGET_SURE);
    }
    
    @Override
    protected void assignModelParameter(IResolvableModel<VariableDeclaration, Template> targetModel, 
        IResolvableModel<VariableDeclaration, Template> srcModel) throws VilException {
        // take sure values
        if (srcModel.getParameterCount() >= 1) {
            setModelArgument(srcModel.getParameter(0), getParameter(PARAM_CONFIG_SURE));
        }
        if (srcModel.getParameterCount() >= 2) {
            setModelArgument(srcModel.getParameter(1), getParameter(PARAM_TARGET_SURE));
        }
        evaluateModelParameter(targetModel, srcModel, 2);
    }

    @Override
    protected IExpressionParser<Resolver> getExpressionParser() {
        return ExpressionParserRegistry.getExpressionParser(LANGUAGE);
    }

    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        Object result;
        Object val = environment.getValue(ex.getVariable());
        int indentation = environment.getIndentation();
        environment.setIndentationSteps(1); // reset to template level
        if (val instanceof Def) {
            Def def = (Def) val;
            result = proceedModelCall(def, (Template) environment.getContextModel(), ex, 
                ex.isPlaceholder(), false);
        } else {
            result = super.visitResolvableOperationCallExpression(ex);
        }
        environment.setIndentation(indentation);
        return result;
    }
    
    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        return null; // typedefs are processed during parsing
    }

    @Override
    public Object visitWhile(WhileStatement stmt) throws VilException {
        Expression condition = stmt.getConditionExpression();
        boolean executeLoop = false;
        environment.pushLevel();
        Object bodyResult = NullValue.VALUE;
        do {
            Object conditionResult = condition.accept(this);
            executeLoop = (conditionResult instanceof Boolean && (Boolean) conditionResult);
            if (executeLoop) {
                tracer.visitWhileBody();
                ITemplateElement loopStmt = stmt.getLoopStatement();
                increaseIndentation(loopStmt);
                bodyResult = loopStmt.accept(this);
                if (null == bodyResult) {
                    executeLoop = false;
                }
                decreaseIndentation(loopStmt);
                tracer.visitedWhileBody();
            }
        } while (executeLoop && !stop);
        environment.popLevel();
        return checkContentStatement(bodyResult, NullValue.VALUE, stmt.getLoopStatement());
    }

    @Override
    public void stop() {
        stop = true;
    }

    @Override
    public Object visitFlush(FlushStatement stmt) throws VilException {
        tracer.visitFlush();
        storeContent();
        tracer.visitedFlush();
        return null;
    }
    
    /**
     * Explicitly stores the concatenated results of the content statements to the target artifact.
     * 
     * @throws VilException if storing the content fails for some reason
     */
    public void storeContent() throws VilException {
        Object tgt = getParameter(TemplateLangExecution.PARAM_TARGET_SURE);
        if (null == tgt) {
            tgt = getParameter(TemplateLangExecution.PARAM_TARGET);
        }
        if (tgt instanceof IArtifact && mainOut instanceof StringWriter) {
            storeContent((IArtifact) tgt, (StringWriter) mainOut);
        }
    }
    
    /**
     * Explicitly stores the concatenated results of the content statements to the target artifact.
     * 
     * @param target the target artifact
     * @param out the output writer to take the produced content from
     * @throws VilException if storing the content fails for some reason
     */
    public static void storeContent(IArtifact target, StringWriter out) throws VilException {
        String tmp = out.toString();
        if (tmp.length() > 0) {
            target.getText().setText(tmp);
        }
        target.store();
    }

    @Override
    public Object visitContentAlternativeExpression(ContentAlternativeExpression ex) throws VilException {
        Object result = null;
        Object cond = ex.getCondition().accept(this);
        if (Boolean.TRUE.equals(cond)) {
            result = evaluateContentExpression(ex.thenEx());
        } else if (Boolean.FALSE.equals(cond)) {
            if (ex.getElseExpressionsCount() > 0) {
                result = evaluateContentExpression(ex.elseEx());
            } else {
                result = "";
            }
        }
        return result;
    }

    /**
     * Evaluates a separator expression.
     * 
     * @param ex the expression (may be <b>null</b>)
     * @param deflt the default value to be used as result if <code>ex</code> is <b>null</b>
     * @return the separator, <code>deflt</code> if <code>ex</code> is <b>null</b> or the evaluation leads to undefined,
     *     the separator string else
     * @throws VilException in case that the evaluation fails
     */
    private String evaluateSeparator(Expression ex, String deflt) throws VilException {
        String separator = deflt;
        if (null != ex) {
            Object tmp = ex.accept(this);
            if (null == tmp) {
                separator = deflt;
            } else {
                separator = tmp.toString();
            }
        }
        return separator;
    }

    @Override
    public Object visitContentLoopExpression(ContentLoopExpression ex) throws VilException {
        String result = null;
        String separator = evaluateSeparator(ex.getSeparator(), "");
        String endSeparator = evaluateSeparator(ex.getEndSeparator(), "");
        Object init = ex.getInit().accept(this);
        Iterator<?> iter;
        if (init instanceof Collection) {
            iter = ((Collection<?>) init).iterator();
        } else if (init instanceof java.util.Collection) {
            iter = ((java.util.Collection<?>) init).iterator();
        } else if (init instanceof ContainerValue) {
            iter = ((ContainerValue) init).iterator();
        } else {
            iter = null;
        }
        if (null != iter) {
            result = "";
            environment.pushLevel();
            VariableDeclaration decl = ex.getIterator();
            environment.addValue(decl, null);
            while (iter.hasNext()) {
                environment.setValue(decl, iter.next());
                String tmp = evaluateContentExpression(ex);
                if (null == tmp) {
                    break;
                }
                if (result.length() == 0) {
                    result = tmp;
                } else {
                    result = result + separator + tmp;
                }
            }
            environment.popLevel();
            if (result.length() > 0) {
                result = result + endSeparator;
            }
        }
        return result;
    }

    @Override
    public Object visitContentVarDeclExpression(ContentVarDeclExpression ex) throws VilException {
        VariableDeclaration var = ex.getVariable();
        Object value;
        if (null != var.getExpression()) {
            value = var.getExpression().accept(this);
        } else {
            value = null; // shall not occur due to required syntax in StringParser
        }
        environment.addValue(var, value);
        return ""; // replace me by nothing
    }

    @Override
    public Object visitContentImportExpression(ContentImportExpression ex) throws VilException {
        try {
            Template current = (Template) environment.getContextModel();
            AvailableModels<Template> available = TemplateModel.INSTANCE.availableModels();
            ModelInfo<Template> currentInfo = available.getModelInfo(current);
            URI baseUri = null;
            if (null != currentInfo) {
                baseUri = currentInfo.getLocation();
            } 
            if (null == baseUri) {
                baseUri = getFallbackBaseURI();
            }
            Template resolved = TemplateModel.INSTANCE.resolve(ex.getTemplate(), ex.getVersionRestriction(), 
                baseUri, environment);
            if (null != resolved) {
                ModelImport<Template> imp = new ModelImport<Template>(ex.getTemplate());
                imp.setResolved(resolved);
                current.addRuntimeImport(imp);
            }
        } catch (ModelManagementException e) {
            throw new VilException(e);
        }
        return ""; // replace me by nothing
    }
    
    /**
     * Returns the base URI for template resolution in this execution if there is no template to obtain it from.
     * 
     * @return the base URI
     */
    protected URI getFallbackBaseURI() {
        return null;
    }

    @Override
    public Object visitCompound(Compound compound) throws VilException {
        return null; // declaration is not executed
    }

}