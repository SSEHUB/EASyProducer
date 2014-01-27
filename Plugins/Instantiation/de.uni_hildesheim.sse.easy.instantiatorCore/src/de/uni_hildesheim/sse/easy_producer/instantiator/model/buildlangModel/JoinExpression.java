package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Realizes a VIL join, typically over the variability model configuration and / or 
 * a project's artifact model.
 * 
 * @author Holger Eichelberger
 */
public class JoinExpression extends Expression {
    
    private JoinVariableDeclaration[] joinVariables;
    private JoinVariableDeclaration[] visibleVariables;
    private Expression condition;
    private TypeDescriptor<? extends IVilType> type;

    /**
     * Creates a new join expression.
     * 
     * @param joinVariables the join variables (must not be <b>null</b> and must contain at least 
     *   two variables although a higher number might be not supported)
     * @param condition the join condition, may be <b>null</b>
     * @throws ExpressionException in case that structural or semantic constraints are not satisfied
     */
    public JoinExpression(JoinVariableDeclaration[] joinVariables, Expression condition) throws ExpressionException {
        if (null == joinVariables || 0 == joinVariables.length) {
            throw new ExpressionException("no join variables given", ExpressionException.ID_SEMANTIC);
        }
        if (1 == joinVariables.length) {
            throw new ExpressionException("not enough join variables given", ExpressionException.ID_SEMANTIC);
        }
        this.joinVariables = joinVariables;
        int visibleCount = 0;
        for (int j = 0; j < joinVariables.length; j++) {
            if (!joinVariables[j].isExcluded()) {
                visibleCount++;
            }
        }
        if (0 == joinVariables.length) {
            throw new ExpressionException("at least one join variable must be visible " 
                + "(i.e., not all must be excluded)", ExpressionException.ID_SEMANTIC);
        }
        visibleVariables = new JoinVariableDeclaration[visibleCount];
        visibleCount = 0;
        for (int j = 0; j < joinVariables.length; j++) {
            if (!joinVariables[j].isExcluded()) {
                visibleVariables[visibleCount++] = joinVariables[j];
            }
        }
        if (null != condition) {
            this.condition = condition;
            if (!TypeRegistry.booleanType().isAssignableFrom(this.condition.inferType())) {
                throw new ExpressionException("join expression must be boolean", ExpressionException.ID_SEMANTIC);
            }
        }
    }
    
    /**
     * Returns the number of join variables.
     * 
     * @return the number of join variables
     */
    public int getVariablesCount() {
        return joinVariables.length;
    }
    
    /**
     * Returns the specified join variable.
     * 
     * @param index the 0-based index denoting the variable to be returned
     * @return the specified join variable
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getVariablesCount()}</code>
     */
    public JoinVariableDeclaration getVariable(int index) {
        return joinVariables[index];
    }
    
    /**
     * Returns the number of visible join variables.
     * 
     * @return the number of visible join variables
     */
    public int getVisibleVariablesCount() {
        return visibleVariables.length;
    }
    
    /**
     * Returns the specified visible join variable.
     * 
     * @param index the 0-based index denoting the variable to be returned
     * @return the specified visible join variable
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getVisibleVariablesCount()}</code>
     */
    public JoinVariableDeclaration getVisibleVariable(int index) {
        return visibleVariables[index];
    }
    
    /**
     * Returns the join condition.
     * 
     * @return the join condition (may be empty)
     */
    public Expression getCondition() {
        return condition;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        if (null == type) {
            TypeDescriptor<? extends IVilType>[] tmp = TypeDescriptor.createArray(visibleVariables.length);
            for (int j = 0; j < visibleVariables.length; j++) {
                tmp[j] = visibleVariables[j].getType();
                if (tmp[j].getParameterCount() > 0) {
                    // just to be sure, can only be the first
                    tmp[j] = tmp[j].getParameterType(0);
                }
            }
            try {
                type = TypeRegistry.getSequenceType(tmp);
            } catch (VilException e) {
                throw new ExpressionException(e);
            }
        }
        return type;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitJoinExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }
    
}
