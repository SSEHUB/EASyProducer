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
import eu.qualimaster.data.imp.TimeGraphQueriesSource;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.TimeGraphQueriesSourceProtos.*;
/**
 * The implementation of the serializers for the data element "TimeGraphQueriesSource" (GEN).
 */
@Generated(value="EASy-Producer")
public class TimeGraphQueriesSourceSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link TimeGraphQueriesSource.ITimeGraphQueriesSourceSnapshotQueryStreamOutput} algorithm.
 */
public static class TimeGraphQueriesSourceSnapshotQueryStreamOutputSerializer extends Serializer<TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput> implements ISerializer<TimeGraphQueriesSource.ITimeGraphQueriesSourceSnapshotQueryStreamOutput> {

    @Override
    public void serializeTo(TimeGraphQueriesSource.ITimeGraphQueriesSourceSnapshotQueryStreamOutput object, OutputStream out) throws IOException {
        STimeGraphQueriesSourceSnapshotQueryStreamOutput tmp = STimeGraphQueriesSourceSnapshotQueryStreamOutput.newBuilder()
            .setStart(object.getStart())
            .setEnd(object.getEnd())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(TimeGraphQueriesSource.ITimeGraphQueriesSourceSnapshotQueryStreamOutput object, IDataOutput out) throws IOException {
            out.writeLong(object.getStart());
            out.writeLong(object.getEnd());
        }

    @Override
    public TimeGraphQueriesSource.ITimeGraphQueriesSourceSnapshotQueryStreamOutput deserializeFrom(InputStream in) throws IOException {
        TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput result = new TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput();
        STimeGraphQueriesSourceSnapshotQueryStreamOutput tmp = STimeGraphQueriesSourceSnapshotQueryStreamOutput.parseDelimitedFrom(in);
        result.setStart(tmp.getStart());
        result.setEnd(tmp.getEnd());
        return result;
    }

        @Override
        public TimeGraphQueriesSource.ITimeGraphQueriesSourceSnapshotQueryStreamOutput deserializeFrom(IDataInput in) throws IOException {
            TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput result = new TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput();
            result.setStart(in.nextLong());
            result.setEnd(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput object) {
        output.writeLong(object.getStart());
        output.writeLong(object.getEnd());
    }

    @Override
    public TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput read(Kryo kryo, Input input, Class<TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput> type) {
        TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput result = new TimeGraphQueriesSource.TimeGraphQueriesSourceSnapshotQueryStreamOutput();
        result.setStart(input.readLong());
        result.setEnd(input.readLong());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link TimeGraphQueriesSource.ITimeGraphQueriesSourcePathQueryStreamOutput} algorithm.
 */
public static class TimeGraphQueriesSourcePathQueryStreamOutputSerializer extends Serializer<TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput> implements ISerializer<TimeGraphQueriesSource.ITimeGraphQueriesSourcePathQueryStreamOutput> {

    @Override
    public void serializeTo(TimeGraphQueriesSource.ITimeGraphQueriesSourcePathQueryStreamOutput object, OutputStream out) throws IOException {
        STimeGraphQueriesSourcePathQueryStreamOutput tmp = STimeGraphQueriesSourcePathQueryStreamOutput.newBuilder()
            .setStart(object.getStart())
            .setEnd(object.getEnd())
            .setVertexA(object.getVertexA())
            .setVertexB(object.getVertexB())
            .setType(object.getType())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(TimeGraphQueriesSource.ITimeGraphQueriesSourcePathQueryStreamOutput object, IDataOutput out) throws IOException {
            out.writeLong(object.getStart());
            out.writeLong(object.getEnd());
            out.writeString(object.getVertexA());
            out.writeString(object.getVertexB());
            out.writeString(object.getType());
        }

    @Override
    public TimeGraphQueriesSource.ITimeGraphQueriesSourcePathQueryStreamOutput deserializeFrom(InputStream in) throws IOException {
        TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput result = new TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput();
        STimeGraphQueriesSourcePathQueryStreamOutput tmp = STimeGraphQueriesSourcePathQueryStreamOutput.parseDelimitedFrom(in);
        result.setStart(tmp.getStart());
        result.setEnd(tmp.getEnd());
        result.setVertexA(tmp.getVertexA());
        result.setVertexB(tmp.getVertexB());
        result.setType(tmp.getType());
        return result;
    }

        @Override
        public TimeGraphQueriesSource.ITimeGraphQueriesSourcePathQueryStreamOutput deserializeFrom(IDataInput in) throws IOException {
            TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput result = new TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput();
            result.setStart(in.nextLong());
            result.setEnd(in.nextLong());
            result.setVertexA(in.nextString());
            result.setVertexB(in.nextString());
            result.setType(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput object) {
        output.writeLong(object.getStart());
        output.writeLong(object.getEnd());
        output.writeString(object.getVertexA());
        output.writeString(object.getVertexB());
        output.writeString(object.getType());
    }

    @Override
    public TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput read(Kryo kryo, Input input, Class<TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput> type) {
        TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput result = new TimeGraphQueriesSource.TimeGraphQueriesSourcePathQueryStreamOutput();
        result.setStart(input.readLong());
        result.setEnd(input.readLong());
        result.setVertexA(input.readString());
        result.setVertexB(input.readString());
        result.setType(input.readString());
        return result;
    }
}

}
