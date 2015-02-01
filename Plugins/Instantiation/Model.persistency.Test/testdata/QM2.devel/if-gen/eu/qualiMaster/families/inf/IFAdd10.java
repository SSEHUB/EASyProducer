package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFAdd10".
 */
public interface IFAdd10 {

    /**
     * Defines the data input interface for the {@link IIFAdd10Input} algorithm (over all defined input tuples).
     */
    public interface IIFAdd10Input {

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
     * Defines the data output interface for the {@link IIFAdd10Output} algorithm (over all defined output tuples).
     */
    public interface IIFAdd10Output {

        /**
         * Returns the input value for tuple field "valuePlus10".
         * @return the tuple value
         */
        public double getValuePlus10();

        /**
         * Changes the output value for tuple field "valuePlus10".
         * @param valuePlus10 the field value
         */
        public void setValuePlus10(double valuePlus10);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFAdd10Input input, IIFAdd10Output result);

}
