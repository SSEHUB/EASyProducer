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

}
