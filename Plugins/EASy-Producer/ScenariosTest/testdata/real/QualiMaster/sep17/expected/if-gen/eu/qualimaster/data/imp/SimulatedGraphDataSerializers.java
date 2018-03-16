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
import eu.qualimaster.data.imp.SimulatedGraphData;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.SimulatedGraphDataProtos.*;
/**
 * The implementation of the serializers for the data element "SimulatedGraphData" (GEN).
 */
@Generated(value="EASy-Producer")
public class SimulatedGraphDataSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link SimulatedGraphData.ISimulatedGraphDataEdgeStreamOutput} algorithm.
 */
public static class SimulatedGraphDataEdgeStreamOutputSerializer extends Serializer<SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput> implements ISerializer<SimulatedGraphData.ISimulatedGraphDataEdgeStreamOutput> {

    @Override
    public void serializeTo(SimulatedGraphData.ISimulatedGraphDataEdgeStreamOutput object, OutputStream out) throws IOException {
        SSimulatedGraphDataEdgeStreamOutput tmp = SSimulatedGraphDataEdgeStreamOutput.newBuilder()
            .setEdge(object.getEdge())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(SimulatedGraphData.ISimulatedGraphDataEdgeStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getEdge());
        }

    @Override
    public SimulatedGraphData.ISimulatedGraphDataEdgeStreamOutput deserializeFrom(InputStream in) throws IOException {
        SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput result = new SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput();
        SSimulatedGraphDataEdgeStreamOutput tmp = SSimulatedGraphDataEdgeStreamOutput.parseDelimitedFrom(in);
        result.setEdge(tmp.getEdge());
        return result;
    }

        @Override
        public SimulatedGraphData.ISimulatedGraphDataEdgeStreamOutput deserializeFrom(IDataInput in) throws IOException {
            SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput result = new SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput();
            result.setEdge(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput object) {
        output.writeString(object.getEdge());
    }

    @Override
    public SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput read(Kryo kryo, Input input, Class<SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput> type) {
        SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput result = new SimulatedGraphData.SimulatedGraphDataEdgeStreamOutput();
        result.setEdge(input.readString());
        return result;
    }
}

}
