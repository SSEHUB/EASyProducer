package test.de.uni_hildesheim.sse.java.artifacts;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import de.uni_hildesheim.sse.easy.java.artifacts.DefaultJavaFileArtifactCreator;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaAttribute;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaClass;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaFileArtifact;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaMethod;
import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Test the Java Artifacts.
 * 
 * @author Sass
 * 
 */
public class JavaFileArtifactTest extends AbstractExecutionTest {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(JavaFileArtifactTest.class, Bundle.ID);
    
    // TODO ok for now as the JavaFileArtifact was not registered with the ArtifactFactory, 
    // shall work via ArtifactFactory 
    private static final DefaultJavaFileArtifactCreator CREATOR = new DefaultJavaFileArtifactCreator();
    
    private static File constantAttributes;
    private static File variableAttributes;
    private static File mainWithNoMethods;
    private static File originalFile;
    
    private static File temp;
    private static File tempFile;

    @Override
    protected String getSystemPropertyName() {
        return "instantiator.java.testdata.home";
    }

    /**
     * Formats a specific file with eclipse code formatter.
     * 
     * @param file the file to be formatted
     */
    public static void formatFile(File file) {
        /*
         * TODO DIRTY! 
         * TODO REFACTOR!
         * Needs to be done because the changes are formatted by the Eclipse CodeFormatter. The
         * formatter inserts tabs instead of spaces.
         */
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(file, null);
            Set<JavaClass> classes = javaFileArtefact.classes();
            for (JavaClass javaClass : classes) {
                javaClass.store();
            }
        } catch (ArtifactException e) {
            logger.exception(e);
        }
    }

    /**
     * Initializes this test.
     * 
     * @throws IOException shall not occur
     */
    @Before
    public void init() throws IOException {
        temp = createTempDir("javaArtifacts");
        tempFile = new File(temp, "Tmp.java");

        constantAttributes = copyOriginal("MainConstant.java");
        variableAttributes = copyOriginal("MainVariable.java");
        mainWithNoMethods = copyOriginal("MainWithNoMethods.java");
        originalFile = new File(getArtifactsFolder() + "/src2/test/MainOrg.java");

        // ensure same formatting
        formatFile(constantAttributes);
        formatFile(variableAttributes);
        formatFile(mainWithNoMethods);
    }
    
    /**
     * Copies the given original file into the temp folder.
     * 
     * @param name the name of the original file (no path)
     * @return the temp file
     * @throws IOException in case of I/O problems
     */
    private final File copyOriginal(String name) throws IOException {
        File orig = new File(getArtifactsFolder(), "src2/test/" + name);
        File tmp = new File(temp, name);
        copyFile(orig, tmp);
        return tmp;
    }
    
    /**
     * Cleans up this test.
     */
    @After
    public void clean() {
        deleteQuietly(temp);
    }

    /**
     * Test if attributes are made constant.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMakeAttributeConstant() throws IOException {
        copyFile(originalFile, tempFile);
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            Set<JavaClass> classes = javaFileArtefact.classes();
            Assert.assertEquals(1, classes.size());
            for (JavaClass javaClass : classes) {
                Assert.assertEquals("Main", javaClass.getName());
                Set<JavaAttribute> attributes = javaClass.attributes();
                Assert.assertEquals(5, attributes.size());
                for (JavaAttribute javaAttribute : attributes) {
                    javaAttribute.makeConstant();
                    // Test if modifiers are inserted twice
                    javaAttribute.makeConstant();
                }
            }
            javaFileArtefact.store();
            // Test if attributes were made constant
            
            assertFileEqualitySafe(tempFile, constantAttributes);
        } catch (ArtifactException e) {
            logger.exception(e);
        }
    }
    
    /**
     * Test if attributes are made variable.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testMakeAttributeVariable() throws IOException {
        copyFile(originalFile, tempFile);
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            Set<JavaClass> classes = javaFileArtefact.classes();
            Assert.assertEquals(1, classes.size());
            for (JavaClass javaClass : classes) {
                Assert.assertEquals("Main", javaClass.getName());
                Assert.assertEquals(3, javaClass.methods().size());
                Set<JavaAttribute> attributes = javaClass.attributes();
                Assert.assertEquals(5, attributes.size());
                for (JavaAttribute javaAttribute : attributes) {
                    javaAttribute.makeVariable();
                }
            }
            javaFileArtefact.store();
            // Test whether attributes were made constant
            assertFileEqualitySafe(tempFile, variableAttributes);
        } catch (ArtifactException e) {
            logger.exception(e);
        }
    }
    
    /**
     * Test if annotations are found.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testHasAnnotations() throws IOException {
        copyFile(originalFile, tempFile); // just to be on the safe side
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            Assert.assertEquals(true, javaFileArtefact.hasAnnotation("VariationPoint", null, "A"));
            Assert.assertEquals(true, javaFileArtefact.hasAnnotation("VariationPoint", null, "B"));
            Assert.assertEquals(false, javaFileArtefact.hasAnnotation("VariationPoint", null, "5"));
        } catch (ArtifactException e) {
            logger.exception(e);
        }
    }
    
    /**
     * Test if methods can be deleted.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testDeleteMethods() throws IOException {
        copyFile(originalFile, tempFile);
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            Set<JavaClass> classes = javaFileArtefact.classes();
            for (JavaClass javaClass : classes) {
                Set<JavaMethod> methods = javaClass.methods();
                for (JavaMethod javaMethod : methods) {
                    Assert.assertEquals(0, javaMethod.annotations().size());
                    javaMethod.delete();
                }
            }
            javaFileArtefact.store();
            assertFileEqualitySafe(tempFile, mainWithNoMethods);
        } catch (ArtifactException e) {
            logger.exception(e);
        }
                
    }
}
