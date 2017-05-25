package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Iterator;

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
    @OperationMeta(name = {"notEmpty", "isNotEmpty"}, notOclCompliant = "isNotEmpty")
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
     * Does type selection of elements (only the same type).
     * 
     * @param type the target type
     * @return the selected elements (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Collection<T> selectByType(TypeDescriptor<?> type);

    /**
     * Does type selection of elements (including subtypes).
     * 
     * @param type the target type
     * @return the selected elements (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @OperationMeta(name = {"selectByKind", "typeSelect"}, returnGenerics = IVilType.class)
    public Collection<T> selectByKind(TypeDescriptor<?> type);

    /**
     * Does type selection of elements not having the same type (including subtypes).
     * 
     * @param type the target type
     * @return the selected elements (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @OperationMeta(returnGenerics = IVilType.class)
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

}
