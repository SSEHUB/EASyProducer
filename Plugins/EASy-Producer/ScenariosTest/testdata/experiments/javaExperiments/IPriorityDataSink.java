package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sinks.IDataSink;

/**
* Define the data sink interface(GEN).
**/
public interface IPriorityDataSink extends IDataSink {

    /**
    * Define the sink data input interface.
    **/
    public static interface IPriorityDataSinkPairwiseFinancialInput extends Serializable {
        /**
         * Returns the input value for tuple field "id0".
         * @return the tuple value
         */
        public String getId0();

        /**
         * Changes the output value for tuple field "id0".
         * @param id0 the field value
         */
        public void setId0(String id0);
        /**
         * Returns the input value for tuple field "id1".
         * @return the tuple value
         */
        public String getId1();

        /**
         * Changes the output value for tuple field "id1".
         * @param id1 the field value
         */
        public void setId1(String id1);
        /**
         * Returns the input value for tuple field "date".
         * @return the tuple value
         */
        public String getDate();

        /**
         * Changes the output value for tuple field "date".
         * @param date the field value
         */
        public void setDate(String date);
        /**
         * Returns the input value for tuple field "value".
         * @return the tuple value
         */
        public double getValue();

        /**
         * Changes the output value for tuple field "value".
         * @param value the field value
         */
        public void setValue(double value);
    }
    /**
    * Define the sink data input interface.
    **/
    public static interface IPriorityDataSinkAnalyzedStreamInput extends Serializable {
        /**
         * Returns the input value for tuple field "symbolId".
         * @return the tuple value
         */
        public String getSymbolId();

        /**
         * Changes the output value for tuple field "symbolId".
         * @param symbolId the field value
         */
        public void setSymbolId(String symbolId);
        /**
         * Returns the input value for tuple field "timestamp".
         * @return the tuple value
         */
        public long getTimestamp();

        /**
         * Changes the output value for tuple field "timestamp".
         * @param timestamp the field value
         */
        public void setTimestamp(long timestamp);
        /**
         * Returns the input value for tuple field "value".
         * @return the tuple value
         */
        public double getValue();

        /**
         * Changes the output value for tuple field "value".
         * @param value the field value
         */
        public void setValue(double value);
        /**
         * Returns the input value for tuple field "volume".
         * @return the tuple value
         */
        public int getVolume();

        /**
         * Changes the output value for tuple field "volume".
         * @param volume the field value
         */
        public void setVolume(int volume);
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data IPriorityDataSinkPairwiseFinancialInput 
    **/
    public void postDataPairwiseFinancial(IPriorityDataSinkPairwiseFinancialInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IPriorityDataSinkPairwiseFinancialInput to be emitted 
    **/
    public void emit(int ticket, IPriorityDataSinkPairwiseFinancialInput tuple);

    /**
    * Posts a specific type of data sink.
    * @param data the sink data IPriorityDataSinkAnalyzedStreamInput 
    **/
    public void postDataAnalyzedStream(IPriorityDataSinkAnalyzedStreamInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple IPriorityDataSinkAnalyzedStreamInput to be emitted 
    **/
    public void emit(int ticket, IPriorityDataSinkAnalyzedStreamInput tuple);
 
}
