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
import eu.qualimaster.data.imp.DynamicGraphSink;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.DynamicGraphSinkProtos.*;
/**
 * The implementation of the serializers for the data element "DynamicGraphSink" (GEN).
 */
@Generated(value="EASy-Producer")
public class DynamicGraphSinkSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link DynamicGraphSink.IDynamicGraphSinkHubStreamInput} algorithm.
 */
public static class DynamicGraphSinkHubStreamInputSerializer extends Serializer<DynamicGraphSink.DynamicGraphSinkHubStreamInput> implements ISerializer<DynamicGraphSink.IDynamicGraphSinkHubStreamInput> {

    @Override
    public void serializeTo(DynamicGraphSink.IDynamicGraphSinkHubStreamInput object, OutputStream out) throws IOException {
        SDynamicGraphSinkHubStreamInput tmp = SDynamicGraphSinkHubStreamInput.newBuilder()
            .setHubList(object.getHubList())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(DynamicGraphSink.IDynamicGraphSinkHubStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getHubList());
        }

    @Override
    public DynamicGraphSink.IDynamicGraphSinkHubStreamInput deserializeFrom(InputStream in) throws IOException {
        DynamicGraphSink.DynamicGraphSinkHubStreamInput result = new DynamicGraphSink.DynamicGraphSinkHubStreamInput();
        SDynamicGraphSinkHubStreamInput tmp = SDynamicGraphSinkHubStreamInput.parseDelimitedFrom(in);
        result.setHubList(tmp.getHubList());
        return result;
    }

        @Override
        public DynamicGraphSink.IDynamicGraphSinkHubStreamInput deserializeFrom(IDataInput in) throws IOException {
            DynamicGraphSink.DynamicGraphSinkHubStreamInput result = new DynamicGraphSink.DynamicGraphSinkHubStreamInput();
            result.setHubList(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, DynamicGraphSink.DynamicGraphSinkHubStreamInput object) {
        output.writeString(object.getHubList());
    }

    @Override
    public DynamicGraphSink.DynamicGraphSinkHubStreamInput read(Kryo kryo, Input input, Class<DynamicGraphSink.DynamicGraphSinkHubStreamInput> type) {
        DynamicGraphSink.DynamicGraphSinkHubStreamInput result = new DynamicGraphSink.DynamicGraphSinkHubStreamInput();
        result.setHubList(input.readString());
        return result;
    }
}

}
