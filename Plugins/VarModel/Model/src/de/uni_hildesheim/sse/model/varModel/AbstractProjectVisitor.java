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

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.model.varModel.filter.FilterType;

/**
 * Abstract super class for visiting projects.
 * This visitor can be controlled to specify whether project imports shall be visited or not.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractProjectVisitor implements IModelVisitor {
    /**
     * The project where the visiting has been started.
     */
    private Project originProject;
    
    /**
     * Specifies whether project imports shall be considered or not.
     */
    private FilterType filterType;
    
    private Set<Project> done = new HashSet<Project>();
    
    /**
     * Sole constructor for this visitor.
     * This constructor does not start the visiting process, the {@link Project#accept(IModelVisitor)} should be called
     * inside the constructor of the inherited visitors.
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    protected AbstractProjectVisitor(Project originProject, FilterType filterType) {
        this.originProject = originProject;
        this.filterType = filterType;
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        if (null != pImport.getResolved()) {
            pImport.getResolved().accept(this);
        }
    }
    
    @Override
    public void visitProject(Project project) {
        if (!done.contains(project)) {
            done.add(project);
            boolean importedProject = originProject != project;
            
            // Visit imports.
            if (FilterType.ALL == filterType || FilterType.ONLY_IMPORTS == filterType) {
                for (int i = 0; i < project.getImportsCount(); i++) {
                    project.getImport(i).accept(this);
                }
            }
            
            // Visit current project.
            boolean anyProject = FilterType.ALL == filterType;
            boolean onlyImports = FilterType.ONLY_IMPORTS == filterType && importedProject;
            boolean noImports = FilterType.NO_IMPORTS == filterType && !importedProject;
            if (anyProject || onlyImports || noImports) {
                for (int i = 0; i < project.getElementCount(); i++) {
                    project.getElement(i).accept(this);
                }
            }
        }
    }
    
    /**
     * Returns the original project which was the starting point for visitation.
     * @return The starting point of the visitation.
     */
    protected Project getStartingProject() {
        return originProject;
    }
    
    /**
     * Resets the knowledge if a this visitor should be used for a second iteration.
     * @param originProject The starting project, should be the project from the constructor call.
     */
    protected void clear(Project originProject) {
        done.clear();
        // Reset original project only if explicitly specified.
        if (null != originProject) {
            this.originProject = originProject;
        }
    }
}
