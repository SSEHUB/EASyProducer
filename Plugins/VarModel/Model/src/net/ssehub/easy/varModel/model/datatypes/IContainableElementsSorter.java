/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.model.datatypes;

import java.util.Comparator;

import net.ssehub.easy.varModel.model.ContainableModelElement;

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
