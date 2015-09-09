package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * A wrapper type to pass and evaluate expressions in VIL languages. This is helpful to realize
 * expression-based collection selection and projection operators. In case of aggregating expressions,
 * consider multiple declarators, in particular {@link #getResultType()}
 * and for evaluation {@link #initializeDeclarators()} and {@link #getResultValue()}.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionEvaluator extends Expression implements IVilType, IStringValueProvider {

    private EvaluationVisitor evaluationVisitor;
    private Expression expression;
    private VariableDeclaration iterator;
    private List<VariableDeclaration> declarators;

    /**
     * Creates an expression evaluator.
     * 
     * @param expression the expression to evaluate on
     * @param iterator the iterator variable, one of <code>declarators</code>
     * @param declarators all declarators of this expression in source sequence, if <b>null</b> a
     *   list consisting of <code>iterator</code> will be created
     */
    public ExpressionEvaluator(Expression expression, VariableDeclaration iterator, 
        List<? extends VariableDeclaration> declarators) {
        this.expression = expression;
        this.iterator = iterator;
        this.declarators = new ArrayList<VariableDeclaration>();
        if (null == declarators) {
            this.declarators.add(iterator);
        } else {
            for (int d = 0; d < declarators.size(); d++) {
                this.declarators.add(declarators.get(d));
            }
        }
    }
    
    /**
     * Returns the number of declarators.
     * 
     * @return the number of declarators
     */
    public int getDeclaratorsCount() {
        return declarators.size();
    }
    
    /**
     * Returns the specified declarator.
     * 
     * @param index the 0-based index
     * @return the declarator
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getDeclaratorsCount()}</code>
     */
    public VariableDeclaration getDeclarator(int index) {
        return declarators.get(index);
    }
    
    /**
     * Returns the explicit result type of an aggregating iterator.
     * 
     * @return the explicit result type (if there are multiple declarators than it's the first one
     *   if it has a default value), <b>null</b> else
     */
    public TypeDescriptor<?> getResultType() {
        TypeDescriptor<?> result = null;
        VariableDeclaration resDecl = getResultDeclarator();
        if (null != resDecl) {
            result = resDecl.getType();
        }
        return result;
    }

    /**
     * Returns the explicit result declarator of an aggregating iterator.
     * 
     * @return the explicit declarator (if there are multiple declarators than it's the first one
     *   if it has a default value), <b>null</b> else
     */
    private VariableDeclaration getResultDeclarator() {
        VariableDeclaration result = null;
        if (declarators.size() > 1) {
            VariableDeclaration decl = declarators.get(0);
            if (null != decl.getExpression()) {
                result = decl;
            }
        }
        return result;
    }

    /**
     * Returns the explicit result value of an aggregating iterator.
     * 
     * @return the explicit value, <b>null</b> else
     * @throws VilException in case that obtaining the result value fails
     */
    public Object getResultValue() throws VilException {
        Object result;
        VariableDeclaration resDecl = getResultDeclarator();
        if (null != resDecl) {
            result = evaluationVisitor.getRuntimeEnvironment().getValue(resDecl);
        } else {
            result = null;
        }
        return result;
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
    
    /**
     * Initializes the declarators in case of default values given and changes the 
     * runtime environment accordingly.
     * 
     * @throws VilException if evaluating or setting the evaluated value fails
     */
    public void initializeDeclarators() throws VilException {
        for (int d = 0; d < declarators.size(); d++) {
            VariableDeclaration decl = declarators.get(d);
            if (null != decl.getExpression()) {
                evaluationVisitor.getRuntimeEnvironment().setValue(decl, 
                    decl.getExpression().accept(evaluationVisitor));
            }
        }
    }
    
}
