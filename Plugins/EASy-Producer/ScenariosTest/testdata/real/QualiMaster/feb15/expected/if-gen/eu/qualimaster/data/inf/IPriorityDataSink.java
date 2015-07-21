package eu.qualimaster.data.inf;

import java.io.Serializable;

/**
* Define the data sink interface(GEN).
**/
public interface IPriorityDataSink {

    /**
    * Define the sink data input interface.
    **/
    public static interface IPriorityDataSink1Input extends Serializable {
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
    public static interface IPriorityDataSink2Input extends Serializable {
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
    * @return IPriorityDataSink1Input the sink data
    **/
    public void postData1(IPriorityDataSink1Input data);
    /**
    * Returns a specific type of data sink.
    * @return IPriorityDataSink2Input the sink data
    **/
    public void postData2(IPriorityDataSink2Input data);
}
