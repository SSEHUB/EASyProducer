package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFCountTweets".
 */
public interface IFCountTweets {

    /**
     * Defines the data input interface for the {@link IIFCountTweetsInput} algorithm (over all defined input tuples).
     */
    public interface IIFCountTweetsInput {

        /**
         * Returns the input value for tuple field "hashtag".
         * @return the tuple value
         */
        public String getHashtag();

        /**
         * Changes the output value for tuple field "hashtag".
         * @param hashtag the field value
         */
        public void setHashtag(String hashtag);
        /**
         * Returns the input value for tuple field "tweet".
         * @return the tuple value
         */
        public String getTweet();

        /**
         * Changes the output value for tuple field "tweet".
         * @param tweet the field value
         */
        public void setTweet(String tweet);
    }

    /**
     * Defines the data output interface for the {@link IIFCountTweetsOutput} algorithm (over all defined output tuples).
     */
    public interface IIFCountTweetsOutput {

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
         * Returns the input value for tuple field "tweet".
         * @return the tuple value
         */
        public String getTweet();

        /**
         * Changes the output value for tuple field "tweet".
         * @param tweet the field value
         */
        public void setTweet(String tweet);
        /**
         * Returns the input value for tuple field "counts".
         * @return the tuple value
         */
        public int getCounts();

        /**
         * Changes the output value for tuple field "counts".
         * @param counts the field value
         */
        public void setCounts(int counts);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFCountTweetsInput input, IIFCountTweetsOutput result);

}
