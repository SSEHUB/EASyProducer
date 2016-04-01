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
import eu.qualimaster.families.imp.FKeywordAnalyzer;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FKeywordAnalyzerProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFKeywordAnalyzer" (GEN).
 */
@Generated(value="EASy-Producer")
public class FKeywordAnalyzerSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFKeywordAnalyzer.IIFKeywordAnalyzerTwitterStreamInput} algorithm.
     */
    public static class IFKeywordAnalyzerTwitterStreamInputSerializer extends Serializer<FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput> implements ISerializer<IFKeywordAnalyzer.IIFKeywordAnalyzerTwitterStreamInput> {

        @Override
        public void serializeTo(IFKeywordAnalyzer.IIFKeywordAnalyzerTwitterStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFKeywordAnalyzer.IIFKeywordAnalyzerTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
            FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput result = new FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput();
            result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput object) {
            kryo.writeObject(output, object.getEvents());
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput read(Kryo kryo, Input input, Class<FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput> type) {
            FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput result = new FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput();
            result.setEvents(kryo.readObject(input, java.util.ArrayList.class));
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFKeywordAnalyzer.IIFKeywordAnalyzerTwitterStreamOutput} algorithm.
     */
    public static class IFKeywordAnalyzerTwitterStreamOutputSerializer extends Serializer<FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput> implements ISerializer<IFKeywordAnalyzer.IIFKeywordAnalyzerTwitterStreamOutput> {

        @Override
        public void serializeTo(IFKeywordAnalyzer.IIFKeywordAnalyzerTwitterStreamOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFKeywordAnalyzer.IIFKeywordAnalyzerTwitterStreamOutput deserializeFrom(InputStream in) throws IOException {
            FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput result = new FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput();
            result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput object) {
            kryo.writeObject(output, object.getEvents());
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput read(Kryo kryo, Input input, Class<FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput> type) {
            FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput result = new FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput();
            result.setEvents(kryo.readObject(input, java.util.ArrayList.class));
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

}
