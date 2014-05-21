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

import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Creates a new EASy project.
 * @author El-Sharkawy
 *
 */
class NewProjectCreator extends AbstractProjectCreator {
    
    /**
     * Sole constructor for creating a new EASy project, without a predecessor.
     * @param projectName The name of the new project (should already be checked, whether the name is valid).
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before.
     * @param configurators Optional list of configurators to configure the newly created project, maybe <tt>null</tt>.
     *     The configurators whill be applied in the ordering of the array.
     */
    NewProjectCreator(String projectName, boolean lazy, IEASyProjectConfigurator... configurators) {
        super(projectName, lazy, configurators);
    }
    
    /**
     * Creates a new {@link ProductLineProject} without any predecessors.
     * @return The newly created {@link ProductLineProject}.
     */
    @Override
    ProductLineProject createEASyProject() {
        super.createProject();
        super.setPersistenceProperties();
        return super.getCreatedProject();
    }

}
