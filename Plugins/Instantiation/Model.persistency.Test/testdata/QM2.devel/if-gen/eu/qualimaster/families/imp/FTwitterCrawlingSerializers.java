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

import eu.qualimaster.protos.FTwitterCrawlingProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTwitterCrawling" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTwitterCrawlingSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FTwitterCrawling.IFTwitterCrawlingAnalysisInput} algorithm.
     */
    public class IFTwitterCrawlingAnalysisInputSerializer extends Serializer<FTwitterCrawling.IFTwitterCrawlingAnalysisInput> implements ISerializer<FTwitterCrawling.IFTwitterCrawlingAnalysisInput> {

        @Override
        public void serializeTo(FTwitterCrawling.IFTwitterCrawlingAnalysisInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public FTwitterCrawling.IFTwitterCrawlingAnalysisInput deserializeFrom(InputStream in) throws IOException {
            FTwitterCrawling.IFTwitterCrawlingAnalysisInput result = new FTwitterCrawling.IFTwitterCrawlingAnalysisInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTwitterCrawling.IFTwitterCrawlingAnalysisInput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FTwitterCrawling.IFTwitterCrawlingAnalysisInput read(Kryo kryo, Input input, Class<FTwitterCrawling.IFTwitterCrawlingAnalysisInput> type) {
            FTwitterCrawling.IFTwitterCrawlingAnalysisInput result = new FTwitterCrawling.IFTwitterCrawlingAnalysisInput();
            result.setStatus(kryo.readObject(input, twitter4j.Status.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FTwitterCrawling.IFTwitterCrawlingAnalysisOutput} algorithm.
     */
    public class IFTwitterCrawlingAnalysisOutputSerializer extends Serializer<FTwitterCrawling.IFTwitterCrawlingAnalysisOutput> implements ISerializer<FTwitterCrawling.IFTwitterCrawlingAnalysisOutput> {

        @Override
        public void serializeTo(FTwitterCrawling.IFTwitterCrawlingAnalysisOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).serializeTo(object.getEvents(), out);
            SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).serializeTo(object.getTimeInterval(), out);
        }

        @Override
        public FTwitterCrawling.IFTwitterCrawlingAnalysisOutput deserializeFrom(InputStream in) throws IOException {
            FTwitterCrawling.IFTwitterCrawlingAnalysisOutput result = new FTwitterCrawling.IFTwitterCrawlingAnalysisOutput();
            result.setEvents(SerializerRegistry.getListSerializerSafe("IFEVENTLISTTYPE", eu.qualimaster.families.datatypes.events.IFEvent.class).deserializeFrom(in));
            result.setTimeInterval(SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FTwitterCrawling.IFTwitterCrawlingAnalysisOutput object) {
            kryo.writeObject(output, object.getEvents());
            kryo.writeObject(output, object.getTimeInterval());
        }

        @Override
        public FTwitterCrawling.IFTwitterCrawlingAnalysisOutput read(Kryo kryo, Input input, Class<FTwitterCrawling.IFTwitterCrawlingAnalysisOutput> type) {
            FTwitterCrawling.IFTwitterCrawlingAnalysisOutput result = new FTwitterCrawling.IFTwitterCrawlingAnalysisOutput();
            result.setEvents(kryo.readObject(input, java.util.List.class));
            result.setTimeInterval(kryo.readObject(input, eu.qualimaster.families.datatypes.common.IFTimeInterval.class));
            return result;
        }
    }

}
