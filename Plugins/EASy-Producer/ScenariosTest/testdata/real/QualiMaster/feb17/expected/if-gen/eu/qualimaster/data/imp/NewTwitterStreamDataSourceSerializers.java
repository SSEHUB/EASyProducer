package eu.qualimaster.data.imp;

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
import eu.qualimaster.data.imp.NewTwitterStreamDataSource;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.NewTwitterStreamDataSourceProtos.*;
/**
 * The implementation of the serializers for the data element "NewTwitterStreamDataSource" (GEN).
 */
@Generated(value="EASy-Producer")
public class NewTwitterStreamDataSourceSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link NewTwitterStreamDataSource.INewTwitterStreamDataSourceAnalysisOutput} algorithm.
 */
public static class NewTwitterStreamDataSourceAnalysisOutputSerializer extends Serializer<NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput> implements ISerializer<NewTwitterStreamDataSource.INewTwitterStreamDataSourceAnalysisOutput> {

    @Override
    public void serializeTo(NewTwitterStreamDataSource.INewTwitterStreamDataSourceAnalysisOutput object, OutputStream out) throws IOException {
        SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).serializeTo(object.getStatus(), out);
    }

        @Override
        public void serializeTo(NewTwitterStreamDataSource.INewTwitterStreamDataSourceAnalysisOutput object, IDataOutput out) throws IOException {
            SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).serializeTo(object.getStatus(), out);
        }

    @Override
    public NewTwitterStreamDataSource.INewTwitterStreamDataSourceAnalysisOutput deserializeFrom(InputStream in) throws IOException {
        NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput result = new NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput();
        result.setStatus(SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).deserializeFrom(in));
        return result;
    }

        @Override
        public NewTwitterStreamDataSource.INewTwitterStreamDataSourceAnalysisOutput deserializeFrom(IDataInput in) throws IOException {
            NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput result = new NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput();
            result.setStatus(SerializerRegistry.getSerializerSafe("STATUS", twitter4j.Status.class).deserializeFrom(in));
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput object) {
        kryo.writeObject(output, object.getStatus());
    }

    @Override
    public NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput read(Kryo kryo, Input input, Class<NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput> type) {
        NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput result = new NewTwitterStreamDataSource.NewTwitterStreamDataSourceAnalysisOutput();
        result.setStatus(kryo.readObject(input, twitter4j.Status.class));
        return result;
    }
}

}
