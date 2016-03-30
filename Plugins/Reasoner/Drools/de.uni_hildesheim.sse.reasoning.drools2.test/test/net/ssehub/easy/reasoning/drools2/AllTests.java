package net.ssehub.easy.reasoning.drools2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.ssehub.easy.reasoning.drools2.translation.DroolsEngineTests;
import net.ssehub.easy.reasoning.drools2.translation.ModelTranslatorTest;
import net.ssehub.easy.reasoning.drools2.translation.OCLFeatureTranslationFactoryTest;

/**
 * Bundling all tests.
 * @author Sizonenko
 * @author El-Sharkawy
 */
@RunWith(Suite.class)
@SuiteClasses({
    // FIXME SE: OperationTest is currently not working with Drools2
    //OperationTests.class,
    ModelTranslatorTest.class,
    OCLFeatureTranslationFactoryTest.class,
    DroolsEngineTests.class,
    ReasoningScenarioTests.class
    })
public class AllTests {

}
