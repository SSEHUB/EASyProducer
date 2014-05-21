package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;

/**
 * Holds the value for a {@link MetaType}.
 *
 * @author Holger Eichelberger
 */
public class MetaTypeValue extends Value {
    
    private IDatatype value;

    /**
     * Constructor.
     * @param value Value of this instance
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected MetaTypeValue(Object value) throws ValueDoesNotMatchTypeException {
        super(MetaType.TYPE);
        setValue(value);
    }
    
    /**
     * Argumentless constructor.
     */
    protected MetaTypeValue() {
        super(MetaType.TYPE);
    }
    
    /**
     * Getter for the value.
     * 
     * @return the saved datatype
     */
    public IDatatype getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof IDatatype) {
            this.value = (IDatatype) value;
        } else {
            throw new ValueDoesNotMatchTypeException(
                stringValueOf(value), this, ValueDoesNotMatchTypeException.NO_DATATYPE);
        }
    }
    
    /** 
     * Accept method for the visitor. <br/>
     * This method is used for saving this model element.
     * @param visitor The visitor, which should save this model element.
     */
    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitMetaTypeValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    /**
     * {@inheritDoc}
     */
    public Value clone() {
        Value result;
        try {
            result = new MetaTypeValue(value);
        } catch (ValueDoesNotMatchTypeException e) {
            assert false;
            // shall not happen on valid instances
            result = null;
        }
        return result;
    }
    
    /**
     * Returns the data type explicitly contained in this value. This is 
     * typically a meta value, i.e. a type expression.
     * 
     * @return the contained type or <b>null</b> if there is none
     */
    public IDatatype getContainedType() {
        return value;
    }

}
