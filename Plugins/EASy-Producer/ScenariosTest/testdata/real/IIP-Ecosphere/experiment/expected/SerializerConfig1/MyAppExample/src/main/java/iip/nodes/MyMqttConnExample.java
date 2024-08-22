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
import static de.iip_ecosphere.platform.connectors.model.ModelAccessProvider.optional;
import de.iip_ecosphere.platform.support.*;
import de.iip_ecosphere.platform.support.identities.*;
import de.iip_ecosphere.platform.support.resources.*;
import de.iip_ecosphere.platform.support.iip_aas.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import de.iip_ecosphere.platform.support.net.*;
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
import de.iip_ecosphere.platform.connectors.Connector;
import de.iip_ecosphere.platform.connectors.ConnectorFactory;
import de.iip_ecosphere.platform.connectors.ConnectorParameter;
import de.iip_ecosphere.platform.connectors.ConnectorParameter.CacheMode;
import de.iip_ecosphere.platform.connectors.types.*;
import de.iip_ecosphere.platform.connectors.model.*;
import iip.datatypes.*;
import iip.serializers.*;

/**
 * Spring Cloud Stream service frame for net node 'myMqttConnExample'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.myMqttConn", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class MyMqttConnExample extends SpringAsyncServiceBase {

    @Value("${iip.service.myMqttConn:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private ConnectorServiceWrapper<byte[], byte[], MyConnPltfIn, MyConnPltfOut> service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private io.micrometer.core.instrument.Timer processingTime;
    private String appInstId = "";

     /**
     * Creates an instance.
     */
    public MyMqttConnExample() {
        ConnectorParameter param = createConnectorParameter();
        Connector<byte[], byte[], MyConnPltfIn, MyConnPltfOut> conn = ConnectorFactory.createConnector(
            "de.iip_ecosphere.platform.connectors.mqttv3.PahoMqttv3Connector", () -> param, 
            createConnectorAdapter(()->service.getInPath(""), ()->service.getOutPath("")));
        conn.enablePolling(false); // independent of notifications, disable as @Autowired may not be
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader
            .getResourceAsStream("deployment.yml"));
        YamlService serviceData = art.getServiceSafe("myMqttConn"); 
        service = new ConnectorServiceWrapper<byte[], byte[], MyConnPltfIn, MyConnPltfOut>(serviceData, conn, 
            () -> param);
        service.setReceptionCallback(new ConnectorReceptionCallback());
        appInstId = getAppInstIdSuffix(service, "_");
    }

    /**
    * Creates the default connector adapter without path suppliers. [public for testing]
    *
    * @return the connector adapter
    */
    public static ChannelTranslatingProtocolAdapter<byte[], byte[], MyConnPltfIn, MyConnPltfOut> createConnectorAdapter() {
        return createConnectorAdapter(null, null, null, null);
    }
    
    /**
    * Creates the connector adapter. [public for testing]
    *
    * @param inPathSupplier function returning the actual input base path to use for data accesses, may be <b>null</b>
    * @param outPathSupplier function returning the actual output base path to use for data accesses, may be <b>null</b>
    * @return the connector adapter
    */
    public static ChannelTranslatingProtocolAdapter<byte[], byte[], MyConnPltfIn, MyConnPltfOut> createConnectorAdapter(Supplier<String> inPathSupplier, Supplier<String> outPathSupplier) {
        return createConnectorAdapter(null, null, inPathSupplier, outPathSupplier);
    }
    
    /**
    * Creates the connector adapter without path suppliers. [public for testing]
    *
    * @param metrics the metrics provider to use, <b>null</b> for no metric measurements
    * @param log the log file to use to record individual measurements in experiments, <b>null</b> for no logging.
    *      Only becomes active if {@code metrics} is not <b>null</b>
    * @return the connector adapter
    */
    public static ChannelTranslatingProtocolAdapter<byte[], byte[], MyConnPltfIn, MyConnPltfOut> createConnectorAdapter(
        de.iip_ecosphere.platform.services.environment.metricsProvider.MetricsProvider metrics, File log) {
        return createConnectorAdapter(metrics, log, null, null);
    }
    
    /**
    * Creates the connector adapter. [public for testing]
    *
    * @param metrics the metrics provider to use, <b>null</b> for no metric measurements
    * @param log the log file to use to record individual measurements in experiments, <b>null</b> for no logging.
    *      Only becomes active if {@code metrics} is not <b>null</b>
    * @param inPathSupplier function returning the actual input base path to use for data accesses, may be <b>null</b>
    * @param outPathSupplier function returning the actual output base path to use for data accesses, may be <b>null</b>
    * @return the connector adapter
    */
    public static ChannelTranslatingProtocolAdapter<byte[], byte[], MyConnPltfIn, MyConnPltfOut> createConnectorAdapter(
        de.iip_ecosphere.platform.services.environment.metricsProvider.MetricsProvider metrics, File log, Supplier<String> inPathSupplier, Supplier<String> outPathSupplier) {
        ChannelTranslatingProtocolAdapter<byte[], byte[], MyConnPltfIn, MyConnPltfOut> adapter;
        if (metrics != null) {
            adapter = new MonitoredTranslatingProtocolAdapter<byte[], byte[], MyConnPltfIn, MyConnPltfOut>(
                "OUT", new ChanneledConnectorOutputTypeAdapter<MyConnPltfIn>(new MyMqttConnExampleParserSerializer("US-ASCII", null, outPathSupplier)), 
                "IN", new ConnectorInputTypeAdapter<MyConnPltfOut>(new MyMqttConnExampleFormatterSerializer("US-ASCII", null, inPathSupplier)), 
                metrics, log);
        } else {
            adapter = new ChannelTranslatingProtocolAdapter<byte[], byte[], MyConnPltfIn, MyConnPltfOut>(
                "OUT", new ChanneledConnectorOutputTypeAdapter<MyConnPltfIn>(new MyMqttConnExampleParserSerializer("US-ASCII", null, outPathSupplier)), 
                "IN", new ConnectorInputTypeAdapter<MyConnPltfOut>(new MyMqttConnExampleFormatterSerializer("US-ASCII", null, inPathSupplier)));
        };
        return adapter;
    }
    /**
    * Called when data arrived that shall be passed on to the connector.
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<MyConnPltfOut> createMyConnPltfOut_myMqttConn() {
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
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader
            .getResourceAsStream("deployment.yml"));
        YamlService yaml = art.getServiceSafe("myMqttConn"); 
        String host = "localhost";
        String hostOverride = null;
        int port = 4321;
        if (null != yaml.getNetMgtKey() && yaml.getNetMgtKey().length() > 0) {
            ServerAddress netKeyMgtAddress = NetworkManagerFactory.getInstance().getPort(yaml.getNetMgtKey());
            if (null != netKeyMgtAddress) {
                host = netKeyMgtAddress.getHost();
                hostOverride = host;
                port = netKeyMgtAddress.getPort();
                System.out.println(host+" "+port);
            }
        }NameplateSetup.Service svc = NameplateSetup.resolveServiceFromAas("mqttv3");
        if (null != svc) { // device has precedence
            host = svc.getHost();
            port = svc.getPort();
        }
        return ConnectorParameter.ConnectorParameterBuilder
                .newBuilder(host, port)
                .setService(svc)
                .setApplicationInformation("myApp", "")
                .setCacheMode(CacheMode.NONE)
                .setNotificationInterval(0)
                .build();
        }

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service myMqttConn: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service); // service.getId() is "static"
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("myMqttConn", sId, "myApp", iId);
            serviceReceived = metrics.createServiceReceivedCounter("myMqttConn", sId, "myApp", iId);
            processingTime = metrics.createServiceProcessingTimer("myMqttConn", sId, "myApp", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            service.enablePolling(true); // if notifications enabled, enable now also polling as @Autowired is done
            
        }
    }
    
    private class ConnectorReceptionCallback implements ReceptionCallback<MyConnPltfIn> {
    
        {
            Starter.getSetup(); // initialize Transport if needed
        }
    
        @Override
        public void received(MyConnPltfIn data) {
            MetricsProvider.increaseCounterBy(serviceSent, 1.0);
            Transport.send(c -> c.asyncSend("data_myMqttConn_MyConnPltfIn_myApp" + appInstId, data), "myMqttConn", "processMyConnPltfIn_myAnonymizer-in-0");
        }
    
        @Override
        public Class<MyConnPltfIn> getType() {
            return MyConnPltfIn.class;
        }
            
    }
}
