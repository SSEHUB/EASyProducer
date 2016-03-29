package de.uni_hildesheim.sse.easy_producer.instantiator.model.tracing;

import java.io.StringWriter;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IBuildlangElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IEnumeratingLoop;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.IInstantiatorTracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression.CallType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Def;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITemplateLangElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FieldDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;

/**
 * Implements a combined tracer for VIL and VTL with common indentation.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractVilTracer 
    implements de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer, 
    de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer, IInstantiatorTracer {

    private static final String INDENTATION_STEP = "  ";
    private String indentation = "";
    
    /**
     * Creates a tracer instance.
     */
    protected AbstractVilTracer() {
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
        writeImpl(indentation + msg);
    }

    /**
     * Writes a message.
     * 
     * @param msg the message to be written
     */
    protected abstract void writeImpl(String msg);
    
    @Override
    public void trace(String text) {
    }

    @Override
    public void valueDefined(VariableDeclaration var, FieldDescriptor field, Object value) {
    }

    @Override
    public void traceExecutionException(VilException exception) {
        write("exception " + exception.getMessage());
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
        if (TracerHelper.trace(descriptor)) {
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
    public void visitRule(Rule rule, RuntimeEnvironment environment) {
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

    @Override
    public void visitedRule(Rule rule, RuntimeEnvironment environment, Object result) {
        decreaseIndentation();
    }

    @Override
    public void visitLoop(IEnumeratingLoop map, RuntimeEnvironment environment) {
    }

    @Override
    public void visitIteratorAssignment(IEnumeratingLoop loop, 
        de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration var,
        Object value) {
    }

    @Override
    public void visitedLoop(IEnumeratingLoop loop, RuntimeEnvironment environment) {
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
        if (args.length > 0) {
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
    }

    @Override
    public void failedAt(IBuildlangElement element) {
        StringWriter out = new StringWriter();
        BuildlangWriter writer = new BuildlangWriter(out);
        try {
            element.accept(writer);
        } catch (VilException e) {
        }
        write("failed at: " + out.toString());
    }

    @Override
    public void visitScript(Script script) {
        String ver = Version.toString(script.getVersion());
        if (null != ver && ver.length() > 0) {
            ver = " version " + ver;
        }
        String location = "";
        ModelInfo<Script> info = BuildModel.INSTANCE.availableModels().getModelInfo(script);
        if (null != info) {
            location = " @ " + info.getLocation();
        }
        write("executing script " + script.getName() + ver + location);
        increaseIndentation();
    }

    @Override
    public void visitedScript(Script script) {
        decreaseIndentation();
    }

    @Override
    public void visitDef(Def def, RuntimeEnvironment environment) {
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

    @Override
    public void visitedDef(Def def, RuntimeEnvironment environment, Object result) {
        decreaseIndentation();
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
        StringWriter out = new StringWriter();
        TemplateLangWriter writer = new TemplateLangWriter(out);
        try {
            element.accept(writer);
        } catch (VilException e) {
        }
        write("failed at: " + out.toString());
    }

    @Override
    public void visitTemplate(Template template) {
        String location = "";
        ModelInfo<Template> info = TemplateModel.INSTANCE.availableModels().getModelInfo(template);
        if (null != info) {
            location = " @ " + info.getLocation();
        }
        write(template.getName() + " " + Version.toString(template.getVersion()) + location);
        increaseIndentation();
    }

    @Override
    public void visitedTemplate(Template template) {
        decreaseIndentation();
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

    /**
     * Trace an error (usually going to System.err in an instantiator).
     * 
     * @param message the message to be traced
     */
    public void traceError(String message) {
        write(message);
    }

    @Override
    public void visitWhileBody() {
    }

    @Override
    public void visitedWhileBody() {
    }

}
