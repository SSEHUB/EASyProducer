package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;

/**
 * This class holds the value for the integer.
 * @author lueder
 * @author Holger Eichelberger
 */
public class IntValue extends BasisDatatypeValue {
    
    private Integer value;

    /**
     * Constructor.
     * @param value Value of the datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected IntValue(String value) throws ValueDoesNotMatchTypeException {
        super(IntegerType.TYPE);
        this.setValue(value);
    }
    
    /**
     * Argumentless constructor.
     */
    protected IntValue() {
        super(IntegerType.TYPE);
    }

    /**
     * Creates a value object from the given value.
     * 
     * @param value the value to set
     */
    protected IntValue(Integer value) {
        super(IntegerType.TYPE);
        this.value = value;
    }

    /**
     * Setter for the value.
     * @param value Value of the datatype
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Getter for the value.
     * @return the saved int
     */
    public Integer getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (null != value) {
            String sValue = stringValueOf(value);
            try {
                this.value = Integer.parseInt(sValue);      
            } catch (NumberFormatException e) {
                throw new ValueDoesNotMatchTypeException(sValue, this, 
                    ValueDoesNotMatchTypeException.TYPE_MISMATCH);
            }
        } else {
            this.value = null;
        }
    }
    
    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    /** 
     * Accept method for the visitor. <br/>
     * This method is used for saving this model element.
     * @param visitor The visitor, which should save this model element.
     */
    public void accept(IValueVisitor visitor) {
        visitor.visitIntValue(this);
    }
    
    /**
     * {@inheritDoc}
     */
    public Value clone() {
        return new IntValue(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        //Two objects are equal if they instances of the same class and have the same hashCode
        boolean equals = false;
        
        if (obj instanceof IntValue) {
            equals = this.hashCode() == obj.hashCode();
        }
        
        return equals;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (null != value) {
            hash = value.hashCode();
        }
        
        return hash;
    }
    
}
