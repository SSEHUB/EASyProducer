package iip.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.iip_ecosphere.platform.connectors.rest.Convertable;

import iip.datatypes.RestPhoenixRwEEMMixed;
import iip.datatypes.RestPhoenixRwEEMMixedImpl;

/**
 * Rest type for the application data type RestPhoenixRwEEMMixed.
 * Generated by: EASy-Producer.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestPhoenixRwEEMMixedRestType implements Convertable {

    private RestPhoenixEEMResponseTariffNumberRestType tn1;
    private RestPhoenixEEMResponseTariffNumberRestType tn2;

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public RestPhoenixRwEEMMixedRestType() {
    }

    /**
     * Returns the value of tn1.
     *
     * @return the value of tn1
     */
    public RestPhoenixEEMResponseTariffNumberRestType getTn1() {
        return tn1;
    }

    /**
     * Changes the value of tn1.
     *
     * @param value the new value
     */
    public void setTn1(RestPhoenixEEMResponseTariffNumberRestType value) {
        this.tn1 = value;
    }

    /**
     * Returns the value of tn2.
     *
     * @return the value of tn2
     */
    public RestPhoenixEEMResponseTariffNumberRestType getTn2() {
        return tn2;
    }

    /**
     * Changes the value of tn2.
     *
     * @param value the new value
     */
    public void setTn2(RestPhoenixEEMResponseTariffNumberRestType value) {
        this.tn2 = value;
    }

    @Override
    public Object fromREST(Object data) {
        Object result = data;
        if (data instanceof RestPhoenixRwEEMMixedRestType) {
            result = fromRESTImpl((RestPhoenixRwEEMMixedRestType) data);
        } else if (data instanceof RestPhoenixRwEEMMixedRestType[]) {
            result = fromRESTImpl((RestPhoenixRwEEMMixedRestType[]) data);
        }
        return result;
    }

    /**
     * Implements the conversion from the corresponding REST type.
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixRwEEMMixed fromRESTImpl(RestPhoenixRwEEMMixedRestType orig) {
        RestPhoenixRwEEMMixed result = new RestPhoenixRwEEMMixedImpl();
        result.setTn1(RestPhoenixEEMResponseTariffNumberRestType.fromRESTImpl(orig.getTn1()));
        result.setTn2(RestPhoenixEEMResponseTariffNumberRestType.fromRESTImpl(orig.getTn2()));
        return result;
    }

    /**
     * Implements the conversion from the corresponding REST type array.
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixRwEEMMixed[] fromRESTImpl(RestPhoenixRwEEMMixedRestType[] orig) {
        RestPhoenixRwEEMMixed[] result = null;
        if (orig != null) {
            result = new RestPhoenixRwEEMMixed[orig.length];
            for (int i = 0; i < orig.length; i++) {
                result[i] = fromRESTImpl(orig[i]);
            }
        }
        return result;
    }

    @Override
    public Object toREST(Object data) {
        Object result = data;
        if (data instanceof RestPhoenixRwEEMMixed) {
            result = toRESTImpl((RestPhoenixRwEEMMixed) data);
        } else if (data instanceof RestPhoenixRwEEMMixed[]) {
            result = toRESTImpl((RestPhoenixRwEEMMixed[]) data);
        }
        return result;
    }

    /**
     * Implements the conversion from the transport type to REST
     *
     * @param orig the original value
     * @return the converted instance
     */
    public static RestPhoenixRwEEMMixedRestType[] toRESTImpl(RestPhoenixRwEEMMixed[] orig) {
        RestPhoenixRwEEMMixedRestType[] result = null;
        if (orig != null) {
            result = new RestPhoenixRwEEMMixedRestType[orig.length];
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
    public static RestPhoenixRwEEMMixedRestType toRESTImpl(RestPhoenixRwEEMMixed orig) {
        RestPhoenixRwEEMMixedRestType result = new RestPhoenixRwEEMMixedRestType();
        result.setTn1(RestPhoenixEEMResponseTariffNumberRestType.toRESTImpl(orig.getTn1()));
        result.setTn2(RestPhoenixEEMResponseTariffNumberRestType.toRESTImpl(orig.getTn2()));
        return result;
    }

}
