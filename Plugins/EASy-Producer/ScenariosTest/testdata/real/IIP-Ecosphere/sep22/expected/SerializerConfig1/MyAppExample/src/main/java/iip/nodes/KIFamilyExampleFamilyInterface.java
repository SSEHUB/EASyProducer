package iip.nodes;

import java.util.function.*;
import iip.datatypes.*;
import iip.interfaces.*;
import java.util.concurrent.ExecutionException;
import de.iip_ecosphere.platform.services.environment.switching.ServiceSelector;
import de.iip_ecosphere.platform.services.environment.*;
import de.iip_ecosphere.platform.services.environment.switching.*;

/**
 * Family Interface for a Spring Cloud Stream service for 'KI family example'.
 *
 * @author EASy-Producer.
 */
public interface KIFamilyExampleFamilyInterface extends ServiceBase {

    /**
    * Called when data arrived that shall be processed (synchronously).
    *
    * @return the data transformation functor
    */
    public Function<Rec1, RtsaTestInput> transformRec1RtsaTestInput_myKiFamily();

    /**
     * Initializes the service instance. Please execute resource-intensive or time-intensive calls here.
     */
    public void initService();
    
    /**
     * Changes the state. [R133c]
     * 
     * @param state the new state
     * @throws ExecutionException if changing the state fails for some reason
     */
    public void setState(ServiceState state) throws ExecutionException;
    
    /**
     * Detaches the service. Opposite of {@link #initService()}.
     */
    public void detach();
    
}
