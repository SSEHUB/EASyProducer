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
package net.ssehub.easy.standalone.cmd;

import java.io.File;

/**
 * Implements a name mapper for projects, in particular if the containing folder is not named
 * according to EASy conventions.
 * 
 * @author Holger Eichelberger
 */
public abstract class ProjectNameMapper {

    /**
     * The default name mapper assumes that the folder of the project corresponds
     * to the name of the product line (EASy conventions).
     */
    public static final ProjectNameMapper DEFAULT = new ProjectNameMapper() {
        
        @Override
        public String getName(File project) {
            return project.getName();
        }
    };
    
    private static ProjectNameMapper instance = DEFAULT;

    /**
     * Defines the mapper instance to be used.
     * 
     * @param mapper the mapper instance (<b>null</b> is ignored)
     */
    public static void setInstance(ProjectNameMapper mapper) {
        if (null != mapper) {
            instance = mapper;
        }
    }
    
    /**
     * Returns the actual instance.
     * 
     * @return the actual mapper instance
     */
    public static ProjectNameMapper getInstance() {
        return instance;
    }
    
    /**
     * Returns the name of the project.
     * 
     * @param project the project location
     * @return the name of the project
     */
    public abstract String getName(File project);

}
