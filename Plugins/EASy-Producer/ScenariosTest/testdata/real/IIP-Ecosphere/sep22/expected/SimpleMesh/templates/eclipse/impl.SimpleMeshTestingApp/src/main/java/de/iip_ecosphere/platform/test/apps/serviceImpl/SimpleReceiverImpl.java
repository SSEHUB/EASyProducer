package de.iip_ecosphere.platform.test.apps.serviceImpl;

import java.io.*;        
import de.iip_ecosphere.platform.services.environment.*;
import iip.datatypes.*;
import iip.impl.*;

/**
 * Service implementation for net node 'Simple Data Receiver'.
 * Generated by: EASy-Producer.
 */
public class SimpleReceiverImpl extends SimpleDataReceiverImpl {

    /**
    * Fallback constructor, also used for testing main program.
    */
    public SimpleReceiverImpl() {
        super(ServiceKind.SINK_SERVICE);
    }

    /**
    * Creates a service instance from a service id and a YAML artifact.
    * 
    * @param serviceId the service id
    * @param ymlFile the YML file containing the YAML artifact with the service descriptor
    */
    public SimpleReceiverImpl(String serviceId, InputStream ymlFile) {
        super(serviceId, ymlFile);
    }

    @Override
    public void processRec1(Rec1 data) {
        // TODO call ingest<Type>(instance)
    }
        
    
}
