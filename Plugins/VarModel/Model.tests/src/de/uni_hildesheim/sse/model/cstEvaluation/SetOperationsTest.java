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
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Tests the implemented set operations. Container iterators need to be tested on the level of the 
 * EvaluationVisitor.
 * 
 * @author Holger Eichelberger
 */
public class SetOperationsTest {

    /**
     * Tests the equals and the unequals operation for sets.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor set1 = Utils.createValue(setType, context, 1, 2, 3, 4, 5);
        EvaluationAccessor set2 = Utils.createValue(setType, context, 5, 4, 3, 2, 1);
        EvaluationAccessor set3 = Utils.createValue(setType, context, 1, 2, 4, 5);
        EvaluationAccessor empty = Utils.createValue(setType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.testEquals(true, Set.EQUALS, Set.UNEQUALS, set1, set1);
        Utils.testEquals(true, Set.EQUALS, Set.UNEQUALS, set1, set2);
        Utils.testEquals(true, Set.EQUALS, Set.UNEQUALS, set2, set2);
        Utils.testEquals(false, Set.EQUALS, Set.UNEQUALS, set1, set3);
        Utils.testEquals(false, Set.EQUALS, Set.UNEQUALS, set2, set3);
        Utils.testEquals(false, Set.EQUALS, Set.UNEQUALS, empty, set1);
        Utils.testEquals(false, Set.EQUALS, Set.UNEQUALS, empty, set2);
        Utils.testEquals(false, Set.EQUALS, Set.UNEQUALS, empty, set3);
        Utils.testEquals(true, Set.EQUALS, Set.UNEQUALS, empty, empty);

        Utils.testEquals(false, Set.EQUALS, Set.UNEQUALS, nullV, empty);
        Utils.testEquals(false, Set.EQUALS, Set.UNEQUALS, nullV, set1);

        // null shall not happen through the visitor

        set1.release();
        set2.release();
        set3.release();
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
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        Object[] set1Data = new Object[] {1, 2, 3, 4, 5};
        EvaluationAccessor set1 = Utils.createValue(setType, context, set1Data);
        EvaluationAccessor empty = Utils.createValue(setType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);

        Utils.assertEquals(set1Data.length, Utils.evaluate(Set.SIZE, set1));
        Utils.assertEquals(0, Utils.evaluate(Set.SIZE, empty));
        Utils.assertEquals((Integer) null, Utils.evaluate(Set.SIZE, nullV));
        
        set1.release();
        empty.release();
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
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        Object[] set1Data = new Object[] {1, 2, 3, 4, 5};
        EvaluationAccessor set1 = Utils.createValue(setType, context, set1Data);
        EvaluationAccessor empty = Utils.createValue(setType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        EvaluationAccessor val6 = Utils.createValue(IntegerType.TYPE, context, 6);
        
        EvaluationAccessor result = Utils.evaluate(Sequence.ADD, set1, val6);
        Utils.assertEquals(6, result.getValue());
        Utils.assertContainer(new Object[]{1, 2, 3, 4, 5, 6}, set1.getValue());
        result.release();
        result = Utils.evaluate(Sequence.ADD, set1, val6);
        Utils.assertEquals(6, result.getValue());
        Utils.assertContainer(new Object[]{1, 2, 3, 4, 5, 6}, set1.getValue());
        result.release();
        
        result = Utils.evaluate(Sequence.ADD, empty, val6);
        Utils.assertEquals(6, result.getValue());
        Utils.assertContainer(new Object[]{6}, empty.getValue());
        result.release();

        result = Utils.evaluate(Sequence.ADD, nullV, val6);
        Assert.assertNull(result);

        set1.release();
        empty.release();
        nullV.release();
        val6.release();
    }

    /**
     * Tests the is-defined operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testDefined() throws ValueDoesNotMatchTypeException {
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        Utils.testDefined(setType, Set.IS_DEFINED, new Object[]{1, 101, 20});
    }

    /**
     * Tests the size operation for sets.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAsSet() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        final Object[] set1Data = new Object[] {1, 2, 3, 5};
        EvaluationAccessor set1 = Utils.createValue(setType, context, set1Data);
        EvaluationAccessor empty = Utils.createValue(setType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = Set.AS_SET;

        Utils.assertContainer(set1Data, op, set1);
        Utils.assertContainer(new Object[]{}, op, empty);
        Utils.assertContainer(null, op, nullV);
        
        set1.release();
        empty.release();
        nullV.release();
    }

    /**
     * Tests the size operation for sets.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAsSequence() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        final Object[] set1Data = new Object[] {1, 2, 3, 5};
        EvaluationAccessor set1 = Utils.createValue(setType, context, set1Data);
        EvaluationAccessor empty = Utils.createValue(setType, context);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = Set.AS_SEQUENCE;

        Utils.assertContainer(set1Data, op, set1);
        Utils.assertContainer(new Object[]{}, op, empty);
        Utils.assertContainer(null, op, nullV);
        
        set1.release();
        empty.release();
        nullV.release();
    }
    
    /**
     * Tests the MIN operation for sets.    
     */
    @Test
    public void testMin() {
        Number[] values = {1, -3, 5, -4, 2};
        String operation = OclKeyWords.MIN;
        ContainterOperationsUtils.assertUnaryConstraint(values, operation, -4, IntegerType.TYPE, true);
        
        Number[] values2 = {1.0, -3.0, 5, -4, 2};
        ContainterOperationsUtils.assertUnaryConstraint(values2, operation, -4.0, RealType.TYPE, true);
        
        Number[] values3 = {1.0, -3.0, 5d, -4, 2d};
        ContainterOperationsUtils.assertUnaryConstraint(values3, operation, -4.0, RealType.TYPE, true);
    }
    
    /**
     * Tests the MAX operation for sets.    
     */
    @Test
    public void testMax() {
        Number[] values = {1, -3, 5, -4, 2};
        String operation = OclKeyWords.MAX;
        ContainterOperationsUtils.assertUnaryConstraint(values, operation, 5, IntegerType.TYPE, true);
        
        Number[] values2 = {1.0, -3.0, 5, -4, 2};
        ContainterOperationsUtils.assertUnaryConstraint(values2, operation, 5.0, RealType.TYPE, true);
        
        Number[] values3 = {1.0, -3.0, 5d, -4, 2d};
        ContainterOperationsUtils.assertUnaryConstraint(values3, operation, 5.0, RealType.TYPE, true);
    }

    /**
     * Tests the "typeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor value = Utils.createValue(setType, context, new Object[]{1, 7, 9});
        Utils.testTypeOf(context, Set.TYPE_OF, value);
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
        IDatatype setType = new Set("intSet", IntegerType.TYPE, null);
        IDatatype sequenceType = new Sequence("intSet", IntegerType.TYPE, null);
        EvaluationAccessor value = Utils.createValue(setType, context, new Object[]{1, 7, 9});
        Utils.testIsTypeKindOf(context, AnyType.IS_TYPE_OF, value, false, IntegerType.TYPE, 
            StringType.TYPE, Set.TYPE, Sequence.TYPE, sequenceType);
        value.release();
    }

    /**
     * Tests the "isKindOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIsKindOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        IDatatype setRealType = new Set("realSet", RealType.TYPE, null);
        IDatatype sequenceType = new Sequence("intSet", IntegerType.TYPE, null);
        EvaluationAccessor intValue = Utils.createValue(setIntType, context, new Object[]{1, 7, 9});
        EvaluationAccessor realValue = Utils.createValue(setRealType, context, new Object[]{1.2, 7.7, 1.4});
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, intValue, false, IntegerType.TYPE, 
            StringType.TYPE, Sequence.TYPE, Set.TYPE, sequenceType, setRealType);
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, realValue, true, setRealType, setIntType);
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
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor set1 = Utils.createValue(setIntType, context, new Object[]{1, 7, 9});
        EvaluationAccessor set2 = Utils.createValue(setIntType, context, new Object[]{7, 9, 13});
        EvaluationAccessor empty = Utils.createValue(setIntType, context, new Object[]{});
        Object[] expected = new Object[]{1, 7, 9, 13}; // here sequence is assumed... for now
        Utils.assertContainer(expected, Set.UNION, set1, set2);
        Utils.assertContainer(new Object[]{1, 7, 9}, Set.UNION, set1, empty);
        Utils.assertContainer(new Object[]{7, 9, 13}, Set.UNION, empty, set2);
        Utils.assertContainer(new Object[]{}, Set.UNION, empty, empty);
        set1.release();
        set2.release();
        empty.release();
    }

    /**
     * Tests the "intersection" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIntersection() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor set1 = Utils.createValue(setIntType, context, new Object[]{1, 7, 9});
        EvaluationAccessor set2 = Utils.createValue(setIntType, context, new Object[]{7, 9, 13});
        EvaluationAccessor empty = Utils.createValue(setIntType, context, new Object[]{});
        Object[] expected = new Object[]{7, 9}; // here sequence is assumed... for now
        Utils.assertContainer(expected, Set.INTERSECTION, set1, set2);
        Utils.assertContainer(new Object[]{}, Set.INTERSECTION, set1, empty);
        Utils.assertContainer(new Object[]{}, Set.INTERSECTION, empty, set2);
        Utils.assertContainer(new Object[]{}, Set.INTERSECTION, empty, empty);
        set1.release();
        set2.release();
        empty.release();
    }

    /**
     * Tests the "excluding" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testExcluding() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(setIntType, context, new Object[]{1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 10);
        Object[] expected = new Object[]{1, 7, 9, 4}; // here sequence is assumed... for now
        Utils.assertContainer(expected, Set.EXCLUDING, set, value);
        set.release();

        set = Utils.createValue(setIntType, context, new Object[]{});
        Utils.assertContainer(new Object[]{}, Set.EXCLUDING, set, value);
        set.release();
        value.release();
    }

    /**
     * Tests the "including" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIncluding() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(setIntType, context, new Object[]{1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 11);
        Object[] expected = new Object[]{1, 7, 9, 10, 4, 11}; // here sequence is assumed... for now
        Utils.assertContainer(expected, Set.INCLUDING, set, value);
        set.release();
        
        set = Utils.createValue(setIntType, context, new Object[]{});
        Utils.assertContainer(new Object[]{11}, Set.INCLUDING, set, value);
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
        IDatatype setIntType = new Set("setSeq", IntegerType.TYPE, null);
        ArrayList<Integer> data = new ArrayList<Integer>();
        Collections.addAll(data, 1, 6, 9, 11, 4);
        int sum = 0;
        for (int d : data) {
            sum += d;
        }
        EvaluationAccessor seq = Utils.createValue(setIntType, context, data.toArray());
        Utils.assertEquals(sum, Utils.evaluate(Set.SUM, seq));
        seq.release();
        seq = Utils.createValue(setIntType, context, new Object[]{});
        Utils.assertEquals(0, Utils.evaluate(Set.SUM, seq));
        seq.release();
        
        IDatatype setRealType = new Set("realSet", RealType.TYPE, null);
        ArrayList<Double> dataD = new ArrayList<Double>();
        Collections.addAll(dataD, 1.7, -7.2, 9.3, 10.4, 4.1);
        double sumD = 0;
        for (double d : dataD) {
            sumD += d;
        }
        EvaluationAccessor seqD = Utils.createValue(setRealType, context, dataD.toArray());
        Utils.assertEquals(sumD, Utils.evaluate(Set.SUM, seqD));
        seqD.release();
        seqD = Utils.createValue(setRealType, context, new Object[]{});
        Utils.assertEquals(0.0, Utils.evaluate(Set.SUM, seqD));
        seqD.release();
    }

    /**
     * Tests the "product" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testProduct() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setIntType = new Set("setSeq", IntegerType.TYPE, null);
        ArrayList<Integer> data = new ArrayList<Integer>();
        Collections.addAll(data, 1, 6, 9, 11, 4);
        int sum = 0;
        for (int d : data) {
            sum *= d;
        }
        EvaluationAccessor seq = Utils.createValue(setIntType, context, data.toArray());
        Utils.assertEquals(sum, Utils.evaluate(Set.PRODUCT, seq));
        seq.release();
        seq = Utils.createValue(setIntType, context, new Object[]{});
        Utils.assertEquals(0, Utils.evaluate(Set.PRODUCT, seq));
        seq.release();
        
        IDatatype setRealType = new Set("realSet", RealType.TYPE, null);
        ArrayList<Double> dataD = new ArrayList<Double>();
        Collections.addAll(dataD, 1.7, -7.2, 9.3, 10.4, 4.1);
        double sumD = 0;
        for (double d : dataD) {
            sumD *= d;
        }
        EvaluationAccessor seqD = Utils.createValue(setRealType, context, dataD.toArray());
        Utils.assertEquals(sumD, Utils.evaluate(Set.PRODUCT, seqD));
        seqD.release();
        seqD = Utils.createValue(setRealType, context, new Object[]{});
        Utils.assertEquals(0.0, Utils.evaluate(Set.PRODUCT, seqD));
        seqD.release();
    }

    /**
     * Tests the "avg" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAvg() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setIntType = new Set("setSeq", IntegerType.TYPE, null);
        ArrayList<Integer> data = new ArrayList<Integer>();
        Collections.addAll(data, 1, 6, 9, 11, 4);
        int sum = 0;
        for (int d : data) {
            sum *= d;
        }
        sum /= data.size();
        EvaluationAccessor seq = Utils.createValue(setIntType, context, data.toArray());
        Utils.assertEquals(sum, Utils.evaluate(Set.PRODUCT, seq));
        seq.release();
        seq = Utils.createValue(setIntType, context, new Object[]{});
        Utils.assertEquals(0, Utils.evaluate(Set.PRODUCT, seq));
        seq.release();
        
        IDatatype setRealType = new Set("realSet", RealType.TYPE, null);
        ArrayList<Double> dataD = new ArrayList<Double>();
        Collections.addAll(dataD, 1.7, -7.2, 9.3, 10.4, 4.1);
        double sumD = 0;
        for (double d : dataD) {
            sumD *= d;
        }
        sumD /= data.size();
        EvaluationAccessor seqD = Utils.createValue(setRealType, context, dataD.toArray());
        Utils.assertEquals(sumD, Utils.evaluate(Set.PRODUCT, seqD));
        seqD.release();
        seqD = Utils.createValue(setRealType, context, new Object[]{});
        Utils.assertEquals(0.0, Utils.evaluate(Set.PRODUCT, seqD));
        seqD.release();
    }
    
    /**
     * Tests the "Includes" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIncludes() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(setIntType, context, new Object[] {1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 10);
        Utils.assertEquals(true, Utils.evaluate(Set.INCLUDES, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.assertEquals(true, Utils.evaluate(Set.INCLUDES, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, -1);
        Utils.assertEquals(false, Utils.evaluate(Set.INCLUDES, set, value));
        set.release();
        set = Utils.createValue(setIntType, context, new Object[] {});
        Utils.assertEquals(false, Utils.evaluate(Set.INCLUDES, set, value));
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
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        EvaluationAccessor set = Utils.createValue(setIntType, context, new Object[] {1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 10);
        Utils.assertEquals(false, Utils.evaluate(Set.EXCLUDES, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.assertEquals(false, Utils.evaluate(Set.EXCLUDES, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, -1);
        Utils.assertEquals(true, Utils.evaluate(Set.EXCLUDES, set, value));
        set.release();
        set = Utils.createValue(setIntType, context, new Object[] {});
        Utils.assertEquals(true, Utils.evaluate(Set.EXCLUDES, set, value));
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
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        // no duplicates
        EvaluationAccessor set = Utils.createValue(setIntType, context, new Object[] {1, 7, 9, 10, 4});
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 10);
        Utils.assertEquals(1, Utils.evaluate(Set.COUNT, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.assertEquals(1, Utils.evaluate(Set.COUNT, set, value));
        value.release();
        value = Utils.createValue(IntegerType.TYPE, context, -1);
        Utils.assertEquals(0, Utils.evaluate(Set.COUNT, set, value));
        set.release();
        set = Utils.createValue(setIntType, context, new Object[] {});
        Utils.assertEquals(0, Utils.evaluate(Set.COUNT, set, value));
        set.release();
        value.release();
    }

    /**
     * Tests the "flatten" function.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testFlatten() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        IDatatype setIntType = new Set("intSet", IntegerType.TYPE, null);
        IDatatype setSetIntType = new Set("intSetSet", setIntType, null);
        Value inner1 = ValueFactory.createValue(setIntType, new Object[] {1, 7, 9, 10, 4});
        Value inner2 = ValueFactory.createValue(setIntType, new Object[] {3, 8, 9, 11, 4});
        EvaluationAccessor set = Utils.createValue(setSetIntType, context, new Object[] {inner1, inner2});
        EvaluationAccessor result = Utils.evaluate(Set.FLATTEN, set);
        Value resVal = ValueFactory.createValue(setIntType, new Object[] {1, 7, 9, 10, 4, 3, 8, 11});
        Assert.assertEquals(resVal, result.getValue());
        result.release();
        set.release();
        
        EvaluationAccessor set2 = Utils.createValue(setSetIntType, context, new Object[] {});
        Value resVal2 = ValueFactory.createValue(setIntType, new Object[] {});
        result = Utils.evaluate(Set.FLATTEN, set2);
        Assert.assertEquals(resVal2, result.getValue());
        result.release();
        set2.release();
    }

    // Container iterators need to be tested on the level of the EvaluationVisitor!

}
