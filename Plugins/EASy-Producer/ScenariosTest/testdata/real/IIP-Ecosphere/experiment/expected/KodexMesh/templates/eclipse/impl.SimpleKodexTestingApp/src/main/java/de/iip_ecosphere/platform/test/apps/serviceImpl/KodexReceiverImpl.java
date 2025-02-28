package de.iip_ecosphere.platform.test.apps.serviceImpl;

import java.io.InputStream;

import de.iip_ecosphere.platform.services.environment.ServiceKind;

import iip.datatypes.KRec13Anon;
import iip.impl.KodexDataReceiverImpl;

/**
 * Service implementation for net node 'Kodex Data Receiver'.
 * Generated by: EASy-Producer.
 */
public class KodexReceiverImpl extends KodexDataReceiverImpl {

    /**
    * Fallback constructor, also used for testing main program.
    */
    public KodexReceiverImpl() {
        super(ServiceKind.SINK_SERVICE);
    }

    /**
    * Creates a service instance from a service id and a YAML artifact.
    * 
    * @param serviceId the service id
    * @param ymlFile the YML file containing the YAML artifact with the service descriptor
    */
    public KodexReceiverImpl(String serviceId, InputStream ymlFile) {
        super(serviceId, ymlFile);
    }

    @Override
    public void processKRec13Anon(KRec13Anon data) {
        // TODO Store, emit, pass on your data here. This is the sink.
    }

}
