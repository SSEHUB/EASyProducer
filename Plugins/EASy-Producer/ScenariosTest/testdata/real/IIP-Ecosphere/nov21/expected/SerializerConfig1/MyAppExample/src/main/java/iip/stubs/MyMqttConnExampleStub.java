package iip.stubs;

import de.iip_ecosphere.platform.services.environment.*;
import de.iip_ecosphere.platform.support.aas.InvocablesCreator;
import iip.datatypes.*;
import iip.interfaces.*;

/**
 * IIP-Ecosphere service stub for net node 'myMqttConnExample'.
 * Generated by: EASy-Producer.
 */
public class MyMqttConnExampleStub extends ServiceStub implements MyMqttConnExampleService {

    /**
     * Creates the setup and registers the operations.
     * 
     * @param iCreator the AAS invocables creator
     * @param serviceId the service id to create the qualified names via {@link ServiceMapper#getQName(Service, String)}
     */
    public MyMqttConnExampleStub(InvocablesCreator iCreator, String serviceId) {
        super(iCreator, serviceId);
    }
    
    

    @Override
                 public void attachcreateString_myMqttConnIngestor(DataIngestor<String> ingestor) {
     // TODO clarify with Python
                 }
}
