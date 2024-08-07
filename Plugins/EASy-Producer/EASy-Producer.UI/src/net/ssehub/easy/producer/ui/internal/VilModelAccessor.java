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
package net.ssehub.easy.producer.ui.internal;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.TopLevelModelAccessor.AbstractDefaultModelAccessor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.standard.EASyInitializer;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;

/**
 * Implements a model accessor for the top level IVML project.
 * 
 * @author Holger Eichelberger
 */
public class VilModelAccessor extends AbstractDefaultModelAccessor<Script> {

    public static final VilModelAccessor INSTANCE = new VilModelAccessor();
    public static final String EXTENSION = EASyInitializer.VIL_EXTENSION;
    
    /**
     * Prevents external creation (singleton).
     */
    private VilModelAccessor() {
    }
    
    @Override
    public ModelInfo<Script> getModelInfo(String projectName, Object project) {
        ModelInfo<Script> result = null;
        if (project instanceof ProductLineProject) {
            result = getModelManagement().availableModels().getModelInfo(
                ((ProductLineProject) project).getBuildScript());
        }
        return result;
    }

    @Override
    public ModelManagement<Script> getModelManagement() {
        return BuildModel.INSTANCE;
    }

    @Override
    public String getPathKindHint() {
        return PathKind.VIL.name();
    }

}
