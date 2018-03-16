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
import eu.qualimaster.families.imp.FMapper;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FMapperProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFMapper" (GEN).
 */
@Generated(value="EASy-Producer")
public class FMapperSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFMapper.IIFMapperPreprocessedStreamInput} algorithm.
 */
public static class IFMapperPreprocessedStreamInputSerializer extends Serializer<FMapper.IFMapperPreprocessedStreamInput> implements ISerializer<IFMapper.IIFMapperPreprocessedStreamInput> {

    @Override
    public void serializeTo(IFMapper.IIFMapperPreprocessedStreamInput object, OutputStream out) throws IOException {
        SIFMapperPreprocessedStreamInput tmp = SIFMapperPreprocessedStreamInput.newBuilder()
            .setSymbolId(object.getSymbolId())
            .setTimestamp(object.getTimestamp())
            .setValue(object.getValue())
            .setVolume(object.getVolume())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFMapper.IIFMapperPreprocessedStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolId());
            out.writeLong(object.getTimestamp());
            out.writeDouble(object.getValue());
            out.writeInt(object.getVolume());
        }

    @Override
    public IFMapper.IIFMapperPreprocessedStreamInput deserializeFrom(InputStream in) throws IOException {
        FMapper.IFMapperPreprocessedStreamInput result = new FMapper.IFMapperPreprocessedStreamInput();
        SIFMapperPreprocessedStreamInput tmp = SIFMapperPreprocessedStreamInput.parseDelimitedFrom(in);
        result.setSymbolId(tmp.getSymbolId());
        result.setTimestamp(tmp.getTimestamp());
        result.setValue(tmp.getValue());
        result.setVolume(tmp.getVolume());
        return result;
    }

        @Override
        public IFMapper.IIFMapperPreprocessedStreamInput deserializeFrom(IDataInput in) throws IOException {
            FMapper.IFMapperPreprocessedStreamInput result = new FMapper.IFMapperPreprocessedStreamInput();
            result.setSymbolId(in.nextString());
            result.setTimestamp(in.nextLong());
            result.setValue(in.nextDouble());
            result.setVolume(in.nextInt());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FMapper.IFMapperPreprocessedStreamInput object) {
        output.writeString(object.getSymbolId());
        output.writeLong(object.getTimestamp());
        output.writeDouble(object.getValue());
        output.writeInt(object.getVolume());
    }

    @Override
    public FMapper.IFMapperPreprocessedStreamInput read(Kryo kryo, Input input, Class<FMapper.IFMapperPreprocessedStreamInput> type) {
        FMapper.IFMapperPreprocessedStreamInput result = new FMapper.IFMapperPreprocessedStreamInput();
        result.setSymbolId(input.readString());
        result.setTimestamp(input.readLong());
        result.setValue(input.readDouble());
        result.setVolume(input.readInt());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFMapper.IIFMapperSymbolListInput} algorithm.
 */
public static class IFMapperSymbolListInputSerializer extends Serializer<FMapper.IFMapperSymbolListInput> implements ISerializer<IFMapper.IIFMapperSymbolListInput> {

    @Override
    public void serializeTo(IFMapper.IIFMapperSymbolListInput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
    }

        @Override
        public void serializeTo(IFMapper.IIFMapperSymbolListInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

    @Override
    public IFMapper.IIFMapperSymbolListInput deserializeFrom(InputStream in) throws IOException {
        FMapper.IFMapperSymbolListInput result = new FMapper.IFMapperSymbolListInput();
        result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFMapper.IIFMapperSymbolListInput deserializeFrom(IDataInput in) throws IOException {
            FMapper.IFMapperSymbolListInput result = new FMapper.IFMapperSymbolListInput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FMapper.IFMapperSymbolListInput object) {
        kryo.writeObject(output, object.getAllSymbols());
    }

    @Override
    public FMapper.IFMapperSymbolListInput read(Kryo kryo, Input input, Class<FMapper.IFMapperSymbolListInput> type) {
        FMapper.IFMapperSymbolListInput result = new FMapper.IFMapperSymbolListInput();
        result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFMapper.IIFMapperSymbolsStreamOutput} algorithm.
 */
public static class IFMapperSymbolsStreamOutputSerializer extends Serializer<FMapper.IFMapperSymbolsStreamOutput> implements ISerializer<IFMapper.IIFMapperSymbolsStreamOutput> {

    @Override
    public void serializeTo(IFMapper.IIFMapperSymbolsStreamOutput object, OutputStream out) throws IOException {
        SIFMapperSymbolsStreamOutput tmp = SIFMapperSymbolsStreamOutput.newBuilder()
            .setSymbolId(object.getSymbolId())
            .setTimestamp(object.getTimestamp())
            .setValue(object.getValue())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFMapper.IIFMapperSymbolsStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolId());
            out.writeLong(object.getTimestamp());
            out.writeDouble(object.getValue());
        }

    @Override
    public IFMapper.IIFMapperSymbolsStreamOutput deserializeFrom(InputStream in) throws IOException {
        FMapper.IFMapperSymbolsStreamOutput result = new FMapper.IFMapperSymbolsStreamOutput();
        SIFMapperSymbolsStreamOutput tmp = SIFMapperSymbolsStreamOutput.parseDelimitedFrom(in);
        result.setSymbolId(tmp.getSymbolId());
        result.setTimestamp(tmp.getTimestamp());
        result.setValue(tmp.getValue());
        return result;
    }

        @Override
        public IFMapper.IIFMapperSymbolsStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FMapper.IFMapperSymbolsStreamOutput result = new FMapper.IFMapperSymbolsStreamOutput();
            result.setSymbolId(in.nextString());
            result.setTimestamp(in.nextLong());
            result.setValue(in.nextDouble());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FMapper.IFMapperSymbolsStreamOutput object) {
        output.writeString(object.getSymbolId());
        output.writeLong(object.getTimestamp());
        output.writeDouble(object.getValue());
    }

    @Override
    public FMapper.IFMapperSymbolsStreamOutput read(Kryo kryo, Input input, Class<FMapper.IFMapperSymbolsStreamOutput> type) {
        FMapper.IFMapperSymbolsStreamOutput result = new FMapper.IFMapperSymbolsStreamOutput();
        result.setSymbolId(input.readString());
        result.setTimestamp(input.readLong());
        result.setValue(input.readDouble());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFMapper.IIFMapperConfigurationStreamOutput} algorithm.
 */
public static class IFMapperConfigurationStreamOutputSerializer extends Serializer<FMapper.IFMapperConfigurationStreamOutput> implements ISerializer<IFMapper.IIFMapperConfigurationStreamOutput> {

    @Override
    public void serializeTo(IFMapper.IIFMapperConfigurationStreamOutput object, OutputStream out) throws IOException {
        SIFMapperConfigurationStreamOutput tmp = SIFMapperConfigurationStreamOutput.newBuilder()
            .setPairKey(object.getPairKey())
            .setPairValue(object.getPairValue())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFMapper.IIFMapperConfigurationStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getPairKey());
            out.writeString(object.getPairValue());
        }

    @Override
    public IFMapper.IIFMapperConfigurationStreamOutput deserializeFrom(InputStream in) throws IOException {
        FMapper.IFMapperConfigurationStreamOutput result = new FMapper.IFMapperConfigurationStreamOutput();
        SIFMapperConfigurationStreamOutput tmp = SIFMapperConfigurationStreamOutput.parseDelimitedFrom(in);
        result.setPairKey(tmp.getPairKey());
        result.setPairValue(tmp.getPairValue());
        return result;
    }

        @Override
        public IFMapper.IIFMapperConfigurationStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FMapper.IFMapperConfigurationStreamOutput result = new FMapper.IFMapperConfigurationStreamOutput();
            result.setPairKey(in.nextString());
            result.setPairValue(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FMapper.IFMapperConfigurationStreamOutput object) {
        output.writeString(object.getPairKey());
        output.writeString(object.getPairValue());
    }

    @Override
    public FMapper.IFMapperConfigurationStreamOutput read(Kryo kryo, Input input, Class<FMapper.IFMapperConfigurationStreamOutput> type) {
        FMapper.IFMapperConfigurationStreamOutput result = new FMapper.IFMapperConfigurationStreamOutput();
        result.setPairKey(input.readString());
        result.setPairValue(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFMapper.IIFMapperResetWindowStreamOutput} algorithm.
 */
public static class IFMapperResetWindowStreamOutputSerializer extends Serializer<FMapper.IFMapperResetWindowStreamOutput> implements ISerializer<IFMapper.IIFMapperResetWindowStreamOutput> {

    @Override
    public void serializeTo(IFMapper.IIFMapperResetWindowStreamOutput object, OutputStream out) throws IOException {
        SIFMapperResetWindowStreamOutput tmp = SIFMapperResetWindowStreamOutput.newBuilder()
            .setWindowStart(object.getWindowStart())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFMapper.IIFMapperResetWindowStreamOutput object, IDataOutput out) throws IOException {
            out.writeLong(object.getWindowStart());
        }

    @Override
    public IFMapper.IIFMapperResetWindowStreamOutput deserializeFrom(InputStream in) throws IOException {
        FMapper.IFMapperResetWindowStreamOutput result = new FMapper.IFMapperResetWindowStreamOutput();
        SIFMapperResetWindowStreamOutput tmp = SIFMapperResetWindowStreamOutput.parseDelimitedFrom(in);
        result.setWindowStart(tmp.getWindowStart());
        return result;
    }

        @Override
        public IFMapper.IIFMapperResetWindowStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FMapper.IFMapperResetWindowStreamOutput result = new FMapper.IFMapperResetWindowStreamOutput();
            result.setWindowStart(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FMapper.IFMapperResetWindowStreamOutput object) {
        output.writeLong(object.getWindowStart());
    }

    @Override
    public FMapper.IFMapperResetWindowStreamOutput read(Kryo kryo, Input input, Class<FMapper.IFMapperResetWindowStreamOutput> type) {
        FMapper.IFMapperResetWindowStreamOutput result = new FMapper.IFMapperResetWindowStreamOutput();
        result.setWindowStart(input.readLong());
        return result;
    }
}

}
