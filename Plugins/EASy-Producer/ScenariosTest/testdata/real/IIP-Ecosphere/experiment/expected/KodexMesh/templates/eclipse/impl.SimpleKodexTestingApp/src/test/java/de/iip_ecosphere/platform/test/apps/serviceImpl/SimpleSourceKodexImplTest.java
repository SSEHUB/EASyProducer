package de.iip_ecosphere.platform.test.apps.serviceImpl;

import java.util.concurrent.ExecutionException;

import de.iip_ecosphere.platform.services.environment.ServiceState;
import de.iip_ecosphere.platform.test.apps.serviceImpl.SimpleSourceKodexImpl;

import iip.datatypes.KRec13;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * IIP-Ecosphere service jUnit test for 'Simple Kodex Data Source'.
 * Generated by: EASy-Producer.
 */
public class SimpleSourceKodexImplTest {

    private SimpleSourceKodexImpl service;

    /**
     * Synchronous source method, called to produce data items of type "KRec13".
     */
    @Test
    public void testProduceKRec13() {
        KRec13 res = service.produceKRec13();
        Assert.assertNotNull(res);
        // TODO assert fields of res
    }

    /**
     * Initializes the test.
     */
    @Before
    public void startup() {
        // constructor for testing, does not set up service management values!
        service = new SimpleSourceKodexImpl();        
        try {
            service.setState(ServiceState.STARTING);
        } catch (ExecutionException e) {
            LoggerFactory.getLogger(getClass())
                .error("Cannot start service: {}", e);
        }
    }

    /**
     * Shuts down the test.
     */
    @After
    public void shutdown() {
        try {
            service.setState(ServiceState.STOPPING);
        } catch (ExecutionException e) {
            LoggerFactory.getLogger(getClass())
                .error("Cannot stop service: {}", e);
        }
    }

}
