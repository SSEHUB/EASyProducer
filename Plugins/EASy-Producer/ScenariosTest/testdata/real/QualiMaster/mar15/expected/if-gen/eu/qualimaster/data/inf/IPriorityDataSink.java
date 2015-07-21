package eu.qualimaster.data.inf;

import java.io.Serializable;

/**
* Define the data sink interface(GEN).
**/
public interface IPriorityDataSink {

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
    * Returns a specific type of data sink.
    * @return IPriorityDataSinkPairwiseFinancialInput the sink data
    **/
    public void postDataPairwiseFinancial(IPriorityDataSinkPairwiseFinancialInput data);
    /**
    * Returns a specific type of data sink.
    * @return IPriorityDataSinkPairwiseTwitterInput the sink data
    **/
    public void postDataPairwiseTwitter(IPriorityDataSinkPairwiseTwitterInput data);
}
