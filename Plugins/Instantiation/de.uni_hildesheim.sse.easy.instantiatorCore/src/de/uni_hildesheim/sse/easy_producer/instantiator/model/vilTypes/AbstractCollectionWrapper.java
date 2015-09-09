package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * Abstract basic wrapper implementation.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
public abstract class AbstractCollectionWrapper<T> implements Collection<T> {

    public static final Comparator<Number> NUMBER_COMPARATOR = new Comparator<Number>() {

        @Override
        public int compare(Number o1, Number o2) {
            return Double.compare(o1.doubleValue(), o2.doubleValue());
        }
        
    };
    
    /**
     * Returns whether two collection contains the same elements in the same sequence than <code>elements</code>.
     * 
     * @param c1 the first collection to be compared
     * @param c2 the second collection to be compared
     * @return <code>true</code> if both collections contain the same elements in the same sequence, 
     *     <code>false</code> else
     */
    public static boolean equals(Collection<?> c1, Collection<?> c2) {
        boolean equals = c1.size() == c2.size();
        if (equals) {
            Iterator<?> thisIter = c1.iterator();
            Iterator<?> eltIter = c2.iterator();
            while (equals && thisIter.hasNext() && eltIter.hasNext()) {
                equals = thisIter.next().equals(eltIter.next());
            }
        }
        return equals;
    }

    /**
     * Returns whether two collections contain the same elements regardless
     * of their sequence.
     * 
     * @param c1 the first collection
     * @param c2 the second collection
     * 
     * @return <code>true</code> if both collections contain the same elements, <code>false</code> else
     */
    public static boolean sameElements(Collection<?> c1, Collection<?> c2) {
        boolean same = c1.size() == c2.size();
        if (same) {
            java.util.Set<Object> known = new HashSet<Object>();
            Iterator<?> iter = c2.iterator();
            while (iter.hasNext()) {
                known.add(iter.next());
            }
            iter = c1.iterator();
            while (same && iter.hasNext()) {
                same = known.contains(iter.next());                
            }
        }
        return same;
    }
    
    /**
     * Returns all elements from <code>base</code> not containing those in <code>elements</code>.
     * 
     * @param <T> the element type
     * @param base the base collection to exclude the elements from
     * @param elements the elements which must not be in the result
     * @return the projected result
     */
    public static <T> List<T> excluding(Collection<T> base, Collection<?> elements) {
        java.util.Set<Object> known = new HashSet<Object>();
        Iterator<?> iter = elements.iterator();
        while (iter.hasNext()) {
            known.add(iter.next());
        }
        List<T> result = new ArrayList<T>();
        Iterator<T> iterB = base.iterator();
        while (iterB.hasNext()) {
            T element = iterB.next();
            if (!known.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
    
    /**
     * Returns all elements from <code>base</code> including those in <code>elements</code>.
     * 
     * @param <T> the element type
     * @param base the base collection to include the elements to
     * @param elements the elements which must also be in the result
     * @return the projected result
     */
    public static <T> List<T> including(Collection<T> base, Collection<T> elements) {
        List<T> result = new ArrayList<T>();
        java.util.Set<Object> known = new HashSet<Object>();
        Iterator<T> iter = base.iterator();
        while (iter.hasNext()) {
            T elt = iter.next();
            known.add(elt);
            result.add(elt);
        }
        iter = elements.iterator();
        while (iter.hasNext()) {
            T elt = iter.next();
            if (!known.contains(elt)) {
                result.add(elt);
            }
        }
        return result;
    }

    /**
     * Appends all elements from <code>elements</code> to <code>base</code>.
     * 
     * @param <T> the element type
     * @param base the base collection to include the elements to
     * @param elements the elements which shall be appended
     * @return the projected result
     */
    public static <T> List<T> append(Collection<T> base, Collection<T> elements) {
        List<T> result = new ArrayList<T>();
        Iterator<T> iter = base.iterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        iter = elements.iterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }
    
    /**
     * Returns the selection of elements from <code>collection</code> complying to the given <code>type</code>.
     * 
     * @param <T> the element type
     * @param collection the collection to analyze
     * @param type the type to select for
     * @return the elements of type <code>type</code>
     */
    public static <T> List<T> selectByType(Collection<T> collection, TypeDescriptor<?> type) {
        List<T> result = new ArrayList<T>();
        Iterator<T> iter = collection.iterator();
        while (iter.hasNext()) {
            T element = iter.next();
            if (null == type || type.isInstance(element)) {
                result.add(element);
            }
            
        }
        return result;
    }

    /**
     * Selects those elements from <code>collection</code> which comply to the result of <code>evaluator</code>.
     *
     * @param <T> the element type
     * @param collection the collection to select from
     * @param evaluator the evaluator instance
     * @return the selected elements
     * @throws VilException in case that evaluation or selection fails
     */
    public static <T> List<T> select(Collection<T> collection, ExpressionEvaluator evaluator) 
        throws VilException {
        List<T> result = new ArrayList<T>();
        if (!TypeRegistry.booleanType().isAssignableFrom(evaluator.getExpression().inferType())) {
            throw new VilException("iterator must be of type boolean", 
                VilException.ID_RUNTIME_ITERATOR);
        }
        Iterator<T> iter = collection.iterator();
        while (iter.hasNext()) {
            T value = iter.next();
            Object eval = evaluator.evaluate(value);
            if (eval instanceof Boolean && ((Boolean) eval)) {
                result.add(value);
            }
        }
        return result;
    }
    
    /**
     * Processes elements in this set by applying to given expression.
     * 
     * @param <T> the element type
     * @param collection the collection to iterate over
     * @param evaluator the evaluator holding the iterator / expression to apply
     * @return the aggregated result, <b>null</b> in case of a non-aggregating evaluation
     * @throws VilException in case that selection fails
     */
    public static <T> Object apply(Collection<T> collection, ExpressionEvaluator evaluator) throws VilException {
        Iterator<T> iter = collection.iterator();
        evaluator.initializeDeclarators();
        while (iter.hasNext()) {
            evaluator.evaluate(iter.next());
        }
        return evaluator.getResultValue();
    }
    
    /**
     * Collects the application of <code>evaluator</code> to <code>collection</code>.
     *
     * @param <T> the element type
     * @param collection the collection to select from
     * @param evaluator the evaluator instance
     * @return the application results
     * @throws VilException in case that evaluation or selection fails
     */
    public static <T> List<Object> collect(Collection<T> collection, ExpressionEvaluator evaluator) 
        throws VilException {
        List<Object> result = new ArrayList<Object>();
        Iterator<T> iter = collection.iterator();
        while (iter.hasNext()) {
            T value = iter.next();
            Object eval = evaluator.evaluate(value);
            if (null != eval) {
                result.add(eval);
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isNotEmpty() {
        return size() != 0;
    }

    @Override
    public boolean includes(T element) {
        boolean found = false;
        Iterator<T> iter = iterator();
        while (iter.hasNext() && !found) {
            found = iter.next().equals(element);
        }
        return found;
    }
    
    @Override
    public boolean excludes(T element) {
        return !includes(element);
    }
    
    @Override
    public int count(T element) {
        int count = 0;
        Iterator<T> iter = iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(element)) {
                count++;
            }
        }
        return count;        
    }

    /**
     * Implements the sortAlpha function. 
     * 
     * @return a sorted (internal) list
     */
    protected List<T> sortAlphaImpl() {
        java.util.Map<String, List<T>> mapping = new TreeMap<String, List<T>>(Collator.getInstance());
        Iterator<T> iter = iterator();
        while (iter.hasNext()) {
            T elt = iter.next();
            getList(mapping, StringValueHelper.getStringValue(elt, null)).add(elt);
        }
        return toEntryList(mapping);
    }
    
    /**
     * Returns a list indicated by <code>key</code> from the multi-entry <code>map</code>. Creates a new list
     * if it does not exist.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param map the map to be modified as a side effect
     * @param key the key
     * @return the list containing entries assigned to <code>key</code>, potentially a new list
     */
    private static <K, V> List<V> getList(java.util.Map<K, List<V>> map, K key) {
        List<V> list = map.get(key);
        if (null == list) {
            list = new ArrayList<V>();
            map.put(key, list);
        }
        return list;
    }

    /**
     * Turns the multi-entry <code>map</code> into a list of single elements, preserving the sequence of the elements
     * in the individual lists in <code>map</code>. 
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param map the map to be modified as a side effect
     * @return the list of elements
     */
    private static <K, V> List<V> toEntryList(java.util.Map<K, List<V>> map) {
        List<V> result = new ArrayList<V>();
        for (List<V> list : map.values()) {
            result.addAll(list);
        }
        return result;
    }

    /**
     * Implements the more generic sort function (take numbers if the evaluator returns numbers, 
     * else lexicographic sort).
     * 
     * @param evaluator the evaluator
     * @return a sorted sequence
     * @throws VilException in case of evaluation problems
     */
    protected List<T> sortImpl(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?> compareEltType = evaluator.getExpression().inferType();
        java.util.Map<?, List<T>> tempMap;
        if (TypeRegistry.realType().isAssignableFrom(compareEltType) 
            || TypeRegistry.integerType().isAssignableFrom(compareEltType)) {
            // lexicographic ordering does not work with negative numbers
            java.util.Map<Number, List<T>> mapping = new TreeMap<Number, List<T>>(NUMBER_COMPARATOR);
            Iterator<T> iter = iterator();
            while (iter.hasNext()) {
                T value = iter.next();
                Object eval = evaluator.evaluate(value);
                Number key;
                if (eval instanceof Number) {
                    key = (Number) eval;
                } else { // although undefined, it the sort operation must return all values
                    key = 0;
                }
                getList(mapping, key).add(value);
            }
            tempMap = mapping;
        } else {
            java.util.Map<String, List<T>> mapping = new TreeMap<String, List<T>>(Collator.getInstance());
            Iterator<T> iter = iterator();
            while (iter.hasNext()) {
                T value = iter.next();
                Object eval = evaluator.evaluate(value);
                String key;
                if (null != eval) { // VIL ignore
                    key = StringValueHelper.getStringValue(eval, null);
                } else { // although undefined, it the sort operation must return all values
                    key = "";
                }
                getList(mapping, key).add(value);
            }
            tempMap = mapping;
        }
        return toEntryList(tempMap);
    }
    
    /**
     * Implements the revert operation.
     * 
     * @return the reverted list
     */
    protected List<T> revertImpl() {
        List<T> tmp = new LinkedList<T>();
        Iterator<T> iter = iterator();
        while (iter.hasNext()) {
            tmp.add(0, iter.next());
        }
        return tmp;
    }
    
    /**
     * Constructs a collection type.
     * 
     * @param param the parameter
     * @param set whether the result shall represent a set or a sequence
     * @return the constructed type
     */
    protected static TypeDescriptor<?> constructType(TypeDescriptor<?>[] param, boolean set) {
        TypeDescriptor<?> result;
        try {
            result = set ? TypeRegistry.getSetType(param) : TypeRegistry.getSequenceType(param);
        } catch (VilException e) {
            Class<?> cls = set ? Set.class : Sequence.class;
            result = TypeRegistry.DEFAULT.findType(cls);
        }
        return result;
    }
    
}
