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
 * Spring Cloud Stream service frame for net node 'KI family example'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.myKiFamily", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class KIFamilyExample extends SpringAsyncServiceBase {

    @Value("${iip.service.myKiFamily:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private ServiceSelector<Rec1> selector = 
        ServiceSelector.createInstance(getClass().getClassLoader(), "de.iip_ecosphere.platform.apps.myApp.MyKiServiceFamilySelector", Rec1.class, "myKi");
    private KIFamilyExampleFamilyInterface service;
    private String actServiceId = "myKi";
    private FamilyServiceStub familyStub;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private io.micrometer.core.instrument.Timer processingTime;
    private String appInstId = "";

    /**
    * Selects the new service from the given {@code data} via the {@link #selector}.
    * 
    * @param data the data to select from
    * @return {@link #service} for call chains
    */
    private KIFamilyExampleFamilyInterface selectService(Rec1 data) {
        String id = selector.select(data);
        if (null != id && !actServiceId.equals(id)) {
            Transport.sendTraceRecord(new TraceRecord("myKiFamily", TraceRecord.ACTION_SWITCHING_SERVICE, actServiceId));
            KIFamilyExampleFamilyInterface newService; // instantiation shall override AAS service mapping
            switch (id) {
            case "myKi": 
                newService = new MyKiExampleFamilyKIFamilyExample(streamBridge, metrics);
                break;
            case "myKi2": 
                newService = new AlternativeMyKiExampleFamilyKIFamilyExample(streamBridge, metrics);
                break;                    
            default:
                newService = null;
                break;
            }
            if (newService != null) {
                KIFamilyExampleFamilyInterface oldService = service;
                service = selector.createStrategy().doSwitch(service, newService);
                if (oldService != service) {
                    service.initService(); // connect outputs
                    actServiceId = service.getId();
                    oldService.detach();
                }
            }
            selector.actionCompleted(actServiceId);
            Transport.sendTraceRecord(new TraceRecord("myKiFamily", TraceRecord.ACTION_SWITCHED_SERVICE, actServiceId));
        }
        return service;
    }

     /**
     * Creates an instance.
     */
    public KIFamilyExample() {
        familyStub = new FamilyServiceStub("myKiFamily", 
            AbstractService.getResourceAsStream(KIFamilyExample.class.getClassLoader(), "deployment.yml"));
        appInstId = getAppInstIdSuffix(familyStub, "_");
    }

    /**
    * Called when data arrived that shall be processed (synchronously).
    *
    * @return the data transformation functor
    */
    @Bean
    public Function<Rec1, RtsaTestInput> transformRec1RtsaTestInput_myKiFamily() {
        return data -> selectService(data).transformRec1RtsaTestInput_myKiFamily().apply(data);
    }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service myKiFamily: {}", activated);
            familyStub.setActiveMemberSupplier(() -> service);
            service = new MyKiExampleFamilyKIFamilyExample(streamBridge, metrics);
            selector.initial("myKi");
            Starter.mapService(familyStub);
            
service.initService();
        }
    }
    
    
}
