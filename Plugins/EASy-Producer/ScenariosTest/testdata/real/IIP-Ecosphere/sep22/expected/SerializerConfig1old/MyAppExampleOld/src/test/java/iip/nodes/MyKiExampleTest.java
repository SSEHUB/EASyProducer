

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
* Implements tests for "MyKiExample". The generated class is meant to be re-usable and extensible, e.g.,
* regarding the assert predicates. We provide a main method to ease startup. 
* There is no guarantee on the sequence of received data, in particular not when 
* the service is declared to be asynchronous. The test loads input data file from the system 
* property "iip.test.dataFile", "../../src/test/resources/testData-myKi.json", the default resource "testData-myKi.json" 
* or "resources/software" if you want to deploy it, e.g., in case of a mocked connector.
* The input data file is a JSON file, one data unit per line, following a generic structure per data unit. 
* A data unit consists of one optional object entry per input type of the service under test (attribute name
* is the type name with first character in small case) - the contents of the same structure as defined in the
* configuration model. The structure for this service is: {@code {"rec1": {"intField": m, "stringField": m}, "$period": p, "$repeats": r}}. Depending
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
    "spring.cloud.stream.bindings.receiveString_MyReceiver-in-0.destination=transformString_myKi",
        "spring.cloud.stream.bindings.transformRec1String_myKi-in-0.destination=processRec1_myAnonymizer",
        "spring.cloud.stream.bindings.transformRec1String_myKi-in-0.useNativeEncoding=true",
        "spring.cloud.stream.bindings.transformString_myKi-out-0.destination=transformString_myKi",
        "spring.cloud.function.definition=transformRec1String_myKi;transformString_myKi",
        "iip.service.myAnonymizer=false",
        "iip.service.myKi=true",
        "iip.service.myMqttConn=false",
        "iip.service.myOpcConn=false",
        "iip.service.MyReceiver=false",
        "iip.service.mySource=false"})
@RunWith(SpringRunner.class)
public class MyKiExampleTest extends SpringAsyncServiceBase {

    private TestMatcher matcher = new TestMatcher();
    private Map<Class<?>, Integer> received = new HashMap<>();
    private static String[] cmdArgs = new String[0];
    
    /**
    * Represents all potential inputs to the service and the JSON input format.
    *
    * @author EASy-Producer
    */
    public static class DataUnit extends DataMapper.BaseDataUnit {
    
        private Rec1 rec1;
        
    
        /**
        * Returns rec1.
        *
        * @return rec1, may be <b>null</b>
        */
        public Rec1 getRec1() {
            return rec1;
        }
        
        
        /**
        * Changes rec1. [required by Jackson]
        *
        * @param rec1, the new value, may be <b>null</b>
        */
        public void setRec1(Rec1 rec1) {
            this.rec1 = rec1;
        }
        
        
        @Override
        public String toString() {
            return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this, 
                de.iip_ecosphere.platform.services.environment.IipStringStyle.SHORT_STRING_STYLE);
        }
        
    }
    
    /**
    * A predicate-based matcher for spring-based output testing. Class generated here, because we do not want to 
    * include the testing artifact of services.environment and hamcrest shall not be a major production dependency.
    *
    * @author EASy-Producer
    */
    private class TestMatcher extends IsAnything<Object> {
    
        private Map<Class<?>, Predicate<?>> predicates = new HashMap<>();
    
        /**
        * Creates an instance.
        */
        public TestMatcher() {
            super("myKi matcher");
        }
        
        /**
        * Adds a predicate for a given type.
        * 
        * @param <T> the type of data to be considered by the predicate
        * @param cls the type to add the predicate for
        * @param pred the predicate
        */
        private <T> void addPredicate(Class<T> cls, Predicate<T> pred) {
            predicates.put(cls, pred);
        }
    
        @Override
        public boolean matches(Object obj) {
            return test(obj);
        }
        
        /**
        * Does a typed test against {@link #predicates}.
        *
        * @param <T> the type of data to be considered by the test
        * @param obj the data/object to be tested
        * @return whether {@code obj} matches the condition of a registered predicate or {@code true} if none was 
        *     registered
        */
        private <T> boolean test(T obj) {
            incrementReceived(obj.getClass());
            printReceivedData(obj);
            @SuppressWarnings("unchecked")
            Predicate<T> pred = (Predicate<T>) predicates.get(obj.getClass());
            return null == pred ? true : pred.test(obj);
        }
    };
    
    
    
    /**
    * Creates an instance and registers the application serializers.
    */
    public MyKiExampleTest() {
        SerializerRegistry.registerSerializer(iip.serializers.MyConnMachineInSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MyConnMachineOutSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MyConnPltfInSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MyConnPltfOutSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.Rec1Serializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.TestTypeSerializer.class);
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
            consumer.addHandler(Rec1.class, d -> {
                Message<Rec1> msg = MessageBuilder.withPayload(d).build();
                source.send(msg);
                Assert.assertThat(target.receive().getPayload(), matcher);
            });
            DataMapper.mapJsonData(in, DataUnit.class, consumer);
            final Predicate<String> predString = getAssertPredicateString();
            createReceptionCallback("myKi_String", d -> {
                incrementReceived(String.class); 
                printReceivedData(d);
                Assert.assertTrue(predString.test(d));
            }, String.class);
        }
    }
    
    /**
    * Tests the service with the file given in system property "iip.test.dataFile",  
    * "../../src/test/resources/testData-myKi.json" or the default resource "testData-myKi.json".
    *
    * @throws IOException of the data cannot be loaded/mapped to the service input data
    */
    public void testService() throws IOException {
        InputStream in;
        try {
            in = new java.io.FileInputStream(
                System.getProperty("iip.test.dataFile", "../../src/test/resources/testData-myKi.json"));
        } catch (IOException e) {
            in = ResourceLoader.getResourceAsStream("testData-myKi.json");
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
    * Creates/returns a predicate asserting that the received data of type String
    * as output of the testing object is ok (or not). Allows for overriding the test behavior
    * with "semantic" expectations.
    *
    * @return the predicate (default: lambda function always returning {@code true})
    */ 
    protected Predicate<String> getAssertPredicateString() {
        return d -> true;
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
    * Tests the service with the default resource "testData-myKi.json".
    *
    * @throws IOException shall not occur / test failure
    */
    @Test
    public void testMyKiService() throws IOException {
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
        junit.run(MyKiExampleTest.class);
    }
    
}
