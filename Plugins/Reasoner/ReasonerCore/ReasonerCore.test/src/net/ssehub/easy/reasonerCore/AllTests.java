package net.ssehub.easy.reasonerCore;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.ssehub.easy.reasonerCore.model.ReasonerModelTest;
import net.ssehub.easy.reasonerCore.reasoner.AttributeValuesTest;
import net.ssehub.easy.reasonerCore.upgrader.UpgraderTests;

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
    ReasonerModelTest.class })
public class AllTests {
        
}
