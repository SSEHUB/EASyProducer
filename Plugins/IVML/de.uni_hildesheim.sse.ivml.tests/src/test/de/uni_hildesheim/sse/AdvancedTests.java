package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

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
     * Tests freezes (fails due to freezing a type).
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testFreezeFail() throws IOException {
        assertEqual(createFile("freezeFail"), "freezeFail", "0", ErrorCodes.FREEZE);
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
     * Tests operation definitions indicating dynamic dispatch and typedefs (contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testOpDefDispatch2() throws IOException {
        assertEqual(createFile("opDefDispatch2"), "testopdefDispatch2", "0");
    }
    
    /**
     * Tests operation definitions indicating dynamic dispatch (contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testOpDefDispatch() throws IOException {
        assertEqual(createFile("opDefDispatch"), "testopdefDispatch", "0");
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
     * Tests refined compounds.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRefinedCompoundFail() throws IOException {
        assertEqual(createFile("refinedCompoundFail"), "testRefinedCompoundFail", "0", ErrorCodes.UNKNOWN_ELEMENT);
    }
    
    /**
     * Tests refined compounds, the refined compounds is written before the super/parent compound.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testRefinedCompoundReverseOrder() throws IOException {
        assertEqual(createFile("refinedCompoundReverseOrder"), "refinedCompoundReverseOrder", "0");
    }

    /**
     * Tests references.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRefs() throws IOException {
        assertEqual(createFile("refs"), "testRefs", "0");
    }

    /**
     * Tests reference assignments.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRefAssignments() throws IOException {
        assertEqual(createFile("refAssignments"), null, null);
    }

    /**
     * Tests failing reference assignments (type incompatbility).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRefAssignmentsFail() throws IOException {
        assertEqual(createFile("refAssignmentsFail"), null, null, CSTSemanticException.TYPE_MISMATCH);
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
     * @throws IOException should not occur
     */
    @Test
    public void testImportExport() throws IOException {
        assertEqual(createFile("import"), null, "0", ErrorCodes.UNKNOWN_ELEMENT);
    }
    
    /**
     * Tests imports and exports including enums (inspired by S. Bender).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImportExport2() throws IOException {
        assertEqual(createFile("import2"), null, "0");
    }
    
    /**
     * Tests imports and exports including enums (contributed by S. Bender).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImportExport3() throws IOException {
        assertEqual(createFile("import3"), null, "0");
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
        assertEqual(createFile("opDefRecursive"), "testopdefRecursive", "0", null);
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
     * Tests constraint variables in compounds via configuration (QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstraintVariables2() throws IOException {
        assertEqual(createFile("constraintVar2"), "constraintVar2", "0");
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

    /**
     * For dependent compounds.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDependentCompounds() throws IOException {
        assertEqual(createFile("dependentCompounds"), null, null);
    }

    /**
     * Test references taken from a container (contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRefAssignmentContainer() throws IOException {
        assertEqual(createFile("refAssignmentContainer"), null, null);
    }
    
    /**
     * Test qualification of the project from a compound (contributed by ScaleLog).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundQualifiesProject() throws IOException {
        assertEqual(createFile("compoundQualifiesProject"), null, null);
    }

    /**
     * Test qualification of the project from an assignment block inside a compound (contributed by ScaleLog).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundQualifiesProject2() throws IOException {
        assertEqual(createFile("compoundQualifiesProject2"), null, null);
    }

    /**
     * Test whether variables can be exported in an interface using their full qualified decision name.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFQDNInInterfaces() throws IOException {
        assertEqual(createFile("FQDN_in_Interfaces"), null, null);
    }
    
    /**
     * Test whether a value can be assigned to an exported enumeration.
     * @throws IOException should not occur
     */
    @Test
    public void testExportedEnumType() throws IOException {
        assertEqual(createFile("ExportedEnumType"), null, null);
    }

    /**
     * Test whether self can be used within a compound.
     * @throws IOException should not occur
     */
    @Test
    public void testSelf() throws IOException {
        assertEqual(createFile("self"), null, null);
    }

    /**
     * Test whether self can be used within a compound.
     * @throws IOException should not occur
     */
    @Test
    public void testSelfFail() throws IOException {
        assertEqual(createFile("selfFail"), null, null, 
            ErrorCodes.UNKNOWN_ELEMENT, ErrorCodes.UNKNOWN_ELEMENT, ErrorCodes.UNKNOWN_ELEMENT);
    }

    /**
     * Test whether operation definitions can be imported.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testOpDefImport() throws IOException {
        assertEqual(createFile("opDefImport"), null, null);
    }
    
    /**
     * Test that the ordering of projects inside the same IVML file is kept after (re-)saving.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testmultipleProjectsInIVMLFile() throws IOException {
        File inputTestFile = createFile("MultipleProjectsInIVMLFile");
        List<Project> projects = assertEqual(inputTestFile, null, null);
        // Test correct ordering inside list as this ordering is also used for saving the projects
        Assert.assertEquals("Error: Not exact 3 projects found in \"" + inputTestFile.getAbsolutePath() + "\"",
            3, projects.size());
        assertProjectInPosition(projects, "MultipleProjectsInIVMLFile", 0);
        assertProjectInPosition(projects, "InternalProject", 1);
        assertProjectInPosition(projects, "InterfacedProject", 2);
    }

    /**
     * Helpermethod of {@link #testmultipleProjectsInIVMLFile()}, tests whether the projects inside the list
     * are stored at the correct position.
     * @param projects The list of all parsed projects of the same file.
     * @param expectedProject The name of the project to test.
     * @param index The expected index of the project (should be the same as inside the file, starting with index 0).
     */
    private void assertProjectInPosition(List<Project> projects, String expectedProject, int index) {
        String actualProject = projects.get(index).getName();
        Assert.assertEquals("Wrong project at index " + index + " expected \"" + expectedProject + "\" but was \""
            + actualProject + "\"." , expectedProject, actualProject);
    }
    
}
