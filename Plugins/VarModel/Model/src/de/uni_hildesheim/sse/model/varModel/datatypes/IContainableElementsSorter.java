package de.uni_hildesheim.sse.model.varModel.datatypes;

import java.util.Comparator;

import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;

/**
 * Defines an interface for classes which are able to sort their elements 
 * according to a given comparator.
 * 
 * @author Holger Eichelberger
 */
public interface IContainableElementsSorter {

    /**
     * Sorts the contained elements (and creates the related datastructure if needed) according to the specified 
     * comparator. Please note the following requirements for applying this method:
     * <ul>
     *   <li>All Elements which were added before this operation must still be 
     *       member of this project after executing this operation.</li>
     *   <li>Comments related to an element must occur before the element in the
     *       final sequence.</li>
     * </ul>
     * @param comp a comparator which fulfills the requirements above
     */
    public void sortContainedElements(Comparator<ContainableModelElement> comp);

}
