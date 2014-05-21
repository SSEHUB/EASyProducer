package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.IContainableElementsSorter;

/**
 * Describes a container for decision variables.
 * 
 * @author Holger Eichelberger
 */
public interface IDecisionVariableContainer extends IModelElement, IContainableElementsSorter {

    /**
     * Adds a nested assignment.
     * 
     * @param assignment the assignment which should be added
     */
    public void add(AttributeAssignment assignment);
    
    /**
     * Returns the number of assignments.
     * 
     * @return the number of assignments
     */
    public int getAssignmentCount();
    
    /**
     * Returns the assignment specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the element to be returned
     * @return the assignment
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getAssignmentCount}</code>
     */
    public AttributeAssignment getAssignment(int index);

    
    /**
     * Returns a contained model element specified by <code>index</code>. Please note that this method returns all
     * contained model elements, i.e., decision variables and constraints and is intended to restore the input
     * sequence correctly.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the contained element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getModelElementCount()}</code>
     */
    public ContainableModelElement getModelElement(int index);

    /**
     * Returns the number of contained elements. Please note that this method refers to all
     * contained model elements, i.e., decision variables and constraints and is intended to restore the input
     * sequence correctly.
     * 
     * @return the number of contained elements
     */
    public int getModelElementCount();
    
    /**
     * Returns the element specified by <code>name</code>.
     * 
     * @param name the name of the element
     * @return the element, <b>null</b> if none was found
     */
    public DecisionVariableDeclaration getElement(String name);
    
    /**
     * Returns whether this element contains <code>var</code>.
     * 
     * @param var the variable declaration to search for
     * @return <code>true</code> if found, <code>false</code> else
     */
    public boolean contains(DecisionVariableDeclaration var);

    
    /**
     * Adds a comment to the list of contained elements.
     * 
     * @param comment the comment to be added
     */
    public void add(Comment comment);


    /**
     * Returns the number of elements.
     * 
     * @return the number of elements
     */
    public int getElementCount();
    
    /**
     * Returns the element specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the element to be returned
     * @return the element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getElementCount}</code>
     */
    public DecisionVariableDeclaration getElement(int index);

    /**
     * Method to add an object to the elements list of the project.
     * 
     * @param elem which should be added
     * @return <code>true</code> if the addition was successful, 
     *   <code>false</code> else due to duplicated variable declaration
     */
    public boolean add(DecisionVariableDeclaration elem);

    
    /**
     * Returns the number of contained constraints.
     * 
     * @return the number of constraints
     */
    public int getConstraintsCount();
    
    /**
     * Returns the specified contained constraint. 
     * 
     * @param index the index of the constraint to be returned
     * @return the specified constraint
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index &gt;= {@link #getConstraintsCount()}</code>
     */
    public Constraint getConstraint(int index);

    /**
     * Adds a constraint.
     * 
     * @param constraint the constraint to be added
     * @param internal whether the constraint is internally created while building up the model (ignored)
     */
    public void addConstraint(Constraint constraint, boolean internal);
    
    /**
     * Returns the number of realizing constraints. Please note that these constraints
     * are derived and not originally specified in the input IVML model.
     * 
     * @return the number of constraints
     */
    public int getRealizingCount();
    
    /**
     * Returns the specified realizing constraint. Please note that these constraints
     * are derived and not originally specified in the input IVML model.
     * 
     * @param index the index of the constraint to be returned
     * @return the specified constraint
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index &gt;= {@link #getRealizingCount()}</code>
     */
    public Constraint getRealizing(int index);
    
    /**
     * Returns the number of all nested {@link DecisionVariableDeclaration}s including nested
     * {@link DecisionVariableDeclaration}s of {@link AttributeAssignment}s.
     * @return The number of all nested {@link DecisionVariableDeclaration}s. This will be greater or equal to 0.
     */
    public int getDeclarationCount();
    
    
    /**
     * Returns the specified {@link DecisionVariableDeclaration}.
     * 
     * @param index the index of the {@link DecisionVariableDeclaration} to be returned
     * @return the specified {@link DecisionVariableDeclaration}
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index &gt;= {@link #getDeclarationCount()}</code>
     */
    public DecisionVariableDeclaration getDeclaration(int index);

}

