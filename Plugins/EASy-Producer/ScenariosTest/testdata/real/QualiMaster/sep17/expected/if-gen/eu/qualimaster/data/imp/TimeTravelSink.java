package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.ITimeTravelSink;
import eu.qualimaster.data.inf.ITimeTravelSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
* Define the data source class(GEN).
**/
public class TimeTravelSink implements ITimeTravelSink{

    /**
    * Define the source data input interface.
    **/
    public static class TimeTravelSinkSnapshotStreamInput implements ITimeTravelSinkSnapshotStreamInput {
        private String snapshot;
        /**
        * Returns the input value for tuple field "snapshot".
        * @return the tuple value
        */
        @Override
        public String getSnapshot() {
            return snapshot;
        }

        /**
        * Sets the output value for tuple field "snapshot".
        * @param snapshot the field value
        */
        @Override
        public void setSnapshot(String snapshot) {
            this.snapshot = snapshot;
        }
        static {
            SerializerRegistry.register("TimeTravelSinkSnapshotStreamInput", TimeTravelSinkSerializers.TimeTravelSinkSnapshotStreamInputSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class TimeTravelSinkPathStreamInput implements ITimeTravelSinkPathStreamInput {
        private String path;
        /**
        * Returns the input value for tuple field "path".
        * @return the tuple value
        */
        @Override
        public String getPath() {
            return path;
        }

        /**
        * Sets the output value for tuple field "path".
        * @param path the field value
        */
        @Override
        public void setPath(String path) {
            this.path = path;
        }
        static {
            SerializerRegistry.register("TimeTravelSinkPathStreamInput", TimeTravelSinkSerializers.TimeTravelSinkPathStreamInputSerializer.class);
        }
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data TimeTravelSinkSnapshotStreamInput
    **/
    @Override
    public void postDataSnapshotStream(ITimeTravelSinkSnapshotStreamInput data) {
    }

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple ITimeTravelSinkSnapshotStreamInput to be emitted 
    **/
    public void emit(int ticket, ITimeTravelSinkSnapshotStreamInput tuple) {
    }

    /**
    * Posts a specific type of data sink.
    * @param data the sink data TimeTravelSinkPathStreamInput
    **/
    @Override
    public void postDataPathStream(ITimeTravelSinkPathStreamInput data) {
    }

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple ITimeTravelSinkPathStreamInput to be emitted 
    **/
    public void emit(int ticket, ITimeTravelSinkPathStreamInput tuple) {
    }

    @Override
    public void connect() {}

    @Override
    public void disconnect(){}

    @Override
    public void setStrategy(IStorageStrategyDescriptor strategy) {}

    @Override
    public IStorageStrategyDescriptor getStrategy() { return NoStorageStrategyDescriptor.INSTANCE;}

    @Override
    public Double getMeasurement(IObservable observable) { return null;}
}
