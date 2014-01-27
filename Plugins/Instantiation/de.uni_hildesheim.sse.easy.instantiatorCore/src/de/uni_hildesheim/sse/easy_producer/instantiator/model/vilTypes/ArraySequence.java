package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * Implements an array wrapper for the VIL sequence type.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
public class ArraySequence<T> extends AbstractArrayWrapper<T> implements Sequence<T> {

    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param param the only type parameter characterizing <T>
     */
    public ArraySequence(T[] array, Class<? extends IVilType> param) {
        super(array, TypeRegistry.convert(param));
    }
    
    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param params the type parameter characterizing <T>
     */
    public ArraySequence(T[] array, Class<? extends IVilType>... params) {
        super(array, TypeRegistry.convert(params));
    }

    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param params the type parameter characterizing <T>
     */
    public ArraySequence(T[] array, TypeDescriptor<? extends IVilType>... params) {
        super(array, params);
    }
    
    @Override
    public T at(int index) {
        T[] array = getArray();
        T result;
        if (null == array || index < 0 || index >= array.length) {
            result = null;
        } else {
            result = array[index];
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
    public static final <T> Sequence<T> empty(Class<? extends IVilType> param) {
        return empty(TypeRegistry.getType(TypeDescriptor.getRegName(param)));
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
        return new ArraySequence<T>(null, params);
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
        return new ArraySet<T>(getArray(), getParams());
    }

    @Override
    @OperationMeta(returnGenerics = IVilType.class)
    public Sequence<T> sortAlpha() {
        Sequence<T> result;
        if (null == getArray()) {
            result = this;
        } else {
            result = new ListSequence<T>(sortAlphaImpl(), getParams());
        }
        return result;
    }

    @Override
    public T first() {
        return getArray()[0];
    }

    @Override
    public T last() {
        return getArray()[size() - 1];
    }

}
