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
import eu.qualimaster.families.imp.FTimeGraphQueryExecutor;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTimeGraphQueryExecutorProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTimeGraphQueryExecutor" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTimeGraphQueryExecutorSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotQueryStreamInput} algorithm.
 */
public static class IFTimeGraphQueryExecutorSnapshotQueryStreamInputSerializer extends Serializer<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput> implements ISerializer<IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotQueryStreamInput> {

    @Override
    public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotQueryStreamInput object, OutputStream out) throws IOException {
        SIFTimeGraphQueryExecutorSnapshotQueryStreamInput tmp = SIFTimeGraphQueryExecutorSnapshotQueryStreamInput.newBuilder()
            .setStart(object.getStart())
            .setEnd(object.getEnd())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotQueryStreamInput object, IDataOutput out) throws IOException {
            out.writeLong(object.getStart());
            out.writeLong(object.getEnd());
        }

    @Override
    public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotQueryStreamInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput();
        SIFTimeGraphQueryExecutorSnapshotQueryStreamInput tmp = SIFTimeGraphQueryExecutorSnapshotQueryStreamInput.parseDelimitedFrom(in);
        result.setStart(tmp.getStart());
        result.setEnd(tmp.getEnd());
        return result;
    }

        @Override
        public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotQueryStreamInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput();
            result.setStart(in.nextLong());
            result.setEnd(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput object) {
        output.writeLong(object.getStart());
        output.writeLong(object.getEnd());
    }

    @Override
    public FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput read(Kryo kryo, Input input, Class<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput> type) {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotQueryStreamInput();
        result.setStart(input.readLong());
        result.setEnd(input.readLong());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathQueryStreamInput} algorithm.
 */
public static class IFTimeGraphQueryExecutorPathQueryStreamInputSerializer extends Serializer<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput> implements ISerializer<IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathQueryStreamInput> {

    @Override
    public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathQueryStreamInput object, OutputStream out) throws IOException {
        SIFTimeGraphQueryExecutorPathQueryStreamInput tmp = SIFTimeGraphQueryExecutorPathQueryStreamInput.newBuilder()
            .setStart(object.getStart())
            .setEnd(object.getEnd())
            .setVertexA(object.getVertexA())
            .setVertexB(object.getVertexB())
            .setType(object.getType())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathQueryStreamInput object, IDataOutput out) throws IOException {
            out.writeLong(object.getStart());
            out.writeLong(object.getEnd());
            out.writeString(object.getVertexA());
            out.writeString(object.getVertexB());
            out.writeString(object.getType());
        }

    @Override
    public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathQueryStreamInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput();
        SIFTimeGraphQueryExecutorPathQueryStreamInput tmp = SIFTimeGraphQueryExecutorPathQueryStreamInput.parseDelimitedFrom(in);
        result.setStart(tmp.getStart());
        result.setEnd(tmp.getEnd());
        result.setVertexA(tmp.getVertexA());
        result.setVertexB(tmp.getVertexB());
        result.setType(tmp.getType());
        return result;
    }

        @Override
        public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathQueryStreamInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput();
            result.setStart(in.nextLong());
            result.setEnd(in.nextLong());
            result.setVertexA(in.nextString());
            result.setVertexB(in.nextString());
            result.setType(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput object) {
        output.writeLong(object.getStart());
        output.writeLong(object.getEnd());
        output.writeString(object.getVertexA());
        output.writeString(object.getVertexB());
        output.writeString(object.getType());
    }

    @Override
    public FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput read(Kryo kryo, Input input, Class<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput> type) {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathQueryStreamInput();
        result.setStart(input.readLong());
        result.setEnd(input.readLong());
        result.setVertexA(input.readString());
        result.setVertexB(input.readString());
        result.setType(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorExternalResponsesInput} algorithm.
 */
public static class IFTimeGraphQueryExecutorExternalResponsesInputSerializer extends Serializer<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput> implements ISerializer<IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorExternalResponsesInput> {

    @Override
    public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorExternalResponsesInput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getExternalResponse(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorExternalResponsesInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getExternalResponse(), out);
        }

    @Override
    public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorExternalResponsesInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput();
        result.setExternalResponse(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorExternalResponsesInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput();
            result.setExternalResponse(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput object) {
        kryo.writeObject(output, object.getExternalResponse());
    }

    @Override
    public FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput read(Kryo kryo, Input input, Class<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput> type) {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorExternalResponsesInput();
        result.setExternalResponse(kryo.readObject(input, Object.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotStreamOutput} algorithm.
 */
public static class IFTimeGraphQueryExecutorSnapshotStreamOutputSerializer extends Serializer<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput> implements ISerializer<IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotStreamOutput> {

    @Override
    public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotStreamOutput object, OutputStream out) throws IOException {
        SIFTimeGraphQueryExecutorSnapshotStreamOutput tmp = SIFTimeGraphQueryExecutorSnapshotStreamOutput.newBuilder()
            .setSnapshot(object.getSnapshot())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSnapshot());
        }

    @Override
    public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotStreamOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput();
        SIFTimeGraphQueryExecutorSnapshotStreamOutput tmp = SIFTimeGraphQueryExecutorSnapshotStreamOutput.parseDelimitedFrom(in);
        result.setSnapshot(tmp.getSnapshot());
        return result;
    }

        @Override
        public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorSnapshotStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput();
            result.setSnapshot(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput object) {
        output.writeString(object.getSnapshot());
    }

    @Override
    public FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput read(Kryo kryo, Input input, Class<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput> type) {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorSnapshotStreamOutput();
        result.setSnapshot(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathStreamOutput} algorithm.
 */
public static class IFTimeGraphQueryExecutorPathStreamOutputSerializer extends Serializer<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput> implements ISerializer<IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathStreamOutput> {

    @Override
    public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathStreamOutput object, OutputStream out) throws IOException {
        SIFTimeGraphQueryExecutorPathStreamOutput tmp = SIFTimeGraphQueryExecutorPathStreamOutput.newBuilder()
            .setPath(object.getPath())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getPath());
        }

    @Override
    public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathStreamOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput();
        SIFTimeGraphQueryExecutorPathStreamOutput tmp = SIFTimeGraphQueryExecutorPathStreamOutput.parseDelimitedFrom(in);
        result.setPath(tmp.getPath());
        return result;
    }

        @Override
        public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorPathStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput();
            result.setPath(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput object) {
        output.writeString(object.getPath());
    }

    @Override
    public FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput read(Kryo kryo, Input input, Class<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput> type) {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorPathStreamOutput();
        result.setPath(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorUnicastRequestsOutput} algorithm.
 */
public static class IFTimeGraphQueryExecutorUnicastRequestsOutputSerializer extends Serializer<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput> implements ISerializer<IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorUnicastRequestsOutput> {

    @Override
    public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorUnicastRequestsOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUnicastExternalRequest(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorUnicastRequestsOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUnicastExternalRequest(), out);
        }

    @Override
    public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorUnicastRequestsOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput();
        result.setUnicastExternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorUnicastRequestsOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput();
            result.setUnicastExternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput object) {
        kryo.writeObject(output, object.getUnicastExternalRequest());
    }

    @Override
    public FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput read(Kryo kryo, Input input, Class<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput> type) {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorUnicastRequestsOutput();
        result.setUnicastExternalRequest(kryo.readObject(input, Object.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorBroadcastRequestsOutput} algorithm.
 */
public static class IFTimeGraphQueryExecutorBroadcastRequestsOutputSerializer extends Serializer<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput> implements ISerializer<IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorBroadcastRequestsOutput> {

    @Override
    public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorBroadcastRequestsOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getBroadcastExternalRequest(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorBroadcastRequestsOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getBroadcastExternalRequest(), out);
        }

    @Override
    public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorBroadcastRequestsOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput();
        result.setBroadcastExternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTimeGraphQueryExecutor.IIFTimeGraphQueryExecutorBroadcastRequestsOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput();
            result.setBroadcastExternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput object) {
        kryo.writeObject(output, object.getBroadcastExternalRequest());
    }

    @Override
    public FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput read(Kryo kryo, Input input, Class<FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput> type) {
        FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput result = new FTimeGraphQueryExecutor.IFTimeGraphQueryExecutorBroadcastRequestsOutput();
        result.setBroadcastExternalRequest(kryo.readObject(input, Object.class));
        return result;
    }
}

}
