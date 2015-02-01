package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangWriter;

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
        return "persistency.testdata.home";
    }
    
    /**
     * The directory containing all tests.
     * 
     * @return the test data directory
     */
    protected File getTestDataDir() {
        return determineTestDataDir(getSystemPropertyName());
    }
    
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
     * @throws VilLanguageException exception
     */
    public static String toVilString(Script script) throws VilLanguageException {
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
     * @throws VilLanguageException exception
     */
    public static String toVtlString(Template template) throws VilLanguageException {
        Writer writer = new StringWriter();
        TemplateLangWriter visitor = new TemplateLangWriter(writer);
        template.accept(visitor);
        String result = writer.toString();
        return result;
    }
}
