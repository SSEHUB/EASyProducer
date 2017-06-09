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
import eu.qualimaster.data.imp.SpringFinancialData;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.SpringFinancialDataProtos.*;
/**
 * The implementation of the serializers for the data element "SpringFinancialData" (GEN).
 */
@Generated(value="EASy-Producer")
public class SpringFinancialDataSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link SpringFinancialData.ISpringFinancialDataSymbolListOutput} algorithm.
 */
public static class SpringFinancialDataSymbolListOutputSerializer extends Serializer<SpringFinancialData.SpringFinancialDataSymbolListOutput> implements ISerializer<SpringFinancialData.ISpringFinancialDataSymbolListOutput> {

    @Override
    public void serializeTo(SpringFinancialData.ISpringFinancialDataSymbolListOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
    }

        @Override
        public void serializeTo(SpringFinancialData.ISpringFinancialDataSymbolListOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

    @Override
    public SpringFinancialData.ISpringFinancialDataSymbolListOutput deserializeFrom(InputStream in) throws IOException {
        SpringFinancialData.SpringFinancialDataSymbolListOutput result = new SpringFinancialData.SpringFinancialDataSymbolListOutput();
        result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
        return result;
    }

        @Override
        public SpringFinancialData.ISpringFinancialDataSymbolListOutput deserializeFrom(IDataInput in) throws IOException {
            SpringFinancialData.SpringFinancialDataSymbolListOutput result = new SpringFinancialData.SpringFinancialDataSymbolListOutput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SpringFinancialData.SpringFinancialDataSymbolListOutput object) {
        kryo.writeObject(output, object.getAllSymbols());
    }

    @Override
    public SpringFinancialData.SpringFinancialDataSymbolListOutput read(Kryo kryo, Input input, Class<SpringFinancialData.SpringFinancialDataSymbolListOutput> type) {
        SpringFinancialData.SpringFinancialDataSymbolListOutput result = new SpringFinancialData.SpringFinancialDataSymbolListOutput();
        result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link SpringFinancialData.ISpringFinancialDataSpringStreamOutput} algorithm.
 */
public static class SpringFinancialDataSpringStreamOutputSerializer extends Serializer<SpringFinancialData.SpringFinancialDataSpringStreamOutput> implements ISerializer<SpringFinancialData.ISpringFinancialDataSpringStreamOutput> {

    @Override
    public void serializeTo(SpringFinancialData.ISpringFinancialDataSpringStreamOutput object, OutputStream out) throws IOException {
        SSpringFinancialDataSpringStreamOutput tmp = SSpringFinancialDataSpringStreamOutput.newBuilder()
            .setSymbolTuple(object.getSymbolTuple())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(SpringFinancialData.ISpringFinancialDataSpringStreamOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolTuple());
        }

    @Override
    public SpringFinancialData.ISpringFinancialDataSpringStreamOutput deserializeFrom(InputStream in) throws IOException {
        SpringFinancialData.SpringFinancialDataSpringStreamOutput result = new SpringFinancialData.SpringFinancialDataSpringStreamOutput();
        SSpringFinancialDataSpringStreamOutput tmp = SSpringFinancialDataSpringStreamOutput.parseDelimitedFrom(in);
        result.setSymbolTuple(tmp.getSymbolTuple());
        return result;
    }

        @Override
        public SpringFinancialData.ISpringFinancialDataSpringStreamOutput deserializeFrom(IDataInput in) throws IOException {
            SpringFinancialData.SpringFinancialDataSpringStreamOutput result = new SpringFinancialData.SpringFinancialDataSpringStreamOutput();
            result.setSymbolTuple(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SpringFinancialData.SpringFinancialDataSpringStreamOutput object) {
        output.writeString(object.getSymbolTuple());
    }

    @Override
    public SpringFinancialData.SpringFinancialDataSpringStreamOutput read(Kryo kryo, Input input, Class<SpringFinancialData.SpringFinancialDataSpringStreamOutput> type) {
        SpringFinancialData.SpringFinancialDataSpringStreamOutput result = new SpringFinancialData.SpringFinancialDataSpringStreamOutput();
        result.setSymbolTuple(input.readString());
        return result;
    }
}

}
