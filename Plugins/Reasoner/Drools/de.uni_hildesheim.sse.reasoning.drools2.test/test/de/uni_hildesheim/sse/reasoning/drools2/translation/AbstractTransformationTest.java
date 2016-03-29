package de.uni_hildesheim.sse.reasoning.drools2.translation;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.test.AbstractTest;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.validation.IvmlValidationVisitor;

/**
 * Abstract super class for testing the sub classes of the {@link AbstractModelTranslator}.
 * 
 * @author El-Sharkawy
 * 
 */
public class AbstractTransformationTest extends AbstractTest<Project> {

    private static final File TESTDATA = determineTestDataFolder("reasonerCore.testdata.home");
    private static final File FOLDER = new File(TESTDATA, "operationsTemplates");
    
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
     * Frees the memory after testing.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        try {
            VarModel.INSTANCE.locations().removeLocation(FOLDER, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("Could not remove location of test files.");
        }
    }
    
    /**
     * Method for determining folder with IVML files.
     * @param property property
     * @return folder location
     */
    protected static File determineTestDataFolder(String property) {
        File testdataFolder = determineTestDataDir(property);
        String externalLocation = System.getProperty(property);
        
        // If no property was defined, use ReasonerCore.test/testdata directory
        if (null == externalLocation) {
            // Detour over the path avoids a NullPointer exception
            String path = testdataFolder.getAbsolutePath();
            testdataFolder = new File(path);
            testdataFolder = testdataFolder.getParentFile().getParentFile();
            testdataFolder = new File(testdataFolder, "ReasonerCore.test");
            testdataFolder = new File(testdataFolder, "testdata");
        }
            
        return testdataFolder;    
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
     * Creates a simple {@link Project} with one constraint (<tt>decisionName</tt> greater than <tt>number</tt>).
     * 
     * @param decisionName The name of the decision variable which is used inside the constraint-
     * @param number The number which is used inside the constraint
     * @return An array with 2 elements: The translated {@link ReasonerModel}, The translated {@link OCLFeatureCall}.
     * @throws ValueDoesNotMatchTypeException Should not occur, otherwise there is an error inside the
     *     {@link ValueFactory}
     * @throws CSTSemanticException Should not occur, otherwise there is an error inside the
     *     {@link Constraint#setConsSyntax(de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree)) method.
     * @throws ConfigurationException Should not occur, otherwise there is an error inside the
     *     {@link IDecisionVariable#setValue(Value, de.uni_hildesheim.sse.model.confModel.IAssignmentState))) method.
     */
    protected Object[] createModelWithSimpleConstraint(String decisionName, int number)
        throws ValueDoesNotMatchTypeException, CSTSemanticException, ConfigurationException {

        // Create Project with one variable and one constraint
        Project project = new Project("a_project");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration(decisionName, IntegerType.TYPE, project);
        project.add(decl);
        // Create constraint
        Value value = ValueFactory.createValue(decl.getType(), number);
        ConstantValue constValue = new ConstantValue(value);
        Variable variable = new Variable(decl);
        OCLFeatureCall call = new OCLFeatureCall(variable, OclKeyWords.GREATER, constValue);
        Constraint constraint = new Constraint(project);
        constraint.setConsSyntax(call);
        project.add(constraint);
        checkProject(project);
        
        // Create configuration and set one value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl);
        value = ValueFactory.createValue(decl.getType(), 5);
        var.setValue(value, AssignmentState.ASSIGNED);

        // Create ReasoningModel
        ReasonerModel model = new ReasonerModel(config, null);
        Object[] result = new Object[] {model, call};
        return result;
    }

    /**
     * checks whether a created project can be used for testing.
     * This method should be called, after a project was created manually.
     * @param project A project, which should be used for testing.
     */
    protected final void checkProject(Project project) {
        Assert.assertNotNull(project);
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        Assert.assertEquals(0, validator.getErrorCount());
    }
}
