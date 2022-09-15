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
 * Spring Cloud Stream service frame for net node 'myRoutingSource'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.myRoutingSource", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class MyRoutingSource extends SpringAsyncServiceBase {

    @Value("${iip.service.myRoutingSource:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private MyRoutingSourceInterface service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private io.micrometer.core.instrument.Timer processingTime;

     /**
     * Creates an instance.
     */
    public MyRoutingSource() {
        service = AbstractService.createInstance("de.iip_ecosphere.platform.test.apps.serviceImpl.routingTest.SourceImpl", 
            MyRoutingSourceInterface.class, 
            "myRoutingSource", 
            "deployment.yml");
        
    }

    /**
    * Called when data arrived that shall be processed (asynchronously).
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<RoutingCommand> processRoutingCommand_myRoutingSource() {
        return data -> {
        MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
        processingTime.record(() -> service.processRoutingCommand(data)); 
        };
    }    /**
        * Creates data to be ingested.
        *
        * @return the data supplier functor
        */
        @Bean
        public Supplier<RoutingTestData> createRoutingTestData_myRoutingSource() {
            return () -> {
            MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
            return service.produceRoutingTestData(); 
        }; 
                    }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service myRoutingSource: {}", activated);
            serviceSent = Counter.builder("service.sent")
                .baseUnit("tuple/s")
                .description("Tuples sent out by a service")
                .tags("service", "myRoutingSource", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            serviceReceived = Counter.builder("service.received")
                .baseUnit("tuple/s")
                .description("Tuples received by a service")
                .tags("service", "myRoutingSource", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            processingTime = io.micrometer.core.instrument.Timer.builder("service.processed")
                .description("Main processing time of a service")
                .tags("service", "myRoutingSource", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
                MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            
            createReceptionCallback("RoutingSink_RoutingCommand", processRoutingCommand_myRoutingSource(), RoutingCommand.class, "processRoutingCommand_myRoutingSource-in-0");
        }
    }
    
    
}
