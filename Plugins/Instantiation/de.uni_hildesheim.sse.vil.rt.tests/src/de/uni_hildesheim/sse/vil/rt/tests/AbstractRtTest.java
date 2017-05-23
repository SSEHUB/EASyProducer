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
package de.uni_hildesheim.sse.vil.rt.tests;

import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;

import java.util.List;

import org.junit.Assert;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IVariableFilter;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
//import net.ssehub.easy.reasoning.sseReasoner.Reasoner;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * An abstract basic rt-VIL test.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractRtTest extends AbstractExecutionTest<Script> {

    private static boolean reasonerRegistered = false;
    
    /**
     * Registers the reasoner but only once per VM test execution.
     */
    protected static void registerReasoner() {
  /*      if (!reasonerRegistered) {
            ReasonerFrontend fe = ReasonerFrontend.getInstance();
            Reasoner reasoner = new Reasoner();
            fe.getRegistry().register(reasoner);
            // set the preferred reasoner, in particular for plugin-based tests as then also older reasoners
            // may be available
            fe.setReasonerHint(reasoner.getDescriptor());
            reasonerRegistered = true;
        }*/
    }
    
    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new RtVilTestConfigurer();
    }

    /**
     * Returns the default configuration for the given variability model.
     * 
     * @param varModelName the name of the variability model
     * @param filter the variable filter to apply (use 
     *   {@link net.ssehub.easy.instantiation.core.model.vilTypes.configuration.NoVariableFilter#INSTANCE}
     *   for runtime)
     * @return the default configuration
     */
    protected static Configuration getIvmlConfiguration(String varModelName, IVariableFilter filter) {
        List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo(varModelName);
        Assert.assertNotNull("IVML model '" + varModelName + "' not found", infos);
        Assert.assertEquals("IVML model '" + varModelName + "' ambiguous (" + infos.size() + "models found)", 
            1, infos.size());
        ModelInfo<Project> info = infos.get(0);
        Project varModel = null;
        try {
            varModel = VarModel.INSTANCE.load(info);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        Assert.assertNotNull("IVML model '" + varModelName + "' not loaded", varModel);
        net.ssehub.easy.varModel.confModel.Configuration cfg 
            = new net.ssehub.easy.varModel.confModel.Configuration(varModel);
        return new Configuration(cfg , filter);
    }

}
