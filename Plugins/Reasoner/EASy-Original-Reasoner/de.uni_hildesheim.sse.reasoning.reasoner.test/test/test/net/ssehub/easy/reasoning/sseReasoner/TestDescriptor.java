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
package test.net.ssehub.easy.reasoning.sseReasoner;

import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTestDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.GeneralMeasures;
import net.ssehub.easy.reasoning.core.reasoner.IMeasurementKey;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;
import net.ssehub.easy.reasoning.sseReasoner.Descriptor;
import net.ssehub.easy.reasoning.sseReasoner.Measures;
import net.ssehub.easy.reasoning.sseReasoner.Reasoner;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector.IMeasurementIdentifier;

/**
 * The test descriptor for the SSE reasoner.
 * 
 * @author Holger Eichelberger
 */
public class TestDescriptor extends AbstractTestDescriptor {

    public static final ITestDescriptor INSTANCE = new TestDescriptor();
    private static final IMeasurementKey[] MEASUREMENTS = concat(Measures.values(), GeneralMeasures.values());
    private Reasoner reasoner = new Reasoner();

    /**
     * The specific measurement identifiers for the SSE reasoner.
     * 
     * @author Holger Eichelberger
     */
    public enum MeasurementIdentifier implements IMeasurementIdentifier {

        /**
         * Number of variables in constraints.
         */
        REASONER_VARIABLES_IN_CONSTRAINTS,

        /**
         * Number of constraints with evaluation problems.
         */
        REASONER_PROBLEM_CONSTRAINTS,

        /**
         * Number of constraints with assignment problems.
         */
        REASONER_PROBLEM_ASSIGNMENTS;

        @Override
        public boolean isAutomatic() {
            return false;
        }

    }
    
    /**
     * Creates a test descriptor.
     */
    private TestDescriptor() {
        super("net.ssehub.easy.reasoning.sseReasoner.tests", 
            null, 
            true, // CHECK
            false);
    }
    
    @Override
    public IReasoner createReasoner() {
        return new Reasoner();
    }

    @Override
    public void registerResoner() {
        ReasonerFrontend.getInstance().getRegistry().register(reasoner);
    }

    @Override
    public void unregisterReasoner() {
        ReasonerFrontend.getInstance().getRegistry().unregister(reasoner);
    }

    @Override
    public String getName() {
        return Descriptor.NAME;
    }

    @Override
    public String getVersion() {
        return Descriptor.VERSION;
    }

    /**
     * Registers the measurement mappings for the SSE reasoner.
     */
    public static void registerMeasurementMappings() {
        MeasurementCollector.registerMapping(Measures.VARIABLES_IN_CONSTRAINTS, 
            MeasurementIdentifier.REASONER_VARIABLES_IN_CONSTRAINTS);
        MeasurementCollector.registerMapping(Measures.PROBLEM_CONSTRAINTS, 
            MeasurementIdentifier.REASONER_PROBLEM_CONSTRAINTS);
        MeasurementCollector.registerMapping(Measures.PROBLEM_ASSIGNMENTS, 
            MeasurementIdentifier.REASONER_PROBLEM_ASSIGNMENTS);
    }
    
    /**
     * Automatically registers the measurement mappings.
     */
    static {
        registerMeasurementMappings();
    }

    @Override
    public IMeasurementKey[] measurements() {
        return MEASUREMENTS;    
    }

    @Override
    public String getMeasurementFileName() {
        return "measurements-sse.tsv";
    }

}
