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
import eu.qualimaster.data.imp.FocusFincancialData;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.FocusFincancialDataProtos.*;
/**
 * The implementation of the serializers for the data element "FocusFincancialData" (GEN).
 */
@Generated(value="EASy-Producer")
public class FocusFincancialDataSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FocusFincancialData.IFocusFincancialDataSymbolListOutput} algorithm.
 */
public static class FocusFincancialDataSymbolListOutputSerializer extends Serializer<FocusFincancialData.FocusFincancialDataSymbolListOutput> implements ISerializer<FocusFincancialData.IFocusFincancialDataSymbolListOutput> {

    @Override
    public void serializeTo(FocusFincancialData.IFocusFincancialDataSymbolListOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
    }

        @Override
        public void serializeTo(FocusFincancialData.IFocusFincancialDataSymbolListOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

    @Override
    public FocusFincancialData.IFocusFincancialDataSymbolListOutput deserializeFrom(InputStream in) throws IOException {
        FocusFincancialData.FocusFincancialDataSymbolListOutput result = new FocusFincancialData.FocusFincancialDataSymbolListOutput();
        result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
        return result;
    }

        @Override
        public FocusFincancialData.IFocusFincancialDataSymbolListOutput deserializeFrom(IDataInput in) throws IOException {
            FocusFincancialData.FocusFincancialDataSymbolListOutput result = new FocusFincancialData.FocusFincancialDataSymbolListOutput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FocusFincancialData.FocusFincancialDataSymbolListOutput object) {
        kryo.writeObject(output, object.getAllSymbols());
    }

    @Override
    public FocusFincancialData.FocusFincancialDataSymbolListOutput read(Kryo kryo, Input input, Class<FocusFincancialData.FocusFincancialDataSymbolListOutput> type) {
        FocusFincancialData.FocusFincancialDataSymbolListOutput result = new FocusFincancialData.FocusFincancialDataSymbolListOutput();
        result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FocusFincancialData.IFocusFincancialDataSpringStreamOutput} algorithm.
 */
public static class FocusFincancialDataSpringStreamOutputSerializer extends Serializer<FocusFincancialData.FocusFincancialDataSpringStreamOutput> implements ISerializer<FocusFincancialData.IFocusFincancialDataSpringStreamOutput> {

    @Override
    public void serializeTo(FocusFincancialData.IFocusFincancialDataSpringStreamOutput object, OutputStream out) throws IOException {
        SFocusFincancialDataSpringStreamOutput tmp = SFocusFincancialDataSpringStreamOutput.newBuilder()
            .setSymbolTuple(object.getSymbolTuple())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(FocusFincancialData.IFocusFincancialDataSpringStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolTuple());
        }

    @Override
    public FocusFincancialData.IFocusFincancialDataSpringStreamOutput deserializeFrom(InputStream in) throws IOException {
        FocusFincancialData.FocusFincancialDataSpringStreamOutput result = new FocusFincancialData.FocusFincancialDataSpringStreamOutput();
        SFocusFincancialDataSpringStreamOutput tmp = SFocusFincancialDataSpringStreamOutput.parseDelimitedFrom(in);
        result.setSymbolTuple(tmp.getSymbolTuple());
        return result;
    }

        @Override
        public FocusFincancialData.IFocusFincancialDataSpringStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FocusFincancialData.FocusFincancialDataSpringStreamOutput result = new FocusFincancialData.FocusFincancialDataSpringStreamOutput();
            result.setSymbolTuple(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FocusFincancialData.FocusFincancialDataSpringStreamOutput object) {
        output.writeString(object.getSymbolTuple());
    }

    @Override
    public FocusFincancialData.FocusFincancialDataSpringStreamOutput read(Kryo kryo, Input input, Class<FocusFincancialData.FocusFincancialDataSpringStreamOutput> type) {
        FocusFincancialData.FocusFincancialDataSpringStreamOutput result = new FocusFincancialData.FocusFincancialDataSpringStreamOutput();
        result.setSymbolTuple(input.readString());
        return result;
    }
}

}
