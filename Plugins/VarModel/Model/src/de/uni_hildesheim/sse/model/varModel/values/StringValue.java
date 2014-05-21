package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * This class holds the value for the string.
 * @author lueder
 * @author Holger Eichelberger
 */
public class StringValue extends BasisDatatypeValue {
    
    private String value;

    /**
     * Argumentless constructor.
     */
    protected StringValue() {
        super(StringType.TYPE);
    }
    
    /**
     * Constructor.
     * @param value Value of the Datatype
     */
    protected StringValue(String value) {
        super(StringType.TYPE);
        this.value = value;
    }
    
    /**
     * Setter for the value.
     * @param value Value of the Datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        this.value = stringValueOf(value);
    }
    
    /**
     * Getter for the value.
     * @return the saved String
     */
    public String getValue() {
        return value;
    }
    
    /** 
     * Accept method for the visitor. <br/>
     * This method is used for saving this model element.
     * @param visitor The visitor, which should save this model element.
     */
    public void accept(IValueVisitor visitor) {
        visitor.visitStringValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    /**
     * {@inheritDoc}
     */
    public Value clone() {
        return new StringValue(value);
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
