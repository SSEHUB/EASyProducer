package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for ModbusSiemensRwSentron.
 * Generated by: EASy-Producer.
 */
public class ModbusSiemensRwSentronSerializer implements Serializer<ModbusSiemensRwSentron> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        JsonUtils.handleIipDataClasses(MAPPER); // only if nested?
    }

    @Override             
    public ModbusSiemensRwSentron from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, ModbusSiemensRwSentronImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(ModbusSiemensRwSentron source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public ModbusSiemensRwSentron clone(ModbusSiemensRwSentron origin) throws IOException {
        return new ModbusSiemensRwSentronImpl(origin);
    }

    @Override
    public Class<ModbusSiemensRwSentron> getType() {
        return ModbusSiemensRwSentron.class;
    }

}
