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
import de.iip_ecosphere.platform.kiServices.rapidminer.rtsa.MultiRtsaRestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Spring Cloud Stream service frame for net node 'myRtsa example'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.myRtsa", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class MyRtsaExample extends SpringAsyncServiceBase {

    @Value("${iip.service.myRtsa:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private MultiRtsaRestService service;
    // so far plain delegation, preparation but so far no support for service switching
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private io.micrometer.core.instrument.Timer processingTime;
    private String appInstId = "";

    /**
     * In-data JSON type translator.
     * 
     * @author EASy-Producer
     */
    private static class RtsaTestInputInputTranslator implements TypeTranslator<RtsaTestInput, String> {
    
        @Override
        public RtsaTestInput from(String data) throws IOException {
            return null; // shall be filled, not needed here
        }
    
        @Override
        public String to(RtsaTestInput source) throws IOException {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(source);
            } catch (JsonProcessingException e) {
                throw new IOException(e);
            }                
        }
    
     }
     /**
      * Out-data JSON type translator.
      * 
      * @author EASy-Producer
      */
     private static class RtsaTestOutputOutputTranslator implements TypeTranslator<String, RtsaTestOutput> {
    
         @Override
         public String from(RtsaTestOutput data) throws IOException {
             return null; // shall be filled, not needed here
         }
    
         @Override
         public RtsaTestOutput to(String source) throws IOException {
             try {
                 ObjectMapper objectMapper = new ObjectMapper();
                 JsonUtils.handleIipDataClasses(objectMapper); // only if nested?
                 return objectMapper.readValue(source, RtsaTestOutputImpl.class);
             } catch (JsonProcessingException e) {
                 throw new IOException(e);
             }
         }
     }
     

     /**
     * Creates an instance.
     */
    public MyRtsaExample() {
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader
            .getResourceAsStream("deployment.yml"));
        YamlService serviceData = art.getServiceSafe("myRtsa");
        
        service = new MultiRtsaRestService(serviceData);
        service.registerInputTypeTranslator(RtsaTestInput.class, "RtsaTestInput", new RtsaTestInputInputTranslator());
        service.registerOutputTypeTranslator(RtsaTestOutput.class, "RtsaTestOutput", new RtsaTestOutputOutputTranslator());
        
    }

    /**
    * Called when data arrived that shall be processed (asynchronously).
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<RtsaTestInput> processRtsaTestInput_myRtsa() {
        return data -> {
        MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
        processingTime.record(() -> service.processQuiet("RtsaTestInput", data)); 
        };
    }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service myRtsa: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service); // service.getId() is "static"
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("myRtsa", sId, "myApp", iId);
            serviceReceived = metrics.createServiceReceivedCounter("myRtsa", sId, "myApp", iId);
            processingTime = metrics.createServiceProcessingTimer("myRtsa", sId, "myApp", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            
            service.attachIngestor(RtsaTestOutputImpl.class, "RtsaTestOutput", data -> {
                MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
                Transport.send(c -> c.asyncSend("data_myRtsa_RtsaTestOutput_myApp" + appInstId, data), "myRtsa", "receiveRtsaTestOutput_aasSink-in-0"); 
            });
            service.attachIngestor(RtsaTestOutput.class, "RtsaTestOutput", data -> {
                MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
                Transport.send(c -> c.asyncSend("data_myRtsa_RtsaTestOutput_myApp" + appInstId, data), "myRtsa", "receiveRtsaTestOutput_aasSink-in-0"); 
            });
        }
    }
    
    
}
