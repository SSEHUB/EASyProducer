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
import eu.qualimaster.families.imp.FTweetClassifier;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTweetClassifierProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTweetClassifier" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTweetClassifierSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTweetClassifier.IIFTweetClassifierModifiedTwitterStreamInput} algorithm.
     */
    public static class IFTweetClassifierModifiedTwitterStreamInputSerializer extends Serializer<FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput> implements ISerializer<IFTweetClassifier.IIFTweetClassifierModifiedTwitterStreamInput> {

        @Override
        public void serializeTo(IFTweetClassifier.IIFTweetClassifierModifiedTwitterStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFTweetClassifier.IIFTweetClassifierModifiedTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
            FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput result = new FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput read(Kryo kryo, Input input, Class<FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput> type) {
            FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput result = new FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput();
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTweetClassifier.IIFTweetClassifierKeywordStreamInput} algorithm.
     */
    public static class IFTweetClassifierKeywordStreamInputSerializer extends Serializer<FTweetClassifier.IFTweetClassifierKeywordStreamInput> implements ISerializer<IFTweetClassifier.IIFTweetClassifierKeywordStreamInput> {

        @Override
        public void serializeTo(IFTweetClassifier.IIFTweetClassifierKeywordStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getKeywords(), out);
        }

        @Override
        public IFTweetClassifier.IIFTweetClassifierKeywordStreamInput deserializeFrom(InputStream in) throws IOException {
            FTweetClassifier.IFTweetClassifierKeywordStreamInput result = new FTweetClassifier.IFTweetClassifierKeywordStreamInput();
            result.setKeywords(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTweetClassifier.IFTweetClassifierKeywordStreamInput object) {
            kryo.writeObject(output, object.getKeywords());
        }

        @Override
        public FTweetClassifier.IFTweetClassifierKeywordStreamInput read(Kryo kryo, Input input, Class<FTweetClassifier.IFTweetClassifierKeywordStreamInput> type) {
            FTweetClassifier.IFTweetClassifierKeywordStreamInput result = new FTweetClassifier.IFTweetClassifierKeywordStreamInput();
            result.setKeywords(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTweetClassifier.IIFTweetClassifierModifiedTwitterStreamOutput} algorithm.
     */
    public static class IFTweetClassifierModifiedTwitterStreamOutputSerializer extends Serializer<FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput> implements ISerializer<IFTweetClassifier.IIFTweetClassifierModifiedTwitterStreamOutput> {

        @Override
        public void serializeTo(IFTweetClassifier.IIFTweetClassifierModifiedTwitterStreamOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getTweet(), out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStocks(), out);
        }

        @Override
        public IFTweetClassifier.IIFTweetClassifierModifiedTwitterStreamOutput deserializeFrom(InputStream in) throws IOException {
            FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput result = new FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput();
            result.setTweet(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            result.setStocks(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput object) {
            kryo.writeObject(output, object.getTweet());
            kryo.writeObject(output, object.getStocks());
        }

        @Override
        public FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput read(Kryo kryo, Input input, Class<FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput> type) {
            FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput result = new FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput();
            result.setTweet(kryo.readObject(input, Object.class));
            result.setStocks(kryo.readObject(input, Object.class));
            return result;
        }
    }

}
