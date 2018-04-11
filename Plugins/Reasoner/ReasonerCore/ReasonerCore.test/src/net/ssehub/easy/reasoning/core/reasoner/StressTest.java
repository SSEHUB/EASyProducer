package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Test;

/**
 * Stresstests.
 * 
 * @author krafczyk
 */
public class StressTest extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected StressTest(ITestDescriptor descriptor) {
        super(descriptor, "stresstest");
    }

    /**
     * Tests whether boolean default values are handled correctly.
     */
    @Test
    public void testBooleanDefault() {
        // Test whether default values for booleans are not treated as project constraints
        reasoningTest("BooleanDefault.1.ivml", 0);
        // Test whether default values for booleans are applied to them
        reasoningTest("BooleanDefault.2.ivml", 1);
    }
    
    /**
     * Tests whether boolean implies values are handled correctly.
     */
    @Test
    public void testBooleanImplies() {
        reasoningTest("BooleanImplies.ivml", 1);
    }
    
    /**
     * Tests whether constraint variables are evaluated correctly.
     */
    @Test
    public void testConstraintEvaluation() {
        reasoningTest("ConstraintEval.ivml", 1);
    }
    
    /**
     * Tests whether overridden default values for constraint variables are evaluated correctly.
     */
    @Test
    public void testConstraintDefaults() {
        reasoningTest("ConstraintDefault.1.ivml", 0); 
        reasoningTest("ConstraintDefault.2.ivml", 1);
    }
    
    /**
     * Tests whether automatic assignment of undefined variables in constraints
     * via == results in failing constraints.
     */
    @Test
    public void testUndefinedVariables() {
        reasoningTest("UndefinedVariables.ivml", 1);
    }
    
    /**
     * Tests whether typedefs work correctly with compounds.
     */
    @Test
    public void testCompoundTypedef() {
        // Tests whether simple typedefs ("aliases") work
        reasoningTest("CompoundTypedef.1.ivml", 0);
        // Tests whether typedefs with "with" work
        reasoningTest("CompoundTypedef.2.ivml", 1);
    }
    
    /**
     * Tests whether typedefs work correctly with sequences and sets.
     */
    @Test
    public void testSetAndSequenceTypedef() {
        // Tests whether simple typedefs ("aliases") work with sets and sequences
        reasoningTest("SetAndSequenceTypedef.ivml", 2);
        // Tests whether typedefs of typedefs and "with" works for sequences
        reasoningTest("SequenceTypedefWith.ivml", 1);
    }
    
    /**
     * Tests whether constraints in refined compounds produce the right number of error messages.
     */
    @Test
    public void testCompoundRefineConstraints() {
        reasoningTest("CompoundRefineConstraints.ivml", 1);
    }
    
    /**
     * Tests whether typedef constraints are correctly evaluated in sequences / sets.
     */
    @Test
    public void testTypedefConstraintsInSequences() {
        reasoningTest("TypedefConstraintSequence.ivml", 1);
    }
    
    /**
     * Tests whether out-of-bounds accesses to sequences are handled correctly.
     */
    @Test
    public void testOutOfBoundsIndex() {
        reasoningTest("OutOfBoundsIndex.ivml", 0);
    }
    
    /**
     * Tests whether size() works for null sets and sequences.
     */
    @Test
    public void testNullSize() {
        reasoningTest("NullSize.ivml", 0);
    }
    
    /**
     * Tests whether == in implies LHS is treated correctly.
     */
    @Test
    public void testPropagationSyntax() {
        reasoningTest("PropagationSyntax1.ivml", 0);
    }
    
    /**
     * Tests whether undefined values in if are handled correctly.
     */
    @Test
    public void testIfWithUndefinedValues() {
        reasoningTest("UndefinedIf.ivml", 0);
    }
    
    /**
     * Tests whether constraints with undefined variables are ignored.
     */
    @Test
    public void testUndefinedVariableConstraints() {
        reasoningTest("UndefinedVariableConstraints.ivml", 0);
    }
    
    /**
     * Tests whether constants passed to custom operations don't cause exceptions.
     */
    @Test
    public void testConstantInCustomOperation() {
        reasoningTest("ConstantInCustomOperation.ivml", 0);
    }

}
