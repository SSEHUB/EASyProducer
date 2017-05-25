package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.AbstractCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;

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
     * Compute the union of <code>c1</code> and <code>c2</code> (without duplicates).
     * 
     * @param <T> the element type
     * @param c1 the first collection to be considered
     * @param c2 the second collection to be considered
     * @return the union of <code>c1</code> and <code>c2</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public static <T> List<T> union(Collection<T> c1, Collection<T> c2) {
        List<T> result = new ArrayList<T>();
        java.util.Set<T> s1 = new HashSet<T>();
        Iterator<T> iter = c1.iterator();
        while (iter.hasNext()) {
            T elt = iter.next();
            s1.add(elt);
            result.add(elt);
        }
        iter = c2.iterator();
        while (iter.hasNext()) {
            T elt = iter.next();
            if (!s1.contains(elt)) {
                result.add(elt);
            }
        }
        return result;
    }

    /**
     * Returns the intersection of <code>c1</code> and <code>c2</code>.
     * 
     * @param <T> the element type
     * @param c1 the first collection to be considered
     * @param c2 the second collection to be considered
     * @return the intersection of <code>c1</code> and <code>c2</code>
     */
    @OperationMeta(returnGenerics = IVilType.class)
    public static <T> List<T> intersection(Collection<T> c1, Collection<T> c2) {
        List<T> result = new ArrayList<T>();
        java.util.Set<T> s1 = new HashSet<T>();
        Iterator<T> iter = c1.iterator();
        while (iter.hasNext()) {
            s1.add(iter.next());
        }
        iter = c2.iterator();
        while (iter.hasNext()) {
            T elt = iter.next();
            if (s1.contains(elt)) {
                result.add(elt);
            }
        }
        return result;
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
     * @param byKind select by kind (<code>true</code>, including subclasses) or by type equality <code>false</code>
     * @param negate negate the selection
     * @return the elements of type <code>type</code>
     */
    public static <T> List<T> selectByType(Collection<T> collection, TypeDescriptor<?> type, boolean byKind, 
        boolean negate) {
        List<T> result = new ArrayList<T>();
        selectByType(collection, type, result, byKind, negate);
        return result;
    }
    
    /**
     * Calculates the selection of elements from <code>collection</code> complying to the given <code>type</code>.
     * 
     * @param <T> the element type
     * @param collection the collection to analyze
     * @param type the type to select for
     * @param result the elements of type <code>type</code> (modified as a side effect)
     * @param negate negate the selection
     * @param byKind select by kind (<code>true</code>, including subclasses) or by type equality <code>false</code>
     */
    protected static <T> void selectByType(Collection<T> collection, TypeDescriptor<?> type, 
        java.util.Collection<T> result, boolean byKind, boolean negate) {
        Iterator<T> iter = collection.iterator();
        while (iter.hasNext()) {
            T element = iter.next();
            if (null == type || isSelectedByType(type, element, byKind, negate)) {
                result.add(element);
            }
        }
    }

    /**
     * Returns whether type selection matches.
     * 
     * @param type the type to be considered (may be <b>null</b>, than this parameter is ignored)
     * @param element the element to test
     * @param byKind do the selection by subtyping (<code>true</code>) or by equality (<code>false</code>)
     * @param negate negate the result
     * @return <code>true</code> if types match, <code>false</code> else
     */
    private static boolean isSelectedByType(TypeDescriptor<?> type, Object element, boolean byKind, boolean negate) {
        boolean result = (byKind && type.isInstance(element)) || (!byKind && type.isSameType(element));
        if (negate) {
            result = !result;
        }
        return result;
    }
 
    /**
     * Selects those elements from <code>collection</code> which comply to the result of <code>evaluator</code>.
     *
     * @param <T> the element type
     * @param collection the collection to select from
     * @param evaluator the evaluator instance
     * @param select do a select (<code>true</code>) or a reject (<code>false</code>)
     * @return the selected elements
     * @throws VilException in case that evaluation or selection fails
     */
    public static <T> List<T> select(Collection<T> collection, ExpressionEvaluator evaluator, boolean select) 
        throws VilException {
        List<T> result = new ArrayList<T>();
        select(collection, evaluator, result, select);
        return result;
    }
    
    /**
     * Selects those elements from <code>collection</code> which comply to the result of <code>evaluator</code>.
     *
     * @param <T> the element type
     * @param collection the collection to select from
     * @param evaluator the evaluator instance
     * @param result the elements of type <code>type</code> (modified as a side effect)
     * @param select do a select (<code>true</code>) or a reject (<code>false</code>)
     * @throws VilException in case that evaluation or selection fails
     */
    protected static <T> void select(Collection<T> collection, ExpressionEvaluator evaluator, 
        java.util.Collection<T> result, boolean select) throws VilException {
        TypeDescriptor<?> type = evaluator.getExpression().inferType();
        boolean isDecVar = IvmlTypes.decisionVariableType().isAssignableFrom(type);
        if (!isDecVar && !TypeRegistry.booleanType().isAssignableFrom(type)) {
            // shall be done at language translation time, not at runtime - keep for now
            throw new VilException("iterator must be of type boolean", VilException.ID_RUNTIME_ITERATOR);
        }
        Iterator<T> iter = collection.iterator();
        while (iter.hasNext()) {
            T value = iter.next();
            Object eval = evaluator.evaluate(value);
            Boolean selectionCriterion = null;
            if (isDecVar) {
                if (eval instanceof DecisionVariable) {
                    selectionCriterion = ((DecisionVariable) eval).getBooleanValue();
                }
            } else if (eval instanceof Boolean) {
                selectionCriterion = (Boolean) eval;
            }
            if (null != selectionCriterion && isSelected(selectionCriterion, select)) {
                result.add(value);
            }
        }
    }
    
    /**
     * Determines whether an element is selected.
     * 
     * @param selectionCriterion the original criterion
     * @param select select or reject (negate)
     * @return <code>true</code> for selected, <code>false</code> else
     */
    private static boolean isSelected(boolean selectionCriterion, boolean select) {
        return (select && selectionCriterion) || (!select && !selectionCriterion);
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
        collect(collection, evaluator, result);
        return result;
    }
    
    /**
     * Collects the application of <code>evaluator</code> to <code>collection</code>.
     *
     * @param <T> the element type
     * @param collection the collection to select from
     * @param evaluator the evaluator instance
     * @param result the elements of type <code>type</code> (modified as a side effect)
     * @throws VilException in case that evaluation or selection fails
     */
    protected static <T> void collect(Collection<T> collection, ExpressionEvaluator evaluator, 
        java.util.Collection<Object> result) throws VilException {
        Iterator<T> iter = collection.iterator();
        while (iter.hasNext()) {
            T value = iter.next();
            Object eval = evaluator.evaluate(value);
            if (null != eval) {
                result.add(eval);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @OperationMeta(name = {"notEmpty", "isNotEmpty"}, notOclCompliant = "isNotEmpty")
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
        return sortImpl(iterator(), evaluator);
    }

    /**
     * Sorts the elements in <code>iter</code> (take numbers if the evaluator returns numbers, 
     * else lexicographic sort).
     * 
     * @param <T> the data type
     * @param iter the iterator holding the data
     * @param evaluator the evaluator
     * @return the sorted sequence from <code>iter</code>
     * @throws VilException in case of evaluation problems
     */
    public static <T> List<T> sortImpl(Iterator<T> iter, ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?> compareEltType = evaluator.getExpression().inferType();
        java.util.Map<?, List<T>> tempMap;
        if (TypeRegistry.realType().isAssignableFrom(compareEltType) 
            || TypeRegistry.integerType().isAssignableFrom(compareEltType)) {
            // lexicographic ordering does not work with negative numbers
            java.util.Map<Number, List<T>> mapping = new TreeMap<Number, List<T>>(NUMBER_COMPARATOR);
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

    @Override
    public Object sum() {
        return aggregate("+");
    }

    /**
     * Aggregates elements.
     * 
     * @param opName denotes an operation on the elements of this collection. The operation 
     *   must be binary (2 parameters) on the element type of this collection and return
     *   a type that is assignable to the element type of this collection
     * @return the aggregated result or <b>null</b> if undefined/aggregation not possible
     */
    private Object aggregate(String opName) {
        Object result = null;
        TypeDescriptor<?> elementType;
        if (1 == getGenericParameterCount()) {
            elementType = getGenericParameterType(0);
        } else {
            elementType = TypeRegistry.anyType();
        }
        IMetaOperation op = null;
        CallArgument resArg = new CallArgument(elementType);
        CallArgument eltArg = new CallArgument(elementType);
        try {
            op = AbstractCallExpression.resolveOperation(elementType, opName, resArg, eltArg);
        } catch (VilException e) {
            // no operation, no aggregation; result -> null
        }
        if (null != op && elementType.isAssignableFrom(op.getReturnType())) {
            Iterator<T> iter = iterator();
            boolean first = true;
            while (iter.hasNext()) {
                T element = iter.next();
                if (first) {
                    result = element;
                } else {
                    try {
                        result = op.invoke(result, element);
                    } catch (VilException e) {
                        result = null;
                        break;
                    }
                }
                first = false;
            }
            
        }
        return result;
    }
    
}
