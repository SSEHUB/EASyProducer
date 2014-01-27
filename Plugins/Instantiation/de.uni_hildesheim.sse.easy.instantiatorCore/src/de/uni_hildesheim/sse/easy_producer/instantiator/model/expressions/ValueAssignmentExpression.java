package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Represents a value assignment.
 * 
 * @author Holger Eichelberger
 */
public class ValueAssignmentExpression extends Expression {

    private VariableDeclaration varDecl;
    private Expression valueExpression;
    
    /**
     * Creates a new value assignment expression which assigns <code>valueExpression</code> to 
     * <code>varDecl</code>.
     * 
     * @param varDecl the variable declaration
     * @param valueExpression the value expression
     */
    public ValueAssignmentExpression(VariableDeclaration varDecl, Expression valueExpression) {
        this.varDecl = varDecl;
        this.valueExpression = valueExpression;
    }

    /**
     * Returns the variable declaration.
     * 
     * @return the variable declaration
     */
    public VariableDeclaration getVarDecl() {
        return varDecl;
    }

    /**
     * Returns the value expression.
     * 
     * @return the value expression
     */
    public Expression getValueExpression() {
        return valueExpression;
    }
    
    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        TypeDescriptor<? extends IVilType> varType = this.varDecl.getType();
        TypeDescriptor<? extends IVilType> valType = this.valueExpression.inferType();
        if (!varType.isAssignableFrom(valType)) {
            OperationDescriptor operation = valType.findConversion(valType, varType);
            if (null == operation) {
                operation = varType.findConversion(valType, varType);
            }
            if (null != operation) {
                this.valueExpression = new CallExpression(operation, new CallArgument(valueExpression));
            } else {
                throw new ExpressionException("cannot assign/convert " + valType.getVilName() 
                    + " to " + varType.getVilName(), ExpressionException.ID_SEMANTIC);
            }
        }
        return TypeDescriptor.VOID;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        return visitor.visitValueAssignmentExpression(this);
    }

}
