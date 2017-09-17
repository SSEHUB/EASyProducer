package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Representation of an alternative-statement in VIL templates which allows conditional
 * processing of two template language statements or blocks (if-then-else).
 *  
 * @author kroeher
 */
public class AlternativeStatement extends AbstractTemplateElement {
    
    private Expression condition;
    private ITemplateElement ifStatement;
    private ITemplateElement elseStatement;

    /**
     * Create an alternative-statement with a single if-block only.
     * 
     * @param condition The condition which must be evaluated to <b>true</b> to process the if-block. 
     * @param ifStatement The if-statement which subsumes a set of template elements that will only be
     *        processed if the <b>condition</b> is evaluated to true.
     * @throws VilException in case that the construction fails due to semantic problems
     */
    public AlternativeStatement(Expression condition, ITemplateElement ifStatement) 
        throws VilException {
        this(condition, ifStatement, null);
    }
    
    /**
     * Create an alternative-statement with an if-block and an else-block.
     * 
     * @param condition The condition of this alternative. If evaluated to <b>true</b> the <b>if-block</b> will
     * be processed. If evaluated to <b>false</b> the <b>else-block</b> will be processed.
     * @param ifStatement The if-block which subsumes a set of template elements that will only be
     *        processed if the <b>condition</b> is evaluated to <b>true</b>.
     * @param elseStatement The else-block which subsumes a set of template elements that will only be
     *        processed if the <b>condition</b> is evaluated to <b>false</b>.
     * @throws VilException in case that the construction fails due to semantic problems
     */
    public AlternativeStatement(Expression condition, ITemplateElement ifStatement, ITemplateElement elseStatement) 
        throws VilException {
        this.condition = condition;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }
    
    /**
     * Get the condition of this alternative.
     * 
     * @return The condition expression of this alternative
     */
    public Expression getCondition() {
        return this.condition;
    }
    
    /**
     * Get the if-statement of this alternative.
     *  
     * @return The template element that represents the if-statement of this alternative.
     */
    public ITemplateElement getIfStatement() {
        return ifStatement;
    }
    
    /**
     * Get the else-statement of this alternative.
     * 
     * @return The template element that represents the else-statement of this alternative
     *         or <b>null</b> if no else-statement is defined.
     */
    public ITemplateElement getElseStatement() {
        return elseStatement;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitAlternative(this);
    }

    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        TypeDescriptor<?> result;
        if (null == elseStatement) {
            result = ifStatement.inferType();
        } else {
            TypeDescriptor<?> ifType = ifStatement.inferType();
            TypeDescriptor<?> elseType = elseStatement.inferType();
            if (ifType.equals(elseType)) {
                result = ifType;
            } else {
                result = TypeRegistry.anyType();
            }
        }
        return result;
    }
    
    @Override
    public boolean endsWithContentStatement() {
        boolean endsWith = ifStatement.endsWithContentStatement();
        if (null != elseStatement) {
            endsWith &= elseStatement.endsWithContentStatement();
        }
        return endsWith;
    }

}
