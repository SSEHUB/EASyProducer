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
package net.ssehub.easy.varModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.ssehub.easy.varModel.confModel.AllTestsForConfModel;
import net.ssehub.easy.varModel.cst.AllCSTTests;
import net.ssehub.easy.varModel.cstEvaluation.CstEvaluationTests;
import net.ssehub.easy.varModel.logger.AllLoggerTests;
import net.ssehub.easy.varModel.model.datatypes.AllDatatypeTests;
import net.ssehub.easy.varModel.model.filter.AllFilterTests;
import net.ssehub.easy.varModel.model.rewrite.AllRewriteTests;
import net.ssehub.easy.varModel.persistency.IVMLWriterTest;
import net.ssehub.easy.varModel.validation.AllValidationTests;
import net.ssehub.easy.varModel.varModel.ContainableModelElementListTest;
import net.ssehub.easy.varModel.varModel.FreezeBlockTest;
import net.ssehub.easy.varModel.varModel.MessageTest;
import net.ssehub.easy.varModel.varModel.ModelQueryTest;
import net.ssehub.easy.varModel.varModel.PartialEvaluationBlockTest;
import net.ssehub.easy.varModel.varModel.ProjectInfoTest;
import net.ssehub.easy.varModel.varModel.ProjectInterfaceTest;
import net.ssehub.easy.varModel.varModel.VersionTest;
import net.ssehub.easy.varModel.varModel.management.AllManagementTests;
import net.ssehub.easy.varModel.varModel.management.SerializationTest;
import net.ssehub.easy.varModel.varModel.values.CompoundValueTest;
import net.ssehub.easy.varModel.varModel.values.DerivedDatatypeValueTest;
import net.ssehub.easy.varModel.varModel.values.IntValueTest;
import net.ssehub.easy.varModel.varModel.values.NullValueTest;
import net.ssehub.easy.varModel.varModel.values.RealValueTest;
import net.ssehub.easy.varModel.varModel.values.ReferenceValueTest;
import net.ssehub.easy.varModel.varModel.values.SequenceValueTest;
import net.ssehub.easy.varModel.varModel.values.SetValueTest;
import net.ssehub.easy.varModel.varModel.values.StringValueTest;
import net.ssehub.easy.varModel.varModel.values.ValueFactoryTest;
import net.ssehub.easy.varModel.varModel.versioning.ImportValidationTest;

/**
 * Test Suite for running all test cases. <br>
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
    CompoundValueTest.class,
    net.ssehub.easy.varModel.varModel.values.SerializationTest.class,
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
    ProjectInterfaceTest.class,
    SerializationTest.class,
    AllFilterTests.class,
    //CompoundVariableTest (part of AllTestsForConfModel) must be executed after VarModelTest (AllManagementTests)
    AllTestsForConfModel.class,
    ImportValidationTest.class,
//    IVMLValidationVisitorTest.class,
    AllValidationTests.class,
    CstEvaluationTests.class,
    AllRewriteTests.class,
    ModelQueryTest.class
    })
public class AllTests {

}
