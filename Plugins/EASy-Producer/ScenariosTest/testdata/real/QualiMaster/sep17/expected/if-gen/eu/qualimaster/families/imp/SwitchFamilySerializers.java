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
import eu.qualimaster.families.imp.SwitchFamily;
import eu.qualimaster.families.inf.*;

import eu.qualimaster.protos.SwitchFamilyProtos.*;
/**
 * The implementation of the serializers for the algorithm family "ISwitchFamily" (GEN).
 */
@Generated(value="EASy-Producer")
public class SwitchFamilySerializers {

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link ISwitchFamily.IISwitchFamilyRandomDataInput} algorithm.
 */
public static class ISwitchFamilyRandomDataInputSerializer extends Serializer<SwitchFamily.ISwitchFamilyRandomDataInput> implements ISerializer<ISwitchFamily.IISwitchFamilyRandomDataInput> {

    @Override
    public void serializeTo(ISwitchFamily.IISwitchFamilyRandomDataInput object, OutputStream out) throws IOException {
        SISwitchFamilyRandomDataInput tmp = SISwitchFamilyRandomDataInput.newBuilder()
            .setRandomInteger(object.getRandomInteger())
            .setTimestamp(object.getTimestamp())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(ISwitchFamily.IISwitchFamilyRandomDataInput object, IDataOutput out) throws IOException {
            out.writeInt(object.getRandomInteger());
            out.writeLong(object.getTimestamp());
        }

    @Override
    public ISwitchFamily.IISwitchFamilyRandomDataInput deserializeFrom(InputStream in) throws IOException {
        SwitchFamily.ISwitchFamilyRandomDataInput result = new SwitchFamily.ISwitchFamilyRandomDataInput();
        SISwitchFamilyRandomDataInput tmp = SISwitchFamilyRandomDataInput.parseDelimitedFrom(in);
        result.setRandomInteger(tmp.getRandomInteger());
        result.setTimestamp(tmp.getTimestamp());
        return result;
    }

        @Override
        public ISwitchFamily.IISwitchFamilyRandomDataInput deserializeFrom(IDataInput in) throws IOException {
            SwitchFamily.ISwitchFamilyRandomDataInput result = new SwitchFamily.ISwitchFamilyRandomDataInput();
            result.setRandomInteger(in.nextInt());
            result.setTimestamp(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SwitchFamily.ISwitchFamilyRandomDataInput object) {
        output.writeInt(object.getRandomInteger());
        output.writeLong(object.getTimestamp());
    }

    @Override
    public SwitchFamily.ISwitchFamilyRandomDataInput read(Kryo kryo, Input input, Class<SwitchFamily.ISwitchFamilyRandomDataInput> type) {
        SwitchFamily.ISwitchFamilyRandomDataInput result = new SwitchFamily.ISwitchFamilyRandomDataInput();
        result.setRandomInteger(input.readInt());
        result.setTimestamp(input.readLong());
        return result;
    }
}

/**
 * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link ISwitchFamily.IISwitchFamilyRandomDataOutput} algorithm.
 */
public static class ISwitchFamilyRandomDataOutputSerializer extends Serializer<SwitchFamily.ISwitchFamilyRandomDataOutput> implements ISerializer<ISwitchFamily.IISwitchFamilyRandomDataOutput> {

    @Override
    public void serializeTo(ISwitchFamily.IISwitchFamilyRandomDataOutput object, OutputStream out) throws IOException {
        SISwitchFamilyRandomDataOutput tmp = SISwitchFamilyRandomDataOutput.newBuilder()
            .setRandomInteger(object.getRandomInteger())
            .setTimestamp(object.getTimestamp())
            .build();
        tmp.writeDelimitedTo(out);
    }

        @Override
        public void serializeTo(ISwitchFamily.IISwitchFamilyRandomDataOutput object, IDataOutput out) throws IOException {
            out.writeInt(object.getRandomInteger());
            out.writeLong(object.getTimestamp());
        }

    @Override
    public ISwitchFamily.IISwitchFamilyRandomDataOutput deserializeFrom(InputStream in) throws IOException {
        SwitchFamily.ISwitchFamilyRandomDataOutput result = new SwitchFamily.ISwitchFamilyRandomDataOutput();
        SISwitchFamilyRandomDataOutput tmp = SISwitchFamilyRandomDataOutput.parseDelimitedFrom(in);
        result.setRandomInteger(tmp.getRandomInteger());
        result.setTimestamp(tmp.getTimestamp());
        return result;
    }

        @Override
        public ISwitchFamily.IISwitchFamilyRandomDataOutput deserializeFrom(IDataInput in) throws IOException {
            SwitchFamily.ISwitchFamilyRandomDataOutput result = new SwitchFamily.ISwitchFamilyRandomDataOutput();
            result.setRandomInteger(in.nextInt());
            result.setTimestamp(in.nextLong());
            return result;
        }

    @Override
    public void write(Kryo kryo, Output output, SwitchFamily.ISwitchFamilyRandomDataOutput object) {
        output.writeInt(object.getRandomInteger());
        output.writeLong(object.getTimestamp());
    }

    @Override
    public SwitchFamily.ISwitchFamilyRandomDataOutput read(Kryo kryo, Input input, Class<SwitchFamily.ISwitchFamilyRandomDataOutput> type) {
        SwitchFamily.ISwitchFamilyRandomDataOutput result = new SwitchFamily.ISwitchFamilyRandomDataOutput();
        result.setRandomInteger(input.readInt());
        result.setTimestamp(input.readLong());
        return result;
    }
}

}
