package iip.serializers;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iip_ecosphere.platform.support.json.JsonUtils;
import de.iip_ecosphere.platform.transport.serialization.Serializer;
import iip.datatypes.*;

/**
 * JSON transport serializer for KRec13.
 * Generated by: EASy-Producer.
 */
public class KRec13ImplSerializer implements Serializer<KRec13Impl> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        JsonUtils.handleIipDataClasses(MAPPER);
    }

    @Override             
    public KRec13Impl from(byte[] data) throws IOException {
        try {
            return MAPPER.readValue(data, KRec13Impl.class);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override    
    public byte[] to(KRec13Impl source) throws IOException {
        try {
            return MAPPER.writeValueAsBytes(source);
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    @Override
    public KRec13Impl clone(KRec13Impl origin) throws IOException {
        return new KRec13Impl(origin);
    }

    @Override
    public Class<KRec13Impl> getType() {
        return KRec13Impl.class;
    }

}

