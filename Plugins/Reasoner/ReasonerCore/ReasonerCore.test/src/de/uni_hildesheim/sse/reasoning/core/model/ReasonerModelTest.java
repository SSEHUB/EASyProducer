package de.uni_hildesheim.sse.reasoning.core.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.test.AbstractTest;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.reasoning.core.model.datatypes.CompoundType;
import de.uni_hildesheim.sse.reasoning.core.model.datatypes.EnumType;
import de.uni_hildesheim.sse.reasoning.core.model.datatypes.ReasonerDatatype;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributeException;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributeValues;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Tests the correct creation and behavior of the {@link ReasonerModel}.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class ReasonerModelTest extends AbstractTest<Project> {
    private static final File TESTDATA = determineTestDataDir("reasonerCore.testdata.home");
    private static final File FOLDER = new File(TESTDATA, "reasonerModel/");
    
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
     * Helper method for load an IVML file.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    protected Project loadProject(String path) {
        Project project = null;
        try {
            File projectFile = new File(FOLDER, path);
            URI uri = URI.createFileURI(projectFile.getAbsolutePath());
            TranslationResult<Project> result = ModelUtility.INSTANCE.parse(uri);
            StringBuffer errorMsg = new StringBuffer();
            for (int i = 0; i < result.getMessageCount(); i++) {
                Message msg = result.getMessage(i);
                if (!msg.ignore()) {
                    errorMsg.append(msg.getDescription());
                    errorMsg.append("\n");
                }
            }
            if (errorMsg.length() == 0) {
                project = result.getResult(0);
            } else {
                Assert.fail(errorMsg.toString());
            }
            Assert.assertNotNull("Error: The loaded project " + path + " is NULL (should not happen)", project);
            VarModel.INSTANCE.updateModel(project, projectFile.toURI());
        } catch (IOException exc) {
            Assert.fail(exc.getLocalizedMessage());
        }
        
        return project;
    }
    
    /**
     * Test whether all variable declarations are translated correctly into {@link ReasonerVariable}s.
     */
    @Test    
    public void simpleTranslationTest() {
        Project project = loadProject("SimpleTranslationTest.ivml");
        Configuration config = new Configuration(project, true);
        ReasonerModel rModel = new ReasonerModel(config, null);
        
        for (IDecisionVariable originVariable : config) {
            String name = originVariable.getDeclaration().getName();
            ReasonerVariable rVariable = rModel.getVariable(name);
            Assert.assertNotNull(rVariable);
            Assert.assertEquals(name, rVariable.getName());
            Assert.assertSame(originVariable, rVariable.getDecisionVariable());
            new DatatypeTester(rVariable);
        }        
    }
    
    /**
     * Test whether all variable ReasoningStates are assigned correctly.
     */
    @Test
    public void reasoningStateAssignmentTest() {
        // Check imported project
        Project projectImported = loadProject("StateCheckProjectImported.ivml");
        Configuration configImported = new Configuration(projectImported, true);
        ReasonerModel rModelImported = new ReasonerModel(configImported, null);
        
        Map<String, ReasoningState> expectedStates = new HashMap<String, ReasoningState>();
        expectedStates.put("a", ReasoningState.DEFAULT_SAME);
        expectedStates.put("b", ReasoningState.UNASSIGNED);
        expectedStates.put("c", ReasoningState.DEFAULT_SAME);
        
        checkCorrectStates(rModelImported, expectedStates);
        
        // Check main project
        Project project = loadProject("StateCheckProject.ivml");
        Configuration config = new Configuration(project, true);
        ReasonerModel rModel = new ReasonerModel(config, null);
        
        expectedStates.clear();
        expectedStates.put("a", ReasoningState.DEFAULT_SAME);
        expectedStates.put("b", ReasoningState.DEFAULT_SAME);
        expectedStates.put("c", ReasoningState.DEFAULT_SAME);
        expectedStates.put("d", ReasoningState.DEFAULT_SAME);
        expectedStates.put("e", ReasoningState.UNASSIGNED);
        expectedStates.put("f", ReasoningState.DEFAULT_SAME);
        
        checkCorrectStates(rModel, expectedStates);
    }

    /**
     * Helping method to test the correct assignments inside a {@link ReasonerModel}.
     * @param rModel The {@link ReasonerModel} to check.
     * @param expectedStates Expected {@link ReasoningState}s.
     *     A pair of (<tt>variable name</tt>, <tt>its expected state</tt>). 
     *     variable names not defined in the map, will be ignored.
     */
    private void checkCorrectStates(ReasonerModel rModel, Map<String, ReasoningState> expectedStates) {
        Configuration config = rModel.getConfiguration();
        for (IDecisionVariable originVariable : config) {
            String name = originVariable.getDeclaration().getName();
            ReasonerVariable rVariable = rModel.getVariable(name);           
            
            ReasoningState expectedState = expectedStates.get(name);
            if (null != expectedState) {
                ReasoningState actualState = rVariable.getReasoningState();
                Assert.assertEquals("Expected state for variable " + name + ":" + config.getProject().getName()
                    + " was " + expectedState + " but was " + actualState, expectedState, actualState);
            }
        }
    }
    
    /**
     * Test whether all constraints are retrieved correctly. At this moment only normal and internal constraints.
     */
    @Test
    public void constraintRetrievalTest() {     
        Project project = loadProject("ConstraintRetrievalCheck.ivml");
        Configuration config = new Configuration(project, true);
        ReasonerModel rModel = new ReasonerModel(config, null);
       
        // Normal Constraints
        List<ConstraintSyntaxTree> normalConstaintList
            = new ArrayList<ConstraintSyntaxTree>(rModel.getNormalConstraintCount());
        for (int i = 0; i < rModel.getNormalConstraintCount(); i++) {
            normalConstaintList.add(rModel.getNormalConstraint(i));
        }
        printConstraints(normalConstaintList);
        
        // Test normal constraints
        System.out.println("Normal constraint count: " + normalConstaintList.size());
        Assert.assertEquals("Number of normal constraints", 9, normalConstaintList.size());

        //Internal Constraints
        List<ConstraintSyntaxTree> internalConstaintList
            = new ArrayList<ConstraintSyntaxTree>(rModel.getInternalConstraintCount());
        for (int i = 0; i < rModel.getInternalConstraintCount(); i++) {
            internalConstaintList.add(rModel.getInternalConstraint(i));
        }
        printConstraints(internalConstaintList);
        
        
        // Test internal constraints
        System.out.println("Internal constraint count: " + internalConstaintList.size());
        Assert.assertEquals("Number of internal constraints", 3, internalConstaintList.size());
        for (int i = 0; i < internalConstaintList.size(); i++) {            
            OCLFeatureCall constraint = (OCLFeatureCall) internalConstaintList.get(i);
            Variable variable = (Variable) constraint.getOperand();
            AbstractVariable decl = variable.getVariable();
            IDatatype type = decl.getType();
            Assert.assertEquals(DerivedDatatype.class, type.getClass());
        }
        
        // Test ReasonerDatatypes
        int nDatatypes = 0;
        Iterator<ReasonerDatatype> datatypeIterator = rModel.datatypeIterator();
        while (datatypeIterator.hasNext()) {
            nDatatypes++;
            ReasonerDatatype customType = datatypeIterator.next();
            if (customType instanceof EnumType) {
                EnumType enumType = (EnumType) customType;
                if (enumType.getName().equals("View")) {
                    Assert.assertEquals(0, enumType.getMinOrdinal());
                    Assert.assertEquals(2, enumType.getMaxOrdinal());
                    Assert.assertTrue(enumType.isValidOrdinal(1));
                    Assert.assertFalse(enumType.isValidOrdinal(enumType.getMaxOrdinal() + 1));
                    Assert.assertFalse(enumType.isValidOrdinal(enumType.getMinOrdinal() - 1));
                } else if (enumType.getName().equals("ContentType")) {
                    Assert.assertEquals(1, enumType.getMinOrdinal());
                    Assert.assertEquals(8, enumType.getMaxOrdinal());
                    Assert.assertFalse(enumType.isValidOrdinal(3));
                    Assert.assertTrue(enumType.isValidOrdinal(4));
                    Assert.assertFalse(enumType.isValidOrdinal(5));
                    Assert.assertFalse(enumType.isValidOrdinal(enumType.getMaxOrdinal() + 1));
                    Assert.assertFalse(enumType.isValidOrdinal(enumType.getMinOrdinal() - 1));
                }
            } else {
                CompoundType cmpType = (CompoundType) customType;
                Assert.assertEquals(3, cmpType.getConstraintCount());
            }
        }
        Assert.assertEquals(3, nDatatypes);
    }    
    
    /**
     * Help method to print out constraints in a list.
     * @param constraints List to print out.
     */
    private void printConstraints(List<ConstraintSyntaxTree> constraints) {
        for (int i = 0; i < constraints.size(); i++) {
            String s = StringProvider.toIvmlString(constraints.get(i));
            System.out.println(s);            
        }
    }
    
    /**
     * Test whether all variables used in constraints are retrieved.
     */
    @Test
    public void variablesUsedInConstraintsTest() {
        
        Project project = loadProject("ConstraintRetrievalCheck.ivml");
        Configuration config = new Configuration(project, true);
        ReasonerModel rModel = new ReasonerModel(config, null);        
        Set<ReasonerVariable> usedVariables = rModel.getVariablesUsedInConstraints();
        
        Assert.assertEquals("Number of used variables", 5, usedVariables.size());
        System.out.println("Variables used in constraints: " + usedVariables.size());
        
        for (ReasonerVariable reasonerVariable : usedVariables) {
            System.out.println("Variable: " + reasonerVariable.getName() + " Type: "
                    + reasonerVariable.getClass().getSimpleName());
        }
    }
    
    /**
     * Tests whether the {@link ReasonerModel#isFullyConfigured()} method works for a project
     * having no attributes.
     */
    @Test
    public void fullyConfiguredTestNoAttributes() {
        // Fully configured project, without attributes.
        Project project = loadProject("FullyConfiguredProject_1.ivml");
        Configuration config = new Configuration(project, true);
        ReasonerModel rModel = new ReasonerModel(config, null);
        
        Assert.assertFalse(rModel.hasAttributes());
        Assert.assertTrue(rModel.isFullyConfigured());
        
        // Not fully configured project, without attributes.
        Project project2 = loadProject("FullyConfiguredProject_2.ivml");
        Configuration config2 = new Configuration(project2);
        ReasonerModel rModel2 = new ReasonerModel(config2, null);
        
        Assert.assertFalse(rModel2.hasAttributes());
        Assert.assertFalse(rModel2.isFullyConfigured());
    }
    
    /**
     * Tests whether the {@link ReasonerModel#isFullyConfigured()} method works for a project
     * having attributes.
     */
    @Test
    public void fullyConfiguredTestWithAttributes() {
        // Fully configured project, with attributes.
        Project project = loadProject("FullyConfiguredProject_3.ivml");
        Configuration config = new Configuration(project, true);
        ReasonerConfiguration settings = new ReasonerConfiguration();
        AttributeValues attrValues = new AttributeValues();
        settings.setAttributeValues(attrValues);
        List<String> values = new ArrayList<String>();
        values.add("STATE_1");
        attrValues.addUnresolved("attributeStateVariable", values);
        try {
            attrValues.resolveUsing(project, true);
        } catch (AttributeException exc) {
            Assert.fail(exc.getLocalizedMessage());
        }
        ReasonerModel rModel = new ReasonerModel(config, settings);
        
        Assert.assertTrue(rModel.hasAttributes());
        Assert.assertTrue(rModel.isFullyConfigured());
        
        // Not fully configured project, with attributes.
        Project project2 = loadProject("FullyConfiguredProject_4.ivml");
        Configuration config2 = new Configuration(project2);
        ReasonerConfiguration settings2 = new ReasonerConfiguration();
        AttributeValues attrValues2 = new AttributeValues();
        List<String> values2 = new ArrayList<String>();
        values2.add("STATE_1");
        attrValues2.addUnresolved("attributeStateVariable", values2);
        settings2.setAttributeValues(attrValues2);
        try {
            attrValues2.resolveUsing(project2, true);
        } catch (AttributeException exc) {
            Assert.fail(exc.getLocalizedMessage());
        }
        ReasonerModel rModel2 = new ReasonerModel(config2, settings2);
        
        Assert.assertTrue(rModel2.hasAttributes());
        Assert.assertFalse(rModel2.isFullyConfigured());
    }
}
