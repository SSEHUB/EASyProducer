package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FFilterTweet implements IFFilterTweet {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFFilterTweetInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFFilterTweetInput implements IFFilterTweet.IIFFilterTweetInput {

        private String tweet;

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
     * Provides a default implementation of the data output for the {@link IFFilterTweetOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFFilterTweetOutput implements IFFilterTweet.IIFFilterTweetOutput {

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

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFFilterTweetInput input, IIFFilterTweetOutput result) {
    }

}
