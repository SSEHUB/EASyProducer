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
 * This task will transform a <tt>site.xml</tt>, set the version numbers, and will save it again as
 * <tt>site.xml</tt>.
 * 
 * @author El-Sharkawy
 *
 */
public class UpdateSiteTask extends AbstractVersionReplacementTask {

    /**
     * Default constructor of this task.
     * Will only transform <tt>site.xml</tt> artifacts.
     */
    public UpdateSiteTask() {
        super("^site.xml$");
    }
    
    @Override
    // checkstyle: stop exception type check
    protected void transformArtifact(File artifact) throws Exception {
        VersionReplacer.createUpdateSite(artifact, getVersion(), new File(getDestinationFolder(), "site.xml"));
    }
    // checkstyle: resume exception type check

}
