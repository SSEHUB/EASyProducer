package eu.qualimaster.data.inf;

import java.io.Serializable;

/**
* Define the data source interface(GEN).
**/
public interface ITwitterStreamData {

    /**
    * Define the source data input interface.
    **/
    public static interface ITwitterStreamDataSymbolListOutput extends Serializable{
        /**
         * Returns the input value for tuple field "allSymbols".
         * @return the tuple value
         */
        public java.util.List<String> getAllSymbols();

        /**
         * Sets the output value for tuple field "allSymbols".
         * @param allSymbols the field value
         */
        public void setAllSymbols(java.util.List<String> allSymbols);
    }
    /**
    * Define the source data input interface.
    **/
    public static interface ITwitterStreamDataTwitterStreamOutput extends Serializable{
        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public Object getStatus();

        /**
         * Sets the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(Object status);
    }


    /**
    * Returns a specific type of data source.
    * @return ITwitterStreamDataSymbolListOutput the source data
    **/
    public ITwitterStreamDataSymbolListOutput getSymbolList();
    /**
    * Returns a specific type of data source.
    * @return ITwitterStreamDataTwitterStreamOutput the source data
    **/
    public ITwitterStreamDataTwitterStreamOutput getTwitterStream();
    // data source parameters

    /**
     * Sets the data source parameter "consumerKey".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterConsumerKey(String value);

    /**
     * Sets the data source parameter "consumerSecret".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterConsumerSecret(String value);

    /**
     * Sets the data source parameter "accessToken".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterAccessToken(String value);

    /**
     * Sets the data source parameter "accessTokenSecret".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterAccessTokenSecret(String value);

    /**
     * Sets the data source parameter "queueSize".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterQueueSize(int value);

    /**
     * Sets the data source parameter "tweetDirectory".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterTweetDirectory(String value);

    /**
     * Sets the data source parameter "speedFactor".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterSpeedFactor(double value);

    /**
     * Sets the data source parameter "runLocally".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterRunLocally(boolean value);

    /**
     * Sets the data source parameter "adjustTimeToNow".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterAdjustTimeToNow(boolean value);

    /**
     * Sets the data source parameter "realLoops".
     *
     * @param value the new value of the data source parameter
     */
    public void setParameterRealLoops(boolean value);

}
