

package iip.nodes;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;

import de.iip_ecosphere.platform.support.*;
import de.iip_ecosphere.platform.support.iip_aas.ActiveAasBase;
import de.iip_ecosphere.platform.support.iip_aas.ActiveAasBase.NotificationMode;
import de.iip_ecosphere.platform.support.setup.CmdLine;
import de.iip_ecosphere.platform.support.resources.ResourceLoader;
import de.iip_ecosphere.platform.transport.Transport;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.services.environment.*;
import de.iip_ecosphere.platform.services.environment.spring.SpringAsyncServiceBase;

import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.*;
import de.iip_ecosphere.platform.connectors.ConnectorParameter;
import de.iip_ecosphere.platform.connectors.mqttv3.PahoMqttv3Connector;
import de.iip_ecosphere.platform.transport.connectors.ReceptionCallback;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.hamcrest.core.IsAnything;

import iip.datatypes.*;
import iip.serializers.*;
import iip.nodes.*;

/**
* Implements tests for "MyMqttConnExample". The generated class is meant to be re-usable and extensible, e.g.,
* regarding the assert predicates. We provide a main method to ease startup. 
* The connector test directly approaches the configured connector, i.e., the addressed device or server must 
* be accessible. The command line parameter {@code --iip.test.samplingTime=t} can specify the time <i>t</i> in 
* ms the connector will do sampling during the test (default <i>t</i>=10000).
*
* @author EASy-Producer
*/        
public class MyMqttConnExampleTest {

    private Map<Class<?>, Integer> received = new HashMap<>();
    private static String[] cmdArgs = new String[0];
    
    /**
    * Represents all potential inputs to the service and the JSON input format.
    *
    * @author EASy-Producer
    */
    public static class DataUnit extends DataMapper.BaseDataUnit {
    
        private MyConnPltfOut myConnPltfOut;
        
    
        /**
        * Returns myConnPltfOut.
        *
        * @return myConnPltfOut, may be <b>null</b>
        */
        public MyConnPltfOut getMyConnPltfOut() {
            return myConnPltfOut;
        }
        
        
        /**
        * Changes myConnPltfOut. [required by Jackson]
        *
        * @param myConnPltfOut, the new value, may be <b>null</b>
        */
        public void setMyConnPltfOut(MyConnPltfOut myConnPltfOut) {
            this.myConnPltfOut = myConnPltfOut;
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
            super("myMqttConn matcher");
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
    public MyMqttConnExampleTest() {
        SerializerRegistry.registerSerializer(iip.serializers.AvaMqttOutputSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MipMqttInputSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MipMqttOutputSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MyConnMachineInSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MyConnMachineOutSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MyConnPltfInSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MyConnPltfOutSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MyNestedSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.Rec1Serializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.TestTypeSerializer.class);
    }
    
    /**
    * Tests the connector.
    *
    * @param params the connector parameter to use
    * @param callback the callback to attach to the connector
    *
    * @throws IOException shall not occur
    */
    protected void testConnector(ConnectorParameter params, ReceptionCallback<MyConnPltfIn> callback) throws IOException {
        ActiveAasBase.setNotificationMode(NotificationMode.NONE); // disable AAS connector registration
        de.iip_ecosphere.platform.connectors.mqttv3.PahoMqttv3Connector<MyConnPltfIn, MyConnPltfOut> conn = 
            new de.iip_ecosphere.platform.connectors.mqttv3.PahoMqttv3Connector<>(MyMqttConnExample.createConnectorAdapter());
        conn.connect(params);
        conn.setReceptionCallback(callback);
        conn.request(true);
        System.out.println("Disconnecting...");
        conn.disconnect();
    }
    
    /**
    * Returns the connector parameter to be used.
    *
    * @return the connector parameter, by default as configured in the model
    */
    protected ConnectorParameter createConnectorParameter() {
        return MyMqttConnExample.createConnectorParameter();
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
    * Creates/returns a predicate asserting that the received data of type MyConnPltfIn
    * as output of the testing object is ok (or not). Allows for overriding the test behavior
    * with "semantic" expectations.
    *
    * @return the predicate (default: lambda function always returning {@code true})
    */ 
    protected Predicate<MyConnPltfIn> getAssertPredicateMyConnPltfIn() {
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
    * Tests the connector, here whether the connector (parameterized by 
    * {@link #createConnectorParameter()} delivered any data.
    *
    * @throws IOException shall not occur / test failure
    */
    @Test
    public void testConnector() throws IOException {
        MyMqttConnExampleTest test = new MyMqttConnExampleTest();
        AtomicInteger counter = new AtomicInteger(0);
        ReceptionCallback<MyConnPltfIn> callback = new ReceptionCallback<MyConnPltfIn>() {
        
            @Override
            public void received(MyConnPltfIn data) {
                counter.incrementAndGet();
                printReceivedData(data);
                incrementReceived(MyConnPltfIn.class);
            }
            
            @Override
            public Class<MyConnPltfIn> getType() {
                return MyConnPltfIn.class;
            }
            
        };
        test.testConnector(test.createConnectorParameter(), callback);
        Assert.assertTrue("Connector does not deliver data", counter.get() > 0);
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
        MyMqttConnExampleTest test = new MyMqttConnExampleTest();
        ReceptionCallback<MyConnPltfIn> callback = new ReceptionCallback<MyConnPltfIn>() {
        
            @Override
            public void received(MyConnPltfIn data) {
                System.out.println(data);
            }
            
            @Override
            public Class<MyConnPltfIn> getType() {
                return MyConnPltfIn.class;
            }
            
        };
        test.testConnector(test.createConnectorParameter(), callback);
        System.exit(0);
    }
    
}
