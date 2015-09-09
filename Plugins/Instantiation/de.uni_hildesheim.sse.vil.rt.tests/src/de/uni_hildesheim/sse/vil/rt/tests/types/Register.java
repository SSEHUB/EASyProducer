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
package de.uni_hildesheim.sse.vil.rt.tests.types;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.types.ITypeAnalyzer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.types.RtVilTypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IRegisteredStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider.StringComparator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ReflectionResolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Registers additional types.
 * 
 * @author Holger Eichelberger
 */
public class Register {
    
    private static boolean done = false;

    /**
     * Implements a simple type analyzer.
     * 
     * @author Holger Eichelberger
     */
    private static class TypeAnalyzer implements ITypeAnalyzer {

        @Override
        public String getVilName(Class<?> cls) {
            String name = cls.getSimpleName();
            if (null != cls.getDeclaringClass()) {
                name = cls.getDeclaringClass().getSimpleName() + name;
            }
            return "eu::" + name;
        }

        @Override
        public boolean isVisible(Class<?> cls) {
            return true;
        }

        @Override
        public boolean isVisible(Method method) {
            return true;
        }

        @Override
        public boolean isVisible(Field field) {
            return true;
        }

        @Override
        public boolean isVisible(Constructor<?> constructor) {
            return true;
        }

        @Override
        public IRegisteredStringValueProvider getStringValueProvider(final Class<?> cls) {
            return new IRegisteredStringValueProvider() {

                @Override
                public String getStringValue(Object object, StringComparator comparator) {
                    String result;
                    if (null != object && object.getClass().isEnum()) {
                        result = ((Enum<?>) object).name();
                    } else {
                        result = "<" + cls.getSimpleName() + ">";
                    }
                    return result;
                }
                
            };
        }

        @Override
        public boolean isDisabledDuringSimulation(Method method) {
            return false;
        }

        @Override
        public String getVilName(Method method) {
            return null; // use method.getName()
        }

        @Override
        public String getVilName(Field field) {
            return null; // use field.getName()
        }

        @Override
        public Class<?>[] getFieldGenerics(Field field) {
            return null; // legacy
        }

        @Override
        public Class<?>[] getReturnGenerics(Method method) {
            OperationMeta annotation = method.getAnnotation(OperationMeta.class);
            return null == annotation ? null : annotation.returnGenerics();
        }

        @Override
        public Class<?>[] getParameterGenerics(Method method, int index) {
            Generics annotation = TypeHelper.getParameterAnnotation(method.getParameterAnnotations(), 
                index, Generics.class);
            return null == annotation ? null : annotation.types();
        }

        @Override
        public Class<?>[] getParameterGenerics(Constructor<?> constructor, int index) {
            Generics annotation = TypeHelper.getParameterAnnotation(constructor.getParameterAnnotations(), 
                index, Generics.class);
            return null == annotation ? null : annotation.types();
        }

        @Override
        public TypeDescriptor<?> resolveTypeFallback(String name) {
            return null; // so far not needed for the tests
        }
        
    }
    
    /**
     * Registers additional types.
     */
    public static void register() {
        if (!done) {
            done = true;
            ITypeAnalyzer old = RtVilTypeRegistry.getTypeAnalyzer();
            RtVilTypeRegistry.setTypeAnalyzer(new TypeAnalyzer());
            TypeRegistry regSave = ReflectionResolver.setTypeRegistry(RtVilTypeRegistry.INSTANCE);
            List<Class<?>> types = new ArrayList<Class<?>>();
            types.add(IAdaptationEvent.class);
            types.add(LifecycleEvent.class); // inner events are registered automatically
            types.add(RegularAdaptationEvent.class);
            types.add(Command.class);
            types.add(CommandSequence.class);
            types.add(AlgorithmChangeCommand.class);
            types.add(StartupAdaptationEvent.class);
            types.add(IObservable.class);
            types.add(TimeBehavior.class);
            types.add(ResourceUsage.class);
            types.add(FrozenSystemState.class);
            try {
                RtVilTypeRegistry.registerRtTypes(types);
            } catch (VilException e) {
                e.printStackTrace();
            }
            RtVilTypeRegistry.setTypeAnalyzer(old);
            ReflectionResolver.setTypeRegistry(regSave);
        }
    }

}
