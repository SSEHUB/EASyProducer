package net.ssehub.easy.instantiation.core.model.tracing;

import java.io.StringWriter;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangWriter;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IBuildlangElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IEnumeratingLoop;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.ITraceFilter;
import net.ssehub.easy.instantiation.core.model.common.NoTraceFilter;
import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.common.ITraceFilter.LanguageElementKind;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionWriter;
import net.ssehub.easy.instantiation.core.model.expressions.AbstractTracerBase;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;
import net.ssehub.easy.instantiation.core.model.templateModel.ITemplateLangElement;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangWriter;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;

/**
 * Implements a combined tracer for VIL and VTL with common indentation.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractVilTracer extends AbstractTracerBase
    implements net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer, 
    net.ssehub.easy.instantiation.core.model.templateModel.ITracer, IInstantiatorTracer {

    private static final String INDENTATION_STEP = "  ";
    private String indentation = "";
    private boolean emitTraceText;
    private boolean enable = true;
    private ITraceFilter filter = NoTraceFilter.INSTANCE;

    /**
     * Creates a tracer instance without emitting trace texts.
     */
    protected AbstractVilTracer() {
        this(false);
    }
    
    /**
     * Creates a tracer instance.
     * 
     * @param emitTraceText whether text passed to {@link #trace(String)} shall be emitted
     */
    protected AbstractVilTracer(boolean emitTraceText) {
        this.emitTraceText = emitTraceText;
    }

    @Override
    public void setTraceFilter(ITraceFilter filter) {
        if (null != filter) {
            this.filter = filter;
        }
    }
    
    @Override
    public ITraceFilter getTraceFilter() {
        return filter;
    }
    
    /**
     * Increases the indentation by one {@link #INDENTATION_STEP}.
     */
    private void increaseIndentation() {
        indentation += INDENTATION_STEP;
    }
    
    /**
     * Decreases the indentation by one {@link #INDENTATION_STEP} if possible.
     */
    private void decreaseIndentation() {
        int pos = indentation.length() - INDENTATION_STEP.length();
        if (pos > 0) {
            indentation = indentation.substring(0, pos);
        } 
    }
    
    /**
     * Writes a message and indents it.
     * 
     * @param msg the message to be written
     */
    protected void write(String msg) {
        if (enable) {
            writeImpl(indentation + msg);
        }
    }
    
    /**
     * Writes a message.
     * 
     * @param msg the message to be written
     */
    protected abstract void writeImpl(String msg);
    
    @Override
    public void trace(String text) {
        if (emitTraceText) {
            write(text);
        }
    }

    @Override
    public void valueDefined(VariableDeclaration var, FieldDescriptor field, Object value) {
    }

    @Override
    public void traceExecutionException(VilException exception) {
        if (filter.isEnabled(LanguageElementKind.FAILURE)) {
            write("exception " + exception.getMessage());
        }
    }

    /**
     * Cleans implicit arguments from the optional arguments.
     * 
     * @param argument the arguments to be cleaned
     * @return a copy of <code>argument</code>
     */
    private static Map<?, ?> cleanImplicitFromOptionalArgument(Map<?, ?> argument) {
        java.util.Map<Object, Object> cleaned = new java.util.HashMap<Object, Object>();
        for (Map.Entry<?, ?> entry : argument.entrySet()) {
            if (!Constants.IMPLICIT_PARAMETER.contains(entry.getKey())) {
                cleaned.put(entry.getKey(), entry.getValue());
            }
        }
        if (cleaned.isEmpty()) {
            cleaned = null;
        }
        return cleaned;
    }

    @Override
    public void visitedCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args, Object result) {
    }
    
    @Override
    public void visitingCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args) {
        if (TracerHelper.trace(descriptor) && filter.isEnabled(LanguageElementKind.OPERATION_EXECUTION)) {
            String msg = "call " + descriptor.getName();
            if (descriptor.isConstructor() && null != descriptor.getReturnType()) {
                msg += " " + descriptor.getReturnType().getVilName();
            }
            msg += "(";
            if (null != args) {
                // determine optional parameter and temporarily remove implicit parameters if required
                java.util.Map<?, ?> optionalArgsOrig = null;
                int lastArgPos = args.length - 1;
                int argsLength = args.length;
                if (descriptor.acceptsImplicitParameters() && lastArgPos >= 0) {
                    Object tmp = args[lastArgPos];
                    if (tmp instanceof java.util.Map) {
                        optionalArgsOrig = (java.util.Map<?, ?>) tmp;
                        args[lastArgPos] = cleanImplicitFromOptionalArgument(optionalArgsOrig);
                    }
                    if (null == args[lastArgPos]) {
                        argsLength--; // prevent output
                    }
                }
                for (int i = 0; i < argsLength; i++) {
                    if (i > 0) {
                        msg += ", ";
                    }
                    msg += TracerHelper.toString(args[i], true);
                }
                if (null != optionalArgsOrig) {
                    args[lastArgPos] = optionalArgsOrig;
                }
            }
            msg += ")";
            write(msg);
        }
    }

    @Override
    public void visitRule(Rule rule, RuntimeEnvironment<?, ?> environment) {
        if (filter.isEnabled(LanguageElementKind.FUNCTION_EXECUTION)) {
            String msg = "execute " + rule.getSignature() + " with (";
            for (int p = 0; p < rule.getParameterCount(); p++) {
                try {
                    if (p > 0) {
                        msg += ", ";
                    }
                    msg += TracerHelper.toString(environment.getValue(rule.getParameter(p)), true);
                } catch (VilException e) {
                    // just ignore this
                }
            }
            msg += ")";
            write(msg);
            increaseIndentation();
        }
    }

    @Override
    public void visitedRule(Rule rule, RuntimeEnvironment<?, ?> environment, Object result) {
        if (filter.isEnabled(LanguageElementKind.FUNCTION_EXECUTION)) {
            decreaseIndentation();
        }
    }

    @Override
    public void visitLoop(IEnumeratingLoop map, RuntimeEnvironment<?, ?> environment) {
    }

    @Override
    public void visitIteratorAssignment(IEnumeratingLoop loop, 
        net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration var,
        Object value) {
    }

    @Override
    public void visitedLoop(IEnumeratingLoop loop, RuntimeEnvironment<?, ?> environment) {
    }

    @Override
    public Collection<?> adjustSequenceForMap(Collection<?> collection) {
        return collection;
    }

    @Override
    public Collection<Object> adjustSequenceForJoin(
        Collection<Object> collection) {
        return collection;
    }

    @Override
    public void visitSystemCall(String[] args) {
        if (filter.isEnabled(LanguageElementKind.SYSCALL_EXECUTION) && args.length > 0) {
            String msg = "syscall";
            for (int i = 0; i < args.length; i++) {
                if (i > 0) {
                    msg += " ";
                }
                msg += TracerHelper.toString(args[i], false);
            }
            write(msg);
        }
    }

    @Override
    public void visitingInstantiator(String name) {
        // handled by visitCallExpression
    }

    @Override
    public void visitedInstantiator(String name, Object result) {
    }

    @Override
    public void failedAt(Expression expression) {
        if (filter.isEnabled(LanguageElementKind.FAILURE)) {
            StringWriter out = new StringWriter();
            ExpressionWriter writer = new BuildlangWriter(out);
            try {
                expression.accept(writer);
            } catch (VilException e) {
            }
            write("failed expression: " + out);
        }
    }

    @Override
    public void failedAt(IBuildlangElement element) {
        if (filter.isEnabled(LanguageElementKind.FAILURE)) {
            StringWriter out = new StringWriter();
            BuildlangWriter writer = new BuildlangWriter(out);
            try {
                element.accept(writer);
            } catch (VilException e) {
            }
            write("failed at: " + out);
        }
    }

    @Override
    public void visitScript(Script script, RuntimeEnvironment<?, ?> environment) {
        if (filter.isEnabled(LanguageElementKind.LANGUAGE_UNIT)) {
            String ver = Version.toString(script.getVersion());
            if (null != ver && ver.length() > 0) {
                ver = " version " + ver;
            }
            String location = "";
            ModelInfo<Script> info = BuildModel.INSTANCE.availableModels().getModelInfo(script);
            if (null != info) {
                location = " @ " + info.getLocation();
            }
            write("executing script " + script.getName() + " (" + script.getLanguageName() + ") " 
                + ver + location);
            increaseIndentation();
        }
    }
    
    @Override
    public void visitScriptBody(Script script, RuntimeEnvironment<?, ?> environment) {
        if (filter.isEnabled(LanguageElementKind.LANGUAGE_UNIT)) {
            decreaseIndentation();
        }
    }

    @Override
    public void visitedScript(Script script) {
    }

    @Override
    public void visitDef(Def def, RuntimeEnvironment<?, ?> environment) {
        if (filter.isEnabled(LanguageElementKind.FUNCTION_DEFINITION)) {
            String msg = "execute def " + def.getSignature() + " with (";
            for (int p = 0; p < def.getParameterCount(); p++) {
                try {
                    if (p > 0) {
                        msg += ", ";
                    }
                    msg += TracerHelper.toString(environment.getValue(def.getParameter(p)), true);
                } catch (VilException e) {
                    // just ignore this
                }
            }
            msg += ")";
            write(msg);
            increaseIndentation();
        }
    }

    @Override
    public void visitedDef(Def def, RuntimeEnvironment<?, ?> environment, Object result) {
        if (filter.isEnabled(LanguageElementKind.FUNCTION_DEFINITION)) {
            decreaseIndentation();
        }
    }

    @Override
    public void visitedSwitch(Object select, int alternative, Object value) {
    }

    @Override
    public void visitLoop(VariableDeclaration var) {
    }

    @Override
    public void visitedLoop(VariableDeclaration var) {
    }

    @Override
    public void visitAlternative(boolean takeIf) {
    }

    @Override
    public void failedAt(ITemplateLangElement element) {
        if (filter.isEnabled(LanguageElementKind.FAILURE)) {
            StringWriter out = new StringWriter();
            TemplateLangWriter writer = new TemplateLangWriter(out);
            try {
                element.accept(writer);
            } catch (VilException e) {
            }
            write("failed at: " + out.toString());
        }
    }

    @Override
    public void visitTemplate(Template template) {
        if (filter.isEnabled(LanguageElementKind.LANGUAGE_UNIT)) {
            String location = "";
            ModelInfo<Template> info = TemplateModel.INSTANCE.availableModels().getModelInfo(template);
            if (null != info) {
                location = " @ " + info.getLocation();
            }
            write(template.getName() + " " + Version.toString(template.getVersion()) + location);
            increaseIndentation();
        }
    }

    @Override
    public void visitedTemplate(Template template) {
        if (filter.isEnabled(LanguageElementKind.LANGUAGE_UNIT)) {
            decreaseIndentation();
        }
    }

    @Override
    public void reset() {
        indentation = "";
    }

    /**
     * Trace a message (usually going to System.out in an instantiator).
     * 
     * @param message the message to be traced
     */
    public void traceMessage(String message) {
        write(message);
    }

    @Override
    public void traceError(String message) {
        write(message);
    }

    @Override
    public void traceWarning(String message) {
        write("Warning: " + message);
    }

    @Override
    public void visitWhileBody() {
    }

    @Override
    public void visitedWhileBody() {
    }
    
    /**
     * Returns whether the tracer is enabled.
     * 
     * @return <code>true</code> enabled, <code>false</code> else
     */
    protected boolean isEnabled() {
        return enable;
    }

    @Override
    public void enable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public void visitFlush() {
    }

    @Override
    public void visitedFlush() {
    }

}
