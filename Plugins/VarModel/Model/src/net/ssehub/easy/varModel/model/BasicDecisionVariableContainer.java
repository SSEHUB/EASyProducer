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
package net.ssehub.easy.varModel.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.varModel.model.filter.DeclarationInContainerFinder;

/**
 * This class basically realizes a decision variable container (this class does not support realizing constraints). 
 * However, this type of class (regarding the interface) may be used from a data type as well as from a containable 
 * model element in two different parts of the same inheritance hierarchy. This would duplicate code. As multiple 
 * inheritance is not supported in Java, we implement the basic functionality here and support reuse by delegation. 
 * So far we refrained from defining (multiple) recursive iterators (over the assignments) due to different style and
 * potential performance issues of the generic code.
 * 
 * @author Holger Eichelberger
 */
public class BasicDecisionVariableContainer extends ModelElement implements IDecisionVariableContainer {

    private List<DecisionVariableDeclaration> elements = new ArrayList<DecisionVariableDeclaration>();
    private List<Constraint> constraints = new ArrayList<Constraint>();
    private List<AttributeAssignment> assignments = null; // lazy
    private List<ContainableModelElement> modelElements = new ArrayList<ContainableModelElement>();
    private Set<String> names = new HashSet<String>();
    
    /**
     * This includes all {@link DecisionVariableDeclaration}, including nested {@link DecisionVariableDeclaration}s
     * of attribute assignments.
     * This list will only be generated on demand, i.e. if <tt>getDeclarationCount()</tt> is called.
     */
    private List<DecisionVariableDeclaration> allDeclarations = null;
    
    /**
     * Creates a container instance.
     */
    public BasicDecisionVariableContainer() {
        super(null);
    }
    
    @Override
    public void sortContainedElements(Comparator<ContainableModelElement> comp) {
        assert null != comp;
        int size = modelElements.size();
        Collections.sort(modelElements, comp);
        assert modelElements.size() == size;
    }

    @Override
    public void add(AttributeAssignment assignment) {
        assert null != assignment;
        if (null == assignments) {
            assignments = new ArrayList<AttributeAssignment>();
        }
        assignments.add(assignment);
        modelElements.add(assignment);
    }
    
    /**
     * adds a nested evaluation block.
     * 
     * @param eval the eval block
     */
    public void add(EvaluationBlock eval) {
        assert null != eval;
        // currently no need for specialized structure
        modelElements.add(eval);
    }

    @Override
    public int getAssignmentCount() {
        return null == assignments ? 0 : assignments.size();
    }

    @Override
    public AttributeAssignment getAssignment(int index) {
        if (null == assignments) {
            throw new IndexOutOfBoundsException();
        }
        return assignments.get(index);
    }

    @Override
    public ContainableModelElement getModelElement(int index) {
        return modelElements.get(index);
    }

    /**
     * Returns the number of contained elements. Please note that this method refers to all
     * contained model elements, i.e., decision variables and constraints and is intended to restore the input
     * sequence correctly.
     * 
     * @return the number of contained elements
     */
    public int getModelElementCount() {
        return modelElements.size();
    }

    @Override
    public DecisionVariableDeclaration getElement(String name) {
        DecisionVariableDeclaration result = null;
        for (int e = 0; null == result && e < elements.size(); e++) {
            DecisionVariableDeclaration element = elements.get(e);
            if (null != element && (element.getName().equals(name) || element.getQualifiedName().equals(name))) {
                // null due to incremental validation in xText
                result = element;
            }
        }
        if (null == result) {
            for (int a = 0; null == result && a < getAssignmentCount(); a++) {
                result = getAssignment(a).getElement(name);
            }
        }        
        return result;
    }

    @Override
    public boolean contains(DecisionVariableDeclaration var) {
        boolean found = containsByName(var.getName());
        for (int e = 0; !found && e < elements.size(); e++) {
            found = elements.get(e).isSame(var);
        }
        for (int a = 0; !found && a < getAssignmentCount(); a++) {
            found = getAssignment(a).contains(var);
        }
        return found;
    }
    
    /**
     * Returns whether this project contains an element and its name.
     * 
     * @param name
     *            the name to search for
     * @return <code>true</code> if this project contains the specified element, <code>false</code> else
     */
    public boolean containsByName(String name) {
        return null != name && names.contains(name);
    }

    @Override
    public void add(Comment comment) {
        if (null != comment) {
            modelElements.add(comment);
        }
    }

    @Override
    public int getElementCount() {
        return elements.size();
    }

    @Override
    public DecisionVariableDeclaration getElement(int index) {
        return elements.get(index);
    }

    @Override
    public boolean add(DecisionVariableDeclaration elem) {
        assert null != elem;
        boolean found = contains(elem);
        if (!found) {
            names.add(elem.getName());
            elements.add(elem);
            modelElements.add(elem);
        }
        return !found; // use exception?
    }

    @Override
    public int getConstraintsCount() {
        return null == constraints ? 0 : constraints.size();
    }

    @Override
    public Constraint getConstraint(int index) {
        if (null == constraints) {
            throw new IndexOutOfBoundsException();
        }
        return constraints.get(index);
    }

    @Override
    public void addConstraint(Constraint constraint, boolean internal) {
        assert null != constraint;
        if (null == constraints) {
            constraints = new ArrayList<Constraint>();
        }
        constraints.add(constraint);
        modelElements.add(constraint);
    }

    @Override
    public int getRealizingCount() {
        return 0;
    }
    
    @Override
    public Constraint getRealizing(int index) {
        throw new IndexOutOfBoundsException("no elements");
    }
    
    @Override
    public boolean propagateAttribute(Attribute attribute) {
        boolean successful = true;
        for (int e = 0; e < elements.size(); e++) {
            successful &= elements.get(e).propagateAttribute(attribute);
        }
        if (null != assignments) {
            for (int a = 0; a < assignments.size(); a++) {
                successful &= assignments.get(a).propagateAttribute(attribute);
            }
        }
        return successful;
    }

    @Override
    public void accept(IModelVisitor visitor) {
        // unused as done by delegating class
    }

    @Override
    public int getDeclarationCount() {
        if (null == allDeclarations) {
            allDeclarations = new ArrayList<DecisionVariableDeclaration>();
            for (int i = 0; i < modelElements.size(); i++) {
                DeclarationInContainerFinder finder = new DeclarationInContainerFinder(modelElements.get(i));
                allDeclarations.addAll(finder.getDeclarations());
            }
        }
        return allDeclarations.size();
    }

    @Override
    public DecisionVariableDeclaration getDeclaration(int index) {
        return allDeclarations.get(index);
    }
    
    /**
     * Removes the specified model element from this container (if it exists).
     * @param element The {@link Constraint}, {@link DecisionVariableDeclaration}, or {@link AttributeAssignment}
     * to remove. If <tt>null</tt> nothing will happen.
     * @return <tt>true</tt> if the model element was part of this container and was removed successfully.
     */
    public boolean removeModelElement(ContainableModelElement element) {
        boolean found = false;
        if (null != element) {
            if (element instanceof Constraint) {
                found = constraints.remove(element);
            } else if (element instanceof DecisionVariableDeclaration) {
                found = elements.remove(element);
                if (found) {
                    // Force update
                    allDeclarations = null;
                }
            } else if (element instanceof AttributeAssignment) {
                found = assignments.remove(element);
            }
            
            if (found) {
                found |= modelElements.remove(element);
            }
        }
        
        return found;
    }
}
