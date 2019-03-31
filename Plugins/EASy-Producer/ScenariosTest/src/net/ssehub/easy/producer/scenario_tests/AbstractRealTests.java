/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTestDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector;

/**
 * Test infrastructure class for real tests.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractRealTests extends AbstractEasyScenarioTest {
    
    protected boolean enableRealTimeAsserts;

    // a simple runtime variability test, at least that runtime reasoning seems to be working
    @Override
    protected Configuration assertConfiguration(net.ssehub.easy.varModel.model.Project prj, Mode mode) {
        Configuration result = super.assertConfiguration(prj, mode);
        if (enableRealTimeAsserts && "QM".equals(prj.getName())) {
            net.ssehub.easy.varModel.confModel.Configuration cfg = result.getConfiguration();
            try {
                AbstractVariable ppfe2 = ModelQuery.findVariable(prj, "PriorityPip_FamilyElement2", null);
                if (null != ppfe2) {
                    IDecisionVariable cVar = cfg.getDecision(ppfe2);
                    IDecisionVariable eVar = cVar.getNestedElement("capacity");
                    // set to extreme high capacity, shall lead to failure
                    eVar.setValue(ValueFactory.createValue(eVar.getDeclaration().getType(), 1.0), 
                        AssignmentState.ASSIGNED);
                    System.out.println("Performing runtime reasoning/propagation...");
                    ReasonerConfiguration rCfg = new ReasonerConfiguration();
                    rCfg.setRuntimeMode(true);
                    for (int r = 1; r <= AbstractTest.NUM_INCREMENTAL_REASONING; r++) {
                        String id = mode.doMeasure() ? MeasurementCollector.start(cfg, "SCENARIO-INC", r) : null;
                        ReasoningResult res = ReasonerFrontend.getInstance().propagate(prj, 
                            cfg, rCfg, ProgressObserver.NO_OBSERVER);
                        if (null != id) {
                            MeasurementCollector.endAuto(id);
                            net.ssehub.easy.reasoning.core.reasoner.AbstractTest.transferReasoningMeasures(
                                MeasurementCollector.getInstance(), id, getMeasurements(), res);
                            MeasurementCollector.end(id);
                        }
                        res.logInformation(prj, rCfg, debug);
                        Assert.assertTrue("Runtime configuration must have conflict", res.hasConflict());
                        assertFailureMessage(res, ppfe2);
                    }

                    if (AbstractTest.NUM_INSTANCE_REASONING > 0) {
                        System.out.println("Performing runtime reasoning/propagation with instance ...");
                        long instanceCreation = System.currentTimeMillis();
                        IReasonerInstance inst = ReasonerFrontend.getInstance().createInstance(prj, cfg, rCfg);
                        instanceCreation = System.currentTimeMillis() - instanceCreation;
                        for (int r = 1; r <= AbstractTest.NUM_INSTANCE_REASONING; r++) {
                            String id = mode.doMeasure() ? MeasurementCollector.start(cfg, "SCENARIO-INST ", r) : null;
                            ReasoningResult res = inst.propagate(ProgressObserver.NO_OBSERVER);
                            if (null != id) {
                                MeasurementCollector.endAuto(id);
                                net.ssehub.easy.reasoning.core.reasoner.AbstractTest.transferReasoningMeasures(
                                    MeasurementCollector.getInstance(), id, getMeasurements(), res);
                                MeasurementCollector.set(id, 
                                    AbstractTestDescriptor.MeasurementIdentifier.REASONER_INSTANCE_CREATION_TIME, 
                                    instanceCreation);
                                MeasurementCollector.end(id);
                            }
                            res.logInformation(prj, rCfg, debug);
                            Assert.assertTrue("Runtime configuration must have conflict", res.hasConflict());
                            assertFailureMessage(res, ppfe2);
                        }
                    }
                }
            } catch (ModelQueryException e) {
                e.printStackTrace();
            } catch (ValueDoesNotMatchTypeException e) {
                e.printStackTrace();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Asserts failure messages for each <code>vars</code>.
     * 
     * @param res the reasoning result
     * @param vars the variables that must cause conflicts
     */
    private static void assertFailureMessage(ReasoningResult res, AbstractVariable... vars) {
        Set<AbstractVariable> check = new HashSet<AbstractVariable>();
        for (AbstractVariable v : vars) {
            check.add(v);
        }
        for (int m = 0; m < res.getMessageCount(); m++) {
            Message msg = res.getMessage(m);
            for (Set<AbstractVariable> s : msg.getConstraintVariables()) {
                for (AbstractVariable v : s) {
                    check.remove(v);
                }
            }
        }
        Assert.assertTrue("No runtime failure found for " + check, check.isEmpty());
    }

}
