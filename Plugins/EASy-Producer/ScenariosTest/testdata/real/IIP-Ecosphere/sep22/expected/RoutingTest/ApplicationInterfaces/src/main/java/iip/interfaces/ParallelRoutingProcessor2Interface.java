package iip.interfaces;

import de.iip_ecosphere.platform.services.environment.*;
import iip.datatypes.*;

/**
 * IIP-Ecosphere service interface for 'ParallelRoutingProcessor2'.
 * Generated by: EASy-Producer.
 */
public interface ParallelRoutingProcessor2Interface extends Service {

    public static final String SERVICE_ID = "ParallelRoutingProcessor2";

    /**
     * Processes a data item of type "RoutingTestData" asynchronously. Use the respective ingestor for the return
     * type to pass back the result of processing.
     *
     * @param data the data item to be processed
     */
    public void processRoutingTestData(RoutingTestData data);
    /**
     * Processes a data item of type "RoutingCommand" asynchronously. Use the respective ingestor for the return
     * type to pass back the result of processing.
     *
     * @param data the data item to be processed
     */
    public void processRoutingCommand(RoutingCommand data);
    /**
     * Attaches a return value ingestor for asynchronous processing.
     *
     * @param ingestor the ingestor instance
     */
    public void attachRoutingTestDataIngestor(DataIngestor<RoutingTestData> ingestor);
    
}
