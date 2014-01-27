package de.uni_hildesheim.sse.varModel.datatypes;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.validation.IvmlValidationVisitor;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

/**
 * This class tests the commonalities of {@link Set}s and {@link Sequence}s, implemented in the super class
 * {@link Container}.
 * 
 * @author El-Sharkawy
 *
 */
public class ContainerTest {
    
    private Project project;
    private Set setType;
    private Sequence seqType;
    
    /**
     * setUp for all test cases. 
     */
    @Before
    public void setUp() {
        // Create project and datatypes.
        project = new Project("a_project");
        setType = new Set("SetType", IntegerType.TYPE, project);
        seqType = new Sequence("SeqType", IntegerType.TYPE, project);
        project.add(setType);
        project.add(seqType);
        
        //Check whether project is valid and can be used for testing.
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        Assert.assertEquals("Project is not valid, and cannot be used for testing other components",
            0, validator.getMessageCount());
    }
    
    /**
     * Tests the correct behavior of the isAssignableFrom method of sub classes of the container class.
     */
    @Test
    public void testIsAssignableFrom() {
        // Check whether inherited class are assignable from a container
        Assert.assertTrue("Error: Set is not a container", Container.TYPE.isAssignableFrom(setType));
        Assert.assertTrue("Error: Sequence is not a container", Container.TYPE.isAssignableFrom(seqType));
    }
}
