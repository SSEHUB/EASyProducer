package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for TestType.
 * Generated by: EASy-Producer.
 */
public class TestTypeSerializer implements Serializer<TestType> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
    }

    @Override             
    public TestType from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, TestType.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(TestType source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public TestType clone(TestType origin) throws IOException {
        return new TestType(origin);
    }

    @Override
    public Class<TestType> getType() {
        return TestType.class;
    }

}
