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

        private Object status;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
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

        private Object keywords;

        @Override
        public Object getKeywords(){
            return keywords;
        }

        @Override
        public void setKeywords(Object keywords){
            this.keywords = keywords;
        }
        static {
            SerializerRegistry.register("IFTweetClassifierKeywordStreamInput", FTweetClassifierSerializers.IFTweetClassifierKeywordStreamInputSerializer.class);
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
        protected IFTweetClassifierModifiedTwitterStreamOutput createItem() {
            return new IFTweetClassifierModifiedTwitterStreamOutput(false);
        }
        private Object tweet;
        private Object stocks;

        @Override
        public Object getTweet(){
            return tweet;
        }

        @Override
        public void setTweet(Object tweet){
            this.tweet = tweet;
        }
        @Override
        public Object getStocks(){
            return stocks;
        }

        @Override
        public void setStocks(Object stocks){
            this.stocks = stocks;
        }
        static {
            SerializerRegistry.register("IFTweetClassifierModifiedTwitterStreamOutput", FTweetClassifierSerializers.IFTweetClassifierModifiedTwitterStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFTweetClassifierModifiedTwitterStreamInput input, IIFTweetClassifierModifiedTwitterStreamOutput result){
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFTweetClassifierKeywordStreamInput input, IIFTweetClassifierModifiedTwitterStreamOutput result){
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
