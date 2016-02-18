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
import eu.qualimaster.families.imp.FRecommendations;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FRecommendationsProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFRecommendations" (GEN).
 */
@Generated(value="EASy-Producer")
public class FRecommendationsSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFRecommendations.IIFRecommendationsTwitterStreamInput} algorithm.
     */
    public static class IFRecommendationsTwitterStreamInputSerializer extends Serializer<FRecommendations.IFRecommendationsTwitterStreamInput> implements ISerializer<IFRecommendations.IIFRecommendationsTwitterStreamInput> {

        @Override
        public void serializeTo(IFRecommendations.IIFRecommendationsTwitterStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFRecommendations.IIFRecommendationsTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
            FRecommendations.IFRecommendationsTwitterStreamInput result = new FRecommendations.IFRecommendationsTwitterStreamInput();
            result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FRecommendations.IFRecommendationsTwitterStreamInput object) {
            kryo.writeObject(output, object.getEvents());
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FRecommendations.IFRecommendationsTwitterStreamInput read(Kryo kryo, Input input, Class<FRecommendations.IFRecommendationsTwitterStreamInput> type) {
            FRecommendations.IFRecommendationsTwitterStreamInput result = new FRecommendations.IFRecommendationsTwitterStreamInput();
            result.setEvents(kryo.readObject(input, java.util.ArrayList.class));
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFRecommendations.IIFRecommendationsRecommendationStreamOutput} algorithm.
     */
    public static class IFRecommendationsRecommendationStreamOutputSerializer extends Serializer<FRecommendations.IFRecommendationsRecommendationStreamOutput> implements ISerializer<IFRecommendations.IIFRecommendationsRecommendationStreamOutput> {

        @Override
        public void serializeTo(IFRecommendations.IIFRecommendationsRecommendationStreamOutput object, OutputStream out) throws IOException {
            SIFRecommendationsRecommendationStreamOutput tmp = SIFRecommendationsRecommendationStreamOutput.newBuilder()
                .setRecommendations(object.getRecommendations())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public IFRecommendations.IIFRecommendationsRecommendationStreamOutput deserializeFrom(InputStream in) throws IOException {
            FRecommendations.IFRecommendationsRecommendationStreamOutput result = new FRecommendations.IFRecommendationsRecommendationStreamOutput();
            SIFRecommendationsRecommendationStreamOutput tmp = SIFRecommendationsRecommendationStreamOutput.parseDelimitedFrom(in);
            result.setRecommendations(tmp.getRecommendations());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FRecommendations.IFRecommendationsRecommendationStreamOutput object) {
            output.writeString(object.getRecommendations());
        }

        @Override
        public FRecommendations.IFRecommendationsRecommendationStreamOutput read(Kryo kryo, Input input, Class<FRecommendations.IFRecommendationsRecommendationStreamOutput> type) {
            FRecommendations.IFRecommendationsRecommendationStreamOutput result = new FRecommendations.IFRecommendationsRecommendationStreamOutput();
            result.setRecommendations(input.readString());
            return result;
        }
    }

}
