package iip.datatypes;

import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Implementation of the application data type MipMqttOutput.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("MipMqttOutput")
public class MipMqttOutput {
 
    @JsonProperty("mipcontext")
    @ConfiguredName("mipcontext")
    private String mipcontext;
    
    @JsonProperty("mipdate")
    @ConfiguredName("mipdate")
    private String mipdate;
    
    @JsonProperty("mipfrom")
    @ConfiguredName("mipfrom")
    private String mipfrom;
    
    @JsonProperty("mipid_tag")
    @ConfiguredName("mipid_tag")
    private String mipid_tag;
    
    @JsonProperty("mipreader")
    @ConfiguredName("mipreader")
    private String mipreader;
    
    @JsonProperty("mipraw_signal_clock")
    @ConfiguredName("mipraw_signal_clock")
    private String mipraw_signal_clock;
    
    @JsonProperty("mipraw_signal_data1")
    @ConfiguredName("mipraw_signal_data1")
    private String mipraw_signal_data1;
    
    @JsonProperty("mipraw_signal_data2")
    @ConfiguredName("mipraw_signal_data2")
    private String mipraw_signal_data2;
    

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public MipMqttOutput() {
    }
    
    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public MipMqttOutput(MipMqttOutput from) {
        this.mipcontext = from.getMipcontext();
        this.mipdate = from.getMipdate();
        this.mipfrom = from.getMipfrom();
        this.mipid_tag = from.getMipid_tag();
        this.mipreader = from.getMipreader();
        this.mipraw_signal_clock = from.getMipraw_signal_clock();
        this.mipraw_signal_data1 = from.getMipraw_signal_data1();
        this.mipraw_signal_data2 = from.getMipraw_signal_data2();
    }

    /**
      * Returns the value of {@code mipcontext}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipcontext() {
    
        return mipcontext;
    }
    
    /**
      * Returns the value of {@code mipdate}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipdate() {
    
        return mipdate;
    }
    
    /**
      * Returns the value of {@code mipfrom}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipfrom() {
    
        return mipfrom;
    }
    
    /**
      * Returns the value of {@code mipid_tag}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipid_tag() {
    
        return mipid_tag;
    }
    
    /**
      * Returns the value of {@code mipreader}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipreader() {
    
        return mipreader;
    }
    
    /**
      * Returns the value of {@code mipraw_signal_clock}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipraw_signal_clock() {
    
        return mipraw_signal_clock;
    }
    
    /**
      * Returns the value of {@code mipraw_signal_data1}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipraw_signal_data1() {
    
        return mipraw_signal_data1;
    }
    
    /**
      * Returns the value of {@code mipraw_signal_data2}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipraw_signal_data2() {
    
        return mipraw_signal_data2;
    }
    
    
    /**
     * Changes the value of {@code mipcontext}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipcontext(String value) {
    
        this.mipcontext = value;
    }
    
    /**
     * Changes the value of {@code mipdate}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipdate(String value) {
    
        this.mipdate = value;
    }
    
    /**
     * Changes the value of {@code mipfrom}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipfrom(String value) {
    
        this.mipfrom = value;
    }
    
    /**
     * Changes the value of {@code mipid_tag}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipid_tag(String value) {
    
        this.mipid_tag = value;
    }
    
    /**
     * Changes the value of {@code mipreader}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipreader(String value) {
    
        this.mipreader = value;
    }
    
    /**
     * Changes the value of {@code mipraw_signal_clock}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipraw_signal_clock(String value) {
    
        this.mipraw_signal_clock = value;
    }
    
    /**
     * Changes the value of {@code mipraw_signal_data1}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipraw_signal_data1(String value) {
    
        this.mipraw_signal_data1 = value;
    }
    
    /**
     * Changes the value of {@code mipraw_signal_data2}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipraw_signal_data2(String value) {
    
        this.mipraw_signal_data2 = value;
    }
    

    @Override
    public int hashCode() {
        int hc = 0;
        hc += getMipcontext() != null ? getMipcontext().hashCode() : 0;
        hc += getMipdate() != null ? getMipdate().hashCode() : 0;
        hc += getMipfrom() != null ? getMipfrom().hashCode() : 0;
        hc += getMipid_tag() != null ? getMipid_tag().hashCode() : 0;
        hc += getMipreader() != null ? getMipreader().hashCode() : 0;
        hc += getMipraw_signal_clock() != null ? getMipraw_signal_clock().hashCode() : 0;
        hc += getMipraw_signal_data1() != null ? getMipraw_signal_data1().hashCode() : 0;
        hc += getMipraw_signal_data2() != null ? getMipraw_signal_data2().hashCode() : 0;
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof MipMqttOutput) {
            MipMqttOutput oth = (MipMqttOutput) other;
            eq = true;
            eq &= getMipcontext() != null ? getMipcontext().equals(oth.getMipcontext()) : true;
            eq &= getMipdate() != null ? getMipdate().equals(oth.getMipdate()) : true;
            eq &= getMipfrom() != null ? getMipfrom().equals(oth.getMipfrom()) : true;
            eq &= getMipid_tag() != null ? getMipid_tag().equals(oth.getMipid_tag()) : true;
            eq &= getMipreader() != null ? getMipreader().equals(oth.getMipreader()) : true;
            eq &= getMipraw_signal_clock() != null ? getMipraw_signal_clock().equals(oth.getMipraw_signal_clock()) : true;
            eq &= getMipraw_signal_data1() != null ? getMipraw_signal_data1().equals(oth.getMipraw_signal_data1()) : true;
            eq &= getMipraw_signal_data2() != null ? getMipraw_signal_data2().equals(oth.getMipraw_signal_data2()) : true;
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