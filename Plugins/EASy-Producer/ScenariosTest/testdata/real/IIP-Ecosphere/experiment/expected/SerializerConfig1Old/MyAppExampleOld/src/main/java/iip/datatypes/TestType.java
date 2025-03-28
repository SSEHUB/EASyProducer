package iip.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.iip_ecosphere.platform.services.environment.IipStringStyle;
import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Implementation of the application data type TestType.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("testType")
public class TestType {
 
    @JsonProperty("$type")
    @ConfiguredName("$type")
    private String $type;
    
    @JsonProperty("_kip")
    @ConfiguredName("_kip")
    private String _kip;
    
    @JsonProperty("values")
    @ConfiguredName("values")
    private int[] values;

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public TestType() {
    }
    
    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public TestType(TestType from) {
        this.$type = from.get$type();
        this._kip = from.get_kip();
        this.values = from.getValues();
    }

    /**
      * Returns the value of {@code $type}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String get$type() {
        return $type;
    }

    /**
     * Changes the value of {@code $type}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void set$type(String value) {
        this.$type = value;
    }
    
    /**
      * Returns the value of {@code _kip}.
      * 
      * @return the value
      */
    @JsonIgnore
    public String get_kip() {
        return _kip;
    }

    /**
     * Changes the value of {@code _kip}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void set_kip(String value) {
        this._kip = value;
    }
    
    /**
      * Returns the value of {@code values}.
      * 
      * @return the value
      */
    @JsonIgnore
    public int[] getValues() {
        return values;
    }
    
    /**
     * Changes the value of {@code values}.
     * 
     * @param value the new value
     */
    @JsonIgnore
    public void setValues(int[] value) {
        this.values = value;
    }

    @Override
    public int hashCode() {
        int hc = 0;
        hc += get$type() != null ? get$type().hashCode() : 0;
        hc += get_kip() != null ? get_kip().hashCode() : 0;
        hc += getValues() != null ? getValues().hashCode() : 0;
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof TestType) {
            TestType oth = (TestType) other;
            eq = true;
            eq &= get$type() != null ? get$type().equals(oth.get$type()) : true;
            eq &= get_kip() != null ? get_kip().equals(oth.get_kip()) : true;
            eq &= getValues() != null ? getValues().equals(oth.getValues()) : true;
        } else {
            eq = false;
        }
        return eq;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, IipStringStyle.SHORT_STRING_STYLE);
    }

}
