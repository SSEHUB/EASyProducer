package iip.serializers;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import de.iip_ecosphere.platform.transport.serialization.Serializer;
import iip.datatypes.*;

/**
 * JSON transport serializer for MyConnPltfOut.
 * Generated by: EASy-Producer.
 */
public class MyConnPltfOutSerializer implements Serializer<MyConnPltfOut> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    static {
        JsonUtils.handleIipDataClasses(MAPPER);
    }

    @Override             
    public MyConnPltfOut from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, MyConnPltfOutImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(MyConnPltfOut source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public MyConnPltfOut clone(MyConnPltfOut origin) throws IOException {
        return new MyConnPltfOutImpl(origin);
    }

    @Override
    public Class<MyConnPltfOut> getType() {
        return MyConnPltfOut.class;
    }

}

