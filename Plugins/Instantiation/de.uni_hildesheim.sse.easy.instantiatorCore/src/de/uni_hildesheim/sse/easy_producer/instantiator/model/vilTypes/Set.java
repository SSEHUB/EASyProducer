package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

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

    /**
     * Does type selection of artifacts.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> selectByType(Class<?> type);
    
    /**
     * Exclude the elements in <code>set</code>.
     * @param set the elements to be excluded
     * @return this set without the elements in <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> excluding(Collection<T> set);
    
    /**
     * Selects elements in this set according to the given expression.
     * 
     * @param evaluator the evaluator (results must evaluate to Boolean results)
     * @return the selected elements
     * @throws ArtifactException in case that selection fails
     */
    public Set<T> select(ExpressionEvaluator evaluator) throws ArtifactException;

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

}
