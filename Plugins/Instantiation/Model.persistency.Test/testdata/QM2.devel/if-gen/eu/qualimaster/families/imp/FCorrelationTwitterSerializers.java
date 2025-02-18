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

import eu.qualimaster.protos.FCorrelationTwitterProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFCorrelationTwitter" (GEN).
 */
@Generated(value="EASy-Producer")
public class FCorrelationTwitterSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput} algorithm.
     */
    public class IFCorrelationTwitterAnalyzedStreamInputSerializer extends Serializer<FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput> implements ISerializer<FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput> {

        @Override
        public void serializeTo(FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput object, OutputStream out) throws IOException {
            SIFCorrelationTwitterAnalyzedStreamInput tmp = SIFCorrelationTwitterAnalyzedStreamInput.newBuilder()
                .setSymbolId(object.getSymbolId())
                .setTimestamp(object.getTimestamp())
                .setValue(object.getValue())
                .setVolume(object.getVolume())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput deserializeFrom(InputStream in) throws IOException {
            FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput result = new FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput();
            SIFCorrelationTwitterAnalyzedStreamInput tmp = SIFCorrelationTwitterAnalyzedStreamInput.parseDelimitedFrom(in);
            result.setSymbolId(tmp.getSymbolId());
            result.setTimestamp(tmp.getTimestamp());
            result.setValue(tmp.getValue());
            result.setVolume(tmp.getVolume());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput object) {
            output.writeString(object.getSymbolId());
            output.writeLong(object.getTimestamp());
            output.writeDouble(object.getValue());
            output.writeInt(object.getVolume());
        }

        @Override
        public FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput read(Kryo kryo, Input input, Class<FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput> type) {
            FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput result = new FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput();
            result.setSymbolId(input.readString());
            result.setTimestamp(input.readLong());
            result.setValue(input.readDouble());
            result.setVolume(input.readInt());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FCorrelationTwitter.IFCorrelationTwitterSymbolListInput} algorithm.
     */
    public class IFCorrelationTwitterSymbolListInputSerializer extends Serializer<FCorrelationTwitter.IFCorrelationTwitterSymbolListInput> implements ISerializer<FCorrelationTwitter.IFCorrelationTwitterSymbolListInput> {

        @Override
        public void serializeTo(FCorrelationTwitter.IFCorrelationTwitterSymbolListInput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getAllSymbols(), out);
        }

        @Override
        public FCorrelationTwitter.IFCorrelationTwitterSymbolListInput deserializeFrom(InputStream in) throws IOException {
            FCorrelationTwitter.IFCorrelationTwitterSymbolListInput result = new FCorrelationTwitter.IFCorrelationTwitterSymbolListInput();
            result.setAllSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FCorrelationTwitter.IFCorrelationTwitterSymbolListInput object) {
            kryo.writeObject(output, object.getAllSymbols());
        }

        @Override
        public FCorrelationTwitter.IFCorrelationTwitterSymbolListInput read(Kryo kryo, Input input, Class<FCorrelationTwitter.IFCorrelationTwitterSymbolListInput> type) {
            FCorrelationTwitter.IFCorrelationTwitterSymbolListInput result = new FCorrelationTwitter.IFCorrelationTwitterSymbolListInput();
            result.setAllSymbols(kryo.readObject(input, java.util.List.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput} algorithm.
     */
    public class IFCorrelationTwitterPairwiseTwitterOutputSerializer extends Serializer<FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput> implements ISerializer<FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput> {

        @Override
        public void serializeTo(FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput object, OutputStream out) throws IOException {
            SIFCorrelationTwitterPairwiseTwitterOutput tmp = SIFCorrelationTwitterPairwiseTwitterOutput.newBuilder()
                .setPairwiseCorrelationTwitter(object.getPairwiseCorrelationTwitter())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput deserializeFrom(InputStream in) throws IOException {
            FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput result = new FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput();
            SIFCorrelationTwitterPairwiseTwitterOutput tmp = SIFCorrelationTwitterPairwiseTwitterOutput.parseDelimitedFrom(in);
            result.setPairwiseCorrelationTwitter(tmp.getPairwiseCorrelationTwitter());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput object) {
            output.writeString(object.getPairwiseCorrelationTwitter());
        }

        @Override
        public FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput read(Kryo kryo, Input input, Class<FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput> type) {
            FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput result = new FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput();
            result.setPairwiseCorrelationTwitter(input.readString());
            return result;
        }
    }

}
