package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Representation of a loop-statement in VIL which allows multiple
 * processing of a <code>WorkflowElementBlock</code> instance.
 * 
 * @author kroeher
 */
public class WhileStatement implements ITemplateElement {

    private Expression condition;
    private ITemplateElement statement;
    
    /**
     * Create a loop-statement.
     * 
     * @param condition the condition determining the end of the loop (Boolean expression)
     * @param statement the loop-statement which may subsumes a set of template elements that will be 
     *   processed multiple times.
     * @throws VilException in case of semantic problems while creating this loop object
     */
    public WhileStatement(Expression condition, ITemplateElement statement) 
        throws VilException {
        this.condition = condition;
        this.statement = statement;
        if (null == condition) {
            throw new VilException("no condition given", VilException.ID_SEMANTIC);
        }
    }
    
    /**
     * Get the condition of this loop.
     * 
     * @return The <code>condition</code> of this loop.
     */
    public Expression getConditionExpression() {
        return condition;
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
        return visitor.visitWhile(this);
    }

    @Override
    public boolean isBlock() {
        return false; // unsure
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.voidType();
    }

}
