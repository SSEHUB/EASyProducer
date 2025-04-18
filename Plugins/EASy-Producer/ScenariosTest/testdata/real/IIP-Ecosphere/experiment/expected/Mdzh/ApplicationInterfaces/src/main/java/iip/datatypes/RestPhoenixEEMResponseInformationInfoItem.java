package iip.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;

/**
 * Interface of the application data type RestPhoenixEEMResponseInformationInfoItem.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("RestPhoenixEEMResponseInformationInfoItem")
public interface RestPhoenixEEMResponseInformationInfoItem {

    /**
     * Returns the value of {@code href}.
     *
     * @return the value
     */
    @JsonIgnore
    public String getHref();

    /**
     * Changes the value of {@code href}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setHref(String value);

    /**
     * Returns the value of {@code id}.
     *
     * @return the value
     */
    @JsonIgnore
    public String getId();

    /**
     * Changes the value of {@code id}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setId(String value);

    /**
     * Returns the value of {@code name}.
     *
     * @return the value
     */
    @JsonIgnore
    public String getName();

    /**
     * Changes the value of {@code name}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setName(String value);

    /**
     * Returns the value of {@code value}.
     *
     * @return the value
     */
    @JsonIgnore
    public Object getValue();

    /**
     * Changes the value of {@code value}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setValue(Object value);

    /**
     * Returns the value of {@code description}.
     *
     * @return the value
     */
    @JsonIgnore
    public String getDescription();

    /**
     * Changes the value of {@code description}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setDescription(String value);

}
