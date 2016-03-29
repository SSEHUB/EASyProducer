package net.ssehub.easy.varModel.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Test setting of {@link Reference} values.
 * @author El-Sharkawy
 *
 */
public class ReferenceValueTest {

    private static final String COMPOUND_NAME = "cmp";
    
    private Configuration config;
    private DecisionVariableDeclaration cmpDecl;
    private DecisionVariableDeclaration refDecl;
    
    /**
     * Creates a project, which is needed as toplevel element.
     */
    @Before
    public void setUp() {
        Project project = new Project("project");
        
        // Create Compound
        Compound cmp = new Compound("CP", project);
        cmp.add(new DecisionVariableDeclaration("intA", IntegerType.TYPE, cmp));
        cmp.add(new DecisionVariableDeclaration("intB", IntegerType.TYPE, cmp));
        cmpDecl = new DecisionVariableDeclaration(COMPOUND_NAME, cmp, project);
        project.add(cmpDecl);
        
        // Create Reference
        Reference ref = new Reference("Ref", cmp, project);
        refDecl = new DecisionVariableDeclaration("ref", ref, project);
        project.add(refDecl);
        
        //Create Configuration
        config = new Configuration(project);
    }
    
    /**
     * Tests correct behavior of the ValueFactory regarding {@link Reference} values.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise there is a bug inside the RefernceValue creation
     * inside the ValueFactory 
     * @throws ConfigurationException Must not occur, otherwise there is a bug in assigning reference values.
     */
    @Test
    public void testSetValue() throws ValueDoesNotMatchTypeException, ConfigurationException {
        IDecisionVariable refVar = config.getDecision(refDecl);
        
        //Test precondition: Variable must not be assigned
        Assert.assertEquals(AssignmentState.UNDEFINED, refVar.getState());

        // generic use of Reference.TYPE for creating values is deprecated - specific types must be used
        Value refValue = ValueFactory.createValue(refVar.getDeclaration().getType(), cmpDecl);
        refVar.setValue(refValue, AssignmentState.ASSIGNED);
        
        // Test postcondition: variable must be assigned.
        Assert.assertEquals(AssignmentState.ASSIGNED, refVar.getState());
    }

}
