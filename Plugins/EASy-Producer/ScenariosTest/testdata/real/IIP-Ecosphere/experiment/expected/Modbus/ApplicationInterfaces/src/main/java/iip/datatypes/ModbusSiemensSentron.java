package iip.datatypes;

import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Interface of the application data type ModbusSiemensSentron.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("ModbusSiemensSentron")
public interface ModbusSiemensSentron {
 

    /**
      * Returns the value of {@code DisplayContrast}. Display Contrast
      * 
      * @return the value
      */
    @JsonIgnore
    public long getDisplayContrast();
    
    /**
      * Returns the value of {@code DisplayBrightness}. Display Brightness
      * 
      * @return the value
      */
    @JsonIgnore
    public long getDisplayBrightness();
    
    /**
      * Returns the value of {@code BrightnessDuration}. BrightnessDuration
      * 
      * @return the value
      */
    @JsonIgnore
    public long getBrightnessDuration();
    
    /**
      * Returns the value of {@code Frequency}. Power Frequency
      * 
      * @return the value
      */
    @JsonIgnore
    public float getFrequency();
    
    /**
      * Returns the value of {@code VoltageL1N}. Voltage L1-N
      * 
      * @return the value
      */
    @JsonIgnore
    public float getVoltageL1N();
    
    /**
      * Returns the value of {@code CurrentL1}. Current L1
      * 
      * @return the value
      */
    @JsonIgnore
    public float getCurrentL1();
    
    
    /**
     * Changes the value of {@code DisplayContrast}. Display Contrast
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setDisplayContrast(long value);
    
    /**
     * Changes the value of {@code DisplayBrightness}. Display Brightness
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setDisplayBrightness(long value);
    
    /**
     * Changes the value of {@code BrightnessDuration}. BrightnessDuration
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setBrightnessDuration(long value);
    
    /**
     * Changes the value of {@code Frequency}. Power Frequency
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setFrequency(float value);
    
    /**
     * Changes the value of {@code VoltageL1N}. Voltage L1-N
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setVoltageL1N(float value);
    
    /**
     * Changes the value of {@code CurrentL1}. Current L1
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setCurrentL1(float value);
    
    

}