package test.net.ssehub.easy.reasoning.sseReasoner.adaptation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Tests for testing the reasoning capabilities for adaptation.<br/>
 * Usually a property is used to specify the location of test data.
 * This is done with the property
 * {@link net.ssehub.easy.reasoning.core.frontend.TestConfiguration#SYSTEM_PROPERTY}. For instance: <br/>
 * <tt>-DreasonerCore.testdata.home=C:\EASyProducer-git\Plugins\Reasoner\ReasonerCore\ReasonerCore.test\testdata</tt>
 * @author Sizonenko
 * @author El-Sharkawy
 */
@RunWith(Suite.class)
@SuiteClasses({
    AdaptationIntegrityTests.class,
    AdaptationScenarioTests.class
    })
public class AllTests {

}