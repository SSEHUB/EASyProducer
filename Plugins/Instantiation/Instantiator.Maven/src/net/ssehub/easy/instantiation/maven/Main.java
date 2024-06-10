/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;

/**
 * Just for a quick test of the included libraries. So far, there are no unit tests for this instantiator.
 * 
 * @author Holger Eichelberger
 */
public class Main {
    
    /**
     * Main program, tries to run the maven instantiator without effects.
     * 
     * @param args ignored
     */
    public static void main(String[] args) throws VilException {
        TracerFactory.setInstance(ConsoleTracerFactory.INSTANCE);
        File base = new File(".");
        ArtifactModel model = ArtifactFactory.createArtifactModel(base);
        Path root = Path.createInstance(new File("./pom.xml"), model);
        List<String> mvnArgs = new ArrayList<>();
        mvnArgs.add("--version");
        Sequence<String> vilMvnArgs = new ListSequence<>(mvnArgs, String.class);
        Maven.maven(root, vilMvnArgs, false);
    }

}
