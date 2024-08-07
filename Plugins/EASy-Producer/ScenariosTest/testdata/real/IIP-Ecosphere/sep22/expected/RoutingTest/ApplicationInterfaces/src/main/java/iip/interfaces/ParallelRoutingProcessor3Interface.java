package iip.interfaces;

import de.iip_ecosphere.platform.services.environment.*;
import iip.datatypes.*;

/**
 * IIP-Ecosphere service interface for 'ParallelRoutingProcessor3'.
 * Generated by: EASy-Producer.
 */
public interface ParallelRoutingProcessor3Interface extends Service {

    public static final String SERVICE_ID = "ParallelRoutingProcessor3";

    /**
     * Processes/transforms a data item of type "RoutingTestData" synchronously.
     *
     * @param data the data item to be processed
     * @return the result of processing
     */
    public RoutingTestData transformRoutingTestData(RoutingTestData data);/**
     * Processes a data item of type "RoutingCommand" asynchronously. Use the respective ingestor for the return
     * type to pass back the result of processing.
     *
     * @param data the data item to be processed
     */
    public void processRoutingCommand(RoutingCommand data);
    
    
}
