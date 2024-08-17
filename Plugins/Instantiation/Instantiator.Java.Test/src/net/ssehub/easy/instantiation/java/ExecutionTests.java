package net.ssehub.easy.instantiation.java;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEqualitySafe;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.DefaultLibUtils;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.java.artifacts.DefaultJavaFileArtifactCreator;
import net.ssehub.easy.instantiation.java.artifacts.JavaClass;
import net.ssehub.easy.instantiation.java.artifacts.JavaFileArtifact;
import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;

/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionTests extends AbstractExecutionTest<Script> {

    private static ExecutionTests tests;

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("instantiator.java.testdata.home");
    }

    @Override
    protected void furtherInitialization() {
        Registration.register();
        DefaultLibUtils.loadDefaultModels(OBSERVER, Bundle.ID);
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
     * The execution of the Java compiler.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testJavac() throws IOException {
        assertSelfInstantiate("javac");
    }

    /**
     * Tests the implicit LHSMATCH variable.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testJavac2() throws IOException {
        assertSelfInstantiate("javac2");
    }

    /**
     * Will test whether EASy is able to retrieve the Java&trade; compiler even
     * if the <code>java.home</code> property is pointing to a wrong location.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testGetJavaCompiler() throws IOException {
        // reset and check!
        /*
        THIS DOES NOT IMPRESS JAVA 9 ANYMORE
        String homeProperty = System.getProperty("java.home");
        System.setProperty("java.home", "");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        Assert.assertNull(compiler);*/

        assertSelfInstantiate("javac2");

        //System.setProperty("java.home", homeProperty);
    }

    /**
     * The execution of jar operations.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testJar() throws IOException {
        assertSelfInstantiate("jar");
    }

    /**
     * The execution of jar operations. This test case test the correct behavior
     * of creating JARs with a given manifest file. Further tests were also
     * applied:
     * <ul>
     * <li>Making files relative to directory</li>
     * <li>Include only files from a specific subfolder</li>
     * </ul>
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testJarWithManifest() throws IOException {
        assertSelfInstantiate("jar2", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                // Manifest which should be included in JAR file
                File expected = new File(new File(getArtifactsFolder(), "jar2Testfiles"), "MANIFEST.MF");

                // Unpacked manifest file from the JAR file
                File generated = new File(new File(base, "Jar2TestUnzipped"), "META-INF");
                generated = new File(generated, "MANIFEST.MF");

                // Check that not the default Manifest file was used.
                assertFileEqualitySafe(expected, generated);
            }

        });
    }

    /**
     * The execution of copy with vil.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testJavaCopy() throws IOException {
        assertSelfInstantiate("copy", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File copyBla2 = new File(getArtifactsFolder(), "src2/test/CopyBla2.java");
                File tempFile = new File(base, "javaCopy/dest/instantiated/test/Bla2.java");
                assertFileEqualitySafe(tempFile, copyBla2);

                File copyBla = new File(getArtifactsFolder(), "src2/test/CopyBla.java");
                tempFile = new File(base, "javaCopy/dest/instantiated/test/Bla.java");
                assertFileEqualitySafe(tempFile, copyBla);
            }

        });
    }

    /**
     * Test the modification of methods by deleting java calls within a vil
     * script.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testModifyMethod() throws IOException {
        final File expected = new File(getArtifactsFolder(), "classpathTest/src/ModifiedMethodFile.java");
        final File expectedCpy = new File(getTempDir(), "ModifiedMethodFile.java");
        FileUtils.copyFile(expected, expectedCpy);
        try {
            DefaultJavaFileArtifactCreator creator = new DefaultJavaFileArtifactCreator();
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) creator.createArtifactInstance(expected, null);
            Set<JavaClass> classes = javaFileArtefact.classes();
            for (JavaClass javaClass : classes) {
                javaClass.notifyChildChanged(javaClass);
                javaClass.store();
            }
        } catch (VilException e) {
            e.printStackTrace();
        }
        assertSelfInstantiate("method", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, "classpathTest");
            }

            @Override
            public void assertIn(File base) {
                File tempFile = new File(base, "src/MethodFile.java");
                assertFileEqualitySafe(tempFile, expected);
            }

        });
        FileUtils.copyFile(expectedCpy, expected);
    }

    /**
     * Test the modification of methods by deleting java calls within a VIL
     * script. All references to the deleted method should be removed.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testDeleteWithCalls() throws IOException {
        assertSelfInstantiate("deleteWithCalls", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, "deleteMethod");
            }

            @Override
            public void assertIn(File base) {
                File expectedMethodClass2 = new File(getArtifactsFolder(), "deleteMethodExpected/MethodClass2.java");
                File tempFileMethodClass2 = new File(base, "MethodClass2.java");
                assertFileEqualitySafe(tempFileMethodClass2, expectedMethodClass2);

                File expectedMethodClass = new File(getArtifactsFolder(), "deleteMethodExpected/MethodClass.java");
                File tempFileMethodClass = new File(base, "MethodClass.java");
                assertFileEqualitySafe(tempFileMethodClass, expectedMethodClass);
            }

        });
    }

    /**
     * Test the modification of methods by deleting java calls within a VIL
     * script. All references to the deleted method should be removed.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testDeleteWithCallsClasspathAsSetOfString() throws IOException {
        assertSelfInstantiate("deleteWithCallsClasspathAsSetOfString", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, "deleteMethod");
            }

            @Override
            public void assertIn(File base) {
                File expectedMethodClass2 = new File(getArtifactsFolder(), "deleteMethodExpected/MethodClass2.java");
                File tempFileMethodClass2 = new File(base, "MethodClass2.java");
                assertFileEqualitySafe(tempFileMethodClass2, expectedMethodClass2);

                File expectedMethodClass = new File(getArtifactsFolder(), "deleteMethodExpected/MethodClass.java");
                File tempFileMethodClass = new File(base, "MethodClass.java");
                assertFileEqualitySafe(tempFileMethodClass, expectedMethodClass);
            }

        });
    }

    /**
     * Test the modification of methods by deleting java calls within a VIL
     * script. All references to the deleted method should be removed.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testDeleteWithCallsClasspathAsSetOfPath() throws IOException {
        assertSelfInstantiate("deleteWithCallsClasspathAsSetOfPath", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, "deleteMethod");
            }

            @Override
            public void assertIn(File base) {
                File expectedMethodClass2 = new File(getArtifactsFolder(), "deleteMethodExpected/MethodClass2.java");
                File tempFileMethodClass2 = new File(base, "MethodClass2.java");
                assertFileEqualitySafe(tempFileMethodClass2, expectedMethodClass2);

                File expectedMethodClass = new File(getArtifactsFolder(), "deleteMethodExpected/MethodClass.java");
                File tempFileMethodClass = new File(base, "MethodClass.java");
                assertFileEqualitySafe(tempFileMethodClass, expectedMethodClass);
            }

        });
    }

    /**
     * Test the modification of methods by deleting java calls within a VIL
     * script. All references to the deleted method should be removed.In this
     * case test if a method can be deleted if the return type is not void.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testMethodReturnType() throws IOException {
        assertSelfInstantiate("methodReturnType", "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, "methodReturnType");
            }

            @Override
            public void assertIn(File base) {
                File expectedMethodClass2 = new File(getArtifactsFolder(),
                        "deleteMethodExpected/MethodReturnType.java");
                File tempFileMethodClass2 = new File(base, "MethodReturnType.java");
                assertFileEqualitySafe(tempFileMethodClass2, expectedMethodClass2);
            }

        });
    }
    
    /**
     * Assertion for Java code tests.
     * 
     * @param modelName the name of the VIL model to execute
     * @param fileName the file name of the file to assert against, may end with ".java", added if not present
     * @throws IOException if reading files fails
     */
    private void assertJavaCode(String modelName, String fileName) throws IOException {
        final String folder = "javaCode";
        if (!fileName.endsWith(".java")) {
            fileName += ".java";
        }
        final String fName = fileName;
        
        assertSelfInstantiate(modelName, "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, folder);
            }

            @Override
            public void assertIn(File base) {
                File expectedMethodClass2 = new File(getArtifactsFolder(), folder + File.separator + fName);
                File tempFileMethodClass2 = new File(base, fName);
                // for debugging
                try { 
                    System.out.println(FileUtils.readFileToString(tempFileMethodClass2, Charset.defaultCharset()));
                } catch (IOException e) {
                }
                assertFileEqualitySafe(tempFileMethodClass2, expectedMethodClass2);
            }

        });
    }

    /**
     * Test the JavaCode artifact in VIL.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavaCode() throws IOException {
        assertJavaCode("javaCode", "JCATest");
    }

    /**
     * Test the JavaCode artifact in VIL (mixed style).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavaCode2() throws IOException {
        assertJavaCode("javaCode2", "JCATest2");
    }

    /**
     * Test the JavaCode artifact for an annotated junit test suite.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavaCode3() throws IOException {
        assertJavaCode("javaCode3", "JCATest3");
    }

    /**
     * Test the JavaCode artifact for enums.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavaCode4() throws IOException {
        assertJavaCode("javaCode4", "JCATest4");
    }

    /**
     * Test the JavaCode artifact for sorted class elements.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavaCode5() throws IOException {
        assertJavaCode("javaCode5", "JCATest5");
    }

}
