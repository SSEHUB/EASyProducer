package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Configures the operation tests for SSE reasoner.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class ReasoningScenarioTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected ReasoningScenarioTests(ITestDescriptor descriptor) {
        super(descriptor, "operationsTemplates");
    }

    /**
     * Initializes this Test class.
     */
    @Before
    public void setUpBeforeClass() {
        startup();
    }
    
    /**
     * Frees the memory after testing.
     */
    @After
    public void tearDownAfterClass() {
        shutdown();
    }
    
    /**
     * Basic test.
     */
    @Test    
    public void initialTest() {
        reasoningTest("InitialTest.ivml", 2);
    } 
    
    /**
     * Tests collections.
     */
    @Test    
    public void preCollectionTest() {
        reasoningTest("PreCollectionTest.ivml", 1);
    }
    
    /**
     * Tests duplicates.
     */
    @Ignore
    @Test    
    public void hasDuplicatesTestTest() {
        reasoningTest("HasDuplicatesTest.ivml", 0);
    }      
    
    /**
     * Tests freeze.
     */
    @Test    
    public void freezeTest() {
        reasoningTest("FreezeTest.ivml", 0);
    } 
    
    /**
     * Tests import freeze.
     */
    @Test    
    public void freezeImportTest() {
        reasoningTest("FreezeTest.ivml", "FreezeImportTest.ivml", 1);
    } 
    
    /**
     * Tests import freeze.
     */
    @Test 
    @Ignore
    public void nullTest() {
        reasoningTest("NullTest.ivml", 3);
    } 
    
    /**
     * Tests null import.
     */
    @Test  
    @Ignore
    public void nullImportTest() {
        reasoningTest("NullTest.ivml", "NullImportTest.ivml", 4);
    } 
    
    /**
     * Tests import child (1 failed constraint).
     */
    @Test    
    public void importChildTest() {
        reasoningTest("ImportChild.ivml", 1);
    } 
    
    /**
     * Tests import core (variable is reassigned and 0 constraints fail).
     */
    @Test    
    public void importCoreTest() {
        reasoningTest("ImportChild.ivml", "ImportCore.ivml", 0);
    } 
    
    /**
     * Tests internal constraints.
     */ 
    @Test
    @Ignore
    public void internalConstraintTest() {
        reasoningTest("InternalConstraintTest.ivml", 1);
    }
    
    /**
     * Tests constraint variables. 
     */ 
    @Test    
    public void constraintVariablesTest() {
        reasoningTest("ConstraintVariableTest.ivml", 2);
    }
    
    /**
     * Tests failed variables assignments.
     */ 
    @Test    
    public void variableAssignmentFailTest() {
        reasoningTest("VariableAssignmentFailTest.ivml", 1);
    }
    
    /**
     * Tests constraint variables.
     */ 
    @Test    
    public void compoundEqualityTest() {
        reasoningTest("CompoundEqualityTest.ivml", 0);
    }
    
    /**
     * Tests compound internal constraints.
     */
    @Test    
    public void constrainedCompoundTest() {
        reasoningTest("ConstrainedCompoundTest.ivml", 3);
    }
    
    /**
     * Tests annotation assignment.
     */
    @Test    
    public void annotationInitialTest() {
        reasoningTest("AnnotationInitialTest.ivml", 0);
    }
    
    /**
     * Tests annotations in compound.
     */
    @Test    
    public void annotationAssignedToDifferentCompoundSlotsValid() {
        reasoningTest("AnnotationAssignedToDifferentCompoundSlotsValid.ivml", 0);
    }
    
    /**
     * Tests compound nested constraints.
     */
    @Test    
    @Ignore
    public void refinedCompoundTest() {
        reasoningTest("RefinedCompoundTest.ivml", 0);
    }
    
    /**
     * Tests trace in failed elements.
     */
    @Test
    public void traceTest() {
        reasoningTest("TraceTest.ivml", 1);
    }
    
    /**
     * Tests trace in failed elements.
     */
    @Test
    public void nestedVariableReplaceTest() {
        reasoningTest("nestedVariableReplaceTest.ivml", 1);
    }
    
    /**
     * String patern test with internal constraint.
     */
    @Test
    public void internalConstraintStringPaternTest() {
        reasoningTest("internalConstraintStringPaternTest.ivml", 1);
    }
    
    /**
     * Inherited internal constraint test.
     */
    @Test
    public void internalConstraintInheritedTest() {
        reasoningTest("internalConstraintInheritedTest.ivml", 1);
    }
    
    /**
     * Inherited internal constraint in compound test.
     */
    @Test
    public void internalConstraintInheritedInCompoundTest() {
        reasoningTest("internalConstraintInheritedInCompoundTest.ivml", 1);
    }
    
    /**
     * Collection internal constraint test.
     */
    @Test
    public void internalConstraintCollectionTest() {
        reasoningTest("internalConstraintCollectionTest.ivml", 2);
    }
    
    /**
     * Collection internal constraint in compound test.
     */
    @Test
    public void internalConstraintCollectionInCompoundTest() {
        reasoningTest("internalConstraintCollectionInCompoundTest.ivml", 2);
    }
    
    /**
     * String pattern test with internal constraint.
     */
    @Test
    public void refToCompoundInSequenceTest() {
        reasoningTest("RefToCompoundInSequenceTest.ivml", 0);
    }
    
    /**
     * Default constraint reevaluation.
     */
    @Test
    public void defaultConstraintReevaluationTest() {
        reasoningTest("DefaultConstraintReevaluationTest.ivml", 1);
    }
    
    /**
     * isDefined test.
     */
    @Test
    public void isDefinedTest() {
        reasoningTest("IsDefinedTest.ivml", 10);
    }  
    
    /**
     * isDefined Compound test.
     */
    @Test
    public void isDefinedCompoundTest() {
        reasoningTest("IsDefinedCompoundTest.ivml", 1);
    }  
    
    /**
     * Test for collections of compounds equality operation.
     */
    @Test
    public void compoundCollectionEqualityTest() {
        reasoningTest("compoundCollectionEqualityTest.ivml", 1);
    }  
    
    /**
     * Test for collections of refTo(compounds) equality operation.
     */
    @Test
    public void refByCompoundCollectionEqualityTest() {
        reasoningTest("refByCompoundCollectionEqualityTest.ivml", 1);
    }  
    
    /**
     * Test for collections of string equality operation.
     */
    @Test
    public void stringCollectionEqualityTest() {
        reasoningTest("stringCollectionEqualityTest.ivml", 2);
    }
    
    /**
     * Test for incremental reasoning and clering derived values in configuration..
     */
    @Test
    public void clearConfigTest() {
        reasoningTest("ClearConfigBase.ivml", "ClearConfigCore.ivml", 0);
    }   

}
