package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.io.StringWriter;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.cst.CSTSemanticException;

/**
 * A version restriction based on expressions.
 * 
 * @author Holger Eichelberger
 */
public abstract class ExpressionVersionRestriction implements IVersionRestriction {

    private Expression expr;
    private VariableDeclaration versionVariable;
    
    /**
     * Creates a new expression version restriction.
     * 
     * @param expr the version restriction expression
     * @param versionVariable the variable representing the actual version of the project to be imported
     * @throws RestrictionEvaluationException in case of type compliance problems
     */
    public ExpressionVersionRestriction(Expression expr, VariableDeclaration versionVariable) 
        throws RestrictionEvaluationException {
        this.expr = expr;
        this.versionVariable = versionVariable;
        try {
            TypeDescriptor<?> type = expr.inferType();
            if (!TypeRegistry.booleanType().isAssignableFrom(type)) {
                throw new RestrictionEvaluationException("restriction expression must be of type Boolean", 
                    CSTSemanticException.TYPE_MISMATCH);
            }
        } catch (VilException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId(), e);
        }
    }
    
    /**
     * Creates a typical single restriction from the given variable (see {@link #createRestrictionVars(String)}, the
     * operator and the version.
     * 
     * @param var the variable to use
     * @param operator the operator
     * @param version the version
     * @return the expression
     * @throws VilException in case of type problems
     */
    public static Expression createSingleRestriction(VariableDeclaration var, String operator, 
        Version version) throws VilException {
        Expression result = new VariableExpression(var);
        Expression varConst = new ConstantExpression(TypeRegistry.versionType(), version, TypeRegistry.DEFAULT);
        result = new CallExpression(null, operator, result, varConst);
        result.inferType();
        return result;
    }

    
    @Override
    public void emit(Object context) {
        if (context instanceof IExpressionVisitor) {
            try {
                expr.accept((IExpressionVisitor) context);
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
            }
        }
    }

    @Override
    public String toSpecification() {
        StringWriter out = new StringWriter();
        ExpressionWriter writer = new ExpressionWriter(out);
        try {
            expr.accept(writer);
        } catch (VilException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
        }
        return out.toString();
    }

    @Override
    public boolean evaluate(IRestrictionEvaluationContext context, Version version) 
        throws RestrictionEvaluationException {
        boolean result = false;
        if (context instanceof IRuntimeEnvironment) {
            Object visitor = context.startEvaluation();
            try {
                context.setValue(versionVariable, version);
                Object tmp = expr.accept((IExpressionVisitor) visitor);
                context.unsetValue(versionVariable);
                if (tmp instanceof Boolean) {
                    result = ((Boolean) tmp).booleanValue();
                } else if (null != tmp) {
                    context.endEvaluation(visitor);
                    throw new RestrictionEvaluationException("expression does not evaluate to Boolean", 
                        VilException.ID_INTERNAL);
                }
            } catch (VilException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
            }
            context.endEvaluation(visitor);
        }
        return result;
    }
    
    /**
     * Returns the restriction expression.
     * 
     * @return the restriction expression
     */
    protected Expression getExpression() {
        return expr;
    }
    
    /**
     * Returns the version variable.
     * 
     * @return the version variable
     */
    protected VariableDeclaration getVersionVariable() {
        return versionVariable;
    }

}
