package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements equality and unequality for the dynamic types.
 * 
 * @author Holger Eichelberger
 */
public class IvmlComparisonOperationDescriptor extends IvmlOperationDescriptor {

    private boolean equality;

    /**
     * Creates a new comparison operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param name the name of the operation (in order to consider aliases)
     * @param equality whether equality or unequality shall be handled by the descriptor
     * @param paramType the type of the parameter (values must be a subclass of {@link IVilType})
     */
    IvmlComparisonOperationDescriptor(TypeDescriptor<?> declaringType, String name, boolean equality, 
        TypeDescriptor<?> paramType) {
        super(declaringType, name, false);
        this.equality = equality;
        List<TypeDescriptor<?>> parameters = new ArrayList<TypeDescriptor<?>>();
        parameters.add(declaringType);
        parameters.add(paramType);
        setParameters(parameters, false, false);
        setReturnType(TypeRegistry.booleanType());
        setCharacteristics(OperationType.INFIX, AliasType.NONE, false, name);
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return CompatibilityResult.COMPATIBLE;
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        Object result;
        if (null == args[0] || null == args[1]) {
            result = null;
        } else {
            boolean tmp;
            if (args[0] == TypeRegistry.NULL) {
                // be careful due to casts below
                tmp = (args[1] == TypeRegistry.NULL);
            } else if (args[1] == TypeRegistry.NULL) {
                // be careful due to casts below
                tmp = (args[0] == TypeRegistry.NULL);
            } else {
                Object dVal = ((DecisionVariable) args[0]).getValue();
                Object iVal = ((IvmlElement) args[1]).getValue();
                tmp = (dVal != null && iVal != null && dVal.equals(iVal));
            }
            if (!equality) {
                tmp = !tmp;
            }
            result = tmp;
        }
        return result;
    }

}
