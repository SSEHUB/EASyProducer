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
import eu.qualimaster.dataManagement.serialization.IDataInput;
import eu.qualimaster.dataManagement.serialization.IDataOutput;
import eu.qualimaster.families.imp.FSimpleRecommendations;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FSimpleRecommendationsProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFSimpleRecommendations" (GEN).
 */
@Generated(value="EASy-Producer")
public class FSimpleRecommendationsSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamInput} algorithm.
 */
public static class IFSimpleRecommendationsTwitterStreamInputSerializer extends Serializer<FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput> implements ISerializer<IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamInput> {

    @Override
    public void serializeTo(IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamInput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
        SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).serializeTo(object.getStatus(), out);
    }

        @Override
        public void serializeTo(IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
            SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).serializeTo(object.getStatus(), out);
        }

    @Override
    public IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
        FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput result = new FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput();
        result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
        result.setStatus(SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamInput deserializeFrom(IDataInput in) throws IOException {
            FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput result = new FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput();
            result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setStatus(SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput object) {
        kryo.writeObject(output, object.getEvents());
        kryo.writeObject(output, object.getStatus());
    }

    @Override
    public FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput read(Kryo kryo, Input input, Class<FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput> type) {
        FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput result = new FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput();
        result.setEvents(kryo.readObject(input, java.util.ArrayList.class));
        result.setStatus(kryo.readObject(input, eu.qualimaster.data.stream.source.LabelledTweet.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamOutput} algorithm.
 */
public static class IFSimpleRecommendationsTwitterStreamOutputSerializer extends Serializer<FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput> implements ISerializer<IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamOutput> {

    @Override
    public void serializeTo(IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamOutput object, OutputStream out) throws IOException {
        SIFSimpleRecommendationsTwitterStreamOutput tmp = SIFSimpleRecommendationsTwitterStreamOutput.newBuilder()
            .setRecommendations(object.getRecommendations())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getRecommendations());
        }

    @Override
    public IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamOutput deserializeFrom(InputStream in) throws IOException {
        FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput result = new FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput();
        SIFSimpleRecommendationsTwitterStreamOutput tmp = SIFSimpleRecommendationsTwitterStreamOutput.parseDelimitedFrom(in);
        result.setRecommendations(tmp.getRecommendations());
        return result;
    }

        @Override
        public IFSimpleRecommendations.IIFSimpleRecommendationsTwitterStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput result = new FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput();
            result.setRecommendations(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput object) {
        output.writeString(object.getRecommendations());
    }

    @Override
    public FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput read(Kryo kryo, Input input, Class<FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput> type) {
        FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput result = new FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput();
        result.setRecommendations(input.readString());
        return result;
    }
}

}
