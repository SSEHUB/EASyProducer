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
 * A set of reflective operations on VilTypes. Instances of this class are created upon
 * registration. Thereby, the available operations are determined and cached for fast access.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the specific VilType or Artifact
 */
public class TypeDescriptor <T extends IVilType> implements IMetaType {

    public static final TypeDescriptor<PseudoVoid> VOID;
    public static final TypeDescriptor<PseudoType> TYPE;
    public static final TypeDescriptor<PseudoAny> ANY;
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(OperationDescriptor.class, Bundle.ID);
    
    static {
        TypeDescriptor<PseudoVoid> v = null; 
        TypeDescriptor<PseudoType> t = null; 
        TypeDescriptor<PseudoAny> a = null; 
        try {
            v = new TypeDescriptor<PseudoVoid>(PseudoVoid.class) {
                {
                    this.name = "Void";
                }

            };
        } catch (VilException e) {
            LOGGER.exception(e);
        }
        try {
            t = new TypeDescriptor<PseudoType>(PseudoType.class) {
                @Override
                public boolean isAssignableFrom(IMetaType type) {
                    return TypeDescriptor.class.isAssignableFrom(type.getClass());
                }

                @Override
                public boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc) {
                    return true;
                }

                {
                    this.name = "Type";
                }

            };
        } catch (VilException e) {
            LOGGER.exception(e);
        }
        try {
            a = new TypeDescriptor<PseudoAny>(PseudoAny.class) {
                @Override
                public boolean isAssignableFrom(IMetaType type) {
                    return TypeDescriptor.class.isAssignableFrom(type.getClass());
                }

                @Override
                public boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc) {
                    return true;
                }
                
                {
                    this.name = "Any";
                }
            };
        } catch (VilException e) {
            LOGGER.exception(e);
        }
        VOID = v;
        TYPE = t;
        ANY = a;
    }

    protected String name;
    private Class<T> cls;
    private OperationDescriptor[] operations;
    private OperationDescriptor[] conversions;
    private TypeDescriptor<? extends IVilType>[] parameter;
    
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
    TypeDescriptor(Class<T> cls) throws VilException {
        this(cls, (TypeDescriptor<? extends IVilType>[]) null);
    }
    
    /**
     * Creates a new type descriptor.
     * 
     * @param cls the class to create the type descriptor for
     * @param parameter type parameter (may be <b>null</b>)
     * @throws VilException if analyzing the class fails for some reason
     */
    TypeDescriptor(Class<T> cls, TypeDescriptor<? extends IVilType>... parameter) throws VilException {
        this.cls = cls;
        this.parameter = parameter;
        ClassMeta meta = cls.getAnnotation(ClassMeta.class);
        Instantiator inst = cls.getAnnotation(Instantiator.class);
        name = getAlias(meta);
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
        operations = new OperationDescriptor[tmp.size()];
        tmp.values().toArray(operations);
        conversions = new OperationDescriptor[convs.size()];
        convs.toArray(conversions);
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
                            convs.add(new OperationDescriptor(this, method));
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
            TypeDescriptor<?> tDesc = TypeRegistry.getType(getRegName(cls));
            if (null != tDesc) {
                int count = tDesc.getOperationsCount();
                for (int o = 0; o < count; o++) {
                    OperationDescriptor op = tDesc.getOperation(o);
                    if (!op.isConstructor() || (op.isConstructor() && cls == start)) {
                        String sig = op.getJavaSignature();
                        if (!operations.containsKey(sig)) {
                            operations.put(sig, tDesc.getOperation(o));
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
            String sig = OperationDescriptor.getJavaSignature(method);
            if (null == invAnnotation && !TypeRegistry.hasInheritedInvisibleAnnotation(
                sig, method.getDeclaringClass()) && filterMethodByName(method, instantiatorName)) {
                if (!operations.containsKey(sig) && OperationDescriptor.isOperationOrConstructor(method)) {
                    if (registerAliasOperation(operations, method)) {
                        operations.put(sig, new OperationDescriptor(this, method));
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
     * Register the given <code>method</code> as an alias operation, i.e., getters without "get".
     * This method considers {@link OperationMeta}.
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
                    OperationDescriptor desc = new OperationDescriptor(this, method, names[n]);
                    operations.put(desc.getJavaSignature(), desc);
                }
                regOriginal = names.length == 0;
            }
        } else {
            String name = method.getName();
            if (name.startsWith("get") && name.length() > 3) {
                name = name.substring(3);
                if (Character.isUpperCase(name.charAt(0))) {
                    name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
                }
                OperationDescriptor desc = new OperationDescriptor(this, method, name);
                operations.put(desc.getJavaSignature(), desc);
            }
        }
        return regOriginal;
    }
    
    /**
     * Returns the (simple) name of this type.
     * 
     * @return the simple name
     */
    public String getName() {
        return null == name ? cls.getSimpleName() : name;
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
        for (int o = 0; !found && o < operations.length; o++) {
            OperationDescriptor op = operations[o];            
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
    
    /**
     * Returns the available operations.
     * 
     * @return the available operations
     */
    public Iterable<OperationDescriptor> getOperations() {
        return new ArrayIterable<OperationDescriptor>(operations);
    }
    
    /**
     * Returns the number of operations provided by this type descriptor.
     * 
     * @return the number of operations
     */
    public int getOperationsCount() {
        return operations.length;
    }
    
    /**
     * Returns the specified operation.
     * 
     * @param index the index of the operation to be returned
     * @return the specified operation
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index&gt;={@link #getOperationsCount()}</code>
     */
    public OperationDescriptor getOperation(int index) {
        return operations[index];
    }
    
    /**
     * Returns the class of the described VIL type. Please use this
     * method sparingly as the required functionality is provided by
     * this class.
     * 
     * @return the class
     */
    public Class<T> getTypeClass() {
        return cls;
    }
    
    /**
     * Returns the number of conversions provided by this type descriptor.
     * 
     * @return the number of conversions, i.e., from this type to other types
     */
    public int getConversionsCount() {
        return conversions.length;
    }
    
    /**
     * Returns the specified conversion.
     * 
     * @param index the index of the conversion to be returned
     * @return the specified conversion
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index&gt;={@link #getConversionsCount()}</code>
     */
    public OperationDescriptor getConversion(int index) {
        return conversions[index];
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

    /**
     * Returns whether this type is the same or a super class of <code>type</code>.
     * 
     * @param type the descriptor to be tested
     * @return <code>true</code> if both types are assignment compatible, <code>false</code> else
     */
    @SuppressWarnings("unchecked")
    public boolean isAssignableFrom(IMetaType type) {
        boolean result = false;
        if (getClass().isInstance(type)) {
            result = isAssignableFrom(getClass().cast(type));
        }
        return result;
    }
    
    /**
     * Returns whether this descriptor is the same or a super class of <code>desc</code>.
     * 
     * @param desc the descriptor to be tested
     * @return <code>true</code> if both descriptors are assignment compatible, <code>false</code> else
     */
    public boolean isAssignableFrom(TypeDescriptor<? extends IVilType> desc) {
        boolean assignable;
        Class<?> descC = desc.getTypeClass();
        assignable = !isNAssign(descC) && !desc.isNAssign(cls);
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
        return assignable;
    }
    
    /**
     * Returns the conversion operation from this type to target type (if there is any).
     * 
     * @param sourceType the source type to convert from
     * @param targetType the target type to convert to
     * @return the conversion operation as defined in the underlying implementation class, 
     *   <b>null</b> if no matching can be found
     */
    public IMetaOperation findConversion(IMetaType sourceType, IMetaType targetType) {
        IMetaOperation result = null;
        for (int c = 0; null == result && c < conversions.length; c++) {
            IMetaOperation desc = conversions[c];
            if (desc.getParameterType(0).isAssignableFrom(sourceType) 
                && desc.getReturnType().isAssignableFrom(targetType)) {
                result = desc;
            }
        }
        return result;
    }
    
    /**
     * Returns the conversion operation from this type to target type considering
     * both types as declarators of the conversion operation (if there is any).
     * 
     * @param sourceType the source type to convert from
     * @param targetType the target type to convert to
     * @return the conversion operation as defined in the underlying implementation class, 
     *   <b>null</b> if no matching can be found
     */
    public static final OperationDescriptor findConversionOnBoth(TypeDescriptor<? extends IVilType> sourceType, 
        TypeDescriptor<? extends IVilType> targetType) {
        OperationDescriptor conversion = targetType.findConversion(sourceType, targetType);
        if (null == conversion) {
            conversion = sourceType.findConversion(sourceType, targetType);
        }
        return conversion;
    }
    
    /**
     * Returns the conversion operation from this type to target type (if there is any).
     * 
     * @param sourceType the source type to convert from
     * @param targetType the target type to convert to
     * @return the conversion operation as defined in the underlying implementation class, 
     *   <b>null</b> if no matching can be found
     */
    public OperationDescriptor findConversion(TypeDescriptor<? extends IVilType> sourceType, 
        TypeDescriptor<? extends IVilType> targetType) {
        // duplicated code with findConversion :(
        OperationDescriptor result = null;
        for (int c = 0; null == result && c < conversions.length; c++) {
            OperationDescriptor desc = conversions[c];
            if (desc.getParameterType(0).isAssignableFrom(sourceType) 
                && desc.getReturnType().isAssignableFrom(targetType)) {
                result = desc;
            }
        }
        return result;
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
    
    /**
     * Returns the number of type parameters.
     * 
     * @return the number of type parameter
     */
    public int getParameterCount() {
        return null == parameter ? 0 : parameter.length;
    }
    
    /**
     * Returns the specified parameter type.
     * 
     * @param index the index of the parameter type to return
     * @return the specified parameter type
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getParameterCount()}</code>
     */
    public TypeDescriptor<? extends IVilType> getParameterType(int index) {
        return parameter[index];
    }

    /**
     * Creates an empty array of type descriptors.
     * 
     * @param length the length of the array to be created
     * @return the array instance
     */
    @SuppressWarnings("unchecked")
    public static TypeDescriptor<? extends IVilType>[] createArray(int length) {
        return new TypeDescriptor[length];
    }
    
    /**
     * Appends the type parameters to <code>name</code>.
     * 
     * @param name the VIL name of this type
     * @return the VIL name including parameter types if applicable
     */
    private String appendParameter(String name) {
        StringBuilder tmp = new StringBuilder(name);
        int count = getParameterCount();
        if (count > 0) {
            tmp.append('(');
            for (int p = 0; p < count; p++) {
                if (p > 0) {
                    tmp.append(", ");
                }
                TypeDescriptor<? extends IVilType> param = getParameterType(p);
                if (null == param) {
                    tmp.append("<null>"); // shall not happen
                } else {
                    tmp.append(param.getVilName());
                }
            }
            tmp.append(')');
        }
        return tmp.toString();
    }
    
    /**
     * Returns the name of this type in VIL notation.
     * 
     * @return the name of this type
     */
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

    /**
     * Returns whether this descriptor represents a VIL collection, i.e., set, sequence or collection.
     * 
     * @return <code>true</code> if this is a VIL collection, <code>false</code> else
     */
    public boolean isCollection() {
        return isSet() || isSequence() || isCollection(cls);
    }

    /**
     * Returns whether this descriptor represents a VIL set.
     * 
     * @return <code>true</code> if this is a VIL set, <code>false</code> else
     */
    public boolean isSet() {
        return isSet(cls);
    }

    /**
     * Returns whether this descriptor represents a VIL sequence.
     * 
     * @return <code>true</code> if this is a VIL sequence, <code>false</code> else
     */
    public boolean isSequence() {
        return isSequence(cls);
    }
    
    /**
     * Returns whether the given <code>object</code> is an instance of this descriptor.
     * 
     * @param object the object to be checked
     * @return <code>true</code> if it is an instance, <code>false</code> else
     */
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

}
