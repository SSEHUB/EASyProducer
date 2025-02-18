package iip.interfaces;

import de.iip_ecosphere.platform.services.environment.DataIngestor;
import de.iip_ecosphere.platform.services.environment.Service;

/**
 * IIP-Ecosphere service interface for net node 'mySource example'.
 * Generated by: EASy-Producer.
 */
public interface MySourceExampleService extends Service {
    
    /**
     * Called by the platform to attach an asynchronous data ingestor for type "String".
     *
     * @param ingestor the "String" ingestor instance
     */
     public void attachcreateString_mySourceIngestor(DataIngestor<String> ingestor);

}
