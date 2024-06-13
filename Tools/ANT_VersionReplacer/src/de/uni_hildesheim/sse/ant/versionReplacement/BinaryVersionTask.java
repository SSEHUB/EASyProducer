/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * Replaces the version in a product specification (assuming for now that relevant features / bundles are
 * linked without version).
 * 
 * @author Holger Eichelberger
 */
public class BinaryVersionTask extends Task {

    private String version;
    private File sourceFolder;
    private File destinationFolder;
    private String prefix;

    /**
     * The version number to set.
     * @param version Should be in the following format:<br/>
     * <code>&lt;number&gt;'.'&lt;number&gt;['.'&lt;number&gt;]</code>
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
    /**
     * The version to set.
     * @return The version to set.
     */
    protected String getVersion() {
        return version;
    }
    
    /**
     * Defines the source folder where to take the binaries from.
     * 
     * @param folder the source folder
     */
    public void setSourceFolder(String folder) {
        this.sourceFolder = new File(folder);
    }

    /**
     * Defines the destination folder where to write to.
     * 
     * @param destinationFolder the destination folder
     */
    public void setDestinationFolder(String destinationFolder) {
        this.destinationFolder = new File(destinationFolder);
    }
    
    /**
     * Defines the prefix that files to be copied shall have.
     * 
     * @param prefix the prefix, may be <b>null</b> or empty
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    @Override
    public void execute() throws BuildException {
        if (null == version || version.isEmpty()) {
            throw new BuildException("No version specified.");
        }
        if (null == sourceFolder) {
            throw new BuildException("No source folder specified.");
        }
        if (!sourceFolder.exists()) {
            sourceFolder.mkdirs();
        }
        if (!sourceFolder.isDirectory()) {
            throw new BuildException("Source folder not is a directory.");
        }
        if (null == destinationFolder) {
            throw new BuildException("No destination folder specified.");
        }
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }
        if (!destinationFolder.isDirectory()) {
            throw new BuildException("Destination folder not is a directory.");
        }
        
        File[] files = sourceFolder.listFiles();
        for (File f : files) {
            String name = f.getName();
            boolean rename = true;
            if (null != prefix && prefix.length() > 0) {
                rename = name.startsWith(prefix);
            }
            if (rename) {
                int pos = name.lastIndexOf('_');
                name = name.substring(0, pos + 1) + version;
            }
            try {
                File target = new File(destinationFolder, name);
                FileUtils.copyFile(f, target);
                log("Copied to " + target);
            } catch (IOException e) {
                throw new BuildException(e);
            }

        }
    }

}
