/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.core.varMod.container;

/**
 * Data class for describing semantic errors occurred during parsing a Model file.
 * @author El-Sharkawy
 *
 */
public class SemanticErrorDescription {

    private String location;
    private String description;
    
    /**
     * Sole constructor for this class.
     * @param location The location of the parsed file (could be a URI or a path in the file system).
     * @param description Description of the error occurred during parsing.
     */
    public SemanticErrorDescription(String location, String description) {
        this.location = location;
        this.description = description;
    }
    
    /**
     * Getter for the location of the file.
     * @return The location of the parsed/loaded file.
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * Getter for the error description.
     * @return A message describing the parser error. 
     */
    public String getDescription() {
        return description;
    }
}
