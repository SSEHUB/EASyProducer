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
package standaloneTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import de.uni_hildesheim.sse.easy.loader.ListLoader;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Runs EASy standalone.
 * 
 * @author Holger Eichelberger
 */
public class Test {
    
    /**
     * The main method.
     * 
     * @param args ignored
     * @throws IOException if reading models fails
     * @throws ModelManagementException if configuring the model management fails
     */
    public static void main(String[] args) throws IOException, ModelManagementException {
        final File modelFolder = new File("../model");
        ListLoader loader = new ListLoader();
        loader.setVerbose(true);
        System.out.println("EASy starting");
        loader.startup();
        System.out.println("EASy started");
        VarModel.INSTANCE.locations().addLocation(modelFolder, ProgressObserver.NO_OBSERVER);
        System.out.println("Location added");
        List<ModelInfo<Project>> models = VarModel.INSTANCE.availableModels().getModelInfo("simple");
        System.out.println("Models: " + models);
        if (!models.isEmpty()) {
            ModelInfo<Project> info = models.get(0);
            try {
                Project prj = VarModel.INSTANCE.load(info);
                System.out.println(StringProvider.toIvmlString(prj));
            } catch (ModelManagementException e) {
                System.out.println("CANNOT READ " + info.getName() + ": " + e.getMessage());
            }
        }
        // perform model operations
        System.out.println("Removing location");
        VarModel.INSTANCE.locations().removeLocation(modelFolder, ProgressObserver.NO_OBSERVER);
        System.out.println("EASy stopping");
        loader.shutdown();
        System.out.println("EASy stopped");
    }

}
