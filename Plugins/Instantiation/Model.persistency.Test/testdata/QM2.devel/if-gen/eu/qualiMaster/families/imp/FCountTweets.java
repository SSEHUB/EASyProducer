package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FCountTweets implements IFCountTweets {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFCountTweetsInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCountTweetsInput implements IFCountTweets.IIFCountTweetsInput {

        private String hashtag;
        private String tweet;

        @Override
        public String getHashtag() {
            return hashtag;
        }

        @Override
        public void setHashtag(String hashtag) {
            this.hashtag = hashtag;
        }
        @Override
        public String getTweet() {
            return tweet;
        }

        @Override
        public void setTweet(String tweet) {
            this.tweet = tweet;
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFCountTweetsOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCountTweetsOutput implements IFCountTweets.IIFCountTweetsOutput {

        private String timestamp;
        private String tweet;
        private int counts;

        @Override
        public String getTimestamp() {
            return timestamp;
        }

        @Override
        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
        @Override
        public String getTweet() {
            return tweet;
        }

        @Override
        public void setTweet(String tweet) {
            this.tweet = tweet;
        }
        @Override
        public int getCounts() {
            return counts;
        }

        @Override
        public void setCounts(int counts) {
            this.counts = counts;
        }
    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFCountTweetsInput input, IIFCountTweetsOutput result) {
    }

}
