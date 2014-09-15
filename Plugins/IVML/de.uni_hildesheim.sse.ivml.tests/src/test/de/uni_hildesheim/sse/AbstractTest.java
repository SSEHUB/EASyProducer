package test.de.uni_hildesheim.sse;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Assert;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.model.management.CommentResource;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.validation.IvmlValidationVisitor;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.reasoning.core.importResolver.ReasoningImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * An abstract test support class for reading, parsing and comparing models.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractTest extends de.uni_hildesheim.sse.dslCore.test.AbstractTest<Project> {

    /**
     * The directory containing all tests.
     */
    protected static final File TESTDATA_DIR = determineTestDataDir("ivml.testdata.home");

    /**
     * Starts up the {@link VarModel} by registering {@link #TESTDATA_DIR} as
     * model directory and registering {@link ModelUtility} as model loader.
     */
    @BeforeClass
    public static void startUp() {
        try {
            ReasoningImportResolver.registerAsTopResolver();
            resourceInitialization();
            VarModel.INSTANCE.locations().addLocation(TESTDATA_DIR, OBSERVER);
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
    }

    /**
     * Tears down the {@link VarModel} by unregistering {@link #TESTDATA_DIR}
     * as model directory and unregistering {@link ModelUtility} as model
     * loader.
     */
    @AfterClass
    public static void shutDown() {
        try {
            VarModel.INSTANCE.locations().removeLocation(TESTDATA_DIR, OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail();
        }
        VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, OBSERVER);
    }

    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>fileName</code> as a model, analyzes it, compares the
     * obtained errors with <code>expectedErrorCodes</code>, compares the
     * contents of <code>fileName</code> with the printed (analyzed) model and
     * checks the project information directly obtained from the file and the
     * one cached in {@link VarModel}.
     * 
     * @param fileName
     *            the file containing the model
     * @param expectedName
     *            the expected name of (at least one) containing project
     * @param expectedVersion
     *            the expected version of <code>expectedName</code>
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String fileName, String expectedName,
        String expectedVersion, int... expectedErrorCodes)
        throws IOException {
        assertEqual(new File(fileName), expectedName, expectedVersion,
                expectedErrorCodes);
    }

    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file and the one cached in
     * {@link VarModel}.
     * 
     * @param file
     *            the file containing the model
     * @param expectedName
     *            the expected name of (at least one) containing project,
     *            (may be <b>null</b> to disable check)
     * @param expectedVersion
     *            the expected version of <code>expectedName</code>
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @return the loaded projects
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected List<Project> assertEqual(File file, String expectedName,
        String expectedVersion, int... expectedErrorCodes)
        throws IOException {

        List<Project> loaded = null;
        if (file.exists()) {
            URI uri = URI.createFileURI(file.getAbsolutePath());

            // parse the model
            TranslationResult<Project> result = ModelUtility.INSTANCE.parse(uri);
            String errorCodesMsg = checkErrorCodes(result, null, expectedErrorCodes);
            Assert.assertNull(errorCodesMsg, errorCodesMsg);

            if (0 == result.getErrorCount()) {
                // read model file into memory
                String fileAsString = file2String(file);
                Assert.assertTrue(null != fileAsString);

                // read model into String
                java.io.CharArrayWriter writer = new CharArrayWriter();
                ModelUtility.INSTANCE.print(result, writer, false, false);
                String errorMsg = checkEqualsAndPrepareMessage(fileAsString, writer);
                Assert.assertNull(errorMsg, errorMsg);
            }
            
            loaded = assertProjectInfo(expectedName, expectedVersion, uri, result, expectedErrorCodes);
        } else {
            System.err.println("File '" + file + "' does not exist");
            Assert.assertTrue(false);
        }

        // due to the startUp the VarModel shall already know about the project!
        if (null != expectedName) {
            try {
                Version version;
                if (0 == expectedVersion.length()) {
                    version = null;
                } else {
                    version = new Version(expectedVersion);
                }
                Assert.assertNotNull(VarModel.INSTANCE.availableModels()
                    .getModelInfo(expectedName, version));
            } catch (VersionFormatException e) {
                Assert.assertTrue(false); // shall not happen
            }
        }
        return loaded;
    }
    
    /**
     * Assert that the comments in <code>commentResource</code> (seen as expected)
     * are attached to the proper model elements.
     * 
     * @param projects the projects loaded by {@link #assertEqual(File, String, String, int...)}
     * @param commentResource the resource file containing the expected 
     */
    protected void assertComments(List<Project> projects, File commentResource) {
        Assert.assertNotNull(projects);
        Assert.assertNotNull(commentResource);
        Assert.assertTrue(commentResource.exists());
        
        CommentResource props = new CommentResource();
        FileReader fr = null;
        try {
            fr = new FileReader(commentResource);
            props.load(fr);
            fr.close();
        } catch (IOException e) {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e1) {
                Assert.fail("shall not occur");
            }
            Assert.fail("shall not occur");
        }

        for (int p = 0; p < projects.size(); p++) {
            Project project = projects.get(p);
            for (int e = 0; e < project.getElementCount(); e++) {
                ContainableModelElement elt = project.getElement(e);
                assertComment(elt, props);
                if (elt instanceof Compound) {
                    Compound comp = (Compound) elt;
                    for (int f = 0; f < comp.getElementCount(); f++) {
                        assertComment(comp.getElement(f), props);
                    }
                }
            }
        }
        Assert.assertTrue(props.isEmpty());
    }

    /**
     * Asserts an individual comment assignment.
     * 
     * @param elt the element to look for
     * @param props the comments (modified as a side effect when the comment is properly
     *   assigned, i.e. the mapping is removed)
     */
    private void assertComment(ContainableModelElement elt, CommentResource props) {
        String qName = elt.getQualifiedName();
        String cmt = props.get(qName);
        if (null != cmt) {
            Assert.assertEquals(cmt, elt.getComment());
            props.remove(qName);
        }
    }

    /**
     * Asserts matching data in the project information object, i.e. in the
     * information object read from file as well as in the information object
     * cached in VarModel.
     * 
     * @param expectedName the expected name of the project (may be <b>null</b> to disable check)
     * @param expectedVersion the expected version
     * @param uri the URI of the model
     * @param result the result reading/parsing/analyzing the model
     * @param expectedErrorCodes the expected error codes
     * @return the projects as loaded by {@link VarModel}       
     * @throws IOException in case of I/O problems during obtaining the model
     */
    private List<Project> assertProjectInfo(String expectedName, String expectedVersion,
            URI uri, TranslationResult<Project> result, int[] expectedErrorCodes) throws IOException {
        // get project infos
        List<Project> pRes = null;
        if (null != expectedName) {
            List<ModelInfo<Project>> info = ModelUtility.INSTANCE.obtainInfo(uri);
            HashMap<String, ModelInfo<Project>> map = new HashMap<String, ModelInfo<Project>>();
            for (ModelInfo<Project> pi : info) {
                map.put(getKey(pi.getName(), pi.getVersion()), pi);
            }
            String expectedKey = getKey(expectedName, expectedVersion);
            for (int r = 0; r < result.getResultCount(); r++) {
                de.uni_hildesheim.sse.model.varModel.Project project = result.getResult(r);
                String key = getKey(project.getName(), project.getVersion());
                if (null != expectedKey && expectedKey.equals(key)) {
                    expectedKey = null;
                }
                Assert.assertTrue(null != map.remove(key));
                
                IvmlValidationVisitor valVis = new IvmlValidationVisitor();
                project.accept(valVis);
                if (valVis.getErrorCount() > 0) {
                    System.out.println("validation messages:");
                    for (int m = 0; m < valVis.getMessageCount(); m++) {
                        System.err.println(" - " + valVis.getMessage(m).getDescription());
                    }
                }
                Assert.assertEquals(0, valVis.getErrorCount());
            }
            Assert.assertTrue(map.isEmpty());
            Assert.assertTrue(null == expectedKey); // otherwise wrong expectation
            
            // required for further processing
            pRes = new ArrayList<Project>();
            for (ModelInfo<Project> pi : info) {
                try {
                    ModelInfo<Project> match = VarModel.INSTANCE.availableModels().getModelInfo(pi);
                    Assert.assertNotNull(match);
                    pRes.add(VarModel.INSTANCE.load(match));
                } catch (ModelManagementException e) {
                    if (null == expectedErrorCodes) { // recheck needed!
                        Assert.fail(e.getMessage());
                    }
                }
            }
        }
        return pRes;
    }

    /**
     * Returns the key for hashing a project information object or a project.
     * 
     * @param name
     *            the name of the project
     * @param version
     *            the version of the project
     * @return the key combining both
     */
    private String getKey(String name, Version version) {
        return getKey(name, Version.toString(version));
    }

    /**
     * Returns the key for hashing a project information object or a project.
     * 
     * @param name
     *            the name of the project
     * @param version
     *            the version of the project
     * @return the key combining both
     */
    private String getKey(String name, String version) {
        return name + "_" + version;
    }

}
