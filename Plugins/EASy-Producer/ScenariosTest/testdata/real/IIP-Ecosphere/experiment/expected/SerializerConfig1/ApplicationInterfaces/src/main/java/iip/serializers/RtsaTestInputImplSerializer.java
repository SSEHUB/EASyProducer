package iip.serializers;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import de.iip_ecosphere.platform.transport.serialization.Serializer;
import iip.datatypes.*;

/**
 * JSON transport serializer for RtsaTestInput.
 * Generated by: EASy-Producer.
 */
public class RtsaTestInputImplSerializer implements Serializer<RtsaTestInputImpl> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    static {
        JsonUtils.handleIipDataClasses(MAPPER);
    }

    @Override             
    public RtsaTestInputImpl from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, RtsaTestInputImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(RtsaTestInputImpl source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public RtsaTestInputImpl clone(RtsaTestInputImpl origin) throws IOException {
        return new RtsaTestInputImpl(origin);
    }

    @Override
    public Class<RtsaTestInputImpl> getType() {
        return RtsaTestInputImpl.class;
    }

}

