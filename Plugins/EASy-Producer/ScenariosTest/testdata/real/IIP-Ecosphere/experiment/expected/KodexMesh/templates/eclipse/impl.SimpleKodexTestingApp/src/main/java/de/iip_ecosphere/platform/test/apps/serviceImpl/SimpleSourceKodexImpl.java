package de.iip_ecosphere.platform.test.apps.serviceImpl;

import java.io.InputStream;

import de.iip_ecosphere.platform.services.environment.ServiceKind;

import iip.datatypes.KRec13;
import iip.datatypes.KRec13Impl;
import iip.impl.SimpleKodexDataSourceImpl;

/**
 * Service implementation for net node 'Simple Kodex Data Source'.
 * Generated by: EASy-Producer.
 */
public class SimpleSourceKodexImpl extends SimpleKodexDataSourceImpl {

    /**
    * Fallback constructor, also used for testing main program.
    */
    public SimpleSourceKodexImpl() {
        super(ServiceKind.SOURCE_SERVICE);
    }

    /**
    * Creates a service instance from a service id and a YAML artifact.
    * 
    * @param serviceId the service id
    * @param ymlFile the YML file containing the YAML artifact with the service descriptor
    */
    public SimpleSourceKodexImpl(String serviceId, InputStream ymlFile) {
        super(serviceId, ymlFile);
    }

    @Override
    public KRec13 produceKRec13() {
        KRec13 result = new KRec13Impl();
        // TODO add your code here
        return result;
    }

}
