package test.net.ssehub.easy.reasoning.core.frontend;

import java.io.IOException;

import org.junit.Test;

import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Tests individual operations.
 * 
 * @author Holger Eichelberger
 */
public abstract class OperationTests extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected OperationTests(ITestDescriptor descriptor) {
        super(descriptor, "operations");
    }
    
    // ---------------------------------- Integer constants ----------------------------------
    
    /**
     * Tests integer equality and unequality operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerConstants() throws IOException {
        reasoningTest("integerEqConstants", 0);
    }
    
    /**
     * Tests integer add operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testIntegerAddConstants() throws IOException {
        reasoningTest("integerAddConstants", 0);
    }

    /**
     * Tests integer subtraction operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testIntegerSubConstants() throws IOException {
        reasoningTest("integerSubConstants", 0);
    }

    /**
     * Tests integer multiplication operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */   
    @Test
    public void testIntegerMulConstants() throws IOException {
        reasoningTest("integerMulConstants", 0);
    }
    
    /**
     * Tests integer multiplication operations on constants which shall fail.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerMulConstantsFail() throws IOException {
        reasoningTest("integerMulConstantsFail", 3);
    }
    
    /**
     * Tests integer division operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test    
    public void testIntegerDivConstants() throws IOException {
        reasoningTest("integerDivConstants", 0);
    }
    
    /**
     * Tests integer division operations on constants which shall fail.
     * 
     * @throws IOException in case of problems reading a model
     */  
    @Test // Must fail div by 0
    public void testIntegerDivConstantsFail() throws IOException {
        reasoningTest("integerDivConstantsFail", 0); // -> undefined
    }
    
    /**
     * Tests integer ABS operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testIntegerABSConstants() throws IOException {
        reasoningTest("integerABSConstants", 0);
    }
    
    /**
     * Tests integer DIV operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerDIVopConstants() throws IOException {
        reasoningTest("integerDIVopConstants", 0);
    }
    
    /**
     * Tests integer MOD operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMODopConstants() throws IOException {
        reasoningTest("integerMODopConstants", 0);
    }
    
    /**
     * Tests integer MAX operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMAXConstants() throws IOException {
        reasoningTest("integerMAXConstants", 0);
    }
    
    /**
     * Tests integer MIN operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerMINConstants() throws IOException {
        reasoningTest("integerMINConstants", 0);
    }
    
    /**
     * Tests integer > operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerGreaterThanConstants() throws IOException {
        reasoningTest("integerGreaterThanConstants", 0);
    }
    
    /**
     * Tests integer &lt; operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerLessThanConstants() throws IOException {
        reasoningTest("integerLessThanConstants", 0);
    }
    
    /**
     * Tests integer &lt;= operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerLessThanOrEqualsConstants() throws IOException {
        reasoningTest("integerLessThanOrEqualsConstants", 0);
    }
    
    /**
     * Tests integer &gt;= operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerGreaterThanOrEqualsConstants() throws IOException {
        reasoningTest("integerGreaterThanOrEqualsConstants", 0);
    }

    // ---------------------------------- Integer variables ----------------------------------
    
    /**
     * Tests integer equality and unequality operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerEqVariables() throws IOException {
        reasoningTest("integerEqVariables", 0);
    }

    /**
     * Tests integer equality and unequality operations on simple variables which shall fail.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerEqVariablesFail() throws IOException {
        reasoningTest("integerEqVariablesFail", 9);
    }

    /**
     * Tests integer add operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerAddVariables() throws IOException {
        reasoningTest("integerAddVariables", 0);
    }

    /**
     * Tests integer subtraction operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerSubVariables() throws IOException {
        reasoningTest("integerSubVariables", 0);
    }

    /**
     * Tests integer multiplication operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerMulVariables() throws IOException {
        reasoningTest("integerMulVariables", 0);
    }

    /**
     * Tests integer division operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerDivVariables() throws IOException {
        reasoningTest("integerDivVariables", 0);
    }
    
    /**
     * Tests integer division operations on simple variables which shall fail.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerDivVariablesFails() throws IOException {
        reasoningTest("integerDivVariablesFail", 0); // -> undefined
    }
    
    /**
     * Tests integer ABS operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerABSVariables() throws IOException {
        reasoningTest("integerABSVariables", 0);
    }
    
    /**
     * Tests integer DIV operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerDIVopVariables() throws IOException {
        reasoningTest("integerDIVopVariables", 0);
    }
    
    /**
     * Tests integer MOD operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMODopVariables() throws IOException {
        reasoningTest("integerMODopVariables", 0);
    }
    
    /**
     * Tests integer MAX operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMAXVariables() throws IOException {
        reasoningTest("integerMAXVariables", 0);
    }
    
    /**
     * Tests integer MIN operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMINVariables() throws IOException {
        reasoningTest("integerMINVariables", 0);
    }

    /**
     * Tests integer &gt; operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test 
    public void testIntegerGreaterThanVariables() throws IOException {
        reasoningTest("integerGreaterThanVariables", 0);
    }
    
    /**
     * Tests integer &lt; operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test 
    public void testIntegerLessThanVariables() throws IOException {
        reasoningTest("integerLessThanVariables", 0);
    }
    
    /**
     * Tests integer &lt;= operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test 
    public void testIntegerLessThanOrEqualsVariables() throws IOException {
        reasoningTest("integerLessThanOrEqualsVariables", 0);
    }
    
    /**
     * Tests integer &gt;= operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test 
    public void testIntegerGreaterThanOrEqualsVariables() throws IOException {
        reasoningTest("integerGreaterThanOrEqualsVariables", 0);
    }
    
    // ---------------------------------- Real constants ----------------------------------
    /**
     * Tests real + operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealAddConstants() throws IOException {
        reasoningTest("realAddConstants", 0);
    }
    
    /**
     * Tests real + operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealDivConstants() throws IOException {
        reasoningTest("realDivConstants", 0);
    }
    
    /**
     * Tests real * operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMulConstants() throws IOException {
        reasoningTest("realMulConstants", 0);
    }
    
    /**
     * Tests real - operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealSubConstants() throws IOException {
        reasoningTest("realSubConstants", 0);
    }
    
    /**
     * Tests real - operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealABSConstants() throws IOException {
        reasoningTest("realABSConstants", 0);
    }
    
    /**
     * Tests real FLOOR operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealFLOORConstants() throws IOException {
        reasoningTest("realFLOORConstants", 0);
    }
    
    /**
     * Tests real ROUND operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealROUNDConstants() throws IOException {
        reasoningTest("realROUNDConstants", 0);
    }
    
    /**
     * Tests real MAX operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testRealMAXConstants() throws IOException {
        reasoningTest("realMAXConstants", 0);
    }
    
    /**
     * Tests real MIN operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMINConstants() throws IOException {
        reasoningTest("realMINConstants", 0);
    }
    
    /**
     * Tests real == and &lt;&gt; operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealEqConstants() throws IOException {
        reasoningTest("realEqConstants", 0);
    }
    
    /**
     * Tests real &gt; operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealGreaterThanConstants() throws IOException {
        reasoningTest("realGreaterThanConstants", 0);
    }    
    
    /**
     * Tests real &gt;= operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealGreaterThanOrEqualsConstants() throws IOException {
        reasoningTest("realGreaterThanOrEqualsConstants", 0);
    } 
    
    /**
     * Tests real &lt; operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealLessThanConstants() throws IOException {
        reasoningTest("realLessThanConstants", 0);
    } 
    
    /**
     * Tests real &lt;= operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealLessThanOrEqualsConstants() throws IOException {
        reasoningTest("realLessThanOrEqualsConstants", 0);
    } 
   
    // ---------------------------------- Real variables ----------------------------------
    
    /**
     * Tests real + operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealAddVariables() throws IOException {
        reasoningTest("realAddVariables", 0);
    }
    
    /**
     * Tests real / operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealDivVariables() throws IOException {
        reasoningTest("realDivVariables", 0);
    }
    
    /**
     * Tests real * operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMulVariables() throws IOException {
        reasoningTest("realMulVariables", 0);
    }
    
    /**
     * Tests real - operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealSubVariables() throws IOException {
        reasoningTest("realSubVariables", 0);
    }
    
    /**
     * Tests real - operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealABSVariables() throws IOException {
        reasoningTest("realABSVariables", 0);
    }
    
    /**
     * Tests real FLOOR operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealFLOORVariables() throws IOException {
        reasoningTest("realFLOORVariables", 0);
    }
    
    /**
     * Tests real ROUND operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealROUNDVariables() throws IOException {
        reasoningTest("realROUNDVariables", 0);
    }
    
    /**
     * Tests real MAX operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMAXVariables() throws IOException {
        reasoningTest("realMAXVariables", 0);
    }
    
    /**
     * Tests real MIN operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMINVariables() throws IOException {
        reasoningTest("realMINVariables", 0);
    }
    
    /**
     * Tests real == and &lt;&gt; operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealEqVariables() throws IOException {
        reasoningTest("realEqVariables", 0);
    }
    
    /**
     * Tests real &gt; operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealGreaterThanVariables() throws IOException {
        reasoningTest("realGreaterThanVariables", 0);
    }
    
    /**
     * Tests real &gt;= operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealGreaterThanOrEqualsVariables() throws IOException {
        reasoningTest("realGreaterThanOrEqualsVariables", 0);
    }
    
    /**
     * Tests real &lt; operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealLessThenVariables() throws IOException {
        reasoningTest("realLessThanVariables", 0);
    }
    
    /**
     * Tests real &lt;= operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealLessThenOrEqualsVariables() throws IOException {
        reasoningTest("realLessThanOrEqualsVariables", 0);
    }
    
    // ---------------------------------- Mix constants ----------------------------------
    
    /**
     * Tests mix MAX operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testMixMAXVariables() throws IOException {
        reasoningTest("mixMAXVariables", 0);
    }
    
    /**
     * Tests mix MIN operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testMixMINVariables() throws IOException {
        reasoningTest("mixMINVariables", 0);
    }
    
    // ---------------------------------- Boolean constants ----------------------------------
    
    /**
     * Tests boolean OR operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testBooleanORConstants() throws IOException {
        reasoningTest("booleanORConstants", 0);
    }
    
    /**
     * Tests boolean AND operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanANDConstants() throws IOException {
        reasoningTest("booleanANDConstants", 0);
    }
    
    /**
     * Tests boolean XOR operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testBooleanXORConstants() throws IOException {
        reasoningTest("booleanXORConstants", 0);
    }
    
    /**
     * Tests boolean NOT operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testBooleanNOTConstants() throws IOException {
        reasoningTest("booleanNOTConstants", 0);
    } 
    
    // ---------------------------------- Boolean variables ----------------------------------
    
    /**
     * Tests boolean OR operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanORVariables() throws IOException {
        reasoningTest("booleanORVariables", 0);
    }
    
    /**
     * Tests boolean AND operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanANDVariables() throws IOException {
        reasoningTest("booleanANDVariables", 0);
    }
    
    /**
     * Tests boolean XOR operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanXORVariables() throws IOException {
        reasoningTest("booleanXORVariables", 0);
    }
    
    /**
     * Tests boolean NOT operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanNOTVariables() throws IOException {
        reasoningTest("booleanNOTVariables", 0);
    }
    
    /**
     * Tests boolean Implies operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanImpliesVariables() throws IOException {
        reasoningTest("booleanImpliesVariables", 0);
    }
    
    /**
     * Tests boolean IFF operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanIFFVariables() throws IOException {
        reasoningTest("booleanIFFVariables", 0);
    }
    
    /**
     * Tests boolean EvaluateValueAssign operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanEvaluateValueAssignVariables() throws IOException {
        reasoningTest("booleanEvaluateValueAssignVariables", 0);
    }
    
    // ----------------------------------- String -----------------------
    
    /**
     * Tests String operations.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testStringOperationsIsValid() throws IOException {
        reasoningTest("string", 0);
    }
    
// ----------------------------------- Complicated Types -----------------------
    
    /**
     * Tests SequenceOf operations.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testSequenceOperationsIsValid() throws IOException {
        reasoningTest("sequence", 0);
    }

    // ----------------------------------- Typedefs -----------------------
    
    /**
     * Tests simple typedef operations (valid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefValid() throws IOException {
        reasoningTest("typedef", 0);
    }
    
    /**
     * Tests typedef using another typedef (valid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefOfTypedefValid() throws IOException {
        reasoningTest("typedefOfTypedefValid", 0);
    }
    
    /**
     * Tests typedef using another typedef (invalid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefOfTypedefInvalid() throws IOException {
        reasoningTest("typedefOfTypedefInvalid", 1);
    }
    
    /**
     * Tests typedef nested inside a compound (valid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefNestedInCompoundValid() throws IOException {
        reasoningTest("typedefNestedInCompoundValid", 0);
    }
    
    /**
     * Tests typedef nested inside a compound (invalid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefNestedInCompoundInvalid() throws IOException {
        reasoningTest("typedefNestedInCompoundInvalid", 1);
    }

    /**
     * Tests typedef of compound nested/applied inside a sequence (valid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefCompoundNestedInSequenceValid1() throws IOException {
        reasoningTest("typedefCompoundNestedInSequenceValid1", 0);
    }
    
    /**
     * Tests typedef of compound nested/applied inside a compound (invalid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefCompoundNestedInSequenceInvalid1() throws IOException {
        reasoningTest("typedefCompoundNestedInSequenceInvalid1", 1);
    }
    
    /**
     * Tests typedef of compound nested/applied inside a sequence (valid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefCompoundNestedInSequenceValid2() throws IOException {
        reasoningTest("typedefCompoundNestedInSequenceValid2", 0);
    }
    
    /**
     * Tests typedef of compound nested/applied inside a compound (invalid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefCompoundNestedInSequenceInvalid2() throws IOException {
        reasoningTest("typedefCompoundNestedInSequenceInvalid2", 2);
    }

    /**
     * Tests typedef nested inside a set (valid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefNestedInSetValid() throws IOException {
        reasoningTest("typedefNestedInSetValid", 0);
    }
    
    /**
     * Tests typedef nested inside a set (invalid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefNestedInSetInvalid() throws IOException {
        reasoningTest("typedefNestedInSetInvalid", 1);
    }
    
    /**
     * Tests typedef nested inside a sequence (valid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefNestedInSequenceValid() throws IOException {
        reasoningTest("typedefNestedInSequenceValid", 0);
    }
    
    /**
     * Tests typedef nested inside a sequence (invalid).
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefNestedInSequenceInvalid() throws IOException {
        reasoningTest("typedefNestedInSequenceInvalid", 1);
    }
    
    /**
     * Tests whether an alias (typed without a constraint) can be used to define a compound.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testAliasesInContainerValid() throws IOException {
        reasoningTest("AliasUsedInSet", 0);
    }
    
    // ----------------------------------- Value validation -----------------------
    
    /**
     * Tests value validation.
     *   - Qualified names
     *   - Constraints outside compound
     *   - No assign blocks
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testValueValidation1IsValid() throws IOException {
        reasoningTest("valueValidation1", 0);
    }
    
    /**
     * Tests value validation.
     *   - Qualified names
     *   - Constraints inside compound
     *   - No assign blocks
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testValueValidation2IsValid() throws IOException {
        reasoningTest("valueValidation2", 0);
    }
    
    /**
     * Tests value validation.
     *   - Unqualified names
     *   - Constraints inside compound
     *   - No assign blocks
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testValueValidation3IsValid() throws IOException {
        reasoningTest("valueValidation3", 0);
    }
    
    /**
     * Tests value validation.
     *   - Unqualified names
     *   - Constraints outside compound
     *   - Assign block on constraint
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testValueValidation4IsValid() throws IOException {
        reasoningTest("valueValidation4", 0);
    }
    
    /**
     * Tests value validation.
     *   - Qualified names
     *   - Constraints inside compound
     *   - Assign block on constraint
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testValueValidation5IsValid() throws IOException {
        reasoningTest("valueValidation5", 0);
    }
    
    /**
     * Tests value validation.
     *   - Unqualified names
     *   - Constraints inside compound
     *   - Assign block on constraint
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testValueValidation6IsValid() throws IOException {
        reasoningTest("valueValidation6", 0);
    }
    
    /**
     * Tests value validation.
     *   - Qualified names
     *   - Constraints inside compound
     *   - Assign block on variables
     * 
     * @throws IOException in case of problems reading a model
     */ 
    @Test
    public void testValueValidation7IsValid() throws IOException {
        reasoningTest("valueValidation7", 0);
    }
    
    /**
     * Tests value validation.
     *   - Unqualified names
     *   - Constraints inside compound
     *   - Assign block on variables
     * 
     * @throws IOException in case of problems reading a model
     */ 
    @Test
    public void testValueValidation8IsValid() throws IOException {
        reasoningTest("valueValidation8", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names
     *  - Constraints inside compound
     *  - Assign block on variables and constraints (one assign block)
     * @throws IOException in case of problems reading a model
     */ 
    @Test
    public void testValueValidation9IsValid() throws IOException {
        reasoningTest("valueValidation9", 0);
    }
    
    /**
     * Tests value validation.
     *   - Unqualified names
     *   - Constraints inside compound
     *   - Assign block on variables and constraints (one assign block)
     * 
     * @throws IOException in case of problems reading a model
     */ 
    @Test
    public void testValueValidation10IsValid() throws IOException {
        reasoningTest("valueValidation10", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names
     *  - Constraints inside compound
     *  - Assign block on variables and constraints (two assign block, same attributes)
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testValueValidation11IsValid() throws IOException {
        reasoningTest("valueValidation11", 0);
    }
    
    /**
     * Tests value validation.
     *  - Unqualified names
     *  - Constraints inside compound
     *  - Assign block on variables and constraints (two assign block, same attributes)
     * @throws IOException in case of problems reading a model
     */ 
    @Test
    public void testValueValidation12IsValid() throws IOException {
        reasoningTest("valueValidation12", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names
     *  - Constraints inside compound
     *  - Assign block on variables and constraints (two assign block, different attributes)
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testValueValidation13IsValid() throws IOException {
        reasoningTest("valueValidation13", 0);
    }
    
    /**
     * Tests value validation.
     *  - Unqualified names
     *  - Constraints inside compound
     *  - Assign block on variables and constraints (two assign block, different attributes)
     * @throws IOException in case of problems reading a model
     */  
    @Test
    public void testValueValidation14IsValid() throws IOException {
        reasoningTest("valueValidation14", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names (type)
     *  - Constraints outside compound
     *  - Assign block on constraints
     * @throws IOException in case of problems reading a model
     */     
    @Test
    public void testValueValidation15IsValid() throws IOException {
        reasoningTest("valueValidation15", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names (instance)
     *  - Constraints outside compound
     *  - Assign block on constraints
     * @throws IOException in case of problems reading a model
     */     
    @Test
    public void testValueValidation16IsValid() throws IOException {
        reasoningTest("valueValidation16", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names (type)
     *  - Constraints outside compound
     *  - Assign block on variables
     * @throws IOException in case of problems reading a model
     */     
    @Test
    public void testValueValidation17IsValid() throws IOException {
        reasoningTest("valueValidation17", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names (instance)
     *  - Constraints outside compound
     *  - Assign block on variables
     * @throws IOException in case of problems reading a model
     */     
    @Test
    public void testValueValidation18IsValid() throws IOException {
        reasoningTest("valueValidation18", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names (type)
     *  - Constraints outside compound
     *  - Assign block on variables and constraints (two assign block, same attributes)
     * @throws IOException in case of problems reading a model
     */     
    @Test
    public void testValueValidation19IsValid() throws IOException {
        reasoningTest("valueValidation19", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names (instance)
     *  - Constraints outside compound
     *  - Assign block on variables and constraints (two assign block, same attributes)
     * @throws IOException in case of problems reading a model
     */     
    @Test
    public void testValueValidation20IsValid() throws IOException {
        reasoningTest("valueValidation20", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names (type)
     *  - Constraints outside compound
     *  - Assign block on variables and constraints (two assign block, different attributes)
     * @throws IOException in case of problems reading a model
     */     
    @Test
    public void testValueValidation21IsValid() throws IOException {
        reasoningTest("valueValidation21", 0);
    }
    
    /**
     * Tests value validation.
     *  - Qualified names (instance)
     *  - Constraints outside compound
     *  - Assign block on variables and constraints (two assign block, different attributes)
     * @throws IOException in case of problems reading a model
     */     
    @Test
    public void testValueValidation22IsValid() throws IOException {
        reasoningTest("valueValidation22", 0);
    }
    
    // ----------------------------------- Annotations -----------------------
    
    /**
     * Tests whether different slots of a compound can be assigned to different annotations.
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testAnnotationsToDifferenCompoundSlotsValid() throws IOException {
        reasoningTest("annotationAssignedToDifferentCompoundSlotsValid", 0);
    }

    // --------------------------User defined operations -----------------------

    /**
     * Tests whether operations can be selected through dynamic dispatch in a complex refinement hierarchy.
     * Reasoner should detect an error.
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testDynamicDispatchIsInvalid() throws IOException {
        reasoningTest("DynamicDispatchIsInvalid", 1);
    }
    
    /**
     * Tests whether operations can be selected through dynamic dispatch in a complex refinement hierarchy.
     * Reasoner should <b>not</b> detect an error.
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testDynamicDispatchIsValid() throws IOException {
        reasoningTest("DynamicDispatchIsValid", 0);
    }
    
}
