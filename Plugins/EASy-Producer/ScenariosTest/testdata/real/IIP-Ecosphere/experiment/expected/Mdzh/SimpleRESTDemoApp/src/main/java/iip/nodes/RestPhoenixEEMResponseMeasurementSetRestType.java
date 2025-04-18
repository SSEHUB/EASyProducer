package iip.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.iip_ecosphere.platform.connectors.rest.Convertable;

import iip.datatypes.RestPhoenixEEMResponseMeasurementSet;
import iip.datatypes.RestPhoenixEEMResponseMeasurementSetImpl;

/**
 * Rest type for the application data type RestPhoenixEEMResponseMeasurementSet.
 * Generated by: EASy-Producer.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestPhoenixEEMResponseMeasurementSetRestType implements Convertable {

    @JsonProperty("context")
    private String context;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("items")
    private RestPhoenixEEMResponseMeasurementSetItemRestType[] items;

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public RestPhoenixEEMResponseMeasurementSetRestType() {
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
     * Returns the value of items.
     *
     * @return the value of items
     */
    public RestPhoenixEEMResponseMeasurementSetItemRestType[] getItems() {
        return items;
    }

    /**
     * Changes the value of items.
     *
     * @param value the new value
     */
    public void setItems(RestPhoenixEEMResponseMeasurementSetItemRestType[] value) {
        this.items = value;
    }

    @Override
    public Object fromREST(Object data) {
        Object result = data;
        if (data instanceof RestPhoenixEEMResponseMeasurementSetRestType) {
            result = fromRESTImpl((RestPhoenixEEMResponseMeasurementSetRestType) data);
        } else if (data instanceof RestPhoenixEEMResponseMeasurementSetRestType[]) {
            result = fromRESTImpl((RestPhoenixEEMResponseMeasurementSetRestType[]) data);
        }
        return result;
    }

    /**
     * Implements the conversion from the corresponding REST type.
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixEEMResponseMeasurementSet fromRESTImpl(RestPhoenixEEMResponseMeasurementSetRestType orig) {
        RestPhoenixEEMResponseMeasurementSet result = new RestPhoenixEEMResponseMeasurementSetImpl();
        result.setContext(orig.getContext());
        result.setTimestamp(orig.getTimestamp());
        result.setItems(RestPhoenixEEMResponseMeasurementSetItemRestType.fromRESTImpl(orig.getItems()));
        return result;
    }

    /**
     * Implements the conversion from the corresponding REST type array.
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixEEMResponseMeasurementSet[] fromRESTImpl(RestPhoenixEEMResponseMeasurementSetRestType[]
        orig) {
        RestPhoenixEEMResponseMeasurementSet[] result = null;
        if (orig != null) {
            result = new RestPhoenixEEMResponseMeasurementSet[orig.length];
            for (int i = 0; i < orig.length; i++) {
                result[i] = fromRESTImpl(orig[i]);
            }
        }
        return result;
    }

    @Override
    public Object toREST(Object data) {
        Object result = data;
        if (data instanceof RestPhoenixEEMResponseMeasurementSet) {
            result = toRESTImpl((RestPhoenixEEMResponseMeasurementSet) data);
        } else if (data instanceof RestPhoenixEEMResponseMeasurementSet[]) {
            result = toRESTImpl((RestPhoenixEEMResponseMeasurementSet[]) data);
        }
        return result;
    }

    /**
     * Implements the conversion from the transport type to REST
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixEEMResponseMeasurementSetRestType[] toRESTImpl(RestPhoenixEEMResponseMeasurementSet[] orig)
        {
        RestPhoenixEEMResponseMeasurementSetRestType[] result = null;
        if (orig != null) {
            result = new RestPhoenixEEMResponseMeasurementSetRestType[orig.length];
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
    public static RestPhoenixEEMResponseMeasurementSetRestType toRESTImpl(RestPhoenixEEMResponseMeasurementSet orig) {
        RestPhoenixEEMResponseMeasurementSetRestType result = new RestPhoenixEEMResponseMeasurementSetRestType();
        result.setContext(orig.getContext());
        result.setTimestamp(orig.getTimestamp());
        result.setItems(RestPhoenixEEMResponseMeasurementSetItemRestType.toRESTImpl(orig.getItems()));
        return result;
    }

}
