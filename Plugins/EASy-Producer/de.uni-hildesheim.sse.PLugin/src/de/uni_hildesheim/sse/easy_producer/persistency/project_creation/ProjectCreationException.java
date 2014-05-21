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
package de.uni_hildesheim.sse.easy_producer.persistency.project_creation;

/**
 * Exception if a project should be created, but could not be created.
 * @author El-Sharkawy
 *
 */
@SuppressWarnings("serial")
public class ProjectCreationException extends Exception {
    private ValidProjectNameType reason;
    
    /**
     * Sole constructor for this class.
     * @param reason The reason, why the project could not be created.
     */
    public ProjectCreationException(ValidProjectNameType reason) {
        this.reason = reason;
    }
    
    /**
     * Returns the reason, why the project could not be created.
     * @return A {@link ValidProjectNameType} describing the occurred reasonung, why the project could not be created.
     */
    public ValidProjectNameType getReason() {
        return reason;
    }
}
