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
         * Returns the input value for tuple field "pairwiseCorrelationFinancial".
         * @return the tuple value
         */
        public String getPairwiseCorrelationFinancial();

        /**
         * Sets the output value for tuple field "pairwiseCorrelationFinancial".
         * @param pairwiseCorrelationFinancial the field value
         */
        public void setPairwiseCorrelationFinancial(String pairwiseCorrelationFinancial);
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
         * Sets the output value for tuple field "symbolId".
         * @param symbolId the field value
         */
        public void setSymbolId(String symbolId);
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
        /**
         * Returns the input value for tuple field "volume".
         * @return the tuple value
         */
        public int getVolume();

        /**
         * Sets the output value for tuple field "volume".
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
    * Posts a specific type of data sink.
    * @param data the sink data IPriorityDataSinkAnalyzedStreamInput 
    **/
    public void postDataAnalyzedStream(IPriorityDataSinkAnalyzedStreamInput data);
}
