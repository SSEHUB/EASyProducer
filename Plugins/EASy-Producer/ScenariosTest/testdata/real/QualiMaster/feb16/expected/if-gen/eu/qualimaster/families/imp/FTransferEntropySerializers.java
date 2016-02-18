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
import eu.qualimaster.families.imp.FTransferEntropy;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTransferEntropyProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTransferEntropy" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTransferEntropySerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTransferEntropy.IIFTransferEntropyPreprocessedStreamInput} algorithm.
     */
    public static class IFTransferEntropyPreprocessedStreamInputSerializer extends Serializer<FTransferEntropy.IFTransferEntropyPreprocessedStreamInput> implements ISerializer<IFTransferEntropy.IIFTransferEntropyPreprocessedStreamInput> {

        @Override
        public void serializeTo(IFTransferEntropy.IIFTransferEntropyPreprocessedStreamInput object, OutputStream out) throws IOException {
            SIFTransferEntropyPreprocessedStreamInput tmp = SIFTransferEntropyPreprocessedStreamInput.newBuilder()
                .setSymbolId(object.getSymbolId())
                .setTimestamp(object.getTimestamp())
                .setValue(object.getValue())
                .setVolume(object.getVolume())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public IFTransferEntropy.IIFTransferEntropyPreprocessedStreamInput deserializeFrom(InputStream in) throws IOException {
            FTransferEntropy.IFTransferEntropyPreprocessedStreamInput result = new FTransferEntropy.IFTransferEntropyPreprocessedStreamInput();
            SIFTransferEntropyPreprocessedStreamInput tmp = SIFTransferEntropyPreprocessedStreamInput.parseDelimitedFrom(in);
            result.setSymbolId(tmp.getSymbolId());
            result.setTimestamp(tmp.getTimestamp());
            result.setValue(tmp.getValue());
            result.setVolume(tmp.getVolume());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTransferEntropy.IFTransferEntropyPreprocessedStreamInput object) {
            output.writeString(object.getSymbolId());
            output.writeLong(object.getTimestamp());
            output.writeDouble(object.getValue());
            output.writeInt(object.getVolume());
        }

        @Override
        public FTransferEntropy.IFTransferEntropyPreprocessedStreamInput read(Kryo kryo, Input input, Class<FTransferEntropy.IFTransferEntropyPreprocessedStreamInput> type) {
            FTransferEntropy.IFTransferEntropyPreprocessedStreamInput result = new FTransferEntropy.IFTransferEntropyPreprocessedStreamInput();
            result.setSymbolId(input.readString());
            result.setTimestamp(input.readLong());
            result.setValue(input.readDouble());
            result.setVolume(input.readInt());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTransferEntropy.IIFTransferEntropySymbolListInput} algorithm.
     */
    public static class IFTransferEntropySymbolListInputSerializer extends Serializer<FTransferEntropy.IFTransferEntropySymbolListInput> implements ISerializer<IFTransferEntropy.IIFTransferEntropySymbolListInput> {

        @Override
        public void serializeTo(IFTransferEntropy.IIFTransferEntropySymbolListInput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

        @Override
        public IFTransferEntropy.IIFTransferEntropySymbolListInput deserializeFrom(InputStream in) throws IOException {
            FTransferEntropy.IFTransferEntropySymbolListInput result = new FTransferEntropy.IFTransferEntropySymbolListInput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTransferEntropy.IFTransferEntropySymbolListInput object) {
            kryo.writeObject(output, object.getAllSymbols());
        }

        @Override
        public FTransferEntropy.IFTransferEntropySymbolListInput read(Kryo kryo, Input input, Class<FTransferEntropy.IFTransferEntropySymbolListInput> type) {
            FTransferEntropy.IFTransferEntropySymbolListInput result = new FTransferEntropy.IFTransferEntropySymbolListInput();
            result.setAllSymbols(kryo.readObject(input, java.util.ArrayList.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTransferEntropy.IIFTransferEntropyPairwiseFinancialOutput} algorithm.
     */
    public static class IFTransferEntropyPairwiseFinancialOutputSerializer extends Serializer<FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput> implements ISerializer<IFTransferEntropy.IIFTransferEntropyPairwiseFinancialOutput> {

        @Override
        public void serializeTo(IFTransferEntropy.IIFTransferEntropyPairwiseFinancialOutput object, OutputStream out) throws IOException {
            SIFTransferEntropyPairwiseFinancialOutput tmp = SIFTransferEntropyPairwiseFinancialOutput.newBuilder()
                .setPairwiseCorrelationFinancial(object.getPairwiseCorrelationFinancial())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public IFTransferEntropy.IIFTransferEntropyPairwiseFinancialOutput deserializeFrom(InputStream in) throws IOException {
            FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput result = new FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput();
            SIFTransferEntropyPairwiseFinancialOutput tmp = SIFTransferEntropyPairwiseFinancialOutput.parseDelimitedFrom(in);
            result.setPairwiseCorrelationFinancial(tmp.getPairwiseCorrelationFinancial());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput object) {
            output.writeString(object.getPairwiseCorrelationFinancial());
        }

        @Override
        public FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput read(Kryo kryo, Input input, Class<FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput> type) {
            FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput result = new FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput();
            result.setPairwiseCorrelationFinancial(input.readString());
            return result;
        }
    }

}
