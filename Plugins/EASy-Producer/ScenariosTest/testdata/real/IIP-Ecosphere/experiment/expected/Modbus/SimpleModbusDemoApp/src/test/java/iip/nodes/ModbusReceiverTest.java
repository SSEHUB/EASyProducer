


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

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.hamcrest.core.IsAnything;

import iip.datatypes.*;
import iip.serializers.*;
import iip.nodes.*;
import iip.interfaces.*;

/**
* Implements tests for "ModbusReceiver". The generated class is meant to be re-usable and extensible, e.g.,
* regarding the assert predicates. We provide a main method to ease startup. 
* There is no guarantee on the sequence of received data, in particular not when 
* the service is declared to be asynchronous. The test loads input data file from the system 
* property "iip.test.dataFile", "../../src/test/resources/testData-ModbusReceiver.json", the default resource "testData-ModbusReceiver.json" 
* or "resources/software" if you want to deploy it, e.g., in case of a mocked connector.
* The input data file is a JSON file, one data unit per line, following a generic structure per data unit. 
* A data unit consists of one optional object entry per input type of the service under test (attribute name
* is the type name with first character in small case) - the contents of the same structure as defined in the
* configuration model. The structure for this service is: {@code {"modbusPhoenixEEM": {"Day": m, "Month": m, "Year": m, "U1": m, "frequency": m, "I1": m}, "modbusSiemensSentron": {"DisplayContrast": m, "DisplayBrightness": m, "BrightnessDuration": m, "Frequency": m, "VoltageL1N": m, "CurrentL1": m}, "$period": p, "$repeats": r}}. Depending
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
    "spring.cloud.function.definition=createModbusPhoenixEEM_myModbusConn;createModbusSiemensSentron_myModbusSentronConn",
        "spring.cloud.stream.source=",
        "iip.service.ModbusReceiver=true",
        "iip.service.myModbusConn=false",
        "iip.service.myModbusSentronConn=false"})
@RunWith(SpringRunner.class)
public class ModbusReceiverTest extends SpringAsyncServiceBase {

    private Map<Class<?>, Integer> received = new HashMap<>();
    private static String[] cmdArgs = new String[0];
    
    /**
    * Represents all potential inputs to the service and the JSON input format.
    *
    * @author EASy-Producer
    */
    public static class DataUnit extends DataMapper.BaseDataUnit {
    
        private ModbusPhoenixEEMImpl modbusPhoenixEEM;
        private ModbusSiemensSentronImpl modbusSiemensSentron;
        
    
        /**
        * Returns modbusPhoenixEEM.
        *
        * @return modbusPhoenixEEM, may be <b>null</b>
        */
        public ModbusPhoenixEEMImpl getModbusPhoenixEEM() {
            return modbusPhoenixEEM;
        }
        /**
        * Returns modbusSiemensSentron.
        *
        * @return modbusSiemensSentron, may be <b>null</b>
        */
        public ModbusSiemensSentronImpl getModbusSiemensSentron() {
            return modbusSiemensSentron;
        }
        
        
        /**
        * Changes modbusPhoenixEEM. [required by Jackson]
        *
        * @param modbusPhoenixEEM, the new value, may be <b>null</b>
        */
        public void setModbusPhoenixEEM(ModbusPhoenixEEMImpl modbusPhoenixEEM) {
            this.modbusPhoenixEEM = modbusPhoenixEEM;
        }
        /**
        * Changes modbusSiemensSentron. [required by Jackson]
        *
        * @param modbusSiemensSentron, the new value, may be <b>null</b>
        */
        public void setModbusSiemensSentron(ModbusSiemensSentronImpl modbusSiemensSentron) {
            this.modbusSiemensSentron = modbusSiemensSentron;
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
    public ModbusReceiverTest() {
        SerializerRegistry.registerSerializer(iip.serializers.AvaMqttOutputImplSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.AvaMqttOutputSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MipMqttInputImplSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MipMqttInputSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MipMqttOutputImplSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.MipMqttOutputSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.ModbusPhoenixEEMImplSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.ModbusPhoenixEEMSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.ModbusPhoenixRwEEMImplSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.ModbusPhoenixRwEEMSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.ModbusSiemensRwSentronImplSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.ModbusSiemensRwSentronSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.ModbusSiemensSentronImplSerializer.class);
        SerializerRegistry.registerSerializer(iip.serializers.ModbusSiemensSentronSerializer.class);
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
    
            iip.Starter.getSetup(); // force initializing Transport
            DataMapper.BaseMappingConsumer<DataUnit> consumer = 
                new DataMapper.BaseMappingConsumer<DataUnit>(DataUnit.class, getInitialPeriod());
            consumer.addHandler(ModbusPhoenixEEMImpl.class, d -> {
                                        // one for spring - ignored if async
                                        Transport.send(c -> c.asyncSend("createModbusPhoenixEEM_myModbusConn", d), "myModbusConn", "createModbusPhoenixEEM_myModbusConn-in-0");
                                        // one for async via transport - ignored if spring
                                        Transport.send(c -> c.asyncSend("data_myModbusConn_ModbusPhoenixEEM_ModbusApp", d), "myModbusConn", "createModbusPhoenixEEM_myModbusConn-in-0");
                                    });
            consumer.addHandler(ModbusSiemensSentronImpl.class, d -> {
                                        // one for spring - ignored if async
                                        Transport.send(c -> c.asyncSend("createModbusSiemensSentron_myModbusSentronConn", d), "myModbusSentronConn", "createModbusSiemensSentron_myModbusSentronConn-in-0");
                                        // one for async via transport - ignored if spring
                                        Transport.send(c -> c.asyncSend("data_myModbusSentronConn_ModbusSiemensSentron_ModbusApp", d), "myModbusSentronConn", "createModbusSiemensSentron_myModbusSentronConn-in-0");
                                    });
            
            DataMapper.mapJsonData(in, DataUnit.class, consumer);
            TimeUtils.sleep(3000); // if context is not ready
            context.close();
            detach();
            LoggerFactory.getLogger(getClass()).info("Test done. Cooling down for 1s");
            TimeUtils.sleep(1000);
        }
    }
    
    /**
    * After the test (class): If there are still service threads hanging around, get rid of them.
    */      
    @AfterClass
    public static void after() {
        System.exit(0); // no other way known so far, binders survive, not suitable for jUnit
    }
    
    /**
    * Tests the service with the file given in system property "iip.test.dataFile",  
    * "../../src/test/resources/testData-ModbusReceiver.json" or the default resource "testData-ModbusReceiver.json".
    *
    * @throws IOException of the data cannot be loaded/mapped to the service input data
    */
    public void testService() throws IOException {
        InputStream in;
        try {
            String fileName = System.getProperty("iip.test.dataFile", "../../src/test/resources/testData-ModbusReceiver.json");
            LoggerFactory.getLogger(getClass()).info("Opening {}", fileName);
            in = new FileInputStream(fileName);
        } catch (IOException e) {
            in = ResourceLoader.getResourceAsStream("testData-ModbusReceiver.json");
        }
        if (null != in) {
            testService(in);
        } else {
            LoggerFactory.getLogger(getClass()).error("No test data found. Skipping test.");
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
    * Tests the service with the default resource "testData-ModbusReceiver.json".
    *
    * @throws IOException shall not occur / test failure
    */
    @Test
    public void testModbusReceiverService() throws IOException {
        NotificationMode oldM = ActiveAasBase.setNotificationMode(NotificationMode.NONE);
        testService();
        Assert.assertTrue("Received counters not as expected", 
            createReceivedCounterAssertPredicate().test(Collections.unmodifiableMap(received)));
        Service svc = iip.Starter.getMappedService("ModbusReceiver");
        if (null != svc) {
            try {
                LoggerFactory.getLogger(getClass()).info("Service autostop (test): ModbusReceiver");
                svc.setState(ServiceState.STOPPING);
            } catch (ExecutionException e) {
                LoggerFactory.getLogger(getClass()).error("Stopping service ModbusReceiver: {}", e.getMessage());
            }
        }
        ActiveAasBase.setNotificationMode(oldM);
    }
    
    
    /**
    * Starts the configured version of this service/connector as main program.
    *
    * @param args the command line arguments
    * @throws IOException shall not occur
    */
    public static void main(String[] args) throws IOException {
        cmdArgs = args;
        iip.Starter.setServiceAutostart(true);
        iip.Starter.setOnServiceAutostartAttachShutdownHook(false);
        
        YamlService yaml = YamlArtifact.readFromYamlSafe(ResourceLoader.getResourceAsStream("deployment.yml"))
            .getServiceSafe("ModbusReceiver");
        File f = FileUtils.findFile(new File(".."), "SimpleModbusDemoApp-0.1.0-SNAPSHOT-bin.jar");
        if (null != f && null != yaml.getProcess()) {
            Starter.extractProcessArtifacts("ModbusReceiver", yaml.getProcess(), f, null);
        } else {
            LoggerFactory.getLogger(ModbusReceiverTest.class).info("Service artifact {} not found in {}", "SimpleModbusDemoApp-0.1.0-SNAPSHOT-bin.jar", "..");
        }
        
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(ModbusReceiverTest.class);
    }
    
}
