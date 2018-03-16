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
import eu.qualimaster.data.imp.FixedRateSimulatedFinancialData;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.FixedRateSimulatedFinancialDataProtos.*;
/**
 * The implementation of the serializers for the data element "FixedRateSimulatedFinancialData" (GEN).
 */
@Generated(value="EASy-Producer")
public class FixedRateSimulatedFinancialDataSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSymbolListOutput} algorithm.
 */
public static class FixedRateSimulatedFinancialDataSymbolListOutputSerializer extends Serializer<FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput> implements ISerializer<FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSymbolListOutput> {

    @Override
    public void serializeTo(FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSymbolListOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
    }

        @Override
        public void serializeTo(FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSymbolListOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

    @Override
    public FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSymbolListOutput deserializeFrom(InputStream in) throws IOException {
        FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput result = new FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput();
        result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
        return result;
    }

        @Override
        public FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSymbolListOutput deserializeFrom(IDataInput in) throws IOException {
            FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput result = new FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput object) {
        kryo.writeObject(output, object.getAllSymbols());
    }

    @Override
    public FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput read(Kryo kryo, Input input, Class<FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput> type) {
        FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput result = new FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSymbolListOutput();
        result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSpringStreamOutput} algorithm.
 */
public static class FixedRateSimulatedFinancialDataSpringStreamOutputSerializer extends Serializer<FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput> implements ISerializer<FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSpringStreamOutput> {

    @Override
    public void serializeTo(FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSpringStreamOutput object, OutputStream out) throws IOException {
        SFixedRateSimulatedFinancialDataSpringStreamOutput tmp = SFixedRateSimulatedFinancialDataSpringStreamOutput.newBuilder()
            .setSymbolTuple(object.getSymbolTuple())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSpringStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolTuple());
        }

    @Override
    public FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSpringStreamOutput deserializeFrom(InputStream in) throws IOException {
        FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput result = new FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput();
        SFixedRateSimulatedFinancialDataSpringStreamOutput tmp = SFixedRateSimulatedFinancialDataSpringStreamOutput.parseDelimitedFrom(in);
        result.setSymbolTuple(tmp.getSymbolTuple());
        return result;
    }

        @Override
        public FixedRateSimulatedFinancialData.IFixedRateSimulatedFinancialDataSpringStreamOutput deserializeFrom(IDataInput in) throws IOException {
            FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput result = new FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput();
            result.setSymbolTuple(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput object) {
        output.writeString(object.getSymbolTuple());
    }

    @Override
    public FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput read(Kryo kryo, Input input, Class<FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput> type) {
        FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput result = new FixedRateSimulatedFinancialData.FixedRateSimulatedFinancialDataSpringStreamOutput();
        result.setSymbolTuple(input.readString());
        return result;
    }
}

}
