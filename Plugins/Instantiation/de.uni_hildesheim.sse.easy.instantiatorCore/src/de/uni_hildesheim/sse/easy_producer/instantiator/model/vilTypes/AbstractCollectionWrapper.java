package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;

/**
 * Abstract basic wrapper implementation.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
public abstract class AbstractCollectionWrapper<T> implements Collection<T> {
    
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
     * Returns the selection of elements from <code>collection</code> complying to the given <code>type</code>.
     * 
     * @param <T> the element type
     * @param collection the collection to analyze
     * @param type the type to select for
     * @return the elements of type <code>type</code>
     */
    public static <T> List<T> selectByType(Collection<T> collection, Class<?> type) {
        TypeDescriptor<? extends IVilType> desc = TypeRegistry.DEFAULT.findType(type); // TODO -> dynamic
        List<T> result = new ArrayList<T>();
        Iterator<T> iter = collection.iterator();
        while (iter.hasNext()) {
            T element = iter.next();
            if (type.isInstance(element) || (null != desc && desc.isInstance(element))) {
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
     * @throws ArtifactException in case that evaluation or selection fails
     */
    public static <T> List<T> select(Collection<T> collection, ExpressionEvaluator evaluator) 
        throws ArtifactException {
        List<T> result = new ArrayList<T>();
        try {
            if (!TypeRegistry.booleanType().isAssignableFrom(evaluator.getExpression().inferType())) {
                throw new ArtifactException("iterator must be of type boolean", ArtifactException.ID_RUNTIME_ITERATOR);
            }
            Iterator<T> iter = collection.iterator();
            while (iter.hasNext()) {
                T value = iter.next();
                Object eval = evaluator.evaluate(value);
                if (eval instanceof Boolean && ((Boolean) eval)) {
                    result.add(value);
                }
            }
        } catch (ExpressionException e) {
            throw new ArtifactException(e, e.getId());
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
     * Implements the sortAlpha function. However, just using a comparator does not lead to a stable sorting.
     * 
     * @return a sorted (internal) list
     */
    protected List<T> sortAlphaImpl() {
        java.util.Map<String, T> mapping = new TreeMap<String, T>(Collator.getInstance());
        Iterator<T> iter = iterator();
        while (iter.hasNext()) {
            T elt = iter.next();
            mapping.put(StringValueHelper.getStringValue(elt, null), elt);
        }
        List<T> tmp = new ArrayList<T>();
        tmp.addAll(mapping.values());
        return tmp;
    }
    
}
