package de.uni_hildesheim.sse.varModel.values;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

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
        
        Value refValue = ValueFactory.createValue(Reference.TYPE, cmpDecl);
        refVar.setValue(refValue, AssignmentState.ASSIGNED);
        
        // Test postcondition: variable must be assigned.
        Assert.assertEquals(AssignmentState.ASSIGNED, refVar.getState());
    }

}
