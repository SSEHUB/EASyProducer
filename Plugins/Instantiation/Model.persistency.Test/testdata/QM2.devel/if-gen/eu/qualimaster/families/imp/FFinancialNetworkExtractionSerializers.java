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

import eu.qualimaster.protos.FFinancialNetworkExtractionProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFFinancialNetworkExtraction" (GEN).
 */
@Generated(value="EASy-Producer")
public class FFinancialNetworkExtractionSerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput} algorithm.
     */
    public class IFFinancialNetworkExtractionAnalysisInputSerializer extends Serializer<FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput> implements ISerializer<FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput> {

        @Override
        public void serializeTo(FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput object, OutputStream out) throws IOException {
            SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).serializeTo(object.getStatus(), out);
        }

        @Override
        public FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput deserializeFrom(InputStream in) throws IOException {
            FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput result = new FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput object) {
            kryo.writeObject(output, object.getStatus());
        }

        @Override
        public FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput read(Kryo kryo, Input input, Class<FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput> type) {
            FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput result = new FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput();
            result.setStatus(kryo.readObject(input, twitter4j.Status.class));
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput} algorithm.
     */
    public class IFFinancialNetworkExtractionAnalysisOutputSerializer extends Serializer<FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput> implements ISerializer<FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput> {

        @Override
        public void serializeTo(FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput object, OutputStream out) throws IOException {
            SerializerRegistry.getListSerializerSafe("IFEDGETYPE", eu.qualimaster.families.datatypes.financialnetwork.IFEdge.class).serializeTo(object.getEdges(), out);
            SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).serializeTo(object.getTimeInterval(), out);
        }

        @Override
        public FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput deserializeFrom(InputStream in) throws IOException {
            FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput result = new FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput();
            result.setEdges(SerializerRegistry.getListSerializerSafe("IFEDGETYPE", eu.qualimaster.families.datatypes.financialnetwork.IFEdge.class).deserializeFrom(in));
            result.setTimeInterval(SerializerRegistry.getSerializerSafe("IFTIMEINTERVAL", eu.qualimaster.families.datatypes.common.IFTimeInterval.class).deserializeFrom(in));
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput object) {
            kryo.writeObject(output, object.getEdges());
            kryo.writeObject(output, object.getTimeInterval());
        }

        @Override
        public FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput read(Kryo kryo, Input input, Class<FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput> type) {
            FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput result = new FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput();
            result.setEdges(kryo.readObject(input, java.util.List.class));
            result.setTimeInterval(kryo.readObject(input, eu.qualimaster.families.datatypes.common.IFTimeInterval.class));
            return result;
        }
    }

}
