package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import junit.framework.Assert;

import org.junit.Test;

import de.uni_hildesheim.sse.Config;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.ModelQueryException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.translation.ErrorCodes;
import de.uni_hildesheim.sse.translation.UnknownTypeException;

/**
 * A test class for blackbox testing parser and type resolution. Please note
 * that the outputs of the model visitor must exactly match to the input file.
 * We defined here individual test cases instead of loop in order to display
 * them as individual test and to simplify debugging.
 * 
 * @author Holger Eichelberger
 */
public class AdvancedTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "advanced");

    /**
     * Creates a model file object for {@link #DIR}.
     * 
     * @param name the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }

    /**
     * Creates a comments resource file object for {@link #DIR}.
     * 
     * @param name the name of the file (excluding ".text")
     * @return the file
     */
    private static final File createCommentsFile(String name) {
        return new File(DIR, name + ".text");
    }

    /**
     * Tests attributes.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAttributeFail() throws IOException {
        assertEqual(createFile("attributeFail"), "attributeFail", "0", 20208);
    }
    
    /**
     * Tests attributes.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAttributes() throws IOException {
        assertEqual(createFile("attribute"), "attributes", "0");
    }

    /**
     * Tests attributes at enumerations. (ScaleLog case)
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAttributeEnum() throws IOException {
        assertEqual(createFile("attributeEnum"), "attributeEnum", "0");
    }
    
    /**
     * Tests attributes.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testAttributeCompound() throws IOException {
        assertEqual(createFile("attributeCompound"), "attributeCompound", "0");
    }
    
    /**
     * Tests duplicated attribute definitions.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testAttributeDuplicated() throws IOException {
        assertEqual(createFile("attributeDuplicated"), "attributeDuplicated", "0", ErrorCodes.ATTRIBUTION);
    }

    /**
     * Tests compound comparisons.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundComparison() throws IOException {
        assertEqual(createFile("compoundComparison"), "compoundComparison", "0");
    }
    
    /**
     * Tests evals.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testEval() throws IOException {
        assertEqual(createFile("eval"), "evals", "0");
    }

    /**
     * Tests freezes.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testFreeze() throws IOException {
        assertEqual(createFile("freeze"), "freezes", "0");
    }

    /**
     * Tests If-then-else.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testIfThenElse() throws IOException {
        assertEqual(createFile("if-then"), "ifthenelse", "0");
    }

    /**
     * Tests Imports-conflicts.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testImportConflicts() throws IOException {
        assertEqual(createFile("importConflict"), "testImport", "0");
    }

    /**
     * Tests attribute assignments.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testAttributeAssignments() throws IOException {
        assertEqual(createFile("attributeAssignment"), "attributeAssignment", "0");
    }

    /**
     * Tests multiple attribute assignments.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testAttributeAssignments2() throws IOException {
        assertEqual(createFile("attributeAssignment2"), "attributeAssignment2", "0");
    }

    /**
     * Tests multiple attribute assignments in a compound.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testAttributeAssignments2Compound() throws IOException {
        assertEqual(createFile("attributeAssignment2Compound"), "attributeAssignment2Compound", "0");
    }
    
    /**
     * Tests Imports-conflicts (erroneous model).
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testImportConflictsFail() throws IOException {
        assertEqual(createFile("importConflictFail"), "testImportFail", "0",
                ErrorCodes.IMPORT, ErrorCodes.IMPORT, ErrorCodes.IMPORT);
        // one for unknown test1, one for test
    }

    /**
     * Tests Imports-conflicts (erroneous model).
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testImportConflictsFail2() throws IOException {
        assertEqual(createFile("importConflictFail2"), "testImportFail2", "0",
                ErrorCodes.IMPORT, ErrorCodes.IMPORT);
        // one for importing a model with interfaces but not its interface
    }

    /**
     * Tests Imports-conflicts (erroneous model).
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testImportConflictsFail3() throws IOException {
        assertEqual(createFile("importConflictFail3"), "testImportFail3", "0",
                ErrorCodes.UNKNOWN_ELEMENT, ErrorCodes.UNKNOWN_ELEMENT,
                ErrorCodes.UNKNOWN_ELEMENT, ModelQueryException.ACCESS_ERROR,
                UnknownTypeException.CODE);
        // b1 is unknown (in accessible scope), :i3 is unknown (in accessible
        // scope),
        // i3 is unknown (in accessible scope), iface2 is not accessible
        // comp2 is unknown as no variable of its type is exported
    }

    /**
     * Tests interface.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testInterface() throws IOException {
        assertEqual(createFile("interface"), "testInterface", "0");
    }

    /**
     * Tests let.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testLet() throws IOException {
        assertEqual(createFile("let"), "testlet", "0");
    }

    /**
     * Tests operation definitions.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testOpDef() throws IOException {
        assertEqual(createFile("opDef"), "testopdef", "0");
    }

    /**
     * Tests refined compounds.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testRefinedCompound() throws IOException {
        assertEqual(createFile("refinedCompound"), "testRefinedCompound", "0");
    }

    /**
     * Tests references.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testRefs() throws IOException {
        assertEqual(createFile("refs"), "testRefs", "0");
    }

    /**
     * Tests a versioned project.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testVersionedProject() throws IOException {
        assertEqual(createFile("versionedProject"), "testVersionedProject",
                "1.1");
    }

    /**
     * Tests a DSL fragment.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testDslFragment() throws IOException {
        assertEqual(createFile("dsl"), "testDsl", "0");
    }

    /**
     * Tests type constraints (SAP case).
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testTypeConstraints() throws IOException {
        assertEqual(createFile("typeConstraints"), "typeConstraints", "0");
    }

    /**
     * Tests type constraints (SAP case).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImportSameFile() throws IOException {
        List<Project> loaded = assertEqual(createFile("importProjectInSameFile"),
            "testImportSameFile", "0");
        Assert.assertNotNull(loaded);
        
    }
    
    /**
     * Tests the internationalized comments.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIntl() throws IOException {
        Locale origLocale = VarModel.INSTANCE.locale().getLocale();
        Locale origDefltLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
        
        // test with null depends on actual locale!
        
        // resource not present, shall use default
        VarModel.INSTANCE.locale().setLocale(Locale.FRANCE);
        List<Project> loaded = assertEqual(createFile("intl"), "intl", "0");
        assertComments(loaded, createCommentsFile("intl"));
        
        // resource present, shall use DE
        VarModel.INSTANCE.locale().setLocale(Locale.GERMANY);
        loaded = assertEqual(createFile("intl1"), "intl1", "0");
        assertComments(loaded, createCommentsFile("intl1_de"));
            
        Locale.setDefault(origDefltLocale);
        VarModel.INSTANCE.locale().setLocale(origLocale);
    }

    /**
     * Tests imports and exports.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testImportExport() throws IOException {
        assertEqual(createFile("import"), null, "0", ErrorCodes.UNKNOWN_ELEMENT);
    }

    /**
     * Tests dependent operation definitions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testOpDefDependent() throws IOException {
        assertEqual(createFile("opDefDependent"), "testopdefDependent", "0");
    }

    /**
     * Tests recursive operation definitions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testOpDefRecursive() throws IOException {
        int[] expectedErrors;
        if (Config.ENABLE_RECURSIVE_OPERATION_DEFINITIONS) {
            expectedErrors = null;
        } else {
            expectedErrors = new int[2];
            expectedErrors[0] = CSTSemanticException.UNKNOWN_OPERATION;
            expectedErrors[1] = CSTSemanticException.UNKNOWN_OPERATION;
        }
        assertEqual(createFile("opDefRecursive"), "testopdefRecursive", "0", expectedErrors);
    }

    /**
     * Tests constraint variables. Although constraint variables are defined as basic
     * types using them is considered as advanced modelling.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstraintVariables() throws IOException {
        assertEqual(createFile("constraintVar"), "constraintVar", "0");
    }

    /**
     * Tests enumeration imports. This case was contributed by Jacek Serafinski (NDL).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEnumImportAdvanced() throws IOException {
        assertEqual(createFile("enumImport"), null, null);
    }

    /**
     * Tests multiple attributed elements (KS).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMultiAttributes() throws IOException {
        assertEqual(createFile("multiAttribute"), null, null);
    }

    /**
     * Tests failing attribute assignments (duplicate name, KS).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAttributeAssignmentFail() throws IOException {
        assertEqual(createFile("attributeAssignmentFail"), null, null, ErrorCodes.REDEFINITION);
    }

    /**
     * Tests failing attribute assignments (duplicate name in compound, KS).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAttributeAssignmentFail2() throws IOException {
        assertEqual(createFile("attributeAssignmentFail2"), null, null, ErrorCodes.REDEFINITION);
    }

}
