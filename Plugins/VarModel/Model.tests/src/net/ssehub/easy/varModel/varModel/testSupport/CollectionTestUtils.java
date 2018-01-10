/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.varModel.testSupport;

import java.util.Collection;

import org.junit.Assert;

/**
 * Some test utilities for collections.
 * 
 * @author Holger Eichelberger
 */
public class CollectionTestUtils {

    /**
     * Returns whether all elements in <code>expected</code> are also in <code>actual</code> and
     * <code>actual</code> has the same number of elements as <code>expected</code>.
     * 
     * @param <T> the type of elements to compare
     * @param actual actual the actual elements
     * @param expected the expected elements
     */
    public static <T> void assertContains(Collection<T> actual, T... expected) {
        Assert.assertEquals("sizes do not match", expected.length, actual.size());
        for (int e = 0; e < expected.length; e++) {
            Assert.assertTrue("Entry " + e + "is not contained", actual.contains(expected[e]));
        }
    }
    
}