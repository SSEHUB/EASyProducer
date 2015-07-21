package eu.qualimaster.data.imp;

import java.io.Serializable;
import eu.qualimaster.data.inf.IPriorityDataSink.*;

/**
* Define the data source class(GEN).
**/
public class PriorityDataSink {

    /**
    * Define the source data input interface.
    **/
    public static class PriorityDataSink1Input implements IPriorityDataSink1Input {
        private static final long serialVersionUID = 1L;
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
    public static class PriorityDataSink2Input implements IPriorityDataSink2Input {
        private static final long serialVersionUID = 1L;
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
    * @return PriorityDataSink1Input the sink data
    **/
    public PriorityDataSink1Input getData1() {
        return null;
    }
    /**
    * Returns a specific type of data sink.
    * @return PriorityDataSink2Input the sink data
    **/
    public PriorityDataSink2Input getData2() {
        return null;
    }
}
