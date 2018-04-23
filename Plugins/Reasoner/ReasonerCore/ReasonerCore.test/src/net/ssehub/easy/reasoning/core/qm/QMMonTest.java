/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.qm;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Qualimaster monitoring test.
 * Model is valid.
 * 
 * @author Holger Eichelberger
 */
public class QMMonTest extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected QMMonTest(ITestDescriptor descriptor) {
        super(descriptor, "qmMonTest");
    }

    /**
     * Basic test.
     * 
     * @throws ModelQueryException shall not occur
     * @throws ConfigurationException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test    
    public void monTest() throws ModelQueryException, ConfigurationException, ValueDoesNotMatchTypeException {
        Project prj = loadProject("QM");
        Configuration config = new Configuration(prj, true);
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setRuntimeMode(true);
        IReasoner reasoner = createReasoner();
        ReasoningResult rResult = reasoner.propagate(prj, config, rConfig, ProgressObserver.NO_OBSERVER);
        Assert.assertFalse(rResult.hasConflict());

        AbstractVariable alg1Decl = ModelQuery.findVariable(prj, "alg1", null);
        AbstractVariable alg2Decl = ModelQuery.findVariable(prj, "alg2", null);
        IDecisionVariable alg1 = config.getDecision(alg1Decl);
        IDecisionVariable alg2 = config.getDecision(alg2Decl);
        
        alg1.getNestedElement("throughputItem").setValue(
            ValueFactory.createValue(IntegerType.TYPE, 22), AssignmentState.ASSIGNED);
        alg2.getNestedElement("throughputItem").setValue(
            ValueFactory.createValue(IntegerType.TYPE, 22), AssignmentState.ASSIGNED);

        rResult = reasoner.propagate(prj, config, rConfig, ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(rResult.hasConflict());
    }

}
