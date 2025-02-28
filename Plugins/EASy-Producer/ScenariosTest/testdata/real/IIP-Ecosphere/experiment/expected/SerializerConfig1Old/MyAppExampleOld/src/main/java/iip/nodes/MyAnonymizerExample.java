package iip.nodes;

import java.util.function.Consumer;
import javax.annotation.PostConstruct;

import de.iip_ecosphere.platform.services.environment.AbstractService;
import de.iip_ecosphere.platform.services.environment.MonitoringService;
import de.iip_ecosphere.platform.services.environment.spring.SpringAsyncServiceBase;
import de.iip_ecosphere.platform.services.environment.spring.Starter;
import de.iip_ecosphere.platform.services.environment.spring.metricsProvider.MetricsProvider;
import de.iip_ecosphere.platform.services.environment.switching.ServiceBase;
import de.iip_ecosphere.platform.transport.spring.SerializerMessageConverter;

import iip.datatypes.MyConnPltfIn;
import iip.interfaces.MyAnonymizerExampleService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Spring Cloud Stream service frame for net node 'myAnonymizer example'.
 * Generated by: EASy-Producer.
 */
@Component
@ConditionalOnProperty(value = "iip.service.myAnonymizer", havingValue = "true", matchIfMissing = true)
@EnableScheduling
public class MyAnonymizerExample extends SpringAsyncServiceBase {

    @Value("${iip.service.myAnonymizer:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private MyAnonymizerExampleService service;
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private Timer processingTime;
    private String appInstId = "";

     /**
     * Creates an instance.
     */
    public MyAnonymizerExample() {
        service = AbstractService.createInstance("MyAnonymizerImpl", MyAnonymizerExampleService.class, "myAnonymizer", 
            "deployment.yml");
        appInstId = getAppInstIdSuffix(service, "_");
    }

    /**
    * Called when data arrived that shall be processed (asynchronously).
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<String> processString_myAnonymizer() {
        return data -> {
            MetricsProvider.increaseCounterBy(serviceReceived, 1.0);
            LoggerFactory.getLogger(getClass())
                .debug("received in {}: {}", "myAnonymizer", data); 
            processingTime.record(() -> service.processString(data)); 
        };
    }
    
    
    /**
    * Called when data arrived that shall be processed (asynchronously).
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<MyConnPltfIn> processMyConnPltfIn_myAnonymizer() {
        return data -> {
            MetricsProvider.increaseCounterBy(serviceReceived, 1.0);
            LoggerFactory.getLogger(getClass())
                .debug("received in {}: {}", "myAnonymizer", data); 
            processingTime.record(() -> service.processMyConnPltfIn(data)); 
        };
    }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass())
                .info("Initializing service myAnonymizer: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service);
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("myAnonymizer", sId, "myApp", iId);
            serviceReceived = metrics.createServiceReceivedCounter("myAnonymizer", sId, "myApp", iId);
            processingTime = metrics.createServiceProcessingTimer("myAnonymizer", sId, "myApp", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            
            service.attachprocessRec1_myAnonymizerIngestor(data -> {
                MetricsProvider.increaseCounterBy(serviceSent, 1.0);
                LoggerFactory.getLogger(getClass())
                    .debug("sending in {}: {}", "myAnonymizer", data); 
                SerializerMessageConverter.serializeAndSend(streamBridge, "transformRec1String_myKi-in-0", data);
            });
            createReceptionCallback("data_myMqttConn_MyConnPltfIn_myApp" + appInstId, processMyConnPltfIn_myAnonymizer(
                ), MyConnPltfIn.class, "processMyConnPltfIn_myAnonymizer-in-0");
            createReceptionCallback("data_myOpcConn_MyConnPltfIn_myApp" + appInstId, processMyConnPltfIn_myAnonymizer(), 
                MyConnPltfIn.class, "processMyConnPltfIn_myAnonymizer-in-0");
            createReceptionCallback("data_mySource_String_myApp" + appInstId, processString_myAnonymizer(), String.
                class, "processString_myAnonymizer-in-0");
        }
    }

}
