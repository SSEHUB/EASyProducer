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
 * Spring Cloud Stream service frame for net node 'myModbusConn example'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.myModbusConn", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class MyModbusConnExample extends SpringAsyncServiceBase {

    @Value("${iip.service.myModbusConn:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private ConnectorServiceWrapper<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM> service;
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
    public MyModbusConnExample() {
        ConnectorParameter param = createConnectorParameter();
        Connector<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM> conn = ConnectorFactory.createConnector(
            "de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusTcpIpConnector", () -> param, 
            createConnectorAdapter(()->service.getInPath(""), ()->service.getOutPath("")));
        conn.enablePolling(false); // independent of notifications, disable as @Autowired may not be
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader
            .getResourceAsStream("deployment.yml"));
        YamlService serviceData = art.getServiceSafe("myModbusConn"); 
        service = new ConnectorServiceWrapper<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM>(serviceData, conn, 
            () -> param);
        service.setReceptionCallback(new ConnectorReceptionCallback());
        appInstId = getAppInstIdSuffix(service, "_");
    }

    /**
    * Creates the default connector adapter without path suppliers. [public for testing]
    *
    * @return the connector adapter
    */
    public static TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM> createConnectorAdapter() {
        return createConnectorAdapter(null, null, null, null);
    }
    
    /**
    * Creates the connector adapter. [public for testing]
    *
    * @param inPathSupplier function returning the actual input base path to use for data accesses, may be <b>null</b>
    * @param outPathSupplier function returning the actual output base path to use for data accesses, may be <b>null</b>
    * @return the connector adapter
    */
    public static TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM> createConnectorAdapter(Supplier<String> inPathSupplier, Supplier<String> outPathSupplier) {
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
    public static TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM> createConnectorAdapter(
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
    public static TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM> createConnectorAdapter(
        de.iip_ecosphere.platform.services.environment.metricsProvider.MetricsProvider metrics, File log, Supplier<String> inPathSupplier, Supplier<String> outPathSupplier) {
        TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM> adapter;
        if (metrics != null) {
            adapter = new MonitoredTranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM>(
                new MachineOutputTranslator(outPathSupplier), 
                new MachineInputTranslator(inPathSupplier), 
                metrics, log);
        } else {
            adapter = new TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, Object, ModbusPhoenixEEM, ModbusPhoenixRwEEM>(
                new MachineOutputTranslator(outPathSupplier), 
                new MachineInputTranslator(inPathSupplier));
        };
        return adapter;
    }
    /**
    * Called when data arrived that shall be passed on to the connector.
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<ModbusPhoenixRwEEM> createModbusPhoenixRwEEM_myModbusConn() {
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
        YamlService yaml = art.getServiceSafe("myModbusConn"); 
        String host = "127.0.0.1";
        String hostOverride = null;
        int port = 502;
        if (null != yaml.getNetMgtKey() && yaml.getNetMgtKey().length() > 0) {
            ServerAddress netKeyMgtAddress = NetworkManagerFactory.getInstance().getPort(yaml.getNetMgtKey());
            if (null != netKeyMgtAddress) {
                host = netKeyMgtAddress.getHost();
                hostOverride = host;
                port = netKeyMgtAddress.getPort();
                System.out.println(host+" "+port);
            }
        }NameplateSetup.Service svc = NameplateSetup.resolveServiceFromAas("modbus/tcp");
        if (null != svc) { // device has precedence
            host = svc.getHost();
            port = svc.getPort();
        }
        return ConnectorParameter.ConnectorParameterBuilder
                .newBuilder(host, port)
                .setService(svc)
                .setApplicationInformation("ModbusApp", "")
                .setCacheMode(CacheMode.NONE)
                .setNotificationInterval(0)
                .setSpecificSettingFromResourceSafe("SERVER_STRUCTURE", "myModbusConnexample.server")
                .build();
        }

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service myModbusConn: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service); // service.getId() is "static"
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("myModbusConn", sId, "ModbusApp", iId);
            serviceReceived = metrics.createServiceReceivedCounter("myModbusConn", sId, "ModbusApp", iId);
            processingTime = metrics.createServiceProcessingTimer("myModbusConn", sId, "ModbusApp", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            service.enablePolling(true); // if notifications enabled, enable now also polling as @Autowired is done
            
        }
    }
    

private static class MachineInputTranslator extends AbstractConnectorInputTypeTranslator<ModbusPhoenixRwEEM, Object> {

private Supplier<String> pathSupplier;

    private MachineInputTranslator(Supplier<String> pathSupplier) {
        this.pathSupplier = pathSupplier;
    }

    @Override
public Object from(ModbusPhoenixRwEEM data) throws IOException {
    ModelAccess access = getModelAccess();
    final ModelOutputConverter outConverter = access.getOutputConverter();
    final ModelInputConverter inConverter = access.getInputConverter();
    final String path = pathSupplier == null ? "" : pathSupplier.get();
                access.set(path + "Day", outConverter.fromShort(data.getDay()));
    access.set(path + "Month", outConverter.fromShort(data.getMonth()));
    access.set(path + "Year", outConverter.fromShort(data.getYear()));
    
    return null; // done, no instance of pseudo type
}

    @Override
    public Class<? extends Object> getSourceType() {
        return Object.class;
    }

    @Override
    public Class<? extends ModbusPhoenixRwEEM> getTargetType() {
        return ModbusPhoenixRwEEM.class;
    }

}

private static class MachineOutputTranslator extends AbstractConnectorOutputTypeTranslator<de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem, ModbusPhoenixEEM> {

private Supplier<String> pathSupplier;

    private MachineOutputTranslator(Supplier<String> pathSupplier) {
        this.pathSupplier = pathSupplier;
    }

    @Override
public ModbusPhoenixEEM to(de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem source) throws IOException {
    ModelAccess access = getModelAccess();
    final ModelInputConverter inConverter = access.getInputConverter();
    final ModelOutputConverter outConverter = access.getOutputConverter();
    final String path = pathSupplier == null ? "" : pathSupplier.get();
    
    ModbusPhoenixEEM result = new ModbusPhoenixEEMImpl();
    result.setDay(inConverter.toShort(access.get(path + "Day", 0)));
    result.setMonth(inConverter.toShort(access.get(path + "Month", 0)));
    result.setYear(inConverter.toShort(access.get(path + "Year", 0)));
    result.setU1(inConverter.toFloat(access.get(path + "U1", 0)));
    result.setFrequency(inConverter.toFloat(access.get(path + "frequency", 0)));
    result.setI1(inConverter.toFloat(access.get(path + "I1", 0)));
    
    return result; 
}

    @Override
    public void initializeModelAccess() throws IOException {
        ModelAccess access = getModelAccess();
        access.useNotifications(true);
    }

    @Override
    public Class<? extends de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem> getSourceType() {
        return de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusItem.class;
    }

    @Override
    public Class<? extends ModbusPhoenixEEM> getTargetType() {
        return ModbusPhoenixEEM.class;
    }

}
            private class ConnectorReceptionCallback implements ReceptionCallback<ModbusPhoenixEEM> {
            
                {
                    Starter.getSetup(); // initialize Transport if needed
                }
            
                @Override
                public void received(ModbusPhoenixEEM data) {
                    MetricsProvider.increaseCounterBy(serviceSent, 1.0);
                    Transport.send(c -> c.asyncSend("data_myModbusConn_ModbusPhoenixEEM_ModbusApp" + appInstId, data), "myModbusConn", "receiveModbusPhoenixEEM_ModbusReceiver-in-0");
                }
            
                @Override
                public Class<ModbusPhoenixEEM> getType() {
                    return ModbusPhoenixEEM.class;
                }
                    
            }
        }
