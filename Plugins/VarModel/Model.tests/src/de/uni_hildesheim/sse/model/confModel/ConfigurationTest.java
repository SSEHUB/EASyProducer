package de.uni_hildesheim.sse.model.confModel;

import java.net.URI;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * This class tests the correct behavior of the configuration.
 * @author El-Sharkawy
 *
 */
public class ConfigurationTest {
    
    private Project project;
    private Configuration configuration;
    
    /**
     * SetUp method: creates an empty project together with a configuration.
     * @throws URISyntaxException Must not occur
     */
    @Before
    public void setUp() throws URISyntaxException {
        project = new Project("configurationTestProject");
        // This call overwrites old instances of projects with same name and version number
        URI fictiveLocation = new URI("path/" + project.getName());
        VarModel.INSTANCE.updateModel(project, fictiveLocation);
        configuration = new Configuration(project);        
    }

    /**
     * This method tests whether the constructor works fine.
     * It mainly tests the correct instantiation of decision variables.
     */
    @Test
    public void testInstantiation() {
        //Test empty configuration, should be empty even after refreshing it
        Assert.assertEquals(0, configuration.getDecisionCount());
        configuration.refresh();
        Assert.assertEquals(0, configuration.getDecisionCount());
        
        //Create one declaration, refresh configuration, and test element count
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(intA);
        configuration.refresh();
        Assert.assertEquals(1, configuration.getDecisionCount());
        
        //Test whether variable do not have any values.
        IDecisionVariable variable = configuration.getDecision(intA);
        Assert.assertNotNull(variable);
        Assert.assertNull(variable.getValue());
    }
    
    /**
     * Tests the correct instantiation of decisions having a default value.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is an error in the configuration
     */
    @Test
    public void testDefaultValueAssignment() throws ValueDoesNotMatchTypeException {
        //Create project & configuration
        String valueForIntA = "5";
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        intA.setValue(valueForIntA);
        project.add(intA);
        configuration.refresh();
        
        //Test behavior of configuration
        IDecisionVariable variable = configuration.getDecision(intA);
        Assert.assertNotNull(variable);
        Assert.assertNotNull(variable.getValue());
        Assert.assertEquals(ValueFactory.createValue(intA.getType(), valueForIntA), variable.getValue());
    }
    
    /**
     * Tests the correct instantiation of decisions having a default value.
     * This test case test the behavior of compound assignments
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is an error in the configuration
     */
    @Test
    public void testDefaultValueAssignmentCompound() throws ValueDoesNotMatchTypeException {
        //Create project & configuration
        String valueForIntA = "5";
        Compound cmp = new Compound("CMP", project);
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, cmp);
        intA.setValue(valueForIntA);
        cmp.add(intA);
        project.add(cmp);
        DecisionVariableDeclaration cmpInstance = new DecisionVariableDeclaration("cp", cmp, project);
        project.add(cmpInstance);
        
        configuration.refresh();
        
        //Test behavior of configuration
        IDecisionVariable variable = configuration.getDecision(cmpInstance);
        Assert.assertNotNull(variable);
        Assert.assertNotNull(variable.getValue());
        Assert.assertNotNull(variable.getValue().isConfigured());
    }
    
    /**
     * Tests whether the configuration will be stored into a new project will be created.
     * This method does not tests the whole saving process,
     * instead the correct behavior depending to the given parameter is tested.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise a failure inside the {@link ValueFactory} exists
     * @throws ConfigurationException Must not occur otherwise a failure inside the
     * {@link IDecisionVariable#setValue(Value, IAssignmentState)} exists
     * @see #testToNewProject()
     */
    @Test
    public void testToOwnProject() throws ValueDoesNotMatchTypeException, ConfigurationException {
        // Create Project/Configuration with one (configured) variable.
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(intA);
        configuration.refresh();
        IDecisionVariable varIntA = configuration.getDecision(intA);
        Value intAValue = ValueFactory.createValue(intA.getType(), "5");
        varIntA.setValue(intAValue, AssignmentState.ASSIGNED);
        
        // Save precondition
        int elementsInProject = project.getElementCount();
        
        // Save into same and different project
        Project confInSameProject = configuration.toProject(false);
        
        // Test post condition for saving into same project
        Assert.assertSame(project, confInSameProject);
        Assert.assertEquals(elementsInProject + 1, project.getElementCount());
    }
    
    /**
     * Tests whether the configuration will be stored into the related project.
     * This method does not tests the whole saving process,
     * instead the correct behavior depending to the given parameter is tested.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise a failure inside the {@link ValueFactory} exists
     * @throws ConfigurationException Must not occur otherwise a failure inside the
     * {@link IDecisionVariable#setValue(Value, IAssignmentState)} exists
     * @see #testToOwnProject()
     */
    @Test
    public void testToNewProject() throws ValueDoesNotMatchTypeException, ConfigurationException {
        // Create Project/Configuration with one (configured) variable.
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(intA);
        configuration.refresh();
        IDecisionVariable varIntA = configuration.getDecision(intA);
        Value intAValue = ValueFactory.createValue(intA.getType(), "5");
        varIntA.setValue(intAValue, AssignmentState.ASSIGNED);
        
        // Save precondition
        int elementsInProject = project.getElementCount();
        
        // Save into same and different project
        Project confInNewProject = configuration.toProject(true);
        
        // Test post condition for saving into different project
        Assert.assertNotSame(project, confInNewProject);
        Assert.assertEquals(elementsInProject, project.getElementCount());
        Assert.assertEquals(elementsInProject, confInNewProject.getElementCount());
    }

}
