package de.uni_hildesheim.sse.reasoning.core.frontend;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests individual operations.
 * 
 * @author Holger Eichelberger
 */
public abstract class OperationTests extends AbstractReasonerFrontendTest {

    /**
     * Performs a test directly located in the operations test directory [convenience].
     * 
     * @param localFile the name of the file directly located in the test directory
     * @param isValid whether the model shall be valid (or not) to pass
     * 
     * @throws IOException in case of problems reading a model
     */
    private void performOpCheck(String localFile, boolean isValid) throws IOException {
        performCheck("operations/" + localFile, isValid);
    }
    
 // ---------------------------------- Integer constants ----------------------------------
    /**
     * Tests integer equality and unequality operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerConstants() throws IOException {
        performOpCheck("integerEqConstants.ivml", true);
    }
    
    /**
     * Tests integer add operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testIntegerAddConstants() throws IOException {
        performOpCheck("integerAddConstants.ivml", true);
    }

    /**
     * Tests integer subtraction operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testIntegerSubConstants() throws IOException {
        performOpCheck("integerSubConstants.ivml", true);
    }

    /**
     * Tests integer multiplication operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */   
    @Test
    public void testIntegerMulConstants() throws IOException {
        performOpCheck("integerMulConstants.ivml", true);
    }
    
    /**
     * Tests integer multiplication operations on constants which shall fail.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerMulConstantsFail() throws IOException {
        performOpCheck("integerMulConstantsFail.ivml", false);
    }
    
    /**
     * Tests integer division operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test    
    public void testIntegerDivConstants() throws IOException {
        performOpCheck("integerDivConstants.ivml", true);
    }
    
    /**
     * Tests integer division operations on constants which shall fail.
     * 
     * @throws IOException in case of problems reading a model
     */  
    @Test // Must fail div by 0
    public void testIntegerDivConstantsFail() throws IOException {
        performOpCheck("integerDivConstantsFail.ivml", false);
    }
    
    /**
     * Tests integer ABS operations on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testIntegerABSConstants() throws IOException {
        performOpCheck("integerABSConstants.ivml", true);
    }
    
    /**
     * Tests integer DIV operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerDIVopConstants() throws IOException {
        performOpCheck("integerDIVopConstants.ivml", true);
    }
    
    /**
     * Tests integer MOD operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMODopConstants() throws IOException {
        performOpCheck("integerMODopConstants.ivml", true);
    }
    
    /**
     * Tests integer MAX operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMAXConstants() throws IOException {
        performOpCheck("integerMAXConstants.ivml", true);
    }
    
    /**
     * Tests integer MIN operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerMINConstants() throws IOException {
        performOpCheck("integerMINConstants.ivml", true);
    }
    
    /**
     * Tests integer > operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerGreaterThanConstants() throws IOException {
        performOpCheck("integerGreaterThanConstants.ivml", true);
    }
    
    /**
     * Tests integer < operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerLessThanConstants() throws IOException {
        performOpCheck("integerLessThanConstants.ivml", true);
    }
    
    /**
     * Tests integer <= operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerLessThanOrEqualsConstants() throws IOException {
        performOpCheck("integerLessThanOrEqualsConstants.ivml", true);
    }
    
    /**
     * Tests integer >= operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerGreaterThanOrEqualsConstants() throws IOException {
        performOpCheck("integerGreaterThanOrEqualsConstants.ivml", true);
    }

    // ---------------------------------- Integer variables ----------------------------------
    
    /**
     * Tests integer equality and unequality operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerEqVariables() throws IOException {
        performOpCheck("integerEqVariables.ivml", true);
    }

    /**
     * Tests integer equality and unequality operations on simple variables which shall fail.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerEqVariablesFail() throws IOException {
        performOpCheck("integerEqVariablesFail.ivml", false);
    }

    /**
     * Tests integer add operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerAddVariables() throws IOException {
        performOpCheck("integerAddVariables.ivml", true);
    }

    /**
     * Tests integer subtraction operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerSubVariables() throws IOException {
        performOpCheck("integerSubVariables.ivml", true);
    }

    /**
     * Tests integer multiplication operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerMulVariables() throws IOException {
        performOpCheck("integerMulVariables.ivml", true);
    }

    /**
     * Tests integer division operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerDivVariables() throws IOException {
        performOpCheck("integerDivVariables.ivml", true);
    }
    
    /**
     * Tests integer division operations on simple variables which shall fail.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerDivVariablesFails() throws IOException {
        performOpCheck("integerDivVariablesFail.ivml", false);
    }
    
    /**
     * Tests integer ABS operations on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testIntegerABSVariables() throws IOException {
        performOpCheck("integerABSVariables.ivml", true);
    }
    
    /**
     * Tests integer DIV operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerDIVopVariables() throws IOException {
        performOpCheck("integerDIVopVariables.ivml", true);
    }
    
    /**
     * Tests integer MOD operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMODopVariables() throws IOException {
        performOpCheck("integerMODopVariables.ivml", true);
    }
    
    /**
     * Tests integer MAX operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMAXVariables() throws IOException {
        performOpCheck("integerMAXVariables.ivml", true);
    }
    
    /**
     * Tests integer MIN operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test 
    public void testIntegerMINVariables() throws IOException {
        performOpCheck("integerMINVariables.ivml", true);
    }

    /**
     * Tests integer > operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test 
    public void testIntegerGreaterThanVariables() throws IOException {
        performOpCheck("integerGreaterThanVariables.ivml", true);
    }
    
    /**
     * Tests integer < operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test 
    public void testIntegerLessThanVariables() throws IOException {
        performOpCheck("integerLessThanVariables.ivml", true);
    }
    
    /**
     * Tests integer <= operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test 
    public void testIntegerLessThanOrEqualsVariables() throws IOException {
        performOpCheck("integerLessThanOrEqualsVariables.ivml", true);
    }
    
    /**
     * Tests integer >= operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test 
    public void testIntegerGreaterThanOrEqualsVariables() throws IOException {
        performOpCheck("integerGreaterThanOrEqualsVariables.ivml", true);
    }
    
    // ---------------------------------- Real constants ----------------------------------
    /**
     * Tests real + operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealAddConstants() throws IOException {
        performOpCheck("realAddConstants.ivml", true);
    }
    
    /**
     * Tests real + operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealDivConstants() throws IOException {
        performOpCheck("realDivConstants.ivml", true);
    }
    
    /**
     * Tests real * operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMulConstants() throws IOException {
        performOpCheck("realMulConstants.ivml", true);
    }
    
    /**
     * Tests real - operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealSubConstants() throws IOException {
        performOpCheck("realSubConstants.ivml", true);
    }
    
    /**
     * Tests real - operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealABSConstants() throws IOException {
        performOpCheck("realABSConstants.ivml", true);
    }
    
    /**
     * Tests real FLOOR operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealFLOORConstants() throws IOException {
        performOpCheck("realFLOORConstants.ivml", true);
    }
    
    /**
     * Tests real ROUND operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealROUNDConstants() throws IOException {
        performOpCheck("realROUNDConstants.ivml", true);
    }
    
    /**
     * Tests real MAX operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testRealMAXConstants() throws IOException {
        performOpCheck("realMAXConstants.ivml", true);
    }
    
    /**
     * Tests real MIN operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMINConstants() throws IOException {
        performOpCheck("realMINConstants.ivml", true);
    }
    
    /**
     * Tests real == and <> operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealEqConstants() throws IOException {
        performOpCheck("realEqConstants.ivml", true);
    }
    
    /**
     * Tests real > operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealGreaterThanConstants() throws IOException {
        performOpCheck("realGreaterThanConstants.ivml", true);
    }    
    
    /**
     * Tests real >= operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealGreaterThanOrEqualsConstants() throws IOException {
        performOpCheck("realGreaterThanOrEqualsConstants.ivml", true);
    } 
    
    /**
     * Tests real > operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealLessThanConstants() throws IOException {
        performOpCheck("realLessThanConstants.ivml", true);
    } 
    
    /**
     * Tests real >= operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealLessThanOrEqualsConstants() throws IOException {
        performOpCheck("realLessThanOrEqualsConstants.ivml", true);
    } 
   
 // ---------------------------------- Real variables ----------------------------------
    /**
     * Tests real + operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealAddVariables() throws IOException {
        performOpCheck("realAddVariables.ivml", true);
    }
    
    /**
     * Tests real / operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealDivVariables() throws IOException {
        performOpCheck("realDivVariables.ivml", true);
    }
    
    /**
     * Tests real * operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMulVariables() throws IOException {
        performOpCheck("realMulVariables.ivml", true);
    }
    
    /**
     * Tests real - operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealSubVariables() throws IOException {
        performOpCheck("realSubVariables.ivml", true);
    }
    
    /**
     * Tests real - operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealABSVariables() throws IOException {
        performOpCheck("realABSVariables.ivml", true);
    }
    
    /**
     * Tests real FLOOR operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealFLOORVariables() throws IOException {
        performOpCheck("realFLOORVariables.ivml", true);
    }
    
    /**
     * Tests real ROUND operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealROUNDVariables() throws IOException {
        performOpCheck("realROUNDVariables.ivml", true);
    }
    
    /**
     * Tests real MAX operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMAXVariables() throws IOException {
        performOpCheck("realMAXVariables.ivml", true);
    }
    
    /**
     * Tests real MIN operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealMINVariables() throws IOException {
        performOpCheck("realMINVariables.ivml", true);
    }
    
    /**
     * Tests real == and <> operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealEqVariables() throws IOException {
        performOpCheck("realEqVariables.ivml", true);
    }
    
    /**
     * Tests real > operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealGreaterThanVariables() throws IOException {
        performOpCheck("realGreaterThanVariables.ivml", true);
    }
    
    /**
     * Tests real >= operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealGreaterThanOrEqualsVariables() throws IOException {
        performOpCheck("realGreaterThanOrEqualsVariables.ivml", true);
    }
    
    /**
     * Tests real < operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealLessThenVariables() throws IOException {
        performOpCheck("realLessThanVariables.ivml", true);
    }
    
    /**
     * Tests real <= operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testRealLessThenOrEqualsVariables() throws IOException {
        performOpCheck("realLessThanOrEqualsVariables.ivml", true);
    }
    
 // ---------------------------------- Mix constants ----------------------------------
    /**
     * Tests mix MAX operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testMixMAXVariables() throws IOException {
        performOpCheck("mixMAXVariables.ivml", true);
    }
    
    /**
     * Tests mix MIN operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testMixMINVariables() throws IOException {
        performOpCheck("mixMINVariables.ivml", true);
    }
    
 // ---------------------------------- Boolean constants ----------------------------------
    /**
     * Tests boolean OR operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testBooleanORConstants() throws IOException {
        performOpCheck("booleanORConstants.ivml", true);
    }
    
    /**
     * Tests boolean AND operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanANDConstants() throws IOException {
        performOpCheck("booleanANDConstants.ivml", true);
    }
    
    /**
     * Tests boolean XOR operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testBooleanXORConstants() throws IOException {
        performOpCheck("booleanXORConstants.ivml", true);
    }
    
    /**
     * Tests boolean NOT operand on constants.
     * 
     * @throws IOException in case of problems reading a model
     */    
    @Test
    public void testBooleanNOTConstants() throws IOException {
        performOpCheck("booleanNOTConstants.ivml", true);
    } 
    
 // ---------------------------------- Boolean variables ----------------------------------
    /**
     * Tests boolean OR operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanORVariables() throws IOException {
        performOpCheck("booleanORVariables.ivml", true);
    }
    
    /**
     * Tests boolean AND operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanANDVariables() throws IOException {
        performOpCheck("booleanANDVariables.ivml", true);
    }
    
    /**
     * Tests boolean XOR operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanXORVariables() throws IOException {
        performOpCheck("booleanXORVariables.ivml", true);
    }
    
    /**
     * Tests boolean NOT operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanNOTVariables() throws IOException {
        performOpCheck("booleanNOTVariables.ivml", true);
    }
    
    /**
     * Tests boolean Implies operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanImpliesVariables() throws IOException {
        performOpCheck("booleanImpliesVariables.ivml", true);
    }
    
    /**
     * Tests boolean IFF operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanIFFVariables() throws IOException {
        performOpCheck("booleanIFFVariables.ivml", true);
    }
    
    /**
     * Tests boolean EvaluateValueAssign operand on simple variables.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBooleanEvaluateValueAssignVariables() throws IOException {
        performOpCheck("booleanEvaluateValueAssignVariables.ivml", true);
    }
    // ----------------------------------- String -----------------------
    
    /**
     * Tests String operations.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testStringOperationsIsValid() throws IOException {
        performOpCheck("string.ivml", true);
    }
    
// ----------------------------------- Complicated Types -----------------------
    
    /**
     * Tests SequenceOf operations.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testSequenceOperationsIsValid() throws IOException {
        performOpCheck("sequence.ivml", true);
    }
    
    /**
     * Tests SequenceOf operations.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testTypedefValid() throws IOException {
        performOpCheck("typedef.ivml", true);
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
        performOpCheck("valueValidation1.ivml", true);
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
        performOpCheck("valueValidation2.ivml", true);
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
        performOpCheck("valueValidation3.ivml", true);
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
        performOpCheck("valueValidation4.ivml", true);
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
        performOpCheck("valueValidation5.ivml", true);
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
        performOpCheck("valueValidation6.ivml", true);
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
        performOpCheck("valueValidation7.ivml", true);
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
        performOpCheck("valueValidation8.ivml", true);
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
        performOpCheck("valueValidation9.ivml", true);
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
        performOpCheck("valueValidation10.ivml", true);
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
        performOpCheck("valueValidation11.ivml", true);
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
        performOpCheck("valueValidation12.ivml", true);
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
        performOpCheck("valueValidation13.ivml", true);
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
        performOpCheck("valueValidation14.ivml", true);
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
        performOpCheck("valueValidation15.ivml", true);
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
        performOpCheck("valueValidation16.ivml", true);
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
        performOpCheck("valueValidation17.ivml", true);
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
        performOpCheck("valueValidation18.ivml", true);
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
        performOpCheck("valueValidation19.ivml", true);
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
        performOpCheck("valueValidation20.ivml", true);
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
        performOpCheck("valueValidation21.ivml", true);
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
        performOpCheck("valueValidation22.ivml", true);
    }
    
}
