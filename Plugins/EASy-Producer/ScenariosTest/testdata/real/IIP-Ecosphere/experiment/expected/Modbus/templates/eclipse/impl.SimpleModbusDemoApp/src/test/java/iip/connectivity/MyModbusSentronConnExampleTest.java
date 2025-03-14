package iip.connectivity;

import java.io.IOException;

import de.iip_ecosphere.platform.connectors.ConnectorParameter;
import de.iip_ecosphere.platform.connectors.modbustcpipv1.ModbusTcpIpConnector;
import de.iip_ecosphere.platform.support.TimeUtils;
import de.iip_ecosphere.platform.transport.connectors.ReceptionCallback;
import de.iip_ecosphere.platform.transport.serialization.SerializerRegistry;

import iip.datatypes.ModbusSiemensRwSentron;
import iip.datatypes.ModbusSiemensSentron;
import iip.nodes.MyModbusSentronConnExample;
import iip.serializers.ModbusSiemensRwSentronImplSerializer;
import iip.serializers.ModbusSiemensRwSentronSerializer;
import iip.serializers.ModbusSiemensSentronImplSerializer;
import iip.serializers.ModbusSiemensSentronSerializer;

/**
 * Technical connection test for connector "myModbusSentronConn example".
 * Generated by: EASy-Producer.
 */
public class MyModbusSentronConnExampleTest {

    private static ReceptionCallback<ModbusSiemensSentron> callback = new ReceptionCallback<ModbusSiemensSentron>()
        {
    
        @Override
        public void received(ModbusSiemensSentron data) {
            System.out.println("Connector received: " + data);
        }
    
        @Override
        public Class<ModbusSiemensSentron> getType() {
            return ModbusSiemensSentron.class;
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
        SerializerRegistry.registerSerializer(ModbusSiemensSentronImplSerializer.class);
        SerializerRegistry.registerSerializer(ModbusSiemensSentronSerializer.class);
        SerializerRegistry.registerSerializer(ModbusSiemensRwSentronImplSerializer.class);
        SerializerRegistry.registerSerializer(ModbusSiemensRwSentronSerializer.class);
        
        // as configured, or create own and customize
        ConnectorParameter params = MyModbusSentronConnExample.createConnectorParameter();
            
        ModbusTcpIpConnector<ModbusSiemensSentron, ModbusSiemensRwSentron> conn = new ModbusTcpIpConnector<>(
            MyModbusSentronConnExample.createConnectorAdapter());
        Runtime.getRuntime()
            .addShutdownHook(new Thread(() -> conn.disconnectSafe()));
        conn.connect(params);
        conn.setReceptionCallback(callback);
        System.out.println("Connector myModbusSentronConn example created...");

        // wait for data
        System.out.println("Requesting data until <CTRL>+C...");
        while (true) {
            TimeUtils.sleep(300);
        }
    }

}
