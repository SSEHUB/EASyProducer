package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains partial evaluable elements.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class PartialEvaluationBlock extends EvaluationBlock {
    
    private IPartialEvaluable[] elements;
    
    private PartialEvaluationBlock[] nested;
    
    private List<ContainableModelElement> modelElements = new ArrayList<ContainableModelElement>();

    /**
     * Constructor for the partial evaluation block.
     * @param name Name of the partial evaluation block
     * @param parent the object, in which this specific one is embedded
     */
    public PartialEvaluationBlock(String name, IModelElement parent) {
        this(name, null, parent);
    }

    /**
     * Constructor for the partial evaluation block.
     * @param name Name of the partial evaluation block
     * @param elements the evaluable elements
     * @param parent the object, in which this specific one is embedded
     */
    public PartialEvaluationBlock(String name, IPartialEvaluable[] elements, IModelElement parent) {
        this(name, elements, null, parent);
    }
    
    /**
     * Constructor for the partial evaluation block.
     * @param name Name of the partial evaluation block
     * @param elements the evaluable elements
     * @param nested nested evaluation blocks (may be <b>null</b>)
     * @param parent the object, in which this specific one is embedded
     */
    public PartialEvaluationBlock(String name, IPartialEvaluable[] elements, PartialEvaluationBlock[] nested, 
        IModelElement parent) {
        super(name, parent);
        this.elements = elements;
        this.nested = nested;
    }
    
    /**
     * Checks whether the evaluation block is empty.
     * @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return null == elements || 0 == elements.length;
    }
    
    /**
     * Returns the constraint specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the evaluable to be returned
     * @return the specified evaluable
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getEvaluableCount}</code>
     */
    public IPartialEvaluable getEvaluable(int index) {
        return elements[index];
    }

    /**
     * Returns the number of constraints.
     * 
     * @return the number of constraints
     */
    public int getEvaluableCount() {
        return null == elements ? 0 : elements.length;
    }
    
    /**
     * Changes the evaluables. [required as consequence of parent elements]
     * 
     * @param elements the new evaluables (may be <b>null</b>)
     */
    public void setEvaluables(IPartialEvaluable[] elements) {
        this.elements = elements;
    }

    /**
     * Returns the nested block specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the block to be returned
     * @return the specified nested block
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getNestedCount}</code>
     */
    public PartialEvaluationBlock getNested(int index) {
        return nested[index];
    }

    /**
     * Returns the number of nested blocks.
     * 
     * @return the number of nested blocks
     */
    public int getNestedCount() {
        return null == nested ? 0 : nested.length;
    }
    
    /**
     * Changes the nested blocks. [required as consequence of parent elements]
     * 
     * @param nested the new nested blocks (may be <b>null</b>)
     */
    public void setNested(PartialEvaluationBlock[] nested) {
        this.nested = nested;
    }

    /** 
     * {@inheritDoc}
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitPartialEvaluationBlock(this);
    }
    
    /**
     * Returns the specified model element.
     * 
     * @param index the 0-based index of the model element
     * @return the model-element
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getModelElementCount()}</code>
     */
    public ContainableModelElement getModelElement(int index) {
        return modelElements.get(index);
    }

    /**
     * Returns the number of model elements.
     * 
     * @return the number of model elements
     */
    public int getModelElementCount() {
        return modelElements.size();
    }

    /**
     * Adds a model element in sequence. Please note that this method refers to all
     * contained model elements, i.e., decision variables and constraints and is intended to restore the input
     * sequence correctly.
     * 
     * @param element the model element
     */
    public void addModelElement(ContainableModelElement element) {
        // TODO unify implementation with other classes, see sort method
        modelElements.add(element);
    }

}
