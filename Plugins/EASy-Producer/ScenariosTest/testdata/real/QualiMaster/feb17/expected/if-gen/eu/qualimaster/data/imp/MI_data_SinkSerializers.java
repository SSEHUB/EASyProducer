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
import eu.qualimaster.data.imp.MI_data_Sink;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.MI_data_SinkProtos.*;
/**
 * The implementation of the serializers for the data element "MI_data_Sink" (GEN).
 */
@Generated(value="EASy-Producer")
public class MI_data_SinkSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link MI_data_Sink.IMI_data_SinkPairwiseFinancialInput} algorithm.
 */
public static class MI_data_SinkPairwiseFinancialInputSerializer extends Serializer<MI_data_Sink.MI_data_SinkPairwiseFinancialInput> implements ISerializer<MI_data_Sink.IMI_data_SinkPairwiseFinancialInput> {

    @Override
    public void serializeTo(MI_data_Sink.IMI_data_SinkPairwiseFinancialInput object, OutputStream out) throws IOException {
        SMI_data_SinkPairwiseFinancialInput tmp = SMI_data_SinkPairwiseFinancialInput.newBuilder()
            .setId0(object.getId0())
            .setId1(object.getId1())
            .setDate(object.getDate())
            .setValue(object.getValue())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(MI_data_Sink.IMI_data_SinkPairwiseFinancialInput object, IDataOutput out) throws IOException {
            out.writeString(object.getId0());
            out.writeString(object.getId1());
            out.writeString(object.getDate());
            out.writeDouble(object.getValue());
        }

    @Override
    public MI_data_Sink.IMI_data_SinkPairwiseFinancialInput deserializeFrom(InputStream in) throws IOException {
        MI_data_Sink.MI_data_SinkPairwiseFinancialInput result = new MI_data_Sink.MI_data_SinkPairwiseFinancialInput();
        SMI_data_SinkPairwiseFinancialInput tmp = SMI_data_SinkPairwiseFinancialInput.parseDelimitedFrom(in);
        result.setId0(tmp.getId0());
        result.setId1(tmp.getId1());
        result.setDate(tmp.getDate());
        result.setValue(tmp.getValue());
        return result;
    }

        @Override
        public MI_data_Sink.IMI_data_SinkPairwiseFinancialInput deserializeFrom(IDataInput in) throws IOException {
            MI_data_Sink.MI_data_SinkPairwiseFinancialInput result = new MI_data_Sink.MI_data_SinkPairwiseFinancialInput();
            result.setId0(in.nextString());
            result.setId1(in.nextString());
            result.setDate(in.nextString());
            result.setValue(in.nextDouble());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, MI_data_Sink.MI_data_SinkPairwiseFinancialInput object) {
        output.writeString(object.getId0());
        output.writeString(object.getId1());
        output.writeString(object.getDate());
        output.writeDouble(object.getValue());
    }

    @Override
    public MI_data_Sink.MI_data_SinkPairwiseFinancialInput read(Kryo kryo, Input input, Class<MI_data_Sink.MI_data_SinkPairwiseFinancialInput> type) {
        MI_data_Sink.MI_data_SinkPairwiseFinancialInput result = new MI_data_Sink.MI_data_SinkPairwiseFinancialInput();
        result.setId0(input.readString());
        result.setId1(input.readString());
        result.setDate(input.readString());
        result.setValue(input.readDouble());
        return result;
    }
}

}
