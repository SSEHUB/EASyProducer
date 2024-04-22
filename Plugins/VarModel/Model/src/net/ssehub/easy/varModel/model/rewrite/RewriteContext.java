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
     * Returns the qualified name of a project as unique identifier for comparison whether the project was deleted.
     * @param project The project for which the qualified name shall be generated.
     * @return projectName[+Version].
     */
    private String generateQualifiedName(Project project) {
        Version v = project.getVersion();
        return (null == v) ? project.getName() : project.getName() + "+" + v.getVersion();
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
     * @return {@code true} if the element was removed, {@code false} if the element still exist.
     */
    public boolean elementWasRemoved(ContainableModelElement elememt) {
        Class<?> elementType = elememt.getClass();
        Set<ContainableModelElement> removedElementList = removedElements.get(elementType);
        return removedElementList != null && removedElementList.contains(elememt);
    }
    
    /**
     * Checks whether elements of the given {@link ContainableModelElement} was removed.
     * @param type A class, visited by {@link net.ssehub.easy.varModel.model.IModelVisitor}.
     * @return {@code true} if at least one element of this class was removed.
     */
    public boolean hasRemovedElementsOfType(Class<? extends ContainableModelElement> type) {
        Set<ContainableModelElement> removedElementList = removedElements.get(type);
        
        return null != removedElementList && !removedElementList.isEmpty();
    }
    
    /**
     * Returns whether elements were removed during the last iteration.
     * @return {@code true} if at least one element was removed, {@code false} otherwise.
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
     * @return {@code true}project is still part of the main project, <b>{@code false}</b> it is unclear.
     */
    public boolean projectIsStillPresent(Project project) {
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
     * @return The instances for the given type or <b>null</b> if no instances exist.
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
     * @return The instances for the given declaration or <b>null</b> if no instances exist.
     */
    public Set<IDecisionVariable> getInstancesForDeclaration(Configuration config, AbstractVariable declaration) {
        return variablesTable.getInstancesForDeclaration(declaration);
    }
    
    /**
     * Checks whether the declaration is known or whether the declaration is a local declaration used as
     * an iterator of a constraint.
     * Needs that the internal {@link VariableLookUpTable} was already initialized with a {@link Configuration}.
     * @param declaration The declaration to check.
     * @return {@code true} if the declaration is used for a {@link IDecisionVariable} of the configuration or
     * if the internal table was not initialized with a {@link Configuration}, {@code false} otherwise.
     */
    boolean declarationKnown(AbstractVariable declaration) {
        return variablesTable.declarationKnown(declaration);
    }

    /**
     * Marks that a project was used, i.e., is still part of the overall structure and should not be removed.
     * @param project A visited project, which is may be imported.
     * @see #projectIsStillPresent(Project)
     */
    public void addUsedProject(Project project) {
        String qName = generateQualifiedName(project);
        projectQualifier.add(qName);
    }
}
