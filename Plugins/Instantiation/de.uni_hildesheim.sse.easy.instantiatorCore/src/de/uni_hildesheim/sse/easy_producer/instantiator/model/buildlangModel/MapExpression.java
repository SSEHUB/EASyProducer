package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Describes a map statement.
 * 
 * @author Holger Eichelberger
 */
public class MapExpression extends Expression implements IRuleBlock {

    private VariableDeclaration[] variables;
    private Expression expr;
    private IRuleElement[] body;
    private TypeDescriptor<?> type;
    private TypeDescriptor<?>[] givenTypes;
    private boolean colon;
    
    /**
     * Creates a map statement.
     * 
     * @param variables the variables to iterate over (including values)
     * @param expr the expression denoting on what to iterate / map
     * @param body the body elements
     * @param givenTypes the given types in addition to the inferred types
     *   of the <code>variable</code> (may be <b>null</b>; if given must have
     *   same length as <code>variables</code>, may contain <b>null</b> if no type
     *   is given, types must at least be supertypes of those in <code>variables</code>)
     * @param colon <code>true</code> it it was a colon, <code>else</code> if it was an equals character
     * @throws VilException in case of syntactic or semantic problems
     */
    public MapExpression(VariableDeclaration[] variables, Expression expr, IRuleElement[] body, 
        TypeDescriptor<?>[] givenTypes, boolean colon) throws VilException {
        if (null == variables || variables.length < 1) {
            throw new VilException("no iterator variables given", VilException.ID_SEMANTIC);
        }
        if (null != givenTypes && variables.length != givenTypes.length) {
            throw new VilException("given types length does not match to variables length", 
                VilException.ID_SEMANTIC);
        }
        this.variables = variables;
        if (null == expr) {
            throw new VilException("no expression given", VilException.ID_SEMANTIC);
        }
        this.expr = expr;
        this.body = body;
        this.givenTypes = givenTypes;
        this.colon = colon;
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
     * Returns the specified given type (further specifying to {@link #getVariable(int)}).
     * 
     * @param index the 0-based index denoting the type to be returned
     * @return the specified type, may be <b>null</b> if not given
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getVariablesCount()}</code>
     */    
    public TypeDescriptor<?> getGivenType(int index) {
        return null == givenTypes ? null : givenTypes[index]; 
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
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitMapExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        if (null == type) {
            // don't care for variable assignments, this happens in a variable assignment expression
            Expression expr = Utils.findLastExpression(this);
            if (null == expr) {
                type = TypeRegistry.voidType();
            } else {
                TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
                param[0] = expr.inferType();
                type = TypeRegistry.getSequenceType(param);
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
        return Utils.findLastExpressionStatement(this);
    }
    
    /**
     * Returns whether the given separator was a colon.
     * 
     * @return <code>true</code> it it was a colon, <code>else</code> if it was an equals character
     */
    public boolean isColonSeparator() {
        return colon;
    }

    @Override
    public boolean isVirtual() {
        return false;
    }

    @Override
    public void addBodyElement(int index, IRuleElement elt) {
        body = RuleBlock.addBodyElement(body, index, elt);
    }

}
