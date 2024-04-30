/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.ui.project_management;

import net.ssehub.easy.producer.eclipse.persistency.project_creation.IEASyProjectConfigurator;

/**
 * Wrapper to use Eclipse project "configurators" to configure EASy projects.
 * @author El-Sharkawy
 */
public abstract class AbstractProjectCreationDescriptor implements Comparable<AbstractProjectCreationDescriptor> {
    
    @Override
    public int compareTo(AbstractProjectCreationDescriptor other) {
        return Integer.compare(this.getPriority(), other.getPriority());
    }
    
    /**
     * The name of supported Eclipse projects.
     * @return The type of Eclipse projects, e.g., <code>Java Project</code>.
     */
    public abstract String getProjectType();
    
    /**
     * Factory: The configurator to configure the new EASy project.
     * @return The configurator to configure the new EASy project, if <code>null</code> an Eclipsem project without any
     * natures will be created.
     */
    public abstract IEASyProjectConfigurator getProjectConfigurator();
    
    /**
     * Used to sort the configurators.
     * @return The lower the number, the earlier the configurator is displayed.
     */
    public abstract int getPriority();

}
