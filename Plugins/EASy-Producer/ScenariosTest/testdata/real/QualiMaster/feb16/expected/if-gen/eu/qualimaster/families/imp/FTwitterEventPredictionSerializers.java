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
import eu.qualimaster.families.imp.FTwitterEventPrediction;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTwitterEventPredictionProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTwitterEventPrediction" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTwitterEventPredictionSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTwitterEventPrediction.IIFTwitterEventPredictionAnalysisInput} algorithm.
     */
    public static class IFTwitterEventPredictionAnalysisInputSerializer extends Serializer<FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput> implements ISerializer<IFTwitterEventPrediction.IIFTwitterEventPredictionAnalysisInput> {

        @Override
        public void serializeTo(IFTwitterEventPrediction.IIFTwitterEventPredictionAnalysisInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFTwitterEventPrediction.IIFTwitterEventPredictionAnalysisInput deserializeFrom(InputStream in) throws IOException {
            FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput result = new FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput read(Kryo kryo, Input input, Class<FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput> type) {
            FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput result = new FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput();
            result.setStatus(kryo.readObject(input, Object.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTwitterEventPrediction.IIFTwitterEventPredictionAnalysisOutput} algorithm.
     */
    public static class IFTwitterEventPredictionAnalysisOutputSerializer extends Serializer<FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput> implements ISerializer<IFTwitterEventPrediction.IIFTwitterEventPredictionAnalysisOutput> {

        @Override
        public void serializeTo(IFTwitterEventPrediction.IIFTwitterEventPredictionAnalysisOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getSymbols(), out);
            SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).serializeTo(object.getTimeInterval(), out);
        }

        @Override
        public IFTwitterEventPrediction.IIFTwitterEventPredictionAnalysisOutput deserializeFrom(InputStream in) throws IOException {
            FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput result = new FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput();
            result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setSymbols(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setTimeInterval(SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput object) {
            kryo.writeObject(output, object.getEvents());
            kryo.writeObject(output, object.getSymbols());
            kryo.writeObject(output, object.getTimeInterval());
        }

        @Override
        public FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput read(Kryo kryo, Input input, Class<FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput> type) {
            FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput result = new FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput();
            result.setEvents(kryo.readObject(input, java.util.ArrayList.class));
            result.setSymbols(kryo.readObject(input, java.util.ArrayList.class));
            result.setTimeInterval(kryo.readObject(input, eu.qualimaster.families.datatypes.common.IFTimeInterval.class));
            return result;
        }
    }

}
