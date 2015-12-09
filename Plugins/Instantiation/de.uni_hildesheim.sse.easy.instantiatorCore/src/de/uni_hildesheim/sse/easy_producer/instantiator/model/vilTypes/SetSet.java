/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * A VIL set wrapper based on a Java set.
 * 
 * @param <T> the element type
 * @author Holger Eichelberger
 */
public class SetSet<T> extends AbstractCollectionWrapper<T> implements Set<T> {

    private java.util.Set<T> set;
    private TypeDescriptor<?>[] params;
    private TypeDescriptor<?> type;
    
    /**
     * Creates a new array collection wrapper using the default type registry.
     * 
     * @param set the set to be wrapped
     * @param param the only type parameter characterizing <T>
     */
    public SetSet(java.util.Set<T> set, Class<?> param) {
        this(set, param, TypeRegistry.DEFAULT);
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param set the set to be wrapped
     * @param registry the type registry to use
     * @param param the only type parameter characterizing <T>
     */
    public SetSet(java.util.Set<T> set, Class<?> param, TypeRegistry registry) {
        this(set, registry.convert(param));
    }
    
    /**
     * Creates a new set wrapper.
     * 
     * @param set the set to be wrapped
     * @param params the type parameter characterizing <T>
     */
    public SetSet(java.util.Set<T> set, TypeDescriptor<?>... params) {
        this.set = set;
        this.params = params;
        this.type = constructType(this.params, true);
    }
    
    @Override
    public int getGenericParameterCount() {
        return null == params ? 0 : params.length;
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        if (null == params) {
            throw new IndexOutOfBoundsException();
        }
        return params[index];
    }

    @Override
    public int size() {
        return null == set ? 0 : set.size();
    }

    @Override
    public boolean allowSequenceAdjustment() {
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return null == set ? new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                throw new NoSuchElementException("empty");
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
            
        } : set.iterator();
    }

    @Override
    public boolean isEquals(Collection<?> elements) {
        return null == set ? null == elements : set.equals(elements);
    }

    @Override
    public TypeDescriptor<?> getType() {
        return type;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return StringValueHelper.getStringValue(this, comparator);
    }

    @Override
    public Set<T> excluding(Collection<T> set) {
        java.util.Set<T> tmp = new java.util.HashSet<T>();
        if (null != this.set) {
            tmp.addAll(this.set);
        }
        if (null != set) {
            for (T t : set) {
                tmp.remove(t);
            }
        }
        return new SetSet<T>(tmp, params);
    }

    @Override
    public Set<T> including(Collection<T> set) {
        java.util.Set<T> tmp = new java.util.HashSet<T>();
        if (null != this.set) {
            tmp.addAll(this.set);
        }
        if (null != set) {
            for (T t : set) {
                tmp.add(t);
            }
        }
        return new SetSet<T>(tmp, params);
    }

    @Override
    public Set<T> union(Set<T> set) {
        return including(set);
    }

    @Override
    public Set<T> intersection(Set<T> set) {
        return excluding(set);
    }

    @Override
    public T add(T element) {
        T result;
        if (null == set) {
            result = null;
        } else {
            set.add(element);
            result = element;
        }
        return result;
    }

    @Override
    public boolean remove(T element) {
        return null == set ? false : set.remove(element);
    }

    @Override
    public Set<T> selectByType(TypeDescriptor<?> type) {
        java.util.Set<T> tmp = new java.util.HashSet<T>();
        if (null != set) {
            selectByType(this, type, tmp);
        }
        return new SetSet<T>(tmp, params);
    }

    @Override
    public Set<T> select(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.getIteratorVariable().getType();
        java.util.Set<T> tmp = new java.util.HashSet<T>();
        if (null != set) {
            select(this, evaluator, tmp);
        }
        return new SetSet<T>(tmp, param);
    }

    @Override
    public Set<?> collect(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.inferType();
        java.util.Set<Object> tmp = new java.util.HashSet<Object>();
        if (null != set) {
            collect(this, evaluator, tmp);
        }
        return new SetSet<Object>(tmp, param);
    }

    @Override
    public Object apply(ExpressionEvaluator evaluator) throws VilException {
        return AbstractCollectionWrapper.apply(this, evaluator);
    }

    @Override
    public Sequence<T> toSequence() {
        return asSequence();
    }

    @Override
    public Sequence<T> asSequence() {
        List<T> tmp = new ArrayList<T>(set.size());
        tmp.addAll(set);
        return new ListSequence<T>(tmp, params);
    }

    @Override
    public T projectSingle() {
        return 1 == size() ? set.iterator().next() : null;
    }

    @Override
    @Invisible
    public java.util.Set<T> toMappedSet() {
        java.util.Set<T> result;
        if (null == set) {
            result = null;
        } else {
            result = new java.util.HashSet<T>(set.size());
            result.addAll(set);
        }
        return result;
    }

}