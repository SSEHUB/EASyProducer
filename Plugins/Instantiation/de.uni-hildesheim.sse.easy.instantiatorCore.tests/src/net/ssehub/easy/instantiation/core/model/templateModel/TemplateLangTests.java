package net.ssehub.easy.instantiation.core.model.templateModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The test suite for the template language.
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    IndentationUtilsTests.class, 
    SerializationTest.class, 
    TemplateTest.class,
    ContentFormatterTest.class
})
public class TemplateLangTests {

}
