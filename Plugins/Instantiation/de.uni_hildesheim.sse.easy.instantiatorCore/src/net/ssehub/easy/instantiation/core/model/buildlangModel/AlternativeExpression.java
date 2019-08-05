package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a VIL alternative.
 * 
 * @author Holger Eichelberger
 */
public class AlternativeExpression extends Expression {

    private Expression condition;
    private IRuleBlock ifPart;
    private IRuleBlock elsePart;
    private TypeDescriptor<?> type;

    /**
     * Constructor for serialization.
     */ 
    AlternativeExpression() {
    }
    
    /**
     * Creates an alternative expression.
     * 
     * @param condition the condition to be evaluated
     * @param ifPart the if-part to be executed if the alternative is true
     * @param elsePart the optional else-part to be executed if the alternative is false
     * @throws VilException in case of syntactic or semantic problems
     */
    public AlternativeExpression(Expression condition, IRuleBlock ifPart, IRuleBlock elsePart) 
        throws VilException {
        if (null == condition) {
            throw new VilException("no condition given", VilException.ID_SEMANTIC);
        }
        if (null == ifPart) {
            throw new VilException("no if-part given", VilException.ID_SEMANTIC);
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
    public TypeDescriptor<?> inferType() throws VilException {
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
                    TypeDescriptor<?> thenType = thenExpr.inferType();
                    TypeDescriptor<?> elseType = elseExpr.inferType();
                    if (thenType.isAssignableFrom(elseType)) {
                        type = thenType;
                    } else if (elseType.isAssignableFrom(thenType)) {
                        type = elseType;
                    } else {
                        throw new VilException("if given, both paths must lead to compatible types", 
                            VilException.ID_SEMANTIC);
                    }
                }
            }
        } 
        return type;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitAlternativeExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }

}
