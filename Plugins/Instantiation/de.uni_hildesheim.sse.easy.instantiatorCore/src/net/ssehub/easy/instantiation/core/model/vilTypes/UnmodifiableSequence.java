package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Iterator;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;

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
    public int getGenericParameterCount() {
        return sequence.getGenericParameterCount();
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        return sequence.getGenericParameterType(index);
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

    @OperationMeta(name = {"notEmpty", "isNotEmpty"}, notOclCompliant = "isNotEmpty")
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
    public Sequence<T> selectByType(TypeDescriptor<?> type) {
        return sequence.selectByType(type);
    }

    @Override
    public Sequence<T> selectByKind(TypeDescriptor<?> type) {
        return sequence.selectByKind(type);
    }

    @Override
    public Sequence<T> typeReject(TypeDescriptor<?> type) {
        return sequence.typeReject(type);
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
    @OperationMeta(genericArgument = {0 })
    public T add(T element) {
        // unmodifiable, do nothing
        return element;
    }

    @Override
    public boolean remove(T element) {
        // unmodifiable, do nothing
        return false;
    }
    
    @Override
    public Sequence<?> flatten() throws VilException {
        return sequence.flatten();
    }

    @Override
    public Sequence<T> select(ExpressionEvaluator evaluator) throws VilException {
        return sequence.select(evaluator);
    }

    @Override
    public Sequence<T> reject(ExpressionEvaluator evaluator) throws VilException {
        return sequence.reject(evaluator);
    }
    
    @OperationMeta(useParameter = 0)
    @Override
    public Sequence<?> collect(ExpressionEvaluator evaluator) throws VilException {
        return sequence.collect(evaluator);
    }

    @Override
    public Object apply(ExpressionEvaluator evaluator) throws VilException {
        return sequence.apply(evaluator);
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
    public Set<T> asSet() {
        return toSet();
    }

    @Override
    public Sequence<T> asSequence() {
        return sequence.asSequence();
    }

    @Override
    public Sequence<T> sortAlpha() {
        return sequence.sortAlpha();
    }
    
    @Override
    public Sequence<T> sort(ExpressionEvaluator evaluator) throws VilException {
        return sequence.sort(evaluator);
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
    public Map<T, T> mapAny(Sequence<T> other) {
        return sequence.mapAny(other);
    }

    @Override
    public boolean equals(Object object) {
        return sequence.equals(object);
    }
    
    @Override
    public int hashCode() {
        return sequence.hashCode();
    }

    @Override
    public List<T> toMappedList() {
        return sequence.toMappedList();
    }

    @Override
    public Sequence<T> revert() {
        return sequence.revert();
    }

    @Override
    public TypeDescriptor<?> getType() {
        return sequence.getType();
    }

    @Invisible
    @Override
    public String toString() {
        return sequence.toString();
    }

    @Override
    public void clear() {
        sequence.clear();
    }

    @Override
    public T sum() {
        return sequence.sum();
    }

    @Override
    public Object avg() {
        return sequence.avg();
    }

    @Override
    public T product() {
        return sequence.product();
    }

    @Override
    public T min() {
        return sequence.min();
    }

    @Override
    public T max() {
        return sequence.max();
    }

    @Override
    public boolean includesAll(Collection<?> elements) {
        return sequence.includesAll(elements);
    }

    @Override
    public boolean excludesAll(Collection<?> elements) {
        return sequence.excludesAll(elements);
    }

    @Override
    public T any(ExpressionEvaluator evaluator) throws VilException {
        return sequence.any(evaluator);
    }

    @Override
    public T one(ExpressionEvaluator evaluator) throws VilException {
        return sequence.one(evaluator);
    }

}