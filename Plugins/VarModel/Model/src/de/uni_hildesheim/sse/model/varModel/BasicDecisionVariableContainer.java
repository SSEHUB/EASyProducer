package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.filter.DeclarationInContainerFinder;

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
    
    /**
     * This includes all {@link DecisionVariableDeclaration}, injcluding nested {@link DecisionVariableDeclaration}s
     * of attribute assignments.
     * This list will only be generated on demand, i.e. if <tt>getDeclarationCount()</tt> is called.
     */
    private List<DecisionVariableDeclaration> allDeclarations = new ArrayList<DecisionVariableDeclaration>();
    
    /**
     * Creates a container instance.
     */
    public BasicDecisionVariableContainer() {
        super(null);
    }
    
    /**
     * {@inheritDoc}
     */
    public void sortContainedElements(Comparator<ContainableModelElement> comp) {
        assert null != comp;
        int size = modelElements.size();
        Collections.sort(modelElements, comp);
        assert modelElements.size() == size;
    }

    /**
     * {@inheritDoc}
     */
    public void add(AttributeAssignment assignment) {
        assert null != assignment;
        if (null == assignments) {
            assignments = new ArrayList<AttributeAssignment>();
        }
        assignments.add(assignment);
        modelElements.add(assignment);
    }

    /**
     * {@inheritDoc}
     */
    public int getAssignmentCount() {
        return null == assignments ? 0 : assignments.size();
    }

    /**
     * {@inheritDoc}
     */
    public AttributeAssignment getAssignment(int index) {
        if (null == assignments) {
            throw new IndexOutOfBoundsException();
        }
        return assignments.get(index);
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public DecisionVariableDeclaration getElement(String name) {
        DecisionVariableDeclaration result = null;
        for (int e = 0; null == result && e < elements.size(); e++) {
            DecisionVariableDeclaration element = elements.get(e);
            if (element.getName().equals(name)) {
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

    /**
     * {@inheritDoc}
     */
    public boolean contains(DecisionVariableDeclaration var) {
        boolean found = false;
        for (int e = 0; !found && e < elements.size(); e++) {
            found = elements.get(e).isSame(var);
        }
        for (int a = 0; !found && a < getAssignmentCount(); a++) {
            found = getAssignment(a).contains(var);
        }
        return found;
    }

    /**
     * {@inheritDoc}
     */
    public void add(Comment comment) {
        if (null != comment) {
            modelElements.add(comment);
        }
    }

    /**
     * {@inheritDoc}
     */
    public int getElementCount() {
        return elements.size();
    }

    /**
     * {@inheritDoc}
     */
    public DecisionVariableDeclaration getElement(int index) {
        return elements.get(index);
    }

    /**
     * {@inheritDoc}
     */
    public boolean add(DecisionVariableDeclaration elem) {
        assert null != elem;
        boolean found = contains(elem);
        if (!found) {
            elements.add(elem);
            modelElements.add(elem);
        }
        return !found; // use exception?
    }

    /**
     * {@inheritDoc}
     */
    public int getConstraintsCount() {
        return null == constraints ? 0 : constraints.size();
    }

    /**
     * {@inheritDoc}
     */
    public Constraint getConstraint(int index) {
        if (null == constraints) {
            throw new IndexOutOfBoundsException();
        }
        return constraints.get(index);
    }

    /**
     * {@inheritDoc}
     */
    public void addConstraint(Constraint constraint, boolean internal) {
        assert null != constraint;
        if (null == constraints) {
            constraints = new ArrayList<Constraint>();
        }
        constraints.add(constraint);
        modelElements.add(constraint);
    }

    /**
     * {@inheritDoc}
     */
    public int getRealizingCount() {
        return 0;
    }
    
    /**
     * {@inheritDoc}
     */
    public Constraint getRealizing(int index) {
        throw new IndexOutOfBoundsException("no elements");
    }
    
    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IModelVisitor visitor) {
        // unused as done by delegating class
    }

    /**
     * {@inheritDoc}
     */
    public int getDeclarationCount() {
        allDeclarations.clear();
        
        for (int i = 0; i < modelElements.size(); i++) {
            DeclarationInContainerFinder finder = new DeclarationInContainerFinder(modelElements.get(i));
            allDeclarations.addAll(finder.getDeclarations());
        }
        
        return allDeclarations.size();
    }

    /**
     * {@inheritDoc}
     */
    public DecisionVariableDeclaration getDeclaration(int index) {
        return allDeclarations.get(index);
    }
    
}
