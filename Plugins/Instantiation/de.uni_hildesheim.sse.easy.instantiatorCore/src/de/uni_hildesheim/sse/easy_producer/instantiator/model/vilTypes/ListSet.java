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

import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * Implements an list wrapper for the VIL set type.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
public class ListSet<T> extends AbstractListWrapper<T> implements Set<T> {

    // TODO turn this into a set wrapper!!
    
    /**
     * Creates a new array collection wrapper using the default type registry.
     * 
     * @param list the wrapped list
     * @param registry the registry to convert <code>param</code>
     * @param param the only type parameter characterizing <T>
     */
    public ListSet(List<T> list, TypeRegistry registry, Class<? extends IVilType> param) {
        super(removeDuplicates(list), registry, param);
    }
    
    /**
     * Creates a new array collection wrapper using the default type registry.
     * 
     * @param list the wrapped list
     * @param param the only type parameter characterizing <T>
     */
    public ListSet(List<T> list, Class<? extends IVilType> param) {
        super(removeDuplicates(list), TypeRegistry.DEFAULT.convert(param));
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param params the type parameter characterizing <T>
     */
    public ListSet(List<T> list, TypeDescriptor<? extends IVilType>... params) {
        super(removeDuplicates(list), params);
    }

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> selectByType(TypeDescriptor<? extends IVilType> type) {
        return new ListSet<T>(selectByType(this, type), getParameter());
    }
    
    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> excluding(Collection<T> set) {
        return new ListSet<T>(excluding(this, set), getParameter());
    }
    
    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> including(Collection<T> set) {
        return new ListSet<T>(including(this, set), getParameter());
    }

    @Override
    public Set<T> select(ExpressionEvaluator evaluator) throws ArtifactException {
        TypeDescriptor<? extends IVilType>[] param = TypeDescriptor.createArray(1);
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
        return new ListSequence<T>(getList(), getParams());
    }
    
    @Override
    public T projectSingle() {
        return 1 == size() ? getList().get(0) : null;
    }

    /**
     * Returns an empty set for one type parameter.
     * 
     * @param param the type parameter characterizing <T>
     * @return an empty set
     * @param <T> the element type
     */
    @Invisible
    public static final <T> Set<T> empty(TypeDescriptor<? extends IVilType> param) {
        TypeDescriptor<? extends IVilType>[] params = TypeDescriptor.createArray(1);
        params[0] = param;
        return new ListSet<T>(null, params);
    }

    @Override
    public T add(T element) {
        if (!getList().contains(element)) {
            getList().add(element);
        }
        return element;
    }

    @Override
    public void remove(T element) {
        getList().remove(element);
    }

}
