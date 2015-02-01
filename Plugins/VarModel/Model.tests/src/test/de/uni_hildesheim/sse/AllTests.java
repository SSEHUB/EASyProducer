package test.de.uni_hildesheim.sse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.uni_hildesheim.sse.cst.CommentTest;
import de.uni_hildesheim.sse.cst.ConstraintReplacerTest;
import de.uni_hildesheim.sse.cst.ContainerOperationCallTest;
import de.uni_hildesheim.sse.cst.OCLFeatureCallTest;
import de.uni_hildesheim.sse.cst.ParenthesisTest;
import de.uni_hildesheim.sse.logger.EASyLoggerFactoryTest;
import de.uni_hildesheim.sse.logger.JavaLoggerTest;
import de.uni_hildesheim.sse.model.confModel.AssignmentResolverTest;
import de.uni_hildesheim.sse.model.confModel.CompoundVariableTest;
import de.uni_hildesheim.sse.model.confModel.ConfigurationTest;
import de.uni_hildesheim.sse.model.confModel.DecisionVariableTest;
import de.uni_hildesheim.sse.model.confModel.SetVariableTest;
import de.uni_hildesheim.sse.model.cstEvaluation.CstEvaluationTests;
import de.uni_hildesheim.sse.model.validation.IvmlIdentifierCheckTest;
import de.uni_hildesheim.sse.model.validation.IvmlValidationVisitorTest;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeMapperTests;
import de.uni_hildesheim.sse.persistency.IVMLWriterTest;
import de.uni_hildesheim.sse.varModel.ContainableModelElementListTest;
import de.uni_hildesheim.sse.varModel.FreezeBlockTest;
import de.uni_hildesheim.sse.varModel.MessageTest;
import de.uni_hildesheim.sse.varModel.PartialEvaluationBlockTest;
import de.uni_hildesheim.sse.varModel.ProjectInfoTest;
import de.uni_hildesheim.sse.varModel.ProjectInterfaceTest;
import de.uni_hildesheim.sse.varModel.VersionTest;
import de.uni_hildesheim.sse.varModel.datytypes.AttributeTest;
import de.uni_hildesheim.sse.varModel.datytypes.BasisDatatypeTest;
import de.uni_hildesheim.sse.varModel.datytypes.CompoundTest;
import de.uni_hildesheim.sse.varModel.datytypes.ContainerTest;
import de.uni_hildesheim.sse.varModel.datytypes.DerivedDatatypeTest;
import de.uni_hildesheim.sse.varModel.datytypes.EnumTest;
import de.uni_hildesheim.sse.varModel.datytypes.OperationTest;
import de.uni_hildesheim.sse.varModel.datytypes.ReferenceTest;
import de.uni_hildesheim.sse.varModel.datytypes.SequenceTestTMP;
import de.uni_hildesheim.sse.varModel.filter.ConstraintSeparatorTest;
import de.uni_hildesheim.sse.varModel.filter.FreezeBlockFinderTest;
import de.uni_hildesheim.sse.varModel.filter.FrozenElementsFinderTest;
import de.uni_hildesheim.sse.varModel.management.ProjectTest;
import de.uni_hildesheim.sse.varModel.management.VarModelListenerTest;
import de.uni_hildesheim.sse.varModel.management.VarModelTest;
import de.uni_hildesheim.sse.varModel.management.VersionedProjectInfosTest;
import de.uni_hildesheim.sse.varModel.values.CompoundValueTest;
import de.uni_hildesheim.sse.varModel.values.DerivedDatatypeValueTest;
import de.uni_hildesheim.sse.varModel.values.IntValueTest;
import de.uni_hildesheim.sse.varModel.values.NullValueTest;
import de.uni_hildesheim.sse.varModel.values.RealValueTest;
import de.uni_hildesheim.sse.varModel.values.ReferenceValueTest;
import de.uni_hildesheim.sse.varModel.values.SequenceValueTest;
import de.uni_hildesheim.sse.varModel.values.SetValueTest;
import de.uni_hildesheim.sse.varModel.values.StringValueTest;
import de.uni_hildesheim.sse.varModel.values.ValueFactoryTest;
import de.uni_hildesheim.sse.varModel.versioning.ImportValidationTest;

/**
 * Test Suite for running all test cases. <br/>
 * this test suite is for simplifying local testing of all test cases, and is not used on the CruiseControl server.
 * Please insert all test cases to this test suite for simplify testing.
 * @author El-Sharkawy
 *
 */
@RunWith(Suite.class)
// TODO restructure into sub-test-suites and reference them here (done for cstEvaluation)
@SuiteClasses({
    ConstraintReplacerTest.class,
    ContainerOperationCallTest.class,
    OCLFeatureCallTest.class,
    DecisionVariableTest.class,
    IVMLWriterTest.class,
    ContainableModelElementListTest.class,
    AttributeTest.class,
    BasisDatatypeTest.class,
    CompoundTest.class,
    ContainerTest.class,
    DerivedDatatypeTest.class,
    EnumTest.class,
    OperationTest.class,
    ReferenceTest.class,
    SequenceTestTMP.class,
    FreezeBlockTest.class,
    MessageTest.class,
    PartialEvaluationBlockTest.class,
    ProjectInfoTest.class,
    ProjectInterfaceTest.class,
    ProjectTest.class,
    CompoundValueTest.class,
    DerivedDatatypeValueTest.class,
    IntValueTest.class,
    RealValueTest.class,
    SequenceValueTest.class,
    SetValueTest.class,
    StringValueTest.class,
    NullValueTest.class,
    ValueFactoryTest.class,
    // VarModelTest must be executed before VarModelListenerTest
    VarModelTest.class,
    VarModelListenerTest.class,
    //CompoundVariableTest must be executed after VarModelTest
    CompoundVariableTest.class,
    VersionTest.class,
    VersionedProjectInfosTest.class,
    ReferenceValueTest.class,
    FreezeBlockFinderTest.class,
    FrozenElementsFinderTest.class,
    ConstraintSeparatorTest.class,
    ParenthesisTest.class,
    ConfigurationTest.class,
    CommentTest.class,
    SetVariableTest.class,
    ImportValidationTest.class,
//    IVMLValidationVisitorTest.class,
    EASyLoggerFactoryTest.class,
    JavaLoggerTest.class,
    IvmlIdentifierCheckTest.class,
    IvmlValidationVisitorTest.class,
    TypeMapperTests.class,
    CstEvaluationTests.class,
    AssignmentResolverTest.class
    })
public class AllTests {

}
