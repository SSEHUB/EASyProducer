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

import org.junit.Assert;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Some test utilities.
 * 
 * @author Holger Eichelberger
 */
class Utils {

    /**
     * Prevents external creation.
     */
    private Utils() {
    }

    /**
     * Creates a constant evaluation accessor for the given type, values and context.
     * 
     * @param type the type
     * @param context the context
     * @param values the values
     * @return the accessor
     * @throws ValueDoesNotMatchTypeException in case that values do not match type
     */
    static final EvaluationAccessor createValue(IDatatype type, EvaluationContext context, Object... values) 
        throws ValueDoesNotMatchTypeException {
        return ConstantAccessor.POOL.getInstance().bind(ValueFactory.createValue(type, values), context);
    }

    /**
     * Creates a constant evaluation accessor for the null value.
     * 
     * @param context the evaluation context
     * @return the accessor
     */
    static final EvaluationAccessor createNullValue(EvaluationContext context) {
        return ConstantAccessor.POOL.getInstance().bind(NullValue.INSTANCE, context);
    }
    
    /**
     * Tests the is-defined operation.
     * 
     * @param type the type to test for
     * @param op the specific is-defined operation
     * @param value a valid value
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    static void testDefined(IDatatype type, Operation op, Object value) throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor iValue = Utils.createValue(type, context, value);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        EvaluationAccessor notDef = ConstantAccessor.POOL.getInstance().bind(null, context);
        
        Utils.assertEquals(true, Utils.evaluate(op, iValue));
        Utils.assertEquals(false, Utils.evaluate(op, nullV));
        Utils.assertEquals(false, Utils.evaluate(op, notDef));
        
        iValue.release();
        notDef.release();
        nullV.release();
    }

    /**
     * Tests symmetric equals/unequals operations in all combinations.
     * 
     * @param expected the expected result for <code>equals</code> (may be <b>null</b>)
     * @param equals the equals operation
     * @param unequals the corresponding unequals operation
     * @param argument the argument
     * @param operand the operand
     */
    static void testEquals(Boolean expected, Operation equals, Operation unequals, EvaluationAccessor operand, 
        EvaluationAccessor argument) {
        testEquals(expected, equals, unequals, operand, argument, true);
    }
    
    // checkstyle: stop parameter number check
    
    /**
     * Tests equals/unequals operations in all combinations.
     * 
     * @param expected the expected result for <code>equals</code> (may be <b>null</b>)
     * @param equals the equals operation
     * @param unequals the corresponding unequals operation
     * @param argument the argument
     * @param operand the operand
     * @param symmetric whether the underlying operations are symmetric
     */
    static void testEquals(Boolean expected, Operation equals, Operation unequals, EvaluationAccessor operand, 
        EvaluationAccessor argument, boolean symmetric) {
        assertEquals(expected, evaluate(equals, operand, argument));
        if (symmetric) {
            assertEquals(expected, evaluate(equals, argument, operand));
        }
        if (null != expected) {
            assertEquals(!expected, evaluate(unequals, operand, argument));
            if (symmetric) {
                assertEquals(!expected, evaluate(unequals, argument, operand));
            }
        }
    }

    // checkstyle: resume parameter number check
    
    /**
     * Evaluates the operation for the given <code>operand</code> (must match) and the given
     * <code>arguments</code>.
     * 
     * @param operation the operation to be evaluated
     * @param operand the operand to the operation
     * @param arguments the arguments of the operation
     * @return the evaluation result, <b>null</b> if the evaluation failed or no operation was registered
     */
    static EvaluationAccessor evaluate(Operation operation, EvaluationAccessor operand, 
        EvaluationAccessor... arguments) {
        EvaluationAccessor result;
        IOperationEvaluator eval = EvaluatorRegistry.getOperationEvaluator(operation);
        if (null != eval) {
            result = eval.evaluate(operand, arguments);
        } else {
            Assert.fail("operation " + operation.getName() + " is not registered");
            result = null;
        }
        return result;
    }
    
    /**
     * Asserts equality between an expected boolean value and an actual evaluation accessor value.
     * Releases <code>actual</code>.
     * 
     * @param expected the expected value
     * @param actual the actual evaluation result
     */
    static final void assertEquals(Boolean expected, EvaluationAccessor actual) {
        Value val;
        if (null != actual) {
            val = actual.getValue();
            actual.release();
        } else {
            val = null;
        }
        if (null != expected && val instanceof BooleanValue) {
            Assert.assertEquals(expected, ((BooleanValue) val).getValue());
        } else if (null == expected && null == val) {
            Assert.assertTrue(true); // useless, I know
        } else {
            Assert.fail("expected " + expected + " does not match " + val);
        }
    }

    /**
     * Asserts equality between an expected integer value and an actual evaluation accessor value.
     * Releases <code>actual</code>.
     * 
     * @param expected the expected value
     * @param actual the actual evaluation result
     */
    static final void assertEquals(Integer expected, EvaluationAccessor actual) {
        Value val;
        if (null != actual) {
            val = actual.getValue();
            actual.release();
        } else {
            val = null;
        }
        assertEquals(expected, val);
    }

    /**
     * Asserts equality between an expected boolean value and an actual IVML value.
     * 
     * @param expected the expected value
     * @param actual the actual evaluation result
     */
    static final void assertEquals(Boolean expected, Value actual) {
        if (null != expected && actual instanceof BooleanValue) {
            Assert.assertEquals(expected, ((BooleanValue) actual).getValue());
        } else if (null == expected && null == actual) {
            Assert.assertTrue(true); // useless, I know
        } else {
            Assert.fail("expected " + expected + " does not match " + actual);
        }        
    }
    
    /**
     * Asserts equality between an expected integer value and an actual IVML value.
     * 
     * @param expected the expected value
     * @param actual the actual evaluation result
     */
    static final void assertEquals(Integer expected, Value actual) {
        if (null != expected && actual instanceof IntValue) {
            Assert.assertEquals(expected, ((IntValue) actual).getValue());
        } else if (null == expected && null == actual) {
            Assert.assertTrue(true); // useless, I know
        } else {
            Assert.fail("expected " + expected + " does not match " + actual);
        }        
    }
    
    /**
     * Asserts equality between an expected enum value and an actual IVML value.
     * 
     * @param expected the expected value
     * @param actual the actual evaluation result
     */
    static final void assertEquals(EnumLiteral expected, EvaluationAccessor actual) {
        Value val;
        if (null != actual) {
            val = actual.getValue();
            actual.release();
        } else {
            val = null;
        }
        if (null != expected && val instanceof EnumValue) {
            Assert.assertEquals(expected, ((EnumValue) val).getValue());
        } else if (null == expected && null == actual) {
            Assert.assertTrue(true); // useless, I know
        } else {
            Assert.fail("expected " + expected + " does not match " + actual);
        }        
    }

    /**
     * Asserts equality between an expected double value and an actual evaluation accessor value.
     * Releases <code>actual</code>.
     * 
     * @param expected the expected value
     * @param actual the actual evaluation result
     */
    static final void assertEquals(Double expected, EvaluationAccessor actual) {
        Value val;
        if (null != actual) {
            val = actual.getValue();
            actual.release();
        } else {
            val = null;
        }
        if (null != expected && val instanceof RealValue) {
            Assert.assertEquals(expected, ((RealValue) val).getValue());
        } else if (null == expected && null == val) {
            Assert.assertTrue(true); // useless, I know
        } else {
            Assert.fail("expected " + expected + " does not match " + val);
        }
    }

    /**
     * Asserts equality between an expected String value and an actual evaluation accessor value.
     * Releases <code>actual</code>.
     * 
     * @param expected the expected value
     * @param actual the actual evaluation result
     */
    static final void assertEquals(String expected, EvaluationAccessor actual) {
        Value val;
        if (null != actual) {
            val = actual.getValue();
            actual.release();
        } else {
            val = null;
        }
        if (null != expected && val instanceof StringValue) {
            Assert.assertEquals(expected, ((StringValue) val).getValue());
        } else if (null == expected && null == val) {
            Assert.assertTrue(true); // useless, I know
        } else {
            Assert.fail("expected " + expected + " does not match " + val);
        }
    }
    
    /**
     * Asserts equality between an expected datatype and an actual evaluation accessor value.
     * Releases <code>actual</code>.
     * 
     * @param expected the expected value
     * @param actual the actual evaluation result
     */
    static final void assertEquals(IDatatype expected, EvaluationAccessor actual) {
        Value val;
        if (null != actual) {
            val = actual.getValue();
            actual.release();
        } else {
            val = null;
        }
        if (null != expected && val instanceof MetaTypeValue) {
            Assert.assertTrue(TypeQueries.sameTypes(expected, ((MetaTypeValue) val).getValue()));
        } else if (null == expected && null == val) {
            Assert.assertTrue(true); // useless, I know
        } else {
            Assert.fail("expected " + expected + " does not match " + val);
        }
    }

    /**
     * Asserts container equality.
     * 
     * @param expected the expected set elements (may be <b>null</b>)
     * @param op the operation to be executed
     * @param set the actual set
     * @param args the arguments
     * @return the evaluation result (shall be released)
     */
    static EvaluationAccessor assertContainer(Object[] expected, Operation op, EvaluationAccessor set, 
        EvaluationAccessor... args) {
        EvaluationAccessor result = Utils.evaluate(op, set, args);
        if (null != result) {
            assertContainer(expected, result.getValue());
        } else {
            Assert.assertNull("result and expected must be null", expected); // result == expected
        }
        return result;
    }
    
    /**
     * Asserts container equality.
     * 
     * @param expected the expected set elements (may be <b>null</b>)
     * @param value the calculated (container) value
     */
    static void assertContainer(Object[] expected, Value value) {
        Assert.assertTrue(value instanceof ContainerValue);
        ContainerValue cValue = (ContainerValue) value;
        if (null != expected) {
            Assert.assertEquals(expected.length, cValue.getElementSize());
            for (int i = 0; i < expected.length; i++) {
                Value eltVal = cValue.getElement(i);
                if (expected[i] instanceof Value) {
                    Assert.assertTrue(eltVal.equals(expected[i]));
                } else {
                    Assert.assertEquals(expected[i], eltVal.getValue());
                }
            }
        } else {
            Assert.fail("null expected but result obtained");
        }
    }
    
    /**
     * Tests the "typeOf" operation. 
     * 
     * @param context the evaluation context
     * @param op the operation to be tested
     * @param values the values to be tested
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    static void testTypeOf(EvaluationContext context, Operation op, EvaluationAccessor... values) 
        throws ValueDoesNotMatchTypeException {
        EvaluationAccessor nullV = Utils.createNullValue(context);

        for (EvaluationAccessor acc : values) {
            Utils.assertEquals(acc.getValue().getType(), Utils.evaluate(op, acc));
        }
        
        nullV.release();
    }

    /**
     * Tests the "toString" operation. 
     * 
     * @param context the evaluation context
     * @param op the operation to be tested
     * @param operand the operand value to calculate the string representation for
     * @param expected the expected output
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    static void testToString(EvaluationContext context, Operation op, EvaluationAccessor operand, String expected) {
        testToString(context, op, operand, expected, -1);
    }
    
    /**
     * Tests the "toString" operation. 
     * 
     * @param context the evaluation context
     * @param op the operation to be tested
     * @param operand the operand value to calculate the string representation for
     * @param expected the expected output
     * @param maxLen the maximum length to compare, ignored if negative
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    static void testToString(EvaluationContext context, Operation op, EvaluationAccessor operand, String expected, 
        int maxLen) {
        EvaluationAccessor res = Utils.evaluate(op, operand);
        Assert.assertNotNull(res);
        Assert.assertNotNull(res.getValue());
        Assert.assertTrue(res.getValue() instanceof StringValue);
        Assert.assertEquals(cut(expected, maxLen), cut(((StringValue) res.getValue()).getValue(), maxLen));
        res.release();
        
        res = Utils.evaluate(op, null);
        Assert.assertNull(res);
    }

    /**
     * Cuts the given <code>text</code>.
     * 
     * @param text the text to cut
     * @param maxLen the maximum length to compare, ignored if negative
     * @return the <code>text</code> in <code>maxLen</code>
     */
    private static String cut(String text, int maxLen) {
        String result = text;
        if (null != result && maxLen >= 0 && result.length() > maxLen) {
            result = result.substring(0, maxLen);
        }
        return result;
    }

    /**
     * Tests the "isTypeOf"/"isKindOf" operation. This method considers 
     * {@link net.ssehub.easy.varModel.model.datatypes.AnyType} as test case.
     * 
     * @param context the evaluation context
     * @param op the operation to be tested
     * @param value the value to be tested
     * @param otherResult the result for the other types
     * @param others types to be tested
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    static void testIsTypeKindOf(EvaluationContext context, Operation op, EvaluationAccessor value, 
        boolean otherResult, IDatatype... others) 
        throws ValueDoesNotMatchTypeException {
        EvaluationAccessor nullV = Utils.createNullValue(context);
        EvaluationAccessor valueType = Utils.createValue(MetaType.TYPE, context, value.getValue().getType());
        EvaluationAccessor nullType = Utils.createValue(MetaType.TYPE, context, nullV.getValue().getType());

        Utils.assertEquals(true, Utils.evaluate(op, value, valueType));
        if (IvmlKeyWords.IS_TYPE_OF.equals(op.getName())) {
            Utils.assertEquals(false, Utils.evaluate(op, value, nullType));
            Utils.assertEquals(false, Utils.evaluate(op, nullType, value));
        } else {
            Utils.assertEquals(true, Utils.evaluate(op, value, nullType));
            Utils.assertEquals(true, Utils.evaluate(op, nullType, value));
        }
        Utils.assertEquals(true, Utils.evaluate(op, nullV, nullType));

        for (IDatatype type : others) {
            EvaluationAccessor tmpType = Utils.createValue(MetaType.TYPE, context, type);
            Utils.assertEquals(otherResult, Utils.evaluate(op, value, tmpType));
            tmpType.release();
        }
        
        nullType.release();
    }

    /**
     * Creates a function call ("shortcut").
     * 
     * @param operand the operand (tree)
     * @param op the operation 
     * @param args the argument (trees, may be left out in case of no parameters)
     * @return the created call
     */
    static OCLFeatureCall createCall(DecisionVariableDeclaration operand, Operation op, 
        ConstraintSyntaxTree... args) {
        return createCall(new Variable(operand), op, args);
    }
    
    /**
     * Creates a function call ("shortcut").
     * 
     * @param operand the operand (tree)
     * @param op the operation 
     * @param args the argument (trees, may be left out in case of no parameters)
     * @return the created call
     */
    static OCLFeatureCall createCall(ConstraintSyntaxTree operand, Operation op, ConstraintSyntaxTree... args) {
        return new OCLFeatureCall(operand, op.getName(), args);
    }

    /**
     * Creates a container operation call ("shortcut").
     * 
     * @param container the container to operate on
     * @param op the operation
     * @param iterEx the iterator expression
     * @param decl the declarators
     * @return the created call
     */
    static ContainerOperationCall createContainerCall(DecisionVariableDeclaration container, Operation op, 
        ConstraintSyntaxTree iterEx, DecisionVariableDeclaration... decl) {
        return createContainerCall(new Variable(container), op, iterEx, decl);
    }
    
    /**
     * Creates a container operation call ("shortcut").
     * 
     * @param container the container to operate on
     * @param op the operation
     * @param iterEx the iterator expression
     * @param decl the declarators
     * @return the created call
     */
    static ContainerOperationCall createContainerCall(ConstraintSyntaxTree container, Operation op, 
        ConstraintSyntaxTree iterEx, DecisionVariableDeclaration... decl) {
        return new ContainerOperationCall(container, op.getName(), iterEx, decl);
    }

    /**
     * Wraps an expression into a parenthesis and calls {@link ConstraintSyntaxTree#inferDatatype()}.
     * 
     * @param cst the constraint tree to be wrapped
     * @return the wrapped constraint tree
     * @throws CSTSemanticException in case of type consistency problems
     */
    static ConstraintSyntaxTree wrapInParenthesis(ConstraintSyntaxTree cst) throws CSTSemanticException {
        ConstraintSyntaxTree result = new Parenthesis(cst);
        result.inferDatatype();
        return result;
    }

}
