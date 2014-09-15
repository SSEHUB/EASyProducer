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
package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.utils.modelManagement.IModelListener;

/**
 * Defines a project listener in order to inform interested parties about
 * changes within a project instance. Currently, this class does only notify
 * about the internal replacement of an entire project instance as the editor
 * does not support incremental model updates. [retyping for convenience]
 * 
 * @author Holger Eichelberger
 */
public interface IProjectListener extends IModelListener<Project> {
    
}
