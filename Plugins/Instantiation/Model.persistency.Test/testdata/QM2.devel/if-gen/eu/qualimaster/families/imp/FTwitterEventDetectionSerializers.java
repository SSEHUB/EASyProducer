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

import eu.qualimaster.protos.FTwitterEventDetectionProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTwitterEventDetection" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTwitterEventDetectionSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput} algorithm.
     */
    public class IFTwitterEventDetectionAnalysisInputSerializer extends Serializer<FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput> implements ISerializer<FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput> {

        @Override
        public void serializeTo(FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput deserializeFrom(InputStream in) throws IOException {
            FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput result = new FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput read(Kryo kryo, Input input, Class<FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput> type) {
            FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput result = new FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput();
            result.setStatus(kryo.readObject(input, twitter4j.Status.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput} algorithm.
     */
    public class IFTwitterEventDetectionAnalysisOutputSerializer extends Serializer<FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput> implements ISerializer<FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput> {

        @Override
        public void serializeTo(FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
            SerializerRegistry.getListSerializerSafe("IFEDGETYPE", eu.qualimaster.families.datatypes.financialnetwork.IFEdge.class).serializeTo(object.getEdges(), out);
            SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).serializeTo(object.getTimeInterval(), out);
        }

        @Override
        public FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput deserializeFrom(InputStream in) throws IOException {
            FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput result = new FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput();
            result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setEdges(SerializerRegistry.getListSerializerSafe("IFEDGETYPE", eu.qualimaster.families.datatypes.financialnetwork.IFEdge.class).deserializeFrom(in));
            result.setTimeInterval(SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput object) {
            kryo.writeObject(output, object.getEvents());
            kryo.writeObject(output, object.getEdges());
            kryo.writeObject(output, object.getTimeInterval());
        }

        @Override
        public FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput read(Kryo kryo, Input input, Class<FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput> type) {
            FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput result = new FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput();
            result.setEvents(kryo.readObject(input, java.util.List.class));
            result.setEdges(kryo.readObject(input, java.util.List.class));
            result.setTimeInterval(kryo.readObject(input, eu.qualimaster.families.datatypes.common.IFTimeInterval.class));
            return result;
        }
    }

}
