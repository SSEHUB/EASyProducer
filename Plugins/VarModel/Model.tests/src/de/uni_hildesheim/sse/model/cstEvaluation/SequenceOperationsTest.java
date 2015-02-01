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
package de.uni_hildesheim.sse.model.cstEvaluation;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

/**
 * Tests the implemented sequence operations. Container iterators need to be tested on the level of the 
 * EvaluationVisitor.
 * 
 * @author Holger Eichelberger
 */
public class SequenceOperationsTest {

    /**
     * Tests the equals and the unequals operation for sequences.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype sequenceType = new Sequence("intSequence", IntegerType.TYPE, null);
        EvaluationAccessor set1 = Utils.createValue(sequenceType, context, 1, 2, 3, 4, 5);
        EvaluationAccessor set2 = Utils.createValue(sequenceType, context, 1, 2, 3, 4, 5);
        EvaluationAccessor set3 = Utils.createValue(sequenceType, context, 1, 2, 4, 5);
        EvaluationAccessor set4 = Utils.createValue(sequenceType, context, 2, 1, 3, 4, 5);
        EvaluationAccessor empty = Utils.createValue(sequenceType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.testEquals(true, Sequence.EQUALS, Sequence.UNEQUALS, set1, set1);
        Utils.testEquals(true, Sequence.EQUALS, Sequence.UNEQUALS, set1, set2);
        Utils.testEquals(true, Sequence.EQUALS, Sequence.UNEQUALS, set2, set2);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, set1, set3);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, set2, set3);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, set1, set4);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, set2, set4);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, empty, set1);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, empty, set2);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, empty, set3);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, empty, set4);
        Utils.testEquals(true, Sequence.EQUALS, Sequence.UNEQUALS, empty, empty);
        
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, nullV, empty);
        Utils.testEquals(false, Sequence.EQUALS, Sequence.UNEQUALS, nullV, set1);

        // null shall not happen through the visitor

        set1.release();
        set2.release();
        set3.release();
        set4.release();
        empty.release();
        nullV.release();
    }

    /**
     * Tests the size operation for sequences.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testSize() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype sequenceType = new Sequence("intSequence", IntegerType.TYPE, null);
        Object[] sequence1Data = new Object[] {1, 2, 3, 4, 5};
        EvaluationAccessor sequence1 = Utils.createValue(sequenceType, context, sequence1Data);
        EvaluationAccessor empty = Utils.createValue(sequenceType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);

        Utils.assertEquals(sequence1Data.length, Utils.evaluate(Sequence.SIZE, sequence1));
        Utils.assertEquals(0, Utils.evaluate(Sequence.SIZE, empty));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.SIZE, nullV));
        
        sequence1.release();
        empty.release();
        nullV.release();
    }

    /**
     * Tests the array accecss operation for sequences.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAccess() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype sequenceType = new Sequence("intSequence", IntegerType.TYPE, null);
        Object[] sequence1Data = new Object[] {1, 2, 3, 4, 5};
        EvaluationAccessor sequence1 = Utils.createValue(sequenceType, context, sequence1Data);
        EvaluationAccessor empty = Utils.createValue(sequenceType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        EvaluationAccessor i0 = Utils.createValue(IntegerType.TYPE, context, -1);
        EvaluationAccessor i1 = Utils.createValue(IntegerType.TYPE, context, 0);
        EvaluationAccessor i2 = Utils.createValue(IntegerType.TYPE, context, 3);
        EvaluationAccessor i3 = Utils.createValue(IntegerType.TYPE, context, 5);
        
        Utils.assertEquals((Integer) sequence1Data[0], Utils.evaluate(Sequence.AT, sequence1, i1));
        Utils.assertEquals((Integer) sequence1Data[3], Utils.evaluate(Sequence.AT, sequence1, i2));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, sequence1, i0));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, sequence1, i3));

        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, empty, i0));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, empty, i1));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, empty, i2));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, empty, i3));

        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, nullV, i0));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, nullV, i1));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, nullV, i2));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.AT, nullV, i3));

        sequence1.release();
        empty.release();
        i0.release();
        i1.release();
        i2.release();
        i3.release();
        nullV.release();
    }

    /**
     * Tests the "add" operation for sequences.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAdd() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype sequenceType = new Sequence("intSequence", IntegerType.TYPE, null);
        Object[] sequence1Data = new Object[] {1, 2, 3, 4, 5};
        EvaluationAccessor sequence1 = Utils.createValue(sequenceType, context, sequence1Data);
        EvaluationAccessor empty = Utils.createValue(sequenceType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        EvaluationAccessor val6 = Utils.createValue(IntegerType.TYPE, context, 6);
        
        EvaluationAccessor result = Utils.evaluate(Sequence.ADD, sequence1, val6);
        Utils.assertEquals(6, result.getValue());
        Utils.assertContainer(new Object[]{1, 2, 3, 4, 5, 6}, sequence1.getValue());
        result.release();
        result = Utils.evaluate(Sequence.ADD, sequence1, val6);
        Utils.assertEquals(6, result.getValue());
        Utils.assertContainer(new Object[]{1, 2, 3, 4, 5, 6, 6}, sequence1.getValue());
        result.release();
        
        result = Utils.evaluate(Sequence.ADD, empty, val6);
        Utils.assertEquals(6, result.getValue());
        Utils.assertContainer(new Object[]{6}, empty.getValue());
        result.release();

        result = Utils.evaluate(Sequence.ADD, nullV, val6);
        Assert.assertNull(result);

        sequence1.release();
        empty.release();
        nullV.release();
        val6.release();
    }
    
    /**
     * Tests the first/last operations for sequences.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testFirstLast() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype sequenceType = new Sequence("intSequence", IntegerType.TYPE, null);
        Object[] sequence1Data = new Object[] {1, 2, 3, 4, 5};
        EvaluationAccessor sequence1 = Utils.createValue(sequenceType, context, sequence1Data);
        EvaluationAccessor empty = Utils.createValue(sequenceType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.assertEquals((Integer) sequence1Data[0], Utils.evaluate(Sequence.FIRST, sequence1));
        Utils.assertEquals((Integer) sequence1Data[4], Utils.evaluate(Sequence.LAST, sequence1));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.FIRST, empty));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.LAST, empty));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.FIRST, nullV));
        Utils.assertEquals((Integer) null, Utils.evaluate(Sequence.LAST, nullV));

        sequence1.release();
        empty.release();
        nullV.release();
    }
    
    /**
     * Tests the is-defined operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testDefined() throws ValueDoesNotMatchTypeException {
        IDatatype sequenceType = new Sequence("intSequence", IntegerType.TYPE, null);
        Utils.testDefined(sequenceType, Sequence.IS_DEFINED, new Object[]{1, 100, 20});
    }

    /**
     * Tests the size operation for sequences.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAsSet() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setType = new Sequence("intSequence", IntegerType.TYPE, null);
        final Object[] set1Data = new Object[] {1, 2, 3, 1, 5};
        final Object[] expected = new Object[] {1, 2, 3, 5};
        EvaluationAccessor set1 = Utils.createValue(setType, context, set1Data);
        EvaluationAccessor empty = Utils.createValue(setType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = Set.AS_SET;

        Utils.assertContainer(expected, op, set1).release();
        Utils.assertContainer(new Object[]{}, op, empty).release();
        Utils.assertContainer(null, op, nullV);
        
        set1.release();
        empty.release();
        nullV.release();
    }

    /**
     * Tests the size operation for sequences.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAsSequence() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setType = new Sequence("intSequence", IntegerType.TYPE, null);
        final Object[] set1Data = new Object[] {1, 2, 3, 1, 5};
        EvaluationAccessor set1 = Utils.createValue(setType, context, set1Data);
        EvaluationAccessor empty = Utils.createValue(setType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = Set.AS_SEQUENCE;

        Utils.assertContainer(set1Data, op, set1).release();
        Utils.assertContainer(new Object[]{}, op, empty).release();
        Utils.assertContainer(null, op, nullV);
        
        set1.release();
        empty.release();
        nullV.release();
    }
    
    /**
     * Tests the MIN operation for sequences.    
     */
    @Test
    public void testMin() {
        Number[] values = {1, -3, 5, -4, 2, 5, -4, -3};
        String operation = OclKeyWords.MIN;
        ContainterOperationsUtils.assertUnaryConstraint(values, operation, -4, IntegerType.TYPE, false);
        
        Number[] values2 = {1.0, -3.0, 5, -4, 2, 5, -4, -3};
        ContainterOperationsUtils.assertUnaryConstraint(values2, operation, -4.0, RealType.TYPE, false);
        
        Number[] values3 = {1.0, -3.0, 5.0, -4, 2.0, 5.0, -4.0, -3.0};
        ContainterOperationsUtils.assertUnaryConstraint(values3, operation, -4.0, RealType.TYPE, false);
    }
    
    /**
     * Tests the MIN operation for sequences.    
     */
    @Test
    public void testMax() {
        Number[] values = {1, -3, 5, -4, 2, 5, -4, -3};
        String operation = OclKeyWords.MAX;
        ContainterOperationsUtils.assertUnaryConstraint(values, operation, 5, IntegerType.TYPE, false);
        
        Number[] values2 = {1.0, -3.0, 5, -4, 2, 5, -4, -3};
        ContainterOperationsUtils.assertUnaryConstraint(values2, operation, 5.0, RealType.TYPE, false);
        
        Number[] values3 = {1.0, -3.0, 5.0, -4, 2.0, 5.0, -4.0, -3.0};
        ContainterOperationsUtils.assertUnaryConstraint(values3, operation, 5.0, RealType.TYPE, false);
    }

    /**
     * Tests the "typeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqType = new Sequence("intSequence", IntegerType.TYPE, null);
        EvaluationAccessor value = Utils.createValue(seqType, context, new Object[]{1, 7, 9});
        Utils.testTypeOf(context, Sequence.TYPE_OF, value);
        value.release();
    }
    
    /**
     * Tests the "isTypeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIsTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqType = new Sequence("intSequence", IntegerType.TYPE, null);
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor value = Utils.createValue(seqType, context, new Object[]{1, 7, 9});
        Utils.testIsTypeKindOf(context, AnyType.IS_TYPE_OF, value, false, IntegerType.TYPE, 
            StringType.TYPE, Set.TYPE, Sequence.TYPE, setType);
        value.release();
    }

    /**
     * Tests the "isTypeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIsKindOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSequence", IntegerType.TYPE, null);
        IDatatype seqRealType = new Sequence("realSequence", RealType.TYPE, null);
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor intValue = Utils.createValue(seqIntType, context, new Object[]{1, 7, 9});
        EvaluationAccessor realValue = Utils.createValue(seqRealType, context, new Object[]{1, 7, 9});
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, intValue, false, IntegerType.TYPE, 
            StringType.TYPE, Sequence.TYPE, Set.TYPE, setType, seqRealType);
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, realValue, true, seqRealType, seqIntType);
        intValue.release();
        realValue.release();
    }
    
    /**
     * Tests the "union" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testUnion() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set1 = Utils.createValue(seqIntType, context, new Object[]{1, 7, 9});
        EvaluationAccessor set2 = Utils.createValue(seqIntType, context, new Object[]{7, 9, 13});
        Object[] expected = new Object[]{1, 7, 9, 7, 9, 13};
        Utils.assertContainer(expected, Sequence.UNION, set1, set2);
        EvaluationAccessor empty = Utils.createValue(seqIntType, context, new Object[]{});
        Utils.assertContainer(new Object[]{1, 7, 9}, Sequence.UNION, set1, empty);
        Utils.assertContainer(new Object[]{7, 9, 13}, Sequence.UNION, empty, set2);
        Utils.assertContainer(new Object[]{}, Sequence.UNION, empty, empty);
        set1.release();
        set2.release();
        empty.release();
    }

    /**
     * Tests the "append" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAppend() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(seqIntType, context, new Object[]{1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 11);
        Object[] expected = new Object[]{1, 7, 9, 10, 4, 11}; // here sequence is assumed... for now
        Utils.assertContainer(expected, Sequence.APPEND, set, value).release();
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[]{});
        Utils.assertContainer(new Object[]{11}, Sequence.APPEND, set, value).release();
        set.release();
        value.release();
    }

    /**
     * Tests the "prepend" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testPrepend() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(seqIntType, context, new Object[]{1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 11);
        Object[] expected = new Object[]{11, 1, 7, 9, 10, 4}; // here sequence is assumed... for now
        Utils.assertContainer(expected, Sequence.PREPEND, set, value);
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[]{});
        Utils.assertContainer(new Object[]{11}, Sequence.PREPEND, set, value);
        set.release();
        value.release();
    }

    /**
     * Tests the "insertAt" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testInsertAt() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(seqIntType, context, new Object[]{1, 7, 9, 10, 4});
        EvaluationAccessor index0 = Utils.createValue(IntegerType.TYPE, context, 0);
        EvaluationAccessor index4 = Utils.createValue(IntegerType.TYPE, context, 4);
        EvaluationAccessor index7 = Utils.createValue(IntegerType.TYPE, context, 7);
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 11);
        EvaluationAccessor result = Utils.assertContainer(
            new Object[]{11, 1, 7, 9, 10, 4}, Sequence.INSERT_AT, set, index0, value);
        result = Utils.assertContainer(
            new Object[]{11, 1, 7, 9, 11, 10, 4}, Sequence.INSERT_AT, result, index4, value);
        result = Utils.assertContainer(
            new Object[]{11, 1, 7, 9, 11, 10, 4, 11}, Sequence.INSERT_AT, result, index7, value);
        result = Utils.assertContainer(
            new Object[]{11, 11, 1, 7, 9, 11, 10, 4, 11}, Sequence.INSERT_AT, result, index0, value);
        result.release();
        set.release();
        index4.release();
        index7.release();
        set = Utils.createValue(seqIntType, context, new Object[]{});
        result = Utils.assertContainer(
            new Object[]{11}, Sequence.INSERT_AT, set, index0, value);
        index0.release();
        value.release();
        result.release();
    }

    /**
     * Tests the "hasDuplicates" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testHasDuplicates() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(seqIntType, context, new Object[]{1, 7, 9, 10, 4});
        Utils.assertEquals(false, Utils.evaluate(Sequence.HAS_DUPLICATES, set));
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[]{1, 9, 7, 9, 10, 4});
        Utils.assertEquals(true, Utils.evaluate(Sequence.HAS_DUPLICATES, set));
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[]{});
        Utils.assertEquals(false, Utils.evaluate(Sequence.HAS_DUPLICATES, set));
        set.release();
    }

    /**
     * Tests the "hasDuplicates" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIndexOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(seqIntType, context, new Object[]{1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 7);
        Utils.assertEquals(1, Utils.evaluate(Sequence.INDEX_OF, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, 10);
        Utils.assertEquals(3, Utils.evaluate(Sequence.INDEX_OF, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, 15);
        Utils.assertEquals(-1, Utils.evaluate(Sequence.INDEX_OF, set, value));
        value.release();
        set.release();

        value = Utils.createValue(IntegerType.TYPE, context, -1);
        set = Utils.createValue(seqIntType, context, new Object[]{});
        Utils.assertEquals(-1, Utils.evaluate(Sequence.INDEX_OF, set, value));
        value.release();
        set.release();
    }
    
    /**
     * Tests the "sum" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testSum() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        ArrayList<Integer> data = new ArrayList<Integer>();
        Collections.addAll(data, 1, 7, 9, 10, 4);
        int sum = 0;
        for (int d : data) {
            sum += d;
        }
        EvaluationAccessor set = Utils.createValue(seqIntType, context, data.toArray());
        Utils.assertEquals(sum, Utils.evaluate(Sequence.SUM, set));
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[]{});
        Utils.assertEquals(0, Utils.evaluate(Sequence.SUM, set));
        set.release();
        
        IDatatype seqRealType = new Sequence("realSeq", RealType.TYPE, null);
        ArrayList<Double> dataD = new ArrayList<Double>();
        Collections.addAll(dataD, 1.7, 7.2, 9.3, 10.4, 4.1);
        double sumD = 0;
        for (double d : dataD) {
            sumD += d;
        }
        EvaluationAccessor setD = Utils.createValue(seqRealType, context, dataD.toArray());
        Utils.assertEquals(sumD, Utils.evaluate(Sequence.SUM, setD));
        setD.release();
        setD = Utils.createValue(seqRealType, context, new Object[]{});
        Utils.assertEquals(0.0, Utils.evaluate(Sequence.SUM, setD));
        setD.release();
    }

    /**
     * Tests the "product" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testProduct() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        ArrayList<Integer> data = new ArrayList<Integer>();
        Collections.addAll(data, 1, 7, 9, 10, 4);
        int sum = 0;
        for (int d : data) {
            sum *= d;
        }
        EvaluationAccessor set = Utils.createValue(seqIntType, context, data.toArray());
        Utils.assertEquals(sum, Utils.evaluate(Sequence.PRODUCT, set));
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[]{});
        Utils.assertEquals(0, Utils.evaluate(Sequence.PRODUCT, set));
        set.release();
        
        IDatatype seqRealType = new Sequence("realSeq", RealType.TYPE, null);
        ArrayList<Double> dataD = new ArrayList<Double>();
        Collections.addAll(dataD, 1.7, 7.2, 9.3, 10.4, 4.1);
        double sumD = 0;
        for (double d : dataD) {
            sumD *= d;
        }
        EvaluationAccessor setD = Utils.createValue(seqRealType, context, dataD.toArray());
        Utils.assertEquals(sumD, Utils.evaluate(Sequence.PRODUCT, setD));
        setD.release();
        setD = Utils.createValue(seqRealType, context, new Object[]{});
        Utils.assertEquals(0.0, Utils.evaluate(Sequence.PRODUCT, setD));
        setD.release();
    }
    
    /**
     * Tests the "avg" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAvg() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        ArrayList<Integer> data = new ArrayList<Integer>();
        Collections.addAll(data, 1, 7, 9, 10, 4);
        int sum = 0;
        for (int d : data) {
            sum *= d;
        }
        sum /= data.size();
        EvaluationAccessor set = Utils.createValue(seqIntType, context, data.toArray());
        Utils.assertEquals(sum, Utils.evaluate(Sequence.PRODUCT, set));
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[]{});
        Utils.assertEquals(0, Utils.evaluate(Sequence.PRODUCT, set));
        set.release();
        
        IDatatype seqRealType = new Sequence("realSeq", RealType.TYPE, null);
        ArrayList<Double> dataD = new ArrayList<Double>();
        Collections.addAll(dataD, 1.7, 7.2, 9.3, 10.4, 4.1);
        double sumD = 0;
        for (double d : dataD) {
            sumD *= d;
        }
        sumD /= dataD.size();
        EvaluationAccessor setD = Utils.createValue(seqRealType, context, dataD.toArray());
        Utils.assertEquals(sumD, Utils.evaluate(Sequence.PRODUCT, setD));
        setD.release();
        setD = Utils.createValue(seqRealType, context, new Object[]{});
        Utils.assertEquals(0.0, Utils.evaluate(Sequence.PRODUCT, setD));
        setD.release();
    }

    /**
     * Tests the "Includes" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIncludes() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(seqIntType, context, new Object[] {1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 10);
        Utils.assertEquals(true, Utils.evaluate(Sequence.INCLUDES, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.assertEquals(true, Utils.evaluate(Sequence.INCLUDES, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, -1);
        Utils.assertEquals(false, Utils.evaluate(Sequence.INCLUDES, set, value));
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[] {});
        Utils.assertEquals(false, Utils.evaluate(Sequence.INCLUDES, set, value));
        set.release();
        value.release();
    }

    /**
     * Tests the "excludes" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testExcludes() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(seqIntType, context, new Object[] {1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 10);
        Utils.assertEquals(false, Utils.evaluate(Sequence.EXCLUDES, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.assertEquals(false, Utils.evaluate(Sequence.EXCLUDES, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, -1);
        Utils.assertEquals(true, Utils.evaluate(Sequence.EXCLUDES, set, value));
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[] {});
        Utils.assertEquals(true, Utils.evaluate(Sequence.EXCLUDES, set, value));
        set.release();
        value.release();
    }

    /**
     * Tests the "count" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testCount() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype seqIntType = new Sequence("intSeq", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(seqIntType, context, new Object[] {1, 7, 9, 10, 1, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 10);
        Utils.assertEquals(1, Utils.evaluate(Sequence.COUNT, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.assertEquals(2, Utils.evaluate(Sequence.COUNT, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, -1);
        Utils.assertEquals(0, Utils.evaluate(Sequence.COUNT, set, value));
        set.release();
        set = Utils.createValue(seqIntType, context, new Object[] {});
        Utils.assertEquals(0, Utils.evaluate(Sequence.COUNT, set, value));
        set.release();
        value.release();
    }
    
    // Container iterators need to be tested on the level of the EvaluationVisitor!

}
