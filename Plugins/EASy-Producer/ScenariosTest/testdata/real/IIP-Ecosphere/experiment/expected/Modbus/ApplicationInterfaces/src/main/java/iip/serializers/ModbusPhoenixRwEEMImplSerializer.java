package iip.serializers;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import de.iip_ecosphere.platform.transport.serialization.Serializer;
import iip.datatypes.*;

/**
 * JSON transport serializer for ModbusPhoenixRwEEM.
 * Generated by: EASy-Producer.
 */
public class ModbusPhoenixRwEEMImplSerializer implements Serializer<ModbusPhoenixRwEEMImpl> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    static {
        JsonUtils.handleIipDataClasses(MAPPER);
    }

    @Override             
    public ModbusPhoenixRwEEMImpl from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, ModbusPhoenixRwEEMImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(ModbusPhoenixRwEEMImpl source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public ModbusPhoenixRwEEMImpl clone(ModbusPhoenixRwEEMImpl origin) throws IOException {
        return new ModbusPhoenixRwEEMImpl(origin);
    }

    @Override
    public Class<ModbusPhoenixRwEEMImpl> getType() {
        return ModbusPhoenixRwEEMImpl.class;
    }

}

