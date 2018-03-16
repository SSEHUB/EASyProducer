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
import eu.qualimaster.data.imp.WindowedSpringFinancialData;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.WindowedSpringFinancialDataProtos.*;
/**
 * The implementation of the serializers for the data element "WindowedSpringFinancialData" (GEN).
 */
@Generated(value="EASy-Producer")
public class WindowedSpringFinancialDataSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link WindowedSpringFinancialData.IWindowedSpringFinancialDataSymbolListOutput} algorithm.
 */
public static class WindowedSpringFinancialDataSymbolListOutputSerializer extends Serializer<WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput> implements ISerializer<WindowedSpringFinancialData.IWindowedSpringFinancialDataSymbolListOutput> {

    @Override
    public void serializeTo(WindowedSpringFinancialData.IWindowedSpringFinancialDataSymbolListOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
    }

        @Override
        public void serializeTo(WindowedSpringFinancialData.IWindowedSpringFinancialDataSymbolListOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

    @Override
    public WindowedSpringFinancialData.IWindowedSpringFinancialDataSymbolListOutput deserializeFrom(InputStream in) throws IOException {
        WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput();
        result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
        return result;
    }

        @Override
        public WindowedSpringFinancialData.IWindowedSpringFinancialDataSymbolListOutput deserializeFrom(IDataInput in) throws IOException {
            WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput object) {
        kryo.writeObject(output, object.getAllSymbols());
    }

    @Override
    public WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput read(Kryo kryo, Input input, Class<WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput> type) {
        WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataSymbolListOutput();
        result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link WindowedSpringFinancialData.IWindowedSpringFinancialDataSpringStreamOutput} algorithm.
 */
public static class WindowedSpringFinancialDataSpringStreamOutputSerializer extends Serializer<WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput> implements ISerializer<WindowedSpringFinancialData.IWindowedSpringFinancialDataSpringStreamOutput> {

    @Override
    public void serializeTo(WindowedSpringFinancialData.IWindowedSpringFinancialDataSpringStreamOutput object, OutputStream out) throws IOException {
        SWindowedSpringFinancialDataSpringStreamOutput tmp = SWindowedSpringFinancialDataSpringStreamOutput.newBuilder()
            .setSymbolTuple(object.getSymbolTuple())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(WindowedSpringFinancialData.IWindowedSpringFinancialDataSpringStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolTuple());
        }

    @Override
    public WindowedSpringFinancialData.IWindowedSpringFinancialDataSpringStreamOutput deserializeFrom(InputStream in) throws IOException {
        WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput();
        SWindowedSpringFinancialDataSpringStreamOutput tmp = SWindowedSpringFinancialDataSpringStreamOutput.parseDelimitedFrom(in);
        result.setSymbolTuple(tmp.getSymbolTuple());
        return result;
    }

        @Override
        public WindowedSpringFinancialData.IWindowedSpringFinancialDataSpringStreamOutput deserializeFrom(IDataInput in) throws IOException {
            WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput();
            result.setSymbolTuple(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput object) {
        output.writeString(object.getSymbolTuple());
    }

    @Override
    public WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput read(Kryo kryo, Input input, Class<WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput> type) {
        WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataSpringStreamOutput();
        result.setSymbolTuple(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link WindowedSpringFinancialData.IWindowedSpringFinancialDataResetWindowOutput} algorithm.
 */
public static class WindowedSpringFinancialDataResetWindowOutputSerializer extends Serializer<WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput> implements ISerializer<WindowedSpringFinancialData.IWindowedSpringFinancialDataResetWindowOutput> {

    @Override
    public void serializeTo(WindowedSpringFinancialData.IWindowedSpringFinancialDataResetWindowOutput object, OutputStream out) throws IOException {
        SWindowedSpringFinancialDataResetWindowOutput tmp = SWindowedSpringFinancialDataResetWindowOutput.newBuilder()
            .setWindowStart(object.getWindowStart())
            .setWindowEnd(object.getWindowEnd())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(WindowedSpringFinancialData.IWindowedSpringFinancialDataResetWindowOutput object, IDataOutput out) throws IOException {
            out.writeLong(object.getWindowStart());
            out.writeLong(object.getWindowEnd());
        }

    @Override
    public WindowedSpringFinancialData.IWindowedSpringFinancialDataResetWindowOutput deserializeFrom(InputStream in) throws IOException {
        WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput();
        SWindowedSpringFinancialDataResetWindowOutput tmp = SWindowedSpringFinancialDataResetWindowOutput.parseDelimitedFrom(in);
        result.setWindowStart(tmp.getWindowStart());
        result.setWindowEnd(tmp.getWindowEnd());
        return result;
    }

        @Override
        public WindowedSpringFinancialData.IWindowedSpringFinancialDataResetWindowOutput deserializeFrom(IDataInput in) throws IOException {
            WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput();
            result.setWindowStart(in.nextLong());
            result.setWindowEnd(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput object) {
        output.writeLong(object.getWindowStart());
        output.writeLong(object.getWindowEnd());
    }

    @Override
    public WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput read(Kryo kryo, Input input, Class<WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput> type) {
        WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput result = new WindowedSpringFinancialData.WindowedSpringFinancialDataResetWindowOutput();
        result.setWindowStart(input.readLong());
        result.setWindowEnd(input.readLong());
        return result;
    }
}

}
