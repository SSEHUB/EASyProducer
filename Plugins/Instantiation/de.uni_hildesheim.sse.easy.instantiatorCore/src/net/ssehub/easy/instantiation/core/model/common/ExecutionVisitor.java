package net.ssehub.easy.instantiation.core.model.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.buildlangModel.AlternativeExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.MapExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult.Status;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.EvaluationVisitor;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IArgumentProvider;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionParser;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Extends the basic expression evaluation visitor for the execution of those classes being
 * defined in this package.
 * 
 * @param <M> the actual model type
 * @param <O> the actual operation type
 * @param <V> the actual variable declaration type
 * 
 * @author Holger Eichelberger
 */
public abstract class ExecutionVisitor <M extends IResolvableModel<V>, O extends IResolvableOperation<V>, 
    V extends VariableDeclaration> extends EvaluationVisitor implements IVisitor {

    private RuntimeEnvironment<V> environment;
    private ITracer tracer;
    private Map<String, Object> parameter;

    /**
     * Creates an execution visitor.
     * 
     * @param environment the runtime environment
     * @param tracer the execution tracer instance (for testing)
     * @param parameter the parameter given from outside for the execution of the model
     */
    protected ExecutionVisitor(RuntimeEnvironment<V> environment, ITracer tracer, Map<String, Object> parameter) {
        super(environment, tracer);
        this.environment = environment;
        this.tracer = tracer;
        tracer.setRuntimeEnvironment(environment);
        this.parameter = parameter;
    }
    
    /**
     * Exchanges the current script parameter in case of context changes. [better - assign to context]
     * 
     * @param parameter the new parameter set
     * @return the old parameter set
     */
    protected Map<String, Object> replaceParameter(Map<String, Object> parameter) {
        Map<String, Object> result = parameter;
        this.parameter = parameter;
        return result;
    }
    
    /**
     * Returns the runtime environment (for testing).
     * 
     * @return the runtime environment
     */
    @Override
    public RuntimeEnvironment<V> getRuntimeEnvironment() {
        return environment;
    }

    /**
     * Returns the specified parameter.
     * 
     * @param name the name of the parameter
     * @return the value of the parameter
     */
    protected Object getParameter(String name) {
        return parameter.get(name);
    }

    /**
     * Enables/disables auto storing parameters upon variables becoming unavailable.
     * 
     * @param autoStore do auto store or not
     */
    protected void enableArtifactAutoStoreOnParameters(boolean autoStore) {
        if (null != parameter) {
            for (Object a : parameter.values()) {
                if (a instanceof IArtifact) {
                    if (autoStore) {
                        environment.unmarkNoAutoStore((IArtifact) a);
                    } else {
                        environment.markNoAutoStore((IArtifact) a);
                    }
                }
            }
        }
    }
    
    /**
     * Releases the resources allocated by this execution.
     * 
     * @param releaseDefault shall also default artifacts, i.e., artifacts that cannot be assigned to a source / target
     *   artifact model be released? May affect execution of other VIL models.
     */
    public void release(boolean releaseDefault) {
    }
    
    /**
     * Returns whether the specified parameter is defined.
     * 
     * @param name the name of the parameter
     * @return <code>true</code> if the parameter is defined, <code>false</code> else
     */
    protected boolean hasParameter(String name) {
        return parameter.containsKey(name);
    }
    
    /**
     * Returns the number of parameters.
     * 
     * @return the number of parameters
     */
    protected int getParameterCount() {
        return parameter.size();
    }
    
    /**
     * Returns the tracer instance..
     * 
     * @return the tracer instance
     */
    protected ITracer getTracer() {
        return tracer;
    }
    
    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        Object value = null;
        @SuppressWarnings("unchecked")
        V v = (V) var;
        if (null != var.getExpression()) {
            value = var.getExpression().accept(this);
            if (var.getType().isMap()) {
                value = net.ssehub.easy.instantiation.core.model.vilTypes.Map.checkConvertEmpty(
                    var.getType(), value);
            }
            environment.addValue(v, value);
            tracer.valueDefined(var, null, value);
        } else {
            // add as undefined to current level in runtime environment. otherwise variable may be assigned implicitly 
            // to wrong level upon first assignment, which may be removed (e.g., inner levels of alternatives 
            // containing initial assignment), and thus not be valid outside on correct level
            environment.addValue(v, null); 
        }
        return value;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        // shall be ignored here
        return null;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        return statement.getExpression().accept(this);
    }

    @Override
    protected void notifyValueDefined(VariableDeclaration var, FieldDescriptor field, Object val) {
        tracer.valueDefined(var, field, val);
    }
    
    /**
     * Specifies various types of artifact condition tests.
     * 
     * @author Holger Eichelberger
     */
    protected enum ConditionTest {
        
        /**
         * The artifact must exist {@link IArtifact#exists()}.
         */
        EXISTS,

        /**
         * Don't care for specific artifact checks.
         */
        DONT_CARE
    }
    
    /**
     * Checks the results of an evaluation of a condition.
     * 
     * @param value the evaluation result
     * @param element the element to check on
     * @param test how to test individual artifacts
     * @return <code>true</code> if the condition is fulfilled, <code>false</code> else
     */
    protected boolean checkConditionResult(Object value, Object element, ConditionTest test) {
        boolean ok = true;
        if (null == value) {
            ok = false;
        } else if (value instanceof Collection) {
            Collection<?> collection = (Collection<?>) value;
            if (0 == collection.size()) {
                ok = false;
            } else {
                Iterator<?> iter = collection.iterator();
                while (iter.hasNext()) {
                    ok = checkConditionResult(iter.next(), element, test);
                    if (!ok) {
                        break;
                    }
                }
            }
        } else if (Boolean.class.isInstance(value)) {
            ok = ((Boolean) value).booleanValue();
        } else if (value instanceof IArtifact) {
            switch (test) {
            case EXISTS:
                ok = ((IArtifact) value).exists();
                break;
            default:
                ok = true;
                break;
            }
        }
        return ok;
    }

    /**
     * Visits the related model headers.
     * 
     * @param model the model to be visited
     * @throws VilException in case that visiting fails (cyclic inclusion)
     */
    public void visitModelHeader(IResolvableModel<V> model) throws VilException {
        Set<IResolvableModel<V>> visited = new HashSet<IResolvableModel<V>>();
        visitModelHeader(model, visited);
    }

    /**
     * Visits the related model headers.
     * 
     * @param model the model to be visited
     * @param visited the already visited models
     * @throws VilException in case that visiting fails for some reason
     */
    @SuppressWarnings("unchecked")
    private void visitModelHeader(IResolvableModel<V> model, Set<IResolvableModel<V>> visited) 
        throws VilException {
        if (!visited.contains(model)) {
            visited.add(model);
            IResolvableModel<V> oldContext = environment.switchContext(model);
            processModelParameter(model);
            for (int i = 0; i < model.getImportsCount(); i++) {
                ModelImport<?> imp = model.getImport(i);
                IResolvableModel<V> imported = (IResolvableModel<V>) model.getImport(i).getResolved();
                if (null != imported) {
                    visitModelHeader(imported, visited);
                } else {
                    throw new VilException(imp.getName() + " is not resolved ", 
                        VilException.ID_RUNTIME_NOT_RESOLVED);
                }
            }
            initializeImplicitVariables(model);
            for (int v = 0; v < model.getVariableDeclarationCount(); v++) {
                V varDecl = model.getVariableDeclaration(v);
                if (!model.isImplicit(varDecl)) {
                    model.getVariableDeclaration(v).accept((IVisitor) this);
                }
            }
            environment.switchContext(oldContext);
        }
    }

    /**
     * Initializes implicit variables of a model (before explicitly defined variables).
     * 
     * @param model the model being initialized
     * @throws VilException in case that the initialization fails, e.g., assigning values
     */
    protected void initializeImplicitVariables(IResolvableModel<V> model) throws VilException {
    }

    /**
     * Defines the value of a given model/main argument and allows (by overriding) implicit (programmed) 
     * conversion of main arguments.
     * 
     * @param param the model/main parameter corresponding to the argument
     * @param value the actual value of the argument
     * @throws VilException in case that setting the value fails due to type conflicts or as a 
     *     constant shall be modified
     */
    protected void setModelArgument(V param, Object value) throws VilException {
        environment.addValue(param, value);
    }
    
    /**
     * Processes the parameters of <code>model</code>. Calls {@link #handleParameterInSequence(IResolvableModel, Map)}.
     * 
     * @param model the model to be processed
     * @throws VilException in case of execution errors
     */
    protected void processModelParameter(IResolvableModel<V> model) throws VilException {
        Map<String, V> sParam = new HashMap<String, V>();
        for (int p = 0; p < model.getParameterCount(); p++) {
            V param = model.getParameter(p);
            sParam.put(param.getName(), param);
        }
        handleParameterInSequence(model, sParam);
        for (Map.Entry<String, Object> param : parameter.entrySet()) {
            String name = param.getKey();
            if (sParam.containsKey(name)) {
                setModelArgument(sParam.get(name), param.getValue());
                sParam.remove(name);
            }
        }
        for (Map.Entry<String, V> unbound : sParam.entrySet()) {
            setModelArgument(unbound.getValue(), null);
        }
    }

    /**
     * Handles model parameters in sequence if appropriate. If and only if mapping is possible, this method shall
     * modify <code>varMap</code> by removing assigned parameters. Otherwise, no error shall be emitted by this
     * method. Implemented empty in this class as intended for overriding.
     * 
     * @param model the model to be processed
     * @param varMap a mapping of parameter names to implementing variable declarations, to be modified as a side
     *   effect if parameters are bound
     * @throws VilException in case of execution errors
     */
    protected void handleParameterInSequence(IResolvableModel<V> model, Map<String, V> varMap) 
        throws VilException {
    }

    /**
     * Determines script parameters from a call, i.e., takes over arguments and fixes them.
     * 
     * @param call the call to be executed
     * @return the script parameter (may be <b>null</b>)
     * @throws VilException in case of evaluation problems
     */
    protected Map<String, Object> determineScriptParam(ModelCallExpression<V, M, O> call) throws VilException {
        Map<String, Object> result = null;
        if (null != call) {
            if (null == call.getResolved()) {
                throw new VilException("cannot execute rule " + call.getVilSignature() 
                    + " as it is not resolved", VilException.ID_RUNTIME_NOT_RESOLVED);
            }
            O resolved = call.getResolved();
            // fix the parameter for the call in this context, i.e., fix expressions into other context 
            result = new HashMap<String, Object>();
            for (int a = 0; a < call.getArgumentsCount(); a++) {
                CallArgument arg = call.getArgument(a);
                Object val = arg.fixValue(this);
                String name = arg.getName();
                if (null == name && a < resolved.getParameterCount()) {
                    name = resolved.getParameter(a).getName();
                }
                result.put(name, val);
            }
        }
        return result;
    }
    
    /**
     * Visits a model call expression. Currently, this method is intended
     * to facilitate reuse and not declared in the visitor in order to avoid
     * further template parameters etc. This method calls 
     * {@link #executeModelCall(IResolvableOperation)}.
     * 
     * @param call the call to be visited
     * @return the result of the execution
     * @throws VilException in case that the execution fails
     */
    protected Object visitModelCallExpression(ModelCallExpression<V, M, O> call) throws VilException {
        return proceedModelCall(call.getResolved(), call.getQualifiedName(), call.getModel(), call, 
            call.isPlaceholder());
    }
    
    /**
     * Performs a model call. Currently, this method is intended
     * to facilitate reuse, in particular for VTL. This method calls 
     * {@link #executeModelCall(IResolvableOperation)}.
     * 
     * @param resolved the resolved operation
     * @param qName the (qualified) name to be used with the tracer
     * @param model the containing model
     * @param arguments the call arguments
     * @param isPlaceholder whether <code>resolved</code> shall be treated as a placeholder operatio
     * @return the result of the execution
     * @throws VilException in case that the execution fails
     */
    protected Object proceedModelCall(O resolved, String qName, M model, IArgumentProvider arguments, 
        boolean isPlaceholder) throws VilException {
        Object result;
        if (isPlaceholder) {
            result = null;
        } else {
            // evaluate in this context before context switch
            Status status = Status.SUCCESS;
            Object[] args = new Object[arguments.getArgumentsCount()];
            Map<String, Object> namedArgs = null;
            for (int a = 0; Status.SUCCESS == status && a < arguments.getArgumentsCount(); a++) {
                CallArgument ca = arguments.getArgument(a);
                Object argVal = ca.accept(this);
                if (null == ca.getName() || ca.getName().equals(resolved.getParameter(a).getName())) {
                    args[a] = argVal;
                }
                if (null != ca.getName()) {
                    if (null == namedArgs) {
                        namedArgs = new HashMap<String, Object>();
                    }
                    namedArgs.put(ca.getName(), argVal);
                }
                if (argVal instanceof RuleExecutionResult) {
                    status = ((RuleExecutionResult) argVal).getStatus();
                }
            }
            if (Status.SUCCESS == status) {
                IResolvableModel<V> oldContext = environment.switchContext(model);
                environment.pushLevel();
                assignModelParameter(model, oldContext);
                if (null == resolved) {
                    throw new VilException("call " + qName + " is not resolved", 
                        VilException.ID_RUNTIME);
                }
                O operation = dynamicDispatch(resolved, args, arguments);
                int reqParamCount = operation.getRequiredParameterCount();
                for (int p = 0; p < operation.getParameterCount(); p++) {
                    V param = operation.getParameter(p);
                    if (p < reqParamCount) {
                        environment.addValue(param, args[p]);    
                    } else {
                        if (p >= args.length || p >= reqParamCount) {
                            Object pVal = null == namedArgs ? null : namedArgs.get(param.getName());
                            if (null == pVal && p < args.length) {
                                pVal = args[p];
                            }
                            if (null == pVal) {
                                pVal = evaluateDefault(param); // no value, try default; no default, pVal still null
                            }
                            if (null != pVal) { // legacy: optional named parameters;
                                environment.addValue(param, pVal);
                            }
                        } else {
                            if (null == args[p]) {
                                args[p] = evaluateDefault(param); // no value, try default; no deflt, args[p] still null
                            }
                            environment.addValue(param, args[p]);
                        }
                    }
                }
                result = executeModelCall(operation);
                environment.popLevel();
                environment.switchContext(oldContext);
            } else {
                result = null;
            }
        }
        return result;        
    }
    
    /**
     * Evaluates the default value of <code>decl</code>.
     * 
     * @param decl the declaration to evaluate the default value for
     * @return the default value or <b>null</b> if none was defined
     * @throws VilException if evaluating the default value (if defined) fails
     */
    private Object evaluateDefault(VariableDeclaration decl) throws VilException {
        Object result;
        if (null != decl.getExpression()) {
            // no value, try default
            result = decl.getExpression().accept(this);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Assigns the model parameters. Allows to use model-specific code.
     * 
     * @param targetModel the target model to be executed
     * @param srcModel the source model to take the (named, optional) parameters from
     * @throws VilException if accessing parameters / assigning values fails
     */
    protected abstract void assignModelParameter(IResolvableModel<V> targetModel, IResolvableModel<V> srcModel) 
        throws VilException;

    /**
     * Assigns the model parameters.
     * 
     * @param targetModel the target model to be executed
     * @param srcModel the source model to take the (named, optional) parameters from
     * @param startIndex which parameter to start from
     * @throws VilException if accessing parameters / assigning values fails
     */
    protected void evaluateModelParameter(IResolvableModel<V> targetModel, IResolvableModel<V> srcModel, int startIndex)
        throws VilException {
        RuntimeEnvironment<V> env = getRuntimeEnvironment();
        for (int p = startIndex; p < targetModel.getParameterCount(); p++) {
            V param = targetModel.getParameter(p);
            Object val = getParameter(param.getName());
            if (null == val) {
                try {
                    val = env.getValue(srcModel, param.getName());
                } catch (VilException e) {
                    // ignore for now
                }
            }
            if (null == val && null != param.getExpression()) {
                val = param.getExpression().accept(this);
            }
            if (null != val) {
                setModelArgument(param, val);
            } // else exception?
        }
    }
    
    /**
     * Performs the dynamic dispatch on the operation type.
     * 
     * @param operation the operation to be dispatched
     * @param args the actual arguments
     * @param argumentProvider access to the argument expressions
     * @return <code>operation</code> or the more actual operation
     */
    protected abstract O dynamicDispatch(O operation, Object[] args, IArgumentProvider argumentProvider);
    
    /**
     * Actually executes a model call. Basically, a subclassing visitor shall
     * call the related visit method. Currently, this method is intended
     * to facilitate reuse and not declared in the visitor in order to avoid
     * further template parameters etc.
     * 
     * @param operation the operation to be executed
     * @return the execution result
     * @throws VilException in case that execution fails
     */
    protected abstract Object executeModelCall(O operation) throws VilException;

    /**
     * Executes the main operation. Prerequisite is that (at least the leading) parameters of <code>model</code>
     * are assignable to the parameters of the <code>operation</code>. This must be ensured by the caller. More
     * parameters in <code>model</code> ("varargs" passed from the instantiator) are ignored.
     * 
     * @param model the model to execute the operation on
     * @param operation the operation
     * @return the result of the execution
     * @throws VilException if execution fails
     */
    protected Object executeMain(M model, O operation) throws VilException {
        Object result;
        environment.pushLevel();
        environment.increaseIndentation();
        // we do the main call via the call expression to get the parameter right
        // we just ignore more parameters in the model
        CallArgument[] args = new CallArgument[operation.getParameterCount()];
        int commonParameterCount = Math.min(operation.getParameterCount(), model.getParameterCount());
        for (int p = 0; p < commonParameterCount; p++) {
            V opPar = operation.getParameter(p);
            V modelPar = model.getParameter(p);
            if (!opPar.getType().isAssignableFrom(modelPar.getType())) {
                throw new VilException("model parameter " + modelPar.getName() + " of type " 
                    + modelPar.getType().getVilName() + " is not assignable to parameter " + opPar.getName() 
                    + " of type " + opPar.getType().getVilName() + " in " + operation.getName(), 
                    VilException.ID_RUNTIME_TYPE);
            }
            args[p] = new CallArgument(new VariableExpression(model.getParameter(p)));
        }
        ModelCallExpression<V, M, O> call = createModelCall(model, operation, args);
        result = call.accept(this);
        environment.decreaseIndentation();
        environment.popLevel();
        environment.storeArtifacts(false); // store artifacts in global variables
        return result;
    }
    
    /**
     * Creates a model call expression instance.
     * 
     * @param model the model
     * @param operation the operation to be called on <code>model</code>
     * @param arguments the arguments
     * @return the call expression instance
     * @throws VilException in case of an erroneously qualified name
     */
    protected abstract ModelCallExpression<V, M, O> createModelCall(M model, O operation, CallArgument...arguments) 
        throws VilException;

    /**
     * Returns whether a rule element may fail.
     * 
     * @param elt the element to be checked
     * @return <code>true</code> if the element may fail (guard expression), <code>false</code> else
     */
    protected boolean mayFail(Object elt) {
        boolean result = false;
        if (elt instanceof ExpressionStatement) {
            ExpressionStatement ee = (ExpressionStatement) elt;
            Expression ex = ee.getExpression();
            // not nice, just an experiment
            result = !(ex instanceof CallExpression || ex instanceof MapExpression 
                || ex instanceof ModelCallExpression || ex instanceof AlternativeExpression);
        }
        return result;
    }
    
    /**
     * Converts the actual <code>value</code> of <code>expr</code> to a container
     * if required and possible.
     *  
     * @param expr the expression
     * @param value the actual value of expression 
     * @param eltName the name of the language element / concept, e.g., "loop" or "map"
     * @return the converted <code>value</code> or <code>value</code>
     * @throws VilException in case of conversion problems
     */
    protected Object convertToContainer(Expression expr, Object value, String eltName) throws VilException {
        TypeDescriptor<?> type = expr.inferType();
        if (type.isIterator()) {
            List<Object> result = new ArrayList<Object>();
            Iterator<?> iter = (Iterator<?>) value;
            while (iter.hasNext()) {
                result.add(iter.next());
            }
            value = new ListSequence<Object>(result, type.getGenericParameter());
        } else if (!type.isCollection()) {
            OperationDescriptor desc = type.getConversionToSequence();
            if (null != desc) {
                value = desc.invoke(value);
            } else {
                throw new VilException("cannot convert " + eltName + " variable to container", 
                    VilException.ID_RUNTIME);
            }
        }
        return value;
    }
    
    /**
     * Returns the actual expression parser.
     * 
     * @return the actual expression parser
     */
    protected abstract IExpressionParser getExpressionParser();

}
