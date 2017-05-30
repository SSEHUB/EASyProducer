package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import net.ssehub.easy.basics.DefaultLocale;
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
    @Invisible
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
     * @param result the elements of type <code>type</code> (modified as a side effect) - may be <b>null</b> then stop
     *   at first match
     * @param select do a select (<code>true</code>) or a reject (<code>false</code>)
     * @return the last match
     * @throws VilException in case that evaluation or selection fails
     */
    protected static <T> T select(Collection<T> collection, ExpressionEvaluator evaluator, 
        java.util.Collection<T> result, boolean select) throws VilException {
        T res = null;
        boolean isDecVar = assertBooleanIterator(evaluator);
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
                res = value;
                if (null == result) {
                    break;
                } else {
                    result.add(value);
                }
            }
        }
        return res;
    }

    /**
     * Asserts an iterator of boolean type.
     * 
     * @param evaluator the evaluator to check
     * @return whether the actual iterator is also a decision variable 
     * @throws VilException in case that evaluation
     */
    private static boolean assertBooleanIterator(ExpressionEvaluator evaluator) throws VilException {
        TypeDescriptor<?> type = evaluator.getExpression().inferType();
        boolean isDecVar = IvmlTypes.decisionVariableType().isAssignableFrom(type);
        if (!isDecVar && !TypeRegistry.booleanType().isAssignableFrom(type)) {
            // shall be done at language translation time, not at runtime - keep for now
            throw new VilException("iterator must be of type boolean", VilException.ID_RUNTIME_ITERATOR);
        }
        return isDecVar;
    }
    
    @Override
    public T any(ExpressionEvaluator evaluator) throws VilException {
        return any(this, evaluator);
    }

    /**
     * Returns the first match from <code>collection</code>.
     *
     * @param <T> the element type
     * @param collection the collection
     * @param evaluator the evaluator to check
     * @return the first match or <b>null</b>
     * @throws VilException in case that evaluation
     */
    @Invisible
    public static <T> T any(Collection<T> collection, ExpressionEvaluator evaluator) throws VilException {
        return select(collection, evaluator, null, true);
    }

    /**
     * Returns whether there is an element matching the <code>evaluator</code>.
     *
     * @param <T> the element type
     * @param collection the collection
     * @param evaluator the evaluator to check
     * @return <code>true</code> there is one, <code>false</code> else
     * @throws VilException in case that evaluation
     */
    @Invisible
    public static <T> Boolean exists(Collection<T> collection, ExpressionEvaluator evaluator) throws VilException {
        return select(collection, evaluator, null, true) != null;
    }

    /**
     * Returns whether there is an element matching the <code>evaluator</code>.
     *
     * @param <T> the element type
     * @param collection the collection
     * @param evaluator the evaluator to check
     * @return <code>true</code> there is one, <code>false</code> else
     * @throws VilException in case that evaluation
     */
    @Invisible
    public static <T> Boolean forAll(Collection<T> collection, ExpressionEvaluator evaluator) throws VilException {
        return select(collection, evaluator, true).size() == collection.size(); // optimize - stop on first false
    }

    /**
     * Returns whether there is an element matching the <code>evaluator</code>.
     *
     * @param <T> the element type
     * @param collection the collection
     * @param evaluator the evaluator to check
     * @return <code>true</code> there is one, <code>false</code> else
     * @throws VilException in case that evaluation
     */
    @Invisible
    public static <T> Boolean isUnique(Collection<T> collection, ExpressionEvaluator evaluator) throws VilException {
        List<Object> tmp = collect(collection, evaluator, false); // optimize - stop on first
        java.util.Set<Object> tmpSet = new java.util.HashSet<Object>();
        int nullCount = 0;
        boolean unique = true;
        for (int i = 0; unique && i < tmp.size(); i++) {
            Object val = tmp.get(i);
            if (null == val) {
                if (0 == nullCount) {
                    nullCount++;
                } else {
                    unique = false;
                }
            } else {
                unique = tmpSet.add(val);
            }
        }
        return unique;
    }

    /**
     * Returns whether there exists on element in the collection for which the <code>evaluator</code>
     * returns <code>true</code>. 
     * 
     * @param evaluator the evaluator
     * @return <code>true</code> for the exists one, <code>false</code> else
     * @throws VilException in case that evaluation fails
     */
    @Override
    public Boolean exists(ExpressionEvaluator evaluator) throws VilException {
        return exists(this, evaluator);
    }

    /**
     * Returns whether all elements in the collection for which the <code>evaluator</code>
     * returns <code>true</code>. 
     * 
     * @param evaluator the evaluator
     * @return <code>true</code> for the exists one, <code>false</code> else
     * @throws VilException in case that evaluation fails
     */
    public Boolean forAll(ExpressionEvaluator evaluator) throws VilException {
        return forAll(this, evaluator);
    }

    /**
     * Returns whether the evaluator returns a different result for all elements in the collection. 
     * 
     * @param evaluator the evaluator
     * @return <code>true</code> if all results are different, <code>false</code> else
     * @throws VilException in case that evaluation fails
     */
    public Boolean isUnique(ExpressionEvaluator evaluator) throws VilException {
        return isUnique(this, evaluator);
    }

    /**
     * Returns the first match from <code>collection</code> if there can be only one match.
     *
     * @param <T> the element type
     * @param collection the collection
     * @param evaluator the evaluator to check
     * @return the first and only match or <b>null</b>
     * @throws VilException in case that evaluation
     */
    @Invisible
    public static <T> T one(Collection<T> collection, ExpressionEvaluator evaluator) throws VilException {
        T result;
        List<T> tmp = select(collection, evaluator, true);
        if (tmp.size() != 1) {
            result = null;
        } else {
            result = tmp.get(0);
        }
        return result;
    }

    @Override
    public T one(ExpressionEvaluator evaluator) throws VilException {
        return one(this, evaluator);
    }
    
    /**
     * Returns the type parameters for a flattened collection.
     * 
     * @param collection the original collection
     * @return the flattened type parameter(s)
     */
    public TypeDescriptor<?>[] getFlattenedParams(Collection<?> collection) {
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = collection.getType().flattenParam();
        return param;
    }
    
    /**
     * Flattens a collection.
     * 
     * @param <T1> the element type of the input collection
     * @param <T2> the element type of the result collection
     * @param collection the VIL collection to flatten
     * @param result the result (to be modified as a side effect)
     * @throws VilException in case that a single element value cannot be added to the result collection
     */
    protected static <T1, T2> void flatten(Collection<T1> collection, java.util.Collection<T2> result) 
        throws VilException {
        Iterator<T1> iter = collection.iterator();
        while (iter.hasNext()) {
            flatten(iter.next(), result);
        }
    }
    
    /**
     * Flattens an element value (may contain a Java collection).
     * 
     * @param <T1> the element type
     * @param <T2> the element type of the result collection
     * @param value the element value
     * @param result the result (to be modified as a side effect)
     * @throws VilException in case that a single element value cannot be added to the result collection
     */
    @SuppressWarnings("unchecked")
    private static <T1, T2> void flatten(T1 value, java.util.Collection<T2> result) throws VilException {
        if (value instanceof Collection) {
            flatten((Collection<?>) value, result);
        } else if (value instanceof java.util.Collection) {
            java.util.Collection<?> coll = (java.util.Collection<?>) value;
            for (Object o : coll) {
                flatten(o, result);
            }
        } else {
            try {
                result.add((T2) value);
            } catch (ClassCastException e) {
                new VilException(e, VilException.ID_RUNTIME_TYPE);
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
     * @throws VilException in case that evaluator fails
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
     * Calculates the closure over <code>collection</code> and <code>evaluator</code>.
     * 
     * @param collection the collection to operate on
     * @param evaluator the evaluator used to determine the next closure elements
     * @return the closure
     * @throws VilException in case that evaluation fails
     */
    public static java.util.Set<Object> closure(Collection<?> collection, ExpressionEvaluator evaluator) 
        throws VilException {
        java.util.Set<Object> result = new java.util.HashSet<Object>();
        Iterator<?> iter = collection.iterator();
        while (iter.hasNext()) {
            closureOnElement(iter.next(), result, evaluator, false);
        }
        return result;
    }
    
    /**
     * Returns whether the closure over this collection and <code>evaluator</code> is acyclic.
     * 
     * @param evaluator the evaluator
     * @return <code>true</code> for acyclic, <code>false</code> for cyclic
     * @throws VilException in case that evaluation fails
     */
    public boolean isAcyclic(ExpressionEvaluator evaluator) throws VilException {
        return isAcyclic(this, evaluator);
    }

    /**
     * Returns whether the closure over <code>collection</code> and <code>evaluator</code> is acyclic.
     * 
     * @param collection the collection to run over
     * @param evaluator the evaluator
     * @return <code>true</code> for acyclic, <code>false</code> for cyclic
     * @throws VilException in case that evaluation fails
     */
    public static boolean isAcyclic(Collection<?> collection, ExpressionEvaluator evaluator) throws VilException {
        boolean cyclic = false;
        java.util.Set<Object> tmp = new java.util.HashSet<Object>();
        Iterator<?> iter = collection.iterator();
        while (!cyclic && iter.hasNext()) {
            cyclic = closureOnElement(iter.next(), tmp, evaluator, true);
        }
        return !cyclic;
    }
    
    /**
     * Calculates the closure for <code>value</code> using <code>evaluator</code> and does not visit already 
     * visited elements in <code>result</code> again.
     * 
     * @param value the value to calculate the closure on
     * @param result the result
     * @param evaluator the evaluator
     * @param stopOnCycle whether iteration/recursion shall stop immediately if a cycle is detected
     * @return <code>true</code> if a cycle was detected, <code>false</code> else
     * @throws VilException in case that evaluator fails
     */
    private static boolean closureOnElement(Object value, java.util.Set<Object> result, ExpressionEvaluator evaluator, 
        boolean stopOnCycle) throws VilException {
        boolean cyclic = false;
        if (null != value) {
            cyclic = !result.add(value);
            if (!cyclic) {
                Object eval = evaluator.evaluate(value);
                if (null != eval) {
                    Iterator<?> iter = null;
                    if (eval instanceof Collection) {
                        iter = ((Collection<?>) eval).iterator();
                    } else if (eval instanceof java.util.Collection) {
                        iter = ((java.util.Collection<?>) eval).iterator();
                    } else {
                        cyclic = !result.add(value);
                    }
                    while (null != iter && iter.hasNext()) {
                        if (cyclic && stopOnCycle) {
                            break;
                        }
                        cyclic |= closureOnElement(iter.next(), result, evaluator, stopOnCycle);
                    }
                }
            }
        }
        return cyclic;
    }
    
    /**
     * Collects the application of <code>evaluator</code> to <code>collection</code>.
     *
     * @param collection the collection to select from
     * @param evaluator the evaluator instance
     * @param flatten flatten the result
     * @return the application results
     * @throws VilException in case that evaluation fails
     */
    public static List<Object> collect(Collection<?> collection, ExpressionEvaluator evaluator, boolean flatten) 
        throws VilException {
        List<Object> result = new ArrayList<Object>();
        collect(collection, evaluator, result, flatten);
        return result;
    }
    
    /**
     * Collects the application of <code>evaluator</code> to <code>collection</code>.
     *
     * @param collection the collection to select from
     * @param evaluator the evaluator instance
     * @param result the elements of type <code>type</code> (modified as a side effect)
     * @param flatten flatten the result
     * @throws VilException in case that evaluation fails
     */
    protected static void collect(Collection<?> collection, ExpressionEvaluator evaluator, 
        java.util.Collection<Object> result, boolean flatten) throws VilException {
        Iterator<?> iter = collection.iterator();
        while (iter.hasNext()) {
            collect(iter.next(), evaluator, result, flatten);
        }
    }

    /**
     * Performs a (non-)flattening collect operation on <code>value</code>.
     * 
     * @param value the value to collect
     * @param evaluator the evaluator to apply on <code>value</code>
     * @param result the result collection to fill as a side effect
     * @param flatten whether the result shall be flattened or nesting shall be kept
     * @throws VilException in case that evaluation fails
     */
    private static void collect(Object value, ExpressionEvaluator evaluator, 
        java.util.Collection<Object> result, boolean flatten) throws VilException {
        java.util.Collection<Object> res = result;
        Iterator<?> iter = null;
        if (value instanceof Collection) {
            Collection<?> coll = (Collection<?>) value;
            iter = coll.iterator();
            res = createSubCollection(result, coll, flatten);
        } else if (value instanceof java.util.Collection) {
            java.util.Collection<?> coll = (java.util.Collection<?>) value;
            iter = coll.iterator();
            res = createSubCollection(result, coll, flatten);
        } else {
            Object eval = evaluator.evaluate(value);
            if (null != eval) {
                res.add(eval);
            }
        }
        if (null != iter) {
            while (iter.hasNext()) {
                collect(iter.next(), evaluator, res, flatten);
            }
        }
    }

    /**
     * Creates a sub-collection for non-flattened collect operations.
     * 
     * @param parent the parent collection the sub-collection shall be added to
     * @param template the template defining the type (set or sequence)
     * @param flatten whether the result shall be flattened or nesting shall be kept
     * @return the sub-collection or <code>parent</code> if no sub-collection can be created
     */
    private static java.util.Collection<Object> createSubCollection(java.util.Collection<Object> parent, 
        Object template, boolean flatten) {
        java.util.Collection<Object> result = parent;
        if (!flatten) {
            if (template instanceof java.util.Set || template instanceof Set) {
                result = new HashSet<Object>();
                parent.add(result);
            } else if (template instanceof java.util.Set || template instanceof Sequence) {
                result = new ArrayList<Object>();
                parent.add(result);
            }
        }
        return result;
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
        java.util.Map<String, List<T>> mapping = new TreeMap<String, List<T>>(PseudoString.getCurrentCollator());
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
            java.util.Map<String, List<T>> mapping = new TreeMap<String, List<T>>(
                Collator.getInstance(DefaultLocale.getDefaultLocale()));
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
    public T sum() {
        return aggregate(this, "+");
    }
    
    @OperationMeta(useAny = true)
    @Override
    public Object avg() {
        Object res = aggregate(this, "+");
        TypeDescriptor<?> elementType = getElementType(this);
        IMetaOperation op = null;
        CallArgument resArg = new CallArgument(elementType);
        CallArgument eltArg = new CallArgument(TypeRegistry.integerType());
        try {
            op = AbstractCallExpression.resolveOperation(elementType, "/", resArg, eltArg);
        } catch (VilException e) {
            try {
                op = AbstractCallExpression.resolveOperation(elementType, "div", resArg, eltArg);
            } catch (VilException e1) {
                // no operation, no aggregation; result -> null
            }
        }
        if (null != op) {
            try {
                res = op.invoke(res, size());
            } catch (VilException e) {
                res = null;
            }
        }
        return res;
    }

    @Override
    public T product() {
        return aggregate(this, "*");
    }

    @Override
    public T min() {
        return aggregate(this, "min");
    }

    @Override
    public T max() {
        return aggregate(this, "max");
    }

    /**
     * Returns the element type of <code>collection</code>.
     * 
     * @param collection the collection 
     * @return the element type
     */
    private static TypeDescriptor<?> getElementType(Collection<?> collection) {
        TypeDescriptor<?> elementType;
        if (1 == collection.getGenericParameterCount()) {
            elementType = collection.getGenericParameterType(0);
        } else {
            elementType = TypeRegistry.anyType();
        }
        return elementType;
    }

    /**
     * Aggregates elements over <code>collection</code> by resolving the given operation over the element type
     * of the collection.
     * 
     * @param <T> the element type of the collection
     * @param collection the collection
     * @param opName denotes an operation on the elements of this collection. The operation 
     *   must be binary (2 parameters) on the element type of this collection and return
     *   a type that is assignable to the element type of this collection
     * @return the aggregated result or <b>null</b> if undefined/aggregation not possible
     */
    @SuppressWarnings("unchecked")
    public static <T> T aggregate(Collection<T> collection, String opName) {
        Object result = null;
        TypeDescriptor<?> elementType = getElementType(collection);
        IMetaOperation op = null;
        CallArgument resArg = new CallArgument(elementType);
        CallArgument eltArg = new CallArgument(elementType);
        try {
            op = AbstractCallExpression.resolveOperation(elementType, opName, resArg, eltArg);
        } catch (VilException e) {
            // no operation, no aggregation; result -> null
        }
        if (null != op && elementType.isAssignableFrom(op.getReturnType())) {
            Iterator<T> iter = collection.iterator();
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
        return (T) result;
    }

    @Override
    public boolean includesAll(Collection<?> elements) {
        return containsAll(this, elements, false);
    }
    
    @Override
    public boolean excludesAll(Collection<?> elements) {
        return containsAll(this, elements, true);
    }
    
    /**
     * Returns whether all elements in <code>elements</code> are also in <code>base</code>
     * collection.
     * 
     * @param base the base collection
     * @param elements the elements to check for
     * @param negate whether the result shall be negated, i.e., it shall be checked for not being
     *   member of this collection
     * @return <code>true</code> if (non-)containment holds for all elements
     */
    public static boolean containsAll(Collection<?> base, Collection<?> elements, boolean negate) {
        boolean all = true;
        HashSet<Object> tmp = new HashSet<Object>();
        Iterator<?> myIter = base.iterator();
        while (myIter.hasNext()) {
            tmp.add(myIter.next());
        }
        Iterator<?> iter = elements.iterator();
        while (all && iter.hasNext()) {
            boolean eTmp = tmp.contains(iter.next());
            if (negate) {
                eTmp = !eTmp;
            }
            all = eTmp;
        }
        return all;        
    }

}
