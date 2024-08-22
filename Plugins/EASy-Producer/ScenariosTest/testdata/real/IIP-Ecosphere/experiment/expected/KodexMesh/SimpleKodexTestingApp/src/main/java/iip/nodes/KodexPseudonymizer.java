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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Spring Cloud Stream service frame for net node 'Kodex Pseudonymizer'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.Pseudonymizer", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class KodexPseudonymizer extends SpringAsyncServiceBase {

    @Value("${iip.service.Pseudonymizer:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private de.iip_ecosphere.platform.security.services.kodex.KodexService<KRec13,KRec13Anon> serviceKRec13KRec13Anon;
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
    private static class KRec13InputTranslator implements TypeTranslator<KRec13, String> {
    
        @Override
        public KRec13 from(String data) throws IOException {
            return null; // shall be filled, not needed here
        }
    
        @Override
        public String to(KRec13 source) throws IOException {
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
     private static class KRec13AnonOutputTranslator implements TypeTranslator<String, KRec13Anon> {
    
         @Override
         public String from(KRec13Anon data) throws IOException {
             return null; // shall be filled, not needed here
         }
    
         @Override
         public KRec13Anon to(String source) throws IOException {
             try {
                 ObjectMapper objectMapper = new ObjectMapper();
                 JsonUtils.handleIipDataClasses(objectMapper); // only if nested?
                 return objectMapper.readValue(source, KRec13AnonImpl.class);
             } catch (JsonProcessingException e) {
                 throw new IOException(e);
             }
         }
     }
     

     /**
     * Creates an instance.
     */
    public KodexPseudonymizer() {
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader
            .getResourceAsStream("deployment.yml"));
        YamlService serviceData = art.getServiceSafe("Pseudonymizer");
        serviceKRec13KRec13Anon = new de.iip_ecosphere.platform.security.services.kodex.KodexService(
            new KRec13InputTranslator(), 
            new KRec13AnonOutputTranslator(), 
            null, // via attachIngestor
            serviceData);
    }

    /**
    * Called when data arrived that shall be processed (asynchronously).
    *
    * @return the data consumer functor
    */
    @Bean
    public Consumer<KRec13> processKRec13_Pseudonymizer() {
        return data -> {
            {
                    MetricsProvider.increaseCounterBy(serviceReceived, 1.0); 
                    processingTime.record(() -> serviceKRec13KRec13Anon.processQuiet(data)); 
            };
        };
    }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service Pseudonymizer: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(serviceKRec13KRec13Anon); // serviceKRec13KRec13Anon.getId() is "static"
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("Pseudonymizer", sId, "KodexMeshApp", iId);
            serviceReceived = metrics.createServiceReceivedCounter("Pseudonymizer", sId, "KodexMeshApp", iId);
            processingTime = metrics.createServiceProcessingTimer("Pseudonymizer", sId, "KodexMeshApp", iId);
            MonitoringService.setUp(serviceKRec13KRec13Anon, metrics);
            Starter.mapService(serviceKRec13KRec13Anon);
            
            serviceKRec13KRec13Anon.attachIngestor(KRec13AnonImpl.class, data -> {
                MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
                SerializerMessageConverter.serializeAndSend(streamBridge, "transformKRec13AnonKRec13Anon_KodexPythonService-in-0", data);; 
            });
            serviceKRec13KRec13Anon.attachIngestor(KRec13Anon.class, data -> {
                MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
                SerializerMessageConverter.serializeAndSend(streamBridge, "transformKRec13AnonKRec13Anon_KodexPythonService-in-0", data);; 
            });
        }
    }
    
    
}
