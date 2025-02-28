package iip.interfaces;

import de.iip_ecosphere.platform.services.environment.Service;

import iip.datatypes.Rec1;
import iip.datatypes.RtsaTestInput;

/**
 * IIP-Ecosphere service interface for 'KI family example'.
 * Generated by: EASy-Producer.
 */
public interface KIFamilyExampleInterface extends Service {

    public static final String SERVICE_ID = "myKiFamily";
    public static final String MEMBER_MYKI = "myKi";
    public static final String MEMBER_MYKI2 = "myKi2";

    /**
     * Processes/transforms a data item of type "Rec1" synchronously.
     *
     * @param data the data item to be processed
     * @return the result of processing (must not be <b>null</b>)
     */
    public RtsaTestInput transformRec1(Rec1 data);

}
