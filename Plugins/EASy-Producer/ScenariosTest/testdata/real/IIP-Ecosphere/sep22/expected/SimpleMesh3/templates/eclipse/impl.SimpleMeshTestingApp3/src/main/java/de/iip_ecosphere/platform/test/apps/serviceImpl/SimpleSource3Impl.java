package de.iip_ecosphere.platform.test.apps.serviceImpl;

import java.io.*;        
import de.iip_ecosphere.platform.services.environment.*;
import iip.datatypes.*;
import iip.impl.*;

/**
 * Service implementation for net node 'Simple Data Source3'.
 * Generated by: EASy-Producer.
 */
public class SimpleSource3Impl extends SimpleDataSource3Impl {

    /**
    * Fallback constructor, also used for testing main program.
    */
    public SimpleSource3Impl() {
        super(ServiceKind.SOURCE_SERVICE);
    }

    /**
    * Creates a service instance from a service id and a YAML artifact.
    * 
    * @param serviceId the service id
    * @param ymlFile the YML file containing the YAML artifact with the service descriptor
    */
    public SimpleSource3Impl(String serviceId, InputStream ymlFile) {
        super(serviceId, ymlFile);
    }

    
    
    @Override
    public Rec13 produceRec13() {
        Rec13 result = new Rec13Impl();
        // TODO add your code here
        return result;
    }
    
    
}
