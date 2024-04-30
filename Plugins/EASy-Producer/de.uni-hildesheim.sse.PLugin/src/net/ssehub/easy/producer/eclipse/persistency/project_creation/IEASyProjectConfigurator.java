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
package net.ssehub.easy.producer.eclipse.persistency.project_creation;

import org.eclipse.core.resources.IProject;


/**
 * Configurator for configuring newly created EASy projects.
 * These Configurators should set {@link IProject} settings of Eclipse, like
 * <ul>
 * <li>Natures</li>
 * <li>Classpath Entries</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public interface IEASyProjectConfigurator {

    /**
     * Configures the given {@link IProject}.
     * @param project The project to configure. Should be a new created project, must not be <code>null</code>.
     */
    public void configure(IProject project);
    
    /**
     * Configures the given {@link IProject}, while deriving a new product line member project.
     * @param project The project to configure. Should be a new created project, must not be <code>null</code>.
     * @param parentProject The project from which <code>project</code> was derived. This should be used as a template.
     */
    public void configure(IProject project, IProject parentProject);
}
