package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The test suite for the VIL expresion trees.
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ConstantExpressionTest.class, CallExpressionTest.class, 
    StringReplacerTest.class, ConstructorCallExpressionTest.class })
public class ExpressionTests {

}
