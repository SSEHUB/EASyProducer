package iip.nodes;

import java.io.IOException;
import java.util.function.*;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.transport.connectors.ReceptionCallback;
import de.iip_ecosphere.platform.transport.spring.SerializerMessageConverter;
import de.iip_ecosphere.platform.services.environment.*;
import de.iip_ecosphere.platform.services.environment.spring.Starter;
import de.iip_ecosphere.platform.services.environment.spring.metricsProvider.MetricsProvider;
import de.iip_ecosphere.platform.connectors.ConnectorParameter;
import de.iip_ecosphere.platform.connectors.types.*;
import iip.datatypes.*;
import iip.interfaces.*;
import iip.stubs.*;

/**
 * Spring Cloud Stream service frame for net node 'Simple Data Receiver3'.
 * Generated by: EASy-Producer.
 */
@Component
@EnableScheduling
public class SimpleDataReceiver3 {

    @Autowired
    private StreamBridge streamBridge;
    private SimpleDataReceiver3Service service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    @SuppressWarnings("unused")
    private MetricsProvider metrics;

    /**
     * Creates an instance.
     */
    public SimpleDataReceiver3() {
        service = AbstractService.createInstance("de.iip_ecosphere.platform.test.apps.serviceImpl.SimpleReceiver3Impl", SimpleDataReceiver3Service.class, "SimpleReceiver3", "/deployment.yml");
        Starter.mapService(service);
    }

    /**
    * Called when data arrived that shall be received (data sink).
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<Rec13> receiveRec13_SimpleReceiver3() {
        return data -> service.receiveRec13(data);
    }
    

    /**
     * Attaches the ingestors.
     */
    @PostConstruct 
    public void attachIngestors() {
    
    
}