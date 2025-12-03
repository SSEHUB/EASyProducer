package net.ssehub.easy.instantiation.core.model.expressions;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaParameterDeclaration;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.varModel.model.values.NullValue;

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
            if (resolved.acceptsImplicitParameters()) {
                addImplicitParamters(named);
            }
        }
        int pCount = resolved.getParameterCount();
        if (acceptsNamed) {
            pCount++;
        }
        Object[] args = new Object[pCount];
        int aCount = 0;
        Map<String, Object> namedArgs = null;
        for (int p = 0; p < call.getArgumentsCount(); p++) {
            CallArgument arg = call.getArgument(p);
            if (!arg.hasName()) {
                args[aCount++] = arg.accept(this);
            } else {
                IMetaParameterDeclaration pDecl = resolved.getParameter(arg.getName());
                if (null != pDecl) {
                    if (null == namedArgs) {
                        namedArgs = new HashMap<String, Object>();
                    }
                    namedArgs.put(arg.getName(), arg.accept(this));
                }
            }
        }
        while (aCount < resolved.getParameterCount()) {
            IMetaParameterDeclaration pDecl = resolved.getParameter(aCount);
            Object val = null != namedArgs ? namedArgs.get(pDecl.getName()) : null;
            if (null == val && null != pDecl.getExpression()) {
                val = pDecl.getExpression().accept(this);
            }
            args[aCount++] = val;
        }
        if (acceptsNamed) {
            args[pCount - 1] = named;
        }
        resolved = AbstractCallExpression.dynamicDispatch(resolved, args, OperationDescriptor.class, 
            environment.getTypeRegistry(), call, null); // operandOverride unsure
        tracer.visitingCallExpression(resolved, type, args);
        if (resolved.storeArtifactsBeforeExecution()) {
            environment.storeArtifacts(true);
        }
        Object result = resolved.invoke(args);
        if (null == result && call.inferType() == TypeRegistry.voidType()) {
            // happens with aggregating iterators 
            result = NullValue.VALUE; // void methods otherwise cause failing of the calling rule / template
        }        
        tracer.visitedCallExpression(resolved, type, args, result);
        return result;        
    }

    /**
     * Adds additional implicit named parameters.
     * 
     * @param named the named parameters
     */
    protected void addImplicitParamters(java.util.Map<String, Object> named) {
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return cst.getValue();
    }
    
    @Override
    public Object visitStringExpression(StringExpression ex) throws VilException {
        Object res = ex.getExpression().accept(this);
        if (null != res) {
            res = StringValueHelper.getStringValueInReplacement(res, null);
        }
        return res;
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
        if (type.getGenericParameterCount() > 0) {
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
        return evaluateContentExpression(ex);
    }

    /**
     * Evaluates <code>iter</code> as a content expression.
     * 
     * @param iter the iterator
     * @return the evaluation result
     * @throws VilException if evaluation fails
     */
    protected String evaluateContentExpression(IExpressionIterator iter) throws VilException {
        String result = "";
        Expression lastEx = null;
        Object lastValue = null;
        boolean replaceEmptyLine = false;
        for (int e = 0; e < iter.getExpressionsCount(); e++) {
            Expression expression = iter.getExpression(e);
            Object value;
            try {
                value = expression.accept(this);
            } catch (VilException e1) {
                if (e1.getId() == VilException.ID_NOT_FOUND) {
                    result = null;
                    tracer.failedAt(expression);
                    break;
                } else {
                    throw e1;
                }
            }
            if (value != null) {
                String sValue = StringValueHelper.getStringValueInReplacement(value, null);
                if (replaceEmptyLine) { // if we shall check this, remove all directly following newlines
                    int i = 0;
                    do {
                        char c = sValue.charAt(i);
                        if (c == '\r' || c == '\n') {
                            i++;
                        } else {
                            break;
                        }
                    } while (i < sValue.length());
                    if (i > sValue.length()) {
                        sValue = null;
                    } else if (i > 0) {
                        sValue = sValue.substring(i);
                    }
                }
                if (null != sValue) {
                    result = appendInCompositeExpression(result, lastEx, lastValue, sValue, expression);
                }
            } else {
                result = null;
                break;
            }
            lastEx = expression;
            lastValue = value;
            // replace empty/newline line start if requested by last content statement and its own value is empty
            replaceEmptyLine = lastContentReplaceEmptyLine() && lastValue != null && lastValue.toString().length() == 0;
        }
        return result;
    }
    
    /**
     * Returns whether the last content commands that empty lines (itself empty, following line breaks) shall
     * be removed.
     * 
     * @return {@code true} for remove, {@code false} else
     */
    protected boolean lastContentReplaceEmptyLine() {
        return false;
    }
    
    /**
     * Appends <code>s2</code> to <code>s2</code> originating from the respective expressions. This
     * allows to potentially consider indentation formatting.
     * 
     * @param s1 the first string
     * @param e1 the expression causing <code>s1</code>
     * @param v1 the value causting <code>s1</code>
     * @param s2 the string to append
     * @param e2 the expression causing <code>s2</code>
     * @return the appended string
     */
    protected String appendInCompositeExpression(String s1, Expression e1, Object v1, String s2, Expression e2) {
        return s1 + s2;
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
            StringWriter out = new StringWriter();
            try {
                ExpressionWriter writer = new ExpressionWriter(out);
                ex.accept(writer);
            } catch (VilException e1) {
                out.append("(exception while printing expression: " + e1.getMessage());
            }
            TracerFactory.createInstantiatorTracer().traceError(e.getMessage() 
                + " while evaluating " + out.toString());
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

    @Override
    public Object visitMultiAndExpression(MultiAndExpression ex) throws VilException {
        Object result = Boolean.TRUE;
        for (int e = 0; Boolean.TRUE.equals(result) && e < ex.getExpressionCount(); e++) {
            result = ex.getExpression(e).accept(this);
        }
        return result;
    }

    
}
