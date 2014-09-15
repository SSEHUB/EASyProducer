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

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * Defines the interface representing a sequence. The iterator
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
public interface Sequence<T> extends Collection<T> {

    /**
     * Returns a specific element from the collection.
     * 
     * @param index the index of the element to be returned
     * @return the element or <b>null</b> in case of non-existing data or if 
     * <code>index &lt; 0 || index &gt;= {@link #size()}</code>
     */
    @OperationMeta(name = Constants.ARRAY_ACCESS)
    public T at(int index);

    /**
     * Returns a specific element from the collection.
     * 
     * @param index the index of the element to be returned
     * @return the element or <b>null</b> in case of non-existing data or if 
     * <code>index &lt; 0 || index &gt;= {@link #size()}</code>
     */
    public T get(int index);
    
    /**
     * Does type selection of artifacts.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> selectByType(TypeDescriptor<? extends IVilType> type);

    /**
     * Exclude the elements in <code>sequence</code>.
     * @param sequence the elements to be excluded
     * @return this set without the elements in <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> excluding(Collection<T> sequence);

    /**
     * Append the elements in <code>set</code>.
     * @param set the elements to be excluded
     * @return this set without the elements in <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> append(Collection<T> set);
    
    /**
     * Selects elements in this set according to the given expression.
     * 
     * @param evaluator the evaluator (results must evaluate to Boolean results)
     * @return the selected elements
     * @throws ArtifactException in case that selection fails
     */
    public Sequence<T> select(ExpressionEvaluator evaluator) throws ArtifactException;

    /**
     * Turns this sequence into a set.
     * 
     * @return the set containing the elements of this sequence (excluding duplicates)
     */
    public Set<T> toSet();
    
    /**
     * Returns an alphabetically sorted sequence. Elements are considered using their
     * (internal) string representations and sorted.
     * 
     * @return the sorted sequence
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> sortAlpha();
    
    /**
     * Returns the first element.
     * 
     * @return the first element
     */
    public T first();
    
    /**
     * Returns the last element.
     * 
     * @return the last element
     */
    public T last();
    
    /**
     * Returns the index of <code>element</code> in this sequence.
     * 
     * @param element the element to return the index for
     * @return the 0-based index of <code>element</code> in this sequence, <code>-1</code> if not found
     */
    public int indexOf(T element);
    
}
