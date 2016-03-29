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
package net.ssehub.easy.varModel.varModel.management;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Sub Test Suite to load all tests related to model management (Project, VarModel, Versions, ...). 
 * @author El-Sharkawy
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
    ProjectTest.class,
    // VarModelTest must be executed before VarModelListenerTest
    VarModelTest.class,
    VarModelListenerTest.class,
    VersionedProjectInfosTest.class
    })
public class AllManagementTests {

}
