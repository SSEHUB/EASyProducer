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

import java.util.Random;

import org.junit.Assert;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Utility functions for {@link RealOperationsTest} and {@link IntegerOperationsTest}.
 * @author El-Sharkawy
 *
 */
class NumberOperationUtils {
    
    static final int RANDOM_ITERATIONS = 500;
    
    /**
     * An oracle for calculating the estimated value of a randomly generated <b>Integer</b> test.
     * @author El-Sharkawy
     *
     */
    abstract static class IntOperation {
        /**
         * Calculates the estimated value for two randomly generated integer values.
         * @param value1 The first constant integer value
         * @param value2 The second constant integer value
         * @return The <b>estimated</b> value
         */
        abstract int operation(int value1, int value2);
    }
    
    /**
     * An oracle for calculating the estimated value of a randomly generated <b>Integer</b> comparison.
     * @author El-Sharkawy
     *
     */
    abstract static class IntComparison {
        /**
         * Calculates the estimated value for two randomly generated integer values.
         * @param value1 The first constant integer value
         * @param value2 The second constant integer value
         * @return The <b>estimated</b> value
         */
        abstract boolean operation(int value1, int value2);
    }
    
    /**
     * An oracle for calculating the estimated value of a randomly generated <b>Integer</b> unary operations.
     * @author El-Sharkawy
     *
     */
    abstract static class IntUnaryOperation {
        /**
         * Calculates the estimated value for one randomly generated integer value.
         * @param value The integer value
         * @return The <b>estimated</b> value
         */
        abstract int operation(int value);
    }
    
    /**
     * An oracle for calculating the estimated value of a randomly generated <b>Real</b> test.
     * @author El-Sharkawy
     *
     */
    abstract static class RealOperation {
        
        /**
         * Calculates the estimated value for two randomly generated real values.
         * @param value1 The first constant integer value
         * @param value2 The second constant double value
         * @return The <b>estimated</b> value
         */
        abstract double operation(int value1, double value2);
    }
    
    /**
     * An oracle for calculating the estimated value of a randomly generated <b>Real</b> comparison.
     * @author El-Sharkawy
     *
     */
    abstract static class RealComparison {
        
        /**
         * Calculates the estimated value for two randomly generated integer values.
         * @param value1 The first constant number value
         * @param value2 The second constant number value
         * @return The <b>estimated</b> value
         */
        abstract boolean operation(int value1, double value2);
    }
    
    /**
     * An oracle for calculating the estimated value of a randomly generated <b>Real</b> unary operations.
     * @author El-Sharkawy
     *
     */
    abstract static class RealUnaryOperation {
        /**
         * Calculates the estimated value for one randomly generated real value.
         * @param value The real value
         * @return The <b>estimated</b> value
         */
        abstract double operation(double value);
    }
    
    /**
     * An oracle for calculating the estimated value of a randomly generated <b>Real</b> unary operations.
     * @author El-Sharkawy
     *
     */
    abstract static class RealUnaryOperation2 {
        /**
         * Calculates the estimated value for one randomly generated real value.
         * @param value The real value
         * @return The <b>estimated</b> value
         */
        abstract int operation(double value);
    }
    
    private static final Random RANDOM = new Random();
    
    /**
     * Creates randomly an Integer value between -(Integer.MAX_VALUE - 1) and +(Integer.MAX_VALUE - 1).
     * @return A randomly created Integer.
     */
    private static int randomInt() {
        int value = RANDOM.nextInt(Integer.MAX_VALUE - 1);
        if (RANDOM.nextInt(2) == 1) {
            value *= -1;
        }
        
        return value;
    }
    
    /**
     * Creates randomly an double value between -(Double.MAX_VALUE - 1) and +(Double.MAX_VALUE - 1).
     * @return A randomly created Doubler.
     */
    private static double randomDouble() {
        double value = RANDOM.nextDouble() * Double.MAX_VALUE;
        if (RANDOM.nextInt(2) == 1) {
            value *= -1;
        }
        
        return value;
    }
    
    /**
     * Tests randomly Integer operations.
     * @param operation A number operation. One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param isSymmetric If <tt>true</tt> also a second constraint will be created and tested,
     * with <tt>value2 (operation) value1</tt>.
     * @param op An oracle which should calculate the <b>estimated</b> value.
     */
    static void intOperationLoop(String operation, boolean isSymmetric, IntOperation op) {
        for (int i = 0; i < RANDOM_ITERATIONS; i++) {
            int value1 = randomInt();
            int value2 = randomInt();
            int expectedResult = op.operation(value1, value2);
            NumberOperationUtils.assertArithmeticConstraint(value1, value2, operation, expectedResult, isSymmetric,
                IntegerType.TYPE);
        }
    }
    
    /**
     * Tests randomly Integer operations.
     * @param operation A number operation. One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param op An oracle which should calculate the <b>estimated</b> value.
     */
    static void intComparisonLoop(String operation, IntComparison op) {
        for (int i = 0; i < RANDOM_ITERATIONS; i++) {
            int value1 = randomInt();
            int value2 = randomInt();
            boolean expectedResult = op.operation(value1, value2);
            NumberOperationUtils.assertArithmeticConstraint(value1, value2, operation, expectedResult, false,
                BooleanType.TYPE);
        }
    }
    
    /**
     * Tests randomly Integer operations.
     * @param operation An unary number operation.
     *     One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param isSymmetric If <tt>true</tt> operation(expectedResult) = value and vice versa,
     *     else operation(expectedResult) = expectedResult
     * @param op An oracle which should calculate the <b>estimated</b> value.
     */
    static void intUnaryOperationLoop(String operation, boolean isSymmetric, IntUnaryOperation op) {
        for (int i = 0; i < RANDOM_ITERATIONS; i++) {
            int value = randomInt();
            int expectedResult = op.operation(value);
            NumberOperationUtils.assertUnaryConstraint(value, operation, expectedResult, IntegerType.TYPE, isSymmetric);
        }
    }
    
    /**
     * Tests randomly Real operations.
     * @param operation A number operation. One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param isSymmetric If <tt>true</tt> also a second constraint will be created and tested,
     * with <tt>value2 (operation) value1</tt>.
     * @param op An oracle which should calculate the <b>estimated</b> value.
     */
    static void realOperationLoop(String operation, boolean isSymmetric, RealOperation op) {
        for (int i = 0; i < RANDOM_ITERATIONS; i++) {
            int value1 = randomInt();
            double value2 = randomDouble();
            double expectedResult = op.operation(value1, value2);
            NumberOperationUtils.assertArithmeticConstraint(value1, value2, operation, expectedResult, isSymmetric, 
                RealType.TYPE);
        }
    }

    /**
     * Tests randomly Integer operations.
     * @param operation A number operation. One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param op An oracle which should calculate the <b>estimated</b> value.
     */
    static void realComparisonLoop(String operation, RealComparison op) {
        for (int i = 0; i < RANDOM_ITERATIONS; i++) {
            int value1 = randomInt();
            double value2 = randomDouble();
            boolean expectedResult = op.operation(value1, value2);
            NumberOperationUtils.assertArithmeticConstraint(value1, value2, operation, expectedResult, false,
                BooleanType.TYPE);
        }
    }

    /**
     * Tests randomly Real operations.
     * @param operation An unary number operation.
     *     One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param isSymmetric If <tt>true</tt> operation(expectedResult) = value and vice versa,
     *     else operation(expectedResult) = expectedResult
     * @param op An oracle which should calculate the <b>estimated</b> value.
     */
    static void realUnaryOperationLoop(String operation, boolean isSymmetric, RealUnaryOperation op) {
        for (int i = 0; i < RANDOM_ITERATIONS; i++) {
            double value = randomDouble();
            double expectedResult = op.operation(value);
            NumberOperationUtils.assertUnaryConstraint(value, operation, expectedResult, RealType.TYPE, isSymmetric);
        }
    }
    
    /**
     * Tests randomly Real operations.
     * Contrary to {@link #realUnaryOperationLoop(String, boolean, RealUnaryOperation)}, this will only test one
     *     constraint and not also the mirrored version of the constraint.
     * @param operation An unary number operation.
     *     One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param op An oracle which should calculate the <b>estimated</b> value.
     */
    static void realUnaryOperationLoop(String operation, RealUnaryOperation2 op) {
        for (int i = 0; i < RANDOM_ITERATIONS; i++) {
            // Here a smaller range is supported than by the other operations
            double value = RANDOM.nextDouble() * Integer.MAX_VALUE;
            if (RANDOM.nextInt(2) == 1) {
                value *= -1;
            }
            int expectedResult = op.operation(value);
            NumberOperationUtils.assertUnaryConstraint(value, operation, expectedResult, IntegerType.TYPE);
        }
    }
    
    // checkstyle: stop parameter number check
    
    /**
     * Creates a constraint and tests whether the {@link EvaluationVisitor} will evaluate it to a correct value.
     * @param value1 The first constant integer value
     * @param value2 The second constant integer value
     * @param operation A number operation. One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param expectedResult For testing the expected result of the operation.
     * @param symmetric If <tt>true</tt> also a second constraint will be created and tested,
     * with <tt>value2 (operation) value1</tt>.
     * @param numberType The expected {@link IDatatype} of created results.
     */
    static void assertArithmeticConstraint(Number value1, Number value2, String operation, Object expectedResult,
        boolean symmetric, IDatatype numberType) {
        
        EvaluationVisitor evaluator = new EvaluationVisitor();
        evaluator.init(new Configuration(new Project("test")), null, false, null);
        ConstraintSyntaxTree cst = createArithmeticConstraint(value1, value2, operation);
        cst.accept(evaluator);
        Value result = evaluator.getResult();
        Assert.assertNotNull(result);
        Assert.assertSame(result.getType(), numberType);
        String errorMsg = "Error in " + operation + "-Operation. Expected: " 
            + value1 + " " + operation + " " + value2 + " = " + expectedResult + ", but was : " + result.getValue();
        Assert.assertEquals(errorMsg, expectedResult, result.getValue());
        
        if (symmetric) {
            evaluator.clear();
            evaluator.init(new Configuration(new Project("test")), null, false, null);
            cst = createArithmeticConstraint(value2, value1, operation);
            cst.accept(evaluator);
            result = evaluator.getResult();
            Assert.assertNotNull(result);
            Assert.assertSame(result.getType(), numberType);
            errorMsg = "Error in " + operation + "-Operation. Expected: " 
                + value2 + " " + operation + " " + value1 + " = " + expectedResult + ", but was : " + result.getValue();
            Assert.assertEquals(errorMsg, expectedResult, result.getValue());
        }
    }
    
    /**
     * Creates a constraint and tests whether the {@link EvaluationVisitor} will evaluate it to a correct value.
     * @param value The first constant integer value
     * @param operation A unary number operation.
     *     One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param expectedResult For testing the expected result of the operation.
     * @param numberType The expected {@link IDatatype} of created results.
     * @param isSymmetric If <tt>true</tt> operation(expectedResult) = value and vice versa,
     *     else operation(expectedResult) = expectedResult
     */
    static void assertUnaryConstraint(Number value, String operation, Object expectedResult,
        IDatatype numberType, boolean isSymmetric) {
        
        EvaluationVisitor evalutator = new EvaluationVisitor();
        ConstraintSyntaxTree cst = createUnaryConstraint(value, operation);
        cst.accept(evalutator);
        Value result = evalutator.getResult();
        Assert.assertNotNull(result);
        Assert.assertSame(result.getType(), numberType);
        String errorMsg = "Error in " + operation + "-Operation. Expected: " 
            + operation + "(" + value + ") = " + expectedResult + ", but was : " + result.getValue();
        Assert.assertEquals(errorMsg, expectedResult, result.getValue());
        
        // Vice versa
        expectedResult = isSymmetric ? value : expectedResult;
        evalutator.clear();
        Number operand = (Number) result.getValue();
        cst = createUnaryConstraint(operand, operation);
        cst.accept(evalutator);
        Value secondResult = evalutator.getResult();
        Assert.assertNotNull(secondResult);
        Assert.assertSame(secondResult.getType(), numberType);
        errorMsg = "Error in " + operation + "-Operation. Expected: " 
            + operation + "(" + operand + ") = " + expectedResult + ", but was : " + secondResult;
        Assert.assertEquals(errorMsg, expectedResult, secondResult.getValue());       
    }
    
    /**
     * Creates a constraint and tests whether the {@link EvaluationVisitor} will evaluate it to a correct value.
     * Contrary to {@link #assertUnaryConstraint(Number, String, Object, IDatatype, boolean)}, this will only test one
     *     constraint and not also the mirrored version of the constraint.
     * @param value The first constant integer value
     * @param operation A unary number operation.
     *     One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @param expectedResult For testing the expected result of the operation.
     * @param numberType The expected {@link IDatatype} of created results.
     */
    static void assertUnaryConstraint(Number value, String operation, Object expectedResult,
        IDatatype numberType) {
        
        EvaluationVisitor evalutator = new EvaluationVisitor();
        ConstraintSyntaxTree cst = createUnaryConstraint(value, operation);
        cst.accept(evalutator);
        Value result = evalutator.getResult();
        Assert.assertNotNull(result);
        Assert.assertSame(result.getType(), numberType);
        String errorMsg = "Error in " + operation + "-Operation. Expected: " 
            + operation + "(" + value + ") = " + expectedResult + ", but was : " + result.getValue();
        Assert.assertEquals(errorMsg, expectedResult, result.getValue());     
    }
    
    // checkstyle: resume parameter number check
    
    /**
     * Creates an arithmetic {@link RealType} constraint. This constraint can be a mixture
     * of one {@link RealType} and one {@link IntegerType} or {@link RealType}.
     * This constraint will have the following form:
     * <tt>value1 (operation) value2</tt>
     * @param value1 The first constant number value
     * @param value2 The second constant number value
     * @param operation A number operation. One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @return A constraint in form of <tt>value1 (operation) value2</tt>.
     */
    static ConstraintSyntaxTree createArithmeticConstraint(Number value1, Number value2, String operation) {
        OCLFeatureCall cst = null;
        try {
            IDatatype type1 = value1 instanceof Integer ? IntegerType.TYPE : RealType.TYPE;
            IDatatype type2 = value2 instanceof Integer ? IntegerType.TYPE : RealType.TYPE;
            
            Value vValue1 = ValueFactory.createValue(type1, value1);
            Value vValue2 = ValueFactory.createValue(type2, value2);
            ConstantValue cValue1 = new ConstantValue(vValue1);
            ConstantValue cValue2 = new ConstantValue(vValue2);
            cst = new OCLFeatureCall(cValue1, operation, cValue2);
            cst.inferDatatype();
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        return cst;
    }
    
    /**
     * Creates an unary constraint for number types.
     * This constraint will have the following form:
     * <tt>(operation) value</tt>
     * @param value The constant number value
     * @param operation A unary number operation.
     *     One of {@link de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords}.
     * @return A constraint in form of <tt>(operation) value</tt>.
     */
    static ConstraintSyntaxTree createUnaryConstraint(Number value, String operation) {
        OCLFeatureCall cst = null;
        try {
            IDatatype type1 = value instanceof Integer ? IntegerType.TYPE : RealType.TYPE;       
            Value vValue1 = ValueFactory.createValue(type1, value);
            
            ConstantValue cValue1 = new ConstantValue(vValue1);
            cst = new OCLFeatureCall(cValue1, operation);
            cst.inferDatatype();
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        return cst;
    }
}
