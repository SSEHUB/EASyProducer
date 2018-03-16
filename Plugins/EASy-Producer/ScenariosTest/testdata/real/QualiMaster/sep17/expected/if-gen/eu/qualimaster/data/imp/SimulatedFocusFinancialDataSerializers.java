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
import eu.qualimaster.data.imp.SimulatedFocusFinancialData;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.SimulatedFocusFinancialDataProtos.*;
/**
 * The implementation of the serializers for the data element "SimulatedFocusFinancialData" (GEN).
 */
@Generated(value="EASy-Producer")
public class SimulatedFocusFinancialDataSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSymbolListOutput} algorithm.
 */
public static class SimulatedFocusFinancialDataSymbolListOutputSerializer extends Serializer<SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput> implements ISerializer<SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSymbolListOutput> {

    @Override
    public void serializeTo(SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSymbolListOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
    }

        @Override
        public void serializeTo(SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSymbolListOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

    @Override
    public SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSymbolListOutput deserializeFrom(InputStream in) throws IOException {
        SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput result = new SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput();
        result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
        return result;
    }

        @Override
        public SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSymbolListOutput deserializeFrom(IDataInput in) throws IOException {
            SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput result = new SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput object) {
        kryo.writeObject(output, object.getAllSymbols());
    }

    @Override
    public SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput read(Kryo kryo, Input input, Class<SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput> type) {
        SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput result = new SimulatedFocusFinancialData.SimulatedFocusFinancialDataSymbolListOutput();
        result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSpringStreamOutput} algorithm.
 */
public static class SimulatedFocusFinancialDataSpringStreamOutputSerializer extends Serializer<SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput> implements ISerializer<SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSpringStreamOutput> {

    @Override
    public void serializeTo(SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSpringStreamOutput object, OutputStream out) throws IOException {
        SSimulatedFocusFinancialDataSpringStreamOutput tmp = SSimulatedFocusFinancialDataSpringStreamOutput.newBuilder()
            .setSymbolTuple(object.getSymbolTuple())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSpringStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolTuple());
        }

    @Override
    public SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSpringStreamOutput deserializeFrom(InputStream in) throws IOException {
        SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput result = new SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput();
        SSimulatedFocusFinancialDataSpringStreamOutput tmp = SSimulatedFocusFinancialDataSpringStreamOutput.parseDelimitedFrom(in);
        result.setSymbolTuple(tmp.getSymbolTuple());
        return result;
    }

        @Override
        public SimulatedFocusFinancialData.ISimulatedFocusFinancialDataSpringStreamOutput deserializeFrom(IDataInput in) throws IOException {
            SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput result = new SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput();
            result.setSymbolTuple(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput object) {
        output.writeString(object.getSymbolTuple());
    }

    @Override
    public SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput read(Kryo kryo, Input input, Class<SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput> type) {
        SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput result = new SimulatedFocusFinancialData.SimulatedFocusFinancialDataSpringStreamOutput();
        result.setSymbolTuple(input.readString());
        return result;
    }
}

}
