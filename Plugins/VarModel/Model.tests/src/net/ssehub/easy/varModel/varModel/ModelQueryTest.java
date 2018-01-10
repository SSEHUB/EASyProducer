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

import org.junit.Test;

import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.varModel.testSupport.CollectionTestUtils;

/**
 * Dedicated Tests for {@link ModelQuery}.
 * 
 * @author Holger Eichelberger
 */
public class ModelQueryTest {

    /**
     * Tests {@link ModelQuery#findRefining(net.ssehub.easy.varModel.model.datatypes.IResolutionScope, Compound)}.
     */
    @Test
    public void testFindRefining() {
        Project prj = new Project("prj");
        Compound c1 = new Compound("c1", prj);
        prj.add(c1);
        Compound c2 = new Compound("c2", prj, c1);
        prj.add(c2);
        Compound c3 = new Compound("c3", prj);
        prj.add(c3);

        CollectionTestUtils.assertContains(ModelQuery.findRefining(prj, c2));
        CollectionTestUtils.assertContains(ModelQuery.findRefining(prj, c3));
        CollectionTestUtils.assertContains(ModelQuery.findRefining(prj, c1), c2);
    }
    
}
