package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;
import eu.qualimaster.base.algorithm.IDirectGroupingInfo;

/**
 * Defines the interface for the algorithm family "IFTweetClassifier" (GEN).
 */
public interface IFTweetClassifier extends IFamily{

    /**
     * Defines the data input interface for the {@link IIFTweetClassifierModifiedTwitterStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTweetClassifierModifiedTwitterStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "status".
         * @return the tuple value
         */
        public twitter4j.Status getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(twitter4j.Status status);
    }

    /**
     * Defines the data input interface for the {@link IIFTweetClassifierKeywordStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTweetClassifierKeywordStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "keywords".
         * @return the tuple value
         */
        public java.util.List<String> getKeywords();

        /**
         * Changes the output value for tuple field "keywords".
         * @param keywords the field value
         */
        public void setKeywords(java.util.List<String> keywords);
    }

    /**
     * Defines the data output interface for the {@link IIFTweetClassifierModifiedTwitterStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTweetClassifierModifiedTwitterStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTweetClassifierModifiedTwitterStreamOutput>, IDirectGroupingInfo {

        /**
         * Returns the input value for tuple field "tweet".
         * @return the tuple value
         */
        public twitter4j.Status getTweet();

        /**
         * Changes the output value for tuple field "tweet".
         * @param tweet the field value
         */
        public void setTweet(twitter4j.Status tweet);
        /**
         * Returns the input value for tuple field "stocks".
         * @return the tuple value
         */
        public java.util.List<String> getStocks();

        /**
         * Changes the output value for tuple field "stocks".
         * @param stocks the field value
         */
        public void setStocks(java.util.List<String> stocks);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTweetClassifierModifiedTwitterStreamInput input, IIFTweetClassifierModifiedTwitterStreamOutput modifiedTwitterStreamResult);
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTweetClassifierKeywordStreamInput input, IIFTweetClassifierModifiedTwitterStreamOutput modifiedTwitterStreamResult);
}
