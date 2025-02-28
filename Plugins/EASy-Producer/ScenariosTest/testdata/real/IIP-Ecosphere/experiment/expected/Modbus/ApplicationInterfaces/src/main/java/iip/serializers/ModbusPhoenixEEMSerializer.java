package iip.serializers;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import de.iip_ecosphere.platform.transport.serialization.Serializer;
import iip.datatypes.*;

/**
 * JSON transport serializer for ModbusPhoenixEEM.
 * Generated by: EASy-Producer.
 */
public class ModbusPhoenixEEMSerializer implements Serializer<ModbusPhoenixEEM> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    static {
        JsonUtils.handleIipDataClasses(MAPPER);
    }

    @Override             
    public ModbusPhoenixEEM from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, ModbusPhoenixEEMImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(ModbusPhoenixEEM source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public ModbusPhoenixEEM clone(ModbusPhoenixEEM origin) throws IOException {
        return new ModbusPhoenixEEMImpl(origin);
    }

    @Override
    public Class<ModbusPhoenixEEM> getType() {
        return ModbusPhoenixEEM.class;
    }

}

