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
package de.uni_hildesheim.sse.model.varModel.rewrite;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Used as part of {@link ProjectCopyVisitor} to store translated Objects.
 * @author El-Sharkawy
 *
 */
public class RewriteContext {
    
    private Map<Project, Project> translatedProjects;
    
    /**
     * Avoid instantiation from outside.
     */
    protected RewriteContext() {
        translatedProjects = new HashMap<Project, Project>();
    }

    /**
     * Stores a translated equivalent of the given Project.
     * @param oldProject A project which is currently be translated.
     * @param translatedProject The translated copy of the first parameter.
     */
    void storeTranslatedProject(Project oldProject, Project translatedProject) {
        translatedProjects.put(oldProject, translatedProject);
        // Also store reference to itself (if already translated project is returned somewhere.
        translatedProjects.put(translatedProject, translatedProject);
    }
    
    /**
     * Returns the translated equivalent for the given project. If the given project is already a translated copy,
     * the same reference will be returned.
     * @param originalProject A project of the current translation process, maybe already translated.
     * @return The translated equivalent of the current Translation process, maybe <tt>null</tt> in case of errors.
     */
    public Project getTranslatedProject(Project originalProject) {
        return translatedProjects.get(originalProject);
    }
}
