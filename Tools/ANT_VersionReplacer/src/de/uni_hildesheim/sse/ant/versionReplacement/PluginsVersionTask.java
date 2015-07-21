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

/**
 * 
 * This task will unzip existing plug-ins/fragments, set the version numbers, re-pack them
 * and will save them as a <tt>JAR</tt>.
 * 
 * @author El-Sharkawy
 *
 */
public class PluginsVersionTask extends AbstractVersionReplacementTask {
    private File tmpFolder;
    
    /**
     * Default constructor of this task.
     * Will only transform <tt>*.jar</tt> artifacts.
     */
    public PluginsVersionTask() {
        super("^.*jar$");
    }
    
    /**
     * Specification of a temporary folder where the plug-ins/fragments can be unpacked for transformation.
     * @param tempFolder An exsiting folder which can be used for transformation, must not be <tt>null</tt>.
     */
    public void setTempFolder(String tempFolder) {
        this.tmpFolder = new File(tempFolder);
    }

    @Override
    // checkstyle: stop exception type check
    protected void transformArtifact(File artifact) throws Exception {
        PluginVersionReplacer.updatePlugins(tmpFolder, artifact, getVersion(), getDestinationFolder());
    }
    // checkstyle: resume exception type check
}
