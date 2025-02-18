package de.iip_ecosphere.platform.test.apps.serviceImpl;

import java.util.concurrent.ExecutionException;

import de.iip_ecosphere.platform.services.environment.ServiceState;
import de.iip_ecosphere.platform.test.apps.serviceImpl.KodexReceiverImpl;

import iip.datatypes.KRec13Anon;
import iip.datatypes.KRec13AnonImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * IIP-Ecosphere service jUnit test for 'Kodex Data Receiver'.
 * Generated by: EASy-Producer.
 */
public class KodexReceiverImplTest {

    private KodexReceiverImpl service;

    /**
     * Tests processing a data item of type "KRec13Anon" asynchronously.
     */
    @Test
    public void testProcessKRec13Anon() {
        KRec13Anon data = new KRec13AnonImpl();
        // TODO fill data via setters
        service.processKRec13Anon(data);
        // no direct output for a sink. may be it's generating a log, a file, etc. to assert
    }    /**
     * Initializes the test.
     */
    @Before
    public void startup() {
        // constructor for testing, does not set up service management values!
        service = new KodexReceiverImpl();         try {
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