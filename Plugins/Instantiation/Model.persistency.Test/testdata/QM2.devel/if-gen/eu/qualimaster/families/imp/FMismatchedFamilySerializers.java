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

import eu.qualimaster.protos.FMismatchedFamilyProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFMismatchedFamily" (GEN).
 */
@Generated(value="EASy-Producer")
public class FMismatchedFamilySerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FMismatchedFamily.IFMismatchedFamilyMisStringInput} algorithm.
     */
    public class IFMismatchedFamilyMisStringInputSerializer extends Serializer<FMismatchedFamily.IFMismatchedFamilyMisStringInput> implements ISerializer<FMismatchedFamily.IFMismatchedFamilyMisStringInput> {

        @Override
        public void serializeTo(FMismatchedFamily.IFMismatchedFamilyMisStringInput object, OutputStream out) throws IOException {
            SIFMismatchedFamilyMisStringInput tmp = SIFMismatchedFamilyMisStringInput.newBuilder()
                .setSymbolTuple1(object.getSymbolTuple1())
                .setVolume(object.getVolume())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public FMismatchedFamily.IFMismatchedFamilyMisStringInput deserializeFrom(InputStream in) throws IOException {
            FMismatchedFamily.IFMismatchedFamilyMisStringInput result = new FMismatchedFamily.IFMismatchedFamilyMisStringInput();
            SIFMismatchedFamilyMisStringInput tmp = SIFMismatchedFamilyMisStringInput.parseDelimitedFrom(in);
            result.setSymbolTuple1(tmp.getSymbolTuple1());
            result.setVolume(tmp.getVolume());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FMismatchedFamily.IFMismatchedFamilyMisStringInput object) {
            output.writeString(object.getSymbolTuple1());
            output.writeInt(object.getVolume());
        }

        @Override
        public FMismatchedFamily.IFMismatchedFamilyMisStringInput read(Kryo kryo, Input input, Class<FMismatchedFamily.IFMismatchedFamilyMisStringInput> type) {
            FMismatchedFamily.IFMismatchedFamilyMisStringInput result = new FMismatchedFamily.IFMismatchedFamilyMisStringInput();
            result.setSymbolTuple1(input.readString());
            result.setVolume(input.readInt());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FMismatchedFamily.IFMismatchedFamilyMisStringOutput} algorithm.
     */
    public class IFMismatchedFamilyMisStringOutputSerializer extends Serializer<FMismatchedFamily.IFMismatchedFamilyMisStringOutput> implements ISerializer<FMismatchedFamily.IFMismatchedFamilyMisStringOutput> {

        @Override
        public void serializeTo(FMismatchedFamily.IFMismatchedFamilyMisStringOutput object, OutputStream out) throws IOException {
            SIFMismatchedFamilyMisStringOutput tmp = SIFMismatchedFamilyMisStringOutput.newBuilder()
                .setStreamID1(object.getStreamID1())
                .setTimestamp(object.getTimestamp())
                .setQuote(object.getQuote())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public FMismatchedFamily.IFMismatchedFamilyMisStringOutput deserializeFrom(InputStream in) throws IOException {
            FMismatchedFamily.IFMismatchedFamilyMisStringOutput result = new FMismatchedFamily.IFMismatchedFamilyMisStringOutput();
            SIFMismatchedFamilyMisStringOutput tmp = SIFMismatchedFamilyMisStringOutput.parseDelimitedFrom(in);
            result.setStreamID1(tmp.getStreamID1());
            result.setTimestamp(tmp.getTimestamp());
            result.setQuote(tmp.getQuote());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FMismatchedFamily.IFMismatchedFamilyMisStringOutput object) {
            output.writeString(object.getStreamID1());
            output.writeInt(object.getTimestamp());
            output.writeDouble(object.getQuote());
        }

        @Override
        public FMismatchedFamily.IFMismatchedFamilyMisStringOutput read(Kryo kryo, Input input, Class<FMismatchedFamily.IFMismatchedFamilyMisStringOutput> type) {
            FMismatchedFamily.IFMismatchedFamilyMisStringOutput result = new FMismatchedFamily.IFMismatchedFamilyMisStringOutput();
            result.setStreamID1(input.readString());
            result.setTimestamp(input.readInt());
            result.setQuote(input.readDouble());
            return result;
        }
    }

}
