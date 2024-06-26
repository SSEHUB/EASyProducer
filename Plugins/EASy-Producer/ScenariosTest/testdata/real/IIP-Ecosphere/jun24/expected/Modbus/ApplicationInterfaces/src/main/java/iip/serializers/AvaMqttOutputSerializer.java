package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for AvaMqttOutput.
 * Generated by: EASy-Producer.
 */
public class AvaMqttOutputSerializer implements Serializer<AvaMqttOutput> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        JsonUtils.handleIipDataClasses(MAPPER); // only if nested?
    }

    @Override             
    public AvaMqttOutput from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, AvaMqttOutputImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(AvaMqttOutput source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public AvaMqttOutput clone(AvaMqttOutput origin) throws IOException {
        return new AvaMqttOutputImpl(origin);
    }

    @Override
    public Class<AvaMqttOutput> getType() {
        return AvaMqttOutput.class;
    }

}

