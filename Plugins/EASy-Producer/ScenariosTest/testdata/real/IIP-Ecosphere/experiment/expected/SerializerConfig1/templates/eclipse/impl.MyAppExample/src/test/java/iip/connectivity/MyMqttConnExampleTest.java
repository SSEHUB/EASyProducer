package iip.connectivity;

import java.io.IOException;

import de.iip_ecosphere.platform.connectors.ConnectorParameter;
import de.iip_ecosphere.platform.connectors.mqttv3.PahoMqttv3Connector;
import de.iip_ecosphere.platform.support.TimeUtils;
import de.iip_ecosphere.platform.transport.connectors.ReceptionCallback;
import de.iip_ecosphere.platform.transport.serialization.SerializerRegistry;

import iip.datatypes.MyConnPltfIn;
import iip.datatypes.MyConnPltfOut;
import iip.nodes.MyMqttConnExample;
import iip.serializers.MyConnPltfInImplSerializer;
import iip.serializers.MyConnPltfInSerializer;
import iip.serializers.MyConnPltfOutImplSerializer;
import iip.serializers.MyConnPltfOutSerializer;

/**
 * Technical connection test for connector "myMqttConnExample".
 * Generated by: EASy-Producer.
 */
public class MyMqttConnExampleTest {

    private static ReceptionCallback<MyConnPltfIn> callback = new ReceptionCallback<MyConnPltfIn>() {
    
        @Override
        public void received(MyConnPltfIn data) {
            System.out.println("Connector received: " + data);
        }
    
        @Override
        public Class<MyConnPltfIn> getType() {
            return MyConnPltfIn.class;
        }
    
    };

    /**
     * Main program.
     * 
     * @param args ignored
     *
     * @throws IOException if intended connectivity fails
     */
    public static void main(String[] args) throws IOException {
        SerializerRegistry.registerSerializer(MyConnPltfInImplSerializer.class);
        SerializerRegistry.registerSerializer(MyConnPltfInSerializer.class);
        SerializerRegistry.registerSerializer(MyConnPltfOutImplSerializer.class);
        SerializerRegistry.registerSerializer(MyConnPltfOutSerializer.class);
        
        // as configured, or create own and customize
        ConnectorParameter params = MyMqttConnExample.createConnectorParameter();
            
        PahoMqttv3Connector<MyConnPltfIn, MyConnPltfOut> conn = new PahoMqttv3Connector<>(MyMqttConnExample.
            createConnectorAdapter());
        Runtime.getRuntime()
            .addShutdownHook(new Thread(() -> conn.disconnectSafe()));
        conn.connect(params);
        conn.setReceptionCallback(callback);
        System.out.println("Connector myMqttConnExample created...");

        // wait for data
        System.out.println("Requesting data until <CTRL>+C...");
        while (true) {
            TimeUtils.sleep(300);
        }
    }

}
