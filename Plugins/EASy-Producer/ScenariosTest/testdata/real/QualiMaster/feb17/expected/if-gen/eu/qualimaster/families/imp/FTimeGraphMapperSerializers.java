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
import eu.qualimaster.families.imp.FTimeGraphMapper;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTimeGraphMapperProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTimeGraphMapper" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTimeGraphMapperSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTimeGraphMapper.IIFTimeGraphMapperEdgeStreamInput} algorithm.
 */
public static class IFTimeGraphMapperEdgeStreamInputSerializer extends Serializer<FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput> implements ISerializer<IFTimeGraphMapper.IIFTimeGraphMapperEdgeStreamInput> {

    @Override
    public void serializeTo(IFTimeGraphMapper.IIFTimeGraphMapperEdgeStreamInput object, OutputStream out) throws IOException {
        SIFTimeGraphMapperEdgeStreamInput tmp = SIFTimeGraphMapperEdgeStreamInput.newBuilder()
            .setEdge(object.getEdge())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFTimeGraphMapper.IIFTimeGraphMapperEdgeStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getEdge());
        }

    @Override
    public IFTimeGraphMapper.IIFTimeGraphMapperEdgeStreamInput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput result = new FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput();
        SIFTimeGraphMapperEdgeStreamInput tmp = SIFTimeGraphMapperEdgeStreamInput.parseDelimitedFrom(in);
        result.setEdge(tmp.getEdge());
        return result;
    }

        @Override
        public IFTimeGraphMapper.IIFTimeGraphMapperEdgeStreamInput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput result = new FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput();
            result.setEdge(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput object) {
        output.writeString(object.getEdge());
    }

    @Override
    public FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput read(Kryo kryo, Input input, Class<FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput> type) {
        FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput result = new FTimeGraphMapper.IFTimeGraphMapperEdgeStreamInput();
        result.setEdge(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTimeGraphMapper.IIFTimeGraphMapperDataStreamOutput} algorithm.
 */
public static class IFTimeGraphMapperDataStreamOutputSerializer extends Serializer<FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput> implements ISerializer<IFTimeGraphMapper.IIFTimeGraphMapperDataStreamOutput> {

    @Override
    public void serializeTo(IFTimeGraphMapper.IIFTimeGraphMapperDataStreamOutput object, OutputStream out) throws IOException {
        SIFTimeGraphMapperDataStreamOutput tmp = SIFTimeGraphMapperDataStreamOutput.newBuilder()
            .setIsAddition(object.getIsAddition())
            .build();
        tmp.writeDelimitedTo(out);
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUpdate(), out);
    }

        @Override
        public void serializeTo(IFTimeGraphMapper.IIFTimeGraphMapperDataStreamOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getUpdate(), out);
            out.writeBoolean(object.getIsAddition());
        }

    @Override
    public IFTimeGraphMapper.IIFTimeGraphMapperDataStreamOutput deserializeFrom(InputStream in) throws IOException {
        FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput result = new FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput();
        result.setUpdate(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        SIFTimeGraphMapperDataStreamOutput tmp = SIFTimeGraphMapperDataStreamOutput.parseDelimitedFrom(in);
        result.setIsAddition(tmp.getIsAddition());
        return result;
    }

        @Override
        public IFTimeGraphMapper.IIFTimeGraphMapperDataStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput result = new FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput();
            result.setUpdate(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            result.setIsAddition(in.nextBoolean());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput object) {
        kryo.writeObject(output, object.getUpdate());
        output.writeBoolean(object.getIsAddition());
    }

    @Override
    public FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput read(Kryo kryo, Input input, Class<FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput> type) {
        FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput result = new FTimeGraphMapper.IFTimeGraphMapperDataStreamOutput();
        result.setUpdate(kryo.readObject(input, Object.class));
        result.setIsAddition(input.readBoolean());
        return result;
    }
}

}
