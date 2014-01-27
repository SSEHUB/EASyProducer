package de.uni_hildesheim.sse.translation;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;

/**
 * A helper class which supports ordering of containable model elements. Basically, the
 * original sequence can be obtained from the grammar. Typically, this sequence can 
 * not be used for entirely resolving all types due to dependencies among the individual
 * elements. However, correctly resolving the type dependencies leads to a different
 * insertion sequence in the resulting project. Therefore, this helper class supports
 * reordering the already inserted elements (and keeping the existing implementation). This
 * works in three phases whereby each phase must be completed before entering the
 * next phase as in particular the second phase changes the internal link structure:
 * <ol>
 *  <li>Insertion of elements using {@link #put(EObject, Comment, ContainableModelElement)}.</li>
 *  <li>Defining the sequence by assigning index positions to the {@link EObject EObjects} using
 *      {@link #setIndex(EObject, int)}.</li>
 *  <li>Reordering a sequence of comments and containable model elements using the {@link Comparator}
 *      property of this class.</li>
 * </ol>
 * <b>Note:</b> This approach is suboptimal
 * 
 * @author Holger Eichelberger
 *
 */
class ContainableElementsMapAndComparator implements Comparator<ContainableModelElement> {
    
    /**
     * Stores the {@link EObject}-{@link ContainableElementsMapAndComparator.Data} or 
     * {@link ContainableModelElement}-{@link ContainableElementsMapAndComparator.Data} mappings.
     */
    private Map<Object, Data> map;
    
    /**
     * Stores internal data to be assigned to a key.
     * 
     * @author Holger Eichelberger
     */
    private static class Data {
        
        /**
         * The comment instance. May be <b>null</b>.
         */
        private Comment comment;
        
        /**
         * The model element instance.
         */
        private ContainableModelElement element;
        
        /**
         * The index of the comment with respect to the initial {@link EObject}
         * key. The element index can be derived by adding 1.
         */
        private long index;
    }
    
    /**
     * Creates an instance of this class.
     */
    public ContainableElementsMapAndComparator() {
        map = new HashMap<Object, Data>();
    }
    
    /**
     * Adds a mapping from <code>key</code> to <code>comment</code> (optional)
     * and <code>element</code>. (phase 1)
     * 
     * @param key the key object as parsed by xText from the input file
     * @param comment the comment instance (may be <b>null</b>)
     * @param element the element instance
     */
    public void put(EObject key, Comment comment, ContainableModelElement element) {
        Data data = new Data();
        data.comment = comment;
        data.element = element;
        map.put(key, data);
    }
    
    /**
     * Assigns the given index taken from the sequence of key objects to the
     * comment or element in the assigned data. This method changes the linking
     * so that <code>key</code> is not accessible after execution of this method.
     * (phase 2)
     * 
     * @param key the key object
     * @param index the index of <code>key</code> in its containing data structure
     */
    public void setIndex(EObject key, int index) {
        Data data = map.get(key);
        if (null != data) {
            data.index = 2 * index; // spread the index to have space for
            map.remove(key);
            map.put(data.element, data);
            if (null != data.comment) {
                map.put(data.comment, data);
            }
        }
    }

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second. Unknown elements will be treated as if the 
     * smallest possible index has been assigned to them. (phase 3)
     * 
     * @param element1 the first element to be compared.
     * @param element2 the second element to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     */
    //@Override
    public int compare(ContainableModelElement element1, ContainableModelElement element2) {
        long index1 = determineIndex(element1);
        long index2 = determineIndex(element2);
        return (index1 < index2 ? -1 : (index1 == index2 ? 0 : 1));
    }
    
    /**
     * Determines the actual (virtual) index of the given <code>element</code>.
     * 
     * @param element the element
     * @return the (virtual) target index for sorting
     */
    private long determineIndex(ContainableModelElement element) {
        long result;
        Data data = map.get(element);
        if (null == data) {
            result = Long.MIN_VALUE;
        } else {
            if (data.element == element) {
                result = data.index + 1;
            } else if (data.comment == element) {
                result = data.index;
            } else {
                result = Long.MIN_VALUE;
            }
        }
        return result;
    }
    
    /**
     * Clears the data in this object.
     */
    public void clear() {
        map.clear();
    }

}
