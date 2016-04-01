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
import eu.qualimaster.families.imp.FDynamicHubComputation;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FDynamicHubComputationProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFDynamicHubComputation" (GEN).
 */
@Generated(value="EASy-Producer")
public class FDynamicHubComputationSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFDynamicHubComputation.IIFDynamicHubComputationEdgeStreamInput} algorithm.
     */
    public static class IFDynamicHubComputationEdgeStreamInputSerializer extends Serializer<FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput> implements ISerializer<IFDynamicHubComputation.IIFDynamicHubComputationEdgeStreamInput> {

        @Override
        public void serializeTo(IFDynamicHubComputation.IIFDynamicHubComputationEdgeStreamInput object, OutputStream out) throws IOException {
            SIFDynamicHubComputationEdgeStreamInput tmp = SIFDynamicHubComputationEdgeStreamInput.newBuilder()
                .setEdge(object.getEdge())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public IFDynamicHubComputation.IIFDynamicHubComputationEdgeStreamInput deserializeFrom(InputStream in) throws IOException {
            FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput result = new FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput();
            SIFDynamicHubComputationEdgeStreamInput tmp = SIFDynamicHubComputationEdgeStreamInput.parseDelimitedFrom(in);
            result.setEdge(tmp.getEdge());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput object) {
            output.writeString(object.getEdge());
        }

        @Override
        public FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput read(Kryo kryo, Input input, Class<FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput> type) {
            FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput result = new FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput();
            result.setEdge(input.readString());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFDynamicHubComputation.IIFDynamicHubComputationHubStreamOutput} algorithm.
     */
    public static class IFDynamicHubComputationHubStreamOutputSerializer extends Serializer<FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput> implements ISerializer<IFDynamicHubComputation.IIFDynamicHubComputationHubStreamOutput> {

        @Override
        public void serializeTo(IFDynamicHubComputation.IIFDynamicHubComputationHubStreamOutput object, OutputStream out) throws IOException {
            SIFDynamicHubComputationHubStreamOutput tmp = SIFDynamicHubComputationHubStreamOutput.newBuilder()
                .setHubList(object.getHubList())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public IFDynamicHubComputation.IIFDynamicHubComputationHubStreamOutput deserializeFrom(InputStream in) throws IOException {
            FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput result = new FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput();
            SIFDynamicHubComputationHubStreamOutput tmp = SIFDynamicHubComputationHubStreamOutput.parseDelimitedFrom(in);
            result.setHubList(tmp.getHubList());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput object) {
            output.writeString(object.getHubList());
        }

        @Override
        public FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput read(Kryo kryo, Input input, Class<FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput> type) {
            FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput result = new FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput();
            result.setHubList(input.readString());
            return result;
        }
    }

}
