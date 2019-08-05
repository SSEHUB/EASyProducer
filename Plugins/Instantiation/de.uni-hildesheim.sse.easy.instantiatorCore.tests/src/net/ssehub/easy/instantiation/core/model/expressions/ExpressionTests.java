package net.ssehub.easy.instantiation.core.model.expressions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The test suite for the VIL expresion trees.
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ConstantExpressionTest.class, CallExpressionTest.class, 
    StringParserTest.class, ConstructorCallExpressionTest.class, SerializationTest.class })
public class ExpressionTests {

}
