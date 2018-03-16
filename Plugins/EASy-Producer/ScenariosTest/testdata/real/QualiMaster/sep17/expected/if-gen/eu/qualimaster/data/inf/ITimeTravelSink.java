package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sinks.IDataSink;

/**
* Define the data sink interface(GEN).
**/
public interface ITimeTravelSink extends IDataSink {

    /**
    * Define the sink data input interface.
    **/
    public static interface ITimeTravelSinkSnapshotStreamInput extends Serializable {
        /**
         * Returns the input value for tuple field "snapshot".
         * @return the tuple value
         */
        public String getSnapshot();

        /**
         * Sets the output value for tuple field "snapshot".
         * @param snapshot the field value
         */
        public void setSnapshot(String snapshot);
    }
    /**
    * Define the sink data input interface.
    **/
    public static interface ITimeTravelSinkPathStreamInput extends Serializable {
        /**
         * Returns the input value for tuple field "path".
         * @return the tuple value
         */
        public String getPath();

        /**
         * Sets the output value for tuple field "path".
         * @param path the field value
         */
        public void setPath(String path);
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data ITimeTravelSinkSnapshotStreamInput 
    **/
    public void postDataSnapshotStream(ITimeTravelSinkSnapshotStreamInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple ITimeTravelSinkSnapshotStreamInput to be emitted 
    **/
    public void emit(int ticket, ITimeTravelSinkSnapshotStreamInput tuple);

    /**
    * Posts a specific type of data sink.
    * @param data the sink data ITimeTravelSinkPathStreamInput 
    **/
    public void postDataPathStream(ITimeTravelSinkPathStreamInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple ITimeTravelSinkPathStreamInput to be emitted 
    **/
    public void emit(int ticket, ITimeTravelSinkPathStreamInput tuple);

}
