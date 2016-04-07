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

import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Tests the implemented constraint operations.
 * 
 * @author Holger Eichelberger
 */
public class ConstraintOperationsTest {

    /**
     * Tests the equals and unequals operation for constraints.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("x", IntegerType.TYPE, null);
        
        ConstantValue c0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree cst1 = new OCLFeatureCall(
            new Variable(decl), IntegerType.LESS_EQUALS_INTEGER_INTEGER.getName(), c0);
        ConstraintSyntaxTree cst2 = new OCLFeatureCall(
            new Variable(decl), IntegerType.GREATER_EQUALS_INTEGER_INTEGER.getName(), c0);

        EvaluationAccessor val1 = Utils.createValue(ConstraintType.TYPE, context, cst1);
        EvaluationAccessor val2 = Utils.createValue(ConstraintType.TYPE, context, cst2);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        // equals is useless and will be tested in the EvaluationVisitorTest
        
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
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("x", IntegerType.TYPE, null);
        ConstantValue c0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree cst = new OCLFeatureCall(
            new Variable(decl), IntegerType.LESS_EQUALS_INTEGER_INTEGER.getName(), c0);
        Utils.testDefined(ConstraintType.TYPE, ConstraintType.IS_DEFINED, cst);
    }

    /**
     * Tests the "typeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("x", IntegerType.TYPE, null);
        ConstantValue c0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree cst = new OCLFeatureCall(
            new Variable(decl), IntegerType.LESS_EQUALS_INTEGER_INTEGER.getName(), c0);
        EvaluationAccessor cValue = Utils.createValue(ConstraintType.TYPE, context, cst);
        Utils.testTypeOf(context, ConstraintType.TYPE_OF, cValue);
        cValue.release();
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
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("x", IntegerType.TYPE, null);
        ConstantValue c0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree cst = new OCLFeatureCall(
            new Variable(decl), IntegerType.LESS_EQUALS_INTEGER_INTEGER.getName(), c0);
        EvaluationAccessor cValue = Utils.createValue(ConstraintType.TYPE, context, cst);
        Utils.testIsTypeKindOf(context, op, cValue, false, IntegerType.TYPE, RealType.TYPE, StringType.TYPE);
        cValue.release();
    }

}
