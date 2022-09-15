

package iip.nodes;

import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.BlockingQueue;

import de.iip_ecosphere.platform.support.TimeUtils;
import de.iip_ecosphere.platform.support.iip_aas.ActiveAasBase;
import de.iip_ecosphere.platform.support.iip_aas.ActiveAasBase.NotificationMode;
import de.iip_ecosphere.platform.support.iip_aas.config.CmdLine;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.services.environment.*;
import de.iip_ecosphere.platform.support.resources.ResourceLoader;
import de.iip_ecosphere.platform.services.environment.spring.SpringAsyncServiceBase;
import de.iip_ecosphere.platform.transport.Transport;

import java.io.InputStream;
import org.hamcrest.core.IsAnything;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.*;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.cloud.stream.messaging.*;
import org.springframework.messaging.Message;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import iip.datatypes.*;
import iip.interfaces.*;
import iip.serializers.*;
import iip.nodes.*;

/**
* Implements tests for "SimpleDataReceiver3". The generated class is meant to be re-usable and extensible, e.g.,
* regarding the assert predicates. We provide a main method to ease startup. 
* There is no guarantee on the sequence of received data, in particular not when 
* the service is declared to be asynchronous. The test loads input data file from the system 
* property "iip.test.dataFile", "../../src/test/resources/testData-SimpleReceiver3.json", the default resource "testData-SimpleReceiver3.json" 
* or "resources/software" if you want to deploy it, e.g., in case of a mocked connector.
* The input data file is a JSON file, one data unit per line, following a generic structure per data unit. 
* A data unit consists of one optional object entry per input type of the service under test (attribute name
* is the type name with first character in small case) - the contents of the same structure as defined in the
* configuration model. The structure for this service is: {@code {"rec13": {"intField": m, "stringField": m}, "$period": p, "$repeats": r}}. Depending
* on your data type definitions in the model, individual fields may be mandatory (indicated by <i>m</i>), 
* optional (indicated by <i>o</i>) or nested fields (not indicated further). "$period" is 
* an optional generic entry that defines the delay period <i>p</i> between the actual
* and the next data entry (if unspecified the initial value is {@link #getInitialPeriod()}.
* "$repeats" is the number of repeats of the specifying line (0: none, positive: #repeats, negative: endless).
*
* @author EASy-Producer
*/        
@SpringBootTest(classes = iip.Starter.class)
@ImportAutoConfiguration(TestChannelBinderConfiguration.class)
@TestPropertySource(properties = {
    "spring.cloud.stream.bindings.receiveRec13_SimpleReceiver3-in-0.destination=transformRec13Rec13_SimpleTransformer3",
        "spring.cloud.stream.bindings.transformRec13Rec13_SimpleTransformer3-out-0.destination=transformRec13Rec13_SimpleTransformer3",
        "spring.cloud.function.definition=receiveRec13_SimpleReceiver3",
        "iip.service.SimpleReceiver3=true",
        "iip.service.SimpleSource3=false",
        "iip.service.SimpleTransformer3=false"})
@RunWith(SpringRunner.class)
public class SimpleDataReceiver3Test extends SpringAsyncServiceBase {

    private Map<Class<?>, Integer> received = new HashMap<>();
    private static String[] cmdArgs = new String[0];
    
    /**
    * Represents all potential inputs to the service and the JSON input format.
    *
    * @author EASy-Producer
    */
    public static class DataUnit extends DataMapper.BaseDataUnit {
    
        private Rec13Impl rec13;
        
    
        /**
        * Returns rec13.
        *
        * @return rec13, may be <b>null</b>
        */
        public Rec13Impl getRec13() {
            return rec13;
        }
        
        
        /**
        * Changes rec13. [required by Jackson]
        *
        * @param rec13, the new value, may be <b>null</b>
        */
        public void setRec13(Rec13Impl rec13) {
            this.rec13 = rec13;
        }
        
        
        @Override
        public String toString() {
            return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this, 
                de.iip_ecosphere.platform.services.environment.IipStringStyle.SHORT_STRING_STYLE);
        }
        
    }
    
    
    /**
    * Creates an instance and registers the application serializers.
    */
    public SimpleDataReceiver3Test() {
        SerializerRegistry.registerSerializer(iip.serializers.Rec13ImplSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.Rec13Serializer.class);
    }
    
    /**
    * Tests the service with a given JSON input stream.
    * 
    * @param in the Yaml input stream, will be closed
    * @throws IOException if the data cannot be loaded/mapped to the service input data
    */
    public void testService(InputStream in) throws IOException {
        try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
            TestChannelBinderConfiguration.getCompleteConfiguration())
                .web(WebApplicationType.NONE)
                .run()) {
            InputDestination source = context.getBean(InputDestination.class);
            OutputDestination target = context.getBean(OutputDestination.class);
        
            DataMapper.BaseMappingConsumer<DataUnit> consumer = 
                new DataMapper.BaseMappingConsumer<DataUnit>(DataUnit.class, getInitialPeriod());
            consumer.addHandler(Rec13Impl.class, d -> {
                Transport.send(c -> c.asyncSend("SimpleTransformer3_Rec13", d), "SimpleTransformer3", "transformRec13Rec13_SimpleTransformer3-in-0");
            });
            DataMapper.mapJsonData(in, DataUnit.class, consumer);
            
        }
    }
    
    /**
    * Tests the service with the file given in system property "iip.test.dataFile",  
    * "../../src/test/resources/testData-SimpleReceiver3.json" or the default resource "testData-SimpleReceiver3.json".
    *
    * @throws IOException of the data cannot be loaded/mapped to the service input data
    */
    public void testService() throws IOException {
        InputStream in;
        try {
            in = new java.io.FileInputStream(
                System.getProperty("iip.test.dataFile", "../../src/test/resources/testData-SimpleReceiver3.json"));
        } catch (IOException e) {
            in = ResourceLoader.getResourceAsStream("testData-SimpleReceiver3.json");
        }
        testService(in);
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
    * Tests the service with the default resource "testData-SimpleReceiver3.json".
    *
    * @throws IOException shall not occur / test failure
    */
    @Test
    public void testSimpleReceiver3Service() throws IOException {
        testService();
        Assert.assertTrue("Received counters not as expected", 
            createReceivedCounterAssertPredicate().test(Collections.unmodifiableMap(received)));            
    }
    
    
    /**
    * Starts the configured version of this service/connector as main program.
    *
    * @param args the command line arguments
    * @throws IOException shall not occur
    */
    public static void main(String[] args) throws IOException {
        cmdArgs = args;
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(SimpleDataReceiver3Test.class);
    }
    
}
