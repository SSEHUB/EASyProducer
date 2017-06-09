package eu.qualimaster.data.imp;

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
import eu.qualimaster.data.imp.FocusSink;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.FocusSinkProtos.*;
/**
 * The implementation of the serializers for the data element "FocusSink" (GEN).
 */
@Generated(value="EASy-Producer")
public class FocusSinkSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FocusSink.IFocusSinkRecommendationStreamInput} algorithm.
 */
public static class FocusSinkRecommendationStreamInputSerializer extends Serializer<FocusSink.FocusSinkRecommendationStreamInput> implements ISerializer<FocusSink.IFocusSinkRecommendationStreamInput> {

    @Override
    public void serializeTo(FocusSink.IFocusSinkRecommendationStreamInput object, OutputStream out) throws IOException {
        SFocusSinkRecommendationStreamInput tmp = SFocusSinkRecommendationStreamInput.newBuilder()
            .setRecommendations(object.getRecommendations())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(FocusSink.IFocusSinkRecommendationStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getRecommendations());
        }

    @Override
    public FocusSink.IFocusSinkRecommendationStreamInput deserializeFrom(InputStream in) throws IOException {
        FocusSink.FocusSinkRecommendationStreamInput result = new FocusSink.FocusSinkRecommendationStreamInput();
        SFocusSinkRecommendationStreamInput tmp = SFocusSinkRecommendationStreamInput.parseDelimitedFrom(in);
        result.setRecommendations(tmp.getRecommendations());
        return result;
    }

        @Override
        public FocusSink.IFocusSinkRecommendationStreamInput deserializeFrom(IDataInput in) throws IOException {
            FocusSink.FocusSinkRecommendationStreamInput result = new FocusSink.FocusSinkRecommendationStreamInput();
            result.setRecommendations(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FocusSink.FocusSinkRecommendationStreamInput object) {
        output.writeString(object.getRecommendations());
    }

    @Override
    public FocusSink.FocusSinkRecommendationStreamInput read(Kryo kryo, Input input, Class<FocusSink.FocusSinkRecommendationStreamInput> type) {
        FocusSink.FocusSinkRecommendationStreamInput result = new FocusSink.FocusSinkRecommendationStreamInput();
        result.setRecommendations(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FocusSink.IFocusSinkEdgeStreamInput} algorithm.
 */
public static class FocusSinkEdgeStreamInputSerializer extends Serializer<FocusSink.FocusSinkEdgeStreamInput> implements ISerializer<FocusSink.IFocusSinkEdgeStreamInput> {

    @Override
    public void serializeTo(FocusSink.IFocusSinkEdgeStreamInput object, OutputStream out) throws IOException {
        SFocusSinkEdgeStreamInput tmp = SFocusSinkEdgeStreamInput.newBuilder()
            .setEdge(object.getEdge())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(FocusSink.IFocusSinkEdgeStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getEdge());
        }

    @Override
    public FocusSink.IFocusSinkEdgeStreamInput deserializeFrom(InputStream in) throws IOException {
        FocusSink.FocusSinkEdgeStreamInput result = new FocusSink.FocusSinkEdgeStreamInput();
        SFocusSinkEdgeStreamInput tmp = SFocusSinkEdgeStreamInput.parseDelimitedFrom(in);
        result.setEdge(tmp.getEdge());
        return result;
    }

        @Override
        public FocusSink.IFocusSinkEdgeStreamInput deserializeFrom(IDataInput in) throws IOException {
            FocusSink.FocusSinkEdgeStreamInput result = new FocusSink.FocusSinkEdgeStreamInput();
            result.setEdge(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FocusSink.FocusSinkEdgeStreamInput object) {
        output.writeString(object.getEdge());
    }

    @Override
    public FocusSink.FocusSinkEdgeStreamInput read(Kryo kryo, Input input, Class<FocusSink.FocusSinkEdgeStreamInput> type) {
        FocusSink.FocusSinkEdgeStreamInput result = new FocusSink.FocusSinkEdgeStreamInput();
        result.setEdge(input.readString());
        return result;
    }
}

}
