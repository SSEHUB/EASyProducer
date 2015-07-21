package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor.CompatibilityResult;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Represents an actual type based on reflection analysis of the underlying class. Instances of this class are created 
 * upon registration. This class works on the default type registry (only). Thereby, the available operations are 
 * determined and cached for fast access.
 * 
 * @param <T> the specific VilType or Artifact
 * @author Holger Eichelberger
 */
public class ReflectionTypeDescriptor <T> extends TypeDescriptor <T> {

    // define the constants of the pseudo types here but register
    // only those in the Type registry while startup thay may be used
    // Add all types into PSEUDO_TYPES array.
    public static final TypeDescriptor<PseudoVoid> VOID;
    public static final TypeDescriptor<PseudoType> TYPE;
    public static final TypeDescriptor<PseudoAny> ANY;
    public static final TypeDescriptor<PseudoVersion> VERSION;
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ReflectionOperationDescriptor.class, 
        Bundle.ID);
    
    static {
        ReflectionTypeDescriptor<PseudoVoid> v = null; 
        ReflectionTypeDescriptor<PseudoType> t = null; 
        ReflectionTypeDescriptor<PseudoAny> a = null; 
        ReflectionTypeDescriptor<PseudoVersion> r = null; 
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
            v.resolve();
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
                public boolean isAssignableFrom(TypeDescriptor<?> desc) {
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
            t.resolve();
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
                public boolean isAssignableFrom(TypeDescriptor<?> desc) {
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
            a.resolve();
        } catch (VilException e) {
            LOGGER.exception(e);
        }
        try {
            r = new ReflectionTypeDescriptor<PseudoVersion>(PseudoVersion.class) {

                @Override
                public boolean canBeInstantiated() {
                    return false;
                }

                {
                    setName("Version");
                }

            };
            r.resolve();
        } catch (VilException e) {
            LOGGER.exception(e);
        }
        VOID = v;
        TYPE = t;
        ANY = a;
        VERSION = r;

        // build up a pseudo type and conversions for TypeDescriptor -> Select
        // we must use the own class for the conversions due to class initialization sequence
        TypeRegistry.addTypeMapping(TypeDescriptor.class.getSimpleName(), TYPE);
    }
    // checkstyle: stop declaration order check
    public static final TypeDescriptor<?>[] PSEUDO_TYPES = {VOID, TYPE, ANY, VERSION};
    // checkstyle: resume declaration order check    
    private Class<T> cls;
    private boolean canBeInstantiated = false; // to be initialized while adding operations
    private IMetaType superType;

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
    protected ReflectionTypeDescriptor(Class<T> cls) throws VilException {
        this(cls, (TypeDescriptor<?>[]) null);
    }
    
    /**
     * Creates a new type descriptor.
     * 
     * @param cls the class to create the type descriptor for
     * @param parameter type parameter (may be <b>null</b>)
     * @throws VilException if analyzing the class fails for some reason
     */
    ReflectionTypeDescriptor(Class<T> cls, TypeDescriptor<?>... parameter) throws VilException {
        super(parameter);
        this.cls = cls;
    }
    
    /**
     * Resolves the details of the type. Required to register the type first in order to allow resolution of the own
     * type in operations and fields.
     * 
     * @return <b>this</b> (builder pattern)
     * @throws VilException in case of resolution problems
     */
    protected ReflectionTypeDescriptor<T> resolve() throws VilException {
        if (!isInitialized()) {
            processInner(cls);
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
            superType = getTypeRegistry().findType(cls.getSuperclass());
        }
        return this;
    }
    
    /**
     * Processes the inner classes of <code>cls</code>.
     * 
     * @param cls the class
     * @throws VilException in case of failures
     */
    protected void processInner(Class<?> cls) throws VilException {
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
                            convs.add(new ReflectionOperationDescriptor(this, method, considerAsConstructor(method)));
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
            TypeDescriptor<?> tDesc = getTypeRegistry().getType(getRegName(cls));
            if (null != tDesc && tDesc != this) {
                int count = tDesc.getOperationsCount();
                for (int o = 0; o < count; o++) {
                    OperationDescriptor op = tDesc.getOperation(o);
                    if (!op.isConstructor() || (op.isConstructor() && cls == start)) {
                        String sig = op.getJavaSignature();
                        if (!operations.containsKey(sig)) {
                            addOperation(operations, sig, tDesc.getOperation(o).specializeFor(this));
                        }
                    }
                }
            } else {
                Method[] methods = cls.getDeclaredMethods();
                for (int m = 0; m < methods.length; m++) {
                    Method method = methods[m];
                    if (enableMethod(method)) {
                        addMethod(operations, method, instantiatorName);
                    }
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
     * Returns whether a method shall be added.
     * 
     * @param method the method to be added
     * @return <code>true</code> if the method shall be added, <code>false</code> else
     */
    protected boolean enableMethod(Method method) {
        return true;
    }
    
    /**
     * Returns whether the given <code>method</code> shall be considered as constructor.
     * 
     * @param method the method to be checked
     * @return <code>true</code> if the method shall be considered as constructor, <code>false</code> else
     */
    protected boolean considerAsConstructor(Method method) {
        return OperationDescriptor.isConstructor(method);
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
                        addOperation(operations, sig, createDescriptor(method, null, considerAsConstructor(method)));
                    }
                }
            }
        }
    }
    
    /**
     * Creates a reflection operation descriptor for an usual method call.
     * 
     * @param method the method to be wrapped into the descriptor
     * @param name the name of the operation (<b>null</b> use the one of <code>method</code>)
     * @param constructor whether the method is considered to be a constructor
     * @return the descriptor
     */
    protected ReflectionOperationDescriptor createDescriptor(Method method, String name, boolean constructor) {
        String tmp = name;
        if (null == tmp) {
            tmp = method.getName();
        }
        return new ReflectionOperationDescriptor(this, method, tmp, considerAsConstructor(method));
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
                    OperationDescriptor desc = createDescriptor(method, names[n], considerAsConstructor(method));
                    addOperation(operations, desc.getJavaSignature(), desc);
                }
                regOriginal = names.length == 0;
            }
        } else {
            String name = stripGetterPrefix(method.getName());
            if (null != name) {
                OperationDescriptor desc = createDescriptor(method, name, considerAsConstructor(method));
                addOperation(operations, desc.getJavaSignature(), desc);
            }
        }
        return regOriginal;
    }

    /**
     * Strips the getter prefix {@link Constants#GETTER_PREFIX} from <code>name</code>.
     * 
     * @param name the name to strip
     * @return the name without the getter prefix, <b>null</b> if there was nothing to strip off
     */
    public static String stripGetterPrefix(String name) {
        if (name.startsWith(Constants.GETTER_PREFIX) && name.length() > 3) {
            name = name.substring(3);
            if (Character.isUpperCase(name.charAt(0))) {
                name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
            }
        } else {
            name = null;
        }
        return name;
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
        if (null != meta && null != meta.name() && meta.name().length() > 0) {
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
        String tmp = super.getQualifiedName();
        return null == tmp ? getName() : tmp;
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
                    throw new VilException("VIL constructor does not return a result", 
                           VilException.ID_NO_RESULT);
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
            throw new VilException("VIL constructor not found", VilException.ID_OP_NOT_FOUND);
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
    
    @Override
    public boolean isAssignableFrom(IMetaType type) {
        boolean result = false;
        type = AliasTypeDescriptor.unalias(type);
        if (ReflectionTypeDescriptor.class.isInstance(type)) {
            result = isAssignableFrom(ReflectionTypeDescriptor.class.cast(type));
        }
        return result;
    }

    @Override
    public boolean isAssignableFrom(TypeDescriptor<?> desc) {
        boolean assignable;
        desc = AliasTypeDescriptor.unalias(desc);
        if (desc instanceof ReflectionTypeDescriptor) {
            ReflectionTypeDescriptor<?> rDesc = (ReflectionTypeDescriptor<?>) desc;
            Class<?> descC = rDesc.getTypeClass();
            assignable = !isNAssign(descC) && !rDesc.isNAssign(cls);
            if (assignable) {
                assignable = cls.isAssignableFrom(descC) || desc == ANY;
                if (assignable && getGenericParameterCount() > 0) {
                    assignable = (getGenericParameterCount() == desc.getGenericParameterCount());
                    for (int p = 0; assignable && p < getGenericParameterCount(); p++) {
                        if (null != getGenericParameterType(p)) {
                            // generic type without specific generic parameter e.g. in set -> match
                            assignable = getGenericParameterType(p).isAssignableFrom(desc.getGenericParameterType(p));
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
            result = appendParameter("setOf", 0); 
        } else if (Sequence.class.isAssignableFrom(cls)) {
            result = appendParameter("sequenceOf", 0); 
        } else if (Map.class.isAssignableFrom(cls)) {
            result = appendParameter("mapOf", 0); 
        } else if (ResolvableOperationType.class.isAssignableFrom(cls)) {
            result = "callOf";
            TypeDescriptor<?> ret = getGenericParameterType(getGenericParameterCount() - 1);
            if (VOID != ret) {
                result += " " + ret.getVilName() + " ";
            }
            result += appendParameter("", 1); 
        } else if (getGenericParameterCount() > 0) {
            result = appendParameter(getName(), 0); 
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
    
    /**
     * Returns whether the given class represents a VIL map.
     * 
     * @param cls the class to be checked
     * @return <code>true</code> if it is a VIL map, <code>false</code> else
     */
    static boolean isMap(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }

    @Override
    public boolean isCollection() {
        return isSet() || isSequence() || isCollection(cls);
    }

    @Override
    public boolean isMap() {
        return isMap(cls);
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
        return null != cls.getAnnotation(Instantiator.class);
    }

    @Override
    public IMetaType getSuperType() {
        return superType;
    }

}
