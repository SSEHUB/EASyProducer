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
import eu.qualimaster.families.imp.FExpertSearch;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FExpertSearchProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFExpertSearch" (GEN).
 */
@Generated(value="EASy-Producer")
public class FExpertSearchSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFExpertSearch.IIFExpertSearchAnalysisInput} algorithm.
     */
    public static class IFExpertSearchAnalysisInputSerializer extends Serializer<FExpertSearch.IFExpertSearchAnalysisInput> implements ISerializer<IFExpertSearch.IIFExpertSearchAnalysisInput> {

        @Override
        public void serializeTo(IFExpertSearch.IIFExpertSearchAnalysisInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public IFExpertSearch.IIFExpertSearchAnalysisInput deserializeFrom(InputStream in) throws IOException {
            FExpertSearch.IFExpertSearchAnalysisInput result = new FExpertSearch.IFExpertSearchAnalysisInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FExpertSearch.IFExpertSearchAnalysisInput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FExpertSearch.IFExpertSearchAnalysisInput read(Kryo kryo, Input input, Class<FExpertSearch.IFExpertSearchAnalysisInput> type) {
            FExpertSearch.IFExpertSearchAnalysisInput result = new FExpertSearch.IFExpertSearchAnalysisInput();
            result.setStatus(kryo.readObject(input, twitter4j.Status.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFExpertSearch.IIFExpertSearchAnalysisOutput} algorithm.
     */
    public static class IFExpertSearchAnalysisOutputSerializer extends Serializer<FExpertSearch.IFExpertSearchAnalysisOutput> implements ISerializer<IFExpertSearch.IIFExpertSearchAnalysisOutput> {

        @Override
        public void serializeTo(IFExpertSearch.IIFExpertSearchAnalysisOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEXPERTLIST", eu.qualimaster.families.datatypes.expertsearch.IFExpert.class).serializeTo(object.getExperts(), out);
            SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).serializeTo(object.getTimeInterval(), out);
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getKeywords(), out);
            SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).serializeTo(object.getSymbols(), out);
        }

        @Override
        public IFExpertSearch.IIFExpertSearchAnalysisOutput deserializeFrom(InputStream in) throws IOException {
            FExpertSearch.IFExpertSearchAnalysisOutput result = new FExpertSearch.IFExpertSearchAnalysisOutput();
            result.setExperts(SerializerRegistry.getListSerializerSafe("IFEXPERTLIST", eu.qualimaster.families.datatypes.expertsearch.IFExpert.class).deserializeFrom(in));
            result.setTimeInterval(SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).deserializeFrom(in));
            result.setKeywords(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            result.setSymbols(SerializerRegistry.getListSerializerSafe("STRINGLIST", String.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FExpertSearch.IFExpertSearchAnalysisOutput object) {
            kryo.writeObject(output, object.getExperts());
            kryo.writeObject(output, object.getTimeInterval());
            kryo.writeObject(output, object.getKeywords());
            kryo.writeObject(output, object.getSymbols());
        }

        @Override
        public FExpertSearch.IFExpertSearchAnalysisOutput read(Kryo kryo, Input input, Class<FExpertSearch.IFExpertSearchAnalysisOutput> type) {
            FExpertSearch.IFExpertSearchAnalysisOutput result = new FExpertSearch.IFExpertSearchAnalysisOutput();
            result.setExperts(kryo.readObject(input, java.util.ArrayList.class));
            result.setTimeInterval(kryo.readObject(input, eu.qualimaster.families.datatypes.common.IFTimeInterval.class));
            result.setKeywords(kryo.readObject(input, java.util.ArrayList.class));
            result.setSymbols(kryo.readObject(input, java.util.ArrayList.class));
            return result;
        }
    }

}
