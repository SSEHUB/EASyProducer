package iip.nodes;

import java.util.function.Supplier;
import javax.annotation.PostConstruct;

import de.iip_ecosphere.platform.services.environment.AbstractService;
import de.iip_ecosphere.platform.services.environment.MonitoringService;
import de.iip_ecosphere.platform.services.environment.spring.SpringAsyncServiceBase;
import de.iip_ecosphere.platform.services.environment.spring.Starter;
import de.iip_ecosphere.platform.services.environment.spring.metricsProvider.MetricsProvider;
import de.iip_ecosphere.platform.services.environment.switching.ServiceBase;

import iip.datatypes.Rec13;
import iip.interfaces.SimpleDataSource3Interface;
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
 * Spring Cloud Stream service frame for net node 'Simple Data Source3'.
 * Generated by: EASy-Producer.
 */
@Component
@ConditionalOnProperty(value = "iip.service.SimpleSource3", havingValue = "true", matchIfMissing = true)
@EnableScheduling
public class SimpleDataSource3 extends SpringAsyncServiceBase {

    @Value("${iip.service.SimpleSource3:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private SimpleDataSource3Interface service;
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private Timer processingTime;
    private String appInstId = "";

     /**
     * Creates an instance.
     */
    public SimpleDataSource3() {
        service = AbstractService.createInstance("de.iip_ecosphere.platform.test.apps.serviceImpl.SimpleSource3Impl", 
            SimpleDataSource3Interface.class, 
            "SimpleSource3", 
            "deployment.yml");
        
        appInstId = getAppInstIdSuffix(service, "_");
        
    }

    /**
    * Creates data to be ingested.
    *
    * @return the data supplier functor
    */
    @Bean
    public Supplier<Rec13> createRec13_SimpleSource3() {
        return () -> {
        MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
        return service.produceRec13(); 
    }; 
                }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass())
                .info("Initializing service SimpleSource3: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service);
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("SimpleSource3", sId, "SimpleMeshApp3", iId);
            serviceReceived = metrics.createServiceReceivedCounter("SimpleSource3", sId, "SimpleMeshApp3", iId);
            processingTime = metrics.createServiceProcessingTimer("SimpleSource3", sId, "SimpleMeshApp3", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
        }
    }

}
