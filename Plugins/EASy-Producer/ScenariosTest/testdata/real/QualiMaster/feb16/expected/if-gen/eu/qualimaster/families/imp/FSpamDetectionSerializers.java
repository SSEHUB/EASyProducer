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
import eu.qualimaster.families.imp.FSpamDetection;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FSpamDetectionProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFSpamDetection" (GEN).
 */
@Generated(value="EASy-Producer")
public class FSpamDetectionSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFSpamDetection.IIFSpamDetectionTwitterStreamInput} algorithm.
     */
    public static class IFSpamDetectionTwitterStreamInputSerializer extends Serializer<FSpamDetection.IFSpamDetectionTwitterStreamInput> implements ISerializer<IFSpamDetection.IIFSpamDetectionTwitterStreamInput> {

        @Override
        public void serializeTo(IFSpamDetection.IIFSpamDetectionTwitterStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFSpamDetection.IIFSpamDetectionTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
            FSpamDetection.IFSpamDetectionTwitterStreamInput result = new FSpamDetection.IFSpamDetectionTwitterStreamInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FSpamDetection.IFSpamDetectionTwitterStreamInput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FSpamDetection.IFSpamDetectionTwitterStreamInput read(Kryo kryo, Input input, Class<FSpamDetection.IFSpamDetectionTwitterStreamInput> type) {
            FSpamDetection.IFSpamDetectionTwitterStreamInput result = new FSpamDetection.IFSpamDetectionTwitterStreamInput();
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFSpamDetection.IIFSpamDetectionTwitterStreamOutput} algorithm.
     */
    public static class IFSpamDetectionTwitterStreamOutputSerializer extends Serializer<FSpamDetection.IFSpamDetectionTwitterStreamOutput> implements ISerializer<IFSpamDetection.IIFSpamDetectionTwitterStreamOutput> {

        @Override
        public void serializeTo(IFSpamDetection.IIFSpamDetectionTwitterStreamOutput object, OutputStream out) throws IOException {
            SIFSpamDetectionTwitterStreamOutput tmp = SIFSpamDetectionTwitterStreamOutput.newBuilder()
                .setSpamPropability(object.getSpamPropability())
                .build();
            tmp.writeDelimitedTo(out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFSpamDetection.IIFSpamDetectionTwitterStreamOutput deserializeFrom(InputStream in) throws IOException {
            FSpamDetection.IFSpamDetectionTwitterStreamOutput result = new FSpamDetection.IFSpamDetectionTwitterStreamOutput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            SIFSpamDetectionTwitterStreamOutput tmp = SIFSpamDetectionTwitterStreamOutput.parseDelimitedFrom(in);
            result.setSpamPropability(tmp.getSpamPropability());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FSpamDetection.IFSpamDetectionTwitterStreamOutput object) {
            kryo.writeObject(output, object.getStatus());
            output.writeDouble(object.getSpamPropability());
        }

        @Override
        public FSpamDetection.IFSpamDetectionTwitterStreamOutput read(Kryo kryo, Input input, Class<FSpamDetection.IFSpamDetectionTwitterStreamOutput> type) {
            FSpamDetection.IFSpamDetectionTwitterStreamOutput result = new FSpamDetection.IFSpamDetectionTwitterStreamOutput();
            result.setStatus(kryo.readObject(input, Object.class));
            result.setSpamPropability(input.readDouble());
            return result;
        }
    }

}
