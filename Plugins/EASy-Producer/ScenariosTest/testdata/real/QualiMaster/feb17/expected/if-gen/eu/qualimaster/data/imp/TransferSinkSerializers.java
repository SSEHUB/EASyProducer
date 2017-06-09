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
import eu.qualimaster.data.imp.TransferSink;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.TransferSinkProtos.*;
/**
 * The implementation of the serializers for the data element "TransferSink" (GEN).
 */
@Generated(value="EASy-Producer")
public class TransferSinkSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link TransferSink.ITransferSinkPairwiseFinancialInput} algorithm.
 */
public static class TransferSinkPairwiseFinancialInputSerializer extends Serializer<TransferSink.TransferSinkPairwiseFinancialInput> implements ISerializer<TransferSink.ITransferSinkPairwiseFinancialInput> {

    @Override
    public void serializeTo(TransferSink.ITransferSinkPairwiseFinancialInput object, OutputStream out) throws IOException {
        STransferSinkPairwiseFinancialInput tmp = STransferSinkPairwiseFinancialInput.newBuilder()
            .setId0(object.getId0())
            .setId1(object.getId1())
            .setDate(object.getDate())
            .setValue(object.getValue())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(TransferSink.ITransferSinkPairwiseFinancialInput object, IDataOutput out) throws IOException {
            out.writeString(object.getId0());
            out.writeString(object.getId1());
            out.writeString(object.getDate());
            out.writeDouble(object.getValue());
        }

    @Override
    public TransferSink.ITransferSinkPairwiseFinancialInput deserializeFrom(InputStream in) throws IOException {
        TransferSink.TransferSinkPairwiseFinancialInput result = new TransferSink.TransferSinkPairwiseFinancialInput();
        STransferSinkPairwiseFinancialInput tmp = STransferSinkPairwiseFinancialInput.parseDelimitedFrom(in);
        result.setId0(tmp.getId0());
        result.setId1(tmp.getId1());
        result.setDate(tmp.getDate());
        result.setValue(tmp.getValue());
        return result;
    }

        @Override
        public TransferSink.ITransferSinkPairwiseFinancialInput deserializeFrom(IDataInput in) throws IOException {
            TransferSink.TransferSinkPairwiseFinancialInput result = new TransferSink.TransferSinkPairwiseFinancialInput();
            result.setId0(in.nextString());
            result.setId1(in.nextString());
            result.setDate(in.nextString());
            result.setValue(in.nextDouble());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, TransferSink.TransferSinkPairwiseFinancialInput object) {
        output.writeString(object.getId0());
        output.writeString(object.getId1());
        output.writeString(object.getDate());
        output.writeDouble(object.getValue());
    }

    @Override
    public TransferSink.TransferSinkPairwiseFinancialInput read(Kryo kryo, Input input, Class<TransferSink.TransferSinkPairwiseFinancialInput> type) {
        TransferSink.TransferSinkPairwiseFinancialInput result = new TransferSink.TransferSinkPairwiseFinancialInput();
        result.setId0(input.readString());
        result.setId1(input.readString());
        result.setDate(input.readString());
        result.setValue(input.readDouble());
        return result;
    }
}

}
