package MySourceImpl;

import java.util.concurrent.ExecutionException;
import de.iip_ecosphere.platform.services.environment.*;
import iip.datatypes.*;

import org.slf4j.LoggerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * IIP-Ecosphere service jUnit test for 'mySource example'.
 * Generated by: EASy-Producer.
 */
public class MySourceImplTest {

    private MySourceImpl service;


    /**
     * Initializes the test.
     */
    @Before
    public void startup() {
        service = new MySourceImpl(); // constructor for testing, does not set up service management values!
        service.attachStringIngestor(d -> {
            // called when results from asynchronous service processing occurs 
            Assert.assertNotNull(d); // contract, see platform handbook            
            // TODO add assert here or collect results and assert in test
        });
        
        try {
            service.setState(ServiceState.STARTING);
        } catch (ExecutionException e) {
            LoggerFactory.getLogger(getClass()).error("Cannot start service: {}", e);
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
            LoggerFactory.getLogger(getClass()).error("Cannot stop service: {}", e);
        }
    }
    
}