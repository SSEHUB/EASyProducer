package iip.datatypes;

import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Interface of the application data type MyConnMachineOut.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("myConnMachineOut")
public interface MyConnMachineOut {
 

    /**
      * Returns the value of {@code cmdField}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getCmdField();
    
    /**
      * Returns the value of {@code nested}.
      * 
      * @return the value
      */
    @JsonIgnore
    public MyNested[] getNested();
    
    
    /**
     * Changes the value of {@code cmdField}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setCmdField(String value);
    
    /**
     * Changes the value of {@code nested}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setNested(MyNested[] value);
    
    

}