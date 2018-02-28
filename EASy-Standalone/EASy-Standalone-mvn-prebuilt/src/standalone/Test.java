/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package standalone;

import java.io.File;
import java.io.IOException;
import java.util.List;

import de.uni_hildesheim.sse.easy.loader.ListLoader;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Runs EASy standalone. No asserts in here, use {@link TestFailedException} which is turned by a jUnit
 * Test into assertion fails.
 * 
 * @author Holger Eichelberger
 */
public class Test {
    
    /**
     * The main method. Also re-used for the tests.
     * 
     * @param args may contain the test model location as first argument, else ignored
     * @throws IOException if reading models fails
     * @throws ModelManagementException if configuring the model management fails
     * @throws TestFailedException in case that an explicit test failed
     */
    public static void main(String[] args) throws IOException, ModelManagementException, TestFailedException {
        File modelFolder;
        if (null != args && 1 == args.length && null != args[0]) {
            modelFolder = new File(args[0]);
        } else {
            modelFolder = new File("../model");
        }
        ListLoader loader = new ListLoader();
        loader.setVerbose(true);
        System.out.println("EASy starting");
        loader.startup();
        System.out.println("EASy started");
        assertSetup();
        ReasonerFrontend.getInstance().setPreferredReasoner();
        VarModel.INSTANCE.locations().addLocation(modelFolder, ProgressObserver.NO_OBSERVER);
        BuildModel.INSTANCE.locations().addLocation(modelFolder, ProgressObserver.NO_OBSERVER);
        TemplateModel.INSTANCE.locations().addLocation(modelFolder, ProgressObserver.NO_OBSERVER);
        System.out.println("Locations added");
        List<ModelInfo<Project>> models = VarModel.INSTANCE.availableModels().getModelInfo("simple");
        System.out.println("Models: " + models);
        if (null != models && !models.isEmpty()) {
            ModelInfo<Project> info = models.get(0);
            try {
                Project prj = VarModel.INSTANCE.load(info);
                testModel(prj);
            } catch (ModelManagementException e) {
                new TestFailedException("Cannot read model " + info.getName() + ": " + e.getMessage());
            }
            // do reasoning
        } else {
            throw new TestFailedException("No models found!");
        }
        // perform model operations
        System.out.println("Removing locations");
        TemplateModel.INSTANCE.locations().removeLocation(modelFolder, ProgressObserver.NO_OBSERVER);
        BuildModel.INSTANCE.locations().removeLocation(modelFolder, ProgressObserver.NO_OBSERVER);
        VarModel.INSTANCE.locations().removeLocation(modelFolder, ProgressObserver.NO_OBSERVER);
        System.out.println("EASy stopping");
        loader.shutdown();
        System.out.println("EASy stopped");
    }
    
    /**
     * Asserts the setup after starting EASy standalone.
     * 
     * @throws TestFailedException in case that the setup failed
     */
    private static void assertSetup() throws TestFailedException {
        if (0 == ReasonerFrontend.getInstance().getReasonersCount()) {
            throw new TestFailedException("No reasoners registered!");
        }
    }
    
    /**
     * Tests the model in <code>project</code>.
     * 
     * @param project the project to test
     * @throws TestFailedException in case that the setup failed
     */
    private static void testModel(Project project) throws TestFailedException {
        ReasonerConfiguration rCfg = new ReasonerConfiguration();
        rCfg.setTimeout(2000);
        ReasonerFrontend rFront = ReasonerFrontend.getInstance();
        System.out.println(StringProvider.toIvmlString(project));
        Configuration cfg = new Configuration(project);
        System.out.println("Configuration created");
        ReasoningResult rResult = rFront.propagate(project, cfg, rCfg, ProgressObserver.NO_OBSERVER);
        if (rResult.hasConflict()) {
            throw new TestFailedException("Reasoning failed");
        }
        System.out.println("Reasoning done");
        // TODO VIL
        // TODO by reflection, rt-VIL
    }
    
}
