package de.uni_hildesheim.sse.varModel.values;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the correct behavior of {@link NullValue}s.
 * @author El-Sharkawy
 *
 */
public class NullValueTest {
        
    private Project project;
    private Configuration config;
    private int nOfVariables;
    
    /**
     * Creates a project/configuration for testing.
     */
    @Before
    public void setUp() {
        project = new Project("testProject");
        
        nOfVariables = ProjectTestUtilities.createInstancesForAllDatatypes(project);        
        ProjectTestUtilities.validateProject(project);

        config = new Configuration(project);
    }
    
    /**
     * Tests whether {@link NullValue}s can be assigned to all kind of variables. 
     */
    @Test
    public void testIsAssignable() {
        int variablesChecked = 0;
        for (IDecisionVariable variable : config) {
            //checkstyle: stop exception type check 
            try {
                variable.setValue(NullValue.INSTANCE, AssignmentState.ASSIGNED);
                variablesChecked++;
            } catch (Exception e) {
                IDatatype type = variable.getDeclaration().getType();
                Assert.fail("Error: Could not assign NullValue to a " + type + " variable.");
            }
            //checkstyle: resume exception type check
        }
        Assert.assertEquals("Error: More or less variables were tested than expected.", nOfVariables, variablesChecked);
    }

}
