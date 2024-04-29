package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Iterator;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;

/**
 * Defines the basic VIL collection type to be used with maps and joins. The iterator
 * is an internal type which is not registered in the {@link TypeRegistry}.
 * Please note that iterator with one type parameter will be represented by the
 * iterator itself, iterators over multiple types by an iterator over an object
 * array of instances which can be cast into the given types.
 * 
 * @param <T> the element type
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(furtherOperations = CollectionOperations.class)
public interface Collection<T> extends Iterable<T>, IVilGenericType, IStringValueProvider {

    /**
     * Returns the number of generic parameters of <code>T</code>.
     * 
     * @return the number of generic parameter
     */
    @Invisible(inherit = true)
    public int getGenericParameterCount();
    
    /**
     * Returns the type of the specified generic parameter of <code>T</code>.
     * 
     * @param index the 0-based index of the generic parameter
     * 
     * @return the actual type of the generic parameter
     */
    @Invisible(inherit = true)
    public TypeDescriptor<?> getGenericParameterType(int index);
    
    /**
     * Returns the number of elements in the underlying collection.
     * 
     * @return the number of elements
     */
    public int size();
    
    /**
     * Returns whether a {@link IStringValueProvider} may reorder the sequence of this collection for
     * (test) output.
     * 
     * @return <code>true</code> if a value provider may reorder the sequence, <code>false</code> else
     */
    @Invisible(inherit = true)
    public boolean allowSequenceAdjustment();

    /**
     * Returns whether the collection is empty.
     * 
     * @return <code>true</code> if it is empty, <code>false</code> else
     */
    public boolean isEmpty();

    /**
     * Returns whether the collection is not empty (inverse of {@link #isEmpty()}.
     * 
     * @return <code>false</code> if it is empty, <code>true</code> else
     */
    @NotOclCompliant("isNotEmpty")
    @OperationMeta(name = {"notEmpty", "isNotEmpty"})
    public boolean isNotEmpty();
    
    /**
     * Returns whether this collection contains a certain element.
     * 
     * @param element the element to look for
     * @return <code>true</code> if this collection contains <code>element</code>, <code>false</code> else
     */
    public boolean includes(T element);

    /**
     * Returns whether this collection does not contain a certain element.
     * 
     * @param element the element to look for
     * @return <code>true</code> if this collection does not contain <code>element</code>, <code>true</code> else
     */
    public boolean excludes(T element);

    /**
     * Returns the number of elements in this collection which are equal to <code>element</code>.
     * 
     * @param element the element to look for
     * @return the number of equal elements in this collection
     */
    public int count(T element);
    
    /**
     * Returns an iterator on the individual elements of this collection.
     * 
     * @return the iterator
     */
    @Invisible
    public Iterator<T> iterator();

    /**
     * Returns whether this collection is equal to <code>elements</code>. Please note that
     * the actual semantics, i.e., whether the elements must also be in the same sequence, depends
     * on the actual semantics of the collection.
     * 
     * @param elements the collection to be tested
     * @return <code>true</code> if both collections are considered to be equal, <code>false</code> else
     */
    @OperationMeta(name = "equals")
    public boolean isEquals(Collection<?> elements);

    /**
     * Clears this collection.
     */
    public void clear();

    /**
     * Selects elements in this collection according to the given expression.
     * 
     * @param evaluator the evaluator (results must evaluate to Boolean)
     * @return the selected elements
     * @throws VilException in case that evaluation fails
     */
    @OperationMeta(useGenericParameter = 0)
    public Collection<T> select(ExpressionEvaluator evaluator) throws VilException;
    
    /**
     * Rejects elements in this collection according to the given expression.
     * 
     * @param evaluator the evaluator (results must evaluate to Boolean)
     * @return the rejected elements
     * @throws VilException in case that evaluation fails
     */
    @OperationMeta(useGenericParameter = 0)
    public Collection<T> reject(ExpressionEvaluator evaluator) throws VilException;
    
    /**
     * Calculates a transitive closure over elements provided by this collection and <code>evaluator</code>.
     * 
     * @param evaluator the evaluator providing the links/collections to follow
     * @return the closure
     * @throws VilException in case that evaluation fails
     */
    @OperationMeta(useParameter = 0, flatten = true)
    public Collection<?> closure(ExpressionEvaluator evaluator) throws VilException;

    /**
     * Returns whether the transitive closure over elements provided by this collection and <code>evaluator</code> 
     * does not contain a cycle.
     * 
     * @param evaluator the evaluator providing the links/collections to follow
     * @return <code>true</code> for cycle, <code>false</code> else
     * @throws VilException in case that evaluation fails
     */
    public boolean isAcyclic(ExpressionEvaluator evaluator) throws VilException;
    
    /**
     * Collects the application of <code>evaluator</code> to each individual element and flattens nested structures.
     * 
     * @param evaluator the evaluator (results must evaluate to Boolean)
     * @return the application results
     * @throws VilException in case that evaluation fails
     */
    @OperationMeta(useParameter = 0, flatten = true)
    public Collection<?> collect(ExpressionEvaluator evaluator) throws VilException;

    /**
     * Collects the application of <code>evaluator</code> to each individual element and keeps nested structures.
     * 
     * @param evaluator the evaluator (results must evaluate to Boolean)
     * @return the application results
     * @throws VilException in case that evaluation fails
     */
    @OperationMeta(useParameter = Integer.MAX_VALUE)
    public Collection<?> collectNested(ExpressionEvaluator evaluator) throws VilException;

    /**
     * Returns any element complying with the <code>evaluator</code>.
     * 
     * @param evaluator the evaluator (results must evaluate to Boolean)
     * @return one element complying with <code>evaluator</code> 
     * @throws VilException in case that application fails
     */
    public T any(ExpressionEvaluator evaluator) throws VilException;

    /**
     * Returns the element complying with the <code>evaluator</code> if there is exactly one.
     * 
     * @param evaluator the evaluator (results must evaluate to Boolean)
     * @return the element complying with <code>evaluator</code> 
     * @throws VilException in case that evaluation fails
     */
    public T one(ExpressionEvaluator evaluator) throws VilException;
    
    /**
     * Returns whether there exists on element in the collection for which the <code>evaluator</code>
     * returns <code>true</code>. 
     * 
     * @param evaluator the evaluator
     * @return <code>true</code> for the exists one, <code>false</code> else
     * @throws VilException in case that evaluation fails
     */
    public Boolean exists(ExpressionEvaluator evaluator) throws VilException;

    /**
     * Returns whether all elements in the collection for which the <code>evaluator</code>
     * returns <code>true</code>. 
     * 
     * @param evaluator the evaluator
     * @return <code>true</code> for the exists one, <code>false</code> else
     * @throws VilException in case that evaluation fails
     */
    public Boolean forAll(ExpressionEvaluator evaluator) throws VilException;

    /**
     * Returns whether the evaluator returns a different result for all elements in the collection. 
     * 
     * @param evaluator the evaluator
     * @return <code>true</code> if all results are different, <code>false</code> else
     * @throws VilException in case that evaluation fails
     */
    public Boolean isUnique(ExpressionEvaluator evaluator) throws VilException;
    
    /**
     * Does type selection of elements (only the same type).
     * 
     * @param type the target type
     * @return the selected elements (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @ReturnGenerics(IVilType.class)
    public Collection<T> selectByType(TypeDescriptor<?> type);

    /**
     * Does type selection of elements (including subtypes).
     * 
     * @param type the target type
     * @return the selected elements (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @ReturnGenerics(IVilType.class)
    @OperationMeta(name = {"selectByKind", "typeSelect"})
    public Collection<T> selectByKind(TypeDescriptor<?> type);

    /**
     * Does type selection of elements not having the same type (including subtypes).
     * 
     * @param type the target type
     * @return the selected elements (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @ReturnGenerics(IVilType.class)
    public Collection<T> typeReject(TypeDescriptor<?> type);

    /**
     * Returns the sum of all elements.
     * 
     * @return the sum of all elements or <b>null</b> if the elements do not define addition
     */
    public T sum();

    /**
     * Returns the average of all elements.
     * 
     * @return the average of all elements or <b>null</b> if the elements do not define addition or division
     */
    @OperationMeta(useAny = true)
    public Object avg();

    /**
     * Returns the product of all elements.
     * 
     * @return the product of all elements or <b>null</b> if the elements do not define multiplication
     */
    public T product();

    /**
     * Returns the minimum of all elements.
     * 
     * @return the minimum of all elements or <b>null</b> if the elements do not define the minimum operation
     */
    public T min();

    /**
     * Returns the maximum of all elements.
     * 
     * @return the maximum of all elements or <b>null</b> if the elements do not define the maximum operation
     */
    public T max();
    
    /**
     * Returns whether this collection contains all elements in <code>elements</code>.
     * 
     * @param elements the elements to look for
     * @return <code>true</code> if this collection contains all <code>elements</code>, <code>false</code> else
     */
    public boolean includesAll(Collection<?> elements);
    
    /**
     * Returns whether this collection contains no elements from <code>elements</code>.
     * 
     * @param elements the elements to look for
     * @return <code>true</code> if this collection contains none from <code>elements</code>, <code>false</code> else
     */
    public boolean excludesAll(Collection<?> elements);

    /**
     * Turns this collection into a sequence.
     * 
     * @return the set containing the elements of this collection
     */
    @NotOclCompliant("asSequence")
    @OperationMeta(name = {"asSequence", "toSequence"})
    public Sequence<T> asSequence();

    /**
     * Turns this collection into a set.
     * 
     * @return the set containing the elements of this collection (excluding duplicates)
     */
    @NotOclCompliant("asSet")
    @OperationMeta(name = {"asSet", "toSet"})
    public Set<T> asSet();
    
    /**
     * Flattens this collection if needed, i.e., flatten sub-collections.
     * 
     * @return the flattened collection
     * @throws VilException in case of type incompatibilities
     */
    @OperationMeta(useGenericParameter = 0, flatten = true)
    public Collection<?> flatten() throws VilException;

    /**
     * Sorts the elements in this collection according to the given expression in ascending order.
     * 
     * @param evaluator the evaluator
     * @return the selected elements
     * @throws VilException in case that selection fails
     */
    @NotOclCompliant("sort")
    @ReturnGenerics(IVilType.class)
    @OperationMeta(name = {"sortedBy", "sort"})
    public Collection<T> sortedBy(ExpressionEvaluator evaluator) throws VilException;

    /**
     * Processes elements in this set by applying to given expression.
     * 
     * @param evaluator the evaluator holding the iterator / expression to apply
     * @return the aggregated value, <b>null</b> in case of no aggregation
     * @throws VilException in case that selection fails
     */
    @NotOclCompliant("apply")
    @OperationMeta(name = {"apply", "iterate"}, allowsAggregation = true)
    public Object apply(ExpressionEvaluator evaluator) throws VilException;
    
    /**
     * Clones this collection. (QVT)
     * 
     * @return a clone of this collection
     */
    @OperationMeta(name = "clone")
    public Collection<T> cloneCollection();

}
