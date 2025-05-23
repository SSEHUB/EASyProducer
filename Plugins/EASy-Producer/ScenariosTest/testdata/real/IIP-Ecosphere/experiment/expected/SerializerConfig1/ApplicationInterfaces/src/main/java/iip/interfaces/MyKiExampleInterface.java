package iip.interfaces;

import de.iip_ecosphere.platform.services.environment.Service;

import iip.datatypes.Rec1;
import iip.datatypes.RtsaTestInput;

/**
 * IIP-Ecosphere service interface for 'myKi example'.
 * Generated by: EASy-Producer.
 */
public interface MyKiExampleInterface extends Service {

    public static final String SERVICE_ID = "myKi";

    /**
     * Processes/transforms a data item of type "Rec1" synchronously.
     *
     * @param data the data item to be processed
     * @return the result of processing (must not be <b>null</b>)
     */
    public RtsaTestInput transformRec1(Rec1 data);

}
