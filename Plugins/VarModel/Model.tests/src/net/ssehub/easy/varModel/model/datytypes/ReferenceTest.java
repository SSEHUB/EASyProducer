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
package net.ssehub.easy.varModel.model.datytypes;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Reference;

/**
 * Testfile for the Reference-class.
 * @author beck
 *
 */
public class ReferenceTest {

    /**
     * Test creates a Reference and tests the reference-methods but the accept-method.
     */
    @Test
    public void createReferenceTest() {
        //create a reference to the compound cp1
        String cp1Name = "cp1";
        String refName = "refToCp1";
        Compound cp1 = new Compound(cp1Name, null);        
        Reference refToCompound = new Reference(refName, cp1, null);
        
        Assert.assertEquals(cp1, refToCompound.getType());
    }

}
