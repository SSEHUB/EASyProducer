package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Describes a map statement.
 * 
 * @author Holger Eichelberger
 */
public class MapExpression extends Expression implements IRuleBlock {

    private VariableDeclaration[] variables;
    private Expression expr;
    private IRuleElement[] body;
    private TypeDescriptor<? extends IVilType> type;
    
    /**
     * Creates a map statement.
     * 
     * @param variables the variables to iterate over (including values)
     * @param expr the expression denoting on what to iterate / map
     * @param body the body elements
     * @throws VilLanguageException in case of syntactic or semantic problems
     */
    public MapExpression(VariableDeclaration[] variables, Expression expr, IRuleElement[] body) 
        throws VilLanguageException {
        if (null == variables || variables.length < 1) {
            throw new VilLanguageException("no iterator variables given", VilLanguageException.ID_SEMANTIC);
        }
        this.variables = variables;
        if (null == expr) {
            throw new VilLanguageException("no expression given", VilLanguageException.ID_SEMANTIC);
        }
        this.expr = expr;
        this.body = body;
    }

    @Override
    public int getBodyElementCount() {
        return null == body ? 0 : body.length;
    }
    
    @Override
    public IRuleElement getBodyElement(int index) {
        if (null == body) {
            throw new IndexOutOfBoundsException();
        }
        return body[index];
    }
    
    /**
     * Returns the number of variables defined for this map statement.
     * 
     * @return the number of variables
     */
    public int getVariablesCount() {
        return variables.length;
    }
    
    /**
     * Returns the specified variable.
     * 
     * @param index the 0-based index denoting the variable to be returned
     * @return the specified variable
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getVariablesCount()}</code>
     */
    public VariableDeclaration getVariable(int index) {
        return variables[index];
    }
    
    /**
     * Returns the iterator expression.
     * 
     * @return the iterator expression
     */
    public Expression getExpression() {
        return expr;
    }
    
    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitMapExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        if (null == type) {
            Expression expr = null;
            for (int e = getBodyElementCount() - 1; null == expr && e >= 0; e--) {
                IRuleElement elt = getBodyElement(e);
                if (elt instanceof ExpressionStatement) {
                    // don't care for variable assignments, this happens in a variable assignment expression
                    expr = ((ExpressionStatement) elt).getExpression();
                }
            }
            if (null == expr) {
                type = TypeDescriptor.VOID;
            } else {
                try {
                    TypeDescriptor<? extends IVilType>[] param = TypeDescriptor.createArray(1);
                    param[0] = expr.inferType();
                    type = TypeRegistry.getSequenceType(param);
                } catch (VilException e) {
                    throw new ExpressionException(e);
                }
            }
        } 
        return type;
    }
    
    /**
     * Returns the body element which determines the result.
     * 
     * @return the rule element determining the result
     */
    public IRuleElement determinesResult() {
        IRuleElement result = null;
        for (int e = getBodyElementCount() - 1; null == result && e >= 0; e--) {
            IRuleElement elt = getBodyElement(e);
            if (elt instanceof ExpressionStatement) {
                result = elt;
            }
        }
        return result;
    }

}
