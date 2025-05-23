package iip.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.iip_ecosphere.platform.support.json.JsonUtils;
import de.iip_ecosphere.platform.transport.serialization.Serializer;

import iip.datatypes.*;

/**
 * JSON transport serializer for AvaMqttOutput.
 * Generated by: EASy-Producer.
 */
public class AvaMqttOutputSerializer implements Serializer<AvaMqttOutput> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        JsonUtils.handleIipDataClasses(MAPPER);
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
