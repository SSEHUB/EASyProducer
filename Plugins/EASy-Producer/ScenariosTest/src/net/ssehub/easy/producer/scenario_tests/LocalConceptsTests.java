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
package net.ssehub.easy.producer.scenario_tests;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.standard.Persistencer;

/**
 * Tests that cannot be executed on Jenkins by now.
 * 
 * @author Holger Eichelberger
 */
public class LocalConceptsTests extends ConceptsTests {

    /**
     * Sets the IVML location on startup.
     * 
     * @throws ModelManagementException shall not occur, leads to failure
     */
    @Before
    public void startup() throws ModelManagementException {
        super.startup();
        PersistenceUtils.loadDefaultModels(Persistencer.class.getClassLoader(), ProgressObserver.NO_OBSERVER, null);
    }

    /**
     * Unsets the IVML location on startup.
     * 
     * @throws ModelManagementException shall not occur, leads to failure
     */
    @After
    public void end() throws ModelManagementException {
        super.end();
    }
    
    /**
     * Tests availability of IVML default library. Basically the same test as for EASy core
     * but here without initializing the full EASy core.
     */
    @Test
    public void testDefaultLib() {
        HashMap<String, Object> expected = new HashMap<String, Object>();
        expected.put("var", Boolean.TRUE);
        doConceptTest("DefaultLibTest", expected);
    }
    
}
