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
package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Tests the constraint base class.
 * 
 * @author Holger Eichelberger
 */
public class ConstraintBaseTest extends ConstraintListTest {

    /**
     * Tests the constraint base, only the specific operations.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testConstraintBase1() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Constraint first = createTestConstraint(1);
        Constraint second = createTestConstraint(2);
        Constraint third = createTestConstraint(3);

        // test add/contains
        ConstraintBase base = new ConstraintBase();
        base.add(first);
        base.add(second);
        base.add(third);
        Assert.assertTrue(base.contains(first));
        Assert.assertTrue(base.contains(second));
        Assert.assertTrue(base.contains(third));
        
        // test remove/contains
        base.removeFirst();
        base.removeLast();
        Assert.assertFalse(base.contains(first));
        Assert.assertTrue(base.contains(second));
        Assert.assertFalse(base.contains(third));
        base.removeFirst();
        Assert.assertFalse(base.contains(first));
        Assert.assertFalse(base.contains(second));
        Assert.assertFalse(base.contains(third));
        assertEmptyList(base);

        assertEmptyList(base);
        base.add(first);
        base.add(second);
        base.add(third);

        // test removeAll/contains
        List<Constraint> constraints = new ArrayList<Constraint>();
        constraints.add(second);
        constraints.add(third);
        base.removeAll(constraints);
        Assert.assertTrue(base.contains(first));
        Assert.assertFalse(base.contains(second));
        Assert.assertFalse(base.contains(third));
        constraints.clear();
        constraints.add(second);
        constraints.add(first);
        base.removeAll(constraints);
        assertEmptyList(base);
        
        // test clear/contains
        base.add(first);
        base.add(second);
        Assert.assertTrue(base.contains(first));
        Assert.assertTrue(base.contains(second));
        base.clear();
        Assert.assertFalse(base.contains(first));
        Assert.assertFalse(base.contains(second));
        Assert.assertFalse(base.contains(third));
    }

    /**
     * Tests the constraint base, only the specific operations.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testConstraintBase2() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Constraint first = createTestConstraint(1);
        Constraint second = createTestConstraint(2);
        Constraint third = createTestConstraint(3);

        ConstraintBase base = new ConstraintBase();
        base.addFirst(first);
        base.addFirst(second);
        base.addFirst(third);
        Assert.assertTrue(base.contains(first));
        Assert.assertTrue(base.contains(second));
        Assert.assertTrue(base.contains(third));
        
        base.removeFirst();
        base.removeLast();
        Assert.assertFalse(base.contains(first));
        Assert.assertTrue(base.contains(second));
        Assert.assertFalse(base.contains(third));
        
        ConstraintBase base2 = new ConstraintBase();
        base2.add(first);
        base2.add(third);
        base.addAll(base2, true);
        Assert.assertTrue(base.contains(first));
        Assert.assertTrue(base.contains(second));
        Assert.assertTrue(base.contains(third));
        assertEmptyList(base2);
    }
    
}
