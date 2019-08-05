package net.ssehub.easy.instantiation.core;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.LoggingLevel;
import net.ssehub.easy.instantiation.core.model.JavaUtilitiesTest;
import net.ssehub.easy.instantiation.core.model.artifactmodel.XmlFileArtifactTest;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangTests;
import net.ssehub.easy.instantiation.core.model.common.CommonTests;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionTests;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangTests;
import net.ssehub.easy.instantiation.core.model.vilTypes.VilTests;

/**
 * Test Suite, which starts all individual test cases.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({VilTests.class, ExpressionTests.class, CommonTests.class,
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
