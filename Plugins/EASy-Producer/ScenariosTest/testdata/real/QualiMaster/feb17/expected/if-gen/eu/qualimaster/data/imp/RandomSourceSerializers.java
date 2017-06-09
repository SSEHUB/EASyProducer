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
import eu.qualimaster.data.imp.RandomSource;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.RandomSourceProtos.*;
/**
 * The implementation of the serializers for the data element "RandomSource" (GEN).
 */
@Generated(value="EASy-Producer")
public class RandomSourceSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link RandomSource.IRandomSourceRandomDataOutput} algorithm.
 */
public static class RandomSourceRandomDataOutputSerializer extends Serializer<RandomSource.RandomSourceRandomDataOutput> implements ISerializer<RandomSource.IRandomSourceRandomDataOutput> {

    @Override
    public void serializeTo(RandomSource.IRandomSourceRandomDataOutput object, OutputStream out) throws IOException {
        SRandomSourceRandomDataOutput tmp = SRandomSourceRandomDataOutput.newBuilder()
            .setRandomInteger(object.getRandomInteger())
            .setTimestamp(object.getTimestamp())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(RandomSource.IRandomSourceRandomDataOutput object, IDataOutput out) throws IOException {
            out.writeInt(object.getRandomInteger());
            out.writeLong(object.getTimestamp());
        }

    @Override
    public RandomSource.IRandomSourceRandomDataOutput deserializeFrom(InputStream in) throws IOException {
        RandomSource.RandomSourceRandomDataOutput result = new RandomSource.RandomSourceRandomDataOutput();
        SRandomSourceRandomDataOutput tmp = SRandomSourceRandomDataOutput.parseDelimitedFrom(in);
        result.setRandomInteger(tmp.getRandomInteger());
        result.setTimestamp(tmp.getTimestamp());
        return result;
    }

        @Override
        public RandomSource.IRandomSourceRandomDataOutput deserializeFrom(IDataInput in) throws IOException {
            RandomSource.RandomSourceRandomDataOutput result = new RandomSource.RandomSourceRandomDataOutput();
            result.setRandomInteger(in.nextInt());
            result.setTimestamp(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, RandomSource.RandomSourceRandomDataOutput object) {
        output.writeInt(object.getRandomInteger());
        output.writeLong(object.getTimestamp());
    }

    @Override
    public RandomSource.RandomSourceRandomDataOutput read(Kryo kryo, Input input, Class<RandomSource.RandomSourceRandomDataOutput> type) {
        RandomSource.RandomSourceRandomDataOutput result = new RandomSource.RandomSourceRandomDataOutput();
        result.setRandomInteger(input.readInt());
        result.setTimestamp(input.readLong());
        return result;
    }
}

}
