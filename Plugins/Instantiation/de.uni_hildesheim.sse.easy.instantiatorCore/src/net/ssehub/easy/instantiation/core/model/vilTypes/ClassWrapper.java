package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Wraps the public static methods into VIL operation descriptors.
 * 
 * @author Holger Eichelberger
 */
public class ClassWrapper implements IMetaType {

    private Class<?> cls;
    private OperationDescriptor[] operations;
    private TypeRegistry registry;
    
    /**
     * Creates a new class wrapper for the given class.
     * 
     * @param cls the class to be wrapped
     * @param registry the registry this wrapper is registered with
     */
    public ClassWrapper(Class<?> cls, TypeRegistry registry) {
        this.cls = cls;
        this.registry = registry;
        Method[] methods = cls.getDeclaredMethods();
        if (null != methods) {
            List<OperationDescriptor> tmp = new ArrayList<OperationDescriptor>();
            for (int m = 0; m < methods.length; m++) {
                Method method = methods[m];
                int modifier = method.getModifiers();
                if (Modifier.isPublic(modifier) && Modifier.isStatic(modifier) 
                    && !Modifier.isAbstract(modifier)) {
                    // null as type is dangerous
                    tmp.add(new ReflectionOperationDescriptor(null, methods[m], 
                        OperationDescriptor.isConstructor(methods[m])));
                }
            }
            operations = new OperationDescriptor[tmp.size()];
            tmp.toArray(operations);
        }
    }
    
    @Override
    public String getName() {
        return cls.getSimpleName();
    }
    
    @Override
    public String getQualifiedName() {
        return getName(); // TODO preliminary, needs introduction of qualified names in grammar
    }

    @Override
    public int getOperationsCount() {
        return null == operations ? 0 : operations.length;
    }

    @Override
    public IMetaOperation getOperation(int index) {
        return operations[index];
    }

    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return false;
    }

    @Override
    public IMetaOperation findConversion(IMetaType sourceType, IMetaType targetType) {
        return null;
    }

    @Override
    public boolean isBasicType() {
        return TypeHelper.isBasicType(cls);
    }
    
    @Override
    public TypeRegistry getTypeRegistry() {
        return registry;
    }
    
    @Override
    public boolean enableDynamicDispatch() {
        return false;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public IMetaOperation addPlaceholderOperation(String name, int parameterCount, boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return false; // class wrapper shall not be handled by IActualTypeProvider
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public IMetaField getField(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isInternal() {
        return true;
    }
    
    /**
     * Returns the class of the wrapped class.
     * 
     * @return class
     */
    @Invisible
    public Class<?> getWrappedClass() {
        return cls;
    }

    @Override
    public IMetaType getSuperType() {
        return null; // just wraps a Java class - no supertype required here
    }

    @Override
    public int getGenericParameterCount() {
        return 0;
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        throw new IllegalArgumentException();
    }
    
    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return true;
    }

    @Override
    public List<IMetaOperation> getCandidates(String name, int unnamedArgsCount) {
        return TypeDescriptor.getCandidates(this, name, unnamedArgsCount);
    }
    
}
