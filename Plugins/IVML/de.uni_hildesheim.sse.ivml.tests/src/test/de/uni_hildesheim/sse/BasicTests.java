package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.translation.ErrorCodes;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * A test class for blackbox testing parser and type resolution. Please note
 * that the outputs of the model visitor must exactly match to the input file.
 * We defined here individual test cases instead of loop in order to display
 * them as individual test and to simplify debugging. Please note that although 
 * constraint variables are defined as basic types using them is considered as 
 * advanced modelling and, thus, tested in {@link AdvancedTests}.
 * 
 * @author Holger Eichelberger
 */
public class BasicTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(getTestDataDir(), "basic");

    /**
     * Creates a file object relative to {@link #DIR} (not a file).
     * 
     * @param name the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }

    /**
     * Tests the AnyType datatype.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAnyType() throws IOException {
        assertEqual(createFile("anyType"), "anyType", "0");
    }
    
    /**
     * Tests the basic datatypes with defaults.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBasicDatatypesDefaults() throws IOException {
        assertEqual(createFile("basicDatatypesDefaults"),
                "testBasicDatatypesDefaults", "0");
    }

    /**
     * Tests the basic datatypes without defaults.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBasicDatatypesNoDefaults() throws IOException {
        assertEqual(createFile("basicDatatypesNoDefaults"),
                "testBasicDatatypesNoDefaults", "0");
    }

    /**
     * Tests compounds.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompound() throws IOException {
        assertEqual(createFile("compound"), "testCompounds", "0");
    }
    
    /**
     * Tests compounds with failing access as not directly defined.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundFail() throws IOException {
        assertEqual(createFile("compoundFail"), "compoundFail", "0", ErrorCodes.UNKNOWN_ELEMENT);
    }

    /**
     * Tests an abstract compound.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAbstractCompound() throws IOException {
        assertEqual(createFile("abstractCompound"), "abstractCompound", "0");
    }

    /**
     * Tests a failing abstract compound (instantiation).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAbstractCompoundFail() throws IOException {
        assertEqual(createFile("abstractCompoundFail"), "abstractCompoundFail", "0", 
            ValueDoesNotMatchTypeException.IS_ABSTRACT);
    }
    
    /**
     * Tests a failing project, where accidentally parentheses are added behind a variable
     * name. No user defined operations are defined.
     * Bug detected at 01.07.2015
     * 
     * @throws IOException should not occur
     */
    //@Ignore
    @Test
    public void testUndefinedOperationFail() throws IOException {
        assertEqual(createFile("undefinedOperationFail"), "undefinedOperationFail", "0",
            CSTSemanticException.UNKNOWN_OPERATION);
    }
    
    /**
     * Tests compound accesses.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundAccess() throws IOException {
        assertEqual(createFile("compoundAccess"), "testCompoundAccess", "0");
    }

    /**
     * Tests compound constraint variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundConstraintVar() throws IOException {
        assertEqual(createFile("compoundConstraintVar"), "testCompoundConstraintVar", "0");
    }
    
    /**
     * Tests constraints.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstraints() throws IOException {
        assertEqual(createFile("constraints"), "testConstraints", "0");
    }

    /**
     * Tests containers.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContainer() throws IOException {
        assertEqual(createFile("container"), "testContainer", "0");
    }

    /**
     * Tests container with associated constraints.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContainerConstraints() throws IOException {
        assertEqual(createFile("containerConstraints"),
                "testContainerConstraints", "0");
    }

    /**
     * Tests container with associated constraints (min/max iterator).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContainerConstraints2() throws IOException {
        assertEqual(createFile("containerConstraints2"),
                "testContainerConstraints2", "0");
    }

    /**
     * Tests container with associated constraints (extended apply).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContainerConstraints3() throws IOException {
        assertEqual(createFile("containerConstraints3"),
                "testContainerConstraints3", "0");
    }

    /**
     * Tests container with associated constraints.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContainerConstraintsFail() throws IOException {
        assertEqual(createFile("containerConstraintsFail"),
                "testContainerConstraintsFail", "0",
                CSTSemanticException.TYPE_MISMATCH);
    }

    /**
     * Tests the empty project.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEmptyProject() throws IOException {
        assertEqual(createFile("emptyProject"), "testEmptyProject", "");
    }

    /**
     * Tests enumerations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEnumerations() throws IOException {
        assertEqual(createFile("enumerations"), "testEnumerations", "0");
    }

    /**
     * Tests min/max on ordered enums.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEnumerations2() throws IOException {
        assertEqual(createFile("enumerations2"), "testEnumerations2", "0");
    }

    /**
     * Tests the enumeration ordinal operation.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEnumerationOrdinal() throws IOException {
        assertEqual(createFile("enumerationOrdinal"), "testEnumerationOrdinal", "0");
    }

    /**
     * Tests failing enumerations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEnumerationsFail() throws IOException {
        assertEqual(createFile("enumerationsFail"), "testEnumerationsFail",
                "0", ErrorCodes.INITIALIZER_CONSISTENCY,
                ErrorCodes.INITIALIZER_CONSISTENCY);
    }

    /**
     * Tests failing enumerations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEnumerationsFail2() throws IOException {
        assertEqual(createFile("enumerationsFail2"), "testEnumerationsFail2",
                "0", ErrorCodes.NAME_CLASH);
    }

    /**
     * Tests the all instances operation.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAllInstances() throws IOException {
        assertEqual(createFile("allInstances"), "allInstances", "0");
    }
    
    /**
     * Tests constants.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstants() throws IOException {
        assertEqual(createFile("constants"), "constants", "0");
    }

    /**
     * Tests constant failures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstantsFail() throws IOException {
        assertEqual(createFile("constantsFail"), "constantsFail", "0", ErrorCodes.REDEFINITION);
    }
    
    /**
     * Tests nested enums.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEval() throws IOException {
        assertEqual(createFile("eval"), "testEval", "0");
    }

    /**
     * Tests initializers at basic compounds.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInitializersBasicCompounds() throws IOException {
        assertEqual(createFile("initializersBasicCompounds"),
                "testInitializersBasicCompounds", "0");
    }

    /**
     * Tests initializers at basic containers.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInitializersBasicContainers() throws IOException {
        assertEqual(createFile("initializersBasicContainers"),
                "testInitializersBasicContainers", "0");
    }

    /**
     * Tests custom initializers.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInitializersCustom() throws IOException {
        assertEqual(createFile("initializersCustom"), "testInitializersCustom", "0");
    }

    /**
     * Tests the assignment of null to a reference variable.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferencesNull() throws IOException {
        assertEqual(createFile("referencesNull"), "referencesNull", "0");
    }

    /**
     * Tests abuse of references.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferencesFail1() throws IOException {
        assertEqual(createFile("referencesFail1"), "referencesFail1", "0", ErrorCodes.TYPE_CONSISTENCY);
    }

    /**
     * Tests abuse of references.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferencesFail2() throws IOException {
        assertEqual(createFile("referencesFail2"), "referencesFail2", "0", CSTSemanticException.TYPE_MISMATCH);
    }

    /**
     * Tests custom typedefs.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypedef() throws IOException {
        assertEqual(createFile("typedef"), "testTypedef", "0");
    }

    /**
     * Tests custom typedefs.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypedefCompound1() throws IOException {
        assertEqual(createFile("typedefCompound1"), "testTypedefCompound1", "0");
    }

    /**
     * Tests custom typedefs.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypedefCompound1Fail() throws IOException {
        assertEqual(createFile("typedefCompound1Fail"), "testTypedefCompound1Fail", "0", ErrorCodes.TYPE_CONSISTENCY);
    }

    
    /**
     * Tests custom typedefs. (failing)
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypedefFail() throws IOException {
        assertEqual(createFile("typedefFail"), "testTypedefFail", "0", ErrorCodes.NAME_CLASH);
    }
    
    /**
     * Tests custom typedefs on compounds (SAP case).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypedefCompounds() throws IOException {
        assertEqual(createFile("typedefCompound"), "testTypedefCompound", "0");
    }

    /**
     * Tests custom typedefs.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundConstraintReferringToOutside() throws IOException {
        assertEqual(createFile("compoundConstraintReferringToOutside"),
                "outsideConstraint", "0");
    }

    /**
     * Tests static compound access (SAP case).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStaticCompoundAccess() throws IOException {
        assertEqual(createFile("staticCompoundAccess"), "staticCompoundAccess", "0");
    }
    
    /**
     * Tests the basic datatypes without defaults.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypedefSubsequent() throws IOException {
        assertEqual(createFile("typedefSubsequent"), "testTypedefSubsequent", "0");
    }
    
    /**
     * Tests implication operations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImplies() throws IOException {
        assertEqual(createFile("implies"), "impliesM", "0");
    }

    /**
     * Tests implication operations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImpliesFail() throws IOException {
        assertEqual(createFile("impliesFail"), "impliesFail", "0", ErrorCodes.ASSIGNMENT);
    }
    
    /**
     * Tests whether container duplicates are handled correctly. As a pattern with duplicates
     * is passed to both, a set and a sequence, two errors may occur. This test will assert
     * the notification of these errors.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContainerDuplicates() throws IOException {
        assertEqual(createFile("containerDuplicates"), "testContainerDuplicates", "0", 
            ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE, 
            ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE);
    }

    /**
     * Tests the syntax of operation definitions (contributed by QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testOperationDefinitions() throws IOException {
        assertEqual(createFile("opDef"), "opDef", "0");
    }

    /**
     * Tests null values.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testNullValues() throws IOException {
        assertEqual(createFile("nullValues"), "testNullValues", "0");
    }

    /**
     * Tests compound initializations (contributed by Sascha).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundInit() throws IOException {
        assertEqual(createFile("compoundInit"), "compoundInit", "0");
    }
    
    /**
     * Tests evals in compounds (contributed by QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundEval() throws IOException {
        assertEqual(createFile("compoundEval"), "compoundEval", "0");
    }
    
    /**
     * Tests a failing compound initializations as a container initializer 
     * is used (contributed by Sascha).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundInitFail() throws IOException {
        assertEqual(createFile("compoundInitFail"), "compoundInitFail", "0", ErrorCodes.INITIALIZER_CONSISTENCY);
    } 
    
    /**
     * Tests correct handling of String values containing escape sequences. The desired behavior is:
     * <ul>
     *   <li>They should be escaped while writing the text file</li>
     *   <li>Parser should be able to read escaped characters</li>
     *   <li>Should <b>not</b> be escaped in the data model</li>
     * </ul>
     * 
     * This test tests:
     * <ul>
     *   <li>Tab</li>
     *   <li>double quotes</li>
     *   <li>line break</li>
     *   <li>backslash</li>
     * </ul>
     * 
     * Each time as default value and also as assignment.
     * @throws IOException should not occur
     */
    @Test
    public void testStringEscapeSequences() throws IOException {
        List<Project> projects = assertEqual(createFile("stringEscapedValues"), "testStringEscapeSequences", "0");
        
        Assert.assertEquals("File does not contain exactly one project.", 1, projects.size());
        Project project = projects.get(0);
        for (int i = 0, end = project.getElementCount(); i < end; i++) {
            ContainableModelElement element = project.getElement(i);
            if (element instanceof AbstractVariable) {
                ConstantValue defaultValue = (ConstantValue) ((AbstractVariable) element).getDefaultValue();
                if (null != defaultValue) {
                    String strValue = defaultValue.getConstantValue().getValue().toString();
                    // Consider backslash value while checking whether the value was escaped during parsing
                    boolean valueWasEscaped = strValue.contains("\\") && strValue.length() > 1;
                    Assert.assertFalse("Default value of \"" + element.getName() + "\" was escaped: " + strValue,
                        valueWasEscaped);
                }
            } else if (element instanceof Constraint) {
                OCLFeatureCall assignment = (OCLFeatureCall) ((Constraint) element).getConsSyntax();
                Value assignedValue = ((ConstantValue) assignment.getParameter(0)).getConstantValue();
                String strValue = assignedValue.getValue().toString();
                // Consider backslash value while checking whether the value was escaped during parsing
                boolean valueWasEscaped = strValue.contains("\\") && strValue.length() > 1;
                Assert.assertFalse("Default value of \"" + element.getName() + "\" was escaped: " + strValue,
                    valueWasEscaped);
            }
        }
    }
    
    /**
     * Test whether values of Boolean/Constraint sequences are correctly initialized.
     * @throws IOException should not occur
     */
    @Test
    public void testSequenceValueInitialization() throws IOException {
        List<Project> projects = assertEqual(createFile("sequenceValueInitialization"), "sequenceValueInitialization",
            "0");
        
        // Search for the two declarations
        Assert.assertEquals("File does not contain exactly one project.", 1, projects.size());
        DeclarationFinder finder = new DeclarationFinder(projects.get(0), FilterType.ALL, null);
        List<AbstractVariable> variables = finder.getVariableDeclarations(VisibilityType.ALL);
        Assert.assertEquals("Project has not exactly 2 declarations.", 2, variables.size());
        AbstractVariable consSeq = null;
        AbstractVariable boolSeq = null;
        for (int i = 0; i < variables.size(); i++) {
            AbstractVariable var = variables.get(i);
            if ("consSeq".equals(var.getName())) {
                consSeq = var;
            } else if ("boolSeq".equals(var.getName())) {
                boolSeq = var;
            }
        }
        ContainerValue consValue = (ContainerValue) extractDefaultValue(consSeq, "consSeq");
        ContainerValue boolValue = (ContainerValue) extractDefaultValue(boolSeq, "boolSeq");
        
        // Test: Check correct type of ContainerValue AND of their nested elements
        Assert.assertSame("Error: Value of \"consSeq\" is not the correct IDatatype.", ConstraintType.TYPE,
            consValue.getContainedType());
        Assert.assertSame("Error: Value of \"consSeq\" is not the correct IDatatype.", ConstraintType.TYPE,
            consValue.getElement(0).getType());
        Assert.assertSame("Error: Value of \"boolSeq\" is not the correct IDatatype.", BooleanType.TYPE,
            boolValue.getContainedType());
        Assert.assertSame("Error: Value of \"boolSeq\" is not the correct IDatatype.", BooleanType.TYPE,
            boolValue.getElement(0).getType());
    }
    
    /**
     * Helpermethod: Extracts the {@link Value} out of the default value from the given {@link AbstractVariable}.
     * @param var The declaration which shall contain a default value.
     * @param varName The name of the declaration (for proper error messages).
     * @return The default value of the {@link AbstractVariable}. Will fail if the declaration does not have any.
     */
    private Value extractDefaultValue(AbstractVariable var, String varName) {
        Assert.assertNotNull("Declaration of \"" + varName + "\" not found.", var);
        ConstraintSyntaxTree cst = var.getDefaultValue();
        Value containerValue = null;
        try {
            containerValue = (Value) ((ConstantValue) cst).getConstantValue();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
            Assert.fail(cce.getMessage());
        }
        Assert.assertNotNull("Variable \"" + varName + "\" has no default value.", containerValue);
        return containerValue;
    }
    
}
