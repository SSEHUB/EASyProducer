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
import eu.qualimaster.data.imp.TwitterStreamData;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.TwitterStreamDataProtos.*;
/**
 * The implementation of the serializers for the data element "TwitterStreamData" (GEN).
 */
@Generated(value="EASy-Producer")
public class TwitterStreamDataSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link TwitterStreamData.ITwitterStreamDataSymbolListOutput} algorithm.
 */
public static class TwitterStreamDataSymbolListOutputSerializer extends Serializer<TwitterStreamData.TwitterStreamDataSymbolListOutput> implements ISerializer<TwitterStreamData.ITwitterStreamDataSymbolListOutput> {

    @Override
    public void serializeTo(TwitterStreamData.ITwitterStreamDataSymbolListOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
    }

        @Override
        public void serializeTo(TwitterStreamData.ITwitterStreamDataSymbolListOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

    @Override
    public TwitterStreamData.ITwitterStreamDataSymbolListOutput deserializeFrom(InputStream in) throws IOException {
        TwitterStreamData.TwitterStreamDataSymbolListOutput result = new TwitterStreamData.TwitterStreamDataSymbolListOutput();
        result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
        return result;
    }

        @Override
        public TwitterStreamData.ITwitterStreamDataSymbolListOutput deserializeFrom(IDataInput in) throws IOException {
            TwitterStreamData.TwitterStreamDataSymbolListOutput result = new TwitterStreamData.TwitterStreamDataSymbolListOutput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, TwitterStreamData.TwitterStreamDataSymbolListOutput object) {
        kryo.writeObject(output, object.getAllSymbols());
    }

    @Override
    public TwitterStreamData.TwitterStreamDataSymbolListOutput read(Kryo kryo, Input input, Class<TwitterStreamData.TwitterStreamDataSymbolListOutput> type) {
        TwitterStreamData.TwitterStreamDataSymbolListOutput result = new TwitterStreamData.TwitterStreamDataSymbolListOutput();
        result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link TwitterStreamData.ITwitterStreamDataTwitterStreamOutput} algorithm.
 */
public static class TwitterStreamDataTwitterStreamOutputSerializer extends Serializer<TwitterStreamData.TwitterStreamDataTwitterStreamOutput> implements ISerializer<TwitterStreamData.ITwitterStreamDataTwitterStreamOutput> {

    @Override
    public void serializeTo(TwitterStreamData.ITwitterStreamDataTwitterStreamOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).serializeTo(object.getStatus(), out);
    }

        @Override
        public void serializeTo(TwitterStreamData.ITwitterStreamDataTwitterStreamOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).serializeTo(object.getStatus(), out);
        }

    @Override
    public TwitterStreamData.ITwitterStreamDataTwitterStreamOutput deserializeFrom(InputStream in) throws IOException {
        TwitterStreamData.TwitterStreamDataTwitterStreamOutput result = new TwitterStreamData.TwitterStreamDataTwitterStreamOutput();
        result.setStatus(SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).deserializeFrom(in));
        return result;
    }

        @Override
        public TwitterStreamData.ITwitterStreamDataTwitterStreamOutput deserializeFrom(IDataInput in) throws IOException {
            TwitterStreamData.TwitterStreamDataTwitterStreamOutput result = new TwitterStreamData.TwitterStreamDataTwitterStreamOutput();
            result.setStatus(SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, TwitterStreamData.TwitterStreamDataTwitterStreamOutput object) {
        kryo.writeObject(output, object.getStatus());
    }

    @Override
    public TwitterStreamData.TwitterStreamDataTwitterStreamOutput read(Kryo kryo, Input input, Class<TwitterStreamData.TwitterStreamDataTwitterStreamOutput> type) {
        TwitterStreamData.TwitterStreamDataTwitterStreamOutput result = new TwitterStreamData.TwitterStreamDataTwitterStreamOutput();
        result.setStatus(kryo.readObject(input, eu.qualimaster.data.stream.source.LabelledTweet.class));
        return result;
    }
}

}
