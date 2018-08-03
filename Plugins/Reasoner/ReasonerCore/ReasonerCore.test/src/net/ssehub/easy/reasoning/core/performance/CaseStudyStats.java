package net.ssehub.easy.reasoning.core.performance;

import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class CaseStudyStats extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected CaseStudyStats(ITestDescriptor descriptor) {
        super(descriptor, "performanceModels");
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
        reasoningTest("SimpleAssignmentsWithConstraintVars.ivml", 1, 9);       
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
        reasoningTest("CompoundSimpleAssignmentsWithConstraintVars.ivml", 1, 10);       
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
        reasoningTest("CompoundConstraintsInCollectionWithConstraintVars.ivml", 2, 15);       
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
        reasoningTest("TypedefCollectionsInCompound.ivml", 1, 3);       
    }     

}
