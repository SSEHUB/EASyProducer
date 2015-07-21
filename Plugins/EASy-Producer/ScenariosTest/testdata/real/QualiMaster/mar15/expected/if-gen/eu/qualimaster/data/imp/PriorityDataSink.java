package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IPriorityDataSink.*;

/**
* Define the data source class(GEN).
**/
public class PriorityDataSink {

    /**
    * Define the source data input interface.
    **/
    public static class PriorityDataSinkPairwiseFinancialInput implements IPriorityDataSinkPairwiseFinancialInput {
        private String pairwiseCorrelationFinancial;
        /**
        * Returns the input value for tuple field "pairwiseCorrelationFinancial".
        * @return the tuple value
        */
        @Override
        public String getPairwiseCorrelationFinancial(){
            return pairwiseCorrelationFinancial;
        }

        /**
        * Sets the output value for tuple field "pairwiseCorrelationFinancial".
        * @param pairwiseCorrelationFinancial the field value
        */
        @Override
        public void setPairwiseCorrelationFinancial(String pairwiseCorrelationFinancial){
            this.pairwiseCorrelationFinancial = pairwiseCorrelationFinancial;
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class PriorityDataSinkPairwiseTwitterInput implements IPriorityDataSinkPairwiseTwitterInput {
        private String pairwiseCorrelationTwitter;
        /**
        * Returns the input value for tuple field "pairwiseCorrelationTwitter".
        * @return the tuple value
        */
        @Override
        public String getPairwiseCorrelationTwitter(){
            return pairwiseCorrelationTwitter;
        }

        /**
        * Sets the output value for tuple field "pairwiseCorrelationTwitter".
        * @param pairwiseCorrelationTwitter the field value
        */
        @Override
        public void setPairwiseCorrelationTwitter(String pairwiseCorrelationTwitter){
            this.pairwiseCorrelationTwitter = pairwiseCorrelationTwitter;
        }
    }


    /**
    * Returns a specific type of data sink.
    * @return PriorityDataSinkPairwiseFinancialInput the sink data
    **/
    public PriorityDataSinkPairwiseFinancialInput getDataPairwiseFinancial() {
        return null;
    }
    /**
    * Returns a specific type of data sink.
    * @return PriorityDataSinkPairwiseTwitterInput the sink data
    **/
    public PriorityDataSinkPairwiseTwitterInput getDataPairwiseTwitter() {
        return null;
    }
}
