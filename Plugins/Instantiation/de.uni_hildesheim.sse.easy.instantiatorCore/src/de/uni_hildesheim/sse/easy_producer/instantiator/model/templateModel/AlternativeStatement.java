package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Representation of an alternative-statement in VIL templates which allows conditional
 * processing of two template language statements or blocks (if-then-else).
 *  
 * @author kroeher
 */
public class AlternativeStatement implements ITemplateElement {
    
    private Expression condition;
    private ITemplateElement ifStatement;
    private ITemplateElement elseStatement;

    /**
     * Create an alternative-statement with a single if-block only.
     * 
     * @param condition The condition which must be evaluated to <b>true</b> to process the if-block. 
     * @param ifStatement The if-statement which subsumes a set of template elements that will only be
     *        processed if the <b>condition</b> is evaluated to true.
     * @throws VilLanguageException in case that the construction fails due to semantic problems
     */
    public AlternativeStatement(Expression condition, ITemplateElement ifStatement) 
        throws VilLanguageException {
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
     * @throws VilLanguageException in case that the construction fails due to semantic problems
     */
    public AlternativeStatement(Expression condition, ITemplateElement ifStatement, ITemplateElement elseStatement) 
        throws VilLanguageException {
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
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return visitor.visitAlternative(this);
    }

    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws VilLanguageException {
        TypeDescriptor<? extends IVilType> result;
        if (null == elseStatement) {
            result = ifStatement.inferType();
        } else {
            TypeDescriptor<? extends IVilType> ifType = ifStatement.inferType();
            TypeDescriptor<? extends IVilType> elseType = elseStatement.inferType();
            if (ifType.equals(elseType)) {
                result = ifType;
            } else {
                result = TypeDescriptor.ANY;
            }
        }
        return result;
    }

}
