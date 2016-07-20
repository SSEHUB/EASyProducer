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

import org.junit.Ignore;
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
    
    // apply
    
    /**
     * Tests whether the reasoner is able to handle fulfilled
     * {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#APPLY}. In detail:
     * <ul>
     *   <li>Tests the creation of a new set by using a apply constraint.</li>
     *   <li>New set will <b>not</b> be assigned to an existing variable.</li>
     *   <li>Size of the new set will be tested -&gt; should <b>not</b> fail.</li>
     *   <li>Further: The type of the new set differs to the original setOf(refTo(String)) -&gt; setOf(String)</li>
     * </ul>
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testApplyCreateSetWithUnpackedReferencesSizeTestValid() throws IOException {
        performOpCheck("Apply_CreateSetWithUnpackedReferences_SizeTest_Valid.ivml", true);
    }
    
    /**
     * Tests whether the reasoner is able to handle a violated
     * {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#APPLY}. In detail:
     * <ul>
     *   <li>Tests the creation of a new set by using a apply constraint.</li>
     *   <li>New set will <b>not</b> be assigned to an existing variable.</li>
     *   <li>Size of the new set will be tested -&gt; should fail.</li>
     *   <li>Further: The type of the new set differs to the original setOf(refTo(String)) -&gt; setOf(String)</li>
     * </ul>
     * 
     * @throws IOException in case of problems reading a model
     */
    @Ignore
    @Test
    public void testApplyCreateSetWithUnpackedReferencesSizeTestInvalid() throws IOException {
        performOpCheck("Apply_CreateSetWithUnpackedReferences_SizeTest_Invalid.ivml", false);
    }
    
    /**
     * Tests whether the reasoner is able to handle a fulfilled
     * {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#APPLY}. In detail:
     * <ul>
     *   <li>Tests the creation of a new set by using a apply constraint.</li>
     *   <li>New set will be assigned to an existing variable.</li>
     *   <li>Size of the new set will be tested -&gt; should <b>not</b> fail.</li>
     *   <li>Further: The type of the new set differs to the original setOf(refTo(String)) -&gt; setOf(String)</li>
     * </ul>
     * 
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testApplyCreateSetWithUnpackedReferencesAssignmentValid() throws IOException {
        performOpCheck("Apply_CreateSetWithUnpackedReferences_Assignment_Valid.ivml", true);
    }
    
    /**
     * Tests whether the reasoner is able to handle a fulfilled
     * {@link net.ssehub.easy.varModel.model.datatypes.OclKeyWords#APPLY}. In detail:
     * <ul>
     *   <li>Tests the creation of a new set by using a apply constraint.</li>
     *   <li>New set will be assigned to an existing variable.</li>
     *   <li>Size of the new set will be tested -&gt; should <b>not</b> fail.</li>
     *   <li>Further: The type of the new set differs to the original setOf(refTo(String)) -&gt; setOf(String)</li>
     * </ul>
     * 
     * @throws IOException in case of problems reading a model
     */
    @Ignore
    @Test
    public void testApplyCreateSetWithUnpackedReferencesAssignmentInvalid() throws IOException {
        performOpCheck("Apply_CreateSetWithUnpackedReferences_Assignment_Invalid.ivml", false);
    }
}
