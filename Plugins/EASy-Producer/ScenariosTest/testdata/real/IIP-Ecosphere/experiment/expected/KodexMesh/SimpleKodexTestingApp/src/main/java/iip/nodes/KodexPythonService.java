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
 * Spring Cloud Stream service frame for net node 'Kodex Python Service'.
 *
 * @author EASy-Producer.
 */
@Component
@ConditionalOnProperty(value="iip.service.KodexPythonService", havingValue="true", matchIfMissing=true)
@EnableScheduling
public class KodexPythonService extends SpringAsyncServiceBase {

    @Value("${iip.service.KodexPythonService:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private de.iip_ecosphere.platform.services.environment.PythonAsyncProcessService service;
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
    private static class KRec13AnonInputTranslator implements TypeTranslator<KRec13Anon, String> {
    
        @Override
        public KRec13Anon from(String data) throws IOException {
            return null; // shall be filled, not needed here
        }
    
        @Override
        public String to(KRec13Anon source) throws IOException {
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
    public KodexPythonService() {
        service = AbstractService.createInstance("de.iip_ecosphere.platform.services.environment.PythonAsyncProcessService", 
            de.iip_ecosphere.platform.services.environment.PythonAsyncProcessService.class, 
            "KodexPythonService", 
            "deployment.yml");
        service.registerInputTypeTranslator(KRec13Anon.class, "KRec13Anon", new KRec13AnonInputTranslator());
        service.registerOutputTypeTranslator(KRec13Anon.class, "KRec13Anon", new KRec13AnonOutputTranslator());
        
        service.addParameterConfigurer(c -> {
            AbstractService.addConfigurer(c, "passThrough", Boolean.class, TypeTranslators.BOOLEAN, v -> {}, null, "iip.app.sc1.passThrough");
            AbstractService.addConfigurer(c, "sParam", String.class, TypeTranslators.JSON_STRING, v -> {}, null);
        });
                
        HashMap<String, String> paramValues = new HashMap<>();
        ParameterConfigurer<?> cfg;
        cfg = service.getParameterConfigurer("passThrough");
        if (null != cfg) {
            cfg.addValue(paramValues, false);
        }
        cfg = service.getParameterConfigurer("sParam");
        if (null != cfg) {
            cfg.addValue(paramValues, "abc");
        }
        try {
            service.reconfigure(paramValues);
        } catch (ExecutionException e) {
            LoggerFactory.getLogger(getClass()).error("Configuring initial parameter: " + e.getMessage());
        }
        appInstId = getAppInstIdSuffix(service, "_");
    }

    /**
    * Called when data arrived that shall be processed (synchronously).
    *
    * @return the data transformation functor
    */
    @Bean
    public Function<KRec13Anon, KRec13Anon> transformKRec13AnonKRec13Anon_KodexPythonService() {
        return data -> {
            MetricsProvider.increaseCounterBy(serviceSent, 1.0); 
            return service.processSyncQuiet("KRec13Anon", data, "KRec13Anon"); 
        };
    }
    

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass()).info("Initializing service KodexPythonService: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service); // service.getId() is "static"
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("KodexPythonService", sId, "KodexMeshApp", iId);
            serviceReceived = metrics.createServiceReceivedCounter("KodexPythonService", sId, "KodexMeshApp", iId);
            processingTime = metrics.createServiceProcessingTimer("KodexPythonService", sId, "KodexMeshApp", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            
            
        }
    }
    
    
}
