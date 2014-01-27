package de.uni_hildesheim.sse.model.confModel;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * this class tests whether for all <code>IDatatype</code> {@link DecisionVariable}s can be created.
 * @author El-Sharkawy
 *
 */
public class DecisionVariableTest {

    
    private Project project;
    private Configuration config;
    
    /**
     * Creation of an empty project and configuration, needed for all tests.
     */
    @Before
    public void setUp() {
        project = new Project("project");
        config = new Configuration(project);
    }
    
    /**
     * This method tests whether it is possible to create a {@link DecisionVariable} for a {@link DerivedDatatype}.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise there is an error in the whole model
     * @throws CSTSemanticException Must not occur, otherwise there is an error in the whole model
     * @throws ConfigurationException Must not occur, otherwise there is an error in the whole model
     */
    @Test
    public void testDerivedDatatypeVariables()
        throws ValueDoesNotMatchTypeException, CSTSemanticException, ConfigurationException {
        
        //Create DerivedDatatype
        DerivedDatatype bitrate = new DerivedDatatype("Bitrate", IntegerType.TYPE, project);
        Variable var = new Variable(bitrate.getTypeDeclaration());
        Value value = ValueFactory.createValue(IntegerType.TYPE, "128");
        ConstantValue consValue = new ConstantValue(value);
        OCLFeatureCall constraint = new OCLFeatureCall(var, IntegerType.GREATER_INTEGER_INTEGER.getName(), consValue);
        Constraint cons = new Constraint(constraint, null);
        Constraint[] constraints = {cons};
        bitrate.setConstraints(constraints);
        
        //Create DecisionVariable
        DecisionVariableDeclaration videoBitrate = new DecisionVariableDeclaration("videoBitrate", bitrate, project);
        Value val = ValueFactory.createValue(bitrate, "5");
        VariableCreator creator = new VariableCreator(videoBitrate, config, true);
        IDecisionVariable decVar = creator.getVariable();
        Assert.assertNotNull(decVar);
        Assert.assertSame(videoBitrate, decVar.getDeclaration());
        decVar.setValue(val, AssignmentState.ASSIGNED);
        Assert.assertNotNull(decVar.getValue());
        Assert.assertEquals("5", decVar.getValue().getValue().toString());
    }
    
    /**
     * Tests whether a new value and {@link AssignmentState#FROZEN} can be assigned to an
     * {@link IDecisionVariable} using the setValue method.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise there is an error in the whole model
     * @throws ConfigurationException Must not occur, otherwise there is an error in the whole model
     */
    @Test
    public void testSetValueWithFreeze() throws ValueDoesNotMatchTypeException, ConfigurationException {
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("a", IntegerType.TYPE, project);
        project.add(decl);
        config.refresh();
        IDecisionVariable var = config.getDecision(decl);
        Assert.assertNotNull(var);
        
        Value val = ValueFactory.createValue(decl.getType(), "1");
        Assert.assertNotNull(val);
        var.setValue(val, AssignmentState.FROZEN);
        Assert.assertNotNull(var.getValue());
        Assert.assertEquals(AssignmentState.FROZEN, var.getState());
        Assert.assertEquals("1", var.getValue().getValue().toString());
    }

}
