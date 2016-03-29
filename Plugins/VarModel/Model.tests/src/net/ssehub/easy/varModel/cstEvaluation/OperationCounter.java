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

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.cstEvaluation.EvaluatorRegistry;
import net.ssehub.easy.varModel.cstEvaluation.IIteratorEvaluator;
import net.ssehub.easy.varModel.cstEvaluation.IOperationEvaluator;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.Types;

/**
 * Just to count the actually implemented evaluation operations.
 * 
 * @author Holger Eichelberger
 */
public class OperationCounter {
    
    /**
     * Counts the implemented operations.
     * 
     * @param printMissing print out the missing operations
     * @return the number of implemented operations
     */
    private static int count(boolean printMissing) {
        int implemented = 0;
        for (int o = 0; o < Operation.getOperationsCount(); o++) {
            Operation op = Operation.getOperation(o);
            if (op.isContainerOperation()) {
                IIteratorEvaluator eval = EvaluatorRegistry.getIteratorEvaluator(op);
                if (null != eval) {
                    implemented++;
                } else {
                    if (printMissing) {
                        System.out.println("Missing: " + op.getSignature());
                    }
                }
            } else {
                IOperationEvaluator eval = EvaluatorRegistry.getOperationEvaluator(op);
                if (null != eval) {
                    implemented++;
                } else {
                    if (printMissing) {
                        System.out.println("Missing: " + op.getSignature());
                    }
                }
            }
        }
        return implemented;
    }
    
    /**
     * Prints the currently implemented operations. Turn into test when finished with implementation.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        // force init
        IDatatype[] types = Types.getTypes();
        System.out.println("Types: " + Arrays.toString(types));
        System.out.println();
        int count = Operation.getOperationsCount();
        int implemented = count(true);
        
        System.out.println();
        System.out.println("implemented: " + implemented + " missing: " + (count - implemented) + " total: " + count 
            + ", " + (implemented / (double) count) * 100 + "% implemented");
    }
    
    /**
     * Just a structural test whether all operatins are implemented.
     */
    @Test
    public void testImplemented() {
        // force init
        Types.getTypes();
        int count = Operation.getOperationsCount();
        int implemented = count(true);
        Assert.assertEquals(implemented  + " IVML operations are not implemented", count, implemented);
    }

}
