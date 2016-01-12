/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.de.uni_hildesheim.sse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.uni_hildesheim.sse.cst.AllCSTTests;
import de.uni_hildesheim.sse.logger.AllLoggerTests;
import de.uni_hildesheim.sse.model.confModel.AllTestsForConfModel;
import de.uni_hildesheim.sse.model.cstEvaluation.CstEvaluationTests;
import de.uni_hildesheim.sse.model.validation.AllValidationTests;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeMapperTests;
import de.uni_hildesheim.sse.model.varModel.filter.mandatoryVars.MandatoryDeclarationClassifierTest;
import de.uni_hildesheim.sse.persistency.IVMLWriterTest;
import de.uni_hildesheim.sse.varModel.ContainableModelElementListTest;
import de.uni_hildesheim.sse.varModel.FreezeBlockTest;
import de.uni_hildesheim.sse.varModel.MessageTest;
import de.uni_hildesheim.sse.varModel.PartialEvaluationBlockTest;
import de.uni_hildesheim.sse.varModel.ProjectInfoTest;
import de.uni_hildesheim.sse.varModel.ProjectInterfaceTest;
import de.uni_hildesheim.sse.varModel.VersionTest;
import de.uni_hildesheim.sse.varModel.datytypes.AllDatatypeTests;
import de.uni_hildesheim.sse.varModel.filter.AllFilterTests;
import de.uni_hildesheim.sse.varModel.management.AllManagementTests;
import de.uni_hildesheim.sse.varModel.rewrite.ProjectRewriteVisitorTest;
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
    AllCSTTests.class,
    AllLoggerTests.class,
    IVMLWriterTest.class,
    ContainableModelElementListTest.class,
    AllDatatypeTests.class,
    FreezeBlockTest.class,
    MessageTest.class,
    PartialEvaluationBlockTest.class,
    ProjectInfoTest.class,
    ProjectInterfaceTest.class,
    CompoundValueTest.class,
    DerivedDatatypeValueTest.class,
    IntValueTest.class,
    RealValueTest.class,
    SequenceValueTest.class,
    SetValueTest.class,
    StringValueTest.class,
    NullValueTest.class,
    ValueFactoryTest.class,
    AllManagementTests.class,
    VersionTest.class,
    ReferenceValueTest.class,
    AllFilterTests.class,
    //CompoundVariableTest (part of AllTestsForConfModel) must be executed after VarModelTest (AllManagementTests)
    AllTestsForConfModel.class,
    ImportValidationTest.class,
//    IVMLValidationVisitorTest.class,
    AllValidationTests.class,
    TypeMapperTests.class,
    CstEvaluationTests.class,
    ProjectRewriteVisitorTest.class,
    MandatoryDeclarationClassifierTest.class
    })
public class AllTests {

}
