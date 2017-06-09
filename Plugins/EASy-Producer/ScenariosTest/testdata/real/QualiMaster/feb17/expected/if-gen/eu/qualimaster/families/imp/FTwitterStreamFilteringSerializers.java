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
import eu.qualimaster.dataManagement.serialization.IDataInput;
import eu.qualimaster.dataManagement.serialization.IDataOutput;
import eu.qualimaster.families.imp.FTwitterStreamFiltering;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.FTwitterStreamFilteringProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IFTwitterStreamFiltering" (GEN).
 */
@Generated(value="EASy-Producer")
public class FTwitterStreamFilteringSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisInput} algorithm.
 */
public static class IFTwitterStreamFilteringAnalysisInputSerializer extends Serializer<FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput> implements ISerializer<IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisInput> {

    @Override
    public void serializeTo(IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisInput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
    }

        @Override
        public void serializeTo(IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisInput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

    @Override
    public IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisInput deserializeFrom(InputStream in) throws IOException {
        FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput result = new FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput();
        result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisInput deserializeFrom(IDataInput in) throws IOException {
            FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput result = new FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput object) {
        kryo.writeObject(output, object.getStatus());
    }

    @Override
    public FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput read(Kryo kryo, Input input, Class<FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput> type) {
        FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput result = new FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput();
        result.setStatus(kryo.readObject(input, Object.class));
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisOutput} algorithm.
 */
public static class IFTwitterStreamFilteringAnalysisOutputSerializer extends Serializer<FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput> implements ISerializer<IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisOutput> {

    @Override
    public void serializeTo(IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
    }

        @Override
        public void serializeTo(IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("OBJECT", Object.class).serializeTo(object.getStatus(), out);
        }

    @Override
    public IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisOutput deserializeFrom(InputStream in) throws IOException {
        FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput result = new FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput();
        result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
        return result;
    }

        @Override
        public IFTwitterStreamFiltering.IIFTwitterStreamFilteringAnalysisOutput deserializeFrom(IDataInput in) throws IOException {
            FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput result = new FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput();
            result.setStatus(SerializerRegistry.getSerializerSafe("OBJECT", Object.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput object) {
        kryo.writeObject(output, object.getStatus());
    }

    @Override
    public FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput read(Kryo kryo, Input input, Class<FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput> type) {
        FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput result = new FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput();
        result.setStatus(kryo.readObject(input, Object.class));
        return result;
    }
}

}
