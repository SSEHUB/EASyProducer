/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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

package net.ssehub.easy.instantiation.json;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.DefaultFileArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Defines the default file artifact creator.
 * 
 * @author Eichelberger
 */
public class JsonArtifactCreator extends DefaultFileArtifactCreator {
    
    @Override
    protected boolean handlesFileImpl(File file) {
        return checkSuffix(file, ".json");
    }

    @Override
    public FileArtifact createArtifactInstance(Object real, ArtifactModel model) throws VilException {
        return new JsonFileArtifact((File) real, model);
    }
    
    @Override
    public java.lang.Class<? extends IArtifact> getArtifactClass() {
        return JsonFileArtifact.class;
    }
    
}
