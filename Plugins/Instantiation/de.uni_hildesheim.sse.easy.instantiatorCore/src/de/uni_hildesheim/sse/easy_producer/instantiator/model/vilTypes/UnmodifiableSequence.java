package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.Iterator;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * Implements an unmodifiable wrapper for sequences. This is just a runtime type.
 * 
 * @param <T> the element type
 * @author Holger Eichelberger
 */
public class UnmodifiableSequence<T> implements Sequence<T> {

    private Sequence<T> sequence;

    /**
     * Creates a new unmodifiable sequence.
     * 
     * @param sequence the sequence to be wrapped
     */
    public UnmodifiableSequence(Sequence<T> sequence) {
        this.sequence = sequence;
    }
    
    @Override
    public int getDimensionCount() {
        return sequence.getDimensionCount();
    }

    @Override
    public TypeDescriptor<? extends IVilType> getDimensionType(int index) {
        return sequence.getDimensionType(index);
    }

    @Override
    public int size() {
        return sequence.size();
    }

    @Override
    public boolean allowSequenceAdjustment() {
        return sequence.allowSequenceAdjustment();
    }

    @Override
    public boolean isEmpty() {
        return sequence.isEmpty();
    }

    @Override
    public boolean isNotEmpty() {
        return sequence.isNotEmpty();
    }

    @Override
    public boolean includes(T element) {
        return sequence.includes(element);
    }

    @Override
    public boolean excludes(T element) {
        return sequence.excludes(element);
    }

    @Override
    public int count(T element) {
        return sequence.count(element);
    }

    @Override
    public Iterator<T> iterator() {
        return sequence.iterator();
    }

    @Override
    public boolean isEquals(Collection<?> elements) {
        return sequence.isEquals(elements);
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return sequence.getStringValue(comparator);
    }

    @Override
    public T at(int index) {
        return sequence.at(index);
    }

    @Override
    public T get(int index) {
        return sequence.get(index);
    }

    @Override
    public Sequence<T> selectByType(TypeDescriptor<? extends IVilType> type) {
        return sequence.selectByType(type);
    }

    @Override
    public Sequence<T> excluding(Collection<T> sequence) {
        return this.sequence.excluding(sequence);
    }

    @Override
    public Sequence<T> append(Collection<T> set) {
        return sequence.append(set);
    }

    @Override
    public T add(T element) {
        // unmodifiable, do nothing
        return element;
    }

    @Override
    public void remove(T element) {
        // unmodifiable, do nothing
    }

    @Override
    public Sequence<T> select(ExpressionEvaluator evaluator) throws ArtifactException {
        return sequence.select(evaluator);
    }

    @Override
    public Set<T> toSet() {
        Set<T> result = sequence.toSet();
        if (!(result instanceof UnmodifiableSet)) {
            result = new UnmodifiableSet<T>(result);
        }
        return result;
    }

    @Override
    public Sequence<T> sortAlpha() {
        return sequence.sortAlpha();
    }

    @Override
    public T first() {
        return sequence.first();
    }

    @Override
    public T last() {
        return sequence.last();
    }

    @Override
    public int indexOf(T element) {
        return sequence.indexOf(element);
    }

    @Override
    public Map<T, T> mapSequence(Sequence<T> other) {
        return sequence.mapSequence(other);
    }

    @Override
    public boolean equals(Object object) {
        return sequence.equals(object);
    }
    
    @Override
    public int hashCode() {
        return sequence.hashCode();
    }

}
