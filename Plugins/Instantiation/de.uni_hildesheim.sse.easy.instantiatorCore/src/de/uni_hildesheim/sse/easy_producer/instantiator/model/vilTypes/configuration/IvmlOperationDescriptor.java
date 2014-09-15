package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

/**
 * Implements a delegating operation descriptor, i.e., virtual operations representing access to 
 * IVML configuration data.
 * 
 * @author Holger Eichelberger
 */
abstract class IvmlOperationDescriptor extends OperationDescriptor {

    /**
     * Creates a new operation descriptor. Overriding constructors shall call 
     * {@link #setCharacteristics(OperationType, AliasType, boolean)} in order to redefined the 
     * default values.
     * 
     * @param declaringType the declaring type
     * @param name the alias name (may be <b>null</b> if the original name of <code>method</code> shall be used)
     * @param isConstructor whether the operation is a constructor
     */
    IvmlOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, String name, boolean isConstructor) {
        super(declaringType, name, isConstructor);
    }

    /**
     * Determines the VIL/VTL return type for the given IVML <code>type</code>.
     * @param type the IVML type
     * @return the return type
     * @throws VilException in case that creating the type fails
     */
    protected TypeDescriptor<? extends IVilType> determineReturnType(IDatatype type) throws VilException {
        TypeDescriptor<? extends IVilType> result;
        if (Set.TYPE.isAssignableFrom(type)) {
            TypeDescriptor<? extends IVilType>[] generics = TypeDescriptor.createArray(1);
            generics[0] = IvmlTypes.decisionVariableType();
            result = TypeRegistry.getSetType(generics);
        } else if (Sequence.TYPE.isAssignableFrom(type)) {
            TypeDescriptor<? extends IVilType>[] generics = TypeDescriptor.createArray(1);
            generics[0] = IvmlTypes.decisionVariableType();
            result = TypeRegistry.getSequenceType(generics);
        } else {
            result = IvmlTypes.decisionVariableType();
        }
//result = IvmlTypes.decisionVariableType();        
        return result;
    }
    
    @Override
    protected void initializeParameters() {
        // no lazy initialization here
    }

    @Override
    protected void initializeReturnType() {
        // no lazy initialization here
    }
    
    /**
     * Creates a parameter list for one parameter (type).
     * 
     * @param param the parameter type
     * @return the parameter list
     */
    protected static List<TypeDescriptor<? extends IVilType>> createParameterList(
        TypeDescriptor<? extends IVilType> param) {
        List<TypeDescriptor<? extends IVilType>> result = new ArrayList<TypeDescriptor<? extends IVilType>>();
        result.add(param);
        return result;
    }

    @Override
    protected String getDeclaringTypeNameFallback() {
        return null;
    }

    @Override
    public boolean isStatic() {
        return false;
    }
    
    @Override
    public boolean isFirstParameterOperand() {
        return false;
    }

    @Override
    public String getJavaSignature() {
        StringBuilder tmp = new StringBuilder(getName());
        tmp.append("(");
        int pCount = getParameterCount();
        boolean acceptsNamedParameters = acceptsNamedParameters();
        if (pCount > 0) {
            if (acceptsNamedParameters) {
                pCount--;
            }
            for (int p = 0; p < pCount; p++) {
                tmp.append(getParameterType(p).getVilName());
                if (p < pCount - 1) {
                    tmp.append(",");
                }
            }
            if (acceptsNamedParameters) {
                if (pCount > 0) {
                    tmp.append(",");
                }
                tmp.append("...");
            }
        }
        tmp.append(")");
        return tmp.toString(); 
    }

    /**
     * Generic implementation of the compatibility method for one parameter of type {@link DecisionVariable}.
     * 
     * @param params the actual parameters
     * @return the compatibility result
     */
    protected static CompatibilityResult isCompatibleToDecisionVariable(Object[] params) {
        return isCompatible(params, DecisionVariable.class);
    }
  
    /**
     * Generic implementation of the compatibility method for one parameter.
     * 
     * @param params the actual parameters
     * @param paramType the expected parameter type
     * @return the compatibility result
     */
    protected static CompatibilityResult isCompatible(Object[] params, Class<?> paramType) {
        CompatibilityResult result;
        if (null != params && params.length == 1 && paramType.isInstance(params[0])) {
            result = CompatibilityResult.COMPATIBLE;
        } else {
            result = CompatibilityResult.INCOMPATIBLE;
        }
        return result;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

}
