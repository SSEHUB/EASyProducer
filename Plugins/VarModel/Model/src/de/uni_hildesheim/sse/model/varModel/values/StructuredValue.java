package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.StructuredDatatype;

/**
 * Super class of {@link ContainerValue} and {@link CompoundValue}.
 * @author beck
 * @author El-Sharkawy
 *
 */
abstract class StructuredValue extends Value {

    /**
     * Constructor for the Class.
     * @param type the type of the specific object.
     */
    protected StructuredValue(StructuredDatatype type) {
        super(type);      
    }

    /**
     * Method to check, whether each object of the Value has a value assigned.
     * @return <b>true</b> if all sub-elements are configured, else <b>false</b>
     */
    public abstract boolean isFullyConfigured();
    
    @Override
    public final boolean isConfigured() {
        return isFullyConfigured();
    }
}
