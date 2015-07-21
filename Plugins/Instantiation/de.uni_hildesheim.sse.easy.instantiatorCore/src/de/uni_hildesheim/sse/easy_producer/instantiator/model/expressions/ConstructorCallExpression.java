package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Represents a constructor call.
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

}
