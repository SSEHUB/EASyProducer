package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for MyConnMachineIn.
 * Generated by: EASy-Producer.
 */
public class MyConnMachineInSerializer implements Serializer<MyConnMachineIn> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
    }

    @Override             
    public MyConnMachineIn from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, MyConnMachineIn.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(MyConnMachineIn source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public MyConnMachineIn clone(MyConnMachineIn origin) throws IOException {
        return new MyConnMachineIn(origin);
    }

    @Override
    public Class<MyConnMachineIn> getType() {
        return MyConnMachineIn.class;
    }

}

