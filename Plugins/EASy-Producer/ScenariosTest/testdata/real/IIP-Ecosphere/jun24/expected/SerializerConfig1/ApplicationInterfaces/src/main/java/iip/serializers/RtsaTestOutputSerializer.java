package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for RtsaTestOutput.
 * Generated by: EASy-Producer.
 */
public class RtsaTestOutputSerializer implements Serializer<RtsaTestOutput> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        JsonUtils.handleIipDataClasses(MAPPER); // only if nested?
    }

    @Override             
    public RtsaTestOutput from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, RtsaTestOutputImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(RtsaTestOutput source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public RtsaTestOutput clone(RtsaTestOutput origin) throws IOException {
        return new RtsaTestOutputImpl(origin);
    }

    @Override
    public Class<RtsaTestOutput> getType() {
        return RtsaTestOutput.class;
    }

}

