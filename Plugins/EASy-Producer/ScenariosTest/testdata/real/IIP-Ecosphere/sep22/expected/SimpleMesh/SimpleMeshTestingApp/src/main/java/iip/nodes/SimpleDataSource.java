package iip.nodes;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;
import javax.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import io.micrometer.core.instrument.*;
import static de.iip_ecosphere.platform.support.function.IOVoidFunction.optional;
import de.iip_ecosphere.platform.support.identities.*;
import de.iip_ecosphere.platform.support.resources.*;
import de.iip_ecosphere.platform.support.iip_aas.Id;
import de.iip_ecosphere.platform.transport.Transport;
import de.iip_ecosphere.platform.transport.status.TraceRecord;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.transport.connectors.*;
import de.iip_ecosphere.platform.transport.spring.SerializerMessageConverter;
import de.iip_ecosphere.platform.services.environment.switching.ServiceSelector;
import de.iip_ecosphere.platform.services.environment.*;
import de.iip_ecosphere.platform.services.environment.switching.*;
import de.iip_ecosphere.platform.services.environment.metricsProvider.MonitoredTranslatingProtocolAdapter;
import de.iip_ecosphere.platform.services.environment.spring.Starter;
import de.iip_ecosphere.platform.services.environment.spring.SpringAsyncServiceBase;
import de.iip_ecosphere.platform.services.environment.spring.metricsProvider.MetricsProvider;
import de.iip_ecosphere.platform.connectors.ConnectorParameter;
import de.iip_ecosphere.platform.connectors.ConnectorParameter.CacheMode;
import de.iip_ecosphere.platform.connectors.types.*;
import de.iip_ecosphere.platform.connectors.model.*;
import iip.datatypes.*;
import iip.interfaces.*;
import iip.serializers.*;
import reactor.core.publisher.Flux;

/**
 * Spring Cloud Stream service frame for net node 'Simple Data Source'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.SimpleSource", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class SimpleDataSource extends SpringAsyncServiceBase {

    @Value("${iip.service.SimpleSource:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private SimpleDataSourceInterface service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private io.micrometer.core.instrument.Timer processingTime;

     /**
     * Creates an instance.
     */
    public SimpleDataSource() {
        service = AbstractService.createInstance("de.iip_ecosphere.platform.test.apps.serviceImpl.SimpleSourceImpl", 
            SimpleDataSourceInterface.class, 
            "SimpleSource", 
            "deployment.yml");
        
    }

    /**
    * Creates data to be ingested.
    *
    * @return the data supplier functor
    */
    @Bean
    public Supplier<Flux<Rec1>> createRec1_SimpleSource() {
        // this is no real use of flux, but ensures that method is called only once to set the ingestor
        // when the mesh element is really active
        return () -> Flux.from(emitter -> {
            // empty emitter, else duplicates the effort of #28
        });
    }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service SimpleSource: {}", activated);
            serviceSent = Counter.builder("service.sent")
                .baseUnit("tuple/s")
                .description("Tuples sent out by a service")
                .tags("service", "SimpleSource", "application", "SimpleMeshApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            serviceReceived = Counter.builder("service.received")
                .baseUnit("tuple/s")
                .description("Tuples received by a service")
                .tags("service", "SimpleSource", "application", "SimpleMeshApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            processingTime = io.micrometer.core.instrument.Timer.builder("service.processed")
                .description("Main processing time of a service")
                .tags("service", "SimpleSource", "application", "SimpleMeshApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
                MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            
            service.attachRec1Ingestor(data -> {
                MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
                Transport.send(c -> c.asyncSend("SimpleSource_Rec1", data), "SimpleSource", "receiveRec1_SimpleReceiver-in-0"); 
            });
        }
    }
    
    
}
