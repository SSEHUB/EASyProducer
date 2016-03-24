package de.uni_hildesheim.sse.easy_producer.core.mgmt;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.core.AllTests;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.model.confModel.AllFreezeSelector;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.reasoning.core.frontend.IReasonerListener;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;

/**
 * Extended test cases for the {@link PLPInfo}. Contrary to {@link PLPInfoTest},
 * this class test not elementary functions of the {@link PLPInfo}, it tests scenarios.
 * @author El-Sharkawy
 *
 */
public class PLPInfoSenariosTest extends AbstractPLPInfoTest {
    
    /**
     * Tests usually include instantiation and, thus, projects will be edited.
     * -> PLPs must be stored to {@link AllTests#TESTDATA_DIR_COPY}.
     */
    private static final File BASE_TEST_FOLDER = new File(AllTests.TESTDATA_DIR_COPY, "scenarios");

    /**
     * Project for testing instantiation of CSV files with the aim of templates.
     * Test will tests whether the template file will be created correctly
     */
    private static final File TEST_TEMPLATE_INSTANTIATION
        = new File(BASE_TEST_FOLDER, "NumericCSVInstantiationTest");
    
    /**
     * Project for testing instantiation of a filtered text file (in this case ini) with the aim of templates.
     * Test will tests whether the template file will be created correctly
     */
    private static final File TEST_FILTERED_INSTANTIATION
        = new File(BASE_TEST_FOLDER, "FilteredInstantiationTest");
    
    /**
     * Project for testing hierarchical instantiation (step 1).
     * Test will test instantiation.
     */
    private static final File TEST_HIERARCHICAL_INSTANTIATION_STEP1
        = new File(BASE_TEST_FOLDER, "PL_1");
    
    /**
     * Project for testing hierarchical instantiation (step 2).
     * Test will test instantiation.
     */
    private static final File TEST_HIERARCHICAL_INSTANTIATION_STEP2
        = new File(BASE_TEST_FOLDER, "PL_2");
    
    /**
     * Project for testing hierarchical instantiation (step 3).
     * Test will test instantiation.
     */
    private static final File TEST_HIERARCHICAL_INSTANTIATION_STEP3
        = new File(BASE_TEST_FOLDER, "PL_3");
    
    /**
     * Project for testing instantiation of compounds.
     * Test will test instantiation.
     */
    private static final File TEST_COMPOUND_INSTANTIATION
        = new File(BASE_TEST_FOLDER, "CompoundInstantiationTest");
    
    private static Set<PLPInfo> loadedInfos = new HashSet<PLPInfo>();
    
    /**
     * Registers VIL and VTL expression parser. This should normally be done via the Descriptive Services (DS),
     * but it seems that it is not the case when the tests are executed via ANT.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        AbstractPLPInfoTest.setUpBeforeClass();
    }
    
    /**
     * Closes all {@link PLPInfo}s, which were loaded in a test.
     * This should avoid side effects inside the {@link de.uni_hildesheim.sse.utils.modelManagement.ModelManagement}s,
     * while parsing the config files of different {@link PLPInfo} projects.
     */
    @After
    public void tearDown() {
        for (PLPInfo plp : loadedInfos) {
            plp.close();
        }
        
        loadedInfos.clear();
    }
    
    /**
     * Helping method for loading projects from the testdata folder.
     * @param projectFolder The toplevel folder of a saved {@link PLPInfo} which should be used for testing.
     * @return A {@link PLPInfo} which was loaded from the given location.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
    protected static PLPInfo loadPLPInfo(File projectFolder) throws PersistenceException {
        PLPInfo plp = AbstractPLPInfoTest.loadPLPInfo(projectFolder);
        // For closing the plps after running all tests
        loadedInfos.add(plp);
        
        return plp;
    }
    
    /**
     * Tests simple hierarchical instantiation. Test created by Sebastian Bender.
     * @throws PersistenceException If the project could not be loaded from the file system.
     * @throws VilException If instantiation is not possible (this should be tested by this test!)
     */
//    @Ignore
    @Test
    public void testHierarchicalInstantiation() throws PersistenceException, VilException {
        // Load projects
        PLPInfo plp1 = loadPLPInfo(TEST_HIERARCHICAL_INSTANTIATION_STEP1);
        Assert.assertNotNull(plp1.getBuildScript());
        printPLP(plp1);
        PLPInfo plp2 = loadPLPInfo(TEST_HIERARCHICAL_INSTANTIATION_STEP2);
        Assert.assertNotNull(plp2.getBuildScript());
        printPLP(plp2);
        PLPInfo plp3 = loadPLPInfo(TEST_HIERARCHICAL_INSTANTIATION_STEP3);
        Assert.assertNotNull(plp3.getBuildScript());
        printPLP(plp3);
        
        // Hierarchical instantiation
        plp3.addVilExecutionListener(this);
        plp3.instantiate(null);
    }
    
    /**
     * Tests whether the instantiation process of templates will work.
     * @throws PersistenceException If the project could not be loaded from the file system.
     * @throws VilException If instantiation is not possible
     * @throws IOException If the produced file was not saved or the expected file was not found for comparison
     */
    @Test
    public void testInstantiateNumericCSVInstantiation() throws PersistenceException, VilException,
        IOException {

        File expectedFile = new File(TEST_TEMPLATE_INSTANTIATION, "expected/NumericCSVInstantiationTest.csv");
        File actualFile = new File(TEST_TEMPLATE_INSTANTIATION, "NumericCSVInstantiationTest.csv");
        
        // Load project
        PLPInfo plp = loadPLPInfo(TEST_TEMPLATE_INSTANTIATION);
        
        // Test length of configuration
        int nFrozenVars = countFrozenVariables(plp);
        Assert.assertEquals("Error: Expected 5 frozen variables, but there where only " + nFrozenVars + " frozen vars.",
            5, nFrozenVars);
        
        // Test precondition:actualFile must not exist
        Assert.assertTrue(expectedFile.exists());
        Assert.assertFalse(actualFile.exists());
        
        //Instantiate project
        plp.addVilExecutionListener(PLPInfoSenariosTest.this);
        plp.instantiate(null);
        
        // Test postcondition: actualFile must exist and have exactly the same content as expectedFile.
        Assert.assertTrue(expectedFile.exists());
        Assert.assertTrue("File: " + actualFile.getAbsolutePath() + " not found.", actualFile.exists());
        assertFileEquality(actualFile, expectedFile);
    }
    
    /**
     * Tests a more complex instantiation scenario.
     * <ul>
     * <li>Filters the configuration to instantiate only a part of the frozen configuration. This is done inside
     * the VTL file.</li>
     * <li>Uses the reasoner to propagate values (high level variables should trigger low level variables)</li>
     * <li>Freezes the whole configuration</li>
     * <li>Instantiates the template via VIL</li>
     * </ul>
     * @throws PersistenceException If the project could not be loaded from the file system.
     */
    @Test
    public void testFilteredInstantation() throws PersistenceException {
        
        final File expectedFile = new File(TEST_FILTERED_INSTANTIATION, "expected/FilteredInstantiationTest.ini");
        final File actualFile = new File(TEST_FILTERED_INSTANTIATION, "FilteredInstantiationTest.ini");
        
        // Load project
        final PLPInfo plp = loadPLPInfo(TEST_FILTERED_INSTANTIATION);
        
        // Test precondition: actualFile must not exist and configuration should not contain any frozen variables
        Assert.assertTrue(expectedFile.exists());
        Assert.assertFalse(actualFile.exists());
        int nFrozenVars = countFrozenVariables(plp);
        Assert.assertEquals("Error: Expected no frozen variables, but there where " + nFrozenVars + " frozen vars.",
            0, nFrozenVars);
        
        // Perform action: Propagate, freeze, and instantiate
        plp.reason(ReasoningOperation.PROPAGATION, new IReasonerListener() {
            
            @Override
            public void reasoningFinished(ReasoningResult result) {
                StringBuffer errorMsg = new StringBuffer();
                if (result.hasConflict()) {
                    for (int i = 0; i < result.getMessageCount(); i++) {
                        Message msg = result.getMessage(i);
                        errorMsg.append(msg.getStatus() + ": " + msg.getDescription());
                        List<ModelElement> elements = msg.getConflicts();
                        if (!elements.isEmpty()) {
                            errorMsg.append(": ");
                            errorMsg.append(StringProvider.toIvmlString(elements.get(0)));
                        }
                        errorMsg.append("\n");
                    }
                }
                Assert.assertFalse(errorMsg.toString(), result.hasConflict());
                
                plp.getConfiguration().freeze(AllFreezeSelector.INSTANCE);
                plp.addVilExecutionListener(PLPInfoSenariosTest.this);
                plp.instantiate(null);
                
                /* 
                 * Test postcondition: actualFile must exist and have exactly the same content as expectedFile.
                 * The configuration should contain 4 frozen variables (but only 2 are instantiated).
                 */
                int nFrozenVars = countFrozenVariables(plp);
                Assert.assertEquals("Error: Expected 4 frozen variables, but there where " + nFrozenVars
                    + " frozen vars.", 4, nFrozenVars);
                Assert.assertTrue(expectedFile.exists());
                Assert.assertTrue("File: " + actualFile.getAbsolutePath() + " not found.", actualFile.exists());
                try {
                    PLPInfoTest.assertFileEquality(actualFile, expectedFile);
                } catch (IOException e) {
                    Assert.fail(e.getMessage());
                }
            }
        });
    }
    
    /**
     * Tests whether {@link de.uni_hildesheim.sse.model.varModel.datatypes.Compound}s can be used in instantiation.
     * Bug occurred on 12.08.2014.
     * @throws PersistenceException If the project could not be loaded from the file system.
     */
    @Test
    public void testCompoundInstantiation() throws PersistenceException {
        final File expectedFile = new File(TEST_COMPOUND_INSTANTIATION, "expected/CompoundInstantiationTest.txt");
        final File actualFile = new File(TEST_COMPOUND_INSTANTIATION, "CompoundInstantiationTest.txt");
        
        // Load project
        final PLPInfo plp = loadPLPInfo(TEST_COMPOUND_INSTANTIATION);
        
        // Test precondition: actualFile must not exist
        Assert.assertTrue(expectedFile.exists());
        Assert.assertFalse(actualFile.exists());
        
        plp.addVilExecutionListener(this);
        plp.instantiate(null);
        
        // Test postcondition: actualFile must exist and have exactly the same content as expectedFile.
        Assert.assertTrue(expectedFile.exists());
        Assert.assertTrue("File: " + actualFile.getAbsolutePath() + " not found.", actualFile.exists());
        try {
            PLPInfoTest.assertFileEquality(actualFile, expectedFile);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
