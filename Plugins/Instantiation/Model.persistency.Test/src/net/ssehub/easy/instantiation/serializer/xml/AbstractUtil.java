package net.ssehub.easy.instantiation.serializer.xml;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import org.junit.Assert;

import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangWriter;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangWriter;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Abstract utility class for test cases.
 * 
 * @author Sass
 *
 */
public class AbstractUtil {
    
    /**
     * Returns the system property determining the directory containing the actual test data.
     * 
     * @return the name of the system property
     */
    protected static String getSystemPropertyName() {
        return "instantiation.serializer.testdata.home";
    }
    
    private static final File TESTDATA = determineTestDataDir(getSystemPropertyName());
    
    /**
     * temporary data where data can be written. Will be cleaned up after tests.
     */
    protected static final File TEMPDATA = new File(TESTDATA, "tmp");
    
    /**
     * Data which must not be modified.
     */
    protected static final File MODELDATA = new File(TESTDATA, "QM2.devel");
    
    /**
     * Data which contains the xml files.
     */
    protected static final File XMLDATA = new File(TESTDATA, "serializedModel");
    
//    /**
//     * The directory containing all tests.
//     * 
//     * @return the test data directory
//     */
//    protected static File getTestDataDir() {
//        return determineTestDataDir(getSystemPropertyName());
//    }
//    
//    /**
//     * The directory containing all tests.
//     * 
//     * @return the test data directory
//     */
//    protected static File getTempDataDir() {
//        return new File(getTestDataDir(), "/tmp");
//    }
    
    /**
     * Determines the actual directory with the test IVML files depending on the
     * JVM system specified property which may contain a specific
     * directory (or be empty -> default directory <code>testdata</code>).
     * 
     * @param property the JVM property to read out
     * 
     * @return the actual directory as file
     */
    protected static File determineTestDataDir(String property) {
        File result;
        String externalLocation = System.getProperty(property);
        if (null == externalLocation) {
            result = new File("testdata");
        } else {
            result = new File(externalLocation);
        }
        return result;
    }
    
    /**
     * Converts a VIL script to string.
     * 
     * @param script    the script to be converted
     * @return  script as string
     * @throws VilException exception
     */
    public static String toVilString(Script script) throws VilException {
        Writer writer = new StringWriter();
        BuildlangWriter visitor = new BuildlangWriter(writer);
        script.accept(visitor);
        String result = writer.toString();
        return result;
    }
    
    /**
     * Converts a VIL script to string.
     * 
     * @param template    the template to be converted
     * @return  script as string
     * @throws VilException exception
     */
    public static String toVtlString(Template template) throws VilException {
        Writer writer = new StringWriter();
        TemplateLangWriter visitor = new TemplateLangWriter(writer);
        template.accept(visitor);
        String result = writer.toString();
        return result;
    }
    
    /**
     * Converts a IVML project to string.
     * 
     * @param project   the project to be converted
     * @return project as string
     * @throws VilException exception
     */
    public static String toIVMLString(Project project) throws VilException {
        String result = StringProvider.toIvmlString(project);
        return result;
    }
    
    /**
     * Loads the properties from the properties file.
     */
    public static void loadProperties() {
        Properties properties = new Properties();
        BufferedInputStream stream;
        String prop = "easy.maven.classpathExclude";
        try {
            File propertyFile = new File("build.properties");
            String exclude = null;
            if (propertyFile.exists()) {
                stream = new BufferedInputStream(new FileInputStream("build.properties"));
                properties.load(stream);
                stream.close();
                exclude = properties.getProperty(prop);
            } else {
                exclude = ".*/Eclipse-SSE-4.3.1/.*";
            }
            System.setProperty(prop, exclude);
        } catch (FileNotFoundException e) {
            Assert.fail(e.getMessage());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Reads a file from the file system.
     * 
     * @param fileName path to the file
     * @return File as string
     * @throws IOException exception
     */
    public String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
