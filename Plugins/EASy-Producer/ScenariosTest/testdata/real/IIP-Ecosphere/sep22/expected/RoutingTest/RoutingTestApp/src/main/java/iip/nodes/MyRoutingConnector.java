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
import de.iip_ecosphere.platform.connectors.events.*;

/**
 * Spring Cloud Stream service frame for net node 'myRoutingConnector'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.myRoutingConnector", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class MyRoutingConnector extends SpringAsyncServiceBase {

    @Value("${iip.service.myRoutingConnector:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private ConnectorServiceWrapper<Object, Object, RoutingConnOut, RoutingConnIn> service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private io.micrometer.core.instrument.Timer processingTime;
    private ConnectorInputHandler<RoutingCommand> routingCommandHandler = ConnectorEventUtils.createInputHandlerInstance(
        MyRoutingConnector.class.getClassLoader(), 
        "de.iip_ecosphere.platform.test.apps.serviceImpl.routingTest.ConnectorCommandEventHandler", RoutingCommand.class);

     /**
     * Creates an instance.
     */
    public MyRoutingConnector() {
        de.iip_ecosphere.platform.test.apps.serviceImpl.routingTest.ConnectorImpl<RoutingConnOut, RoutingConnIn> conn = 
            new de.iip_ecosphere.platform.test.apps.serviceImpl.routingTest.ConnectorImpl<>(createConnectorAdapter());
        conn.enablePolling(false); // independent of notifications, disable as @Autowired may not be
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader
            .getResourceAsStream("deployment.yml"));
        YamlService serviceData = art.getServiceSafe("myRoutingConnector"); 
        service = new ConnectorServiceWrapper<Object, Object, RoutingConnOut, RoutingConnIn>(serviceData, conn, 
            () -> createConnectorParameter());
        service.setReceptionCallback(new ConnectorReceptionCallback());
    }

    /**
    * Creates the connector adapter. [public for testing]
    *
    * @return the connector adapter
    */
    public static TranslatingProtocolAdapter<Object, Object, RoutingConnOut, RoutingConnIn> createConnectorAdapter() {
        return createConnectorAdapter(null, null);
    }
    
    /**
    * Creates the connector adapter. [public for testing]
    *
    * @param metrics the metrics provider to use, <b>null</b> for no metric measurements
    * @param log the log file to use to record individual measurements in experiments, <b>null</b> for no logging.
    *      Only becomes active if {@code metrics} is not <b>null</b>
    * @return the connector adapter
    */
    public static TranslatingProtocolAdapter<Object, Object, RoutingConnOut, RoutingConnIn> createConnectorAdapter(
        de.iip_ecosphere.platform.services.environment.metricsProvider.MetricsProvider metrics, File log) {
        TranslatingProtocolAdapter<Object, Object, RoutingConnOut, RoutingConnIn> adapter;
        if (metrics != null) {
            adapter = new MonitoredTranslatingProtocolAdapter<Object, Object, RoutingConnOut, RoutingConnIn>(
                new MachineOutputTranslator(), 
                new MachineInputTranslator(), 
                metrics, log);
        } else {
            adapter = new TranslatingProtocolAdapter<Object, Object, RoutingConnOut, RoutingConnIn>(
                new MachineOutputTranslator(), 
                new MachineInputTranslator());
        };
        return adapter;
    }
    /**
    * Called when data arrived that shall be passed on to the connector.
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<RoutingConnIn> createRoutingConnIn_myRoutingConnector() {
        return data -> {
    MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
    processingTime.record(() -> service.send(data)); 
    };
    }
    /**
    * Called when data arrived that shall be passed on to the connector.
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<RoutingCommand> processRoutingCommand_myRoutingConnector() {
        return data -> {
    MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
    processingTime.record(() -> handleRoutingCommand(service, data)); 
    };
    }
    
    /**
    * Creates the connector parameter instance. [public for testing]
    *
    * @return the instance to be passed to the connector
    */
    public static ConnectorParameter createConnectorParameter() {
        return ConnectorParameter.ConnectorParameterBuilder
            .newBuilder("localhost", 1234)
            .setApplicationInformation("RoutingTestApp", "")
            .setCacheMode(CacheMode.NONE)
            .setNotificationInterval(500)
            .build();
    }

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service myRoutingConnector: {}", activated);
            serviceSent = Counter.builder("service.sent")
                .baseUnit("tuple/s")
                .description("Tuples sent out by a service")
                .tags("service", "myRoutingConnector", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            serviceReceived = Counter.builder("service.received")
                .baseUnit("tuple/s")
                .description("Tuples received by a service")
                .tags("service", "myRoutingConnector", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            processingTime = io.micrometer.core.instrument.Timer.builder("service.processed")
                .description("Main processing time of a service")
                .tags("service", "myRoutingConnector", "application", "RoutingTestApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
                MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            service.enablePolling(true); // if notifications enabled, enable now also polling as @Autowired is done
            createReceptionCallback("RoutingSink_RoutingCommand", processRoutingCommand_myRoutingConnector(), RoutingCommand.class, "processRoutingCommand_myRoutingConnector-in-0");
        }
    }
    

private static class MachineInputTranslator extends AbstractConnectorInputTypeTranslator<RoutingConnIn, Object> {
    
    @Override
    public Object from(RoutingConnIn data) throws IOException {
        ModelAccess access = getModelAccess();
        ModelInputConverter inConverter = access.getInputConverter();
        ModelOutputConverter outConverter = access.getOutputConverter();
        access.set("intField", outConverter.fromInteger(data.getIntField()));
            
                    return null; // done, no instance of pseudo type
                }
            
                @Override
                public Class<? extends Object> getSourceType() {
                    return Object.class;
                }
            
                @Override
                public Class<? extends RoutingConnIn> getTargetType() {
                    return RoutingConnIn.class;
                }
            
            }
            
            private static class MachineOutputTranslator extends AbstractConnectorOutputTypeTranslator<Object, RoutingConnOut> {
                    
            @Override
            public RoutingConnOut to(Object source) throws IOException {
                ModelAccess access = getModelAccess();
                ModelInputConverter inConverter = access.getInputConverter();
                ModelOutputConverter outConverter = access.getOutputConverter();
                RoutingConnOut result = new RoutingConnOutImpl();
                
            result.setSerNr(inConverter.toInteger(access.get("serNr", -1)));
                
                result.setData(inConverter.toString(access.get("data", -1)));
                
                return result; 
            }
                    
                        @Override
                        public void initializeModelAccess() throws IOException {
                            ModelAccess access = getModelAccess();
                            access.useNotifications(false);
                        }
                    
                        @Override
                        public Class<? extends Object> getSourceType() {
                            return Object.class;
                        }
                    
                        @Override
                        public Class<? extends RoutingConnOut> getTargetType() {
                            return RoutingConnOut.class;
                        }
                    
                    }
    private class ConnectorReceptionCallback implements ReceptionCallback<RoutingConnOut> {
    
        {
            Starter.getSetup(); // initialize Transport if needed
        }
    
        @Override
        public void received(RoutingConnOut data) {
            MetricsProvider.increaseCounterBy(serviceSent, 1.0);
            Transport.send(c -> c.asyncSend("myRoutingConnector_RoutingConnOut", data), "myRoutingConnector", "processRoutingConnOut_RoutingProcessor-in-0");
        }
    
        @Override
        public Class<RoutingConnOut> getType() {
            return RoutingConnOut.class;
        }
            
    }
    private ConnectorServiceWrapper<Object, Object, RoutingConnOut, RoutingConnIn> handleRoutingCommand(ConnectorServiceWrapper<Object, Object, RoutingConnOut, RoutingConnIn> service, RoutingCommand data) {
        if (null != routingCommandHandler) {
            routingCommandHandler.received(data, service.getConnector());
        }
        return service;
    }
}
