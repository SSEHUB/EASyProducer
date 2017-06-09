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
import eu.qualimaster.families.imp.FHayashiYoshida;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FHayashiYoshidaProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFHayashiYoshida" (GEN).
 */
@Generated(value="EASy-Producer")
public class FHayashiYoshidaSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFHayashiYoshida.IIFHayashiYoshidaSymbolsStreamInput} algorithm.
 */
public static class IFHayashiYoshidaSymbolsStreamInputSerializer extends Serializer<FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput> implements ISerializer<IFHayashiYoshida.IIFHayashiYoshidaSymbolsStreamInput> {

    @Override
    public void serializeTo(IFHayashiYoshida.IIFHayashiYoshidaSymbolsStreamInput object, OutputStream out) throws IOException {
        SIFHayashiYoshidaSymbolsStreamInput tmp = SIFHayashiYoshidaSymbolsStreamInput.newBuilder()
            .setSymbolId(object.getSymbolId())
            .setTimestamp(object.getTimestamp())
            .setValue(object.getValue())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFHayashiYoshida.IIFHayashiYoshidaSymbolsStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getSymbolId());
            out.writeLong(object.getTimestamp());
            out.writeDouble(object.getValue());
        }

    @Override
    public IFHayashiYoshida.IIFHayashiYoshidaSymbolsStreamInput deserializeFrom(InputStream in) throws IOException {
        FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput result = new FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput();
        SIFHayashiYoshidaSymbolsStreamInput tmp = SIFHayashiYoshidaSymbolsStreamInput.parseDelimitedFrom(in);
        result.setSymbolId(tmp.getSymbolId());
        result.setTimestamp(tmp.getTimestamp());
        result.setValue(tmp.getValue());
        return result;
    }

        @Override
        public IFHayashiYoshida.IIFHayashiYoshidaSymbolsStreamInput deserializeFrom(IDataInput in) throws IOException {
            FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput result = new FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput();
            result.setSymbolId(in.nextString());
            result.setTimestamp(in.nextLong());
            result.setValue(in.nextDouble());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput object) {
        output.writeString(object.getSymbolId());
        output.writeLong(object.getTimestamp());
        output.writeDouble(object.getValue());
    }

    @Override
    public FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput read(Kryo kryo, Input input, Class<FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput> type) {
        FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput result = new FHayashiYoshida.IFHayashiYoshidaSymbolsStreamInput();
        result.setSymbolId(input.readString());
        result.setTimestamp(input.readLong());
        result.setValue(input.readDouble());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFHayashiYoshida.IIFHayashiYoshidaConfigurationStreamInput} algorithm.
 */
public static class IFHayashiYoshidaConfigurationStreamInputSerializer extends Serializer<FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput> implements ISerializer<IFHayashiYoshida.IIFHayashiYoshidaConfigurationStreamInput> {

    @Override
    public void serializeTo(IFHayashiYoshida.IIFHayashiYoshidaConfigurationStreamInput object, OutputStream out) throws IOException {
        SIFHayashiYoshidaConfigurationStreamInput tmp = SIFHayashiYoshidaConfigurationStreamInput.newBuilder()
            .setPairKey(object.getPairKey())
            .setPairValue(object.getPairValue())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFHayashiYoshida.IIFHayashiYoshidaConfigurationStreamInput object, IDataOutput out) throws IOException {
            out.writeString(object.getPairKey());
            out.writeString(object.getPairValue());
        }

    @Override
    public IFHayashiYoshida.IIFHayashiYoshidaConfigurationStreamInput deserializeFrom(InputStream in) throws IOException {
        FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput result = new FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput();
        SIFHayashiYoshidaConfigurationStreamInput tmp = SIFHayashiYoshidaConfigurationStreamInput.parseDelimitedFrom(in);
        result.setPairKey(tmp.getPairKey());
        result.setPairValue(tmp.getPairValue());
        return result;
    }

        @Override
        public IFHayashiYoshida.IIFHayashiYoshidaConfigurationStreamInput deserializeFrom(IDataInput in) throws IOException {
            FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput result = new FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput();
            result.setPairKey(in.nextString());
            result.setPairValue(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput object) {
        output.writeString(object.getPairKey());
        output.writeString(object.getPairValue());
    }

    @Override
    public FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput read(Kryo kryo, Input input, Class<FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput> type) {
        FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput result = new FHayashiYoshida.IFHayashiYoshidaConfigurationStreamInput();
        result.setPairKey(input.readString());
        result.setPairValue(input.readString());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFHayashiYoshida.IIFHayashiYoshidaResetWindowStreamInput} algorithm.
 */
public static class IFHayashiYoshidaResetWindowStreamInputSerializer extends Serializer<FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput> implements ISerializer<IFHayashiYoshida.IIFHayashiYoshidaResetWindowStreamInput> {

    @Override
    public void serializeTo(IFHayashiYoshida.IIFHayashiYoshidaResetWindowStreamInput object, OutputStream out) throws IOException {
        SIFHayashiYoshidaResetWindowStreamInput tmp = SIFHayashiYoshidaResetWindowStreamInput.newBuilder()
            .setWindowStart(object.getWindowStart())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFHayashiYoshida.IIFHayashiYoshidaResetWindowStreamInput object, IDataOutput out) throws IOException {
            out.writeLong(object.getWindowStart());
        }

    @Override
    public IFHayashiYoshida.IIFHayashiYoshidaResetWindowStreamInput deserializeFrom(InputStream in) throws IOException {
        FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput result = new FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput();
        SIFHayashiYoshidaResetWindowStreamInput tmp = SIFHayashiYoshidaResetWindowStreamInput.parseDelimitedFrom(in);
        result.setWindowStart(tmp.getWindowStart());
        return result;
    }

        @Override
        public IFHayashiYoshida.IIFHayashiYoshidaResetWindowStreamInput deserializeFrom(IDataInput in) throws IOException {
            FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput result = new FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput();
            result.setWindowStart(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput object) {
        output.writeLong(object.getWindowStart());
    }

    @Override
    public FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput read(Kryo kryo, Input input, Class<FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput> type) {
        FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput result = new FHayashiYoshida.IFHayashiYoshidaResetWindowStreamInput();
        result.setWindowStart(input.readLong());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFHayashiYoshida.IIFHayashiYoshidaPairwiseFinancialOutput} algorithm.
 */
public static class IFHayashiYoshidaPairwiseFinancialOutputSerializer extends Serializer<FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput> implements ISerializer<IFHayashiYoshida.IIFHayashiYoshidaPairwiseFinancialOutput> {

    @Override
    public void serializeTo(IFHayashiYoshida.IIFHayashiYoshidaPairwiseFinancialOutput object, OutputStream out) throws IOException {
        SIFHayashiYoshidaPairwiseFinancialOutput tmp = SIFHayashiYoshidaPairwiseFinancialOutput.newBuilder()
            .setPairwiseCorrelationFinancial(object.getPairwiseCorrelationFinancial())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IFHayashiYoshida.IIFHayashiYoshidaPairwiseFinancialOutput object, IDataOutput out) throws IOException {
            out.writeString(object.getPairwiseCorrelationFinancial());
        }

    @Override
    public IFHayashiYoshida.IIFHayashiYoshidaPairwiseFinancialOutput deserializeFrom(InputStream in) throws IOException {
        FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput result = new FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput();
        SIFHayashiYoshidaPairwiseFinancialOutput tmp = SIFHayashiYoshidaPairwiseFinancialOutput.parseDelimitedFrom(in);
        result.setPairwiseCorrelationFinancial(tmp.getPairwiseCorrelationFinancial());
        return result;
    }

        @Override
        public IFHayashiYoshida.IIFHayashiYoshidaPairwiseFinancialOutput deserializeFrom(IDataInput in) throws IOException {
            FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput result = new FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput();
            result.setPairwiseCorrelationFinancial(in.nextString());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput object) {
        output.writeString(object.getPairwiseCorrelationFinancial());
    }

    @Override
    public FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput read(Kryo kryo, Input input, Class<FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput> type) {
        FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput result = new FHayashiYoshida.IFHayashiYoshidaPairwiseFinancialOutput();
        result.setPairwiseCorrelationFinancial(input.readString());
        return result;
    }
}

}
