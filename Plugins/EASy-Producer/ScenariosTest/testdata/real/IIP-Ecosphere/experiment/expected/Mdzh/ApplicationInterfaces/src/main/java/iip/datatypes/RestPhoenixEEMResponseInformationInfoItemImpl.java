package iip.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.iip_ecosphere.platform.services.environment.IipStringStyle;
import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;

import iip.datatypes.RestPhoenixEEMResponseInformationInfoItem;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Implementation of the application data type RestPhoenixEEMResponseInformationInfoItem.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("RestPhoenixEEMResponseInformationInfoItem")
public class RestPhoenixEEMResponseInformationInfoItemImpl implements RestPhoenixEEMResponseInformationInfoItem {

    @JsonProperty("href")
    @ConfiguredName("href")
    private String href;
    @JsonProperty("id")
    @ConfiguredName("id")
    private String id;
    @JsonProperty("name")
    @ConfiguredName("name")
    private String name;
    @JsonProperty("value")
    @ConfiguredName("value")
    private Object value;
    @JsonProperty("description")
    @ConfiguredName("description")
    private String description;

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public RestPhoenixEEMResponseInformationInfoItemImpl() {
    }

    /**
     * Copy constructor.
     *
     * @param from the instance to copy the values from
     */
    public RestPhoenixEEMResponseInformationInfoItemImpl(RestPhoenixEEMResponseInformationInfoItem from) {
        this.href = from.getHref();
        this.id = from.getId();
        this.name = from.getName();
        this.value = from.getValue();
        this.description = from.getDescription();
    }

    @Override
    @JsonIgnore
    public String getHref() {
        return href;
    }

    @Override
    @JsonIgnore
    public void setHref(String value) {
        this.href = value;
    }

    @Override
    @JsonIgnore
    public String getId() {
        return id;
    }

    @Override
    @JsonIgnore
    public void setId(String value) {
        this.id = value;
    }

    @Override
    @JsonIgnore
    public String getName() {
        return name;
    }

    @Override
    @JsonIgnore
    public void setName(String value) {
        this.name = value;
    }

    @Override
    @JsonIgnore
    public Object getValue() {
        return value;
    }

    @Override
    @JsonIgnore
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    @JsonIgnore
    public String getDescription() {
        return description;
    }

    @Override
    @JsonIgnore
    public void setDescription(String value) {
        this.description = value;
    }

    @Override
    public int hashCode() {
        int hc = 0;
        hc += getHref() != null ? getHref().hashCode() : 0;
        hc += getId() != null ? getId().hashCode() : 0;
        hc += getName() != null ? getName().hashCode() : 0;
        hc += getValue() != null ? getValue().hashCode() : 0;
        hc += getDescription() != null ? getDescription().hashCode() : 0;
        return hc;
    }

    @Override
    public boolean equals(Object other) {
        boolean eq;
        if (other instanceof RestPhoenixEEMResponseInformationInfoItem) {
            RestPhoenixEEMResponseInformationInfoItem oth = (RestPhoenixEEMResponseInformationInfoItem) other;
            eq = true;
            eq &= getHref() != null ? getHref().equals(oth.getHref()) : true;
            eq &= getId() != null ? getId().equals(oth.getId()) : true;
            eq &= getName() != null ? getName().equals(oth.getName()) : true;
            eq &= getValue() != null ? getValue().equals(oth.getValue()) : true;
            eq &= getDescription() != null ? getDescription().equals(oth.getDescription()) : true;
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
