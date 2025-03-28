package iip.nodes;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import de.iip_ecosphere.platform.services.environment.AbstractService;
import de.iip_ecosphere.platform.services.environment.MonitoringService;
import de.iip_ecosphere.platform.services.environment.ParameterConfigurer;
import de.iip_ecosphere.platform.services.environment.ServiceState;
import de.iip_ecosphere.platform.services.environment.spring.SpringAsyncServiceBase;
import de.iip_ecosphere.platform.services.environment.spring.Starter;
import de.iip_ecosphere.platform.services.environment.spring.metricsProvider.MetricsProvider;
import de.iip_ecosphere.platform.services.environment.switching.ServiceBase;

import iip.datatypes.Rec1;
import iip.datatypes.RtsaTestInput;
import iip.interfaces.AlternativeMyKiExampleInterface;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Spring Cloud Stream service frame for net node 'KI family example'.
 * Generated by: EASy-Producer.
 */
@Component
@ConditionalOnProperty(value = "iip.service.myKiFamily", havingValue = "true", matchIfMissing = true)
@EnableScheduling
public class AlternativeMyKiExampleFamilyKIFamilyExample extends SpringAsyncServiceBase implements KIFamilyExampleFamilyInterface {

    @Value("${iip.service.myKiFamily:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private AlternativeMyKiExampleInterface service;
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private Timer processingTime;
    private String appInstId = "";

     /**
     * Creates an instance.
     *
     * @param streamBridge the stream bridge
     * @param metrics the metrics provider
     */
    public AlternativeMyKiExampleFamilyKIFamilyExample(StreamBridge streamBridge, MetricsProvider metrics) {
        this.streamBridge = streamBridge;
        this.metrics = metrics;
        service = AbstractService.createInstance("MyKi2Impl", AlternativeMyKiExampleInterface.class, "myKi2", 
            "deployment.yml");
        HashMap<String, String> paramValues = new HashMap<>();
        ParameterConfigurer<?> cfg;
        cfg = service.getParameterConfigurer("threshold");
        if (null != cfg) {
            cfg.addValue(paramValues, 15);
        }
        try {
            service.reconfigure(paramValues);
        } catch (ExecutionException e) {
            LoggerFactory.getLogger(getClass())
                .error("Configuring initial parameter: {}", e.getMessage());
        }
        appInstId = getAppInstIdSuffix(service, "_");
    }

    /**
    * Called when data arrived that shall be processed (synchronously).
    *
    * @return the data transformation functor
    */
    public Function<Rec1, RtsaTestInput> transformRec1RtsaTestInput_myKiFamily() {
        return data -> service.transformRec1(data);
    }

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass())
                .info("Initializing service myKiFamily: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service);
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("myKiFamily", sId, "myApp", iId);
            serviceReceived = metrics.createServiceReceivedCounter("myKiFamily", sId, "myApp", iId);
            processingTime = metrics.createServiceProcessingTimer("myKiFamily", sId, "myApp", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service, false);
        }
    }
    
    @Override
    public void setState(ServiceState state) throws ExecutionException {
        service.setState(state);
    }

    @Override
    public ServiceState getState() {
        return service.getState();
    }

    @Override
    public String getId() {
        return service.getId();
    }

}
