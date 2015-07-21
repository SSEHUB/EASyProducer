package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * A wrapper type to pass and evaluate expressions in VIL languages. This is helpful to realize
 * expression-based collection selection and projection operators.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionEvaluator extends Expression implements IVilType, IStringValueProvider {

    private EvaluationVisitor evaluationVisitor;
    private Expression expression;
    private VariableDeclaration iterator;

    /**
     * Creates an expression evaluator.
     * 
     * @param expression the expression to evaluate on
     * @param iterator the iterator variable
     */
    public ExpressionEvaluator(Expression expression, VariableDeclaration iterator) {
        this.expression = expression;
        this.iterator = iterator;
    }
    
    /**
     * Binds the evaluation visitor. Must be called before {@link #evaluate(Object)}.
     * 
     * @param evaluationVisitor the evaluation visitor used for evaluating the contained expression
     */
    public void bind(EvaluationVisitor evaluationVisitor) {
        this.evaluationVisitor = evaluationVisitor;
    }
    
    /**
     * Unbinds the evaluation visitor (see {@link #evaluate(Object)}).
     */
    public void unbind() {
        evaluationVisitor = null;
    }
    
    /**
     * Evaluates the wrapped expression. This method is intended to be called from the type being
     * evaluated (which does not have access to the {@link #evaluationVisitor}). Thus, 
     * {@link #bind(EvaluationVisitor)} must be called before and {@link #unbind()} shall be called
     * by the type being evaluated.
     * 
     * @param iteratorValue the current value when iterating with the expression
     * @return the result of evaluating {@link #expression} in the current context of {@link #evaluationVisitor}
     * @throws VilException in case that the evaluation fails
     */
    public Object evaluate(Object iteratorValue) throws VilException {
        if (null == expression) {
            throw new VilException("cannot evaluate null", VilException.ID_INTERNAL);
        }
        evaluationVisitor.getRuntimeEnvironment().setValue(iterator, iteratorValue);
        return expression.accept(evaluationVisitor);
    }
    
    /**
     * Returns the expression. Before evaluating this expression, the {@link #getIteratorVariable() iterator variable}
     * must be bound with an actual value.
     * 
     * @return the expression to be evaluated
     */
    public Expression getExpression() {
        return expression;
    }
    
    /**
     * Returns the iterator variable.
     * 
     * @return the iterator variable
     */
    public VariableDeclaration getIteratorVariable() {
        return iterator;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.DEFAULT.getType(ExpressionEvaluator.class);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitExpressionEvaluator(this);
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "<evaluator>";
    }
    
}
