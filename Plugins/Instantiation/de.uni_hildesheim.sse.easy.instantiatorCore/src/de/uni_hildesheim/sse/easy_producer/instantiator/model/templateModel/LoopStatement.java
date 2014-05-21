package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Representation of a loop-statement in VIL which allows multiple
 * processing of a <code>WorkflowElementBlock</code> instance.
 * 
 * @author kroeher
 */
public class LoopStatement implements ITemplateElement {

    private VariableDeclaration iteratorVar;
    private Expression containerExpression;
    private ITemplateElement statement;
    private Expression separatorExpression;
    private Expression finalSeparatorExpression;
    
    /**
     * Create a loop-statement.
     * 
     * @param iteratorVar the iterator variable (name and type of iterator variable)
     * @param containerExpression the container to iterate over
     * @param statement the loop-statement which may subsumes a set of template elements that will be 
     *   processed multiple times.
     * @param separatorExpression an optional separator expression to be emitted between elements (may be <b>null</b>)
     * @param finalSeparatorExpression an optional separator expression to be emitted after the last element 
     *   (may be <b>null</b>)
     * @throws VilLanguageException in case of semantic problems while creating this loop object
     */
    public LoopStatement(VariableDeclaration iteratorVar, Expression containerExpression, ITemplateElement statement, 
        Expression separatorExpression, Expression finalSeparatorExpression) 
        throws VilLanguageException {
        this.iteratorVar = iteratorVar;
        this.containerExpression = containerExpression;
        this.statement = statement;
        this.separatorExpression = separatorExpression;
        if (null != separatorExpression) {
            // see grammar
            this.finalSeparatorExpression = finalSeparatorExpression;
        }
    }
    
    /**
     * Returns the optional separator expression.
     * 
     * @return the separator expression or <b>null</b>
     */
    public Expression getSeparatorExpression() {
        return separatorExpression;
    }
    
    /**
     * Returns the optional final separator expression.
     * 
     * @return the separator expression or <b>null</b>
     */
    public Expression getFinalSeparatorExpression() {
        return finalSeparatorExpression;
    }
    
    /**
     * Returns the iterator variable.
     * 
     * @return The iterator variable.
     */
    public VariableDeclaration getIteratorVariable() {
        return iteratorVar;
    }
    
    /**
     * Get the expression of this loop which defines the set of elements to iterate over.
     * 
     * @return The <code>Expression</code> of this loop.
     */
    public Expression getContainerExpression() {
        return containerExpression;
    }
    
    /**
     * Get the loop-statement which may subsume a set of template elements that will be processed multiple times.
     * 
     * @return The template element that represents the loop-statement/block.
     */
    public ITemplateElement getLoopStatement() {
        return statement;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return visitor.visitLoop(this);
    }

    @Override
    public boolean isBlock() {
        return false; // unsure
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws VilLanguageException {
        return TypeRegistry.voidType();
    }

}
