package eu.qualimaster.families.imp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Generated;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.Kryo;
import eu.qualimaster.dataManagement.serialization.ISerializer;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.families.imp.FStockParser;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FStockParserProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFStockParser" (GEN).
 */
@Generated(value="EASy-Producer")
public class FStockParserSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFStockParser.IIFStockParserTwitterStreamInput} algorithm.
     */
    public static class IFStockParserTwitterStreamInputSerializer extends Serializer<FStockParser.IFStockParserTwitterStreamInput> implements ISerializer<IFStockParser.IIFStockParserTwitterStreamInput> {

        @Override
        public void serializeTo(IFStockParser.IIFStockParserTwitterStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFStockParser.IIFStockParserTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
            FStockParser.IFStockParserTwitterStreamInput result = new FStockParser.IFStockParserTwitterStreamInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FStockParser.IFStockParserTwitterStreamInput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FStockParser.IFStockParserTwitterStreamInput read(Kryo kryo, Input input, Class<FStockParser.IFStockParserTwitterStreamInput> type) {
            FStockParser.IFStockParserTwitterStreamInput result = new FStockParser.IFStockParserTwitterStreamInput();
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFStockParser.IIFStockParserTwitterStreamOutput} algorithm.
     */
    public static class IFStockParserTwitterStreamOutputSerializer extends Serializer<FStockParser.IFStockParserTwitterStreamOutput> implements ISerializer<IFStockParser.IIFStockParserTwitterStreamOutput> {

        @Override
        public void serializeTo(IFStockParser.IIFStockParserTwitterStreamOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStocks(), out);
        }

        @Override
        public IFStockParser.IIFStockParserTwitterStreamOutput deserializeFrom(InputStream in) throws IOException {
            FStockParser.IFStockParserTwitterStreamOutput result = new FStockParser.IFStockParserTwitterStreamOutput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            result.setStocks(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FStockParser.IFStockParserTwitterStreamOutput object) {
            kryo.writeObject(output, object.getStatus());
            kryo.writeObject(output, object.getStocks());
        }

        @Override
        public FStockParser.IFStockParserTwitterStreamOutput read(Kryo kryo, Input input, Class<FStockParser.IFStockParserTwitterStreamOutput> type) {
            FStockParser.IFStockParserTwitterStreamOutput result = new FStockParser.IFStockParserTwitterStreamOutput();
            result.setStatus(kryo.readObject(input, Object.class));
            result.setStocks(kryo.readObject(input, Object.class));
            return result;
        }
    }

}
