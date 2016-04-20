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
import java.util.Comparator;
import java.util.List;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.datatypes.Compound;

/**
 * Represents an assignment of a value to attributes of at least
 * one model element.
 * So far we refrained from defining (multiple) recursive iterators (over the assignments) due to different style and
 * potential performance issues of the generic code.
 * 
 * @author Holger Eichelberger
 */
public class AttributeAssignment extends ContainableModelElement implements IDecisionVariableContainer {

    private List<Assignment> data = new ArrayList<Assignment>();

    private BasicDecisionVariableContainer container = new FullDecisionVariableContainer();

    /**
     * Characterizes an attribute-value assignment. Please note that this instance may store
     * the data to be applied to multiple attributes.
     * 
     * @author Holger Eichelberger
     */
    public static class Assignment {
        private String name;
        private ConstraintSyntaxTree expression;
        private String operation;

        /**
         * Creates an attribute-value assignment.
         * 
         * @param name the name of the attribute the value shall be assigned to
         * @param operation the operation to be applied (as string as this data may apply to
         *   multiple attributes)
         * @param expression the value expression
         */
        public Assignment(String name, String operation, ConstraintSyntaxTree expression) {
            this.name = name;
            this.expression = expression;
            this.operation = operation;
        }
        
        /**
         * Returns the name of the attribute the value shall be assigned to.
         * 
         * @return the name of the attribute
         */
        public String getName() {
            return name;
        }
        
        /**
         * Returns the expression representing the actual value of the assignment.
         * 
         * @return the value expression
         */
        public ConstraintSyntaxTree getExpression() {
            return expression;
        }
        
        /**
         * Returns the operation of this individual attribute assignment. We cannot
         * store the name and data in this instance as it may apply to multiple attributes.
         * 
         * @return the name of the operation
         */
        public String getOperation() {
            return operation;
        }
        
    }
    
    /**
     * Creates a new attribute assignment.
     * 
     * @param parent the model element, in which this specific one is embedded
     */
    public AttributeAssignment(IModelElement parent) {
        super("attributeAssignment", parent);
    }
    
    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitAttributeAssignment(this);
    }
    
    /**
     * Returns the effective parent of this assignment, i.e., the 
     * containing compound or project.
     * 
     * @return the effective parent (<b>null</b> if there is none)
     */
    public IModelElement getEffectiveParent() {
        IModelElement result = getParent();
        if (result instanceof AttributeAssignment) {
            result = ((AttributeAssignment) result).getEffectiveParent();
        }
        return result;
    }
    
    /**
     * Returns the number of assignment data instances (attribute-value combinations).
     * 
     * @return the number of assignment instances
     */
    public int getAssignmentDataCount() {
        return data.size();
    }
    
    /**
     * Returns the specified assignment data instance.
     * 
     * @param index the index of the assignment to be returned
     * @return the specified assignment
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index &gt;= {@link #getAssignmentCount()}</code>
     */
    public Assignment getAssignmentData(int index) {
        return data.get(index);
    }
    
    @Override
    public boolean add(DecisionVariableDeclaration elem) {
        boolean added = false;
        if (!containsByName(elem.getName())) {
            added = container.add(elem);
        } 
        return added;
    }
    
    /**
     * Adds an individual assignment.
     * 
     * @param assignment the assignment to be added
     */
    public void add(Assignment assignment) {
        assert null != assignment;
        data.add(assignment);
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    // -------------------------------- delegation part ----------------------------------

    @Override
    public int getElementCount() {
        return container.getElementCount();
    }
    
    @Override
    public DecisionVariableDeclaration getElement(String name) {
        return container.getElement(name);
    }
    
    @Override
    public boolean contains(DecisionVariableDeclaration var) {
        return container.contains(var);
    }
    
    @Override
    public DecisionVariableDeclaration getElement(int index) {
        return container.getElement(index);
    }

    @Override
    public int getConstraintsCount() {
        return container.getConstraintsCount();
    }
    
    @Override
    public Constraint getConstraint(int index) {
        return container.getConstraint(index);
    }

    @Override
    public int getRealizingCount() {
        return container.getRealizingCount();
    }
    
    @Override
    public Constraint getRealizing(int index) {
        return container.getRealizing(index);
    }
    
    @Override
    public void add(Comment comment) {
        container.add(comment);
    }

    @Override
    public void add(AttributeAssignment assignment) {
        container.add(assignment);
    }
    
    @Override
    public void addConstraint(Constraint constraint, boolean internal) {
        container.addConstraint(constraint, internal);
    }
    
    @Override
    public int getAssignmentCount() {
        return container.getAssignmentCount();
    }
    
    @Override
    public AttributeAssignment getAssignment(int index) {
        return container.getAssignment(index);
    }
    
    @Override
    public ContainableModelElement getModelElement(int index) {
        return container.getModelElement(index);
    }

    @Override
    public int getModelElementCount() {
        return container.getModelElementCount();
    }

    @Override
    public void sortContainedElements(Comparator<ContainableModelElement> comp) {
        container.sortContainedElements(comp);
    }
    
    @Override
    public boolean propagateAttribute(Attribute attribute) {
        return container.propagateAttribute(attribute);
    }

    @Override
    public int getDeclarationCount() {
        return container.getDeclarationCount();
    }

    @Override
    public DecisionVariableDeclaration getDeclaration(int index) {
        return container.getDeclaration(index);
    }

    @Override
    public void add(EvaluationBlock eval) {
        container.add(eval);
    }
    
    @Override
    public boolean containsByName(String name) {
        boolean found = container.containsByName(name);
        IModelElement parent = getEffectiveParent();
        if (parent instanceof Project) {
            found = ((Project) parent).containsByName(name);
        } else if (parent instanceof Compound) {
            Compound cmp = ((Compound) parent);
            do {
                found = cmp.containsByName(name);
                cmp = cmp.getRefines();
            } while (cmp != null && !found);
        }
        return found;
    }

    @Override
    public void forceUpdate() {
        container.forceUpdate();
    }
}
