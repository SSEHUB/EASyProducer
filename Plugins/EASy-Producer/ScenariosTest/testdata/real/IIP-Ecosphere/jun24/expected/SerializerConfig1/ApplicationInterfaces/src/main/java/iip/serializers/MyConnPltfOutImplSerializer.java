package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for MyConnPltfOut.
 * Generated by: EASy-Producer.
 */
public class MyConnPltfOutImplSerializer implements Serializer<MyConnPltfOutImpl> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        JsonUtils.handleIipDataClasses(MAPPER); // only if nested?
    }

    @Override             
    public MyConnPltfOutImpl from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, MyConnPltfOutImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(MyConnPltfOutImpl source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public MyConnPltfOutImpl clone(MyConnPltfOutImpl origin) throws IOException {
        return new MyConnPltfOutImpl(origin);
    }

    @Override
    public Class<MyConnPltfOutImpl> getType() {
        return MyConnPltfOutImpl.class;
    }

}
