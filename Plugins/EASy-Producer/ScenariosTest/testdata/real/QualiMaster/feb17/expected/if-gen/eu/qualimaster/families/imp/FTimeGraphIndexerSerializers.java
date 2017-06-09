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
import eu.qualimaster.families.imp.FTimeGraphIndexer;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTimeGraphIndexerProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTimeGraphIndexer" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTimeGraphIndexerSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraphIndexer.IIFTimeGraphIndexerDataStreamInput} algorithm.
 */
public static class IFTimeGraphIndexerDataStreamInputSerializer extends Serializer<FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput> implements ISerializer<IFTimeGraphIndexer.IIFTimeGraphIndexerDataStreamInput> {

    @Override
    public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerDataStreamInput object, OutputStream out) throws IOException {
        SIFTimeGraphIndexerDataStreamInput tmp = SIFTimeGraphIndexerDataStreamInput.newBuilder()
            .setIsAddition(object.getIsAddition())
            .build();
        tmp.writeDelimitedTo(out);
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUpdate(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerDataStreamInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUpdate(), out);
            out.writeBoolean(object.getIsAddition());
        }

    @Override
    public IFTimeGraphIndexer.IIFTimeGraphIndexerDataStreamInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput result = new FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput();
        result.setUpdate(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        SIFTimeGraphIndexerDataStreamInput tmp = SIFTimeGraphIndexerDataStreamInput.parseDelimitedFrom(in);
        result.setIsAddition(tmp.getIsAddition());
        return result;
    }

        @Override
        public IFTimeGraphIndexer.IIFTimeGraphIndexerDataStreamInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput result = new FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput();
            result.setUpdate(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            result.setIsAddition(in.nextBoolean());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput object) {
        kryo.writeObject(output, object.getUpdate());
        output.writeBoolean(object.getIsAddition());
    }

    @Override
    public FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput read(Kryo kryo, Input input, Class<FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput> type) {
        FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput result = new FTimeGraphIndexer.IFTimeGraphIndexerDataStreamInput();
        result.setUpdate(kryo.readObject(input, Object.class));
        result.setIsAddition(input.readBoolean());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsInput} algorithm.
 */
public static class IFTimeGraphIndexerInternalRequestsInputSerializer extends Serializer<FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput> implements ISerializer<IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsInput> {

    @Override
    public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsInput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getInternalRequest(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getInternalRequest(), out);
        }

    @Override
    public IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput();
        result.setInternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput();
            result.setInternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput object) {
        kryo.writeObject(output, object.getInternalRequest());
    }

    @Override
    public FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput read(Kryo kryo, Input input, Class<FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput> type) {
        FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsInput();
        result.setInternalRequest(kryo.readObject(input, Object.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraphIndexer.IIFTimeGraphIndexerUnicastRequestsInput} algorithm.
 */
public static class IFTimeGraphIndexerUnicastRequestsInputSerializer extends Serializer<FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput> implements ISerializer<IFTimeGraphIndexer.IIFTimeGraphIndexerUnicastRequestsInput> {

    @Override
    public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerUnicastRequestsInput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUnicastExternalRequest(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerUnicastRequestsInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUnicastExternalRequest(), out);
        }

    @Override
    public IFTimeGraphIndexer.IIFTimeGraphIndexerUnicastRequestsInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput();
        result.setUnicastExternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTimeGraphIndexer.IIFTimeGraphIndexerUnicastRequestsInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput();
            result.setUnicastExternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput object) {
        kryo.writeObject(output, object.getUnicastExternalRequest());
    }

    @Override
    public FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput read(Kryo kryo, Input input, Class<FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput> type) {
        FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerUnicastRequestsInput();
        result.setUnicastExternalRequest(kryo.readObject(input, Object.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraphIndexer.IIFTimeGraphIndexerBroadcastRequestsInput} algorithm.
 */
public static class IFTimeGraphIndexerBroadcastRequestsInputSerializer extends Serializer<FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput> implements ISerializer<IFTimeGraphIndexer.IIFTimeGraphIndexerBroadcastRequestsInput> {

    @Override
    public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerBroadcastRequestsInput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getBroadcastExternalRequest(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerBroadcastRequestsInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getBroadcastExternalRequest(), out);
        }

    @Override
    public IFTimeGraphIndexer.IIFTimeGraphIndexerBroadcastRequestsInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput();
        result.setBroadcastExternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTimeGraphIndexer.IIFTimeGraphIndexerBroadcastRequestsInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput();
            result.setBroadcastExternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput object) {
        kryo.writeObject(output, object.getBroadcastExternalRequest());
    }

    @Override
    public FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput read(Kryo kryo, Input input, Class<FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput> type) {
        FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput result = new FTimeGraphIndexer.IFTimeGraphIndexerBroadcastRequestsInput();
        result.setBroadcastExternalRequest(kryo.readObject(input, Object.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraphIndexer.IIFTimeGraphIndexerExternalResponsesOutput} algorithm.
 */
public static class IFTimeGraphIndexerExternalResponsesOutputSerializer extends Serializer<FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput> implements ISerializer<IFTimeGraphIndexer.IIFTimeGraphIndexerExternalResponsesOutput> {

    @Override
    public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerExternalResponsesOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getExternalResponse(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerExternalResponsesOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getExternalResponse(), out);
        }

    @Override
    public IFTimeGraphIndexer.IIFTimeGraphIndexerExternalResponsesOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput result = new FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput();
        result.setExternalResponse(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTimeGraphIndexer.IIFTimeGraphIndexerExternalResponsesOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput result = new FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput();
            result.setExternalResponse(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput object) {
        kryo.writeObject(output, object.getExternalResponse());
    }

    @Override
    public FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput read(Kryo kryo, Input input, Class<FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput> type) {
        FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput result = new FTimeGraphIndexer.IFTimeGraphIndexerExternalResponsesOutput();
        result.setExternalResponse(kryo.readObject(input, Object.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsOutput} algorithm.
 */
public static class IFTimeGraphIndexerInternalRequestsOutputSerializer extends Serializer<FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput> implements ISerializer<IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsOutput> {

    @Override
    public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getInternalRequest(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getInternalRequest(), out);
        }

    @Override
    public IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput result = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput();
        result.setInternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTimeGraphIndexer.IIFTimeGraphIndexerInternalRequestsOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput result = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput();
            result.setInternalRequest(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput object) {
        kryo.writeObject(output, object.getInternalRequest());
    }

    @Override
    public FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput read(Kryo kryo, Input input, Class<FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput> type) {
        FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput result = new FTimeGraphIndexer.IFTimeGraphIndexerInternalRequestsOutput();
        result.setInternalRequest(kryo.readObject(input, Object.class));
        return result;
    }
}

}
