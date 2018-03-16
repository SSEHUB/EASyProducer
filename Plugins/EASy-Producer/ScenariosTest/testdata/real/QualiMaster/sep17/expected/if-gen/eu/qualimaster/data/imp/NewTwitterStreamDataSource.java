package eu.qualimaster.data.imp;

import java.util.Map;
import eu.qualimaster.data.inf.INewTwitterStreamDataSource;
import eu.qualimaster.data.inf.INewTwitterStreamDataSource.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;
import eu.qualimaster.dataManagement.sources.*;

/**
* Define the data source class(GEN).
**/
public class NewTwitterStreamDataSource implements INewTwitterStreamDataSource{

    /**
    * Define the source data input interface.
    **/
    public static class NewTwitterStreamDataSourceAnalysisOutput implements INewTwitterStreamDataSourceAnalysisOutput {
        private twitter4j.Status status;
        /**
        * Returns the input value for tuple field "status".
        * @return the tuple value
        */
        @Override
        public twitter4j.Status getStatus(){
            return status;
        }

        /**
        * Sets the output value for tuple field "status".
        * @param status the field value
        */
        @Override
        public void setStatus(twitter4j.Status status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("NewTwitterStreamDataSourceAnalysisOutput", NewTwitterStreamDataSourceSerializers.NewTwitterStreamDataSourceAnalysisOutputSerializer.class);
        }
    }


    /**
    * Returns a specific type of data source.
    * @return NewTwitterStreamDataSourceAnalysisOutput the source data
    **/
    @Override
    public NewTwitterStreamDataSourceAnalysisOutput getAnalysis() {
        return null;
    }

    /**
    * Returns an aggregation key from the key property of the tuple type for predicting source data. If null, do not aggregate or predict.
    * @return an aggregation key
    **/
    @Override
    public String getAggregationKey(INewTwitterStreamDataSourceAnalysisOutput tuple) {
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
