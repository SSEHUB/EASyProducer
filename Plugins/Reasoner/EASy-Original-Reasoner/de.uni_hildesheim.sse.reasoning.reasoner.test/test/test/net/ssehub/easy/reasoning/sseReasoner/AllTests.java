package test.net.ssehub.easy.reasoning.sseReasoner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for automated test execution on build server.
 * Do not forget to add new test suites here.<br/>
 * Usually a property is used to specify the location of test data.
 * This is done with the property
 * {@link test.net.ssehub.easy.reasoning.core.frontend.TestConfiguration#SYSTEM_PROPERTY}. For instance: <br/>
 * <tt>-DreasonerCore.testdata.home=C:\EASyProducer-git\Plugins\Reasoner\ReasonerCore\ReasonerCore.test\testdata</tt>
 * @author Sizonenko
 * @author El-Sharkawy
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
    test.net.ssehub.easy.reasoning.sseReasoner.reasoner.RampUpTest.class, // must be first
    test.net.ssehub.easy.reasoning.sseReasoner.adaptation.AllTests.class,
    test.net.ssehub.easy.reasoning.sseReasoner.capabilities.AllTests.class,
    test.net.ssehub.easy.reasoning.sseReasoner.qm.AllTests.class,
    test.net.ssehub.easy.reasoning.sseReasoner.reasoner.AllTests.class,
    test.net.ssehub.easy.reasoning.sseReasoner.performance.AllTests.class,
})
public class AllTests {
    
}
