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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * Implements an array wrapper for the VIL set type.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
public class ArraySet<T> extends AbstractArrayWrapper<T> implements Set<T> {

    /**
     * Creates a new array collection wrapper using the default type registry.
     * 
     * @param array the wrapped array
     * @param param the only type parameter characterizing <T>
     */
    public ArraySet(T[] array, Class<?> param) {
        this(array, param, TypeRegistry.DEFAULT);
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param registry the type registry to use
     * @param param the only type parameter characterizing <T>
     */
    public ArraySet(T[] array, Class<?> param, TypeRegistry registry) {
        super(removeDuplicates(array), true, registry.convert(param));
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param params the type parameter characterizing <T>
     */
    public ArraySet(T[] array, TypeDescriptor<?>... params) {
        super(removeDuplicates(array), true, params);
    }

    /**
     * Returns an empty set for one type parameter using the default type registry.
     * 
     * @param param the type parameter characterizing <T>
     * @return an empty set
     * @param <T> the element type
     */
    @Invisible
    public static final <T extends IVilType> Set<T> empty(Class<T> param) {
        return empty(param, TypeRegistry.DEFAULT);
    }
    
    /**
     * Returns an empty set for one type parameter.
     * 
     * @param param the type parameter characterizing <T>
     * @param registry the type registry used for resolution
     * @return an empty set
     * @param <T> the element type
     */
    @Invisible
    public static final <T> Set<T> empty(Class<?> param, TypeRegistry registry) {
        return empty(registry.findType(param));
    }
    
    /**
     * Returns an empty set for one type parameter.
     * 
     * @param param the type parameter characterizing <T>
     * @return an empty set
     * @param <T> the element type
     */
    @Invisible
    public static final <T> Set<T> empty(TypeDescriptor<?> param) {
        TypeDescriptor<?>[] params = TypeDescriptor.createArray(1);
        params[0] = param;
        return new ArraySet<T>(null, params);
    }

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> selectByType(TypeDescriptor<?> type) {
        return new ListSet<T>(selectByType(this, type), getGenericParameter());
    }

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> excluding(Collection<T> set) {
        return new ListSet<T>(excluding(this, set), getGenericParameter());
    }

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> including(Collection<T> set) {
        return new ListSet<T>(including(this, set), getGenericParameter());
    }

    @Override
    public Set<T> select(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.getIteratorVariable().getType();
        return new ListSet<T>(select(this, evaluator), param);
    }

    @Override
    @OperationMeta(name = "equals")
    public boolean isEquals(Collection<?> elements) {
        return sameElements(this, elements);
    }

    @Override
    public Sequence<T> toSequence() {
        return new ArraySequence<T>(getArray(), getGenericParameter());
    }
    
    @Override
    public T projectSingle() {
        return 1 == size() ? getArray()[0] : null;
    }

    @Override
    @OperationMeta(genericArgument = {0 })
    public T add(T element) {
        extendCapacity(1);
        T[] array = getArray();
        array[array.length - 1] = element;
        return element;
    }

}
