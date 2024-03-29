package iip.datatypes;

import iip.datatypes.MyConnMachineIn;

/**
 * Implementation of the application data type MyConnMachineIn.
 * Generated by: EASy-Producer.
 */
public class MyConnMachineInImpl implements MyConnMachineIn {
 
    private String dataField;
    
    private int axis;
    
    private String cmdField;
    

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public MyConnMachineInImpl() {
    }
    
    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public MyConnMachineInImpl(MyConnMachineIn from) {
        this.dataField = from.getDataField();
        this.axis = from.getAxis();
        this.cmdField = from.getCmdField();
    }

    @Override
    public String getDataField() {
    
        return dataField;
    }
    
    @Override
    public int getAxis() {
    
        return axis;
    }
    
    @Override
    public String getCmdField() {
    
        return cmdField;
    }
    
    
    @Override
    public void setDataField(String value) {
    
        this.dataField = value;
    }
    
    @Override
    public void setAxis(int value) {
    
        this.axis = value;
    }
    
    @Override
    public void setCmdField(String value) {
    
        this.cmdField = value;
    }
    

    @Override
    public int hashCode() {
        int hc = 0;
        hc += getDataField() != null ? getDataField().hashCode() : 0;
        hc += Integer.hashCode(getAxis());
        hc += getCmdField() != null ? getCmdField().hashCode() : 0;
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof MyConnMachineIn) {
            MyConnMachineIn oth = (MyConnMachineIn) other;
            eq = true;
            eq &= getDataField() != null ? getDataField().equals(oth.getDataField()) : true;
            eq &= getAxis() == oth.getAxis();
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
