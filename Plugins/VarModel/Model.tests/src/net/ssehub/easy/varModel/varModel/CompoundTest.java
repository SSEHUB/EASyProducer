/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.varModel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.varModel.testSupport.CollectionTestUtils;

/**
 * Dedicated Tests for {@link Compound}.
 * 
 * @author Holger Eichelberger
 */
public class CompoundTest {
    
    /**
     * Tests compound pruning (here, currently no other direct test).
     */
    @Test
    public void testCompoundPruning() {
        List<Compound> test = new ArrayList<Compound>();
        Assert.assertEquals(0, Compound.pruneAbstract(test).size());
        Assert.assertEquals(0, Compound.pruneNonAbstract(test).size());
        
        Compound c1 = new Compound("c1", null, true);
        Compound c2 = new Compound("c2", null, false);
        test.add(c1);
        test.add(c2);
        CollectionTestUtils.assertContains(Compound.pruneAbstract(test), c2);
        test.clear();
        test.add(c1);
        test.add(c2);
        CollectionTestUtils.assertContains(Compound.pruneNonAbstract(test), c1);
    }

    /**
     * Tests {@link Compound#getRefinesDistanceTo(Compound)}.
     */
    @Test
    public void testRefinesDistance() {
        Project prj = new Project("p");
        Compound c1 = new Compound("c1", prj);
        prj.add(c1);
        Compound c21 = new Compound("c2.1", prj, c1);
        prj.add(c21);
        Compound c22 = new Compound("c2.2", prj, c1);
        prj.add(c22);
        Compound c3 = new Compound("c3", prj, c21);
        prj.add(c3);
        Compound c4 = new Compound("c4", prj);
        prj.add(c4);
        
        assertRefinesDistance(-1, c1, c4);
        assertRefinesDistance(0, c1, c1);
        assertRefinesDistance(0, c4, c4);
        assertRefinesDistance(1, c1, c21);
        assertRefinesDistance(1, c1, c22);
        assertRefinesDistance(-1, c21, c22);
        assertRefinesDistance(2, c1, c3);
    }

    /**
     * Tests {@link Compound#closestRefining(java.util.Collection)}.
     */
    @Test
    public void testClosestRefining() {
        Project prj = new Project("p");
        Compound c1 = new Compound("c1", prj);
        prj.add(c1);
        Compound c21 = new Compound("c2.1", prj, c1);
        prj.add(c21);
        Compound c22 = new Compound("c2.2", prj, c1);
        prj.add(c22);
        Compound c3 = new Compound("c3", prj, c21);
        prj.add(c3);
        Compound c4 = new Compound("c4", prj);
        prj.add(c4);
        
        List<Compound> cmps = new ArrayList<Compound>();
        cmps.add(c21);
        cmps.add(c22);
        cmps.add(c3);
        cmps.add(c4);
        CollectionTestUtils.assertContains(c1.closestRefining(cmps), c21, c22);
        cmps.add(c1);
        CollectionTestUtils.assertContains(c1.closestRefining(cmps), c1);
    }
    
    /**
     * Asserts the <code>expected</code> {@link Compound#getRefinesDistanceTo(Compound)} between
     * the given compounds by checking both (the difference is absolute and symmetric).
     * 
     * @param expected the expected result
     * @param c1 the first compound
     * @param c2 the second compound
     */
    private static void assertRefinesDistance(int expected, Compound c1, Compound c2) {
        Assert.assertEquals(expected, c1.getRefinesDistanceTo(c2));
        Assert.assertEquals(expected, c2.getRefinesDistanceTo(c1));
    }

}
