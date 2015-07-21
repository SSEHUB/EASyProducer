package test.de.uni_hildesheim.sse.vil.buildlang;

import static de.uni_hildesheim.sse.varModel.testSupport.TextTestUtils.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.RandomDouble;

/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionTests extends AbstractExecutionTest<Script> {
    
    private static ExecutionTests tests;

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("vil.buildlang.testdata.home");
    }
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new ExecutionTests();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        if (null != tests) {
            tests.cleanTemp();
            tests = null;
        }
    }
    
    /**
     * Tests the load properties element.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoadProperties() throws IOException {
        assertEqual("loadProperties");
    }

    /**
     * Tests loading OS specific properties (contributed by S. Bender).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoadPropertiesOS() throws IOException {
        assertEqual("loadPropertiesOs");
    }
    
    /**
     * Tests the load properties element (failing test due to overriden constant).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoadPropertiesFail() throws IOException {
        assertEqual("loadPropertiesFail", VilException.ID_IS_CONSTANT);
    }

    /**
     * Tests basic numerical functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testNumbers() throws IOException {
        assertEqual("numbers");
    }

    /**
     * Tests basic boolean functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBooleans() throws IOException {
        assertEqual("boolean");
    }

    /**
     * Tests alternative expressions with blocks.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative() throws IOException {
        assertEqual("alternative");
    }

    /**
     * Tests the application of a "function pointer" as parameter.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply() throws IOException {
        assertEqual("apply");
    }

    /**
     * Tests the application of a "function pointer" as variable.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply2() throws IOException {
        assertEqual("apply2");
    }
    
    /**
     * Tests typedefs and "function pointer".
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply3() throws IOException {
        assertEqual("apply3");
    }

    /**
     * Tests typedefs and "function pointer" with "Any".
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply4() throws IOException {
        assertEqual("apply4");
    }
    
    /**
     * Tests a rule as function.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFunction() throws IOException {
        assertEqual("function");
    }
    
    /**
     * Tests alternative expressions without blocks.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative1() throws IOException {
        assertEqual("alternative1");
    }
    
    /**
     * Tests the random "instantiators" (inspired by K. Schmid).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRandom() throws IOException {
        boolean inTests = RandomDouble.setInTests(true);
        assertEqual("random");
        RandomDouble.setInTests(inTests);
    }
    
    /**
     * Tests basic boolean functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrings() throws IOException {
        assertEqual("string");
    }

    /**
     * Tests basic collection functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCollections() throws IOException {
        assertEqual("collections");
    }

    /**
     * Tests basic collection functions (contributed by C. Qin, QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCollections2() throws IOException {
        assertEqual("collections2");
    }
    
    /**
     * Tests basic map functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMap() throws IOException {
        assertEqual("mapTest");
    }

    /**
     * Tests simplified map initialization (contributed by C. Qin, QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMap1() throws IOException {
        assertEqual("mapTest1");
    }
    
    /**
     * Tests simple independent variable declarations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarations() throws IOException {
        assertEqual("variableDeclarations");
    }

    /**
     * Tests simple depending variable declarations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarations2() throws IOException {
        assertEqual("variableDeclarations2");
    }

    /**
     * Tests simple script parameter (without script parameter).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testScriptParameter() throws IOException {
        assertEqual("scriptParameter");
    }

    /**
     * Tests simple script parameter (with typical script parameter).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testScriptParameter2() throws IOException {
        assertEqual("scriptParameter2", VilException.ID_RUNTIME_PARAMETER);
        assertEqualDefaultParam("scriptParameter2");
    }

    /**
     * Tests simple rule execution (without script parameter).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules() throws IOException {
        assertEqual("simpleRules");
    }

    /**
     * Tests simple rule execution (with typical script parameter).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules2() throws IOException {
        assertEqual("simpleRules2", VilException.ID_RUNTIME_PARAMETER);
        assertEqualDefaultParam("simpleRules2");
    }

    /**
     * Tests simple rule execution (nested rule dependency).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules3() throws IOException {
        assertEqual("simpleRules3");
    }

    /**
     * Tests simple rule execution (co-occurring rule dependency).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules4() throws IOException {
        assertEqual("simpleRules4");
    }
    
    /**
     * Tests simple rule execution (boolean pre/postcondition).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules5() throws IOException {
        assertEqual("simpleRules5");
    }

    /**
     * Tests simple rule execution (boolean pre/postcondition, one failing precondition).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules6() throws IOException {
        assertEqual("simpleRules6");
    }

    /**
     * Tests simple rule execution (boolean pre/postcondition, one failing precondition).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules7() throws IOException {
        assertEqual("simpleRules7");
    }
    
    /**
     * Tests the functionality of sequences.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSequences() throws IOException {
        assertSelfInstantiate("sequences");
    }
    
    /**
     * Tests the functionality of enumerating sequences.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSequences1() throws IOException {
        assertSelfInstantiate("sequences1");
    }

    /**
     * Tests the functionality of a simple map.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapSimple() throws IOException {
        assertSelfInstantiate("mapSimple");
    }

    /**
     * Tests the functionality of a nested map.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapNested() throws IOException {
        assertSelfInstantiate("mapNested");
    }

    /**
     * Tests the instantiation of an artifact via a constructor.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstructor() throws IOException {
        assertSelfInstantiate("constructor");
    }

    /**
     * Tests a simple double-sided join.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJoin1() throws IOException {
        assertSelfInstantiate("join1");
    }

    /**
     * Tests a simple double-sided join with condition.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJoin2() throws IOException {
        assertSelfInstantiate("join2");
    }

    /**
     * Tests a simple left-sided join with condition.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJoin3() throws IOException {
        assertSelfInstantiate("join3");
    }

    /**
     * Tests a simple right-sided join with condition (consider that just
     * the names not the paths shall be equal).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJoin4() throws IOException {
        assertSelfInstantiate("join4");
    }
    
    /**
     * The execution of a protected rule.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testProtected() throws IOException {
        assertSelfInstantiate("protectedRules");
        // the same as before, just explicitly using the default start rule
        assertSelfInstantiate("protectedRules", "main"); 
        // shall not work, protected
        assertSelfInstantiate("protectedRules", "compile", VilException.ID_RUNTIME_STARTRULE);
        // shall not work, does not exist
        assertSelfInstantiate("protectedRules", "bla", VilException.ID_RUNTIME_STARTRULE); 
    }

    /**
     * The execution of VTL templates.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVtl() throws IOException {
        assertSelfInstantiate("vtl", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "test.txt");
                File expected = new File(base, "templates/test.vtl.expected");
                assertFileEqualitySafe(file, expected);
                file = new File(base, "test1.txt");
                assertFileEqualitySafe(file, expected);
                file = new File(base, "init.sql");
                expected = new File(base, "init.sql.expected");
                assertFileEqualitySafe(file, expected);
            }
            
        });
    }
    
    /**
     * The execution of VTL templates.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVtl1() throws IOException {
        assertSelfInstantiate("vtl1", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "test2.txt");
                File expected = new File(base, "templates/test2.vtl.expected");
                assertFileEqualitySafe(file, expected);
            }

        });
    }
    
    /**
     * The execution of a Velocity template.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVelocity() throws IOException {
        assertSelfInstantiate("velocity", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "velocity.txt");
                File expected = new File(base, "velocity.txt.expected");
                assertFileEqualitySafe(file, expected);
            }
            
        });
    }
    
    /**
     * The execution of a Velocity template.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFileArtifact() throws IOException {
        assertSelfInstantiate("FileArtifactTest", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "Mapping.tmp");
                File expected = new File(base, "Mapping.tmp.expected");
                assertFileEqualitySafe(file, expected);
            }
            
        });
    }

    
    /**
     * The execution of conditional rules with explicit dependencies.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConditionalRules() throws IOException {
        assertSelfInstantiate("conditionalRules");
    }

    /**
     * The execution of conditional rules with implicit dependencies.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConditionalRules2() throws IOException {
        assertSelfInstantiate("conditionalRules2");
    }

    /**
     * The execution of zip operations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testZip() throws IOException {
        assertSelfInstantiate("zip");
    }

    /**
     * The use of a temporary folder.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTmpFolder() throws IOException {
        assertSelfInstantiate("tmpFolder");
    }

    /**
     * Tests simple operations on the textual representation.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testText() throws IOException {
        assertSelfInstantiate("text");
    }

    /**
     * Tests implicit variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImplicitVars() throws IOException {
        assertSelfInstantiate("implicitVars");
    }

    /**
     * Tests the instantiation command. However, we cannot test
     * all variants of the call as currently the main script cannot
     * easily be determined in tests (projects are fed in as files).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInstantiate() throws IOException {
        assertSelfInstantiate("instantiate");
    }

    /**
     * Tests a main rule call to a base PL from an extended PL (contributed by Sascha).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testExtendedPL() throws IOException {
        assertSelfInstantiate("extendedPL");
    }

    /**
     * Tests type selects (actually a part of an existing test used for debugging).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypeSelect() throws IOException {
        assertSelfInstantiate("typeSelect");
    }
    
    /**
     * Tests creation of a new text file (inspired by S. Bender).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testNewText() throws IOException {
        assertSelfInstantiate("newText", "main", new SelfInstantiationAsserter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "newText.txt");
                File expected = new File(base, "newText.txt.expected");
                assertFileEqualitySafe(file, expected);
            }

            @Override
            public void deleteBetween(File base) {
            }
            
        });
    }
    
    /**
     * Tests the selection of the right VTL script from a VIL script (contributed by Sebastian Bender).
     * The correct scripts are nested in the <code>PL_3</code> folder, but the same are also present 
     * in the <code>PL_2</code> folder
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testPL3() throws IOException {
        assertSelfInstantiate("PL_3/EASy/PL_3");
    }
    
    /**
     * Tests some XML cases.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testXML1() throws IOException {
        assertSelfInstantiate("xml1"); // file not created
    }

    /**
     * Tests some XML cases.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testXML2() throws IOException {
        assertSelfInstantiate("xml2", "main", new SelfInstantiationAsserter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "xml2File.xml");
                File expected = new File(base, "xml2File.xml.expected");
                assertFileEqualitySafe(file, expected);
            }
            
            @Override
            public void deleteBetween(File base) {
                File file = new File(base, "xml2File.xml");
                try {
                    ArtifactFactory.createArtifact(file).delete();
                } catch (VilException e) {
                    e.printStackTrace();
                }
            }
            
        });
    }

    /**
     * Tests the rename operation for file artifacts.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRename() throws IOException {
        assertSelfInstantiate("rename", "main", new SelfInstantiationAsserter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "rename.txt");
                Assert.assertFalse(file.exists());
                file = new File(base, "rename_0.txt");
                Assert.assertTrue(file.exists());
            }

            @Override
            public void deleteBetween(File base) {
                // reset test situation
                File fileAfter = new File(base, "rename_0.txt");
                File fileBefore = new File(base, "rename.txt");
                try {
                    ArtifactFactory.createArtifact(fileAfter).rename(fileBefore.getPath());
                } catch (VilException e) {
                    e.printStackTrace();
                }
            }
            
        });
        
    }

    /**
     * Tests the rename operation for file artifacts.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRename1() throws IOException {
        assertSelfInstantiate("rename1", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "rename1.txt");
                Assert.assertFalse(file.exists());
                file = new File(base, "rename_1.txt");
                Assert.assertTrue(file.exists());
            }

            @Override
            public void deleteBetween(File base) {
                // reset test situation
                File fileAfter = new File(base, "rename_1.txt");
                File fileBefore = new File(base, "rename1.txt");
                try {
                    ArtifactFactory.createArtifact(fileAfter).rename(fileBefore.getPath());
                } catch (VilException e) {
                    e.printStackTrace();
                }
            }

        });
        
    }

    /**
     * Tests auto-storing artifacts (rename after).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStoreArtifact1() throws IOException {
        assertSelfInstantiate("storeArtifact1", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "renStoreArtifact1.txt");
                Assert.assertTrue(file.exists());
                File expected = new File(base, "renStoreArtifact1.txt.expected");
                assertFileEqualitySafe(file, expected);
            }

            @Override
            public void deleteBetween(File base) {
                // reset test situation
                File file = new File(base, "renStoreArtifact1.txt");
                try {
                    ArtifactFactory.createArtifact(file).delete();
                } catch (VilException e) {
                    e.printStackTrace();
                }
            }

        });
        
    }

    /**
     * Tests auto-storing artifacts (rename after).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStoreArtifact2() throws IOException {
        assertSelfInstantiate("storeArtifact2", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "storeArtifact2.txt");
                Assert.assertTrue(file.exists());
                File expected = new File(base, "storeArtifact2.txt.expected");
                assertFileEqualitySafe(file, expected);
            }

            @Override
            public void deleteBetween(File base) {
                // reset test situation
                File file = new File(base, "storeArtifact2.txt");
                try {
                    ArtifactFactory.createArtifact(file).delete();
                } catch (VilException e) {
                    e.printStackTrace();
                }
            }

        });
        
    }

    /**
     * Tests some VTL cases (passing IVML instances).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVtl2() throws IOException {
        assertSelfInstantiate("vtl2", "main", "adviceTestVIL1", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "test3.txt");
                File expected = new File(base, "templates/test3.vtl.expected");
                assertFileEqualitySafe(file, expected);
            }

        });
    }

    /**
     * Tests whether files are copied recursively if a file pattern was used. 
     * @throws IOException should not occur
     */
    @Test
    public void testRecursiveCopyOnInclusionPattern() throws IOException {
        assertSelfInstantiate("RecursiveCopyTestProject/RecursiceCopyIncludePattern", "main", null,
            new SelfInstantiationAsserterAdapter() {

                @Override
                public void assertIn(File base) {
                    File fileToCopy = new File(base, "trgForRecursiveCopy/base/FileToCopy.txt");
                    Assert.assertTrue("Error: File was not recursively copied to \"" + fileToCopy.getAbsolutePath()
                        + "\"", fileToCopy.exists());
                    File fileToBeIgnored = new File(base, "trgForRecursiveCopy/ignored/ToBeIgnored.txt");
                    Assert.assertFalse("Error: File was copied to \"" + fileToBeIgnored.getAbsolutePath()
                        + "\", but this must not happen.", fileToBeIgnored.exists());
                }

            });
    }
}
