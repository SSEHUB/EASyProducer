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
import eu.qualimaster.families.imp.FTwitterEventDetection;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTwitterEventDetectionProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTwitterEventDetection" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTwitterEventDetectionSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTwitterEventDetection.IIFTwitterEventDetectionTwitterStreamInput} algorithm.
     */
    public static class IFTwitterEventDetectionTwitterStreamInputSerializer extends Serializer<FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput> implements ISerializer<IFTwitterEventDetection.IIFTwitterEventDetectionTwitterStreamInput> {

        @Override
        public void serializeTo(IFTwitterEventDetection.IIFTwitterEventDetectionTwitterStreamInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStocks(), out);
        }

        @Override
        public IFTwitterEventDetection.IIFTwitterEventDetectionTwitterStreamInput deserializeFrom(InputStream in) throws IOException {
            FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput result = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            result.setStocks(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput object) {
            kryo.writeObject(output, object.getStatus());
            kryo.writeObject(output, object.getStocks());
        }

        @Override
        public FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput read(Kryo kryo, Input input, Class<FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput> type) {
            FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput result = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput();
            result.setStatus(kryo.readObject(input, Object.class));
            result.setStocks(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTwitterEventDetection.IIFTwitterEventDetectionTwitterStreamOutput} algorithm.
     */
    public static class IFTwitterEventDetectionTwitterStreamOutputSerializer extends Serializer<FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput> implements ISerializer<IFTwitterEventDetection.IIFTwitterEventDetectionTwitterStreamOutput> {

        @Override
        public void serializeTo(IFTwitterEventDetection.IIFTwitterEventDetectionTwitterStreamOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFTwitterEventDetection.IIFTwitterEventDetectionTwitterStreamOutput deserializeFrom(InputStream in) throws IOException {
            FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput result = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput();
            result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput object) {
            kryo.writeObject(output, object.getEvents());
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput read(Kryo kryo, Input input, Class<FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput> type) {
            FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput result = new FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput();
            result.setEvents(kryo.readObject(input, java.util.ArrayList.class));
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

}
