package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IPriorityDataSink;
import eu.qualimaster.data.inf.IPriorityDataSink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;

/**
* Define the data source class(GEN).
**/
public class PriorityDataSink implements IPriorityDataSink{

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
    * Posts a specific type of data sink.
    * @param data the sink data PriorityDataSinkPairwiseFinancialInput
    **/
    @Override
    public void postDataPairwiseFinancial(IPriorityDataSinkPairwiseFinancialInput data) {
    }
    /**
    * Posts a specific type of data sink.
    * @param data the sink data PriorityDataSinkPairwiseTwitterInput
    **/
    @Override
    public void postDataPairwiseTwitter(IPriorityDataSinkPairwiseTwitterInput data) {
    }
    @Override
    public void connect() {}

    @Override
    public void disconnect(){}

    @Override
    public void setStrategy(IStorageStrategyDescriptor strategy) {}

    @Override
    public IStorageStrategyDescriptor getStrategy() { return NoStorageStrategyDescriptor.INSTANCE;}

    @Override
    public Double getMeasurement(IObservable observable) { return null;}
}
