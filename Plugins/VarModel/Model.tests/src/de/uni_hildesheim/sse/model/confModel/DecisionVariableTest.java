package de.uni_hildesheim.sse.model.confModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

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
        project = new Project("testProject");
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
        ProjectTestUtilities.validateProject(project);
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

    /**
     * Tests whether the {@link IDecisionVariable#hasValue()} and {@link IDecisionVariable#hasNullValue()}
     * are working correctly.
     */
    @Test
    public void testHasValue() {
        // Create project with an instance for all IDatatypes
        final int noOfVariables = ProjectTestUtilities.createInstancesForAllDatatypes(project);
        ProjectTestUtilities.validateProject(project);
        config.refresh();
        
        // Test whether all variables did not have a value
        int noOfIterations = 0;
        for (IDecisionVariable var : config) {
            noOfIterations++;
            // Compounds are allowed to have an empty value...
            if (!Compound.TYPE.isAssignableFrom(var.getDeclaration().getType())) {
                Assert.assertFalse("Error: " + var.getDeclaration().getName() + " should not have a value, but it has.",
                    var.hasValue());
            }
        }
        Assert.assertEquals("Error: More or less variables were tested than expected.", noOfVariables, noOfIterations);
        
        // Test whether all variables can have a null value.
        noOfIterations = 0;
        for (IDecisionVariable var : config) {
            noOfIterations++;
            //checkstyle: stop exception type check 
            try {
                var.setValue(NullValue.INSTANCE, AssignmentState.ASSIGNED);
                Assert.assertTrue("Error: Variable should have a NullValue, but it is not shown.", var.hasValue());
                Assert.assertTrue("Error: Variable should have a NullValue, but it is not shown.", var.hasNullValue());
            } catch (Exception e) {
                IDatatype type = var.getDeclaration().getType();
                Assert.fail("Error: Could not assign NullValue to a " + type + " variable.");
            }
            //checkstyle: resume exception type check
        }
        Assert.assertEquals("Error: More or less variables were tested than expected.", noOfVariables, noOfIterations);
        
        // Test whether the NullValue can be removed easily
        noOfIterations = 0;
        for (IDecisionVariable var : config) {
            noOfIterations++;
            IDatatype type = var.getDeclaration().getType();
            try {
                Value value = ValueFactory.createValue(type, (Object[]) null);
                var.setValue(value, AssignmentState.UNDEFINED);
            } catch (ValueDoesNotMatchTypeException e) {
                Assert.fail(e.getMessage());
            } catch (ConfigurationException e) {
                Assert.fail(e.getMessage());
            }
            
            // Compounds are allowed to have an empty value...
            if (!Compound.TYPE.isAssignableFrom(var.getDeclaration().getType())) {
                Assert.assertFalse("Error: " + var.getDeclaration().getName() + " should not have a value, but it has.",
                    var.hasValue());
            } else {
                Assert.assertTrue("Error: " + var.getDeclaration().getName() + " should have a value, but it has not.",
                    var.hasValue());
            }
        }
        Assert.assertEquals("Error: More or less variables were tested than expected.", noOfVariables, noOfIterations);
    }
    
    /**
     * Tests the {@link IDecisionVariable#getQualifiedName()} method.
     * Contrary to {@link de.uni_hildesheim.sse.model.varModel.ContainableModelElement#getQualifiedName()} this method
     * should also return unique names for nested {@link IDecisionVariable}s, e.g., nested inside a Compound.
     */
    @Test
    public void testQualifiedNames() {
        Compound dimType = new Compound("Dimension", project);
        project.add(dimType);
        DecisionVariableDeclaration declWidth = new DecisionVariableDeclaration("width", IntegerType.TYPE, dimType);
        DecisionVariableDeclaration declHeight = new DecisionVariableDeclaration("height", IntegerType.TYPE, dimType);
        dimType.add(declWidth);
        dimType.add(declHeight);
        DecisionVariableDeclaration dimDecl1 = new DecisionVariableDeclaration("dimension1", dimType, project);
        project.add(dimDecl1);
        DecisionVariableDeclaration dimDecl2 = new DecisionVariableDeclaration("dimension2", dimType, project);
        project.add(dimDecl2);
        
        ProjectTestUtilities.validateProject(project, true);
        config.refresh();
        
        IDecisionVariable cmpVar1 = config.getDecision(dimDecl1);
        IDecisionVariable cmpVar2 = config.getDecision(dimDecl2);
        
        // Test (unique) qualified names of all 6 variables.
        Assert.assertEquals(dimDecl1.getQualifiedName(), cmpVar1.getQualifiedName());
        Assert.assertEquals(dimDecl1.getQualifiedName() + IvmlKeyWords.COMPOUND_ACCESS + declWidth.getName(),
            cmpVar1.getNestedElement(0).getQualifiedName());
        Assert.assertEquals(dimDecl1.getQualifiedName() + IvmlKeyWords.COMPOUND_ACCESS + declHeight.getName(),
            cmpVar1.getNestedElement(1).getQualifiedName());
        Assert.assertEquals(dimDecl2.getQualifiedName(), cmpVar2.getQualifiedName());
        Assert.assertEquals(dimDecl2.getQualifiedName() + IvmlKeyWords.COMPOUND_ACCESS + declWidth.getName(),
            cmpVar2.getNestedElement(0).getQualifiedName());
        Assert.assertEquals(dimDecl2.getQualifiedName() + IvmlKeyWords.COMPOUND_ACCESS + declHeight.getName(),
            cmpVar2.getNestedElement(1).getQualifiedName());
        Assert.assertNotEquals(cmpVar1.getNestedElement(0).getQualifiedName(),
            cmpVar2.getNestedElement(0).getQualifiedName());
        Assert.assertNotEquals(cmpVar1.getNestedElement(1).getQualifiedName(),
            cmpVar2.getNestedElement(1).getQualifiedName());
    }
}
