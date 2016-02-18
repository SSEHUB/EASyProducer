package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.IMI_data_Sink;
import eu.qualimaster.data.inf.IMI_data_Sink.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;

/**
* Define the data source class(GEN).
**/
public class MI_data_Sink implements IMI_data_Sink{

    /**
    * Define the source data input interface.
    **/
    public static class MI_data_SinkPairwiseFinancialInput implements IMI_data_SinkPairwiseFinancialInput {
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
    public static class MI_data_SinkAnalyzedStreamInput implements IMI_data_SinkAnalyzedStreamInput {
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
    * @param data the sink data MI_data_SinkPairwiseFinancialInput
    **/
    @Override
    public void postDataPairwiseFinancial(IMI_data_SinkPairwiseFinancialInput data) {
    }
    /**
    * Posts a specific type of data sink.
    * @param data the sink data MI_data_SinkAnalyzedStreamInput
    **/
    @Override
    public void postDataAnalyzedStream(IMI_data_SinkAnalyzedStreamInput data) {
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
