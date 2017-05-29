/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Iterator;

/**
 * Specific reusable operations for sets.
 * 
 * @author Holger Eichelberger
 */
public class SetOperations {

    /**
     * Calculates the difference between the given two sets, i.e., the elements of <code>s1</code>
     * that are not in <code>s2</code>.
     * 
     * @param <T> the element type
     * @param s1 the first set
     * @param s2 the second set
     * @return the set difference
     */
    public static <T> java.util.Set<T> difference(Set<T> s1, Set<T> s2) {
        return difference(s1, s2, null);
    }

    /**
     * Calculates the difference between the given two sets, i.e., the elements of <code>s1</code>
     * that are not in <code>s2</code>.
     * 
     * @param <T> the element type
     * @param s1 the first set
     * @param s2 the second set
     * @param result the result set (a new one is created if <b>null</b>)
     * @return the set difference in terms of <code>result</code> or the new set created
     */
    private static <T> java.util.Set<T> difference(Set<T> s1, Set<T> s2, java.util.Set<T> result) {
        java.util.Set<T> res = result;
        if (null == res) {
            res = new java.util.HashSet<T>();
        }
        Iterator<T> iter = s1.iterator();
        while (iter.hasNext()) {
            T elt = iter.next();
            if (!s2.includes(elt)) {
                res.add(elt);
            }
        }
        return res;
    }

    /**
     * Calculates the symmetric difference between the given two sets, i.e., the elements that are either in 
     * <code>s1</code> or in <code>s2</code> but not in both.
     * 
     * @param <T> the element type
     * @param s1 the first set
     * @param s2 the second set
     * @return the symmetric set difference
     */
    public static <T> java.util.Set<T> symmetricDifference(Set<T> s1, Set<T> s2) {
        java.util.Set<T> result = difference(s1, s2, null);
        return difference(s2, s1, result);
    }

}
