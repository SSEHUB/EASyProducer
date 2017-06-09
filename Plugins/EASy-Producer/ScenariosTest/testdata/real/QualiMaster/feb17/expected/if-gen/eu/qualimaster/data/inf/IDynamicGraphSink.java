package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sinks.IDataSink;

/**
* Define the data sink interface(GEN).
**/
public interface IDynamicGraphSink extends IDataSink {

    /**
    * Define the sink data input interface.
    **/
    public static interface IDynamicGraphSinkHubStreamInput extends Serializable {
        /**
         * Returns the input value for tuple field "hubList".
         * @return the tuple value
         */
        public String getHubList();

        /**
         * Sets the output value for tuple field "hubList".
         * @param hubList the field value
         */
        public void setHubList(String hubList);
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data IDynamicGraphSinkHubStreamInput 
    **/
    public void postDataHubStream(IDynamicGraphSinkHubStreamInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IDynamicGraphSinkHubStreamInput to be emitted 
    **/
    public void emit(int ticket, IDynamicGraphSinkHubStreamInput tuple);

}
