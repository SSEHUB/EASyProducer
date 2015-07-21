package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Represents a fake operation descriptor, i.e., an operation which accepts every type of
 * parameter and the result can be used everywhere.
 * 
 * @author Holger Eichelberger
 */
public class FakeOperationDescriptor extends OperationDescriptor {

    /**
     * Create a fake operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param name the name of the operation
     * @param parameterCount the number of parameters of the operation
     * @param acceptsNamedParameters whether the operation accepts named parameters
     */
    FakeOperationDescriptor(TypeDescriptor<?> declaringType, 
        String name, int parameterCount, boolean acceptsNamedParameters) {
        super(declaringType, name, OperationDescriptor.CONSTRUCTOR_NAME.equals(name));
        final TypeDescriptor<?> any = TypeRegistry.anyType();
        
        // allow this operation to accept everything and the return type to be acceptable for everything
        setReturnType(any);
        List<TypeDescriptor<?>> param = new ArrayList<TypeDescriptor<?>>();
        for (int p = 0; p < parameterCount; p++) {
            param.add(any);
        }
        setParameters(param, acceptsNamedParameters, false);
    }
    
    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public boolean isFirstParameterOperand() {
        return true;
    }

    @Override
    public boolean isPlaceholder() {
        return true;
    }

    @Override
    protected void initializeParameters() {
    }

    @Override
    protected void initializeReturnType() {
    }

    @Override
    protected String getDeclaringTypeNameFallback() {
        return null;
    }

    @Override
    public String getJavaSignature() {
        StringBuilder tmp = new StringBuilder();
        if (isConstructor()) {
            tmp.append(getDeclaringTypeName());
            tmp.append(" ");
        } else {
            tmp.append(getName());
        }
        tmp.append("(");
        int pCount = getParameterCount();
        for (int p = 0; p < pCount; p++) {
            tmp.append(getParameterType(p).getVilName());
            if (p < pCount - 1) {
                tmp.append(",");
            }
        }
        tmp.append(")");
        return tmp.toString();
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return CompatibilityResult.COMPATIBLE; // accept everything
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        return null;
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
