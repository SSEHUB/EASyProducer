package eu.qualimaster.families.inf;

import java.io.Serializable;
import eu.qualimaster.base.algorithm.IFamily;

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
        public Object getStatus();

        /**
         * Changes the output value for tuple field "status".
         * @param status the field value
         */
        public void setStatus(Object status);
    }

    /**
     * Defines the data input interface for the {@link IIFTweetClassifierKeywordStreamInput} algorithm (over all defined input tuples).
     */
    public static interface IIFTweetClassifierKeywordStreamInput extends Serializable {

        /**
         * Returns the input value for tuple field "keywords".
         * @return the tuple value
         */
        public Object getKeywords();

        /**
         * Changes the output value for tuple field "keywords".
         * @param keywords the field value
         */
        public void setKeywords(Object keywords);
    }

    /**
     * Defines the data output interface for the {@link IIFTweetClassifierModifiedTwitterStreamOutput} algorithm (over all defined output tuples).
     */
    public static interface IIFTweetClassifierModifiedTwitterStreamOutput extends Serializable, eu.qualimaster.base.algorithm.IOutputItem<IIFTweetClassifierModifiedTwitterStreamOutput> {

        /**
         * Returns the input value for tuple field "tweet".
         * @return the tuple value
         */
        public Object getTweet();

        /**
         * Changes the output value for tuple field "tweet".
         * @param tweet the field value
         */
        public void setTweet(Object tweet);
        /**
         * Returns the input value for tuple field "stocks".
         * @return the tuple value
         */
        public Object getStocks();

        /**
         * Changes the output value for tuple field "stocks".
         * @param stocks the field value
         */
        public void setStocks(Object stocks);
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTweetClassifierModifiedTwitterStreamInput input, IIFTweetClassifierModifiedTwitterStreamOutput result);

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTweetClassifierKeywordStreamInput input, IIFTweetClassifierModifiedTwitterStreamOutput result);

}
