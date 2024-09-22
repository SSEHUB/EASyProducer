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

import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnType.ReturnTypeKind;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;

/**
 * Implements an array wrapper for the VIL sequence type.
 * 
 * @param <T> the element type
 * @author Holger Eichelberger
 */
public class ListSequence<T> extends AbstractListWrapper<T> implements Sequence<T> {

    /**
     * Creates a new array collection wrapper using the default type registry.
     * 
     * @param list the wrapped list
     * @param param the only type parameter characterizing &lt;T&gt;
     */
    public ListSequence(List<T> list, Class<?> param) {
        super(list, TypeRegistry.DEFAULT, false, param);
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param registry the registry to convert <code>param</code>
     * @param param the only type parameter characterizing &lt;T&gt;
     */
    public ListSequence(List<T> list, TypeRegistry registry, Class<?> param) {
        super(list, registry, false, param);
    }

    /**
     * Creates a new array collection wrapper using the default type registry.
     * 
     * @param list the wrapped list
     * @param params the type parameter characterizing &lt;T&gt;
     */
    public ListSequence(List<T> list, TypeDescriptor<?>... params) {
        super(list, false, params);
    }
    
    @Override
    public T at(int index) {
        List<T> list = getList();
        T result;
        int i = OclKeyWords.toJavaIndex(index);
        if (null == list || i < 0 || i >= list.size()) {
            result = null;
        } else {
            result = list.get(index);
        }
        return result;
    }

    @Override
    public T get(int index) {
        return at(OclKeyWords.toJavaIndex(index));
    }
    
    /**
     * Returns an empty sequence for one type parameter.
     * 
     * @param param the type parameter characterizing &lt;T&gt;
     * @return an empty sequence
     * @param <T> the element type
     */
    @Invisible
    public static final <T> Sequence<T> empty(TypeDescriptor<?> param) {
        TypeDescriptor<?>[] params = TypeDescriptor.createArray(1);
        params[0] = param;
        return new ListSequence<T>(null, params);
    }

    @Override
    @ReturnGenerics(IVilType.class)
    public Sequence<T> selectByType(TypeDescriptor<?> type) {
        return new ListSequence<T>(selectByType(this, type, false, false), getGenericParameter());
    }

    @Override
    @ReturnGenerics(IVilType.class)
    public Sequence<T> selectByKind(TypeDescriptor<?> type) {
        return new ListSequence<T>(selectByType(this, type, true, false), getGenericParameter());
    }

    @Override
    @ReturnGenerics(IVilType.class)
    public Sequence<T> typeReject(TypeDescriptor<?> type) {
        return new ListSequence<T>(selectByType(this, type, true, true), getGenericParameter());
    }

    @Override
    @ReturnGenerics(IVilType.class)    
    public Sequence<T> excluding(Collection<T> sequence) {
        return new ListSequence<T>(excluding(this, sequence), getGenericParameter());
    }

    @Override
    @ReturnGenerics(IVilType.class)
    public Sequence<T> append(Collection<T> sequence) {
        return new ListSequence<T>(append(this, sequence), getGenericParameter());
    }

    @Override
    public Sequence<?> flatten() throws VilException {
        List<Object> result = new java.util.ArrayList<Object>();
        flatten(this, result);
        return new ListSequence<Object>(result, getFlattenedParams(this));
    }
    
    @Override
    @ReturnType(kind = ReturnTypeKind.SET)
    @OperationMeta(useGenericParameter = 0)    
    public Sequence<T> select(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.getIteratorVariable().getType();
        return new ListSequence<T>(select(this, evaluator, true), param);
    }

    @Override
    public Sequence<T> reject(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.getIteratorVariable().getType();
        return new ListSequence<T>(select(this, evaluator, false), param);
    }

    @Override
    public Sequence<?> collect(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.inferType();
        return new ListSequence<Object>(collect(this, evaluator, true), param);
    }

    @Override
    public void forEach(ExpressionEvaluator evaluator) throws VilException {
        collect(this, evaluator, true);
    }
    
    @Override
    public Sequence<?> collectNested(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.inferType();
        return new ListSequence<Object>(collect(this, evaluator, false), param);
    }
    
    @Override
    public Set<?> closure(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.inferType();
        return new SetSet<Object>(closure(this, evaluator), param);
    }
    
    @Override
    public Object apply(ExpressionEvaluator evaluator) throws VilException {
        return AbstractCollectionWrapper.apply(this, evaluator);
    }

    @Override
    @OperationMeta(name = "equals")
    public boolean isEquals(Collection<?> elements) {
        return equals(this, elements);
    }

    @Override
    public Set<T> toSet() {
        return new ListSet<T>(getList(), getGenericParameter());
    }
    
    @Override
    public Set<T> asSet() {
        return toSet();
    }
    
    @Override
    public Sequence<T> asSequence() {
        return this;
    }

    @Override
    @ReturnGenerics(IVilType.class)
    public Sequence<T> sortAlpha() {
        Sequence<T> result;
        if (null == getList()) {
            result = this;
        } else {
            result = new ListSequence<T>(sortAlphaImpl(), getGenericParameter());
        }
        return result;
    }
    
    @Override
    @NotOclCompliant("sort")
    @ReturnGenerics(IVilType.class)
    @OperationMeta(name = {"sortedBy", "sort"})
    public Sequence<T> sortedBy(ExpressionEvaluator evaluator) throws VilException {
        Sequence<T> result;
        if (null == getList()) {
            result = this;
        } else {
            result = new ListSequence<T>(sortImpl(evaluator), getGenericParameter());
        }
        return result;
    }
    
    @Override
    @NotOclCompliant("revert")
    @ReturnGenerics(IVilType.class)
    @OperationMeta(name = {"reverse", "revert"})
    public Sequence<T> revert() {
        Sequence<T> result;
        if (null == getList()) {
            result = this;
        } else {
            result = new ListSequence<T>(revertImpl(), getGenericParameter());
        }
        return result;
    }

    @Override
    public T first() {
        List<T> list = getList();
        T result;
        if (0 == list.size()) {
            result = null;
        } else {
            result = list.get(0);
        }
        return result;
    }

    @Override
    public T last() {
        List<T> list = getList();
        T result;
        if (0 == list.size()) {
            result = null;
        } else {
            result = list.get(size() - 1);
        }
        return result;
    }
    
    @Override
    public int indexOf(T element) {
        return OclKeyWords.toIvmlIndex(getList().indexOf(element));
    }

    @Override
    @GenericArguments(0)
    public T add(T element) {
        getList().add(element);
        return element;
    }

    @Override
    public boolean remove(T element) {
        return getList().remove(element);
    }

    @Override
    public Map<T, T> mapSequence(Sequence<T> other) {
        return SequenceOperations.mapSequence(this, other);
    }

    @Override
    public Map<T, T> mapAny(Sequence<T> other) {
        return SequenceOperations.mapAny(this, other);
    }

    @ReturnGenerics(IVilType.class)
    @Override
    public Sequence<T> union(Sequence<T> seq) {
        return new ListSequence<T>(SequenceOperations.union(this, seq), getGenericParameter());
    }

    @ReturnGenerics(IVilType.class)
    @Override
    public Sequence<T> append(T object) {
        return new ListSequence<T>(SequenceOperations.append(this, object), getGenericParameter());
    }

    @ReturnGenerics(IVilType.class)
    @Override
    public Sequence<T> prepend(T object) {
        return new ListSequence<T>(SequenceOperations.prepend(this, object), getGenericParameter());
    }

    @ReturnGenerics(IVilType.class)
    @Override
    public Sequence<T> insertAt(int index, T object) {
        return new ListSequence<T>(SequenceOperations.insertAt(this, index, object), getGenericParameter());
    }

    @ReturnGenerics(IVilType.class)
    @Override
    public Sequence<T> subSequence(int lower, int upper) {
        return new ListSequence<T>(SequenceOperations.subSequence(this, lower, upper), getGenericParameter());
    }

    @Override
    public boolean allowSequenceAdjustment() {
        return false;
    }

    @Override
    public boolean hasDuplicates() {
        return SequenceOperations.hasDuplicates(this);
    }

    @Override
    public boolean overlaps(Sequence<T> other) {
        return SequenceOperations.overlaps(this, other);
    }

    @Override
    public boolean isSubsequenceOf(Sequence<T> other) {
        return SequenceOperations.isSubsequenceOf(this, other);
    }

    @Override
    public String joinfields(String separator, String begin, String end) {
        return SequenceOperations.joinfields(this, separator, begin, end);
    }

    @Override
    public void removeAll(T element) {
        List<T> lst = getList();
        for (int i = lst.size() - 1; i >= 0; i--) {
            T elt = lst.get(i);
            if (element.equals(elt)) {
                lst.remove(i);
            }
        }
    }

    @Override
    public T removeAt(int index) {
        return getList().remove(OclKeyWords.toJavaIndex(index));
    }

    @Override
    public T removeFirst() {
        return size() > 0 ? getList().remove(0) : null;
    }

    @Override
    public T removeLast() {
        int size = size();
        return size > 0 ? getList().remove(size - 1) : null;
    }

    @Override
    @ReturnType(kind = ReturnTypeKind.SEQUENCE)
    @OperationMeta(name = "clone")    
    public Sequence<T> cloneCollection() {
        return new ListSequence<T>(getList(), getGenericParameter());
    }

}
