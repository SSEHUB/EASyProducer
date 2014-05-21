package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.BasisDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Holding basis data types.
 * @author Marcel Lueder
 *
 */
public abstract class BasisDatatypeValue extends Value {

    /**
     * Constructor for a new BasisDatatypeValue.
     * @param type type of the Value
     */
    protected BasisDatatypeValue(IDatatype type) {
        super(type);        
        assert type instanceof BasisDatatype;
    }
    /**
     * Getter for the value. Not implemented yet.
     * @return null
     */
    @Override
    public Object getValue() {
        return null;
    }
    
}
