package iip.datatypes;

import iip.datatypes.KRec13Anon;

/**
 * Implementation of the application data type KRec13Anon.
 * Generated by: EASy-Producer.
 */
public class KRec13AnonImpl implements KRec13Anon {
 
    private String kip;
    
    private int intField;
    
    private String stringField;
    

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public KRec13AnonImpl() {
    }
    
    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public KRec13AnonImpl(KRec13Anon from) {
        this.kip = from.getKip();
        this.intField = from.getIntField();
        this.stringField = from.getStringField();
    }

    @Override
    public String getKip() {
    
        return kip;
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
    public void setKip(String value) {
    
        this.kip = value;
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
        hc += getKip() != null ? getKip().hashCode() : 0;
        hc += Integer.hashCode(getIntField());
        hc += getStringField() != null ? getStringField().hashCode() : 0;
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof KRec13Anon) {
            KRec13Anon oth = (KRec13Anon) other;
            eq = true;
            eq &= getKip() != null ? getKip().equals(oth.getKip()) : true;
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
