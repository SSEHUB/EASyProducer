package test;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.JavaUtilitiesTest;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactmodel.XmlFileArtifactTest;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangTests;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionTests;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangTests;
import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilTests;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.LoggingLevel;

/**
 * Test Suite, which starts all individual test cases.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({VilTests.class, ExpressionTests.class, 
    BuildlangTests.class, TemplateLangTests.class, XmlFileArtifactTest.class, JavaUtilitiesTest.class })
public class AllTests {
    
    /**
     * Setup and disable logging at some degree.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.WARN);
    }
}
