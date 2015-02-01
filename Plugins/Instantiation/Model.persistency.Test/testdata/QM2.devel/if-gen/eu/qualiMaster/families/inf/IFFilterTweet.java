package eu.qualiMaster.families.inf;


/**
 * Defines the interface for the algorithm family "IFFilterTweet".
 */
public interface IFFilterTweet {

    /**
     * Defines the data input interface for the {@link IIFFilterTweetInput} algorithm (over all defined input tuples).
     */
    public interface IIFFilterTweetInput {

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
     * Defines the data output interface for the {@link IIFFilterTweetOutput} algorithm (over all defined output tuples).
     */
    public interface IIFFilterTweetOutput {

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
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFFilterTweetInput input, IIFFilterTweetOutput result);

}
