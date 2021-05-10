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
package net.ssehub.easy.standalone.ant;

import java.io.File;

import org.apache.tools.ant.Task;

public abstract class AbstractEASyTask extends Task  {

    private File source;
    private File target;
    private String projectName;

    /**
     * Defines the source folder.
     * 
     * @param source the source folder
     */
    public void setSource(File source) {
        this.source = source;
    }
    
    /**
     * Defines the target folder.
     * 
     * @param target the target folder
     */
    public void setTarget(File target) {
        this.target = target;
    }
    
    /**
     * Returns the project name. Typically EASy assumes the name of the folder
     * to be the name of the project. However, this is not always the case.
     * 
     * @param projectName the project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Defines the optional installation location of Maven.
     * 
     * @param mavenHome as absolute path
     */
    public void setMavenHome(String mavenHome) {
        if (mavenHome.length() > 0) {
            System.setProperty("easy.maven.home", mavenHome);
        }
    }

    /**
     * Returns the source folder.
     * 
     * @return the source folder
     */
    public File getSource() {
        return source;
    }

    /**
     * Retruns the target folder.
     * 
     * @return the target folder
     */
    public File getTarget() {
        return target;
    }

    /**
     * Returns the project name.
     * 
     * @return the project name
     */
    public String getProjectName() {
        return projectName;
    }

}
