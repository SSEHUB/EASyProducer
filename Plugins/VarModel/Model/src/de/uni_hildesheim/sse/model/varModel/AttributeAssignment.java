package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;

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
     * Creates a new comment element.
     * 
     * @param parent the model element, in which this specific one is embedded
     */
    public AttributeAssignment(IModelElement parent) {
        super("attributeAssignment", parent);
    }
    
    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
    public boolean add(DecisionVariableDeclaration elem) {
        boolean yetAdded = false;
        IModelElement parent = getEffectiveParent();
        if (parent instanceof Project) {
            if (((Project) parent).containsByName(elem.getName(), null)) {
                yetAdded = true;
            }
        } // handled in compound
        if (!yetAdded) {
            yetAdded = !container.add(elem);
        } 
        return !yetAdded;
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

    /**
     * {@inheritDoc}
     */
    public boolean isTransparent() {
        return true;
    }

    // -------------------------------- delegation part ----------------------------------

    /**
     * {@inheritDoc} 
     */
    public int getElementCount() {
        return container.getElementCount();
    }
    
    /**
     * {@inheritDoc}
     */
    public DecisionVariableDeclaration getElement(String name) {
        return container.getElement(name);
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean contains(DecisionVariableDeclaration var) {
        return container.contains(var);
    }
    
    /**
     * {@inheritDoc} 
     */
    public DecisionVariableDeclaration getElement(int index) {
        return container.getElement(index);
    }

    /**
     * {@inheritDoc}
     */
    public int getConstraintsCount() {
        return container.getConstraintsCount();
    }
    
    /**
     * {@inheritDoc}
     */
    public Constraint getConstraint(int index) {
        return container.getConstraint(index);
    }

    /**
     * {@inheritDoc}
     */
    public int getRealizingCount() {
        return container.getRealizingCount();
    }
    
    /**
     * {@inheritDoc}
     */
    public Constraint getRealizing(int index) {
        return container.getRealizing(index);
    }
    
    /**
     * {@inheritDoc}
     */
    public void add(Comment comment) {
        container.add(comment);
    }

    /**
     * {@inheritDoc}
     */
    public void add(AttributeAssignment assignment) {
        container.add(assignment);
    }
    
    /**
     * {@inheritDoc}
     */
    public void addConstraint(Constraint constraint, boolean internal) {
        container.addConstraint(constraint, internal);
    }
    
    /**
     * {@inheritDoc}
     */
    public int getAssignmentCount() {
        return container.getAssignmentCount();
    }
    
    /**
     * {@inheritDoc}
     */
    public AttributeAssignment getAssignment(int index) {
        return container.getAssignment(index);
    }
    
    /**
     * {@inheritDoc}
     */
    public ContainableModelElement getModelElement(int index) {
        return container.getModelElement(index);
    }

    /**
     * {@inheritDoc}
     */
    public int getModelElementCount() {
        return container.getModelElementCount();
    }

    /**
     * {@inheritDoc}
     */
    public void sortContainedElements(Comparator<ContainableModelElement> comp) {
        container.sortContainedElements(comp);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean propagateAttribute(Attribute attribute) {
        return container.propagateAttribute(attribute);
    }

    /**
     * {@inheritDoc}
     */
    public int getDeclarationCount() {
        return container.getDeclarationCount();
    }

    /**
     * {@inheritDoc}
     */
    public DecisionVariableDeclaration getDeclaration(int index) {
        return container.getDeclaration(index);
    }

}
