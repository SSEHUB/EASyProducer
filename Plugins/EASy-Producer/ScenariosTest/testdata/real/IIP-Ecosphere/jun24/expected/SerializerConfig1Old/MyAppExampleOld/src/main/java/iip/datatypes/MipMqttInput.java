package iip.datatypes;

import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Implementation of the application data type MipMqttInput.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("MipMqttInput")
public class MipMqttInput {
 
    @JsonProperty("mipcontext")
    @ConfiguredName("mipcontext")
    private String mipcontext;
    
    @JsonProperty("mipdate")
    @ConfiguredName("mipdate")
    private String mipdate;
    
    @JsonProperty("mipto")
    @ConfiguredName("mipto")
    private String mipto;
    
    @JsonProperty("mipfrom")
    @ConfiguredName("mipfrom")
    private String mipfrom;
    
    @JsonProperty("mipcommand")
    @ConfiguredName("mipcommand")
    private String mipcommand;
    
    @JsonProperty("mipbitstream_ai_clock")
    @ConfiguredName("mipbitstream_ai_clock")
    private String mipbitstream_ai_clock;
    
    @JsonProperty("mipbitstream_ai_data1")
    @ConfiguredName("mipbitstream_ai_data1")
    private String mipbitstream_ai_data1;
    
    @JsonProperty("mipbitstream_ai_data2")
    @ConfiguredName("mipbitstream_ai_data2")
    private String mipbitstream_ai_data2;
    
    @JsonProperty("mipreader")
    @ConfiguredName("mipreader")
    private String mipreader;
    

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public MipMqttInput() {
    }
    
    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public MipMqttInput(MipMqttInput from) {
        this.mipcontext = from.getMipcontext();
        this.mipdate = from.getMipdate();
        this.mipto = from.getMipto();
        this.mipfrom = from.getMipfrom();
        this.mipcommand = from.getMipcommand();
        this.mipbitstream_ai_clock = from.getMipbitstream_ai_clock();
        this.mipbitstream_ai_data1 = from.getMipbitstream_ai_data1();
        this.mipbitstream_ai_data2 = from.getMipbitstream_ai_data2();
        this.mipreader = from.getMipreader();
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
      * Returns the value of {@code mipto}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipto() {
    
        return mipto;
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
      * Returns the value of {@code mipcommand}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipcommand() {
    
        return mipcommand;
    }
    
    /**
      * Returns the value of {@code mipbitstream_ai_clock}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipbitstream_ai_clock() {
    
        return mipbitstream_ai_clock;
    }
    
    /**
      * Returns the value of {@code mipbitstream_ai_data1}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipbitstream_ai_data1() {
    
        return mipbitstream_ai_data1;
    }
    
    /**
      * Returns the value of {@code mipbitstream_ai_data2}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String getMipbitstream_ai_data2() {
    
        return mipbitstream_ai_data2;
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
     * Changes the value of {@code mipto}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipto(String value) {
    
        this.mipto = value;
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
     * Changes the value of {@code mipcommand}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipcommand(String value) {
    
        this.mipcommand = value;
    }
    
    /**
     * Changes the value of {@code mipbitstream_ai_clock}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipbitstream_ai_clock(String value) {
    
        this.mipbitstream_ai_clock = value;
    }
    
    /**
     * Changes the value of {@code mipbitstream_ai_data1}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipbitstream_ai_data1(String value) {
    
        this.mipbitstream_ai_data1 = value;
    }
    
    /**
     * Changes the value of {@code mipbitstream_ai_data2}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setMipbitstream_ai_data2(String value) {
    
        this.mipbitstream_ai_data2 = value;
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
    

    @Override
    public int hashCode() {
        int hc = 0;
        hc += getMipcontext() != null ? getMipcontext().hashCode() : 0;
        hc += getMipdate() != null ? getMipdate().hashCode() : 0;
        hc += getMipto() != null ? getMipto().hashCode() : 0;
        hc += getMipfrom() != null ? getMipfrom().hashCode() : 0;
        hc += getMipcommand() != null ? getMipcommand().hashCode() : 0;
        hc += getMipbitstream_ai_clock() != null ? getMipbitstream_ai_clock().hashCode() : 0;
        hc += getMipbitstream_ai_data1() != null ? getMipbitstream_ai_data1().hashCode() : 0;
        hc += getMipbitstream_ai_data2() != null ? getMipbitstream_ai_data2().hashCode() : 0;
        hc += getMipreader() != null ? getMipreader().hashCode() : 0;
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof MipMqttInput) {
            MipMqttInput oth = (MipMqttInput) other;
            eq = true;
            eq &= getMipcontext() != null ? getMipcontext().equals(oth.getMipcontext()) : true;
            eq &= getMipdate() != null ? getMipdate().equals(oth.getMipdate()) : true;
            eq &= getMipto() != null ? getMipto().equals(oth.getMipto()) : true;
            eq &= getMipfrom() != null ? getMipfrom().equals(oth.getMipfrom()) : true;
            eq &= getMipcommand() != null ? getMipcommand().equals(oth.getMipcommand()) : true;
            eq &= getMipbitstream_ai_clock() != null ? getMipbitstream_ai_clock().equals(oth.getMipbitstream_ai_clock()) : true;
            eq &= getMipbitstream_ai_data1() != null ? getMipbitstream_ai_data1().equals(oth.getMipbitstream_ai_data1()) : true;
            eq &= getMipbitstream_ai_data2() != null ? getMipbitstream_ai_data2().equals(oth.getMipbitstream_ai_data2()) : true;
            eq &= getMipreader() != null ? getMipreader().equals(oth.getMipreader()) : true;
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