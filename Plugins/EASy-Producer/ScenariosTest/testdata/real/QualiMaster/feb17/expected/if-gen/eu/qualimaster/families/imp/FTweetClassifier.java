package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFTweetClassifier" (GEN).
 */
public class FTweetClassifier implements IFTweetClassifier {

    /**
     * Provides a default implementation of the data input for the {@link IFTweetClassifierModifiedTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTweetClassifierModifiedTwitterStreamInput implements IIFTweetClassifierModifiedTwitterStreamInput {

        private twitter4j.Status status;

        @Override
        public twitter4j.Status getStatus(){
            return status;
        }

        @Override
        public void setStatus(twitter4j.Status status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFTweetClassifierModifiedTwitterStreamInput", FTweetClassifierSerializers.IFTweetClassifierModifiedTwitterStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data input for the {@link IFTweetClassifierKeywordStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTweetClassifierKeywordStreamInput implements IIFTweetClassifierKeywordStreamInput {

        private java.util.List<String> keywords;

        @Override
        public java.util.List<String> getKeywords(){
            return keywords;
        }

        @Override
        public void setKeywords(java.util.List<String> keywords){
            this.keywords = keywords;
        }
        static {
            SerializerRegistry.register("IFTweetClassifierKeywordStreamInput", FTweetClassifierSerializers.IFTweetClassifierKeywordStreamInputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFTweetClassifierModifiedTwitterStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTweetClassifierModifiedTwitterStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFTweetClassifierModifiedTwitterStreamOutput> implements IIFTweetClassifierModifiedTwitterStreamOutput {

        /**
         * Creates the item.
         */
        public IFTweetClassifierModifiedTwitterStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFTweetClassifierModifiedTwitterStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public IFTweetClassifierModifiedTwitterStreamOutput createItem() {
            return new IFTweetClassifierModifiedTwitterStreamOutput(false);
        }
        @Override
        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }
        @Override
        public int getTaskId() {
            return taskId;
        }
        private transient int taskId;
        private twitter4j.Status tweet;
        private java.util.List<String> stocks;

        @Override
        public twitter4j.Status getTweet(){
            return tweet;
        }

        @Override
        public void setTweet(twitter4j.Status tweet){
            this.tweet = tweet;
        }
        @Override
        public java.util.List<String> getStocks(){
            return stocks;
        }

        @Override
        public void setStocks(java.util.List<String> stocks){
            this.stocks = stocks;
        }
        static {
            SerializerRegistry.register("IFTweetClassifierModifiedTwitterStreamOutput", FTweetClassifierSerializers.IFTweetClassifierModifiedTwitterStreamOutputSerializer.class);
            SerializerRegistry.register("STRINGLIST", eu.qualimaster.base.serializer.StringListSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTweetClassifierModifiedTwitterStreamInput input, IIFTweetClassifierModifiedTwitterStreamOutput modifiedTwitterStreamResult) {
    }
    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IIFTweetClassifierKeywordStreamInput input, IIFTweetClassifierModifiedTwitterStreamOutput modifiedTwitterStreamResult) {
    }
    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
