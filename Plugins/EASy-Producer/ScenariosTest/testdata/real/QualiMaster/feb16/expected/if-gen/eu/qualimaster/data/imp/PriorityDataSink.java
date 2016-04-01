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
    public static class PriorityDataSinkAnalyzedStreamInput implements IPriorityDataSinkAnalyzedStreamInput {
        private String symbolId;
        private long timestamp;
        private double value;
        private int volume;
        /**
        * Returns the input value for tuple field "symbolId".
        * @return the tuple value
        */
        @Override
        public String getSymbolId(){
            return symbolId;
        }

        /**
        * Sets the output value for tuple field "symbolId".
        * @param symbolId the field value
        */
        @Override
        public void setSymbolId(String symbolId){
            this.symbolId = symbolId;
        }
        /**
        * Returns the input value for tuple field "timestamp".
        * @return the tuple value
        */
        @Override
        public long getTimestamp(){
            return timestamp;
        }

        /**
        * Sets the output value for tuple field "timestamp".
        * @param timestamp the field value
        */
        @Override
        public void setTimestamp(long timestamp){
            this.timestamp = timestamp;
        }
        /**
        * Returns the input value for tuple field "value".
        * @return the tuple value
        */
        @Override
        public double getValue(){
            return value;
        }

        /**
        * Sets the output value for tuple field "value".
        * @param value the field value
        */
        @Override
        public void setValue(double value){
            this.value = value;
        }
        /**
        * Returns the input value for tuple field "volume".
        * @return the tuple value
        */
        @Override
        public int getVolume(){
            return volume;
        }

        /**
        * Sets the output value for tuple field "volume".
        * @param volume the field value
        */
        @Override
        public void setVolume(int volume){
            this.volume = volume;
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
    * @param data the sink data PriorityDataSinkAnalyzedStreamInput
    **/
    @Override
    public void postDataAnalyzedStream(IPriorityDataSinkAnalyzedStreamInput data) {
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
