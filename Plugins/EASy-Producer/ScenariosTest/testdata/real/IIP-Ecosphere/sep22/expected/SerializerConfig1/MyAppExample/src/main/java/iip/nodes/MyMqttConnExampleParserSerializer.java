package iip.nodes;

import java.io.IOException;
import java.util.*;
import static de.iip_ecosphere.platform.support.function.IOVoidFunction.optional;
import de.iip_ecosphere.platform.support.function.*;
import de.iip_ecosphere.platform.transport.serialization.*;
import de.iip_ecosphere.platform.connectors.parser.InputParser.InputConverter;
import de.iip_ecosphere.platform.connectors.parser.InputParser.ParseResult;
import de.iip_ecosphere.platform.connectors.parser.*;
import de.iip_ecosphere.platform.connectors.formatter.OutputFormatter.OutputConverter;
import de.iip_ecosphere.platform.connectors.formatter.*;
import iip.datatypes.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Parser/formatter connector serializer for MyConnPltfIn.
 * Generated by: EASy-Producer.
 */
public class MyMqttConnExampleParserSerializer implements Serializer<MyConnPltfIn> {

    private JsonInputParser parser;
    private Map<String, Integer> mapping;
    
    public MyMqttConnExampleParserSerializer(String encoding, Map<String, Integer> mapping) {
        this.mapping = mapping;
        parser = (JsonInputParser) ParserUtils.createInstance(
            MyMqttConnExampleParserSerializer.class.getClassLoader(), "JsonInputParser", encoding);
    }

    @Override             
    public MyConnPltfIn from(byte[] data) throws IOException {
        JsonInputParser.JsonParseResult pr = parser.parse(data);
        JsonInputParser.JsonInputConverter inConverter = parser.getConverter(); 
        MyConnPltfIn result = new MyConnPltfInImpl();
        
        return result;
    }

    @Override    
    public byte[] to(MyConnPltfIn source) throws IOException {
        return null;
    }

    @Override
    public MyConnPltfIn clone(MyConnPltfIn origin) throws IOException {
        return new MyConnPltfInImpl(origin);
    }

    @Override
    public Class<MyConnPltfIn> getType() {
        return MyConnPltfIn.class;
    }

}
