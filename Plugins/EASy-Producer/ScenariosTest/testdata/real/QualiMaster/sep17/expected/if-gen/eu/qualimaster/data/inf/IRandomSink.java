package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sinks.IDataSink;

/**
* Define the data sink interface(GEN).
**/
public interface IRandomSink extends IDataSink {

    /**
    * Define the sink data input interface.
    **/
    public static interface IRandomSinkRandomDataInput extends Serializable {
        /**
         * Returns the input value for tuple field "randomInteger".
         * @return the tuple value
         */
        public int getRandomInteger();

        /**
         * Sets the output value for tuple field "randomInteger".
         * @param randomInteger the field value
         */
        public void setRandomInteger(int randomInteger);
        /**
         * Returns the input value for tuple field "timestamp".
         * @return the tuple value
         */
        public long getTimestamp();

        /**
         * Sets the output value for tuple field "timestamp".
         * @param timestamp the field value
         */
        public void setTimestamp(long timestamp);
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data IRandomSinkRandomDataInput 
    **/
    public void postDataRandomData(IRandomSinkRandomDataInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IRandomSinkRandomDataInput to be emitted 
    **/
    public void emit(int ticket, IRandomSinkRandomDataInput tuple);

}
