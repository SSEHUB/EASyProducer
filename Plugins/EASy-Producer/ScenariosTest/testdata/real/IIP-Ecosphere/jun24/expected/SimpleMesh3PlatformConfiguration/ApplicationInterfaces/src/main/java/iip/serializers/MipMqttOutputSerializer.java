package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for MipMqttOutput.
 * Generated by: EASy-Producer.
 */
public class MipMqttOutputSerializer implements Serializer<MipMqttOutput> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        JsonUtils.defineOptionals(MAPPER, MipMqttOutput.class, "mipraw_signal_clock", "mipraw_signal_data1", "mipraw_signal_data2");
        JsonUtils.handleIipDataClasses(MAPPER); // only if nested?
    }

    @Override             
    public MipMqttOutput from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, MipMqttOutputImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(MipMqttOutput source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public MipMqttOutput clone(MipMqttOutput origin) throws IOException {
        return new MipMqttOutputImpl(origin);
    }

    @Override
    public Class<MipMqttOutput> getType() {
        return MipMqttOutput.class;
    }

}

