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

import eu.qualimaster.protos.SwitchFamilyProtos.*;
/**
 * The implementation of the serializers for the algorithm family "ISwitchFamily" (GEN).
 */
@Generated(value="EASy-Producer")
public class SwitchFamilySerializers {

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data input for the {@link SwitchFamily.ISwitchFamilyRandomDataInput} algorithm.
     */
    public class ISwitchFamilyRandomDataInputSerializer extends Serializer<SwitchFamily.ISwitchFamilyRandomDataInput> implements ISerializer<SwitchFamily.ISwitchFamilyRandomDataInput> {

        @Override
        public void serializeTo(SwitchFamily.ISwitchFamilyRandomDataInput object, OutputStream out) throws IOException {
            SISwitchFamilyRandomDataInput tmp = SISwitchFamilyRandomDataInput.newBuilder()
                .setRandomInteger(object.getRandomInteger())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public SwitchFamily.ISwitchFamilyRandomDataInput deserializeFrom(InputStream in) throws IOException {
            SwitchFamily.ISwitchFamilyRandomDataInput result = new SwitchFamily.ISwitchFamilyRandomDataInput();
            SISwitchFamilyRandomDataInput tmp = SISwitchFamilyRandomDataInput.parseDelimitedFrom(in);
            result.setRandomInteger(tmp.getRandomInteger());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, SwitchFamily.ISwitchFamilyRandomDataInput object) {
            output.writeInt(object.getRandomInteger());
        }

        @Override
        public SwitchFamily.ISwitchFamilyRandomDataInput read(Kryo kryo, Input input, Class<SwitchFamily.ISwitchFamilyRandomDataInput> type) {
            SwitchFamily.ISwitchFamilyRandomDataInput result = new SwitchFamily.ISwitchFamilyRandomDataInput();
            result.setRandomInteger(input.readInt());
            return result;
        }
    }

    /**
     * Provides a serializer (supports both Kyro and Protobuf) for the default implementation of the data output for the {@link SwitchFamily.ISwitchFamilyProccessedDataOutput} algorithm.
     */
    public class ISwitchFamilyProccessedDataOutputSerializer extends Serializer<SwitchFamily.ISwitchFamilyProccessedDataOutput> implements ISerializer<SwitchFamily.ISwitchFamilyProccessedDataOutput> {

        @Override
        public void serializeTo(SwitchFamily.ISwitchFamilyProccessedDataOutput object, OutputStream out) throws IOException {
            SISwitchFamilyProccessedDataOutput tmp = SISwitchFamilyProccessedDataOutput.newBuilder()
                .setRandomInteger(object.getRandomInteger())
                .build();
            tmp.writeDelimitedTo(out);
        }

        @Override
        public SwitchFamily.ISwitchFamilyProccessedDataOutput deserializeFrom(InputStream in) throws IOException {
            SwitchFamily.ISwitchFamilyProccessedDataOutput result = new SwitchFamily.ISwitchFamilyProccessedDataOutput();
            SISwitchFamilyProccessedDataOutput tmp = SISwitchFamilyProccessedDataOutput.parseDelimitedFrom(in);
            result.setRandomInteger(tmp.getRandomInteger());
            return result;
        }

        @Override
        public void write(Kryo kryo, Output output, SwitchFamily.ISwitchFamilyProccessedDataOutput object) {
            output.writeInt(object.getRandomInteger());
        }

        @Override
        public SwitchFamily.ISwitchFamilyProccessedDataOutput read(Kryo kryo, Input input, Class<SwitchFamily.ISwitchFamilyProccessedDataOutput> type) {
            SwitchFamily.ISwitchFamilyProccessedDataOutput result = new SwitchFamily.ISwitchFamilyProccessedDataOutput();
            result.setRandomInteger(input.readInt());
            return result;
        }
    }

}
