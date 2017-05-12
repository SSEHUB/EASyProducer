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
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the implemented string operations.
 * 
 * @author Holger Eichelberger
 */
public class StringOperationsTest {

    /**
     * Tests the equals and the unequals operation for booleans.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEquals() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor sValue1 = Utils.createValue(StringType.TYPE, context, "abba");
        EvaluationAccessor sValue2 = Utils.createValue(StringType.TYPE, context, "abba");
        EvaluationAccessor sEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor nullV = Utils.createNullValue(context);
        
        Utils.testEquals(true, StringType.EQUALS, StringType.UNEQUALS, sValue1, sValue1);
        Utils.testEquals(true, StringType.EQUALS, StringType.UNEQUALS, sValue2, sValue2);
        Utils.testEquals(true, StringType.EQUALS, StringType.UNEQUALS, sValue1, sValue2);
        Utils.testEquals(false, StringType.EQUALS, StringType.UNEQUALS, sEmpty, sValue1);
        Utils.testEquals(false, StringType.EQUALS, StringType.UNEQUALS, sEmpty, sValue2);
        Utils.testEquals(true, StringType.EQUALS, StringType.UNEQUALS, sEmpty, sEmpty);
        Utils.testEquals(false, StringType.EQUALS, StringType.UNEQUALS, sValue1, nullV);
        Utils.testEquals(false, StringType.EQUALS, StringType.UNEQUALS, sValue2, nullV);
        Utils.testEquals(false, StringType.EQUALS, StringType.UNEQUALS, sEmpty, nullV);

        sValue1.release();
        sValue2.release();
        sEmpty.release();
        nullV.release();
    }

    /**
     * Tests the is-defined operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testDefined() throws ValueDoesNotMatchTypeException {
        Utils.testDefined(StringType.TYPE, StringType.IS_DEFINED, "abba");
    }

    /**
     * Tests the "size" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testSize() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor str = Utils.createValue(StringType.TYPE, context, "SSE");
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = StringType.SIZE;

        Utils.assertEquals(3, Utils.evaluate(op, str));
        Utils.assertEquals(0, Utils.evaluate(op, strEmpty));
        Utils.assertEquals((Integer) null, Utils.evaluate(op, nullV));
        
        str.release();
        strEmpty.release();
        nullV.release();
    }

    /**
     * Tests the "toInt" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testToInt() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        final int testValue = 1054;
        EvaluationAccessor strValid = Utils.createValue(StringType.TYPE, context, String.valueOf(testValue));
        EvaluationAccessor strInvalid = Utils.createValue(StringType.TYPE, context, "SSE");
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = StringType.TO_INTEGER;

        Utils.assertEquals(testValue, Utils.evaluate(op, strValid));
        Utils.assertEquals((Integer) null, Utils.evaluate(op, strInvalid));
        Utils.assertEquals((Integer) null, Utils.evaluate(op, strEmpty));
        Utils.assertEquals((Integer) null, Utils.evaluate(op, nullV));
        
        strValid.release();
        strInvalid.release();
        strEmpty.release();
        nullV.release();
    }

    /**
     * Tests the "toReal" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testToReal() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        final double testValue = 3.41;
        EvaluationAccessor strValid = Utils.createValue(StringType.TYPE, context, String.valueOf(testValue));
        EvaluationAccessor strInvalid = Utils.createValue(StringType.TYPE, context, "SSE");
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = StringType.TO_REAL;

        Utils.assertEquals(testValue, Utils.evaluate(op, strValid));
        Utils.assertEquals((Double) null, Utils.evaluate(op, strInvalid));
        Utils.assertEquals((Double) null, Utils.evaluate(op, strEmpty));
        Utils.assertEquals((Double) null, Utils.evaluate(op, nullV));
        
        strValid.release();
        strInvalid.release();
        strEmpty.release();
        nullV.release();
    }

    /**
     * Tests the "toReal" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testToBoolean() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor strTrue = Utils.createValue(StringType.TYPE, context, "true");
        EvaluationAccessor strFalse = Utils.createValue(StringType.TYPE, context, "false");
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor strSSE = Utils.createValue(StringType.TYPE, context, "SSE");
        final Operation op = StringType.TO_BOOLEAN;

        Utils.assertEquals(true, Utils.evaluate(op, strTrue));
        Utils.assertEquals(false, Utils.evaluate(op, strFalse));
        Utils.assertEquals(false, Utils.evaluate(op, strEmpty));
        Utils.assertEquals(false, Utils.evaluate(op, strSSE));
        
        strTrue.release();
        strFalse.release();
        strEmpty.release();
        strSSE.release();
    }

    /**
     * Tests the "concat" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testConcat() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        final String s1Value = "SSE";
        final String s2Value = "@SUH";
        final String testValue = s1Value + s2Value;
        EvaluationAccessor strS1 = Utils.createValue(StringType.TYPE, context, s1Value);
        EvaluationAccessor strS2 = Utils.createValue(StringType.TYPE, context, s2Value);
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor nullV = Utils.createNullValue(context);
        Operation op = StringType.CONCAT;

        Utils.assertEquals(testValue, Utils.evaluate(op, strS1, strS2));
        Utils.assertEquals(s1Value, Utils.evaluate(op, strS1, strEmpty));
        Utils.assertEquals(s2Value, Utils.evaluate(op, strEmpty, strS2));
        Utils.assertEquals((String) null, Utils.evaluate(op, strS1, nullV));
        Utils.assertEquals((String) null, Utils.evaluate(op, strEmpty, nullV));

        op = StringType.PLUS;
        Utils.assertEquals(testValue, Utils.evaluate(op, strS1, strS2));
        Utils.assertEquals(s1Value, Utils.evaluate(op, strS1, strEmpty));
        Utils.assertEquals(s2Value, Utils.evaluate(op, strEmpty, strS2));
        Utils.assertEquals((String) null, Utils.evaluate(op, strS1, nullV));
        Utils.assertEquals((String) null, Utils.evaluate(op, strEmpty, nullV));

        strS1.release();
        strS2.release();
        strEmpty.release();
        nullV.release();
    }

    /**
     * Tests the "substring" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testSubstring() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        final String sValue = "SSE@SUH";
        final int index1 = 1;
        final int index2 = 4;
        final int index3 = -1;
        final int index4 = sValue.length() + 1;
        
        EvaluationAccessor str = Utils.createValue(StringType.TYPE, context, sValue);
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor i1 = Utils.createValue(IntegerType.TYPE, context, index1);
        EvaluationAccessor i2 = Utils.createValue(IntegerType.TYPE, context, index2);
        EvaluationAccessor i3 = Utils.createValue(IntegerType.TYPE, context, index3);
        EvaluationAccessor i4 = Utils.createValue(IntegerType.TYPE, context, index4);
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = StringType.SUBSTRING;

        Utils.assertEquals(sValue.substring(index1, index2), Utils.evaluate(op, str, i1, i2));
        Utils.assertEquals((String) null, Utils.evaluate(op, str, i2, i1));
        Utils.assertEquals((String) null, Utils.evaluate(op, str, i3, i2));
        Utils.assertEquals((String) null, Utils.evaluate(op, str, i1, i4));

        Utils.assertEquals((String) null, Utils.evaluate(op, strEmpty, i1, i2));
        Utils.assertEquals((String) null, Utils.evaluate(op, strEmpty, i2, i1));
        Utils.assertEquals((String) null, Utils.evaluate(op, strEmpty, i3, i2));
        Utils.assertEquals((String) null, Utils.evaluate(op, strEmpty, i1, i4));

        Utils.assertEquals((String) null, Utils.evaluate(op, nullV, i1, i2));
        Utils.assertEquals((String) null, Utils.evaluate(op, nullV, i2, i1));
        Utils.assertEquals((String) null, Utils.evaluate(op, nullV, i3, i2));
        Utils.assertEquals((String) null, Utils.evaluate(op, nullV, i1, i4));

        Utils.assertEquals((String) null, Utils.evaluate(op, nullV, nullV, nullV));
        
        str.release();
        strEmpty.release();
        i1.release();
        i2.release();
        i3.release();
        i4.release();
        nullV.release();
    }

    /**
     * Tests the "matches" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testMatches() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor str = Utils.createValue(StringType.TYPE, context, "SSE@SUH");
        EvaluationAccessor strReg1 = Utils.createValue(StringType.TYPE, context, ".*E@S.*");
        EvaluationAccessor strReg2 = Utils.createValue(StringType.TYPE, context, ".*expr.*");
        EvaluationAccessor strReg3 = Utils.createValue(StringType.TYPE, context, "(.e"); // patternSyntax!
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = StringType.MATCHES;

        Utils.assertEquals(true, Utils.evaluate(op, str, strReg1));
        Utils.assertEquals(false, Utils.evaluate(op, str, strReg2));
        Utils.assertEquals(false, Utils.evaluate(op, strEmpty, strReg1));
        Utils.assertEquals(false, Utils.evaluate(op, strEmpty, strReg2));
        Utils.assertEquals(false, Utils.evaluate(op, str, strEmpty));
        Utils.assertEquals((String) null, Utils.evaluate(op, str, strReg3)); // patternSyntax
        Utils.assertEquals((String) null, Utils.evaluate(op, nullV, strReg1)); 
        Utils.assertEquals((String) null, Utils.evaluate(op, str, nullV)); 
        
        str.release();
        strReg1.release();
        strReg2.release();
        strReg3.release();
        strEmpty.release();
        nullV.release();
    }

    /**
     * Tests the "substitutes" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testSubstitutes() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        final String sValue = "SSE@SUH";
        final String pValue = ".*E@S.*";
        final String rValue = "S@E*";
        final String testResult = sValue.replaceAll(pValue, rValue);
        EvaluationAccessor str = Utils.createValue(StringType.TYPE, context, sValue);
        EvaluationAccessor pat = Utils.createValue(StringType.TYPE, context, pValue);
        EvaluationAccessor repl = Utils.createValue(StringType.TYPE, context, rValue);
        EvaluationAccessor pat2 = Utils.createValue(StringType.TYPE, context, ".*expr.*");
        EvaluationAccessor pat3 = Utils.createValue(StringType.TYPE, context, "(.e"); // patternSyntax!
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        EvaluationAccessor nullV = Utils.createNullValue(context);
        final Operation op = StringType.SUBSTITUTES;

        Utils.assertEquals(testResult, Utils.evaluate(op, str, pat, repl));
        Utils.assertEquals(sValue, Utils.evaluate(op, str, pat2, repl)); // no match, no subst
        Utils.assertEquals("", Utils.evaluate(op, strEmpty, pat, repl)); // no match, no subst
        Utils.assertEquals((String) null, Utils.evaluate(op, str, pat3, repl)); // pattern Syntax

        Utils.assertEquals((String) null, Utils.evaluate(op, nullV, pat, repl));
        Utils.assertEquals((String) null, Utils.evaluate(op, str, nullV, repl));
        Utils.assertEquals((String) null, Utils.evaluate(op, str, pat, nullV));
        Utils.assertEquals((String) null, Utils.evaluate(op, nullV, nullV, nullV));

        str.release();
        pat.release();
        repl.release();
        pat2.release();
        pat3.release();
        strEmpty.release();
        nullV.release();
    }

    /**
     * Tests the "typeOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testTypeOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor str = Utils.createValue(StringType.TYPE, context, "abba");
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        Utils.testTypeOf(context, StringType.TYPE_OF, str, strEmpty);
        str.release();
        strEmpty.release();
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
     * Tests kind/type of as we do not have to consider type inheritance relations.
     * 
     * @param op the actual operation to be considered
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    private static void testTypeKindOf(Operation op) throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor str = Utils.createValue(StringType.TYPE, context, "abba");
        EvaluationAccessor strEmpty = Utils.createValue(StringType.TYPE, context, "");
        Utils.testIsTypeKindOf(context, op, str, false, IntegerType.TYPE, BooleanType.TYPE, 
            ConstraintType.TYPE);
        Utils.testIsTypeKindOf(context, op, strEmpty, false, IntegerType.TYPE, BooleanType.TYPE, 
            ConstraintType.TYPE);
        str.release();
        strEmpty.release();
    }
    
    /**
     * Tests the "isKindOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIsKindOf() throws ValueDoesNotMatchTypeException {
        testTypeKindOf(AnyType.IS_KIND_OF);
    }
    
    /**
     * Tests whether equals operation of <tt>string.size()</tt> works, if string is not initialized.
     * Bug occurred at 14.08.2014.
     * Test will test project:
     * <pre><code>
     * project stringTestProject {
     * 
     * String str;
     * not size(str) == 0;
     * }
     * </code></pre>
     */
    @Test
    public void testSizeOfUndefinedString() {
        Project project = new Project("stringTestProject");
        DecisionVariableDeclaration str = new DecisionVariableDeclaration("str", StringType.TYPE, project);
        project.add(str);
        
        // Create Constraint: not(size(str) == 0)
        try {
            OCLFeatureCall size = new OCLFeatureCall(new Variable(str), OclKeyWords.SIZE);
            Value zeroValue = ValueFactory.createValue(IntegerType.TYPE, 0);
            OCLFeatureCall equals = new OCLFeatureCall(size, OclKeyWords.EQUALS, new ConstantValue(zeroValue));
            OCLFeatureCall not = new OCLFeatureCall(equals, OclKeyWords.NOT);
            
            Constraint constraint = new Constraint(project);
            constraint.setConsSyntax(not);
            project.add(constraint);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        } 
        
        ProjectTestUtilities.validateProject(project);
        
        // Configuration calls the evaluation visitor, check that NO NullPointerException occurrs!
        new Configuration(project);
    }
    
    /**
     * Tests the "toString" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testToString() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor sValue = Utils.createValue(StringType.TYPE, context, "abba");
        Utils.testToString(context, StringType.TO_STRING, sValue, "abba");
        sValue.release();
        sValue = Utils.createValue(StringType.TYPE, context, "");
        Utils.testToString(context, StringType.TO_STRING, sValue, "");
        sValue.release();
    }
    
    /**
     * Tests the "indexOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIndexOf() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor textValue = Utils.createValue(StringType.TYPE, context, "abba");
        EvaluationAccessor searchValue = Utils.createValue(StringType.TYPE, context, "a");
        Utils.assertEquals(0, Utils.evaluate(StringType.INDEX_OF, textValue, searchValue));
        searchValue.release();
        searchValue = Utils.createValue(StringType.TYPE, context, "ba");
        Utils.assertEquals(2, Utils.evaluate(StringType.INDEX_OF, textValue, searchValue));
        searchValue.release();
        searchValue = Utils.createValue(StringType.TYPE, context, "c");
        Utils.assertEquals(-1, Utils.evaluate(StringType.INDEX_OF, textValue, searchValue));
        searchValue.release();
        textValue.release();
    }

    /**
     * Tests the "indexOf" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAt() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor textValue = Utils.createValue(StringType.TYPE, context, "abba");
        EvaluationAccessor indexValue = Utils.createValue(IntegerType.TYPE, context, 0);
        Utils.assertEquals("a", Utils.evaluate(StringType.AT, textValue, indexValue));
        indexValue.release();
        indexValue = Utils.createValue(IntegerType.TYPE, context, 2);
        Utils.assertEquals("b", Utils.evaluate(StringType.AT, textValue, indexValue));
        indexValue.release();
        indexValue = Utils.createValue(IntegerType.TYPE, context, -1);
        Assert.assertNull(Utils.evaluate(StringType.AT, textValue, indexValue));
        indexValue.release();
        indexValue = Utils.createValue(IntegerType.TYPE, context, 5);
        Assert.assertNull(Utils.evaluate(StringType.AT, textValue, indexValue));
        indexValue.release();
        textValue.release();
    }

    /**
     * Tests the "equalsIgnoreCase" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testEqualsIgnoreCase() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor textValue = Utils.createValue(StringType.TYPE, context, "abba");
        EvaluationAccessor testValue = Utils.createValue(StringType.TYPE, context, "ABBA");
        assertLocale(textValue);
        Utils.assertEquals(true, Utils.evaluate(StringType.EQUALS_IGNORE_CASE, textValue, testValue));
        Utils.assertEquals(true, Utils.evaluate(StringType.EQUALS_IGNORE_CASE, textValue, textValue));
        testValue.release();
        testValue = Utils.createValue(StringType.TYPE, context, "AB1BA");
        Utils.assertEquals(false, Utils.evaluate(StringType.EQUALS_IGNORE_CASE, textValue, testValue));
        testValue.release();
        textValue.release();
    }

    /**
     * Tests the "equalsIgnoreCase" operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testCase() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor textValue = Utils.createValue(StringType.TYPE, context, "abba");
        assertLocale(textValue);
        Utils.assertEquals("ABBA", Utils.evaluate(StringType.TO_UPPER_CASE, textValue));
        textValue.release();
        textValue = Utils.createValue(StringType.TYPE, context, "ABBA");
        Utils.assertEquals("abba", Utils.evaluate(StringType.TO_LOWER_CASE, textValue));
        textValue.release();
    }
    
    /**
     * Asserts the global locale (and the locale operations) on <code>accessor</code>.
     * 
     * @param accessor the accessor to change the locale on
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    public static void assertLocale(EvaluationAccessor accessor) throws ValueDoesNotMatchTypeException {
        String expected = GenericOperations.localeToString(accessor);
        Utils.assertEquals(expected, Utils.evaluate(AnyType.GET_LOCALE, accessor));
        String testLocale = "en_US";
        EvaluationAccessor textValue = Utils.createValue(StringType.TYPE, accessor.getContext(), testLocale);
        Utils.assertEquals(testLocale, Utils.evaluate(AnyType.SET_LOCALE, accessor, textValue));
        Assert.assertEquals(GenericOperations.localeToString(accessor), testLocale);
        textValue.release();
    }
    
    /**
     * Tests the compare operations.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testCompare() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor value1 = Utils.createValue(StringType.TYPE, context, "abba");
        assertLocale(value1);
        EvaluationAccessor value2 = Utils.createValue(StringType.TYPE, context, "ABBA");
        Utils.assertEquals(true, Utils.evaluate(StringType.LESS, value1, value2));
        Utils.assertEquals(true, Utils.evaluate(StringType.LESS_EQUALS, value1, value2));
        Utils.assertEquals(false, Utils.evaluate(StringType.LESS, value1, value1));
        Utils.assertEquals(true, Utils.evaluate(StringType.LESS_EQUALS, value1, value1));
        Utils.assertEquals(true, Utils.evaluate(StringType.GREATER, value2, value1));
        Utils.assertEquals(false, Utils.evaluate(StringType.GREATER_EQUALS, value1, value2));
        Utils.assertEquals(false, Utils.evaluate(StringType.GREATER, value1, value1));
        Utils.assertEquals(true, Utils.evaluate(StringType.GREATER_EQUALS, value1, value1));
        value1.release();
        value2.release();
    }

    /**
     * Tests the "sequence" operator.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testSequence() throws ValueDoesNotMatchTypeException {
        TestEvaluationContext context = new TestEvaluationContext();
        EvaluationAccessor value = Utils.createValue(StringType.TYPE, context, "abba");
        assertConcatenatedSequence("abba", Utils.evaluate(StringType.CHARACTERS, value));
        value.release();
        value = Utils.createValue(StringType.TYPE, context, "");
        assertConcatenatedSequence("", Utils.evaluate(StringType.CHARACTERS, value));
        value.release();
    }
    
    /**
     * Asserts that <code>actual</code> is a container of String values and compares the concatenated
     * string values (in container given sequence) to <code>expected</code>. If <code>expected</code> is 
     * <b>null</b>, the value of <code>actual</code> must be null. Releases actual at the end.
     * 
     * @param expected the expected concatenated string
     * @param actual the actual evaluation result
     */
    private static void assertConcatenatedSequence(String expected, EvaluationAccessor actual) {
        Value val = actual.getValue();
        if (null == expected) {
            Assert.assertNull(expected);
        } else {
            Assert.assertNotNull(expected);
            Assert.assertTrue(val instanceof ContainerValue);
            ContainerValue cValue = (ContainerValue) val;
            String sActual = "";
            for (int i = 0; i < cValue.getElementSize(); i++) {
                Value eVal = cValue.getElement(i);
                Assert.assertTrue(eVal instanceof StringValue);
                sActual += ((StringValue) eVal).getValue();
            }
            Assert.assertEquals(expected, sActual);
            actual.release();
        }
    }

}
