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

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Factory for {@link ModelContainer}s.
 * @author El-Sharkawy
 *
 */
public class ModelContainerFactory {

    /**
     * Creates a {@link ModelContainer} for a successfully loaded {@link IModel}.
     * @param model The loaded model, either one of {@link Project} or {@link Script}.
     * @param location The location from the model.
     * @return The {@link ModelContainer} or <tt>null</tt> not one of {@link Project} or {@link Script} was passed
     *     as a model.
     */
    public static ModelContainer<?> createContainer(IModel model, Configuration location) {
        
        ModelContainer<?> result = null;
        if (model instanceof Project) {
            Project project = (Project) model;
            result = new ProjectContainer(project, location);
        } else if (model instanceof Script) {
            Script script = (Script) model;
            result = new ScriptContainer(script, location);
        }
        
        return result;
    }
    
    /**
     * Creates a {@link ModelContainer} for a loaded {@link IModel}, which contain {@link SemanticErrorDescription}s.
     * @param model The loaded model, either one of {@link Project} or {@link Script}.
     * @param description description A description of an occurred semantic error while parsing the {@link IModel}.
     *     Can be <tt>null</tt>, then this constructor has the same behavior as
     *     {@link ModelContainerFactory#createContainer(IModel, Configuration)}.
     * @param location The location from the model.
     * @return The {@link ModelContainer} or <tt>null</tt> not one of {@link Project} or {@link Script} was passed
     *     as a model.
     */
    public static ModelContainer<?> createContainer(IModel model, SemanticErrorDescription description,
        Configuration location) {
        
        ModelContainer<?> result = null;
        if (model instanceof Project) {
            Project project = (Project) model;
            result = new ProjectContainer(project, description, location);
        } else if (model instanceof Script) {
            Script script = (Script) model;
            result = new ScriptContainer(script, description, location);
        }
        
        return result;
    }
}
