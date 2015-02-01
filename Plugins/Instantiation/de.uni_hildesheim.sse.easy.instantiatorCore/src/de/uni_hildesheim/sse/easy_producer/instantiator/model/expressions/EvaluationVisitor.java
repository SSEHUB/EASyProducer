package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

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
    public Object visitParenthesisExpression(ParenthesisExpression par) throws ExpressionException {
        return par.getExpr().accept(this);
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws ExpressionException {
        OperationDescriptor resolved = call.getResolved();
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
        try {
            resolved = AbstractCallExpression.dynamicDispatch(resolved, args, OperationDescriptor.class, 
                environment.getTypeRegistry());
            tracer.visitingCallExpression(resolved, call.getCallType(), args);
            if (resolved.storeArtifactsBeforeExecution()) {
                environment.storeArtifacts();
            }
            Object result = resolved.invoke(args);
            tracer.visitedCallExpression(resolved, call.getCallType(), args, result);
            return result;
        } catch (VilException e) {
            throw new ExpressionException(e);
        } catch (ArtifactException e) {
            throw new ExpressionException(e);
        }
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException {
        return cst.getValue();
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws ExpressionException {
        return environment.getIvmlValue(identifier.getIdentifier());
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws ExpressionException {
        return typeExpression.getResolved(); //.getTypeClass();
    }
    
    @Override
    public Object visitVariableExpression(VariableExpression cst) throws ExpressionException {
        return environment.getValue(cst.getDeclaration());
    }

    @Override
    public Object visitExpression(Expression ex) throws ExpressionException {
        return null;
    }
    
    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws ExpressionException {
        ex.bind(this);
        return ex;
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws ExpressionException {
        try {
            VariableDeclaration var = ex.getVarDecl();
            Object val = ex.getValueExpression().accept(this);
            environment.setValue(var, val);
            notifyValueDefined(var, val);
        } catch (VilLanguageException e) {
            throw new ExpressionException(e);
        }
        return Boolean.TRUE;
    }
    
    /**
     * Is called when a value of a value is defined.
     * 
     * @param var the variable
     * @param val the value
     */
    protected void notifyValueDefined(VariableDeclaration var, Object val) {
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws ExpressionException {
        Object result;
        List<Object> data = new ArrayList<Object>();
        TypeDescriptor<? extends IVilType> type = ex.inferType();
        for (int e = 0; e < ex.getInitExpressionsCount(); e++) {
            data.add(ex.getInitExpression(e).accept(this));
        }
        TypeDescriptor<? extends IVilType>[] param;
        if (type.getParameterCount() > 1) {
            param = TypeDescriptor.createArray(type.getParameterCount());
            for (int p = 0; p < param.length; p++) {
                param[p] = type.getParameterType(p);
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

}
