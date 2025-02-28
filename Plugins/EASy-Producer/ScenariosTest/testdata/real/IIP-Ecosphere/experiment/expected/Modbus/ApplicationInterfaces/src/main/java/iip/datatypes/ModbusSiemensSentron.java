package iip.datatypes;

import java.math.BigInteger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;

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
    public BigInteger getDisplayContrast();

    /**
     * Changes the value of {@code DisplayContrast}. Display Contrast
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setDisplayContrast(BigInteger value);
    
    /**
     * Returns the value of {@code DisplayBrightness}. Display Brightness
     * 
     * @return the value
     */
    @JsonIgnore
    public BigInteger getDisplayBrightness();

    /**
     * Changes the value of {@code DisplayBrightness}. Display Brightness
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setDisplayBrightness(BigInteger value);
    
    /**
     * Returns the value of {@code BrightnessDuration}. BrightnessDuration
     * 
     * @return the value
     */
    @JsonIgnore
    public BigInteger getBrightnessDuration();

    /**
     * Changes the value of {@code BrightnessDuration}. BrightnessDuration
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setBrightnessDuration(BigInteger value);
    
    /**
     * Returns the value of {@code Frequency}. Power Frequency
     * 
     * @return the value
     */
    @JsonIgnore
    public float getFrequency();

    /**
     * Changes the value of {@code Frequency}. Power Frequency
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setFrequency(float value);
    
    /**
     * Returns the value of {@code VoltageL1N}. Voltage L1-N
     * 
     * @return the value
     */
    @JsonIgnore
    public float getVoltageL1N();

    /**
     * Changes the value of {@code VoltageL1N}. Voltage L1-N
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setVoltageL1N(float value);
    
    /**
     * Returns the value of {@code CurrentL1}. Current L1
     * 
     * @return the value
     */
    @JsonIgnore
    public float getCurrentL1();
    
    /**
     * Changes the value of {@code CurrentL1}. Current L1
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setCurrentL1(float value);

}
