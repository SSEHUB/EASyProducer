package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.Iterator;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * Implements an unmodifiable set wrapper. This is just a runtime type.
 * 
 * @param <T> the parameter type
 * @author Holger Eichelberger
 */
public class UnmodifiableSet<T> implements Set<T> {

    private Set<T> set;
    
    /**
     * Creates an unmodifiable set wrapper.
     * 
     * @param set the set to be wrapped
     */
    public UnmodifiableSet(Set<T> set) {
        this.set = set;
    }
    
    @Override
    public int getDimensionCount() {
        return set.getDimensionCount();
    }

    @Override
    public TypeDescriptor<? extends IVilType> getDimensionType(int index) {
        return set.getDimensionType(index);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean allowSequenceAdjustment() {
        return set.allowSequenceAdjustment();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean isNotEmpty() {
        return set.isNotEmpty();
    }

    @Override
    public boolean includes(T element) {
        return set.includes(element);
    }

    @Override
    public boolean excludes(T element) {
        return set.excludes(element);
    }

    @Override
    public int count(T element) {
        return set.count(element);
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean isEquals(Collection<?> elements) {
        return set.isEquals(elements);
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return set.getStringValue(comparator);
    }

    @Override
    public Set<T> selectByType(TypeDescriptor<? extends IVilType> type) {
        return set.selectByType(type);
    }

    @Override
    public Set<T> excluding(Collection<T> set) {
        return this.set.excluding(set);
    }

    @Override
    public Set<T> including(Collection<T> set) {
        return this.set.including(set);
    }

    @Override
    public T add(T element) {
        return element; // do nothing, unmodifiable
    }

    @Override
    public void remove(T element) {
        // do nothing, unmodifiable
    }

    @Override
    public Set<T> select(ExpressionEvaluator evaluator) throws ArtifactException {
        return set.select(evaluator);
    }

    @Override
    public Sequence<T> toSequence() {
        Sequence<T> result = set.toSequence();
        if (!(result instanceof UnmodifiableSequence)) {
            result = new UnmodifiableSequence<T>(result);
        }
        return result;
    }

    @Override
    public T projectSingle() {
        return set.projectSingle();
    }

    @Override
    public boolean equals(Object object) {
        return set.equals(object);
    }
    
    @Override
    public int hashCode() {
        return set.hashCode();
    }

}
