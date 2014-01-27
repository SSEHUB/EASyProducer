package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The test suite for the buildlanguage.
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({VariableExpressionTest.class, PathRuleMatcherTest.class,
    StrategyCallExpressionTest.class, ScriptTests.class })
public class BuildlangTests {

}
