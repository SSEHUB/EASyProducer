package de.uni_hildesheim.sse.varModel.filter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test Suite for running tests of this package, the tests for the filters.
 * @author El-Sharkawy
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
    AbstractFrozenElementsFinderTest.class,
    ConstraintSeparatorTest.class,
    DatatypeFinderTest.class,
    FreezeBlockFinderTest.class,
    FrozenElementsFinderTest.class,
    ProjectInterfaceTest.class,
    ReferenceValueFinderTest.class
    })
public class AllFilterTests {

}
