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
import eu.qualimaster.families.imp.FSentimentAnalysis;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FSentimentAnalysisProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFSentimentAnalysis" (GEN).
 */
@Generated(value="EASy-Producer")
public class FSentimentAnalysisSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFSentimentAnalysis.IIFSentimentAnalysisTwitterStreamInput} algorithm.
 */
public static class IFSentimentAnalysisTwitterStreamInputSerializer extends Serializer<FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput> implements ISerializer<IFSentimentAnalysis.IIFSentimentAnalysisTwitterStreamInput> {

    @Override
    public void serializeTo(IFSentimentAnalysis.IIFSentimentAnalysisTwitterStreamInput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).serializeTo(object.getStatus(), out);
    }

        @Override
        public void serializeTo(IFSentimentAnalysis.IIFSentimentAnalysisTwitterStreamInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).serializeTo(object.getStatus(), out);
        }

    @Override
    public IFSentimentAnalysis.IIFSentimentAnalysisTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
        FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput result = new FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput();
        result.setStatus(SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFSentimentAnalysis.IIFSentimentAnalysisTwitterStreamInput deserializeFrom(IDataInput in) throws IOException {
            FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput result = new FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("LABELLEDTWEET", eu.qualimaster.data.stream.source.LabelledTweet.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput object) {
        kryo.writeObject(output, object.getStatus());
    }

    @Override
    public FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput read(Kryo kryo, Input input, Class<FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput> type) {
        FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput result = new FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput();
        result.setStatus(kryo.readObject(input, eu.qualimaster.data.stream.source.LabelledTweet.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFSentimentAnalysis.IIFSentimentAnalysisAnalyzedStreamOutput} algorithm.
 */
public static class IFSentimentAnalysisAnalyzedStreamOutputSerializer extends Serializer<FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput> implements ISerializer<IFSentimentAnalysis.IIFSentimentAnalysisAnalyzedStreamOutput> {

    @Override
    public void serializeTo(IFSentimentAnalysis.IIFSentimentAnalysisAnalyzedStreamOutput object, OutputStream out) throws IOException {
        SIFSentimentAnalysisAnalyzedStreamOutput tmp = SIFSentimentAnalysisAnalyzedStreamOutput.newBuilder()
            .setSymbolId(object.getSymbolId())
            .setTimestamp(object.getTimestamp())
            .setValue(object.getValue())
            .setVolume(object.getVolume())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFSentimentAnalysis.IIFSentimentAnalysisAnalyzedStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolId());
            out.writeLong(object.getTimestamp());
            out.writeDouble(object.getValue());
            out.writeInt(object.getVolume());
        }

    @Override
    public IFSentimentAnalysis.IIFSentimentAnalysisAnalyzedStreamOutput deserializeFrom(InputStream in) throws IOException {
        FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput result = new FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput();
        SIFSentimentAnalysisAnalyzedStreamOutput tmp = SIFSentimentAnalysisAnalyzedStreamOutput.parseDelimitedFrom(in);
        result.setSymbolId(tmp.getSymbolId());
        result.setTimestamp(tmp.getTimestamp());
        result.setValue(tmp.getValue());
        result.setVolume(tmp.getVolume());
        return result;
    }

        @Override
        public IFSentimentAnalysis.IIFSentimentAnalysisAnalyzedStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput result = new FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput();
            result.setSymbolId(in.nextString());
            result.setTimestamp(in.nextLong());
            result.setValue(in.nextDouble());
            result.setVolume(in.nextInt());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput object) {
        output.writeString(object.getSymbolId());
        output.writeLong(object.getTimestamp());
        output.writeDouble(object.getValue());
        output.writeInt(object.getVolume());
    }

    @Override
    public FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput read(Kryo kryo, Input input, Class<FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput> type) {
        FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput result = new FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput();
        result.setSymbolId(input.readString());
        result.setTimestamp(input.readLong());
        result.setValue(input.readDouble());
        result.setVolume(input.readInt());
        return result;
    }
}

}
