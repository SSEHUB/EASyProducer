package iip.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.iip_ecosphere.platform.support.iip_aas.ConfiguredName;

/**
 * Interface of the application data type RestPhoenixEEMResponseInformation.
 * Generated by: EASy-Producer.
 */
@ConfiguredName("RestPhoenixEEMResponseInformation")
public interface RestPhoenixEEMResponseInformation {

    /**
     * Returns the value of {@code context}.
     *
     * @return the value
     */
    @JsonIgnore
    public String getContext();

    /**
     * Changes the value of {@code context}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setContext(String value);

    /**
     * Returns the value of {@code timestamp}.
     *
     * @return the value
     */
    @JsonIgnore
    public String getTimestamp();

    /**
     * Changes the value of {@code timestamp}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setTimestamp(String value);

    /**
     * Returns the value of {@code rootItems}.
     *
     * @return the value
     */
    @JsonIgnore
    public RestPhoenixEEMResponseInformationRootItem[] getRootItems();

    /**
     * Changes the value of {@code rootItems}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setRootItems(RestPhoenixEEMResponseInformationRootItem[] value);

    /**
     * Returns the value of {@code infoItems}.
     *
     * @return the value
     */
    @JsonIgnore
    public RestPhoenixEEMResponseInformationInfoItem[] getInfoItems();

    /**
     * Changes the value of {@code infoItems}.
     *
     * @param value the new value
     */
    @JsonIgnore
    public void setInfoItems(RestPhoenixEEMResponseInformationInfoItem[] value);

}
