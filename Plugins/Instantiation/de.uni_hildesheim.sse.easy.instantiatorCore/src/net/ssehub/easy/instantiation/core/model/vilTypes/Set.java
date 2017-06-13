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
 * Defines the interface representing a set. The iterator
 * is an internal type which is not registered in the {@link TypeRegistry}.
 * Please note that iterator with one type parameter will be represented by the
 * iterator itself, iterators over multiple types by an iterator over an object
 * array of instances which can be cast into the given types.
 * 
 * This interface and {@link Sequence} shall not be applied together in one class!
 * 
 * @param <T> the element type
 * 
 * @author Holger Eichelberger
 */
public interface Set<T> extends Collection<T> {

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> selectByType(TypeDescriptor<?> type);

    @Override
    @OperationMeta(name = {"selectByKind", "typeSelect"}, returnGenerics = IVilType.class)
    public Set<T> selectByKind(TypeDescriptor<?> type);
    
    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> typeReject(TypeDescriptor<?> type);

    /**
     * Exclude the elements in <code>set</code>.
     * @param set the elements to be excluded
     * @return this set without the elements in <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> excluding(Collection<T> set);

    /**
     * Include the elements in <code>set</code>. Duplicates will not be included.
     * 
     * @param set the elements to be excluded
     * @return this set without the elements in <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> including(Collection<T> set);

    /**
     * Compute the union of this set and <code>set</code> (without duplicates).
     * 
     * @param set the elements to be unified with this set
     * @return the union of this set and <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> union(Set<T> set);

    /**
     * Returns the intersection of this set with <code>set</code>.
     * 
     * @param set the elements to be unified with this set
     * @return the intersection of this set and <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> intersection(Set<T> set);
    
    /**
     * Adds an element to this set.
     * 
     * @param element the element to be added
     * @return <code>element</code>
     */
    @OperationMeta(genericArgument = {0 })
    public T add(T element);
    
    /**
     * Removes the given element from this sequence.
     * 
     * @param element the element to be removed
     * @return <code>true</code> of the element was removed, <code>false</code> else
     */
    public boolean remove(T element);
    
    @Override
    public Set<T> select(ExpressionEvaluator evaluator) throws VilException;

    @Override
    public Set<T> reject(ExpressionEvaluator evaluator) throws VilException;

    @Override
    @OperationMeta(useParameter = 0, flatten = true)
    public Set<?> closure(ExpressionEvaluator evaluator) throws VilException;
    
    @Override
    @OperationMeta(useParameter = 0, flatten = true)
    public Set<?> collect(ExpressionEvaluator evaluator) throws VilException;
    
    @Override
    @OperationMeta(useParameter = Integer.MAX_VALUE)
    public Set<?> collectNested(ExpressionEvaluator evaluator) throws VilException;
    
    /**
     * Turns this set into a sequence.
     * 
     * @return the set containing the elements of this set
     */
    public Sequence<T> toSequence();

    /**
     * In case that the sequence has exactly one element, this will be returned.
     * 
     * @return the only element or <b>null</b>
     */
    public T projectSingle();

    /**
     * Converts back to a set for utilizing this with external classes.
     * 
     * @return the internal map
     */
    @Invisible
    public java.util.Set<T> toMappedSet();

    @OperationMeta(useGenericParameter = 0, flatten = true)
    @Override
    public Set<?> flatten() throws VilException;

    /**
     * Calculates the difference between this and the given set.
     * 
     * @param set the set to calculate the difference for
     * @return the set difference
     */
    @OperationMeta(name = "-", opType = OperationType.INFIX)
    public Set<T> difference(Set<T> set);

    /**
     * Calculates the symmetric difference between this and the given set.
     * 
     * @param set the set to calculate the difference for
     * @return the symmetric set difference
     */
    public Set<T> symmetricDifference(Set<T> set);
    
}
