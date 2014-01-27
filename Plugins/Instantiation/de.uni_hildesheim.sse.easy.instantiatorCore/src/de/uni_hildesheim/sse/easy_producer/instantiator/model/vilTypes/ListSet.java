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

    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param param the only type parameter characterizing <T>
     */
    public ListSet(List<T> list, Class<? extends IVilType> param) {
        super(removeDuplicates(list), TypeRegistry.convert(param));
    }
    
    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param params the type parameter characterizing <T>
     */
    public ListSet(List<T> list, Class<? extends IVilType>... params) {
        super(removeDuplicates(list), TypeRegistry.convert(params));
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
    
    /**
     * Returns an empty set for one type parameter.
     * 
     * @param param the type parameter characterizing <T>
     * @return an empty set
     * @param <T> the element type
     */
    @Invisible
    public static final <T> Set<T> empty(Class<? extends IVilType> param) {
        return empty(TypeRegistry.getType(TypeDescriptor.getRegName(param)));
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

    /**
     * Does type selection of artifacts.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> selectByType(Class<?> type) {
        return new ListSet<T>(selectByType(this, type), getParameter());
    }
    
    /**
     * Exclude the elements in <code>set</code>.
     * @param set the elements to be excluded
     * @return this set without the elements in <code>set</code>
     */
    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Set<T> excluding(Collection<T> set) {
        return new ListSet<T>(excluding(this, set), getParameter());
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

}
