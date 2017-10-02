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
import eu.qualimaster.families.imp.FCorrelationFinancial;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FCorrelationFinancialProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFCorrelationFinancial" (GEN).
 */
@Generated(value="EASy-Producer")
public class FCorrelationFinancialSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFCorrelationFinancial.IIFCorrelationFinancialPreprocessedStreamInput} algorithm.
     */
    public static class IFCorrelationFinancialPreprocessedStreamInputSerializer extends Serializer<FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput> implements ISerializer<IFCorrelationFinancial.IIFCorrelationFinancialPreprocessedStreamInput> {
    
        @Override
        public void serializeTo(IFCorrelationFinancial.IIFCorrelationFinancialPreprocessedStreamInput object, OutputStream out) throws IOException {
            SIFCorrelationFinancialPreprocessedStreamInput tmp = SIFCorrelationFinancialPreprocessedStreamInput.newBuilder()
                .setSymbolId(object.getSymbolId())
                .setTimestamp(object.getTimestamp())
                .setValue(object.getValue())
                .setVolume(object.getVolume())
                .build();
            tmp.writeDelimitedTo(out);
        }
    
            @Override
            public void serializeTo(IFCorrelationFinancial.IIFCorrelationFinancialPreprocessedStreamInput object, IDataOutput out) throws IOException {
                out.writeString(object.getSymbolId());
                out.writeLong(object.getTimestamp());
                out.writeDouble(object.getValue());
                out.writeInt(object.getVolume());
            }
    
        @Override
        public IFCorrelationFinancial.IIFCorrelationFinancialPreprocessedStreamInput deserializeFrom(InputStream in) throws IOException {
            FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput result = new FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput();
            SIFCorrelationFinancialPreprocessedStreamInput tmp = SIFCorrelationFinancialPreprocessedStreamInput.parseDelimitedFrom(in);
            result.setSymbolId(tmp.getSymbolId());
            result.setTimestamp(tmp.getTimestamp());
            result.setValue(tmp.getValue());
            result.setVolume(tmp.getVolume());
            return result;
        }
    
            @Override
            public IFCorrelationFinancial.IIFCorrelationFinancialPreprocessedStreamInput deserializeFrom(IDataInput in) throws IOException {
                FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput result = new FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput();
                result.setSymbolId(in.nextString());
                result.setTimestamp(in.nextLong());
                result.setValue(in.nextDouble());
                result.setVolume(in.nextInt());
                return result;
            }
    
        @Override
        public void write(Kryo kryo, Output output, FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput object) {
            output.writeString(object.getSymbolId());
            output.writeLong(object.getTimestamp());
            output.writeDouble(object.getValue());
            output.writeInt(object.getVolume());
        }
    
        @Override
        public FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput read(Kryo kryo, Input input, Class<FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput> type) {
            FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput result = new FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput();
            result.setSymbolId(input.readString());
            result.setTimestamp(input.readLong());
            result.setValue(input.readDouble());
            result.setVolume(input.readInt());
            return result;
        }
    }
    
    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFCorrelationFinancial.IIFCorrelationFinancialSymbolListInput} algorithm.
     */
    public static class IFCorrelationFinancialSymbolListInputSerializer extends Serializer<FCorrelationFinancial.IFCorrelationFinancialSymbolListInput> implements ISerializer<IFCorrelationFinancial.IIFCorrelationFinancialSymbolListInput> {
    
        @Override
        public void serializeTo(IFCorrelationFinancial.IIFCorrelationFinancialSymbolListInput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }
    
            @Override
            public void serializeTo(IFCorrelationFinancial.IIFCorrelationFinancialSymbolListInput object, IDataOutput out) throws IOException {
                SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
            }
    
        @Override
        public IFCorrelationFinancial.IIFCorrelationFinancialSymbolListInput deserializeFrom(InputStream in) throws IOException {
            FCorrelationFinancial.IFCorrelationFinancialSymbolListInput result = new FCorrelationFinancial.IFCorrelationFinancialSymbolListInput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }
    
            @Override
            public IFCorrelationFinancial.IIFCorrelationFinancialSymbolListInput deserializeFrom(IDataInput in) throws IOException {
                FCorrelationFinancial.IFCorrelationFinancialSymbolListInput result = new FCorrelationFinancial.IFCorrelationFinancialSymbolListInput();
                result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
                return result;
            }
    
        @Override
        public void write(Kryo kryo, Output output, FCorrelationFinancial.IFCorrelationFinancialSymbolListInput object) {
            kryo.writeObject(output, object.getAllSymbols());
        }
    
        @Override
        public FCorrelationFinancial.IFCorrelationFinancialSymbolListInput read(Kryo kryo, Input input, Class<FCorrelationFinancial.IFCorrelationFinancialSymbolListInput> type) {
            FCorrelationFinancial.IFCorrelationFinancialSymbolListInput result = new FCorrelationFinancial.IFCorrelationFinancialSymbolListInput();
            result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
            return result;
        }
    }
    
    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFCorrelationFinancial.IIFCorrelationFinancialPairwiseFinancialOutput} algorithm.
     */
    public static class IFCorrelationFinancialPairwiseFinancialOutputSerializer extends Serializer<FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput> implements ISerializer<IFCorrelationFinancial.IIFCorrelationFinancialPairwiseFinancialOutput> {
    
        @Override
        public void serializeTo(IFCorrelationFinancial.IIFCorrelationFinancialPairwiseFinancialOutput object, OutputStream out) throws IOException {
            SIFCorrelationFinancialPairwiseFinancialOutput tmp = SIFCorrelationFinancialPairwiseFinancialOutput.newBuilder()
                .setId0(object.getId0())
                .setId1(object.getId1())
                .setDate(object.getDate())
                .setValue(object.getValue())
                .build();
            tmp.writeDelimitedTo(out);
        }
    
            @Override
            public void serializeTo(IFCorrelationFinancial.IIFCorrelationFinancialPairwiseFinancialOutput object, IDataOutput out) throws IOException {
                out.writeString(object.getId0());
                out.writeString(object.getId1());
                out.writeString(object.getDate());
                out.writeDouble(object.getValue());
            }
    
        @Override
        public IFCorrelationFinancial.IIFCorrelationFinancialPairwiseFinancialOutput deserializeFrom(InputStream in) throws IOException {
            FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput result = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
            SIFCorrelationFinancialPairwiseFinancialOutput tmp = SIFCorrelationFinancialPairwiseFinancialOutput.parseDelimitedFrom(in);
            result.setId0(tmp.getId0());
            result.setId1(tmp.getId1());
            result.setDate(tmp.getDate());
            result.setValue(tmp.getValue());
            return result;
        }
    
            @Override
            public IFCorrelationFinancial.IIFCorrelationFinancialPairwiseFinancialOutput deserializeFrom(IDataInput in) throws IOException {
                FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput result = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
                result.setId0(in.nextString());
                result.setId1(in.nextString());
                result.setDate(in.nextString());
                result.setValue(in.nextDouble());
                return result;
            }
    
        @Override
        public void write(Kryo kryo, Output output, FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput object) {
            output.writeString(object.getId0());
            output.writeString(object.getId1());
            output.writeString(object.getDate());
            output.writeDouble(object.getValue());
        }
    
        @Override
        public FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput read(Kryo kryo, Input input, Class<FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput> type) {
            FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput result = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
            result.setId0(input.readString());
            result.setId1(input.readString());
            result.setDate(input.readString());
            result.setValue(input.readDouble());
            return result;
        }
    }
 
}
