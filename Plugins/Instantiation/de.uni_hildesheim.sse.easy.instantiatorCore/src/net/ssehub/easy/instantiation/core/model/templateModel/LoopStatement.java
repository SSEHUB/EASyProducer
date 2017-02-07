package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Representation of a loop-statement in VIL which allows multiple
 * processing of a <code>WorkflowElementBlock</code> instance.
 * 
 * @author kroeher
 */
public class LoopStatement extends AbstractTemplateElement {

    private VariableDeclaration iteratorVar;
    private Expression containerExpression;
    private ITemplateElement statement;
    private Expression separatorExpression;
    private Expression finalSeparatorExpression;
    
    // checkstyle: stop parameter number check
    
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
     * @throws VilException in case of semantic problems while creating this loop object
     */
    public LoopStatement(VariableDeclaration iteratorVar, Expression containerExpression, ITemplateElement statement, 
        Expression separatorExpression, Expression finalSeparatorExpression) throws VilException {
        this.iteratorVar = iteratorVar;
        this.containerExpression = containerExpression;
        this.statement = statement;
        this.separatorExpression = separatorExpression;
        if (null != separatorExpression) {
            // see grammar
            this.finalSeparatorExpression = finalSeparatorExpression;
        }
    }

    // checkstyle: resume parameter number check
    
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
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitLoop(this);
    }

    @Override
    public boolean isBlock() {
        return false; // unsure
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.voidType();
    }

    @Override
    protected void setParent(ILanguageElement parent) {
        super.setParent(parent);
        iteratorVar.setParent(this);
    }

}
