/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Test;

import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.VersionType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Tests the implemented version operations.
 * 
 * @author Holger Eichelberger
 */
public class VersionOperationsTest {
    
    /**
     * Tests the equals and the unequals operation for integers.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor v12 = Utils.createValue(VersionType.TYPE, context, "1.2");
        EvaluationAccessor v23 = Utils.createValue(VersionType.TYPE, context, "2.3");
        EvaluationAccessor v0 = Utils.createValue(VersionType.TYPE, context, "0");
        
        Utils.testEquals(true, VersionType.EQUALS, VersionType.UNEQUALS, v12, v12);
        Utils.testEquals(true, VersionType.EQUALS, VersionType.UNEQUALS, v23, v23);
        Utils.testEquals(true, VersionType.EQUALS, VersionType.UNEQUALS, v0, v0);
        Utils.testEquals(false, VersionType.EQUALS, VersionType.UNEQUALS, v0, v12);
        Utils.testEquals(false, VersionType.EQUALS, VersionType.UNEQUALS, v0, v23);
        Utils.testEquals(false, VersionType.EQUALS, VersionType.UNEQUALS, v12, v23);
        
        v12.release();
        v23.release();
        v0.release();
    }

    /**
     * Tests the evaluation of (constant) Greater operations.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testGreater() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        Operation op = VersionType.GREATER;
       
        EvaluationAccessor v11 = Utils.createValue(VersionType.TYPE, context, "1.1");
        EvaluationAccessor v12 = Utils.createValue(VersionType.TYPE, context, "1.2");
        EvaluationAccessor v23 = Utils.createValue(VersionType.TYPE, context, "2.3");
        EvaluationAccessor v0 = Utils.createValue(VersionType.TYPE, context, "0");
        
        Utils.assertEquals(false, Utils.evaluate(op, v12, v12));
        Utils.assertEquals(false, Utils.evaluate(op, v12, v23));
        Utils.assertEquals(false, Utils.evaluate(op, v11, v12));
        Utils.assertEquals(true, Utils.evaluate(op, v12, v11));
        Utils.assertEquals(true, Utils.evaluate(op, v23, v12));
        Utils.assertEquals(true, Utils.evaluate(op, v23, v0));
        Utils.assertEquals(true, Utils.evaluate(op, v12, v0));
        Utils.assertEquals(false, Utils.evaluate(op, v0, v0));
        Utils.assertEquals(false, Utils.evaluate(op, v0, v12));
        Utils.assertEquals(false, Utils.evaluate(op, v0, v23));

        v11.release();
        v12.release();
        v23.release();
        v0.release();
    }
    
    /**
     * Tests the evaluation of (constant) Greater or Equal operations.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testGreaterEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        Operation op = VersionType.GREATER_EQUALS;
       
        EvaluationAccessor v11 = Utils.createValue(VersionType.TYPE, context, "1.1");
        EvaluationAccessor v12 = Utils.createValue(VersionType.TYPE, context, "1.2");
        EvaluationAccessor v23 = Utils.createValue(VersionType.TYPE, context, "2.3");
        EvaluationAccessor v0 = Utils.createValue(VersionType.TYPE, context, "0");
        
        Utils.assertEquals(true, Utils.evaluate(op, v12, v12));
        Utils.assertEquals(false, Utils.evaluate(op, v12, v23));
        Utils.assertEquals(false, Utils.evaluate(op, v11, v12));
        Utils.assertEquals(true, Utils.evaluate(op, v12, v11));
        Utils.assertEquals(true, Utils.evaluate(op, v23, v12));
        Utils.assertEquals(true, Utils.evaluate(op, v23, v0));
        Utils.assertEquals(true, Utils.evaluate(op, v12, v0));
        Utils.assertEquals(true, Utils.evaluate(op, v0, v0));
        Utils.assertEquals(false, Utils.evaluate(op, v0, v12));
        Utils.assertEquals(false, Utils.evaluate(op, v0, v23));

        v11.release();
        v12.release();
        v23.release();
        v0.release();
    }
    
    /**
     * Tests the evaluation of (constant) Less operations.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testLess() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        Operation op = VersionType.LESS;
       
        EvaluationAccessor v11 = Utils.createValue(VersionType.TYPE, context, "1.1");
        EvaluationAccessor v12 = Utils.createValue(VersionType.TYPE, context, "1.2");
        EvaluationAccessor v23 = Utils.createValue(VersionType.TYPE, context, "2.3");
        EvaluationAccessor v0 = Utils.createValue(VersionType.TYPE, context, "0");
        
        Utils.assertEquals(false, Utils.evaluate(op, v12, v12));
        Utils.assertEquals(true, Utils.evaluate(op, v12, v23));
        Utils.assertEquals(true, Utils.evaluate(op, v11, v12));
        Utils.assertEquals(false, Utils.evaluate(op, v12, v11));
        Utils.assertEquals(false, Utils.evaluate(op, v23, v12));
        Utils.assertEquals(false, Utils.evaluate(op, v23, v0));
        Utils.assertEquals(false, Utils.evaluate(op, v12, v0));
        Utils.assertEquals(false, Utils.evaluate(op, v0, v0));
        Utils.assertEquals(true, Utils.evaluate(op, v0, v12));
        Utils.assertEquals(true, Utils.evaluate(op, v0, v23));

        v11.release();
        v12.release();
        v23.release();
        v0.release();
    }
    
    /**
     * Tests the evaluation of (constant) Less or Equal operations.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testLessEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        Operation op = VersionType.LESS_EQUALS;
       
        EvaluationAccessor v11 = Utils.createValue(VersionType.TYPE, context, "1.1");
        EvaluationAccessor v12 = Utils.createValue(VersionType.TYPE, context, "1.2");
        EvaluationAccessor v23 = Utils.createValue(VersionType.TYPE, context, "2.3");
        EvaluationAccessor v0 = Utils.createValue(VersionType.TYPE, context, "0");
        
        Utils.assertEquals(true, Utils.evaluate(op, v12, v12));
        Utils.assertEquals(true, Utils.evaluate(op, v12, v23));
        Utils.assertEquals(true, Utils.evaluate(op, v11, v12));
        Utils.assertEquals(false, Utils.evaluate(op, v12, v11));
        Utils.assertEquals(false, Utils.evaluate(op, v23, v12));
        Utils.assertEquals(false, Utils.evaluate(op, v23, v0));
        Utils.assertEquals(false, Utils.evaluate(op, v12, v0));
        Utils.assertEquals(true, Utils.evaluate(op, v0, v0));
        Utils.assertEquals(true, Utils.evaluate(op, v0, v12));
        Utils.assertEquals(true, Utils.evaluate(op, v0, v23));

        v11.release();
        v12.release();
        v23.release();
        v0.release();
    }
    
}
