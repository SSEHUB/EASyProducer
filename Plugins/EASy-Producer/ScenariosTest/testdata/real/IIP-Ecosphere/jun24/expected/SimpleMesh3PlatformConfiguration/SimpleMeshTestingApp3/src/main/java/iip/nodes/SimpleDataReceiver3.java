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
import iip.interfaces.*;


/**
 * Spring Cloud Stream service frame for net node 'Simple Data Receiver3'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.SimpleReceiver3", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class SimpleDataReceiver3 extends SpringAsyncServiceBase {

    @Value("${iip.service.SimpleReceiver3:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private SimpleDataReceiver3Interface service;
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
    public SimpleDataReceiver3() {
        service = AbstractService.createInstance("de.iip_ecosphere.platform.test.apps.serviceImpl.SimpleReceiver3Impl", 
            SimpleDataReceiver3Interface.class, 
            "SimpleReceiver3", 
            "deployment.yml");
        
        appInstId = getAppInstIdSuffix(service, "_");
        
    }

    /**
    * Called when data arrived that shall be received (data sink).
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<Rec13> receiveRec13_SimpleReceiver3() {
        return data -> {
        MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
        processingTime.record(() -> service.processRec13(data)); 
        };
    }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service SimpleReceiver3: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service); // service.getId() is "static"
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("SimpleReceiver3", sId, "SimpleMeshApp3", iId);
            serviceReceived = metrics.createServiceReceivedCounter("SimpleReceiver3", sId, "SimpleMeshApp3", iId);
            processingTime = metrics.createServiceProcessingTimer("SimpleReceiver3", sId, "SimpleMeshApp3", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            
            
        }
    }
    
    
}
