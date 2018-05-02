package net.ssehub.easy.reasoning.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.ssehub.easy.reasoning.core.reasoner.AttributeValuesTest;
import net.ssehub.easy.reasoning.core.reasoner.ConstraintBaseTest;
import net.ssehub.easy.reasoning.core.reasoner.ConstraintListTest;
import net.ssehub.easy.reasoning.core.reasoner.TypedConstraintTest;
import net.ssehub.easy.reasoning.core.upgrader.UpgraderTests;

/**
 * All tests for the Reasoner Core. Please note that the tests in this test suite 
 * just test the functionality of the reasoner core itself. For the moment, this
 * class 
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
@RunWith(Suite.class)
@SuiteClasses({
    UpgraderTests.class,
    AttributeValuesTest.class, 
    ConstraintListTest.class,
    ConstraintBaseTest.class, 
    TypedConstraintTest.class})
public class AllTests {
        
}
