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
import eu.qualimaster.data.imp.TimeTravelSink;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.TimeTravelSinkProtos.*;
/**
 * The implementation of the serializers for the data element "TimeTravelSink" (GEN).
 */
@Generated(value="EASy-Producer")
public class TimeTravelSinkSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link TimeTravelSink.ITimeTravelSinkSnapshotStreamInput} algorithm.
 */
public static class TimeTravelSinkSnapshotStreamInputSerializer extends Serializer<TimeTravelSink.TimeTravelSinkSnapshotStreamInput> implements ISerializer<TimeTravelSink.ITimeTravelSinkSnapshotStreamInput> {

    @Override
    public void serializeTo(TimeTravelSink.ITimeTravelSinkSnapshotStreamInput object, OutputStream out) throws IOException {
        STimeTravelSinkSnapshotStreamInput tmp = STimeTravelSinkSnapshotStreamInput.newBuilder()
            .setSnapshot(object.getSnapshot())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(TimeTravelSink.ITimeTravelSinkSnapshotStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getSnapshot());
        }

    @Override
    public TimeTravelSink.ITimeTravelSinkSnapshotStreamInput deserializeFrom(InputStream in) throws IOException {
        TimeTravelSink.TimeTravelSinkSnapshotStreamInput result = new TimeTravelSink.TimeTravelSinkSnapshotStreamInput();
        STimeTravelSinkSnapshotStreamInput tmp = STimeTravelSinkSnapshotStreamInput.parseDelimitedFrom(in);
        result.setSnapshot(tmp.getSnapshot());
        return result;
    }

        @Override
        public TimeTravelSink.ITimeTravelSinkSnapshotStreamInput deserializeFrom(IDataInput in) throws IOException {
            TimeTravelSink.TimeTravelSinkSnapshotStreamInput result = new TimeTravelSink.TimeTravelSinkSnapshotStreamInput();
            result.setSnapshot(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, TimeTravelSink.TimeTravelSinkSnapshotStreamInput object) {
        output.writeString(object.getSnapshot());
    }

    @Override
    public TimeTravelSink.TimeTravelSinkSnapshotStreamInput read(Kryo kryo, Input input, Class<TimeTravelSink.TimeTravelSinkSnapshotStreamInput> type) {
        TimeTravelSink.TimeTravelSinkSnapshotStreamInput result = new TimeTravelSink.TimeTravelSinkSnapshotStreamInput();
        result.setSnapshot(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link TimeTravelSink.ITimeTravelSinkPathStreamInput} algorithm.
 */
public static class TimeTravelSinkPathStreamInputSerializer extends Serializer<TimeTravelSink.TimeTravelSinkPathStreamInput> implements ISerializer<TimeTravelSink.ITimeTravelSinkPathStreamInput> {

    @Override
    public void serializeTo(TimeTravelSink.ITimeTravelSinkPathStreamInput object, OutputStream out) throws IOException {
        STimeTravelSinkPathStreamInput tmp = STimeTravelSinkPathStreamInput.newBuilder()
            .setPath(object.getPath())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(TimeTravelSink.ITimeTravelSinkPathStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getPath());
        }

    @Override
    public TimeTravelSink.ITimeTravelSinkPathStreamInput deserializeFrom(InputStream in) throws IOException {
        TimeTravelSink.TimeTravelSinkPathStreamInput result = new TimeTravelSink.TimeTravelSinkPathStreamInput();
        STimeTravelSinkPathStreamInput tmp = STimeTravelSinkPathStreamInput.parseDelimitedFrom(in);
        result.setPath(tmp.getPath());
        return result;
    }

        @Override
        public TimeTravelSink.ITimeTravelSinkPathStreamInput deserializeFrom(IDataInput in) throws IOException {
            TimeTravelSink.TimeTravelSinkPathStreamInput result = new TimeTravelSink.TimeTravelSinkPathStreamInput();
            result.setPath(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, TimeTravelSink.TimeTravelSinkPathStreamInput object) {
        output.writeString(object.getPath());
    }

    @Override
    public TimeTravelSink.TimeTravelSinkPathStreamInput read(Kryo kryo, Input input, Class<TimeTravelSink.TimeTravelSinkPathStreamInput> type) {
        TimeTravelSink.TimeTravelSinkPathStreamInput result = new TimeTravelSink.TimeTravelSinkPathStreamInput();
        result.setPath(input.readString());
        return result;
    }
}

}
