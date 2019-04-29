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
package net.ssehub.easy.reasoning.drools2;

import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTestDescriptor;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * The test descriptor for this reasoner.
 * 
 * @author Holger Eichelberger
 */
public class TestDescriptor extends AbstractTestDescriptor {

    public static final ITestDescriptor INSTANCE = new TestDescriptor();
    private DroolsReasoner reasoner = new DroolsReasoner();

    /**
     * Creates a test descriptor.
     */
    private TestDescriptor() {
        super("net.ssehub.easy.reasoning.drools2.tests", 
            null, 
            true, // CHECK
            false);
    }
    
    @Override
    public IReasoner createReasoner() {
        return new DroolsReasoner();
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
        return DroolsReasonerDescriptor.NAME;
    }

    @Override
    public String getVersion() {
        return DroolsReasonerDescriptor.VERSION;
    }

    @Override
    public String getMeasurementFileName() {
        return "measurements-drools2.tsv";
    }

}
