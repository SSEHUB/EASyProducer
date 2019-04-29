package test.net.ssehub.easy.reasoning.core.reasoner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.test.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.AttributeException;
import net.ssehub.easy.reasoning.core.reasoner.AttributeValues;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Tests the {@link AttributeValues} class.
 * @author El-Sharkawy
 *
 */
public class AttributeValuesTest extends AbstractTest<Project> {
    
    private static final File TESTDATA = determineTestDataDir("reasonerCore.testdata.home");
    private static final File FOLDER = new File(TESTDATA, "reasoner/");
    
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
            if (0 == result.getMessageCount()) {
                project = result.getResult(0);
            }
            Assert.assertNotNull("Error: The loaded project " + path + " is NULL (should not happen)", project);
            VarModel.INSTANCE.updateModel(project, projectFile.toURI());
        } catch (IOException exc) {
            Assert.fail(exc.getLocalizedMessage());
        }
        
        return project;
    }
    
    /**
     * Tests whether the attributes variables could be found using the {@link AttributeValues} class.
     * This class tests the {@link AttributeValues#hasValue(AbstractVariable, Value)} and the
     * {@link AttributeValues#contains(Attribute)} method.
     * @throws AttributeException Should not occur, otherwise the {@link AttributeValues#contains(Attribute)} is broken.
     */
    @Test
    public void testHasValue() throws AttributeException {
        String givenAttribute = "attributeStateVariable";
        String givenValue = "STATE_1";
        
        Project project = loadProject("AttributedProject.ivml");
        Configuration config = new Configuration(project);
        AttributeValues attrValues = new AttributeValues();
        List<String> values = new ArrayList<String>();
        values.add(givenValue);
        attrValues.addUnresolved(givenAttribute, values);
        attrValues.resolveUsing(project, true);
        
        for (IDecisionVariable var : config) {
            IDecisionVariable attributeVar = var.getAttribute(0);
            AbstractVariable attributeDecl = attributeVar.getDeclaration();
            Value value = attributeVar.getValue();
            if (null != value) {
                String attributeName = attributeDecl.getName();
                EnumLiteral literal = (EnumLiteral) value.getValue();
                if (givenAttribute.equals(attributeName) && givenValue.equals(literal.toString())) {
                    Assert.assertTrue("Expected attribute not found: " + attributeName + " on " 
                        + var.getDeclaration().getQualifiedName(), attrValues.contains((Attribute) attributeDecl));
                    Assert.assertTrue("Expected attribute assignment not found: " + attributeName + ":"
                        + literal.getName(), attrValues.hasValue(attributeDecl, value));
                } else {
                    Assert.assertFalse(attrValues.hasValue(attributeDecl, value));
                }
            }
        }
    }

}
