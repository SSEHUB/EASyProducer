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

/**
 * Spring Cloud Stream service frame for net node 'RoutingProcessor'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.RoutingProcessor", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class RoutingProcessor extends SpringAsyncServiceBase {

    @Value("${iip.service.RoutingProcessor:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private RoutingProcessorInterface service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private io.micrometer.core.instrument.Timer processingTime;

     /**
     * Creates an instance.
     */
    public RoutingProcessor() {
        service = AbstractService.createInstance("de.iip_ecosphere.platform.test.apps.serviceImpl.routingTest.ProcessorImpl", 
            RoutingProcessorInterface.class, 
            "RoutingProcessor", 
            "deployment.yml");
        
    }

    /**
    * Called when data arrived that shall be processed (asynchronously).
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<RoutingTestData> processRoutingTestData_RoutingProcessor() {
        return data -> {
        MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
        processingTime.record(() -> service.processRoutingTestData(data)); 
        };
    }    /**
        * Called when data arrived that shall be processed (asynchronously).
        *
        * @return the data consumer functor
        */
        @Bean
        public Consumer<RoutingConnOut> processRoutingConnOut_RoutingProcessor() {
            return data -> {
            MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
            processingTime.record(() -> service.processRoutingConnOut(data)); 
            };
        }    /**
        * Called when data arrived that shall be processed (asynchronously).
        *
        * @return the data consumer functor
        */
        @Bean
        public Consumer<RoutingCommand> processRoutingCommand_RoutingProcessor() {
            return data -> {
            MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
            processingTime.record(() -> service.processRoutingCommand(data)); 
            };
        }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service RoutingProcessor: {}", activated);
            serviceSent = Counter.builder("service.sent")
                .baseUnit("tuple/s")
                .description("Tuples sent out by a service")
                .tags("service", "RoutingProcessor", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            serviceReceived = Counter.builder("service.received")
                .baseUnit("tuple/s")
                .description("Tuples received by a service")
                .tags("service", "RoutingProcessor", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            processingTime = io.micrometer.core.instrument.Timer.builder("service.processed")
                .description("Main processing time of a service")
                .tags("service", "RoutingProcessor", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
                MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            
            service.attachRoutingTestDataIngestor(data -> {
                MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
                SerializerMessageConverter.serializeAndSend(streamBridge, "transformRoutingTestDataRoutingTestData_ParallelRoutingProcessor3-in-0", data);; 
            });
            service.attachRoutingTestDataIngestor(data -> {
                MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
                Transport.send(c -> c.asyncSend("RoutingProcessor_RoutingTestData", data), "RoutingProcessor", "processRoutingTestData_ParallelRoutingProcessor1-in-0", "processRoutingTestData_ParallelRoutingProcessor2-in-0"); 
            });
            createReceptionCallback("myRoutingConnector_RoutingConnOut", processRoutingConnOut_RoutingProcessor(), RoutingConnOut.class, "processRoutingConnOut_RoutingProcessor-in-0");
            createReceptionCallback("RoutingSink_RoutingCommand", processRoutingCommand_RoutingProcessor(), RoutingCommand.class, "processRoutingCommand_RoutingProcessor-in-0");
        }
    }
    
    
}
