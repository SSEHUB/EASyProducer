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
package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.IOException;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;

/**
 * An abstract test for basic (structural) tests.
 * 
 * @param <M> the actual model type
 * @author Holger Eichelberger
 */
public abstract class AbstractBasicTest <M extends Script> extends AbstractTest<M> {

    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * no version shall be checked.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedName
     *            the expected name of the model
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, String expectedName, int... expectedErrorCodes) 
        throws IOException {
        EqualitySetup data = new EqualitySetup(createFile(file), expectedName, null);
        assertEqual(data, expectedErrorCodes);
    }
    
    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * the name of the model is the same as of the file.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedName
     *            the expected name of the model
     * @param expectedVersion
     *            the expected version of <code>expectedName</code>
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, String expectedName, String expectedVersion, int... expectedErrorCodes) 
        throws IOException {
        EqualitySetup data = new EqualitySetup(createFile(file), expectedName, expectedVersion, null);
        assertEqual(data, expectedErrorCodes);
    }
    
    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * the name of the model is the same as of the file and no version.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, int... expectedErrorCodes) throws IOException {
        EqualitySetup data = new EqualitySetup(createFile(file), file, null, null);
        assertEqual(data, expectedErrorCodes);
    }

}
