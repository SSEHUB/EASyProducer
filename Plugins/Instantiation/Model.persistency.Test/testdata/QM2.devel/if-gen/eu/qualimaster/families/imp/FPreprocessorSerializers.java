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

import eu.qualimaster.protos.FPreprocessorProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFPreprocessor" (GEN).
 */
@Generated(value="EASy-Producer")
public class FPreprocessorSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FPreprocessor.IFPreprocessorSpringStreamInput} algorithm.
     */
    public class IFPreprocessorSpringStreamInputSerializer extends Serializer<FPreprocessor.IFPreprocessorSpringStreamInput> implements ISerializer<FPreprocessor.IFPreprocessorSpringStreamInput> {

        @Override
        public void serializeTo(FPreprocessor.IFPreprocessorSpringStreamInput object, OutputStream out) throws IOException {
            SIFPreprocessorSpringStreamInput tmp = SIFPreprocessorSpringStreamInput.newBuilder()
                .setSymbolTuple(object.getSymbolTuple())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public FPreprocessor.IFPreprocessorSpringStreamInput deserializeFrom(InputStream in) throws IOException {
            FPreprocessor.IFPreprocessorSpringStreamInput result = new FPreprocessor.IFPreprocessorSpringStreamInput();
            SIFPreprocessorSpringStreamInput tmp = SIFPreprocessorSpringStreamInput.parseDelimitedFrom(in);
            result.setSymbolTuple(tmp.getSymbolTuple());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FPreprocessor.IFPreprocessorSpringStreamInput object) {
            output.writeString(object.getSymbolTuple());
        }

        @Override
        public FPreprocessor.IFPreprocessorSpringStreamInput read(Kryo kryo, Input input, Class<FPreprocessor.IFPreprocessorSpringStreamInput> type) {
            FPreprocessor.IFPreprocessorSpringStreamInput result = new FPreprocessor.IFPreprocessorSpringStreamInput();
            result.setSymbolTuple(input.readString());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FPreprocessor.IFPreprocessorPreprocessedStreamOutput} algorithm.
     */
    public class IFPreprocessorPreprocessedStreamOutputSerializer extends Serializer<FPreprocessor.IFPreprocessorPreprocessedStreamOutput> implements ISerializer<FPreprocessor.IFPreprocessorPreprocessedStreamOutput> {

        @Override
        public void serializeTo(FPreprocessor.IFPreprocessorPreprocessedStreamOutput object, OutputStream out) throws IOException {
            SIFPreprocessorPreprocessedStreamOutput tmp = SIFPreprocessorPreprocessedStreamOutput.newBuilder()
                .setSymbolId(object.getSymbolId())
                .setTimestamp(object.getTimestamp())
                .setValue(object.getValue())
                .setVolume(object.getVolume())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public FPreprocessor.IFPreprocessorPreprocessedStreamOutput deserializeFrom(InputStream in) throws IOException {
            FPreprocessor.IFPreprocessorPreprocessedStreamOutput result = new FPreprocessor.IFPreprocessorPreprocessedStreamOutput();
            SIFPreprocessorPreprocessedStreamOutput tmp = SIFPreprocessorPreprocessedStreamOutput.parseDelimitedFrom(in);
            result.setSymbolId(tmp.getSymbolId());
            result.setTimestamp(tmp.getTimestamp());
            result.setValue(tmp.getValue());
            result.setVolume(tmp.getVolume());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FPreprocessor.IFPreprocessorPreprocessedStreamOutput object) {
            output.writeString(object.getSymbolId());
            output.writeLong(object.getTimestamp());
            output.writeDouble(object.getValue());
            output.writeInt(object.getVolume());
        }

        @Override
        public FPreprocessor.IFPreprocessorPreprocessedStreamOutput read(Kryo kryo, Input input, Class<FPreprocessor.IFPreprocessorPreprocessedStreamOutput> type) {
            FPreprocessor.IFPreprocessorPreprocessedStreamOutput result = new FPreprocessor.IFPreprocessorPreprocessedStreamOutput();
            result.setSymbolId(input.readString());
            result.setTimestamp(input.readLong());
            result.setValue(input.readDouble());
            result.setVolume(input.readInt());
            return result;
        }
    }

}
