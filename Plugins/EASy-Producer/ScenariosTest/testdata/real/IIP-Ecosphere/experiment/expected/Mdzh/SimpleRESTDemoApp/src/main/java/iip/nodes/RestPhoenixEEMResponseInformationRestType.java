package iip.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.iip_ecosphere.platform.connectors.rest.Convertable;

import iip.datatypes.RestPhoenixEEMResponseInformation;
import iip.datatypes.RestPhoenixEEMResponseInformationImpl;

/**
 * Rest type for the application data type RestPhoenixEEMResponseInformation.
 * Generated by: EASy-Producer.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestPhoenixEEMResponseInformationRestType implements Convertable {

    @JsonProperty("context")
    private String context;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("rootItems")
    private RestPhoenixEEMResponseInformationRootItemRestType[] rootItems;
    @JsonProperty("infoItems")
    private RestPhoenixEEMResponseInformationInfoItemRestType[] infoItems;

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public RestPhoenixEEMResponseInformationRestType() {
    }

    /**
     * Returns the value of context.
     *
     * @return the value of context
     */
    public String getContext() {
        return context;
    }

    /**
     * Changes the value of context.
     *
     * @param value the new value
     */
    public void setContext(String value) {
        this.context = value;
    }

    /**
     * Returns the value of timestamp.
     *
     * @return the value of timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Changes the value of timestamp.
     *
     * @param value the new value
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Returns the value of rootItems.
     *
     * @return the value of rootItems
     */
    public RestPhoenixEEMResponseInformationRootItemRestType[] getRootItems() {
        return rootItems;
    }

    /**
     * Changes the value of rootItems.
     *
     * @param value the new value
     */
    public void setRootItems(RestPhoenixEEMResponseInformationRootItemRestType[] value) {
        this.rootItems = value;
    }

    /**
     * Returns the value of infoItems.
     *
     * @return the value of infoItems
     */
    public RestPhoenixEEMResponseInformationInfoItemRestType[] getInfoItems() {
        return infoItems;
    }

    /**
     * Changes the value of infoItems.
     *
     * @param value the new value
     */
    public void setInfoItems(RestPhoenixEEMResponseInformationInfoItemRestType[] value) {
        this.infoItems = value;
    }

    @Override
    public Object fromREST(Object data) {
        Object result = data;
        if (data instanceof RestPhoenixEEMResponseInformationRestType) {
            result = fromRESTImpl((RestPhoenixEEMResponseInformationRestType) data);
        } else if (data instanceof RestPhoenixEEMResponseInformationRestType[]) {
            result = fromRESTImpl((RestPhoenixEEMResponseInformationRestType[]) data);
        }
        return result;
    }

    /**
     * Implements the conversion from the corresponding REST type.
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixEEMResponseInformation fromRESTImpl(RestPhoenixEEMResponseInformationRestType orig) {
        RestPhoenixEEMResponseInformation result = new RestPhoenixEEMResponseInformationImpl();
        result.setContext(orig.getContext());
        result.setTimestamp(orig.getTimestamp());
        result.setRootItems(RestPhoenixEEMResponseInformationRootItemRestType.fromRESTImpl(orig.getRootItems()));
        result.setInfoItems(RestPhoenixEEMResponseInformationInfoItemRestType.fromRESTImpl(orig.getInfoItems()));
        return result;
    }

    /**
     * Implements the conversion from the corresponding REST type array.
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixEEMResponseInformation[] fromRESTImpl(RestPhoenixEEMResponseInformationRestType[] orig) {
        RestPhoenixEEMResponseInformation[] result = null;
        if (orig != null) {
            result = new RestPhoenixEEMResponseInformation[orig.length];
            for (int i = 0; i < orig.length; i++) {
                result[i] = fromRESTImpl(orig[i]);
            }
        }
        return result;
    }

    @Override
    public Object toREST(Object data) {
        Object result = data;
        if (data instanceof RestPhoenixEEMResponseInformation) {
            result = toRESTImpl((RestPhoenixEEMResponseInformation) data);
        } else if (data instanceof RestPhoenixEEMResponseInformation[]) {
            result = toRESTImpl((RestPhoenixEEMResponseInformation[]) data);
        }
        return result;
    }

    /**
     * Implements the conversion from the transport type to REST
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixEEMResponseInformationRestType[] toRESTImpl(RestPhoenixEEMResponseInformation[] orig) {
        RestPhoenixEEMResponseInformationRestType[] result = null;
        if (orig != null) {
            result = new RestPhoenixEEMResponseInformationRestType[orig.length];
            for (int i = 0; i < orig.length; i++) {
                result[i] = toRESTImpl(orig[i]);
            }
        }
        return result;
    }

    /**
     * Implements the conversion from the transport type to REST
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixEEMResponseInformationRestType toRESTImpl(RestPhoenixEEMResponseInformation orig) {
        RestPhoenixEEMResponseInformationRestType result = new RestPhoenixEEMResponseInformationRestType();
        result.setContext(orig.getContext());
        result.setTimestamp(orig.getTimestamp());
        result.setRootItems(RestPhoenixEEMResponseInformationRootItemRestType.toRESTImpl(orig.getRootItems()));
        result.setInfoItems(RestPhoenixEEMResponseInformationInfoItemRestType.toRESTImpl(orig.getInfoItems()));
        return result;
    }

}
