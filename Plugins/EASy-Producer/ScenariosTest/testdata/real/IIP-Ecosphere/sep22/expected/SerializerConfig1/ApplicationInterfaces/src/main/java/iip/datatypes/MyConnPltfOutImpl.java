package iip.datatypes;

import iip.datatypes.MyConnPltfOut;

/**
 * Implementation of the application data type MyConnPltfOut.
 * Generated by: EASy-Producer.
 */
public class MyConnPltfOutImpl implements MyConnPltfOut {
 
    private String cmdField;
    

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public MyConnPltfOutImpl() {
    }
    
    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public MyConnPltfOutImpl(MyConnPltfOut from) {
        this.cmdField = from.getCmdField();
    }

    @Override
    public String getCmdField() {
    
        return cmdField;
    }
    
    
    @Override
    public void setCmdField(String value) {
    
        this.cmdField = value;
    }
    

    @Override
    public int hashCode() {
        int hc = 0;
        hc += getCmdField() != null ? getCmdField().hashCode() : 0;
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof MyConnPltfOut) {
            MyConnPltfOut oth = (MyConnPltfOut) other;
            eq = true;
            eq &= getCmdField() != null ? getCmdField().equals(oth.getCmdField()) : true;
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