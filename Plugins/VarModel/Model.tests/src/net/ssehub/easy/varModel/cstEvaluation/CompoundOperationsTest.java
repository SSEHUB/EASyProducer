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

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Tests the implemented compound operations.
 * 
 * @author Holger Eichelberger
 */
public class CompoundOperationsTest {

    /**
     * Tests the equals and unequals operation for compounds.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();

        Compound baseC = new Compound("base", null);
        baseC.add(new DecisionVariableDeclaration("test", IntegerType.TYPE, baseC));
        Compound refC = new Compound("ref", null, baseC);
        
        Value baseCVal = ValueFactory.createValue(baseC, new Object[]{"test", 1});
        Value refCVal = ValueFactory.createValue(refC, new Object[]{"test", 1});
        
        EvaluationAccessor val1 = Utils.createValue(baseC, context, baseCVal);
        EvaluationAccessor val2 = Utils.createValue(refC, context, refCVal);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.testEquals(true, ConstraintType.EQUALS, ConstraintType.UNEQUALS, val1, val1);
        Utils.testEquals(true, ConstraintType.EQUALS, ConstraintType.UNEQUALS, val2, val2);
        Utils.testEquals(false, ConstraintType.EQUALS, ConstraintType.UNEQUALS, val1, val2);
        Utils.testEquals(false, ConstraintType.EQUALS, ConstraintType.UNEQUALS, val2, val1);
        Utils.testEquals(false, ConstraintType.EQUALS, ConstraintType.UNEQUALS, val1, nullV);
        Utils.testEquals(false, ConstraintType.EQUALS, ConstraintType.UNEQUALS, val2, nullV);

        val1.release();
        val2.release();
        nullV.release();
    }

    /**
     * Tests the is-defined operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testDefined() throws ValueDoesNotMatchTypeException {
        Compound baseC = new Compound("base", null);
        baseC.add(new DecisionVariableDeclaration("test", IntegerType.TYPE, baseC));
        Value baseCVal = ValueFactory.createValue(baseC, new Object[]{"test", 1});
        Utils.testDefined(baseC, Compound.IS_DEFINED, baseCVal);
    }

    /**
     * Tests the "typeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        Compound baseC = new Compound("base", null);
        baseC.add(new DecisionVariableDeclaration("test", IntegerType.TYPE, baseC));
        Compound refC = new Compound("ref", null, baseC);
        Value baseCVal = ValueFactory.createValue(baseC, new Object[]{"test", 1});
        Value refCVal = ValueFactory.createValue(refC, new Object[]{"test", 1});
        EvaluationAccessor valBaseC = Utils.createValue(baseC, context, baseCVal);
        EvaluationAccessor valRefC = Utils.createValue(baseC, context, refCVal);
        
        Utils.testTypeOf(context, Compound.TYPE_OF, valBaseC);
        Utils.testTypeOf(context, Compound.TYPE_OF, valRefC);
        valBaseC.release();
        valRefC.release();
    }

    /**
     * Tests the "isTypeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIsTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        Compound baseC = new Compound("base", null);
        baseC.add(new DecisionVariableDeclaration("test", IntegerType.TYPE, baseC));
        Compound refC = new Compound("ref", null, baseC);
        
        Value baseCVal = ValueFactory.createValue(baseC, new Object[]{"test", 1});
        Value refCVal = ValueFactory.createValue(refC, new Object[]{"test", 1});
        EvaluationAccessor valBaseC = Utils.createValue(baseC, context, baseCVal);
        EvaluationAccessor valRefC = Utils.createValue(baseC, context, refCVal);
        
        Utils.testIsTypeKindOf(context, AnyType.IS_TYPE_OF, valBaseC, false, IntegerType.TYPE, RealType.TYPE, 
            StringType.TYPE, refC);
        Utils.testIsTypeKindOf(context, AnyType.IS_TYPE_OF, valRefC, false, IntegerType.TYPE, RealType.TYPE, 
            StringType.TYPE, baseC);
        valBaseC.release();
        valRefC.release();
    }

    /**
     * Tests the "isTypeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIsKindOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        Compound baseC = new Compound("base", null);
        baseC.add(new DecisionVariableDeclaration("test", IntegerType.TYPE, baseC));
        Compound refC = new Compound("ref", null, baseC);
        
        Value baseCVal = ValueFactory.createValue(baseC, new Object[]{"test", 1});
        Value refCVal = ValueFactory.createValue(refC, new Object[]{"test", 1});
        EvaluationAccessor valBaseC = Utils.createValue(baseC, context, baseCVal);
        EvaluationAccessor valRefC = Utils.createValue(baseC, context, refCVal);
        
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, valBaseC, false, IntegerType.TYPE, RealType.TYPE, 
            StringType.TYPE);
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, valBaseC, true, refC);
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, valRefC, false, IntegerType.TYPE, RealType.TYPE, 
            StringType.TYPE);
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, valRefC, true, refC);
        valBaseC.release();
        valRefC.release();
    }

    /**
     * Tests the "asType" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAsType() throws ValueDoesNotMatchTypeException {
        Compound c1 = new Compound("c1", null);
        Compound c2 = new Compound("c2", null, c1);
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor vc1 = Utils.createValue(c1, context, new Object[]{});
        EvaluationAccessor vc2 = Utils.createValue(c2, context, new Object[]{});
        Utils.testAsType(context, vc1, c1);
        Utils.testAsType(context, vc2, c1);
        Utils.testAsType(context, vc2, c2);
        vc1.release();
        vc2.release();
    }

}
