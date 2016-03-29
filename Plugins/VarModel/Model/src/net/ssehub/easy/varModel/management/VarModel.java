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
package net.ssehub.easy.varModel.management;

import java.io.IOException;

import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.varModel.model.Project;

/**
 * The variability model, the central class holding all project instances and being
 * responsible for import resolution. Model loading is done by plugins of type 
 * {@link net.ssehub.easy.basics.modelManagement.IModelLoader}. Public access shall be 
 * synchronized (in any way) as multiple
 * source parts and tools may access the information concurrently. Please note that specific
 * information and settings are available via {@link #availableModels()}, {@link #comments()}, 
 * {@link #events()}, {@link #loaders()}, {@link #locale()} and {@link #locations()}.
 * The variability model needs a loader and a location to operate. After providing this 
 * information, available IVML projects can be accessed via {@link #availableModels()}.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class VarModel extends ModelManagement<Project> {
    
    // for optimizing speed we may consider letting the loaders store their individual part of the index 
    
    /**
     * Stores the singleton instance.
     */
    public static final VarModel INSTANCE = new VarModel();

    private ModelCommentsPersistencer comments;
        
    /**
     * Singleton.
     */
    private VarModel() {
        comments = new ModelCommentsPersistencer(repository());
    }

    /**
     * Provides access to the comments persistencer. For future compatibility, 
     * please store the returned instance just for temporary purposes within a method and 
     * not for long-term use in an attribute etc.
     * 
     * @return the events object
     */
    public ModelCommentsPersistencer comments() {
        return comments;
    }
    
    /**
     * Additional code to be executed after a model was loaded. 
     * 
     * @param info the information object describing the model
     * @throws IOException in case that loading fails - however, model loading will not fail
     */
    @Override
    protected void postLoadModel(ModelInfo<Project> info) throws IOException {
        comments.loadComments(info);
    }

    @Override
    protected ImportResolver<Project> createResolver() {
        return new DefaultImportResolver();
    }

}
