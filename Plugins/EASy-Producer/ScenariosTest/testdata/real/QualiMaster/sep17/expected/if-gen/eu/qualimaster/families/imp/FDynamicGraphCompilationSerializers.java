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
import eu.qualimaster.families.imp.FDynamicGraphCompilation;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FDynamicGraphCompilationProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFDynamicGraphCompilation" (GEN).
 */
@Generated(value="EASy-Producer")
public class FDynamicGraphCompilationSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFDynamicGraphCompilation.IIFDynamicGraphCompilationPairwiseFinancialInput} algorithm.
 */
public static class IFDynamicGraphCompilationPairwiseFinancialInputSerializer extends Serializer<FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput> implements ISerializer<IFDynamicGraphCompilation.IIFDynamicGraphCompilationPairwiseFinancialInput> {

    @Override
    public void serializeTo(IFDynamicGraphCompilation.IIFDynamicGraphCompilationPairwiseFinancialInput object, OutputStream out) throws IOException {
        SIFDynamicGraphCompilationPairwiseFinancialInput tmp = SIFDynamicGraphCompilationPairwiseFinancialInput.newBuilder()
            .setId0(object.getId0())
            .setId1(object.getId1())
            .setDate(object.getDate())
            .setValue(object.getValue())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFDynamicGraphCompilation.IIFDynamicGraphCompilationPairwiseFinancialInput object, IDataOutput out) throws IOException {
            out.writeString(object.getId0());
            out.writeString(object.getId1());
            out.writeString(object.getDate());
            out.writeDouble(object.getValue());
        }

    @Override
    public IFDynamicGraphCompilation.IIFDynamicGraphCompilationPairwiseFinancialInput deserializeFrom(InputStream in) throws IOException {
        FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput();
        SIFDynamicGraphCompilationPairwiseFinancialInput tmp = SIFDynamicGraphCompilationPairwiseFinancialInput.parseDelimitedFrom(in);
        result.setId0(tmp.getId0());
        result.setId1(tmp.getId1());
        result.setDate(tmp.getDate());
        result.setValue(tmp.getValue());
        return result;
    }

        @Override
        public IFDynamicGraphCompilation.IIFDynamicGraphCompilationPairwiseFinancialInput deserializeFrom(IDataInput in) throws IOException {
            FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput();
            result.setId0(in.nextString());
            result.setId1(in.nextString());
            result.setDate(in.nextString());
            result.setValue(in.nextDouble());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput object) {
        output.writeString(object.getId0());
        output.writeString(object.getId1());
        output.writeString(object.getDate());
        output.writeDouble(object.getValue());
    }

    @Override
    public FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput read(Kryo kryo, Input input, Class<FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput> type) {
        FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput();
        result.setId0(input.readString());
        result.setId1(input.readString());
        result.setDate(input.readString());
        result.setValue(input.readDouble());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFDynamicGraphCompilation.IIFDynamicGraphCompilationEdgeStreamOutput} algorithm.
 */
public static class IFDynamicGraphCompilationEdgeStreamOutputSerializer extends Serializer<FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput> implements ISerializer<IFDynamicGraphCompilation.IIFDynamicGraphCompilationEdgeStreamOutput> {

    @Override
    public void serializeTo(IFDynamicGraphCompilation.IIFDynamicGraphCompilationEdgeStreamOutput object, OutputStream out) throws IOException {
        SIFDynamicGraphCompilationEdgeStreamOutput tmp = SIFDynamicGraphCompilationEdgeStreamOutput.newBuilder()
            .setEdge(object.getEdge())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFDynamicGraphCompilation.IIFDynamicGraphCompilationEdgeStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getEdge());
        }

    @Override
    public IFDynamicGraphCompilation.IIFDynamicGraphCompilationEdgeStreamOutput deserializeFrom(InputStream in) throws IOException {
        FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput();
        SIFDynamicGraphCompilationEdgeStreamOutput tmp = SIFDynamicGraphCompilationEdgeStreamOutput.parseDelimitedFrom(in);
        result.setEdge(tmp.getEdge());
        return result;
    }

        @Override
        public IFDynamicGraphCompilation.IIFDynamicGraphCompilationEdgeStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput();
            result.setEdge(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput object) {
        output.writeString(object.getEdge());
    }

    @Override
    public FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput read(Kryo kryo, Input input, Class<FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput> type) {
        FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput();
        result.setEdge(input.readString());
        return result;
    }
}

}
