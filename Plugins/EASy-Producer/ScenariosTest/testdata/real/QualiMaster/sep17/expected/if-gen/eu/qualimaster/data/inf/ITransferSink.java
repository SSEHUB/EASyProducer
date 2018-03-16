package eu.qualimaster.data.inf;

import java.io.Serializable;
import eu.qualimaster.dataManagement.sinks.IDataSink;

/**
* Define the data sink interface(GEN).
**/
public interface ITransferSink extends IDataSink {

    /**
    * Define the sink data input interface.
    **/
    public static interface ITransferSinkPairwiseFinancialInput extends Serializable {
        /**
         * Returns the input value for tuple field "id0".
         * @return the tuple value
         */
        public String getId0();

        /**
         * Sets the output value for tuple field "id0".
         * @param id0 the field value
         */
        public void setId0(String id0);
        /**
         * Returns the input value for tuple field "id1".
         * @return the tuple value
         */
        public String getId1();

        /**
         * Sets the output value for tuple field "id1".
         * @param id1 the field value
         */
        public void setId1(String id1);
        /**
         * Returns the input value for tuple field "date".
         * @return the tuple value
         */
        public String getDate();

        /**
         * Sets the output value for tuple field "date".
         * @param date the field value
         */
        public void setDate(String date);
        /**
         * Returns the input value for tuple field "value".
         * @return the tuple value
         */
        public double getValue();

        /**
         * Sets the output value for tuple field "value".
         * @param value the field value
         */
        public void setValue(double value);
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data ITransferSinkPairwiseFinancialInput 
    **/
    public void postDataPairwiseFinancial(ITransferSinkPairwiseFinancialInput data);

    /**
    * Emits tuple along with a ticket.
    * @param ticket the ticket to identify the responses for application
    * @param tuple the tuple ITransferSinkPairwiseFinancialInput to be emitted 
    **/
    public void emit(int ticket, ITransferSinkPairwiseFinancialInput tuple);

}
