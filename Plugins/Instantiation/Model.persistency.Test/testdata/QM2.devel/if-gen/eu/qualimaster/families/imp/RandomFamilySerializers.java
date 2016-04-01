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

import eu.qualimaster.protos.RandomFamilyProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IRandomFamily" (GEN).
 */
@Generated(value="EASy-Producer")
public class RandomFamilySerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link RandomFamily.IRandomFamilyRandomDataInput} algorithm.
     */
    public class IRandomFamilyRandomDataInputSerializer extends Serializer<RandomFamily.IRandomFamilyRandomDataInput> implements ISerializer<RandomFamily.IRandomFamilyRandomDataInput> {

        @Override
        public void serializeTo(RandomFamily.IRandomFamilyRandomDataInput object, OutputStream out) throws IOException {
            SIRandomFamilyRandomDataInput tmp = SIRandomFamilyRandomDataInput.newBuilder()
                .setRandomInteger(object.getRandomInteger())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public RandomFamily.IRandomFamilyRandomDataInput deserializeFrom(InputStream in) throws IOException {
            RandomFamily.IRandomFamilyRandomDataInput result = new RandomFamily.IRandomFamilyRandomDataInput();
            SIRandomFamilyRandomDataInput tmp = SIRandomFamilyRandomDataInput.parseDelimitedFrom(in);
            result.setRandomInteger(tmp.getRandomInteger());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, RandomFamily.IRandomFamilyRandomDataInput object) {
            output.writeInt(object.getRandomInteger());
        }

        @Override
        public RandomFamily.IRandomFamilyRandomDataInput read(Kryo kryo, Input input, Class<RandomFamily.IRandomFamilyRandomDataInput> type) {
            RandomFamily.IRandomFamilyRandomDataInput result = new RandomFamily.IRandomFamilyRandomDataInput();
            result.setRandomInteger(input.readInt());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link RandomFamily.IRandomFamilyProccessedDataOutput} algorithm.
     */
    public class IRandomFamilyProccessedDataOutputSerializer extends Serializer<RandomFamily.IRandomFamilyProccessedDataOutput> implements ISerializer<RandomFamily.IRandomFamilyProccessedDataOutput> {

        @Override
        public void serializeTo(RandomFamily.IRandomFamilyProccessedDataOutput object, OutputStream out) throws IOException {
            SIRandomFamilyProccessedDataOutput tmp = SIRandomFamilyProccessedDataOutput.newBuilder()
                .setRandomInteger(object.getRandomInteger())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public RandomFamily.IRandomFamilyProccessedDataOutput deserializeFrom(InputStream in) throws IOException {
            RandomFamily.IRandomFamilyProccessedDataOutput result = new RandomFamily.IRandomFamilyProccessedDataOutput();
            SIRandomFamilyProccessedDataOutput tmp = SIRandomFamilyProccessedDataOutput.parseDelimitedFrom(in);
            result.setRandomInteger(tmp.getRandomInteger());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, RandomFamily.IRandomFamilyProccessedDataOutput object) {
            output.writeInt(object.getRandomInteger());
        }

        @Override
        public RandomFamily.IRandomFamilyProccessedDataOutput read(Kryo kryo, Input input, Class<RandomFamily.IRandomFamilyProccessedDataOutput> type) {
            RandomFamily.IRandomFamilyProccessedDataOutput result = new RandomFamily.IRandomFamilyProccessedDataOutput();
            result.setRandomInteger(input.readInt());
            return result;
        }
    }

}
