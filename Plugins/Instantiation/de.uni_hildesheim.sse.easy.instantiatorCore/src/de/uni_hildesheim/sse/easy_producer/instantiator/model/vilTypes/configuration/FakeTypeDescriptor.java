package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Represents a fake type descriptor for IVML. This type descriptor which not correspond to
 * a real type but is inserted to allow the execution of scripts with unknown types (in 
 * the presence of advices). Operations with fake types shall be ignored during execution.
 * 
 * @author Holger Eichelberger
 */
public class FakeTypeDescriptor extends TypeDescriptor<IvmlElement> {

    private TypeRegistry registry;

    /**
     * Creates a fake type descriptor.
     * 
     * @param registry the type registry this type was created for
     * @param name the name of the type
     * @throws VilException in case that the creation fails
     */
    FakeTypeDescriptor(TypeRegistry registry, String name) throws VilException {
        super((TypeDescriptor<?>[]) null);
        this.registry = registry;
        setName(name);
        setOperations(null); // to be added incrementally
        setConversions(null); // to be added incrementally
    }
    
    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return true;
    }

    @Override
    public boolean isBasicType() {
        return false;
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
        return false;
    }

    @Override
    public IvmlElement create(Object... params) throws VilException {
        return null;
    }

    @Override
    public boolean isAssignableFrom(TypeDescriptor<?> desc) {
        return true; // accept everything
    }

    @Override
    public boolean isCollection() {
        return false;
    }

    @Override
    public boolean isIterator() {
        return false;
    }
    
    @Override
    public boolean isMap() {
        return false;
    }
    
    @Override
    public boolean isSet() {
        return false;
    }

    @Override
    public boolean isSequence() {
        return false;
    }

    @Override
    public boolean isInstance(Object object) {
        return true; // accept everything
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
        return false; // shall not be handled by IActualTypeProvider
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public boolean isInstantiator() {
        return false; // actually fakes are only created for IVML
    }

    @Override
    public IMetaType getSuperType() {
        return null; // no information about types
    }

}
