package test.de.uni_hildesheim.sse.vil.templatelang;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlExpressionParser;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.instantiation.core.model.BuiltIn;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.PathUtils;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.templateModel.ExtensionClassLoaders;
import net.ssehub.easy.instantiation.core.model.templateModel.StreamTracer;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangMetricsVisitor;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.varModel.management.VarModel;

/**
 * Provides an abstract test for all tests of the template language.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractTest extends net.ssehub.easy.dslCore.test.AbstractTest<Template> {

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
        initializeInfrastructure();
        initializeLocations(TESTDATA_DIR);
        // TODO clean temp
    }
    
    /**
     * Initialize the model infrastructure.
     */
    public static final void initializeInfrastructure() {
        ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, new VtlExpressionParser());
        try {
            // for advices
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
            // for VTL
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
    }

    /**
     * Initialize the model infrastructure for the given directory.
     * 
     * @param base the base directory to scan
     */
    public static final void initializeLocations(File base) {
        try {
            // for advices
            VarModel.INSTANCE.locations().addLocation(new File(base, "ivml"), OBSERVER);
            // for VTL
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
     * Creates a file object relative to {@link #getTestFolder()} (not a file).
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
     * @return the warnings collected (may be <b>null</b>)
     * @throws IOException problems finding or reading the model file
     */
    protected List<Message> assertEqual(EqualitySetup<Template> data, int... expectedErrorCodes)
        throws IOException {
        List<Message> warnings = null;
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

                if (data.enableEquals()) {
                    // read model into String
                    java.io.CharArrayWriter expected = new CharArrayWriter();
                    TemplateLangModelUtility.INSTANCE.print(result, expected, false, false);
                    String errorMsg = checkEqualsAndPrepareMessage(fileAsString, expected);
                    Assert.assertTrue(errorMsg, null == errorMsg);
                    assertNamingAndVersion(data, result);
                }
            }
            Assert.assertTrue("multiple templates are not possible in VIL", 1 == result.getResultCount());
            File expectedTrace = data.getExpectedTrace();
            if (null != expectedTrace && 0 == result.getErrorCount()) {
                // for debugging insert DelegatingSysoutWriter here
                Writer trace = new CharArrayWriter();
                try {
                    String fileAsString = file2String(expectedTrace);
                    Assert.assertTrue(null != fileAsString);

                    StringWriter writer = new StringWriter();
                    StreamTracer tTracer = new StreamTracer(trace, getBaseFolders(data));
                    TracerFactory.registerTemplateLanguageTracer(tTracer);
                    TemplateLangExecution exec = new TemplateLangExecution(tTracer, 
                         writer, data.getStartElement(), data.getParameter());
                    result.getResult(0).accept(exec);
                    //String traceAsString = writer.toString().trim();
                    //Assert.assertTrue(checkEqualsAndPrint(fileAsString, traceAsString));
                    TracerFactory.unregisterTemplateLanguageTracer(tTracer);
                    String errorMsg = checkEqualsAndPrepareMessage(fileAsString, trace);
                    if (null != errorMsg) {
                        Assert.assertEquals(fileAsString.trim(), trace.toString().trim());
                        Assert.fail(errorMsg);
                    }
                    if (null != data.getExpectedOutputFile()) {
                        fileAsString = file2String(data.getExpectedOutputFile());
                        Assert.assertTrue(null != fileAsString);
                        errorMsg = checkEqualsAndPrepareMessage(fileAsString, writer, false);
                        Assert.assertTrue(errorMsg, null == errorMsg);
                    }
                    // just to test it
                    System.setProperty("easy.vtl.metrics", "true");
                    TemplateLangMetricsVisitor.recordMetrics(result.getResult(0), 0);
                } catch (VilException e) {
                    if (null == messages) {
                        messages = new ArrayList<Message>();
                    }
                    messages.add(new Message(e.getMessage(), Status.ERROR, null, null, e.getId()));
                }
            }
            warnings = new ArrayList<Message>();
            String errorCodesMsg = checkErrorCodes(messages, warnings, expectedErrorCodes);
            Assert.assertNull(errorCodesMsg, errorCodesMsg);
        } else {
            Assert.assertTrue("File '" + file + "' does not exist", false);
        }
        return warnings;
    }

    /**
     * Asserts that no expected warnings are missing.
     * 
     * @param warnings the warnings to check
     * @param expectedWarnings the expected warnings
     */
    protected static void assertWarnings(List<Message> warnings, int... expectedWarnings) {
        String msg = checkWarnings(warnings, expectedWarnings);
        Assert.assertNull(msg, msg);
    }
    
    /**
     * Obtain the base folders (for the stream tracer) from <code>setup</code>.
     * 
     * @param setup the setup instance to be analyzed for default parameters
     * @return the base folders or <b>null</b>
     */
    private static String[] getBaseFolders(EqualitySetup<Template> setup) {
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
                    } catch (VilException e) {
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
