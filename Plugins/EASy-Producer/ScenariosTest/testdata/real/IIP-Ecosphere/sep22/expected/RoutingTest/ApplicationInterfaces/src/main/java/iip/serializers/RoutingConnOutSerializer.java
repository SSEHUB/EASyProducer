package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.iip_aas.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for RoutingConnOut.
 * Generated by: EASy-Producer.
 */
public class RoutingConnOutSerializer implements Serializer<RoutingConnOut> {

    @Override             
    public RoutingConnOut from(byte[] data) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(data, RoutingConnOutImpl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(RoutingConnOut source) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public RoutingConnOut clone(RoutingConnOut origin) throws IOException {
        return new RoutingConnOutImpl(origin);
    }

    @Override
    public Class<RoutingConnOut> getType() {
        return RoutingConnOut.class;
    }

}
