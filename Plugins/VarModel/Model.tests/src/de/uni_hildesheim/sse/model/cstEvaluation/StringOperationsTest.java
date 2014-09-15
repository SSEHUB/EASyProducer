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

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

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
        final Operation op = StringType.CONCAT;

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
}
