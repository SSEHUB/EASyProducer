package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Represents a constructor call. Considers {@link IInitializableValue}.
 * 
 * @author Holger Eichelberger
 */
public class ConstructorCallExpression extends CallExpression {

    private TypeDescriptor<?> type;

    /**
     * Creates a constructor call.
     * 
     * @param type the type to obtain the constructor from
     * @param arguments the arguments
     * @throws VilException in case that determining the type fails
     */
    public ConstructorCallExpression(TypeDescriptor<?> type, Expression... arguments) 
        throws VilException {
        super(null, OperationDescriptor.CONSTRUCTOR_NAME, arguments);
        if (null == type) {
            throw new VilException("cannot resolve type", VilException.ID_SEMANTIC);
        }
        this.type = type;
    }

    /**
     * Creates a constructor call.
     * 
     * @param type the type to obtain the constructor from
     * @param arguments the arguments
     * @throws VilException in case that determining the type fails
     */
    public ConstructorCallExpression(TypeDescriptor<?> type, CallArgument... arguments) 
        throws VilException {
        super(null, OperationDescriptor.CONSTRUCTOR_NAME, arguments);
        if (null == type) {
            throw new VilException("cannot resolve type", VilException.ID_SEMANTIC);
        }
        if (!type.canBeInstantiated()) {
            throw new VilException("'" + type.getVilName() + "' cannot be instantiated", 
                VilException.ID_CANNOT_INSTANTIATE);
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
     * @throws VilException in case that determining the operand fails
     */
    protected TypeDescriptor<?> determineOperand() throws VilException {
        return type;
    }
    
    @Override
    protected boolean checkMetaForFirstArgField() {
        return false; // react on type instead, see determineOperand()
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result = super.accept(visitor);
        if (result instanceof IInitializableValue) {
            ((IInitializableValue) result).initialize(visitor);
        }
        return result;
    }

}
