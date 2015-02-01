package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Represents a VIL alternative.
 * 
 * @author Holger Eichelberger
 */
public class AlternativeExpression extends Expression {

    private Expression condition;
    private IRuleBlock ifPart;
    private IRuleBlock elsePart;
    private TypeDescriptor<? extends IVilType> type;
    
    /**
     * Creates an alternative expression.
     * 
     * @param condition the condition to be evaluated
     * @param ifPart the if-part to be executed if the alternative is true
     * @param elsePart the optional else-part to be executed if the alternative is false
     * @throws VilLanguageException in case of syntactic or semantic problems
     */
    public AlternativeExpression(Expression condition, IRuleBlock ifPart, IRuleBlock elsePart) 
        throws VilLanguageException {
        if (null == condition) {
            throw new VilLanguageException("no condition given", VilLanguageException.ID_SEMANTIC);
        }
        if (null == ifPart) {
            throw new VilLanguageException("no if-part given", VilLanguageException.ID_SEMANTIC);
        }
        this.condition = condition;
        this.ifPart = ifPart;
        this.elsePart = elsePart;
    }

    /**
     * Returns the condition to be evaluated.
     * 
     * @return the condition
     */
    public Expression getCondition() {
        return condition;
    }
    
    /**
     * Returns the if-part to be executed if the condition is false.
     * 
     * @return the if-part
     */
    public IRuleBlock getIfPart() {
        return ifPart;
    }

    /**
     * Returns the else-part to be executed if the condition is false.
     * 
     * @return the else-part
     */
    public IRuleBlock getElsePart() {
        return elsePart;
    }
    
    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        if (null == type) {
            Expression thenExpr = Utils.findLastExpression(ifPart);
            Expression elseExpr = null == elsePart ? null : Utils.findLastExpression(elsePart);
            if (null == elseExpr) { // then may be null, else part or else expr is null
                if (null == thenExpr) {
                    type = TypeRegistry.voidType();
                } else {
                    type = thenExpr.inferType();
                }
            } else {
                if (null == thenExpr) {
                    type = elseExpr.inferType();
                } else {
                    TypeDescriptor<? extends IVilType> thenType = thenExpr.inferType();
                    TypeDescriptor<? extends IVilType> elseType = elseExpr.inferType();
                    if (thenType.isAssignableFrom(elseType)) {
                        type = thenType;
                    } else if (elseType.isAssignableFrom(thenType)) {
                        type = elseType;
                    } else {
                        throw new ExpressionException("if given, both paths must lead to compatible types", 
                            ExpressionException.ID_SEMANTIC);
                    }
                }
            }
        } 
        return type;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitAlternativeExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }

}
