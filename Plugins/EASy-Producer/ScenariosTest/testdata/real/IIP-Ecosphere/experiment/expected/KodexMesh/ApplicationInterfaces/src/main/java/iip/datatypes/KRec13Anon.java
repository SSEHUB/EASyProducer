package iip.datatypes;

import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Interface of the application data type KRec13Anon.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("KRec13Anon")
public interface KRec13Anon {
 

    /**
      * Returns the value of {@code kip}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getKip();
    
    /**
      * Returns the value of {@code intField}.
      * 
      * @return the value
      */
    @JsonIgnore
    public int getIntField();
    
    /**
      * Returns the value of {@code stringField}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getStringField();
    
    
    /**
     * Changes the value of {@code kip}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setKip(String value);
    
    /**
     * Changes the value of {@code intField}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setIntField(int value);
    
    /**
     * Changes the value of {@code stringField}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setStringField(String value);
    
    

}