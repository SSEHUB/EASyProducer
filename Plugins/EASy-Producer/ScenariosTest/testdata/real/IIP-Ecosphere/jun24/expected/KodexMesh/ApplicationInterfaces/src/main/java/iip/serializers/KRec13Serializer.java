package iip.serializers;

import java.io.IOException;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JSON transport serializer for KRec13.
 * Generated by: EASy-Producer.
 */
public class KRec13Serializer implements Serializer<KRec13> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        JsonUtils.handleIipDataClasses(MAPPER); // only if nested?
    }

    @Override             
    public KRec13 from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, KRec13Impl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(KRec13 source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public KRec13 clone(KRec13 origin) throws IOException {
        return new KRec13Impl(origin);
    }

    @Override
    public Class<KRec13> getType() {
        return KRec13.class;
    }

}

