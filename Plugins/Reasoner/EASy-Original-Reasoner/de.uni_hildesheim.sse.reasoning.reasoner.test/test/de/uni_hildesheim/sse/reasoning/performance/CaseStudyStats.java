package de.uni_hildesheim.sse.reasoning.performance;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import de.uni_hildesheim.sse.reasoning.reasoner.Engine;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasonerCore.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasonerCore.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class CaseStudyStats extends de.uni_hildesheim.sse.reasoning.AbstractTest {
    
    private static final File FOLDER = new File(TESTDATA, "performanceModels");
    
    /**
     * Initializes this Test class.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
        try {
            VarModel.INSTANCE.locations().addLocation(FOLDER, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("Could not add location of test files.");
        }
    }
    
    /**
     * Frees the memory after testing.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        try {
            VarModel.INSTANCE.locations().removeLocation(FOLDER, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("Could not remove location of test files.");
        }
    }
    
    /**
     * Helper method for load an IVML file.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    private Project loadProject(String path) {
        return loadProject(FOLDER, path);
    }
    
    /**
     * Method for comparing reasoning result.
     * @param expectedFailedConstraints Number of expected failed constraints.
     * @param expectedReevaluationCount Number of expected reevaluations.
     * @param projectP1 Project to reason on.
     */
    public static void resultComparer(int expectedFailedConstraints, int expectedReevaluationCount, Project projectP1) {
        Configuration config = new Configuration(projectP1, false);        
        ReasonerConfiguration rConfig = new ReasonerConfiguration();

        // Perform reasoning
        Engine engine = new Engine(projectP1, config, rConfig, ProgressObserver.NO_OBSERVER);
        ReasoningResult result = engine.reason();
        
        // Test whether reasoning detected correct result  
        int failedConstraints = 0;
        for (int i = 0; i < result.getMessageCount(); i++) {
            if (result.getMessage(i).getStatus() == Status.ERROR) {
                failedConstraints = failedConstraints + result.getMessage(i).getConflicts().size();
            }
        }
        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, failedConstraints);
        
        // Test whether reasoning is done in correct reevalustion steps  
        Assert.assertTrue("Reevaluation count mismatch. Result: " + engine.getReevaluationCount()
            + " Expected: " + expectedReevaluationCount, engine.getReevaluationCount() == expectedReevaluationCount);
    }  
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param ivmlFile IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     * @param expectedReevaluationCount Number of expected reevaluations.
     */        
    public void reasoningTest(String ivmlFile, int expectedFailedConstraints, int expectedReevaluationCount) {
        Project project = loadProject(ivmlFile);
        resultComparer(expectedFailedConstraints, expectedReevaluationCount, project);
    }   
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param p0 IVML file to translate and reason on.
     * @param p1 IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     * @param expectedReevaluationCount Number of expected reevaluations.
     */        
    public void reasoningTest(String p0, String p1, int expectedFailedConstraints, int expectedReevaluationCount) {
        Project projectP0 = loadProject(p0);
        Project projectP1 = loadProject(p1);
        ProjectImport importP0 = new ProjectImport(projectP0.getName(), null);
        projectP1.addImport(importP0);
        resultComparer(expectedFailedConstraints, expectedReevaluationCount, projectP1);
    } 
    
    /**
     * Simple Assignments.
     */
    @Test    
    public void simpleAssignments() {
        reasoningTest("SimpleAssignments.ivml", 1, 6);       
    } 
    
    /**
     * Simple Assignments with Constraint Variables.
     */
    @Test    
    public void simpleAssignmentsWithConstraintVar() {
        reasoningTest("SimpleAssignmentsWithConstraintVars.ivml", 1, 6);       
    }     
    
    /**
     * Simple Assignments in Compound.
     */
    @Test    
    public void compoundSimpleAssignments() {
        reasoningTest("CompoundSimpleAssignments.ivml", 1, 6);       
    } 
    
    /**
     * Simple Assignments with Constraint Variables in Compound.
     */
    @Test    
    public void compoundSimpleAssignmentsWithConstraintVar() {
        reasoningTest("CompoundSimpleAssignmentsWithConstraintVars.ivml", 1, 6);       
    }  
    
    /**
     * Compound constraints in collection.
     */
    @Test    
    public void compoundConstraintsInCollection() {
        reasoningTest("CompoundConstraintsInCollection.ivml", 1, 3);       
    } 
    
    /**
     * Compound constraints with constraint variables in collection.
     */
    @Test    
    public void compoundConstraintsInCollectionWithConstraintVars() {
        reasoningTest("CompoundConstraintsInCollectionWithConstraintVars.ivml", 1, 3);       
    }  
    
    /**
     * Collection of typedef.
     */
    @Test    
    public void typedefCollections() {
        reasoningTest("TypedefCollections.ivml", 1, 5);       
    } 
    
    /**
     * Collection of typedef in compound.
     */
    @Test    
    public void typedefCollectionsInCompound() {
        reasoningTest("TypedefCollectionsInCompound.ivml", 1, 5);       
    }     
   

}
