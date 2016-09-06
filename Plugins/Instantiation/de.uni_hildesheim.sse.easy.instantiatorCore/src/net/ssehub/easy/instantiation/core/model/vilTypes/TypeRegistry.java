package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.utils.JavaUtils;

/**
 * Used to register the actual types (also replacements by extensions). Optional type
 * resolvers ({@link ITypeResolver}) allow deferred type resolution on other models, 
 * e.g., variability models. Type retrieval calls using a class are intended to be used
 * by the implementation (and may prevent creating dynamic types) while the others
 * based on string are intended for resolution of names used in the VIL/VTL.
 * 
 * @author Holger Eichelberger
 */
public class TypeRegistry {

    public static final Object NULL = NullValue.VALUE;

    /**
     * Those classes for which the methods shall be invisible by default, in particular
     * <code>java.lang.Object</code>. (public also for testing)
     */
    public static final Class<?>[] INVISIBLE_BY_DEFAULT = {Object.class};
    
    public static final TypeRegistry DEFAULT = new TypeRegistry();

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(TypeRegistry.class, Bundle.ID);

    /**
     * Caches the operations vs. inheriting invisible methods.
     */
    private static final java.util.Map<String, List<Method>> INVISIBLE_INHERITED = new HashMap<String, List<Method>>();
    
    /**
     * Stores the registered types.
     */
    private java.util.Map<String, TypeDescriptor<?>> types 
        = new HashMap<String, TypeDescriptor<?>>();

    /**
     * Stores the registered instantiators.
     */
    private java.util.Map<String, TypeDescriptor<? extends IVilType>> instantiators 
        = new HashMap<String, TypeDescriptor<? extends IVilType>>();

    
    private TypeRegistry parentRegistry;
    
    private List<ITypeResolver> resolver;
    
    private IDirectTypeRegistryAccess directAccess;
    
    /**
     * Implements the direct access interface for {@link ITypeResolver}.
     * 
     * @author Holger Eichelberger
     */
    private class DirectAccess implements IDirectTypeRegistryAccess {

        @Override
        public void add(String name, TypeDescriptor<?> type) {
            types.put(name, type);
        }

        @Override
        public boolean contains(String name) {
            return types.containsKey(name);
        }

        @Override
        public TypeDescriptor<?> get(String name) {
            return types.get(name);
        }

        @Override
        public void addInstantiator(String name, TypeDescriptor<? extends IVilType> type) {
            instantiators.put(name, type);
            
        }

        @Override
        public boolean containsInstantiator(String name) {
            return instantiators.containsKey(name);
        }
        
    }
    
    static {
        for (int i = 0; i < INVISIBLE_BY_DEFAULT.length; i++) {
            Method[] methods = INVISIBLE_BY_DEFAULT[i].getDeclaredMethods();
            for (int m = 0; m < methods.length; m++) {
                addInvisibleInherited(methods[m]);
            }
        }
        DEFAULT.register(ReflectionTypeDescriptor.ANY, null);
        DEFAULT.register(ReflectionTypeDescriptor.TYPE, PseudoType.class);
    }
    
    /**
     * Creates the default type registry.
     */
    private TypeRegistry() {
    }
    
    /**
     * Creates a (local) type registry, which delegates unknown types to the
     * <code>parentRegistry</code>.
     * 
     * @param parentRegistry the parent registry, if <b>null</b> {@link #DEFAULT} is used
     */
    public TypeRegistry(TypeRegistry parentRegistry) {
        this.parentRegistry = null == parentRegistry ? DEFAULT : parentRegistry;
        this.directAccess = new DirectAccess();
    }
    
    /**
     * Returns the parent registry.
     * 
     * @return the parent registry (may be <b>null</b> in case of the root registry)
     */
    public TypeRegistry getParentRegistry() {
        return parentRegistry;
    }
    
    /**
     * Adds a type resolver.
     * 
     * @param resolver the resolver to be added (may be <b>null</b>, but is ignored then)
     */
    public void addTypeResolver(ITypeResolver resolver) {
        if (null != resolver) {
            if (null == this.resolver) {
                this.resolver = new LinkedList<ITypeResolver>();
            }
            if (!this.resolver.contains(resolver)) {
                this.resolver.add(resolver);
                resolver.setRegistryAccess(directAccess);
            }
        }
    }

    /**
     * Renoves a type resolver.
     * 
     * @param resolver the resolver to be added (may be <b>null</b>, but is ignored then)
     */
    public void removeTypeResolver(ITypeResolver resolver) {
        if (null != resolver && null != this.resolver) {
            this.resolver.remove(resolver);
        }
    }
    
    /**
     * Adds the given <code>method</code> to the cache of invisible inherited methods.
     * Already existing registrations will not be changed.
     * 
     * @param method the method to be added.
     * @return <code>true</code> if <code>method</code> was registered before, 
     *   <code>false</code> else
     */
    private static boolean addInvisibleInherited(Method method) {
        String sig = SignatureUtils.getJavaSignature(method);
        List<Method> registered = INVISIBLE_INHERITED.get(sig);
        if (null == registered) {
            registered = new ArrayList<Method>();
            INVISIBLE_INHERITED.put(sig, registered);
        }
        boolean contained = registered.contains(method);
        if (!contained) {
            registered.add(method);
        }
        return contained;
    }
    
    /**
     * Registers a type. Please note that overriding a default artifact requires the same simple class
     * name as the one to be overridden and that the new artifact type subclasses the existing one.
     * 
     * @param type the Java class of the VIL type to be registered
     * @param <T> the actual type
     * @return the registered descriptor
     * @throws VilException in case that <code>type</code> cannot be registered for some reason
     */
    @SuppressWarnings({ "unchecked" })
    public <T extends IVilType> TypeDescriptor<T> registerType(Class<T> type) 
        throws VilException {
        String key = ReflectionTypeDescriptor.getRegName(type);
        Instantiator inst = type.getAnnotation(Instantiator.class);
        TypeDescriptor<?> registered;
        if (null == inst) {
            // not an instantiator, handle it as a type / artifact
            registered = getType(key);
            if (null != registered) {
                String msg = ArtifactFactory.checkReplacement(registered.getTypeClass(), type);
                if (null != msg) {
                    throw new VilException(msg, VilException.ID_ALREADY_REGISTERED);
                }
            }
        } else {
            String name = inst.value();
            if (null == name || 0 == name.length()) {
                throw new VilException("instantiator annotation at " + type.getName() 
                    + "does not provide the instantiator name ", VilException.ID_MISSING_DATA);
            }
            registered = instantiators.get(name);
        }
        if (null != registered) {
            if (type.equals(registered.getTypeClass())) {
                throw new VilException("type '" + key + "' is already registered", 
                     VilException.ID_ALREADY_REGISTERED);
            }
            if (!registered.getTypeClass().isAssignableFrom(type)) {
                throw new VilException("type replacement requires subtype relationship", 
                    VilException.ID_TYPE_INCOMPATIBILITY);
            }
        }
        cacheInheritedAnnotations(type);
        ReflectionTypeDescriptor<T> desc;
        if (type.equals(PseudoType.class)) {
            desc = (ReflectionTypeDescriptor<T>) ReflectionTypeDescriptor.TYPE;
        } else {
            desc = createTypeDescriptor(type);
        }
        if (null == inst) {
            register(key, desc);
            if (!type.getSimpleName().equals(key)) {
                // to find also qualified names in signatures
                register(type.getName(), desc);
            }
            desc.resolve();
            registerEquivalentClasses(type, desc);
            ArtifactFactory.registered(type);
        } else {
            desc.resolve();
            testInstantiatorType(desc, inst);
            instantiators.put(inst.value(), desc);
        }
        return desc;
    }

    /**
     * Creates a type descriptor considering {@link IActualValueProvider}.
     * 
     * @param <T> the VIL type
     * @param type the type the descriptor shall be created for
     * @return the descriptor
     * @throws VilException in case that creating the descriptor fails
     */
    private static <T extends IVilType> ReflectionTypeDescriptor<T> createTypeDescriptor(Class<T> type) 
        throws VilException {
        ReflectionTypeDescriptor<T> desc = null;
        if (IActualValueProvider.class.isAssignableFrom(type)) {
            try {
                desc = new ActualValueReflectionTypeDescriptor<T>(type.getDeclaredConstructor());
            } catch (NoSuchMethodException e) {
                // use default descriptor instead
            } catch (SecurityException e) {
                // use default descriptor instead
            }
        }
        if (null == desc) {
            desc = new ReflectionTypeDescriptor<T>(type);
        }
        return desc;
    }

    /**
     * Some basic semantic tests for instantiators.
     * 
     * @param type the type to be tested
     * @param inst the instatiator annotation
     * @throws VilException in case of failing tests
     */
    private static void testInstantiatorType(TypeDescriptor<? extends IVilType> type, Instantiator inst) 
        throws VilException {
        if (!JavaUtils.isJavaIdentifier(inst.value())) {
            throw new VilException("instantiator name '" + inst.value() + "' is not a valid identifier", 
                VilException.ID_INVALID_DATA);
        }
        int constructorMethods = 0;
        int staticInstantiatorMethods = 0;
        int instanceInstantiatorMethods = 0;
        for (int o = 0; o < type.getOperationsCount(); o++) {
            OperationDescriptor desc = type.getOperation(o);
            if (desc.isConstructor()) {
                constructorMethods++;
            } else if (desc.getName().equals(inst.value())) {
                if (desc.isStatic()) {
                    staticInstantiatorMethods++;
                } else {
                    instanceInstantiatorMethods++;
                }
            }
        }
        
        if (0 == staticInstantiatorMethods && 0 == instanceInstantiatorMethods) {
            throw new VilException("no valid instantiator method declared in " + inst.value() 
                + " (" + type.getTypeClass().getName() + ")'", VilException.ID_INVALID_INSTANTIATOR);
        }
        if (instanceInstantiatorMethods > 0 && 0 == constructorMethods) {
            throw new VilException("no valid constructor method declared in instance instantiator " 
                + inst.value() + " (" + type.getTypeClass().getName() + ")'", 
                VilException.ID_INVALID_INSTANTIATOR);
        }
    }
    
    // name shall be a Java identifier
    // dynamic instantiator -> create
    // instantiator method must be present

    /**
     * Registers an individual type via its name and emits an information message on the logger.
     * 
     * @param desc the type descriptor being registered
     * @param metaProvider the class holding the @Meta annotation for registering equivalent classes 
     *     (may be <b>null</b>)
     * @param <T> the actual VIL type
     * @see #registerEquivalentClasses(Class, TypeDescriptor)
     */
    private <T extends IVilType> void register(TypeDescriptor<T> desc, Class<T> metaProvider) {
        register(desc.getName(), desc);
        if (null != metaProvider) {
            registerEquivalentClasses(metaProvider, desc);
        }
    }
    
    /**
     * Registers an individual type and emits an information message on the logger.
     * 
     * @param key the type name to register for
     * @param desc the type descriptor being registered
     */
    protected void register(String key, TypeDescriptor<?> desc) {
        TypeDescriptor<?> previous = types.put(key, desc);
        String prevString = "";
        if (null != previous) {
            prevString = " (overriding)";
        }
        LOGGER.info("registered type " + key + " -> " + desc.getName() + " " + desc.hashCode() + " " + prevString);
    }
    
    /**
     * Registers equivalent classes from {@link ClassMeta#equiv()}.
     * 
     * @param type the type being registered
     * @param desc the already created descriptor for <code>type</code>
     * @param <T> the actual VIL type
     */
    private <T extends IVilType> void registerEquivalentClasses(Class<T> type, TypeDescriptor<T> desc) {
        ClassMeta meta = type.getAnnotation(ClassMeta.class);
        if (null != meta && null != meta.equiv()) {
            for (Class<?> eq : meta.equiv()) {
                if (null != eq) {
                    register(eq.getName(), desc);
                    if (!types.containsKey(eq.getSimpleName())) { // for Java resolution
                        register(eq.getSimpleName(), desc);    
                    }
                    String primitive = null;
                    if (Boolean.class == eq) {
                        primitive = "boolean";
                    } else if (Integer.class == eq) {
                        primitive = "int";
                    } else if (Long.class == eq) {
                        primitive = "long";
                    } else if (Float.class == eq) {
                        primitive = "float";
                    } else if (Double.class == eq) {
                        primitive = "double";
                    } else if (Character.class == eq) {
                        primitive = "char";
                    } else if (Short.class == eq) {
                        primitive = "short";
                    } else if (Byte.class == eq) {
                        primitive = "byte";
                    }
                    if (null != primitive) {
                        register(primitive, desc);
                    }
                }
            }
        }
    }
    
    /**
     * Caches the inherited annotations and avoids repeated class analysis. [performance]
     * 
     * @param cls the class to be cached
     */
    private static void cacheInheritedAnnotations(Class<?> cls) {
        if (cls != Object.class) { // don't go to the very end
            Method[] methods = cls.getDeclaredMethods();
            for (int m = 0; m < methods.length; m++) {
                Method method = methods[m];
                Invisible inv = method.getAnnotation(Invisible.class);
                if (null != inv && inv.inherit()) {
                    if (addInvisibleInherited(methods[m])) {
                        break; // already registered
                    }
                }
            }
            Class<?> superCls = cls.getSuperclass();
            if (null != superCls) {
                cacheInheritedAnnotations(superCls);
            }
            Class<?>[] interf = cls.getInterfaces();
            if (null != interf) {
                for (int i = 0; i < interf.length; i++) {
                    cacheInheritedAnnotations(interf[i]);
                }
            }
        }
    }

    /**
     * Returns whether a certain method given by its signature (see {@link OperationDescriptor#getSignature()} 
     * has an inherited invisible annotation. Helper method for subsequent class analysis.
     * 
     * @param signature the signature of the method to be queried for
     * @param cls the declaring class of the method
     * @return <code>true</code> if it has an inherited {@link Invisible} annotation, <code>false</code> else
     */
    static boolean hasInheritedInvisibleAnnotation(String signature, Class<?> cls) {
        boolean found = false;
        List<Method> methods = INVISIBLE_INHERITED.get(signature);
        if (null != methods) {
            for (int m = 0; !found && m < methods.size(); m++) {
                found = methods.get(m).getDeclaringClass().isAssignableFrom(cls);
            }
        }
        return found;
    }
    
    /**
     * Internal default registration function with error handling.
     * 
     * @param type the type class to be registered
     * @param <T> the actual type
     */
    public <T extends IVilType> void register(Class<T> type) {
        try {
            registerType(type);
        } catch (VilException e) {
            LOGGER.error(e.getMessage());
        }
    }
    
    /**
     * Provides access to all type descriptors.
     * 
     * @return all type descriptors (without a specific sequence)
     */
    public Iterable<TypeDescriptor<?>> allTypes() {
        Iterable<TypeDescriptor<?>> result;
        if (null == parentRegistry) {
            result = types.values();
        } else {
            ArrayList<TypeDescriptor<?>> tmp = new ArrayList<TypeDescriptor<?>>();
            TypeRegistry iter = this;
            do {
                tmp.addAll(iter.types.values());
                iter = iter.parentRegistry;
            } while (null != iter);
            result = tmp;
        }
        return result;
    }
    
    /**
     * Provides access to all instantiators.
     * 
     * @return all instantiators (without a specific sequence)
     */
    public Iterable<TypeDescriptor<? extends IVilType>> allInstantiators() {
        Iterable<TypeDescriptor<? extends IVilType>> result;
        if (null == parentRegistry) {
            result = instantiators.values();
        } else {
            ArrayList<TypeDescriptor<? extends IVilType>> tmp = new ArrayList<TypeDescriptor<? extends IVilType>>();
            TypeRegistry iter = this;
            do {
                tmp.addAll(iter.instantiators.values());
                iter = iter.parentRegistry;
            } while (null != iter);
            result = tmp;
        }
        return result;
    }

    /**
     * Provides access to all type descriptors with names starting with the given <code>prefix</code>.
     * 
     * @param prefix the prefix to look for
     * @return the type descriptors matching the prefix (without a specific sequence)
     */
    public Iterable<TypeDescriptor<?>> typesByNamePrefix(String prefix) {
        List<TypeDescriptor<?>> result = new ArrayList<TypeDescriptor<?>>();
        for (TypeDescriptor<?> type : types.values()) {
            if (type.getName().startsWith(prefix)) {
                result.add(type);
            }
        }
        return result;
    }
    
    /**
     * Returns the registered type descriptor for the given <code>type</code>.
     * 
     * @param type the type to look for
     * @return the type or <b>null</b> if none was registered
     */
    public TypeDescriptor<?> getType(IDatatype type) {
        TypeDescriptor<?> result = null;
        if (null != parentRegistry) {
            result = parentRegistry.getType(type);
        } // no direct lookup
        if (null == result && null != resolver) {
            for (int r = 0; null == result && r < resolver.size(); r++) {
                result = resolver.get(r).resolveType(type);
            }
        }
        if (null == result) {
            result = getType(type.getName());
            if (null == result) {
                result = getType(type.getQualifiedName());
            }
        }
        return result;
    }
    
    /**
     * Returns the registered type descriptor for the given <code>name</code> also in {@link #parentRegistry}.
     * 
     * @param name the name to look for
     * @return the type descriptor or <b>null</b> if no one is registered for <code>name</code>
     */
    public TypeDescriptor<?> getType(String name) {
        return getType(name, true);
    }
    
    /**
     * Returns the registered type descriptor for the given <code>name</code> also in {@link #parentRegistry}.
     * 
     * @param name the name to look for
     * @param addIfMissing allow to dynamically add the type if it is missing through a type resolver (this
     *   shall be prevented for internal types!)
     * @return the type descriptor or <b>null</b> if no one is registered for <code>name</code>
     */
    public TypeDescriptor<?> getType(String name, boolean addIfMissing) {
        TypeDescriptor<?> result = findType(name);
        if (null == result) {
            result = resolve(name, addIfMissing);
        }
        return result;
    }
    
    /**
     * Searches for a type called <code>name</code>, first in this registry, then in 
     * parent registries if given.
     * 
     * @param name the name of the type
     * @return the found type, <b>null</b> if not found
     */
    private TypeDescriptor<?> findType(String name) {
        TypeDescriptor<?> result = null;
        if (null == result) {
            result = types.get(name);
        }
        if (null == result && null != parentRegistry) {
            result = parentRegistry.findType(name);
        }
        return result;
    }
    
    /**
     * Returns whether this type registry knows a type of the given name.
     * 
     * @param name the name to search for
     * @return <code>true</code> if the type with <code>name</code> is known, <code>false</code> else
     */
    public boolean hasType(String name) {
        return null != findType(name);
    }
    
    /**
     * Resolves the given type <code>name</code> via the resolvers.
     * 
     * @param name the name to look for
     * @param addIfMissing allow to dynamically add the type if it is missing through a type resolver (this
     *   shall be prevented for internal types!)
     * @return the resolved type, <b>null</b> if none
     */
    private TypeDescriptor<?> resolve(String name, boolean addIfMissing) {
        TypeDescriptor<?> result = null;
        if (null != resolver) {
            for (int r = 0; null == result && r < resolver.size(); r++) {
                result = resolver.get(r).resolveType(name, addIfMissing);
            }
        }
        if (null == result && null != parentRegistry) {
            parentRegistry.resolve(name, addIfMissing);
        }
        return result;
    }

    /**
     * Returns the VIL type for a map with the given type parameters.
     * 
     * @param parameter the type parameter
     * @return the type
     * @throws VilException in case that the derivation of the type fails
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static final TypeDescriptor<? extends Map<?, ?>> getMapType(TypeDescriptor<?>... parameter) 
        throws VilException {
        return new ReflectionTypeDescriptor(Map.class, parameter).resolve();
    }

    /**
     * Returns the VIL type for a map with the given type parameters.
     * 
     * @param parameter the type parameter
     * @return the type
     * @throws VilException in case that the derivation of the type fails
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static final TypeDescriptor<? extends PseudoIterator<?>> getIteratorType(TypeDescriptor<?>... parameter) 
        throws VilException {
        return new ReflectionTypeDescriptor(PseudoIterator.class, parameter).resolve();
    }
    
    /**
     * Returns the VIL type for a collection with the given type parameters.
     * 
     * @param parameter the type parameter
     * @return the type
     * @throws VilException in case that the derivation of the type fails
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static final TypeDescriptor<? extends Collection<?>> getCollectionType(TypeDescriptor<?>... parameter) 
        throws VilException {
        return new ReflectionTypeDescriptor(Collection.class, parameter).resolve();
    }
    
    /**
     * Returns the VIL type for a set with the given type parameters.
     * 
     * @param parameter the type parameter
     * @return the type
     * @throws VilException in case that the derivation of the type fails
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static final TypeDescriptor<? extends Set<?>> getSetType(TypeDescriptor<?>... parameter) 
        throws VilException {
        return new ReflectionTypeDescriptor(Set.class, parameter).resolve();
    }

    /**
     * Returns the VIL type for a sequence with the given type parameters.
     * 
     * @param parameter the type parameter
     * @return the type
     * @throws VilException in case that the derivation of the type fails
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static final TypeDescriptor<? extends Sequence<?>> getSequenceType(TypeDescriptor<?>... parameter) 
        throws VilException {
        return new ReflectionTypeDescriptor(Sequence.class, parameter).resolve();
    }

    /**
     * Returns the VIL type for a rule type with the given type parameters.
     * 
     * @param parameter the type parameter
     * @return the type
     * @throws VilException in case that the derivation of the type fails
     */
    public static final TypeDescriptor<? extends ResolvableOperationType> getRuleType(TypeDescriptor<?>... parameter) 
        throws VilException {
        return new ReflectionTypeDescriptor<ResolvableOperationType>(
            ResolvableOperationType.class, parameter).resolve();
    }
    
    /**
     * Returns the registered instantiator type descriptor for the given <code>name</code> also 
     * in {@link #parentRegistry}.
     * 
     * @param name the name to look for
     * @return the type descriptor or <b>null</b> if no one is registered for <code>name</code>
     */
    public TypeDescriptor<? extends IVilType> getInstantiator(String name) {
        TypeDescriptor<? extends IVilType> result = null;
        if (null != parentRegistry) {
            result = parentRegistry.getInstantiator(name);
        } 
        if (null == result) {
            result = instantiators.get(name);
        }
        if (null == result && null != resolver) {
            for (int r = 0; null == result && r < resolver.size(); r++) {
                result = resolver.get(r).resolveInstantiator(name);
            }
            if (null != result) {
                instantiators.put(result.getName(), result);
            }
        }
        return result;
    }

    /**
     * Returns the type descriptor for the built-in operation references (a
     * kind of function pointer to evaluate functions generically).
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> resolvableOperationType() {
        return DEFAULT.getType(ResolvableOperationType.class);
    }
    
    /**
     * Returns the type descriptor for the built-in type String.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> stringType() {
        return DEFAULT.getType(Constants.TYPE_STRING);
    }

    /**
     * Returns the type descriptor for the built-in type 'Boolean'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> booleanType() {
        return DEFAULT.getType(Constants.TYPE_BOOLEAN);
    }

    /**
     * Returns the type descriptor for the built-in type 'Version'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> versionType() {
        return ReflectionTypeDescriptor.VERSION;
    }
    
    /**
     * Returns the type descriptor for the built-in type 'any'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> anyType() {
        return ReflectionTypeDescriptor.ANY;
    }

    /**
     * Returns the type descriptor for the built-in type 'void'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> voidType() {
        return ReflectionTypeDescriptor.VOID;
    }

    /**
     * Returns the type descriptor for the built-in type 'Type'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> typeType() {
        return ReflectionTypeDescriptor.TYPE;
    }

    /**
     * Returns the type descriptor for the built-in type 'Integer'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> integerType() {
        return DEFAULT.getType(Constants.TYPE_INTEGER);
    }

    /**
     * Returns the type descriptor for the built-in type 'Real'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> realType() {
        return DEFAULT.getType(Constants.TYPE_REAL);
    }
    
    /**
     * Converts a class into a type descriptor.
     * 
     * @param cls the classes to be converted
     * @return the corresponding type descriptor or <b>null</b>
     */
    public TypeDescriptor<?> getType(Class<?> cls) {
        return getType(ReflectionTypeDescriptor.getRegName(cls), !isInternalType(cls));
    }
    
    /**
     * Returns whether <code>cls</code> is considered as an internal type including implementation
     * types such as the collections.
     * 
     * @param cls the class to be considered
     * @return <code>true</code>
     */
    public static boolean isInternalType(Class<?> cls) {
        // >preliminary fix
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }        
        // <preliminary fix
        String pName;
        if (null == cls.getPackage()) {
            pName = ""; // primitives
        } else {
            pName = cls.getPackage().getName();
        }
        return pName.startsWith(TypeRegistry.class.getPackage().getName());
    }

    /**
     * Finds the type descriptor for a given class.
     * 
     * @param cls the classes to be converted
     * @return the corresponding type descriptor or <b>null</b>
     */
    public TypeDescriptor<?> findType(Class<?> cls) {
        return null == cls ? null : getType(ReflectionTypeDescriptor.getRegName(cls), !isInternalType(cls));
    }
    
    /**
     * Converts a class into a set of type descriptors.
     * 
     * @param param the class to be converted
     * @return the resulting type descriptors, <code>null</code> if <code>params</code> is <b>null</b> or empty. If a 
     *     type descriptor cannot be found, {@link TypeDescriptor#VOID} is used instead.
     */
    public TypeDescriptor<?>[] convert(Class<?> param) {
        TypeDescriptor<?>[] result;
        if (null == param ) {
            result = null;
        } else {
            result = TypeDescriptor.createArray(1);
            result[0] = getType(param);
            if (null == result[0]) {
                result[0] = ReflectionTypeDescriptor.VOID;
            }
        }
        return result;
    }
    
    /**
     * Converts a set of classes into type descriptors.
     * 
     * @param params the classes to be converted
     * @return the resulting type descriptors, <code>null</code> if <code>params</code> is <b>null</b> or empty. If a 
     *     type descriptor cannot be found, {@link TypeDescriptor#VOID} is used instead.
     */
    public TypeDescriptor<?>[] convert(Class<?>... params) {
        TypeDescriptor<?>[] result;
        if (null == params || 0 == params.length) {
            result = null;
        } else {
            result = TypeDescriptor.createArray(params.length);
            for (int p = 0; p < params.length; p++) {
                result[p] = getType(params[p]);
                if (null == result[p]) {
                    result[p] = ReflectionTypeDescriptor.VOID;
                }
            }
        }
        return result;
    }
    
    /**
     * Returns whether this registry provides types for runtime variability instantiation. This is the case if
     * this or at least one of the parent type registries indicates runtime type support.
     * 
     * @return <code>true</code> if this registry or one of its parent registries provides runtime types, 
     *     <code>false</code> else
     */
    public boolean forRuntime() {
        boolean result = false;
        if (null != parentRegistry) {
            result = parentRegistry.forRuntime();
        }
        return result;
    }
    
    /**
     * Returns whether two types are equal.
     * 
     * @param t1 the first type to be compared
     * @param t2 the second type to be compared
     * @return <code>true</code> if <code>t1</code> and <code>t2</code> are equal, <code>false</code> else
     */
    public static final boolean equals(IMetaType t1, IMetaType t2) {
        boolean equals = false;
        if (null != t1 && null != t2) {
            equals = t1.getName().equals(t2.getName());
            if (t1 instanceof TypeDescriptor && t2 instanceof TypeDescriptor) {
                TypeDescriptor<?> td1 = (TypeDescriptor<?>) t1;
                TypeDescriptor<?> td2 = (TypeDescriptor<?>) t2;
                if (td1.getGenericParameterCount() == td2.getGenericParameterCount()) {
                    for (int p = 0; equals && p < td1.getGenericParameterCount(); p++) {
                        equals = equals(td1.getGenericParameterType(p), td2.getGenericParameterType(p));
                    }
                }
            }
        }
        return equals;
    }

    /**
     * Returns the VIL name of <code>type</code>.
     * 
     * @param type the type to return the name for
     * @return the VIL name (if possible), the name else
     */
    public static String toName(IMetaType type) {
        String result;
        if (type instanceof TypeDescriptor) {
            result = ((TypeDescriptor<?>) type).getVilName();
        } else {
            result = type.getName();
        }
        return result;
    }
    
    /**
     * Allows to register internal mapped types, e.g., {@link TypeDescriptor}.
     * 
     * @param name the name of the type
     * @param type the actual type
     */
    public static void addTypeMapping(String name, TypeDescriptor<? extends IVilType> type) {
        DEFAULT.types.put(name, type);
    }

    /**
     * Returns mapped types provided by this registry and the descriptors created by this registry.
     * This can be used to map Java collections into and from VIL.
     * 
     * @param cls the class to be turned into a type
     * @param generics the generics to be applied to the type (ma< be <b>null</b>)
     * @return the type descriptor or <b>null</b> if none is provided
     */
    protected TypeDescriptor<?> getMappedType(Class<?> cls, TypeDescriptor<?>[] generics) {
        return null;
    }
    
    /**
     * Obtains the type descriptor of an object.
     * 
     * @param obj the object the descriptor shall be returned for
     * @return the descriptor
     */
    public TypeDescriptor<?> obtainTypeDescriptor(Object obj) {
        TypeDescriptor<?> result = null;
        if (obj instanceof IVilGenericType) {
            result = ((IVilGenericType) obj).getType();
        }
        if (null == result) {
            if (null == obj) {
                result = voidType();
            } else {
                result = findType(obj.getClass());
            }
        }
        return result;
    }
    
    /**
     * Adds a type alias to this specific type registry.
     * 
     * @param <T> the specific VilType or Artifact
     * @param name the name of the type alias
     * @param type the type to be aliased
     * @return <code>true</code> if successful, <code>false</code> else
     * @throws IllegalArgumentException in case that name is <b>null</b> or empty, <code>type</code> is <b>null</b>
     *   or this function shall be applied on {@link #DEFAULT}
     * @throws VilException if creating the type fails
     */
    public <T> boolean addTypeAlias(String name, TypeDescriptor<T> type) throws VilException {
        if (null == name || 0 == name.length()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        if (null == type) {
            throw new IllegalArgumentException("type must not be null");
        }
        if (DEFAULT == this) {
            throw new IllegalArgumentException("this function cannot be applied to the default type registry");
        }
        boolean success = false;
        TypeDescriptor<?> existing = getType(name, false);
        if (null == existing || equals(type, existing)) {
            types.put(name, new AliasTypeDescriptor<T>(this, name, type));
            success = true;
        }
        return success;
    }

}
