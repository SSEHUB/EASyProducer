/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.datatypes;

import org.junit.Test;

/**
 * This class tests the correct behavior of the sequence class.
 * @author El-Sharkawy
 *
 */
public class SequenceTestTMP {

    /**
     * Tests whether the sequence including its delegate are instantiated correctly.
     * @throws NullPointerException This exception will be thrown if the delegate is not instantiated correctly.
     */
    @Test
    public void testInstantiation() throws NullPointerException {
        IDatatype seq = Sequence.TYPE;
        int anzOperations = seq.getGenericTypeCount();
        for (int i = 0; i < anzOperations; i++) {
            System.out.println(seq.getOperation(i).getName());
            //Next line must not throw NullPointerException.
            System.out.println(seq.getOperation(i).getOperand().getName());
        }
    }

}
