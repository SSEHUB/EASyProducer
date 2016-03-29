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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Used as part of {@link ProjectRewriteVisitor} to store translated Objects.
 * @author El-Sharkawy
 *
 */
public class RewriteContext {
    
    /**
     * Tuple (oldProject, replacement).
     */
    private Map<Project, Project> translatedProjects;
    
    /**
     * Inverse mapping to {@link #translatedProjects}.
     * Tuple (replacement, oldProject).
     */
    private Map<Project, Project> translatedProjectsInverse;
    
    /**
     * Set of identifiers (name + version) of projects which will be kept. Needed for removal of elements, which belong
     * to a removed import. A string is used instead of projects to simplify comparison if references change...
     */
    private Set<String> projectQualifier;
    private Map<Class<?>, Set<ContainableModelElement>> removedElements;
    /**
     * Elements of a removed import. As long as it is unclear whether another project is till importing this project,
     * the elements cannot be removed. At the end of visitation, this map can be used to cleanup the main project.
     */
    private Map<String, List<ContainableModelElement>> elementsOfRemovedImports;
    private boolean elementsWereRemoved;
    private VariableLookUpTable variablesTable;
    
    /**
     * Avoid instantiation from outside.
     */
    protected RewriteContext() {
        translatedProjects = new HashMap<Project, Project>();
        translatedProjectsInverse = new HashMap<Project, Project>();
        removedElements = new HashMap<Class<?>, Set<ContainableModelElement>>();
        elementsOfRemovedImports = new HashMap<String, List<ContainableModelElement>>();
        projectQualifier = new HashSet<String>();
        elementsWereRemoved = false;
        variablesTable = new VariableLookUpTable();
    }
    
    /**
     * Getter for the {@link VariableLookUpTable}, for initialization inside the visitor.
     * @return The (empty) {@link VariableLookUpTable}.
     */
    VariableLookUpTable getLookUpTable() {
        return variablesTable;
    }

    /**
     * Stores a translated equivalent of the given Project.
     * @param oldProject A project which is currently be translated.
     * @param translatedProject The translated copy of the first parameter.
     */
    void storeTranslatedProject(Project oldProject, Project translatedProject) {
        // Project will be translated -> it will be kept
        String qName = generateQualifiedName(oldProject);
        projectQualifier.add(qName);
        
        // Consider multiple runs of the rewriter in this case the old project may already be an replacement for
        // another oldProject -> sore also this change.
        Project preOldProject = translatedProjectsInverse.get(oldProject);
        while (null != preOldProject) {
            translatedProjects.put(preOldProject, translatedProject);
            preOldProject = translatedProjectsInverse.get(preOldProject);
        }
        
        // Store relation between original and copy
        translatedProjects.put(oldProject, translatedProject);
        // Also store reference to itself (if already translated project is returned somewhere).
        translatedProjects.put(translatedProject, translatedProject);
        // Create history for old projects (needed for the loop above)
        translatedProjectsInverse.put(translatedProject, oldProject);
    }

    /**
     * Returns the qualified name of a project as unique identifier for comparison whether the project was deleted.
     * @param project The project for which the qualified name shall be generated.
     * @return projectName[+Version].
     */
    private String generateQualifiedName(Project project) {
        Version v = project.getVersion();
        return (null == v) ? project.getName() : project.getName() + "+" + v.getVersion();
    }
    
    /**
     * Returns the translated equivalent for the given project. If the given project is already a translated copy,
     * the same reference will be returned.
     * @param originalProject A project of the current translation process, maybe already translated.
     * @return The translated equivalent of the current Translation process, maybe <tt>null</tt> in case of errors.
     */
    public Project getTranslatedProject(Project originalProject) {
        Project newParent = translatedProjects.get(originalProject);
        if (null == newParent) {
            newParent = originalProject;
        }
        return newParent;
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
     * @param type A class, visited by {@link net.ssehub.easy.varModel.model.IModelVisitor}.
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
        elementsOfRemovedImports.clear();
    }
    
    /**
     * Resets the internal <b>temporary</b> knowledge if anew project should be filtered based on the knowledge of a
     * previous filtering.
     */
    void newRun() {
        clear();
        elementsWereRemoved = true;
    }
    
    /**
     * Tests whether the project is still part of the main project (via an import).
     * @param project The project to test
     * @return <tt>true</tt>project is still part of the main project, <b><tt>false</tt></b> it is unclear.
     */
    public boolean projectWasNotRemoved(Project project) {
        String qName = generateQualifiedName(project);
        return projectQualifier.contains(qName);
    }
    
    /**
     * Marks an element of an imported project for removal if the related
     * {@link net.ssehub.easy.varModel.model.ProjectImport} was deleted.
     * @param declaringProject The project were the element was created.
     * @param nestedElement The element itself.
     */
    void markForImportRemoval(Project declaringProject, ContainableModelElement nestedElement) {
        String qName = generateQualifiedName(declaringProject);
        List<ContainableModelElement> elementsOfProject = elementsOfRemovedImports.get(qName);
        if (null == elementsOfProject) {
            elementsOfProject = new ArrayList<ContainableModelElement>();
            elementsOfRemovedImports.put(qName, elementsOfProject);
        }
        elementsOfProject.add(nestedElement);
    }
    
    /**
     * Removes elements of removed {@link net.ssehub.easy.varModel.model.ProjectImport},
     * must be called after the {@link ProjectRewriteVisitor} is finished with a complete visitation iteration
     * and before {@link #clear()}.
     */
    void removeElementsOfRemovedImports() {
        for (String qName : elementsOfRemovedImports.keySet()) {
            List<ContainableModelElement> elementsOfProject = elementsOfRemovedImports.get(qName);
            // Import was removed, if qualifier is not registered after complete visitation
            if (!projectQualifier.contains(qName) && null != elementsOfProject) {
                for (int i = 0, n = elementsOfProject.size(); i < n; i++) {
                    removeElement(elementsOfProject.get(i));
                }
            }
        }
    }
    
    /**
     * Returns the set of instances of the given {@link IDatatype}.
     * @param config The configuration which is used to retrieve all {@link IDecisionVariable}s.
     * @param type The <b>exact</b> {@link IDatatype} for which the instances shall be returned,
     * will <b>not</b> consider {@link IDatatype#isAssignableFrom(IDatatype)}.
     * @return The instances for the given type or <tt>null</tt> if no instances exist.
     */
    public Set<IDecisionVariable> getInstancesForType(Configuration config, IDatatype type) {
        return variablesTable.getInstancesForType(type);
    }
    
    /**
     * Returns the set of instances of the given {@link AbstractVariable} declaration.
     * @param config The configuration which is used to retrieve all {@link IDecisionVariable}s.
     * @param declaration The declaration for which the instances shall be returned.
     * If the declaration is nested inside a compound which was multiple times instantiated, this single declaration
     * could return multiple {@link IDecisionVariable}s.
     * @return The instances for the given declaration or <tt>null</tt> if no instances exist.
     */
    public Set<IDecisionVariable> getInstancesForDeclaration(Configuration config, AbstractVariable declaration) {
        return variablesTable.getInstancesForDeclaration(declaration);
    }
    
    /**
     * Checks whether the declaration is known or whether the declaration is a local declaration used as
     * an iterator of a constraint.
     * Needs that the internal {@link VariableLookUpTable} was already initialized with a {@link Configuration}.
     * @param declaration The declaration to check.
     * @return <tt>true</tt> if the declaration is used for a {@link IDecisionVariable} of the configuration or
     * if the internal table was not initialized with a {@link Configuration}, <tt>false</tt> otherwise.
     */
    boolean declarationKnown(AbstractVariable declaration) {
        return variablesTable.declarationKnown(declaration);
    }
}
