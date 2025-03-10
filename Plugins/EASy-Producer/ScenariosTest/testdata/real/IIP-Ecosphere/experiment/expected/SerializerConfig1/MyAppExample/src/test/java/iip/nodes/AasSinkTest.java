package iip.nodes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

import de.iip_ecosphere.platform.services.environment.DataMapper;
import de.iip_ecosphere.platform.services.environment.DataMapper.BaseDataUnit;
import de.iip_ecosphere.platform.services.environment.DataMapper.BaseMappingConsumer;
import de.iip_ecosphere.platform.services.environment.IipStringStyle;
import de.iip_ecosphere.platform.services.environment.Service;
import de.iip_ecosphere.platform.services.environment.ServiceState;
import de.iip_ecosphere.platform.services.environment.YamlArtifact;
import de.iip_ecosphere.platform.services.environment.YamlService;
import de.iip_ecosphere.platform.services.environment.spring.SpringAsyncServiceBase;
import de.iip_ecosphere.platform.support.FileUtils;
import de.iip_ecosphere.platform.support.TimeUtils;
import de.iip_ecosphere.platform.support.iip_aas.ActiveAasBase;
import de.iip_ecosphere.platform.support.iip_aas.ActiveAasBase.NotificationMode;
import de.iip_ecosphere.platform.support.resources.ResourceLoader;
import de.iip_ecosphere.platform.transport.Transport;
import de.iip_ecosphere.platform.transport.serialization.SerializerRegistry;

import iip.Starter;
import iip.datatypes.RtsaTestOutputImpl;
import iip.serializers.AvaMqttOutputImplSerializer;
import iip.serializers.AvaMqttOutputSerializer;
import iip.serializers.MipMqttInputImplSerializer;
import iip.serializers.MipMqttInputSerializer;
import iip.serializers.MipMqttOutputImplSerializer;
import iip.serializers.MipMqttOutputSerializer;
import iip.serializers.MyConnMachineInImplSerializer;
import iip.serializers.MyConnMachineInSerializer;
import iip.serializers.MyConnMachineOutImplSerializer;
import iip.serializers.MyConnMachineOutSerializer;
import iip.serializers.MyConnPltfInImplSerializer;
import iip.serializers.MyConnPltfInSerializer;
import iip.serializers.MyConnPltfOutImplSerializer;
import iip.serializers.MyConnPltfOutSerializer;
import iip.serializers.MyNestedImplSerializer;
import iip.serializers.MyNestedSerializer;
import iip.serializers.Rec1ImplSerializer;
import iip.serializers.Rec1Serializer;
import iip.serializers.RtsaTestInputImplSerializer;
import iip.serializers.RtsaTestInputSerializer;
import iip.serializers.RtsaTestOutputImplSerializer;
import iip.serializers.RtsaTestOutputSerializer;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;

/**
 * Implements tests for "AasSink". The generated class is meant to be re-usable and extensible, e.g., regarding the
 * assert predicates. We provide a main method to ease startup.
 * There is no guarantee on the sequence of received data, in particular not when the service is declared to be
 * asynchronous. The test loads input data file from the system property "iip.test.dataFile",
 * "../../src/test/resources/testData-aasSink.json", the default resource "testData-aasSink.json"
 * or "resources/software" if you want to deploy it, e.g., in case of a mocked connector. The
 * input data file is a JSON file, one data unit per line, following a generic structure per data unit. A data unit
 * consists of one optional object entry per input type of the service under test (attribute name is the type name
 * with first character in small case) - the contents of the same structure as defined in the configuration model.
 * The structure for this service is: {@code {"rtsaTestOutput": {"id": m, "value1": m, "value2": m,
 * "confidence": m, "prediction": m}, "$period": p, "$repeats": r}}. Depending on your data type definitions in the
 * model, individual fields may be mandatory (indicated by <i>m</i>), optional (indicated by <i>o</i>) or nested
 * fields (not indicated further). "$period" is an optional generic entry that defines the delay period <i>p</i>
 * between the actual and the next data entry (if unspecified the initial value is {@link
 * #getInitialPeriod()}. "$repeats" is the number of repeats of the specifying line (0: none, positive:
 * #repeats, negative: endless).
 * Generated by: EASy-Producer.
 */
@SpringBootTest(classes = Starter.class)
@ImportAutoConfiguration(TestChannelBinderConfiguration.class)
@TestPropertySource(properties = {
"spring.cloud.function.definition=receiveRtsaTestOutput_aasSink",
"spring.cloud.stream.source=data_processRtsaTestOutput_myRtsa_myApp",
"iip.service.aasSink=true",
"iip.service.myAnonymizer=false",
"iip.service.myKiFamily=false",
"iip.service.myMqttConn=false",
"iip.service.myOpcConn=false",
"iip.service.myRtsa=false",
"iip.service.mySource=false"})
@RunWith(SpringRunner.class)
public class AasSinkTest extends SpringAsyncServiceBase {

    private Map<Class<?>, Integer> received = new HashMap<>();
    private static String[] cmdArgs = new String[0];
    
    /**
    * Represents all potential inputs to the service and the JSON input format.
    */
    public static class DataUnit extends BaseDataUnit {
    
        private RtsaTestOutputImpl rtsaTestOutput;
        
        /**
        * Returns the value of rtsaTestOutput.
        *
        * @return the value of rtsaTestOutput, may be <b>null</b>
        */
        public RtsaTestOutputImpl getRtsaTestOutput() {
            return rtsaTestOutput;
        }
        
        /**
        * Changes the value of rtsaTestOutput. [required by Jackson]
        *
        * @param rtsaTestOutput the new value, may be <b>null</b>
        */
        public void setRtsaTestOutput(RtsaTestOutputImpl rtsaTestOutput) {
            this.rtsaTestOutput = rtsaTestOutput;
        }
        
        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this, IipStringStyle.SHORT_STRING_STYLE);
        }
        
    }
    
    /**
    * Creates an instance and registers the application serializers.
    */
    public AasSinkTest() {
        SerializerRegistry.registerSerializer(AvaMqttOutputImplSerializer.class);
        SerializerRegistry.registerSerializer(AvaMqttOutputSerializer.class);
        SerializerRegistry.registerSerializer(MipMqttInputImplSerializer.class);
        SerializerRegistry.registerSerializer(MipMqttInputSerializer.class);
        SerializerRegistry.registerSerializer(MipMqttOutputImplSerializer.class);
        SerializerRegistry.registerSerializer(MipMqttOutputSerializer.class);
        SerializerRegistry.registerSerializer(MyConnMachineInImplSerializer.class);
        SerializerRegistry.registerSerializer(MyConnMachineInSerializer.class);
        SerializerRegistry.registerSerializer(MyConnMachineOutImplSerializer.class);
        SerializerRegistry.registerSerializer(MyConnMachineOutSerializer.class);
        SerializerRegistry.registerSerializer(MyConnPltfInImplSerializer.class);
        SerializerRegistry.registerSerializer(MyConnPltfInSerializer.class);
        SerializerRegistry.registerSerializer(MyConnPltfOutImplSerializer.class);
        SerializerRegistry.registerSerializer(MyConnPltfOutSerializer.class);
        SerializerRegistry.registerSerializer(MyNestedImplSerializer.class);
        SerializerRegistry.registerSerializer(MyNestedSerializer.class);
        SerializerRegistry.registerSerializer(Rec1ImplSerializer.class);
        SerializerRegistry.registerSerializer(Rec1Serializer.class);
        SerializerRegistry.registerSerializer(RtsaTestInputImplSerializer.class);
        SerializerRegistry.registerSerializer(RtsaTestInputSerializer.class);
        SerializerRegistry.registerSerializer(RtsaTestOutputImplSerializer.class);
        SerializerRegistry.registerSerializer(RtsaTestOutputSerializer.class);
    }
    
    /**
    * Tests the service with a given JSON input stream.
    * 
    * @param in the Yaml input stream, will be closed
    * 
    * @throws IOException if the data cannot be loaded/mapped to the service input data
    */
    public void testService(InputStream in) throws IOException {
        try (ConfigurableApplicationContext context = new SpringApplicationBuilder(TestChannelBinderConfiguration.
            getCompleteConfiguration()).web(WebApplicationType.NONE).run()) {
            InputDestination source = context.getBean(InputDestination.class);
            OutputDestination target = context.getBean(OutputDestination.class);
            // force initializing Transport
            Starter.getSetup();
            BaseMappingConsumer<DataUnit> consumer = new BaseMappingConsumer<DataUnit>(DataUnit.class, getInitialPeriod(
                ));
            consumer.addHandler(RtsaTestOutputImpl.class, d -> {
                // one for spring - ignored if async
                Transport.send(c -> c.asyncSend("processRtsaTestOutput_myRtsa", d), "myRtsa", 
                    "processRtsaTestOutput_myRtsa-in-0");
                // one for async via transport - ignored if spring
                Transport.send(c -> c.asyncSend("data_myRtsa_RtsaTestOutput_myApp", d), "myRtsa", 
                    "processRtsaTestOutput_myRtsa-in-0");
            });
            
            DataMapper.mapJsonData(in, DataUnit.class, consumer);
            // if context is not ready
            TimeUtils.sleep(3000);
            context.close();
            detach();
            LoggerFactory.getLogger(getClass())
                .info("Test done. Cooling down for 1s");
            TimeUtils.sleep(1000);
        }
    }
    
    /**
    * After the test (class): If there are still service threads hanging around, get rid of them.
    */      
    @AfterClass
    public static void after() {
        // no other way known so far, binders survive, not suitable for jUnit
        System.exit(0);
    }
    
    /**
    * Tests the service with the file given in system property "iip.test.dataFile",  
    * "../../src/test/resources/testData-aasSink.json" or the default resource 
    * "testData-aasSink.json".
    *
    * @throws IOException if the data cannot be loaded/mapped to the service input data
    */
    public void testService() throws IOException {
        InputStream in;
        try {
            String fileName = System.getProperty("iip.test.dataFile", "../../src/test/resources/testData-aasSink.json");
            LoggerFactory.getLogger(getClass())
                .info("Opening {}", fileName);
            in = new FileInputStream(fileName);
        } catch (IOException e) {
            in = ResourceLoader.getResourceAsStream("testData-aasSink.json");
        }
        if (null != in) {
            testService(in);
        } else {
            LoggerFactory.getLogger(getClass())
                .error("No test data found. Skipping test.");
        }
    }
    
    /**
    * Increments the received counter for the given data {@code type}.
    *
    * @param type the type to increment the counter for
    */
    private void incrementReceived(Class<?> type) {
        if (received.containsKey(type)) {
            received.put(type, received.get(type) + 1);
        } else {
            received.put(type, 1);
        }
    }
    
    
    /**
    * Returns the predicate to assert the counters for received data type instances.
    *
    * @return the predicate (by default, a predicate with constant value {@code true})
    */
    protected Predicate<Map<Class<?>, Integer>> createReceivedCounterAssertPredicate() {
        return m -> true;
    }
    
    /**
    * Prints the received data. Can be overridden.
    *
    * @param data the received data
    */
    protected void printReceivedData(Object data) {
        System.out.println(data);
    }
    
    /**
    * Returns the initial period.
    *
    * @return the initial period in ms, no (initial) input delay happens if the value is zero or negative
    */
    protected int getInitialPeriod() {
        return 500;
    } 

    /**
    * Tests the service with the default resource "testData-aasSink.json".
    *
    * @throws IOException shall not occur / test failure
    */
    @Test
    public void testAasSinkService() throws IOException {
        NotificationMode oldM = ActiveAasBase.setNotificationMode(NotificationMode.NONE);
        testService();
        assertTrue("Received counters not as expected", createReceivedCounterAssertPredicate().test(Collections.
            unmodifiableMap(received)));
        Service svc = Starter.getMappedService("aasSink");
        if (null != svc) {
            try {
                LoggerFactory.getLogger(getClass())
                    .info("Service autostop (test): aasSink");
                svc.setState(ServiceState.STOPPING);
            } catch (ExecutionException e) {
                LoggerFactory.getLogger(getClass())
                    .error("Stopping service aasSink: {}", e.getMessage());
            }
        }
        ActiveAasBase.setNotificationMode(oldM);
    }
    
    
    /**
    * Starts the configured version of this service/connector as main program.
    *
    * @param args command line arguments
    * 
    * @throws IOException shall not occur
    */
    public static void main(String[] args) throws IOException {
        cmdArgs = args;
        Starter.setServiceAutostart(true);
        Starter.setOnServiceAutostartAttachShutdownHook(false);
        
        YamlService yaml = YamlArtifact.readFromYamlSafe(ResourceLoader.getResourceAsStream("deployment.yml"))
            .getServiceSafe("aasSink");
        File f = FileUtils.findFile(new File(".."), "MyAppExample-0.1.0-SNAPSHOT-bin.jar");
        if (null != f && null != yaml.getProcess()) {
            Starter.extractProcessArtifacts("aasSink", yaml.getProcess(), f, null);
        } else {
            LoggerFactory.getLogger(AasSinkTest.class)
                .info("Service artifact {} not found in {}", "MyAppExample-0.1.0-SNAPSHOT-bin.jar", "..");
        }
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(AasSinkTest.class);
    }

}
