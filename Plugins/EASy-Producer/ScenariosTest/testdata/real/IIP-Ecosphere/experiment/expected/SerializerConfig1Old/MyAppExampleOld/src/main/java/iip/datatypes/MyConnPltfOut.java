package iip.datatypes;

import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Implementation of the application data type MyConnPltfOut.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("myConnPltfOut")
public class MyConnPltfOut {
 
    @JsonProperty("cmdField")
    @ConfiguredName("cmdField")
    private String cmdField;
    
    @JsonProperty("nested")
    @ConfiguredName("nested")
    private MyNested[] nested;
    

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public MyConnPltfOut() {
    }
    
    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public MyConnPltfOut(MyConnPltfOut from) {
        this.cmdField = from.getCmdField();
        this.nested = from.getNested();
    }

    /**
      * Returns the value of {@code cmdField}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getCmdField() {
    
        return cmdField;
    }
    
    /**
      * Returns the value of {@code nested}.
      * 
      * @return the value
      */
    @JsonIgnore
    public MyNested[] getNested() {
    
        return nested;
    }
    
    
    /**
     * Changes the value of {@code cmdField}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setCmdField(String value) {
    
        this.cmdField = value;
    }
    
    /**
     * Changes the value of {@code nested}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setNested(MyNested[] value) {
    
        this.nested = value;
    }
    

    @Override
    public int hashCode() {
        int hc = 0;
        hc += getCmdField() != null ? getCmdField().hashCode() : 0;
        hc += getNested() != null ? getNested().hashCode() : 0;
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof MyConnPltfOut) {
            MyConnPltfOut oth = (MyConnPltfOut) other;
            eq = true;
            eq &= getCmdField() != null ? getCmdField().equals(oth.getCmdField()) : true;
            eq &= getNested() != null ? getNested().equals(oth.getNested()) : true;
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