/*
 * Copyright 2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.ant.versionReplacement;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

/**
 * This task will transform <tt>XML</tt> files, set the version numbers, and will save them as a
 * <tt>JAR</tt>. Please note that: <tt>example.xml</tt> will be saved as <tt>example.jar</tt> containing
 * a transformed <tt>feature.xml</tt>.
 * 
 * @author El-Sharkawy
 *
 */
public class FeatureVersionTask extends AbstractVersionReplacementTask {
    
    /**
     * Default constructor of this task.
     * Will only transform <tt>*.xml</tt> artifacts.
     */
    public FeatureVersionTask() {
        super("^.*xml$");
    }

    @Override
    // checkstyle: stop exception type check
    protected void transformArtifact(File artifact) throws Exception {
        String name = FilenameUtils.removeExtension(artifact.getName());
        VersionReplacer.createFeature(artifact, getVersion(), new File(getDestinationFolder(), name + ".jar"));
    }
    // checkstyle: resume exception type check
    
}
