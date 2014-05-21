package test.de.uni_hildesheim.sse.vil.templatelang;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.PathUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ExtensionClassLoaders;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.StreamTracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.vil.templatelang.VtlExpressionParser;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;

/**
 * Provides an abstract test for all tests of the template language.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractTest extends de.uni_hildesheim.sse.dslCore.test.AbstractTest<Template> {

    /**
     * The directory containing all tests.
     */
    protected static final File TESTDATA_DIR = determineTestDataDir("vil.templatelang.testdata.home");

    /**
     * Starts up the test by calling {@link #resourceInitialization()}.
     */
    @BeforeClass
    public static void startUp() {
        resourceInitialization();
        BuiltIn.initialize();
        ExtensionClassLoaders.registerLoader(AbstractTest.class.getClassLoader());
        try {
            TypeRegistry.DEFAULT.registerType(StringArtifact.class);
        } catch (VilException e) {
            if (VilException.ID_ALREADY_REGISTERED != e.getId()) {
                Assert.fail("unexpected exception: " + e.getMessage());
            }
        }
        initializeInfrastructure(TESTDATA_DIR);
        // TODO clean temp
    }
    
    /**
     * Initialize the model infrastructure for the given directory.
     * 
     * @param base the base directory to scan
     */
    public static final void initializeInfrastructure(File base) {
        TemplateLangExecution.setExpressionParser(new VtlExpressionParser());
        try {
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
            TemplateModel.INSTANCE.locations().addLocation(base, OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        ExtensionClassLoaders.unregisterLoader(AbstractTest.class.getClassLoader());
    }
    
    /**
     * Returns the actual test folder.
     * 
     * @return the actual test folder
     */
    protected abstract File getTestFolder();
    
    /**
     * Creates a file object relative to {@link #DIR} (not a file).
     * 
     * @param name
     *            the name of the file (excluding ".vil")
     * @return the file
     */
    protected File createFile(String name) {
        return new File(getTestFolder(), name + ".vtl");
    }

    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file or cached in the model
     * management.
     * 
     * @param data the data describing the setup
     * @param expectedErrorCodes the expected and allowed error codes (errors occurring
     *   multiple times need to be listed multiple times here)
     * @throws IOException problems finding or reading the model file
     */
    protected void assertEqual(EqualitySetup data, int... expectedErrorCodes)
        throws IOException {
        File file = data.getFile();
        if (file.exists()) {
            URI uri = URI.createFileURI(file.getAbsolutePath());

            // parse the model
            TranslationResult<Template> result = TemplateLangModelUtility.INSTANCE.parse(uri);
            List<Message> messages = result.getMessageListSpecific();
            
            Assert.assertTrue("no result produced: " + toString(messages), result.getResultCount() > 0);
            if (0 == result.getErrorCount()) {
                // read model file into memory
                String fileAsString = file2String(file);
                Assert.assertTrue("not found: " + file, null != fileAsString);

                // read model into String
                java.io.CharArrayWriter expected = new CharArrayWriter();
                TemplateLangModelUtility.INSTANCE.print(result, expected, false, false);
                String errorMsg = checkEqualsAndPrepareMessage(fileAsString, expected);
                Assert.assertTrue(errorMsg, null == errorMsg);
                assertNamingAndVersion(data, result);
            }
            Assert.assertTrue("multiple templates are not possible in VIL", 1 == result.getResultCount());
            
            File expectedTrace = data.getExpectedTrace();
            if (null != expectedTrace && 0 == result.getErrorCount()) {
                java.io.CharArrayWriter trace = new CharArrayWriter();
                try {
                    String fileAsString = file2String(expectedTrace);
                    Assert.assertTrue(null != fileAsString);

                    StringWriter writer = new StringWriter();
                    TemplateLangExecution exec = new TemplateLangExecution(new StreamTracer(trace, 
                        getBaseFolders(data)),  writer, data.getStartElement(), data.getParameter());
                    result.getResult(0).accept(exec);
                    //String traceAsString = writer.toString().trim();
                    //Assert.assertTrue(checkEqualsAndPrint(fileAsString, traceAsString));
                    String errorMsg = checkEqualsAndPrepareMessage(fileAsString, trace);
                    Assert.assertNull(errorMsg, errorMsg);
                    
                    if (null != data.getExpectedOutputFile()) {
                        fileAsString = file2String(data.getExpectedOutputFile());
                        Assert.assertTrue(null != fileAsString);
                        errorMsg = checkEqualsAndPrepareMessage(fileAsString, writer, false);
                        Assert.assertTrue(errorMsg, null == errorMsg);
                    }
                } catch (VilLanguageException e) {
                    if (null == messages) {
                        messages = new ArrayList<Message>();
                    }
                    messages.add(new Message(e.getMessage(), Status.ERROR, null, null, e.getId()));
                }
            }
            String errorCodesMsg = checkErrorCodes(messages, expectedErrorCodes);
            Assert.assertNull(errorCodesMsg, errorCodesMsg);
        } else {
            Assert.assertTrue("File '" + file + "' does not exist", false);
        }
    }
    
    /**
     * Obtain the base folders (for the stream tracer) from <code>setup</code>.
     * 
     * @param setup the setup instance to be analyzed for default parameters
     * @return the base folders or <b>null</b>
     */
    private static String[] getBaseFolders(EqualitySetup setup) {
        List<String> tmp = new ArrayList<String>();
        Map<String, Object> param = setup.getParameter();
        if (null != param) {
            for (Object o : param.values()) {
                if (o instanceof IFileSystemArtifact) {
                    IFileSystemArtifact artifact = (IFileSystemArtifact) o;
                    try {
                        File path = artifact.getPath().getAbsolutePath();
                        if (FileUtils.isFile(path)) {
                            path = path.getParentFile();
                        }
                        tmp.add(PathUtils.normalize(path.getAbsolutePath()));
                    } catch (ArtifactException e) {
                    }
                }
            }
        }
        String[] result;
        if (tmp.size() > 0) {
            result = new String[tmp.size()];
            tmp.toArray(result);
        } else {
            result = null;
        }
        return result;
    }

    
}
