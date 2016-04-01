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
import eu.qualimaster.families.imp.FEventEnrichment;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FEventEnrichmentProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFEventEnrichment" (GEN).
 */
@Generated(value="EASy-Producer")
public class FEventEnrichmentSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFEventEnrichment.IIFEventEnrichmentEventStreamInput} algorithm.
     */
    public static class IFEventEnrichmentEventStreamInputSerializer extends Serializer<FEventEnrichment.IFEventEnrichmentEventStreamInput> implements ISerializer<IFEventEnrichment.IIFEventEnrichmentEventStreamInput> {

        @Override
        public void serializeTo(IFEventEnrichment.IIFEventEnrichmentEventStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getTweet(), out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getEvents(), out);
        }

        @Override
        public IFEventEnrichment.IIFEventEnrichmentEventStreamInput deserializeFrom(InputStream in) throws IOException {
            FEventEnrichment.IFEventEnrichmentEventStreamInput result = new FEventEnrichment.IFEventEnrichmentEventStreamInput();
            result.setTweet(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            result.setEvents(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FEventEnrichment.IFEventEnrichmentEventStreamInput object) {
            kryo.writeObject(output, object.getTweet());
            kryo.writeObject(output, object.getEvents());
        }

        @Override
        public FEventEnrichment.IFEventEnrichmentEventStreamInput read(Kryo kryo, Input input, Class<FEventEnrichment.IFEventEnrichmentEventStreamInput> type) {
            FEventEnrichment.IFEventEnrichmentEventStreamInput result = new FEventEnrichment.IFEventEnrichmentEventStreamInput();
            result.setTweet(kryo.readObject(input, Object.class));
            result.setEvents(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFEventEnrichment.IIFEventEnrichmentKeywordStreamInput} algorithm.
     */
    public static class IFEventEnrichmentKeywordStreamInputSerializer extends Serializer<FEventEnrichment.IFEventEnrichmentKeywordStreamInput> implements ISerializer<IFEventEnrichment.IIFEventEnrichmentKeywordStreamInput> {

        @Override
        public void serializeTo(IFEventEnrichment.IIFEventEnrichmentKeywordStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getKeywords(), out);
        }

        @Override
        public IFEventEnrichment.IIFEventEnrichmentKeywordStreamInput deserializeFrom(InputStream in) throws IOException {
            FEventEnrichment.IFEventEnrichmentKeywordStreamInput result = new FEventEnrichment.IFEventEnrichmentKeywordStreamInput();
            result.setKeywords(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FEventEnrichment.IFEventEnrichmentKeywordStreamInput object) {
            kryo.writeObject(output, object.getKeywords());
        }

        @Override
        public FEventEnrichment.IFEventEnrichmentKeywordStreamInput read(Kryo kryo, Input input, Class<FEventEnrichment.IFEventEnrichmentKeywordStreamInput> type) {
            FEventEnrichment.IFEventEnrichmentKeywordStreamInput result = new FEventEnrichment.IFEventEnrichmentKeywordStreamInput();
            result.setKeywords(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFEventEnrichment.IIFEventEnrichmentEnrichedEventsStreamOutput} algorithm.
     */
    public static class IFEventEnrichmentEnrichedEventsStreamOutputSerializer extends Serializer<FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput> implements ISerializer<IFEventEnrichment.IIFEventEnrichmentEnrichedEventsStreamOutput> {

        @Override
        public void serializeTo(IFEventEnrichment.IIFEventEnrichmentEnrichedEventsStreamOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getEvents(), out);
        }

        @Override
        public IFEventEnrichment.IIFEventEnrichmentEnrichedEventsStreamOutput deserializeFrom(InputStream in) throws IOException {
            FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput result = new FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput();
            result.setEvents(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput object) {
            kryo.writeObject(output, object.getEvents());
        }

        @Override
        public FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput read(Kryo kryo, Input input, Class<FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput> type) {
            FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput result = new FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput();
            result.setEvents(kryo.readObject(input, Object.class));
            return result;
        }
    }

}
