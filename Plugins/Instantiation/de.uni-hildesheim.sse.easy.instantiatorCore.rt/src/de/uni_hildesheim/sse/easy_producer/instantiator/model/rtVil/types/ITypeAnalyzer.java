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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.types;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.ssehub.easy.instantiation.core.model.vilTypes.IClassNameMapper;
import net.ssehub.easy.instantiation.core.model.vilTypes.IRegisteredStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Allows to change the default VIL behavior of creating type descriptors.
 * 
 * @author Holger Eichelberger
 */
public interface ITypeAnalyzer extends IClassNameMapper {

    /**
     * Returns whether the class itself shall be visible to rt-VIL.
     * 
     * @param cls the class to analyze
     * @return <code>true</code> if visible, <code>false</code> if not
     */
    public boolean isVisible(Class<?> cls);

    /**
     * Returns whether the given method shall be visible to rt-VIL.
     * 
     * @param method the method to analyze
     * @return <code>true</code> if visible, <code>false</code> if not
     */
    public boolean isVisible(Method method);

    /**
     * Returns whether the given method shall be disabled during a simulation.
     * 
     * @param method the method to analyze
     * @return <code>true</code> if the method shall be disabled, <code>false</code> if not
     */
    public boolean isDisabledDuringSimulation(Method method);
    
    /**
     * Returns the VIL name of <code>method</code>.
     * 
     * @param method the method to analyze
     * @return the VIL name of the method or <b>null</b> if the original name shall be used
     */
    public String getVilName(Method method);
    
    /**
     * Returns whether the given field shall be visible to rt-VIL.
     * 
     * @param field the field to analyze
     * @return <code>true</code> if visible, <code>false</code> if not
     */
    public boolean isVisible(Field field);

    /**
     * Returns the VIL name of the <code>field</code>.
     * 
     * @param field the field to analyze
     * @return the VIL name of the field or <b>null</b> if the original name shall be used
     */
    public String getVilName(Field field);

    /**
     * Returns whether the given constructor shall be visible to rt-VIL.
     * Making constructors visible implies that instances of the related class can be created
     * in rt-VIL.
     * 
     * @param constructor the constructor to analyze
     * @return <code>true</code> if visible, <code>false</code> if not
     */
    public boolean isVisible(Constructor<?> constructor);

    /**
     * Returns the string value provider to be used with the specified type.
     * 
     * @param cls the type to return the value provider for
     * @return the value provider or <b>null</b> if none shall be used
     */
    public IRegisteredStringValueProvider getStringValueProvider(Class<?> cls);

    /**
     * Returns the type generics for <code>field</code>.
     * 
     * @param field the field to return the generics for
     * @return the type generics or <b>null</b> if there are none
     */
    public Class<?>[] getFieldGenerics(Field field);

    /**
     * Returns the parameter generics for the specified parameter of <code>method</code>.
     * 
     * @param method the method to return the generics for
     * @param index the parameter index
     * @return the type generics or <b>null</b> if there are none
     */
    public Class<?>[] getParameterGenerics(Method method, int index);

    /**
     * Returns the parameter generics for the specified parameter of <code>constructor</code>.
     * 
     * @param constructor the constructor to return the generics for
     * @param index the parameter index
     * @return the type generics or <b>null</b> if there are none
     */
    public Class<?>[] getParameterGenerics(Constructor<?> constructor, int index);

    /**
     * Returns the return generics for <code>method</code>.
     * 
     * @param method the method to return the generics for
     * @return the type generics or <b>null</b> if there are none
     */
    public Class<?>[] getReturnGenerics(Method method);
    
    /**
     * Called if a type cannot be resolved by the {@link RtVilTypeRegistry}, in particular during
     * reflective analysis. The domain/application specific type analyzer may now react on this, before
     * lower level VIL mechanisms finally determine the actual type, which is for <code>java.lang.Object</code>
     * typically "Any" and for others "Void" (disable unknown types from being called).
     * 
     * @param name the name of the type to be resolved
     * @return the fallback type, may be <b>null</b> if now fallback type is known
     */
    public TypeDescriptor<?> resolveTypeFallback(String name);
    
}
