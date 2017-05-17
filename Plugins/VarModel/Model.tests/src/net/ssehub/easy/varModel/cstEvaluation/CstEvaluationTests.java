/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test Suite for running the CST evaluation tests. 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@SuiteClasses({
    ApplyTests.class,
    OperationCounter.class,
    BooleanOperationsTest.class,
    CompoundOperationsTest.class,
    ConstraintOperationsTest.class,
    EvaluationVisitorTest.class,
    EvaluationVisitorIteratorTest.class,
    DynamicDispatchTest.class,
    IntegerOperationsTest.class,
    RealOperationsTest.class,
    ReferenceEqualityTest.class,
    ReferenceOperationsTest.class,
    SequenceOperationsTest.class,
    SetOperationsTest.class,
    SequenceOperationsTest.class,
    StringOperationsTest.class,
    MetaOperationsTest.class,
    EnumOperationsTest.class,
    ReasonerCaseTests.class,
    VersionOperationsTest.class,
    CustomOpOnCustomDataTypesTest.class
    })
public class CstEvaluationTests {

}
