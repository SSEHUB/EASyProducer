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
import eu.qualimaster.data.imp.PriorityDataSink;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.PriorityDataSinkProtos.*;
/**
 * The implementation of the serializers for the data element "PriorityDataSink" (GEN).
 */
@Generated(value="EASy-Producer")
public class PriorityDataSinkSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link PriorityDataSink.IPriorityDataSinkPairwiseFinancialInput} algorithm.
 */
public static class PriorityDataSinkPairwiseFinancialInputSerializer extends Serializer<PriorityDataSink.PriorityDataSinkPairwiseFinancialInput> implements ISerializer<PriorityDataSink.IPriorityDataSinkPairwiseFinancialInput> {

    @Override
    public void serializeTo(PriorityDataSink.IPriorityDataSinkPairwiseFinancialInput object, OutputStream out) throws IOException {
        SPriorityDataSinkPairwiseFinancialInput tmp = SPriorityDataSinkPairwiseFinancialInput.newBuilder()
            .setId0(object.getId0())
            .setId1(object.getId1())
            .setDate(object.getDate())
            .setValue(object.getValue())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(PriorityDataSink.IPriorityDataSinkPairwiseFinancialInput object, IDataOutput out) throws IOException {
            out.writeString(object.getId0());
            out.writeString(object.getId1());
            out.writeString(object.getDate());
            out.writeDouble(object.getValue());
        }

    @Override
    public PriorityDataSink.IPriorityDataSinkPairwiseFinancialInput deserializeFrom(InputStream in) throws IOException {
        PriorityDataSink.PriorityDataSinkPairwiseFinancialInput result = new PriorityDataSink.PriorityDataSinkPairwiseFinancialInput();
        SPriorityDataSinkPairwiseFinancialInput tmp = SPriorityDataSinkPairwiseFinancialInput.parseDelimitedFrom(in);
        result.setId0(tmp.getId0());
        result.setId1(tmp.getId1());
        result.setDate(tmp.getDate());
        result.setValue(tmp.getValue());
        return result;
    }

        @Override
        public PriorityDataSink.IPriorityDataSinkPairwiseFinancialInput deserializeFrom(IDataInput in) throws IOException {
            PriorityDataSink.PriorityDataSinkPairwiseFinancialInput result = new PriorityDataSink.PriorityDataSinkPairwiseFinancialInput();
            result.setId0(in.nextString());
            result.setId1(in.nextString());
            result.setDate(in.nextString());
            result.setValue(in.nextDouble());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, PriorityDataSink.PriorityDataSinkPairwiseFinancialInput object) {
        output.writeString(object.getId0());
        output.writeString(object.getId1());
        output.writeString(object.getDate());
        output.writeDouble(object.getValue());
    }

    @Override
    public PriorityDataSink.PriorityDataSinkPairwiseFinancialInput read(Kryo kryo, Input input, Class<PriorityDataSink.PriorityDataSinkPairwiseFinancialInput> type) {
        PriorityDataSink.PriorityDataSinkPairwiseFinancialInput result = new PriorityDataSink.PriorityDataSinkPairwiseFinancialInput();
        result.setId0(input.readString());
        result.setId1(input.readString());
        result.setDate(input.readString());
        result.setValue(input.readDouble());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link PriorityDataSink.IPriorityDataSinkAnalyzedStreamInput} algorithm.
 */
public static class PriorityDataSinkAnalyzedStreamInputSerializer extends Serializer<PriorityDataSink.PriorityDataSinkAnalyzedStreamInput> implements ISerializer<PriorityDataSink.IPriorityDataSinkAnalyzedStreamInput> {

    @Override
    public void serializeTo(PriorityDataSink.IPriorityDataSinkAnalyzedStreamInput object, OutputStream out) throws IOException {
        SPriorityDataSinkAnalyzedStreamInput tmp = SPriorityDataSinkAnalyzedStreamInput.newBuilder()
            .setSymbolId(object.getSymbolId())
            .setTimestamp(object.getTimestamp())
            .setValue(object.getValue())
            .setVolume(object.getVolume())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(PriorityDataSink.IPriorityDataSinkAnalyzedStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolId());
            out.writeLong(object.getTimestamp());
            out.writeDouble(object.getValue());
            out.writeInt(object.getVolume());
        }

    @Override
    public PriorityDataSink.IPriorityDataSinkAnalyzedStreamInput deserializeFrom(InputStream in) throws IOException {
        PriorityDataSink.PriorityDataSinkAnalyzedStreamInput result = new PriorityDataSink.PriorityDataSinkAnalyzedStreamInput();
        SPriorityDataSinkAnalyzedStreamInput tmp = SPriorityDataSinkAnalyzedStreamInput.parseDelimitedFrom(in);
        result.setSymbolId(tmp.getSymbolId());
        result.setTimestamp(tmp.getTimestamp());
        result.setValue(tmp.getValue());
        result.setVolume(tmp.getVolume());
        return result;
    }

        @Override
        public PriorityDataSink.IPriorityDataSinkAnalyzedStreamInput deserializeFrom(IDataInput in) throws IOException {
            PriorityDataSink.PriorityDataSinkAnalyzedStreamInput result = new PriorityDataSink.PriorityDataSinkAnalyzedStreamInput();
            result.setSymbolId(in.nextString());
            result.setTimestamp(in.nextLong());
            result.setValue(in.nextDouble());
            result.setVolume(in.nextInt());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, PriorityDataSink.PriorityDataSinkAnalyzedStreamInput object) {
        output.writeString(object.getSymbolId());
        output.writeLong(object.getTimestamp());
        output.writeDouble(object.getValue());
        output.writeInt(object.getVolume());
    }

    @Override
    public PriorityDataSink.PriorityDataSinkAnalyzedStreamInput read(Kryo kryo, Input input, Class<PriorityDataSink.PriorityDataSinkAnalyzedStreamInput> type) {
        PriorityDataSink.PriorityDataSinkAnalyzedStreamInput result = new PriorityDataSink.PriorityDataSinkAnalyzedStreamInput();
        result.setSymbolId(input.readString());
        result.setTimestamp(input.readLong());
        result.setValue(input.readDouble());
        result.setVolume(input.readInt());
        return result;
    }
}

}
