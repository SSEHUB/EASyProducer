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
import eu.qualimaster.data.imp.SimulatedFinancialData;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.SimulatedFinancialDataProtos.*;
/**
 * The implementation of the serializers for the data element "SimulatedFinancialData" (GEN).
 */
@Generated(value="EASy-Producer")
public class SimulatedFinancialDataSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link SimulatedFinancialData.ISimulatedFinancialDataSymbolListOutput} algorithm.
 */
public static class SimulatedFinancialDataSymbolListOutputSerializer extends Serializer<SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput> implements ISerializer<SimulatedFinancialData.ISimulatedFinancialDataSymbolListOutput> {

    @Override
    public void serializeTo(SimulatedFinancialData.ISimulatedFinancialDataSymbolListOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
    }

        @Override
        public void serializeTo(SimulatedFinancialData.ISimulatedFinancialDataSymbolListOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

    @Override
    public SimulatedFinancialData.ISimulatedFinancialDataSymbolListOutput deserializeFrom(InputStream in) throws IOException {
        SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput result = new SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput();
        result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
        return result;
    }

        @Override
        public SimulatedFinancialData.ISimulatedFinancialDataSymbolListOutput deserializeFrom(IDataInput in) throws IOException {
            SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput result = new SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput object) {
        kryo.writeObject(output, object.getAllSymbols());
    }

    @Override
    public SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput read(Kryo kryo, Input input, Class<SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput> type) {
        SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput result = new SimulatedFinancialData.SimulatedFinancialDataSymbolListOutput();
        result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link SimulatedFinancialData.ISimulatedFinancialDataSpringStreamOutput} algorithm.
 */
public static class SimulatedFinancialDataSpringStreamOutputSerializer extends Serializer<SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput> implements ISerializer<SimulatedFinancialData.ISimulatedFinancialDataSpringStreamOutput> {

    @Override
    public void serializeTo(SimulatedFinancialData.ISimulatedFinancialDataSpringStreamOutput object, OutputStream out) throws IOException {
        SSimulatedFinancialDataSpringStreamOutput tmp = SSimulatedFinancialDataSpringStreamOutput.newBuilder()
            .setSymbolTuple(object.getSymbolTuple())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(SimulatedFinancialData.ISimulatedFinancialDataSpringStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolTuple());
        }

    @Override
    public SimulatedFinancialData.ISimulatedFinancialDataSpringStreamOutput deserializeFrom(InputStream in) throws IOException {
        SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput result = new SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput();
        SSimulatedFinancialDataSpringStreamOutput tmp = SSimulatedFinancialDataSpringStreamOutput.parseDelimitedFrom(in);
        result.setSymbolTuple(tmp.getSymbolTuple());
        return result;
    }

        @Override
        public SimulatedFinancialData.ISimulatedFinancialDataSpringStreamOutput deserializeFrom(IDataInput in) throws IOException {
            SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput result = new SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput();
            result.setSymbolTuple(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput object) {
        output.writeString(object.getSymbolTuple());
    }

    @Override
    public SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput read(Kryo kryo, Input input, Class<SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput> type) {
        SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput result = new SimulatedFinancialData.SimulatedFinancialDataSpringStreamOutput();
        result.setSymbolTuple(input.readString());
        return result;
    }
}

}
