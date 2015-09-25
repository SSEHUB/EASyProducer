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
    public static interface IPriorityDataSinkPairwiseTwitterInput extends Serializable {
        /**
         * Returns the input value for tuple field "pairwiseCorrelationTwitter".
         * @return the tuple value
         */
        public String getPairwiseCorrelationTwitter();

        /**
         * Sets the output value for tuple field "pairwiseCorrelationTwitter".
         * @param pairwiseCorrelationTwitter the field value
         */
        public void setPairwiseCorrelationTwitter(String pairwiseCorrelationTwitter);
    }


    /**
    * Posts a specific type of data sink.
    * @param data the sink data IPriorityDataSinkPairwiseFinancialInput 
    **/
    public void postDataPairwiseFinancial(IPriorityDataSinkPairwiseFinancialInput data);
    /**
    * Posts a specific type of data sink.
    * @param data the sink data IPriorityDataSinkPairwiseTwitterInput 
    **/
    public void postDataPairwiseTwitter(IPriorityDataSinkPairwiseTwitterInput data);
}
