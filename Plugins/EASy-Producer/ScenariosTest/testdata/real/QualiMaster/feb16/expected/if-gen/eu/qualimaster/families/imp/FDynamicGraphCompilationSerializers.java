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
                .setPairwiseCorrelationFinancial(object.getPairwiseCorrelationFinancial())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public IFDynamicGraphCompilation.IIFDynamicGraphCompilationPairwiseFinancialInput deserializeFrom(InputStream in) throws IOException {
            FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput();
            SIFDynamicGraphCompilationPairwiseFinancialInput tmp = SIFDynamicGraphCompilationPairwiseFinancialInput.parseDelimitedFrom(in);
            result.setPairwiseCorrelationFinancial(tmp.getPairwiseCorrelationFinancial());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput object) {
            output.writeString(object.getPairwiseCorrelationFinancial());
        }

        @Override
        public FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput read(Kryo kryo, Input input, Class<FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput> type) {
            FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput();
            result.setPairwiseCorrelationFinancial(input.readString());
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
        public IFDynamicGraphCompilation.IIFDynamicGraphCompilationEdgeStreamOutput deserializeFrom(InputStream in) throws IOException {
            FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput result = new FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput();
            SIFDynamicGraphCompilationEdgeStreamOutput tmp = SIFDynamicGraphCompilationEdgeStreamOutput.parseDelimitedFrom(in);
            result.setEdge(tmp.getEdge());
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
