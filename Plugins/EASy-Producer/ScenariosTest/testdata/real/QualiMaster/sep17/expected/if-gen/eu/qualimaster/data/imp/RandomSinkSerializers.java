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
import eu.qualimaster.data.imp.RandomSink;
import eu.qualimaster.data.inf.*;

import eu.qualimaster.protos.RandomSinkProtos.*;
/**
 * The implementation of the serializers for the data element "RandomSink" (GEN).
 */
@Generated(value="EASy-Producer")
public class RandomSinkSerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link RandomSink.IRandomSinkRandomDataInput} algorithm.
 */
public static class RandomSinkRandomDataInputSerializer extends Serializer<RandomSink.RandomSinkRandomDataInput> implements ISerializer<RandomSink.IRandomSinkRandomDataInput> {

    @Override
    public void serializeTo(RandomSink.IRandomSinkRandomDataInput object, OutputStream out) throws IOException {
        SRandomSinkRandomDataInput tmp = SRandomSinkRandomDataInput.newBuilder()
            .setRandomInteger(object.getRandomInteger())
            .setTimestamp(object.getTimestamp())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(RandomSink.IRandomSinkRandomDataInput object, IDataOutput out) throws IOException {
            out.writeInt(object.getRandomInteger());
            out.writeLong(object.getTimestamp());
        }

    @Override
    public RandomSink.IRandomSinkRandomDataInput deserializeFrom(InputStream in) throws IOException {
        RandomSink.RandomSinkRandomDataInput result = new RandomSink.RandomSinkRandomDataInput();
        SRandomSinkRandomDataInput tmp = SRandomSinkRandomDataInput.parseDelimitedFrom(in);
        result.setRandomInteger(tmp.getRandomInteger());
        result.setTimestamp(tmp.getTimestamp());
        return result;
    }

        @Override
        public RandomSink.IRandomSinkRandomDataInput deserializeFrom(IDataInput in) throws IOException {
            RandomSink.RandomSinkRandomDataInput result = new RandomSink.RandomSinkRandomDataInput();
            result.setRandomInteger(in.nextInt());
            result.setTimestamp(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, RandomSink.RandomSinkRandomDataInput object) {
        output.writeInt(object.getRandomInteger());
        output.writeLong(object.getTimestamp());
    }

    @Override
    public RandomSink.RandomSinkRandomDataInput read(Kryo kryo, Input input, Class<RandomSink.RandomSinkRandomDataInput> type) {
        RandomSink.RandomSinkRandomDataInput result = new RandomSink.RandomSinkRandomDataInput();
        result.setRandomInteger(input.readInt());
        result.setTimestamp(input.readLong());
        return result;
    }
}

}
