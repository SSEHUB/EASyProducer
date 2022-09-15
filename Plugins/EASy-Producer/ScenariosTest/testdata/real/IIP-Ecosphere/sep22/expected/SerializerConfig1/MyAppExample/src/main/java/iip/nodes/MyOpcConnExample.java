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
 * Spring Cloud Stream service frame for net node 'myOpcConn example'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.myOpcConn", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class MyOpcConnExample extends SpringAsyncServiceBase {

    @Value("${iip.service.myOpcConn:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private ConnectorServiceWrapper<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, Object, MyConnPltfIn, MyConnPltfOut> service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private io.micrometer.core.instrument.Timer processingTime;

     /**
     * Creates an instance.
     */
    public MyOpcConnExample() {
        de.iip_ecosphere.platform.connectors.opcuav1.OpcUaConnector<MyConnPltfIn, MyConnPltfOut> conn = 
            new de.iip_ecosphere.platform.connectors.opcuav1.OpcUaConnector<>(createConnectorAdapter());
        conn.enablePolling(false); // independent of notifications, disable as @Autowired may not be
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader
            .getResourceAsStream("deployment.yml"));
        YamlService serviceData = art.getServiceSafe("myOpcConn"); 
        service = new ConnectorServiceWrapper<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, Object, MyConnPltfIn, MyConnPltfOut>(serviceData, conn, 
            () -> createConnectorParameter());
        service.setReceptionCallback(new ConnectorReceptionCallback());
    }

    /**
    * Creates the connector adapter. [public for testing]
    *
    * @return the connector adapter
    */
    public static TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, Object, MyConnPltfIn, MyConnPltfOut> createConnectorAdapter() {
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
    public static TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, Object, MyConnPltfIn, MyConnPltfOut> createConnectorAdapter(
        de.iip_ecosphere.platform.services.environment.metricsProvider.MetricsProvider metrics, File log) {
        TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, Object, MyConnPltfIn, MyConnPltfOut> adapter;
        if (metrics != null) {
            adapter = new MonitoredTranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, Object, MyConnPltfIn, MyConnPltfOut>(
                new MachineOutputTranslator(), 
                new MachineInputTranslator(), 
                metrics, log);
        } else {
            adapter = new TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, Object, MyConnPltfIn, MyConnPltfOut>(
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
    public Consumer<MyConnPltfOut> createMyConnPltfOut_myOpcConn() {
        return data -> {
    MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
    processingTime.record(() -> service.send(data)); 
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
            .setApplicationInformation("myApp", "")
            .setCacheMode(CacheMode.NONE)
            .build();
    }

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service myOpcConn: {}", activated);
            serviceSent = Counter.builder("service.sent")
                .baseUnit("tuple/s")
                .description("Tuples sent out by a service")
                .tags("service", "myOpcConn", "application", "myApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            serviceReceived = Counter.builder("service.received")
                .baseUnit("tuple/s")
                .description("Tuples received by a service")
                .tags("service", "myOpcConn", "application", "myApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
            processingTime = io.micrometer.core.instrument.Timer.builder("service.processed")
                .description("Main processing time of a service")
                .tags("service", "myOpcConn", "application", "myApp", "device", Id.getDeviceId())
                .register(metrics.getRegistry());
                MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            service.enablePolling(true); // if notifications enabled, enable now also polling as @Autowired is done
            
        }
    }
    

private static class MachineInputTranslator extends AbstractConnectorInputTypeTranslator<MyConnPltfOut, Object> {
    
    @Override
    public Object from(MyConnPltfOut data) throws IOException {
        ModelAccess access = getModelAccess();
        ModelInputConverter inConverter = access.getInputConverter();
        ModelOutputConverter outConverter = access.getOutputConverter();
        access.set("cmdField", outConverter.fromString(data.getCmdField()));
            
                    return null; // done, no instance of pseudo type
                }
            
                @Override
                public Class<? extends Object> getSourceType() {
                    return Object.class;
                }
            
                @Override
                public Class<? extends MyConnPltfOut> getTargetType() {
                    return MyConnPltfOut.class;
                }
            
            }
            
            private static class MachineOutputTranslator extends AbstractConnectorOutputTypeTranslator<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, MyConnPltfIn> {
                    
            @Override
            public MyConnPltfIn to(de.iip_ecosphere.platform.connectors.opcuav1.DataItem source) throws IOException {
                ModelAccess access = getModelAccess();
                ModelInputConverter inConverter = access.getInputConverter();
                ModelOutputConverter outConverter = access.getOutputConverter();
                MyConnPltfIn result = new MyConnPltfInImpl();
                
                return result; 
            }
                    
                        @Override
                        public void initializeModelAccess() throws IOException {
                            ModelAccess access = getModelAccess();
                            access.useNotifications(true);
                        }
                    
                        @Override
                        public Class<? extends de.iip_ecosphere.platform.connectors.opcuav1.DataItem> getSourceType() {
                            return de.iip_ecosphere.platform.connectors.opcuav1.DataItem.class;
                        }
                    
                        @Override
                        public Class<? extends MyConnPltfIn> getTargetType() {
                            return MyConnPltfIn.class;
                        }
                    
                    }
    private class ConnectorReceptionCallback implements ReceptionCallback<MyConnPltfIn> {
    
        {
            Starter.getSetup(); // initialize Transport if needed
        }
    
        @Override
        public void received(MyConnPltfIn data) {
            MetricsProvider.increaseCounterBy(serviceSent, 1.0);
            Transport.send(c -> c.asyncSend("myOpcConn_MyConnPltfIn", data), "myOpcConn", "processMyConnPltfIn_myAnonymizer-in-0");
        }
    
        @Override
        public Class<MyConnPltfIn> getType() {
            return MyConnPltfIn.class;
        }
            
    }
}
