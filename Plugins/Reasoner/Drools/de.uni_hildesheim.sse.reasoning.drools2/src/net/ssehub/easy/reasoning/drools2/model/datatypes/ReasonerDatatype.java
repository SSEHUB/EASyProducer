package net.ssehub.easy.reasoning.drools2.model.datatypes;

import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;


/**
 * Abstract super class for all translated {@link net.ssehub.easy.varModel.model.datatypes.CustomDatatype}.
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
