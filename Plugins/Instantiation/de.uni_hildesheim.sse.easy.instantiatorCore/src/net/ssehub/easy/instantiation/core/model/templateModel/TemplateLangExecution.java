package net.ssehub.easy.instantiation.core.model.templateModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactTypes;
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
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry.ILanguage;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypedModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlElement;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;

/**
 * Implements the execution of the template language.
 * 
 * @author Holger Eichelberger
 */
public class TemplateLangExecution extends ExecutionVisitor<Template, Def, VariableDeclaration> 
    implements ITemplateLangVisitor, ITerminatable {

    public static final ILanguage LANGUAGE = new ILanguage() {

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
    
    private RuntimeEnvironment environment;
    private PrintWriter out;
    private String mainName;
    private ITracer tracer;
    private boolean stop = false;

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
        this.out = new PrintWriter(out);
        this.mainName = mainName;
        this.tracer = tracer;
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
        Object result;
        if (def.isPlaceholder()) {
            result = null;
        } else {
            tracer.visitDef(def, environment);
            result = visitTemplateBlock(def); // increases indentation
            tracer.visitedDef(def, environment, result);
        }
        return result;
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
        Object value = null;
        environment.increaseIndentation();
        for (int e = 0; ok && !stop && e < block.getBodyElementCount(); e++) {
            ITemplateElement elt = block.getBodyElement(e);
            value = elt.accept(this);
            if (mayFail(elt)) {
                ok = checkConditionResult(value, block, ConditionTest.DONT_CARE);
            }
            if (!ok) {
                tracer.failedAt(block.getBodyElement(e));
            }
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
        } else {
            if (null != alternative.getElseStatement()) {
                ITemplateElement elseStmt = alternative.getElseStatement();
                increaseIndentation(elseStmt);
                tracer.visitAlternative(false);
                value = elseStmt.accept(this);
                decreaseIndentation(elseStmt);
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
                loopStmt.accept(this);
                decreaseIndentation(loopStmt);
                if (null != separator && iter.hasNext()) {
                    out.print(separator);
                }
                if (null != finalSeparator && !iter.hasNext()) {
                    out.print(finalSeparator);
                }
            }
            tracer.visitedLoop(iterVar);
            environment.popLevel();
        } else {
            if (null != object) {
                throw new VilException("loop must iterate over collection", VilException.ID_SEMANTIC);
            }
        }
        return Boolean.TRUE;
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
        String content;
        // search for \r\n, \r, \n followed by indentation*step whitespaces or tabs +1
        content = (String) cnt.getContent().accept(this);
        if (null != content) {
            int indentation = environment.getIndentation();
            if (indentation > 0) {
                IndentationConfiguration config = environment.getIndentationConfiguration();
                // experiment... is this sufficient for '-indentation?
                int indent = indentation + environment.getIndentationConfiguration().getAdditional();
                content = IndentationUtils.removeIndentation(content, indent, config.getTabEmulation());
            }
            if (null != cnt.getIndentExpression()) {
                Object val = cnt.getIndentExpression().accept(this);
                if (val instanceof Integer) {
                    int forced = ((Integer) val).intValue();
                    if (forced > 0) { // precondition of insertIndentation
                        content = IndentationUtils.insertIndentation(content, forced);
                    }
                } else {
                    throw new VilException("indentation value is no integer", 
                        VilException.ID_SEMANTIC);
                }
            }
            if (cnt.printLineEnd()) {
                out.print(content);
                out.print(getLineEnd());
            } else {
                out.print(content);
            }
        }
        return content;
    }
    
    /**
     * Returns the current line end based on the formatting configuration of the actual context model.
     * 
     * @return the actual line end (fallback is the Java line end)
     */
    private String getLineEnd() {
        FormattingConfiguration cfg = null;
        ITypedModel model = environment.getContextModel();
        if (model instanceof Template) {
            Template template = (Template) model;
            cfg = template.getFormattingConfiguration();
        }
        return FormattingConfiguration.getLineEnding(cfg);
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        Object result = cst.getValue();
//         we have to care for $name and ${} but only in strings
        if (result instanceof String) {
            result = StringReplacer.substitute(result.toString(), environment, getExpressionParser(), this);
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
            result = visitModelCallExpression(call);
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
    protected Def dynamicDispatch(Def operation, Object[] args) {
        return AbstractCallExpression.dynamicDispatch(operation, args, Def.class, environment.getTypeRegistry());
    }

    @Override
    protected void handleParameterInSequence(IResolvableModel<VariableDeclaration> model,
        Map<String, VariableDeclaration> varMap) throws VilException {
        if (model.getParameterCount() >= 2) {
            // check default sequence instead, config, target
            boolean ok = IvmlTypes.configurationType().isAssignableFrom(model.getParameter(0).getType());
            ok &= ArtifactTypes.artifactType().isAssignableFrom(model.getParameter(1).getType());
            if (ok) {
                // take sure values
                setModelArgument(model.getParameter(0), getParameter(PARAM_CONFIG_SURE));
                setModelArgument(model.getParameter(1), getParameter(PARAM_TARGET_SURE));
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
    protected IExpressionParser getExpressionParser() {
        return ExpressionParserRegistry.getExpressionParser(LANGUAGE);
    }

    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        Object result;
        Object val = environment.getValue(ex.getVariable());
        if (val instanceof Def) {
            Def def = (Def) val;
            result = proceedModelCall(def, def.getName(), (Template) environment.getContextModel(), ex, 
                ex.isPlaceholder());
        } else {
            result = super.visitResolvableOperationCallExpression(ex);
        }
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
        Object bodyResult = null;
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
        return bodyResult;
    }

    @Override
    public void stop() {
        stop = true;
    }
    
}