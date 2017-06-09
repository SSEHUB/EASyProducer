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
import eu.qualimaster.families.imp.FTimeGraph;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTimeGraphProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTimeGraph" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTimeGraphSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraph.IIFTimeGraphDataStreamInput} algorithm.
 */
public static class IFTimeGraphDataStreamInputSerializer extends Serializer<FTimeGraph.IFTimeGraphDataStreamInput> implements ISerializer<IFTimeGraph.IIFTimeGraphDataStreamInput> {

    @Override
    public void serializeTo(IFTimeGraph.IIFTimeGraphDataStreamInput object, OutputStream out) throws IOException {
        SIFTimeGraphDataStreamInput tmp = SIFTimeGraphDataStreamInput.newBuilder()
            .setIsAddition(object.getIsAddition())
            .build();
        tmp.writeDelimitedTo(out);
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUpdate(), out);
    }

        @Override
        public void serializeTo(IFTimeGraph.IIFTimeGraphDataStreamInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUpdate(), out);
            out.writeBoolean(object.getIsAddition());
        }

    @Override
    public IFTimeGraph.IIFTimeGraphDataStreamInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraph.IFTimeGraphDataStreamInput result = new FTimeGraph.IFTimeGraphDataStreamInput();
        result.setUpdate(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        SIFTimeGraphDataStreamInput tmp = SIFTimeGraphDataStreamInput.parseDelimitedFrom(in);
        result.setIsAddition(tmp.getIsAddition());
        return result;
    }

        @Override
        public IFTimeGraph.IIFTimeGraphDataStreamInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraph.IFTimeGraphDataStreamInput result = new FTimeGraph.IFTimeGraphDataStreamInput();
            result.setUpdate(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            result.setIsAddition(in.nextBoolean());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraph.IFTimeGraphDataStreamInput object) {
        kryo.writeObject(output, object.getUpdate());
        output.writeBoolean(object.getIsAddition());
    }

    @Override
    public FTimeGraph.IFTimeGraphDataStreamInput read(Kryo kryo, Input input, Class<FTimeGraph.IFTimeGraphDataStreamInput> type) {
        FTimeGraph.IFTimeGraphDataStreamInput result = new FTimeGraph.IFTimeGraphDataStreamInput();
        result.setUpdate(kryo.readObject(input, Object.class));
        result.setIsAddition(input.readBoolean());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraph.IIFTimeGraphSnapshotQueryStreamInput} algorithm.
 */
public static class IFTimeGraphSnapshotQueryStreamInputSerializer extends Serializer<FTimeGraph.IFTimeGraphSnapshotQueryStreamInput> implements ISerializer<IFTimeGraph.IIFTimeGraphSnapshotQueryStreamInput> {

    @Override
    public void serializeTo(IFTimeGraph.IIFTimeGraphSnapshotQueryStreamInput object, OutputStream out) throws IOException {
        SIFTimeGraphSnapshotQueryStreamInput tmp = SIFTimeGraphSnapshotQueryStreamInput.newBuilder()
            .setStart(object.getStart())
            .setEnd(object.getEnd())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraph.IIFTimeGraphSnapshotQueryStreamInput object, IDataOutput out) throws IOException {
            out.writeLong(object.getStart());
            out.writeLong(object.getEnd());
        }

    @Override
    public IFTimeGraph.IIFTimeGraphSnapshotQueryStreamInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraph.IFTimeGraphSnapshotQueryStreamInput result = new FTimeGraph.IFTimeGraphSnapshotQueryStreamInput();
        SIFTimeGraphSnapshotQueryStreamInput tmp = SIFTimeGraphSnapshotQueryStreamInput.parseDelimitedFrom(in);
        result.setStart(tmp.getStart());
        result.setEnd(tmp.getEnd());
        return result;
    }

        @Override
        public IFTimeGraph.IIFTimeGraphSnapshotQueryStreamInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraph.IFTimeGraphSnapshotQueryStreamInput result = new FTimeGraph.IFTimeGraphSnapshotQueryStreamInput();
            result.setStart(in.nextLong());
            result.setEnd(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraph.IFTimeGraphSnapshotQueryStreamInput object) {
        output.writeLong(object.getStart());
        output.writeLong(object.getEnd());
    }

    @Override
    public FTimeGraph.IFTimeGraphSnapshotQueryStreamInput read(Kryo kryo, Input input, Class<FTimeGraph.IFTimeGraphSnapshotQueryStreamInput> type) {
        FTimeGraph.IFTimeGraphSnapshotQueryStreamInput result = new FTimeGraph.IFTimeGraphSnapshotQueryStreamInput();
        result.setStart(input.readLong());
        result.setEnd(input.readLong());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraph.IIFTimeGraphPathQueryStreamInput} algorithm.
 */
public static class IFTimeGraphPathQueryStreamInputSerializer extends Serializer<FTimeGraph.IFTimeGraphPathQueryStreamInput> implements ISerializer<IFTimeGraph.IIFTimeGraphPathQueryStreamInput> {

    @Override
    public void serializeTo(IFTimeGraph.IIFTimeGraphPathQueryStreamInput object, OutputStream out) throws IOException {
        SIFTimeGraphPathQueryStreamInput tmp = SIFTimeGraphPathQueryStreamInput.newBuilder()
            .setStart(object.getStart())
            .setEnd(object.getEnd())
            .setVertexA(object.getVertexA())
            .setVertexB(object.getVertexB())
            .setType(object.getType())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraph.IIFTimeGraphPathQueryStreamInput object, IDataOutput out) throws IOException {
            out.writeLong(object.getStart());
            out.writeLong(object.getEnd());
            out.writeString(object.getVertexA());
            out.writeString(object.getVertexB());
            out.writeString(object.getType());
        }

    @Override
    public IFTimeGraph.IIFTimeGraphPathQueryStreamInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraph.IFTimeGraphPathQueryStreamInput result = new FTimeGraph.IFTimeGraphPathQueryStreamInput();
        SIFTimeGraphPathQueryStreamInput tmp = SIFTimeGraphPathQueryStreamInput.parseDelimitedFrom(in);
        result.setStart(tmp.getStart());
        result.setEnd(tmp.getEnd());
        result.setVertexA(tmp.getVertexA());
        result.setVertexB(tmp.getVertexB());
        result.setType(tmp.getType());
        return result;
    }

        @Override
        public IFTimeGraph.IIFTimeGraphPathQueryStreamInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraph.IFTimeGraphPathQueryStreamInput result = new FTimeGraph.IFTimeGraphPathQueryStreamInput();
            result.setStart(in.nextLong());
            result.setEnd(in.nextLong());
            result.setVertexA(in.nextString());
            result.setVertexB(in.nextString());
            result.setType(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraph.IFTimeGraphPathQueryStreamInput object) {
        output.writeLong(object.getStart());
        output.writeLong(object.getEnd());
        output.writeString(object.getVertexA());
        output.writeString(object.getVertexB());
        output.writeString(object.getType());
    }

    @Override
    public FTimeGraph.IFTimeGraphPathQueryStreamInput read(Kryo kryo, Input input, Class<FTimeGraph.IFTimeGraphPathQueryStreamInput> type) {
        FTimeGraph.IFTimeGraphPathQueryStreamInput result = new FTimeGraph.IFTimeGraphPathQueryStreamInput();
        result.setStart(input.readLong());
        result.setEnd(input.readLong());
        result.setVertexA(input.readString());
        result.setVertexB(input.readString());
        result.setType(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraph.IIFTimeGraphSnapshotStreamOutput} algorithm.
 */
public static class IFTimeGraphSnapshotStreamOutputSerializer extends Serializer<FTimeGraph.IFTimeGraphSnapshotStreamOutput> implements ISerializer<IFTimeGraph.IIFTimeGraphSnapshotStreamOutput> {

    @Override
    public void serializeTo(IFTimeGraph.IIFTimeGraphSnapshotStreamOutput object, OutputStream out) throws IOException {
        SIFTimeGraphSnapshotStreamOutput tmp = SIFTimeGraphSnapshotStreamOutput.newBuilder()
            .setSnapshot(object.getSnapshot())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraph.IIFTimeGraphSnapshotStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSnapshot());
        }

    @Override
    public IFTimeGraph.IIFTimeGraphSnapshotStreamOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraph.IFTimeGraphSnapshotStreamOutput result = new FTimeGraph.IFTimeGraphSnapshotStreamOutput();
        SIFTimeGraphSnapshotStreamOutput tmp = SIFTimeGraphSnapshotStreamOutput.parseDelimitedFrom(in);
        result.setSnapshot(tmp.getSnapshot());
        return result;
    }

        @Override
        public IFTimeGraph.IIFTimeGraphSnapshotStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraph.IFTimeGraphSnapshotStreamOutput result = new FTimeGraph.IFTimeGraphSnapshotStreamOutput();
            result.setSnapshot(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraph.IFTimeGraphSnapshotStreamOutput object) {
        output.writeString(object.getSnapshot());
    }

    @Override
    public FTimeGraph.IFTimeGraphSnapshotStreamOutput read(Kryo kryo, Input input, Class<FTimeGraph.IFTimeGraphSnapshotStreamOutput> type) {
        FTimeGraph.IFTimeGraphSnapshotStreamOutput result = new FTimeGraph.IFTimeGraphSnapshotStreamOutput();
        result.setSnapshot(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraph.IIFTimeGraphPathStreamOutput} algorithm.
 */
public static class IFTimeGraphPathStreamOutputSerializer extends Serializer<FTimeGraph.IFTimeGraphPathStreamOutput> implements ISerializer<IFTimeGraph.IIFTimeGraphPathStreamOutput> {

    @Override
    public void serializeTo(IFTimeGraph.IIFTimeGraphPathStreamOutput object, OutputStream out) throws IOException {
        SIFTimeGraphPathStreamOutput tmp = SIFTimeGraphPathStreamOutput.newBuilder()
            .setPath(object.getPath())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraph.IIFTimeGraphPathStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getPath());
        }

    @Override
    public IFTimeGraph.IIFTimeGraphPathStreamOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraph.IFTimeGraphPathStreamOutput result = new FTimeGraph.IFTimeGraphPathStreamOutput();
        SIFTimeGraphPathStreamOutput tmp = SIFTimeGraphPathStreamOutput.parseDelimitedFrom(in);
        result.setPath(tmp.getPath());
        return result;
    }

        @Override
        public IFTimeGraph.IIFTimeGraphPathStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraph.IFTimeGraphPathStreamOutput result = new FTimeGraph.IFTimeGraphPathStreamOutput();
            result.setPath(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraph.IFTimeGraphPathStreamOutput object) {
        output.writeString(object.getPath());
    }

    @Override
    public FTimeGraph.IFTimeGraphPathStreamOutput read(Kryo kryo, Input input, Class<FTimeGraph.IFTimeGraphPathStreamOutput> type) {
        FTimeGraph.IFTimeGraphPathStreamOutput result = new FTimeGraph.IFTimeGraphPathStreamOutput();
        result.setPath(input.readString());
        return result;
    }
}

}
