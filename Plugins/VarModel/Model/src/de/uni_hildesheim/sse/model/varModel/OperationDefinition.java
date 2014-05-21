package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;

/**
 * A containable element which represents user defined operations.
 * 
 * @author Holger Eichelberger
 */
public class OperationDefinition extends ContainableModelElement {

    private CustomOperation operation;
    
    /**
     * Constructor for containable model element.
     * @param parent the object, in which this specific one is embedded
     */
    public OperationDefinition(ModelElement parent) {
        super(null, parent);
    }

    /**
     * Changes the defined operation.
     * 
     * @param operation the defined operation
     */
    public void setOperation(CustomOperation operation) {
        this.operation = operation;
        setName(operation.getName());
    }
    
    /**
     * Returns the defined operation.
     * 
     * @return the operation
     */
    public CustomOperation getOperation() {
        return operation;
    }

    /** 
     * {@inheritDoc}
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitOperationDefinition(this);
    }

}
