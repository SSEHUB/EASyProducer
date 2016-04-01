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

import eu.qualimaster.protos.AggregateFamilyProtos.*;
/**
 * The implementation of the serializers for the algorithm family "IAggregateFamily" (GEN).
 */
@Generated(value="EASy-Producer")
public class AggregateFamilySerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link AggregateFamily.IAggregateFamilyRandomDataInput} algorithm.
     */
    public class IAggregateFamilyRandomDataInputSerializer extends Serializer<AggregateFamily.IAggregateFamilyRandomDataInput> implements ISerializer<AggregateFamily.IAggregateFamilyRandomDataInput> {

        @Override
        public void serializeTo(AggregateFamily.IAggregateFamilyRandomDataInput object, OutputStream out) throws IOException {
            SIAggregateFamilyRandomDataInput tmp = SIAggregateFamilyRandomDataInput.newBuilder()
                .setRandomInteger(object.getRandomInteger())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public AggregateFamily.IAggregateFamilyRandomDataInput deserializeFrom(InputStream in) throws IOException {
            AggregateFamily.IAggregateFamilyRandomDataInput result = new AggregateFamily.IAggregateFamilyRandomDataInput();
            SIAggregateFamilyRandomDataInput tmp = SIAggregateFamilyRandomDataInput.parseDelimitedFrom(in);
            result.setRandomInteger(tmp.getRandomInteger());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, AggregateFamily.IAggregateFamilyRandomDataInput object) {
            output.writeInt(object.getRandomInteger());
        }

        @Override
        public AggregateFamily.IAggregateFamilyRandomDataInput read(Kryo kryo, Input input, Class<AggregateFamily.IAggregateFamilyRandomDataInput> type) {
            AggregateFamily.IAggregateFamilyRandomDataInput result = new AggregateFamily.IAggregateFamilyRandomDataInput();
            result.setRandomInteger(input.readInt());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link AggregateFamily.IAggregateFamilyRandomDataOutput} algorithm.
     */
    public class IAggregateFamilyRandomDataOutputSerializer extends Serializer<AggregateFamily.IAggregateFamilyRandomDataOutput> implements ISerializer<AggregateFamily.IAggregateFamilyRandomDataOutput> {

        @Override
        public void serializeTo(AggregateFamily.IAggregateFamilyRandomDataOutput object, OutputStream out) throws IOException {
            SIAggregateFamilyRandomDataOutput tmp = SIAggregateFamilyRandomDataOutput.newBuilder()
                .setRandomInteger(object.getRandomInteger())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public AggregateFamily.IAggregateFamilyRandomDataOutput deserializeFrom(InputStream in) throws IOException {
            AggregateFamily.IAggregateFamilyRandomDataOutput result = new AggregateFamily.IAggregateFamilyRandomDataOutput();
            SIAggregateFamilyRandomDataOutput tmp = SIAggregateFamilyRandomDataOutput.parseDelimitedFrom(in);
            result.setRandomInteger(tmp.getRandomInteger());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, AggregateFamily.IAggregateFamilyRandomDataOutput object) {
            output.writeInt(object.getRandomInteger());
        }

        @Override
        public AggregateFamily.IAggregateFamilyRandomDataOutput read(Kryo kryo, Input input, Class<AggregateFamily.IAggregateFamilyRandomDataOutput> type) {
            AggregateFamily.IAggregateFamilyRandomDataOutput result = new AggregateFamily.IAggregateFamilyRandomDataOutput();
            result.setRandomInteger(input.readInt());
            return result;
        }
    }

}
