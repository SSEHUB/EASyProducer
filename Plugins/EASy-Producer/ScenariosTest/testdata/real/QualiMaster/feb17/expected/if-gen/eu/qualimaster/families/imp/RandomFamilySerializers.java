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
import eu.qualimaster.families.imp.RandomFamily;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.RandomFamilyProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IRandomFamily" (GEN).
 */
@Generated(value="EASy-Producer")
public class RandomFamilySerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link IRandomFamily.IIRandomFamilyRandomDataInput} algorithm.
 */
public static class IRandomFamilyRandomDataInputSerializer extends Serializer<RandomFamily.IRandomFamilyRandomDataInput> implements ISerializer<IRandomFamily.IIRandomFamilyRandomDataInput> {

    @Override
    public void serializeTo(IRandomFamily.IIRandomFamilyRandomDataInput object, OutputStream out) throws IOException {
        SIRandomFamilyRandomDataInput tmp = SIRandomFamilyRandomDataInput.newBuilder()
            .setRandomInteger(object.getRandomInteger())
            .setTimestamp(object.getTimestamp())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IRandomFamily.IIRandomFamilyRandomDataInput object, IDataOutput out) throws IOException {
            out.writeInt(object.getRandomInteger());
            out.writeLong(object.getTimestamp());
        }

    @Override
    public IRandomFamily.IIRandomFamilyRandomDataInput deserializeFrom(InputStream in) throws IOException {
        RandomFamily.IRandomFamilyRandomDataInput result = new RandomFamily.IRandomFamilyRandomDataInput();
        SIRandomFamilyRandomDataInput tmp = SIRandomFamilyRandomDataInput.parseDelimitedFrom(in);
        result.setRandomInteger(tmp.getRandomInteger());
        result.setTimestamp(tmp.getTimestamp());
        return result;
    }

        @Override
        public IRandomFamily.IIRandomFamilyRandomDataInput deserializeFrom(IDataInput in) throws IOException {
            RandomFamily.IRandomFamilyRandomDataInput result = new RandomFamily.IRandomFamilyRandomDataInput();
            result.setRandomInteger(in.nextInt());
            result.setTimestamp(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, RandomFamily.IRandomFamilyRandomDataInput object) {
        output.writeInt(object.getRandomInteger());
        output.writeLong(object.getTimestamp());
    }

    @Override
    public RandomFamily.IRandomFamilyRandomDataInput read(Kryo kryo, Input input, Class<RandomFamily.IRandomFamilyRandomDataInput> type) {
        RandomFamily.IRandomFamilyRandomDataInput result = new RandomFamily.IRandomFamilyRandomDataInput();
        result.setRandomInteger(input.readInt());
        result.setTimestamp(input.readLong());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link IRandomFamily.IIRandomFamilyRandomDataOutput} algorithm.
 */
public static class IRandomFamilyRandomDataOutputSerializer extends Serializer<RandomFamily.IRandomFamilyRandomDataOutput> implements ISerializer<IRandomFamily.IIRandomFamilyRandomDataOutput> {

    @Override
    public void serializeTo(IRandomFamily.IIRandomFamilyRandomDataOutput object, OutputStream out) throws IOException {
        SIRandomFamilyRandomDataOutput tmp = SIRandomFamilyRandomDataOutput.newBuilder()
            .setRandomInteger(object.getRandomInteger())
            .setTimestamp(object.getTimestamp())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(IRandomFamily.IIRandomFamilyRandomDataOutput object, IDataOutput out) throws IOException {
            out.writeInt(object.getRandomInteger());
            out.writeLong(object.getTimestamp());
        }

    @Override
    public IRandomFamily.IIRandomFamilyRandomDataOutput deserializeFrom(InputStream in) throws IOException {
        RandomFamily.IRandomFamilyRandomDataOutput result = new RandomFamily.IRandomFamilyRandomDataOutput();
        SIRandomFamilyRandomDataOutput tmp = SIRandomFamilyRandomDataOutput.parseDelimitedFrom(in);
        result.setRandomInteger(tmp.getRandomInteger());
        result.setTimestamp(tmp.getTimestamp());
        return result;
    }

        @Override
        public IRandomFamily.IIRandomFamilyRandomDataOutput deserializeFrom(IDataInput in) throws IOException {
            RandomFamily.IRandomFamilyRandomDataOutput result = new RandomFamily.IRandomFamilyRandomDataOutput();
            result.setRandomInteger(in.nextInt());
            result.setTimestamp(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, RandomFamily.IRandomFamilyRandomDataOutput object) {
        output.writeInt(object.getRandomInteger());
        output.writeLong(object.getTimestamp());
    }

    @Override
    public RandomFamily.IRandomFamilyRandomDataOutput read(Kryo kryo, Input input, Class<RandomFamily.IRandomFamilyRandomDataOutput> type) {
        RandomFamily.IRandomFamilyRandomDataOutput result = new RandomFamily.IRandomFamilyRandomDataOutput();
        result.setRandomInteger(input.readInt());
        result.setTimestamp(input.readLong());
        return result;
    }
}

}
