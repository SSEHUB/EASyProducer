package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * Implements an array wrapper for the VIL sequence type.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
public class ListSequence<T> extends AbstractListWrapper<T> implements Sequence<T> {

    /**
     * Creates a new array collection wrapper using the default type registry.
     * 
     * @param list the wrapped list
     * @param param the only type parameter characterizing <T>
     */
    public ListSequence(List<T> list, Class<? extends IVilType> param) {
        super(list, TypeRegistry.DEFAULT, param);
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param registry the registry to convert <code>param</code>
     * @param param the only type parameter characterizing <T>
     */
    public ListSequence(List<T> list, TypeRegistry registry, Class<? extends IVilType> param) {
        super(list, registry, param);
    }

    /**
     * Creates a new array collection wrapper using the default type registry.
     * 
     * @param list the wrapped list
     * @param params the type parameter characterizing <T>
     */
    public ListSequence(List<T> list, TypeDescriptor<? extends IVilType>... params) {
        super(list, params);
    }
    
    @Override
    public T at(int index) {
        List<T> list = getList();
        T result;
        if (null == list || index < 0 || index >= list.size()) {
            result = null;
        } else {
            result = list.get(index);
        }
        return result;
    }

    @Override
    public T get(int index) {
        return at(index);
    }
    
    /**
     * Returns an empty sequence for one type parameter.
     * 
     * @param param the type parameter characterizing <T>
     * @return an empty sequence
     * @param <T> the element type
     */
    @Invisible
    public static final <T> Sequence<T> empty(TypeDescriptor<? extends IVilType> param) {
        TypeDescriptor<? extends IVilType>[] params = TypeDescriptor.createArray(1);
        params[0] = param;
        return new ListSequence<T>(null, params);
    }

    /**
     * Does type selection of artifacts.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type for <code>type</code>)
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> selectByType(Class<?> type) {
        return new ListSequence<T>(selectByType(this, type), getParameter());
    }
    
    /**
     * Exclude the elements in <code>sequence</code>.
     * @param sequence the elements to be excluded
     * @return this set without the elements in <code>set</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> excluding(Collection<T> sequence) {
        return new ListSequence<T>(excluding(this, sequence), getParameter());
    }

    @Override
    public Sequence<T> select(ExpressionEvaluator evaluator) throws ArtifactException {
        TypeDescriptor<? extends IVilType>[] param = TypeDescriptor.createArray(1);
        param[0] = evaluator.getIteratorVariable().getType();
        return new ListSequence<T>(select(this, evaluator), param);
    }

    @Override
    @OperationMeta(name = "equals")
    public boolean isEquals(Collection<?> elements) {
        return equals(this, elements);
    }

    @Override
    public Set<T> toSet() {
        return new ListSet<T>(getList(), getParams());
    }

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> sortAlpha() {
        Sequence<T> result;
        if (null == getList()) {
            result = this;
        } else {
            result = new ListSequence<T>(sortAlphaImpl(), getParams());
        }
        return result;
    }

    @Override
    public T first() {
        return getList().get(0);
    }

    @Override
    public T last() {
        return getList().get(size() - 1);
    }

}
