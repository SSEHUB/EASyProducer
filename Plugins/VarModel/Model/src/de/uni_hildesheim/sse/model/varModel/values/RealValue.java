package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;

/**
 * This class holds the value for the real.
 * @author lueder
 * @author Holger Eichelberger
 */
public class RealValue extends BasisDatatypeValue {
    
    private Double value;

    /**
     * Constructor.
     * @param value Value of the datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected RealValue(String value) throws ValueDoesNotMatchTypeException {
        super(RealType.TYPE);
        this.setValue(value);
    }
    
    /**
     * Argumentless constructor.
     */
    protected RealValue() {
        super(RealType.TYPE);
    }

    /**
     * Creates a value object from the given value.
     * 
     * @param value the value to set
     */
    protected RealValue(Double value) {
        super(RealType.TYPE);
        this.value = value;
    }
    
    //Probably not needed? setValue(Object value) adequate ?
//    /**
//     * Setter for the value.
//     * @param value Value of the datatype
//     */
//    public void setValue(double value) {
//        this.value = value;
//    }
    
    /**
     * Getter for the value.
     * @return the saved float
     */
    public Double getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (null != value) {
            String sValue = stringValueOf(value);
            try {
                this.value = Double.parseDouble(sValue);
            } catch (NumberFormatException e) {
                throw new ValueDoesNotMatchTypeException(sValue, this, 
                    ValueDoesNotMatchTypeException.TYPE_MISMATCH);
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
    public void accept(IValueVisitor visitor) {
        visitor.visitRealValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    /**
     * {@inheritDoc}
     */
    public Value clone() {
        return new RealValue(value);
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
