package iip.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;

/**
 * Interface of the application data type MyConnPltfOut.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("myConnPltfOut")
public interface MyConnPltfOut {
 
    /**
      * Returns the value of {@code cmdField}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getCmdField();

    /**
     * Changes the value of {@code cmdField}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setCmdField(String value);
    
    /**
      * Returns the value of {@code nested}.
      * 
      * @return the value
      */
    @JsonIgnore
    public MyNested[] getNested();
    
    /**
     * Changes the value of {@code nested}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setNested(MyNested[] value);

}
