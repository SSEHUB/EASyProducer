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
 * Spring Cloud Stream service frame for net node 'myOpcConn example'.
 * Generated by: EASy-Producer.
 */
@Component
@EnableScheduling
public class MyOpcConnExample {

    @Autowired
    private StreamBridge streamBridge;
    private ConnectorServiceWrapper<de.iip_ecosphere.platform.connectors.opcuav1.DataItem,Object,String,String> service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    @SuppressWarnings("unused")
    private MetricsProvider metrics;

    /**
     * Creates an instance.
     */
    public MyOpcConnExample() {
        TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.opcuav1.DataItem,Object,String,String> adapter = new TranslatingProtocolAdapter<de.iip_ecosphere.platform.connectors.opcuav1.DataItem,Object,String,String>(
            new MachineOutputTranslator(), 
            new MachineInputTranslator());
                de.iip_ecosphere.platform.connectors.opcuav1.OpcUaConnector<String,String> conn = new de.iip_ecosphere.platform.connectors.opcuav1.OpcUaConnector<>(adapter);
                YamlService serviceData = YamlArtifact.readFromYamlSafe(MyOpcConnExample.class
                    .getResourceAsStream("/deployment.yml")).getServiceSafe("myOpcConn"); 
                service = new ConnectorServiceWrapper<de.iip_ecosphere.platform.connectors.opcuav1.DataItem,Object,String,String>(serviceData, conn, 
                    () -> createConnectorParameter());
                service.setReceptionCallback(new ConnectorReceptionCallback());
                Starter.mapService(service);
    }

    /**
    * Called when data arrived that shall be passed on to the connector.
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<String> createString_myOpcConn() {
        return data -> service.send(data);
    }
    /**
    * Creates the connector parameter instance.
    *
    * @return the instance to be passed to the connector
    */
    private ConnectorParameter createConnectorParameter() {
        return ConnectorParameter.ConnectorParameterBuilder
            .newBuilder("localhost", 1234)
            .setApplicationInformation("myApp", "")
            .build();
    }

    /**
     * Attaches the ingestors.
     */
    @PostConstruct 
    public void attachIngestors() {
    

    private static class MachineInputTranslator extends AbstractConnectorInputTypeTranslator<String, Object> {
    
        @Override
        public Object from(String data) throws IOException {
            return null; // TODO irrelevant?
        }
    
        @Override
        public Class<? extends Object> getSourceType() {
            return Object.class;
        }
    
        @Override
        public Class<? extends String> getTargetType() {
            return String.class;
        }
    
    }
    
    private static class MachineOutputTranslator extends AbstractConnectorOutputTypeTranslator<de.iip_ecosphere.platform.connectors.opcuav1.DataItem, String> {
            
                @Override
                public String to(de.iip_ecosphere.platform.connectors.opcuav1.DataItem source) throws IOException {
                    return null; // TODO
                }
            
                @Override
                public void initializeModelAccess() throws IOException {
                    //ModelAccess access = getModelAccess();
                    //access.useNotifications(withNotifications);
                    //customizer.initializeModelAccess(access, withNotifications);
                }
            
                @Override
                public Class<? extends de.iip_ecosphere.platform.connectors.opcuav1.DataItem> getSourceType() {
                    return de.iip_ecosphere.platform.connectors.opcuav1.DataItem.class;
                }
            
                @Override
                public Class<? extends String> getTargetType() {
                    return String.class;
                }
            
            }
    private class ConnectorReceptionCallback implements ReceptionCallback<String> {
    
        @Override
        public void received(String data) {
            streamBridge.send("createString_myOpcConn", data);
        }
    
        @Override
        public Class<String> getType() {
            return String.class;
        }
            
    }
}