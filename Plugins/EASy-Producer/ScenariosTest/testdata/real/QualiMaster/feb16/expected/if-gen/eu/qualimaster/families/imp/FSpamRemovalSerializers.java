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
import eu.qualimaster.families.imp.FSpamRemoval;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FSpamRemovalProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFSpamRemoval" (GEN).
 */
@Generated(value="EASy-Producer")
public class FSpamRemovalSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFSpamRemoval.IIFSpamRemovalTwitterStreamInput} algorithm.
     */
    public static class IFSpamRemovalTwitterStreamInputSerializer extends Serializer<FSpamRemoval.IFSpamRemovalTwitterStreamInput> implements ISerializer<IFSpamRemoval.IIFSpamRemovalTwitterStreamInput> {

        @Override
        public void serializeTo(IFSpamRemoval.IIFSpamRemovalTwitterStreamInput object, OutputStream out) throws IOException {
            SIFSpamRemovalTwitterStreamInput tmp = SIFSpamRemovalTwitterStreamInput.newBuilder()
                .setSpamPropability(object.getSpamPropability())
                .build();
            tmp.writeDelimitedTo(out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFSpamRemoval.IIFSpamRemovalTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
            FSpamRemoval.IFSpamRemovalTwitterStreamInput result = new FSpamRemoval.IFSpamRemovalTwitterStreamInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            SIFSpamRemovalTwitterStreamInput tmp = SIFSpamRemovalTwitterStreamInput.parseDelimitedFrom(in);
            result.setSpamPropability(tmp.getSpamPropability());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FSpamRemoval.IFSpamRemovalTwitterStreamInput object) {
            kryo.writeObject(output, object.getStatus());
            output.writeDouble(object.getSpamPropability());
        }

        @Override
        public FSpamRemoval.IFSpamRemovalTwitterStreamInput read(Kryo kryo, Input input, Class<FSpamRemoval.IFSpamRemovalTwitterStreamInput> type) {
            FSpamRemoval.IFSpamRemovalTwitterStreamInput result = new FSpamRemoval.IFSpamRemovalTwitterStreamInput();
            result.setStatus(kryo.readObject(input, Object.class));
            result.setSpamPropability(input.readDouble());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFSpamRemoval.IIFSpamRemovalTwitterStreamOutput} algorithm.
     */
    public static class IFSpamRemovalTwitterStreamOutputSerializer extends Serializer<FSpamRemoval.IFSpamRemovalTwitterStreamOutput> implements ISerializer<IFSpamRemoval.IIFSpamRemovalTwitterStreamOutput> {

        @Override
        public void serializeTo(IFSpamRemoval.IIFSpamRemovalTwitterStreamOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFSpamRemoval.IIFSpamRemovalTwitterStreamOutput deserializeFrom(InputStream in) throws IOException {
            FSpamRemoval.IFSpamRemovalTwitterStreamOutput result = new FSpamRemoval.IFSpamRemovalTwitterStreamOutput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FSpamRemoval.IFSpamRemovalTwitterStreamOutput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FSpamRemoval.IFSpamRemovalTwitterStreamOutput read(Kryo kryo, Input input, Class<FSpamRemoval.IFSpamRemovalTwitterStreamOutput> type) {
            FSpamRemoval.IFSpamRemovalTwitterStreamOutput result = new FSpamRemoval.IFSpamRemovalTwitterStreamOutput();
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

}
