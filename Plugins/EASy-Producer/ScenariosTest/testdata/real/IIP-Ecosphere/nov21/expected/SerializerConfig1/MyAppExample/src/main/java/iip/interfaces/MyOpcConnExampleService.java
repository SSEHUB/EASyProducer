package iip.interfaces;

import de.iip_ecosphere.platform.services.environment.*;
import iip.datatypes.*;

/**
 * IIP-Ecosphere service interface for net node 'myOpcConn example'.
 * Generated by: EASy-Producer.
 */
public interface MyOpcConnExampleService extends Service {
    
    

    /**
                 * Called by the platform to attach an asynchronous data ingestor for type "String".
                 *
                 * @param ingestor the "String" ingestor instance
                 */
                 public abstract void attachcreateString_myOpcConnIngestor(DataIngestor<String> ingestor);        
}