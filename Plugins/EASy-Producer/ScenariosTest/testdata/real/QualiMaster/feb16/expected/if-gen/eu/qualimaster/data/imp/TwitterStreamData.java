package eu.qualimaster.data.imp;

import eu.qualimaster.data.inf.ITwitterStreamData;
import eu.qualimaster.data.inf.ITwitterStreamData.*;
import eu.qualimaster.dataManagement.strategies.*;
import eu.qualimaster.observables.*;

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
    }
    /**
    * Define the source data input interface.
    **/
    public static class TwitterStreamDataTwitterStreamOutput implements ITwitterStreamDataTwitterStreamOutput {
        private Object status;
        /**
        * Returns the input value for tuple field "status".
        * @return the tuple value
        */
        @Override
        public Object getStatus(){
            return status;
        }

        /**
        * Sets the output value for tuple field "status".
        * @param status the field value
        */
        @Override
        public void setStatus(Object status){
            this.status = status;
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
    * Returns a specific type of data source.
    * @return TwitterStreamDataTwitterStreamOutput the source data
    **/
    @Override
    public TwitterStreamDataTwitterStreamOutput getTwitterStream() {
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
}
