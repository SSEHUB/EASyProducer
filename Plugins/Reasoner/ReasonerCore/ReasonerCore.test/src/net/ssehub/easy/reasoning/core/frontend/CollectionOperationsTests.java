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
package net.ssehub.easy.reasoning.core.frontend;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests collection operations like <tt>collect</tt> or <tt>forall</tt>.
 * These tests are additional tests to the {@link OperationTests}.
 * 
 * @author El-Sharkawy
 */
public abstract class CollectionOperationsTests extends AbstractReasonerFrontendTest {

    /**
     * Performs a test directly located in the operations test directory [convenience].
     * 
     * @param localFile the name of the file directly located in the test directory
     * @param isValid whether the model shall be valid (or not) to pass
     * 
     * @throws IOException in case of problems reading a model
     */
    private void performOpCheck(String localFile, boolean isValid) throws IOException {
        performCheck("collectionOperations/" + localFile, isValid);
    }
    
    // collect
    
    /**
     * Tests whether the reasoner is able to handle fulfilled
     * {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#COLLECT}
     * constraints based on a collection of {@link net.ssehub.easy.varModel.model.datatypes.Compound}s.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testCompoundCollectionConstraintValid() throws IOException {
        performOpCheck("CompoundCollectionConstraintTest_Valid.ivml", true);
    }
    
    /**
     * Tests whether the reasoner is able to detect errors based in a
     * {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#COLLECT}
     * constraints based on a collection of {@link net.ssehub.easy.varModel.model.datatypes.Compound}s.
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testCompoundCollectionConstraintInvalid() throws IOException {
        performOpCheck("CompoundCollectionConstraintTest_Invalid.ivml", false);
    }
}
