package iip.datatypes;

import iip.datatypes.Rec1;

/**
 * Implementation of the application data type Rec1.
 * Generated by: EASy-Producer.
 */
public class Rec1Impl implements Rec1 {
 
    private int intField;
    
    private String stringField;
    

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public Rec1Impl() {
    }
    
    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public Rec1Impl(Rec1 from) {
        this.intField = from.getIntField();
        this.stringField = from.getStringField();
    }

    @Override
    public int getIntField() {
    
        return intField;
    }
    
    @Override
    public String getStringField() {
    
        return stringField;
    }
    
    
    @Override
    public void setIntField(int value) {
    
        this.intField = value;
    }
    
    @Override
    public void setStringField(String value) {
    
        this.stringField = value;
    }
    

    @Override
    public int hashCode() {
        int hc = 0;
        hc += Integer.hashCode(getIntField());
        hc += getStringField() != null ? getStringField().hashCode() : 0;
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof Rec1) {
            Rec1 oth = (Rec1) other;
            eq = true;
            eq &= getIntField() == oth.getIntField();
            eq &= getStringField() != null ? getStringField().equals(oth.getStringField()) : true;
        } else {
            eq = false;
        }
        return eq;
    }
    
    @Override
    public String toString() {
        return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this, 
            de.iip_ecosphere.platform.services.environment.IipStringStyle.SHORT_STRING_STYLE);
    }

}
