package de.uni_hildesheim.sse.model.varModel;

/** 
 * An evaluation block consisting of constraints to be evaluated.
 * 
 * @author Marcel Lueder
 */
public abstract class EvaluationBlock extends ContainableModelElement {
    
    /**
     * Constructor for the evaluation block.
     * 
     * @param name Name of the evaluation block
     * @param parent the object, in which this specific one is embedded
     */
    public EvaluationBlock(String name, IModelElement parent) {
        super(name, parent);
    }

    /**
     * Checks whether the evaluation block is empty.
     * @return true if empty
     */
    public boolean isEmpty() {
        return true;
    }
    
}
