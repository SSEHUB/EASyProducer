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

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;

/**
 * Testclass for basis datatypes.
 * @author lueder
 *
 */
public class BasisDatatypeTest {

    /**
     * Tests the whole class.
     */
    @Test
    public void basisTest() {
        DecisionVariableDeclaration dec = new DecisionVariableDeclaration("dec", StringType.TYPE, null);
        
        Assert.assertEquals("String", dec.getType().getName());
        Assert.assertEquals("", dec.getType().getNameSpace());
        Assert.assertEquals("String", dec.getType().getQualifiedName());
        Assert.assertEquals("String", dec.getType().getUniqueName());
        Assert.assertEquals(StringType.class, dec.getType().getTypeClass());
        
        try {
            Assert.assertEquals(StringType.class, dec.getType().getGenericType(0));
            Assert.fail(); //Should not occur
        } catch (IndexOutOfBoundsException e) {
            Assert.assertTrue(true);
        }
        
        Assert.assertEquals(0, dec.getType().getGenericTypeCount());
        
        try {
            Assert.assertArrayEquals(null, dec.getType().createConstraints(
                    new DecisionVariableDeclaration("dec2", StringType.TYPE, null)));
        } catch (CSTSemanticException e) {
            Assert.assertTrue(false);
        }
        
        Assert.assertTrue(!dec.getType().isPseudoType());
    }

}
