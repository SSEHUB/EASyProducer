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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Used as part of {@link ProjectCopyVisitor} to store translated Objects.
 * @author El-Sharkawy
 *
 */
public class RewriteContext {
    
    private Map<Project, Project> translatedProjects;
    private Map<Class<?>, Set<ContainableModelElement>> removedElements;
    private boolean elementsWereRemoved;
    
    /**
     * Avoid instantiation from outside.
     */
    protected RewriteContext() {
        translatedProjects = new HashMap<Project, Project>();
        removedElements = new HashMap<Class<?>, Set<ContainableModelElement>>();
        elementsWereRemoved = false;
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
    
    /**
     * Stores the information that a model element was removed. Helpful for removing all instances pointing
     * to this variable.
     * @param removedElememt The removed element.
     */
    public void removeElement(ContainableModelElement removedElememt) {
        elementsWereRemoved = true;
        Class<?> modelElementType = removedElememt.getClass();
        Set<ContainableModelElement> removedElementList = removedElements.get(modelElementType);
        if (null == removedElementList) {
            removedElementList = new HashSet<ContainableModelElement>();
            removedElements.put(modelElementType, removedElementList);
        }
        removedElementList.add(removedElememt);
    }
    
    /**
     * Returns whether the given element was removed from the project.
     * @param elememt An element to test.
     * @return <tt>true</tt> if the element was removed, <tt>false</tt> if the element still exist.
     */
    public boolean elementWasRemoved(ContainableModelElement elememt) {
        Class<?> elementType = elememt.getClass();
        Set<ContainableModelElement> removedElementList = removedElements.get(elementType);
        return removedElementList != null && removedElementList.contains(elememt);
    }
    
    /**
     * Checks whether elements of the given {@link ContainableModelElement} was removed.
     * @param type A class, visited by {@link de.uni_hildesheim.sse.model.varModel.IModelVisitor}.
     * @return <tt>true</tt> if at least one element of this class was removed.
     */
    public boolean hasRemovedElementsOfType(Class<? extends ContainableModelElement> type) {
        Set<ContainableModelElement> removedElementList = removedElements.get(type);
        
        return null != removedElementList && !removedElementList.isEmpty();
    }
    
    /**
     * Returns whether elements were removed during the last iteration.
     * @return <tt>true</tt> if at least one element was removed, <tt>false</tt> otherwise.
     */
    public boolean elementesWereRemoved() {
        return elementsWereRemoved;
    }
    
    /**
     * Resets the internal <b>temporary</b> knowledge if the same projects should be filtered a second time.
     */
    void clear() {
        elementsWereRemoved = false;
    }
}
