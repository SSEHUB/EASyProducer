package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;

/**
 * This class holds the value for the boolean.
 * @author lueder
 * @author Holger Eichelberger
 */
public class BooleanValue extends BasisDatatypeValue {
    
    private Boolean value;

    /**
     * Constructor.
     * @param value Value of the Datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected BooleanValue(String value) throws ValueDoesNotMatchTypeException {
        super(BooleanType.TYPE);
        setValue(value);
    }
    
    /**
     * Argumentless constructor.
     */
    protected BooleanValue() {
        super(BooleanType.TYPE);
    }

    /**
     * Creates a boolean value from the given boolean value.
     * 
     * @param value the value to assign
     */
    protected BooleanValue(Boolean value) {
        super(BooleanType.TYPE);
        this.value = value;
    }
    
    /**
     * Getter for the value.
     * @return the saved boolean
     */
    public Boolean getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (null != value) {
            if ("true".equals(value)) {
                this.value = true;
            } else if ("false".equals(value)) {
                this.value = false;
            } else {
                throw new ValueDoesNotMatchTypeException(
                    stringValueOf(value), this, ValueDoesNotMatchTypeException.NO_LITERAL);
            } 
        } else {
            this.value = null;
        }
    }
    
    /** 
     * Accept method for the visitor. <br/>
     * This method is used for saving this model element.
     * @param visitor The visitor, which should save this model element.
     */
    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitBooleanValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    /**
     * {@inheritDoc}
     */
    public Value clone() {
        return new BooleanValue(value);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        return value.equals(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
}
