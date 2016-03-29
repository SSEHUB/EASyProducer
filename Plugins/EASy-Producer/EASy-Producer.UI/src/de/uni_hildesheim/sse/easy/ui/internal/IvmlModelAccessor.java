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
package de.uni_hildesheim.sse.easy.ui.internal;

import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.EASyInitializer;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.TopLevelModelAccessor.AbstractDefaultModelAccessor;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Implements a model accessor for the top level IVML project.
 * 
 * @author Holger Eichelberger
 */
public class IvmlModelAccessor extends AbstractDefaultModelAccessor<Project> {

    public static final IvmlModelAccessor INSTANCE = new IvmlModelAccessor();
    public static final String EXTENSION = EASyInitializer.IVML_EXTENSION;
    
    /**
     * Prevents external creation (singleton).
     */
    private IvmlModelAccessor() {
    }
    
    @Override
    public ModelInfo<Project> getModelInfo(String projectName, Object project) {
        ModelInfo<Project> result = null;
        if (project instanceof ProductLineProject) {
            result = VarModel.INSTANCE.availableModels().getModelInfo(((ProductLineProject) project).getProject());
        }
        return result;
    }

    @Override
    public ModelManagement<Project> getModelManagement() {
        return VarModel.INSTANCE;
    }

    @Override
    public String getPathKindHint() {
        return PathKind.IVML.name();
    }

}
