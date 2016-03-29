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
import net.ssehub.easy.varModel.cstEvaluation.NumberOperationUtils.IntComparison;
import net.ssehub.easy.varModel.cstEvaluation.NumberOperationUtils.IntOperation;
import net.ssehub.easy.varModel.cstEvaluation.NumberOperationUtils.IntUnaryOperation;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Tests the implemented integer operations.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class IntegerOperationsTest {
    
    /**
     * Tests the equals and the unequals operation for integers.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor int1 = Utils.createValue(IntegerType.TYPE, context, 1);
        EvaluationAccessor int0 = Utils.createValue(IntegerType.TYPE, context, 0);
        EvaluationAccessor real0 = Utils.createValue(RealType.TYPE, context, 0.1);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.testEquals(true, IntegerType.EQUALS_INTEGER_INTEGER, IntegerType.NOTEQUALS_INTEGER_INTEGER, int1, int1);
        Utils.testEquals(true, IntegerType.EQUALS_INTEGER_INTEGER, IntegerType.NOTEQUALS_INTEGER_INTEGER, int0, int0);
        Utils.testEquals(false, IntegerType.EQUALS_INTEGER_INTEGER, IntegerType.NOTEQUALS_INTEGER_INTEGER, int1, int0);
        Utils.testEquals(false, IntegerType.EQUALS_INTEGER_INTEGER, IntegerType.NOTEQUALS_INTEGER_INTEGER, nullV, int1);

        Utils.testEquals(true, IntegerType.EQUALS_INTEGER_REAL, IntegerType.NOTEQUALS_INTEGER_REAL, int0, real0, false);
        Utils.testEquals((Boolean) null, IntegerType.EQUALS_INTEGER_REAL, IntegerType.NOTEQUALS_INTEGER_REAL, nullV, 
            real0, false);

        int1.release();
        int0.release();
        real0.release();
        nullV.release();
    }

    /**
     * Tests the is-defined operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testDefined() throws ValueDoesNotMatchTypeException {
        Utils.testDefined(IntegerType.TYPE, IntegerType.IS_DEFINED, 100);
    }

    /**
     * Tests the evaluation of (constant) PLUS operations.
     */
    @Test
    public void testPlus() {
        String operation = OclKeyWords.PLUS;
        boolean isSymmetric = true;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, 3, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(101, 501, operation, 602, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-1, 4, operation, 3, isSymmetric, IntegerType.TYPE);
        
        NumberOperationUtils.intOperationLoop(operation, isSymmetric, new IntOperation() {
            
            @Override
            int operation(int value1, int value2) {
                return value1 + value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) MINUS operations.
     */
    @Test
    public void testMinus() {
        String operation = OclKeyWords.MINUS;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, -1, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(101, 501, operation, -400, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-1, 4, operation, -5, isSymmetric, IntegerType.TYPE);
        
        NumberOperationUtils.intOperationLoop(operation, isSymmetric, new IntOperation() {
            
            @Override
            int operation(int value1, int value2) {
                return value1 - value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) MULTIPLICATION operations.
     */
    @Test
    public void testMultiplication() {
        String operation = OclKeyWords.MULT;
        boolean isSymmetric = true;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, 2, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(101, 501, operation, 50601, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-1, 4, operation, -4, isSymmetric, IntegerType.TYPE);
        
        NumberOperationUtils.intOperationLoop(operation, isSymmetric, new IntOperation() {
            
            @Override
            int operation(int value1, int value2) {
                return value1 * value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) DIVISION operations.
     */
    @Test
    public void testDivision() {
        String operation = OclKeyWords.DIV_INT;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, 0, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 101, operation, 4, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1, operation, -4, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, 0, operation, null, isSymmetric, IntegerType.TYPE);
        
        NumberOperationUtils.intOperationLoop(operation, isSymmetric, new IntOperation() {
            
            @Override
            int operation(int value1, int value2) {
                return value1 / value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) MODULO operations.
     */
    @Test
    public void testModulo() {
        String operation = OclKeyWords.MOD;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, 1, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 101, operation, 97, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1, operation, 0, isSymmetric, IntegerType.TYPE);
        
        NumberOperationUtils.intOperationLoop(operation, isSymmetric, new IntOperation() {
            
            @Override
            int operation(int value1, int value2) {
                return value1 % value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) Greater operations.
     */
    @Test
    public void testGreater() {
        String operation = OclKeyWords.GREATER;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 101, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-17, -17, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0, -0, operation, false, isSymmetric, BooleanType.TYPE);
        
        NumberOperationUtils.intComparisonLoop(operation, new IntComparison() {
            
            @Override
            boolean operation(int value1, int value2) {
                return value1 > value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) Greater or Equal operations.
     */
    @Test
    public void testGreaterEquals() {
        String operation = OclKeyWords.GREATER_EQUALS;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 101, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-17, -17, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0, -0, operation, true, isSymmetric, BooleanType.TYPE);
        
        NumberOperationUtils.intComparisonLoop(operation, new IntComparison() {
            
            @Override
            boolean operation(int value1, int value2) {
                return value1 >= value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) Less operations.
     */
    @Test
    public void testLess() {
        String operation = OclKeyWords.LESS;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 101, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-17, -17, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0, -0, operation, false, isSymmetric, BooleanType.TYPE);
        
        NumberOperationUtils.intComparisonLoop(operation, new IntComparison() {
            
            @Override
            boolean operation(int value1, int value2) {
                return value1 < value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) Less or Equal operations.
     */
    @Test
    public void testLessEquals() {
        String operation = OclKeyWords.LESS_EQUALS;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 101, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-17, -17, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0, -0, operation, true, isSymmetric, BooleanType.TYPE);
        
        NumberOperationUtils.intComparisonLoop(operation, new IntComparison() {
            
            @Override
            boolean operation(int value1, int value2) {
                return value1 <= value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) Negation operations.
     */
    @Test
    public void testInverse() {
        String operation = OclKeyWords.INVERSE;
        boolean isSymmetric = true;
        NumberOperationUtils.assertUnaryConstraint(-1, operation, 1, IntegerType.TYPE, isSymmetric);
        NumberOperationUtils.assertUnaryConstraint(-0, operation, 0, IntegerType.TYPE, isSymmetric);
        NumberOperationUtils.assertUnaryConstraint(100, operation, -100, IntegerType.TYPE, isSymmetric);
        
        NumberOperationUtils.intUnaryOperationLoop(operation, isSymmetric, new IntUnaryOperation() {
            
            @Override
            int operation(int value) {
                return -1 * value;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) Absolute operations.
     */
    @Test
    public void testAbsolute() {
        String operation = OclKeyWords.ABS;
        boolean isSymmetric = false;
        NumberOperationUtils.assertUnaryConstraint(-1, operation, 1, IntegerType.TYPE, isSymmetric);
        NumberOperationUtils.assertUnaryConstraint(-0, operation, 0, IntegerType.TYPE, isSymmetric);
        NumberOperationUtils.assertUnaryConstraint(100, operation, 100, IntegerType.TYPE, isSymmetric);
        
        NumberOperationUtils.intUnaryOperationLoop(operation, isSymmetric, new IntUnaryOperation() {
            
            @Override
            int operation(int value) {
                return Math.abs(value);
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) MIN operations.
     */
    @Test
    public void testMin() {
        String operation = OclKeyWords.MIN;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, 1, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-501, 101, operation, -501, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-4, -1, operation, -4, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0, -0, operation, 0, isSymmetric, IntegerType.TYPE);
        
        NumberOperationUtils.intOperationLoop(operation, isSymmetric, new IntOperation() {
            
            @Override
            int operation(int value1, int value2) {
                return Math.min(value1, value2);
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) MAX operations.
     */
    @Test
    public void testMax() {
        String operation = OclKeyWords.MAX;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, 2, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-501, 101, operation, 101, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-4, -1, operation, -1, isSymmetric, IntegerType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0, -0, operation, 0, isSymmetric, IntegerType.TYPE);
        
        NumberOperationUtils.intOperationLoop(operation, isSymmetric, new IntOperation() {
            
            @Override
            int operation(int value1, int value2) {
                return Math.max(value1, value2);
            }
        });
    }
    
    /**
     * Tests the "typeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.testTypeOf(context, IntegerType.TYPE_OF, value);
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
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.testIsTypeKindOf(context, AnyType.IS_TYPE_OF, value, false, 
            RealType.TYPE, StringType.TYPE, MetaType.TYPE);
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
        EvaluationAccessor value = Utils.createValue(IntegerType.TYPE, context, 1);
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, value, false, StringType.TYPE, MetaType.TYPE, 
            RealType.TYPE);
        value.release();
    }
    
}
