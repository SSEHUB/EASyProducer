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

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * Abstract task for exchanging the version numbers of all (Eclipse-) artifacts in a folder.
 * @author El-Sharkawy
 *
 */
abstract class AbstractVersionReplacementTask extends Task {
    
    private File sourceFolder;
    private String version;
    private File destinationFodler;
    private String inclusionPattern;
    private String exclusionPattern;
    
    /**
     * Sole constructor for this task.
     * @param inclusionPattern Optional parameter to specify which kind of files shall be transformed.
     * If <tt>null</tt> all files in the given folder will be transformed.
     */
    protected AbstractVersionReplacementTask(String inclusionPattern) {
        this.inclusionPattern = inclusionPattern;
    }
    
    /**
     * The version number to set.
     * @param version Should be in the following format:<br/>
     * <tt>&lt;number&gt;'.'&lt;number&gt;['.'&lt;number&gt;]</tt>
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * A folder containing artifacts to transform. Will not consider sub folders.
     * @param sourceFolder A folder containing the source artifacts for transformation.
     */
    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = new File(sourceFolder);
    }
    
    /**
     * The target folder where the transformed artifacts hall be stored.
     * @param destinationFolder The folder must exist (must not be <tt>null</tt>).
     */
    public void setDestinationFolder(String destinationFolder) {
        this.destinationFodler = new File(destinationFolder);
    }
    
    /**
     * An optional file name pattern for artifacts in {@link #setSourceFolder(String)}, which shall not be considered.
     * @param exclusionPattern For instance:<br/>
     * <tt>^.*(test|tests).jar$</tt><br/>
     * to avoid consideration of test artifacts.
     */
    public void setExclusionPattern(String exclusionPattern) {
        this.exclusionPattern = exclusionPattern;
    }

    /**
     * Returns the source folder containing the artifacts for transformation.
     * @return The source location.
     */
    protected File getSourceFolder() {
        return sourceFolder;
    }

    /**
     * The version to set.
     * @return The version to set.
     */
    protected String getVersion() {
        return version;
    }

    /**
     * Returns the target location where the transformed artifacts shall be saved to.
     * @return The target location
     */
    protected File getDestinationFolder() {
        return destinationFodler;
    }

    @Override
    public void execute() throws BuildException {
        if (null == sourceFolder) {
            throw new BuildException("No source folder specified.");
        }
        if (!sourceFolder.exists() || !sourceFolder.isDirectory()) {
            throw new BuildException("Source folder does not exist: " + sourceFolder.getAbsolutePath());
        }
        if (null == destinationFodler) {
            throw new BuildException("No destination folder specified.");
        }
        if (!destinationFodler.exists() || !destinationFodler.isDirectory()) {
            throw new BuildException("Destination folder does not exist: " + destinationFodler.getAbsolutePath());
        }
        if (null == version || version.isEmpty()) {
            throw new BuildException("No version specified.");
        }
        if (null != sourceFolder && sourceFolder.isDirectory()) {
            File[] nestedElements = sourceFolder.listFiles();
            if (null != nestedElements) {
                for (int i = 0; i < nestedElements.length; i++) {
                    File artifact = nestedElements[i];
                    if (includeArtifact(artifact.getName()) && !excludeArtifact(artifact.getName())) {
                        try {
                            transformArtifact(nestedElements[i]);
                        // checkstyle: stop exception type check
                        } catch (Exception exc) {
                            exc.printStackTrace();
                            throw new BuildException(exc);
                        }
                        // checkstyle: resume exception type check
                    }
                }
            }
        }
    }
    
    /**
     * Checks whether an artifact of {@link #getSourceFolder()} should be considered.
     * @param artifactName The name of the artifact.
     * @return <tt>true</tt> if the artifact should be transformed (no inclusion pattern or name matches inclusion
     * pattern), <tt>false</tt> otherwise.
     */
    private boolean includeArtifact(String artifactName) {
        return !(null != inclusionPattern && !artifactName.matches(inclusionPattern));
    }
    
    /**
     * Checks whether an artifact of {@link #getSourceFolder()} should <b>not</b> be considered.
     * @param artifactName The name of the artifact.
     * @return <tt>true</tt> if the artifact should <b>not</b> be transformed (artifact name matches exclusion
     * pattern), <tt>false</tt> otherwise.
     */
    private boolean excludeArtifact(String artifactName) {
        return null != exclusionPattern && artifactName.matches(exclusionPattern);
    }
    
    /**
     * This method should transform one artifact of {@link #getSourceFolder()}.
     * @param artifact The artifact to transform, should not be <tt>null</tt>.
     * @throws Exception Maybe thrown in any case of an error which stops the transformation.
     */
    // checkstyle: stop exception type check
    protected abstract void transformArtifact(File artifact) throws Exception;
    // checkstyle: resume exception type check
}
