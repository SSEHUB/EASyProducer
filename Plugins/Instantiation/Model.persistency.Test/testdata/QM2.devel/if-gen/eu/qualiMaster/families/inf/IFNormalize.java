package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFNormalize".
 */
public interface IFNormalize {

    /**
     * Defines the data input interface for the {@link IIFNormalizeInput} algorithm (over all defined input tuples).
     */
    public interface IIFNormalizeInput {

        /**
         * Returns the input value for tuple field "springData".
         * @return the tuple value
         */
        public String getSpringData();

        /**
         * Changes the output value for tuple field "springData".
         * @param springData the field value
         */
        public void setSpringData(String springData);
    }

    /**
     * Defines the data output interface for the {@link IIFNormalizeOutput} algorithm (over all defined output tuples).
     */
    public interface IIFNormalizeOutput {

        /**
         * Returns the input value for tuple field "streamID".
         * @return the tuple value
         */
        public String getStreamID();

        /**
         * Changes the output value for tuple field "streamID".
         * @param streamID the field value
         */
        public void setStreamID(String streamID);
        /**
         * Returns the input value for tuple field "timestamp".
         * @return the tuple value
         */
        public String getTimestamp();

        /**
         * Changes the output value for tuple field "timestamp".
         * @param timestamp the field value
         */
        public void setTimestamp(String timestamp);
        /**
         * Returns the input value for tuple field "quote".
         * @return the tuple value
         */
        public double getQuote();

        /**
         * Changes the output value for tuple field "quote".
         * @param quote the field value
         */
        public void setQuote(double quote);
        /**
         * Returns the input value for tuple field "volume".
         * @return the tuple value
         */
        public int getVolume();

        /**
         * Changes the output value for tuple field "volume".
         * @param volume the field value
         */
        public void setVolume(int volume);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFNormalizeInput input, IIFNormalizeOutput result);

    // algorithm parameters

    /**
     * Sets the algorithm parameter "test".
     *
     * @param value the new value of the algorithm parameter
     */

}
