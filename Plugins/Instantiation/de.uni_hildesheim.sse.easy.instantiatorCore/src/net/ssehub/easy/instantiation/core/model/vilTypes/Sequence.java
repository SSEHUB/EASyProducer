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
    
    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> selectByType(TypeDescriptor<?> type);

    @Override
    @OperationMeta(name = {"selectByKind", "typeSelect"}, returnGenerics = IVilType.class)
    public Sequence<T> selectByKind(TypeDescriptor<?> type);

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> typeReject(TypeDescriptor<?> type);

    /**
     * Exclude the elements in <code>sequence</code>.
     * @param sequence the elements to be excluded
     * @return this set without the elements in <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> excluding(Collection<T> sequence);

    /**
     * Append the elements in <code>set</code>.
     * @param set the elements to be appended
     * @return this set including the elements in <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> append(Collection<T> set);

    /**
     * Append the elements in <code>seq</code>.
     * @param seq the elements to be appended
     * @return this set including the elements in <code>seq</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> union(Sequence<T> seq);

    /**
     * Adds an element to the end of this sequence.
     * 
     * @param element the element to be added
     * @return <code>element</code>
     */
    @OperationMeta(genericArgument = {0 })
    public T add(T element);
    
    /**
     * Removes the first occurrence of the given element from this sequence.
     * 
     * @param element the element to be removed
     * @return <code>true</code> of the element was removed, <code>false</code> else
     */
    public boolean remove(T element);
    
    @Override
    public Sequence<T> select(ExpressionEvaluator evaluator) throws VilException;

    @Override
    public Sequence<T> reject(ExpressionEvaluator evaluator) throws VilException;

    @Override
    @OperationMeta(useParameter = 0, flatten = true)
    public Set<?> closure(ExpressionEvaluator evaluator) throws VilException; // always set
    
    @Override
    @OperationMeta(useParameter = 0, flatten = true)
    public Sequence<?> collect(ExpressionEvaluator evaluator) throws VilException;
    
    @Override
    @OperationMeta(useParameter = Integer.MAX_VALUE)
    public Sequence<?> collectNested(ExpressionEvaluator evaluator) throws VilException;
    
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
     * Sorts the elements in this sequence according to the given expression in ascending order.
     * 
     * @param evaluator the evaluator
     * @return the selected elements
     * @throws VilException in case that selection fails
     */
    @OperationMeta(name = {"sortedBy", "sort"}, notOclCompliant = "sort", returnGenerics = IVilType.class)
    public Sequence<T> sortedBy(ExpressionEvaluator evaluator) throws VilException;

    /**
     * Reverts this sequence.
     * 
     * @return the reverted sequence
     */
    @OperationMeta(name = {"reverse", "revert"}, notOclCompliant = "revert", returnGenerics = IVilType.class)
    public Sequence<T> revert();
    
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
    
    /**
     * Maps the elements of this sequence to the elements of <code>other</code>
     * and returns the mapping pairs (based on the equals operation) in the given sequence. Please note that
     * both sequences must have exactly one type parameter. 
     * 
     * @param other the second sequence to map against
     * @return the mapping (key is taken from this sequence, value from <code>other</code>)
     */
    @OperationMeta(returnGenerics = {IVilType.class, IVilType.class })
    public Map<T, T> mapSequence(Sequence<T> other);

    /**
     * Maps the elements of this sequence to the elements of <code>other</code>
     * and returns the mapping pairs (based on the equals operation) regardless of the sequence. Please note that
     * both sequences must have exactly one type parameter. 
     * 
     * @param other the second sequence to map against
     * @return the mapping (key is taken from this sequence, value from <code>other</code>)
     */
    @OperationMeta(returnGenerics = {IVilType.class, IVilType.class })
    public Map<T, T> mapAny(Sequence<T> other);
    
    /**
     * Converts back to a list for utilizing this with external classes.
     * 
     * @return the internal map
     */
    @Invisible
    public java.util.List<T> toMappedList();

    @OperationMeta(useGenericParameter = 0, flatten = true)
    @Override
    public Sequence<?> flatten() throws VilException;

    /**
     * Returns the combined sequence of <code>seq</code> and <code>object</code>appended.
     * 
     * @param object the object to append
     * @return the combined sequence
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> append(T object);
    
    /**
     * Returns the combined sequence of <code>object</code> prepended before this sequence.
     * 
     * @param object the object to prepend
     * @return the combined sequence
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> prepend(T object);

    /**
     * Returns the sequence having <code>object</code> inserted at position <code>index</code>.
     * 
     * @param index the index to insert at
     * @param object the object to insert
     * @return the combined sequence
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> insertAt(int index, T object);
    
    /**
     * Returns the sub-sequence of this sequence.
     * 
     * @param lower the lower index where the sub-sequence shall start
     * @param upper the end index where the sub-sequence shall end
     * @return the sub-sequence
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> subSequence(int lower, int upper); 

    /**
     * Returns whether at least one of the elements in operand has a duplicate.
     * 
     * @return <code>true</code> for duplicates, <code>false</code> else
     */
    public boolean hasDuplicates();
    
    /**
     * Returns the sequence in that this sequence and <code>other</code> have in common.
     * 
     * @param other the other sequence
     * @return <code>true</code> for overlaps, <code>false</code> else
     */
    public boolean overlaps(Sequence<T> other);
    
    /**
     * Returns whether operand is a subsequence (considering the sequence and including equality) 
     * of <code>other</code>.
     * 
     * @param other the other sequence
     * @return <code>true</code> for subsequence, <code>false</code> else
     */
    public boolean isSubsequenceOf(Sequence<T> other);

    /**
     * Returns a concatenation of the string representation of elements, with <code>begin</code> as 
     * lead in, <code>sep</code> as separator between the elements and <code>end</code> as lead out. (QVT)
     * 
     * @param separator the separator
     * @param begin the lead in
     * @param end the lead out
     * @return the concatenated result
     */
    public String joinfields(String separator, String begin, String end);

    /**
     * Removes all elements equal to <code>element</code>. (QVT)
     * 
     * @param element the element to remove all copies for
     */
    public void removeAll(T element);

    /**
     * Removes the element at <code>index</code>. (QVT)
     * 
     * @param index the index of the element to remove
     * @return the removed index, undefined if index is not valid
     */
    public T removeAt(int index);

    /**
     * Removes the first element. (QVT)
     * 
     * @return the removed element, undefined if there is no first element
     */
    public T removeFirst();

    /**
     * Removes the last element. (QVT)
     * 
     * @return the removed element, undefined if there is no last element
     */
    public T removeLast();

}
