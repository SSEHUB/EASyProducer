/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.instantiation.rt.core.model.rtVil.types;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IClassNameMapper;
import net.ssehub.easy.instantiation.core.model.vilTypes.IClassNameMapperProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IDirectTypeRegistryAccess;
import net.ssehub.easy.instantiation.core.model.vilTypes.ILazyDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IRegisteredStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypeResolver;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Map;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReflectionConstructorDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReflectionFieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReflectionOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReflectionTypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Bundle;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.ISimulationNotifier;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilStorage;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Defines the rt-VIL specific type registry, i.e., it may provide specific types not visible to VIL.
 * 
 * @author Holger Eichelberger
 */
public class RtVilTypeRegistry extends TypeRegistry implements IClassNameMapperProvider {

    public static final RtVilTypeRegistry INSTANCE = new RtVilTypeRegistry();
    private static ITypeAnalyzer typeAnalyzer;
    
    
    /**
     * Prevents external creation.
     */
    private RtVilTypeRegistry() {
        super(TypeRegistry.DEFAULT);
    }

    /**
     * Returns the type descriptor for the built-in type 'RtVilConcept'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> conceptType() {
        return INSTANCE.getType(Constants.TYPE_RT_VIL_CONCEPT);
    }

    /**
     * Returns the type descriptor for the built-in type 'Strategy'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> strategyType() {
        return INSTANCE.getType(Constants.TYPE_STRATEGY);
    }

    /**
     * Returns the type descriptor for the built-in type 'Tactic'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> tacticType() {
        return INSTANCE.getType(Constants.TYPE_TACTIC);
    }
    
    /**
     * Realizes a slightly extended reflection operation descriptor which may the actual disable execution in case 
     * of simulation as well as VIL-to-Java mapping and parameter generics mappings.
     * 
     * @author Holger Eichelberger
     */
    private static class RtReflectionOperationDescriptor extends ReflectionOperationDescriptor {
        
        private boolean disableExecution;
        
        /**
         * Creates a new operation descriptor.
         * 
         * @param declaringType the declaring type
         * @param method the reflection method to be called
         * @param name optional explicit name of the operation (<b>null</b> to use the name from <code>method</code>)
         * @param isConstructor whether this descriptor shall act as constructor
         * @param disableExecution if {@link RtVilStorage#isInSimulation()} is set and this parameter is true,
         *     this operation descriptor will not be executed and return <b>null</b> instead
         */
        public RtReflectionOperationDescriptor(TypeDescriptor<?> declaringType, Method method, String name, 
            boolean isConstructor, boolean disableExecution) {
            super(declaringType, method, name, isConstructor);
            this.disableExecution = disableExecution;
        }
        
        @Override
        protected Class<?>[] getParameterGenerics(int index) {
            return RtVilTypeRegistry.getTypeAnalyzer().getParameterGenerics(getMethod(), index);
        }
        
        @Override
        protected boolean considerNamedParameters() {
            return false;
        }

        @Override
        protected Class<?>[] getReturnGenerics() {
            return RtVilTypeRegistry.getTypeAnalyzer().getReturnGenerics(getMethod());
        }
        
        @Override
        public Object invoke(Object... args) throws VilException {
            mapArgumentsToJava(args);
            Object result;
            ISimulationNotifier notifier = RtVilStorage.getSimulationNotifier();
            if (null != notifier && disableExecution) {
                notifier.notifyOperationCall(this, args);
                result = null;
            } else {
                result = super.invoke(args);
            }
            return mapValueToVil(result, getReturnType());
        }
    }
    
    /**
     * Specializes the reflection constructor descriptor to consider parameter generics and VIL-to-Java mapping.
     * 
     * @author Holger Eichelberger
     */
    private static class RtReflectionConstructorDescriptor extends ReflectionConstructorDescriptor {
        
        /**
         * Creates a reflection constructor descriptor.
         * 
         * @param declaringType the declaring type
         * @param constructor the constructor
         */
        public RtReflectionConstructorDescriptor(TypeDescriptor<?> declaringType, Constructor<?> constructor) {
            super(declaringType, constructor);
        }

        @Override
        protected Class<?>[] getParameterGenerics(int index) {
            return RtVilTypeRegistry.getTypeAnalyzer().getParameterGenerics(getConstructor(), index);
        }
        
        @Override
        public Object invoke(Object... args) throws VilException {
            mapArgumentsToJava(args);
            return super.invoke(args);
        }
        
    }

    /**
     * Specializes the reflection field descriptor to provide a VIL-to-Java mapping.
     * 
     * @author Holger Eichelberger
     */
    private static class RtReflectionFieldDescriptor extends ReflectionFieldDescriptor {
        
        /**
         * Creates a new reflection field descriptor taking the information from <code>field</code>.
         * 
         * @param declaringType the declaring type
         * @param field the field
         * @param name the explicit name of the field (may be <b>null</b> to take the name of <code>field</code>)
         * @param typeGenerics the generics of the field type (may be <b>null</b>)
         */
        public RtReflectionFieldDescriptor(TypeDescriptor<?> declaringType, Field field, String name, 
            Class<?>[] typeGenerics) {
            super(declaringType, field, name, typeGenerics);
        }
        
        @Override
        public Object getValue(Object owner) throws VilException {
            return mapValueToVil(super.getValue(owner), getType());
        }

        @Override
        public void setValue(Object owner, Object value) throws VilException {
            super.setValue(owner, mapValueToJava(value));
        }
        
    }

    /**
     * Implements the rt-VIL specific reflection type descriptor.
     * 
     * @param <T> the actual type being represented
     * @author Holger Eichelberger
     */
    private static class RtTypeDescriptor<T> extends ReflectionTypeDescriptor<T> {

        private boolean canBeInstantiated;
        
        /**
         * Creates a type descriptor.
         * 
         * @param cls the type class
         * @param name the (qualified) name of the descriptor
         * @throws VilException in case that creating the descriptor fails
         */
        RtTypeDescriptor(Class<T> cls, String name) throws VilException {
            super(cls);
            super.setName(name);
        }
        
        @Override
        protected void setName(String name) {
            if (!isNameSet()) { // name is set in constructor - avoid resetting
                super.setName(name);
            }
        }
        
        @Override
        protected RtTypeDescriptor<T> resolve() throws VilException {
//            if (!isInitialized()) {
//                Field[] fields = getTypeClass().getFields();
//                List<FieldDescriptor> fd = new ArrayList<FieldDescriptor>();
//                for (int f = 0; f < fields.length; f++) {
//                    Field field = fields[f];
//                    boolean isVisible = Modifier.isPublic(field.getModifiers());
//                    String name = null;
//                    if (isVisible && null != typeAnalyzer) {
//                        name = typeAnalyzer.getVilName(field);
//                        isVisible &= typeAnalyzer.isVisible(fields[f]);
//                    }
//                    if (isVisible) {
//                        fd.add(new RtReflectionFieldDescriptor(this, fields[f], name, 
//                            typeAnalyzer.getFieldGenerics(fields[f])));
//                    }
//                }
//                setFields(fd);
//            }
            super.resolve();
            for (int o = 0; o < getOperationsCount(); o++) {
                OperationDescriptor op = getOperation(o);
                if (op instanceof ILazyDescriptor) {
                    ((ILazyDescriptor) op).forceInitialization();
                }
            }
            return this;
        }
        
        @Override
        protected void resolveFields() {
            Field[] fields = getTypeClass().getFields();
            List<FieldDescriptor> fd = new ArrayList<FieldDescriptor>();
            for (int f = 0; f < fields.length; f++) {
                Field field = fields[f];
                boolean isVisible = Modifier.isPublic(field.getModifiers());
                String name = null;
                if (isVisible && null != typeAnalyzer) {
                    name = typeAnalyzer.getVilName(field);
                    isVisible &= typeAnalyzer.isVisible(fields[f]);
                }
                if (isVisible) {
                    fd.add(new RtReflectionFieldDescriptor(this, fields[f], name, 
                        typeAnalyzer.getFieldGenerics(fields[f])));
                }
            }
            setFields(fd);
        }
        
        @Override
        protected void processInner(Class<?> cls) throws VilException {
            Class<?>[] decls = cls.getDeclaredClasses();
            for (int i = 0; i < decls.length; i++) {
                Class<?> inner = decls[i];
                int modifier = inner.getModifiers();
                if (Modifier.isPublic(modifier) && Modifier.isStatic(modifier)) {
                    registerRtType(inner);
                }
            }
        }
        
        /**
         * Defines the operations for this type.
         *  
         * @param operations the operations (may be <b>null</b>)
         */
        protected void setOperations(java.util.Collection<OperationDescriptor> operations) {
            List<OperationDescriptor> ops = new ArrayList<OperationDescriptor>();
            ops.addAll(operations);
            Constructor<?>[] cons = getTypeClass().getConstructors();
            for (int c = 0; c < cons.length; c++) {
                Constructor<?> constructor = cons[c];
                if (Modifier.isPublic(constructor.getModifiers()) 
                    && (null == typeAnalyzer || typeAnalyzer.isVisible(constructor))) {
                    ops.add(new RtReflectionConstructorDescriptor(this, constructor));
                    canBeInstantiated = true;
                }
            }
            super.setOperations(ops);
        }

        @Override
        protected boolean enableMethod(Method method) {
            boolean result;
            if (null != typeAnalyzer) {
                result = typeAnalyzer.isVisible(method);
            } else {
                result = super.enableMethod(method);
            }
            return result;
        }

        @Override
        protected ReflectionOperationDescriptor createDescriptor(Method method, String name, boolean constructor) {
            boolean disableExecution = false;
            String actName = null;
            if (null != typeAnalyzer) {
                disableExecution = typeAnalyzer.isDisabledDuringSimulation(method);
                if (null != name) {
                    actName = name;
                } else {
                    actName = typeAnalyzer.getVilName(method);
                }
            } 
            return new RtReflectionOperationDescriptor(this, method, actName, considerAsConstructor(method), 
                disableExecution);
        }
        
        @Override
        protected boolean considerAsConstructor(Method method) {
            return false; // this is VIL specific
        }
        
        @Override
        public TypeRegistry getTypeRegistry() {
            return RtVilTypeRegistry.INSTANCE;
        }
        
        @Override
        public boolean canBeInstantiated() {
            return canBeInstantiated;
        }

    }
    
    /**
     * Changes the type analyzer.
     * 
     * @param analyzer the new type analyzer (<b>null</b> means ignore)
     */
    public static void setTypeAnalyzer(ITypeAnalyzer analyzer) {
        typeAnalyzer = analyzer;
    }

    /**
     * Returns the type analyzer.
     * 
     * @return the type analyzer (<b>null</b> means ignore)
     */
    public static ITypeAnalyzer getTypeAnalyzer() {
        return typeAnalyzer;
    }
    
    @Override
    public IClassNameMapper getClassNameMapper() {
        return typeAnalyzer;
    }

    @Override
    public boolean forRuntime() {
        return true;
    }

    /**
     * Imports a class as a type.
     * 
     * @param <T> the actual type
     * @param type the class to import
     * @return the registered type descriptor
     * @throws VilException in case of import problems
     */
    public static <T> TypeDescriptor<T> registerRtType(Class<T> type) throws VilException {
        ITypeAnalyzer analyzer = getTypeAnalyzer();
        String fqName = null == analyzer ? type.getName() : analyzer.getVilName(type);
        if (null == fqName) {
            fqName = type.getName().replace("$", "");
        }
        
        String simpleName = strip(fqName, ITypeAnalyzer.SEPARATOR);
        if (0 == simpleName.length()) {
            throw new VilException("illegal simple name", VilException.ID_ALREADY_REGISTERED);
        }

        TypeDescriptor<?> sd = INSTANCE.getType(simpleName);
        check(sd, type, simpleName, false);
        if (!fqName.equals(simpleName)) {
            TypeDescriptor<?> fd = INSTANCE.getType(fqName);
            check(fd, type, fqName, true);
        }
        
        RtTypeDescriptor<T> desc = new RtTypeDescriptor<T>(type, fqName);
        if (null == sd) {
            INSTANCE.register(simpleName, desc);
        }
        if (!fqName.equals(simpleName)) {
            INSTANCE.register(fqName, desc);
        }
        desc.resolve();
        IRegisteredStringValueProvider valueProvider = null == analyzer ? null : analyzer.getStringValueProvider(type);
        if (null != valueProvider) {
            StringValueHelper.registerStringValueProvider(type, valueProvider);
        }
        return desc;
    }
    
    /**
     * Implements a type resolver that tries to resolve currently unknown types from 
     * a list of classes that shall be resolved in one step. Prevents cycles, but
     * does currently not handle cyclic dependencies (requires fake type to be replaced later).
     * 
     * @author Holger Eichelberger
     */
    private static class ReflectionTypeResolver implements ITypeResolver {

        private IDirectTypeRegistryAccess access;
        private List<Class<?>> classes;
        private Set<Class<?>> inProcess = new HashSet<Class<?>>();
        
        /**
         * Creates a type resolver with the classes to be resolved in one step.
         * 
         * @param classes the classes to be resolved, can be modified as a side effect
         *   as resolved classes are set to <b>null</b>
         */
        private ReflectionTypeResolver(List<Class<?>> classes) {
            this.classes = classes;
        }
        
        @Override
        public TypeRegistry getTypeRegistry() {
            return INSTANCE;
        }

        /**
         * Marks a class as being in progress. 
         * 
         * @param cls the class to be marked
         */
        public void inProcess(Class<?> cls) {
            inProcess.add(cls);
        }
        
        /**
         * Marks a class as done.
         * 
         * @param cls the class to be marked
         */
        public void done(Class<?> cls) {
            inProcess.remove(cls);
        }

        @Override
        public TypeDescriptor<?> resolveType(String name, boolean addIfMissing) {
            TypeDescriptor<?> result = access.get(name);
            if (null == result && addIfMissing) {
                Class<?> found = null;
                for (int c = 0; null == found && c < classes.size(); c++) {
                    Class<?> cls = classes.get(c);
                    if (null != cls) {
                        String tName = typeAnalyzer.getVilName(cls);
                        String simpleName = strip(tName, ITypeAnalyzer.SEPARATOR);
                        if ((name.equals(tName) || simpleName.equals(tName)) && !inProcess.contains(cls)) {
                            inProcess(cls);
                            try {
                                result = registerRtType(cls);
                                classes.set(c, null);
                            } catch (VilException e) {
                                EASyLoggerFactory.INSTANCE.getLogger(RtVilTypeRegistry.class, Bundle.ID).exception(e);
                            }
                            done(cls);
                        }
                    }
                }
            }
            if (null == result) {
                ITypeAnalyzer analyzer = RtVilTypeRegistry.getTypeAnalyzer();
                if (null != analyzer) {
                    result = analyzer.resolveTypeFallback(name);
                }
            }
            return result;
        }

        @Override
        public TypeDescriptor<?> resolveType(IDatatype type) {
            return null; // no IVML resolution
        }

        @Override
        public TypeDescriptor<? extends IVilType> resolveInstantiator(String name) {
            return null; // no instantiator resolution
        }

        @Override
        public void setRegistryAccess(IDirectTypeRegistryAccess access) {
            this.access = access;
        }
        
    }

    /**
     * Registers a set of types while considering the dependencies among them.
     * 
     * @param types the types to be resolved
     * @throws VilException in case of resolution problems
     */
    public static void registerRtTypes(List<Class<?>> types) throws VilException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        classes.addAll(types);
        ReflectionTypeResolver resolver = new ReflectionTypeResolver(classes);
        INSTANCE.addTypeResolver(resolver);
        for (int t = 0; t < classes.size(); t++) {
            Class<?> cls = classes.get(t);
            if (null != cls) {
                resolver.inProcess(cls);
                registerRtType(cls);
                resolver.done(cls);
            }
        }
        INSTANCE.removeTypeResolver(resolver);
    }

    /**
     * Checks the given (potentially existing) <code>descriptor</code> for validity against the new information.
     * 
     * @param descriptor the existing descriptor
     * @param type the type to be registered
     * @param key the name key of <code>type</code>
     * @param checkRegistered check whether <code>key</code> is already registered
     * @throws VilException in case of violations
     */
    private static void check(TypeDescriptor<?> descriptor, Class<?> type, String key, boolean checkRegistered) 
        throws VilException {
        if (null != descriptor) {
            String msg = ArtifactFactory.checkReplacement(descriptor.getTypeClass(), type);
            if (null != msg) {
                throw new VilException(msg, VilException.ID_ALREADY_REGISTERED);
            }
            if (checkRegistered && type.equals(descriptor.getTypeClass())) {
                throw new VilException("type '" + key + "' is already registered", 
                     VilException.ID_ALREADY_REGISTERED);
            }
            if (!descriptor.getTypeClass().isAssignableFrom(type)) {
                throw new VilException("type replacement requires subtype relationship", 
                    VilException.ID_TYPE_INCOMPATIBILITY);
            }
        }
    }

    /**
     * Strips the prefix before the last position of <code>separator</code> from <code>name</code>.
     * 
     * @param name the name to strip
     * @param separator the separator
     * @return the stripped name
     */
    public static final String strip(String name, String separator) {
        int pos = name.lastIndexOf(separator);
        if (pos > 0) {
            int cutPos = pos + separator.length();
            if (cutPos < name.length()) {
                name = name.substring(cutPos);
            } else {
                name = "";
            }
        }
        return name;
    }

    /**
     * Maps VIL invoke arguments to externally used Java instances.
     * 
     * @param args the arguments (may be modified as a side effect)
     */
    private static void mapArgumentsToJava(Object[] args) {
        if (null != args) {
            for (int a = 0; a < args.length; a++) {
                args[a] = mapValueToJava(args[a]);
            }
        }
    }
    
    @Override
    protected TypeDescriptor<?> getMappedType(Class<?> cls, TypeDescriptor<?>[] generics) {
        // see mapValueToJava and mapValueToVil
        TypeDescriptor<?> result = null;
        try {
            if (java.util.Map.class.isAssignableFrom(cls)) {
                result = TypeRegistry.getMapType(generics);
            } else if (java.util.List.class.isAssignableFrom(cls)) {
                result = TypeRegistry.getSequenceType(generics);
            } else if (java.util.Set.class.isAssignableFrom(cls)) {
                result = TypeRegistry.getSetType(generics);
            } else if (Double.class.equals(cls) /*|| Float.class.equals(cls)*/) {
                result = TypeRegistry.realType();
            } else if (Integer.class.equals(cls) /*|| Long.class.equals(cls)*/) {
                result = TypeRegistry.integerType();
            } else if (Boolean.class.equals(cls)) {
                result = TypeRegistry.booleanType();
            }

        } catch (VilException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
        }
        return result;
    }

    /**
     * Maps a VIL value to externally used Java instances.
     * 
     * @param value the value to be mapped
     * @return the mapped value
     */
    private static Object mapValueToJava(Object value) {
        if (value instanceof Map) {
            value = ((Map<?, ?>) value).toMap();
        } else if (value instanceof Sequence) {
            value = ((Sequence<?>) value).toMappedList();
        } else if (value instanceof net.ssehub.easy.instantiation.core.model.vilTypes.Set<?>) {
            value = ((net.ssehub.easy.instantiation.core.model.vilTypes.Set<?>) value).toMappedSet();
        }
        return value;
    }

    /**
     * Maps externally used Java instances to VIL instances. 
     * 
     * @param result the value
     * @param type the VIL type (for generics)
     * @return the mapped value instance
     */
    @SuppressWarnings("unchecked")
    private static Object mapValueToVil(Object result, TypeDescriptor<?> type) {
        if (result instanceof java.util.Map<?, ?>) {
            result = new Map<Object, Object>((java.util.Map<Object, Object>) result, type.getGenericParameter());
        } else if (result instanceof java.util.Set<?>) {
            result = new ArraySet<Object>(((java.util.Set<?>) result).toArray(), type.getGenericParameter());
        } else if (result instanceof java.util.List<?>) {
            result = new ArraySequence<Object>(((java.util.List<?>) result).toArray(), type.getGenericParameter());
        }
        return result;
    }

}
