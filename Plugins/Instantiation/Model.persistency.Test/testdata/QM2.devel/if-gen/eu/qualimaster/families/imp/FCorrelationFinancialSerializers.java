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

import eu.qualimaster.protos.FCorrelationFinancialProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFCorrelationFinancial" (GEN).
 */
@Generated(value="EASy-Producer")
public class FCorrelationFinancialSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput} algorithm.
     */
    public class IFCorrelationFinancialPreprocessedStreamInputSerializer extends Serializer<FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput> implements ISerializer<FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput> {

        @Override
        public void serializeTo(FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput object, OutputStream out) throws IOException {
            SIFCorrelationFinancialPreprocessedStreamInput tmp = SIFCorrelationFinancialPreprocessedStreamInput.newBuilder()
                .setSymbolId(object.getSymbolId())
                .setTimestamp(object.getTimestamp())
                .setValue(object.getValue())
                .setVolume(object.getVolume())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput deserializeFrom(InputStream in) throws IOException {
            FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput result = new FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput();
            SIFCorrelationFinancialPreprocessedStreamInput tmp = SIFCorrelationFinancialPreprocessedStreamInput.parseDelimitedFrom(in);
            result.setSymbolId(tmp.getSymbolId());
            result.setTimestamp(tmp.getTimestamp());
            result.setValue(tmp.getValue());
            result.setVolume(tmp.getVolume());
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
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FCorrelationFinancial.IFCorrelationFinancialSymbolListInput} algorithm.
     */
    public class IFCorrelationFinancialSymbolListInputSerializer extends Serializer<FCorrelationFinancial.IFCorrelationFinancialSymbolListInput> implements ISerializer<FCorrelationFinancial.IFCorrelationFinancialSymbolListInput> {

        @Override
        public void serializeTo(FCorrelationFinancial.IFCorrelationFinancialSymbolListInput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

        @Override
        public FCorrelationFinancial.IFCorrelationFinancialSymbolListInput deserializeFrom(InputStream in) throws IOException {
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
            result.setAllSymbols(kryo.readObject(input, java.util.List.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput} algorithm.
     */
    public class IFCorrelationFinancialPairwiseFinancialOutputSerializer extends Serializer<FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput> implements ISerializer<FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput> {

        @Override
        public void serializeTo(FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput object, OutputStream out) throws IOException {
            SIFCorrelationFinancialPairwiseFinancialOutput tmp = SIFCorrelationFinancialPairwiseFinancialOutput.newBuilder()
                .setPairwiseCorrelationFinancial(object.getPairwiseCorrelationFinancial())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput deserializeFrom(InputStream in) throws IOException {
            FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput result = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
            SIFCorrelationFinancialPairwiseFinancialOutput tmp = SIFCorrelationFinancialPairwiseFinancialOutput.parseDelimitedFrom(in);
            result.setPairwiseCorrelationFinancial(tmp.getPairwiseCorrelationFinancial());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput object) {
            output.writeString(object.getPairwiseCorrelationFinancial());
        }

        @Override
        public FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput read(Kryo kryo, Input input, Class<FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput> type) {
            FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput result = new FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput();
            result.setPairwiseCorrelationFinancial(input.readString());
            return result;
        }
    }

}
