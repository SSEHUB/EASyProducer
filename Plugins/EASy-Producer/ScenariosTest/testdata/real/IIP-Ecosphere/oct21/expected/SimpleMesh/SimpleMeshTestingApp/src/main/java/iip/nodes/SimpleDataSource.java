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
 * Spring Cloud Stream service frame for net node 'Simple Data Source'.
 * Generated by: EASy-Producer.
 */
@Component
@EnableScheduling
public class SimpleDataSource {

    @Autowired
    private StreamBridge streamBridge;
    private SimpleDataSourceService service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    @SuppressWarnings("unused")
    private MetricsProvider metrics;

    /**
     * Creates an instance.
     */
    public SimpleDataSource() {
        service = AbstractService.createInstance("de.iip_ecosphere.platform.test.apps.serviceImpl.SimpleSourceImpl", SimpleDataSourceService.class, "SimpleSource", "/deployment.yml");
        Starter.mapService(service);
    }

    
    

    /**
     * Attaches the ingestors.
     */
    @PostConstruct 
    public void attachIngestors() {
        service.attachcreateRec1_SimpleSourceIngestor(data -> SerializerMessageConverter.serializeAndSend(streamBridge, "createRec1_SimpleSource-in-0", data));
    }
    
    
}