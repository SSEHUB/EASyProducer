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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;

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
     * @param array the array to be wrapped
     * @param param the only type parameter characterizing <T>
     */
    public ArraySet(T[] array, Class<?> param) {
        this(array, param, TypeRegistry.DEFAULT);
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the array to be wrapped
     * @param registry the type registry to use
     * @param param the only type parameter characterizing <T>
     */
    public ArraySet(T[] array, Class<?> param, TypeRegistry registry) {
        super(removeDuplicates(array), true, registry.convert(param));
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the array to be wrapped
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
        return new ListSet<T>(selectByType(this, type, false, false), getGenericParameter());
    }

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> selectByKind(TypeDescriptor<?> type) {
        return new ListSet<T>(selectByType(this, type, true, false), getGenericParameter());
    }

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> typeReject(TypeDescriptor<?> type) {
        return new ListSet<T>(selectByType(this, type, true, true), getGenericParameter());
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
    public Set<?> flatten() throws VilException {
        java.util.List<Object> result = new java.util.ArrayList<Object>();
        flatten(this, result);
        return new ListSet<Object>(result, getFlattenedParams(this));
    }

    @Override
    public Set<T> select(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.getIteratorVariable().getType();
        return new ListSet<T>(select(this, evaluator, true), param);
    }

    @Override
    public Set<T> reject(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.getIteratorVariable().getType();
        return new ListSet<T>(select(this, evaluator, false), param);
    }

    @OperationMeta(useParameter = 0)
    @Override
    public Set<?> collect(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.inferType();
        return new ListSet<Object>(collect(this, evaluator), param);
    }

    @Override
    public Object apply(ExpressionEvaluator evaluator) throws VilException {
        return AbstractCollectionWrapper.apply(this, evaluator);
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
    public Sequence<T> asSequence() {
        return toSequence();
    }
    
    @Override
    public Set<T> asSet() {
        return this;
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

    /**
     * Compute the union of this set and <code>set</code> (without duplicates).
     * 
     * @param set the elements to be unified with this set
     * @return the union of this set and <code>set</code>
     */
    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> union(Set<T> set) {
        return new ListSet<T>(union(this, set), getGenericParameter());
    }

    /**
     * Returns the intersection of this set with <code>set</code>.
     * 
     * @param set the elements to be unified with this set
     * @return the union of this set and <code>set</code>
     */
    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> intersection(Set<T> set) {
        return new ListSet<T>(intersection(this, set), getGenericParameter());
    }

    @Override
    @OperationMeta(name = {"sortedBy", "sort"}, notOclCompliant = "sort", returnGenerics = IVilType.class)
    public Collection<T> sortedBy(ExpressionEvaluator evaluator) throws VilException {
        Collection<T> result;
        if (null == getArray()) {
            result = this;
        } else {
            result = new ListSequence<T>(sortImpl(evaluator), getGenericParameter());
        }
        return result;
    }
    
    @Override
    public Set<T> difference(Set<T> set) {
        return new SetSet<T>(SetOperations.difference(this, set), getGenericParameter());
    }

    @Override
    public Set<T> symmetricDifference(Set<T> set) {
        return new SetSet<T>(SetOperations.symmetricDifference(this, set), getGenericParameter());
    }
    
}
