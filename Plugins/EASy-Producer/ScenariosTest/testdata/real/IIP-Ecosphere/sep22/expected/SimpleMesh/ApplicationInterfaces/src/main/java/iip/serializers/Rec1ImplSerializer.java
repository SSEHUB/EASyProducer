package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.iip_aas.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for Rec1.
 * Generated by: EASy-Producer.
 */
public class Rec1ImplSerializer implements Serializer<Rec1Impl> {

    @Override             
    public Rec1Impl from(byte[] data) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(data, Rec1Impl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(Rec1Impl source) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public Rec1Impl clone(Rec1Impl origin) throws IOException {
        return new Rec1Impl(origin);
    }

    @Override
    public Class<Rec1Impl> getType() {
        return Rec1Impl.class;
    }

}

