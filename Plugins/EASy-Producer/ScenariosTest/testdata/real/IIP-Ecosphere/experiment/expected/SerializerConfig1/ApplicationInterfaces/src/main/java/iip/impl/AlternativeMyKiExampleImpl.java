

package iip.impl;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.io.InputStream;
import de.iip_ecosphere.platform.transport.serialization.TypeTranslators;
import de.iip_ecosphere.platform.services.environment.*;
import iip.datatypes.*;
import iip.interfaces.*;

/**
 * IIP-Ecosphere supporting service implementation for 'Alternative myKi example'.
 * Generated by: EASy-Producer.
 */
public abstract class AlternativeMyKiExampleImpl extends DefaultServiceImpl implements AlternativeMyKiExampleInterface {


    private int threshold = 15;            private Map<String, ParameterConfigurer<?>> paramConfigurers = new HashMap<>();

    /**
     * Fallback constructor setting most fields to "empty" default values.
     * 
     * @param kind the service kind
     */
    protected AlternativeMyKiExampleImpl(ServiceKind kind) {
        super(kind);
        registerParameterConfigurers();
    }

    /**
     * Fallback constructor setting most fields to "empty" default values.
     * 
     * @param id the id of the service
     * @param kind the service kind
     */
    protected AlternativeMyKiExampleImpl(String id, ServiceKind kind) {
        super(id, kind);
        registerParameterConfigurers();
    }

    /**
    * Creates a service instance from YAML information.
    * 
    * @param yaml the service information as read from YAML
    */
    protected AlternativeMyKiExampleImpl(YamlService yaml) {
        super(yaml);
        registerParameterConfigurers();
    }
    
    /**
    * Creates a service instance from a service id and a YAML artifact.
    * 
    * @param serviceId the service id
    * @param ymlFile the YML file containing the YAML artifact with the service descriptor
    */
    protected AlternativeMyKiExampleImpl(String serviceId, InputStream ymlFile) {
        super(serviceId, ymlFile);
        registerParameterConfigurers();
    }
    
    @Override
    public ParameterConfigurer<?> getParameterConfigurer(String paramName) {
        return paramConfigurers.get(paramName);
    }
    
    @Override
    public Set<String> getParameterNames() {
        return paramConfigurers.keySet();
    }
    
    /**
    * Registers the configurers.
    */
    protected void registerParameterConfigurers() {
        AbstractService.addConfigurer(paramConfigurers, "threshold", Integer.class, TypeTranslators.INTEGER, v -> setParameterThreshold(v), () -> getParameterThreshold());
    }

    /**
    * Changes the service parameter "threshold".
    *
    * @param threshold the parameter value
    * @throws ExecutionException if setting the value fails, e.g., as the service is in the wrong state such as 
    *    startup vs. runtime
    */
    public void setParameterThreshold(int threshold) throws ExecutionException {
        this.threshold = threshold;
    }
    /**
    * Returns the service parameter "threshold".
    *
    * @return the value of the parameter
    */
    public int getParameterThreshold() {
        return this.threshold;
    }
                
}