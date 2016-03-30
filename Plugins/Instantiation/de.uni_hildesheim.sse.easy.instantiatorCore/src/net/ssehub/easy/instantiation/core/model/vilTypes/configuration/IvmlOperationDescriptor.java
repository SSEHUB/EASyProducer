package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

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
    IvmlOperationDescriptor(TypeDescriptor<?> declaringType, String name, boolean isConstructor) {
        super(declaringType, name, isConstructor);
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
    protected static List<TypeDescriptor<?>> createParameterList(
        TypeDescriptor<?> param) {
        List<TypeDescriptor<?>> result = new ArrayList<TypeDescriptor<?>>();
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

    @Override
    public boolean isPlaceholder() {
        return false;
    }
    
    @Override
    public int useGenericParameterAsReturn() {
        return -1;
    }
    
    @Override
    public int useParameterAsReturn() {
        return -1;
    }

    @Override
    public boolean storeArtifactsBeforeExecution() {
        return false;
    }

}
