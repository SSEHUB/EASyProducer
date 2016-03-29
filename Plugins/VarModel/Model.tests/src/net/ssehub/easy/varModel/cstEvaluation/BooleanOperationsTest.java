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

import net.ssehub.easy.varModel.cstEvaluation.EvaluationAccessor;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Tests the implemented boolean operations.
 * 
 * @author Holger Eichelberger
 */
public class BooleanOperationsTest {

    /**
     * Tests the equals and the unequals operation for booleans.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor bTrue = Utils.createValue(BooleanType.TYPE, context, true);
        EvaluationAccessor bFalse = Utils.createValue(BooleanType.TYPE, context, false);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.testEquals(true, BooleanType.EQUALS, BooleanType.UNEQUALS, bTrue, bTrue);
        Utils.testEquals(true, BooleanType.EQUALS, BooleanType.UNEQUALS, bFalse, bFalse);
        Utils.testEquals(false, BooleanType.EQUALS, BooleanType.UNEQUALS, bTrue, bFalse);
        Utils.testEquals(false, BooleanType.EQUALS, BooleanType.UNEQUALS, nullV, bFalse);

        bTrue.release();
        bFalse.release();
        nullV.release();
    }
    
    /**
     * Tests the is-defined operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testDefined() throws ValueDoesNotMatchTypeException {
        Utils.testDefined(BooleanType.TYPE, BooleanType.IS_DEFINED, true);
    }

    /**
     * Tests the Boolean negation function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testNot() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor bTrue = Utils.createValue(BooleanType.TYPE, context, true);
        EvaluationAccessor bFalse = Utils.createValue(BooleanType.TYPE, context, false);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = BooleanType.NOT;

        Utils.assertEquals(false, Utils.evaluate(op, bTrue));
        Utils.assertEquals(true, Utils.evaluate(op, bFalse));
        Utils.assertEquals((Boolean) null, Utils.evaluate(op, nullV));
        
        bTrue.release();
        bFalse.release();
        nullV.release();
    }
    
    /**
     * Tests a Boolean binary operation.
     * 
     * @param op the operation to be tested
     * @param expected the expected values for <code>true</code> <i>op</i> <code>true</code>,
     *   <code>true</code> <i>op</i> <code>false</code>, <code>false</code> <i>op</i> <code>true</code>,
     *   <code>false</code> <i>op</i> <code>false</code> (further also operation against IVML null are
     *   tested)
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    private static void assertBooleanBinary(Operation op, Boolean[] expected) throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor bTrue = Utils.createValue(BooleanType.TYPE, context, true);
        EvaluationAccessor bFalse = Utils.createValue(BooleanType.TYPE, context, false);
        EvaluationAccessor nullV = Utils.createNullValue(context);

        Utils.assertEquals(expected[0], Utils.evaluate(op, bTrue, bTrue));
        Utils.assertEquals(expected[1], Utils.evaluate(op, bTrue, bFalse));
        Utils.assertEquals(expected[2], Utils.evaluate(op, bFalse, bTrue));
        Utils.assertEquals(expected[3], Utils.evaluate(op, bFalse, bFalse));
        Utils.assertEquals((Boolean) null, Utils.evaluate(op, bFalse, nullV));
        Utils.assertEquals((Boolean) null, Utils.evaluate(op, nullV, bTrue));
        
        bTrue.release();
        bFalse.release();
        nullV.release();
    }
    
    /**
     * Tests the Boolean "and" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAnd() throws ValueDoesNotMatchTypeException {
        assertBooleanBinary(BooleanType.AND, new Boolean[]{true, false, false, false});
    }

    /**
     * Tests the Boolean "or" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testOr() throws ValueDoesNotMatchTypeException {
        assertBooleanBinary(BooleanType.OR, new Boolean[]{true, true, true, false});
    }

    /**
     * Tests the Boolean "xor" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testXor() throws ValueDoesNotMatchTypeException {
        assertBooleanBinary(BooleanType.XOR, new Boolean[]{false, true, true, false});
    }

    /**
     * Tests the Boolean "implies" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testImplies() throws ValueDoesNotMatchTypeException {
        assertBooleanBinary(BooleanType.IMPLIES, new Boolean[]{true, false, true, true});
    }

    /**
     * Tests the Boolean "iff" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIff() throws ValueDoesNotMatchTypeException {
        assertBooleanBinary(BooleanType.IFF, new Boolean[]{true, false, false, true});
    }

    /**
     * Tests the "typeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor bValue = Utils.createValue(BooleanType.TYPE, context, true);
        Utils.testTypeOf(context, BooleanType.TYPE_OF, bValue);
        bValue.release();
    }

    /**
     * Tests the "isTypeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIsTypeOf() throws ValueDoesNotMatchTypeException {
        testTypeKindOf(AnyType.IS_TYPE_OF);
    }

    /**
     * Tests the "isTypeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIsKindOf() throws ValueDoesNotMatchTypeException {
        testTypeKindOf(AnyType.IS_KIND_OF);
    }
    
    /**
     * Tests kind/type of as we do not have to consider type inheritance relations.
     * 
     * @param op the actual operation to be considered
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    private static void testTypeKindOf(Operation op) throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor value = Utils.createValue(BooleanType.TYPE, context, true);
        Utils.testIsTypeKindOf(context, op, value, false, IntegerType.TYPE, RealType.TYPE, StringType.TYPE);
        value.release();
    }

}
