package de.uni_hildesheim.sse.reasoning.core.model.datatypes;

import de.uni_hildesheim.sse.model.varModel.datatypes.CustomDatatype;


/**
 * Abstract super class for all translated {@link de.uni_hildesheim.sse.model.varModel.datatypes.CustomDatatype}.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public abstract class ReasonerDatatype implements IReasonerTypeVisitable {
    
    private CustomDatatype type;

    /**
     * Sole constructor for this class.
     * Creates a new {@link ReasonerDatatype}.
     * @param type The {@link CustomDatatype} definition.
     */
    protected ReasonerDatatype(CustomDatatype type) {
        this.type = type;
    }
    
    /**
     * Returns the {@link CustomDatatype} definition of the type stored in this {@link ReasonerDatatype}.
     * @return The {@link CustomDatatype} definition.
     */
    public CustomDatatype getType() {
        return type;
    }
    
    /**
     * Returns the name of the {@link CustomDatatype} stored in this {@link ReasonerDatatype}.
     * @return The name of the {@link CustomDatatype}.
     */
    public String getName() {
        return type.getName();
    }
    
    /**
     * Method returns <b>true</b> if this datatype has constraints. 
     * @return <b>true</b> if this datatype has constraints.
     */
    public boolean hasConstraints() {
        return false;
    }
}
