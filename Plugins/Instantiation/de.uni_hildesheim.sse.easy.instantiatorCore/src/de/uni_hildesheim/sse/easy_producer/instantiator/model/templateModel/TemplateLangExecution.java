package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExecutionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IResolvableModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ModelCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.AbstractCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.StringReplacer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;

/**
 * Implements the execution of the template language.
 * 
 * @author Holger Eichelberger
 */
public class TemplateLangExecution extends ExecutionVisitor<Template, Def, VariableDeclaration> 
    implements ITemplateLangVisitor {

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

    private static IExpressionParser expressionParser;
    private RuntimeEnvironment environment;
    private PrintWriter out;
    private String mainName;
    private ITracer tracer;

    /**
     * Creates a new evaluation visitor.
     * 
     * @param tracer the tracer instance for testing
     * @param out where to put the output to
     * @param parameter the top-level parameter for the script to be executed
     */
    public TemplateLangExecution(ITracer tracer, Writer out, Map<String, Object> parameter) {
        this(tracer, out, "main", parameter);
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
        this.environment = getRuntimeEnvironment();
        this.out = new PrintWriter(out);
        this.mainName = mainName;
        this.tracer = tracer;
    }
    
    /**
     * Defines the expression parser.
     * 
     * @param parser the parser
     */
    public static void setExpressionParser(IExpressionParser parser) {
        String info;
        if (null != parser) {
            info = "registered expression parser " + parser.getClass().getName();
        } else {
            info = "expression parser unregistered";
        }
        EASyLoggerFactory.INSTANCE.getLogger(TemplateLangExecution.class, Bundle.ID).info(info);
        expressionParser = parser;
    }
    
    /**
     * Returns the current expression parser instance.
     * 
     * @return the current expression parser instance
     */
    public static IExpressionParser getExpressionParser() {
        return expressionParser;
    }
    
    @Override
    public Object visitTemplate(Template template) throws VilLanguageException {
        tracer.visitTemplate(template);
        visitModelHeader(template);
        environment.switchContext(template);
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
            throw new VilLanguageException("no '" + mainName + "' template found with suitable parameters", 
                VilLanguageException.ID_RUNTIME_STARTRULE);
        }
        Object result = executeMain(template, main);
        tracer.visitedTemplate(template);
        return result;
    }

    @Override
    public Object visitDef(Def def) throws VilLanguageException {
        Object result;
        try {
            tracer.visitDef(def, environment);
            result = visitTemplateBlock(def); // increases indentation
            tracer.visitedDef(def, environment, result);
        } catch (VilLanguageException e) {
            throw new VilLanguageException(e);
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
    public Object visitTemplateBlock(TemplateBlock block) throws VilLanguageException {
        boolean ok = true;
        Object value = null;
        environment.increaseIndentation();
        try {
            for (int e = 0; ok && e < block.getBodyElementCount(); e++) {
                ITemplateElement elt = block.getBodyElement(e);
                value = elt.accept(this);
                if (mayFail(elt)) {
                    ok = checkConditionResult(value, block, ConditionTest.DONT_CARE);
                }
                if (!ok) {
                    tracer.failedAt(block.getBodyElement(e));
                }
            }
        } catch (VilLanguageException e) {
            throw e;
        }
        environment.decreaseIndentation();
        return value;
    }

    @Override
    public Object visitAlternative(AlternativeStatement alternative) throws VilLanguageException {
        Object value = null;
        try {
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
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
        return value;
    }
    
    /**
     * Turns the <code>expression</code> into a separator.
     * 
     * @param expression the expression (may be <b>null</b>)
     * @return the separator (or <b>null</b>)
     * @throws VilLanguageException in case of evaluation problems
     */
    private String getSeparatorFromExpression(Expression expression) throws VilLanguageException {
        String separator;
        if (null != expression) {
            try {
                separator = StringValueHelper.getStringValue(expression.accept(this), null);
            } catch (ExpressionException e) {
                throw new VilLanguageException(e);
            }
        } else {
            separator = null;
        }
        return separator;
    }

    @Override
    public Object visitLoop(LoopStatement loop) throws VilLanguageException {
        Object object;
        try {
            object = loop.getContainerExpression().accept(this);
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
        String separator = getSeparatorFromExpression(loop.getSeparatorExpression());
        String finalSeparator = getSeparatorFromExpression(loop.getFinalSeparatorExpression());
            
        if (object instanceof Collection<?>) {
            try {
                VariableDeclaration iterVar = loop.getIteratorVariable();
                environment.pushLevel();
                Collection<?> collection = (Collection<?>) object;
                Iterator<?> iter = collection.iterator();
                tracer.visitLoop(iterVar);
                while (iter.hasNext()) {
                    Object value = iter.next();
                    environment.addValue(iterVar, value);
                    tracer.valueDefined(iterVar, value);
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
            } catch (VilLanguageException e) {
                throw e;
            } 
            try {
                environment.popLevel();
            } catch (ArtifactException e) {
                throw new VilLanguageException(e);
            }
        } else {
            if (null != object) {
                throw new VilLanguageException("loop must iterate over collection", VilLanguageException.ID_SEMANTIC);
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Object visitSwitch(SwitchStatement swtch) throws VilLanguageException {
        Object value;
        try {
            environment.pushLevel();
            Object select = swtch.getSwitchExpression().accept(this);
            environment.addValue(swtch.getImplicitVariable(), select);
            int found = -1;
            value = null;
            // currently no indentation as content is not allowe in switch
            for (int a = 0; found < 0 && a < swtch.getAlternativeCount(); a++) {
                SwitchStatement.Alternative alt = swtch.getAlternative(a);
                Expression cond = alt.getCondition();
                if (alt.isDefault() || checkConditionResult(cond.accept(this), cond, ConditionTest.DONT_CARE)) {
                    value = alt.getValue().accept(this);
                    found = a;
                }
            }
            // currently no indentation as content is not allowe in switch
            tracer.visitedSwitch(select, found, value);
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        } 
        try {
            environment.popLevel();
        } catch (ArtifactException e) {
            throw new VilLanguageException(e);
        }
        return value;
    }

    @Override
    public Object visitContentStatement(ContentStatement cnt) throws VilLanguageException {
        try {
            // search for \r\n, \r, \n followed by indentation*step whitespaces or tabs +1
            String content = StringReplacer.substitute(cnt.getContent(), environment, expressionParser, this);
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
                    content = IndentationUtils.insertIndentation(content, forced);
                } else {
                    throw new VilLanguageException("indentation value is no integer", 
                        VilLanguageException.ID_SEMANTIC);
                }
            }
            if (cnt.printLineEnd()) {
                out.println(content);
            } else {
                out.print(content);
            }
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
        return Boolean.TRUE;
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException {
        Object result = cst.getValue();
        // we have to care for $name and ${} but only in strings
        if (result instanceof String) {
            result = StringReplacer.substitute(result.toString(), environment, expressionParser, this);
        }
        return result;
    }

    @Override
    public Object visitJavaExtension(JavaExtension ext) throws VilLanguageException {
        // operations shall already be resolvable and handled by expressions
        return null;
    }

    @Override
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws ExpressionException {
        return visitModelCallExpression(call);
    }

    @Override
    protected Object executeModelCall(Def def) throws VilLanguageException {
        return def.accept(this);
    }

    @Override
    protected ModelCallExpression<VariableDeclaration, Template, Def> createModelCall(Template model, Def operation,
        CallArgument... arguments) throws ExpressionException {
        return new TemplateCallExpression(model, operation, arguments);
    }

    @Override
    protected Def dynamicDispatch(Def operation, Object[] args) {
        return AbstractCallExpression.dynamicDispatch(operation, args, Def.class, environment.getTypeRegistry());
    }

    @Override
    protected void handleParameterInSequence(IResolvableModel<VariableDeclaration> model,
        Map<String, VariableDeclaration> varMap) throws VilLanguageException {
        if (model.getParameterCount() >= 2) {
            // check default sequence instead, config, target
            boolean ok = TypeRegistry.configurationType().isAssignableFrom(model.getParameter(0).getType());
            ok &= TypeRegistry.artifactType().isAssignableFrom(model.getParameter(1).getType());
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
    
}
