package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression.CallType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FieldDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * A basic visitor for evaluating expressions.
 * 
 * @author Holger Eichelberger
 */
public class EvaluationVisitor implements IExpressionVisitor {

    private IRuntimeEnvironment environment;
    private ITracer tracer;
    
    /**
     * Creates a new evaluation visitor.
     * 
     * @param environment the runtime environment carrying the variable assignments
     * @param tracer a tracer for being informed about the actual execution
     */
    public EvaluationVisitor(IRuntimeEnvironment environment, ITracer tracer) {
        this.environment = environment;
        this.tracer = tracer;
    }
    
    /**
     * Returns the runtime environment (needed for iterator evaluation).
     * 
     * @return the runtime environment
     */
    public IRuntimeEnvironment getRuntimeEnvironment() {
        return environment;
    }
    
    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        return par.getExpr().accept(this);
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        /*OperationDescriptor resolved = call.getResolved();
        java.util.Map<String, Object> named = null;
        boolean acceptsNamed = resolved.acceptsNamedParameters();
        if (acceptsNamed) {
            named = new HashMap<String, Object>();
            for (int p = 0; p < call.getArgumentsCount(); p++) {
                CallArgument arg = call.getArgument(p);
                if (arg.hasName()) {
                    named.put(arg.getName(), arg.accept(this));
                }
            }
            if (null != call.getParent() && resolved.acceptsImplicitParameters()) {
                named.put(Constants.IMPLICIT_PARENT_PARAMETER_NAME, call.getParent());
                named.put(Constants.IMPLICIT_PATHS_PARAMETER_NAME, environment.getContextPaths());
            }
        }
        int pCount = resolved.getParameterCount();
        if (acceptsNamed) {
            pCount++;
        }
        Object[] args = new Object[pCount];
        int aCount = 0;
        for (int p = 0; p < call.getArgumentsCount(); p++) {
            CallArgument arg = call.getArgument(p);
            if (!arg.hasName()) {
                args[aCount++] = arg.accept(this);
            }
        }
        if (acceptsNamed) {
            args[pCount - 1] = named;
        }
        resolved = AbstractCallExpression.dynamicDispatch(resolved, args, OperationDescriptor.class, 
            environment.getTypeRegistry());
        tracer.visitingCallExpression(resolved, call.getCallType(), args);
        if (resolved.storeArtifactsBeforeExecution()) {
            environment.storeArtifacts();
        }
        Object result = resolved.invoke(args);
        tracer.visitedCallExpression(resolved, call.getCallType(), args, result);
        return result;*/
        return visitCall(call, call.getParent(), call.getResolved(), call.getCallType());
    }

    /**
     * Processes a call.
     * 
     * @param call the call expression holding the arguments
     * @param parent the parent of the call (may be <b>null</b>)
     * @param resolved the resolved operation to be called
     * @param type the call type
     * @return the result of executing the call
     * @throws VilException in case that the call or the evaluation of the arguments fails
     */
    private Object visitCall(AbstractCallExpression call, Object parent, OperationDescriptor resolved, CallType type) 
        throws VilException {
        java.util.Map<String, Object> named = null;
        boolean acceptsNamed = resolved.acceptsNamedParameters();
        if (acceptsNamed) {
            named = new HashMap<String, Object>();
            for (int p = 0; p < call.getArgumentsCount(); p++) {
                CallArgument arg = call.getArgument(p);
                if (arg.hasName()) {
                    named.put(arg.getName(), arg.accept(this));
                }
            }
            if (null != parent && resolved.acceptsImplicitParameters()) {
                named.put(Constants.IMPLICIT_PARENT_PARAMETER_NAME, parent);
                named.put(Constants.IMPLICIT_PATHS_PARAMETER_NAME, environment.getContextPaths());
            }
        }
        int pCount = resolved.getParameterCount();
        if (acceptsNamed) {
            pCount++;
        }
        Object[] args = new Object[pCount];
        int aCount = 0;
        for (int p = 0; p < call.getArgumentsCount(); p++) {
            CallArgument arg = call.getArgument(p);
            if (!arg.hasName()) {
                args[aCount++] = arg.accept(this);
            }
        }
        if (acceptsNamed) {
            args[pCount - 1] = named;
        }
        resolved = AbstractCallExpression.dynamicDispatch(resolved, args, OperationDescriptor.class, 
            environment.getTypeRegistry());
        tracer.visitingCallExpression(resolved, type, args);
        if (resolved.storeArtifactsBeforeExecution()) {
            environment.storeArtifacts();
        }
        Object result = resolved.invoke(args);
        tracer.visitedCallExpression(resolved, type, args, result);
        return result;        
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return cst.getValue();
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws VilException {
        return environment.getIvmlValue(identifier.getIdentifier());
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
        return typeExpression.getResolved(); //.getTypeClass();
    }
    
    @Override
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
        return environment.getValue(cst.getDeclaration());
    }

    @Override
    public Object visitExpression(Expression ex) throws VilException {
        return null;
    }
    
    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        ex.bind(this);
        return ex;
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
        Object result;
        VariableDeclaration var = ex.getVarDecl();
        FieldDescriptor field = ex.getField();
        Object val = ex.getValueExpression().accept(this);
        if (null != val) {
            try {
                if (null != field) {
                    field.setValue(environment.getValue(var), val);
                } else {
                    environment.setValue(var, val);
                }
                notifyValueDefined(var, field, val);
                result = Boolean.TRUE;
            } catch (VilException e) {
                result = null;
                TracerFactory.createInstantiatorTracer().traceError(e.getMessage());
            }
        } else {
            result = null; // undefined
        }
        return result;
    }
    
    /**
     * Is called when a value of a value is defined.
     * 
     * @param var the variable
     * @param field the field in <code>var</code>, may be <b>null</b>
     * @param val the value
     */
    protected void notifyValueDefined(VariableDeclaration var, FieldDescriptor field, Object val) {
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        Object result;
        List<Object> data = new ArrayList<Object>();
        TypeDescriptor<?> type = ex.inferType();
        for (int e = 0; e < ex.getInitExpressionsCount(); e++) {
            data.add(ex.getInitExpression(e).accept(this));
        }
        TypeDescriptor<?>[] param;
        if (type.getGenericParameterCount() > 1) {
            param = TypeDescriptor.createArray(type.getGenericParameterCount());
            for (int p = 0; p < param.length; p++) {
                param[p] = type.getGenericParameterType(p);
            }
        } else {
            param = TypeDescriptor.createArray(1);
            param[0] = type;
        }
        if (type.isSet()) {
            result = new ListSet<Object>(data, param);
        } else {
            result = new ListSequence<Object>(data, param);
        }
        return result;
    }

    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        String result = "";
        for (Expression expression : ex.getExpressionList()) {
            Object value;
            try {
                value = expression.accept(this);
            } catch (VilException e) {
                if (e.getId() == VilException.ID_NOT_FOUND) {
                    result = null;
                    break;
                } else {
                    throw e;
                }
            }
            if (value != null) {
                result += StringValueHelper.getStringValueInReplacement(value, null);
            } else {
                result = null;
                break;
            }
        }
        return result;
    }

    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
        Object result = null;
        try {
            Object ownerValue;
            if (null != ex.getVariable()) {
                ownerValue = environment.getValue(ex.getVariable()); 
            } else {
                if (null == ex.getNested()) { // static -> variable == null
                    ownerValue = null; 
                } else {
                    ownerValue = ex.getNested().accept(this);
                }
            }
            if (ex.isMetaAccess()) {
                result = ex.getField().getMetaValue(ownerValue);
            } else {
                result = ex.getField().getValue(ownerValue);
            }
        } catch (VilException e) {
            // -> undefined
            TracerFactory.createInstantiatorTracer().traceError(e.getMessage());
        }
        return result;
    }

    @Override
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
        return ex.getOperation();
    }

    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        Object result = null;
        Object val = environment.getValue(ex.getVariable());
        if (val instanceof OperationDescriptor) {
            result = visitCall(ex, null, (OperationDescriptor) val, CallType.NORMAL);
        } else if (val instanceof Expression) {
            result = ((Expression) val).accept(this);
        }
        return result;
    }

}
