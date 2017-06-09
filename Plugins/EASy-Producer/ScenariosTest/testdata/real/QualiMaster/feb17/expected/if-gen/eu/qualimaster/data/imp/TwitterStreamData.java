package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.ITwitterStreamData;
import eu.qualimaster.data.inf.ITwitterStreamData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class TwitterStreamData implements ITwitterStreamData{

    /**
    * Define the source data input interface.
    **/
    public static class TwitterStreamDataSymbolListOutput implements ITwitterStreamDataSymbolListOutput {
        private java.util.List<String> allSymbols;
        /**
        * Returns the input value for tuple field "allSymbols".
        * @return the tuple value
        */
        @Override
        public java.util.List<String> getAllSymbols(){
            return allSymbols;
        }

        /**
        * Sets the output value for tuple field "allSymbols".
        * @param allSymbols the field value
        */
        @Override
        public void setAllSymbols(java.util.List<String> allSymbols){
            this.allSymbols = allSymbols;
        }
        static {
            SerializerRegistry.register("TwitterStreamDataSymbolListOutput", TwitterStreamDataSerializers.TwitterStreamDataSymbolListOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }
    /**
    * Define the source data input interface.
    **/
    public static class TwitterStreamDataTwitterStreamOutput implements ITwitterStreamDataTwitterStreamOutput {
        private eu.qualimaster.data.stream.source.LabelledTweet status;
        /**
        * Returns the input value for tuple field "status".
        * @return the tuple value
        */
        @Override
        public eu.qualimaster.data.stream.source.LabelledTweet getStatus(){
            return status;
        }

        /**
        * Sets the output value for tuple field "status".
        * @param status the field value
        */
        @Override
        public void setStatus(eu.qualimaster.data.stream.source.LabelledTweet status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("TwitterStreamDataTwitterStreamOutput", TwitterStreamDataSerializers.TwitterStreamDataTwitterStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }


    /**
    * Returns a specific type of data source.
    * @return TwitterStreamDataSymbolListOutput the source data
    **/
    @Override
    public TwitterStreamDataSymbolListOutput getSymbolList() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(ITwitterStreamDataSymbolListOutput tuple) {
        return null;
    }
    /**
    * Returns a specific type of data source.
    * @return TwitterStreamDataTwitterStreamOutput the source data
    **/
    @Override
    public TwitterStreamDataTwitterStreamOutput getTwitterStream() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(ITwitterStreamDataTwitterStreamOutput tuple) {
        return null;
    }
    // data source parameters

    /**
     * Sets the data source parameter "consumerKey".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterConsumerKey(String value) {
    }

    /**
     * Sets the data source parameter "consumerSecret".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterConsumerSecret(String value) {
    }

    /**
     * Sets the data source parameter "accessToken".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterAccessToken(String value) {
    }

    /**
     * Sets the data source parameter "accessTokenSecret".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterAccessTokenSecret(String value) {
    }

    /**
     * Sets the data source parameter "queueSize".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterQueueSize(int value) {
    }

    /**
     * Sets the data source parameter "tweetDirectory".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterTweetDirectory(String value) {
    }

    /**
     * Sets the data source parameter "speedFactor".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterSpeedFactor(double value) {
    }

    /**
     * Sets the data source parameter "runLocally".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterRunLocally(boolean value) {
    }

    /**
     * Sets the data source parameter "adjustTimeToNow".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterAdjustTimeToNow(boolean value) {
    }

    /**
     * Sets the data source parameter "realLoops".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterRealLoops(boolean value) {
    }

    /**
     * Sets the data source parameter "setAdditionalKeywords".
     *
     * @param value the new value of the data source parameter
     */
    @Override
    public void setParameterSetAdditionalKeywords(String value) {
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

    @Override
    public IHistoricalDataProvider getHistoricalDataProvider() {
        return null;
    }

    @Override
    public Map<String, String> getIdsNamesMap() {
        return null;
    }

    @Override
    public void setDataSourceListener(IDataSourceListener listener) {
        // no mapping, no listener needed
    }

}
