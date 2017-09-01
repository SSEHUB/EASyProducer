package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a fake type descriptor for IVML. This type descriptor which not correspond to
 * a real type but is inserted to allow the execution of scripts with unknown types (in 
 * the presence of advices). Operations with fake types shall be ignored during execution.
 * 
 * @author Holger Eichelberger
 */
public class FakeTypeDescriptor extends TypeDescriptor<IvmlElement> {

    private TypeRegistry registry;
    private TypeDescriptor<?> baseType;

    /**
     * Creates a fake type descriptor without (!) known base type.
     * 
     * @param registry the type registry this type was created for
     * @param name the name of the type
     * @throws VilException in case that the creation fails
     */
    FakeTypeDescriptor(TypeRegistry registry, String name) throws VilException {
        this(registry, name, null); // legacy behavior
    }
    
    /**
     * Creates a fake type descriptor.
     * 
     * @param registry the type registry this type was created for
     * @param name the name of the type
     * @param baseType the known base type, may be <b>null</b>
     * @throws VilException in case that the creation fails
     */
    FakeTypeDescriptor(TypeRegistry registry, String name, TypeDescriptor<?> baseType) throws VilException {
        super((TypeDescriptor<?>[]) null);
        this.registry = registry;
        this.baseType = baseType;
        setName(name);
        setOperations(null); // to be added incrementally
        setConversions(null); // to be added incrementally
    }
    
    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return null == baseType ? true : baseType.isAssignableFrom(type);
    }

    @Override
    public boolean isBasicType() {
        return null == baseType ? false : baseType.isBasicType();
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return registry;
    }

    @Override
    public boolean isPlaceholder() {
        return true;
    }

    @Override
    public Class<IvmlElement> getTypeClass() {
        return IvmlElement.class;
    }

    @Override
    public boolean canBeInstantiated() {
        return null == baseType ? false : baseType.canBeInstantiated();
    }

    @Override
    public IvmlElement create(Object... params) throws VilException {
        IvmlElement res = null;
        if (null != baseType) {
            Object tmp = baseType.create(params);
            if (tmp instanceof IvmlElement) {
                res = (IvmlElement) tmp;
            }
        }
        return res;
    }

    @Override
    public boolean isAssignableFrom(TypeDescriptor<?> desc) {
        return null == baseType ? true : baseType.isAssignableFrom(desc); // accept everything
    }

    @Override
    public boolean isCollection() {
        return null == baseType ? false : baseType.isCollection();
    }

    @Override
    public boolean isIterator() {
        return null == baseType ? false : baseType.isInstantiator();
    }
    
    @Override
    public boolean isMap() {
        return null == baseType ? false : baseType.isMap();
    }
    
    @Override
    public boolean isSet() {
        return null == baseType ? false : baseType.isSet();
    }

    @Override
    public boolean isSequence() {
        return null == baseType ? false : baseType.isSequence();
    }

    @Override
    public boolean isInstance(Object object) {
        return null == baseType ? true : baseType.isInstance(object); // accept everything
    }
    
    @Override
    public boolean isSameType(Object object) {
        return null == baseType ? true : baseType.isSameType(object); // accept everything
    }

    @Override
    public OperationDescriptor addPlaceholderOperation(String name, int parameterCount, 
        boolean acceptsNamedParameters) {
        OperationDescriptor result = new FakeOperationDescriptor(this, name, parameterCount, acceptsNamedParameters);
        addOperation(result);
        return result;
    }
    
    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return null == baseType ? false : baseType.isActualTypeOf(type); // shall not be handled by IActualTypeProvider
    }

    @Override
    public IMetaType getBaseType() {
        return baseType;
    }

    @Override
    public boolean isInternal() {
        return null == baseType ? false : baseType.isInternal();
    }

    @Override
    public boolean isInstantiator() {
        return null == baseType ? false : baseType.isInstantiator(); // actually fakes are only created for IVML
    }

    @Override
    public IMetaType getSuperType() {
        return null == baseType ? null : baseType.getSuperType(); // no information about types
    }

    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return null == baseType ? true : baseType.checkConversion(param, conversion);
    }

}
