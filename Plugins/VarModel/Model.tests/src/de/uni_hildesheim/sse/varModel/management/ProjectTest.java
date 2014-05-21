package de.uni_hildesheim.sse.varModel.management;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;

/**
 * JUnit test class to check the basis methods of the Project class.
 * 
 * @author heiko beck
 *
 */
public class ProjectTest {

    /**
     * The test case creates an empty Project.
     */
    @Test
    public void testEmptyProject() {
        String testName = "Test1";
        Project testProject = new Project(testName);
        Assert.assertEquals(testName, testProject.getName());
        Assert.assertEquals(0, testProject.getElementCount());              
    }
    
    /**
     * The test case creates an empty Project and fills it with data. 
     */
    @Test
    public void testToFillProject() {
        
        String testName = "Test2";
        String cpName = "CP1";
        Project testProject = new Project(testName);
        Compound cp = new Compound(cpName, testProject);
        //modelElement list of testProject should be empty.
        Assert.assertEquals(0, testProject.getElementCount());
        //add an object to the modelElement list of testObject
        testProject.add(cp);
        Assert.assertEquals(1, testProject.getElementCount());
    }

}
