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

import org.junit.Test;

import de.uni_hildesheim.sse.model.cstEvaluation.NumberOperationUtils.IntComparison;
import de.uni_hildesheim.sse.model.cstEvaluation.NumberOperationUtils.RealComparison;
import de.uni_hildesheim.sse.model.cstEvaluation.NumberOperationUtils.RealOperation;
import de.uni_hildesheim.sse.model.cstEvaluation.NumberOperationUtils.RealUnaryOperation;
import de.uni_hildesheim.sse.model.cstEvaluation.NumberOperationUtils.RealUnaryOperation2;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

/**
 * Tests the implemented real operations.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class RealOperationsTest {

    /**
     * Tests the equals and the unequals operation for integers.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor real1 = Utils.createValue(RealType.TYPE, context, 1.1);
        EvaluationAccessor real0 = Utils.createValue(RealType.TYPE, context, 0.1);
        EvaluationAccessor int0 = Utils.createValue(IntegerType.TYPE, context, 0);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.testEquals(true, RealType.EQUALS_REAL_REAL, RealType.NOTEQUALS_REAL_REAL, real1, real1);
        Utils.testEquals(true, RealType.EQUALS_REAL_REAL, RealType.NOTEQUALS_REAL_REAL, real0, real0);
        Utils.testEquals(false, RealType.EQUALS_REAL_REAL, RealType.NOTEQUALS_REAL_REAL, real1, real0);
        Utils.testEquals(false, RealType.EQUALS_REAL_REAL, RealType.NOTEQUALS_REAL_REAL, nullV, real1);

        Utils.testEquals(false, RealType.EQUALS_REAL_INTEGER, RealType.NOTEQUALS_REAL_INTEGER, real1, int0, false);
        Utils.testEquals(false, RealType.EQUALS_REAL_INTEGER, RealType.NOTEQUALS_REAL_INTEGER, nullV, int0, false);

        real1.release();
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
        Utils.testDefined(RealType.TYPE, RealType.IS_DEFINED, 2.41);
    }
   
    /**
     * Tests the evaluation of (constant) PLUS operations.
     */
    @Test
    public void testPlus() {
        String operation = OclKeyWords.PLUS;
        boolean isSymmetric = true;
        NumberOperationUtils.assertArithmeticConstraint(1, 2.0, operation, 3.0, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(10.1, 50.1, operation, 60.2, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-1, 4.2, operation, 3.2, isSymmetric, RealType.TYPE);
        
        NumberOperationUtils.realOperationLoop(operation, isSymmetric, new RealOperation() {
            
            @Override
            double operation(int value1, double value2) {
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
        NumberOperationUtils.assertArithmeticConstraint(1, 2.0, operation, -1.0, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(10.1, 50.1, operation, -40.0, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-1, 4.2, operation, -5.2, isSymmetric, RealType.TYPE);
        
        NumberOperationUtils.realOperationLoop(operation, isSymmetric, new RealOperation() {
            
            @Override
            double operation(int value1, double value2) {
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
        NumberOperationUtils.assertArithmeticConstraint(1, 2.0, operation, 2.0, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(10.1, 50.1, operation, 506.01, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-1, 4.2, operation, -4.2, isSymmetric, RealType.TYPE);
        
        NumberOperationUtils.realOperationLoop(operation, isSymmetric, new RealOperation() {
            
            @Override
            double operation(int value1, double value2) {
                return value1 * value2;
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) DIVISION operations.
     */
    @Test
    public void testDivision() {
        String operation = OclKeyWords.DIV;
        boolean isSymmetric = false;
        NumberOperationUtils.assertArithmeticConstraint(1, 2, operation, 0.5, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(50.1, 10, operation, 5.01, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-1, 8.0, operation, -0.125, isSymmetric, RealType.TYPE);
        
        NumberOperationUtils.realOperationLoop(operation, isSymmetric, new RealOperation() {
            
            @Override
            double operation(int value1, double value2) {
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
        // Avoid rounding errors
        NumberOperationUtils.assertArithmeticConstraint(1.75, 0.5, operation, 0.25, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(100, 10.75, operation, 3.25, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-1, 8.0, operation, -1.0, isSymmetric, RealType.TYPE);
        
        NumberOperationUtils.realOperationLoop(operation, isSymmetric, new RealOperation() {
            
            @Override
            double operation(int value1, double value2) {
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
        NumberOperationUtils.assertArithmeticConstraint(1.0, 2, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 10.1, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1.0, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-17.0, -17, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0.0, -0, operation, false, isSymmetric, BooleanType.TYPE);
        
        NumberOperationUtils.realComparisonLoop(operation, new RealComparison() {
            
            @Override
            boolean operation(int value1, double value2) {
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
        NumberOperationUtils.assertArithmeticConstraint(1.0, 2, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 10.1, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1.0, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-17.0, -17, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0.0, -0, operation, true, isSymmetric, BooleanType.TYPE);
        
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
        NumberOperationUtils.assertArithmeticConstraint(1.0, 2, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 10.1, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1.0, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-17.0, -17, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0.0, -0, operation, false, isSymmetric, BooleanType.TYPE);
        
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
        NumberOperationUtils.assertArithmeticConstraint(1.0, 2, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(501, 10.1, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(4, -1.0, operation, false, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-17.0, -17, operation, true, isSymmetric, BooleanType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0.0, -0, operation, true, isSymmetric, BooleanType.TYPE);
        
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
        NumberOperationUtils.assertUnaryConstraint(-1.0, operation, 1.0, RealType.TYPE, isSymmetric);
        NumberOperationUtils.assertUnaryConstraint(-0.0, operation, 0.0, RealType.TYPE, isSymmetric);
        NumberOperationUtils.assertUnaryConstraint(100.001, operation, -100.001, RealType.TYPE, isSymmetric);
        
        NumberOperationUtils.realUnaryOperationLoop(operation, isSymmetric, new RealUnaryOperation() {
            
            @Override
            double operation(double value) {
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
        NumberOperationUtils.assertUnaryConstraint(-1.0, operation, 1.0, RealType.TYPE, isSymmetric);
        NumberOperationUtils.assertUnaryConstraint(-0.0, operation, 0.0, RealType.TYPE, isSymmetric);
        NumberOperationUtils.assertUnaryConstraint(100.001, operation, 100.001, RealType.TYPE, isSymmetric);
        
        NumberOperationUtils.realUnaryOperationLoop(operation, isSymmetric, new RealUnaryOperation() {
            
            @Override
            double operation(double value) {
                return Math.abs(value);
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) round operations.
     */
    @Test
    public void testRound() {
        String operation = OclKeyWords.ROUND;
        NumberOperationUtils.assertUnaryConstraint(0.5, operation, 1, IntegerType.TYPE);
        NumberOperationUtils.assertUnaryConstraint(-0.2, operation, -0, IntegerType.TYPE);
        NumberOperationUtils.assertUnaryConstraint(100.001, operation, 100, IntegerType.TYPE);
        double maxSupportedVal = 0.99999 * Integer.MAX_VALUE;
        int expectedVal = (int) Math.round(maxSupportedVal);
        NumberOperationUtils.assertUnaryConstraint(maxSupportedVal, operation, expectedVal, IntegerType.TYPE);
        
        // Tests Doubles which are out of range of an Integer
        double overSupportedVal = 1.5 * Integer.MAX_VALUE;
        expectedVal = Integer.MAX_VALUE;
        NumberOperationUtils.assertUnaryConstraint(overSupportedVal, operation, expectedVal, IntegerType.TYPE);
        overSupportedVal = 1.5 * Integer.MIN_VALUE;
        expectedVal = Integer.MIN_VALUE;
        NumberOperationUtils.assertUnaryConstraint(overSupportedVal, operation, expectedVal, IntegerType.TYPE);
        
        NumberOperationUtils.realUnaryOperationLoop(operation, new RealUnaryOperation2() {
            
            @Override
            int operation(double value) {
                return (int) Math.round(value);
            }
        });
    }
    
    /**
     * Tests the evaluation of (constant) floor operations.
     */
    @Test
    public void testFloor() {
        String operation = OclKeyWords.FLOOR;
        NumberOperationUtils.assertUnaryConstraint(0.5, operation, 0, IntegerType.TYPE);
        NumberOperationUtils.assertUnaryConstraint(-0.2, operation, -1, IntegerType.TYPE);
        NumberOperationUtils.assertUnaryConstraint(100.001, operation, 100, IntegerType.TYPE);
        double maxSupportedVal = 0.99999 * Integer.MAX_VALUE;
        int expectedVal = (int) Math.floor(maxSupportedVal);
        NumberOperationUtils.assertUnaryConstraint(maxSupportedVal, operation, expectedVal, IntegerType.TYPE);
        
        // Tests Doubles which are out of range of an Integer
        double overSupportedVal = 1.5 * Integer.MAX_VALUE;
        expectedVal = Integer.MAX_VALUE;
        NumberOperationUtils.assertUnaryConstraint(overSupportedVal, operation, expectedVal, IntegerType.TYPE);
        overSupportedVal = 1.5 * Integer.MIN_VALUE;
        expectedVal = Integer.MIN_VALUE;
        NumberOperationUtils.assertUnaryConstraint(overSupportedVal, operation, expectedVal, IntegerType.TYPE);
        
        NumberOperationUtils.realUnaryOperationLoop(operation, new RealUnaryOperation2() {
            
            @Override
            int operation(double value) {
                return (int) Math.floor(value);
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
        NumberOperationUtils.assertArithmeticConstraint(1.0, 2, operation, 1d, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-50.1, 10.1, operation, -50.1, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-4.0, -1, operation, -4d, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0.0, -0, operation, 0d, isSymmetric, RealType.TYPE);
        
        NumberOperationUtils.realOperationLoop(operation, isSymmetric, new RealOperation() {
            
            @Override
            double operation(int value1, double value2) {
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
        NumberOperationUtils.assertArithmeticConstraint(1, 2.0, operation, 2d, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-50.1, 10.1, operation, 10.1, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(-4, -1.0, operation, -1d, isSymmetric, RealType.TYPE);
        NumberOperationUtils.assertArithmeticConstraint(0, -0.0, operation, 0d, isSymmetric, RealType.TYPE);
        
        NumberOperationUtils.realOperationLoop(operation, isSymmetric, new RealOperation() {
            
            @Override
            double operation(int value1, double value2) {
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
        EvaluationAccessor value = Utils.createValue(RealType.TYPE, context, 1.22);
        Utils.testTypeOf(context, RealType.TYPE_OF, value);
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
        EvaluationAccessor value = Utils.createValue(RealType.TYPE, context, 1.1);
        Utils.testIsTypeKindOf(context, AnyType.IS_TYPE_OF, value, false, 
            BooleanType.TYPE, StringType.TYPE, IntegerType.TYPE);
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
        EvaluationAccessor value = Utils.createValue(RealType.TYPE, context, 1.1);
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, value, false, 
            BooleanType.TYPE, StringType.TYPE);
        Utils.testIsTypeKindOf(context, AnyType.IS_KIND_OF, value, true, IntegerType.TYPE);
        value.release();
    }

}
