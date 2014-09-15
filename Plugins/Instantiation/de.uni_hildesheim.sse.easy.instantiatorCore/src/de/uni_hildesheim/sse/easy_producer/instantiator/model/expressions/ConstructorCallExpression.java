package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Represents a constructor call.
 * 
 * @author Holger Eichelberger
 */
public class ConstructorCallExpression extends CallExpression {

    private TypeDescriptor<? extends IVilType> type;

    /**
     * Creates a constructor call.
     * 
     * @param type the type to obtain the constructor from
     * @param arguments the arguments
     * @throws ExpressionException in case that determining the type fails
     */
    public ConstructorCallExpression(TypeDescriptor<? extends IVilType> type, Expression... arguments) 
        throws ExpressionException {
        super(null, OperationDescriptor.CONSTRUCTOR_NAME, arguments);
        if (null == type) {
            throw new ExpressionException("cannot resolve type", ExpressionException.ID_SEMANTIC);
        }
        this.type = type;
    }

    /**
     * Creates a constructor call.
     * 
     * @param type the type to obtain the constructor from
     * @param arguments the arguments
     * @throws ExpressionException in case that determining the type fails
     */
    public ConstructorCallExpression(TypeDescriptor<? extends IVilType> type, CallArgument... arguments) 
        throws ExpressionException {
        super(null, OperationDescriptor.CONSTRUCTOR_NAME, arguments);
        if (null == type) {
            throw new ExpressionException("cannot resolve type", ExpressionException.ID_SEMANTIC);
        }
        if (!type.canBeInstantiated()) {
            throw new ExpressionException("'" + type.getVilName() + "' cannot be instantiated", 
                ExpressionException.ID_CANNOT_INSTANTIATE);
        }
        this.type = type;
    }

    @Override
    protected boolean doZeroArgumentTest() {
        return false;
    }

    /**
     * Determines the operand for searching operations on. Is called by {@link #inferType()}.
     * 
     * @return the operand
     * @throws ExpressionException in case that determining the operand fails
     */
    protected TypeDescriptor<? extends IVilType> determineOperand() throws ExpressionException {
        return type;
    }

}
