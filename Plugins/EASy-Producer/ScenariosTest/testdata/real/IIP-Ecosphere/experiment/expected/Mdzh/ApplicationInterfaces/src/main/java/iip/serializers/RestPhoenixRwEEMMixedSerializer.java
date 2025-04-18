package iip.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.iip_ecosphere.platform.support.json.JsonUtils;
import de.iip_ecosphere.platform.transport.serialization.Serializer;

import iip.datatypes.*;

/**
 * JSON transport serializer for RestPhoenixRwEEMMixed.
 * Generated by: EASy-Producer.
 */
public class RestPhoenixRwEEMMixedSerializer implements Serializer<RestPhoenixRwEEMMixed> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        JsonUtils.handleIipDataClasses(MAPPER);
    }

    @Override
    public RestPhoenixRwEEMMixed from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, RestPhoenixRwEEMMixedImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public byte[] to(RestPhoenixRwEEMMixed source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public RestPhoenixRwEEMMixed clone(RestPhoenixRwEEMMixed origin) throws IOException {
        return new RestPhoenixRwEEMMixedImpl(origin);
    }

    @Override
    public Class<RestPhoenixRwEEMMixed> getType() {
        return RestPhoenixRwEEMMixed.class;
    }

}
