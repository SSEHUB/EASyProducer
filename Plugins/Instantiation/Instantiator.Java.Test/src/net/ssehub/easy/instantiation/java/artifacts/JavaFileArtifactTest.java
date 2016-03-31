package net.ssehub.easy.instantiation.java.artifacts;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEqualitySafe;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;

/**
 * Test the Java Artifacts.
 * 
 * @author Sass
 * 
 */
public class JavaFileArtifactTest extends AbstractExecutionTest<Script> {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(JavaFileArtifactTest.class,
        "net.ssehub.easy.instantiation.java.tests");

    // TODO ok for now as the JavaFileArtifact was not registered with the
    // ArtifactFactory,
    // shall work via ArtifactFactory
    private static final DefaultJavaFileArtifactCreator CREATOR = new DefaultJavaFileArtifactCreator();

    private static File constantAttributes;
    private static File variableAttributes;
    private static File mainWithNoMethods;
    private static File originalFile;
    private static File importFile;
    private static File organizedImports;
    private static File packageFile;
    private static File renamedPackage;
    private static File copyFile;
    private static File qualifiedNames;
    private static File renamedQualifiedNames;
    private static File organizedCopyFile;

    private static File temp;
    private static File tempFile;

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("instantiator.java.testdata.home");
    }

    /**
     * Initializes this test.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Before
    public void setUpBeforeClass() throws IOException {
        temp = createTempDir("javaArtifacts");
        tempFile = new File(temp, "Tmp.java");

        constantAttributes = copyOriginal("MainConstant.java");
        variableAttributes = copyOriginal("MainVariable.java");
        mainWithNoMethods = copyOriginal("MainWithNoMethods.java");

        organizedImports = copyOriginal("OrganizedImports.java");
        renamedPackage = copyOriginal("RenamedPackage.java");
        renamedQualifiedNames = copyOriginal("RenamedQualifiedNames.java");

        organizedCopyFile = copyOriginal("OrganizedCopyFile.java");

        originalFile = new File(getArtifactsFolder() + "/src2/test/MainOrg.java");
        importFile = new File(getArtifactsFolder() + "/src2/test/Imports.java");
        packageFile = new File(getArtifactsFolder() + "/src2/test/Packages.java");
        qualifiedNames = new File(getArtifactsFolder() + "/src2/test/QualifiedNames.java");
        copyFile = new File(getArtifactsFolder() + "/src2/test/Copy.java");
    }

    /**
     * Cleans up this test.
     */
    @After
    public void tearDownAfter() {
        deleteQuietly(temp);
    }
    
    /**
     * Formats a specific file with eclipse code formatter.
     * 
     * @param file
     *            the file to be formatted
     */
    public static void formatFile(File file) {
        /*
         * TODO DIRTY! TODO REFACTOR! Needs to be done because the changes are
         * formatted by the Eclipse CodeFormatter. The formatter inserts tabs
         * instead of spaces.
         */
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(file, null);
            Set<JavaClass> classes = javaFileArtefact.classes();
            for (JavaClass javaClass : classes) {
                javaClass.notifyChildChanged(javaClass);
                javaClass.store();
            }
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Copies the given original file into the temp folder.
     * 
     * @param name
     *            the name of the original file (no path)
     * @return the temp file
     * @throws IOException
     *             in case of I/O problems
     */
    private final File copyOriginal(String name) throws IOException {
        File orig = new File(getArtifactsFolder(), "src2/test/" + name);
        File tmp = new File(temp, name);
        copyFile(orig, tmp);
        return tmp;
    }


    /**
     * Test if attributes are made constant.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testMakeAttributeConstant() throws IOException {
        formatFile(constantAttributes);
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
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Test if attributes are made variable.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testMakeAttributeVariable() throws IOException {
        formatFile(variableAttributes);
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
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Test if annotations are found.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testHasAnnotations() throws IOException {
        copyFile(originalFile, tempFile); // just to be on the safe side
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            Assert.assertEquals(true, javaFileArtefact.hasAnnotation("VariationPoint", null, "A"));
            Assert.assertEquals(true, javaFileArtefact.hasAnnotation("VariationPoint", null, "B"));
            Assert.assertEquals(false, javaFileArtefact.hasAnnotation("VariationPoint", null, "5"));
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Test if methods can be deleted.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testDeleteMethods() throws IOException {
        formatFile(mainWithNoMethods);
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
        } catch (VilException e) {
            logger.exception(e);
        }

    }

    /**
     * Test if imports can be organized.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testRenameImports() throws IOException {
        formatFile(organizedImports);
        copyFile(importFile, tempFile);
        String oldName = "java.io";
        String newName = "java.io.test";
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            javaFileArtefact.renameImports(oldName, newName);
            javaFileArtefact.store();
            // Test if import declarations were renamed
            assertFileEqualitySafe(tempFile, organizedImports);
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Test if a (qualified) package name in a Java artifact can be renamed.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testRenamePackage() throws IOException {
        formatFile(renamedPackage);
        copyFile(packageFile, tempFile);
        String oldName = "look";
        String newName = "look.at.me";
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            javaFileArtefact.renamePackages(oldName, newName);
            javaFileArtefact.store();
            // Test if package declaration was renamed
            assertFileEqualitySafe(tempFile, renamedPackage);
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Test if a qualified name can be renamed.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testRenameQualifiedNames() throws IOException {
        formatFile(renamedQualifiedNames);
        copyFile(qualifiedNames, tempFile);
        String oldName = "com.foobar";
        String newName = "com.foobar.test";
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            javaFileArtefact.renameQualifiedNames(oldName, newName);
            javaFileArtefact.store();
            // Test if qualified name was renamed
            assertFileEqualitySafe(tempFile, renamedQualifiedNames);
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Test if a java file artifact can be copied to a new destination while the
     * folder structure changes.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testCopyJavaFileArtifact() throws IOException {
        formatFile(organizedCopyFile);
        copyFile(copyFile, tempFile);
        String oldName = "the.old.folder.destination";
        String newName = "the.created.folder.destination.which.has.a.different.path";
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            javaFileArtefact.renameImports(oldName, newName);
            javaFileArtefact.renamePackages(oldName, newName);
            javaFileArtefact.renameQualifiedNames(oldName, newName);
            javaFileArtefact.store();
            // Test if all imports, packages and qualified names were renamed
            assertFileEqualitySafe(tempFile, organizedCopyFile);
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Test if a java file artifact can be copied to a new destination while the
     * folder structure changes.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testOrganizeJavaFileArtifact() throws IOException {
        formatFile(organizedCopyFile);
        copyFile(copyFile, tempFile);
        String oldName = "the.old.folder.destination";
        String newName = "the.created.folder.destination.which.has.a.different.path";
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            javaFileArtefact.modifyNamespace(oldName, newName);
            // Test if all imports, packages and qualified names were renamed
            assertFileEqualitySafe(tempFile, organizedCopyFile);
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Test if a java file artifact can be copied to a new destination while the
     * folder structure changes. Test if the name mapping is applied.
     * 
     * @throws IOException
     *             shall not occur
     */
    @Test
    public void testOrganizeJavaFileArtifactWithMap() throws IOException {
        formatFile(organizedCopyFile);
        copyFile(copyFile, tempFile);
        String oldName = "the.old.folder.destination";
        String newName = "the.created.folder.destination.which.has.a.different.path";
        Map<String, String> nameMapping = new HashMap<String, String>();
        nameMapping.put(oldName, newName);
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            javaFileArtefact.modifiyNamespace(nameMapping);
            // Test if all imports, packages and qualified names were renamed
            assertFileEqualitySafe(tempFile, organizedCopyFile);
        } catch (VilException e) {
            logger.exception(e);
        }
    }

}
