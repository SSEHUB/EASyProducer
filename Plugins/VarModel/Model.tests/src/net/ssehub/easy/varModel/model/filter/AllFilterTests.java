package net.ssehub.easy.varModel.model.filter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.ssehub.easy.varModel.model.filter.mandatoryVars.MandatoryDeclarationClassifierTest;

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
    IDecisionVariableInConstraintFinderTest.class,
    ProjectInterfaceTest.class,
    ReferenceValueFinderTest.class,
    
    // Sub packages
    MandatoryDeclarationClassifierTest.class
    })
public class AllFilterTests {

}
