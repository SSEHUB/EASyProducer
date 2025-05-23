package iip.interfaces;

import de.iip_ecosphere.platform.services.environment.Service;

import iip.datatypes.KRec13Anon;

/**
 * IIP-Ecosphere service interface for 'Kodex Data Receiver'.
 * Generated by: EASy-Producer.
 */
public interface KodexDataReceiverInterface extends Service {

    public static final String SERVICE_ID = "KodexReceiver";

    /**
     * Processes a data item of type "KRec13Anon" asynchronously. Use the respective ingestor for the return type to pass
     * back the result of processing.
     *
     * @param data the data item to be processed
     */
    public void processKRec13Anon(KRec13Anon data);

}
