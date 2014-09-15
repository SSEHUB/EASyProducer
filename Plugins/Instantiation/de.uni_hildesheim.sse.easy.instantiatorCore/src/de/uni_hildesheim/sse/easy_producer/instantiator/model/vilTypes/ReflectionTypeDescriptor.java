package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor.CompatibilityResult;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Represents an actual type based on reflection analysis of the underlying class. Instances of this class are created 
 * upon registration. This class works on the default type registry (only). Thereby, the available operations are 
 * determined and cached for fast access.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the specific VilType or Artifact
 */
class ReflectionTypeDescriptor <T extends IVilType> extends TypeDescriptor <T> {

    // define the constants of the pseudo types here but register
    // only those in the Type registry while startup thay may be used
    public static final TypeDescriptor<PseudoVoid> VOID;
    public static final TypeDescriptor<PseudoType> TYPE;
    public static final TypeDescriptor<PseudoAny> ANY;
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ReflectionOperationDescriptor.class, 
        Bundle.ID);
    
    static {
        ReflectionTypeDescriptor<PseudoVoid> v = null; 
        ReflectionTypeDescriptor<PseudoType> t = null; 
        ReflectionTypeDescriptor<PseudoAny> a = null; 
        try {
            v = new ReflectionTypeDescriptor<PseudoVoid>(PseudoVoid.class) {

                @Override
                public boolean canBeInstantiated() {
                    return false;
                }

                {
                    setName("Void");
                }

            };
        } catch (VilException e) {
            LOGGER.exception(e);
        }
        try {
            t = new ReflectionTypeDescriptor<PseudoType>(PseudoType.class) {
                @Override
                public boolean isAssignableFrom(IMetaType type) {
                    return ReflectionTypeDescriptor.class.isAssignableFrom(type.getClass());
                }

                @Override
                public boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc) {
                    return equals(desc); // true
                }

                @Override
                public boolean canBeInstantiated() {
                    return false;
                }

                {
                    setName("Type");
                }

            };
        } catch (VilException e) {
            LOGGER.exception(e);
        }
        try {
            a = new ReflectionTypeDescriptor<PseudoAny>(PseudoAny.class) {
                @Override
                public boolean isAssignableFrom(IMetaType type) {
                    return ReflectionTypeDescriptor.class.isAssignableFrom(type.getClass());
                }

                @Override
                public boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc) {
                    return true;
                }
                
                @Override
                public boolean isInstance(Object object) {
                    return true;
                }

                @Override
                public boolean canBeInstantiated() {
                    return false;
                }

                {
                    setName("Any");
                }
            };
        } catch (VilException e) {
            LOGGER.exception(e);
        }
        VOID = v;
        TYPE = t;
        ANY = a;

        // build up a pseudo type and conversions for TypeDescriptor -> Select
        // we must use the own class for the conversions due to class initialization sequence
        TypeRegistry.addTypeMapping(TypeDescriptor.class.getSimpleName(), TYPE);
    }
    
    private Class<T> cls;
    private boolean canBeInstantiated = false; // to be initialized while adding operations

    /**
     * Stores non-assignable classes.
     * 
     * @see ClassMeta#nAssign()
     */
    private Class<?>[] nAssign;
    
    /**
     * Creates a new type descriptor.
     * 
     * @param cls the class to create the type descriptor for
     * @throws VilException if analyzing the class fails for some reason
     */
    ReflectionTypeDescriptor(Class<T> cls) throws VilException {
        this(cls, (TypeDescriptor<? extends IVilType>[]) null);
    }
    
    /**
     * Creates a new type descriptor.
     * 
     * @param cls the class to create the type descriptor for
     * @param parameter type parameter (may be <b>null</b>)
     * @throws VilException if analyzing the class fails for some reason
     */
    ReflectionTypeDescriptor(Class<T> cls, TypeDescriptor<? extends IVilType>... parameter) throws VilException {
        super(parameter);
        this.cls = cls;
        ClassMeta meta = cls.getAnnotation(ClassMeta.class);
        Instantiator inst = cls.getAnnotation(Instantiator.class);
        setName(getAlias(meta));
        Class<?> further = null;
        if (null != meta) {
            nAssign = meta.nAssign();
            further = meta.furtherOperations();
        }
        java.util.Map<String, OperationDescriptor> tmp = new HashMap<String, OperationDescriptor>();
        List<OperationDescriptor> convs = new ArrayList<OperationDescriptor>();
        addMethods(tmp, cls, cls, null != inst ? inst.value() : null);
        addConversions(cls, convs);
        if (null != further && Object.class != further) {
            addMethods(tmp, further, further, null != inst ? inst.value() : null);
            addConversions(further, convs);
        }
        setOperations(tmp.values());
        setConversions(convs);
    }
    
    /**
     * Adds the the conversions in <code>cls</code> to <code>convs</code>.
     * 
     * @param cls the class to analyze
     * @param convs the conversions (to be modified as a side effect)
     */
    private void addConversions(Class<?> cls, List<OperationDescriptor> convs) {
        Method[] methods = cls.getDeclaredMethods();
        if (null != methods) {
            for (int m = 0; m < methods.length; m++) {
                Method method = methods[m];
                int mod = method.getModifiers();
                Conversion conv = method.getAnnotation(Conversion.class);
                if (null != conv && !Modifier.isAbstract(mod) && Modifier.isStatic(mod) && Modifier.isPublic(mod)) {
                    if (Void.TYPE == method.getReturnType()) {
                        LOGGER.warn("conversion operations must return a value (" + method + "). Ignored.");
                    } else {
                        Class<?>[] param = method.getParameterTypes();
                        if (1 == param.length) {
                            // no type check/assignment to class for the moment
                            convs.add(new ReflectionOperationDescriptor(this, method));
                        } else {
                            LOGGER.warn("conversion operations must have exactly one parameter (" 
                                + method + "). Ignored.");
                        }
                    }
                }
            }
        }
    }

    /**
     * Adds a specific operation descriptor via its signature to the temporary operation map.
     * Adjusts {@link #canBeInstantiated}.
     * 
     * @param operations the map of operations (signature-descriptor) to be modified as a side effect
     * @param sig the signature
     * @param desc the operation descriptor to be added
     */
    private void addOperation(java.util.Map<String, OperationDescriptor> operations, String sig, 
        OperationDescriptor desc) {
        operations.put(sig, desc);
        canBeInstantiated |= desc.isConstructor();
    }

    /**
     * Adds all (relevant and not invisible) methods provided by <code>cls</code>.
     * This method works recursively on superclasses of <code>cls</code>.
     * 
     * @param operations the map of operations (signature-descriptor) to be modified as a side effect
     * @param cls the class to be analyzed
     * @param start the class for which this call was initiated
     * @param instantiatorName the name of the instantiator (may be <b>null</b>)
     */
    private void addMethods(java.util.Map<String, OperationDescriptor> operations, Class<?> cls, Class<?> start, 
        String instantiatorName) {
        if (Object.class != cls) {
            TypeDescriptor<?> tDesc = TypeRegistry.DEFAULT.getType(getRegName(cls));
            if (null != tDesc) {
                int count = tDesc.getOperationsCount();
                for (int o = 0; o < count; o++) {
                    OperationDescriptor op = tDesc.getOperation(o);
                    if (!op.isConstructor() || (op.isConstructor() && cls == start)) {
                        String sig = op.getJavaSignature();
                        if (!operations.containsKey(sig)) {
                            addOperation(operations, sig, tDesc.getOperation(o));
                        }
                    }
                }
            } else {
                Method[] methods = cls.getDeclaredMethods();
                for (int m = 0; m < methods.length; m++) {
                    addMethod(operations, methods[m], instantiatorName);
                }
            }
            Class<?> superCls = cls.getSuperclass();
            if (null != superCls) {
                addMethods(operations, superCls, start, instantiatorName);
            }
            Class<?>[] ifaces = cls.getInterfaces();
            if (null != ifaces) {
                for (int i = 0; i < ifaces.length; i++) {
                    addMethods(operations, ifaces[i], start, instantiatorName);
                }
            }
        }
    }

    /**
     * Adds the given method to the operations map.
     * 
     * @param operations the map of operations (signature-descriptor) to be modified as a side effect
     * @param method the method to be added
     * @param instantiatorName the name of the instantiator (may be <b>null</b>)
     * 
     * @see OperationDescriptor#isOperationOrConstructor(Method)
     */
    private void addMethod(java.util.Map<String, OperationDescriptor> operations, Method method, 
        String instantiatorName) {
        if (Modifier.isPublic(method.getModifiers())) {
            Invisible invAnnotation = method.getAnnotation(Invisible.class);
            String sig = SignatureUtils.getJavaSignature(method);
            if (null == invAnnotation && !TypeRegistry.hasInheritedInvisibleAnnotation(
                sig, method.getDeclaringClass()) && filterMethodByName(method, instantiatorName)) {
                if (!operations.containsKey(sig) && OperationDescriptor.isOperationOrConstructor(method)) {
                    if (registerAliasOperation(operations, method)) {
                        addOperation(operations, sig, new ReflectionOperationDescriptor(this, method));
                    }
                }
            }
        }
    }

    /**
     * Returns whether the method shall be considered based on its name. In instantiators, 
     * only methods with the instantiator name or constructors are considered.
     * 
     * @param method the method to be checked
     * @param instantiatorName the instantiator name signalling that we check for an instantiator (may be <b>null</b> 
     * in case of an ordinary {@link IVilType} or an artifact)
     * @return <code>true</code> if it shall be considered, <code>false</code> else
     */
    private static boolean filterMethodByName(Method method, String instantiatorName) {
        boolean result = false;
        if (null == instantiatorName) {
            result = true;
        } else {
            result = instantiatorName.equals(method.getName()) || OperationDescriptor.isConstructor(method);
        }
        return result;
    }
    
    /**
     * Register the given <code>method</code> as an alias operation, i.e., getters without 
     * {@link Constants#GETTER_PREFIX}. This method considers {@link OperationMeta}.
     * 
     * @param operations the map of operations (signature-descriptor) to be modified as a side effect
     * @param method the method to be considered
     * @return <code>true</code> register also the original operation, <code>false</code> do not register
     *   the original operation
     */
    private boolean registerAliasOperation(java.util.Map<String, OperationDescriptor> operations, Method method) {
        boolean regOriginal = true;
        OperationMeta meta = method.getAnnotation(OperationMeta.class);
        if (null != meta) {
            String[] names = meta.name();
            if (null != names) {
                for (int n = 0; n < names.length; n++) {
                    OperationDescriptor desc = new ReflectionOperationDescriptor(this, method, names[n]);
                    addOperation(operations, desc.getJavaSignature(), desc);
                }
                regOriginal = names.length == 0;
            }
        } else {
            String name = method.getName();
            if (name.startsWith(Constants.GETTER_PREFIX) && name.length() > 3) {
                name = name.substring(3);
                if (Character.isUpperCase(name.charAt(0))) {
                    name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                }
                OperationDescriptor desc = new ReflectionOperationDescriptor(this, method, name);
                addOperation(operations, desc.getJavaSignature(), desc);
            }
        }
        return regOriginal;
    }
    
    /**
     * Returns the name how a class shall be registered based on {@link ClassMeta}.
     * @param cls the class to be considered
     * @return the name
     */
    public static String getRegName(Class<?> cls) {
        String name = getAlias(cls);
        if (null == name) {
            name = cls.getSimpleName();
        }
        return name;
    }
    
    /**
     * Returns a possible alias for <code>cls</code> based on {@link ClassMeta}.
     * @param cls the class to be considered
     * @return the alias or <b>null</b> if there is none
     */
    public static String getAlias(Class<?> cls) {
        return getAlias(cls.getAnnotation(ClassMeta.class));
    }

    /**
     * Returns a possible alias for {@link ClassMeta}.
     * @param meta the annotation to query
     * @return the alias or <b>null</b> if there is none
     */
    private static String getAlias(ClassMeta meta) {
        String name = null;
        if (null != meta && null != meta.name()) {
            name = meta.name();
        }
        return name;
    }
    
    @Override
    public String getName() {
        String tmp = super.getName();
        return null == tmp ? cls.getSimpleName() : tmp;
    }
    
    @Override
    public String getQualifiedName() {
        return getName();
    }
    
    @Override
    public boolean canBeInstantiated() {
        return canBeInstantiated;
    }
    
    /**
     * Creates an instance of the type according to the given parameters. 
     * 
     * @param params the parameters
     * @return the created instance
     * @throws VilException in case that the creation does not work
     */
    public T create(Object...params) throws VilException {
        boolean found = false;
        T result = null;
        int oCount = getOperationsCount();
        for (int o = 0; !found && o < oCount; o++) {
            OperationDescriptor op = getOperation(o);            
            if (op.isConstructor() && CompatibilityResult.COMPATIBLE == op.isCompatible(getTypeClass(), params)) {
                found = true;
                Object res = op.invoke(params);
                if (null == res) {
                    throw new VilException("VIL constructor does not return a result", VilException.ID_NO_RESULT);
                } else {
                    try {
                        result = getTypeClass().cast(res);
                    } catch (ClassCastException e) {
                        throw new VilException("VIL constructor returns wrong result type", 
                            VilException.ID_TYPE_INCOMPATIBILITY);
                    }
                }
            }
        }
        if (!found) {
            throw new VilException("VIL constructor not found", VilException.ID_NOT_FOUND);
        }
        return result;
    }

    @Override
    public Class<T> getTypeClass() {
        return cls;
    }
    
    /**
     * Checks whether the given class <code>cls</code> is considered as a 
     * non-assignable class for this type descriptor.
     * 
     * @param cls the class to be tested
     * @return <code>true</code> if it is non-assignable, <code>false</code> else
     * @see ClassMeta#nAssign()
     */
    private boolean isNAssign(Class<?> cls) {
        boolean found = false;
        if (null != nAssign) {
            for (int n = 0; !found && n < nAssign.length; n++) {
                found = (cls == nAssign[n]);
            }
        }
        return found;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean isAssignableFrom(IMetaType type) {
        boolean result = false;
        if (getClass().isInstance(type)) {
            result = isAssignableFrom(getClass().cast(type));
        }
        return result;
    }

    @Override
    public boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc) {
        boolean assignable;
        if (desc instanceof ReflectionTypeDescriptor) {
            ReflectionTypeDescriptor<?> rDesc = (ReflectionTypeDescriptor<?>) desc;
            Class<?> descC = rDesc.getTypeClass();
            assignable = !isNAssign(descC) && !rDesc.isNAssign(cls);
            if (assignable) {
                assignable = cls.isAssignableFrom(descC) || desc == ANY;
                if (assignable && getParameterCount() > 0) {
                    assignable = (getParameterCount() == desc.getParameterCount());
                    for (int p = 0; assignable && p < getParameterCount(); p++) {
                        if (null != getParameterType(p)) {
                            // generic type without specific generic parameter e.g. in set -> match
                            assignable = getParameterType(p).isAssignableFrom(desc.getParameterType(p));
                        }
                    }
                }
            }
        } else {
            assignable = false;
        }
        return assignable;
    }
    
    /**
     * Returns a textual representation of this descriptor (the Java signature).
     * 
     * @return the textual representation
     */
    @Override
    public String toString() {
        return getName() + " representing " + cls.getName();
    }

    @Override
    public String getVilName() {
        String result;
        if (Set.class.isAssignableFrom(cls)) {
            result = appendParameter("setOf"); 
        } else if (Sequence.class.isAssignableFrom(cls)) {
            result = appendParameter("sequenceOf"); 
        } else if (Map.class.isAssignableFrom(cls)) {
            result = appendParameter("mapOf"); 
        } else if (getParameterCount() > 0) {
            result = appendParameter(getName()); 
        } else {
            result = getName();
        }
        return result;
    }
    
    /**
     * Returns whether the given class represents a VIL collection.
     * 
     * @param cls the class to be checked
     * @return <code>true</code> if it is a VIL collection, <code>false</code> else
     */
    static boolean isCollection(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }
    
    /**
     * Returns whether the given class represents a VIL set.
     * 
     * @param cls the class to be checked
     * @return <code>true</code> if it is a VIL set, <code>false</code> else
     */
    static boolean isSet(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }

    /**
     * Returns whether the given class represents a VIL sequence.
     * 
     * @param cls the class to be checked
     * @return <code>true</code> if it is a VIL sequence, <code>false</code> else
     */
    static boolean isSequence(Class<?> cls) {
        return Sequence.class.isAssignableFrom(cls);
    }

    @Override
    public boolean isCollection() {
        return isSet() || isSequence() || isCollection(cls);
    }

    @Override
    public boolean isSet() {
        return isSet(cls);
    }

    @Override
    public boolean isSequence() {
        return isSequence(cls);
    }

    @Override
    public boolean isInstance(Object object) {
        boolean ok = cls.isInstance(object);
        if (!ok) {
            ClassMeta meta = cls.getAnnotation(ClassMeta.class);
            if (null != meta && null != meta.equiv()) {
                Class<?>[] equiv = meta.equiv();
                for (int e = 0; !ok && e < equiv.length; e++) {
                    ok = equiv[e].isInstance(object);
                }
            }
        }
        return ok;
    }
    
    @Override
    public boolean isBasicType() {
        return TypeHelper.isBasicType(cls);
    }
    
    @Override
    public TypeRegistry getTypeRegistry() {
        return TypeRegistry.DEFAULT; // see class comment, default registry only
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public OperationDescriptor addPlaceholderOperation(String name, int parameterCount, 
        boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return false; // shall not be handled by IActualTypeProvider
    }

}
